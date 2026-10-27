package androidx.fragment.app;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f682a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f683b;

    public h0(i0 i0Var, int i10) {
        this.f683b = i0Var;
        this.f682a = i10;
    }

    @Override // androidx.fragment.app.g0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        i0 i0Var = this.f683b;
        s sVar = i0Var.f710w;
        int i10 = this.f682a;
        if (sVar == null || i10 >= 0 || !sVar.h().N(-1, 0)) {
            return i0Var.O(arrayList, arrayList2, i10, 1);
        }
        return false;
    }
}
