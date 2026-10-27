package app.shamel.tv.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CategoryActivity extends f.j implements View.OnClickListener {
    public static final /* synthetic */ int Y = 0;
    public ArrayList M;
    public EditText N;
    public app.shamel.tv.helper.r O;
    public LiveVerticalGridView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public WordModels U = new WordModels();
    public int V = 0;
    public int W = 0;
    public final androidx.activity.result.c X = l(new androidx.fragment.app.e0(2), new k(this));

    public static boolean u(CategoryActivity categoryActivity, String str) {
        categoryActivity.getClass();
        return str.contains("xxx") || str.contains("porn") || str.contains("adult");
    }

    public static int v(CategoryActivity categoryActivity, CategoryModel categoryModel) {
        if (!categoryActivity.M.isEmpty()) {
            for (int i10 = 0; i10 < categoryActivity.M.size(); i10++) {
                if (categoryModel.getName().equalsIgnoreCase(((CategoryModel) categoryActivity.M.get(i10)).getName())) {
                    return i10;
                }
            }
        }
        return 0;
    }

    public static void w(CategoryActivity categoryActivity, CategoryModel categoryModel) {
        androidx.fragment.app.j0 n10 = categoryActivity.n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_lock");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return;
        }
        h5.h0 N = h5.h0.N(categoryActivity.O.u());
        N.f5607z0 = new x4.l(categoryActivity, categoryModel);
        N.M(n10, "fragment_lock");
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                finish();
            } else if (keyCode != 19) {
                if (keyCode == 20 && (this.Q.hasFocus() || this.R.hasFocus() || this.S.hasFocus() || this.T.hasFocus() || this.N.hasFocus())) {
                    y(false);
                    this.P.requestFocus();
                    return true;
                }
            } else {
                if (this.P.hasFocus() && this.W < 2) {
                    y(true);
                    this.R.requestFocus();
                    return true;
                }
                if (this.P.hasFocus() && this.W == 2) {
                    y(true);
                    this.N.requestFocus();
                    return true;
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_home) {
            finish();
            return;
        }
        if (id == R.id.txt_live) {
            LTVApp.f2090y = 1;
            z();
            this.N.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            x(0);
            return;
        }
        if (id == R.id.txt_movie) {
            LTVApp.f2090y = 2;
            z();
            this.N.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            x(0);
            return;
        }
        if (id == R.id.txt_series) {
            LTVApp.f2090y = 3;
            z();
            this.N.setText(_UrlKt.FRAGMENT_ENCODE_SET);
            x(0);
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_category);
        k5.j.a(this);
        this.O = new app.shamel.tv.helper.r(this);
        this.U = app.shamel.tv.helper.a.k(this);
        this.Q = (TextView) findViewById(R.id.txt_home);
        this.R = (TextView) findViewById(R.id.txt_live);
        this.S = (TextView) findViewById(R.id.txt_movie);
        this.T = (TextView) findViewById(R.id.txt_series);
        this.N = (EditText) findViewById(R.id.et_search);
        this.Q.setText(this.U.getHome());
        this.R.setText(this.U.getLive_tv());
        this.S.setText(this.U.getMovies());
        this.T.setText(this.U.getSeries());
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.P = (LiveVerticalGridView) findViewById(R.id.recycler_category);
        int i10 = 0;
        if (app.shamel.tv.helper.a.l(this)) {
            this.P.setNumColumns(3);
            this.P.setLoop(false);
            this.P.setPreserveFocusAfterLayout(true);
            this.P.setOnChildViewHolderSelectedListener(new e(4, new View[]{null}));
        } else {
            this.P.setLayoutManager(new GridLayoutManager(3));
            this.P.setHasFixedSize(true);
        }
        this.N.addTextChangedListener(new l(i10, this));
        if (app.shamel.tv.helper.a.l(this)) {
            y(false);
        }
        z();
        x(this.V);
    }

    public final void x(int i10) {
        int i11 = n.f2032a[s.e.b(LTVApp.f2090y)];
        if (i11 == 1) {
            e5.l.c(this.O.j(), this);
            ArrayList arrayList = LTVApp.f2086u;
            this.M = arrayList;
            this.P.setAdapter(new d5.t0(this, arrayList, i10, true, this.O.g(), true, new m(this, 3)));
            return;
        }
        if (i11 == 2) {
            e5.l.b(this.O.i(), this);
            ArrayList arrayList2 = LTVApp.f2088w;
            this.M = arrayList2;
            this.P.setAdapter(new d5.t0(this, arrayList2, i10, true, this.O.g(), false, new m(this, 4)));
            return;
        }
        e5.l.a(this, this.O.h());
        ArrayList arrayList3 = LTVApp.f2087v;
        this.M = arrayList3;
        this.P.setAdapter(new d5.n0(this, arrayList3, this.O.g(), true, i10, new m(this, 5)));
        this.P.setSelectedPosition(i10);
    }

    public final void y(boolean z10) {
        this.Q.setFocusable(z10);
        this.R.setFocusable(z10);
        this.S.setFocusable(z10);
        this.T.setFocusable(z10);
        this.N.setFocusable(z10);
    }

    public final void z() {
        int i10 = n.f2032a[s.e.b(LTVApp.f2090y)];
        if (i10 == 1) {
            this.R.setTextColor(getColor(R.color.white));
            this.S.setTextColor(getColor(R.color.yellow));
            this.T.setTextColor(getColor(R.color.white));
        } else if (i10 == 2) {
            this.R.setTextColor(getColor(R.color.white));
            this.S.setTextColor(getColor(R.color.white));
            this.T.setTextColor(getColor(R.color.yellow));
        } else {
            if (i10 != 3) {
                return;
            }
            this.R.setTextColor(getColor(R.color.yellow));
            this.S.setTextColor(getColor(R.color.white));
            this.T.setTextColor(getColor(R.color.white));
        }
    }
}
