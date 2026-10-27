package v4;

import android.content.Context;
import android.net.ConnectivityManager;
import com.bumptech.glide.manager.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends f {

    /* renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f12673f;
    public final p g;

    public h(Context context, x4.i iVar) {
        super(context, iVar);
        Object systemService = this.f12668b.getSystemService("connectivity");
        za.h.c("null cannot be cast to non-null type android.net.ConnectivityManager", systemService);
        this.f12673f = (ConnectivityManager) systemService;
        this.g = new p(2, this);
    }

    @Override // v4.f
    public final Object a() {
        return i.a(this.f12673f);
    }

    @Override // v4.f
    public final void c() {
        try {
            o4.p.d().a(i.f12674a, "Registering network callback");
            y4.j.a(this.f12673f, this.g);
        } catch (IllegalArgumentException e7) {
            o4.p.d().c(i.f12674a, "Received exception while registering network callback", e7);
        } catch (SecurityException e8) {
            o4.p.d().c(i.f12674a, "Received exception while registering network callback", e8);
        }
    }

    @Override // v4.f
    public final void d() {
        try {
            o4.p.d().a(i.f12674a, "Unregistering network callback");
            y4.h.c(this.f12673f, this.g);
        } catch (IllegalArgumentException e7) {
            o4.p.d().c(i.f12674a, "Received exception while unregistering network callback", e7);
        } catch (SecurityException e8) {
            o4.p.d().c(i.f12674a, "Received exception while unregistering network callback", e8);
        }
    }
}
