package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class c0 extends androidx.fragment.app.o {
    public boolean A0;
    public b0 B0;
    public app.shamel.tv.helper.r C0;
    public LiveVerticalGridView D0;
    public io.realm.n0 E0;
    public int F0 = 0;
    public int G0 = -1;
    public WordModels H0 = new WordModels();

    /* renamed from: x0, reason: collision with root package name */
    public CategoryModel f5586x0;

    /* renamed from: y0, reason: collision with root package name */
    public f.j f5587y0;

    /* renamed from: z0, reason: collision with root package name */
    public EditText f5588z0;

    public static c0 N(f.j jVar, CategoryModel categoryModel, int i10, boolean z10) {
        c0 c0Var = new c0();
        c0Var.f5587y0 = jVar;
        c0Var.f5586x0 = categoryModel;
        c0Var.A0 = z10;
        c0Var.F0 = i10;
        return c0Var;
    }

    public final void O(String str) {
        int i10 = this.F0;
        if (i10 <= 4 || i10 >= this.C0.s().size() + 5) {
            this.E0 = a6.n.K().w(this.f5586x0, str, this.A0, 0);
        } else if (this.C0.s().size() > 0) {
            a6.n K = a6.n.K();
            app.shamel.tv.helper.r rVar = this.C0;
            this.E0 = K.s(str, rVar.t((String) rVar.s().get(this.F0 - 5)));
        }
        this.D0.setAdapter(new d5.e(this.f5587y0, this.E0, -1, new app.shamel.tv.activities.x(3, this)));
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
        this.C0 = new app.shamel.tv.helper.r(this.f5587y0);
        this.H0 = app.shamel.tv.helper.a.k(this.f5587y0);
        this.f5588z0 = (EditText) inflate.findViewById(R.id.et_search);
        this.D0 = (LiveVerticalGridView) inflate.findViewById(R.id.recycler_channels);
        if (app.shamel.tv.helper.a.l(this.f5587y0)) {
            this.D0.setNumColumns(1);
            this.D0.setLoop(false);
            this.D0.setPreserveFocusAfterLayout(true);
            this.D0.setOnChildViewHolderSelectedListener(new app.shamel.tv.activities.e(25, new View[]{null}));
        } else {
            this.D0.setLayoutManager(new LinearLayoutManager(1));
        }
        this.f5588z0.addTextChangedListener(new app.shamel.tv.activities.l(10, this));
        O(_UrlKt.FRAGMENT_ENCODE_SET);
        if (app.shamel.tv.helper.a.l(this.f5587y0)) {
            this.f5588z0.setFocusable(false);
        }
        this.D0.requestFocus();
        this.f762s0.setOnKeyListener(new e(this, 6));
        return inflate;
    }
}
