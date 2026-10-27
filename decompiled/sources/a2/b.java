package a2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.v0;
import i1.c0;
import i1.d0;
import i1.e0;
import i1.f0;
import i1.p;
import java.util.ArrayList;
import s1.a0;
import s1.d;
import s1.x;
import x4.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends d implements Handler.Callback {
    public final a G;
    public final x H;
    public final Handler I;
    public final t2.a J;
    public com.bumptech.glide.d K;
    public boolean L;
    public boolean M;
    public long N;
    public f0 O;
    public long P;

    public b(x xVar, Looper looper) {
        super(5);
        this.H = xVar;
        this.I = looper == null ? null : new Handler(looper, this);
        this.G = a.f17a;
        this.J = new t2.a(1);
        this.P = -9223372036854775807L;
    }

    public final void B(f0 f0Var, ArrayList arrayList) {
        int i10 = 0;
        while (true) {
            e0[] e0VarArr = f0Var.f5876a;
            if (i10 >= e0VarArr.length) {
                return;
            }
            p a10 = e0VarArr[i10].a();
            if (a10 != null) {
                a aVar = this.G;
                if (aVar.b(a10)) {
                    com.bumptech.glide.d a11 = aVar.a(a10);
                    byte[] b2 = e0VarArr[i10].b();
                    b2.getClass();
                    t2.a aVar2 = this.J;
                    aVar2.j();
                    aVar2.m(b2.length);
                    aVar2.f10410s.put(b2);
                    aVar2.n();
                    f0 i11 = a11.i(aVar2);
                    if (i11 != null) {
                        B(i11, arrayList);
                    }
                    i10++;
                }
            }
            arrayList.add(e0VarArr[i10]);
            i10++;
        }
    }

    public final long C(long j10) {
        l1.d.g(j10 != -9223372036854775807L);
        l1.d.g(this.P != -9223372036854775807L);
        return j10 - this.P;
    }

    public final void D(f0 f0Var) {
        x xVar = this.H;
        a0 a0Var = xVar.f11482o;
        d0 d0Var = a0Var.f11201k0;
        l1.p pVar = a0Var.f11204m;
        c0 a10 = d0Var.a();
        int i10 = 0;
        while (true) {
            e0[] e0VarArr = f0Var.f5876a;
            if (i10 >= e0VarArr.length) {
                break;
            }
            e0VarArr[i10].c(a10);
            i10++;
        }
        a0Var.f11201k0 = new d0(a10);
        d0 r2 = a0Var.r();
        if (!r2.equals(a0Var.S)) {
            a0Var.S = r2;
            pVar.c(14, new v0(22, xVar));
        }
        pVar.c(28, new v0(23, f0Var));
        pVar.b();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        D((f0) message.obj);
        return true;
    }

    @Override // s1.d
    public final String j() {
        return "MetadataRenderer";
    }

    @Override // s1.d
    public final boolean l() {
        return this.M;
    }

    @Override // s1.d
    public final boolean m() {
        return true;
    }

    @Override // s1.d
    public final void n() {
        this.O = null;
        this.K = null;
        this.P = -9223372036854775807L;
    }

    @Override // s1.d
    public final void p(long j10, boolean z10) {
        this.O = null;
        this.L = false;
        this.M = false;
    }

    @Override // s1.d
    public final void u(p[] pVarArr, long j10, long j11, c2.d0 d0Var) {
        this.K = this.G.a(pVarArr[0]);
        f0 f0Var = this.O;
        if (f0Var != null) {
            long j12 = f0Var.f5877b;
            long j13 = (this.P + j12) - j11;
            if (j12 != j13) {
                f0Var = new f0(j13, f0Var.f5876a);
            }
            this.O = f0Var;
        }
        this.P = j11;
    }

    @Override // s1.d
    public final void w(long j10, long j11) {
        boolean z10 = true;
        while (z10) {
            if (!this.L && this.O == null) {
                t2.a aVar = this.J;
                aVar.j();
                e eVar = this.f11250q;
                eVar.f();
                int v10 = v(eVar, aVar, 0);
                if (v10 == -4) {
                    if (aVar.d(4)) {
                        this.L = true;
                    } else if (aVar.f10412u >= this.f11259z) {
                        aVar.f11873x = this.N;
                        aVar.n();
                        com.bumptech.glide.d dVar = this.K;
                        int i10 = l1.a0.f8067a;
                        f0 i11 = dVar.i(aVar);
                        if (i11 != null) {
                            ArrayList arrayList = new ArrayList(i11.f5876a.length);
                            B(i11, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.O = new f0(C(aVar.f10412u), (e0[]) arrayList.toArray(new e0[0]));
                            }
                        }
                    }
                } else if (v10 == -5) {
                    p pVar = (p) eVar.f13543q;
                    pVar.getClass();
                    this.N = pVar.f5996s;
                }
            }
            f0 f0Var = this.O;
            if (f0Var == null || f0Var.f5877b > C(j10)) {
                z10 = false;
            } else {
                f0 f0Var2 = this.O;
                Handler handler = this.I;
                if (handler != null) {
                    handler.obtainMessage(1, f0Var2).sendToTarget();
                } else {
                    D(f0Var2);
                }
                this.O = null;
                z10 = true;
            }
            if (this.L && this.O == null) {
                this.M = true;
            }
        }
    }

    @Override // s1.d
    public final int z(p pVar) {
        if (this.G.b(pVar)) {
            return r.a.a(pVar.O == 0 ? 4 : 2, 0, 0, 0);
        }
        return r.a.a(0, 0, 0, 0);
    }
}
