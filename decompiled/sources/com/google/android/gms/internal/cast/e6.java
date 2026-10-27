package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e6 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f3302a;

    /* renamed from: b, reason: collision with root package name */
    public static final h6 f3303b;

    /* renamed from: c, reason: collision with root package name */
    public static final h6 f3304c;

    static {
        Class<?> cls;
        Class<?> cls2;
        h6 h6Var = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f3302a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                h6Var = (h6) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        f3303b = h6Var;
        f3304c = new h6();
    }

    public static void a(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                int intValue = ((Integer) list.get(i11)).intValue();
                u4Var.Z(i10 << 3);
                u4Var.Z((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            int intValue2 = ((Integer) list.get(i13)).intValue();
            i12 += u4.e0((intValue2 >> 31) ^ (intValue2 + intValue2));
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            int intValue3 = ((Integer) list.get(i11)).intValue();
            u4Var.Z((intValue3 >> 31) ^ (intValue3 + intValue3));
            i11++;
        }
    }

    public static void b(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                long longValue = ((Long) list.get(i11)).longValue();
                u4Var.a0(i10, (longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            long longValue2 = ((Long) list.get(i13)).longValue();
            i12 += u4.f0((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            long longValue3 = ((Long) list.get(i11)).longValue();
            u4Var.b0((longValue3 >> 63) ^ (longValue3 + longValue3));
            i11++;
        }
    }

    public static void c(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                int intValue = ((Integer) list.get(i11)).intValue();
                u4Var.Z(i10 << 3);
                u4Var.Z(intValue);
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += u4.e0(((Integer) list.get(i13)).intValue());
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.Z(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public static void d(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.a0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += u4.f0(((Long) list.get(i13)).longValue());
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.b0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int f(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b5)) {
            int i11 = 0;
            while (i10 < size) {
                i11 += u4.c0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return i11;
        }
        b5 b5Var = (b5) list;
        int i12 = 0;
        while (i10 < size) {
            b5Var.h(i10);
            i12 += u4.c0(b5Var.f3270p[i10]);
            i10++;
        }
        return i12;
    }

    public static int g(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (u4.e0(i10 << 3) + 4) * size;
    }

    public static int h(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (u4.e0(i10 << 3) + 8) * size;
    }

    public static int i(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b5)) {
            int i11 = 0;
            while (i10 < size) {
                i11 += u4.c0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return i11;
        }
        b5 b5Var = (b5) list;
        int i12 = 0;
        while (i10 < size) {
            b5Var.h(i10);
            i12 += u4.c0(b5Var.f3270p[i10]);
            i10++;
        }
        return i12;
    }

    public static int j(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof n5)) {
            int i11 = 0;
            while (i10 < size) {
                i11 += u4.f0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return i11;
        }
        n5 n5Var = (n5) list;
        int i12 = 0;
        while (i10 < size) {
            n5Var.g(i10);
            i12 += u4.f0(n5Var.f3397p[i10]);
            i10++;
        }
        return i12;
    }

    public static int k(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b5)) {
            int i11 = 0;
            while (i10 < size) {
                int intValue = ((Integer) list.get(i10)).intValue();
                i11 += u4.e0((intValue >> 31) ^ (intValue + intValue));
                i10++;
            }
            return i11;
        }
        b5 b5Var = (b5) list;
        int i12 = 0;
        while (i10 < size) {
            b5Var.h(i10);
            int i13 = b5Var.f3270p[i10];
            i12 += u4.e0((i13 >> 31) ^ (i13 + i13));
            i10++;
        }
        return i12;
    }

    public static int l(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof n5)) {
            int i11 = 0;
            while (i10 < size) {
                long longValue = ((Long) list.get(i10)).longValue();
                i11 += u4.f0((longValue >> 63) ^ (longValue + longValue));
                i10++;
            }
            return i11;
        }
        n5 n5Var = (n5) list;
        int i12 = 0;
        while (i10 < size) {
            n5Var.g(i10);
            long j10 = n5Var.f3397p[i10];
            i12 += u4.f0((j10 >> 63) ^ (j10 + j10));
            i10++;
        }
        return i12;
    }

    public static int m(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b5)) {
            int i11 = 0;
            while (i10 < size) {
                i11 += u4.e0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return i11;
        }
        b5 b5Var = (b5) list;
        int i12 = 0;
        while (i10 < size) {
            b5Var.h(i10);
            i12 += u4.e0(b5Var.f3270p[i10]);
            i10++;
        }
        return i12;
    }

    public static int n(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof n5)) {
            int i11 = 0;
            while (i10 < size) {
                i11 += u4.f0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return i11;
        }
        n5 n5Var = (n5) list;
        int i12 = 0;
        while (i10 < size) {
            n5Var.g(i10);
            i12 += u4.f0(n5Var.f3397p[i10]);
            i10++;
        }
        return i12;
    }

    public static void o(h6 h6Var, Object obj, Object obj2) {
        h6Var.getClass();
        a5 a5Var = (a5) obj;
        g6 g6Var = a5Var.zzc;
        g6 g6Var2 = ((a5) obj2).zzc;
        g6 g6Var3 = g6.f3314e;
        if (!g6Var3.equals(g6Var2)) {
            if (g6Var3.equals(g6Var)) {
                g6Var.getClass();
                g6Var2.getClass();
                int[] copyOf = Arrays.copyOf(g6Var.f3315a, 0);
                System.arraycopy(g6Var2.f3315a, 0, copyOf, 0, 0);
                Object[] copyOf2 = Arrays.copyOf(g6Var.f3316b, 0);
                System.arraycopy(g6Var2.f3316b, 0, copyOf2, 0, 0);
                g6Var = new g6(copyOf, copyOf2, true);
            } else {
                g6Var.getClass();
                if (!g6Var2.equals(g6Var3)) {
                    if (!g6Var.f3318d) {
                        throw new UnsupportedOperationException();
                    }
                    int[] iArr = g6Var.f3315a;
                    int length = iArr.length;
                    System.arraycopy(g6Var2.f3315a, 0, iArr, 0, 0);
                    System.arraycopy(g6Var2.f3316b, 0, g6Var.f3316b, 0, 0);
                }
            }
        }
        a5Var.zzc = g6Var;
    }

    public static void p(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                boolean booleanValue = ((Boolean) list.get(i11)).booleanValue();
                u4Var.Z(i10 << 3);
                u4Var.Q(booleanValue ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Boolean) list.get(i13)).getClass();
            i12++;
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.Q(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    public static void q(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.V(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Double) list.get(i13)).getClass();
            i12 += 8;
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.W(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
            i11++;
        }
    }

    public static void r(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                int intValue = ((Integer) list.get(i11)).intValue();
                u4Var.Z(i10 << 3);
                if (intValue >= 0) {
                    u4Var.Z(intValue);
                } else {
                    u4Var.b0(intValue);
                }
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += u4.c0(((Integer) list.get(i13)).intValue());
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            int intValue2 = ((Integer) list.get(i11)).intValue();
            if (intValue2 >= 0) {
                u4Var.Z(intValue2);
            } else {
                u4Var.b0(intValue2);
            }
            i11++;
        }
    }

    public static void s(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.T(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Integer) list.get(i13)).getClass();
            i12 += 4;
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.U(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public static void t(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.V(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Long) list.get(i13)).getClass();
            i12 += 8;
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.W(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    public static void u(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.T(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Float) list.get(i13)).getClass();
            i12 += 4;
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.U(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
            i11++;
        }
    }

    public static void v(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                int intValue = ((Integer) list.get(i11)).intValue();
                u4Var.Z(i10 << 3);
                if (intValue >= 0) {
                    u4Var.Z(intValue);
                } else {
                    u4Var.b0(intValue);
                }
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += u4.c0(((Integer) list.get(i13)).intValue());
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            int intValue2 = ((Integer) list.get(i11)).intValue();
            if (intValue2 >= 0) {
                u4Var.Z(intValue2);
            } else {
                u4Var.b0(intValue2);
            }
            i11++;
        }
    }

    public static void w(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.a0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += u4.f0(((Long) list.get(i13)).longValue());
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.b0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    public static void x(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.T(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Integer) list.get(i13)).getClass();
            i12 += 4;
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.U(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public static void y(int i10, List list, p5 p5Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u4 u4Var = (u4) p5Var.f3425o;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                u4Var.V(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        u4Var.Y(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Long) list.get(i13)).getClass();
            i12 += 8;
        }
        u4Var.Z(i12);
        while (i11 < list.size()) {
            u4Var.W(((Long) list.get(i11)).longValue());
            i11++;
        }
    }
}
