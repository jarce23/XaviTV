package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n3 extends a5 {
    private static final n3 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private f5 zzg;
    private f5 zzh;
    private int zzi;

    static {
        n3 n3Var = new n3();
        zzb = n3Var;
        a5.e(n3.class, n3Var);
    }

    public n3() {
        b6 b6Var = b6.f3272r;
        this.zzg = b6Var;
        this.zzh = b6Var;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003\u001b\u0004\u001b\u0005᠌\u0002", new Object[]{"zzd", "zze", v0.f3525x, "zzf", v0.f3526y, "zzg", f2.class, "zzh", f2.class, "zzi", a0.L});
        }
        if (i11 == 3) {
            return new n3();
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
