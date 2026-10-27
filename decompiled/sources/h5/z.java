package h5;

import android.content.SharedPreferences;
import android.view.View;
import app.shamel.tv.activities.SettingActivity;
import app.shamel.tv.models.LanguageModel;
import app.shamel.tv.models.WordModels;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5681o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a0 f5682p;

    public /* synthetic */ z(a0 a0Var, int i10) {
        this.f5681o = i10;
        this.f5682p = a0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5681o) {
            case 0:
                a0 a0Var = this.f5682p;
                a7.g gVar = a0Var.C0;
                int i10 = a0Var.G0;
                SettingActivity settingActivity = (SettingActivity) gVar.f124p;
                List list = (List) gVar.f125q;
                app.shamel.tv.helper.r rVar = settingActivity.f1853k0;
                String code = ((LanguageModel) list.get(i10)).getCode();
                SharedPreferences.Editor edit = rVar.f2098b.edit();
                edit.putString("language_code", code);
                edit.apply();
                WordModels k10 = app.shamel.tv.helper.a.k(settingActivity);
                settingActivity.f1859q0 = k10;
                ArrayList P = settingActivity.P(k10);
                settingActivity.f1856n0 = P;
                d5.y yVar = settingActivity.f1846c0;
                yVar.g = P;
                yVar.d();
                a0Var.J(false, false);
                break;
            default:
                this.f5682p.J(false, false);
                break;
        }
    }
}
