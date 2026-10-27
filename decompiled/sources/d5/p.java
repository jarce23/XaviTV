package d5;

import android.graphics.Color;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import b4.f1;
import java.io.Serializable;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements View.OnFocusChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4156o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Serializable f4157p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f4158q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ f1 f4159r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ b4.f0 f4160s;

    public /* synthetic */ p(b4.f0 f0Var, f1 f1Var, Serializable serializable, int i10, int i11) {
        this.f4156o = i11;
        this.f4160s = f0Var;
        this.f4159r = f1Var;
        this.f4157p = serializable;
        this.f4158q = i10;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f4156o) {
            case 0:
                View view2 = ((q) this.f4159r).f2232a;
                if (!z10) {
                    view2.setBackgroundResource(R.drawable.item_episode_bg);
                    break;
                } else {
                    ((app.shamel.tv.activities.f) ((r) this.f4160s).f4176h).c((EpisodeModel) this.f4157p, Integer.valueOf(this.f4158q), Boolean.FALSE);
                    view2.setBackgroundResource(R.drawable.item_episode_selected_bg);
                    break;
                }
            case 1:
                EpisodeModel episodeModel = (EpisodeModel) this.f4157p;
                s sVar = (s) this.f4159r;
                View view3 = sVar.f2232a;
                ProgressBar progressBar = sVar.f4182v;
                t tVar = (t) this.f4160s;
                String str = tVar.f4191h;
                if (!z10) {
                    view3.setBackgroundResource(R.color.item_channel_bg);
                    if (tVar.l(str + tVar.g + episodeModel.getTitle()) <= 0) {
                        progressBar.setVisibility(8);
                        break;
                    } else {
                        progressBar.setVisibility(0);
                        break;
                    }
                } else {
                    tVar.f4188d.c(episodeModel, Integer.valueOf(this.f4158q), Boolean.FALSE);
                    view3.setBackgroundResource(R.drawable.live_teim_focus_bg);
                    if (tVar.l(str + tVar.g + episodeModel.getTitle()) > 0) {
                        progressBar.setVisibility(0);
                        break;
                    }
                }
                break;
            case 2:
                CatchUpEpg catchUpEpg = (CatchUpEpg) this.f4157p;
                k0 k0Var = (k0) this.f4159r;
                View view4 = k0Var.f2232a;
                TextView textView = k0Var.f4129x;
                if (!z10) {
                    view4.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    textView.setVisibility(8);
                    break;
                } else {
                    ((app.shamel.tv.activities.b) ((e) this.f4160s).g).c(catchUpEpg, Integer.valueOf(this.f4158q), Boolean.FALSE);
                    view4.setBackgroundResource(R.drawable.live_teim_focus_bg);
                    textView.setText(k5.j.e(catchUpEpg.getDescription()));
                    if (!catchUpEpg.getDescription().isEmpty()) {
                        textView.setVisibility(0);
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                }
            case 3:
                CategoryModel categoryModel = (CategoryModel) this.f4157p;
                n0 n0Var = (n0) this.f4160s;
                ya.q qVar = n0Var.f4141e;
                boolean z11 = n0Var.f4144i;
                m0 m0Var = (m0) this.f4159r;
                TextView textView2 = m0Var.f4137v;
                View view5 = m0Var.f2232a;
                if (!z10) {
                    if (z11) {
                        view5.setBackgroundResource(R.drawable.item_channel_grid_bg);
                    } else {
                        view5.setBackgroundResource(R.color.item_channel_bg);
                    }
                    textView2.setSelected(false);
                    break;
                } else {
                    int i10 = this.f4158q;
                    if (!z11) {
                        if (!n0Var.f4143h) {
                            textView2.setSelected(true);
                            qVar.c(categoryModel, Integer.valueOf(i10), Boolean.FALSE);
                            view5.setBackgroundResource(R.drawable.live_teim_focus_bg);
                            break;
                        } else {
                            n0Var.f4143h = false;
                            break;
                        }
                    } else {
                        textView2.setSelected(true);
                        qVar.c(categoryModel, Integer.valueOf(i10), Boolean.FALSE);
                        view5.setBackgroundResource(R.drawable.item_channel_grid_selected_bg);
                        break;
                    }
                }
            case 4:
                o0 o0Var = (o0) this.f4159r;
                if (!z10) {
                    o0Var.f2232a.setBackgroundResource(R.color.item_channel_bg);
                    break;
                } else {
                    o0Var.f2232a.setBackgroundResource(R.drawable.live_teim_focus_bg);
                    ya.r rVar = (ya.r) ((e) this.f4160s).g;
                    Integer valueOf = Integer.valueOf(this.f4158q);
                    Boolean bool = Boolean.FALSE;
                    rVar.d((EPGChannel) this.f4157p, valueOf, bool, bool);
                    break;
                }
            case 5:
                View view6 = ((q0) this.f4159r).f2232a;
                if (!z10) {
                    view6.setBackgroundResource(R.drawable.search_item_bg);
                    break;
                } else {
                    ((app.shamel.tv.activities.p0) ((k) this.f4160s).f4124e).c((EPGChannel) this.f4157p, Integer.valueOf(this.f4158q), Boolean.FALSE);
                    view6.setBackgroundResource(R.drawable.search_focused_bg);
                    break;
                }
            case 6:
                View view7 = ((r0) this.f4159r).f2232a;
                if (!z10) {
                    view7.setBackgroundResource(R.drawable.search_item_bg);
                    break;
                } else {
                    ((app.shamel.tv.activities.p0) ((k) this.f4160s).f4124e).c((SeriesModel) this.f4157p, Integer.valueOf(this.f4158q), Boolean.FALSE);
                    view7.setBackgroundResource(R.drawable.search_focused_bg);
                    break;
                }
            case 7:
                t0 t0Var = (t0) this.f4160s;
                boolean z12 = t0Var.g;
                View view8 = ((s0) this.f4159r).f2232a;
                if (!z10) {
                    if (!z12) {
                        view8.setBackgroundResource(R.color.item_channel_bg);
                        break;
                    } else {
                        view8.setBackgroundResource(R.drawable.item_channel_grid_bg);
                        break;
                    }
                } else {
                    t0Var.f4194e.c((CategoryModel) this.f4157p, Integer.valueOf(this.f4158q), Boolean.FALSE);
                    if (!z12) {
                        view8.setBackgroundResource(R.drawable.live_teim_focus_bg);
                        break;
                    } else {
                        view8.setBackgroundResource(R.drawable.item_channel_grid_selected_bg);
                        break;
                    }
                }
            default:
                View view9 = ((u0) this.f4159r).f2232a;
                if (!z10) {
                    view9.setBackgroundResource(R.drawable.search_item_bg);
                    break;
                } else {
                    ((app.shamel.tv.activities.p0) ((k) this.f4160s).f4124e).c((MovieModel) this.f4157p, Integer.valueOf(this.f4158q), Boolean.FALSE);
                    view9.setBackgroundResource(R.drawable.search_focused_bg);
                    break;
                }
        }
    }

    public p(t tVar, EpisodeModel episodeModel, int i10, s sVar) {
        this.f4156o = 1;
        this.f4160s = tVar;
        this.f4157p = episodeModel;
        this.f4158q = i10;
        this.f4159r = sVar;
    }

    public p(e eVar, o0 o0Var, int i10, EPGChannel ePGChannel) {
        this.f4156o = 4;
        this.f4160s = eVar;
        this.f4159r = o0Var;
        this.f4158q = i10;
        this.f4157p = ePGChannel;
    }
}
