package u1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends j1.h {

    /* renamed from: n, reason: collision with root package name */
    public int f12180n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12181o;

    /* renamed from: p, reason: collision with root package name */
    public int f12182p;

    /* renamed from: q, reason: collision with root package name */
    public long f12183q;

    /* renamed from: s, reason: collision with root package name */
    public byte[] f12185s;

    /* renamed from: v, reason: collision with root package name */
    public byte[] f12188v;

    /* renamed from: r, reason: collision with root package name */
    public int f12184r = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f12186t = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f12187u = 0;

    /* renamed from: l, reason: collision with root package name */
    public final long f12178l = 100000;

    /* renamed from: i, reason: collision with root package name */
    public final float f12175i = 0.2f;

    /* renamed from: m, reason: collision with root package name */
    public final long f12179m = 2000000;

    /* renamed from: k, reason: collision with root package name */
    public final int f12177k = 10;

    /* renamed from: j, reason: collision with root package name */
    public final short f12176j = 1024;

    public d0() {
        byte[] bArr = l1.a0.f8069c;
        this.f12185s = bArr;
        this.f12188v = bArr;
    }

    @Override // j1.h, j1.g
    public final boolean a() {
        return super.a() && this.f12181o;
    }

    @Override // j1.g
    public final void f(ByteBuffer byteBuffer) {
        int limit;
        int position;
        while (byteBuffer.hasRemaining() && !this.g.hasRemaining()) {
            int i10 = this.f12182p;
            short s10 = this.f12176j;
            if (i10 == 0) {
                int limit2 = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit2, byteBuffer.position() + this.f12185s.length));
                int limit3 = byteBuffer.limit() - 1;
                while (true) {
                    if (limit3 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(limit3) << 8) | (byteBuffer.get(limit3 - 1) & 255)) > s10) {
                        int i11 = this.f12180n;
                        position = ((limit3 / i11) * i11) + i11;
                        break;
                    }
                    limit3 -= 2;
                }
                if (position == byteBuffer.position()) {
                    this.f12182p = 1;
                } else {
                    byteBuffer.limit(Math.min(position, byteBuffer.capacity()));
                    k(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(limit2);
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException();
                }
                l1.d.g(this.f12186t < this.f12185s.length);
                int limit4 = byteBuffer.limit();
                int position2 = byteBuffer.position() + 1;
                while (true) {
                    if (position2 >= byteBuffer.limit()) {
                        limit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(position2) << 8) | (byteBuffer.get(position2 - 1) & 255)) > s10) {
                        int i12 = this.f12180n;
                        limit = (position2 / i12) * i12;
                        break;
                    }
                    position2 += 2;
                }
                int position3 = limit - byteBuffer.position();
                int i13 = this.f12186t;
                int i14 = this.f12187u;
                int i15 = i13 + i14;
                byte[] bArr = this.f12185s;
                if (i15 < bArr.length) {
                    i13 = bArr.length;
                } else {
                    i15 = i14 - (bArr.length - i13);
                }
                int i16 = i13 - i15;
                boolean z10 = limit < limit4;
                int min = Math.min(position3, i16);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuffer.get(this.f12185s, i15, min);
                int i17 = this.f12187u + min;
                this.f12187u = i17;
                l1.d.g(i17 <= this.f12185s.length);
                boolean z11 = z10 && position3 < i16;
                m(z11);
                if (z11) {
                    this.f12182p = 0;
                    this.f12184r = 0;
                }
                byteBuffer.limit(limit4);
            }
        }
    }

    @Override // j1.h
    public final j1.e g(j1.e eVar) {
        if (eVar.f6953c == 2) {
            return eVar.f6951a == -1 ? j1.e.f6950e : eVar;
        }
        throw new j1.f(eVar);
    }

    @Override // j1.h
    public final void h() {
        if (a()) {
            int i10 = this.f6956b.f6952b * 2;
            this.f12180n = i10;
            int i11 = ((((int) ((this.f12178l * r0.f6951a) / 1000000)) / 2) / i10) * i10 * 2;
            if (this.f12185s.length != i11) {
                this.f12185s = new byte[i11];
                this.f12188v = new byte[i11];
            }
        }
        this.f12182p = 0;
        this.f12183q = 0L;
        this.f12184r = 0;
        this.f12186t = 0;
        this.f12187u = 0;
    }

    @Override // j1.h
    public final void i() {
        if (this.f12187u > 0) {
            m(true);
            this.f12184r = 0;
        }
    }

    @Override // j1.h
    public final void j() {
        this.f12181o = false;
        byte[] bArr = l1.a0.f8069c;
        this.f12185s = bArr;
        this.f12188v = bArr;
    }

    public final int l(int i10) {
        int length = ((((int) ((this.f12179m * this.f6956b.f6951a) / 1000000)) - this.f12184r) * this.f12180n) - (this.f12185s.length / 2);
        l1.d.g(length >= 0);
        int min = (int) Math.min((i10 * this.f12175i) + 0.5f, length);
        int i11 = this.f12180n;
        return (min / i11) * i11;
    }

    public final void m(boolean z10) {
        int length;
        int l10;
        int i10 = this.f12187u;
        byte[] bArr = this.f12185s;
        if (i10 == bArr.length || z10) {
            if (this.f12184r == 0) {
                if (z10) {
                    n(i10, 3);
                    length = i10;
                } else {
                    l1.d.g(i10 >= bArr.length / 2);
                    length = this.f12185s.length / 2;
                    n(length, 0);
                }
                l10 = length;
            } else if (z10) {
                int length2 = i10 - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int l11 = l(length2) + (this.f12185s.length / 2);
                n(l11, 2);
                l10 = l11;
                length = length3;
            } else {
                length = i10 - (bArr.length / 2);
                l10 = l(length);
                n(l10, 1);
            }
            l1.d.f("bytesConsumed is not aligned to frame size: %s" + length, length % this.f12180n == 0);
            l1.d.g(i10 >= l10);
            this.f12187u -= length;
            int i11 = this.f12186t + length;
            this.f12186t = i11;
            this.f12186t = i11 % this.f12185s.length;
            this.f12184r = (l10 / this.f12180n) + this.f12184r;
            this.f12183q += (length - l10) / r2;
        }
    }

    public final void n(int i10, int i11) {
        if (i10 == 0) {
            return;
        }
        l1.d.b(this.f12187u >= i10);
        if (i11 == 2) {
            int i12 = this.f12186t;
            int i13 = this.f12187u;
            int i14 = i12 + i13;
            byte[] bArr = this.f12185s;
            if (i14 <= bArr.length) {
                System.arraycopy(bArr, i14 - i10, this.f12188v, 0, i10);
            } else {
                int length = i13 - (bArr.length - i12);
                if (length >= i10) {
                    System.arraycopy(bArr, length - i10, this.f12188v, 0, i10);
                } else {
                    int i15 = i10 - length;
                    System.arraycopy(bArr, bArr.length - i15, this.f12188v, 0, i15);
                    System.arraycopy(this.f12185s, 0, this.f12188v, i15, length);
                }
            }
        } else {
            int i16 = this.f12186t;
            int i17 = i16 + i10;
            byte[] bArr2 = this.f12185s;
            if (i17 <= bArr2.length) {
                System.arraycopy(bArr2, i16, this.f12188v, 0, i10);
            } else {
                int length2 = bArr2.length - i16;
                System.arraycopy(bArr2, i16, this.f12188v, 0, length2);
                System.arraycopy(this.f12185s, 0, this.f12188v, length2, i10 - length2);
            }
        }
        l1.d.a("sizeToOutput is not aligned to frame size: " + i10, i10 % this.f12180n == 0);
        l1.d.g(this.f12186t < this.f12185s.length);
        byte[] bArr3 = this.f12188v;
        l1.d.a("byteOutput size is not aligned to frame size " + i10, i10 % this.f12180n == 0);
        if (i11 != 3) {
            for (int i18 = 0; i18 < i10; i18 += 2) {
                int i19 = i18 + 1;
                int i20 = (bArr3[i19] << 8) | (bArr3[i18] & 255);
                int i21 = this.f12177k;
                if (i11 == 0) {
                    i21 = ((((i18 * 1000) / (i10 - 1)) * (i21 - 100)) / 1000) + 100;
                } else if (i11 == 2) {
                    i21 += (((i18 * 1000) * (100 - i21)) / (i10 - 1)) / 1000;
                }
                int i22 = (i20 * i21) / 100;
                if (i22 >= 32767) {
                    bArr3[i18] = -1;
                    bArr3[i19] = Byte.MAX_VALUE;
                } else if (i22 <= -32768) {
                    bArr3[i18] = 0;
                    bArr3[i19] = Byte.MIN_VALUE;
                } else {
                    bArr3[i18] = (byte) (i22 & 255);
                    bArr3[i19] = (byte) (i22 >> 8);
                }
            }
        }
        k(i10).put(bArr3, 0, i10).flip();
    }
}
