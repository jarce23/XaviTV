package androidx.fragment.app;

import android.util.Log;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements i0.a, f2.o {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f670o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f671p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f672q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f673r;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f670o = obj;
        this.f671p = obj2;
        this.f672q = obj3;
        this.f673r = obj4;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    @Override // f2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o9.w0 b(int r17, i1.u0 r18, int[] r19) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.e.b(int, i1.u0, int[]):o9.w0");
    }

    @Override // i0.a
    public void onCancel() {
        View view = (View) this.f670o;
        k kVar = (k) this.f671p;
        f fVar = (f) this.f672q;
        u0 u0Var = (u0) this.f673r;
        za.h.e("this$0", kVar);
        za.h.e("$animationInfo", fVar);
        za.h.e("$operation", u0Var);
        view.clearAnimation();
        kVar.f718a.endViewTransition(view);
        fVar.d();
        if (i0.F(2)) {
            Log.v("FragmentManager", "Animation from operation " + u0Var + " has been cancelled.");
        }
    }
}
