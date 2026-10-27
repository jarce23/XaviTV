package com.google.android.gms.internal.cast;

import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i1 extends a5 {
    private static final i1 zzb;
    private int zzd;
    private f2 zze;
    private boolean zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private e3 zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;

    static {
        i1 i1Var = new i1();
        zzb = i1Var;
        a5.e(i1.class, i1Var);
    }

    public static h1 l() {
        return (h1) zzb.j();
    }

    public static h1 m(i1 i1Var) {
        z4 j10 = zzb.j();
        a5 a5Var = j10.f3640o;
        if (!a5Var.equals(i1Var)) {
            if (!j10.f3641p.g()) {
                a5 a5Var2 = (a5) a5Var.h(4, null);
                a6.f3253c.a(a5Var2.getClass()).g(a5Var2, j10.f3641p);
                j10.f3641p = a5Var2;
            }
            a5 a5Var3 = j10.f3641p;
            a6.f3253c.a(a5Var3.getClass()).g(a5Var3, i1Var);
        }
        return (h1) j10;
    }

    public static i1 n() {
        return zzb;
    }

    public static /* synthetic */ void o(i1 i1Var, f2 f2Var) {
        i1Var.zze = f2Var;
        i1Var.zzd |= 1;
    }

    public static /* synthetic */ void p(i1 i1Var, boolean z10) {
        i1Var.zzd |= 2;
        i1Var.zzf = z10;
    }

    public static /* synthetic */ void q(i1 i1Var, long j10) {
        i1Var.zzd |= 4;
        i1Var.zzg = j10;
    }

    public static /* synthetic */ void r(i1 i1Var, int i10) {
        i1Var.zzd |= 64;
        i1Var.zzk = i10;
    }

    public static /* synthetic */ void s(i1 i1Var, int i10) {
        i1Var.zzd |= 128;
        i1Var.zzl = i10;
    }

    public static /* synthetic */ void t(i1 i1Var, int i10) {
        i1Var.zzd |= 1024;
        i1Var.zzo = i10;
    }

    public static /* synthetic */ void u(i1 i1Var, boolean z10) {
        i1Var.zzd |= 2048;
        i1Var.zzp = z10;
    }

    public static /* synthetic */ void v(i1 i1Var, int i10) {
        i1Var.zzd |= 4096;
        i1Var.zzq = i10;
    }

    public static /* synthetic */ void w(i1 i1Var, int i10) {
        i1Var.zzd |= 8192;
        i1Var.zzr = i10;
    }

    public static /* synthetic */ void x(i1 i1Var, boolean z10) {
        i1Var.zzd |= Http2.INITIAL_MAX_FRAME_SIZE;
        i1Var.zzs = z10;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007င\u0006\bင\u0007\tဉ\b\n᠌\t\u000bင\n\fဇ\u000b\rင\f\u000eင\r\u000fဇ\u000e", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", a0.f3249z, "zzj", a0.f3248y, "zzk", "zzl", "zzm", "zzn", a0.M, "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i11 == 3) {
            return new i1();
        }
        if (i11 == 4) {
            return new h1(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
