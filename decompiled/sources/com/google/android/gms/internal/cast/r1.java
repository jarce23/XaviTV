package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r1 extends a5 {
    private static final r1 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;

    static {
        r1 r1Var = new r1();
        zzb = r1Var;
        a5.e(r1.class, r1Var);
    }

    public static q1 l() {
        return (q1) zzb.j();
    }

    public static /* synthetic */ void m(r1 r1Var, int i10) {
        r1Var.zzd |= 2;
        r1Var.zzf = i10;
    }

    public static /* synthetic */ void n(r1 r1Var, int i10) {
        r1Var.zzd |= 4;
        r1Var.zzg = i10;
    }

    public static /* synthetic */ void o(r1 r1Var, boolean z10) {
        r1Var.zzd |= 8;
        r1Var.zzh = z10;
    }

    public static /* synthetic */ void p(r1 r1Var, int i10) {
        r1Var.zze = i10 - 1;
        r1Var.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", v0.f3519r, "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new r1();
        }
        if (i11 == 4) {
            return new q1(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
