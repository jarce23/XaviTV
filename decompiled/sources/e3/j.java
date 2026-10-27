package e3;

import android.util.Pair;
import android.util.SparseArray;
import i1.h0;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import k2.g0;
import l1.a0;
import l1.y;
import o9.e0;
import o9.w0;
import okhttp3.internal.http.HttpStatusCodesKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements k2.n {
    public static final byte[] N = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final i1.p O;
    public long A;
    public i B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public k2.p H;
    public g0[] I;
    public g0[] J;
    public boolean K;
    public boolean L;
    public long M;

    /* renamed from: a, reason: collision with root package name */
    public final h3.i f4449a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4450b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4451c;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f4455h;

    /* renamed from: i, reason: collision with root package name */
    public final l1.t f4456i;

    /* renamed from: j, reason: collision with root package name */
    public final y f4457j;

    /* renamed from: o, reason: collision with root package name */
    public final b4.b f4462o;

    /* renamed from: p, reason: collision with root package name */
    public final c4.k f4463p;

    /* renamed from: q, reason: collision with root package name */
    public w0 f4464q;

    /* renamed from: r, reason: collision with root package name */
    public int f4465r;

    /* renamed from: s, reason: collision with root package name */
    public int f4466s;

    /* renamed from: t, reason: collision with root package name */
    public long f4467t;

    /* renamed from: u, reason: collision with root package name */
    public int f4468u;

    /* renamed from: v, reason: collision with root package name */
    public l1.t f4469v;

    /* renamed from: w, reason: collision with root package name */
    public long f4470w;

    /* renamed from: x, reason: collision with root package name */
    public int f4471x;

    /* renamed from: y, reason: collision with root package name */
    public long f4472y;

    /* renamed from: z, reason: collision with root package name */
    public long f4473z;

    /* renamed from: k, reason: collision with root package name */
    public final x4.r f4458k = new x4.r(16);

    /* renamed from: l, reason: collision with root package name */
    public final l1.t f4459l = new l1.t(16);

    /* renamed from: e, reason: collision with root package name */
    public final l1.t f4453e = new l1.t(m1.o.f8813a);

    /* renamed from: f, reason: collision with root package name */
    public final l1.t f4454f = new l1.t(6);
    public final l1.t g = new l1.t();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayDeque f4460m = new ArrayDeque();

    /* renamed from: n, reason: collision with root package name */
    public final ArrayDeque f4461n = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f4452d = new SparseArray();

    static {
        i1.o oVar = new i1.o();
        oVar.f5940m = i1.g0.m("application/x-emsg");
        O = new i1.p(oVar);
    }

    public j(h3.i iVar, int i10, y yVar, List list) {
        this.f4449a = iVar;
        this.f4450b = i10;
        this.f4457j = yVar;
        this.f4451c = Collections.unmodifiableList(list);
        byte[] bArr = new byte[16];
        this.f4455h = bArr;
        this.f4456i = new l1.t(bArr);
        e0 e0Var = o9.g0.f9617p;
        this.f4464q = w0.f9686s;
        this.f4473z = -9223372036854775807L;
        this.f4472y = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.H = k2.p.f7764e;
        this.I = new g0[0];
        this.J = new g0[0];
        this.f4462o = new b4.b(new g(this));
        this.f4463p = new c4.k(1);
        this.M = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i1.l h(java.util.List r19) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.j.h(java.util.List):i1.l");
    }

    public static void i(l1.t tVar, int i10, s sVar) {
        tVar.I(i10 + 8);
        int j10 = tVar.j();
        byte[] bArr = e.f4428a;
        if ((j10 & 1) != 0) {
            throw h0.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (j10 & 2) != 0;
        int A = tVar.A();
        if (A == 0) {
            Arrays.fill(sVar.f4541l, 0, sVar.f4535e, false);
            return;
        }
        int i11 = sVar.f4535e;
        l1.t tVar2 = sVar.f4543n;
        if (A != i11) {
            StringBuilder f10 = r.a.f("Senc sample count ", A, " is different from fragment sample count");
            f10.append(sVar.f4535e);
            throw h0.a(null, f10.toString());
        }
        Arrays.fill(sVar.f4541l, 0, A, z10);
        tVar2.F(tVar.a());
        sVar.f4540k = true;
        sVar.f4544o = true;
        tVar.h(tVar2.f8129a, 0, tVar2.f8131c);
        tVar2.I(0);
        sVar.f4544o = false;
    }

    public static Pair j(long j10, l1.t tVar) {
        long B;
        long B2;
        l1.t tVar2 = tVar;
        tVar2.I(8);
        int e7 = e.e(tVar2.j());
        tVar2.J(4);
        long y8 = tVar2.y();
        if (e7 == 0) {
            B = tVar2.y();
            B2 = tVar2.y();
        } else {
            B = tVar2.B();
            B2 = tVar2.B();
        }
        long j11 = B2 + j10;
        int i10 = a0.f8067a;
        long V = a0.V(B, 1000000L, y8, RoundingMode.DOWN);
        tVar2.J(2);
        int C = tVar2.C();
        int[] iArr = new int[C];
        long[] jArr = new long[C];
        long[] jArr2 = new long[C];
        long[] jArr3 = new long[C];
        long j12 = j11;
        long j13 = V;
        int i11 = 0;
        while (i11 < C) {
            int j14 = tVar2.j();
            if ((Integer.MIN_VALUE & j14) != 0) {
                throw h0.a(null, "Unhandled indirect reference");
            }
            long y10 = tVar2.y();
            iArr[i11] = j14 & Integer.MAX_VALUE;
            jArr[i11] = j12;
            jArr3[i11] = j13;
            B += y10;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long V2 = a0.V(B, 1000000L, y8, RoundingMode.DOWN);
            jArr4[i11] = V2 - jArr5[i11];
            tVar2.J(4);
            j12 += iArr[i11];
            i11++;
            C = C;
            tVar2 = tVar;
            j13 = V2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(V), new k2.j(iArr, jArr, jArr2, jArr3));
    }

    @Override // k2.n
    public final void c(k2.p pVar) {
        int i10;
        int i11 = this.f4450b;
        if ((i11 & 32) == 0) {
            pVar = new c4.e(pVar, this.f4449a);
        }
        this.H = pVar;
        d();
        g0[] g0VarArr = new g0[2];
        this.I = g0VarArr;
        int i12 = 100;
        int i13 = 0;
        if ((i11 & 4) != 0) {
            g0VarArr[0] = this.H.q(100, 5);
            i10 = 1;
            i12 = HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS;
        } else {
            i10 = 0;
        }
        g0[] g0VarArr2 = (g0[]) a0.Q(i10, this.I);
        this.I = g0VarArr2;
        for (g0 g0Var : g0VarArr2) {
            g0Var.a(O);
        }
        List list = this.f4451c;
        this.J = new g0[list.size()];
        while (i13 < this.J.length) {
            g0 q10 = this.H.q(i12, 3);
            q10.a((i1.p) list.get(i13));
            this.J[i13] = q10;
            i13++;
            i12++;
        }
    }

    public final void d() {
        this.f4465r = 0;
        this.f4468u = 0;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        SparseArray sparseArray = this.f4452d;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((i) sparseArray.valueAt(i10)).e();
        }
        this.f4461n.clear();
        this.f4471x = 0;
        ((PriorityQueue) this.f4462o.f2179e).clear();
        this.f4472y = j11;
        this.f4460m.clear();
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:376:0x00ce, code lost:
    
        r5 = r2.f4437a;
        r6 = r2.f4438b;
        r12 = "video/avc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x00db, code lost:
    
        if (r32.f4465r != 3) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x00df, code lost:
    
        if (r2.f4448m != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x00e1, code lost:
    
        r9 = r2.f4440d.f4550d[r2.f4442f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x00f0, code lost:
    
        r32.C = r9;
        r9 = r2.f4440d.f4547a.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x00fe, code lost:
    
        if (java.util.Objects.equals(r9.f5991n, "video/avc") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0102, code lost:
    
        if ((r4 & 64) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0104, code lost:
    
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0117, code lost:
    
        r32.F = !r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x011f, code lost:
    
        if (r2.f4442f >= r2.f4444i) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x0121, code lost:
    
        r0.i(r32.C);
        r0 = r2.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x012a, code lost:
    
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x012d, code lost:
    
        r3 = r6.f4543n;
        r0 = r0.f4529d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0131, code lost:
    
        if (r0 == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0133, code lost:
    
        r3.J(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0136, code lost:
    
        r0 = r2.f4442f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x013a, code lost:
    
        if (r6.f4540k == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0140, code lost:
    
        if (r6.f4541l[r0] == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0142, code lost:
    
        r3.J(r3.C() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x014e, code lost:
    
        if (r2.c() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0150, code lost:
    
        r32.B = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0153, code lost:
    
        r32.f4465r = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0156, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x015f, code lost:
    
        if (r2.f4440d.f4547a.f4521h != r21) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x0161, code lost:
    
        r32.C -= 8;
        r0.i(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x017a, code lost:
    
        if ("audio/ac4".equals(r2.f4440d.f4547a.g.f5991n) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x017c, code lost:
    
        r32.D = r2.d(r32.C, 7);
        k2.b.g(r32.C, r8);
        r5.c(7, r8);
        r32.D += 7;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x019f, code lost:
    
        r32.C += r32.D;
        r32.f4465r = 4;
        r32.E = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0195, code lost:
    
        r8 = 0;
        r32.D = r2.d(r32.C, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0107, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0110, code lost:
    
        if (java.util.Objects.equals(r9.f5991n, "video/hevc") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x0114, code lost:
    
        if ((r4 & 128) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x00ea, code lost:
    
        r9 = r6.f4537h[r2.f4442f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x01aa, code lost:
    
        r4 = r2.f4440d;
        r8 = r4.f4547a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x01b0, code lost:
    
        if (r2.f4448m != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x01b2, code lost:
    
        r15 = r4.f4552f[r2.f4442f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x01b8, code lost:
    
        r34 = "video/hevc";
        r10 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x01c3, code lost:
    
        if (r14 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x01c5, code lost:
    
        r10 = r14.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x01c9, code lost:
    
        r4 = r8.f4524k;
        r8 = r8.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x01cd, code lost:
    
        if (r4 == 0) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x01cf, code lost:
    
        r9 = r32.f4454f;
        r15 = r9.f8129a;
        r15[0] = 0;
        r15[1] = 0;
        r15[r20] = 0;
        r6 = 4 - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x01df, code lost:
    
        r22 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x01e5, code lost:
    
        if (r32.D >= r32.C) goto L527;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x01e7, code lost:
    
        r2 = r32.E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x01e9, code lost:
    
        if (r2 != 0) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x01ee, code lost:
    
        if (r32.J.length > 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x01f2, code lost:
    
        if (r32.F != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x0209, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x020a, code lost:
    
        r0.readFully(r15, r6, r4 + r2);
        r9.I(0);
        r19 = r9.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x0217, code lost:
    
        if (r19 < 0) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0219, code lost:
    
        r32.E = r19 - r2;
        r13 = r32.f4453e;
        r25 = r4;
        r13.I(0);
        r5.c(4, r13);
        r32.D += 4;
        r32.C += r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x0236, code lost:
    
        if (r32.J.length <= 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x0238, code lost:
    
        if (r2 <= 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x023a, code lost:
    
        r13 = r15[4];
        r4 = r8.f5991n;
        r20 = r6;
        r6 = r8.f5988k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x0246, code lost:
    
        if (java.util.Objects.equals(r4, r12) != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x024c, code lost:
    
        if (i1.g0.b(r6, r12) == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x024f, code lost:
    
        r26 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x025a, code lost:
    
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x0262, code lost:
    
        if (java.util.Objects.equals(r8.f5991n, r12) != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x0268, code lost:
    
        if (i1.g0.b(r6, r12) == null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x027f, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x0280, code lost:
    
        r32.G = r4;
        r5.c(r2, r9);
        r32.D += r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x028a, code lost:
    
        if (r2 <= 0) goto L529;
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x028e, code lost:
    
        if (r32.F != false) goto L530;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0294, code lost:
    
        if (m1.o.c(r15, r2, r8) == false) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0296, code lost:
    
        r32.F = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x0299, code lost:
    
        r34 = r12;
        r6 = r20;
        r2 = r22;
        r4 = r25;
        r12 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:463:0x0272, code lost:
    
        if (((r13 & 126) >> 1) != 39) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x0277, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x0253, code lost:
    
        r26 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x0258, code lost:
    
        if ((r13 & 31) == 6) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x0275, code lost:
    
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x0279, code lost:
    
        r20 = r6;
        r26 = r12;
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x02ac, code lost:
    
        throw i1.h0.a(null, "Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x01f4, code lost:
    
        r2 = m1.o.d(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x0204, code lost:
    
        if ((r4 + r2) > (r32.C - r32.D)) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x0206, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x02ad, code lost:
    
        r25 = r4;
        r20 = r6;
        r26 = r12;
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x02b7, code lost:
    
        if (r32.G == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x02b9, code lost:
    
        r4 = r32.g;
        r4.F(r2);
        r0.readFully(r4.f8129a, 0, r32.E);
        r5.c(r32.E, r4);
        r2 = r32.E;
        r2 = m1.o.m(r4.f8131c, r4.f8129a);
        r4.I(0);
        r4.H(r2);
        r2 = r8.f5993p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x02e0, code lost:
    
        if (r2 != (-1)) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x02e4, code lost:
    
        if (r7.f2175a == 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x02e6, code lost:
    
        r7.v(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x02f1, code lost:
    
        r7.a(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x02fd, code lost:
    
        if ((r22.a() & 4) == 0) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x02ff, code lost:
    
        r7.i(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0302, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x030c, code lost:
    
        r32.D += r2;
        r32.E -= r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x02ec, code lost:
    
        if (r7.f2175a == r2) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x02ee, code lost:
    
        r7.v(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x0305, code lost:
    
        r2 = r5.f(r0, r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x032b, code lost:
    
        r0 = r22.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x0331, code lost:
    
        if (r32.F != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x0333, code lost:
    
        r0 = r0 | 67108864;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x0336, code lost:
    
        r28 = r0;
        r0 = r22.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x033c, code lost:
    
        if (r0 == null) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x033e, code lost:
    
        r31 = r0.f4528c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x0345, code lost:
    
        r26 = r10;
        r5.e(r26, r28, r32.C, 0, r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x0356, code lost:
    
        if (r3.isEmpty() != false) goto L533;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0358, code lost:
    
        r0 = (e3.h) r3.removeFirst();
        r32.f4471x -= r0.f4436c;
        r4 = r0.f4434a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x0369, code lost:
    
        if (r0.f4435b == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:0x036b, code lost:
    
        r4 = r4 + r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x036d, code lost:
    
        if (r14 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:0x036f, code lost:
    
        r4 = r14.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x0373, code lost:
    
        r7 = r4;
        r2 = r32.I;
        r4 = r2.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x0378, code lost:
    
        if (r5 >= r4) goto L536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:0x037a, code lost:
    
        r2[r5].e(r7, 1, r0.f4436c, r32.f4471x, null);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x038c, code lost:
    
        if (r22.c() != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x038e, code lost:
    
        r32.B = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x0391, code lost:
    
        r32.f4465r = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:518:0x0396, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:519:0x0343, code lost:
    
        r31 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:520:0x0317, code lost:
    
        r22 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x0319, code lost:
    
        r2 = r32.D;
        r4 = r32.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x031d, code lost:
    
        if (r2 >= r4) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:523:0x031f, code lost:
    
        r32.D += r5.f(r0, r4 - r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:525:0x01bc, code lost:
    
        r15 = r6.f4538i[r2.f4442f];
     */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r33, i1.s r34) {
        /*
            Method dump skipped, instructions count: 2320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.j.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        return this.f4464q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x0423, code lost:
    
        if ((l1.a0.V(r39, 1000000, r7, r45) + l1.a0.V(r7[0], 1000000, r3.f4517c, r45)) >= r3.f4519e) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x07df, code lost:
    
        d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x07e2, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(long r54) {
        /*
            Method dump skipped, instructions count: 2019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.j.k(long):void");
    }

    @Override // k2.n
    public final boolean m(k2.o oVar) {
        w0 w0Var;
        k2.e0 k10 = p.k(oVar, true, false);
        if (k10 != null) {
            w0Var = o9.g0.r(k10);
        } else {
            e0 e0Var = o9.g0.f9617p;
            w0Var = w0.f9686s;
        }
        this.f4464q = w0Var;
        return k10 == null;
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final k2.n b() {
        return this;
    }
}
