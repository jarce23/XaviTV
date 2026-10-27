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
public class SeriesSecondActivity extends f.j implements View.OnClickListener {
    public ArrayList M;
    public EditText N;
    public app.shamel.tv.helper.r O;
    public LiveVerticalGridView P;
    public d5.x0 Q;
    public io.realm.n0 R;
    public CustomSpinner S;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public WordModels Z;

    /* renamed from: a0, reason: collision with root package name */
    public ArrayList f1841a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    public int f1842b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1843c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1844d0 = 0;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3.N.hasFocus() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        if (r3.S.hasFocus() == false) goto L44;
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
            app.shamel.tv.view.CustomSpinner r0 = r3.S
            boolean r0 = r0.hasFocus()
            if (r0 != 0) goto L43
            android.widget.EditText r0 = r3.N
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            goto L43
        L33:
            android.widget.TextView r0 = r3.T
            boolean r0 = r0.hasFocus()
            if (r0 != 0) goto L43
            app.shamel.tv.view.CustomSpinner r0 = r3.S
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
        L43:
            return r1
        L44:
            app.shamel.tv.view.CustomSpinner r0 = r3.S
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            r4 = 0
            r3.u(r4)
            app.shamel.tv.view.LiveVerticalGridView r4 = r3.P
            r4.requestFocus()
            return r1
        L56:
            app.shamel.tv.view.LiveVerticalGridView r0 = r3.P
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            int r0 = r3.f1844d0
            r2 = 6
            if (r0 >= r2) goto L9f
            r3.u(r1)
            app.shamel.tv.view.CustomSpinner r4 = r3.S
            r4.requestFocus()
            return r1
        L6c:
            app.shamel.tv.view.LiveVerticalGridView r0 = r3.P
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            int r0 = r3.f1844d0
            io.realm.n0 r1 = r3.R
            int r1 = r1.size()
            int r1 = r1 + (-13)
            if (r0 >= r1) goto L9f
            int r0 = r3.f1844d0
            int r0 = r0 + r2
            r3.f1844d0 = r0
            app.shamel.tv.view.LiveVerticalGridView r1 = r3.P
            r1.setSelectedPosition(r0)
            goto L9f
        L8b:
            app.shamel.tv.view.LiveVerticalGridView r0 = r3.P
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L9f
            int r0 = r3.f1844d0
            if (r0 <= r2) goto L9f
            int r0 = r0 - r2
            r3.f1844d0 = r0
            app.shamel.tv.view.LiveVerticalGridView r1 = r3.P
            r1.setSelectedPosition(r0)
        L9f:
            boolean r4 = super.dispatchKeyEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.SeriesSecondActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_back || id == R.id.txt_series) {
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
            Intent intent3 = new Intent();
            intent3.putExtra("is_changed", "movie");
            setResult(-1, intent3);
            finish();
        }
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_series_second);
        k5.j.a(this);
        this.O = new app.shamel.tv.helper.r(this);
        this.Z = app.shamel.tv.helper.a.k(this);
        this.V = (TextView) findViewById(R.id.txt_home);
        this.W = (TextView) findViewById(R.id.txt_live);
        this.X = (TextView) findViewById(R.id.txt_movie);
        this.Y = (TextView) findViewById(R.id.txt_series);
        this.U = (TextView) findViewById(R.id.txt_category);
        this.T = (TextView) findViewById(R.id.txt_back);
        this.N = (EditText) findViewById(R.id.et_search);
        this.P = (LiveVerticalGridView) findViewById(R.id.recycler_series);
        this.S = (CustomSpinner) findViewById(R.id.sort_spinner);
        if (app.shamel.tv.helper.a.l(this)) {
            this.P.setNumColumns(6);
            this.P.setLoop(false);
            this.P.setPreserveFocusAfterLayout(true);
            this.P.setOnChildViewHolderSelectedListener(new e(21, new View[]{null}));
        } else {
            this.P.setLayoutManager(new GridLayoutManager(6));
            this.P.setHasFixedSize(true);
        }
        this.V.setText(this.Z.getHome());
        this.T.setText(this.Z.getBack());
        this.W.setText(this.Z.getLive_tv());
        this.X.setText(this.Z.getMovies());
        this.Y.setText(this.Z.getSeries());
        this.V.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.f1841a0 = app.shamel.tv.helper.a.j(this.Z);
        e5.l.b(this.O.i(), this);
        this.M = LTVApp.f2088w;
        this.f1842b0 = getIntent().getIntExtra("category_pos", 0);
        this.f1843c0 = this.O.f2098b.getInt("series_order", 1);
        this.R = a6.n.K().D((CategoryModel) this.M.get(this.f1842b0), _UrlKt.FRAGMENT_ENCODE_SET, this.O.g(), this.f1843c0);
        this.U.setText(((CategoryModel) this.M.get(this.f1842b0)).getName() + "(" + this.R.size() + ")");
        d5.x0 x0Var = new d5.x0(this, this.R, true, 0);
        this.Q = x0Var;
        x0Var.f4220k = new a6.n(12, this);
        this.P.setAdapter(x0Var);
        this.S.setAdapter((SpinnerAdapter) new d5.z0(this, this.f1841a0));
        this.S.setSelection(this.f1843c0);
        this.S.setOnItemSelectedListener(new f0(3, this));
        this.N.addTextChangedListener(new l(7, this));
        if (app.shamel.tv.helper.a.l(this)) {
            u(false);
        }
    }

    public final void u(boolean z10) {
        this.V.setFocusable(z10);
        this.W.setFocusable(z10);
        this.X.setFocusable(z10);
        this.Y.setFocusable(z10);
        this.T.setFocusable(z10);
        this.N.setFocusable(z10);
        this.S.setFocusable(z10);
    }
}
