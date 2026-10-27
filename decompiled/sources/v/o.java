package v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f12622a;

    /* renamed from: b, reason: collision with root package name */
    public u.d f12623b;

    /* renamed from: c, reason: collision with root package name */
    public l f12624c;

    /* renamed from: d, reason: collision with root package name */
    public int f12625d;

    /* renamed from: e, reason: collision with root package name */
    public final g f12626e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f12627f = 0;
    public boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    public final f f12628h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public final f f12629i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    public int f12630j = 1;

    public o(u.d dVar) {
        this.f12623b = dVar;
    }

    public static void b(f fVar, f fVar2, int i10) {
        fVar.f12608l.add(fVar2);
        fVar.f12603f = i10;
        fVar2.f12607k.add(fVar);
    }

    public static f h(u.c cVar) {
        u.c cVar2 = cVar.f12057f;
        if (cVar2 == null) {
            return null;
        }
        u.d dVar = cVar2.f12055d;
        int b2 = s.e.b(cVar2.f12056e);
        if (b2 == 1) {
            return dVar.f12066d.f12628h;
        }
        if (b2 == 2) {
            return dVar.f12068e.f12628h;
        }
        if (b2 == 3) {
            return dVar.f12066d.f12629i;
        }
        if (b2 == 4) {
            return dVar.f12068e.f12629i;
        }
        if (b2 != 5) {
            return null;
        }
        return dVar.f12068e.f12614k;
    }

    public static f i(u.c cVar, int i10) {
        u.c cVar2 = cVar.f12057f;
        if (cVar2 == null) {
            return null;
        }
        u.d dVar = cVar2.f12055d;
        o oVar = i10 == 0 ? dVar.f12066d : dVar.f12068e;
        int b2 = s.e.b(cVar2.f12056e);
        if (b2 == 1 || b2 == 2) {
            return oVar.f12628h;
        }
        if (b2 == 3 || b2 == 4) {
            return oVar.f12629i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i10, g gVar) {
        fVar.f12608l.add(fVar2);
        fVar.f12608l.add(this.f12626e);
        fVar.f12604h = i10;
        fVar.f12605i = gVar;
        fVar2.f12607k.add(fVar);
        gVar.f12607k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        if (i11 == 0) {
            u.d dVar = this.f12623b;
            int i12 = dVar.f12093u;
            int max = Math.max(dVar.f12092t, i10);
            if (i12 > 0) {
                max = Math.min(i12, i10);
            }
            if (max != i10) {
                return max;
            }
        } else {
            u.d dVar2 = this.f12623b;
            int i13 = dVar2.f12096x;
            int max2 = Math.max(dVar2.f12095w, i10);
            if (i13 > 0) {
                max2 = Math.min(i13, i10);
            }
            if (max2 != i10) {
                return max2;
            }
        }
        return i10;
    }

    public long j() {
        if (this.f12626e.f12606j) {
            return r0.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        if (r9.f12622a == 3) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(u.c r12, u.c r13, int r14) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.o.l(u.c, u.c, int):void");
    }
}
