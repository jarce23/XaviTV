package a6;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w implements r5.d {
    @Override // r5.d
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // r5.d
    public final int b(ByteBuffer byteBuffer, u5.f fVar) {
        AtomicReference atomicReference = m6.b.f9006a;
        return c(new m6.a(byteBuffer), fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0018 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // r5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(java.io.InputStream r1, u5.f r2) {
        /*
            r0 = this;
            w0.g r2 = new w0.g
            r2.<init>(r1)
            java.lang.String r1 = "Orientation"
            w0.c r1 = r2.c(r1)
            if (r1 != 0) goto Le
            goto L15
        Le:
            java.nio.ByteOrder r2 = r2.f12745f     // Catch: java.lang.NumberFormatException -> L15
            int r1 = r1.e(r2)     // Catch: java.lang.NumberFormatException -> L15
            goto L16
        L15:
            r1 = 1
        L16:
            if (r1 != 0) goto L19
            r1 = -1
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.w.c(java.io.InputStream, u5.f):int");
    }

    @Override // r5.d
    public final boolean d(ByteBuffer byteBuffer, u5.f fVar) {
        return false;
    }

    @Override // r5.d
    public final ImageHeaderParser$ImageType e(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // r5.d
    public final boolean f(InputStream inputStream, u5.f fVar) {
        return false;
    }
}
