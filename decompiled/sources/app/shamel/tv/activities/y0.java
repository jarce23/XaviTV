package app.shamel.tv.activities;

import android.content.SharedPreferences;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class y0 implements h5.e0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2078o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SettingActivity f2079p;

    public /* synthetic */ y0(SettingActivity settingActivity, int i10) {
        this.f2078o = i10;
        this.f2079p = settingActivity;
    }

    @Override // h5.e0
    public void a(int i10) {
        int i11 = this.f2078o;
        SettingActivity settingActivity = this.f2079p;
        switch (i11) {
            case 0:
                app.shamel.tv.helper.r rVar = settingActivity.f1853k0;
                boolean z10 = i10 == 1;
                SharedPreferences.Editor edit = rVar.f2098b.edit();
                edit.putBoolean("is_allow_protocol", z10);
                edit.apply();
                break;
            case 1:
                SharedPreferences.Editor edit2 = settingActivity.f1853k0.f2098b.edit();
                edit2.putInt("update_period", i10);
                edit2.apply();
                break;
            case 2:
                if (i10 == 0) {
                    int i12 = SettingActivity.f1845u0;
                    settingActivity.getClass();
                    if (!k5.j.b()) {
                        settingActivity.f1853k0.O("tv");
                        break;
                    } else {
                        settingActivity.f1853k0.O("amazon");
                        break;
                    }
                } else {
                    settingActivity.f1853k0.O("mobile");
                    break;
                }
            case 3:
                SharedPreferences.Editor edit3 = settingActivity.f1853k0.f2098b.edit();
                edit3.putInt("live_order", i10);
                edit3.apply();
                break;
            case 4:
                SharedPreferences.Editor edit4 = settingActivity.f1853k0.f2098b.edit();
                edit4.putInt("time_format", i10);
                edit4.apply();
                break;
            case 5:
                SharedPreferences.Editor edit5 = settingActivity.f1853k0.f2098b.edit();
                edit5.putInt("external_player", i10);
                edit5.apply();
                break;
            default:
                app.shamel.tv.helper.r rVar2 = settingActivity.f1853k0;
                String str = i10 == 0 ? "ts" : "m3u8";
                SharedPreferences.Editor edit6 = rVar2.f2098b.edit();
                edit6.putString("live_stream_format", str);
                edit6.apply();
                break;
        }
    }
}
