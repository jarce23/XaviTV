package t5;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements y {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f11985o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f11986p;

    /* renamed from: q, reason: collision with root package name */
    public final y f11987q;

    /* renamed from: r, reason: collision with root package name */
    public final r f11988r;

    /* renamed from: s, reason: collision with root package name */
    public final r5.e f11989s;

    /* renamed from: t, reason: collision with root package name */
    public int f11990t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11991u;

    public s(y yVar, boolean z10, boolean z11, r5.e eVar, r rVar) {
        m6.f.c("Argument must not be null", yVar);
        this.f11987q = yVar;
        this.f11985o = z10;
        this.f11986p = z11;
        this.f11989s = eVar;
        m6.f.c("Argument must not be null", rVar);
        this.f11988r = rVar;
    }

    public final synchronized void a() {
        if (this.f11991u) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f11990t++;
    }

    public final void b() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f11990t;
            if (i10 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z10 = true;
            int i11 = i10 - 1;
            this.f11990t = i11;
            if (i11 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            ((k) this.f11988r).f(this.f11989s, this);
        }
    }

    @Override // t5.y
    public final int c() {
        return this.f11987q.c();
    }

    @Override // t5.y
    public final Class d() {
        return this.f11987q.d();
    }

    @Override // t5.y
    public final synchronized void e() {
        if (this.f11990t > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f11991u) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f11991u = true;
        if (this.f11986p) {
            this.f11987q.e();
        }
    }

    @Override // t5.y
    public final Object get() {
        return this.f11987q.get();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f11985o + ", listener=" + this.f11988r + ", key=" + this.f11989s + ", acquired=" + this.f11990t + ", isRecycled=" + this.f11991u + ", resource=" + this.f11987q + '}';
    }
}
