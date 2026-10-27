package r5;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface d {
    ImageHeaderParser$ImageType a(ByteBuffer byteBuffer);

    int b(ByteBuffer byteBuffer, u5.f fVar);

    int c(InputStream inputStream, u5.f fVar);

    boolean d(ByteBuffer byteBuffer, u5.f fVar);

    ImageHeaderParser$ImageType e(InputStream inputStream);

    boolean f(InputStream inputStream, u5.f fVar);
}
