package c2;

import android.net.Uri;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r0 implements g2.k {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f2695a;

    /* renamed from: b, reason: collision with root package name */
    public final o1.c0 f2696b;

    /* renamed from: c, reason: collision with root package name */
    public final x4.m f2697c;

    /* renamed from: d, reason: collision with root package name */
    public final u0 f2698d;

    /* renamed from: e, reason: collision with root package name */
    public final l1.g f2699e;
    public volatile boolean g;

    /* renamed from: i, reason: collision with root package name */
    public long f2702i;

    /* renamed from: j, reason: collision with root package name */
    public o1.l f2703j;

    /* renamed from: k, reason: collision with root package name */
    public k2.g0 f2704k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2705l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ u0 f2706m;

    /* renamed from: f, reason: collision with root package name */
    public final i1.s f2700f = new i1.s();

    /* renamed from: h, reason: collision with root package name */
    public boolean f2701h = true;

    public r0(u0 u0Var, Uri uri, o1.h hVar, x4.m mVar, u0 u0Var2, l1.g gVar) {
        this.f2706m = u0Var;
        this.f2695a = uri;
        this.f2696b = new o1.c0(hVar);
        this.f2697c = mVar;
        this.f2698d = u0Var2;
        this.f2699e = gVar;
        u.f2717b.getAndIncrement();
        this.f2703j = c(0L);
    }

    @Override // g2.k
    public final void a() {
        o1.h hVar;
        k2.n nVar;
        int i10;
        int i11 = 0;
        while (i11 == 0 && !this.g) {
            try {
                long j10 = this.f2700f.f6018a;
                o1.l c10 = c(j10);
                this.f2703j = c10;
                long j11 = this.f2696b.j(c10);
                if (this.g) {
                    if (i11 != 1 && this.f2697c.x() != -1) {
                        this.f2700f.f6018a = this.f2697c.x();
                    }
                    j1.c.f(this.f2696b);
                    return;
                }
                if (j11 != -1) {
                    j11 += j10;
                    u0 u0Var = this.f2706m;
                    u0Var.E.post(new p0(u0Var, 0));
                }
                long j12 = j11;
                this.f2706m.G = x2.b.d(this.f2696b.f9388o.e());
                o1.c0 c0Var = this.f2696b;
                x2.b bVar = this.f2706m.G;
                if (bVar == null || (i10 = bVar.f13498f) == -1) {
                    hVar = c0Var;
                } else {
                    hVar = new t(c0Var, i10, this);
                    k2.g0 D = this.f2706m.D(new t0(0, true));
                    this.f2704k = D;
                    D.a(u0.f2720e0);
                }
                this.f2697c.B(hVar, this.f2695a, this.f2696b.f9388o.e(), j10, j12, this.f2698d);
                if (this.f2706m.G != null && (nVar = (k2.n) this.f2697c.f13565q) != null) {
                    k2.n b2 = nVar.b();
                    if (b2 instanceof d3.d) {
                        ((d3.d) b2).f4036r = true;
                    }
                }
                if (this.f2701h) {
                    x4.m mVar = this.f2697c;
                    long j13 = this.f2702i;
                    k2.n nVar2 = (k2.n) mVar.f13565q;
                    nVar2.getClass();
                    nVar2.e(j10, j13);
                    this.f2701h = false;
                }
                while (i11 == 0 && !this.g) {
                    try {
                        this.f2699e.a();
                        x4.m mVar2 = this.f2697c;
                        i1.s sVar = this.f2700f;
                        k2.n nVar3 = (k2.n) mVar2.f13565q;
                        nVar3.getClass();
                        k2.k kVar = (k2.k) mVar2.f13566r;
                        kVar.getClass();
                        i11 = nVar3.f(kVar, sVar);
                        long x6 = this.f2697c.x();
                        if (x6 > this.f2706m.f2732w + j10) {
                            this.f2699e.e();
                            u0 u0Var2 = this.f2706m;
                            u0Var2.E.post(u0Var2.D);
                            j10 = x6;
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                if (i11 == 1) {
                    i11 = 0;
                } else if (this.f2697c.x() != -1) {
                    this.f2700f.f6018a = this.f2697c.x();
                }
                j1.c.f(this.f2696b);
            } catch (Throwable th) {
                if (i11 != 1 && this.f2697c.x() != -1) {
                    this.f2700f.f6018a = this.f2697c.x();
                }
                j1.c.f(this.f2696b);
                throw th;
            }
        }
    }

    @Override // g2.k
    public final void b() {
        this.g = true;
    }

    public final o1.l c(long j10) {
        Map map = Collections.EMPTY_MAP;
        Map map2 = u0.f2719d0;
        Uri uri = this.f2695a;
        l1.d.i("The uri must be set.", uri);
        return new o1.l(uri, 0L, 1, null, map2, j10, -1L, null, 6);
    }
}
