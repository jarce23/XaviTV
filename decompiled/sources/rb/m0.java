package rb;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 implements n {

    /* renamed from: o, reason: collision with root package name */
    public final s0 f11039o;

    /* renamed from: p, reason: collision with root package name */
    public final l f11040p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11041q;

    public m0(s0 s0Var) {
        za.h.e("source", s0Var);
        this.f11039o = s0Var;
        this.f11040p = new l();
    }

    @Override // rb.n
    public final void D(long j10) {
        if (!k(j10)) {
            throw new EOFException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        com.bumptech.glide.c.h(16);
        r1 = java.lang.Integer.toString(r2, 16);
        za.h.d("toString(...)", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        throw new java.lang.NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(r1));
     */
    @Override // rb.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long H() {
        /*
            r6 = this;
            r0 = 1
            r6.D(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r6.k(r2)
            rb.l r3 = r6.f11040p
            if (r2 == 0) goto L4e
            long r4 = (long) r0
            byte r2 = r3.x(r4)
            r4 = 48
            if (r2 < r4) goto L1e
            r4 = 57
            if (r2 <= r4) goto L2f
        L1e:
            r4 = 97
            if (r2 < r4) goto L26
            r4 = 102(0x66, float:1.43E-43)
            if (r2 <= r4) goto L2f
        L26:
            r4 = 65
            if (r2 < r4) goto L31
            r4 = 70
            if (r2 <= r4) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L4e
        L34:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            com.bumptech.glide.c.h(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "toString(...)"
            za.h.d(r2, r1)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L4e:
            long r0 = r3.H()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.m0.H():long");
    }

    @Override // rb.n
    public final String I(Charset charset) {
        za.h.e("charset", charset);
        s0 s0Var = this.f11039o;
        l lVar = this.f11040p;
        lVar.d(s0Var);
        return lVar.I(charset);
    }

    @Override // rb.n
    public final InputStream J() {
        return new j(this, 1);
    }

    @Override // rb.n
    public final long L(long j10, o oVar) {
        za.h.e("bytes", oVar);
        return sb.b.d(this, oVar, oVar.d(), j10);
    }

    public final long a(byte b2, long j10, long j11) {
        if (this.f11041q) {
            throw new IllegalStateException("closed");
        }
        if (0 > j11) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j11, "fromIndex=0 toIndex=").toString());
        }
        long j12 = 0;
        while (j12 < j11) {
            l lVar = this.f11040p;
            byte b10 = b2;
            long j13 = j11;
            long K = lVar.K(b10, j12, j13);
            if (K == -1) {
                long j14 = lVar.f11035p;
                if (j14 >= j13 || this.f11039o.read(lVar, 8192L) == -1) {
                    break;
                }
                j12 = Math.max(j12, j14);
                b2 = b10;
                j11 = j13;
            } else {
                return K;
            }
        }
        return -1L;
    }

    @Override // rb.n, rb.m
    public final l b() {
        return this.f11040p;
    }

    public final int c() {
        D(4L);
        return b.g(this.f11040p.readInt());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f11041q) {
            return;
        }
        this.f11041q = true;
        this.f11039o.close();
        this.f11040p.a();
    }

    @Override // rb.n
    public final int e(h0 h0Var) {
        za.h.e("options", h0Var);
        if (this.f11041q) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            l lVar = this.f11040p;
            int d6 = sb.a.d(lVar, h0Var, true);
            if (d6 != -2) {
                if (d6 != -1) {
                    lVar.skip(h0Var.f11011o[d6].d());
                    return d6;
                }
            } else if (this.f11039o.read(lVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // rb.n
    public final o h() {
        s0 s0Var = this.f11039o;
        l lVar = this.f11040p;
        lVar.d(s0Var);
        return lVar.i(lVar.f11035p);
    }

    @Override // rb.n
    public final o i(long j10) {
        D(j10);
        return this.f11040p.i(j10);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f11041q;
    }

    @Override // rb.n
    public final boolean k(long j10) {
        l lVar;
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
        }
        if (this.f11041q) {
            throw new IllegalStateException("closed");
        }
        do {
            lVar = this.f11040p;
            if (lVar.f11035p >= j10) {
                return true;
            }
        } while (this.f11039o.read(lVar, 8192L) != -1);
        return false;
    }

    @Override // rb.n
    public final long l(l lVar) {
        l lVar2;
        long j10 = 0;
        while (true) {
            s0 s0Var = this.f11039o;
            lVar2 = this.f11040p;
            if (s0Var.read(lVar2, 8192L) == -1) {
                break;
            }
            long n10 = lVar2.n();
            if (n10 > 0) {
                j10 += n10;
                lVar.write(lVar2, n10);
            }
        }
        long j11 = lVar2.f11035p;
        if (j11 <= 0) {
            return j10;
        }
        long j12 = j10 + j11;
        lVar.write(lVar2, j11);
        return j12;
    }

    public final long n() {
        D(8L);
        long readLong = this.f11040p.readLong();
        return ((readLong & 255) << 56) | (((-72057594037927936L) & readLong) >>> 56) | ((71776119061217280L & readLong) >>> 40) | ((280375465082880L & readLong) >>> 24) | ((1095216660480L & readLong) >>> 8) | ((4278190080L & readLong) << 8) | ((16711680 & readLong) << 24) | ((65280 & readLong) << 40);
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
        s0 s0Var = this.f11039o;
        l lVar = this.f11040p;
        lVar.d(s0Var);
        return lVar.P(lVar.f11035p);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        za.h.e("sink", byteBuffer);
        l lVar = this.f11040p;
        if (lVar.f11035p == 0 && this.f11039o.read(lVar, 8192L) == -1) {
            return -1;
        }
        return lVar.read(byteBuffer);
    }

    @Override // rb.n
    public final byte readByte() {
        D(1L);
        return this.f11040p.readByte();
    }

    @Override // rb.n
    public final void readFully(byte[] bArr) {
        l lVar = this.f11040p;
        za.h.e("sink", bArr);
        try {
            D(bArr.length);
            lVar.readFully(bArr);
        } catch (EOFException e7) {
            int i10 = 0;
            while (true) {
                long j10 = lVar.f11035p;
                if (j10 <= 0) {
                    throw e7;
                }
                int read = lVar.read(bArr, i10, (int) j10);
                if (read == -1) {
                    throw new AssertionError();
                }
                i10 += read;
            }
        }
    }

    @Override // rb.n
    public final int readInt() {
        D(4L);
        return this.f11040p.readInt();
    }

    @Override // rb.n
    public final long readLong() {
        D(8L);
        return this.f11040p.readLong();
    }

    @Override // rb.n
    public final short readShort() {
        D(2L);
        return this.f11040p.readShort();
    }

    public final short s() {
        D(2L);
        return this.f11040p.Q();
    }

    @Override // rb.n
    public final void skip(long j10) {
        if (this.f11041q) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            l lVar = this.f11040p;
            if (lVar.f11035p == 0 && this.f11039o.read(lVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j10, lVar.f11035p);
            lVar.skip(min);
            j10 -= min;
        }
    }

    @Override // rb.n
    public final boolean t() {
        if (this.f11041q) {
            throw new IllegalStateException("closed");
        }
        l lVar = this.f11040p;
        return lVar.t() && this.f11039o.read(lVar, 8192L) == -1;
    }

    @Override // rb.s0
    public final v0 timeout() {
        return this.f11039o.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f11039o + ')';
    }

    @Override // rb.n
    public final boolean u(long j10, o oVar) {
        za.h.e("bytes", oVar);
        int d6 = oVar.d();
        if (this.f11041q) {
            throw new IllegalStateException("closed");
        }
        if (d6 >= 0 && d6 <= oVar.d()) {
            return d6 == 0 || sb.b.d(this, oVar, d6, 1L) != -1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        com.bumptech.glide.c.h(16);
        r1 = java.lang.Integer.toString(r8, 16);
        za.h.d("toString(...)", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        throw new java.lang.NumberFormatException("Expected a digit or '-' but was 0x".concat(r1));
     */
    @Override // rb.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long w() {
        /*
            r11 = this;
            r0 = 1
            r11.D(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r11.k(r6)
            rb.l r9 = r11.f11040p
            if (r8 == 0) goto L46
            byte r8 = r9.x(r4)
            r10 = 48
            if (r8 < r10) goto L1e
            r10 = 57
            if (r8 <= r10) goto L27
        L1e:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L29
            r5 = 45
            if (r8 == r5) goto L27
            goto L29
        L27:
            r4 = r6
            goto L8
        L29:
            if (r4 == 0) goto L2c
            goto L46
        L2c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            com.bumptech.glide.c.h(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "toString(...)"
            za.h.d(r2, r1)
            java.lang.String r2 = "Expected a digit or '-' but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L46:
            long r0 = r9.w()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.m0.w():long");
    }

    public final String x(long j10) {
        D(j10);
        l lVar = this.f11040p;
        lVar.getClass();
        return lVar.R(j10, gb.a.f5445a);
    }

    @Override // rb.n
    public final String y(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "limit < 0: ").toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long a10 = a((byte) 10, 0L, j11);
        l lVar = this.f11040p;
        if (a10 != -1) {
            return sb.a.c(lVar, a10);
        }
        if (j11 < Long.MAX_VALUE && k(j11) && lVar.x(j11 - 1) == 13 && k(j11 + 1) && lVar.x(j11) == 10) {
            return sb.a.c(lVar, j11);
        }
        l lVar2 = new l();
        lVar.s(0L, lVar2, Math.min(32, lVar.f11035p));
        throw new EOFException("\\n not found: limit=" + Math.min(lVar.f11035p, j10) + " content=" + lVar2.i(lVar2.f11035p).e() + (char) 8230);
    }

    @Override // rb.n
    public final void z(l lVar, long j10) {
        l lVar2 = this.f11040p;
        za.h.e("sink", lVar);
        try {
            D(j10);
            lVar2.z(lVar, j10);
        } catch (EOFException e7) {
            lVar.d(lVar2);
            throw e7;
        }
    }

    @Override // rb.s0
    public final long read(l lVar, long j10) {
        za.h.e("sink", lVar);
        if (j10 >= 0) {
            if (!this.f11041q) {
                l lVar2 = this.f11040p;
                if (lVar2.f11035p == 0) {
                    if (j10 == 0) {
                        return 0L;
                    }
                    if (this.f11039o.read(lVar2, 8192L) == -1) {
                        return -1L;
                    }
                }
                return lVar2.read(lVar, Math.min(j10, lVar2.f11035p));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
    }
}
