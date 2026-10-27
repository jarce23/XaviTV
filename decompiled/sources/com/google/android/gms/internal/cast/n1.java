package com.google.android.gms.internal.cast;

import okhttp3.internal.http2.Http2;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n1 extends a5 {
    private static final n1 zzb;
    private f5 zzA;
    private f5 zzB;
    private f5 zzC;
    private g3 zzD;
    private int zzE;
    private int zzF;
    private f2 zzG;
    private int zzH;
    private l1 zzI;
    private f5 zzJ;
    private f2 zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    private int zzO;
    private int zzP;
    private int zzQ;
    private n3 zzR;
    private i1 zzS;
    private t1 zzT;
    private a1 zzU;
    private r2 zzV;
    private f3 zzW;
    private t2 zzX;
    private f5 zzY;
    private int zzZ;
    private x2 zzaa;
    private f5 zzab;
    private boolean zzac;
    private boolean zzad;
    private int zzae;
    private c1 zzaf;
    private d3 zzag;
    private o2 zzah;
    private a2 zzai;
    private w2 zzaj;
    private j3 zzak;
    private b2 zzal;
    private int zzam;
    private int zzan;
    private int zzao;
    private f5 zzap;
    private q3 zzaq;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private l2 zzi;
    private b3 zzj;
    private k2 zzk;
    private i2 zzl;
    private k1 zzm;
    private a3 zzn;
    private e1 zzo;
    private m3 zzp;
    private h2 zzr;
    private t0 zzs;
    private int zzv;
    private v2 zzw;
    private f5 zzz;
    private byte zzar = 2;
    private String zzq = _UrlKt.FRAGMENT_ENCODE_SET;
    private String zzt = _UrlKt.FRAGMENT_ENCODE_SET;
    private String zzu = _UrlKt.FRAGMENT_ENCODE_SET;
    private String zzx = _UrlKt.FRAGMENT_ENCODE_SET;
    private c5 zzy = b5.f3269r;

    static {
        n1 n1Var = new n1();
        zzb = n1Var;
        a5.e(n1.class, n1Var);
    }

    public n1() {
        b6 b6Var = b6.f3272r;
        this.zzz = b6Var;
        this.zzA = b6Var;
        this.zzB = b6Var;
        this.zzC = b6Var;
        this.zzJ = b6Var;
        this.zzY = b6Var;
        this.zzab = b6Var;
        this.zzap = b6Var;
    }

    public static m1 m() {
        return (m1) zzb.j();
    }

    public static m1 n(n1 n1Var) {
        z4 j10 = zzb.j();
        a5 a5Var = j10.f3640o;
        if (!a5Var.equals(n1Var)) {
            if (!j10.f3641p.g()) {
                a5 a5Var2 = (a5) a5Var.h(4, null);
                a6.f3253c.a(a5Var2.getClass()).g(a5Var2, j10.f3641p);
                j10.f3641p = a5Var2;
            }
            a5 a5Var3 = j10.f3641p;
            a6.f3253c.a(a5Var3.getClass()).g(a5Var3, n1Var);
        }
        return (m1) j10;
    }

    public static /* synthetic */ void o(n1 n1Var, int i10) {
        n1Var.zzd |= Integer.MIN_VALUE;
        n1Var.zzQ = i10;
    }

    public static /* synthetic */ void p(n1 n1Var, i1 i1Var) {
        n1Var.zzS = i1Var;
        n1Var.zze |= 2;
    }

    public static /* synthetic */ void q(n1 n1Var, t1 t1Var) {
        n1Var.zzT = t1Var;
        n1Var.zze |= 4;
    }

    public static void r(n1 n1Var, g1 g1Var) {
        f5 f5Var = n1Var.zzY;
        if (!((p4) f5Var).f3423o) {
            n1Var.zzY = a5.b(f5Var);
        }
        n1Var.zzY.add(g1Var);
    }

    public static /* synthetic */ void s(n1 n1Var, c1 c1Var) {
        n1Var.zzaf = c1Var;
        n1Var.zze |= 4096;
    }

    public static /* synthetic */ void t(n1 n1Var, long j10) {
        n1Var.zzd |= 2;
        n1Var.zzg = j10;
    }

    public static /* synthetic */ void u(n1 n1Var, String str) {
        n1Var.zzd |= 2048;
        n1Var.zzq = str;
    }

    public static /* synthetic */ void v(n1 n1Var, String str) {
        str.getClass();
        n1Var.zzd |= Http2.INITIAL_MAX_FRAME_SIZE;
        n1Var.zzt = str;
    }

    public static /* synthetic */ void w(n1 n1Var, String str) {
        str.getClass();
        n1Var.zzd |= 32768;
        n1Var.zzu = str;
    }

    public static /* synthetic */ void x(n1 n1Var, int i10) {
        n1Var.zzd |= 65536;
        n1Var.zzv = i10;
    }

    public static /* synthetic */ void y(n1 n1Var, String str) {
        n1Var.zzd |= 262144;
        n1Var.zzx = str;
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzar);
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001@\u0000\u0002\u0001@@\u0000\t\u0001\u0001ဂ\u0000\u0002ဂ\u0001\u0003᠌\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဈ\u000e\nဉ\b\u000bဉ\t\fဉ\n\rဈ\u000b\u000eဉ\f\u000fဉ\r\u0010ဉ\u0011\u0011ဈ\u0012\u0012\u0016\u0013\u001b\u0014\u001b\u0015\u001b\u0016\u001b\u0017᠌\u0014\u0018ဉ\u0018\u0019\u001b\u001aဉ\u0019\u001b᠌\u001b\u001cင\u001c\u001dင\u001d\u001eင\u001e\u001fဆ\u001f ဉ !ဉ!\"ဉ##᠌\u0015$ဉ\u0016%ᐉ$&ဉ%'ဉ&(\u001b)᠌'*ဉ(+\u001b,᠌\u001a-ဇ).ဇ*/᠌+0ဉ,1င\u00172ဉ-3ဉ.4ဉ05ဉ16ဉ27᠌38᠌49᠌5:\u001b;ဈ\u000f<ဉ6=ဉ/>ဉ\u0013?ဉ\"@င\u0010", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", v0.f3521t, "zzi", "zzj", "zzk", "zzl", "zzm", "zzt", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzw", "zzx", "zzy", "zzz", m2.class, "zzA", p2.class, "zzB", c2.class, "zzC", h3.class, "zzE", v0.f3516o, "zzI", "zzJ", f2.class, "zzK", "zzM", a0.R, "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzU", "zzF", v0.f3514m, "zzG", "zzV", "zzW", "zzX", "zzY", g1.class, "zzZ", v0.f3515n, "zzaa", "zzab", j1.class, "zzL", a0.Q, "zzac", "zzad", "zzae", a0.O, "zzaf", "zzH", "zzag", "zzah", "zzaj", "zzak", "zzal", "zzam", a0.E, "zzan", v0.f3508f, "zzao", a0.D, "zzap", k3.class, "zzu", "zzaq", "zzai", "zzD", "zzT", "zzv"});
        }
        if (i11 == 3) {
            return new n1();
        }
        if (i11 == 4) {
            return new m1(zzb);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzar = a5Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final i1 l() {
        i1 i1Var = this.zzS;
        return i1Var == null ? i1.n() : i1Var;
    }
}
