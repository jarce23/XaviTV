package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final o1.g f2746a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.fragment.app.v0 f2747b;

    /* renamed from: c, reason: collision with root package name */
    public x4.l f2748c;

    /* renamed from: d, reason: collision with root package name */
    public final n7.i f2749d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2750e;

    public w0(o1.g gVar, k2.l lVar) {
        androidx.fragment.app.v0 v0Var = new androidx.fragment.app.v0(2, lVar);
        x4.l lVar2 = new x4.l(18);
        n7.i iVar = new n7.i(19);
        this.f2746a = gVar;
        this.f2747b = v0Var;
        this.f2748c = lVar2;
        this.f2749d = iVar;
        this.f2750e = 1048576;
    }

    @Override // c2.c0
    public final c0 c(x4.l lVar) {
        l1.d.d("MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.", lVar);
        this.f2748c = lVar;
        return this;
    }

    @Override // c2.c0
    public final a d(i1.a0 a0Var) {
        a0Var.f5793b.getClass();
        return new x0(a0Var, this.f2746a, this.f2747b, this.f2748c.i(a0Var), this.f2749d, this.f2750e, null);
    }

    @Override // c2.c0
    public final c0 b() {
        return this;
    }

    @Override // c2.c0
    public final c0 a(boolean z10) {
        return this;
    }

    @Override // c2.c0
    public final c0 e(d9.f fVar) {
        return this;
    }
}
