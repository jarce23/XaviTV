package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class q0 extends androidx.fragment.app.o {
    public String A0;
    public boolean B0 = false;
    public p0 C0;
    public TextView D0;
    public TextView E0;

    /* renamed from: x0, reason: collision with root package name */
    public Button f5644x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5645y0;

    /* renamed from: z0, reason: collision with root package name */
    public String f5646z0;

    public static q0 N(String str, String str2, boolean z10) {
        q0 q0Var = new q0();
        q0Var.A0 = str;
        q0Var.f5646z0 = str2;
        q0Var.B0 = z10;
        return q0Var;
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_exit, viewGroup, false);
        this.E0 = (TextView) inflate.findViewById(R.id.txt_quit);
        this.D0 = (TextView) inflate.findViewById(R.id.txt_description);
        this.E0.setText(this.A0);
        this.D0.setText(this.f5646z0);
        this.f5645y0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5644x0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f5645y0.setText("Exit");
        this.f5644x0.setText("Play Next");
        this.E0.setAllCaps(true);
        if (this.B0) {
            this.f5644x0.setVisibility(8);
            this.f5645y0.requestFocus();
        } else {
            this.f5644x0.requestFocus();
        }
        this.f5644x0.setOnClickListener(new o0(this, 0));
        this.f5645y0.setOnClickListener(new o0(this, 1));
        return inflate;
    }
}
