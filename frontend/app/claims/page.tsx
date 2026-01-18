import { fetchClaims, fetchPolicies } from "@/lib/api";
import { CreateClaimForm } from "@/components/forms/CreateClaimForm";
import { ClaimsList } from "@/components/claims/ClaimsList";

export default async function ClaimsPage() {
    const claims = await fetchClaims();
    const policies = await fetchPolicies();

    return (
        <div className="space-y-6">
            <h2 className="text-3xl font-bold tracking-tight">Claims Portal</h2>

            <div className="grid gap-6 md:grid-cols-2">
                <div>
                    <h3 className="text-xl font-semibold mb-4">File a Claim</h3>
                    <CreateClaimForm policies={policies} />
                </div>
                <div>
                    <h3 className="text-xl font-semibold mb-4">Recent Claims</h3>
                    <ClaimsList claims={claims} />
                </div>
            </div>
        </div>
    );
}
