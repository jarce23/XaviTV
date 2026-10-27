package d5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.shamel.tv.activities.SeriesPlayerActivity;
import app.shamel.tv.models.EpisodeModel;
import b4.f1;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4173d;

    /* renamed from: e, reason: collision with root package name */
    public List f4174e;

    /* renamed from: f, reason: collision with root package name */
    public int f4175f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public la.a f4176h;

    /* renamed from: i, reason: collision with root package name */
    public Context f4177i;

    public /* synthetic */ r(int i10) {
        this.f4173d = i10;
    }

    @Override // b4.f0
    public final int a() {
        switch (this.f4173d) {
            case 0:
                List list = this.f4174e;
                if (list == null) {
                    return 0;
                }
                return list.size();
            default:
                List list2 = this.f4174e;
                if (list2 == null) {
                    return 0;
                }
                return list2.size();
        }
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        boolean z10;
        boolean z11;
        switch (this.f4173d) {
            case 0:
                q qVar = (q) f1Var;
                EpisodeModel episodeModel = (EpisodeModel) this.f4174e.get(i10);
                TextView textView = qVar.f4169x;
                ImageView imageView = qVar.f4168w;
                View view = qVar.f2232a;
                textView.setText(String.format("S%d .E%d", Integer.valueOf(this.f4175f + 1), Integer.valueOf(i10 + 1)));
                SeriesPlayerActivity seriesPlayerActivity = (SeriesPlayerActivity) this.f4177i;
                new Gson();
                try {
                    z10 = seriesPlayerActivity.getSharedPreferences("PREF", 0).getBoolean("is_m3u", false);
                } catch (Exception unused) {
                    z10 = false;
                }
                com.bumptech.glide.f.n(seriesPlayerActivity, qVar.f4166u, (z10 || episodeModel.getInfo() == null) ? episodeModel.getStream_icon() : episodeModel.getInfo().getMovie_image(), qVar.f4167v);
                view.setOnClickListener(new b(this, episodeModel, i10, 3));
                view.setOnFocusChangeListener(new p(this, qVar, episodeModel, i10, 0));
                if (this.g == i10) {
                    view.requestFocus();
                    imageView.setVisibility(0);
                    break;
                } else {
                    imageView.setVisibility(8);
                    break;
                }
            default:
                e0 e0Var = (e0) f1Var;
                EpisodeModel episodeModel2 = (EpisodeModel) this.f4174e.get(i10);
                TextView textView2 = e0Var.f4091w;
                View view2 = e0Var.f2232a;
                textView2.setText(String.format("S%d .E%d", Integer.valueOf(this.f4175f + 1), Integer.valueOf(i10 + 1)));
                Context context = this.f4177i;
                new Gson();
                try {
                    z11 = context.getSharedPreferences("PREF", 0).getBoolean("is_m3u", false);
                } catch (Exception unused2) {
                    z11 = false;
                }
                com.bumptech.glide.f.n(context, e0Var.f4089u, (z11 || episodeModel2.getInfo() == null) ? episodeModel2.getStream_icon() : episodeModel2.getInfo().getMovie_image(), e0Var.f4090v);
                view2.setOnClickListener(new b(this, episodeModel2, i10, 7));
                if (this.g == i10) {
                    textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play, 0, 0, 0);
                    view2.requestFocus();
                    view2.setBackgroundResource(R.drawable.item_episode_selected_bg);
                    break;
                } else {
                    textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    view2.setBackgroundResource(R.drawable.item_episode_bg);
                    break;
                }
                break;
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        switch (this.f4173d) {
            case 0:
                View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_episode_play, viewGroup, false);
                q qVar = new q(h10);
                qVar.f4169x = (TextView) h10.findViewById(R.id.txt_name);
                qVar.f4166u = (RoundedImageView) h10.findViewById(R.id.image_episode);
                qVar.f4167v = (RoundedImageView) h10.findViewById(R.id.image_logo);
                qVar.f4168w = (ImageView) h10.findViewById(R.id.image_play);
                return qVar;
            default:
                View h11 = android.support.v4.media.d.h(viewGroup, R.layout.item_episode_play, viewGroup, false);
                e0 e0Var = new e0(h11);
                e0Var.f4091w = (TextView) h11.findViewById(R.id.txt_name);
                e0Var.f4089u = (RoundedImageView) h11.findViewById(R.id.image_episode);
                e0Var.f4090v = (ImageView) h11.findViewById(R.id.image_logo);
                return e0Var;
        }
    }
}
