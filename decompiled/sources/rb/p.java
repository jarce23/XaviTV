package rb;

import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements q0 {

    /* renamed from: o, reason: collision with root package name */
    public final l0 f11055o;

    /* renamed from: p, reason: collision with root package name */
    public final Deflater f11056p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11057q;

    public p(l0 l0Var, Deflater deflater) {
        this.f11055o = l0Var;
        this.f11056p = deflater;
    }

    public final void a(boolean z10) {
        n0 V;
        int deflate;
        l0 l0Var = this.f11055o;
        l lVar = l0Var.f11037p;
        while (true) {
            V = lVar.V(1);
            byte[] bArr = V.f11042a;
            Deflater deflater = this.f11056p;
            if (z10) {
                try {
                    int i10 = V.f11044c;
                    deflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
                } catch (NullPointerException e7) {
                    throw new IOException("Deflater already closed", e7);
                }
            } else {
                int i11 = V.f11044c;
                deflate = deflater.deflate(bArr, i11, 8192 - i11);
            }
            if (deflate > 0) {
                V.f11044c += deflate;
                lVar.f11035p += deflate;
                l0Var.v();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (V.f11043b == V.f11044c) {
            lVar.f11034o = V.a();
            o0.a(V);
        }
    }

    @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Deflater deflater = this.f11056p;
        if (this.f11057q) {
            return;
        }
        try {
            deflater.finish();
            a(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f11055o.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f11057q = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // rb.q0, java.io.Flushable
    public final void flush() {
        a(true);
        this.f11055o.flush();
    }

    @Override // rb.q0
    public final v0 timeout() {
        return this.f11055o.f11036o.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f11055o + ')';
    }

    @Override // rb.q0
    public final void write(l lVar, long j10) {
        za.h.e("source", lVar);
        b.e(lVar.f11035p, 0L, j10);
        while (true) {
            Deflater deflater = this.f11056p;
            if (j10 <= 0) {
                deflater.setInput(sb.b.f11669b, 0, 0);
                return;
            }
            n0 n0Var = lVar.f11034o;
            za.h.b(n0Var);
            int min = (int) Math.min(j10, n0Var.f11044c - n0Var.f11043b);
            deflater.setInput(n0Var.f11042a, n0Var.f11043b, min);
            a(false);
            long j11 = min;
            lVar.f11035p -= j11;
            int i10 = n0Var.f11043b + min;
            n0Var.f11043b = i10;
            if (i10 == n0Var.f11044c) {
                lVar.f11034o = n0Var.a();
                o0.a(n0Var);
            }
            j10 -= j11;
        }
    }
}
