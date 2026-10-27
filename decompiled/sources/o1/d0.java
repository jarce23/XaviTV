package o1;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 implements h {

    /* renamed from: o, reason: collision with root package name */
    public final h f9391o;

    /* renamed from: p, reason: collision with root package name */
    public final p1.d f9392p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9393q;

    /* renamed from: r, reason: collision with root package name */
    public long f9394r;

    public d0(h hVar, p1.d dVar) {
        hVar.getClass();
        this.f9391o = hVar;
        dVar.getClass();
        this.f9392p = dVar;
    }

    @Override // o1.h
    public final void close() {
        p1.d dVar = this.f9392p;
        try {
            this.f9391o.close();
            if (this.f9393q) {
                this.f9393q = false;
                if (dVar.f9817d == null) {
                    return;
                }
                try {
                    dVar.a();
                } catch (IOException e7) {
                    throw new p1.c(e7);
                }
            }
        } catch (Throwable th) {
            if (this.f9393q) {
                this.f9393q = false;
                if (dVar.f9817d != null) {
                    try {
                        dVar.a();
                    } catch (IOException e8) {
                        throw new p1.c(e8);
                    }
                }
            }
            throw th;
        }
    }

    @Override // o1.h
    public final Map e() {
        return this.f9391o.e();
    }

    @Override // o1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f9391o.g(e0Var);
    }

    @Override // o1.h
    public final long j(l lVar) {
        long j10 = this.f9391o.j(lVar);
        this.f9394r = j10;
        if (j10 == 0) {
            return 0L;
        }
        if (lVar.g == -1 && j10 != -1) {
            lVar = lVar.c(0L, j10);
        }
        int i10 = lVar.f9435i;
        this.f9393q = true;
        p1.d dVar = this.f9392p;
        dVar.getClass();
        lVar.f9434h.getClass();
        if (lVar.g == -1 && (i10 & 2) == 2) {
            dVar.f9817d = null;
        } else {
            dVar.f9817d = lVar;
            dVar.f9818e = (i10 & 4) == 4 ? dVar.f9815b : Long.MAX_VALUE;
            dVar.f9821i = 0L;
            try {
                dVar.b(lVar);
            } catch (IOException e7) {
                throw new p1.c(e7);
            }
        }
        return this.f9394r;
    }

    @Override // o1.h
    public final Uri l() {
        return this.f9391o.l();
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (this.f9394r == 0) {
            return -1;
        }
        int read = this.f9391o.read(bArr, i10, i11);
        if (read > 0) {
            p1.d dVar = this.f9392p;
            l lVar = dVar.f9817d;
            if (lVar != null) {
                int i12 = 0;
                while (i12 < read) {
                    try {
                        if (dVar.f9820h == dVar.f9818e) {
                            dVar.a();
                            dVar.b(lVar);
                        }
                        int min = (int) Math.min(read - i12, dVar.f9818e - dVar.f9820h);
                        OutputStream outputStream = dVar.g;
                        int i13 = l1.a0.f8067a;
                        outputStream.write(bArr, i10 + i12, min);
                        i12 += min;
                        long j10 = min;
                        dVar.f9820h += j10;
                        dVar.f9821i += j10;
                    } catch (IOException e7) {
                        throw new p1.c(e7);
                    }
                }
            }
            long j11 = this.f9394r;
            if (j11 != -1) {
                this.f9394r = j11 - read;
            }
        }
        return read;
    }
}
