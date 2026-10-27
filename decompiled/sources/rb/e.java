package rb;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements q0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11004o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f11005p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f11006q;

    public /* synthetic */ e(Object obj, int i10, Object obj2) {
        this.f11004o = i10;
        this.f11005p = obj;
        this.f11006q = obj2;
    }

    @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f11004o) {
            case 0:
                g gVar = (g) this.f11005p;
                q0 q0Var = (q0) this.f11006q;
                gVar.enter();
                try {
                    q0Var.close();
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e7) {
                    if (!gVar.exit()) {
                        throw e7;
                    }
                    throw gVar.access$newTimeoutException(e7);
                } finally {
                    gVar.exit();
                }
            default:
                ((OutputStream) this.f11005p).close();
                return;
        }
    }

    @Override // rb.q0, java.io.Flushable
    public final void flush() {
        switch (this.f11004o) {
            case 0:
                g gVar = (g) this.f11005p;
                q0 q0Var = (q0) this.f11006q;
                gVar.enter();
                try {
                    q0Var.flush();
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e7) {
                    if (!gVar.exit()) {
                        throw e7;
                    }
                    throw gVar.access$newTimeoutException(e7);
                } finally {
                    gVar.exit();
                }
            default:
                ((OutputStream) this.f11005p).flush();
                return;
        }
    }

    @Override // rb.q0
    public final v0 timeout() {
        switch (this.f11004o) {
            case 0:
                return (g) this.f11005p;
            default:
                return (v0) this.f11006q;
        }
    }

    public final String toString() {
        switch (this.f11004o) {
            case 0:
                return "AsyncTimeout.sink(" + ((q0) this.f11006q) + ')';
            default:
                return "sink(" + ((OutputStream) this.f11005p) + ')';
        }
    }

    @Override // rb.q0
    public final void write(l lVar, long j10) {
        switch (this.f11004o) {
            case 0:
                za.h.e("source", lVar);
                b.e(lVar.f11035p, 0L, j10);
                long j11 = j10;
                while (true) {
                    long j12 = 0;
                    if (j11 <= 0) {
                        return;
                    }
                    n0 n0Var = lVar.f11034o;
                    za.h.b(n0Var);
                    while (true) {
                        if (j12 < 65536) {
                            j12 += n0Var.f11044c - n0Var.f11043b;
                            if (j12 >= j11) {
                                j12 = j11;
                            } else {
                                n0Var = n0Var.f11047f;
                                za.h.b(n0Var);
                            }
                        }
                    }
                    g gVar = (g) this.f11005p;
                    q0 q0Var = (q0) this.f11006q;
                    gVar.enter();
                    try {
                        try {
                            q0Var.write(lVar, j12);
                            if (gVar.exit()) {
                                throw gVar.access$newTimeoutException(null);
                            }
                            j11 -= j12;
                        } catch (IOException e7) {
                            if (!gVar.exit()) {
                                throw e7;
                            }
                            throw gVar.access$newTimeoutException(e7);
                        }
                    } catch (Throwable th) {
                        gVar.exit();
                        throw th;
                    }
                }
            default:
                za.h.e("source", lVar);
                b.e(lVar.f11035p, 0L, j10);
                while (j10 > 0) {
                    ((v0) this.f11006q).throwIfReached();
                    n0 n0Var2 = lVar.f11034o;
                    za.h.b(n0Var2);
                    int min = (int) Math.min(j10, n0Var2.f11044c - n0Var2.f11043b);
                    ((OutputStream) this.f11005p).write(n0Var2.f11042a, n0Var2.f11043b, min);
                    int i10 = n0Var2.f11043b + min;
                    n0Var2.f11043b = i10;
                    long j13 = min;
                    j10 -= j13;
                    lVar.f11035p -= j13;
                    if (i10 == n0Var2.f11044c) {
                        lVar.f11034o = n0Var2.a();
                        o0.a(n0Var2);
                    }
                }
                return;
        }
    }
}
