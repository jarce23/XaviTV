package h5;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import app.shamel.tv.activities.SettingActivity;
import app.shamel.tv.activities.a1;
import app.shamel.tv.activities.y0;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class v0 extends androidx.fragment.app.o implements View.OnClickListener {
    public TextView A0;
    public String B0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String C0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String D0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public boolean E0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public Button f5669x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5670y0;

    /* renamed from: z0, reason: collision with root package name */
    public y0 f5671z0;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel) {
            J(false, false);
            return;
        }
        if (id != R.id.btn_ok) {
            return;
        }
        if (!this.E0) {
            J(false, false);
            return;
        }
        SettingActivity settingActivity = this.f5671z0.f2079p;
        int i10 = SettingActivity.f1845u0;
        if (k5.j.b()) {
            new a1(settingActivity).execute(settingActivity.f1849f0.getApk_link());
            return;
        }
        String packageName = settingActivity.getPackageName();
        try {
            settingActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            settingActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_update, viewGroup, false);
        this.A0 = (TextView) inflate.findViewById(R.id.txt_description);
        this.f5670y0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5669x0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f5670y0.setOnClickListener(this);
        this.f5669x0.setOnClickListener(this);
        this.A0.setText(this.B0);
        this.f5670y0.setText(this.C0);
        this.f5669x0.setText(this.D0);
        return inflate;
    }
}
