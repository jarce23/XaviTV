package com.google.android.gms.internal.cast;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a1 extends a5 {
    private static final d5 zzb = new f6();
    private static final a1 zzd;
    private int zze;
    private String zzf = _UrlKt.FRAGMENT_ENCODE_SET;
    private String zzg = _UrlKt.FRAGMENT_ENCODE_SET;
    private c5 zzh = b5.f3269r;

    static {
        a1 a1Var = new a1();
        zzd = a1Var;
        a5.e(a1.class, a1Var);
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ࠞ", new Object[]{"zze", "zzf", "zzg", "zzh", v0.B});
        }
        if (i11 == 3) {
            return new a1();
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
