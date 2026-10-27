package u1;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends AudioTrack$StreamEventCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x4.m f12294a;

    public y(x4.m mVar) {
        this.f12294a = mVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i10) {
        z zVar;
        p4.p pVar;
        s1.d0 d0Var;
        if (audioTrack.equals(((z) this.f12294a.f13566r).f12331w) && (pVar = (zVar = (z) this.f12294a.f13566r).f12327s) != null && zVar.W && (d0Var = ((b0) pVar.f9953p).U) != null) {
            d0Var.a();
        }
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        if (audioTrack.equals(((z) this.f12294a.f13566r).f12331w)) {
            ((z) this.f12294a.f13566r).V = true;
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        z zVar;
        p4.p pVar;
        s1.d0 d0Var;
        if (audioTrack.equals(((z) this.f12294a.f13566r).f12331w) && (pVar = (zVar = (z) this.f12294a.f13566r).f12327s) != null && zVar.W && (d0Var = ((b0) pVar.f9953p).U) != null) {
            d0Var.a();
        }
    }
}
