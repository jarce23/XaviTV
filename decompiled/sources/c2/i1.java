package c2;

import android.net.Uri;
import j9.v1;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i1 extends i1.t0 {

    /* renamed from: n, reason: collision with root package name */
    public static final Object f2605n = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final long f2606b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2607c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2608d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2609e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2610f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2611h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2612i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2613j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2614k;

    /* renamed from: l, reason: collision with root package name */
    public final i1.a0 f2615l;

    /* renamed from: m, reason: collision with root package name */
    public final i1.w f2616m;

    static {
        i1.s sVar = new i1.s();
        o9.e0 e0Var = o9.g0.f9617p;
        o9.w0 w0Var = o9.w0.f9686s;
        List list = Collections.EMPTY_LIST;
        o9.w0 w0Var2 = o9.w0.f9686s;
        i1.v vVar = new i1.v();
        i1.y yVar = i1.y.f6072a;
        Uri uri = Uri.EMPTY;
        if (uri != null) {
            new i1.x(uri, null, null, list, w0Var2, -9223372036854775807L);
        }
        sVar.a();
        vVar.a();
        i1.d0 d0Var = i1.d0.B;
    }

    public i1(long j10, long j11, long j12, long j13, long j14, long j15, boolean z10, boolean z11, boolean z12, v1 v1Var, i1.a0 a0Var, i1.w wVar) {
        this.f2606b = j10;
        this.f2607c = j11;
        this.f2608d = j12;
        this.f2609e = j13;
        this.f2610f = j14;
        this.g = j15;
        this.f2611h = z10;
        this.f2612i = z11;
        this.f2613j = z12;
        this.f2614k = v1Var;
        a0Var.getClass();
        this.f2615l = a0Var;
        this.f2616m = wVar;
    }

    @Override // i1.t0
    public final int b(Object obj) {
        return f2605n.equals(obj) ? 0 : -1;
    }

    @Override // i1.t0
    public final i1.r0 f(int i10, i1.r0 r0Var, boolean z10) {
        l1.d.c(i10, 1);
        Object obj = z10 ? f2605n : null;
        long j10 = -this.f2610f;
        r0Var.getClass();
        r0Var.h(null, obj, 0, this.f2608d, j10, i1.c.f5813c, false);
        return r0Var;
    }

    @Override // i1.t0
    public final int h() {
        return 1;
    }

    @Override // i1.t0
    public final Object l(int i10) {
        l1.d.c(i10, 1);
        return f2605n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r1 > r3) goto L10;
     */
    @Override // i1.t0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i1.s0 m(int r22, i1.s0 r23, long r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = 1
            r2 = r22
            l1.d.c(r2, r1)
            long r1 = r0.g
            boolean r13 = r0.f2612i
            if (r13 == 0) goto L2c
            boolean r3 = r0.f2613j
            if (r3 != 0) goto L2c
            r3 = 0
            int r3 = (r24 > r3 ? 1 : (r24 == r3 ? 0 : -1))
            if (r3 == 0) goto L2c
            long r3 = r0.f2609e
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L25
        L23:
            r15 = r5
            goto L2d
        L25:
            long r1 = r1 + r24
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2c
            goto L23
        L2c:
            r15 = r1
        L2d:
            java.lang.Object r1 = i1.s0.f6019q
            long r1 = r0.f2609e
            long r3 = r0.f2610f
            r19 = r3
            i1.a0 r4 = r0.f2615l
            java.lang.Object r5 = r0.f2614k
            long r6 = r0.f2606b
            long r8 = r0.f2607c
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            boolean r12 = r0.f2611h
            i1.w r14 = r0.f2616m
            r3 = r23
            r17 = r1
            r3.b(r4, r5, r6, r8, r10, r12, r13, r14, r15, r17, r19)
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.i1.m(int, i1.s0, long):i1.s0");
    }

    @Override // i1.t0
    public final int o() {
        return 1;
    }
}
