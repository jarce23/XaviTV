package h5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.models.WordModels;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class a0 extends androidx.fragment.app.o {
    public Context A0;
    public List B0;
    public a7.g C0;
    public RecyclerView D0;
    public TextView E0;
    public WordModels F0 = new WordModels();
    public int G0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public d5.y f5578x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5579y0;

    /* renamed from: z0, reason: collision with root package name */
    public Button f5580z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_language, viewGroup, false);
        this.F0 = app.shamel.tv.helper.a.k(this.A0);
        this.f5580z0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5579y0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.E0 = (TextView) inflate.findViewById(R.id.txt_header);
        this.D0 = (RecyclerView) inflate.findViewById(R.id.recyclerGroups);
        this.f5580z0.setText(this.F0.getOk());
        this.f5579y0.setText(this.F0.getCancel());
        this.E0.setText(this.F0.getChange_language());
        List list = this.B0;
        int i10 = this.G0;
        l lVar = new l(this, 4);
        d5.y yVar = new d5.y(0);
        yVar.f4222e = list;
        yVar.f4223f = i10;
        yVar.g = lVar;
        this.f5578x0 = yVar;
        this.D0.setLayoutManager(new LinearLayoutManager(1));
        this.D0.setHasFixedSize(true);
        this.D0.setAdapter(this.f5578x0);
        this.D0.e0(this.G0);
        this.D0.requestFocus();
        this.f5580z0.setOnClickListener(new z(this, 0));
        this.f5579y0.setOnClickListener(new z(this, 1));
        this.f762s0.setOnKeyListener(new e(this, 5));
        return inflate;
    }
}
