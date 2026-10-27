package h5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.activities.SettingActivity;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.WordModels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class y extends androidx.fragment.app.o implements View.OnClickListener {
    public Button A0;
    public ArrayList B0;
    public String[] C0;
    public String[] D0;
    public boolean[] E0;
    public SettingActivity F0;
    public int G0;
    public a6.a0 H0;
    public RecyclerView I0;
    public app.shamel.tv.helper.r J0;
    public TextView K0;
    public List L0 = new ArrayList();
    public WordModels M0 = new WordModels();
    public int N0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public d5.k f5678x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5679y0;

    /* renamed from: z0, reason: collision with root package name */
    public Button f5680z0;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_all) {
            if (this.L0.size() < this.C0.length) {
                this.f5678x0.l(true);
                this.L0.addAll(Arrays.asList(this.C0));
                return;
            } else {
                this.f5678x0.l(false);
                this.L0 = new ArrayList();
                return;
            }
        }
        if (id == R.id.btn_cancel) {
            J(false, false);
            return;
        }
        if (id != R.id.btn_ok) {
            return;
        }
        int i10 = this.G0;
        if (i10 == 0) {
            e5.l.a(this.F0, this.L0);
            app.shamel.tv.helper.r rVar = this.J0;
            List list = this.L0;
            SharedPreferences.Editor edit = rVar.f2098b.edit();
            edit.putString("invisible_live_categories" + rVar.H(), rVar.f2097a.toJson(list));
            edit.apply();
        } else if (i10 == 1) {
            e5.l.c(this.L0, this.F0);
            app.shamel.tv.helper.r rVar2 = this.J0;
            List list2 = this.L0;
            SharedPreferences.Editor edit2 = rVar2.f2098b.edit();
            edit2.putString("invisible_vod_categories" + rVar2.H(), rVar2.f2097a.toJson(list2));
            edit2.apply();
        } else if (i10 == 2) {
            e5.l.b(this.L0, this.F0);
            app.shamel.tv.helper.r rVar3 = this.J0;
            List list3 = this.L0;
            SharedPreferences.Editor edit3 = rVar3.f2098b.edit();
            edit3.putString("invisible_series_categories" + rVar3.H(), rVar3.f2097a.toJson(list3));
            edit3.apply();
        }
        this.H0.getClass();
        int i11 = SettingActivity.f1845u0;
        J(false, false);
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_hide_categories, viewGroup, false);
        this.K0 = (TextView) inflate.findViewById(R.id.txt_header);
        this.I0 = (RecyclerView) inflate.findViewById(R.id.recyclerGroups);
        this.A0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5680z0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f5679y0 = (Button) inflate.findViewById(R.id.btn_all);
        this.A0.setOnClickListener(this);
        this.f5680z0.setOnClickListener(this);
        this.f5679y0.setOnClickListener(this);
        this.J0 = new app.shamel.tv.helper.r(this.F0);
        WordModels k10 = app.shamel.tv.helper.a.k(this.F0);
        this.M0 = k10;
        this.K0.setText(k10.getSelect_categories_you_want_to_hide());
        this.A0.setText(this.M0.getOk());
        this.f5679y0.setText(this.M0.getSelect_all());
        this.f5680z0.setText(this.M0.getCancel());
        int i10 = this.G0;
        if (i10 == 0) {
            this.B0 = new ArrayList();
            this.N0 = this.J0.s().size() + 5;
            for (int i11 = 0; i11 < this.J0.a().size() - this.N0; i11++) {
                this.B0.add((CategoryModel) this.J0.a().get(this.N0 + i11));
            }
            this.L0 = this.J0.h();
        } else if (i10 == 1) {
            this.B0 = new ArrayList();
            this.N0 = 3;
            for (int i12 = 0; i12 < this.J0.J().size() - this.N0; i12++) {
                this.B0.add((CategoryModel) this.J0.J().get(this.N0 + i12));
            }
            this.L0 = this.J0.j();
        } else if (i10 == 2) {
            this.B0 = new ArrayList();
            this.N0 = 3;
            for (int i13 = 0; i13 < this.J0.y().size() - this.N0; i13++) {
                this.B0.add((CategoryModel) this.J0.y().get(this.N0 + i13));
            }
            this.L0 = this.J0.i();
        }
        this.D0 = new String[this.B0.size()];
        this.C0 = new String[this.B0.size()];
        this.E0 = new boolean[this.D0.length];
        for (int i14 = 0; i14 < this.B0.size(); i14++) {
            CategoryModel categoryModel = (CategoryModel) this.B0.get(i14);
            this.D0[i14] = categoryModel.getName();
            this.C0[i14] = categoryModel.getId();
            this.E0[i14] = this.L0.contains(categoryModel.getId());
        }
        this.f5678x0 = new d5.k(this.D0, this.E0, new l(this, 3));
        this.I0.setLayoutManager(new LinearLayoutManager(1));
        this.I0.setHasFixedSize(true);
        this.I0.setAdapter(this.f5678x0);
        this.f762s0.setOnKeyListener(new e(this, 4));
        return inflate;
    }
}
