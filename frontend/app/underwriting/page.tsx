import { fetchPolicies } from "@/lib/api";
import { UnderwritingList } from "@/components/underwriting/UnderwritingList";

export default async function UnderwritingPage() {
    const policies = await fetchPolicies();
    const pendingPolicies = policies.filter((p: any) => p.status === "PENDING_APPROVAL");

    return (
        <div className="space-y-6">
            <h2 className="text-3xl font-bold tracking-tight">Underwriting Queue</h2>
            {pendingPolicies.length === 0 ? (
                <p className="text-muted-foreground">No policies pending approval.</p>
            ) : (
                <UnderwritingList initialPolicies={pendingPolicies} />
            )}
        </div>
    );
}
