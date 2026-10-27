package lb;

import androidx.lifecycle.h0;
import java.io.Serializable;
import java.util.ArrayList;
import la.i;
import ma.j;
import nb.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8340a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Serializable f8341b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(f[] fVarArr) {
        this.f8341b = fVarArr;
    }

    @Override // lb.f
    public final Object a(g gVar, ra.h hVar) {
        switch (this.f8340a) {
            case 0:
                mb.a aVar = new mb.a(gVar, this, (pa.d) null, 0);
                t tVar = new t(hVar.getContext(), hVar);
                Object u10 = a.a.u(tVar, tVar, aVar);
                return u10 == qa.a.f10374o ? u10 : i.f8335a;
            default:
                f[] fVarArr = (f[]) this.f8341b;
                mb.f fVar = new mb.f(fVarArr, new h0(3, fVarArr), new t4.g(3, null), gVar, null);
                mb.g gVar2 = new mb.g(hVar.getContext(), hVar);
                Object u11 = a.a.u(gVar2, gVar2, fVar);
                qa.a aVar2 = qa.a.f10374o;
                i iVar = i.f8335a;
                if (u11 != aVar2) {
                    u11 = iVar;
                }
                return u11 == aVar2 ? u11 : iVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(kb.s r6, ra.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof lb.a
            if (r0 == 0) goto L13
            r0 = r7
            lb.a r0 = (lb.a) r0
            int r1 = r0.f8339r
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8339r = r1
            goto L18
        L13:
            lb.a r0 = new lb.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f8337p
            qa.a r1 = qa.a.f10374o
            int r2 = r0.f8339r
            la.i r3 = la.i.f8335a
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kb.s r6 = r0.f8336o
            com.google.android.gms.internal.cast.n.t(r7)
            goto L49
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            com.google.android.gms.internal.cast.n.t(r7)
            r0.f8336o = r6
            r0.f8339r = r4
            java.io.Serializable r7 = r5.f8341b
            mb.b r7 = (mb.b) r7
            java.lang.Object r7 = r7.b(r6, r0)
            if (r7 != r1) goto L45
            goto L46
        L45:
            r7 = r3
        L46:
            if (r7 != r1) goto L49
            return r1
        L49:
            kb.r r6 = (kb.r) r6
            kb.e r6 = r6.f7924r
            boolean r6 = r6.t()
            if (r6 == 0) goto L54
            return r3
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.b.b(kb.s, ra.c):java.lang.Object");
    }

    public String c() {
        kb.a aVar = kb.a.f7868o;
        ArrayList arrayList = new ArrayList(4);
        arrayList.add("capacity=-2");
        return getClass().getSimpleName() + '[' + j.F(arrayList, ", ", null, null, null, 62) + ']';
    }

    public String toString() {
        switch (this.f8340a) {
            case 0:
                return "block[" + ((mb.b) this.f8341b) + "] -> " + c();
            default:
                return super.toString();
        }
    }

    public b(mb.b bVar) {
        kb.a aVar = kb.a.f7868o;
        this.f8341b = bVar;
    }
}
