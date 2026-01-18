"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import { submitClaim } from "@/lib/api";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Loader2 } from "lucide-react";

export function CreateClaimForm({ policies }: { policies: any[] }) {
    const router = useRouter();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    async function onSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();
        setLoading(true);
        setError("");

        const formData = new FormData(event.currentTarget);
        const data = {
            policyNumber: formData.get("policyNumber") as string,
            amount: parseFloat(formData.get("amount") as string),
            description: formData.get("description") as string,
        };

        try {
            await submitClaim(data);
            router.refresh();
            (event.target as HTMLFormElement).reset(); // Reset form on success
        } catch (err) {
            setError("Failed to submit claim. Ensure Policy Number is valid.");
        } finally {
            setLoading(false);
        }
    }

    return (
        <Card>
            <CardHeader>
                <CardTitle>File New Claim</CardTitle>
            </CardHeader>
            <CardContent>
                <form onSubmit={onSubmit} className="space-y-4">
                    <div className="space-y-2">
                        <label htmlFor="policyNumber" className="text-sm font-medium">Policy Number</label>
                        <select
                            name="policyNumber"
                            id="policyNumber"
                            required
                            className="w-full p-2 border rounded-md"
                        >
                            <option value="">Select a Policy</option>
                            {policies.map((p) => (
                                <option key={p.id} value={p.policyNumber}>
                                    {p.holderName} ({p.policyNumber})
                                </option>
                            ))}
                        </select>
                    </div>

                    <div className="space-y-2">
                        <label htmlFor="amount" className="text-sm font-medium">Claim Amount ($)</label>
                        <input
                            name="amount"
                            id="amount"
                            type="number"
                            step="0.01"
                            required
                            className="w-full p-2 border rounded-md"
                            placeholder="5000.00"
                        />
                    </div>

                    <div className="space-y-2">
                        <label htmlFor="description" className="text-sm font-medium">Description</label>
                        <textarea
                            name="description"
                            id="description"
                            required
                            className="w-full p-2 border rounded-md"
                            placeholder="Describe what happened..."
                            rows={3}
                        />
                    </div>

                    {error && <p className="text-red-500 text-sm">{error}</p>}

                    <button
                        type="submit"
                        disabled={loading}
                        className="w-full bg-red-600 text-white p-2 rounded-md hover:bg-red-700 disabled:opacity-50 flex justify-center items-center"
                    >
                        {loading ? <Loader2 className="mr-2 h-4 w-4 animate-spin" /> : "Submit Claim"}
                    </button>
                </form>
            </CardContent>
        </Card>
    );
}
