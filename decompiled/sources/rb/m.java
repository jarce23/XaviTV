package rb;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface m extends q0, WritableByteChannel {
    m B(o oVar);

    m E(String str);

    m F(long j10);

    OutputStream G();

    l b();

    long d(s0 s0Var);

    m f(String str, int i10, int i11);

    @Override // rb.q0, java.io.Flushable
    void flush();

    m g(long j10);

    m m(int i10);

    m v();

    m write(byte[] bArr);

    m write(byte[] bArr, int i10, int i11);

    m writeByte(int i10);

    m writeInt(int i10);

    m writeShort(int i10);
}
