package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a extends y0 implements pa.d, s {

    /* renamed from: q, reason: collision with root package name */
    public final pa.i f6540q;

    public a(pa.i iVar, boolean z10) {
        super(z10);
        B((p0) iVar.s(r.f6589p));
        this.f6540q = iVar.K(this);
    }

    @Override // ib.y0
    public final void A(a6.m0 m0Var) {
        v.d(this.f6540q, m0Var);
    }

    @Override // ib.y0
    public final void H(Object obj) {
        if (!(obj instanceof l)) {
            O(obj);
        } else {
            l lVar = (l) obj;
            N(lVar.f6575a, l.f6574b.get(lVar) != 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(t tVar, a aVar, ya.p pVar) {
        int ordinal = tVar.ordinal();
        la.i iVar = la.i.f8335a;
        if (ordinal == 0) {
            try {
                nb.a.g(iVar, a.a.m(((ra.a) pVar).create(aVar, this)));
                return;
            } finally {
                resumeWith(com.google.android.gms.internal.cast.n.d(th));
            }
        }
        if (ordinal != 1) {
            if (ordinal == 2) {
                a.a.m(((ra.a) pVar).create(aVar, this)).resumeWith(iVar);
                return;
            }
            if (ordinal != 3) {
                throw new a6.m0();
            }
            try {
                pa.i iVar2 = this.f6540q;
                Object j10 = nb.a.j(iVar2, null);
                try {
                    za.p.b(2, pVar);
                    Object b2 = pVar.b(aVar, this);
                    if (b2 != qa.a.f10374o) {
                        resumeWith(b2);
                    }
                } finally {
                    nb.a.f(iVar2, j10);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // ib.s
    public final pa.i e() {
        return this.f6540q;
    }

    @Override // pa.d
    public final pa.i getContext() {
        return this.f6540q;
    }

    @Override // ib.y0
    public final String o() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // pa.d
    public final void resumeWith(Object obj) {
        Throwable a10 = la.f.a(obj);
        if (a10 != null) {
            obj = new l(a10, false);
        }
        Object E = E(obj);
        if (E == v.f6598d) {
            return;
        }
        j(E);
    }

    public void O(Object obj) {
    }

    public void N(Throwable th, boolean z10) {
    }
}
