package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c1 extends a5 {
    private static final d5 zzb = new f6();
    private static final c1 zzd;
    private int zze;
    private g1 zzf;
    private s2 zzg;
    private f5 zzh = b6.f3272r;
    private c5 zzi = b5.f3269r;

    static {
        c1 c1Var = new c1();
        zzd = c1Var;
        a5.e(c1.class, c1Var);
    }

    public static b1 l() {
        return (b1) zzd.j();
    }

    public static /* synthetic */ void m(c1 c1Var, g1 g1Var) {
        c1Var.zzf = g1Var;
        c1Var.zze |= 1;
    }

    public static void n(c1 c1Var, ArrayList arrayList) {
        f5 f5Var = c1Var.zzi;
        if (!((p4) f5Var).f3423o) {
            b5 b5Var = (b5) f5Var;
            int i10 = b5Var.f3271q;
            int i11 = i10 == 0 ? 10 : i10 + i10;
            if (i11 < i10) {
                throw new IllegalArgumentException();
            }
            c1Var.zzi = new b5(b5Var.f3271q, true, Arrays.copyOf(b5Var.f3270p, i11));
        }
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            ((b5) c1Var.zzi).g(((z0) obj).f3634o);
        }
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004ࠞ", new Object[]{"zze", "zzf", "zzg", "zzh", q2.class, "zzi", v0.B});
        }
        if (i11 == 3) {
            return new c1();
        }
        if (i11 == 4) {
            return new b1(zzd);
        }
        if (i11 != 5) {
            return null;
        }
        return zzd;
    }
}
