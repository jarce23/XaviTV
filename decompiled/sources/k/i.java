package k;

import m.z2;
import m0.q0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends w7.b {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f7569q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7570r;

    /* renamed from: s, reason: collision with root package name */
    public int f7571s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ Object f7572t;

    public i(j jVar) {
        this.f7569q = 0;
        this.f7572t = jVar;
        this.f7570r = false;
        this.f7571s = 0;
    }

    @Override // m0.q0
    public final void c() {
        switch (this.f7569q) {
            case 0:
                int i10 = this.f7571s + 1;
                this.f7571s = i10;
                j jVar = (j) this.f7572t;
                if (i10 == jVar.f7573a.size()) {
                    q0 q0Var = jVar.f7576d;
                    if (q0Var != null) {
                        q0Var.c();
                    }
                    this.f7571s = 0;
                    this.f7570r = false;
                    jVar.f7577e = false;
                    break;
                }
                break;
            default:
                if (!this.f7570r) {
                    ((z2) this.f7572t).f8621a.setVisibility(this.f7571s);
                    break;
                }
                break;
        }
    }

    @Override // w7.b, m0.q0
    public void d() {
        switch (this.f7569q) {
            case 1:
                this.f7570r = true;
                break;
        }
    }

    @Override // w7.b, m0.q0
    public final void e() {
        switch (this.f7569q) {
            case 0:
                if (!this.f7570r) {
                    this.f7570r = true;
                    q0 q0Var = ((j) this.f7572t).f7576d;
                    if (q0Var != null) {
                        q0Var.e();
                        break;
                    }
                }
                break;
            default:
                ((z2) this.f7572t).f8621a.setVisibility(0);
                break;
        }
    }

    public i(z2 z2Var, int i10) {
        this.f7569q = 1;
        this.f7572t = z2Var;
        this.f7571s = i10;
        this.f7570r = false;
    }
}
