package h5;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.shamel.tv.models.WordModels;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class u0 extends androidx.fragment.app.o implements View.OnClickListener {
    public ImageView A0;
    public ImageView B0;
    public ConstraintLayout C0;
    public ConstraintLayout D0;
    public ConstraintLayout E0;
    public app.shamel.tv.helper.r F0;
    public TextView G0;
    public TextView H0;
    public TextView I0;
    public TextView J0;
    public int K0;
    public SwitchCompat L0;
    public TextView M0;
    public TextView N0;
    public boolean O0 = false;
    public int P0 = 5;
    public int Q0 = 12;
    public int R0 = 60;
    public WordModels S0 = new WordModels();

    /* renamed from: x0, reason: collision with root package name */
    public ImageButton f5664x0;

    /* renamed from: y0, reason: collision with root package name */
    public ImageButton f5665y0;

    /* renamed from: z0, reason: collision with root package name */
    public Context f5666z0;

    public final void N(boolean z10) {
        androidx.fragment.app.i0 h10 = h();
        h10.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(h10);
        androidx.fragment.app.s A = h10.A("fragment_subtitle_color");
        if (A != null) {
            android.support.v4.media.d.v(aVar, A, false);
            return;
        }
        Context i10 = i();
        t0 t0Var = new t0();
        t0Var.f5659y0 = i10;
        t0Var.G0 = z10;
        t0Var.f5660z0 = new i(1, this);
        t0Var.M(h10, "fragment_subtitle_color");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_minus) {
            int i10 = this.K0;
            int i11 = this.Q0;
            int i12 = this.P0;
            if (i10 > i11 + i12) {
                this.K0 = i10 - i12;
                this.N0.setText(this.K0 + "pt");
                this.F0.b0(this.K0);
                return;
            }
            return;
        }
        if (id == R.id.btn_plus) {
            int i13 = this.K0;
            int i14 = this.R0;
            int i15 = this.P0;
            if (i13 < i14 - i15) {
                this.K0 = i13 + i15;
                this.N0.setText(this.K0 + "pt");
                this.F0.b0(this.K0);
                return;
            }
            return;
        }
        if (id == R.id.ly_bg_color) {
            N(false);
            return;
        }
        if (id != R.id.ly_enable) {
            if (id == R.id.ly_text_color) {
                N(true);
                return;
            }
            return;
        }
        boolean z10 = !this.O0;
        this.O0 = z10;
        this.L0.setChecked(z10);
        app.shamel.tv.helper.r rVar = this.F0;
        boolean z11 = this.O0;
        SharedPreferences.Editor edit = rVar.f2098b.edit();
        edit.putBoolean("subtitle_enable", z11);
        edit.apply();
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_subtitle, viewGroup, false);
        this.F0 = new app.shamel.tv.helper.r(this.f5666z0);
        this.S0 = app.shamel.tv.helper.a.k(this.f5666z0);
        if (app.shamel.tv.helper.a.l(this.f5666z0)) {
            this.P0 = 5;
            this.Q0 = 12;
            this.R0 = 1000;
        } else {
            this.P0 = 2;
            this.Q0 = 6;
            this.R0 = 48;
        }
        this.K0 = this.F0.F();
        this.O0 = this.F0.E();
        this.M0 = (TextView) inflate.findViewById(R.id.txt_header);
        this.H0 = (TextView) inflate.findViewById(R.id.str_enable);
        this.I0 = (TextView) inflate.findViewById(R.id.str_subtitle_size);
        this.J0 = (TextView) inflate.findViewById(R.id.str_text_color);
        this.G0 = (TextView) inflate.findViewById(R.id.str_bg_color);
        this.N0 = (TextView) inflate.findViewById(R.id.txt_subtitle_size);
        this.E0 = (ConstraintLayout) inflate.findViewById(R.id.ly_enable);
        this.D0 = (ConstraintLayout) inflate.findViewById(R.id.ly_text_color);
        this.C0 = (ConstraintLayout) inflate.findViewById(R.id.ly_bg_color);
        this.f5664x0 = (ImageButton) inflate.findViewById(R.id.btn_minus);
        this.f5665y0 = (ImageButton) inflate.findViewById(R.id.btn_plus);
        this.B0 = (ImageView) inflate.findViewById(R.id.image_subtitle_color);
        this.A0 = (ImageView) inflate.findViewById(R.id.image_background_color);
        this.L0 = (SwitchCompat) inflate.findViewById(R.id.switch_subtitle);
        this.E0.setOnClickListener(this);
        this.D0.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        this.f5664x0.setOnClickListener(this);
        this.f5665y0.setOnClickListener(this);
        this.I0.setText(this.S0.getSubtitel_size());
        this.M0.setText(this.S0.getSubtitle_settings());
        this.H0.setText(this.S0.getEnable_subtitles());
        this.J0.setText(this.S0.getSubtitel_color());
        this.G0.setText(this.S0.getSubtitel_background());
        this.N0.setText(this.K0 + "pt");
        this.L0.setChecked(this.O0);
        this.B0.setBackgroundColor(Color.parseColor(this.F0.D()));
        this.A0.setBackgroundColor(Color.parseColor(this.F0.C()));
        return inflate;
    }
}
