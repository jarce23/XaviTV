package h;

import android.graphics.drawable.Animatable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends com.bumptech.glide.e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5469c;

    /* renamed from: d, reason: collision with root package name */
    public final Animatable f5470d;

    public /* synthetic */ a(Animatable animatable, int i10) {
        this.f5469c = i10;
        this.f5470d = animatable;
    }

    @Override // com.bumptech.glide.e
    public final void v() {
        switch (this.f5469c) {
            case 0:
                this.f5470d.start();
                break;
            default:
                ((m4.d) this.f5470d).start();
                break;
        }
    }

    @Override // com.bumptech.glide.e
    public final void w() {
        switch (this.f5469c) {
            case 0:
                this.f5470d.stop();
                break;
            default:
                ((m4.d) this.f5470d).stop();
                break;
        }
    }
}
