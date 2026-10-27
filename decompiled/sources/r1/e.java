package r1;

import i1.b0;
import i1.p;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class e extends m1.e {

    /* renamed from: q, reason: collision with root package name */
    public p f10408q;

    /* renamed from: r, reason: collision with root package name */
    public final o4.a f10409r = new o4.a();

    /* renamed from: s, reason: collision with root package name */
    public ByteBuffer f10410s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10411t;

    /* renamed from: u, reason: collision with root package name */
    public long f10412u;

    /* renamed from: v, reason: collision with root package name */
    public ByteBuffer f10413v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10414w;

    static {
        b0.a("media3.decoder");
    }

    public e(int i10) {
        this.f10414w = i10;
    }

    public void j() {
        this.f8759p = 0;
        ByteBuffer byteBuffer = this.f10410s;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f10413v;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f10411t = false;
    }

    public final ByteBuffer k(int i10) {
        int i11 = this.f10414w;
        if (i11 == 1) {
            return ByteBuffer.allocate(i10);
        }
        if (i11 == 2) {
            return ByteBuffer.allocateDirect(i10);
        }
        ByteBuffer byteBuffer = this.f10410s;
        throw new d("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i10 + ")");
    }

    public final void m(int i10) {
        ByteBuffer byteBuffer = this.f10410s;
        if (byteBuffer == null) {
            this.f10410s = k(i10);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i11 = i10 + position;
        if (capacity >= i11) {
            this.f10410s = byteBuffer;
            return;
        }
        ByteBuffer k10 = k(i11);
        k10.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            k10.put(byteBuffer);
        }
        this.f10410s = k10;
    }

    public final void n() {
        ByteBuffer byteBuffer = this.f10410s;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f10413v;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }
}
