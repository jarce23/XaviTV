package p1;

import android.net.Uri;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import l1.a0;
import o1.d0;
import o1.e0;
import o1.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements o1.h {
    public long A;
    public long B;
    public t C;
    public boolean D;
    public boolean E;
    public long F;

    /* renamed from: o, reason: collision with root package name */
    public final b f9823o;

    /* renamed from: p, reason: collision with root package name */
    public final o1.h f9824p;

    /* renamed from: q, reason: collision with root package name */
    public final d0 f9825q;

    /* renamed from: r, reason: collision with root package name */
    public final o1.h f9826r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f9827s = false;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f9828t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f9829u;

    /* renamed from: v, reason: collision with root package name */
    public Uri f9830v;

    /* renamed from: w, reason: collision with root package name */
    public o1.l f9831w;

    /* renamed from: x, reason: collision with root package name */
    public o1.l f9832x;

    /* renamed from: y, reason: collision with root package name */
    public o1.h f9833y;

    /* renamed from: z, reason: collision with root package name */
    public long f9834z;

    public e(b bVar, o1.h hVar, o1.h hVar2, d dVar, int i10) {
        this.f9823o = bVar;
        this.f9824p = hVar2;
        this.f9828t = (i10 & 2) != 0;
        this.f9829u = false;
        if (hVar != null) {
            this.f9826r = hVar;
            this.f9825q = dVar != null ? new d0(hVar, dVar) : null;
        } else {
            this.f9826r = z.f9465o;
            this.f9825q = null;
        }
    }

    @Override // o1.h
    public final void close() {
        this.f9831w = null;
        this.f9830v = null;
        this.A = 0L;
        try {
            f();
        } catch (Throwable th) {
            if (this.f9833y == this.f9824p || (th instanceof a)) {
                this.D = true;
            }
            throw th;
        }
    }

    @Override // o1.h
    public final Map e() {
        return !(this.f9833y == this.f9824p) ? this.f9826r.e() : Collections.EMPTY_MAP;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        b bVar = this.f9823o;
        o1.h hVar = this.f9833y;
        if (hVar == null) {
            return;
        }
        try {
            hVar.close();
        } finally {
            this.f9832x = null;
            this.f9833y = null;
            t tVar = this.C;
            if (tVar != null) {
                ((s) bVar).j(tVar);
                this.C = null;
            }
        }
    }

    @Override // o1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f9824p.g(e0Var);
        this.f9826r.g(e0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:3:0x0007, B:6:0x0010, B:7:0x0016, B:9:0x0038, B:14:0x004b, B:16:0x0056, B:20:0x0066, B:22:0x006c, B:25:0x0097, B:28:0x00a3, B:29:0x009f, B:30:0x00a5, B:37:0x00b5, B:39:0x00af, B:40:0x0072, B:42:0x0083, B:45:0x008b, B:46:0x0092, B:47:0x005b, B:52:0x0044), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:3:0x0007, B:6:0x0010, B:7:0x0016, B:9:0x0038, B:14:0x004b, B:16:0x0056, B:20:0x0066, B:22:0x006c, B:25:0x0097, B:28:0x00a3, B:29:0x009f, B:30:0x00a5, B:37:0x00b5, B:39:0x00af, B:40:0x0072, B:42:0x0083, B:45:0x008b, B:46:0x0092, B:47:0x005b, B:52:0x0044), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:3:0x0007, B:6:0x0010, B:7:0x0016, B:9:0x0038, B:14:0x004b, B:16:0x0056, B:20:0x0066, B:22:0x006c, B:25:0x0097, B:28:0x00a3, B:29:0x009f, B:30:0x00a5, B:37:0x00b5, B:39:0x00af, B:40:0x0072, B:42:0x0083, B:45:0x008b, B:46:0x0092, B:47:0x005b, B:52:0x0044), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:3:0x0007, B:6:0x0010, B:7:0x0016, B:9:0x0038, B:14:0x004b, B:16:0x0056, B:20:0x0066, B:22:0x006c, B:25:0x0097, B:28:0x00a3, B:29:0x009f, B:30:0x00a5, B:37:0x00b5, B:39:0x00af, B:40:0x0072, B:42:0x0083, B:45:0x008b, B:46:0x0092, B:47:0x005b, B:52:0x0044), top: B:2:0x0007 }] */
    @Override // o1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long j(o1.l r18) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.e.j(o1.l):long");
    }

    @Override // o1.h
    public final Uri l() {
        return this.f9830v;
    }

    public final void q(o1.l lVar, boolean z10) {
        t l10;
        o1.l a10;
        o1.h hVar;
        String str = lVar.f9434h;
        int i10 = a0.f8067a;
        if (this.E) {
            l10 = null;
        } else if (this.f9827s) {
            try {
                b bVar = this.f9823o;
                long j10 = this.A;
                long j11 = this.B;
                s sVar = (s) bVar;
                synchronized (sVar) {
                    sVar.d();
                    while (true) {
                        l10 = sVar.l(j10, j11, str);
                        if (l10 != null) {
                            break;
                        } else {
                            sVar.wait();
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            l10 = ((s) this.f9823o).l(this.A, this.B, str);
        }
        if (l10 == null) {
            hVar = this.f9826r;
            o1.k a11 = lVar.a();
            a11.f9425f = this.A;
            a11.g = this.B;
            a10 = a11.a();
        } else if (l10.f9844r) {
            Uri fromFile = Uri.fromFile(l10.f9845s);
            long j12 = l10.f9842p;
            long j13 = this.A - j12;
            long j14 = l10.f9843q - j13;
            long j15 = this.B;
            if (j15 != -1) {
                j14 = Math.min(j14, j15);
            }
            o1.k a12 = lVar.a();
            a12.f9420a = fromFile;
            a12.f9421b = j12;
            a12.f9425f = j13;
            a12.g = j14;
            a10 = a12.a();
            hVar = this.f9824p;
        } else {
            long j16 = l10.f9843q;
            if (j16 == -1) {
                j16 = this.B;
            } else {
                long j17 = this.B;
                if (j17 != -1) {
                    j16 = Math.min(j16, j17);
                }
            }
            o1.k a13 = lVar.a();
            a13.f9425f = this.A;
            a13.g = j16;
            a10 = a13.a();
            hVar = this.f9825q;
            if (hVar == null) {
                hVar = this.f9826r;
                ((s) this.f9823o).j(l10);
                l10 = null;
            }
        }
        this.F = (this.E || hVar != this.f9826r) ? Long.MAX_VALUE : this.A + 102400;
        if (z10) {
            l1.d.g(this.f9833y == this.f9826r);
            if (hVar == this.f9826r) {
                return;
            }
            try {
                f();
            } catch (Throwable th) {
                if (!l10.f9844r) {
                    ((s) this.f9823o).j(l10);
                }
                throw th;
            }
        }
        if (l10 != null && !l10.f9844r) {
            this.C = l10;
        }
        this.f9833y = hVar;
        this.f9832x = a10;
        this.f9834z = 0L;
        long j18 = hVar.j(a10);
        g gVar = new g();
        if (a10.g == -1 && j18 != -1) {
            this.B = j18;
            gVar.a("exo_len", Long.valueOf(this.A + j18));
        }
        if (!(this.f9833y == this.f9824p)) {
            Uri l11 = hVar.l();
            this.f9830v = l11;
            Uri uri = lVar.f9428a.equals(l11) ? null : this.f9830v;
            if (uri == null) {
                ((ArrayList) gVar.f9839b).add("exo_redir");
                ((HashMap) gVar.f9838a).remove("exo_redir");
            } else {
                gVar.a("exo_redir", uri.toString());
            }
        }
        if (this.f9833y == this.f9825q) {
            ((s) this.f9823o).c(str, gVar);
        }
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        int i12;
        long j10;
        o1.h hVar = this.f9824p;
        if (i11 == 0) {
            return 0;
        }
        if (this.B == 0) {
            return -1;
        }
        o1.l lVar = this.f9831w;
        lVar.getClass();
        o1.l lVar2 = this.f9832x;
        lVar2.getClass();
        try {
            if (this.A >= this.F) {
                q(lVar, true);
            }
            o1.h hVar2 = this.f9833y;
            hVar2.getClass();
            int read = hVar2.read(bArr, i10, i11);
            if (read != -1) {
                long j11 = read;
                this.A += j11;
                this.f9834z += j11;
                long j12 = this.B;
                if (j12 == -1) {
                    return read;
                }
                this.B = j12 - j11;
                return read;
            }
            o1.h hVar3 = this.f9833y;
            if (!(hVar3 == hVar)) {
                j10 = -1;
                long j13 = lVar2.g;
                if (j13 != -1) {
                    i12 = read;
                    if (this.f9834z < j13) {
                    }
                } else {
                    i12 = read;
                }
                String str = lVar.f9434h;
                int i13 = a0.f8067a;
                this.B = 0L;
                if (!(hVar3 == this.f9825q)) {
                    return i12;
                }
                g gVar = new g();
                gVar.a("exo_len", Long.valueOf(this.A));
                ((s) this.f9823o).c(str, gVar);
                return i12;
            }
            i12 = read;
            j10 = -1;
            long j14 = this.B;
            if (j14 <= 0 && j14 != j10) {
                return i12;
            }
            f();
            q(lVar, false);
            return read(bArr, i10, i11);
        } catch (Throwable th) {
            if (this.f9833y == hVar || (th instanceof a)) {
                this.D = true;
            }
            throw th;
        }
    }
}
