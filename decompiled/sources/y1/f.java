package y1;

import android.graphics.Bitmap;
import android.os.Trace;
import androidx.emoji2.text.o;
import androidx.media3.exoplayer.image.ImageOutput;
import c2.a1;
import i1.p;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends s1.d {
    public final o G;
    public final r1.e H;
    public final ArrayDeque I;
    public boolean J;
    public boolean K;
    public e L;
    public long M;
    public long N;
    public int O;
    public int P;
    public p Q;
    public b R;
    public r1.e S;
    public ImageOutput T;
    public Bitmap U;
    public boolean V;
    public a1 W;
    public a1 X;
    public int Y;
    public boolean Z;

    public f(o oVar) {
        super(4);
        this.G = oVar;
        this.T = ImageOutput.f1199a;
        this.H = new r1.e(0);
        this.L = e.f13761c;
        this.I = new ArrayDeque();
        this.N = -9223372036854775807L;
        this.M = -9223372036854775807L;
        this.O = 0;
        this.P = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0146, code lost:
    
        if (r14 == ((r0 * r1.M) - 1)) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(long r13) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.B(long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if (r2 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010e, code lost:
    
        if (r2 == false) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(long r13) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.C(long):boolean");
    }

    public final void D() {
        if (this.Z) {
            p pVar = this.Q;
            pVar.getClass();
            o oVar = this.G;
            oVar.getClass();
            int c10 = o.c(pVar);
            if (c10 != r.a.a(4, 0, 0, 0) && c10 != r.a.a(3, 0, 0, 0)) {
                throw f(new c("Provided decoder factory can't create decoder for format."), this.Q, false, 4005);
            }
            b bVar = this.R;
            if (bVar != null) {
                bVar.a();
            }
            this.R = new b(oVar.f591o);
            this.Z = false;
        }
    }

    public final void E() {
        this.S = null;
        this.O = 0;
        this.N = -9223372036854775807L;
        b bVar = this.R;
        if (bVar != null) {
            bVar.a();
            this.R = null;
        }
    }

    @Override // s1.d, s1.a1
    public final void c(int i10, Object obj) {
        if (i10 != 15) {
            return;
        }
        ImageOutput imageOutput = obj instanceof ImageOutput ? (ImageOutput) obj : null;
        if (imageOutput == null) {
            imageOutput = ImageOutput.f1199a;
        }
        this.T = imageOutput;
    }

    @Override // s1.d
    public final String j() {
        return "ImageRenderer";
    }

    @Override // s1.d
    public final boolean l() {
        return this.K;
    }

    @Override // s1.d
    public final boolean m() {
        int i10 = this.P;
        if (i10 != 3) {
            return i10 == 0 && this.V;
        }
        return true;
    }

    @Override // s1.d
    public final void n() {
        this.Q = null;
        this.L = e.f13761c;
        this.I.clear();
        E();
        this.T.a();
    }

    @Override // s1.d
    public final void o(boolean z10, boolean z11) {
        this.P = z11 ? 1 : 0;
    }

    @Override // s1.d
    public final void p(long j10, boolean z10) {
        this.P = Math.min(this.P, 1);
        this.K = false;
        this.J = false;
        this.U = null;
        this.W = null;
        this.X = null;
        this.V = false;
        this.S = null;
        b bVar = this.R;
        if (bVar != null) {
            bVar.flush();
        }
        this.I.clear();
    }

    @Override // s1.d
    public final void q() {
        E();
    }

    @Override // s1.d
    public final void r() {
        E();
        this.P = Math.min(this.P, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r2 >= r6) goto L15;
     */
    @Override // s1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(i1.p[] r5, long r6, long r8, c2.d0 r10) {
        /*
            r4 = this;
            y1.e r5 = r4.L
            long r5 = r5.f13763b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 == 0) goto L31
            java.util.ArrayDeque r5 = r4.I
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L26
            long r6 = r4.N
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 == 0) goto L31
            long r2 = r4.M
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 == 0) goto L26
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L26
            goto L31
        L26:
            y1.e r6 = new y1.e
            long r0 = r4.N
            r6.<init>(r0, r8)
            r5.add(r6)
            return
        L31:
            y1.e r5 = new y1.e
            r5.<init>(r0, r8)
            r4.L = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.u(i1.p[], long, long, c2.d0):void");
    }

    @Override // s1.d
    public final void w(long j10, long j11) {
        if (this.K) {
            return;
        }
        if (this.Q == null) {
            x4.e eVar = this.f11250q;
            eVar.f();
            r1.e eVar2 = this.H;
            eVar2.j();
            int v10 = v(eVar, eVar2, 2);
            if (v10 != -5) {
                if (v10 == -4) {
                    l1.d.g(eVar2.d(4));
                    this.J = true;
                    this.K = true;
                    return;
                }
                return;
            }
            p pVar = (p) eVar.f13543q;
            l1.d.h(pVar);
            this.Q = pVar;
            this.Z = true;
        }
        if (this.R == null) {
            D();
        }
        try {
            Trace.beginSection("drainAndFeedDecoder");
            while (B(j10)) {
            }
            while (C(j10)) {
            }
            Trace.endSection();
        } catch (c e7) {
            throw f(e7, null, false, 4003);
        }
    }

    @Override // s1.d
    public final int z(p pVar) {
        this.G.getClass();
        return o.c(pVar);
    }
}
