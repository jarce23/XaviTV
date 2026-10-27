package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class q extends pa.a implements pa.f {

    /* renamed from: p, reason: collision with root package name */
    public static final p f6586p = new p(pa.e.f10145o, o.f6582p);

    public q() {
        super(pa.e.f10145o);
    }

    public abstract void M(pa.i iVar, Runnable runnable);

    public void N(pa.i iVar, Runnable runnable) {
        M(iVar, runnable);
    }

    public boolean O() {
        return !(this instanceof g1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r3.a(r2) != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        return pa.j.f10146o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        if (pa.e.f10145o == r3) goto L15;
     */
    @Override // pa.a, pa.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final pa.i n(pa.h r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            za.h.e(r0, r3)
            boolean r0 = r3 instanceof ib.p
            if (r0 == 0) goto L1c
            ib.p r3 = (ib.p) r3
            pa.h r0 = r2.f10141o
            if (r0 == r3) goto L15
            pa.h r1 = r3.f6585p
            if (r1 != r0) goto L14
            goto L15
        L14:
            return r2
        L15:
            pa.g r3 = r3.a(r2)
            if (r3 == 0) goto L23
            goto L20
        L1c:
            pa.e r0 = pa.e.f10145o
            if (r0 != r3) goto L23
        L20:
            pa.j r3 = pa.j.f10146o
            return r3
        L23:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.q.n(pa.h):pa.i");
    }

    @Override // pa.a, pa.i
    public final pa.g s(pa.h hVar) {
        pa.g a10;
        za.h.e("key", hVar);
        if (!(hVar instanceof p)) {
            if (pa.e.f10145o == hVar) {
                return this;
            }
            return null;
        }
        p pVar = (p) hVar;
        pa.h hVar2 = this.f10141o;
        if ((hVar2 == pVar || pVar.f6585p == hVar2) && (a10 = pVar.a(this)) != null) {
            return a10;
        }
        return null;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + v.b(this);
    }
}
