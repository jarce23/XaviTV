package t5;

import j9.v1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements n6.b {
    public static final v1 K = new v1(18);
    public boolean A;
    public y B;
    public int C;
    public boolean D;
    public u E;
    public boolean F;
    public s G;
    public h H;
    public volatile boolean I;
    public boolean J;

    /* renamed from: q, reason: collision with root package name */
    public final r f11967q;

    /* renamed from: r, reason: collision with root package name */
    public final l0.c f11968r;

    /* renamed from: t, reason: collision with root package name */
    public final p f11970t;

    /* renamed from: u, reason: collision with root package name */
    public final w5.d f11971u;

    /* renamed from: v, reason: collision with root package name */
    public final w5.d f11972v;

    /* renamed from: w, reason: collision with root package name */
    public final w5.d f11973w;

    /* renamed from: y, reason: collision with root package name */
    public q f11975y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f11976z;

    /* renamed from: o, reason: collision with root package name */
    public final n f11965o = new n(new ArrayList(2));

    /* renamed from: p, reason: collision with root package name */
    public final n6.d f11966p = new n6.d();

    /* renamed from: x, reason: collision with root package name */
    public final AtomicInteger f11974x = new AtomicInteger();

    /* renamed from: s, reason: collision with root package name */
    public final v1 f11969s = K;

    public o(w5.d dVar, w5.d dVar2, w5.d dVar3, w5.d dVar4, k kVar, k kVar2, android.support.v4.media.session.a0 a0Var) {
        this.f11971u = dVar;
        this.f11972v = dVar2;
        this.f11973w = dVar4;
        this.f11970t = kVar;
        this.f11967q = kVar2;
        this.f11968r = a0Var;
    }

    public final synchronized void a(i6.f fVar, Executor executor) {
        try {
            this.f11966p.a();
            this.f11965o.f11964o.add(new m(fVar, executor));
            if (this.D) {
                e(1);
                executor.execute(new l(this, fVar, 1));
            } else if (this.F) {
                e(1);
                executor.execute(new l(this, fVar, 0));
            } else {
                m6.f.a("Cannot add callbacks to a cancelled EngineJob", !this.I);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // n6.b
    public final n6.d b() {
        return this.f11966p;
    }

    public final void c() {
        if (f()) {
            return;
        }
        this.I = true;
        h hVar = this.H;
        hVar.Q = true;
        f fVar = hVar.O;
        if (fVar != null) {
            fVar.cancel();
        }
        p pVar = this.f11970t;
        q qVar = this.f11975y;
        k kVar = (k) pVar;
        synchronized (kVar) {
            HashMap hashMap = kVar.f11953a.f3017a;
            if (equals(hashMap.get(qVar))) {
                hashMap.remove(qVar);
            }
        }
    }

    public final void d() {
        s sVar;
        synchronized (this) {
            try {
                this.f11966p.a();
                m6.f.a("Not yet complete!", f());
                int decrementAndGet = this.f11974x.decrementAndGet();
                m6.f.a("Can't decrement below 0", decrementAndGet >= 0);
                if (decrementAndGet == 0) {
                    sVar = this.G;
                    i();
                } else {
                    sVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sVar != null) {
            sVar.b();
        }
    }

    public final synchronized void e(int i10) {
        s sVar;
        m6.f.a("Not yet complete!", f());
        if (this.f11974x.getAndAdd(i10) == 0 && (sVar = this.G) != null) {
            sVar.a();
        }
    }

    public final boolean f() {
        return this.F || this.D || this.I;
    }

    public final void g() {
        synchronized (this) {
            try {
                this.f11966p.a();
                if (this.I) {
                    i();
                    return;
                }
                if (this.f11965o.f11964o.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.F) {
                    throw new IllegalStateException("Already failed once");
                }
                this.F = true;
                q qVar = this.f11975y;
                n nVar = this.f11965o;
                nVar.getClass();
                ArrayList arrayList = new ArrayList(nVar.f11964o);
                e(arrayList.size() + 1);
                ((k) this.f11970t).e(this, qVar, null);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    m mVar = (m) obj;
                    mVar.f11963b.execute(new l(this, mVar.f11962a, 0));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this) {
            try {
                this.f11966p.a();
                if (this.I) {
                    this.B.e();
                    i();
                    return;
                }
                if (this.f11965o.f11964o.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.D) {
                    throw new IllegalStateException("Already have resource");
                }
                v1 v1Var = this.f11969s;
                y yVar = this.B;
                boolean z10 = this.f11976z;
                q qVar = this.f11975y;
                r rVar = this.f11967q;
                v1Var.getClass();
                this.G = new s(yVar, z10, true, qVar, rVar);
                this.D = true;
                n nVar = this.f11965o;
                nVar.getClass();
                ArrayList arrayList = new ArrayList(nVar.f11964o);
                e(arrayList.size() + 1);
                ((k) this.f11970t).e(this, this.f11975y, this.G);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    m mVar = (m) obj;
                    mVar.f11963b.execute(new l(this, mVar.f11962a, 1));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void i() {
        if (this.f11975y == null) {
            throw new IllegalArgumentException();
        }
        this.f11965o.f11964o.clear();
        this.f11975y = null;
        this.G = null;
        this.B = null;
        this.F = false;
        this.I = false;
        this.D = false;
        this.J = false;
        this.H.m();
        this.H = null;
        this.E = null;
        this.C = 0;
        this.f11968r.m(this);
    }

    public final synchronized void j(i6.f fVar) {
        try {
            this.f11966p.a();
            this.f11965o.f11964o.remove(new m(fVar, m6.f.f9014b));
            if (this.f11965o.f11964o.isEmpty()) {
                c();
                if (!this.D) {
                    if (this.F) {
                    }
                }
                if (this.f11974x.get() == 0) {
                    i();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(h hVar) {
        w5.d dVar;
        this.H = hVar;
        int h10 = hVar.h(1);
        if (h10 != 2 && h10 != 3) {
            dVar = this.A ? this.f11973w : this.f11972v;
            dVar.execute(hVar);
        }
        dVar = this.f11971u;
        dVar.execute(hVar);
    }
}
