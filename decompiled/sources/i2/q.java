package i2;

import android.util.Base64;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements n9.h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6277o;

    @Override // n9.h
    public final Object get() {
        switch (this.f6277o) {
            case 0:
                try {
                    return Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                } catch (Exception e7) {
                    throw new IllegalStateException(e7);
                }
            case 1:
                throw new IllegalStateException();
            case 2:
                return new s1.i();
            default:
                byte[] bArr = new byte[12];
                t1.q.f11838i.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
        }
    }
}
