"use client";

import { useState } from "react";
import { Card, CardContent, CardHeader, CardTitle, CardFooter } from "@/components/ui/card";
import { updatePolicyStatus, assessRisk } from "@/lib/api";
import { Loader2, CheckCircle, XCircle, ShieldAlert } from "lucide-react";
import { useRouter } from "next/navigation";

export function UnderwritingList({ initialPolicies }: { initialPolicies: any[] }) {
    const router = useRouter();
    const [loading, setLoading] = useState<string | null>(null);
    const [assessments, setAssessments] = useState<Record<string, any>>({});

    const handleAssess = async (policy: any) => {
        setLoading(policy.id);
        try {
            const result = await assessRisk(policy);
            setAssessments(prev => ({ ...prev, [policy.id]: result }));
        } catch (error) {
            console.error(error);
            alert("Assessment failed");
        } finally {
            setLoading(null);
        }
    };

    const handleDecision = async (id: string, status: "ACTIVE" | "REJECTED") => {
        setLoading(id);
        try {
            await updatePolicyStatus(id, status);
            router.refresh();
        } catch (error) {
            console.error(error);
            alert("Update failed");
        } finally {
            setLoading(null);
        }
    };

    return (
        <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-3">
            {initialPolicies.map((policy) => (
                <Card key={policy.id} className="border-l-4 border-l-yellow-500">
                    <CardHeader>
                        <CardTitle className="text-lg">{policy.holderName}</CardTitle>
                        <p className="text-sm text-muted-foreground">{policy.policyNumber}</p>
                    </CardHeader>
                    <CardContent>
                        <div className="space-y-2">
                            <div className="flex justify-between">
                                <span className="font-medium">Premium:</span>
                                <span>${policy.premium}</span>
                            </div>
                            <div className="flex justify-between">
                                <span className="font-medium">Dates:</span>
                                <span className="text-xs">{policy.startDate} - {policy.endDate}</span>
                            </div>

                            {assessments[policy.id] && (
                                <div className="mt-4 p-3 bg-slate-100 rounded-md text-sm">
                                    <p className="font-bold flex items-center gap-2">
                                        <ShieldAlert className="h-4 w-4" />
                                        Risk Assessment:
                                    </p>
                                    <p className={assessments[policy.id].decision === "APPROVED" ? "text-green-600" : "text-red-600"}>
                                        Decision: {assessments[policy.id].decision}
                                    </p>
                                    <p className="text-xs text-muted-foreground">{assessments[policy.id].reason}</p>
                                </div>
                            )}
                        </div>
                    </CardContent>
                    <CardFooter className="flex justify-between gap-2">
                        {!assessments[policy.id] ? (
                            <button
                                onClick={() => handleAssess(policy)}
                                disabled={loading === policy.id}
                                className="w-full bg-slate-800 text-white py-2 rounded-md hover:bg-slate-900 flex justify-center"
                            >
                                {loading === policy.id ? <Loader2 className="animate-spin" /> : "Assess Risk"}
                            </button>
                        ) : (
                            <>
                                <button
                                    onClick={() => handleDecision(policy.id, "ACTIVE")}
                                    disabled={loading === policy.id}
                                    className="flex-1 bg-green-600 text-white py-2 rounded-md hover:bg-green-700 flex justify-center items-center gap-2"
                                >
                                    <CheckCircle className="h-4 w-4" /> Approve
                                </button>
                                <button
                                    onClick={() => handleDecision(policy.id, "REJECTED")}
                                    disabled={loading === policy.id}
                                    className="flex-1 bg-red-600 text-white py-2 rounded-md hover:bg-red-700 flex justify-center items-center gap-2"
                                >
                                    <XCircle className="h-4 w-4" /> Reject
                                </button>
                            </>
                        )}
                    </CardFooter>
                </Card>
            ))}
        </div>
    );
}
