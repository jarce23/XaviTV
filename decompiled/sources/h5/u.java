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
public class u extends androidx.fragment.app.o {
    public String A0;
    public t B0;
    public String C0;
    public String D0;
    public TextView E0;
    public TextView F0;

    /* renamed from: x0, reason: collision with root package name */
    public Button f5661x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5662y0;

    /* renamed from: z0, reason: collision with root package name */
    public String f5663z0;

    public static u N(String str, String str2, String str3, String str4) {
        u uVar = new u();
        uVar.A0 = str;
        uVar.f5663z0 = str2;
        uVar.D0 = str3;
        uVar.C0 = str4;
        return uVar;
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_exit, viewGroup, false);
        this.F0 = (TextView) inflate.findViewById(R.id.txt_quit);
        this.E0 = (TextView) inflate.findViewById(R.id.txt_description);
        this.F0.setText(this.A0);
        this.E0.setText(this.f5663z0);
        this.f5662y0 = (Button) inflate.findViewById(R.id.btn_ok);
        Button button = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f5661x0 = button;
        button.setOnClickListener(new s(this, 0));
        this.f5662y0.setOnClickListener(new s(this, 1));
        this.f5662y0.setText(this.D0);
        this.f5661x0.setText(this.C0);
        this.f762s0.setOnKeyListener(new e(this, 3));
        this.f5661x0.requestFocus();
        return inflate;
    }
}
