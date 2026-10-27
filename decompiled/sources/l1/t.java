package l1;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import o9.j0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f8126d = {'\r', '\n'};

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f8127e = {'\n'};

    /* renamed from: f, reason: collision with root package name */
    public static final j0 f8128f = j0.m(5, StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);

    /* renamed from: a, reason: collision with root package name */
    public byte[] f8129a;

    /* renamed from: b, reason: collision with root package name */
    public int f8130b;

    /* renamed from: c, reason: collision with root package name */
    public int f8131c;

    public t() {
        this.f8129a = a0.f8069c;
    }

    public static int b(int i10, int i11, int i12, int i13) {
        byte b2 = (byte) i12;
        return com.google.android.gms.internal.cast.n.f((byte) 0, j1.c.e(((i10 & 7) << 2) | ((i11 & 48) >> 4)), j1.c.e(((((byte) i11) & 15) << 4) | ((b2 & 60) >> 2)), j1.c.e(((b2 & 3) << 6) | (((byte) i13) & 63)));
    }

    public static int d(Charset charset) {
        d.a("Unsupported charset: " + charset, f8128f.contains(charset));
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    public static boolean e(byte b2) {
        return (b2 & 192) == 128;
    }

    public final int A() {
        int j10 = j();
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalStateException(android.support.v4.media.d.m(j10, "Top bit not zero: "));
    }

    public final long B() {
        long q10 = q();
        if (q10 >= 0) {
            return q10;
        }
        throw new IllegalStateException(android.support.v4.media.d.n(q10, "Top bit not zero: "));
    }

    public final int C() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        int i11 = i10 + 1;
        this.f8130b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.f8130b = i10 + 2;
        return (bArr[i11] & 255) | i12;
    }

    public final long D() {
        int i10;
        int i11;
        long j10 = this.f8129a[this.f8130b];
        int i12 = 7;
        while (true) {
            if (i12 < 0) {
                break;
            }
            if (((1 << i12) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= r6 - 1;
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 == 0) {
            throw new NumberFormatException(android.support.v4.media.d.n(j10, "Invalid UTF-8 sequence first byte: "));
        }
        for (i10 = 1; i10 < i11; i10++) {
            if ((this.f8129a[this.f8130b + i10] & 192) != 128) {
                throw new NumberFormatException(android.support.v4.media.d.n(j10, "Invalid UTF-8 sequence continuation byte: "));
            }
            j10 = (j10 << 6) | (r3 & 63);
        }
        this.f8130b += i11;
        return j10;
    }

    public final Charset E() {
        if (a() >= 3) {
            byte[] bArr = this.f8129a;
            int i10 = this.f8130b;
            if (bArr[i10] == -17 && bArr[i10 + 1] == -69 && bArr[i10 + 2] == -65) {
                this.f8130b = i10 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f8129a;
        int i11 = this.f8130b;
        byte b2 = bArr2[i11];
        if (b2 == -2 && bArr2[i11 + 1] == -1) {
            this.f8130b = i11 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b2 != -1 || bArr2[i11 + 1] != -2) {
            return null;
        }
        this.f8130b = i11 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final void F(int i10) {
        byte[] bArr = this.f8129a;
        if (bArr.length < i10) {
            bArr = new byte[i10];
        }
        G(i10, bArr);
    }

    public final void G(int i10, byte[] bArr) {
        this.f8129a = bArr;
        this.f8131c = i10;
        this.f8130b = 0;
    }

    public final void H(int i10) {
        d.b(i10 >= 0 && i10 <= this.f8129a.length);
        this.f8131c = i10;
    }

    public final void I(int i10) {
        d.b(i10 >= 0 && i10 <= this.f8131c);
        this.f8130b = i10;
    }

    public final void J(int i10) {
        I(this.f8130b + i10);
    }

    public final int a() {
        return Math.max(this.f8131c - this.f8130b, 0);
    }

    public final void c(int i10) {
        byte[] bArr = this.f8129a;
        if (i10 > bArr.length) {
            this.f8129a = Arrays.copyOf(bArr, i10);
        }
    }

    public final char f(int i10, ByteOrder byteOrder) {
        byte b2;
        byte b10;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f8129a;
            int i11 = this.f8130b + i10;
            b2 = bArr[i11];
            b10 = bArr[i11 + 1];
        } else {
            byte[] bArr2 = this.f8129a;
            int i12 = this.f8130b + i10;
            b2 = bArr2[i12 + 1];
            b10 = bArr2[i12];
        }
        return (char) ((b2 << 8) | (b10 & 255));
    }

    public final int g(Charset charset) {
        int i10;
        int i11;
        d.a("Unsupported charset: " + charset, f8128f.contains(charset));
        if (a() < d(charset)) {
            throw new IndexOutOfBoundsException("position=" + this.f8130b + ", limit=" + this.f8131c);
        }
        int i12 = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b2 = this.f8129a[this.f8130b];
            if ((b2 & 128) == 0) {
                i10 = b2 & 255;
                return (i10 << 8) | i12;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b10 = this.f8129a[this.f8130b];
            int i13 = (b10 & 128) == 0 ? 1 : ((b10 & 224) == 192 && a() >= 2 && e(this.f8129a[this.f8130b + 1])) ? 2 : ((this.f8129a[this.f8130b] & 240) == 224 && a() >= 3 && e(this.f8129a[this.f8130b + 1]) && e(this.f8129a[this.f8130b + 2])) ? 3 : ((this.f8129a[this.f8130b] & 248) == 240 && a() >= 4 && e(this.f8129a[this.f8130b + 1]) && e(this.f8129a[this.f8130b + 2]) && e(this.f8129a[this.f8130b + 3])) ? 4 : 0;
            if (i13 == 1) {
                i11 = this.f8129a[this.f8130b] & 255;
            } else if (i13 == 2) {
                byte[] bArr = this.f8129a;
                int i14 = this.f8130b;
                i11 = b(0, 0, bArr[i14], bArr[i14 + 1]);
            } else {
                if (i13 != 3) {
                    if (i13 == 4) {
                        byte[] bArr2 = this.f8129a;
                        int i15 = this.f8130b;
                        i11 = b(bArr2[i15], bArr2[i15 + 1], bArr2[i15 + 2], bArr2[i15 + 3]);
                    }
                    return 0;
                }
                byte[] bArr3 = this.f8129a;
                int i16 = this.f8130b;
                i11 = b(0, bArr3[i16] & 15, bArr3[i16 + 1], bArr3[i16 + 2]);
            }
            i12 = i13;
            i10 = i11;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char f10 = f(0, byteOrder);
            if (!Character.isHighSurrogate(f10) || a() < 4) {
                i10 = f10;
                i12 = 2;
            } else {
                i10 = Character.toCodePoint(f10, f(2, byteOrder));
                i12 = 4;
            }
        }
        return (i10 << 8) | i12;
    }

    public final void h(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.f8129a, this.f8130b, bArr, i10, i11);
        this.f8130b += i11;
    }

    public final char i(Charset charset, char[] cArr) {
        int g;
        if (a() >= d(charset) && (g = g(charset)) != 0) {
            long j10 = g >>> 8;
            com.bumptech.glide.e.f(j10, (j10 >> 32) == 0, "out of range: %s");
            int i10 = (int) j10;
            if (!Character.isSupplementaryCodePoint(i10)) {
                long j11 = i10;
                char c10 = (char) j11;
                com.bumptech.glide.e.f(j11, ((long) c10) == j11, "Out of range: %s");
                for (char c11 : cArr) {
                    if (c11 == c10) {
                        this.f8130b = com.google.android.gms.internal.cast.n.c(g & 255) + this.f8130b;
                        return c10;
                    }
                }
            }
        }
        return (char) 0;
    }

    public final int j() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        int i11 = i10 + 1;
        this.f8130b = i11;
        int i12 = (bArr[i10] & 255) << 24;
        int i13 = i10 + 2;
        this.f8130b = i13;
        int i14 = ((bArr[i11] & 255) << 16) | i12;
        int i15 = i10 + 3;
        this.f8130b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        this.f8130b = i10 + 4;
        return (bArr[i15] & 255) | i16;
    }

    public final String k(Charset charset) {
        int i10;
        d.a("Unsupported charset: " + charset, f8128f.contains(charset));
        if (a() == 0) {
            return null;
        }
        Charset charset2 = StandardCharsets.US_ASCII;
        if (!charset.equals(charset2)) {
            E();
        }
        if (charset.equals(StandardCharsets.UTF_8) || charset.equals(charset2)) {
            i10 = 1;
        } else {
            if (!charset.equals(StandardCharsets.UTF_16) && !charset.equals(StandardCharsets.UTF_16LE) && !charset.equals(StandardCharsets.UTF_16BE)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i10 = 2;
        }
        int i11 = this.f8130b;
        while (true) {
            int i12 = this.f8131c;
            if (i11 >= i12 - (i10 - 1)) {
                i11 = i12;
                break;
            }
            if ((charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) && a0.M(this.f8129a[i11])) {
                break;
            }
            if (charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) {
                byte[] bArr = this.f8129a;
                if (bArr[i11] == 0 && a0.M(bArr[i11 + 1])) {
                    break;
                }
            }
            if (charset.equals(StandardCharsets.UTF_16LE)) {
                byte[] bArr2 = this.f8129a;
                if (bArr2[i11 + 1] == 0 && a0.M(bArr2[i11])) {
                    break;
                }
            }
            i11 += i10;
        }
        String u10 = u(i11 - this.f8130b, charset);
        if (this.f8130b != this.f8131c && i(charset, f8126d) == '\r') {
            i(charset, f8127e);
        }
        return u10;
    }

    public final int l() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        int i11 = i10 + 1;
        this.f8130b = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.f8130b = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        int i15 = i10 + 3;
        this.f8130b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.f8130b = i10 + 4;
        return ((bArr[i15] & 255) << 24) | i16;
    }

    public final long m() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        this.f8130b = i10 + 1;
        this.f8130b = i10 + 2;
        this.f8130b = i10 + 3;
        long j10 = (bArr[i10] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f8130b = i10 + 4;
        long j11 = j10 | ((bArr[r8] & 255) << 24);
        this.f8130b = i10 + 5;
        long j12 = j11 | ((bArr[r7] & 255) << 32);
        this.f8130b = i10 + 6;
        long j13 = j12 | ((bArr[r8] & 255) << 40);
        this.f8130b = i10 + 7;
        long j14 = j13 | ((bArr[r7] & 255) << 48);
        this.f8130b = i10 + 8;
        return ((bArr[r8] & 255) << 56) | j14;
    }

    public final long n() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        this.f8130b = i10 + 1;
        this.f8130b = i10 + 2;
        long j10 = (bArr[i10] & 255) | ((bArr[r2] & 255) << 8);
        this.f8130b = i10 + 3;
        long j11 = j10 | ((bArr[r7] & 255) << 16);
        this.f8130b = i10 + 4;
        return ((bArr[r2] & 255) << 24) | j11;
    }

    public final int o() {
        int l10 = l();
        if (l10 >= 0) {
            return l10;
        }
        throw new IllegalStateException(android.support.v4.media.d.m(l10, "Top bit not zero: "));
    }

    public final int p() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        int i11 = i10 + 1;
        this.f8130b = i11;
        int i12 = bArr[i10] & 255;
        this.f8130b = i10 + 2;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public final long q() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        this.f8130b = i10 + 1;
        this.f8130b = i10 + 2;
        long j10 = ((bArr[i10] & 255) << 56) | ((bArr[r2] & 255) << 48);
        this.f8130b = i10 + 3;
        long j11 = j10 | ((bArr[r7] & 255) << 40);
        this.f8130b = i10 + 4;
        long j12 = j11 | ((bArr[r2] & 255) << 32);
        this.f8130b = i10 + 5;
        long j13 = j12 | ((bArr[r7] & 255) << 24);
        this.f8130b = i10 + 6;
        long j14 = j13 | ((bArr[r2] & 255) << 16);
        this.f8130b = i10 + 7;
        long j15 = j14 | ((bArr[r7] & 255) << 8);
        this.f8130b = i10 + 8;
        return (bArr[r2] & 255) | j15;
    }

    public final String r() {
        if (a() == 0) {
            return null;
        }
        int i10 = this.f8130b;
        while (i10 < this.f8131c && this.f8129a[i10] != 0) {
            i10++;
        }
        byte[] bArr = this.f8129a;
        int i11 = this.f8130b;
        int i12 = a0.f8067a;
        String str = new String(bArr, i11, i10 - i11, StandardCharsets.UTF_8);
        this.f8130b = i10;
        if (i10 < this.f8131c) {
            this.f8130b = i10 + 1;
        }
        return str;
    }

    public final String s(int i10) {
        if (i10 == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        int i11 = this.f8130b;
        int i12 = (i11 + i10) - 1;
        int i13 = (i12 >= this.f8131c || this.f8129a[i12] != 0) ? i10 : i10 - 1;
        byte[] bArr = this.f8129a;
        int i14 = a0.f8067a;
        String str = new String(bArr, i11, i13, StandardCharsets.UTF_8);
        this.f8130b += i10;
        return str;
    }

    public final short t() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        int i11 = i10 + 1;
        this.f8130b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.f8130b = i10 + 2;
        return (short) ((bArr[i11] & 255) | i12);
    }

    public final String u(int i10, Charset charset) {
        String str = new String(this.f8129a, this.f8130b, i10, charset);
        this.f8130b += i10;
        return str;
    }

    public final int v() {
        return (w() << 21) | (w() << 14) | (w() << 7) | w();
    }

    public final int w() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        this.f8130b = i10 + 1;
        return bArr[i10] & 255;
    }

    public final int x() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        int i11 = i10 + 1;
        this.f8130b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.f8130b = i10 + 2;
        int i13 = (bArr[i11] & 255) | i12;
        this.f8130b = i10 + 4;
        return i13;
    }

    public final long y() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        this.f8130b = i10 + 1;
        this.f8130b = i10 + 2;
        long j10 = ((bArr[i10] & 255) << 24) | ((bArr[r2] & 255) << 16);
        this.f8130b = i10 + 3;
        long j11 = j10 | ((bArr[r7] & 255) << 8);
        this.f8130b = i10 + 4;
        return (bArr[r2] & 255) | j11;
    }

    public final int z() {
        byte[] bArr = this.f8129a;
        int i10 = this.f8130b;
        int i11 = i10 + 1;
        this.f8130b = i11;
        int i12 = (bArr[i10] & 255) << 16;
        int i13 = i10 + 2;
        this.f8130b = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.f8130b = i10 + 3;
        return (bArr[i13] & 255) | i14;
    }

    public t(int i10) {
        this.f8129a = new byte[i10];
        this.f8131c = i10;
    }

    public t(byte[] bArr) {
        this.f8129a = bArr;
        this.f8131c = bArr.length;
    }

    public t(int i10, byte[] bArr) {
        this.f8129a = bArr;
        this.f8131c = i10;
    }
}
