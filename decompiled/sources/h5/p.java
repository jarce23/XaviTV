package h5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import app.shamel.tv.MainActivity;
import app.shamel.tv.models.WordModels;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class p extends androidx.fragment.app.o {
    public TextView A0;
    public TextView B0;
    public TextView C0;
    public TextView D0;
    public TextView E0;
    public String F0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String G0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public int H0 = 0;
    public app.shamel.tv.helper.r I0;
    public WordModels J0;
    public app.shamel.tv.b K0;

    /* renamed from: x0, reason: collision with root package name */
    public Button f5639x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5640y0;

    /* renamed from: z0, reason: collision with root package name */
    public TextView f5641z0;

    @Override // androidx.fragment.app.o, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        app.shamel.tv.b bVar = this.K0;
        if (bVar != null) {
            MainActivity mainActivity = (MainActivity) bVar.f2096q;
            int i10 = MainActivity.f1561l0;
            mainActivity.R();
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void t(Context context) {
        super.t(context);
        this.I0 = new app.shamel.tv.helper.r(context);
        this.J0 = app.shamel.tv.helper.a.k(context);
        this.I0.b();
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
        Bundle bundle2 = this.f811t;
        if (bundle2 != null) {
            this.F0 = bundle2.getString("arg_subscription", _UrlKt.FRAGMENT_ENCODE_SET);
            this.G0 = bundle2.getString("arg_description", _UrlKt.FRAGMENT_ENCODE_SET);
            this.H0 = bundle2.getInt("arg_playlist_size", 0);
        }
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_description, viewGroup, false);
        this.f5641z0 = (TextView) inflate.findViewById(R.id.txt_description);
        this.A0 = (TextView) inflate.findViewById(R.id.txt_subscription);
        this.B0 = (TextView) inflate.findViewById(R.id.txt_mac_address);
        this.C0 = (TextView) inflate.findViewById(R.id.txt_device_key);
        this.D0 = (TextView) inflate.findViewById(R.id.str_device_key);
        this.E0 = (TextView) inflate.findViewById(R.id.str_mac_address);
        this.f5640y0 = (Button) inflate.findViewById(R.id.btn_reload);
        this.f5639x0 = (Button) inflate.findViewById(R.id.btn_cancel);
        Button button = this.f5640y0;
        if (button != null) {
            button.setText(this.J0.getStr_continue());
        }
        Button button2 = this.f5639x0;
        if (button2 != null) {
            button2.setText(this.J0.getCancel());
        }
        TextView textView = this.D0;
        if (textView != null) {
            textView.setText(this.J0.getDevice_key());
        }
        TextView textView2 = this.E0;
        if (textView2 != null) {
            textView2.setText(this.J0.getMac_address());
        }
        if (this.H0 == -1 && this.f5640y0 != null) {
            if (app.shamel.tv.helper.a.l(E())) {
                this.f5640y0.setText(this.J0.getOk());
            } else {
                this.f5640y0.setText(this.J0.getOpen_website());
            }
        }
        TextView textView3 = this.A0;
        if (textView3 != null) {
            textView3.setText(this.F0);
        }
        TextView textView4 = this.f5641z0;
        if (textView4 != null) {
            textView4.setText(this.G0);
        }
        TextView textView5 = this.B0;
        if (textView5 != null) {
            textView5.setText(this.I0.r());
        }
        TextView textView6 = this.C0;
        if (textView6 != null) {
            app.shamel.tv.helper.r rVar = this.I0;
            rVar.getClass();
            String str = _UrlKt.FRAGMENT_ENCODE_SET;
            try {
                str = rVar.f2098b.getString("device_key", _UrlKt.FRAGMENT_ENCODE_SET);
            } catch (Exception unused) {
            }
            textView6.setText(str);
        }
        Button button3 = this.f5640y0;
        if (button3 != null) {
            final int i10 = 0;
            button3.setOnClickListener(new View.OnClickListener(this) { // from class: h5.o

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ p f5636p;

                {
                    this.f5636p = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11 = i10;
                    p pVar = this.f5636p;
                    switch (i11) {
                        case 0:
                            app.shamel.tv.b bVar = pVar.K0;
                            if (bVar != null) {
                                MainActivity mainActivity = (MainActivity) bVar.f2096q;
                                if (bVar.f2095p == -1) {
                                    int i12 = MainActivity.f1561l0;
                                    if (app.shamel.tv.helper.a.l(mainActivity)) {
                                        mainActivity.R();
                                    } else {
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://shamel.tv/manage-playlists/login/"));
                                            intent.addFlags(335544320);
                                            mainActivity.startActivity(intent);
                                        } catch (Exception e7) {
                                            Log.e("MainActivity", "Error occurred", e7);
                                        }
                                    }
                                } else {
                                    int i13 = MainActivity.f1561l0;
                                    mainActivity.U();
                                }
                            }
                            pVar.J(false, false);
                            break;
                        default:
                            app.shamel.tv.b bVar2 = pVar.K0;
                            if (bVar2 != null) {
                                MainActivity mainActivity2 = (MainActivity) bVar2.f2096q;
                                int i14 = MainActivity.f1561l0;
                                mainActivity2.R();
                            }
                            pVar.J(false, false);
                            break;
                    }
                }
            });
        }
        Button button4 = this.f5639x0;
        if (button4 != null) {
            final int i11 = 1;
            button4.setOnClickListener(new View.OnClickListener(this) { // from class: h5.o

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ p f5636p;

                {
                    this.f5636p = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i112 = i11;
                    p pVar = this.f5636p;
                    switch (i112) {
                        case 0:
                            app.shamel.tv.b bVar = pVar.K0;
                            if (bVar != null) {
                                MainActivity mainActivity = (MainActivity) bVar.f2096q;
                                if (bVar.f2095p == -1) {
                                    int i12 = MainActivity.f1561l0;
                                    if (app.shamel.tv.helper.a.l(mainActivity)) {
                                        mainActivity.R();
                                    } else {
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://shamel.tv/manage-playlists/login/"));
                                            intent.addFlags(335544320);
                                            mainActivity.startActivity(intent);
                                        } catch (Exception e7) {
                                            Log.e("MainActivity", "Error occurred", e7);
                                        }
                                    }
                                } else {
                                    int i13 = MainActivity.f1561l0;
                                    mainActivity.U();
                                }
                            }
                            pVar.J(false, false);
                            break;
                        default:
                            app.shamel.tv.b bVar2 = pVar.K0;
                            if (bVar2 != null) {
                                MainActivity mainActivity2 = (MainActivity) bVar2.f2096q;
                                int i14 = MainActivity.f1561l0;
                                mainActivity2.R();
                            }
                            pVar.J(false, false);
                            break;
                    }
                }
            });
        }
        Button button5 = this.f5640y0;
        if (button5 != null) {
            button5.requestFocus();
        }
        return inflate;
    }
}
