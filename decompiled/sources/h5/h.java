package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import app.shamel.tv.models.WordModels;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class h extends androidx.fragment.app.o {
    public String A0;
    public app.shamel.tv.helper.r B0;
    public TextView C0;
    public EditText D0;
    public TextView E0;
    public WordModels F0;
    public List G0 = new ArrayList();
    public boolean H0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public ImageButton f5602x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5603y0;

    /* renamed from: z0, reason: collision with root package name */
    public t1.e f5604z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_group, viewGroup);
        this.B0 = new app.shamel.tv.helper.r(i());
        this.F0 = app.shamel.tv.helper.a.k(i());
        this.f5602x0 = (ImageButton) inflate.findViewById(R.id.btn_back);
        this.C0 = (TextView) inflate.findViewById(R.id.txt_add);
        this.E0 = (TextView) inflate.findViewById(R.id.txt_pick_name);
        this.D0 = (EditText) inflate.findViewById(R.id.txt_name);
        this.f5603y0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.C0.setText(this.F0.getStr_my_group());
        this.E0.setText(this.F0.getStr_group_name());
        this.f5603y0.setText(this.F0.getOk());
        if (this.H0) {
            this.D0.setText(this.A0);
        }
        this.G0 = this.B0.s();
        this.f5603y0.setOnClickListener(new g(this, 0));
        this.f5602x0.setOnClickListener(new g(this, 1));
        this.D0.requestFocus();
        return inflate;
    }
}
