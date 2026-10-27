package z1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import x5.b0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface m {
    void a();

    void b(int i10, o4.a aVar, long j10, int i11);

    void d(Bundle bundle);

    void e(int i10, int i11, long j10, int i12);

    int f(MediaCodec.BufferInfo bufferInfo);

    void flush();

    void h(int i10);

    void i(i2.k kVar, Handler handler);

    boolean j(b0 b0Var);

    void m(int i10);

    MediaFormat o();

    void q();

    ByteBuffer r(int i10);

    void s(Surface surface);

    ByteBuffer v(int i10);

    void w(int i10, long j10);

    int x();
}
