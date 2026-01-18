export const API_BASE_URL = "http://localhost:8080/api";

export async function fetchPolicies() {
    try {
        const res = await fetch(`${API_BASE_URL}/policies`, { cache: "no-store" });
        if (!res.ok) throw new Error("Failed to fetch policies");
        return res.json();
    } catch (error) {
        console.error(error);
        return [];
    }
}

export async function createPolicy(data: any) {
    const res = await fetch(`${API_BASE_URL}/policies`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
    });
    if (!res.ok) {
        const errorData = await res.json().catch(() => ({}));
        throw new Error(errorData.error || (errorData.errors && JSON.stringify(errorData.errors)) || "Failed to create policy");
    }
    return res.json();
}

export async function updatePolicyStatus(id: string, status: string) {
    const res = await fetch(`${API_BASE_URL}/policies/${id}/status?status=${status}`, {
        method: "PATCH",
    });
    if (!res.ok) throw new Error("Failed to update status");
    return res.json();
}

export async function assessRisk(policy: any) {
    const res = await fetch(`${API_BASE_URL}/underwriting/assess`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            policyNumber: policy.policyNumber,
            premium: policy.premium,
            holderName: policy.holderName
        }),
    });
    if (!res.ok) throw new Error("Risk assessment failed");
    return res.json();
}

export async function fetchClaims() {
    try {
        const res = await fetch(`${API_BASE_URL}/claims`, { cache: "no-store" });
        if (!res.ok) throw new Error("Failed to fetch claims");
        return res.json();
    } catch (error) {
        console.error(error);
        return [];
    }
}

export async function submitClaim(data: any) {
    const res = await fetch(`${API_BASE_URL}/claims`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
    });
    if (!res.ok) throw new Error("Failed to submit claim");
    return res.json();
}

export async function fetchUnderwritingQueue() {
    // Placeholder until we implement the endpoint logic or mock aggregation
    return [];
}
