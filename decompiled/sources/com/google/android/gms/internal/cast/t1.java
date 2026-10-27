package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t1 extends a5 {
    private static final t1 zzb;
    private int zzd;
    private f2 zze;
    private long zzf;
    private int zzg;
    private f5 zzh;
    private f5 zzi;
    private f5 zzj;
    private f5 zzk;

    static {
        t1 t1Var = new t1();
        zzb = t1Var;
        a5.e(t1.class, t1Var);
    }

    public t1() {
        b6 b6Var = b6.f3272r;
        this.zzh = b6Var;
        this.zzi = b6Var;
        this.zzj = b6Var;
        this.zzk = b6Var;
    }

    public static s1 l() {
        return (s1) zzb.j();
    }

    public static /* synthetic */ void m(t1 t1Var, f2 f2Var) {
        t1Var.zze = f2Var;
        t1Var.zzd |= 1;
    }

    public static /* synthetic */ void n(t1 t1Var, long j10) {
        t1Var.zzd |= 2;
        t1Var.zzf = j10;
    }

    public static void o(t1 t1Var, ArrayList arrayList) {
        f5 f5Var = t1Var.zzh;
        if (!((p4) f5Var).f3423o) {
            t1Var.zzh = a5.b(f5Var);
        }
        List list = t1Var.zzh;
        Charset charset = g5.f3312a;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(arrayList.size() + list.size());
        }
        int size = list.size();
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            if (obj == null) {
                String o2 = android.support.v4.media.d.o("Element at index ", list.size() - size, " is null.");
                int size3 = list.size();
                while (true) {
                    size3--;
                    if (size3 < size) {
                        throw new NullPointerException(o2);
                    }
                    list.remove(size3);
                }
            } else {
                list.add(obj);
            }
        }
    }

    public static void p(t1 t1Var, ArrayList arrayList) {
        f5 f5Var = t1Var.zzi;
        if (!((p4) f5Var).f3423o) {
            t1Var.zzi = a5.b(f5Var);
        }
        List list = t1Var.zzi;
        Charset charset = g5.f3312a;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(arrayList.size() + list.size());
        }
        int size = list.size();
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            if (obj == null) {
                String o2 = android.support.v4.media.d.o("Element at index ", list.size() - size, " is null.");
                int size3 = list.size();
                while (true) {
                    size3--;
                    if (size3 < size) {
                        throw new NullPointerException(o2);
                    }
                    list.remove(size3);
                }
            } else {
                list.add(obj);
            }
        }
    }

    public static void q(t1 t1Var, ArrayList arrayList) {
        f5 f5Var = t1Var.zzj;
        if (!((p4) f5Var).f3423o) {
            t1Var.zzj = a5.b(f5Var);
        }
        List list = t1Var.zzj;
        Charset charset = g5.f3312a;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(arrayList.size() + list.size());
        }
        int size = list.size();
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            if (obj == null) {
                String o2 = android.support.v4.media.d.o("Element at index ", list.size() - size, " is null.");
                int size3 = list.size();
                while (true) {
                    size3--;
                    if (size3 < size) {
                        throw new NullPointerException(o2);
                    }
                    list.remove(size3);
                }
            } else {
                list.add(obj);
            }
        }
    }

    public static void r(t1 t1Var, ArrayList arrayList) {
        f5 f5Var = t1Var.zzk;
        if (!((p4) f5Var).f3423o) {
            t1Var.zzk = a5.b(f5Var);
        }
        List list = t1Var.zzk;
        Charset charset = g5.f3312a;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(arrayList.size() + list.size());
        }
        int size = list.size();
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            if (obj == null) {
                String o2 = android.support.v4.media.d.o("Element at index ", list.size() - size, " is null.");
                int size3 = list.size();
                while (true) {
                    size3--;
                    if (size3 < size) {
                        throw new NullPointerException(o2);
                    }
                    list.remove(size3);
                }
            } else {
                list.add(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.a5
    public final Object h(int i10, a5 a5Var) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new c6(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001ဉ\u0000\u0002စ\u0001\u0003᠌\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", v0.f3522u, "zzh", r1.class, "zzi", p1.class, "zzj", x1.class, "zzk", v1.class});
        }
        if (i11 == 3) {
            return new t1();
        }
        if (i11 == 4) {
            return new s1(zzb);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
