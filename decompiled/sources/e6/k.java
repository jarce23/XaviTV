package e6;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import okhttp3.internal.http2.Http2;
import t5.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements r5.j {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4666a;

    /* renamed from: b, reason: collision with root package name */
    public final b f4667b;

    /* renamed from: c, reason: collision with root package name */
    public final u5.f f4668c;

    public k(ArrayList arrayList, b bVar, u5.f fVar) {
        this.f4666a = arrayList;
        this.f4667b = bVar;
        this.f4668c = fVar;
    }

    @Override // r5.j
    public final boolean a(Object obj, r5.h hVar) {
        return !((Boolean) hVar.c(j.f4665b)).booleanValue() && com.bumptech.glide.f.l(this.f4666a, (InputStream) obj, this.f4668c) == ImageHeaderParser$ImageType.GIF;
    }

    @Override // r5.j
    public final y b(Object obj, int i10, int i11, r5.h hVar) {
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr2 = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e7) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e7);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.f4667b.b(ByteBuffer.wrap(bArr), i10, i11, hVar);
    }
}
