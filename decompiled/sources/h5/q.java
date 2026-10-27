package h5;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import app.shamel.tv.activities.mobile.SeriesMobilePlayer;
import m.w1;
import m.z1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements View.OnTouchListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5642o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f5643p;

    public /* synthetic */ q(int i10, Object obj) {
        this.f5642o = i10;
        this.f5643p = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f5642o) {
            case 0:
                r rVar = (r) this.f5643p;
                if (motionEvent.getAction() == 3) {
                    rVar.f5648y0.setColorFilter(view.getContext().getColor(R.color.trans_parent));
                }
                if (motionEvent.getAction() == 0) {
                    rVar.f5648y0.setColorFilter(view.getContext().getColor(R.color.hover_color));
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    rVar.f5648y0.setColorFilter(view.getContext().getColor(R.color.trans_parent));
                    rVar.J(false, false);
                }
                return false;
            case 1:
                r rVar2 = (r) this.f5643p;
                if (motionEvent.getAction() == 3) {
                    rVar2.F0.setTextColor(rVar2.l().getColor(R.color.gray));
                }
                if (motionEvent.getAction() == 0) {
                    rVar2.F0.setTextColor(rVar2.l().getColor(R.color.hover_color));
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    rVar2.F0.setTextColor(rVar2.l().getColor(R.color.gray));
                    SeriesMobilePlayer seriesMobilePlayer = rVar2.B0.f2948p;
                    seriesMobilePlayer.C();
                    seriesMobilePlayer.finish();
                    rVar2.J(false, false);
                }
                return false;
            default:
                z1 z1Var = (z1) this.f5643p;
                w1 w1Var = z1Var.F;
                Handler handler = z1Var.J;
                m.x xVar = z1Var.N;
                int action = motionEvent.getAction();
                int x6 = (int) motionEvent.getX();
                int y8 = (int) motionEvent.getY();
                if (action == 0 && xVar != null && xVar.isShowing() && x6 >= 0 && x6 < xVar.getWidth() && y8 >= 0 && y8 < xVar.getHeight()) {
                    handler.postDelayed(w1Var, 250L);
                    return false;
                }
                if (action != 1) {
                    return false;
                }
                handler.removeCallbacks(w1Var);
                return false;
        }
    }
}
