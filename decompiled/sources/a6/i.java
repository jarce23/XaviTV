package a6;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends f {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f65b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(r5.e.f10789a);

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f65b);
    }

    @Override // a6.f
    public final Bitmap c(u5.a aVar, Bitmap bitmap, int i10, int i11) {
        float width;
        float height;
        Paint paint = g0.f59a;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f10 = 0.0f;
        if (bitmap.getWidth() * i11 > bitmap.getHeight() * i10) {
            width = i11 / bitmap.getHeight();
            f10 = (i10 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i10 / bitmap.getWidth();
            height = (i11 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f10 + 0.5f), (int) (height + 0.5f));
        Bitmap e7 = aVar.e(i10, i11, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        e7.setHasAlpha(bitmap.hasAlpha());
        g0.a(bitmap, e7, matrix);
        return e7;
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // r5.e
    public final int hashCode() {
        return -599754482;
    }
}
