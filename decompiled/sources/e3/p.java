package e3;

import i1.e0;
import i1.f0;
import i1.g0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4514a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static m1.a a(f0 f0Var, String str) {
        int i10 = 0;
        while (true) {
            e0[] e0VarArr = f0Var.f5876a;
            if (i10 >= e0VarArr.length) {
                return null;
            }
            e0 e0Var = e0VarArr[i10];
            if (e0Var instanceof m1.a) {
                m1.a aVar = (m1.a) e0Var;
                if (aVar.f8749a.equals(str)) {
                    return aVar;
                }
            }
            i10++;
        }
    }

    public static String b(ArrayList arrayList) {
        int size = arrayList.size();
        boolean z10 = false;
        String str = null;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            String str2 = ((t) obj).f4547a.g.f5991n;
            if (g0.l(str2)) {
                return "video/mp4";
            }
            if (g0.i(str2)) {
                z10 = true;
            } else if (g0.j(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z10 ? "audio/mp4" : str != null ? str : "application/mp4";
    }

    public static boolean c(int i10, boolean z10) {
        if ((i10 >>> 8) == 3368816) {
            return true;
        }
        if (i10 == 1751476579 && z10) {
            return true;
        }
        for (int i11 = 0; i11 < 29; i11++) {
            if (f4514a[i11] == i10) {
                return true;
            }
        }
        return false;
    }

    public static y2.e d(int i10, l1.t tVar) {
        int j10 = tVar.j();
        if (tVar.j() == 1684108385) {
            tVar.J(8);
            String s10 = tVar.s(j10 - 16);
            return new y2.e("und", s10, s10);
        }
        l1.b.q("MetadataUtil", "Failed to parse comment attribute: " + m1.e.c(i10));
        return null;
    }

    public static y2.a e(l1.t tVar) {
        int j10 = tVar.j();
        if (tVar.j() != 1684108385) {
            l1.b.q("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int j11 = tVar.j();
        byte[] bArr = e.f4428a;
        int i10 = j11 & 16777215;
        String str = i10 == 13 ? "image/jpeg" : i10 == 14 ? "image/png" : null;
        if (str == null) {
            android.support.v4.media.d.x("Unrecognized cover art flags: ", i10, "MetadataUtil");
            return null;
        }
        tVar.J(4);
        int i11 = j10 - 16;
        byte[] bArr2 = new byte[i11];
        tVar.h(bArr2, 0, i11);
        return new y2.a(str, null, 3, bArr2);
    }

    public static y2.o f(int i10, String str, l1.t tVar) {
        int j10 = tVar.j();
        if (tVar.j() == 1684108385 && j10 >= 22) {
            tVar.J(10);
            int C = tVar.C();
            if (C > 0) {
                String m10 = android.support.v4.media.d.m(C, _UrlKt.FRAGMENT_ENCODE_SET);
                int C2 = tVar.C();
                if (C2 > 0) {
                    m10 = m10 + "/" + C2;
                }
                return new y2.o(str, null, o9.g0.r(m10));
            }
        }
        l1.b.q("MetadataUtil", "Failed to parse index/count attribute: " + m1.e.c(i10));
        return null;
    }

    public static int g(l1.t tVar) {
        int j10 = tVar.j();
        if (tVar.j() == 1684108385) {
            tVar.J(8);
            int i10 = j10 - 16;
            if (i10 == 1) {
                return tVar.w();
            }
            if (i10 == 2) {
                return tVar.C();
            }
            if (i10 == 3) {
                return tVar.z();
            }
            if (i10 == 4 && (tVar.f8129a[tVar.f8130b] & 128) == 0) {
                return tVar.A();
            }
        }
        l1.b.q("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    public static y2.j h(int i10, String str, l1.t tVar, boolean z10, boolean z11) {
        int g = g(tVar);
        if (z11) {
            g = Math.min(1, g);
        }
        if (g >= 0) {
            return z10 ? new y2.o(str, null, o9.g0.r(Integer.toString(g))) : new y2.e("und", str, Integer.toString(g));
        }
        l1.b.q("MetadataUtil", "Failed to parse uint8 attribute: " + m1.e.c(i10));
        return null;
    }

    public static y2.o i(int i10, String str, l1.t tVar) {
        int j10 = tVar.j();
        if (tVar.j() == 1684108385) {
            tVar.J(8);
            return new y2.o(str, null, o9.g0.r(tVar.s(j10 - 16)));
        }
        l1.b.q("MetadataUtil", "Failed to parse text attribute: " + m1.e.c(i10));
        return null;
    }

    public static void j(int i10, f0 f0Var, i1.o oVar, f0 f0Var2, f0... f0VarArr) {
        if (f0Var2 == null) {
            f0Var2 = new f0(new e0[0]);
        }
        if (f0Var != null) {
            int i11 = 0;
            while (true) {
                e0[] e0VarArr = f0Var.f5876a;
                if (i11 >= e0VarArr.length) {
                    break;
                }
                e0 e0Var = e0VarArr[i11];
                if (e0Var instanceof m1.a) {
                    m1.a aVar = (m1.a) e0Var;
                    if (!aVar.f8749a.equals("com.android.capture.fps")) {
                        f0Var2 = f0Var2.a(aVar);
                    } else if (i10 == 2) {
                        f0Var2 = f0Var2.a(aVar);
                    }
                }
                i11++;
            }
        }
        for (f0 f0Var3 : f0VarArr) {
            f0Var2 = f0Var2.b(f0Var3);
        }
        if (f0Var2.f5876a.length > 0) {
            oVar.f5938k = f0Var2;
        }
    }

    public static k2.e0 k(k2.o oVar, boolean z10, boolean z11) {
        k2.e0 e0Var;
        int i10;
        long j10;
        int i11;
        int i12;
        int i13;
        int[] iArr;
        long c10 = oVar.c();
        long j11 = -1;
        long j12 = 4096;
        if (c10 != -1 && c10 <= 4096) {
            j12 = c10;
        }
        int i14 = (int) j12;
        l1.t tVar = new l1.t(64);
        int i15 = 0;
        int i16 = 0;
        boolean z12 = false;
        while (i16 < i14) {
            tVar.F(8);
            boolean z13 = true;
            if (!oVar.m(tVar.f8129a, i15, 8, true)) {
                break;
            }
            long y8 = tVar.y();
            int j13 = tVar.j();
            if (y8 == 1) {
                j10 = j11;
                oVar.o(tVar.f8129a, 8, 8);
                i12 = 16;
                tVar.H(16);
                y8 = tVar.q();
                i11 = i16;
            } else {
                j10 = j11;
                if (y8 == 0) {
                    long c11 = oVar.c();
                    if (c11 != j10) {
                        i11 = i16;
                        y8 = (c11 - oVar.n()) + 8;
                        i12 = 8;
                    }
                }
                i11 = i16;
                i12 = 8;
            }
            long j14 = y8;
            long j15 = i12;
            if (j14 < j15) {
                return new k();
            }
            int i17 = i11 + i12;
            e0Var = null;
            if (j13 == 1836019574) {
                i14 += (int) j14;
                if (c10 != -1 && i14 > c10) {
                    i14 = (int) c10;
                }
                i16 = i17;
                j11 = j10;
                i15 = 0;
            } else {
                if (j13 == 1836019558 || j13 == 1836475768) {
                    i10 = 1;
                    break;
                }
                if (j13 == 1835295092) {
                    z12 = true;
                }
                long j16 = c10;
                if ((i17 + j14) - j15 >= i14) {
                    i10 = 0;
                    break;
                }
                int i18 = (int) (j14 - j15);
                i16 = i17 + i18;
                if (j13 != 1718909296) {
                    i13 = 0;
                    if (i18 != 0) {
                        oVar.p(i18);
                    }
                } else {
                    if (i18 < 8) {
                        return new k();
                    }
                    tVar.F(i18);
                    i13 = 0;
                    oVar.o(tVar.f8129a, 0, i18);
                    if (c(tVar.j(), z11)) {
                        z12 = true;
                    }
                    tVar.J(4);
                    int a10 = tVar.a() / 4;
                    if (!z12 && a10 > 0) {
                        iArr = new int[a10];
                        int i19 = 0;
                        while (true) {
                            if (i19 >= a10) {
                                z13 = z12;
                                break;
                            }
                            int j17 = tVar.j();
                            iArr[i19] = j17;
                            if (c(j17, z11)) {
                                break;
                            }
                            i19++;
                        }
                    } else {
                        z13 = z12;
                        iArr = null;
                    }
                    if (!z13) {
                        k kVar = new k();
                        if (iArr == null) {
                            int i20 = r9.a.f10977q;
                            return kVar;
                        }
                        int i21 = r9.a.f10977q;
                        if (iArr.length == 0) {
                            return kVar;
                        }
                        new r9.a(Arrays.copyOf(iArr, iArr.length));
                        return kVar;
                    }
                    z12 = z13;
                }
                i15 = i13;
                j11 = j10;
                c10 = j16;
            }
        }
        e0Var = null;
        i10 = i15;
        return !z12 ? k.f4476c : z10 != i10 ? i10 != 0 ? k.f4474a : k.f4475b : e0Var;
    }
}
