package lb;

import x4.o;
import za.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8345a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8346b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8347c;

    public d(e eVar, m mVar, g gVar) {
        this.f8346b = mVar;
        this.f8347c = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    @Override // lb.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r7, ra.c r8) {
        /*
            r6 = this;
            int r0 = r6.f8345a
            switch(r0) {
                case 0: goto L15;
                default: goto L5;
            }
        L5:
            t4.c r7 = (t4.c) r7
            java.lang.Object r8 = r6.f8346b
            t4.e r8 = (t4.e) r8
            java.lang.Object r0 = r6.f8347c
            x4.o r0 = (x4.o) r0
            r8.e(r0, r7)
            la.i r7 = la.i.f8335a
            return r7
        L15:
            java.lang.Object r0 = r6.f8346b
            za.m r0 = (za.m) r0
            boolean r1 = r8 instanceof lb.c
            if (r1 == 0) goto L2c
            r1 = r8
            lb.c r1 = (lb.c) r1
            int r2 = r1.f8344q
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L2c
            int r2 = r2 - r3
            r1.f8344q = r2
            goto L31
        L2c:
            lb.c r1 = new lb.c
            r1.<init>(r6, r8)
        L31:
            java.lang.Object r8 = r1.f8342o
            qa.a r2 = qa.a.f10374o
            int r3 = r1.f8344q
            la.i r4 = la.i.f8335a
            r5 = 1
            if (r3 == 0) goto L4b
            if (r3 != r5) goto L43
            com.google.android.gms.internal.cast.n.t(r8)
        L41:
            r2 = r4
            goto L68
        L43:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4b:
            com.google.android.gms.internal.cast.n.t(r8)
            java.lang.Object r8 = r0.f14177o
            androidx.emoji2.text.s r3 = mb.h.f9085a
            if (r8 == r3) goto L5a
            boolean r8 = za.h.a(r8, r7)
            if (r8 != 0) goto L41
        L5a:
            r0.f14177o = r7
            java.lang.Object r8 = r6.f8347c
            lb.g r8 = (lb.g) r8
            r1.f8344q = r5
            java.lang.Object r7 = r8.a(r7, r1)
            if (r7 != r2) goto L41
        L68:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.d.a(java.lang.Object, ra.c):java.lang.Object");
    }

    public d(t4.e eVar, o oVar) {
        this.f8346b = eVar;
        this.f8347c = oVar;
    }
}
