package com.google.android.gms.internal.cast;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j2 extends a5 {
    private static final d5 zzb = new f6();
    private static final j2 zzd;
    private int zze;
    private boolean zzg;
    private boolean zzh;
    private p3 zzi;
    private boolean zzj;
    private long zzl;
    private long zzm;
    private String zzf = _UrlKt.FRAGMENT_ENCODE_SET;
    private c5 zzk = b5.f3269r;

    static {
        j2 j2Var = new j2();
        zzd = j2Var;
        a5.e(j2.class, j2Var);
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzd, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဉ\u0003\u0004ဇ\u0004\u0005ࠬ\u0006ဇ\u0002\u0007ဂ\u0005\bဂ\u0006", new Object[]{"zze", "zzf", "zzg", "zzi", "zzj", "zzk", v0.f3527z, "zzh", "zzl", "zzm"});
        }
        if (i11 == 3) {
            return new j2();
        }
        if (i11 == 4) {
            return new r0(zzd);
        }
        if (i11 != 5) {
            return null;
        }
        return zzd;
    }
}
