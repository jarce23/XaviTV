package androidx.mediarouter.app;

import android.widget.SeekBar;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ n0 f1343o;

    public m0(n0 n0Var) {
        this.f1343o = n0Var;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (z10) {
            w3.z zVar = (w3.z) seekBar.getTag();
            e0 e0Var = (e0) this.f1343o.J.get(zVar.f13071c);
            if (e0Var != null) {
                e0Var.s(i10 == 0);
            }
            zVar.j(i10);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        n0 n0Var = this.f1343o;
        if (n0Var.K != null) {
            n0Var.F.removeMessages(2);
        }
        n0Var.K = (w3.z) seekBar.getTag();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.f1343o.F.sendEmptyMessageDelayed(2, 500L);
    }
}
