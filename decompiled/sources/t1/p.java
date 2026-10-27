package t1;

import c2.d0;
import i1.t0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f11831a;

    /* renamed from: b, reason: collision with root package name */
    public int f11832b;

    /* renamed from: c, reason: collision with root package name */
    public long f11833c;

    /* renamed from: d, reason: collision with root package name */
    public final d0 f11834d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11835e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11836f;
    public final /* synthetic */ q g;

    public p(q qVar, String str, int i10, d0 d0Var) {
        this.g = qVar;
        this.f11831a = str;
        this.f11832b = i10;
        this.f11833c = d0Var == null ? -1L : d0Var.f2542d;
        if (d0Var == null || !d0Var.b()) {
            return;
        }
        this.f11834d = d0Var;
    }

    public final boolean a(a aVar) {
        d0 d0Var = aVar.f11783d;
        t0 t0Var = aVar.f11781b;
        if (d0Var == null) {
            return this.f11832b != aVar.f11782c;
        }
        long j10 = this.f11833c;
        if (j10 == -1) {
            return false;
        }
        if (d0Var.f2542d > j10) {
            return true;
        }
        d0 d0Var2 = this.f11834d;
        if (d0Var2 == null) {
            return false;
        }
        int i10 = d0Var2.f2540b;
        int b2 = t0Var.b(d0Var.f2539a);
        int b10 = t0Var.b(d0Var2.f2539a);
        if (d0Var.f2542d < d0Var2.f2542d || b2 < b10) {
            return false;
        }
        if (b2 > b10) {
            return true;
        }
        if (!d0Var.b()) {
            int i11 = d0Var.f2543e;
            return i11 == -1 || i11 > i10;
        }
        int i12 = d0Var.f2540b;
        int i13 = d0Var.f2541c;
        if (i12 <= i10) {
            return i12 == i10 && i13 > d0Var2.f2541c;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 < r8.o()) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(i1.t0 r7, i1.t0 r8) {
        /*
            r6 = this;
            int r0 = r6.f11832b
            int r1 = r7.o()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L13
            int r7 = r8.o()
            if (r0 >= r7) goto L11
            goto L36
        L11:
            r0 = r3
            goto L36
        L13:
            t1.q r1 = r6.g
            i1.s0 r4 = r1.f11839a
            r7.n(r0, r4)
            int r0 = r4.f6033n
        L1c:
            int r5 = r4.f6034o
            if (r0 > r5) goto L11
            java.lang.Object r5 = r7.l(r0)
            int r5 = r8.b(r5)
            if (r5 == r3) goto L33
            i1.r0 r7 = r1.f11840b
            i1.r0 r7 = r8.f(r5, r7, r2)
            int r0 = r7.f6014c
            goto L36
        L33:
            int r0 = r0 + 1
            goto L1c
        L36:
            r6.f11832b = r0
            if (r0 != r3) goto L3b
            goto L4a
        L3b:
            c2.d0 r7 = r6.f11834d
            if (r7 != 0) goto L40
            goto L48
        L40:
            java.lang.Object r7 = r7.f2539a
            int r7 = r8.b(r7)
            if (r7 == r3) goto L4a
        L48:
            r7 = 1
            return r7
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.p.b(i1.t0, i1.t0):boolean");
    }
}
