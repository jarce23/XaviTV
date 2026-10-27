package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p1 extends a5 {
    private static final p1 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        p1 p1Var = new p1();
        zzb = p1Var;
        a5.e(p1.class, p1Var);
    }

    public static o1 l() {
        return (o1) zzb.j();
    }

    public static /* synthetic */ void m(p1 p1Var, int i10) {
        p1Var.zzd |= 2;
        p1Var.zzf = i10;
    }

    public static /* synthetic */ void n(p1 p1Var, int i10) {
        p1Var.zzd |= 4;
        p1Var.zzg = i10;
    }

    public static /* synthetic */ void o(p1 p1Var, int i10) {
        p1Var.zzd |= 8;
        p1Var.zzh = i10;
    }

    public static /* synthetic */ void p(p1 p1Var, int i10) {
        p1Var.zzd |= 16;
        p1Var.zzi = i10;
    }

    public static /* synthetic */ void q(p1 p1Var, int i10) {
        p1Var.zze = i10 - 1;
        p1Var.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzd", "zze", v0.f3518q, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new p1();
        }
        if (i11 == 4) {
            return new o1(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
