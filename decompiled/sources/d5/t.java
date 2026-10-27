package d5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.shamel.tv.activities.SeasonActivity;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.ResumeModel;
import b4.f1;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public app.shamel.tv.activities.f f4188d;

    /* renamed from: e, reason: collision with root package name */
    public SeasonActivity f4189e;

    /* renamed from: f, reason: collision with root package name */
    public List f4190f;
    public String g;

    /* renamed from: h, reason: collision with root package name */
    public String f4191h;

    /* renamed from: i, reason: collision with root package name */
    public app.shamel.tv.helper.r f4192i;

    @Override // b4.f0
    public final int a() {
        List list = this.f4190f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        s sVar = (s) f1Var;
        String str = this.f4191h;
        SeasonActivity seasonActivity = this.f4189e;
        EpisodeModel episodeModel = (EpisodeModel) this.f4190f.get(i10);
        TextView textView = sVar.f4185y;
        View view = sVar.f2232a;
        ImageView imageView = sVar.f4181u;
        ProgressBar progressBar = sVar.f4182v;
        textView.setText(episodeModel.getEpisode_num());
        sVar.f4184x.setText(episodeModel.getTitle());
        if (episodeModel.getInfo() != null) {
            sVar.f4183w.setText(episodeModel.getInfo().getPlot());
        }
        if (episodeModel.getInfo() == null || episodeModel.getInfo().getMovie_image() == null || episodeModel.getInfo().getMovie_image().isEmpty()) {
            ((com.bumptech.glide.m) com.bumptech.glide.b.e(seasonActivity).q(Integer.valueOf(R.drawable.episode_icon)).g(R.drawable.episode_icon)).E(imageView);
        } else {
            ((com.bumptech.glide.m) ((com.bumptech.glide.m) com.bumptech.glide.b.e(seasonActivity).r(episodeModel.getInfo().getMovie_image()).g(R.drawable.episode_icon)).p(R.drawable.episode_icon)).E(imageView);
        }
        progressBar.setProgress(l(str + this.g + episodeModel.getTitle()));
        if (l(str + this.g + episodeModel.getTitle()) > 0) {
            progressBar.setVisibility(0);
        } else {
            progressBar.setVisibility(8);
        }
        view.setOnFocusChangeListener(new p(this, episodeModel, i10, sVar));
        view.setOnClickListener(new b(this, episodeModel, i10, 4));
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_episode, viewGroup, false);
        s sVar = new s(h10);
        sVar.f4181u = (ImageView) h10.findViewById(R.id.image_logo);
        sVar.f4184x = (TextView) h10.findViewById(R.id.txt_name);
        sVar.f4185y = (TextView) h10.findViewById(R.id.txt_num);
        sVar.f4183w = (TextView) h10.findViewById(R.id.txt_description);
        sVar.f4182v = (ProgressBar) h10.findViewById(R.id.seekbar);
        return sVar;
    }

    public final int l(String str) {
        for (ResumeModel resumeModel : this.f4192i.A()) {
            if (resumeModel.getName().equalsIgnoreCase(str)) {
                return resumeModel.getPro();
            }
        }
        return 0;
    }
}
