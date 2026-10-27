package a6;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends f {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f67b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(r5.e.f10789a);

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f67b);
    }

    @Override // a6.f
    public final Bitmap c(u5.a aVar, Bitmap bitmap, int i10, int i11) {
        Paint paint = g0.f59a;
        if (bitmap.getWidth() > i10 || bitmap.getHeight() > i11) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return g0.b(aVar, bitmap, i10, i11);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // r5.e
    public final int hashCode() {
        return -670243078;
    }
}
