package app.shamel.tv.activities;

import android.content.Intent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements androidx.activity.result.b, h5.t, h5.j0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ HomeActivity f2050o;

    public /* synthetic */ s(HomeActivity homeActivity) {
        this.f2050o = homeActivity;
    }

    @Override // h5.t
    public void a() {
        this.f2050o.finishAffinity();
        System.exit(0);
    }

    @Override // androidx.activity.result.b
    public void c(Object obj) {
        androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
        if (aVar.f330o != -1 || aVar.f331p == null) {
            return;
        }
        int i10 = HomeActivity.B0;
        this.f2050o.P();
    }

    @Override // h5.j0
    public void f() {
        HomeActivity homeActivity = this.f2050o;
        Intent intent = new Intent(homeActivity, (Class<?>) ChangePlaylistActivity.class);
        intent.putExtra("is_home", false);
        homeActivity.startActivity(intent);
        homeActivity.finish();
    }

    @Override // h5.t
    public void e() {
    }
}
