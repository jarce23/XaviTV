package f2;

import android.os.SystemClock;
import i1.u0;
import java.util.Arrays;
import java.util.List;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d implements t {

    /* renamed from: a, reason: collision with root package name */
    public final u0 f4883a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4884b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f4885c;

    /* renamed from: d, reason: collision with root package name */
    public final i1.p[] f4886d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f4887e;

    /* renamed from: f, reason: collision with root package name */
    public int f4888f;

    public d(u0 u0Var, int[] iArr) {
        int i10 = 0;
        l1.d.g(iArr.length > 0);
        u0Var.getClass();
        this.f4883a = u0Var;
        int length = iArr.length;
        this.f4884b = length;
        this.f4886d = new i1.p[length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.f4886d[i11] = u0Var.f6042d[iArr[i11]];
        }
        Arrays.sort(this.f4886d, new c(0));
        this.f4885c = new int[this.f4884b];
        while (true) {
            int i12 = this.f4884b;
            if (i10 >= i12) {
                this.f4887e = new long[i12];
                return;
            } else {
                this.f4885c[i10] = u0Var.a(this.f4886d[i10]);
                i10++;
            }
        }
    }

    @Override // f2.t
    public final boolean b(int i10, long j10) {
        return this.f4887e[i10] > j10;
    }

    @Override // f2.t
    public final /* synthetic */ boolean c(long j10, d2.a aVar, List list) {
        return false;
    }

    @Override // f2.t
    public final i1.p d(int i10) {
        return this.f4886d[i10];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f4883a.equals(dVar.f4883a) && Arrays.equals(this.f4885c, dVar.f4885c)) {
                return true;
            }
        }
        return false;
    }

    @Override // f2.t
    public final int f(int i10) {
        return this.f4885c[i10];
    }

    @Override // f2.t
    public int g(long j10, List list) {
        return list.size();
    }

    public final int hashCode() {
        if (this.f4888f == 0) {
            this.f4888f = Arrays.hashCode(this.f4885c) + (System.identityHashCode(this.f4883a) * 31);
        }
        return this.f4888f;
    }

    @Override // f2.t
    public final int j() {
        return this.f4885c[n()];
    }

    @Override // f2.t
    public final u0 k() {
        return this.f4883a;
    }

    @Override // f2.t
    public final i1.p l() {
        return this.f4886d[n()];
    }

    @Override // f2.t
    public final int length() {
        return this.f4885c.length;
    }

    @Override // f2.t
    public final boolean o(int i10, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(i10, elapsedRealtime);
        int i11 = 0;
        while (i11 < this.f4884b && !b2) {
            b2 = (i11 == i10 || b(i11, elapsedRealtime)) ? false : true;
            i11++;
        }
        if (!b2) {
            return false;
        }
        long[] jArr = this.f4887e;
        long j11 = jArr[i10];
        int i12 = a0.f8067a;
        long j12 = elapsedRealtime + j10;
        if (((j10 ^ j12) & (elapsedRealtime ^ j12)) < 0) {
            j12 = Long.MAX_VALUE;
        }
        jArr[i10] = Math.max(j11, j12);
        return true;
    }

    @Override // f2.t
    public final int t(int i10) {
        for (int i11 = 0; i11 < this.f4884b; i11++) {
            if (this.f4885c[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    @Override // f2.t
    public void e() {
    }

    @Override // f2.t
    public void h() {
    }

    @Override // f2.t
    public final /* synthetic */ void r() {
    }

    @Override // f2.t
    public final /* synthetic */ void s() {
    }

    @Override // f2.t
    public final void a(boolean z10) {
    }

    @Override // f2.t
    public void p(float f10) {
    }
}
