package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d3 extends a5 {
    private static final d3 zzb;
    private int zzd;
    private f5 zze;
    private f5 zzf;
    private i3 zzg;

    static {
        d3 d3Var = new d3();
        zzb = d3Var;
        a5.e(d3.class, d3Var);
    }

    public d3() {
        b6 b6Var = b6.f3272r;
        this.zze = b6Var;
        this.zzf = b6Var;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zzd", "zze", l3.class, "zzf", d2.class, "zzg"});
        }
        if (i11 == 3) {
            return new d3();
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
