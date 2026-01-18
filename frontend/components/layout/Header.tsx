export function Header() {
    return (
        <div className="border-b p-4 flex items-center justify-between bg-white dark:bg-slate-950">
            <h2 className="text-lg font-semibold">Dashboard</h2>
            <div className="flex items-center gap-x-4">
                <div className="h-8 w-8 rounded-full bg-slate-200 flex items-center justify-center">
                    <span className="text-xs font-bold">AU</span>
                </div>
            </div>
        </div>
    );
}
