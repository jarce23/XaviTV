package rb;

import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements q0 {

    /* renamed from: o, reason: collision with root package name */
    public final l0 f11078o;

    /* renamed from: p, reason: collision with root package name */
    public final Deflater f11079p;

    /* renamed from: q, reason: collision with root package name */
    public final p f11080q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11081r;

    /* renamed from: s, reason: collision with root package name */
    public final CRC32 f11082s;

    public z(m mVar) {
        za.h.e("sink", mVar);
        l0 l0Var = new l0(mVar);
        this.f11078o = l0Var;
        Deflater deflater = new Deflater(-1, true);
        this.f11079p = deflater;
        this.f11080q = new p(l0Var, deflater);
        this.f11082s = new CRC32();
        l lVar = l0Var.f11037p;
        lVar.c0(8075);
        lVar.X(8);
        lVar.X(0);
        lVar.a0(0);
        lVar.X(0);
        lVar.X(0);
    }

    @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int value;
        boolean z10;
        l lVar;
        Deflater deflater = this.f11079p;
        l0 l0Var = this.f11078o;
        if (this.f11081r) {
            return;
        }
        try {
            p pVar = this.f11080q;
            pVar.f11056p.finish();
            pVar.a(false);
            value = (int) this.f11082s.getValue();
            z10 = l0Var.f11038q;
            lVar = l0Var.f11037p;
        } catch (Throwable th) {
            th = th;
        }
        if (z10) {
            throw new IllegalStateException("closed");
        }
        lVar.a0(b.g(value));
        l0Var.v();
        int bytesRead = (int) deflater.getBytesRead();
        if (l0Var.f11038q) {
            throw new IllegalStateException("closed");
        }
        lVar.a0(b.g(bytesRead));
        l0Var.v();
        th = null;
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            l0Var.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f11081r = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // rb.q0, java.io.Flushable
    public final void flush() {
        this.f11080q.flush();
    }

    @Override // rb.q0
    public final v0 timeout() {
        return this.f11078o.f11036o.timeout();
    }

    @Override // rb.q0
    public final void write(l lVar, long j10) {
        za.h.e("source", lVar);
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
        }
        if (j10 == 0) {
            return;
        }
        n0 n0Var = lVar.f11034o;
        za.h.b(n0Var);
        long j11 = j10;
        while (j11 > 0) {
            int min = (int) Math.min(j11, n0Var.f11044c - n0Var.f11043b);
            this.f11082s.update(n0Var.f11042a, n0Var.f11043b, min);
            j11 -= min;
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
        }
        this.f11080q.write(lVar, j10);
    }
}
