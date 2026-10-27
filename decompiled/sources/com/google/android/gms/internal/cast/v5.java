package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v5 implements d6 {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f3532h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    public static final Unsafe f3533i = p6.i();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3534a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f3535b;

    /* renamed from: c, reason: collision with root package name */
    public final o4 f3536c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f3537d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3538e;

    /* renamed from: f, reason: collision with root package name */
    public final m5 f3539f;
    public final h6 g;

    public v5(int[] iArr, Object[] objArr, o4 o4Var, int[] iArr2, int i10, m5 m5Var, h6 h6Var, v4 v4Var) {
        this.f3534a = iArr;
        this.f3535b = objArr;
        this.f3537d = iArr2;
        this.f3538e = i10;
        this.f3539f = m5Var;
        this.g = h6Var;
        this.f3536c = o4Var;
    }

    public static boolean i(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof a5) {
            return ((a5) obj).g();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0247  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.cast.v5 k(com.google.android.gms.internal.cast.c6 r31, com.google.android.gms.internal.cast.m5 r32, com.google.android.gms.internal.cast.h6 r33, com.google.android.gms.internal.cast.v4 r34) {
        /*
            Method dump skipped, instructions count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.v5.k(com.google.android.gms.internal.cast.c6, com.google.android.gms.internal.cast.m5, com.google.android.gms.internal.cast.h6, com.google.android.gms.internal.cast.v4):com.google.android.gms.internal.cast.v5");
    }

    public static int l(long j10, Object obj) {
        return ((Integer) p6.h(j10, obj)).intValue();
    }

    public static int m(int i10) {
        return (i10 >>> 20) & 255;
    }

    public static long o(long j10, Object obj) {
        return ((Long) p6.h(j10, obj)).longValue();
    }

    public static Field q(String str, Class cls) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01ea, code lost:
    
        if (r2 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
    
        if (r2 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00db, code lost:
    
        r6 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dc, code lost:
    
        r1 = r6 + r1;
     */
    @Override // com.google.android.gms.internal.cast.d6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(com.google.android.gms.internal.cast.a5 r11) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.v5.a(com.google.android.gms.internal.cast.a5):int");
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final boolean b(a5 a5Var, a5 a5Var2) {
        boolean e7;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f3534a;
            if (i10 < iArr.length) {
                int n10 = n(i10);
                long j10 = n10 & 1048575;
                switch (m(n10)) {
                    case 0:
                        if (!u(a5Var, a5Var2, i10)) {
                            break;
                        } else {
                            o6 o6Var = p6.f3428c;
                            if (Double.doubleToLongBits(o6Var.a(j10, a5Var)) != Double.doubleToLongBits(o6Var.a(j10, a5Var2))) {
                                break;
                            } else {
                                continue;
                                i10 += 3;
                            }
                        }
                    case 1:
                        if (!u(a5Var, a5Var2, i10)) {
                            break;
                        } else {
                            o6 o6Var2 = p6.f3428c;
                            if (Float.floatToIntBits(o6Var2.b(j10, a5Var)) != Float.floatToIntBits(o6Var2.b(j10, a5Var2))) {
                                break;
                            } else {
                                continue;
                                i10 += 3;
                            }
                        }
                    case 2:
                        if (u(a5Var, a5Var2, i10) && p6.f(j10, a5Var) == p6.f(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 3:
                        if (u(a5Var, a5Var2, i10) && p6.f(j10, a5Var) == p6.f(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 4:
                        if (u(a5Var, a5Var2, i10) && p6.e(j10, a5Var) == p6.e(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 5:
                        if (u(a5Var, a5Var2, i10) && p6.f(j10, a5Var) == p6.f(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 6:
                        if (u(a5Var, a5Var2, i10) && p6.e(j10, a5Var) == p6.e(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 7:
                        if (!u(a5Var, a5Var2, i10)) {
                            break;
                        } else {
                            o6 o6Var3 = p6.f3428c;
                            if (o6Var3.g(j10, a5Var) != o6Var3.g(j10, a5Var2)) {
                                break;
                            } else {
                                continue;
                                i10 += 3;
                            }
                        }
                    case 8:
                        if (u(a5Var, a5Var2, i10) && e6.e(p6.h(j10, a5Var), p6.h(j10, a5Var2))) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 9:
                        if (u(a5Var, a5Var2, i10) && e6.e(p6.h(j10, a5Var), p6.h(j10, a5Var2))) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 10:
                        if (u(a5Var, a5Var2, i10) && e6.e(p6.h(j10, a5Var), p6.h(j10, a5Var2))) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 11:
                        if (u(a5Var, a5Var2, i10) && p6.e(j10, a5Var) == p6.e(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        if (u(a5Var, a5Var2, i10) && p6.e(j10, a5Var) == p6.e(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        if (u(a5Var, a5Var2, i10) && p6.e(j10, a5Var) == p6.e(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        if (u(a5Var, a5Var2, i10) && p6.f(j10, a5Var) == p6.f(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        if (u(a5Var, a5Var2, i10) && p6.e(j10, a5Var) == p6.e(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        if (u(a5Var, a5Var2, i10) && p6.f(j10, a5Var) == p6.f(j10, a5Var2)) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 17:
                        if (u(a5Var, a5Var2, i10) && e6.e(p6.h(j10, a5Var), p6.h(j10, a5Var2))) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        e7 = e6.e(p6.h(j10, a5Var), p6.h(j10, a5Var2));
                        break;
                    case 50:
                        e7 = e6.e(p6.h(j10, a5Var), p6.h(j10, a5Var2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j11 = iArr[i10 + 2] & 1048575;
                        if (p6.e(j11, a5Var) == p6.e(j11, a5Var2) && e6.e(p6.h(j10, a5Var), p6.h(j10, a5Var2))) {
                            continue;
                            i10 += 3;
                        }
                        break;
                    default:
                        i10 += 3;
                }
                if (e7) {
                    i10 += 3;
                }
            } else {
                this.g.getClass();
                if (a5Var.zzc.equals(a5Var2.zzc)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final void c(Object obj, p5 p5Var) {
        int i10;
        v5 v5Var = this;
        Unsafe unsafe = f3533i;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        while (true) {
            int[] iArr = v5Var.f3534a;
            if (i12 >= iArr.length) {
                v5Var.g.getClass();
                g6 g6Var = ((a5) obj).zzc;
                return;
            }
            int n10 = v5Var.n(i12);
            int m10 = m(n10);
            int i15 = iArr[i12];
            if (m10 <= 17) {
                int i16 = iArr[i12 + 2];
                int i17 = i16 & i11;
                if (i17 != i14) {
                    i13 = i17 == i11 ? 0 : unsafe.getInt(obj, i17);
                    i14 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i10 = 0;
            }
            long j10 = n10 & i11;
            switch (m10) {
                case 0:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).V(i15, Double.doubleToRawLongBits(p6.f3428c.a(j10, obj)));
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 1:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).T(i15, Float.floatToRawIntBits(p6.f3428c.b(j10, obj)));
                        break;
                    }
                    break;
                case 2:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).a0(i15, unsafe.getLong(obj, j10));
                        break;
                    }
                    break;
                case 3:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).a0(i15, unsafe.getLong(obj, j10));
                        break;
                    }
                    break;
                case 4:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        int i18 = unsafe.getInt(obj, j10);
                        u4 u4Var = (u4) p5Var.f3425o;
                        u4Var.Z(i15 << 3);
                        if (i18 >= 0) {
                            u4Var.Z(i18);
                            break;
                        } else {
                            u4Var.b0(i18);
                            break;
                        }
                    }
                    break;
                case 5:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).V(i15, unsafe.getLong(obj, j10));
                        break;
                    }
                    break;
                case 6:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).T(i15, unsafe.getInt(obj, j10));
                        break;
                    }
                    break;
                case 7:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        boolean g = p6.f3428c.g(j10, obj);
                        u4 u4Var2 = (u4) p5Var.f3425o;
                        u4Var2.Z(i15 << 3);
                        u4Var2.Q(g ? (byte) 1 : (byte) 0);
                        break;
                    }
                    break;
                case 8:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        Object object = unsafe.getObject(obj, j10);
                        if (object instanceof String) {
                            ((u4) p5Var.f3425o).X(i15, (String) object);
                            break;
                        } else {
                            ((u4) p5Var.f3425o).S(i15, (t4) object);
                            break;
                        }
                    }
                    break;
                case 9:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        p5Var.c(i15, unsafe.getObject(obj, j10), v5Var.p(i12));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 10:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).S(i15, (t4) unsafe.getObject(obj, j10));
                        break;
                    }
                    break;
                case 11:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        int i19 = unsafe.getInt(obj, j10);
                        u4 u4Var3 = (u4) p5Var.f3425o;
                        u4Var3.Z(i15 << 3);
                        u4Var3.Z(i19);
                        break;
                    }
                    break;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        int i20 = unsafe.getInt(obj, j10);
                        u4 u4Var4 = (u4) p5Var.f3425o;
                        u4Var4.Z(i15 << 3);
                        if (i20 >= 0) {
                            u4Var4.Z(i20);
                            break;
                        } else {
                            u4Var4.b0(i20);
                            break;
                        }
                    }
                    break;
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).T(i15, unsafe.getInt(obj, j10));
                        break;
                    }
                    break;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        ((u4) p5Var.f3425o).V(i15, unsafe.getLong(obj, j10));
                        break;
                    }
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        int i21 = unsafe.getInt(obj, j10);
                        u4 u4Var5 = (u4) p5Var.f3425o;
                        u4Var5.Z(i15 << 3);
                        u4Var5.Z((i21 >> 31) ^ (i21 + i21));
                        break;
                    }
                    break;
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        long j11 = unsafe.getLong(obj, j10);
                        ((u4) p5Var.f3425o).a0(i15, (j11 >> 63) ^ (j11 + j11));
                        break;
                    }
                    break;
                case 17:
                    if (v5Var.w(obj, i12, i14, i13, i10)) {
                        p5Var.a(i15, unsafe.getObject(obj, j10), v5Var.p(i12));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 18:
                    e6.q(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 19:
                    e6.u(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 20:
                    e6.w(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 21:
                    e6.d(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 22:
                    e6.v(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 23:
                    e6.t(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 24:
                    e6.s(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 25:
                    e6.p(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 26:
                    int i22 = iArr[i12];
                    List list = (List) unsafe.getObject(obj, j10);
                    Class cls = e6.f3302a;
                    if (list == null) {
                        continue;
                    } else if (!list.isEmpty()) {
                        u4 u4Var6 = (u4) p5Var.f3425o;
                        if (list instanceof j5) {
                            j5 j5Var = (j5) list;
                            for (int i23 = 0; i23 < list.size(); i23++) {
                                Object a10 = j5Var.a(i23);
                                if (a10 instanceof String) {
                                    u4Var6.X(i22, (String) a10);
                                } else {
                                    u4Var6.S(i22, (t4) a10);
                                }
                            }
                        } else {
                            for (int i24 = 0; i24 < list.size(); i24++) {
                                u4Var6.X(i22, (String) list.get(i24));
                            }
                        }
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 27:
                    int i25 = iArr[i12];
                    List list2 = (List) unsafe.getObject(obj, j10);
                    d6 p10 = v5Var.p(i12);
                    Class cls2 = e6.f3302a;
                    if (list2 == null) {
                        continue;
                    } else if (!list2.isEmpty()) {
                        for (int i26 = 0; i26 < list2.size(); i26++) {
                            p5Var.c(i25, list2.get(i26), p10);
                        }
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 28:
                    int i27 = iArr[i12];
                    List list3 = (List) unsafe.getObject(obj, j10);
                    Class cls3 = e6.f3302a;
                    if (list3 == null) {
                        continue;
                    } else if (!list3.isEmpty()) {
                        p5Var.getClass();
                        for (int i28 = 0; i28 < list3.size(); i28++) {
                            ((u4) p5Var.f3425o).S(i27, (t4) list3.get(i28));
                        }
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 29:
                    e6.c(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 30:
                    e6.r(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 31:
                    e6.x(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 32:
                    e6.y(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 33:
                    e6.a(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 34:
                    e6.b(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, false);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 35:
                    e6.q(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 36:
                    e6.u(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 37:
                    e6.w(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 38:
                    e6.d(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 39:
                    e6.v(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 40:
                    e6.t(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 41:
                    e6.s(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 42:
                    e6.p(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 43:
                    e6.c(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 44:
                    e6.r(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 45:
                    e6.x(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 46:
                    e6.y(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 47:
                    e6.a(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 48:
                    e6.b(iArr[i12], (List) unsafe.getObject(obj, j10), p5Var, true);
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 49:
                    int i29 = iArr[i12];
                    List list4 = (List) unsafe.getObject(obj, j10);
                    d6 p11 = v5Var.p(i12);
                    Class cls4 = e6.f3302a;
                    if (list4 == null) {
                        continue;
                    } else if (!list4.isEmpty()) {
                        for (int i30 = 0; i30 < list4.size(); i30++) {
                            p5Var.a(i29, list4.get(i30), p11);
                        }
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 50:
                    if (unsafe.getObject(obj, j10) != null) {
                        int i31 = i12 / 3;
                        v5Var.f3535b[i31 + i31].getClass();
                        throw new ClassCastException();
                    }
                    continue;
                    i12 += 3;
                    i11 = 1048575;
                case 51:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).V(i15, Double.doubleToRawLongBits(((Double) p6.h(j10, obj)).doubleValue()));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 52:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).T(i15, Float.floatToRawIntBits(((Float) p6.h(j10, obj)).floatValue()));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 53:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).a0(i15, o(j10, obj));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 54:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).a0(i15, o(j10, obj));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 55:
                    if (v5Var.j(i15, i12, obj)) {
                        int l10 = l(j10, obj);
                        u4 u4Var7 = (u4) p5Var.f3425o;
                        u4Var7.Z(i15 << 3);
                        if (l10 >= 0) {
                            u4Var7.Z(l10);
                        } else {
                            u4Var7.b0(l10);
                        }
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 56:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).V(i15, o(j10, obj));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 57:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).T(i15, l(j10, obj));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 58:
                    if (v5Var.j(i15, i12, obj)) {
                        boolean booleanValue = ((Boolean) p6.h(j10, obj)).booleanValue();
                        u4 u4Var8 = (u4) p5Var.f3425o;
                        u4Var8.Z(i15 << 3);
                        u4Var8.Q(booleanValue ? (byte) 1 : (byte) 0);
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 59:
                    if (v5Var.j(i15, i12, obj)) {
                        Object object2 = unsafe.getObject(obj, j10);
                        if (object2 instanceof String) {
                            ((u4) p5Var.f3425o).X(i15, (String) object2);
                        } else {
                            ((u4) p5Var.f3425o).S(i15, (t4) object2);
                        }
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 60:
                    if (v5Var.j(i15, i12, obj)) {
                        p5Var.c(i15, unsafe.getObject(obj, j10), v5Var.p(i12));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 61:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).S(i15, (t4) unsafe.getObject(obj, j10));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 62:
                    if (v5Var.j(i15, i12, obj)) {
                        int l11 = l(j10, obj);
                        u4 u4Var9 = (u4) p5Var.f3425o;
                        u4Var9.Z(i15 << 3);
                        u4Var9.Z(l11);
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 63:
                    if (v5Var.j(i15, i12, obj)) {
                        int l12 = l(j10, obj);
                        u4 u4Var10 = (u4) p5Var.f3425o;
                        u4Var10.Z(i15 << 3);
                        if (l12 >= 0) {
                            u4Var10.Z(l12);
                        } else {
                            u4Var10.b0(l12);
                        }
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).T(i15, l(j10, obj));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 65:
                    if (v5Var.j(i15, i12, obj)) {
                        ((u4) p5Var.f3425o).V(i15, o(j10, obj));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 66:
                    if (v5Var.j(i15, i12, obj)) {
                        int l13 = l(j10, obj);
                        u4 u4Var11 = (u4) p5Var.f3425o;
                        u4Var11.Z(i15 << 3);
                        u4Var11.Z((l13 >> 31) ^ (l13 + l13));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 67:
                    if (v5Var.j(i15, i12, obj)) {
                        long o2 = o(j10, obj);
                        ((u4) p5Var.f3425o).a0(i15, (o2 >> 63) ^ (o2 + o2));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                case 68:
                    if (v5Var.j(i15, i12, obj)) {
                        p5Var.a(i15, unsafe.getObject(obj, j10), v5Var.p(i12));
                    } else {
                        continue;
                    }
                    i12 += 3;
                    i11 = 1048575;
                default:
                    i12 += 3;
                    i11 = 1048575;
            }
            v5Var = this;
            i12 += 3;
            i11 = 1048575;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        continue;
     */
    @Override // com.google.android.gms.internal.cast.d6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = i(r8)
            if (r0 != 0) goto L8
            goto L8b
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.cast.a5
            r1 = 0
            if (r0 == 0) goto L18
            r0 = r8
            com.google.android.gms.internal.cast.a5 r0 = (com.google.android.gms.internal.cast.a5) r0
            r0.f()
            r0.zza = r1
            r0.d()
        L18:
            r0 = r1
        L19:
            int[] r2 = r7.f3534a
            int r3 = r2.length
            if (r0 >= r3) goto L7c
            int r3 = r7.n(r0)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r3
            int r3 = m(r3)
            long r4 = (long) r4
            r6 = 9
            if (r3 == r6) goto L66
            r6 = 60
            if (r3 == r6) goto L50
            r6 = 68
            if (r3 == r6) goto L50
            switch(r3) {
                case 17: goto L66;
                case 18: goto L4a;
                case 19: goto L4a;
                case 20: goto L4a;
                case 21: goto L4a;
                case 22: goto L4a;
                case 23: goto L4a;
                case 24: goto L4a;
                case 25: goto L4a;
                case 26: goto L4a;
                case 27: goto L4a;
                case 28: goto L4a;
                case 29: goto L4a;
                case 30: goto L4a;
                case 31: goto L4a;
                case 32: goto L4a;
                case 33: goto L4a;
                case 34: goto L4a;
                case 35: goto L4a;
                case 36: goto L4a;
                case 37: goto L4a;
                case 38: goto L4a;
                case 39: goto L4a;
                case 40: goto L4a;
                case 41: goto L4a;
                case 42: goto L4a;
                case 43: goto L4a;
                case 44: goto L4a;
                case 45: goto L4a;
                case 46: goto L4a;
                case 47: goto L4a;
                case 48: goto L4a;
                case 49: goto L4a;
                case 50: goto L3b;
                default: goto L3a;
            }
        L3a:
            goto L79
        L3b:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.cast.v5.f3533i
            java.lang.Object r2 = r2.getObject(r8, r4)
            if (r2 != 0) goto L44
            goto L79
        L44:
            java.lang.ClassCastException r8 = new java.lang.ClassCastException
            r8.<init>()
            throw r8
        L4a:
            com.google.android.gms.internal.cast.m5 r2 = r7.f3539f
            r2.a(r4, r8)
            goto L79
        L50:
            r2 = r2[r0]
            boolean r2 = r7.j(r2, r0, r8)
            if (r2 == 0) goto L79
            com.google.android.gms.internal.cast.d6 r2 = r7.p(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.cast.v5.f3533i
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.d(r3)
            goto L79
        L66:
            boolean r2 = r7.v(r0, r8)
            if (r2 == 0) goto L79
            com.google.android.gms.internal.cast.d6 r2 = r7.p(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.cast.v5.f3533i
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.d(r3)
        L79:
            int r0 = r0 + 3
            goto L19
        L7c:
            com.google.android.gms.internal.cast.h6 r0 = r7.g
            r0.getClass()
            com.google.android.gms.internal.cast.a5 r8 = (com.google.android.gms.internal.cast.a5) r8
            com.google.android.gms.internal.cast.g6 r8 = r8.zzc
            boolean r0 = r8.f3318d
            if (r0 == 0) goto L8b
            r8.f3318d = r1
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.v5.d(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final boolean e(Object obj) {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i14 < this.f3538e) {
            int i16 = this.f3537d[i14];
            int[] iArr = this.f3534a;
            int i17 = iArr[i16];
            int n10 = n(i16);
            int i18 = iArr[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i15) {
                if (i19 != 1048575) {
                    i13 = f3533i.getInt(obj, i19);
                }
                i11 = i16;
                i12 = i13;
                i10 = i19;
            } else {
                int i21 = i13;
                i10 = i15;
                i11 = i16;
                i12 = i21;
            }
            if ((268435456 & n10) == 0 || w(obj, i11, i10, i12, i20)) {
                int m10 = m(n10);
                if (m10 == 9 || m10 == 17) {
                    if (w(obj, i11, i10, i12, i20) && !p(i11).e(p6.h(n10 & 1048575, obj))) {
                    }
                    i14++;
                    i15 = i10;
                    i13 = i12;
                } else {
                    if (m10 != 27) {
                        if (m10 == 60 || m10 == 68) {
                            if (j(i17, i11, obj) && !p(i11).e(p6.h(n10 & 1048575, obj))) {
                            }
                        } else if (m10 != 49) {
                            if (m10 == 50) {
                                p6.h(n10 & 1048575, obj).getClass();
                                throw new ClassCastException();
                            }
                        }
                        i14++;
                        i15 = i10;
                        i13 = i12;
                    }
                    List list = (List) p6.h(n10 & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        d6 p10 = p(i11);
                        for (int i22 = 0; i22 < list.size(); i22++) {
                            if (p10.e(list.get(i22))) {
                            }
                        }
                    }
                    i14++;
                    i15 = i10;
                    i13 = i12;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final int f(o4 o4Var) {
        int i10;
        int i11;
        int a10;
        int e02;
        int h10;
        int e03;
        int size;
        int n10;
        int e04;
        int e05;
        int e06;
        int e07;
        int e08;
        int i12;
        int i13;
        v5 v5Var = this;
        o4 o4Var2 = o4Var;
        Unsafe unsafe = f3533i;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int[] iArr = v5Var.f3534a;
            if (i16 >= iArr.length) {
                v5Var.g.getClass();
                g6 g6Var = ((a5) o4Var).zzc;
                int i19 = g6Var.f3317c;
                if (i19 == -1) {
                    g6Var.f3317c = 0;
                    i10 = 0;
                } else {
                    i10 = i19;
                }
                return i10 + i18;
            }
            int n11 = v5Var.n(i16);
            int m10 = m(n11);
            int i20 = iArr[i16];
            int i21 = iArr[i16 + 2];
            int i22 = i21 & i14;
            if (m10 <= 17) {
                if (i22 != i15) {
                    i17 = i22 == i14 ? 0 : unsafe.getInt(o4Var2, i22);
                    i15 = i22;
                }
                i11 = 1 << (i21 >>> 20);
            } else {
                i11 = 0;
            }
            int i23 = n11 & i14;
            if (m10 >= x4.f3580p.f3584o) {
                x4.f3581q.getClass();
            }
            long j10 = i23;
            switch (m10) {
                case 0:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 8, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 1:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 4, i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 2:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.f0(unsafe.getLong(o4Var2, j10)), i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 3:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.f0(unsafe.getLong(o4Var2, j10)), i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 4:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.c0(unsafe.getInt(o4Var2, j10)), i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 5:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 8, i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 6:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 4, i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 7:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 1, i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 8:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        int i24 = i20 << 3;
                        Object object = unsafe.getObject(o4Var2, j10);
                        if (object instanceof t4) {
                            Logger logger = u4.f3489h;
                            int h11 = ((t4) object).h();
                            i18 = android.support.v4.media.d.f(i24, u4.e0(h11) + h11, i18);
                        } else {
                            i18 = android.support.v4.media.d.f(i24, u4.d0((String) object), i18);
                        }
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 9:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        Object object2 = unsafe.getObject(o4Var2, j10);
                        d6 p10 = v5Var.p(i16);
                        Class cls = e6.f3302a;
                        Logger logger2 = u4.f3489h;
                        int a11 = ((o4) object2).a(p10);
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.e0(a11) + a11, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 10:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        t4 t4Var = (t4) unsafe.getObject(o4Var2, j10);
                        Logger logger3 = u4.f3489h;
                        int h12 = t4Var.h();
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.e0(h12) + h12, i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 11:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.e0(unsafe.getInt(o4Var2, j10)), i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.c0(unsafe.getInt(o4Var2, j10)), i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 4, i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 8, i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        int i25 = unsafe.getInt(o4Var2, j10);
                        i18 = android.support.v4.media.d.f((i25 >> 31) ^ (i25 + i25), u4.e0(i20 << 3), i18);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        long j11 = unsafe.getLong(o4Var2, j10);
                        i18 += u4.f0((j11 >> 63) ^ (j11 + j11)) + u4.e0(i20 << 3);
                    }
                    v5Var = this;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 17:
                    if (v5Var.w(o4Var2, i16, i15, i17, i11)) {
                        o4 o4Var3 = (o4) unsafe.getObject(o4Var2, j10);
                        d6 p11 = v5Var.p(i16);
                        Logger logger4 = u4.f3489h;
                        a10 = o4Var3.a(p11);
                        e02 = u4.e0(i20 << 3);
                        i12 = e02 + e02;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 18:
                    h10 = e6.h(i20, (List) unsafe.getObject(o4Var2, j10));
                    i18 += h10;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 19:
                    h10 = e6.g(i20, (List) unsafe.getObject(o4Var2, j10));
                    i18 += h10;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(o4Var2, j10);
                    Class cls2 = e6.f3302a;
                    if (list.size() != 0) {
                        e03 = (u4.e0(i20 << 3) * list.size()) + e6.j(list);
                        i18 += e03;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e03 = 0;
                    i18 += e03;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls3 = e6.f3302a;
                    size = list2.size();
                    if (size != 0) {
                        n10 = e6.n(list2);
                        e04 = u4.e0(i20 << 3);
                        e05 = (e04 * size) + n10;
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls4 = e6.f3302a;
                    size = list3.size();
                    if (size != 0) {
                        n10 = e6.i(list3);
                        e04 = u4.e0(i20 << 3);
                        e05 = (e04 * size) + n10;
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 23:
                    h10 = e6.h(i20, (List) unsafe.getObject(o4Var2, j10));
                    i18 += h10;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 24:
                    h10 = e6.g(i20, (List) unsafe.getObject(o4Var2, j10));
                    i18 += h10;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls5 = e6.f3302a;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        e03 = (u4.e0(i20 << 3) + 1) * size2;
                        i18 += e03;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e03 = 0;
                    i18 += e03;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 26:
                    List list5 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls6 = e6.f3302a;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        boolean z10 = list5 instanceof j5;
                        e05 = u4.e0(i20 << 3) * size3;
                        if (z10) {
                            j5 j5Var = (j5) list5;
                            for (int i26 = 0; i26 < size3; i26++) {
                                Object a12 = j5Var.a(i26);
                                if (a12 instanceof t4) {
                                    int h13 = ((t4) a12).h();
                                    e05 = android.support.v4.media.d.f(h13, h13, e05);
                                } else {
                                    e05 = u4.d0((String) a12) + e05;
                                }
                            }
                        } else {
                            for (int i27 = 0; i27 < size3; i27++) {
                                Object obj = list5.get(i27);
                                if (obj instanceof t4) {
                                    int h14 = ((t4) obj).h();
                                    e05 = android.support.v4.media.d.f(h14, h14, e05);
                                } else {
                                    e05 = u4.d0((String) obj) + e05;
                                }
                            }
                        }
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 27:
                    List list6 = (List) unsafe.getObject(o4Var2, j10);
                    d6 p12 = v5Var.p(i16);
                    Class cls7 = e6.f3302a;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        e06 = 0;
                    } else {
                        e06 = u4.e0(i20 << 3) * size4;
                        for (int i28 = 0; i28 < size4; i28++) {
                            int a13 = ((o4) list6.get(i28)).a(p12);
                            e06 = android.support.v4.media.d.f(a13, a13, e06);
                        }
                    }
                    i18 += e06;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 28:
                    List list7 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls8 = e6.f3302a;
                    int size5 = list7.size();
                    if (size5 != 0) {
                        e05 = u4.e0(i20 << 3) * size5;
                        for (int i29 = 0; i29 < list7.size(); i29++) {
                            int h15 = ((t4) list7.get(i29)).h();
                            e05 = android.support.v4.media.d.f(h15, h15, e05);
                        }
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 29:
                    List list8 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls9 = e6.f3302a;
                    size = list8.size();
                    if (size != 0) {
                        n10 = e6.m(list8);
                        e04 = u4.e0(i20 << 3);
                        e05 = (e04 * size) + n10;
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 30:
                    List list9 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls10 = e6.f3302a;
                    size = list9.size();
                    if (size != 0) {
                        n10 = e6.f(list9);
                        e04 = u4.e0(i20 << 3);
                        e05 = (e04 * size) + n10;
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 31:
                    h10 = e6.g(i20, (List) unsafe.getObject(o4Var2, j10));
                    i18 += h10;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 32:
                    h10 = e6.h(i20, (List) unsafe.getObject(o4Var2, j10));
                    i18 += h10;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 33:
                    List list10 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls11 = e6.f3302a;
                    size = list10.size();
                    if (size != 0) {
                        n10 = e6.k(list10);
                        e04 = u4.e0(i20 << 3);
                        e05 = (e04 * size) + n10;
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 34:
                    List list11 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls12 = e6.f3302a;
                    size = list11.size();
                    if (size != 0) {
                        n10 = e6.l(list11);
                        e04 = u4.e0(i20 << 3);
                        e05 = (e04 * size) + n10;
                        i18 += e05;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                    e05 = 0;
                    i18 += e05;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 35:
                    List list12 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls13 = e6.f3302a;
                    a10 = list12.size() * 8;
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 36:
                    List list13 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls14 = e6.f3302a;
                    a10 = list13.size() * 4;
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 37:
                    a10 = e6.j((List) unsafe.getObject(o4Var2, j10));
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 38:
                    a10 = e6.n((List) unsafe.getObject(o4Var2, j10));
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 39:
                    a10 = e6.i((List) unsafe.getObject(o4Var2, j10));
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 40:
                    List list14 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls15 = e6.f3302a;
                    a10 = list14.size() * 8;
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 41:
                    List list15 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls16 = e6.f3302a;
                    a10 = list15.size() * 4;
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 42:
                    List list16 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls17 = e6.f3302a;
                    a10 = list16.size();
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 43:
                    a10 = e6.m((List) unsafe.getObject(o4Var2, j10));
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 44:
                    a10 = e6.f((List) unsafe.getObject(o4Var2, j10));
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 45:
                    List list17 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls18 = e6.f3302a;
                    a10 = list17.size() * 4;
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 46:
                    List list18 = (List) unsafe.getObject(o4Var2, j10);
                    Class cls19 = e6.f3302a;
                    a10 = list18.size() * 8;
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 47:
                    a10 = e6.k((List) unsafe.getObject(o4Var2, j10));
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 48:
                    a10 = e6.l((List) unsafe.getObject(o4Var2, j10));
                    if (a10 > 0) {
                        e07 = u4.e0(a10);
                        e08 = u4.e0(i20 << 3);
                        i12 = e08 + e07;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 49:
                    List list19 = (List) unsafe.getObject(o4Var2, j10);
                    d6 p13 = v5Var.p(i16);
                    Class cls20 = e6.f3302a;
                    int size6 = list19.size();
                    if (size6 == 0) {
                        i13 = 0;
                    } else {
                        i13 = 0;
                        for (int i30 = 0; i30 < size6; i30++) {
                            o4 o4Var4 = (o4) list19.get(i30);
                            Logger logger5 = u4.f3489h;
                            int a14 = o4Var4.a(p13);
                            int e09 = u4.e0(i20 << 3);
                            i13 += e09 + e09 + a14;
                        }
                    }
                    i18 += i13;
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 50:
                    Object object3 = unsafe.getObject(o4Var2, j10);
                    int i31 = i16 / 3;
                    Object obj2 = v5Var.f3535b[i31 + i31];
                    if (object3 != null) {
                        throw new ClassCastException();
                    }
                    obj2.getClass();
                    throw new ClassCastException();
                case 51:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 8, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 52:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 4, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 53:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.f0(o(j10, o4Var2)), i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 54:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.f0(o(j10, o4Var2)), i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 55:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.c0(l(j10, o4Var2)), i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 56:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 8, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 57:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 4, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 58:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 1, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 59:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        int i32 = i20 << 3;
                        Object object4 = unsafe.getObject(o4Var2, j10);
                        if (object4 instanceof t4) {
                            Logger logger6 = u4.f3489h;
                            int h16 = ((t4) object4).h();
                            i18 = android.support.v4.media.d.f(i32, u4.e0(h16) + h16, i18);
                        } else {
                            i18 = android.support.v4.media.d.f(i32, u4.d0((String) object4), i18);
                        }
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 60:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        Object object5 = unsafe.getObject(o4Var2, j10);
                        d6 p14 = v5Var.p(i16);
                        Class cls21 = e6.f3302a;
                        Logger logger7 = u4.f3489h;
                        int a15 = ((o4) object5).a(p14);
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.e0(a15) + a15, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 61:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        t4 t4Var2 = (t4) unsafe.getObject(o4Var2, j10);
                        Logger logger8 = u4.f3489h;
                        int h17 = t4Var2.h();
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.e0(h17) + h17, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 62:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.e0(l(j10, o4Var2)), i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 63:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, u4.c0(l(j10, o4Var2)), i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 4, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 65:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        i18 = android.support.v4.media.d.f(i20 << 3, 8, i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 66:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        int l10 = l(j10, o4Var2);
                        i18 = android.support.v4.media.d.f((l10 >> 31) ^ (l10 + l10), u4.e0(i20 << 3), i18);
                    }
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
                case 67:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        long o2 = o(j10, o4Var2);
                        a10 = u4.e0(i20 << 3);
                        i12 = u4.f0((o2 >> 63) ^ (o2 + o2));
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                case 68:
                    if (v5Var.j(i20, i16, o4Var2)) {
                        o4 o4Var5 = (o4) unsafe.getObject(o4Var2, j10);
                        d6 p15 = v5Var.p(i16);
                        Logger logger9 = u4.f3489h;
                        a10 = o4Var5.a(p15);
                        e02 = u4.e0(i20 << 3);
                        i12 = e02 + e02;
                        i18 += i12 + a10;
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    } else {
                        i16 += 3;
                        o4Var2 = o4Var;
                        i14 = 1048575;
                    }
                default:
                    i16 += 3;
                    o4Var2 = o4Var;
                    i14 = 1048575;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.cast.d6
    public final void g(Object obj, Object obj2) {
        Object obj3;
        if (!i(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
        obj2.getClass();
        int i10 = 0;
        while (true) {
            int[] iArr = this.f3534a;
            if (i10 >= iArr.length) {
                e6.o(this.g, obj, obj2);
                return;
            }
            int n10 = n(i10);
            int i11 = n10 & 1048575;
            int m10 = m(n10);
            int i12 = iArr[i10];
            long j10 = i11;
            switch (m10) {
                case 0:
                    if (v(i10, obj2)) {
                        o6 o6Var = p6.f3428c;
                        obj3 = obj;
                        o6Var.e(obj3, j10, o6Var.a(j10, obj2));
                        t(i10, obj3);
                        i10 += 3;
                        obj = obj3;
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 1:
                    if (v(i10, obj2)) {
                        o6 o6Var2 = p6.f3428c;
                        o6Var2.f(obj, j10, o6Var2.b(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 2:
                    if (v(i10, obj2)) {
                        p6.k(obj, j10, p6.f(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 3:
                    if (v(i10, obj2)) {
                        p6.k(obj, j10, p6.f(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 4:
                    if (v(i10, obj2)) {
                        p6.j(p6.e(j10, obj2), j10, obj);
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 5:
                    if (v(i10, obj2)) {
                        p6.k(obj, j10, p6.f(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 6:
                    if (v(i10, obj2)) {
                        p6.j(p6.e(j10, obj2), j10, obj);
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 7:
                    if (v(i10, obj2)) {
                        o6 o6Var3 = p6.f3428c;
                        o6Var3.c(obj, j10, o6Var3.g(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 8:
                    if (v(i10, obj2)) {
                        p6.l(j10, obj, p6.h(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 9:
                    r(obj, i10, obj2);
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 10:
                    if (v(i10, obj2)) {
                        p6.l(j10, obj, p6.h(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 11:
                    if (v(i10, obj2)) {
                        p6.j(p6.e(j10, obj2), j10, obj);
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    if (v(i10, obj2)) {
                        p6.j(p6.e(j10, obj2), j10, obj);
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    if (v(i10, obj2)) {
                        p6.j(p6.e(j10, obj2), j10, obj);
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    if (v(i10, obj2)) {
                        p6.k(obj, j10, p6.f(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (v(i10, obj2)) {
                        p6.j(p6.e(j10, obj2), j10, obj);
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    if (v(i10, obj2)) {
                        p6.k(obj, j10, p6.f(j10, obj2));
                        t(i10, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 17:
                    r(obj, i10, obj2);
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f3539f.b(j10, obj, obj2);
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 50:
                    Class cls = e6.f3302a;
                    Object h10 = p6.h(j10, obj);
                    Object h11 = p6.h(j10, obj2);
                    if (h10 != null) {
                        throw new ClassCastException();
                    }
                    h11.getClass();
                    throw new ClassCastException();
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (j(i12, i10, obj2)) {
                        p6.l(j10, obj, p6.h(j10, obj2));
                        p6.j(i12, iArr[i10 + 2] & 1048575, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 60:
                    s(obj, i10, obj2);
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 61:
                case 62:
                case 63:
                case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                case 65:
                case 66:
                case 67:
                    if (j(i12, i10, obj2)) {
                        p6.l(j10, obj, p6.h(j10, obj2));
                        p6.j(i12, iArr[i10 + 2] & 1048575, obj);
                    }
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                case 68:
                    s(obj, i10, obj2);
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
                default:
                    obj3 = obj;
                    i10 += 3;
                    obj = obj3;
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final a5 h() {
        return (a5) ((a5) this.f3536c).h(4, null);
    }

    public final boolean j(int i10, int i11, Object obj) {
        return p6.e((long) (this.f3534a[i11 + 2] & 1048575), obj) == i10;
    }

    public final int n(int i10) {
        return this.f3534a[i10 + 1];
    }

    public final d6 p(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        Object[] objArr = this.f3535b;
        d6 d6Var = (d6) objArr[i12];
        if (d6Var != null) {
            return d6Var;
        }
        d6 a10 = a6.f3253c.a((Class) objArr[i12 + 1]);
        objArr[i12] = a10;
        return a10;
    }

    public final void r(Object obj, int i10, Object obj2) {
        if (v(i10, obj2)) {
            int n10 = n(i10) & 1048575;
            Unsafe unsafe = f3533i;
            long j10 = n10;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f3534a[i10] + " is present but null: " + obj2.toString());
            }
            d6 p10 = p(i10);
            if (!v(i10, obj)) {
                if (i(object)) {
                    a5 h10 = p10.h();
                    p10.g(h10, object);
                    unsafe.putObject(obj, j10, h10);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                t(i10, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!i(object2)) {
                a5 h11 = p10.h();
                p10.g(h11, object2);
                unsafe.putObject(obj, j10, h11);
                object2 = h11;
            }
            p10.g(object2, object);
        }
    }

    public final void s(Object obj, int i10, Object obj2) {
        int[] iArr = this.f3534a;
        int i11 = iArr[i10];
        if (j(i11, i10, obj2)) {
            int n10 = n(i10) & 1048575;
            Unsafe unsafe = f3533i;
            long j10 = n10;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i10] + " is present but null: " + obj2.toString());
            }
            d6 p10 = p(i10);
            if (!j(i11, i10, obj)) {
                if (i(object)) {
                    a5 h10 = p10.h();
                    p10.g(h10, object);
                    unsafe.putObject(obj, j10, h10);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                p6.j(i11, iArr[i10 + 2] & 1048575, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!i(object2)) {
                a5 h11 = p10.h();
                p10.g(h11, object2);
                unsafe.putObject(obj, j10, h11);
                object2 = h11;
            }
            p10.g(object2, object);
        }
    }

    public final void t(int i10, Object obj) {
        int i11 = this.f3534a[i10 + 2];
        long j10 = 1048575 & i11;
        if (j10 == 1048575) {
            return;
        }
        p6.j((1 << (i11 >>> 20)) | p6.e(j10, obj), j10, obj);
    }

    public final boolean u(a5 a5Var, a5 a5Var2, int i10) {
        return v(i10, a5Var) == v(i10, a5Var2);
    }

    public final boolean v(int i10, Object obj) {
        int i11 = this.f3534a[i10 + 2];
        long j10 = i11 & 1048575;
        if (j10 == 1048575) {
            int n10 = n(i10);
            long j11 = n10 & 1048575;
            switch (m(n10)) {
                case 0:
                    if (Double.doubleToRawLongBits(p6.f3428c.a(j11, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(p6.f3428c.b(j11, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (p6.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (p6.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (p6.e(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (p6.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (p6.e(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return p6.f3428c.g(j11, obj);
                case 8:
                    Object h10 = p6.h(j11, obj);
                    if (h10 instanceof String) {
                        if (((String) h10).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(h10 instanceof t4)) {
                            throw new IllegalArgumentException();
                        }
                        if (t4.f3476q.equals(h10)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (p6.h(j11, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (t4.f3476q.equals(p6.h(j11, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (p6.e(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    if (p6.e(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    if (p6.e(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    if (p6.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (p6.e(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    if (p6.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (p6.h(j11, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i11 >>> 20)) & p6.e(j10, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean w(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? v(i10, obj) : (i12 & i13) != 0;
    }
}
