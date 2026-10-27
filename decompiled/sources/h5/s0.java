package h5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import com.google.gson.Gson;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class s0 extends androidx.fragment.app.o implements View.OnClickListener {
    public int A0;
    public LiveVerticalGridView B0;
    public boolean[] C0;
    public EditText D0;
    public d E0;
    public LinearLayout F0;
    public LinearLayout G0;
    public LinearLayout H0;
    public androidx.activity.j I0;
    public TextView J0;
    public TextView K0;
    public TextView L0;
    public TextView M0;
    public WordModels N0;
    public AbstractList O0 = new ArrayList();
    public List P0 = new ArrayList();
    public final Handler Q0 = new Handler(Looper.getMainLooper());
    public boolean R0 = false;
    public int S0 = 2;

    /* renamed from: x0, reason: collision with root package name */
    public d5.g f5655x0;

    /* renamed from: y0, reason: collision with root package name */
    public ImageButton f5656y0;

    /* renamed from: z0, reason: collision with root package name */
    public ArrayList f5657z0;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back || id == R.id.ly_complete) {
            d dVar = this.E0;
            List list = this.P0;
            f fVar = dVar.f5589a;
            fVar.W0 = list;
            fVar.T0.setText(fVar.W0.size() + "/300");
            fVar.K0.m(fVar.W0);
            fVar.M0.V(fVar.F0, fVar.W0);
            fVar.C0 = new boolean[fVar.D0.size()];
            for (int i10 = 0; i10 < fVar.D0.size(); i10++) {
                fVar.C0[i10] = !fVar.W0.contains(((EPGChannel) fVar.D0.get(i10)).getName());
            }
            fVar.A0.m(fVar.D0, fVar.C0);
            J(false, false);
            return;
        }
        if (id != R.id.ly_all) {
            if (id != R.id.ly_clear || this.O0.size() <= 0) {
                return;
            }
            for (int i11 = 0; i11 < this.O0.size(); i11++) {
                this.C0[i11] = true;
                this.P0.remove(((EPGChannel) this.O0.get(i11)).getName());
            }
            this.f5655x0.m(this.O0, this.C0);
            return;
        }
        if (this.O0.size() > 0) {
            for (int i12 = 0; i12 < this.O0.size(); i12++) {
                this.C0[i12] = false;
                if (!this.P0.contains(((EPGChannel) this.O0.get(i12)).getName())) {
                    this.P0.add(((EPGChannel) this.O0.get(i12)).getName());
                }
            }
            this.f5655x0.m(this.O0, this.C0);
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        boolean z10;
        View inflate = layoutInflater.inflate(R.layout.fragment_search_channel, viewGroup, false);
        this.N0 = app.shamel.tv.helper.a.k(i());
        Context i10 = i();
        new Gson();
        try {
            z10 = i10.getSharedPreferences("PREF", 0).getBoolean("is_m3u", false);
        } catch (Exception unused) {
            z10 = false;
        }
        this.R0 = z10;
        this.F0 = (LinearLayout) inflate.findViewById(R.id.ly_all);
        this.G0 = (LinearLayout) inflate.findViewById(R.id.ly_clear);
        this.H0 = (LinearLayout) inflate.findViewById(R.id.ly_complete);
        this.f5656y0 = (ImageButton) inflate.findViewById(R.id.btn_back);
        this.F0.setOnClickListener(this);
        this.G0.setOnClickListener(this);
        this.H0.setOnClickListener(this);
        this.f5656y0.setOnClickListener(this);
        this.D0 = (EditText) inflate.findViewById(R.id.et_search);
        this.B0 = (LiveVerticalGridView) inflate.findViewById(R.id.channel_list);
        this.L0 = (TextView) inflate.findViewById(R.id.txt_add);
        this.M0 = (TextView) inflate.findViewById(R.id.txt_category);
        this.J0 = (TextView) inflate.findViewById(R.id.str_clear);
        this.K0 = (TextView) inflate.findViewById(R.id.str_complete);
        this.L0.setText(this.N0.getSearch());
        this.M0.setText(this.N0.getSelect_all());
        this.J0.setText(this.N0.getClear_all());
        this.K0.setText(this.N0.getStr_confirm());
        this.C0 = new boolean[0];
        d5.g gVar = new d5.g(i(), new ArrayList(), this.C0, new app.shamel.tv.activities.f(10, this));
        this.f5655x0 = gVar;
        this.B0.setAdapter(gVar);
        if (app.shamel.tv.helper.a.l(i())) {
            this.B0.setSelectedPosition(0);
            this.B0.setNumColumns(1);
            this.B0.setPreserveFocusAfterLayout(true);
            this.B0.setOnChildViewHolderSelectedListener(new app.shamel.tv.activities.e(26, new View[]{null}));
        } else {
            this.B0.setLayoutManager(new LinearLayoutManager(1));
        }
        this.D0.addTextChangedListener(new app.shamel.tv.activities.l(11, this));
        this.D0.requestFocus();
        this.f762s0.setOnKeyListener(new e(this, 9));
        return inflate;
    }
}
