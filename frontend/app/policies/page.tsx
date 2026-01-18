import { fetchPolicies } from "@/lib/api";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";

export default async function PoliciesPage() {
    const policies = await fetchPolicies();

    return (
        <div className="space-y-6">
            <div className="flex justify-between items-center">
                <h2 className="text-3xl font-bold tracking-tight">Policies</h2>
                <a href="/policies/new" className="bg-blue-600 text-white px-4 py-2 rounded-md hover:bg-blue-700">
                    + Create Policy
                </a>
            </div>
            <div className="grid gap-4">
                {policies.length === 0 ? (
                    <p>No policies found.</p>
                ) : (
                    policies.map((policy: any) => (
                        <Card key={policy.id}>
                            <CardHeader>
                                <CardTitle>{policy.holderName} ({policy.policyNumber})</CardTitle>
                            </CardHeader>
                            <CardContent>
                                <div className="grid grid-cols-2 gap-4">
                                    <div>
                                        <p className="text-sm font-medium">Premium</p>
                                        <p>${policy.premium}</p>
                                    </div>
                                    <div>
                                        <p className="text-sm font-medium">Status</p>
                                        <p>{policy.status}</p>
                                    </div>
                                    <div>
                                        <p className="text-sm font-medium">Start Date</p>
                                        <p>{policy.startDate}</p>
                                    </div>
                                    <div>
                                        <p className="text-sm font-medium">End Date</p>
                                        <p>{policy.endDate}</p>
                                    </div>
                                </div>
                            </CardContent>
                        </Card>
                    ))
                )}
            </div>
        </div>
    );
}
