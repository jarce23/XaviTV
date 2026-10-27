package androidx.activity;

import androidx.fragment.app.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w implements c {

    /* renamed from: o, reason: collision with root package name */
    public final a0 f359o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ y f360p;

    public w(y yVar, a0 a0Var) {
        za.h.e("onBackPressedCallback", a0Var);
        this.f360p = yVar;
        this.f359o = a0Var;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [ya.a, za.g] */
    @Override // androidx.activity.c
    public final void cancel() {
        y yVar = this.f360p;
        ma.h hVar = yVar.f363b;
        a0 a0Var = this.f359o;
        hVar.remove(a0Var);
        if (za.h.a(yVar.f364c, a0Var)) {
            a0Var.getClass();
            yVar.f364c = null;
        }
        a0Var.f645b.remove(this);
        ?? r02 = a0Var.f646c;
        if (r02 != 0) {
            r02.invoke();
        }
        a0Var.f646c = null;
    }
}
