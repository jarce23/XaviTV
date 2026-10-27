package app.shamel.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveHorizontalGridView;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SearchActivity extends f.j {

    /* renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f1784d0 = 0;
    public ImageButton M;
    public io.realm.n0 N;
    public EditText O;
    public d5.k P;
    public io.realm.n0 Q;
    public app.shamel.tv.helper.r R;
    public LiveHorizontalGridView S;
    public LiveHorizontalGridView T;
    public LiveHorizontalGridView U;
    public io.realm.n0 V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public d5.k Z;

    /* renamed from: a0, reason: collision with root package name */
    public WordModels f1785a0 = new WordModels();

    /* renamed from: b0, reason: collision with root package name */
    public boolean f1786b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    public String f1787c0 = _UrlKt.FRAGMENT_ENCODE_SET;

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                Intent intent = new Intent();
                intent.putExtra("is_changed", _UrlKt.FRAGMENT_ENCODE_SET);
                setResult(-1, intent);
                finish();
            } else if (keyCode != 19) {
                if (keyCode != 21) {
                    if (keyCode == 22 && this.M.hasFocus()) {
                        this.M.setFocusable(false);
                        this.O.requestFocus();
                        return true;
                    }
                } else if (this.O.hasFocus()) {
                    this.M.setFocusable(true);
                    this.M.requestFocus();
                    return true;
                }
            } else if (this.S.hasFocus()) {
                this.O.requestFocus();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search);
        k5.j.a(this);
        this.R = new app.shamel.tv.helper.r(this);
        this.f1785a0 = app.shamel.tv.helper.a.k(this);
        this.M = (ImageButton) findViewById(R.id.btn_back);
        this.O = (EditText) findViewById(R.id.et_search);
        this.W = (TextView) findViewById(R.id.str_live);
        this.X = (TextView) findViewById(R.id.str_movies);
        this.Y = (TextView) findViewById(R.id.str_series);
        this.M.setOnClickListener(new androidx.leanback.widget.g0(3, this));
        this.S = (LiveHorizontalGridView) findViewById(R.id.recycler_channels);
        this.T = (LiveHorizontalGridView) findViewById(R.id.recycler_vod);
        this.U = (LiveHorizontalGridView) findViewById(R.id.recycler_series);
        if (app.shamel.tv.helper.a.l(this)) {
            this.S.setLoop(false);
            this.S.setPreserveFocusAfterLayout(true);
            this.S.setOnChildViewHolderSelectedListener(new e(14, new View[]{null}));
        } else {
            this.S.setLayoutManager(new LinearLayoutManager(0));
            this.S.setHasFixedSize(true);
        }
        if (app.shamel.tv.helper.a.l(this)) {
            this.T.setLoop(false);
            this.T.setPreserveFocusAfterLayout(true);
            this.T.setOnChildViewHolderSelectedListener(new e(15, new View[]{null}));
        } else {
            this.T.setLayoutManager(new LinearLayoutManager(0));
            this.T.setHasFixedSize(true);
        }
        if (app.shamel.tv.helper.a.l(this)) {
            this.U.setLoop(false);
            this.U.setPreserveFocusAfterLayout(true);
            this.U.setOnChildViewHolderSelectedListener(new e(16, new View[]{null}));
        } else {
            this.U.setLayoutManager(new LinearLayoutManager(0));
            this.U.setHasFixedSize(true);
        }
        this.f1786b0 = getIntent().getBooleanExtra("is_live", false);
        this.f1787c0 = getIntent().getStringExtra("search_key");
        this.W.setText(this.f1785a0.getLive_tv());
        this.X.setText(this.f1785a0.getMovies());
        this.Y.setText(this.f1785a0.getSeries());
        this.O.setHint(this.f1785a0.getSearch_by_title());
        this.O.addTextChangedListener(new l(5, this));
        this.M.setFocusable(false);
        String str = this.f1787c0;
        if (str == null || str.isEmpty()) {
            this.O.requestFocus();
            return;
        }
        this.O.setText(this.f1787c0);
        this.T.requestFocus();
        this.O.setFocusable(false);
    }
}
