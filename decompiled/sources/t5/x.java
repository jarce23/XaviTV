package t5;

import j9.v1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x implements y, n6.b {

    /* renamed from: s, reason: collision with root package name */
    public static final android.support.v4.media.session.a0 f12003s = n6.c.a(20, new v1(19));

    /* renamed from: o, reason: collision with root package name */
    public final n6.d f12004o = new n6.d();

    /* renamed from: p, reason: collision with root package name */
    public y f12005p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12006q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12007r;

    public final synchronized void a() {
        this.f12004o.a();
        if (!this.f12006q) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f12006q = false;
        if (this.f12007r) {
            e();
        }
    }

    @Override // n6.b
    public final n6.d b() {
        return this.f12004o;
    }

    @Override // t5.y
    public final int c() {
        return this.f12005p.c();
    }

    @Override // t5.y
    public final Class d() {
        return this.f12005p.d();
    }

    @Override // t5.y
    public final synchronized void e() {
        this.f12004o.a();
        this.f12007r = true;
        if (!this.f12006q) {
            this.f12005p.e();
            this.f12005p = null;
            f12003s.m(this);
        }
    }

    @Override // t5.y
    public final Object get() {
        return this.f12005p.get();
    }
}
