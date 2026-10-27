package com.google.android.gms.internal.cast;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g1 extends a5 {
    private static final g1 zzb;
    private int zzd;
    private String zze = _UrlKt.FRAGMENT_ENCODE_SET;
    private String zzf = _UrlKt.FRAGMENT_ENCODE_SET;

    static {
        g1 g1Var = new g1();
        zzb = g1Var;
        a5.e(g1.class, g1Var);
    }

    public static f1 l() {
        return (f1) zzb.j();
    }

    public static /* synthetic */ void m(g1 g1Var, String str) {
        str.getClass();
        g1Var.zzd |= 1;
        g1Var.zze = str;
    }

    public static /* synthetic */ void n(g1 g1Var, String str) {
        str.getClass();
        g1Var.zzd |= 2;
        g1Var.zzf = str;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new g1();
        }
        if (i11 == 4) {
            return new f1(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
