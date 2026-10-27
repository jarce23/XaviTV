package com.google.android.gms.internal.cast;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h3 extends a5 {
    private static final h3 zzb;
    private int zzd;
    private String zze = _UrlKt.FRAGMENT_ENCODE_SET;
    private f5 zzf;
    private f5 zzg;
    private boolean zzh;

    static {
        h3 h3Var = new h3();
        zzb = h3Var;
        a5.e(h3.class, h3Var);
    }

    public h3() {
        b6 b6Var = b6.f3272r;
        this.zzf = b6Var;
        this.zzg = b6Var;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zzd", "zze", "zzf", m2.class, "zzg", f2.class, "zzh"});
        }
        if (i11 == 3) {
            return new h3();
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
