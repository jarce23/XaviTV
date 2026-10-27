package f1;

import android.media.VolumeProvider;
import androidx.emoji2.text.t;
import w3.u;
import w3.w;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends VolumeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f4864a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(t tVar, int i10, int i11, int i12, String str) {
        super(i10, i11, i12, str);
        this.f4864a = tVar;
    }

    @Override // android.media.VolumeProvider
    public final void onAdjustVolume(int i10) {
        t tVar = this.f4864a;
        ((w) ((m) tVar.f601f).f13566r).f13042n.post(new u(tVar, i10, 1));
    }

    @Override // android.media.VolumeProvider
    public final void onSetVolumeTo(int i10) {
        t tVar = this.f4864a;
        ((w) ((m) tVar.f601f).f13566r).f13042n.post(new u(tVar, i10, 0));
    }
}
