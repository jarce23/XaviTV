package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l3 extends a5 {
    private static final l3 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private d1 zzg;

    static {
        l3 l3Var = new l3();
        zzb = l3Var;
        a5.e(l3.class, l3Var);
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", v0.f3517p, "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new l3();
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
