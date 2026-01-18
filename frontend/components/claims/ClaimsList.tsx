import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";

export function ClaimsList({ claims }: { claims: any[] }) {
    if (claims.length === 0) {
        return (
            <Card>
                <CardContent className="pt-6">
                    <p className="text-center text-muted-foreground">No claims found.</p>
                </CardContent>
            </Card>
        );
    }

    return (
        <div className="grid gap-4">
            {claims.map((claim) => (
                <Card key={claim.id}>
                    <CardHeader>
                        <div className="flex justify-between">
                            <CardTitle className="text-lg">Claim #{claim.claimId}</CardTitle>
                            <span className={`px-2 py-1 rounded text-xs font-bold ${claim.status === "APPROVED" ? "bg-green-100 text-green-700" :
                                    claim.status === "REJECTED" ? "bg-red-100 text-red-700" :
                                        "bg-yellow-100 text-yellow-700"
                                }`}>
                                {claim.status}
                            </span>
                        </div>
                        <p className="text-sm text-muted-foreground">Policy: {claim.policyNumber}</p>
                    </CardHeader>
                    <CardContent>
                        <div className="flex justify-between items-center">
                            <p className="font-bold text-lg">${claim.amount}</p>
                            <p className="text-sm text-gray-500">{new Date(claim.submittedAt).toLocaleDateString()}</p>
                        </div>
                        <p className="mt-2 text-sm text-gray-700">{claim.description}</p>
                    </CardContent>
                </Card>
            ))}
        </div>
    );
}
