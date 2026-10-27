package androidx.mediarouter.app;

import android.widget.SeekBar;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final h f1381o = new h(1, this);

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ s f1382p;

    public q(s sVar) {
        this.f1382p = sVar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (z10) {
            w3.z zVar = (w3.z) seekBar.getTag();
            int i11 = s.D0;
            zVar.j(i10);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        s sVar = this.f1382p;
        if (sVar.f1385a0 != null) {
            sVar.Y.removeCallbacks(this.f1381o);
        }
        sVar.f1385a0 = (w3.z) seekBar.getTag();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.f1382p.Y.postDelayed(this.f1381o, 500L);
    }
}
