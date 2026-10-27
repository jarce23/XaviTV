package a6;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends f {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f106b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(r5.e.f10789a);

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f106b);
    }

    @Override // a6.f
    public final Bitmap c(u5.a aVar, Bitmap bitmap, int i10, int i11) {
        return g0.b(aVar, bitmap, i10, i11);
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        return obj instanceof x;
    }

    @Override // r5.e
    public final int hashCode() {
        return 1572326941;
    }
}
