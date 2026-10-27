package app.shamel.tv.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.Season;
import app.shamel.tv.models.SeriesModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import eightbitlab.com.blurview.BlurView;
import io.realm.RealmQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SeasonActivity extends f.j {
    public static final /* synthetic */ int h0 = 0;
    public BlurView M;
    public SeriesModel N;
    public d5.t O;
    public LiveVerticalGridView P;
    public ImageView Q;
    public ImageView R;
    public String S;
    public app.shamel.tv.helper.r T;
    public d5.e U;
    public LiveVerticalGridView V;
    public String W;
    public String X;
    public TextView Y;
    public ArrayList Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    public List f1788a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    public String f1789b0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: c0, reason: collision with root package name */
    public String f1790c0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: d0, reason: collision with root package name */
    public WordModels f1791d0 = new WordModels();

    /* renamed from: e0, reason: collision with root package name */
    public int f1792e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    public int f1793f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    public int f1794g0 = 0;

    public static void u(SeasonActivity seasonActivity, int i10) {
        f.f fVar = new f.f(seasonActivity);
        fVar.setTitle(seasonActivity.f1791d0.getInstall_external_player());
        String want_external_player = seasonActivity.f1791d0.getWant_external_player();
        f.b bVar = fVar.f4778a;
        bVar.f4706f = want_external_player;
        bVar.f4710k = false;
        String ok = seasonActivity.f1791d0.getOk();
        e0 e0Var = new e0(seasonActivity, i10, 3);
        bVar.g = ok;
        bVar.f4707h = e0Var;
        String cancel = seasonActivity.f1791d0.getCancel();
        d0 d0Var = new d0(3);
        bVar.f4708i = cancel;
        bVar.f4709j = d0Var;
        fVar.create().show();
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (this.V.hasFocus() && this.f1792e0 == 0) {
                        this.Q.setFocusable(true);
                        this.Q.requestFocus();
                        return true;
                    }
                    if (this.P.hasFocus() && this.f1793f0 == 0) {
                        this.Q.setFocusable(true);
                        this.Q.requestFocus();
                        return true;
                    }
                    break;
                case 20:
                    if (this.Q.hasFocus()) {
                        this.Q.setFocusable(false);
                        this.V.requestFocus();
                        return true;
                    }
                    break;
                case 21:
                    if (this.P.hasFocus()) {
                        this.U.o(this.f1794g0);
                        this.V.requestFocus();
                        return true;
                    }
                    break;
                case 22:
                    if (this.V.hasFocus()) {
                        this.U.o(this.f1794g0);
                        this.U.e(this.f1794g0);
                        this.P.requestFocus();
                        return true;
                    }
                    if (this.Q.hasFocus()) {
                        this.Q.setFocusable(false);
                        this.P.requestFocus();
                        return true;
                    }
                    break;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_season);
        k5.j.a(this);
        this.T = new app.shamel.tv.helper.r(this);
        this.f1791d0 = app.shamel.tv.helper.a.k(this);
        this.Q = (ImageView) findViewById(R.id.image_back);
        this.R = (ImageView) findViewById(R.id.image_bg);
        this.M = (BlurView) findViewById(R.id.blur_view);
        View decorView = getWindow().getDecorView();
        BlurView blurView = this.M;
        z9.a aVar = new z9.a(blurView, (ViewGroup) decorView.findViewById(android.R.id.content), blurView.f4683p);
        blurView.f4682o.destroy();
        blurView.f4682o = aVar;
        aVar.f14160z = decorView.getBackground();
        aVar.f14150p = new io.realm.internal.p(this);
        aVar.f14149o = 20.0f;
        aVar.d(true);
        int color = getResources().getColor(R.color.black_50);
        if (aVar.f14154t != color) {
            aVar.f14154t = color;
            aVar.f14153s.invalidate();
        }
        this.V = (LiveVerticalGridView) findViewById(R.id.season_list);
        this.P = (LiveVerticalGridView) findViewById(R.id.episode_list);
        this.Y = (TextView) findViewById(R.id.txt_name);
        if (app.shamel.tv.helper.a.l(this)) {
            this.V.setNumColumns(1);
            this.V.setPreserveFocusAfterLayout(true);
            this.V.setOnChildViewHolderSelectedListener(new e(17, new View[]{null}));
            this.P.setLoop(false);
            this.P.setNumColumns(1);
            this.P.setPreserveFocusAfterLayout(true);
            this.P.setOnChildViewHolderSelectedListener(new e(18, new View[]{null}));
        } else {
            this.V.setLayoutManager(new LinearLayoutManager(1));
            this.V.setHasFixedSize(true);
            this.P.setLayoutManager(new LinearLayoutManager(1));
            this.P.setHasFixedSize(true);
        }
        this.Q.setOnClickListener(new androidx.leanback.widget.g0(4, this));
        this.Q.setFocusable(false);
        this.S = getIntent().getStringExtra("image_url");
        this.X = getIntent().getStringExtra("series_name");
        this.f1789b0 = getIntent().getStringExtra("series_id");
        if (this.T.g() || this.f1789b0.isEmpty()) {
            this.N = (SeriesModel) android.support.v4.media.d.j((io.realm.u) a6.n.K().f74p, SeriesModel.class, "name", this.X);
        } else {
            this.N = (SeriesModel) android.support.v4.media.d.j((io.realm.u) a6.n.K().f74p, SeriesModel.class, "series_id", this.f1789b0);
        }
        this.f1789b0 = this.N.getSeries_id();
        this.Y.setText(this.X);
        ArrayList arrayList = new ArrayList();
        b bVar = new b(this, 2);
        d5.e eVar = new d5.e(5);
        eVar.f4086e = 0;
        eVar.f4088h = this;
        eVar.f4087f = arrayList;
        eVar.g = bVar;
        this.U = eVar;
        this.V.setAdapter(eVar);
        ArrayList arrayList2 = new ArrayList();
        String str = this.X;
        String str2 = this.W;
        f fVar = new f(4, this);
        d5.t tVar = new d5.t();
        tVar.f4189e = this;
        tVar.f4190f = arrayList2;
        tVar.f4191h = str;
        tVar.g = str2;
        tVar.f4188d = fVar;
        tVar.f4192i = new app.shamel.tv.helper.r(this);
        this.O = tVar;
        this.P.setAdapter(tVar);
        if (this.T.g()) {
            a6.n K = a6.n.K();
            String str3 = this.X;
            K.getClass();
            RealmQuery V = ((io.realm.u) K.f74p).V(EpisodeModel.class);
            V.c("series_name", str3);
            ArrayList arrayList3 = new ArrayList(V.d());
            a6.n.f71q = new HashMap();
            int size = arrayList3.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList3.get(i10);
                i10++;
                EpisodeModel episodeModel = (EpisodeModel) obj;
                String season_name = episodeModel.getSeason_name();
                List list = (List) a6.n.f71q.get(season_name);
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(episodeModel);
                a6.n.f71q.put(season_name, list);
            }
            TreeSet treeSet = new TreeSet(a6.n.f71q.keySet());
            ArrayList arrayList4 = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                List<EpisodeModel> list2 = (List) a6.n.f71q.get(str4);
                if (list2 != null && !list2.isEmpty()) {
                    Season season = new Season();
                    season.setName(str4);
                    season.setCategory_name(list2.get(0).getCategory_name());
                    season.setEpisodeModels(list2);
                    arrayList4.add(season);
                }
            }
            this.Z = arrayList4;
            if (!arrayList4.isEmpty()) {
                int season_pos = this.N.getSeason_pos();
                this.f1794g0 = season_pos;
                if (season_pos > this.Z.size() - 1) {
                    this.f1794g0 = 0;
                }
                d5.e eVar2 = this.U;
                eVar2.f4087f = this.Z;
                eVar2.d();
                List<EpisodeModel> episodeModels = ((Season) this.Z.get(this.f1794g0)).getEpisodeModels();
                this.f1788a0 = episodeModels;
                d5.t tVar2 = this.O;
                String name = ((Season) this.Z.get(this.f1794g0)).getName();
                tVar2.f4190f = episodeModels;
                tVar2.g = name;
                tVar2.d();
                int episode_pos = this.N.getEpisode_pos();
                this.f1793f0 = episode_pos;
                if (episode_pos > this.f1788a0.size() - 1) {
                    this.f1793f0 = 0;
                }
                this.P.e0(this.f1793f0);
                this.U.o(this.f1794g0);
                this.V.setSelectedPosition(this.f1794g0);
                this.V.requestFocus();
            }
        } else {
            j5.f.a(this.T.B()).get_series_info(this.T.I(), this.T.v(), this.f1789b0).enqueue(new r0(this));
        }
        String str5 = this.S;
        if (str5 == null || str5.isEmpty()) {
            return;
        }
        com.bumptech.glide.b.b(this).c(this).r(this.S).E(this.R);
    }
}
