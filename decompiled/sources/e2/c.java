package e2;

import a6.a0;
import java.util.ArrayList;
import o9.d0;
import o9.e0;
import o9.g0;
import o9.p;
import o9.u0;
import o9.w0;
import o9.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final z f4411b = new z(new p(new a0(20), u0.f9682p), new p(new a0(21), u0.f9683q));

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4412a = new ArrayList();

    @Override // e2.a
    public final g0 a(long j10) {
        ArrayList arrayList = this.f4412a;
        if (!arrayList.isEmpty()) {
            if (j10 >= ((h3.a) arrayList.get(0)).f5522b) {
                ArrayList arrayList2 = new ArrayList();
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    h3.a aVar = (h3.a) arrayList.get(i10);
                    if (j10 >= aVar.f5522b && j10 < aVar.f5524d) {
                        arrayList2.add(aVar);
                    }
                    if (j10 < aVar.f5522b) {
                        break;
                    }
                }
                w0 t3 = g0.t(f4411b, arrayList2);
                d0 m10 = g0.m();
                for (int i11 = 0; i11 < t3.f9688r; i11++) {
                    m10.c(((h3.a) t3.get(i11)).f5521a);
                }
                return m10.f();
            }
        }
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // e2.a
    public final long b(long j10) {
        int i10 = 0;
        long j11 = -9223372036854775807L;
        while (true) {
            ArrayList arrayList = this.f4412a;
            if (i10 >= arrayList.size()) {
                break;
            }
            long j12 = ((h3.a) arrayList.get(i10)).f5522b;
            long j13 = ((h3.a) arrayList.get(i10)).f5524d;
            if (j10 < j12) {
                j11 = j11 == -9223372036854775807L ? j12 : Math.min(j11, j12);
            } else {
                if (j10 < j13) {
                    j11 = j11 == -9223372036854775807L ? j13 : Math.min(j11, j13);
                }
                i10++;
            }
        }
        if (j11 != -9223372036854775807L) {
            return j11;
        }
        return Long.MIN_VALUE;
    }

    @Override // e2.a
    public final boolean c(h3.a aVar, long j10) {
        long j11 = aVar.f5522b;
        l1.d.b(j11 != -9223372036854775807L);
        l1.d.b(aVar.f5523c != -9223372036854775807L);
        boolean z10 = j11 <= j10 && j10 < aVar.f5524d;
        ArrayList arrayList = this.f4412a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (j11 >= ((h3.a) arrayList.get(size)).f5522b) {
                arrayList.add(size + 1, aVar);
                return z10;
            }
        }
        arrayList.add(0, aVar);
        return z10;
    }

    @Override // e2.a
    public final void clear() {
        this.f4412a.clear();
    }

    @Override // e2.a
    public final long d(long j10) {
        ArrayList arrayList = this.f4412a;
        if (arrayList.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j10 < ((h3.a) arrayList.get(0)).f5522b) {
            return -9223372036854775807L;
        }
        long j11 = ((h3.a) arrayList.get(0)).f5522b;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            long j12 = ((h3.a) arrayList.get(i10)).f5522b;
            long j13 = ((h3.a) arrayList.get(i10)).f5524d;
            if (j13 > j10) {
                if (j12 > j10) {
                    break;
                }
                j11 = Math.max(j11, j12);
            } else {
                j11 = Math.max(j11, j13);
            }
        }
        return j11;
    }

    @Override // e2.a
    public final void e(long j10) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f4412a;
            if (i10 >= arrayList.size()) {
                return;
            }
            long j11 = ((h3.a) arrayList.get(i10)).f5522b;
            if (j10 > j11 && j10 > ((h3.a) arrayList.get(i10)).f5524d) {
                arrayList.remove(i10);
                i10--;
            } else if (j10 < j11) {
                return;
            }
            i10++;
        }
    }
}
