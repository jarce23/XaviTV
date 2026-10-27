package app.shamel.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.CustomSpinner;
import app.shamel.tv.view.LiveVerticalGridView;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieSecondActivity extends f.j implements View.OnClickListener {

    /* renamed from: e0, reason: collision with root package name */
    public static final /* synthetic */ int f1779e0 = 0;
    public ArrayList M;
    public EditText N;
    public io.realm.n0 O;
    public app.shamel.tv.helper.r P;
    public LiveVerticalGridView Q;
    public CustomSpinner R;
    public TextView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public d5.x0 Y;
    public WordModels Z;

    /* renamed from: a0, reason: collision with root package name */
    public ArrayList f1780a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    public int f1781b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1782c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1783d0 = 0;

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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3.N.hasFocus() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        if (r3.R.hasFocus() == false) goto L44;
     */
    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            if (r0 != 0) goto L9f
            int r0 = r4.getKeyCode()
            r1 = 4
            if (r0 != r1) goto L12
            r3.finish()
            goto L9f
        L12:
            r1 = 89
            r2 = 12
            if (r0 == r1) goto L8b
            r1 = 90
            if (r0 == r1) goto L6c
            r1 = 1
            switch(r0) {
                case 19: goto L56;
                case 20: goto L44;
                case 21: goto L33;
                case 22: goto L22;
                default: goto L20;
            }
        L20:
            goto L9f
        L22:
            app.shamel.tv.view.CustomSpinner r0 = r3.R
            boolean r0 = r0.hasFocus()
            if (r0 != 0) goto L43
            android.widget.EditText r0 = r3.N
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            goto L43
        L33:
            android.widget.TextView r0 = r3.S
            boolean r0 = r0.hasFocus()
            if (r0 != 0) goto L43
            app.shamel.tv.view.CustomSpinner r0 = r3.R
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
        L43:
            return r1
        L44:
            app.shamel.tv.view.CustomSpinner r0 = r3.R
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            r4 = 0
            r3.v(r4)
            app.shamel.tv.view.LiveVerticalGridView r4 = r3.Q
            r4.requestFocus()
            return r1
        L56:
            app.shamel.tv.view.LiveVerticalGridView r0 = r3.Q
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            int r0 = r3.f1783d0
            r2 = 6
            if (r0 >= r2) goto L9f
            r3.v(r1)
            app.shamel.tv.view.CustomSpinner r4 = r3.R
            r4.requestFocus()
            return r1
        L6c:
            app.shamel.tv.view.LiveVerticalGridView r0 = r3.Q
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            int r0 = r3.f1783d0
            io.realm.n0 r1 = r3.O
            int r1 = r1.size()
            int r1 = r1 + (-13)
            if (r0 >= r1) goto L9f
            int r0 = r3.f1783d0
            int r0 = r0 + r2
            r3.f1783d0 = r0
            app.shamel.tv.view.LiveVerticalGridView r1 = r3.Q
            r1.setSelectedPosition(r0)
            goto L9f
        L8b:
            app.shamel.tv.view.LiveVerticalGridView r0 = r3.Q
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            int r0 = r3.f1783d0
            if (r0 <= r2) goto L9f
            int r0 = r0 - r2
            r3.f1783d0 = r0
            app.shamel.tv.view.LiveVerticalGridView r1 = r3.Q
            r1.setSelectedPosition(r0)
        L9f:
            boolean r4 = super.dispatchKeyEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.MovieSecondActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_back) {
            finish();
            return;
        }
        if (id == R.id.txt_home) {
            Intent intent = new Intent();
            intent.putExtra("is_changed", "home");
            setResult(-1, intent);
            finish();
            return;
        }
        if (id == R.id.txt_live) {
            Intent intent2 = new Intent();
            intent2.putExtra("is_changed", "live");
            setResult(-1, intent2);
            finish();
            return;
        }
        if (id == R.id.txt_movie) {
            finish();
        } else if (id == R.id.txt_series) {
            Intent intent3 = new Intent();
            intent3.putExtra("is_changed", "series");
            setResult(-1, intent3);
            finish();
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movie_second);
        k5.j.a(this);
        this.P = new app.shamel.tv.helper.r(this);
        this.Z = app.shamel.tv.helper.a.k(this);
        this.U = (TextView) findViewById(R.id.txt_home);
        this.V = (TextView) findViewById(R.id.txt_live);
        this.W = (TextView) findViewById(R.id.txt_movie);
        this.X = (TextView) findViewById(R.id.txt_series);
        this.S = (TextView) findViewById(R.id.txt_back);
        this.T = (TextView) findViewById(R.id.txt_category);
        this.N = (EditText) findViewById(R.id.et_search);
        this.Q = (LiveVerticalGridView) findViewById(R.id.recycler_movie);
        this.R = (CustomSpinner) findViewById(R.id.sort_spinner);
        int i10 = 1;
        if (app.shamel.tv.helper.a.l(this)) {
            this.Q.setNumColumns(6);
            this.Q.setLoop(false);
            this.Q.setPreserveFocusAfterLayout(true);
            this.Q.setOnChildViewHolderSelectedListener(new e(13, new View[]{null}));
        } else {
            this.Q.setLayoutManager(new GridLayoutManager(6));
            this.Q.setHasFixedSize(true);
        }
        this.U.setText(this.Z.getHome());
        this.V.setText(this.Z.getLive_tv());
        this.W.setText(this.Z.getMovies());
        this.X.setText(this.Z.getSeries());
        this.S.setText(this.Z.getBack());
        this.S.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.f1780a0 = app.shamel.tv.helper.a.j(this.Z);
        e5.l.c(this.P.j(), this);
        this.M = LTVApp.f2086u;
        this.f1781b0 = getIntent().getIntExtra("category_pos", 0);
        this.f1782c0 = this.P.f2098b.getInt("vod_order", 1);
        this.O = a6.n.K().A((CategoryModel) this.M.get(this.f1781b0), _UrlKt.FRAGMENT_ENCODE_SET, this.P.g(), this.f1782c0);
        this.T.setText(((CategoryModel) this.M.get(this.f1781b0)).getName() + "(" + this.O.size() + ")");
        d5.x0 x0Var = new d5.x0(this, this.O, true, 1);
        this.Y = x0Var;
        x0Var.f4220k = new a6.n(10, this);
        this.Q.setAdapter(x0Var);
        this.R.setAdapter((SpinnerAdapter) new d5.z0(this, this.f1780a0));
        this.R.setSelection(this.f1782c0);
        this.R.setOnItemSelectedListener(new f0(i10, this));
        this.N.addTextChangedListener(new l(4, this));
        if (app.shamel.tv.helper.a.l(this)) {
            v(false);
        }
    }

    public final void v(boolean z10) {
        this.U.setFocusable(z10);
        this.V.setFocusable(z10);
        this.W.setFocusable(z10);
        this.X.setFocusable(z10);
        this.N.setFocusable(z10);
        this.S.setFocusable(z10);
        this.R.setFocusable(z10);
    }

    public final void w(int i10) {
        f.f fVar = new f.f(this);
        fVar.setTitle(this.Z.getInstall_external_player());
        String want_external_player = this.Z.getWant_external_player();
        f.b bVar = fVar.f4778a;
        bVar.f4706f = want_external_player;
        bVar.f4710k = false;
        String ok = this.Z.getOk();
        e0 e0Var = new e0(this, i10, 2);
        bVar.g = ok;
        bVar.f4707h = e0Var;
        String cancel = this.Z.getCancel();
        d0 d0Var = new d0(2);
        bVar.f4708i = cancel;
        bVar.f4709j = d0Var;
        fVar.create().show();
    }
}
