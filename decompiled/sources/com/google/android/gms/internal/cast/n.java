package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import org.chromium.net.R;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class n {

    /* renamed from: a, reason: collision with root package name */
    public static Field f3380a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f3381b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f3382c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3383d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f3384e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f3385f;
    public static Field g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f3386h;

    public static final String a(Object[] objArr, int i10, int i11, ma.e eVar) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            Object obj = objArr[i10 + i12];
            if (obj == eVar) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(obj);
            }
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        za.h.d("toString(...)", sb3);
        return sb3;
    }

    public static List b(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new r9.b(0, iArr.length, iArr);
    }

    public static int c(long j10) {
        int i10 = (int) j10;
        com.bumptech.glide.e.f(j10, ((long) i10) == j10, "Out of range: %s");
        return i10;
    }

    public static final la.e d(Throwable th) {
        za.h.e("exception", th);
        return new la.e(th);
    }

    public static void e(Object obj) {
        LongSparseArray longSparseArray;
        if (!f3383d) {
            try {
                f3382c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e7) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e7);
            }
            f3383d = true;
        }
        Class cls = f3382c;
        if (cls == null) {
            return;
        }
        if (!f3385f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f3384e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e8);
            }
            f3385f = true;
        }
        Field field = f3384e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e10) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e10);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static int f(byte b2, byte b10, byte b11, byte b12) {
        return (b2 << 24) | ((b10 & 255) << 16) | ((b11 & 255) << 8) | (b12 & 255);
    }

    public static final x4.j g(x4.o oVar) {
        za.h.e("<this>", oVar);
        return new x4.j(oVar.f13569a, oVar.f13587t);
    }

    public static String h(String str) {
        int indexOf = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".indexOf(str.substring(str.length() - 2, str.length() - 1));
        int indexOf2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".indexOf(str.substring(str.length() - 1));
        String substring = str.substring(0, str.length() - 2);
        return new String(Base64.decode(substring.substring(0, indexOf) + substring.substring(indexOf + indexOf2), 0), StandardCharsets.UTF_8).trim();
    }

    public static int i(Context context) {
        float fraction;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        boolean z10 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(z10 ? R.dimen.mr_dialog_fixed_width_minor : R.dimen.mr_dialog_fixed_width_major, typedValue, true);
        int i10 = typedValue.type;
        if (i10 == 5) {
            fraction = typedValue.getDimension(displayMetrics);
        } else {
            if (i10 != 6) {
                return -2;
            }
            int i11 = displayMetrics.widthPixels;
            fraction = typedValue.getFraction(i11, i11);
        }
        return (int) fraction;
    }

    public static String j(int i10) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".charAt(random.nextInt(62)));
        }
        return sb2.toString();
    }

    public static String k(int i10) {
        return String.valueOf("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".charAt(i10));
    }

    public static JSONObject l(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
            return jSONObject;
        } catch (Exception e7) {
            Log.e("Security", "getJsonData", e7);
            return jSONObject;
        }
    }

    public static String m(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac_address", str);
            jSONObject.put("parent_control", str2);
        } catch (Exception e7) {
            Log.e("Security", "getParentData", e7);
        }
        String trim = new String(Base64.encode(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 0)).trim();
        int nextInt = new Random().nextInt(20);
        int nextInt2 = new Random().nextInt(trim.length());
        if (nextInt2 > 42) {
            nextInt2 = 42;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(trim.substring(0, nextInt2) + j(nextInt) + trim.substring(nextInt2));
        sb2.append(k(nextInt2));
        sb2.append(k(nextInt));
        return sb2.toString();
    }

    public static int n(int[] iArr, int i10, int i11, int i12) {
        while (i11 < i12) {
            if (iArr[i11] == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static void o(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(str.concat(" can not be null"));
        }
    }

    public static void p(h3.e eVar, int i10, l1.h hVar) {
        long l10 = eVar.l(i10);
        List r2 = eVar.r(l10);
        if (r2.isEmpty()) {
            return;
        }
        if (i10 == eVar.w() - 1) {
            throw new IllegalStateException();
        }
        long l11 = eVar.l(i10 + 1) - eVar.l(i10);
        if (l11 > 0) {
            hVar.accept(new h3.a(l10, l11, r2));
        }
    }

    public static pa.i q(pa.i iVar, pa.i iVar2) {
        za.h.e("context", iVar2);
        return iVar2 == pa.j.f10146o ? iVar : (pa.i) iVar2.x(iVar, new pa.b(1));
    }

    public static final void r(Object[] objArr, int i10, int i11) {
        za.h.e("<this>", objArr);
        while (i10 < i11) {
            objArr[i10] = null;
            i10++;
        }
    }

    public static int s(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }

    public static final void t(Object obj) {
        if (obj instanceof la.e) {
            throw ((la.e) obj).f8330o;
        }
    }

    public static int[] u(Collection collection) {
        if (collection instanceof r9.b) {
            r9.b bVar = (r9.b) collection;
            return Arrays.copyOfRange(bVar.f10980o, bVar.f10981p, bVar.f10982q);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            iArr[i10] = ((Number) obj).intValue();
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0059 A[LOOP:0: B:14:0x0053->B:16:0x0059, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void v(h3.e r12, h3.j r13, l1.h r14) {
        /*
            long r0 = r13.f5536a
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto Le
            r4 = r5
            goto L27
        Le:
            int r4 = r12.a(r0)
            r6 = -1
            if (r4 != r6) goto L19
            int r4 = r12.w()
        L19:
            if (r4 <= 0) goto L27
            int r6 = r4 + (-1)
            long r6 = r12.l(r6)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 != 0) goto L27
            int r4 = r4 + (-1)
        L27:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L51
            int r2 = r12.w()
            if (r4 >= r2) goto L51
            java.util.List r11 = r12.r(r0)
            long r2 = r12.l(r4)
            boolean r6 = r11.isEmpty()
            if (r6 != 0) goto L51
            long r7 = r13.f5536a
            int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r6 >= 0) goto L51
            h3.a r6 = new h3.a
            long r9 = r2 - r7
            r6.<init>(r7, r9, r11)
            r14.accept(r6)
            r2 = 1
            goto L52
        L51:
            r2 = r5
        L52:
            r3 = r4
        L53:
            int r6 = r12.w()
            if (r3 >= r6) goto L5f
            p(r12, r3, r14)
            int r3 = r3 + 1
            goto L53
        L5f:
            boolean r13 = r13.f5537b
            if (r13 == 0) goto L87
            if (r2 == 0) goto L67
            int r4 = r4 + (-1)
        L67:
            if (r5 >= r4) goto L6f
            p(r12, r5, r14)
            int r5 = r5 + 1
            goto L67
        L6f:
            if (r2 == 0) goto L87
            h3.a r6 = new h3.a
            java.util.List r11 = r12.r(r0)
            long r7 = r12.l(r4)
            long r12 = r12.l(r4)
            long r9 = r0 - r12
            r6.<init>(r7, r9, r11)
            r14.accept(r6)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.n.v(h3.e, h3.j, l1.h):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Integer w(String str) {
        byte b2;
        Integer num;
        Long l10;
        byte b10;
        str.getClass();
        if (!str.isEmpty()) {
            int i10 = str.charAt(0) == '-' ? 1 : 0;
            if (i10 != str.length()) {
                int i11 = i10 + 1;
                char charAt = str.charAt(i10);
                if (charAt < 128) {
                    b2 = r9.c.f10983a[charAt];
                } else {
                    byte[] bArr = r9.c.f10983a;
                    b2 = -1;
                }
                if (b2 >= 0 && b2 < 10) {
                    long j10 = -b2;
                    long j11 = 10;
                    long j12 = Long.MIN_VALUE / j11;
                    while (true) {
                        if (i11 < str.length()) {
                            int i12 = i11 + 1;
                            char charAt2 = str.charAt(i11);
                            if (charAt2 < 128) {
                                b10 = r9.c.f10983a[charAt2];
                            } else {
                                byte[] bArr2 = r9.c.f10983a;
                                b10 = -1;
                            }
                            if (b10 < 0 || b10 >= 10 || j10 < j12) {
                                break;
                            }
                            long j13 = j10 * j11;
                            num = null;
                            long j14 = b10;
                            if (j13 < j14 - Long.MIN_VALUE) {
                                break;
                            }
                            j10 = j13 - j14;
                            i11 = i12;
                        } else {
                            num = null;
                            if (i10 != 0) {
                                l10 = Long.valueOf(j10);
                            } else if (j10 != Long.MIN_VALUE) {
                                l10 = Long.valueOf(-j10);
                            }
                        }
                    }
                }
                num = null;
                l10 = num;
                return (l10 == 0 && l10.longValue() == ((long) l10.intValue())) ? Integer.valueOf(l10.intValue()) : num;
            }
        }
        l10 = 0;
        num = null;
        if (l10 == 0) {
        }
    }

    public static Object x(Callable callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static Map y(String str, Bundle bundle) {
        Map map = (Map) bundle.getSerializable(str);
        if (map == null) {
            return o0.f3404u;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                hashMap.put((Integer) entry.getKey(), (Integer) entry.getValue());
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
