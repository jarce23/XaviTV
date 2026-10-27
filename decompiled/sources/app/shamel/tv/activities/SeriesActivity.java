package app.shamel.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.CustomSpinner;
import app.shamel.tv.view.LiveVerticalGridView;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SeriesActivity extends f.j implements View.OnClickListener {

    /* renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f1795k0 = 0;
    public c2.y0 M;
    public ArrayList N;
    public EditText O;
    public LinearLayout P;
    public LinearLayout Q;
    public app.shamel.tv.helper.r R;
    public LiveVerticalGridView S;
    public LiveVerticalGridView T;
    public d5.x0 U;
    public io.realm.n0 V;
    public CustomSpinner W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f1796a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f1797b0;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f1798c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f1799d0;

    /* renamed from: e0, reason: collision with root package name */
    public WordModels f1800e0;

    /* renamed from: f0, reason: collision with root package name */
    public ArrayList f1801f0 = new ArrayList();

    /* renamed from: g0, reason: collision with root package name */
    public int f1802g0 = 0;
    public int h0 = 0;

    /* renamed from: i0, reason: collision with root package name */
    public int f1803i0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    public int f1804j0 = 0;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        if (r3.O.hasFocus() == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        if (r3.P.hasFocus() == false) goto L111;
     */
    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r4) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.SeriesActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ly_back || id == R.id.txt_home) {
            finish();
            return;
        }
        if (id == R.id.ly_search) {
            Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
            intent.putExtra("is_live", false);
            startActivity(intent);
        } else {
            if (id == R.id.txt_live) {
                if (app.shamel.tv.helper.a.l(this)) {
                    startActivity(new Intent(this, (Class<?>) LiveActivity.class));
                } else {
                    startActivity(new Intent(this, (Class<?>) LiveMobileActivity.class));
                }
                finish();
                return;
            }
            if (id == R.id.txt_movie) {
                startActivity(new Intent(this, (Class<?>) MovieActivity.class));
                finish();
            }
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i10;
        super.onCreate(bundle);
        setContentView(R.layout.activity_series);
        this.M = new c2.y0(this);
        k5.j.a(this);
        this.R = new app.shamel.tv.helper.r(this);
        this.f1800e0 = app.shamel.tv.helper.a.k(this);
        this.P = (LinearLayout) findViewById(R.id.ly_back);
        this.Q = (LinearLayout) findViewById(R.id.ly_search);
        this.Z = (TextView) findViewById(R.id.txt_home);
        this.f1796a0 = (TextView) findViewById(R.id.txt_live);
        this.f1797b0 = (TextView) findViewById(R.id.txt_movie);
        this.f1799d0 = (TextView) findViewById(R.id.txt_series);
        this.Y = (TextView) findViewById(R.id.txt_category);
        this.f1798c0 = (TextView) findViewById(R.id.txt_search);
        this.X = (TextView) findViewById(R.id.txt_back);
        this.O = (EditText) findViewById(R.id.et_search);
        this.T = (LiveVerticalGridView) findViewById(R.id.recycler_series);
        this.S = (LiveVerticalGridView) findViewById(R.id.recycler_category);
        this.W = (CustomSpinner) findViewById(R.id.sort_spinner);
        if (app.shamel.tv.helper.a.l(this)) {
            this.S.setNumColumns(1);
            this.S.setLoop(false);
            this.S.setPreserveFocusAfterLayout(true);
            this.S.setOnChildViewHolderSelectedListener(new e(19, new View[]{null}));
        } else {
            this.S.setLayoutManager(new LinearLayoutManager(1));
            this.S.setHasFixedSize(true);
        }
        if (app.shamel.tv.helper.a.l(this)) {
            this.T.setNumColumns(5);
            this.T.setLoop(false);
            this.T.setPreserveFocusAfterLayout(true);
            this.T.setOnChildViewHolderSelectedListener(new e(20, new View[]{null}));
        } else {
            this.T.setLayoutManager(new GridLayoutManager(5));
            this.T.setHasFixedSize(true);
        }
        this.Z.setText(this.f1800e0.getHome());
        this.f1798c0.setText(this.f1800e0.getSearch());
        this.X.setText(this.f1800e0.getBack());
        this.f1796a0.setText(this.f1800e0.getLive_tv());
        this.f1797b0.setText(this.f1800e0.getMovies());
        this.f1799d0.setText(this.f1800e0.getSeries());
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f1796a0.setOnClickListener(this);
        this.f1797b0.setOnClickListener(this);
        this.f1801f0 = app.shamel.tv.helper.a.j(this.f1800e0);
        e5.l.b(this.R.i(), this);
        ArrayList arrayList = LTVApp.f2088w;
        this.N = arrayList;
        if (arrayList != null && !arrayList.isEmpty()) {
            i10 = 0;
            while (i10 < this.N.size()) {
                if (!a6.n.K().D((CategoryModel) this.N.get(i10), _UrlKt.FRAGMENT_ENCODE_SET, this.R.g(), 0).isEmpty()) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        i10 = 0;
        this.f1802g0 = i10;
        this.h0 = this.R.f2098b.getInt("series_order", 1);
        this.V = a6.n.K().D((CategoryModel) this.N.get(this.f1802g0), _UrlKt.FRAGMENT_ENCODE_SET, this.R.g(), this.h0);
        this.Y.setText(((CategoryModel) this.N.get(this.f1802g0)).getName() + "(" + this.V.size() + ")");
        this.S.setAdapter(new d5.t0(this, this.N, this.f1802g0, false, this.R.g(), false, new b(this, 3)));
        this.S.setSelectedPosition(this.f1802g0);
        d5.x0 x0Var = new d5.x0(this, this.V, false, 0);
        this.U = x0Var;
        x0Var.f4220k = new a6.n(11, this);
        this.T.setAdapter(x0Var);
        this.W.setAdapter((SpinnerAdapter) new d5.z0(this, this.f1801f0));
        this.W.setSelection(this.h0);
        this.W.setOnItemSelectedListener(new f0(2, this));
        this.O.addTextChangedListener(new l(6, this));
        if (app.shamel.tv.helper.a.l(this)) {
            u(false);
        }
        this.S.requestFocus();
        String str = e5.l.f4615k;
        String str2 = e5.l.f4616l;
        HashMap hashMap = new HashMap();
        hashMap.put("username", str);
        hashMap.put("password", str2);
        new JSONObject(hashMap);
    }

    @Override // f.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        c2.y0 y0Var = new c2.y0(this);
        this.M = y0Var;
        if (y0Var.g()) {
            this.M.i();
        }
    }

    public final void u(boolean z10) {
        this.Z.setFocusable(z10);
        this.f1796a0.setFocusable(z10);
        this.f1797b0.setFocusable(z10);
        this.f1799d0.setFocusable(z10);
        this.O.setFocusable(z10);
        this.P.setFocusable(z10);
        this.Q.setFocusable(z10);
    }
}
