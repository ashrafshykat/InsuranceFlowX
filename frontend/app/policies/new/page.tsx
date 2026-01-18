import { CreatePolicyForm } from "@/components/forms/CreatePolicyForm";

export default function NewPolicyPage() {
    return (
        <div className="space-y-6">
            <h2 className="text-3xl font-bold tracking-tight">New Policy</h2>
            <CreatePolicyForm />
        </div>
    );
}
