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
public class MovieActivity extends f.j implements View.OnClickListener {

    /* renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f1722k0 = 0;
    public c2.y0 M;
    public ArrayList N;
    public EditText O;
    public LinearLayout P;
    public LinearLayout Q;
    public io.realm.n0 R;
    public app.shamel.tv.helper.r S;
    public LiveVerticalGridView T;
    public LiveVerticalGridView U;
    public CustomSpinner V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f1723a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f1724b0;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f1725c0;

    /* renamed from: d0, reason: collision with root package name */
    public d5.x0 f1726d0;

    /* renamed from: e0, reason: collision with root package name */
    public WordModels f1727e0;

    /* renamed from: f0, reason: collision with root package name */
    public ArrayList f1728f0 = new ArrayList();

    /* renamed from: g0, reason: collision with root package name */
    public int f1729g0 = 0;
    public int h0 = 0;

    /* renamed from: i0, reason: collision with root package name */
    public int f1730i0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    public int f1731j0 = 0;

    public static String u(String str) {
        ArrayList arrayList = LTVApp.f2086u;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            CategoryModel categoryModel = (CategoryModel) obj;
            if (str.equalsIgnoreCase(categoryModel.getId())) {
                return categoryModel.getName();
            }
        }
        return "UnNamed Category";
    }

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
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.MovieActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
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
            if (id == R.id.txt_series) {
                startActivity(new Intent(this, (Class<?>) SeriesActivity.class));
                finish();
            }
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movie);
        this.M = new c2.y0(this);
        k5.j.a(this);
        this.S = new app.shamel.tv.helper.r(this);
        this.f1727e0 = app.shamel.tv.helper.a.k(this);
        this.P = (LinearLayout) findViewById(R.id.ly_back);
        this.Q = (LinearLayout) findViewById(R.id.ly_search);
        this.Y = (TextView) findViewById(R.id.txt_home);
        this.Z = (TextView) findViewById(R.id.txt_live);
        this.f1723a0 = (TextView) findViewById(R.id.txt_movie);
        this.f1725c0 = (TextView) findViewById(R.id.txt_series);
        this.f1724b0 = (TextView) findViewById(R.id.txt_search);
        this.W = (TextView) findViewById(R.id.txt_back);
        this.X = (TextView) findViewById(R.id.txt_category);
        this.O = (EditText) findViewById(R.id.et_search);
        this.U = (LiveVerticalGridView) findViewById(R.id.recycler_movie);
        this.T = (LiveVerticalGridView) findViewById(R.id.recycler_category);
        this.V = (CustomSpinner) findViewById(R.id.sort_spinner);
        int i10 = 9;
        int i11 = 0;
        if (app.shamel.tv.helper.a.l(this)) {
            this.T.setNumColumns(1);
            this.T.setLoop(false);
            this.T.setPreserveFocusAfterLayout(true);
            this.T.setOnChildViewHolderSelectedListener(new e(i10, new View[]{null}));
        } else {
            this.T.setLayoutManager(new LinearLayoutManager(1));
            this.T.setHasFixedSize(true);
        }
        if (app.shamel.tv.helper.a.l(this)) {
            this.U.setNumColumns(5);
            this.U.setLoop(false);
            this.U.setPreserveFocusAfterLayout(true);
            this.U.setOnChildViewHolderSelectedListener(new e(10, new View[]{null}));
        } else {
            this.U.setLayoutManager(new GridLayoutManager(5));
            this.U.setHasFixedSize(true);
        }
        this.Y.setText(this.f1727e0.getHome());
        this.Z.setText(this.f1727e0.getLive_tv());
        this.f1723a0.setText(this.f1727e0.getMovies());
        this.f1725c0.setText(this.f1727e0.getSeries());
        this.W.setText(this.f1727e0.getBack());
        this.f1724b0.setText(this.f1727e0.getSearch());
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f1725c0.setOnClickListener(this);
        this.f1728f0 = app.shamel.tv.helper.a.j(this.f1727e0);
        e5.l.c(this.S.j(), this);
        ArrayList arrayList = LTVApp.f2086u;
        this.N = arrayList;
        int size = arrayList != null ? arrayList.size() : 0;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                i12 = 0;
                break;
            } else if (!a6.n.K().A((CategoryModel) this.N.get(i12), _UrlKt.FRAGMENT_ENCODE_SET, this.S.g(), 0).isEmpty()) {
                break;
            } else {
                i12++;
            }
        }
        this.f1729g0 = i12;
        this.h0 = this.S.f2098b.getInt("vod_order", 1);
        this.R = a6.n.K().A((CategoryModel) this.N.get(this.f1729g0), _UrlKt.FRAGMENT_ENCODE_SET, this.S.g(), this.h0);
        this.X.setText(((CategoryModel) this.N.get(this.f1729g0)).getName() + "(" + this.R.size() + ")");
        this.T.setAdapter(new d5.t0(this, this.N, this.f1729g0, false, this.S.g(), true, new f(2, this)));
        this.T.setSelectedPosition(this.f1729g0);
        d5.x0 x0Var = new d5.x0(this, this.R, false, 1);
        this.f1726d0 = x0Var;
        x0Var.f4220k = new a6.n(i10, this);
        this.U.setAdapter(x0Var);
        this.V.setAdapter((SpinnerAdapter) new d5.z0(this, this.f1728f0));
        this.V.setSelection(this.h0);
        this.V.setOnItemSelectedListener(new f0(i11, this));
        this.O.addTextChangedListener(new l(3, this));
        if (app.shamel.tv.helper.a.l(this)) {
            v(false);
        }
        this.T.requestFocus();
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
        c2.y0 y0Var = this.M;
        if (y0Var == null || !y0Var.g()) {
            return;
        }
        this.M.i();
    }

    public final void v(boolean z10) {
        this.Y.setFocusable(z10);
        this.Z.setFocusable(z10);
        this.f1723a0.setFocusable(z10);
        this.f1725c0.setFocusable(z10);
        this.O.setFocusable(z10);
        this.P.setFocusable(z10);
        this.Q.setFocusable(z10);
    }

    public final void w(int i10) {
        f.f fVar = new f.f(this);
        fVar.setTitle(this.f1727e0.getInstall_external_player());
        String want_external_player = this.f1727e0.getWant_external_player();
        f.b bVar = fVar.f4778a;
        bVar.f4706f = want_external_player;
        bVar.f4710k = false;
        String ok = this.f1727e0.getOk();
        e0 e0Var = new e0(this, i10, 0);
        bVar.g = ok;
        bVar.f4707h = e0Var;
        String cancel = this.f1727e0.getCancel();
        d0 d0Var = new d0(0);
        bVar.f4708i = cancel;
        bVar.f4709j = d0Var;
        fVar.create().show();
    }
}
