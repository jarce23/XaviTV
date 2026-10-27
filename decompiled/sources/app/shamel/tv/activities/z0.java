package app.shamel.tv.activities;

import android.content.Intent;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z0 implements h5.j, h5.e0, h5.j0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SettingActivity f2082o;

    public /* synthetic */ z0(SettingActivity settingActivity) {
        this.f2082o = settingActivity;
    }

    @Override // h5.e0
    public void a(int i10) {
        app.shamel.tv.helper.r rVar = this.f2082o.f1853k0;
        boolean z10 = i10 != 0;
        SharedPreferences.Editor edit = rVar.f2098b.edit();
        edit.putBoolean("is_grid", z10);
        edit.apply();
    }

    @Override // h5.j
    public void b() {
        this.f2082o.f1847d0.J(false, false);
    }

    @Override // h5.j0
    public void f() {
        SettingActivity settingActivity = this.f2082o;
        Intent intent = new Intent(settingActivity, (Class<?>) ChangePlaylistActivity.class);
        intent.addFlags(67108864);
        settingActivity.startActivity(intent);
        settingActivity.finish();
    }
}
