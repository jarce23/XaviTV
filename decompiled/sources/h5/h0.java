package h5;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class h0 extends androidx.fragment.app.o {
    public String A0;

    /* renamed from: x0, reason: collision with root package name */
    public Button f5605x0;

    /* renamed from: y0, reason: collision with root package name */
    public EditText f5606y0;

    /* renamed from: z0, reason: collision with root package name */
    public g0 f5607z0;

    public static h0 N(String str) {
        h0 h0Var = new h0();
        h0Var.A0 = str;
        return h0Var;
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_lock, viewGroup, false);
        this.f5606y0 = (EditText) inflate.findViewById(R.id.et_pass);
        this.f5605x0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5606y0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.f5605x0.setOnClickListener(new androidx.leanback.widget.g0(11, this));
        return inflate;
    }
}
