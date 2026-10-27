package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f617d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f618a;

    /* renamed from: b, reason: collision with root package name */
    public final x4.i f619b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f620c = 0;

    public z(x4.i iVar, int i10) {
        this.f619b = iVar;
        this.f618a = i10;
    }

    public final int a(int i10) {
        u0.a b2 = b();
        int a10 = b2.a(16);
        if (a10 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) b2.f8748r;
        int i11 = a10 + b2.f8745o;
        return byteBuffer.getInt((i10 * 4) + byteBuffer.getInt(i11) + i11 + 4);
    }

    public final u0.a b() {
        ThreadLocal threadLocal = f617d;
        u0.a aVar = (u0.a) threadLocal.get();
        if (aVar == null) {
            aVar = new u0.a();
            threadLocal.set(aVar);
        }
        u0.b bVar = (u0.b) this.f619b.f13553p;
        int a10 = bVar.a(6);
        if (a10 != 0) {
            int i10 = a10 + bVar.f8745o;
            int i11 = (this.f618a * 4) + ((ByteBuffer) bVar.f8748r).getInt(i10) + i10 + 4;
            int i12 = ((ByteBuffer) bVar.f8748r).getInt(i11) + i11;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f8748r;
            aVar.f8748r = byteBuffer;
            if (byteBuffer != null) {
                aVar.f8745o = i12;
                int i13 = i12 - byteBuffer.getInt(i12);
                aVar.f8746p = i13;
                aVar.f8747q = ((ByteBuffer) aVar.f8748r).getShort(i13);
                return aVar;
            }
            aVar.f8745o = 0;
            aVar.f8746p = 0;
            aVar.f8747q = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        u0.a b2 = b();
        int a10 = b2.a(4);
        sb2.append(Integer.toHexString(a10 != 0 ? ((ByteBuffer) b2.f8748r).getInt(a10 + b2.f8745o) : 0));
        sb2.append(", codepoints:");
        u0.a b10 = b();
        int a11 = b10.a(16);
        if (a11 != 0) {
            int i11 = a11 + b10.f8745o;
            i10 = ((ByteBuffer) b10.f8748r).getInt(((ByteBuffer) b10.f8748r).getInt(i11) + i11);
        } else {
            i10 = 0;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            sb2.append(Integer.toHexString(a(i12)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
