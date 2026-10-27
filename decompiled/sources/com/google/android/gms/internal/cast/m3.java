package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m3 extends a5 {
    private static final m3 zzb;
    private int zzd;
    private int zze;
    private f5 zzf;
    private f5 zzg;
    private int zzh;

    static {
        m3 m3Var = new m3();
        zzb = m3Var;
        a5.e(m3.class, m3Var);
    }

    public m3() {
        b6 b6Var = b6.f3272r;
        this.zzf = b6Var;
        this.zzg = b6Var;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003\u001b\u0004င\u0001", new Object[]{"zzd", "zze", v0.f3524w, "zzf", z2.class, "zzg", z2.class, "zzh"});
        }
        if (i11 == 3) {
            return new m3();
        }
        if (i11 == 4) {
            return new y2(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
