package rb;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements s0 {

    /* renamed from: o, reason: collision with root package name */
    public final m0 f10997o;

    /* renamed from: p, reason: collision with root package name */
    public final Inflater f10998p;

    /* renamed from: q, reason: collision with root package name */
    public int f10999q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11000r;

    public c0(m0 m0Var, Inflater inflater) {
        this.f10997o = m0Var;
        this.f10998p = inflater;
    }

    public final long a(l lVar, long j10) {
        Inflater inflater = this.f10998p;
        za.h.e("sink", lVar);
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
        }
        if (this.f11000r) {
            throw new IllegalStateException("closed");
        }
        if (j10 != 0) {
            try {
                n0 V = lVar.V(1);
                int min = (int) Math.min(j10, 8192 - V.f11044c);
                boolean needsInput = inflater.needsInput();
                m0 m0Var = this.f10997o;
                if (needsInput && !m0Var.t()) {
                    n0 n0Var = m0Var.f11040p.f11034o;
                    za.h.b(n0Var);
                    int i10 = n0Var.f11044c;
                    int i11 = n0Var.f11043b;
                    int i12 = i10 - i11;
                    this.f10999q = i12;
                    inflater.setInput(n0Var.f11042a, i11, i12);
                }
                int inflate = inflater.inflate(V.f11042a, V.f11044c, min);
                int i13 = this.f10999q;
                if (i13 != 0) {
                    int remaining = i13 - inflater.getRemaining();
                    this.f10999q -= remaining;
                    m0Var.skip(remaining);
                }
                if (inflate > 0) {
                    V.f11044c += inflate;
                    long j11 = inflate;
                    lVar.f11035p += j11;
                    return j11;
                }
                if (V.f11043b == V.f11044c) {
                    lVar.f11034o = V.a();
                    o0.a(V);
                }
            } catch (DataFormatException e7) {
                throw new IOException(e7);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f11000r) {
            return;
        }
        this.f10998p.end();
        this.f11000r = true;
        this.f10997o.close();
    }

    @Override // rb.s0
    public final long read(l lVar, long j10) {
        za.h.e("sink", lVar);
        do {
            long a10 = a(lVar, j10);
            if (a10 > 0) {
                return a10;
            }
            Inflater inflater = this.f10998p;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f10997o.t());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // rb.s0
    public final v0 timeout() {
        return this.f10997o.f11039o.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c0(s0 s0Var, Inflater inflater) {
        this(b.c(s0Var), inflater);
        za.h.e("source", s0Var);
    }
}
