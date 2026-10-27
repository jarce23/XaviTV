package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h2 extends a5 {
    private static final h2 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private f5 zzh = b6.f3272r;

    static {
        h2 h2Var = new h2();
        zzb = h2Var;
        a5.e(h2.class, h2Var);
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", g2.class});
        }
        if (i11 == 3) {
            return new h2();
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
