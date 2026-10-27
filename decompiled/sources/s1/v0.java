package s1;

import android.util.Pair;
import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v0 implements c2.k0, v1.d {

    /* renamed from: o, reason: collision with root package name */
    public final x0 f11473o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d9.p f11474p;

    public v0(d9.p pVar, x0 x0Var) {
        this.f11474p = pVar;
        this.f11473o = x0Var;
    }

    @Override // c2.k0
    public final void F(int i10, c2.d0 d0Var, c2.z zVar) {
        Pair a10 = a(i10, d0Var);
        if (a10 != null) {
            ((l1.x) this.f11474p.f4320j).c(new r0(this, a10, zVar, 1));
        }
    }

    @Override // c2.k0
    public final void G(int i10, c2.d0 d0Var, c2.z zVar) {
        Pair a10 = a(i10, d0Var);
        if (a10 != null) {
            ((l1.x) this.f11474p.f4320j).c(new r0(this, a10, zVar, 0));
        }
    }

    public final Pair a(int i10, c2.d0 d0Var) {
        c2.d0 d0Var2;
        x0 x0Var = this.f11473o;
        c2.d0 d0Var3 = null;
        if (d0Var != null) {
            int i11 = 0;
            while (true) {
                if (i11 >= x0Var.f11485c.size()) {
                    d0Var2 = null;
                    break;
                }
                if (((c2.d0) x0Var.f11485c.get(i11)).f2542d == d0Var.f2542d) {
                    Object obj = d0Var.f2539a;
                    Object obj2 = x0Var.f11484b;
                    int i12 = c1.f11239k;
                    d0Var2 = d0Var.a(Pair.create(obj2, obj));
                    break;
                }
                i11++;
            }
            if (d0Var2 == null) {
                return null;
            }
            d0Var3 = d0Var2;
        }
        return Pair.create(Integer.valueOf(i10 + x0Var.f11486d), d0Var3);
    }

    @Override // c2.k0
    public final void g(int i10, c2.d0 d0Var, final c2.u uVar, final c2.z zVar, final int i11) {
        final Pair a10 = a(i10, d0Var);
        if (a10 != null) {
            ((l1.x) this.f11474p.f4320j).c(new Runnable() { // from class: s1.t0
                @Override // java.lang.Runnable
                public final void run() {
                    t1.o oVar = (t1.o) v0.this.f11474p.f4319i;
                    Pair pair = a10;
                    oVar.g(((Integer) pair.first).intValue(), (c2.d0) pair.second, uVar, zVar, i11);
                }
            });
        }
    }

    @Override // c2.k0
    public final void i(int i10, c2.d0 d0Var, c2.u uVar, c2.z zVar) {
        Pair a10 = a(i10, d0Var);
        if (a10 != null) {
            ((l1.x) this.f11474p.f4320j).c(new s0(this, a10, uVar, zVar, 0));
        }
    }

    @Override // c2.k0
    public final void l(int i10, c2.d0 d0Var, c2.u uVar, c2.z zVar) {
        Pair a10 = a(i10, d0Var);
        if (a10 != null) {
            ((l1.x) this.f11474p.f4320j).c(new s0(this, a10, uVar, zVar, 1));
        }
    }

    @Override // c2.k0
    public final void p(int i10, c2.d0 d0Var, final c2.u uVar, final c2.z zVar, final IOException iOException, final boolean z10) {
        final Pair a10 = a(i10, d0Var);
        if (a10 != null) {
            ((l1.x) this.f11474p.f4320j).c(new Runnable() { // from class: s1.u0
                @Override // java.lang.Runnable
                public final void run() {
                    t1.o oVar = (t1.o) v0.this.f11474p.f4319i;
                    Pair pair = a10;
                    oVar.p(((Integer) pair.first).intValue(), (c2.d0) pair.second, uVar, zVar, iOException, z10);
                }
            });
        }
    }
}
