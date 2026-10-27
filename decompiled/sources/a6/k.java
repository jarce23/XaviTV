package a6;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements m, r5.f, com.bumptech.glide.load.data.f {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f68o;

    /* renamed from: p, reason: collision with root package name */
    public final ByteBuffer f69p;

    public k(int i10) {
        this.f68o = i10;
        switch (i10) {
            case 2:
                this.f69p = ByteBuffer.allocate(4);
                break;
            default:
                this.f69p = ByteBuffer.allocate(8);
                break;
        }
    }

    private final void e(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l10 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.f69p) {
            this.f69p.position(0);
            messageDigest.update(this.f69p.putLong(l10.longValue()).array());
        }
    }

    @Override // com.bumptech.glide.load.data.f
    public Object a() {
        ByteBuffer byteBuffer = this.f69p;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // a6.m
    public short c() {
        ByteBuffer byteBuffer = this.f69p;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new l();
    }

    @Override // r5.f
    public void d(byte[] bArr, Object obj, MessageDigest messageDigest) {
        switch (this.f68o) {
            case 1:
                e(bArr, obj, messageDigest);
                return;
            default:
                Integer num = (Integer) obj;
                if (num == null) {
                    return;
                }
                messageDigest.update(bArr);
                synchronized (this.f69p) {
                    this.f69p.position(0);
                    messageDigest.update(this.f69p.putInt(num.intValue()).array());
                }
                return;
        }
    }

    @Override // a6.m
    public int f() {
        return (c() << 8) | c();
    }

    @Override // a6.m
    public int g(int i10, byte[] bArr) {
        ByteBuffer byteBuffer = this.f69p;
        int min = Math.min(i10, byteBuffer.remaining());
        if (min == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, min);
        return min;
    }

    @Override // a6.m
    public long skip(long j10) {
        ByteBuffer byteBuffer = this.f69p;
        int min = (int) Math.min(byteBuffer.remaining(), j10);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    public k(int i10, ByteBuffer byteBuffer) {
        this.f68o = i10;
        switch (i10) {
            case 3:
                this.f69p = byteBuffer;
                break;
            default:
                this.f69p = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.f
    public void b() {
    }
}
