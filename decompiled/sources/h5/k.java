package h5;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.WordModels;
import c2.j1;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class k extends androidx.fragment.app.o implements View.OnClickListener, j5.d {
    public Button A0;
    public ImageButton B0;
    public Context C0;
    public EditText D0;
    public EditText E0;
    public EditText F0;
    public EditText G0;
    public j H0;
    public app.shamel.tv.helper.r I0;
    public TextView J0;
    public TextView K0;
    public TextView L0;
    public TextView M0;
    public TextView N0;
    public TextView O0;
    public TextView P0;
    public WordModels Q0 = new WordModels();
    public List R0 = new ArrayList();
    public int S0 = -1;
    public String T0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String U0 = "general";
    public String V0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String W0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public boolean X0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public AppInfoModel f5614x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5615y0;

    /* renamed from: z0, reason: collision with root package name */
    public Button f5616z0;

    public final void N(String str) {
        this.U0 = "general";
        if (this.D0.getText().toString().isEmpty()) {
            String str2 = "Playlist" + (this.R0.size() + 1);
            this.T0 = str2;
            this.D0.setText(str2);
        }
        this.T0 = this.D0.getText().toString();
        if (this.F0.getText().toString().isEmpty()) {
            Toast.makeText(this.C0, this.Q0.getPut_m3u_link(), 0).show();
            return;
        }
        this.W0 = this.F0.getText().toString().trim();
        if (this.X0) {
            this.U0 = "general";
            if (this.G0.getText().toString().isEmpty()) {
                Toast.makeText(this.C0, this.Q0.getPut_username(), 0).show();
                return;
            }
            if (this.E0.getText().toString().isEmpty()) {
                Toast.makeText(this.C0, this.Q0.getPut_password(), 0).show();
                return;
            }
            String trim = this.G0.getText().toString().trim();
            this.W0 = (this.W0 + "/get.php?username=" + trim + "&password=" + this.E0.getText().toString().trim() + "&output=ts&type=m3u_plus").trim();
        }
        String lowerCase = this.I0.r().toLowerCase();
        String str3 = this.T0;
        String str4 = this.W0;
        String str5 = this.U0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac_address", lowerCase);
            jSONObject.put("playlist_id", str);
            jSONObject.put("playlist_name", str3);
            jSONObject.put("playlist_url", str4);
            jSONObject.put("playlist_type", str5);
            jSONObject.put("app_type", "android");
        } catch (Exception e7) {
            Log.e("Security", "getAddData", e7);
        }
        String trim2 = new String(Base64.encode(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 0)).trim();
        int nextInt = new Random().nextInt(20);
        int nextInt2 = new Random().nextInt(trim2.length());
        if (nextInt2 > 42) {
            nextInt2 = 42;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(trim2.substring(0, nextInt2) + com.google.android.gms.internal.cast.n.j(nextInt) + trim2.substring(nextInt2));
        sb2.append(com.google.android.gms.internal.cast.n.k(nextInt2));
        sb2.append(com.google.android.gms.internal.cast.n.k(nextInt));
        String sb3 = sb2.toString();
        j1 j1Var = new j1(i(), 1000);
        j1Var.i(com.google.android.gms.internal.cast.n.l(sb3), e5.l.f4609d);
        j1Var.f2627r = this;
    }

    public final void O() {
        int i10 = this.S0;
        if (!this.X0) {
            if (i10 != -1) {
                this.F0.setText(((AppInfoModel.UrlModel) this.R0.get(i10)).getUrl());
            }
            this.M0.setText(this.Q0.getEnter_m3u());
            this.N0.setVisibility(8);
            this.L0.setVisibility(8);
            this.G0.setVisibility(8);
            this.E0.setVisibility(8);
            this.D0.setNextFocusDownId(R.id.btn_add);
            this.F0.setNextFocusDownId(R.id.btn_add);
            this.f5615y0.setNextFocusUpId(R.id.et_name);
            this.f5616z0.requestFocus();
            return;
        }
        if (i10 != -1) {
            this.F0.setText(app.shamel.tv.helper.a.e(((AppInfoModel.UrlModel) this.R0.get(i10)).getUrl()));
        }
        this.M0.setText(this.Q0.getPort());
        this.N0.setText(this.Q0.getUsername());
        this.L0.setText(this.Q0.getPassword());
        this.N0.setVisibility(0);
        this.L0.setVisibility(0);
        this.G0.setVisibility(0);
        this.E0.setVisibility(0);
        this.D0.setNextFocusDownId(R.id.et_username);
        this.F0.setNextFocusDownId(R.id.et_password);
        this.f5615y0.setNextFocusUpId(R.id.et_username);
        this.A0.requestFocus();
    }

    public final void P() {
        Context i10 = i();
        String str_playlist_uploaded_successfully = this.Q0.getStr_playlist_uploaded_successfully();
        String ok = this.Q0.getOk();
        String cancel = this.Q0.getCancel();
        i iVar = new i(0, this);
        g5.b bVar = new g5.b(i10);
        bVar.requestWindowFeature(1);
        bVar.setContentView(R.layout.dlg_success);
        bVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Button button = (Button) bVar.findViewById(R.id.btn_ok);
        Button button2 = (Button) bVar.findViewById(R.id.btn_cancel);
        button.setText(ok);
        button2.setText(cancel);
        ((TextView) bVar.findViewById(R.id.txt_description)).setText(str_playlist_uploaded_successfully);
        button.setOnClickListener(new g5.a(bVar, iVar, 0));
        button2.setOnClickListener(new g5.a(bVar, iVar, 1));
        button.requestFocus();
        bVar.show();
    }

    @Override // j5.d
    public final void a(JSONObject jSONObject, int i10) {
        if (jSONObject == null) {
            androidx.fragment.app.i0 h10 = h();
            h10.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(h10);
            androidx.fragment.app.s A = h10.A("no_connection");
            if (A != null) {
                android.support.v4.media.d.v(aVar, A, false);
                return;
            }
            Context i11 = i();
            String check_internet = this.Q0.getCheck_internet();
            k0 k0Var = new k0();
            k0Var.f5618y0 = i11;
            k0Var.D0 = check_internet;
            k0Var.f5619z0 = new androidx.fragment.app.v0(9, this);
            k0Var.M(h10, "no_connection");
            return;
        }
        try {
            AppInfoModel.UrlModel urlModel = new AppInfoModel.UrlModel();
            urlModel.setId(jSONObject.getString("id"));
            urlModel.setName(jSONObject.getString("name").trim());
            urlModel.setUrl(jSONObject.getString("url").trim());
            int i12 = this.S0;
            if (i12 != -1) {
                this.R0.set(i12, urlModel);
            } else {
                this.R0.add(urlModel);
            }
            this.f5614x0.setResult(this.R0);
            this.I0.L(this.f5614x0);
            k5.j.p(this.f5614x0);
            P();
        } catch (Exception e7) {
            Log.e("OnGetResponseResult", "JSON parsing error", e7);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        try {
            if (id == R.id.btn_add) {
                N(this.V0);
                return;
            }
            if (id == R.id.btn_back) {
                J(false, false);
                return;
            }
            if (id == R.id.txt_add_m3u) {
                this.X0 = false;
                O();
            } else if (id == R.id.txt_add_xc) {
                this.X0 = true;
                O();
            }
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        View inflate = layoutInflater.inflate(R.layout.fragment_add_playlist, viewGroup, false);
        this.I0 = new app.shamel.tv.helper.r(i());
        this.Q0 = app.shamel.tv.helper.a.k(i());
        AppInfoModel b2 = this.I0.b();
        this.f5614x0 = b2;
        if (b2 != null) {
            this.R0 = b2.getResult();
        }
        this.B0 = (ImageButton) inflate.findViewById(R.id.btn_back);
        this.P0 = (TextView) inflate.findViewById(R.id.txt_name);
        this.A0 = (Button) inflate.findViewById(R.id.txt_add_xc);
        this.f5616z0 = (Button) inflate.findViewById(R.id.txt_add_m3u);
        this.O0 = (TextView) inflate.findViewById(R.id.txt_mac_address);
        this.K0 = (TextView) inflate.findViewById(R.id.str_mac_address);
        this.J0 = (TextView) inflate.findViewById(R.id.str_list_name);
        this.M0 = (TextView) inflate.findViewById(R.id.str_url);
        this.N0 = (TextView) inflate.findViewById(R.id.str_username);
        this.L0 = (TextView) inflate.findViewById(R.id.str_password);
        this.D0 = (EditText) inflate.findViewById(R.id.et_name);
        this.F0 = (EditText) inflate.findViewById(R.id.et_url);
        this.G0 = (EditText) inflate.findViewById(R.id.et_username);
        this.E0 = (EditText) inflate.findViewById(R.id.et_password);
        this.f5615y0 = (Button) inflate.findViewById(R.id.btn_add);
        this.B0.setOnClickListener(this);
        this.A0.setOnClickListener(this);
        this.f5616z0.setOnClickListener(this);
        this.f5615y0.setOnClickListener(this);
        this.P0.setText(this.Q0.getAdd_playlist());
        this.A0.setText(this.Q0.getXtreme_codes());
        this.f5616z0.setText(this.Q0.getAdd_m3u());
        this.f5615y0.setText(this.Q0.getAdd_playlist());
        this.O0.setText(this.I0.r());
        this.K0.setText(this.Q0.getMac_address());
        this.J0.setText(this.Q0.getPlaylist_name());
        int i10 = this.S0;
        if (i10 != -1) {
            if (((AppInfoModel.UrlModel) this.R0.get(i10)).getUrl().contains("username") && ((AppInfoModel.UrlModel) this.R0.get(this.S0)).getUrl().contains("password")) {
                this.X0 = true;
                this.F0.setText(app.shamel.tv.helper.a.e(((AppInfoModel.UrlModel) this.R0.get(this.S0)).getUrl()));
                EditText editText = this.G0;
                try {
                    str = new URL(((AppInfoModel.UrlModel) this.R0.get(this.S0)).getUrl().replaceAll(" ", _UrlKt.FRAGMENT_ENCODE_SET).trim()).getQuery().split("&")[0].split("=")[1];
                } catch (Exception unused) {
                    str = _UrlKt.FRAGMENT_ENCODE_SET;
                }
                editText.setText(str);
                EditText editText2 = this.E0;
                try {
                    str2 = new URL(((AppInfoModel.UrlModel) this.R0.get(this.S0)).getUrl().replaceAll(" ", _UrlKt.FRAGMENT_ENCODE_SET).trim()).getQuery().split("&")[1].split("=")[1];
                } catch (Exception unused2) {
                }
                editText2.setText(str2);
            } else {
                this.X0 = false;
                this.F0.setText(((AppInfoModel.UrlModel) this.R0.get(this.S0)).getUrl());
            }
            this.D0.setText(((AppInfoModel.UrlModel) this.R0.get(this.S0)).getName());
            this.V0 = ((AppInfoModel.UrlModel) this.R0.get(this.S0)).getId();
            this.f5615y0.setText(this.Q0.getStr_update_playlist());
            this.P0.setText(this.Q0.getStr_edit_playlist());
        }
        O();
        this.f762s0.setOnKeyListener(new e(this, 1));
        return inflate;
    }
}
