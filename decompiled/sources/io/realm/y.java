package io.realm;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends a0 {

    /* renamed from: c, reason: collision with root package name */
    public d f6894c;

    @Override // io.realm.a0
    public final void a() {
        String str = this.f6894c.f6645q.f6666c;
        this.f6626a.set(null);
        this.f6894c = null;
        if (this.f6627b.decrementAndGet() < 0) {
            throw new IllegalStateException(android.support.v4.media.d.q("Global reference counter of Realm", str, " not be negative."));
        }
    }

    @Override // io.realm.a0
    public final d b() {
        return this.f6894c;
    }

    @Override // io.realm.a0
    public final int c() {
        return this.f6627b.get();
    }

    @Override // io.realm.a0
    public final boolean d() {
        return this.f6894c != null;
    }

    @Override // io.realm.a0
    public final void e(d dVar) {
        this.f6894c = dVar;
        this.f6626a.set(0);
        this.f6627b.incrementAndGet();
    }
}
