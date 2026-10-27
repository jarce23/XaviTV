package b4;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements i8.b, k2.o, k2.p {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2200o;

    /* renamed from: p, reason: collision with root package name */
    public long f2201p;

    /* renamed from: q, reason: collision with root package name */
    public Object f2202q;

    public /* synthetic */ c(int i10, long j10, Object obj) {
        this.f2200o = i10;
        this.f2201p = j10;
        this.f2202q = obj;
    }

    public void A(int i10) {
        if (i10 < 64) {
            this.f2201p |= 1 << i10;
        } else {
            u();
            ((c) this.f2202q).A(i10 - 64);
        }
    }

    @Override // k2.o
    public int a(int i10) {
        return ((k2.o) this.f2202q).a(i10);
    }

    @Override // k2.o
    public boolean b(byte[] bArr, int i10, int i11, boolean z10) {
        return ((k2.o) this.f2202q).b(bArr, 0, i11, z10);
    }

    @Override // k2.o
    public long c() {
        return ((k2.o) this.f2202q).c() - this.f2201p;
    }

    @Override // k2.o
    public int d(byte[] bArr, int i10, int i11) {
        return ((k2.o) this.f2202q).d(bArr, i10, i11);
    }

    @Override // k2.p
    public void f() {
        ((k2.p) this.f2202q).f();
    }

    @Override // k2.o
    public long getPosition() {
        return ((k2.o) this.f2202q).getPosition() - this.f2201p;
    }

    @Override // k2.o
    public void h() {
        ((k2.o) this.f2202q).h();
    }

    @Override // k2.o
    public void i(int i10) {
        ((k2.o) this.f2202q).i(i10);
    }

    @Override // k2.o
    public boolean k(int i10, boolean z10) {
        return ((k2.o) this.f2202q).k(i10, true);
    }

    @Override // k2.o
    public boolean m(byte[] bArr, int i10, int i11, boolean z10) {
        return ((k2.o) this.f2202q).m(bArr, i10, i11, z10);
    }

    @Override // k2.o
    public long n() {
        return ((k2.o) this.f2202q).n() - this.f2201p;
    }

    @Override // k2.o
    public void o(byte[] bArr, int i10, int i11) {
        ((k2.o) this.f2202q).o(bArr, i10, i11);
    }

    @Override // k2.o
    public void p(int i10) {
        ((k2.o) this.f2202q).p(i10);
    }

    @Override // k2.p
    public k2.g0 q(int i10, int i11) {
        return ((k2.p) this.f2202q).q(i10, i11);
    }

    public void r(int i10) {
        if (i10 < 64) {
            this.f2201p &= ~(1 << i10);
            return;
        }
        c cVar = (c) this.f2202q;
        if (cVar != null) {
            cVar.r(i10 - 64);
        }
    }

    @Override // i1.h
    public int read(byte[] bArr, int i10, int i11) {
        return ((k2.o) this.f2202q).read(bArr, i10, i11);
    }

    @Override // k2.o
    public void readFully(byte[] bArr, int i10, int i11) {
        ((k2.o) this.f2202q).readFully(bArr, i10, i11);
    }

    public int s(int i10) {
        c cVar = (c) this.f2202q;
        if (cVar == null) {
            return i10 >= 64 ? Long.bitCount(this.f2201p) : Long.bitCount(this.f2201p & ((1 << i10) - 1));
        }
        if (i10 < 64) {
            return Long.bitCount(this.f2201p & ((1 << i10) - 1));
        }
        return Long.bitCount(this.f2201p) + cVar.s(i10 - 64);
    }

    @Override // k2.p
    public void t(k2.a0 a0Var) {
        ((k2.p) this.f2202q).t(new s2.c(this, a0Var, a0Var));
    }

    public String toString() {
        switch (this.f2200o) {
            case 0:
                if (((c) this.f2202q) == null) {
                    return Long.toBinaryString(this.f2201p);
                }
                return ((c) this.f2202q).toString() + "xx" + Long.toBinaryString(this.f2201p);
            default:
                return super.toString();
        }
    }

    public void u() {
        if (((c) this.f2202q) == null) {
            this.f2202q = new c();
        }
    }

    public boolean v(int i10) {
        if (i10 < 64) {
            return (this.f2201p & (1 << i10)) != 0;
        }
        u();
        return ((c) this.f2202q).v(i10 - 64);
    }

    @Override // i8.b
    public void w(Exception exc) {
        int i10 = exc instanceof o7.d ? ((o7.d) exc).f9546o.f3193o : 13;
        long j10 = this.f2201p;
        Iterator it = ((i7.h) ((android.support.v4.media.session.a0) this.f2202q).f232r).f6499c.f8311d.iterator();
        while (it.hasNext()) {
            ((l7.p) it.next()).b(j10, i10, null);
        }
    }

    public void x(int i10, boolean z10) {
        if (i10 >= 64) {
            u();
            ((c) this.f2202q).x(i10 - 64, z10);
            return;
        }
        long j10 = this.f2201p;
        boolean z11 = (Long.MIN_VALUE & j10) != 0;
        long j11 = (1 << i10) - 1;
        this.f2201p = ((j10 & (~j11)) << 1) | (j10 & j11);
        if (z10) {
            A(i10);
        } else {
            r(i10);
        }
        if (z11 || ((c) this.f2202q) != null) {
            u();
            ((c) this.f2202q).x(0, z11);
        }
    }

    public boolean y(int i10) {
        if (i10 >= 64) {
            u();
            return ((c) this.f2202q).y(i10 - 64);
        }
        long j10 = 1 << i10;
        long j11 = this.f2201p;
        boolean z10 = (j11 & j10) != 0;
        long j12 = j11 & (~j10);
        this.f2201p = j12;
        long j13 = j10 - 1;
        this.f2201p = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
        c cVar = (c) this.f2202q;
        if (cVar != null) {
            if (cVar.v(0)) {
                A(63);
            }
            ((c) this.f2202q).y(0);
        }
        return z10;
    }

    public void z() {
        this.f2201p = 0L;
        c cVar = (c) this.f2202q;
        if (cVar != null) {
            cVar.z();
        }
    }

    public /* synthetic */ c(android.support.v4.media.session.a0 a0Var, long j10) {
        this.f2200o = 1;
        this.f2202q = a0Var;
        this.f2201p = j10;
    }

    public c(k2.o oVar, long j10) {
        this.f2200o = 3;
        this.f2202q = oVar;
        l1.d.b(oVar.getPosition() >= j10);
        this.f2201p = j10;
    }

    public c() {
        this.f2200o = 0;
        this.f2201p = 0L;
    }
}
