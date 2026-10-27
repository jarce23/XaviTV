package d5;

import android.view.MotionEvent;
import android.view.View;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p0 implements View.OnTouchListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4161o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f4162p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ f1 f4163q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ io.realm.k0 f4164r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ b4.f0 f4165s;

    public /* synthetic */ p0(b4.f0 f0Var, f1 f1Var, io.realm.k0 k0Var, int i10, int i11) {
        this.f4161o = i11;
        this.f4165s = f0Var;
        this.f4163q = f1Var;
        this.f4164r = k0Var;
        this.f4162p = i10;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f4161o) {
            case 0:
                View view2 = ((q0) this.f4163q).f2232a;
                if (motionEvent.getAction() == 3) {
                    view2.setBackgroundResource(R.drawable.search_item_bg);
                }
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() == 1) {
                        view2.setBackgroundResource(R.drawable.search_item_bg);
                        ((app.shamel.tv.activities.p0) ((k) this.f4165s).f4124e).c((EPGChannel) this.f4164r, Integer.valueOf(this.f4162p), Boolean.TRUE);
                    }
                    break;
                } else {
                    view2.setBackgroundResource(R.drawable.search_focused_bg);
                    break;
                }
            case 1:
                View view3 = ((r0) this.f4163q).f2232a;
                if (motionEvent.getAction() == 3) {
                    view3.setBackgroundResource(R.drawable.search_item_bg);
                }
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() == 1) {
                        view3.setBackgroundResource(R.drawable.search_item_bg);
                        ((app.shamel.tv.activities.p0) ((k) this.f4165s).f4124e).c((SeriesModel) this.f4164r, Integer.valueOf(this.f4162p), Boolean.TRUE);
                    }
                    break;
                } else {
                    view3.setBackgroundResource(R.drawable.search_focused_bg);
                    break;
                }
            default:
                View view4 = ((u0) this.f4163q).f2232a;
                if (motionEvent.getAction() == 3) {
                    view4.setBackgroundResource(R.drawable.search_item_bg);
                }
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() == 1) {
                        view4.setBackgroundResource(R.drawable.search_item_bg);
                        ((app.shamel.tv.activities.p0) ((k) this.f4165s).f4124e).c((MovieModel) this.f4164r, Integer.valueOf(this.f4162p), Boolean.TRUE);
                    }
                    break;
                } else {
                    view4.setBackgroundResource(R.drawable.search_focused_bg);
                    break;
                }
        }
        return true;
    }
}
