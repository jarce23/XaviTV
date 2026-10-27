package u;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import v.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public int f12053b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12054c;

    /* renamed from: d, reason: collision with root package name */
    public final d f12055d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12056e;

    /* renamed from: f, reason: collision with root package name */
    public c f12057f;

    /* renamed from: i, reason: collision with root package name */
    public s.f f12059i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f12052a = null;
    public int g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f12058h = Integer.MIN_VALUE;

    public c(d dVar, int i10) {
        this.f12055d = dVar;
        this.f12056e = i10;
    }

    public final void a(c cVar, int i10) {
        b(cVar, i10, Integer.MIN_VALUE, false);
    }

    public final boolean b(c cVar, int i10, int i11, boolean z10) {
        if (cVar == null) {
            j();
            return true;
        }
        if (!z10 && !i(cVar)) {
            return false;
        }
        this.f12057f = cVar;
        if (cVar.f12052a == null) {
            cVar.f12052a = new HashSet();
        }
        HashSet hashSet = this.f12057f.f12052a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i10;
        this.f12058h = i11;
        return true;
    }

    public final void c(int i10, ArrayList arrayList, n nVar) {
        HashSet hashSet = this.f12052a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                v.h.b(((c) it.next()).f12055d, i10, arrayList, nVar);
            }
        }
    }

    public final int d() {
        if (this.f12054c) {
            return this.f12053b;
        }
        return 0;
    }

    public final int e() {
        c cVar;
        if (this.f12055d.f12071f0 == 8) {
            return 0;
        }
        int i10 = this.f12058h;
        return (i10 == Integer.MIN_VALUE || (cVar = this.f12057f) == null || cVar.f12055d.f12071f0 != 8) ? this.g : i10;
    }

    public final c f() {
        int i10 = this.f12056e;
        int b2 = s.e.b(i10);
        d dVar = this.f12055d;
        switch (b2) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return dVar.J;
            case 2:
                return dVar.K;
            case 3:
                return dVar.H;
            case 4:
                return dVar.I;
            default:
                throw new AssertionError(r.a.m(i10));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f12052a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f12057f != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(u.c r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L5
            goto L65
        L5:
            u.d r1 = r11.f12055d
            int r11 = r11.f12056e
            r2 = 6
            int r3 = r10.f12056e
            r4 = 1
            if (r11 != r3) goto L1c
            if (r3 != r2) goto L63
            boolean r11 = r1.D
            if (r11 == 0) goto L65
            u.d r11 = r10.f12055d
            boolean r11 = r11.D
            if (r11 != 0) goto L63
            goto L65
        L1c:
            int r5 = s.e.b(r3)
            r6 = 8
            r7 = 9
            r8 = 4
            r9 = 2
            switch(r5) {
                case 0: goto L65;
                case 1: goto L53;
                case 2: goto L3f;
                case 3: goto L53;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L33;
                case 7: goto L65;
                case 8: goto L65;
                default: goto L29;
            }
        L29:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            java.lang.String r0 = r.a.m(r3)
            r11.<init>(r0)
            throw r11
        L33:
            if (r11 == r2) goto L65
            if (r11 == r6) goto L65
            if (r11 == r7) goto L65
            goto L63
        L3a:
            if (r11 == r9) goto L65
            if (r11 != r8) goto L63
            goto L65
        L3f:
            r2 = 3
            if (r11 == r2) goto L48
            r2 = 5
            if (r11 != r2) goto L46
            goto L48
        L46:
            r2 = r0
            goto L49
        L48:
            r2 = r4
        L49:
            boolean r1 = r1 instanceof u.h
            if (r1 == 0) goto L52
            if (r2 != 0) goto L63
            if (r11 != r7) goto L65
            goto L63
        L52:
            return r2
        L53:
            if (r11 == r9) goto L5a
            if (r11 != r8) goto L58
            goto L5a
        L58:
            r2 = r0
            goto L5b
        L5a:
            r2 = r4
        L5b:
            boolean r1 = r1 instanceof u.h
            if (r1 == 0) goto L64
            if (r2 != 0) goto L63
            if (r11 != r6) goto L65
        L63:
            return r4
        L64:
            return r2
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u.c.i(u.c):boolean");
    }

    public final void j() {
        HashSet hashSet;
        c cVar = this.f12057f;
        if (cVar != null && (hashSet = cVar.f12052a) != null) {
            hashSet.remove(this);
            if (this.f12057f.f12052a.size() == 0) {
                this.f12057f.f12052a = null;
            }
        }
        this.f12052a = null;
        this.f12057f = null;
        this.g = 0;
        this.f12058h = Integer.MIN_VALUE;
        this.f12054c = false;
        this.f12053b = 0;
    }

    public final void k() {
        s.f fVar = this.f12059i;
        if (fVar == null) {
            this.f12059i = new s.f(1);
        } else {
            fVar.c();
        }
    }

    public final void l(int i10) {
        this.f12053b = i10;
        this.f12054c = true;
    }

    public final String toString() {
        return this.f12055d.f12072g0 + ":" + r.a.m(this.f12056e);
    }
}
