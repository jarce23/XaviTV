package s1;

import android.os.Looper;
import j9.v1;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final f.j f11392a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.v f11393b;

    /* renamed from: c, reason: collision with root package name */
    public n9.h f11394c;

    /* renamed from: d, reason: collision with root package name */
    public n9.h f11395d;

    /* renamed from: e, reason: collision with root package name */
    public n9.h f11396e;

    /* renamed from: f, reason: collision with root package name */
    public final m f11397f;
    public final Looper g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11398h;

    /* renamed from: i, reason: collision with root package name */
    public final i1.d f11399i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11400j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f11401k;

    /* renamed from: l, reason: collision with root package name */
    public final f1 f11402l;

    /* renamed from: m, reason: collision with root package name */
    public final e1 f11403m;

    /* renamed from: n, reason: collision with root package name */
    public final long f11404n;

    /* renamed from: o, reason: collision with root package name */
    public final long f11405o;

    /* renamed from: p, reason: collision with root package name */
    public final long f11406p;

    /* renamed from: q, reason: collision with root package name */
    public final g f11407q;

    /* renamed from: r, reason: collision with root package name */
    public final long f11408r;

    /* renamed from: s, reason: collision with root package name */
    public final long f11409s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f11410t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11411u;

    /* renamed from: v, reason: collision with root package name */
    public final String f11412v;

    public n(f.j jVar) {
        m mVar = new m(jVar, 0);
        m mVar2 = new m(jVar, 1);
        m mVar3 = new m(jVar, 2);
        m mVar4 = new m(jVar, 3);
        this.f11392a = jVar;
        this.f11394c = mVar;
        this.f11395d = mVar2;
        this.f11396e = mVar3;
        this.f11397f = mVar4;
        int i10 = l1.a0.f8067a;
        Looper myLooper = Looper.myLooper();
        this.g = myLooper == null ? Looper.getMainLooper() : myLooper;
        this.f11399i = i1.d.f5843b;
        this.f11400j = 1;
        this.f11401k = true;
        this.f11402l = f1.f11292c;
        this.f11404n = 5000L;
        this.f11405o = 15000L;
        this.f11406p = 3000L;
        this.f11403m = e1.f11279b;
        this.f11407q = new g(l1.a0.O(20L), l1.a0.O(500L));
        this.f11393b = l1.v.f8135a;
        this.f11408r = 500L;
        this.f11409s = 2000L;
        this.f11410t = true;
        this.f11412v = _UrlKt.FRAGMENT_ENCODE_SET;
        this.f11398h = -1000;
        new v1();
    }

    public final a0 a() {
        l1.d.g(!this.f11411u);
        this.f11411u = true;
        return new a0(this);
    }

    public final void b(c2.r rVar) {
        l1.d.g(!this.f11411u);
        this.f11395d = new c2.p(3, rVar);
    }

    public final void c(j jVar) {
        l1.d.g(!this.f11411u);
        this.f11394c = new c2.p(4, jVar);
    }

    public final void d(f2.w wVar) {
        l1.d.g(!this.f11411u);
        wVar.getClass();
        this.f11396e = new c2.p(2, wVar);
    }
}
