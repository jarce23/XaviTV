package rb;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 implements m {

    /* renamed from: o, reason: collision with root package name */
    public final q0 f11036o;

    /* renamed from: p, reason: collision with root package name */
    public final l f11037p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11038q;

    public l0(q0 q0Var) {
        za.h.e("sink", q0Var);
        this.f11036o = q0Var;
        this.f11037p = new l();
    }

    @Override // rb.m
    public final m B(o oVar) {
        za.h.e("byteString", oVar);
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.W(oVar);
        v();
        return this;
    }

    @Override // rb.m
    public final m E(String str) {
        za.h.e("string", str);
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.e0(str);
        v();
        return this;
    }

    @Override // rb.m
    public final m F(long j10) {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.Y(j10);
        v();
        return this;
    }

    @Override // rb.m
    public final OutputStream G() {
        return new k(this, 1);
    }

    @Override // rb.m
    public final l b() {
        return this.f11037p;
    }

    @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        q0 q0Var = this.f11036o;
        if (this.f11038q) {
            return;
        }
        try {
            l lVar = this.f11037p;
            long j10 = lVar.f11035p;
            if (j10 > 0) {
                q0Var.write(lVar, j10);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            q0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f11038q = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // rb.m
    public final long d(s0 s0Var) {
        za.h.e("source", s0Var);
        long j10 = 0;
        while (true) {
            long read = s0Var.read(this.f11037p, 8192L);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            v();
        }
    }

    @Override // rb.m
    public final m f(String str, int i10, int i11) {
        za.h.e("string", str);
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.f0(str, i10, i11);
        v();
        return this;
    }

    @Override // rb.m, rb.q0, java.io.Flushable
    public final void flush() {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        l lVar = this.f11037p;
        long j10 = lVar.f11035p;
        q0 q0Var = this.f11036o;
        if (j10 > 0) {
            q0Var.write(lVar, j10);
        }
        q0Var.flush();
    }

    @Override // rb.m
    public final m g(long j10) {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.Z(j10);
        v();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f11038q;
    }

    @Override // rb.m
    public final m m(int i10) {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.g0(i10);
        v();
        return this;
    }

    @Override // rb.q0
    public final v0 timeout() {
        return this.f11036o.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f11036o + ')';
    }

    @Override // rb.m
    public final m v() {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        l lVar = this.f11037p;
        long n10 = lVar.n();
        if (n10 > 0) {
            this.f11036o.write(lVar, n10);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        za.h.e("source", byteBuffer);
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        int write = this.f11037p.write(byteBuffer);
        v();
        return write;
    }

    @Override // rb.m
    public final m writeByte(int i10) {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.X(i10);
        v();
        return this;
    }

    @Override // rb.m
    public final m writeInt(int i10) {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.a0(i10);
        v();
        return this;
    }

    @Override // rb.m
    public final m writeShort(int i10) {
        if (this.f11038q) {
            throw new IllegalStateException("closed");
        }
        this.f11037p.c0(i10);
        v();
        return this;
    }

    @Override // rb.q0
    public final void write(l lVar, long j10) {
        za.h.e("source", lVar);
        if (!this.f11038q) {
            this.f11037p.write(lVar, j10);
            v();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // rb.m
    public final m write(byte[] bArr) {
        za.h.e("source", bArr);
        if (!this.f11038q) {
            this.f11037p.m153write(bArr);
            v();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // rb.m
    public final m write(byte[] bArr, int i10, int i11) {
        za.h.e("source", bArr);
        if (!this.f11038q) {
            this.f11037p.m154write(bArr, i10, i11);
            v();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
