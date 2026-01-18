"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import { createPolicy } from "@/lib/api";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Loader2 } from "lucide-react";

export function CreatePolicyForm() {
    const router = useRouter();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    async function onSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();
        setLoading(true);
        setError("");

        const formData = new FormData(event.currentTarget);
        const data = {
            holderName: formData.get("holderName") as string,
            premium: parseFloat(formData.get("premium") as string),
            startDate: formData.get("startDate") as string,
            endDate: formData.get("endDate") as string,
        };

        try {
            await createPolicy(data);
            router.push("/policies");
            router.refresh();
        } catch (err: any) {
            setError(err.message || "Failed to create policy.");
        } finally {
            setLoading(false);
        }
    }

    // Default dates: Today and Next Year
    const today = new Date().toISOString().split('T')[0];
    const nextYear = new Date(new Date().setFullYear(new Date().getFullYear() + 1)).toISOString().split('T')[0];

    return (
        <Card className="w-full max-w-lg mx-auto">
            <CardHeader>
                <CardTitle>Create New Policy</CardTitle>
            </CardHeader>
            <CardContent>
                <form onSubmit={onSubmit} className="space-y-4">
                    <div className="space-y-2">
                        <label htmlFor="holderName" className="text-sm font-medium">Holder Name</label>
                        <input
                            name="holderName"
                            id="holderName"
                            required
                            className="w-full p-2 border rounded-md"
                            placeholder="Ex: John Doe"
                        />
                    </div>

                    <div className="space-y-2">
                        <label htmlFor="premium" className="text-sm font-medium">Premium ($)</label>
                        <input
                            name="premium"
                            id="premium"
                            type="number"
                            step="0.01"
                            required
                            className="w-full p-2 border rounded-md"
                            placeholder="1000.00"
                        />
                    </div>

                    <div className="grid grid-cols-2 gap-4">
                        <div className="space-y-2">
                            <label htmlFor="startDate" className="text-sm font-medium">Start Date</label>
                            <input
                                name="startDate"
                                id="startDate"
                                type="date"
                                required
                                defaultValue={today}
                                className="w-full p-2 border rounded-md"
                            />
                        </div>

                        <div className="space-y-2">
                            <label htmlFor="endDate" className="text-sm font-medium">End Date</label>
                            <input
                                name="endDate"
                                id="endDate"
                                type="date"
                                required
                                defaultValue={nextYear}
                                className="w-full p-2 border rounded-md"
                            />
                        </div>
                    </div>

                    {error && (
                        <div className="p-3 bg-red-100 border border-red-400 text-red-700 rounded text-sm break-words">
                            {error}
                        </div>
                    )}

                    <button
                        type="submit"
                        disabled={loading}
                        className="w-full bg-blue-600 text-white p-2 rounded-md hover:bg-blue-700 disabled:opacity-50 flex justify-center items-center"
                    >
                        {loading ? <Loader2 className="mr-2 h-4 w-4 animate-spin" /> : "Create Policy"}
                    </button>
                </form>
            </CardContent>
        </Card>
    );
}
