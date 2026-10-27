package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SpeechOrbView extends SearchOrbView {
    public final float G;
    public m0 H;
    public m0 I;
    public int J;
    public boolean K;

    public SpeechOrbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.J = 0;
        this.K = false;
        Resources resources = context.getResources();
        this.G = resources.getFraction(R.fraction.lb_search_bar_speech_orb_max_level_zoom, 1, 1);
        this.I = new m0(resources.getColor(R.color.lb_speech_orb_not_recording), resources.getColor(R.color.lb_speech_orb_not_recording_pulsed), resources.getColor(R.color.lb_speech_orb_not_recording_icon));
        this.H = new m0(resources.getColor(R.color.lb_speech_orb_recording), resources.getColor(R.color.lb_speech_orb_recording), 0);
        c();
    }

    public final void c() {
        setOrbColors(this.I);
        setOrbIcon(getResources().getDrawable(R.drawable.lb_ic_search_mic_out));
        a(hasFocus());
        View view = this.f965q;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.K = false;
    }

    @Override // androidx.leanback.widget.SearchOrbView
    public int getLayoutResourceId() {
        return R.layout.lb_speech_orb;
    }

    public void setListeningOrbColors(m0 m0Var) {
        this.H = m0Var;
    }

    public void setNotListeningOrbColors(m0 m0Var) {
        this.I = m0Var;
    }

    public void setSoundLevel(int i10) {
        if (this.K) {
            int i11 = this.J;
            if (i10 > i11) {
                this.J = ((i10 - i11) / 2) + i11;
            } else {
                this.J = (int) (i11 * 0.7f);
            }
            float focusedZoom = (((this.G - getFocusedZoom()) * this.J) / 100.0f) + 1.0f;
            View view = this.f965q;
            view.setScaleX(focusedZoom);
            view.setScaleY(focusedZoom);
        }
    }
}
