package r3;

import java.util.List;
import o9.g0;
import o9.w0;
import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements k2.n {

    /* renamed from: a, reason: collision with root package name */
    public final b f10453a = new b(null, "audio/ac4", 0, 1);

    /* renamed from: b, reason: collision with root package name */
    public final l1.t f10454b = new l1.t(Http2.INITIAL_MAX_FRAME_SIZE);

    /* renamed from: c, reason: collision with root package name */
    public boolean f10455c;

    @Override // k2.n
    public final void c(k2.p pVar) {
        this.f10453a.e(pVar, new e0(0, 1));
        pVar.f();
        pVar.t(new k2.r(-9223372036854775807L));
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        this.f10455c = false;
        this.f10453a.a();
    }

    @Override // k2.n
    public final int f(k2.o oVar, i1.s sVar) {
        l1.t tVar = this.f10454b;
        int read = oVar.read(tVar.f8129a, 0, Http2.INITIAL_MAX_FRAME_SIZE);
        if (read == -1) {
            return -1;
        }
        tVar.I(0);
        tVar.H(read);
        boolean z10 = this.f10455c;
        b bVar = this.f10453a;
        if (!z10) {
            bVar.f10446o = 0L;
            this.f10455c = true;
        }
        bVar.b(tVar);
        return 0;
    }

    @Override // k2.n
    public final List g() {
        o9.e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
    
        return false;
     */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(k2.o r15) {
        /*
            r14 = this;
            l1.t r0 = new l1.t
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = r2
        L9:
            byte[] r4 = r0.f8129a
            r5 = r15
            k2.k r5 = (k2.k) r5
            r5.m(r4, r2, r1, r2)
            r0.I(r2)
            int r4 = r0.z()
            r6 = 4801587(0x494433, float:6.728456E-39)
            r7 = 3
            if (r4 == r6) goto L90
            r5.f7755t = r2
            r5.f(r3, r2)
            r15 = r2
            r1 = r3
        L25:
            byte[] r4 = r0.f8129a
            r6 = 7
            r5.m(r4, r2, r6, r2)
            r0.I(r2)
            int r4 = r0.C()
            r8 = 44096(0xac40, float:6.1792E-41)
            r9 = 44097(0xac41, float:6.1793E-41)
            if (r4 == r8) goto L4c
            if (r4 == r9) goto L4c
            r5.f7755t = r2
            int r1 = r1 + 1
            int r15 = r1 - r3
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r15 < r4) goto L47
            goto L89
        L47:
            r5.f(r1, r2)
            r15 = r2
            goto L25
        L4c:
            r8 = 1
            int r15 = r15 + r8
            r10 = 4
            if (r15 < r10) goto L52
            return r8
        L52:
            byte[] r8 = r0.f8129a
            int r11 = r8.length
            r12 = -1
            if (r11 >= r6) goto L5a
            r11 = r12
            goto L87
        L5a:
            r11 = 2
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r13 = r8[r7]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r13 = 65535(0xffff, float:9.1834E-41)
            if (r11 != r13) goto L81
            r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 16
            r11 = 5
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r10 = r10 | r11
            r11 = 6
            r8 = r8[r11]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r11 = r10 | r8
            goto L82
        L81:
            r6 = r10
        L82:
            if (r4 != r9) goto L86
            int r6 = r6 + 2
        L86:
            int r11 = r11 + r6
        L87:
            if (r11 != r12) goto L8a
        L89:
            return r2
        L8a:
            int r11 = r11 + (-7)
            r5.f(r11, r2)
            goto L25
        L90:
            r0.J(r7)
            int r4 = r0.v()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.f(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.c.m(k2.o):boolean");
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final k2.n b() {
        return this;
    }
}
