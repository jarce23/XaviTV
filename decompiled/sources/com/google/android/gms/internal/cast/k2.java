package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k2 extends a5 {
    private static final k2 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private c5 zzg;
    private c5 zzh;
    private f5 zzi;
    private f5 zzj;
    private int zzk;

    static {
        k2 k2Var = new k2();
        zzb = k2Var;
        a5.e(k2.class, k2Var);
    }

    public k2() {
        b5 b5Var = b5.f3269r;
        this.zzg = b5Var;
        this.zzh = b5Var;
        b6 b6Var = b6.f3272r;
        this.zzi = b6Var;
        this.zzj = b6Var;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001င\u0000\u0002᠌\u0001\u0003\u0016\u0004\u0016\u0005\u001a\u0006\u001a\u0007᠌\u0002", new Object[]{"zzd", "zze", "zzf", a0.P, "zzg", "zzh", "zzi", "zzj", "zzk", a0.L});
        }
        if (i11 == 3) {
            return new k2();
        }
        if (i11 == 4) {
            return new r0(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
