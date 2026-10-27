package androidx.lifecycle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: o, reason: collision with root package name */
    public final a6.n f1166o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1167p;

    /* renamed from: q, reason: collision with root package name */
    public int f1168q = -1;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ y f1169r;

    public x(y yVar, a6.n nVar) {
        this.f1169r = yVar;
        this.f1166o = nVar;
    }

    public final void c(boolean z10) {
        if (z10 == this.f1167p) {
            return;
        }
        this.f1167p = z10;
        int i10 = z10 ? 1 : -1;
        y yVar = this.f1169r;
        int i11 = yVar.f1173c;
        yVar.f1173c = i10 + i11;
        if (!yVar.f1174d) {
            yVar.f1174d = true;
            while (true) {
                try {
                    int i12 = yVar.f1173c;
                    if (i11 == i12) {
                        break;
                    } else {
                        i11 = i12;
                    }
                } finally {
                    yVar.f1174d = false;
                }
            }
        }
        if (this.f1167p) {
            yVar.c(this);
        }
    }

    public abstract boolean e();

    public void d() {
    }
}
