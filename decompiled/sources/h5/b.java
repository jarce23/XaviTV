package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import app.shamel.tv.activities.HomeActivity;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.LoginModel;
import app.shamel.tv.models.WordModels;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class b extends androidx.fragment.app.o {
    public app.shamel.tv.activities.s A0;
    public LoginModel B0;
    public app.shamel.tv.helper.r C0;
    public TextView D0;
    public TextView E0;
    public TextView F0;
    public TextView G0;
    public TextView H0;
    public TextView I0;
    public TextView J0;
    public TextView K0;
    public TextView L0;
    public TextView M0;
    public TextView N0;
    public TextView O0;
    public TextView P0;
    public TextView Q0;
    public TextView R0;
    public View S0;
    public WordModels T0 = new WordModels();
    public final SimpleDateFormat U0 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    public long V0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public AppInfoModel f5581x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5582y0;

    /* renamed from: z0, reason: collision with root package name */
    public HomeActivity f5583z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        final int i10 = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_account, viewGroup, false);
        this.D0 = (TextView) inflate.findViewById(R.id.str_account);
        this.J0 = (TextView) inflate.findViewById(R.id.str_username);
        this.G0 = (TextView) inflate.findViewById(R.id.str_mac);
        this.I0 = (TextView) inflate.findViewById(R.id.str_state);
        this.F0 = (TextView) inflate.findViewById(R.id.str_expire);
        this.E0 = (TextView) inflate.findViewById(R.id.str_device_key);
        this.H0 = (TextView) inflate.findViewById(R.id.str_playlist_expire);
        this.S0 = inflate.findViewById(R.id.view_click);
        this.R0 = (TextView) inflate.findViewById(R.id.txt_username);
        this.N0 = (TextView) inflate.findViewById(R.id.txt_mac);
        this.Q0 = (TextView) inflate.findViewById(R.id.txt_state);
        this.M0 = (TextView) inflate.findViewById(R.id.txt_expire);
        this.L0 = (TextView) inflate.findViewById(R.id.txt_device_key);
        this.K0 = (TextView) inflate.findViewById(R.id.txt_connections);
        this.O0 = (TextView) inflate.findViewById(R.id.txt_max_connections);
        this.P0 = (TextView) inflate.findViewById(R.id.txt_playlist_expire);
        this.S0.setOnClickListener(new View.OnClickListener(this) { // from class: h5.a

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ b f5577p;

            {
                this.f5577p = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case 0:
                        this.f5577p.J(false, false);
                        break;
                    default:
                        this.f5577p.A0.f2050o.f1623d0.J(false, false);
                        break;
                }
            }
        });
        Button button = (Button) inflate.findViewById(R.id.btn_pay);
        this.f5582y0 = button;
        final int i11 = 1;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: h5.a

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ b f5577p;

            {
                this.f5577p = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i11) {
                    case 0:
                        this.f5577p.J(false, false);
                        break;
                    default:
                        this.f5577p.A0.f2050o.f1623d0.J(false, false);
                        break;
                }
            }
        });
        app.shamel.tv.helper.r rVar = new app.shamel.tv.helper.r(this.f5583z0);
        this.C0 = rVar;
        this.f5581x0 = rVar.b();
        this.B0 = this.C0.q();
        if (this.C0.g()) {
            this.R0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.K0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.O0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            this.P0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
        } else {
            LoginModel loginModel = this.B0;
            if (loginModel != null) {
                this.R0.setText(loginModel.getUsername());
                this.K0.setText(this.B0.getActive_cons());
                this.O0.setText(this.B0.getMax_connections());
                this.P0.setText(k5.j.g(this.B0.getExp_date()));
            }
        }
        try {
            this.V0 = this.U0.parse(this.f5581x0.getExpiredDate()).getTime();
        } catch (Exception unused) {
            this.V0 = 0L;
        }
        this.N0.setText(this.C0.r());
        if (this.f5581x0.getIs_trial() == 2 || this.V0 - new Date().getTime() > 604800000) {
            this.Q0.setText("Activate");
            this.f5582y0.setVisibility(8);
        } else {
            this.f5582y0.setVisibility(8);
            this.Q0.setText("Free Trial");
        }
        if (k5.j.b()) {
            this.f5582y0.setVisibility(8);
        }
        try {
            this.M0.setText(this.f5581x0.getExpiredDate());
        } catch (Exception unused2) {
            this.M0.setText("unlimited");
        }
        this.L0.setText(this.f5581x0.getDevice_key());
        WordModels k10 = app.shamel.tv.helper.a.k(this.f5583z0);
        this.T0 = k10;
        this.D0.setText(k10.getAccount());
        this.J0.setText(this.T0.getUsername());
        this.G0.setText(this.T0.getMac_address());
        this.F0.setText(this.T0.getExpire_date());
        this.I0.setText(this.T0.getApp_status());
        this.E0.setText(this.T0.getDevice_key());
        this.H0.setText(this.T0.getPlaylist_expire_date());
        this.f5582y0.setText(this.T0.getPay_with_google_pay() + "(€" + this.f5581x0.getPrice() + ")");
        return inflate;
    }
}
