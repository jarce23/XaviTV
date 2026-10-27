package d5;

import android.view.View;
import android.widget.TextView;
import app.shamel.tv.activities.MovieCreditActivity;
import app.shamel.tv.models.CastModel;
import app.shamel.tv.models.MovieCreditModel;
import b4.f1;
import java.io.Serializable;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements View.OnFocusChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4107o = 1;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f1 f4108p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Serializable f4109q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ b4.f0 f4110r;

    public h(k kVar, j jVar, CastModel castModel) {
        this.f4110r = kVar;
        this.f4108p = jVar;
        this.f4109q = castModel;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f4107o) {
            case 0:
                j jVar = (j) this.f4108p;
                View view2 = jVar.f2232a;
                int b2 = jVar.b();
                if (b2 != -1) {
                    if (!z10) {
                        view2.setScaleX(0.95f);
                        view2.setScaleY(0.95f);
                        view2.setBackgroundResource(R.color.trans_parent);
                        break;
                    } else {
                        ((app.shamel.tv.activities.f) ((k) this.f4110r).f4124e).c((CastModel) this.f4109q, Integer.valueOf(b2), Boolean.FALSE);
                        view2.setScaleX(1.0f);
                        view2.setScaleY(1.0f);
                        view2.setBackgroundResource(R.drawable.portal_bg_up);
                        break;
                    }
                }
                break;
            default:
                e eVar = (e) this.f4110r;
                MovieCreditActivity movieCreditActivity = (MovieCreditActivity) eVar.f4087f;
                a0 a0Var = (a0) this.f4108p;
                TextView textView = a0Var.f4059x;
                View view3 = a0Var.f2232a;
                if (!z10) {
                    view3.setBackgroundResource(R.drawable.item_group_bg);
                    textView.setTextColor(movieCreditActivity.getResources().getColor(R.color.white));
                    view3.setScaleX(0.95f);
                    view3.setScaleY(0.95f);
                    textView.setSelected(false);
                    break;
                } else {
                    view3.setBackgroundResource(R.drawable.item_vod_selected_bg);
                    textView.setSelected(true);
                    textView.setTextColor(movieCreditActivity.getResources().getColor(R.color.black));
                    view3.setScaleX(1.0f);
                    view3.setScaleY(1.0f);
                    app.shamel.tv.activities.h0 h0Var = (app.shamel.tv.activities.h0) eVar.g;
                    h0Var.f1896p.u((MovieCreditModel) this.f4109q);
                    break;
                }
        }
    }

    public h(e eVar, a0 a0Var, MovieCreditModel movieCreditModel, int i10) {
        this.f4110r = eVar;
        this.f4108p = a0Var;
        this.f4109q = movieCreditModel;
    }
}
