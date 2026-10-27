package rb;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements n, m, Cloneable, ByteChannel {

    /* renamed from: o, reason: collision with root package name */
    public n0 f11034o;

    /* renamed from: p, reason: collision with root package name */
    public long f11035p;

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m B(o oVar) {
        W(oVar);
        return this;
    }

    @Override // rb.n
    public final void D(long j10) {
        if (this.f11035p < j10) {
            throw new EOFException();
        }
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m E(String str) {
        e0(str);
        return this;
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m F(long j10) {
        Y(j10);
        return this;
    }

    @Override // rb.m
    public final OutputStream G() {
        return new k(this, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d A[EDGE_INSN: B:40:0x008d->B:37:0x008d BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
    @Override // rb.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long H() {
        /*
            r14 = this;
            long r0 = r14.f11035p
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L94
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            rb.n0 r6 = r14.f11034o
            za.h.b(r6)
            byte[] r7 = r6.f11042a
            int r8 = r6.f11043b
            int r9 = r6.f11044c
        L16:
            if (r8 >= r9) goto L79
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L25
            r11 = 57
            if (r10 > r11) goto L25
            int r11 = r10 + (-48)
            goto L3a
        L25:
            r11 = 97
            if (r10 < r11) goto L30
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L30
            int r11 = r10 + (-87)
            goto L3a
        L30:
            r11 = 65
            if (r10 < r11) goto L65
            r11 = 70
            if (r10 > r11) goto L65
            int r11 = r10 + (-55)
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L16
        L4a:
            rb.l r0 = new rb.l
            r0.<init>()
            r0.Z(r4)
            r0.X(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.S()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L65:
            if (r0 == 0) goto L69
            r1 = 1
            goto L79
        L69:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = rb.b.i(r10)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L79:
            if (r8 != r9) goto L85
            rb.n0 r7 = r6.a()
            r14.f11034o = r7
            rb.o0.a(r6)
            goto L87
        L85:
            r6.f11043b = r8
        L87:
            if (r1 != 0) goto L8d
            rb.n0 r6 = r14.f11034o
            if (r6 != 0) goto Lb
        L8d:
            long r1 = r14.f11035p
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f11035p = r1
            return r4
        L94:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.l.H():long");
    }

    @Override // rb.n
    public final String I(Charset charset) {
        za.h.e("charset", charset);
        return R(this.f11035p, charset);
    }

    @Override // rb.n
    public final InputStream J() {
        return new j(this, 0);
    }

    public final long K(byte b2, long j10, long j11) {
        n0 n0Var;
        long j12 = 0;
        if (0 > j10 || j10 > j11) {
            throw new IllegalArgumentException(("size=" + this.f11035p + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        long j13 = this.f11035p;
        if (j11 > j13) {
            j11 = j13;
        }
        if (j10 == j11 || (n0Var = this.f11034o) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                n0Var = n0Var.g;
                za.h.b(n0Var);
                j13 -= n0Var.f11044c - n0Var.f11043b;
            }
            while (j13 < j11) {
                byte[] bArr = n0Var.f11042a;
                int min = (int) Math.min(n0Var.f11044c, (n0Var.f11043b + j11) - j13);
                for (int i10 = (int) ((n0Var.f11043b + j10) - j13); i10 < min; i10++) {
                    if (bArr[i10] == b2) {
                        return (i10 - n0Var.f11043b) + j13;
                    }
                }
                j13 += n0Var.f11044c - n0Var.f11043b;
                n0Var = n0Var.f11047f;
                za.h.b(n0Var);
                j10 = j13;
            }
            return -1L;
        }
        while (true) {
            long j14 = (n0Var.f11044c - n0Var.f11043b) + j12;
            if (j14 > j10) {
                break;
            }
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
            j12 = j14;
        }
        while (j12 < j11) {
            byte[] bArr2 = n0Var.f11042a;
            int min2 = (int) Math.min(n0Var.f11044c, (n0Var.f11043b + j11) - j12);
            for (int i11 = (int) ((n0Var.f11043b + j10) - j12); i11 < min2; i11++) {
                if (bArr2[i11] == b2) {
                    return (i11 - n0Var.f11043b) + j12;
                }
            }
            j12 += n0Var.f11044c - n0Var.f11043b;
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
            j10 = j12;
        }
        return -1L;
    }

    @Override // rb.n
    public final long L(long j10, o oVar) {
        za.h.e("bytes", oVar);
        byte[] bArr = sb.a.f11666a;
        return sb.a.a(this, oVar, 0L, j10, oVar.d());
    }

    public final long M(o oVar) {
        int i10;
        int i11;
        za.h.e("targetBytes", oVar);
        n0 n0Var = this.f11034o;
        if (n0Var == null) {
            return -1L;
        }
        long j10 = this.f11035p;
        long j11 = 0;
        if (j10 < 0) {
            while (j10 > 0) {
                n0Var = n0Var.g;
                za.h.b(n0Var);
                j10 -= n0Var.f11044c - n0Var.f11043b;
            }
            if (oVar.d() == 2) {
                byte i12 = oVar.i(0);
                byte i13 = oVar.i(1);
                while (j10 < this.f11035p) {
                    byte[] bArr = n0Var.f11042a;
                    i10 = (int) ((n0Var.f11043b + j11) - j10);
                    int i14 = n0Var.f11044c;
                    while (i10 < i14) {
                        byte b2 = bArr[i10];
                        if (b2 != i12 && b2 != i13) {
                            i10++;
                        }
                        i11 = n0Var.f11043b;
                    }
                    j11 = (n0Var.f11044c - n0Var.f11043b) + j10;
                    n0Var = n0Var.f11047f;
                    za.h.b(n0Var);
                    j10 = j11;
                }
                return -1L;
            }
            byte[] h10 = oVar.h();
            while (j10 < this.f11035p) {
                byte[] bArr2 = n0Var.f11042a;
                i10 = (int) ((n0Var.f11043b + j11) - j10);
                int i15 = n0Var.f11044c;
                while (i10 < i15) {
                    byte b10 = bArr2[i10];
                    for (byte b11 : h10) {
                        if (b10 == b11) {
                            i11 = n0Var.f11043b;
                        }
                    }
                    i10++;
                }
                j11 = (n0Var.f11044c - n0Var.f11043b) + j10;
                n0Var = n0Var.f11047f;
                za.h.b(n0Var);
                j10 = j11;
            }
            return -1L;
        }
        j10 = 0;
        while (true) {
            long j12 = (n0Var.f11044c - n0Var.f11043b) + j10;
            if (j12 > 0) {
                break;
            }
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
            j10 = j12;
        }
        if (oVar.d() == 2) {
            byte i16 = oVar.i(0);
            byte i17 = oVar.i(1);
            while (j10 < this.f11035p) {
                byte[] bArr3 = n0Var.f11042a;
                i10 = (int) ((n0Var.f11043b + j11) - j10);
                int i18 = n0Var.f11044c;
                while (i10 < i18) {
                    byte b12 = bArr3[i10];
                    if (b12 != i16 && b12 != i17) {
                        i10++;
                    }
                    i11 = n0Var.f11043b;
                }
                j11 = (n0Var.f11044c - n0Var.f11043b) + j10;
                n0Var = n0Var.f11047f;
                za.h.b(n0Var);
                j10 = j11;
            }
            return -1L;
        }
        byte[] h11 = oVar.h();
        while (j10 < this.f11035p) {
            byte[] bArr4 = n0Var.f11042a;
            i10 = (int) ((n0Var.f11043b + j11) - j10);
            int i19 = n0Var.f11044c;
            while (i10 < i19) {
                byte b13 = bArr4[i10];
                for (byte b14 : h11) {
                    if (b13 == b14) {
                        i11 = n0Var.f11043b;
                    }
                }
                i10++;
            }
            j11 = (n0Var.f11044c - n0Var.f11043b) + j10;
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
            j10 = j11;
        }
        return -1L;
        return (i10 - i11) + j10;
    }

    public final boolean N(int i10, o oVar, long j10) {
        za.h.e("bytes", oVar);
        if (i10 >= 0 && j10 >= 0 && i10 + j10 <= this.f11035p && i10 <= oVar.d()) {
            return i10 == 0 || sb.a.a(this, oVar, j10, j10 + 1, i10) != -1;
        }
        return false;
    }

    public final i O(i iVar) {
        za.h.e("unsafeCursor", iVar);
        byte[] bArr = sb.a.f11666a;
        if (iVar == b.f10995a) {
            iVar = new i();
        }
        if (iVar.f11013o != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        iVar.f11013o = this;
        iVar.f11014p = true;
        return iVar;
    }

    public final byte[] P(long j10) {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount: ").toString());
        }
        if (this.f11035p < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        readFully(bArr);
        return bArr;
    }

    public final short Q() {
        short readShort = readShort();
        return (short) (((readShort & 255) << 8) | ((65280 & readShort) >>> 8));
    }

    public final String R(long j10, Charset charset) {
        za.h.e("charset", charset);
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount: ").toString());
        }
        if (this.f11035p < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        int i10 = n0Var.f11043b;
        if (i10 + j10 > n0Var.f11044c) {
            return new String(P(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(n0Var.f11042a, i10, i11, charset);
        int i12 = n0Var.f11043b + i11;
        n0Var.f11043b = i12;
        this.f11035p -= j10;
        if (i12 == n0Var.f11044c) {
            this.f11034o = n0Var.a();
            o0.a(n0Var);
        }
        return str;
    }

    public final String S() {
        return R(this.f11035p, gb.a.f5445a);
    }

    public final int T() {
        int i10;
        int i11;
        int i12;
        if (this.f11035p == 0) {
            throw new EOFException();
        }
        byte x6 = x(0L);
        if ((x6 & 128) == 0) {
            i10 = x6 & Byte.MAX_VALUE;
            i12 = 0;
            i11 = 1;
        } else if ((x6 & 224) == 192) {
            i10 = x6 & 31;
            i11 = 2;
            i12 = 128;
        } else if ((x6 & 240) == 224) {
            i10 = x6 & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((x6 & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i10 = x6 & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (this.f11035p < j10) {
            StringBuilder f10 = r.a.f("size < ", i11, ": ");
            f10.append(this.f11035p);
            f10.append(" (to read code point prefixed 0x");
            f10.append(b.i(x6));
            f10.append(')');
            throw new EOFException(f10.toString());
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte x10 = x(j11);
            if ((x10 & 192) != 128) {
                skip(j11);
                return 65533;
            }
            i10 = (i10 << 6) | (x10 & 63);
        }
        skip(j10);
        if (i10 > 1114111) {
            return 65533;
        }
        if ((55296 > i10 || i10 >= 57344) && i10 >= i12) {
            return i10;
        }
        return 65533;
    }

    public final o U(int i10) {
        if (i10 == 0) {
            return o.f11048r;
        }
        b.e(this.f11035p, 0L, i10);
        n0 n0Var = this.f11034o;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            za.h.b(n0Var);
            int i14 = n0Var.f11044c;
            int i15 = n0Var.f11043b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            n0Var = n0Var.f11047f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        n0 n0Var2 = this.f11034o;
        int i16 = 0;
        while (i11 < i10) {
            za.h.b(n0Var2);
            bArr[i16] = n0Var2.f11042a;
            i11 += n0Var2.f11044c - n0Var2.f11043b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = n0Var2.f11043b;
            n0Var2.f11045d = true;
            i16++;
            n0Var2 = n0Var2.f11047f;
        }
        return new p0(bArr, iArr);
    }

    public final n0 V(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        n0 n0Var = this.f11034o;
        if (n0Var == null) {
            n0 b2 = o0.b();
            this.f11034o = b2;
            b2.g = b2;
            b2.f11047f = b2;
            return b2;
        }
        n0 n0Var2 = n0Var.g;
        za.h.b(n0Var2);
        if (n0Var2.f11044c + i10 <= 8192 && n0Var2.f11046e) {
            return n0Var2;
        }
        n0 b10 = o0.b();
        n0Var2.b(b10);
        return b10;
    }

    public final void W(o oVar) {
        za.h.e("byteString", oVar);
        oVar.s(oVar.d(), this);
    }

    public final void X(int i10) {
        n0 V = V(1);
        byte[] bArr = V.f11042a;
        int i11 = V.f11044c;
        V.f11044c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f11035p++;
    }

    public final void Y(long j10) {
        boolean z10;
        if (j10 == 0) {
            X(48);
            return;
        }
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                e0("-9223372036854775808");
                return;
            }
            z10 = true;
        } else {
            z10 = false;
        }
        byte[] bArr = sb.a.f11666a;
        int numberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j10)) * 10) >>> 5;
        int i10 = numberOfLeadingZeros + (j10 > sb.a.f11667b[numberOfLeadingZeros] ? 1 : 0);
        if (z10) {
            i10++;
        }
        n0 V = V(i10);
        byte[] bArr2 = V.f11042a;
        int i11 = V.f11044c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr2[i11] = sb.a.f11666a[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr2[i11 - 1] = 45;
        }
        V.f11044c += i10;
        this.f11035p += i10;
    }

    public final void Z(long j10) {
        if (j10 == 0) {
            X(48);
            return;
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        n0 V = V(i10);
        byte[] bArr = V.f11042a;
        int i11 = V.f11044c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = sb.a.f11666a[(int) (15 & j10)];
            j10 >>>= 4;
        }
        V.f11044c += i10;
        this.f11035p += i10;
    }

    public final void a() {
        skip(this.f11035p);
    }

    public final void a0(int i10) {
        n0 V = V(4);
        byte[] bArr = V.f11042a;
        int i11 = V.f11044c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        V.f11044c = i11 + 4;
        this.f11035p += 4;
    }

    public final void b0(long j10) {
        n0 V = V(8);
        byte[] bArr = V.f11042a;
        int i10 = V.f11044c;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        bArr[i10 + 1] = (byte) ((j10 >>> 48) & 255);
        bArr[i10 + 2] = (byte) ((j10 >>> 40) & 255);
        bArr[i10 + 3] = (byte) ((j10 >>> 32) & 255);
        bArr[i10 + 4] = (byte) ((j10 >>> 24) & 255);
        bArr[i10 + 5] = (byte) ((j10 >>> 16) & 255);
        bArr[i10 + 6] = (byte) ((j10 >>> 8) & 255);
        bArr[i10 + 7] = (byte) (j10 & 255);
        V.f11044c = i10 + 8;
        this.f11035p += 8;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final l clone() {
        l lVar = new l();
        if (this.f11035p == 0) {
            return lVar;
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        n0 c10 = n0Var.c();
        lVar.f11034o = c10;
        c10.g = c10;
        c10.f11047f = c10;
        for (n0 n0Var2 = n0Var.f11047f; n0Var2 != n0Var; n0Var2 = n0Var2.f11047f) {
            n0 n0Var3 = c10.g;
            za.h.b(n0Var3);
            za.h.b(n0Var2);
            n0Var3.b(n0Var2.c());
        }
        lVar.f11035p = this.f11035p;
        return lVar;
    }

    public final void c0(int i10) {
        n0 V = V(2);
        byte[] bArr = V.f11042a;
        int i11 = V.f11044c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        V.f11044c = i11 + 2;
        this.f11035p += 2;
    }

    @Override // rb.m
    public final long d(s0 s0Var) {
        za.h.e("source", s0Var);
        long j10 = 0;
        while (true) {
            long read = s0Var.read(this, 8192L);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    public final void d0(String str, int i10, int i11, Charset charset) {
        za.h.e("charset", charset);
        if (i10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "beginIndex < 0: ").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(android.support.v4.media.d.p("endIndex < beginIndex: ", " < ", i11, i10).toString());
        }
        if (i11 > str.length()) {
            StringBuilder f10 = r.a.f("endIndex > string.length: ", i11, " > ");
            f10.append(str.length());
            throw new IllegalArgumentException(f10.toString().toString());
        }
        if (charset.equals(gb.a.f5445a)) {
            f0(str, i10, i11);
            return;
        }
        String substring = str.substring(i10, i11);
        za.h.d("substring(...)", substring);
        byte[] bytes = substring.getBytes(charset);
        za.h.d("getBytes(...)", bytes);
        m154write(bytes, 0, bytes.length);
    }

    @Override // rb.n
    public final int e(h0 h0Var) {
        za.h.e("options", h0Var);
        int d6 = sb.a.d(this, h0Var, false);
        if (d6 == -1) {
            return -1;
        }
        skip(h0Var.f11011o[d6].d());
        return d6;
    }

    public final void e0(String str) {
        za.h.e("string", str);
        f0(str, 0, str.length());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        long j10 = this.f11035p;
        l lVar = (l) obj;
        if (j10 != lVar.f11035p) {
            return false;
        }
        if (j10 == 0) {
            return true;
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        n0 n0Var2 = lVar.f11034o;
        za.h.b(n0Var2);
        int i10 = n0Var.f11043b;
        int i11 = n0Var2.f11043b;
        long j11 = 0;
        while (j11 < this.f11035p) {
            long min = Math.min(n0Var.f11044c - i10, n0Var2.f11044c - i11);
            long j12 = 0;
            while (j12 < min) {
                int i12 = i10 + 1;
                int i13 = i11 + 1;
                if (n0Var.f11042a[i10] != n0Var2.f11042a[i11]) {
                    return false;
                }
                j12++;
                i10 = i12;
                i11 = i13;
            }
            if (i10 == n0Var.f11044c) {
                n0Var = n0Var.f11047f;
                za.h.b(n0Var);
                i10 = n0Var.f11043b;
            }
            if (i11 == n0Var2.f11044c) {
                n0Var2 = n0Var2.f11047f;
                za.h.b(n0Var2);
                i11 = n0Var2.f11043b;
            }
            j11 += min;
        }
        return true;
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m f(String str, int i10, int i11) {
        f0(str, i10, i11);
        return this;
    }

    public final void f0(String str, int i10, int i11) {
        char charAt;
        za.h.e("string", str);
        if (i10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "beginIndex < 0: ").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(android.support.v4.media.d.p("endIndex < beginIndex: ", " < ", i11, i10).toString());
        }
        if (i11 > str.length()) {
            StringBuilder f10 = r.a.f("endIndex > string.length: ", i11, " > ");
            f10.append(str.length());
            throw new IllegalArgumentException(f10.toString().toString());
        }
        while (i10 < i11) {
            char charAt2 = str.charAt(i10);
            if (charAt2 < 128) {
                n0 V = V(1);
                byte[] bArr = V.f11042a;
                int i12 = V.f11044c - i10;
                int min = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) charAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= min || (charAt = str.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) charAt;
                }
                int i14 = V.f11044c;
                int i15 = (i12 + i10) - i14;
                V.f11044c = i14 + i15;
                this.f11035p += i15;
            } else {
                if (charAt2 < 2048) {
                    n0 V2 = V(2);
                    byte[] bArr2 = V2.f11042a;
                    int i16 = V2.f11044c;
                    bArr2[i16] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i16 + 1] = (byte) ((charAt2 & '?') | 128);
                    V2.f11044c = i16 + 2;
                    this.f11035p += 2;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    n0 V3 = V(3);
                    byte[] bArr3 = V3.f11042a;
                    int i17 = V3.f11044c;
                    bArr3[i17] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((charAt2 & '?') | 128);
                    V3.f11044c = i17 + 3;
                    this.f11035p += 3;
                } else {
                    int i18 = i10 + 1;
                    char charAt3 = i18 < i11 ? str.charAt(i18) : (char) 0;
                    if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                        X(63);
                        i10 = i18;
                    } else {
                        int i19 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        n0 V4 = V(4);
                        byte[] bArr4 = V4.f11042a;
                        int i20 = V4.f11044c;
                        bArr4[i20] = (byte) ((i19 >> 18) | 240);
                        bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                        bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                        bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                        V4.f11044c = i20 + 4;
                        this.f11035p += 4;
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m g(long j10) {
        Z(j10);
        return this;
    }

    public final void g0(int i10) {
        if (i10 < 128) {
            X(i10);
            return;
        }
        if (i10 < 2048) {
            n0 V = V(2);
            byte[] bArr = V.f11042a;
            int i11 = V.f11044c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            V.f11044c = i11 + 2;
            this.f11035p += 2;
            return;
        }
        if (55296 <= i10 && i10 < 57344) {
            X(63);
            return;
        }
        if (i10 < 65536) {
            n0 V2 = V(3);
            byte[] bArr2 = V2.f11042a;
            int i12 = V2.f11044c;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            V2.f11044c = i12 + 3;
            this.f11035p += 3;
            return;
        }
        if (i10 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(b.j(i10)));
        }
        n0 V3 = V(4);
        byte[] bArr3 = V3.f11042a;
        int i13 = V3.f11044c;
        bArr3[i13] = (byte) ((i10 >> 18) | 240);
        bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
        bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
        bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
        V3.f11044c = i13 + 4;
        this.f11035p += 4;
    }

    @Override // rb.n
    public final o h() {
        return i(this.f11035p);
    }

    public final int hashCode() {
        n0 n0Var = this.f11034o;
        if (n0Var == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = n0Var.f11044c;
            for (int i12 = n0Var.f11043b; i12 < i11; i12++) {
                i10 = (i10 * 31) + n0Var.f11042a[i12];
            }
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
        } while (n0Var != this.f11034o);
        return i10;
    }

    @Override // rb.n
    public final o i(long j10) {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount: ").toString());
        }
        if (this.f11035p < j10) {
            throw new EOFException();
        }
        if (j10 < 4096) {
            return new o(P(j10));
        }
        o U = U((int) j10);
        skip(j10);
        return U;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // rb.n
    public final boolean k(long j10) {
        return this.f11035p >= j10;
    }

    @Override // rb.n
    public final long l(l lVar) {
        long j10 = this.f11035p;
        if (j10 > 0) {
            lVar.write(this, j10);
        }
        return j10;
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m m(int i10) {
        g0(i10);
        return this;
    }

    public final long n() {
        long j10 = this.f11035p;
        if (j10 == 0) {
            return 0L;
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        n0 n0Var2 = n0Var.g;
        za.h.b(n0Var2);
        return (n0Var2.f11044c >= 8192 || !n0Var2.f11046e) ? j10 : j10 - (r3 - n0Var2.f11043b);
    }

    @Override // rb.n
    public final String p() {
        return y(Long.MAX_VALUE);
    }

    @Override // rb.n
    public final m0 peek() {
        return b.c(new j0(this));
    }

    @Override // rb.n
    public final byte[] r() {
        return P(this.f11035p);
    }

    @Override // rb.s0
    public final long read(l lVar, long j10) {
        za.h.e("sink", lVar);
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
        }
        long j11 = this.f11035p;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        lVar.write(this, j10);
        return j10;
    }

    @Override // rb.n
    public final byte readByte() {
        if (this.f11035p == 0) {
            throw new EOFException();
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        int i10 = n0Var.f11043b;
        int i11 = n0Var.f11044c;
        int i12 = i10 + 1;
        byte b2 = n0Var.f11042a[i10];
        this.f11035p--;
        if (i12 != i11) {
            n0Var.f11043b = i12;
            return b2;
        }
        this.f11034o = n0Var.a();
        o0.a(n0Var);
        return b2;
    }

    @Override // rb.n
    public final void readFully(byte[] bArr) {
        za.h.e("sink", bArr);
        int i10 = 0;
        while (i10 < bArr.length) {
            int read = read(bArr, i10, bArr.length - i10);
            if (read == -1) {
                throw new EOFException();
            }
            i10 += read;
        }
    }

    @Override // rb.n
    public final int readInt() {
        if (this.f11035p < 4) {
            throw new EOFException();
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        int i10 = n0Var.f11043b;
        int i11 = n0Var.f11044c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = n0Var.f11042a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.f11035p -= 4;
        if (i14 != i11) {
            n0Var.f11043b = i14;
            return i15;
        }
        this.f11034o = n0Var.a();
        o0.a(n0Var);
        return i15;
    }

    @Override // rb.n
    public final long readLong() {
        if (this.f11035p < 8) {
            throw new EOFException();
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        int i10 = n0Var.f11043b;
        int i11 = n0Var.f11044c;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = n0Var.f11042a;
        int i12 = i10 + 7;
        long j10 = ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10] & 255) << 56) | ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
        int i13 = i10 + 8;
        long j11 = j10 | (bArr[i12] & 255);
        this.f11035p -= 8;
        if (i13 != i11) {
            n0Var.f11043b = i13;
            return j11;
        }
        this.f11034o = n0Var.a();
        o0.a(n0Var);
        return j11;
    }

    @Override // rb.n
    public final short readShort() {
        if (this.f11035p < 2) {
            throw new EOFException();
        }
        n0 n0Var = this.f11034o;
        za.h.b(n0Var);
        int i10 = n0Var.f11043b;
        int i11 = n0Var.f11044c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = n0Var.f11042a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.f11035p -= 2;
        if (i14 == i11) {
            this.f11034o = n0Var.a();
            o0.a(n0Var);
        } else {
            n0Var.f11043b = i14;
        }
        return (short) i15;
    }

    public final void s(long j10, l lVar, long j11) {
        za.h.e("out", lVar);
        long j12 = j10;
        b.e(this.f11035p, j12, j11);
        if (j11 == 0) {
            return;
        }
        lVar.f11035p += j11;
        n0 n0Var = this.f11034o;
        while (true) {
            za.h.b(n0Var);
            long j13 = n0Var.f11044c - n0Var.f11043b;
            if (j12 < j13) {
                break;
            }
            j12 -= j13;
            n0Var = n0Var.f11047f;
        }
        n0 n0Var2 = n0Var;
        long j14 = j11;
        while (j14 > 0) {
            za.h.b(n0Var2);
            n0 c10 = n0Var2.c();
            int i10 = c10.f11043b + ((int) j12);
            c10.f11043b = i10;
            c10.f11044c = Math.min(i10 + ((int) j14), c10.f11044c);
            n0 n0Var3 = lVar.f11034o;
            if (n0Var3 == null) {
                c10.g = c10;
                c10.f11047f = c10;
                lVar.f11034o = c10;
            } else {
                n0 n0Var4 = n0Var3.g;
                za.h.b(n0Var4);
                n0Var4.b(c10);
            }
            j14 -= c10.f11044c - c10.f11043b;
            n0Var2 = n0Var2.f11047f;
            j12 = 0;
        }
    }

    @Override // rb.n
    public final void skip(long j10) {
        while (j10 > 0) {
            n0 n0Var = this.f11034o;
            if (n0Var == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j10, n0Var.f11044c - n0Var.f11043b);
            long j11 = min;
            this.f11035p -= j11;
            j10 -= j11;
            int i10 = n0Var.f11043b + min;
            n0Var.f11043b = i10;
            if (i10 == n0Var.f11044c) {
                this.f11034o = n0Var.a();
                o0.a(n0Var);
            }
        }
    }

    @Override // rb.n
    public final boolean t() {
        return this.f11035p == 0;
    }

    @Override // rb.s0
    public final v0 timeout() {
        return v0.NONE;
    }

    public final String toString() {
        long j10 = this.f11035p;
        if (j10 <= 2147483647L) {
            return U((int) j10).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f11035p).toString());
    }

    @Override // rb.n
    public final boolean u(long j10, o oVar) {
        za.h.e("bytes", oVar);
        return N(oVar.d(), oVar, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0093, code lost:
    
        r3 = r19.f11035p - r1;
        r19.f11035p = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0099, code lost:
    
        if (r2 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
    
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:
    
        if (r1 >= r14) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
    
        if (r3 == r17) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
    
        if (r2 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
    
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
    
        r1 = s.e.a(r1, " but was 0x");
        r1.append(rb.b.i(x(r17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c7, code lost:
    
        throw new java.lang.NumberFormatException(r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a9, code lost:
    
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00cd, code lost:
    
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ce, code lost:
    
        if (r2 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d2, code lost:
    
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
    
        r14 = 1;
     */
    @Override // rb.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long w() {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.l.w():long");
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m write(byte[] bArr) {
        m153write(bArr);
        return this;
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m writeByte(int i10) {
        X(i10);
        return this;
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m writeInt(int i10) {
        a0(i10);
        return this;
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m writeShort(int i10) {
        c0(i10);
        return this;
    }

    public final byte x(long j10) {
        b.e(this.f11035p, j10, 1L);
        n0 n0Var = this.f11034o;
        if (n0Var == null) {
            za.h.b(null);
            throw null;
        }
        long j11 = this.f11035p;
        if (j11 - j10 < j10) {
            while (j11 > j10) {
                n0Var = n0Var.g;
                za.h.b(n0Var);
                j11 -= n0Var.f11044c - n0Var.f11043b;
            }
            return n0Var.f11042a[(int) ((n0Var.f11043b + j10) - j11)];
        }
        long j12 = 0;
        while (true) {
            int i10 = n0Var.f11044c;
            int i11 = n0Var.f11043b;
            long j13 = (i10 - i11) + j12;
            if (j13 > j10) {
                return n0Var.f11042a[(int) ((i11 + j10) - j12)];
            }
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
            j12 = j13;
        }
    }

    @Override // rb.n
    public final String y(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "limit < 0: ").toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long K = K((byte) 10, 0L, j11);
        if (K != -1) {
            return sb.a.c(this, K);
        }
        if (j11 < this.f11035p && x(j11 - 1) == 13 && x(j11) == 10) {
            return sb.a.c(this, j11);
        }
        l lVar = new l();
        s(0L, lVar, Math.min(32, this.f11035p));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f11035p, j10) + " content=" + lVar.i(lVar.f11035p).e() + (char) 8230);
    }

    @Override // rb.n
    public final void z(l lVar, long j10) {
        za.h.e("sink", lVar);
        long j11 = this.f11035p;
        if (j11 >= j10) {
            lVar.write(this, j10);
        } else {
            lVar.write(this, j11);
            throw new EOFException();
        }
    }

    @Override // rb.m
    public final /* bridge */ /* synthetic */ m write(byte[] bArr, int i10, int i11) {
        m154write(bArr, i10, i11);
        return this;
    }

    @Override // rb.q0
    public final void write(l lVar, long j10) {
        n0 b2;
        za.h.e("source", lVar);
        if (lVar != this) {
            b.e(lVar.f11035p, 0L, j10);
            while (j10 > 0) {
                n0 n0Var = lVar.f11034o;
                za.h.b(n0Var);
                int i10 = n0Var.f11044c;
                n0 n0Var2 = lVar.f11034o;
                za.h.b(n0Var2);
                long j11 = i10 - n0Var2.f11043b;
                int i11 = 0;
                if (j10 < j11) {
                    n0 n0Var3 = this.f11034o;
                    n0 n0Var4 = n0Var3 != null ? n0Var3.g : null;
                    if (n0Var4 != null && n0Var4.f11046e) {
                        if ((n0Var4.f11044c + j10) - (n0Var4.f11045d ? 0 : n0Var4.f11043b) <= 8192) {
                            n0 n0Var5 = lVar.f11034o;
                            za.h.b(n0Var5);
                            n0Var5.d(n0Var4, (int) j10);
                            lVar.f11035p -= j10;
                            this.f11035p += j10;
                            return;
                        }
                    }
                    n0 n0Var6 = lVar.f11034o;
                    za.h.b(n0Var6);
                    int i12 = (int) j10;
                    if (i12 > 0 && i12 <= n0Var6.f11044c - n0Var6.f11043b) {
                        if (i12 >= 1024) {
                            b2 = n0Var6.c();
                        } else {
                            b2 = o0.b();
                            byte[] bArr = n0Var6.f11042a;
                            byte[] bArr2 = b2.f11042a;
                            int i13 = n0Var6.f11043b;
                            ma.i.C(0, i13, i13 + i12, bArr, bArr2);
                        }
                        b2.f11044c = b2.f11043b + i12;
                        n0Var6.f11043b += i12;
                        n0 n0Var7 = n0Var6.g;
                        za.h.b(n0Var7);
                        n0Var7.b(b2);
                        lVar.f11034o = b2;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range");
                    }
                }
                n0 n0Var8 = lVar.f11034o;
                za.h.b(n0Var8);
                long j12 = n0Var8.f11044c - n0Var8.f11043b;
                lVar.f11034o = n0Var8.a();
                n0 n0Var9 = this.f11034o;
                if (n0Var9 == null) {
                    this.f11034o = n0Var8;
                    n0Var8.g = n0Var8;
                    n0Var8.f11047f = n0Var8;
                } else {
                    n0 n0Var10 = n0Var9.g;
                    za.h.b(n0Var10);
                    n0Var10.b(n0Var8);
                    n0 n0Var11 = n0Var8.g;
                    if (n0Var11 != n0Var8) {
                        za.h.b(n0Var11);
                        if (n0Var11.f11046e) {
                            int i14 = n0Var8.f11044c - n0Var8.f11043b;
                            n0 n0Var12 = n0Var8.g;
                            za.h.b(n0Var12);
                            int i15 = 8192 - n0Var12.f11044c;
                            n0 n0Var13 = n0Var8.g;
                            za.h.b(n0Var13);
                            if (!n0Var13.f11045d) {
                                n0 n0Var14 = n0Var8.g;
                                za.h.b(n0Var14);
                                i11 = n0Var14.f11043b;
                            }
                            if (i14 <= i15 + i11) {
                                n0 n0Var15 = n0Var8.g;
                                za.h.b(n0Var15);
                                n0Var8.d(n0Var15, i14);
                                n0Var8.a();
                                o0.a(n0Var8);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact");
                    }
                }
                lVar.f11035p -= j12;
                this.f11035p += j12;
                j10 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        za.h.e("sink", byteBuffer);
        n0 n0Var = this.f11034o;
        if (n0Var == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), n0Var.f11044c - n0Var.f11043b);
        byteBuffer.put(n0Var.f11042a, n0Var.f11043b, min);
        int i10 = n0Var.f11043b + min;
        n0Var.f11043b = i10;
        this.f11035p -= min;
        if (i10 == n0Var.f11044c) {
            this.f11034o = n0Var.a();
            o0.a(n0Var);
        }
        return min;
    }

    public final int read(byte[] bArr, int i10, int i11) {
        za.h.e("sink", bArr);
        b.e(bArr.length, i10, i11);
        n0 n0Var = this.f11034o;
        if (n0Var == null) {
            return -1;
        }
        int min = Math.min(i11, n0Var.f11044c - n0Var.f11043b);
        byte[] bArr2 = n0Var.f11042a;
        int i12 = n0Var.f11043b;
        ma.i.C(i10, i12, i12 + min, bArr2, bArr);
        int i13 = n0Var.f11043b + min;
        n0Var.f11043b = i13;
        this.f11035p -= min;
        if (i13 == n0Var.f11044c) {
            this.f11034o = n0Var.a();
            o0.a(n0Var);
        }
        return min;
    }

    @Override // rb.n, rb.m
    public final l b() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, rb.q0
    public final void close() {
    }

    @Override // rb.m, rb.q0, java.io.Flushable
    public final void flush() {
    }

    @Override // rb.m
    public final m v() {
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        za.h.e("source", byteBuffer);
        int remaining = byteBuffer.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            n0 V = V(1);
            int min = Math.min(i10, 8192 - V.f11044c);
            byteBuffer.get(V.f11042a, V.f11044c, min);
            i10 -= min;
            V.f11044c += min;
        }
        this.f11035p += remaining;
        return remaining;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m153write(byte[] bArr) {
        za.h.e("source", bArr);
        m154write(bArr, 0, bArr.length);
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m154write(byte[] bArr, int i10, int i11) {
        za.h.e("source", bArr);
        long j10 = i11;
        b.e(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            n0 V = V(1);
            int min = Math.min(i12 - i10, 8192 - V.f11044c);
            int i13 = i10 + min;
            ma.i.C(V.f11044c, i10, i13, bArr, V.f11042a);
            V.f11044c += min;
            i10 = i13;
        }
        this.f11035p += j10;
    }
}
