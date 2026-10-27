package rb;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface n extends s0, ReadableByteChannel {
    void D(long j10);

    long H();

    String I(Charset charset);

    InputStream J();

    long L(long j10, o oVar);

    l b();

    int e(h0 h0Var);

    o h();

    o i(long j10);

    boolean k(long j10);

    long l(l lVar);

    String p();

    m0 peek();

    byte[] r();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j10);

    boolean t();

    boolean u(long j10, o oVar);

    long w();

    String y(long j10);

    void z(l lVar, long j10);
}
