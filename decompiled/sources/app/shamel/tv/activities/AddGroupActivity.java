package app.shamel.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AddGroupActivity extends f.j {

    /* renamed from: f0, reason: collision with root package name */
    public static final /* synthetic */ int f1570f0 = 0;
    public h5.h M;
    public Button N;
    public ImageButton O;
    public d5.e P;
    public d5.c0 Q;
    public ImageView R;
    public app.shamel.tv.helper.r S;
    public LiveVerticalGridView T;
    public LiveVerticalGridView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    public int f1571a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public String f1572b0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: c0, reason: collision with root package name */
    public List f1573c0 = new ArrayList();

    /* renamed from: d0, reason: collision with root package name */
    public List f1574d0 = new ArrayList();

    /* renamed from: e0, reason: collision with root package name */
    public WordModels f1575e0 = new WordModels();

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                switch (keyCode) {
                    case 19:
                        if (this.U.hasFocus() && this.f1571a0 == 0) {
                            this.N.requestFocus();
                            return true;
                        }
                        if (this.T.hasFocus() && this.Z == 0) {
                            this.O.setFocusable(true);
                            this.O.requestFocus();
                            return true;
                        }
                        break;
                    case 20:
                        if (this.N.hasFocus() && this.U.getVisibility() == 0) {
                            this.U.requestFocus();
                            this.U.setSelectedPosition(0);
                            return true;
                        }
                        break;
                    case 21:
                        if (this.N.hasFocus()) {
                            this.O.setFocusable(true);
                            this.O.requestFocus();
                            return true;
                        }
                        break;
                    case 22:
                        if (this.T.hasFocus()) {
                            if (this.U.getVisibility() == 0) {
                                this.U.requestFocus();
                                return true;
                            }
                            this.N.requestFocus();
                            return true;
                        }
                        break;
                }
            } else {
                Intent intent = new Intent();
                intent.putExtra("is_changed", "add_group");
                setResult(-1, intent);
                finish();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_group);
        k5.j.a(this);
        this.S = new app.shamel.tv.helper.r(this);
        this.f1575e0 = app.shamel.tv.helper.a.k(this);
        this.O = (ImageButton) findViewById(R.id.btn_back);
        this.W = (TextView) findViewById(R.id.str_groups);
        this.Y = (TextView) findViewById(R.id.txt_group_name);
        this.V = (TextView) findViewById(R.id.str_add);
        this.X = (TextView) findViewById(R.id.txt_edit);
        this.T = (LiveVerticalGridView) findViewById(R.id.recycler_category);
        this.U = (LiveVerticalGridView) findViewById(R.id.recycler_channel);
        this.N = (Button) findViewById(R.id.btn_add_channel);
        this.R = (ImageView) findViewById(R.id.image_add);
        this.W.setText(this.f1575e0.getStr_my_group());
        this.N.setText(this.f1575e0.getStr_add_channel());
        this.V.setText(this.f1575e0.getStr_group_string());
        this.X.setText(this.f1575e0.getEdit_group_name());
        int i10 = 1;
        this.O.setOnClickListener(new c(this, i10));
        this.f1574d0 = this.S.a();
        List s10 = this.S.s();
        this.f1573c0 = s10;
        int i11 = 0;
        s10.add(0, this.f1575e0.getAdd_group());
        this.f1573c0.add(1, this.f1575e0.getFavorite());
        List list = this.f1573c0;
        a aVar = new a(this);
        d5.e eVar = new d5.e(i11);
        eVar.f4086e = -1;
        eVar.f4088h = this;
        eVar.f4087f = list;
        eVar.g = aVar;
        this.P = eVar;
        this.T.setAdapter(eVar);
        if (app.shamel.tv.helper.a.l(this)) {
            this.T.setNumColumns(1);
            this.T.setPreserveFocusAfterLayout(true);
            this.T.setOnChildViewHolderSelectedListener(new e(i11, new View[]{null}));
        } else {
            this.T.setLayoutManager(new LinearLayoutManager(1));
        }
        d5.c0 c0Var = new d5.c0(this, new ArrayList(), true, new b(this, i11));
        this.Q = c0Var;
        this.U.setAdapter(c0Var);
        if (app.shamel.tv.helper.a.l(this)) {
            this.U.setNumColumns(1);
            this.U.setLoop(false);
            this.U.setPreserveFocusAfterLayout(true);
            this.U.setOnChildViewHolderSelectedListener(new e(i10, new View[]{null}));
        } else {
            this.U.setLayoutManager(new LinearLayoutManager(1));
        }
        this.O.setFocusable(false);
        this.T.setSelectedPosition(0);
        this.T.requestFocus();
        this.N.setVisibility(8);
        this.N.setOnClickListener(new c(this, i11));
    }

    public final void u(String str, boolean z10) {
        androidx.fragment.app.j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        androidx.fragment.app.s A = n10.A("fragment_add_group");
        i10.e(false);
        if (A != null) {
            i10.h(A);
            i10.c();
            return;
        }
        h5.h hVar = new h5.h();
        hVar.H0 = z10;
        hVar.A0 = str;
        this.M = hVar;
        hVar.f5604z0 = new t1.e(this, z10, 4);
        hVar.M(n10, "fragment_add_group");
    }

    public final void v(int i10, String str) {
        if (i10 == 0) {
            this.N.setVisibility(8);
            this.Y.setVisibility(8);
            this.R.setVisibility(0);
            this.V.setVisibility(0);
            this.U.setVisibility(8);
            return;
        }
        if (i10 == 1) {
            this.f1572b0 = str;
            this.N.setVisibility(0);
            this.Y.setVisibility(0);
            this.Y.setText(str);
            List m10 = this.S.m();
            if (m10.isEmpty()) {
                this.R.setVisibility(0);
                this.V.setVisibility(0);
                this.U.setVisibility(8);
                return;
            } else {
                this.R.setVisibility(8);
                this.V.setVisibility(8);
                this.U.setVisibility(0);
                this.Q.m(m10);
                return;
            }
        }
        this.f1572b0 = str;
        this.N.setVisibility(0);
        this.Y.setVisibility(0);
        this.Y.setText(str);
        List t3 = this.S.t(str);
        if (t3.isEmpty()) {
            this.R.setVisibility(0);
            this.V.setVisibility(0);
            this.U.setVisibility(8);
        } else {
            this.R.setVisibility(8);
            this.V.setVisibility(8);
            this.U.setVisibility(0);
            this.Q.m(t3);
        }
    }
}
