package io.realm;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends a0 {

    /* renamed from: c, reason: collision with root package name */
    public final ThreadLocal f6628c = new ThreadLocal();

    @Override // io.realm.a0
    public final void a() {
        ThreadLocal threadLocal = this.f6628c;
        String str = ((d) threadLocal.get()).f6645q.f6666c;
        this.f6626a.set(null);
        threadLocal.set(null);
        if (this.f6627b.decrementAndGet() < 0) {
            throw new IllegalStateException(android.support.v4.media.d.q("Global reference counter of Realm", str, " can not be negative."));
        }
    }

    @Override // io.realm.a0
    public final d b() {
        return (d) this.f6628c.get();
    }

    @Override // io.realm.a0
    public final int c() {
        Integer num = (Integer) this.f6626a.get();
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // io.realm.a0
    public final boolean d() {
        return this.f6628c.get() != null;
    }

    @Override // io.realm.a0
    public final void e(d dVar) {
        this.f6628c.set(dVar);
        this.f6626a.set(0);
        this.f6627b.incrementAndGet();
    }
}
