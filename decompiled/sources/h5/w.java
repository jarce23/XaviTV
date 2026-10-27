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
import app.shamel.tv.activities.y0;
import app.shamel.tv.models.WordModels;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class w extends androidx.fragment.app.o {
    public Context A0;
    public ArrayList B0;
    public String C0;
    public y0 D0;
    public RecyclerView E0;
    public TextView F0;
    public WordModels G0 = new WordModels();
    public int H0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public d5.y f5672x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5673y0;

    /* renamed from: z0, reason: collision with root package name */
    public Button f5674z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_external_player, viewGroup, false);
        this.G0 = app.shamel.tv.helper.a.k(this.A0);
        this.f5674z0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5673y0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.F0 = (TextView) inflate.findViewById(R.id.txt_header);
        this.E0 = (RecyclerView) inflate.findViewById(R.id.recyclerGroups);
        this.f5674z0.setText(this.G0.getOk());
        this.f5673y0.setText(this.G0.getCancel());
        this.F0.setText(this.C0);
        this.f5672x0 = new d5.y(this.B0, this.H0, new l(this, 2));
        this.E0.setLayoutManager(new LinearLayoutManager(1));
        this.E0.setAdapter(this.f5672x0);
        this.E0.h0(this.H0);
        this.E0.requestFocus();
        this.f5674z0.setOnClickListener(new v(this, 0));
        this.f5673y0.setOnClickListener(new v(this, 1));
        return inflate;
    }
}
