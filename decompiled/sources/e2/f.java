package e2;

import a6.n;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.v0;
import c2.d0;
import c2.e1;
import h3.h;
import i1.g0;
import i1.p;
import java.io.IOException;
import java.util.Objects;
import o9.w0;
import s1.a0;
import s1.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends s1.d implements Handler.Callback {
    public final d9.f G;
    public final r1.e H;
    public a I;
    public final e J;
    public boolean K;
    public int L;
    public h3.f M;
    public h N;
    public h3.d O;
    public h3.d P;
    public int Q;
    public final Handler R;
    public final x S;
    public final x4.e T;
    public boolean U;
    public boolean V;
    public p W;
    public long X;
    public long Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(x xVar, Looper looper) {
        super(3);
        n nVar = e.f4414b;
        this.S = xVar;
        this.R = looper == null ? null : new Handler(looper, this);
        this.J = nVar;
        this.G = new d9.f(20);
        this.H = new r1.e(1);
        this.T = new x4.e(16, false);
        this.Y = -9223372036854775807L;
        this.X = -9223372036854775807L;
    }

    public final void B() {
        l1.d.f("Legacy decoding is disabled, can't handle " + this.W.f5991n + " samples (expected application/x-media3-cues).", Objects.equals(this.W.f5991n, "application/cea-608") || Objects.equals(this.W.f5991n, "application/x-mp4-cea-608") || Objects.equals(this.W.f5991n, "application/cea-708"));
    }

    public final long C() {
        if (this.Q == -1) {
            return Long.MAX_VALUE;
        }
        this.O.getClass();
        if (this.Q >= this.O.w()) {
            return Long.MAX_VALUE;
        }
        return this.O.l(this.Q);
    }

    public final long D(long j10) {
        l1.d.g(j10 != -9223372036854775807L);
        return j10 - this.f11258y;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r3.equals("application/cea-608") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            r7 = this;
            r0 = 1
            r7.K = r0
            i1.p r1 = r7.W
            r1.getClass()
            e2.e r2 = r7.J
            a6.n r2 = (a6.n) r2
            java.lang.Object r2 = r2.f74p
            d9.f r2 = (d9.f) r2
            java.lang.String r3 = r1.f5991n
            int r4 = r1.K
            if (r3 == 0) goto L50
            int r5 = r3.hashCode()
            r6 = -1
            switch(r5) {
                case 930165504: goto L34;
                case 1566015601: goto L2b;
                case 1566016562: goto L20;
                default: goto L1e;
            }
        L1e:
            r0 = r6
            goto L3e
        L20:
            java.lang.String r0 = "application/cea-708"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L29
            goto L1e
        L29:
            r0 = 2
            goto L3e
        L2b:
            java.lang.String r5 = "application/cea-608"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L3e
            goto L1e
        L34:
            java.lang.String r0 = "application/x-mp4-cea-608"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L3d
            goto L1e
        L3d:
            r0 = 0
        L3e:
            switch(r0) {
                case 0: goto L4a;
                case 1: goto L4a;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L50
        L42:
            i3.g r0 = new i3.g
            java.util.List r1 = r1.f5994q
            r0.<init>(r4, r1)
            goto L6d
        L4a:
            i3.c r0 = new i3.c
            r0.<init>(r3, r4)
            goto L6d
        L50:
            boolean r0 = r2.b(r1)
            if (r0 == 0) goto L75
            h3.k r0 = r2.n(r1)
            e2.b r1 = new e2.b
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r3 = "Decoder"
            r2.concat(r3)
            r1.<init>(r0)
            r0 = r1
        L6d:
            r7.M = r0
            long r1 = r7.f11259z
            r0.c(r1)
            return
        L75:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Attempted to create decoder for unsupported MIME type: "
            java.lang.String r1 = r.a.l(r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.f.E():void");
    }

    public final void F(k1.c cVar) {
        w0 w0Var = cVar.f7642a;
        x xVar = this.S;
        xVar.f11482o.f11204m.e(27, new e5.c(3, w0Var));
        a0 a0Var = xVar.f11482o;
        a0Var.f11191e0 = cVar;
        a0Var.f11204m.e(27, new v0(21, cVar));
    }

    public final void G() {
        this.N = null;
        this.Q = -1;
        h3.d dVar = this.O;
        if (dVar != null) {
            dVar.k();
            this.O = null;
        }
        h3.d dVar2 = this.P;
        if (dVar2 != null) {
            dVar2.k();
            this.P = null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        F((k1.c) message.obj);
        return true;
    }

    @Override // s1.d
    public final String j() {
        return "TextRenderer";
    }

    @Override // s1.d
    public final boolean l() {
        return this.V;
    }

    @Override // s1.d
    public final boolean m() {
        p pVar = this.W;
        if (pVar != null) {
            if (Objects.equals(pVar.f5991n, "application/x-media3-cues")) {
                a aVar = this.I;
                aVar.getClass();
                if (aVar.b(this.X) == Long.MIN_VALUE) {
                    try {
                        e1 e1Var = this.f11256w;
                        e1Var.getClass();
                        e1Var.r();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    }
                }
            } else {
                if (this.V) {
                    return false;
                }
                if (this.U) {
                    h3.d dVar = this.O;
                    long j10 = this.X;
                    if (dVar == null || dVar.w() <= 0 || dVar.l(dVar.w() - 1) <= j10) {
                        h3.d dVar2 = this.P;
                        long j11 = this.X;
                        if ((dVar2 == null || dVar2.w() <= 0 || dVar2.l(dVar2.w() - 1) <= j11) && this.N != null) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // s1.d
    public final void n() {
        this.W = null;
        this.Y = -9223372036854775807L;
        w0 w0Var = w0.f9686s;
        D(this.X);
        k1.c cVar = new k1.c(w0Var);
        Handler handler = this.R;
        if (handler != null) {
            handler.obtainMessage(1, cVar).sendToTarget();
        } else {
            F(cVar);
        }
        this.X = -9223372036854775807L;
        if (this.M != null) {
            G();
            h3.f fVar = this.M;
            fVar.getClass();
            fVar.a();
            this.M = null;
            this.L = 0;
        }
    }

    @Override // s1.d
    public final void p(long j10, boolean z10) {
        this.X = j10;
        a aVar = this.I;
        if (aVar != null) {
            aVar.clear();
        }
        w0 w0Var = w0.f9686s;
        D(this.X);
        k1.c cVar = new k1.c(w0Var);
        Handler handler = this.R;
        if (handler != null) {
            handler.obtainMessage(1, cVar).sendToTarget();
        } else {
            F(cVar);
        }
        this.U = false;
        this.V = false;
        this.Y = -9223372036854775807L;
        p pVar = this.W;
        if (pVar == null || Objects.equals(pVar.f5991n, "application/x-media3-cues")) {
            return;
        }
        if (this.L == 0) {
            G();
            h3.f fVar = this.M;
            fVar.getClass();
            fVar.flush();
            fVar.c(this.f11259z);
            return;
        }
        G();
        h3.f fVar2 = this.M;
        fVar2.getClass();
        fVar2.a();
        this.M = null;
        this.L = 0;
        E();
    }

    @Override // s1.d
    public final void u(p[] pVarArr, long j10, long j11, d0 d0Var) {
        p pVar = pVarArr[0];
        this.W = pVar;
        if (Objects.equals(pVar.f5991n, "application/x-media3-cues")) {
            this.I = this.W.L == 1 ? new c() : new d(0);
            return;
        }
        B();
        if (this.M != null) {
            this.L = 1;
        } else {
            E();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021e A[EXC_TOP_SPLITTER, LOOP:1: B:94:0x021e->B:115:0x021e, LOOP_START, SYNTHETIC] */
    @Override // s1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(long r19, long r21) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.f.w(long, long):void");
    }

    @Override // s1.d
    public final int z(p pVar) {
        boolean equals = Objects.equals(pVar.f5991n, "application/x-media3-cues");
        String str = pVar.f5991n;
        if (!equals) {
            n nVar = (n) this.J;
            nVar.getClass();
            if (!((d9.f) nVar.f74p).b(pVar) && !Objects.equals(str, "application/cea-608") && !Objects.equals(str, "application/x-mp4-cea-608") && !Objects.equals(str, "application/cea-708")) {
                return g0.k(str) ? r.a.a(1, 0, 0, 0) : r.a.a(0, 0, 0, 0);
            }
        }
        return r.a.a(pVar.O == 0 ? 4 : 2, 0, 0, 0);
    }
}
