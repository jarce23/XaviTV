package s1;

import android.os.Bundle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends i1.i0 {

    /* renamed from: q, reason: collision with root package name */
    public final int f11368q;

    /* renamed from: r, reason: collision with root package name */
    public final String f11369r;

    /* renamed from: s, reason: collision with root package name */
    public final int f11370s;

    /* renamed from: t, reason: collision with root package name */
    public final i1.p f11371t;

    /* renamed from: u, reason: collision with root package name */
    public final int f11372u;

    /* renamed from: v, reason: collision with root package name */
    public final c2.d0 f11373v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f11374w;

    public l(int i10, Exception exc, int i11) {
        this(i10, exc, i11, null, -1, null, 4, null, false);
    }

    public final l a(c2.d0 d0Var) {
        String message = getMessage();
        int i10 = l1.a0.f8067a;
        return new l(message, getCause(), this.f5902o, this.f11368q, this.f11369r, this.f11370s, this.f11371t, this.f11372u, d0Var, this.f5903p, this.f11374w);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, Throwable th, int i10, int i11, String str2, int i12, i1.p pVar, int i13, c2.d0 d0Var, long j10, boolean z10) {
        super(str, th, i10, j10);
        Bundle bundle = Bundle.EMPTY;
        l1.d.b(!z10 || i11 == 1);
        l1.d.b(th != null || i11 == 3);
        this.f11368q = i11;
        this.f11369r = str2;
        this.f11370s = i12;
        this.f11371t = pVar;
        this.f11372u = i13;
        this.f11373v = d0Var;
        this.f11374w = z10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(int r14, java.lang.Exception r15, int r16, java.lang.String r17, int r18, i1.p r19, int r20, c2.d0 r21, boolean r22) {
        /*
            r13 = this;
            if (r14 == 0) goto L43
            r0 = 1
            if (r14 == r0) goto L14
            r0 = 3
            if (r14 == r0) goto L11
            java.lang.String r0 = "Unexpected runtime error"
        La:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L4b
        L11:
            java.lang.String r0 = "Remote error"
            goto La
        L14:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r5 = r17
            r0.append(r5)
            java.lang.String r1 = " error, index="
            r0.append(r1)
            r6 = r18
            r0.append(r6)
            java.lang.String r1 = ", format="
            r0.append(r1)
            r7 = r19
            r0.append(r7)
            java.lang.String r1 = ", format_supported="
            r0.append(r1)
            java.lang.String r1 = l1.a0.y(r20)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L4b
        L43:
            r5 = r17
            r6 = r18
            r7 = r19
            java.lang.String r0 = "Source error"
        L4b:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L58
            java.lang.String r1 = ": null"
            java.lang.String r0 = r.a.c(r0, r1)
        L58:
            r1 = r0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r4 = r14
            r2 = r15
            r3 = r16
            r8 = r20
            r9 = r21
            r12 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.l.<init>(int, java.lang.Exception, int, java.lang.String, int, i1.p, int, c2.d0, boolean):void");
    }
}
