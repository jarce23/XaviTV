package r1;

import java.util.ArrayDeque;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final g f10418a;

    /* renamed from: e, reason: collision with root package name */
    public final e[] f10422e;

    /* renamed from: f, reason: collision with root package name */
    public final f[] f10423f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f10424h;

    /* renamed from: i, reason: collision with root package name */
    public e f10425i;

    /* renamed from: j, reason: collision with root package name */
    public c f10426j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10427k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10428l;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10419b = new Object();

    /* renamed from: m, reason: collision with root package name */
    public long f10429m = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f10420c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f10421d = new ArrayDeque();

    public h(e[] eVarArr, f[] fVarArr) {
        this.f10422e = eVarArr;
        this.g = eVarArr.length;
        for (int i10 = 0; i10 < this.g; i10++) {
            this.f10422e[i10] = g();
        }
        this.f10423f = fVarArr;
        this.f10424h = fVarArr.length;
        for (int i11 = 0; i11 < this.f10424h; i11++) {
            this.f10423f[i11] = h();
        }
        g gVar = new g(this);
        this.f10418a = gVar;
        gVar.start();
    }

    @Override // r1.b
    public final void a() {
        synchronized (this.f10419b) {
            this.f10428l = true;
            this.f10419b.notify();
        }
        try {
            this.f10418a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // r1.b
    public final void c(long j10) {
        boolean z10;
        synchronized (this.f10419b) {
            try {
                if (this.g != this.f10422e.length && !this.f10427k) {
                    z10 = false;
                    l1.d.g(z10);
                    this.f10429m = j10;
                }
                z10 = true;
                l1.d.g(z10);
                this.f10429m = j10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // r1.b
    public final Object f() {
        e eVar;
        synchronized (this.f10419b) {
            try {
                c cVar = this.f10426j;
                if (cVar != null) {
                    throw cVar;
                }
                l1.d.g(this.f10425i == null);
                int i10 = this.g;
                if (i10 == 0) {
                    eVar = null;
                } else {
                    e[] eVarArr = this.f10422e;
                    int i11 = i10 - 1;
                    this.g = i11;
                    eVar = eVarArr[i11];
                }
                this.f10425i = eVar;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // r1.b
    public final void flush() {
        synchronized (this.f10419b) {
            try {
                this.f10427k = true;
                e eVar = this.f10425i;
                if (eVar != null) {
                    eVar.j();
                    e[] eVarArr = this.f10422e;
                    int i10 = this.g;
                    this.g = i10 + 1;
                    eVarArr[i10] = eVar;
                    this.f10425i = null;
                }
                while (!this.f10420c.isEmpty()) {
                    e eVar2 = (e) this.f10420c.removeFirst();
                    eVar2.j();
                    e[] eVarArr2 = this.f10422e;
                    int i11 = this.g;
                    this.g = i11 + 1;
                    eVarArr2[i11] = eVar2;
                }
                while (!this.f10421d.isEmpty()) {
                    ((f) this.f10421d.removeFirst()).k();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract e g();

    public abstract f h();

    public abstract c i(Throwable th);

    public abstract c j(e eVar, f fVar, boolean z10);

    public final boolean k() {
        c i10;
        synchronized (this.f10419b) {
            while (!this.f10428l) {
                try {
                    if (!this.f10420c.isEmpty() && this.f10424h > 0) {
                        break;
                    }
                    this.f10419b.wait();
                } finally {
                }
            }
            if (this.f10428l) {
                return false;
            }
            e eVar = (e) this.f10420c.removeFirst();
            f[] fVarArr = this.f10423f;
            int i11 = this.f10424h - 1;
            this.f10424h = i11;
            f fVar = fVarArr[i11];
            boolean z10 = this.f10427k;
            this.f10427k = false;
            if (eVar.d(4)) {
                fVar.b(4);
            } else {
                fVar.f10415q = eVar.f10412u;
                if (eVar.d(134217728)) {
                    fVar.b(134217728);
                }
                if (!m(eVar.f10412u)) {
                    fVar.f10416r = true;
                }
                try {
                    i10 = j(eVar, fVar, z10);
                } catch (OutOfMemoryError e7) {
                    i10 = i(e7);
                } catch (RuntimeException e8) {
                    i10 = i(e8);
                }
                if (i10 != null) {
                    synchronized (this.f10419b) {
                        this.f10426j = i10;
                    }
                    return false;
                }
            }
            synchronized (this.f10419b) {
                try {
                    if (this.f10427k) {
                        fVar.k();
                    } else if (fVar.f10416r) {
                        fVar.k();
                    } else {
                        this.f10421d.addLast(fVar);
                    }
                    eVar.j();
                    e[] eVarArr = this.f10422e;
                    int i12 = this.g;
                    this.g = i12 + 1;
                    eVarArr[i12] = eVar;
                } finally {
                }
            }
            return true;
        }
    }

    @Override // r1.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final f e() {
        synchronized (this.f10419b) {
            try {
                c cVar = this.f10426j;
                if (cVar != null) {
                    throw cVar;
                }
                if (this.f10421d.isEmpty()) {
                    return null;
                }
                return (f) this.f10421d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean m(long j10) {
        boolean z10;
        synchronized (this.f10419b) {
            long j11 = this.f10429m;
            z10 = j11 == -9223372036854775807L || j10 >= j11;
        }
        return z10;
    }

    @Override // r1.b
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void b(e eVar) {
        synchronized (this.f10419b) {
            try {
                c cVar = this.f10426j;
                if (cVar != null) {
                    throw cVar;
                }
                l1.d.b(eVar == this.f10425i);
                this.f10420c.addLast(eVar);
                if (!this.f10420c.isEmpty() && this.f10424h > 0) {
                    this.f10419b.notify();
                }
                this.f10425i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(f fVar) {
        synchronized (this.f10419b) {
            fVar.j();
            f[] fVarArr = this.f10423f;
            int i10 = this.f10424h;
            this.f10424h = i10 + 1;
            fVarArr[i10] = fVar;
            if (!this.f10420c.isEmpty() && this.f10424h > 0) {
                this.f10419b.notify();
            }
        }
    }
}
