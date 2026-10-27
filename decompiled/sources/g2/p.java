package g2;

import android.net.Uri;
import c2.u;
import l1.a0;
import o1.c0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements k {

    /* renamed from: b, reason: collision with root package name */
    public final o1.l f5134b;

    /* renamed from: d, reason: collision with root package name */
    public final c0 f5136d;

    /* renamed from: e, reason: collision with root package name */
    public final o f5137e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f5138f;

    /* renamed from: c, reason: collision with root package name */
    public final int f5135c = 4;

    /* renamed from: a, reason: collision with root package name */
    public final long f5133a = u.f2717b.getAndIncrement();

    public p(o1.h hVar, o1.l lVar, o oVar) {
        this.f5136d = new c0(hVar);
        this.f5134b = lVar;
        this.f5137e = oVar;
    }

    @Override // g2.k
    public final void a() {
        this.f5136d.f9389p = 0L;
        o1.j jVar = new o1.j(this.f5136d, this.f5134b);
        try {
            jVar.a();
            Uri l10 = this.f5136d.f9388o.l();
            l10.getClass();
            this.f5138f = this.f5137e.a(l10, jVar);
        } finally {
            a0.g(jVar);
        }
    }

    @Override // g2.k
    public final void b() {
    }
}
