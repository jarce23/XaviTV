package mb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements lb.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kb.e f9068a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9069b;

    public d(kb.e eVar, int i10) {
        this.f9068a = eVar;
        this.f9069b = i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x004a, code lost:
    
        if (r6.f9068a.b(r8, r0) == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // lb.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r7, ra.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof mb.c
            if (r0 == 0) goto L13
            r0 = r8
            mb.c r0 = (mb.c) r0
            int r1 = r0.f9067q
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9067q = r1
            goto L18
        L13:
            mb.c r0 = new mb.c
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f9065o
            qa.a r1 = qa.a.f10374o
            int r2 = r0.f9067q
            la.i r3 = la.i.f8335a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L38
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            com.google.android.gms.internal.cast.n.t(r8)
            return r3
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            com.google.android.gms.internal.cast.n.t(r8)
            goto L4d
        L38:
            com.google.android.gms.internal.cast.n.t(r8)
            ma.s r8 = new ma.s
            int r2 = r6.f9069b
            r8.<init>(r2, r7)
            r0.f9067q = r5
            kb.e r7 = r6.f9068a
            java.lang.Object r7 = r7.b(r8, r0)
            if (r7 != r1) goto L4d
            goto La6
        L4d:
            r0.f9067q = r4
            pa.i r7 = r0.getContext()
            ib.r r8 = ib.r.f6589p
            pa.g r8 = r7.s(r8)
            ib.p0 r8 = (ib.p0) r8
            if (r8 == 0) goto L6b
            boolean r2 = r8.a()
            if (r2 == 0) goto L64
            goto L6b
        L64:
            ib.y0 r8 = (ib.y0) r8
            java.util.concurrent.CancellationException r7 = r8.u()
            throw r7
        L6b:
            pa.d r8 = a.a.m(r0)
            boolean r0 = r8 instanceof nb.h
            if (r0 == 0) goto L76
            nb.h r8 = (nb.h) r8
            goto L77
        L76:
            r8 = 0
        L77:
            if (r8 != 0) goto L7b
            r7 = r3
            goto L9e
        L7b:
            ib.q r0 = r8.f9319r
            boolean r2 = r0.O()
            if (r2 == 0) goto L8b
            r8.f9321t = r3
            r8.f6619q = r5
            r0.N(r7, r8)
            goto L9d
        L8b:
            ib.j1 r2 = new ib.j1
            ib.r r4 = ib.j1.f6567p
            r2.<init>(r4)
            pa.i r7 = r7.K(r2)
            r8.f9321t = r3
            r8.f6619q = r5
            r0.N(r7, r8)
        L9d:
            r7 = r1
        L9e:
            qa.a r8 = qa.a.f10374o
            if (r7 != r8) goto La3
            goto La4
        La3:
            r7 = r3
        La4:
            if (r7 != r1) goto La7
        La6:
            return r1
        La7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.d.a(java.lang.Object, ra.c):java.lang.Object");
    }
}
