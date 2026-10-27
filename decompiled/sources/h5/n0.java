package h5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import app.shamel.tv.models.WordModels;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class n0 extends androidx.fragment.app.o implements j5.d {
    public EditText A0;
    public EditText B0;
    public app.shamel.tv.helper.r C0;
    public TextView D0;
    public TextView E0;
    public TextView F0;
    public TextView G0;
    public String H0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public WordModels I0 = new WordModels();

    /* renamed from: x0, reason: collision with root package name */
    public Button f5632x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5633y0;

    /* renamed from: z0, reason: collision with root package name */
    public EditText f5634z0;

    @Override // j5.d
    public final void a(JSONObject jSONObject, int i10) {
        if (jSONObject != null) {
            try {
                if (jSONObject.getBoolean("status")) {
                    app.shamel.tv.helper.r rVar = this.C0;
                    String str = this.H0;
                    SharedPreferences.Editor edit = rVar.f2098b.edit();
                    edit.putString("parent_control", str);
                    edit.apply();
                    Toast.makeText(i(), this.I0.getParent_pass_changed(), 0).show();
                    this.B0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                    this.A0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                    this.f5634z0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                    J(false, false);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_parent, viewGroup, false);
        this.G0 = (TextView) inflate.findViewById(R.id.txt_name);
        this.F0 = (TextView) inflate.findViewById(R.id.str_password);
        this.E0 = (TextView) inflate.findViewById(R.id.str_new_password);
        this.D0 = (TextView) inflate.findViewById(R.id.str_confirm_password);
        this.B0 = (EditText) inflate.findViewById(R.id.et_password);
        this.A0 = (EditText) inflate.findViewById(R.id.et_new_password);
        this.f5634z0 = (EditText) inflate.findViewById(R.id.et_confirm_password);
        this.f5633y0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5632x0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f5633y0.setOnClickListener(new l0(this, 0));
        this.f5632x0.setOnClickListener(new l0(this, 1));
        app.shamel.tv.helper.r rVar = new app.shamel.tv.helper.r(i());
        this.C0 = rVar;
        rVar.b();
        this.H0 = this.C0.u();
        WordModels k10 = app.shamel.tv.helper.a.k(i());
        this.I0 = k10;
        this.G0.setText(k10.getParent_control());
        this.F0.setText(this.I0.getPassword());
        this.E0.setText(this.I0.getNet_pass());
        this.D0.setText(this.I0.getConfirm_password());
        this.f5633y0.setText(this.I0.getOk());
        this.f5632x0.setText(this.I0.getCancel());
        this.B0.addTextChangedListener(new m0(this, 0));
        this.f5634z0.addTextChangedListener(new m0(this, 1));
        this.f762s0.setOnKeyListener(new e(this, 8));
        return inflate;
    }
}
