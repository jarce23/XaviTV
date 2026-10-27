package i6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements d, c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6422a;

    /* renamed from: b, reason: collision with root package name */
    public final d f6423b;

    /* renamed from: c, reason: collision with root package name */
    public volatile c f6424c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f6425d;

    /* renamed from: e, reason: collision with root package name */
    public int f6426e = 3;

    /* renamed from: f, reason: collision with root package name */
    public int f6427f = 3;

    public b(Object obj, d dVar) {
        this.f6422a = obj;
        this.f6423b = dVar;
    }

    @Override // i6.d, i6.c
    public final boolean a() {
        boolean z10;
        synchronized (this.f6422a) {
            try {
                z10 = this.f6424c.a() || this.f6425d.a();
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.d
    public final boolean b(c cVar) {
        boolean z10;
        int i10;
        synchronized (this.f6422a) {
            d dVar = this.f6423b;
            z10 = false;
            if (dVar == null || dVar.b(this)) {
                if (this.f6426e != 5 ? cVar.equals(this.f6424c) : cVar.equals(this.f6425d) && ((i10 = this.f6427f) == 4 || i10 == 5)) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    @Override // i6.d
    public final boolean c(c cVar) {
        boolean z10;
        synchronized (this.f6422a) {
            d dVar = this.f6423b;
            z10 = dVar == null || dVar.c(this);
        }
        return z10;
    }

    @Override // i6.c
    public final void clear() {
        synchronized (this.f6422a) {
            try {
                this.f6426e = 3;
                this.f6424c.clear();
                if (this.f6427f != 3) {
                    this.f6427f = 3;
                    this.f6425d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i6.d
    public final boolean d(c cVar) {
        boolean z10;
        synchronized (this.f6422a) {
            d dVar = this.f6423b;
            z10 = (dVar == null || dVar.d(this)) && cVar.equals(this.f6424c);
        }
        return z10;
    }

    @Override // i6.c
    public final boolean e() {
        boolean z10;
        synchronized (this.f6422a) {
            try {
                z10 = this.f6426e == 3 && this.f6427f == 3;
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.d
    public final void f(c cVar) {
        synchronized (this.f6422a) {
            try {
                if (cVar.equals(this.f6424c)) {
                    this.f6426e = 4;
                } else if (cVar.equals(this.f6425d)) {
                    this.f6427f = 4;
                }
                d dVar = this.f6423b;
                if (dVar != null) {
                    dVar.f(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i6.c
    public final void g() {
        synchronized (this.f6422a) {
            try {
                if (this.f6426e != 1) {
                    this.f6426e = 1;
                    this.f6424c.g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i6.d
    public final d getRoot() {
        d root;
        synchronized (this.f6422a) {
            try {
                d dVar = this.f6423b;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // i6.d
    public final void h(c cVar) {
        synchronized (this.f6422a) {
            try {
                if (cVar.equals(this.f6425d)) {
                    this.f6427f = 5;
                    d dVar = this.f6423b;
                    if (dVar != null) {
                        dVar.h(this);
                    }
                    return;
                }
                this.f6426e = 5;
                if (this.f6427f != 1) {
                    this.f6427f = 1;
                    this.f6425d.g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i6.c
    public final boolean i() {
        boolean z10;
        synchronized (this.f6422a) {
            try {
                z10 = this.f6426e == 4 || this.f6427f == 4;
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.c
    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f6422a) {
            try {
                z10 = true;
                if (this.f6426e != 1 && this.f6427f != 1) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.c
    public final boolean j(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f6424c.j(bVar.f6424c) && this.f6425d.j(bVar.f6425d)) {
                return true;
            }
        }
        return false;
    }

    @Override // i6.c
    public final void pause() {
        synchronized (this.f6422a) {
            try {
                if (this.f6426e == 1) {
                    this.f6426e = 2;
                    this.f6424c.pause();
                }
                if (this.f6427f == 1) {
                    this.f6427f = 2;
                    this.f6425d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
