package i2;

import android.view.Surface;
import i1.f1;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public final z f6145a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f6146b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f6147c;

    /* renamed from: d, reason: collision with root package name */
    public Surface f6148d;

    /* renamed from: e, reason: collision with root package name */
    public i1.p f6149e;

    /* renamed from: f, reason: collision with root package name */
    public long f6150f;
    public l0 g;

    /* renamed from: h, reason: collision with root package name */
    public Executor f6151h;

    /* renamed from: i, reason: collision with root package name */
    public y f6152i;

    public d(z zVar, l1.v vVar) {
        this.f6145a = zVar;
        zVar.f6314l = vVar;
        this.f6146b = new f0(new x4.l(this), zVar);
        this.f6147c = new ArrayDeque();
        this.f6149e = new i1.p(new i1.o());
        this.f6150f = -9223372036854775807L;
        this.g = l0.f6253d;
        this.f6151h = new a(0);
        this.f6152i = new b();
    }

    @Override // i2.n0
    public final boolean b() {
        f0 f0Var = this.f6146b;
        long j10 = f0Var.f6193i;
        return j10 != -9223372036854775807L && f0Var.f6192h == j10;
    }

    @Override // i2.n0
    public final void c() {
        this.f6148d = null;
        this.f6145a.h(null);
    }

    @Override // i2.n0
    public final Surface d() {
        Surface surface = this.f6148d;
        l1.d.h(surface);
        return surface;
    }

    @Override // i2.n0
    public final void e(float f10) {
        this.f6145a.i(f10);
    }

    @Override // i2.n0
    public final void f(i1.p pVar, long j10, int i10, List list) {
        l1.d.g(list.isEmpty());
        int i11 = pVar.f5998u;
        int i12 = pVar.f5999v;
        i1.p pVar2 = this.f6149e;
        int i13 = pVar2.f5998u;
        f0 f0Var = this.f6146b;
        if (i11 != i13 || i12 != pVar2.f5999v) {
            app.shamel.tv.activities.v vVar = f0Var.f6189d;
            long j11 = f0Var.g;
            vVar.a(j11 == -9223372036854775807L ? 0L : j11 + 1, new f1(i11, i12));
        }
        float f10 = pVar.f6002y;
        if (f10 != this.f6149e.f6002y) {
            this.f6145a.g(f10);
        }
        this.f6149e = pVar;
        if (j10 != this.f6150f) {
            if (f0Var.f6191f.f3773q == 0) {
                f0Var.f6187b.f(i10);
                f0Var.f6195k = j10;
            } else {
                app.shamel.tv.activities.v vVar2 = f0Var.f6190e;
                long j12 = f0Var.g;
                vVar2.a(j12 == -9223372036854775807L ? -4611686018427387904L : j12 + 1, Long.valueOf(j10));
            }
            this.f6150f = j10;
        }
    }

    @Override // i2.n0
    public final void g(h5.i iVar) {
        this.g = iVar;
        this.f6151h = s9.a.f11663o;
    }

    @Override // i2.n0
    public final void h(boolean z10) {
        if (z10) {
            z zVar = this.f6145a;
            e0 e0Var = zVar.f6305b;
            e0Var.f6176m = 0L;
            e0Var.f6179p = -1L;
            e0Var.f6177n = -1L;
            zVar.f6310h = -9223372036854775807L;
            zVar.f6309f = -9223372036854775807L;
            zVar.f6308e = Math.min(zVar.f6308e, 1);
            zVar.f6311i = -9223372036854775807L;
        }
        f0 f0Var = this.f6146b;
        app.shamel.tv.activities.v vVar = f0Var.f6189d;
        com.google.android.material.datepicker.m mVar = f0Var.f6191f;
        mVar.f3771o = 0;
        mVar.f3772p = -1;
        mVar.f3773q = 0;
        f0Var.g = -9223372036854775807L;
        f0Var.f6192h = -9223372036854775807L;
        f0Var.f6193i = -9223372036854775807L;
        app.shamel.tv.activities.v vVar2 = f0Var.f6190e;
        if (vVar2.h() > 0) {
            l1.d.b(vVar2.h() > 0);
            while (vVar2.h() > 1) {
                vVar2.e();
            }
            Object e7 = vVar2.e();
            e7.getClass();
            f0Var.f6195k = ((Long) e7).longValue();
        }
        if (vVar.h() > 0) {
            l1.d.b(vVar.h() > 0);
            while (vVar.h() > 1) {
                vVar.e();
            }
            Object e8 = vVar.e();
            e8.getClass();
            vVar.a(0L, (f1) e8);
        }
        this.f6147c.clear();
    }

    @Override // i2.n0
    public final void i(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // i2.n0
    public final void j() {
        this.f6145a.e();
    }

    @Override // i2.n0
    public final boolean k(long j10, h hVar) {
        this.f6147c.add(hVar);
        f0 f0Var = this.f6146b;
        com.google.android.material.datepicker.m mVar = f0Var.f6191f;
        int i10 = mVar.f3773q;
        long[] jArr = (long[]) mVar.f3775s;
        if (i10 == jArr.length) {
            int length = jArr.length << 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
            long[] jArr2 = new long[length];
            int length2 = jArr.length;
            int i11 = mVar.f3771o;
            int i12 = length2 - i11;
            System.arraycopy(jArr, i11, jArr2, 0, i12);
            System.arraycopy((long[]) mVar.f3775s, 0, jArr2, i12, i11);
            mVar.f3771o = 0;
            mVar.f3772p = mVar.f3773q - 1;
            mVar.f3775s = jArr2;
            mVar.f3774r = length - 1;
        }
        int i13 = (mVar.f3772p + 1) & mVar.f3774r;
        mVar.f3772p = i13;
        ((long[]) mVar.f3775s)[i13] = j10;
        mVar.f3773q++;
        f0Var.g = j10;
        f0Var.f6193i = -9223372036854775807L;
        this.f6151h.execute(new androidx.activity.d(13, this));
        return true;
    }

    @Override // i2.n0
    public final void l(y yVar) {
        this.f6152i = yVar;
    }

    @Override // i2.n0
    public final void m(long j10, long j11) {
        try {
            this.f6146b.a(j10, j11);
        } catch (s1.l e7) {
            throw new m0(e7, this.f6149e);
        }
    }

    @Override // i2.n0
    public final void n(boolean z10) {
        this.f6145a.c(z10);
    }

    @Override // i2.n0
    public final boolean o(boolean z10) {
        return this.f6145a.b(z10);
    }

    @Override // i2.n0
    public final void p() {
        this.f6145a.d();
    }

    @Override // i2.n0
    public final boolean q(i1.p pVar) {
        return true;
    }

    @Override // i2.n0
    public final void r() {
        throw new UnsupportedOperationException();
    }

    @Override // i2.n0
    public final void s(long j10) {
        throw new UnsupportedOperationException();
    }

    @Override // i2.n0
    public final void t(Surface surface, l1.u uVar) {
        this.f6148d = surface;
        this.f6145a.h(surface);
    }

    @Override // i2.n0
    public final void u() {
        f0 f0Var = this.f6146b;
        if (f0Var.g == -9223372036854775807L) {
            f0Var.g = Long.MIN_VALUE;
            f0Var.f6192h = Long.MIN_VALUE;
        }
        f0Var.f6193i = f0Var.g;
    }

    @Override // i2.n0
    public final boolean v() {
        return true;
    }

    @Override // i2.n0
    public final void w() {
        z zVar = this.f6145a;
        if (zVar.f6308e == 0) {
            zVar.f6308e = 1;
        }
    }

    @Override // i2.n0
    public final void x(int i10) {
        e0 e0Var = this.f6145a.f6305b;
        if (e0Var.f6173j == i10) {
            return;
        }
        e0Var.f6173j = i10;
        e0Var.d(true);
    }

    @Override // i2.n0
    public final void a() {
    }
}
