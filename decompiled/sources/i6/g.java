package i6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements d, c {

    /* renamed from: a, reason: collision with root package name */
    public final d f6453a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6454b;

    /* renamed from: c, reason: collision with root package name */
    public volatile f f6455c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f6456d;

    /* renamed from: e, reason: collision with root package name */
    public int f6457e = 3;

    /* renamed from: f, reason: collision with root package name */
    public int f6458f = 3;
    public boolean g;

    public g(Object obj, d dVar) {
        this.f6454b = obj;
        this.f6453a = dVar;
    }

    @Override // i6.d, i6.c
    public final boolean a() {
        boolean z10;
        synchronized (this.f6454b) {
            try {
                z10 = this.f6456d.a() || this.f6455c.a();
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.d
    public final boolean b(c cVar) {
        boolean z10;
        synchronized (this.f6454b) {
            try {
                d dVar = this.f6453a;
                z10 = (dVar == null || dVar.b(this)) && cVar.equals(this.f6455c) && !a();
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.d
    public final boolean c(c cVar) {
        boolean z10;
        synchronized (this.f6454b) {
            try {
                d dVar = this.f6453a;
                z10 = (dVar == null || dVar.c(this)) && (cVar.equals(this.f6455c) || this.f6457e != 4);
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.c
    public final void clear() {
        synchronized (this.f6454b) {
            this.g = false;
            this.f6457e = 3;
            this.f6458f = 3;
            this.f6456d.clear();
            this.f6455c.clear();
        }
    }

    @Override // i6.d
    public final boolean d(c cVar) {
        boolean z10;
        synchronized (this.f6454b) {
            try {
                d dVar = this.f6453a;
                z10 = (dVar == null || dVar.d(this)) && cVar.equals(this.f6455c) && this.f6457e != 2;
            } finally {
            }
        }
        return z10;
    }

    @Override // i6.c
    public final boolean e() {
        boolean z10;
        synchronized (this.f6454b) {
            z10 = this.f6457e == 3;
        }
        return z10;
    }

    @Override // i6.d
    public final void f(c cVar) {
        synchronized (this.f6454b) {
            try {
                if (cVar.equals(this.f6456d)) {
                    this.f6458f = 4;
                    return;
                }
                this.f6457e = 4;
                d dVar = this.f6453a;
                if (dVar != null) {
                    dVar.f(this);
                }
                if (!android.support.v4.media.d.e(this.f6458f)) {
                    this.f6456d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i6.c
    public final void g() {
        synchronized (this.f6454b) {
            try {
                this.g = true;
                try {
                    if (this.f6457e != 4 && this.f6458f != 1) {
                        this.f6458f = 1;
                        this.f6456d.g();
                    }
                    if (this.g && this.f6457e != 1) {
                        this.f6457e = 1;
                        this.f6455c.g();
                    }
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // i6.d
    public final d getRoot() {
        d root;
        synchronized (this.f6454b) {
            try {
                d dVar = this.f6453a;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // i6.d
    public final void h(c cVar) {
        synchronized (this.f6454b) {
            try {
                if (!cVar.equals(this.f6455c)) {
                    this.f6458f = 5;
                    return;
                }
                this.f6457e = 5;
                d dVar = this.f6453a;
                if (dVar != null) {
                    dVar.h(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i6.c
    public final boolean i() {
        boolean z10;
        synchronized (this.f6454b) {
            z10 = this.f6457e == 4;
        }
        return z10;
    }

    @Override // i6.c
    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f6454b) {
            z10 = true;
            if (this.f6457e != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // i6.c
    public final boolean j(c cVar) {
        if (!(cVar instanceof g)) {
            return false;
        }
        g gVar = (g) cVar;
        if (this.f6455c == null) {
            if (gVar.f6455c != null) {
                return false;
            }
        } else if (!this.f6455c.j(gVar.f6455c)) {
            return false;
        }
        return this.f6456d == null ? gVar.f6456d == null : this.f6456d.j(gVar.f6456d);
    }

    @Override // i6.c
    public final void pause() {
        synchronized (this.f6454b) {
            try {
                if (!android.support.v4.media.d.e(this.f6458f)) {
                    this.f6458f = 2;
                    this.f6456d.pause();
                }
                if (!android.support.v4.media.d.e(this.f6457e)) {
                    this.f6457e = 2;
                    this.f6455c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
