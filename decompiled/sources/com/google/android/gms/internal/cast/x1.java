package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x1 extends a5 {
    private static final x1 zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        x1 x1Var = new x1();
        zzb = x1Var;
        a5.e(x1.class, x1Var);
    }

    public static w1 l() {
        return (w1) zzb.j();
    }

    public static /* synthetic */ void m(x1 x1Var, int i10) {
        x1Var.zzd |= 2;
        x1Var.zzf = i10;
    }

    public static /* synthetic */ void n(x1 x1Var, int i10) {
        x1Var.zze = i10 - 1;
        x1Var.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zzd", "zze", v0.f3523v, "zzf"});
        }
        if (i11 == 3) {
            return new x1();
        }
        if (i11 == 4) {
            return new w1(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
