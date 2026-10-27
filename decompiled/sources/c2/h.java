package c2;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends p1 {

    /* renamed from: l, reason: collision with root package name */
    public final long f2585l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f2586m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f2587n;

    /* renamed from: o, reason: collision with root package name */
    public final i1.s0 f2588o;

    /* renamed from: p, reason: collision with root package name */
    public f f2589p;

    /* renamed from: q, reason: collision with root package name */
    public g f2590q;

    /* renamed from: r, reason: collision with root package name */
    public long f2591r;

    /* renamed from: s, reason: collision with root package name */
    public long f2592s;

    public h(e eVar) {
        super(eVar.f2569a);
        this.f2585l = eVar.f2570b;
        this.f2586m = eVar.f2571c;
        this.f2587n = new ArrayList();
        this.f2588o = new i1.s0();
    }

    public final void B(i1.t0 t0Var) {
        long j10;
        i1.s0 s0Var = this.f2588o;
        t0Var.n(0, s0Var);
        long j11 = s0Var.f6035p;
        f fVar = this.f2589p;
        long j12 = this.f2585l;
        ArrayList arrayList = this.f2587n;
        if (fVar == null || arrayList.isEmpty()) {
            this.f2591r = j11;
            this.f2592s = j12 != Long.MIN_VALUE ? j11 + j12 : Long.MIN_VALUE;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                d dVar = (d) arrayList.get(i10);
                long j13 = this.f2591r;
                long j14 = this.f2592s;
                dVar.f2536s = j13;
                dVar.f2537t = j14;
            }
            j10 = 0;
        } else {
            j10 = this.f2591r - j11;
            j12 = j12 == Long.MIN_VALUE ? Long.MIN_VALUE : this.f2592s - j11;
        }
        try {
            f fVar2 = new f(t0Var, j10, j12);
            this.f2589p = fVar2;
            l(fVar2);
        } catch (g e7) {
            this.f2590q = e7;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                ((d) arrayList.get(i11)).f2538u = this.f2590q;
            }
        }
    }

    @Override // c2.a
    public final b0 a(d0 d0Var, g2.e eVar, long j10) {
        d dVar = new d(this.f2679k.a(d0Var, eVar, j10), this.f2586m, this.f2591r, this.f2592s);
        this.f2587n.add(dVar);
        return dVar;
    }

    @Override // c2.l, c2.a
    public final void i() {
        g gVar = this.f2590q;
        if (gVar != null) {
            throw gVar;
        }
        super.i();
    }

    @Override // c2.a
    public final void m(b0 b0Var) {
        ArrayList arrayList = this.f2587n;
        l1.d.g(arrayList.remove(b0Var));
        this.f2679k.m(((d) b0Var).f2532o);
        if (arrayList.isEmpty()) {
            f fVar = this.f2589p;
            fVar.getClass();
            B(fVar.f2707b);
        }
    }

    @Override // c2.l, c2.a
    public final void o() {
        super.o();
        this.f2590q = null;
        this.f2589p = null;
    }

    @Override // c2.p1
    public final void y(i1.t0 t0Var) {
        if (this.f2590q != null) {
            return;
        }
        B(t0Var);
    }
}
