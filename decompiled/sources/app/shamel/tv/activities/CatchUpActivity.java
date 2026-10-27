package app.shamel.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CatchUpActivity extends f.j {

    /* renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f1576g0 = 0;
    public List M;
    public ArrayList N;
    public ImageView O;
    public TextView P;
    public List Q;
    public d5.e R;
    public LiveVerticalGridView S;
    public LiveVerticalGridView T;
    public ImageButton U;
    public app.shamel.tv.helper.r V;
    public d5.e W;
    public ProgressBar X;
    public EPGChannel Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f1577a0 = -1;

    /* renamed from: b0, reason: collision with root package name */
    public int f1578b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    public int f1579c0 = -1;

    /* renamed from: d0, reason: collision with root package name */
    public final SimpleDateFormat f1580d0 = new SimpleDateFormat("MMM d");

    /* renamed from: e0, reason: collision with root package name */
    public final SimpleDateFormat f1581e0 = new SimpleDateFormat("EEEE");

    /* renamed from: f0, reason: collision with root package name */
    public WordModels f1582f0 = new WordModels();

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        List list;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                Intent intent = new Intent();
                intent.putExtra("is_changed", _UrlKt.FRAGMENT_ENCODE_SET);
                setResult(-1, intent);
                finish();
                return true;
            }
            if (keyCode != 22) {
                if (keyCode != 19) {
                    if (keyCode == 20 && this.U.hasFocus()) {
                        this.U.setFocusable(false);
                        this.S.requestFocus();
                        return true;
                    }
                } else {
                    if (this.S.hasFocus() && this.f1577a0 == 0) {
                        this.U.setFocusable(true);
                        this.U.requestFocus();
                        return true;
                    }
                    if (this.T.hasFocus() && this.f1579c0 == 0) {
                        this.U.setFocusable(true);
                        this.U.requestFocus();
                        return true;
                    }
                }
            } else if (this.U.hasFocus() && (list = this.Q) != null && !list.isEmpty()) {
                this.U.setFocusable(false);
                this.T.requestFocus();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_catch_up);
        k5.j.a(this);
        this.V = new app.shamel.tv.helper.r(this);
        this.f1582f0 = app.shamel.tv.helper.a.k(this);
        this.O = (ImageView) findViewById(R.id.channel_image);
        this.P = (TextView) findViewById(R.id.channel_name);
        this.S = (LiveVerticalGridView) findViewById(R.id.date_list);
        this.T = (LiveVerticalGridView) findViewById(R.id.epg_list);
        this.Z = (TextView) findViewById(R.id.txt_catch);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.X = progressBar;
        progressBar.setVisibility(8);
        ImageButton imageButton = (ImageButton) findViewById(R.id.image_back);
        this.U = imageButton;
        imageButton.setFocusable(false);
        int i10 = 1;
        this.U.setOnClickListener(new androidx.leanback.widget.g0(1, this));
        this.S.setNumColumns(1);
        this.S.setLoop(false);
        this.S.setPreserveFocusAfterLayout(true);
        this.S.setOnChildViewHolderSelectedListener(new e(2, new View[]{null}));
        this.T.setNumColumns(1);
        this.T.setPreserveFocusAfterLayout(true);
        this.T.setLoop(false);
        this.T.setOnChildViewHolderSelectedListener(new e(3, new View[]{null}));
        this.Z.setText(this.f1582f0.getCatch_up());
        this.Y = (EPGChannel) android.support.v4.media.d.j((io.realm.u) a6.n.K().f74p, EPGChannel.class, "name", LTVApp.f2084s);
        this.P.setText(_UrlKt.FRAGMENT_ENCODE_SET + this.Y.getNum() + " " + this.Y.getName());
        try {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).r(this.Y.getStream_icon()).g(R.drawable.home_logo)).E(this.O);
        } catch (Exception unused) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.b(this).c(this).q(Integer.valueOf(R.drawable.home_logo)).g(R.drawable.home_logo)).E(this.O);
        }
        ArrayList arrayList = new ArrayList();
        f fVar = new f(0, this);
        d5.e eVar = new d5.e(1);
        eVar.f4086e = -1;
        eVar.f4088h = this;
        eVar.f4087f = arrayList;
        eVar.g = fVar;
        this.R = eVar;
        this.S.setAdapter(eVar);
        ArrayList arrayList2 = new ArrayList();
        b bVar = new b(this, i10);
        d5.e eVar2 = new d5.e(3);
        eVar2.f4086e = -1;
        eVar2.f4088h = this;
        eVar2.f4087f = arrayList2;
        eVar2.g = bVar;
        this.W = eVar2;
        this.T.setAdapter(eVar2);
        this.X.setVisibility(0);
        try {
            j5.f.a(this.V.B()).get_full_epg(this.V.I(), this.V.v(), this.Y.getStream_id()).enqueue(new a6.n(8, this));
        } catch (Exception unused2) {
            Toast.makeText(this, this.f1582f0.getNo_epg_avaliable(), 0).show();
            this.X.setVisibility(8);
            this.M = new ArrayList();
            this.U.setFocusable(true);
            this.U.requestFocus();
        }
    }
}
