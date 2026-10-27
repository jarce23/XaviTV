package pb;

import ib.v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: q, reason: collision with root package name */
    public final Runnable f10180q;

    public j(Runnable runnable, long j10, androidx.leanback.widget.i iVar) {
        super(j10, iVar);
        this.f10180q = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10180q.run();
        } finally {
            this.f10179p.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Task[");
        Runnable runnable = this.f10180q;
        sb2.append(runnable.getClass().getSimpleName());
        sb2.append('@');
        sb2.append(v.b(runnable));
        sb2.append(", ");
        sb2.append(this.f10178o);
        sb2.append(", ");
        sb2.append(this.f10179p);
        sb2.append(']');
        return sb2.toString();
    }
}
