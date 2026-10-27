package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f extends androidx.fragment.app.o implements View.OnClickListener {
    public d5.g A0;
    public LiveVerticalGridView B0;
    public boolean[] C0;
    public io.realm.n0 D0;
    public ImageView E0;
    public String F0;
    public app.shamel.tv.activities.d G0;
    public LinearLayout H0;
    public LinearLayout I0;
    public LinearLayout J0;
    public d5.c0 K0;
    public LiveVerticalGridView L0;
    public app.shamel.tv.helper.r M0;
    public TextView N0;
    public TextView O0;
    public TextView P0;
    public TextView Q0;
    public TextView R0;
    public TextView S0;
    public TextView T0;
    public TextView U0;
    public WordModels V0;
    public List W0 = new ArrayList();
    public int X0 = 0;
    public boolean Y0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public ImageButton f5594x0;

    /* renamed from: y0, reason: collision with root package name */
    public ArrayList f5595y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f5596z0;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back || id == R.id.ly_complete) {
            this.G0.a(this.W0);
            J(false, false);
            return;
        }
        if (id == R.id.ly_category) {
            androidx.fragment.app.i0 h10 = h();
            h10.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(h10);
            androidx.fragment.app.s A = h10.A("fragment_my_group");
            if (A != null) {
                aVar.h(A);
                aVar.c();
                return;
            }
            ArrayList arrayList = this.f5595y0;
            int i10 = this.X0;
            x xVar = new x();
            xVar.f5676y0 = arrayList;
            xVar.A0 = i10;
            xVar.B0 = new d(this);
            xVar.M(h10, "fragment_my_group");
            return;
        }
        if (id == R.id.ly_search) {
            androidx.fragment.app.i0 h11 = h();
            h11.getClass();
            androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(h11);
            androidx.fragment.app.s A2 = h11.A("fragment_search_channel");
            if (A2 != null) {
                aVar2.h(A2);
                aVar2.c();
                return;
            }
            ArrayList arrayList2 = this.f5595y0;
            List list = this.W0;
            int i11 = this.X0;
            s0 s0Var = new s0();
            s0Var.f5657z0 = arrayList2;
            s0Var.P0 = list;
            s0Var.A0 = i11;
            s0Var.E0 = new d(this);
            s0Var.M(h11, "fragment_search_channel");
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_channel, viewGroup);
        this.M0 = new app.shamel.tv.helper.r(i());
        this.V0 = app.shamel.tv.helper.a.k(i());
        this.H0 = (LinearLayout) inflate.findViewById(R.id.ly_category);
        this.J0 = (LinearLayout) inflate.findViewById(R.id.ly_search);
        this.I0 = (LinearLayout) inflate.findViewById(R.id.ly_complete);
        this.f5594x0 = (ImageButton) inflate.findViewById(R.id.btn_back);
        this.H0.setOnClickListener(this);
        this.J0.setOnClickListener(this);
        this.I0.setOnClickListener(this);
        this.f5594x0.setOnClickListener(this);
        this.R0 = (TextView) inflate.findViewById(R.id.txt_category);
        this.S0 = (TextView) inflate.findViewById(R.id.txt_category_name);
        this.T0 = (TextView) inflate.findViewById(R.id.txt_count);
        this.U0 = (TextView) inflate.findViewById(R.id.txt_my_category);
        this.Q0 = (TextView) inflate.findViewById(R.id.str_search);
        this.P0 = (TextView) inflate.findViewById(R.id.str_complete);
        this.N0 = (TextView) inflate.findViewById(R.id.txt_add);
        this.B0 = (LiveVerticalGridView) inflate.findViewById(R.id.channel_list);
        this.L0 = (LiveVerticalGridView) inflate.findViewById(R.id.my_channel_list);
        this.O0 = (TextView) inflate.findViewById(R.id.str_check);
        this.E0 = (ImageView) inflate.findViewById(R.id.image_add);
        this.Q0.setText(this.V0.getStr_search_channels());
        this.P0.setText(this.V0.getStr_complete());
        this.N0.setText(this.V0.getStr_add_channels());
        this.O0.setText(this.V0.getStr_mark_channels());
        this.Y0 = this.M0.g();
        this.f5595y0 = new ArrayList();
        for (int size = this.M0.s().size() + 5; size < this.M0.a().size(); size++) {
            CategoryModel categoryModel = (CategoryModel) this.M0.a().get(size);
            if (!e5.l.f4606a.contains(categoryModel.getId())) {
                this.f5595y0.add(categoryModel);
            }
        }
        final int i10 = 0;
        this.R0.setText(((CategoryModel) this.f5595y0.get(0)).getName());
        this.S0.setText(((CategoryModel) this.f5595y0.get(0)).getName());
        this.D0 = a6.n.K().w((CategoryModel) this.f5595y0.get(0), _UrlKt.FRAGMENT_ENCODE_SET, this.Y0, 0);
        final int i11 = 1;
        if (this.f5596z0 == 1) {
            this.W0 = this.M0.m();
            this.U0.setText(this.V0.getFavorite());
        } else {
            this.W0 = this.M0.t(this.F0);
            this.U0.setText(this.F0);
        }
        this.T0.setText(this.W0.size() + "/300");
        if (this.W0.size() > 0) {
            this.L0.setVisibility(0);
            this.O0.setVisibility(8);
            this.E0.setVisibility(8);
        } else {
            this.L0.setVisibility(8);
            this.O0.setVisibility(0);
            this.E0.setVisibility(0);
        }
        this.C0 = new boolean[this.D0.size()];
        for (int i12 = 0; i12 < this.D0.size(); i12++) {
            this.C0[i12] = !this.W0.contains(((EPGChannel) this.D0.get(i12)).getName());
        }
        d5.g gVar = new d5.g(i(), this.D0, this.C0, new ya.q(this) { // from class: h5.c

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ f f5585p;

            {
                this.f5585p = this;
            }

            @Override // ya.q
            public final Object c(Object obj, Serializable serializable, Serializable serializable2) {
                switch (i10) {
                    case 0:
                        EPGChannel ePGChannel = (EPGChannel) obj;
                        boolean booleanValue = ((Boolean) serializable2).booleanValue();
                        f fVar = this.f5585p;
                        if (booleanValue) {
                            if (fVar.W0.contains(ePGChannel.getName())) {
                                fVar.W0.removeAll(Collections.singletonList(ePGChannel.getName()));
                            }
                        } else if (!fVar.W0.contains(ePGChannel.getName())) {
                            fVar.W0.add(ePGChannel.getName());
                        }
                        if (fVar.W0.size() > 0) {
                            fVar.L0.setVisibility(0);
                            fVar.O0.setVisibility(8);
                            fVar.E0.setVisibility(8);
                        } else {
                            fVar.L0.setVisibility(8);
                            fVar.O0.setVisibility(0);
                            fVar.E0.setVisibility(0);
                        }
                        fVar.K0.m(fVar.W0);
                        fVar.T0.setText(fVar.W0.size() + "/300");
                        break;
                    default:
                        String str = (String) obj;
                        if (!((Boolean) serializable2).booleanValue()) {
                            f fVar2 = this.f5585p;
                            fVar2.W0.remove(str);
                            fVar2.K0.m(fVar2.W0);
                            fVar2.T0.setText(fVar2.W0.size() + "/300");
                            fVar2.M0.V(fVar2.F0, fVar2.W0);
                            fVar2.C0 = new boolean[fVar2.D0.size()];
                            for (int i13 = 0; i13 < fVar2.D0.size(); i13++) {
                                fVar2.C0[i13] = !fVar2.W0.contains(((EPGChannel) fVar2.D0.get(i13)).getName());
                            }
                            fVar2.A0.m(fVar2.D0, fVar2.C0);
                            break;
                        }
                        break;
                }
                return null;
            }
        });
        this.A0 = gVar;
        this.B0.setAdapter(gVar);
        if (app.shamel.tv.helper.a.l(i())) {
            this.B0.setSelectedPosition(0);
            this.B0.setNumColumns(1);
            this.B0.setPreserveFocusAfterLayout(true);
            this.B0.setOnChildViewHolderSelectedListener(new app.shamel.tv.activities.e(22, new View[]{null}));
        } else {
            this.B0.setLayoutManager(new LinearLayoutManager(1));
        }
        d5.c0 c0Var = new d5.c0(i(), this.W0, false, new ya.q(this) { // from class: h5.c

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ f f5585p;

            {
                this.f5585p = this;
            }

            @Override // ya.q
            public final Object c(Object obj, Serializable serializable, Serializable serializable2) {
                switch (i11) {
                    case 0:
                        EPGChannel ePGChannel = (EPGChannel) obj;
                        boolean booleanValue = ((Boolean) serializable2).booleanValue();
                        f fVar = this.f5585p;
                        if (booleanValue) {
                            if (fVar.W0.contains(ePGChannel.getName())) {
                                fVar.W0.removeAll(Collections.singletonList(ePGChannel.getName()));
                            }
                        } else if (!fVar.W0.contains(ePGChannel.getName())) {
                            fVar.W0.add(ePGChannel.getName());
                        }
                        if (fVar.W0.size() > 0) {
                            fVar.L0.setVisibility(0);
                            fVar.O0.setVisibility(8);
                            fVar.E0.setVisibility(8);
                        } else {
                            fVar.L0.setVisibility(8);
                            fVar.O0.setVisibility(0);
                            fVar.E0.setVisibility(0);
                        }
                        fVar.K0.m(fVar.W0);
                        fVar.T0.setText(fVar.W0.size() + "/300");
                        break;
                    default:
                        String str = (String) obj;
                        if (!((Boolean) serializable2).booleanValue()) {
                            f fVar2 = this.f5585p;
                            fVar2.W0.remove(str);
                            fVar2.K0.m(fVar2.W0);
                            fVar2.T0.setText(fVar2.W0.size() + "/300");
                            fVar2.M0.V(fVar2.F0, fVar2.W0);
                            fVar2.C0 = new boolean[fVar2.D0.size()];
                            for (int i13 = 0; i13 < fVar2.D0.size(); i13++) {
                                fVar2.C0[i13] = !fVar2.W0.contains(((EPGChannel) fVar2.D0.get(i13)).getName());
                            }
                            fVar2.A0.m(fVar2.D0, fVar2.C0);
                            break;
                        }
                        break;
                }
                return null;
            }
        });
        this.K0 = c0Var;
        this.L0.setAdapter(c0Var);
        if (app.shamel.tv.helper.a.l(i())) {
            this.L0.setNumColumns(1);
            this.L0.setLoop(false);
            this.L0.setPreserveFocusAfterLayout(true);
            this.L0.setOnChildViewHolderSelectedListener(new app.shamel.tv.activities.e(23, new View[]{null}));
        } else {
            this.L0.setLayoutManager(new LinearLayoutManager(1));
        }
        this.f762s0.setOnKeyListener(new e(this, 0));
        this.H0.requestFocus();
        return inflate;
    }
}
