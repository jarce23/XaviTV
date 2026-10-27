package z1;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13954a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i2.k f13955b;

    public /* synthetic */ b(m mVar, i2.k kVar, int i10) {
        this.f13954a = i10;
        this.f13955b = kVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
        switch (this.f13954a) {
            case 0:
                i2.k kVar = this.f13955b;
                Handler handler = kVar.f6223o;
                if (Build.VERSION.SDK_INT >= 30) {
                    kVar.a(j10);
                    break;
                } else {
                    handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 0, (int) (j10 >> 32), (int) j10));
                    break;
                }
            default:
                i2.k kVar2 = this.f13955b;
                Handler handler2 = kVar2.f6223o;
                if (Build.VERSION.SDK_INT >= 30) {
                    kVar2.a(j10);
                    break;
                } else {
                    handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 0, (int) (j10 >> 32), (int) j10));
                    break;
                }
        }
    }
}
