package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u extends x4.f implements androidx.lifecycle.o0, androidx.lifecycle.r, f4.e, m0 {

    /* renamed from: s, reason: collision with root package name */
    public final f.j f825s;

    /* renamed from: t, reason: collision with root package name */
    public final f.j f826t;

    /* renamed from: u, reason: collision with root package name */
    public final Handler f827u;

    /* renamed from: v, reason: collision with root package name */
    public final j0 f828v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ f.j f829w;

    public u(f.j jVar) {
        this.f829w = jVar;
        Handler handler = new Handler();
        this.f828v = new j0();
        this.f825s = jVar;
        this.f826t = jVar;
        this.f827u = handler;
    }

    @Override // x4.f
    public final View F(int i10) {
        return this.f829w.findViewById(i10);
    }

    @Override // x4.f
    public final boolean G() {
        Window window = this.f829w.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // f4.e
    public final f4.d b() {
        return (f4.d) this.f829w.f311s.f3099d;
    }

    @Override // androidx.lifecycle.o0
    public final androidx.lifecycle.n0 e() {
        return this.f829w.e();
    }

    @Override // androidx.lifecycle.r
    public final androidx.lifecycle.t f() {
        return this.f829w.H;
    }

    @Override // androidx.fragment.app.m0
    public final void a() {
    }
}
