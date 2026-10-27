package l4;

import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends n {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8195a = false;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f8196b;

    public c(ViewGroup viewGroup) {
        this.f8196b = viewGroup;
    }

    @Override // l4.n, l4.k
    public final void b() {
        com.bumptech.glide.c.B(this.f8196b, false);
    }

    @Override // l4.n, l4.k
    public final void e() {
        com.bumptech.glide.c.B(this.f8196b, true);
    }

    @Override // l4.n, l4.k
    public final void f(m mVar) {
        com.bumptech.glide.c.B(this.f8196b, false);
        this.f8195a = true;
    }

    @Override // l4.k
    public final void g(m mVar) {
        if (!this.f8195a) {
            com.bumptech.glide.c.B(this.f8196b, false);
        }
        mVar.w(this);
    }
}
