package d5;

import android.view.View;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements View.OnFocusChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4205o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f1 f4206p;

    public /* synthetic */ v(f1 f1Var, int i10) {
        this.f4205o = i10;
        this.f4206p = f1Var;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f4205o) {
            case 0:
                w wVar = (w) this.f4206p;
                if (!z10) {
                    wVar.f2232a.setBackgroundResource(R.color.item_channel_bg);
                    break;
                } else {
                    wVar.f2232a.setBackgroundResource(R.drawable.live_teim_focus_bg);
                    break;
                }
            case 1:
                x xVar = (x) this.f4206p;
                if (!z10) {
                    xVar.f2232a.setBackgroundResource(R.color.item_channel_bg);
                    break;
                } else {
                    xVar.f2232a.setBackgroundResource(R.drawable.live_teim_focus_bg);
                    break;
                }
            case 2:
                z zVar = (z) this.f4206p;
                if (!z10) {
                    zVar.f2232a.setBackgroundResource(R.color.item_channel_bg);
                    break;
                } else {
                    zVar.f2232a.setBackgroundResource(R.drawable.live_teim_focus_bg);
                    break;
                }
            case 3:
                d0 d0Var = (d0) this.f4206p;
                if (!z10) {
                    d0Var.f2232a.setBackgroundResource(R.color.trans_parent);
                    break;
                } else {
                    d0Var.f2232a.setBackgroundResource(R.drawable.live_teim_focus_bg);
                    break;
                }
            default:
                a1 a1Var = (a1) this.f4206p;
                if (!z10) {
                    a1Var.f2232a.setBackgroundResource(R.color.trans_parent);
                    break;
                } else {
                    a1Var.f2232a.setBackgroundResource(R.drawable.round_yellow_border);
                    break;
                }
        }
    }
}
