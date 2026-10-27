package com.google.android.gms.internal.cast;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f2 extends a5 {
    private static final f2 zzb;
    private int zzd;
    private String zze = _UrlKt.FRAGMENT_ENCODE_SET;
    private String zzf = _UrlKt.FRAGMENT_ENCODE_SET;

    static {
        f2 f2Var = new f2();
        zzb = f2Var;
        a5.e(f2.class, f2Var);
    }

    public static e2 l() {
        return (e2) zzb.j();
    }

    public static /* synthetic */ void m(f2 f2Var, String str) {
        str.getClass();
        f2Var.zzd |= 1;
        f2Var.zze = str;
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
            return new f2();
        }
        if (i11 == 4) {
            return new e2(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
