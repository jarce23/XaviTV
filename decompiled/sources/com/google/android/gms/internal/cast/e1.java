package com.google.android.gms.internal.cast;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e1 extends a5 {
    private static final e1 zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private f5 zzi;
    private f5 zzj;
    private String zzk;

    static {
        e1 e1Var = new e1();
        zzb = e1Var;
        a5.e(e1.class, e1Var);
    }

    public e1() {
        b6 b6Var = b6.f3272r;
        this.zzi = b6Var;
        this.zzj = b6Var;
        this.zzk = _UrlKt.FRAGMENT_ENCODE_SET;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0007\u001b\b\u001b\tဈ\u0004", new Object[]{"zzd", "zze", a0.f3247x, "zzf", "zzg", a0.L, "zzh", "zzi", z2.class, "zzj", z2.class, "zzk"});
        }
        if (i11 == 3) {
            return new e1();
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
