package com.bumptech.glide;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaRoute2Info;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.internal.cast.t4;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.t;
import o4.p;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static long f2999a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f3000b;

    public static String A(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e7) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
            sb2.append(name);
            sb2.append("@");
            sb2.append(hexString);
            String sb3 = sb2.toString();
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(sb3), (Throwable) e7);
            String name2 = e7.getClass().getName();
            StringBuilder sb4 = new StringBuilder(sb3.length() + 8 + name2.length() + 1);
            sb4.append("<");
            sb4.append(sb3);
            sb4.append(" threw ");
            sb4.append(name2);
            sb4.append(">");
            return sb4.toString();
        }
    }

    public static String a(String str, String str2) {
        return str + ":" + str2;
    }

    public static String b(String str, String str2, String str3) {
        return str + ":" + str2 + ":" + str3;
    }

    public static String c(String str, int i10, int i11) {
        if (i10 < 0) {
            return f.s("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return f.s("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException(android.support.v4.media.d.m(i11, "negative size: "));
    }

    public static void d(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
    }

    public static void f(long j10, boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(f.s(str, Long.valueOf(j10)));
        }
    }

    public static void g(int i10, int i11) {
        String s10;
        if (i10 < 0 || i10 >= i11) {
            if (i10 < 0) {
                s10 = f.s("%s (%s) must not be negative", "index", Integer.valueOf(i10));
            } else {
                if (i11 < 0) {
                    throw new IllegalArgumentException(android.support.v4.media.d.m(i11, "negative size: "));
                }
                s10 = f.s("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i10), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(s10);
        }
    }

    public static void h(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(c("index", i10, i11));
        }
    }

    public static void i(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException((i10 < 0 || i10 > i12) ? c("start index", i10, i12) : (i11 < 0 || i11 > i12) ? c("end index", i11, i12) : f.s("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public static final void j(int i10, int i11) {
        if (i10 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
    }

    public static int k(Context context, int i10, int i11) {
        Integer num;
        TypedValue x6 = c.x(context, i10);
        if (x6 != null) {
            int i12 = x6.resourceId;
            num = Integer.valueOf(i12 != 0 ? context.getColor(i12) : x6.data);
        } else {
            num = null;
        }
        return num != null ? num.intValue() : i11;
    }

    public static int l(View view, int i10) {
        Context context = view.getContext();
        TypedValue z10 = c.z(i10, view.getContext(), view.getClass().getCanonicalName());
        int i11 = z10.resourceId;
        return i11 != 0 ? context.getColor(i11) : z10.data;
    }

    public static ArrayList m(List list) {
        String id;
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaRoute2Info c10 = n0.c.c(it.next());
            if (c10 != null) {
                id = c10.getId();
                arrayList.add(id);
            }
        }
        return arrayList;
    }

    public static boolean n(LinearLayout linearLayout, View view) {
        while (view != null) {
            if (view == linearLayout) {
                return true;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return false;
            }
            view = (View) parent;
        }
        return false;
    }

    public static boolean o() {
        if (Build.VERSION.SDK_INT >= 29) {
            return k4.a.a();
        }
        try {
            if (f3000b == null) {
                f2999a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f3000b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f3000b.invoke(null, Long.valueOf(f2999a))).booleanValue();
        } catch (Exception e7) {
            if (!(e7 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e7);
                return false;
            }
            Throwable cause = e7.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static int p(float f10, int i10, int i11) {
        return e0.a.f(e0.a.h(i11, Math.round(Color.alpha(i11) * f10)), i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object, java.util.Map] */
    public static final void q(Context context) {
        LinkedHashMap linkedHashMap;
        za.h.e("context", context);
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        za.h.d("context.getDatabasePath(WORK_DATABASE_NAME)", databasePath);
        if (databasePath.exists()) {
            p.d().a(p4.o.f9950a, "Migrating WorkDatabase to the no-backup directory");
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            za.h.d("context.getDatabasePath(WORK_DATABASE_NAME)", databasePath2);
            File file = new File(p4.a.f9901a.a(context), "androidx.work.workdb");
            String[] strArr = p4.o.f9951b;
            int z10 = t.z(strArr.length);
            if (z10 < 16) {
                z10 = 16;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(z10);
            for (String str : strArr) {
                linkedHashMap2.put(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
            }
            if (linkedHashMap2.isEmpty()) {
                ?? singletonMap = Collections.singletonMap(databasePath2, file);
                za.h.d("singletonMap(...)", singletonMap);
                linkedHashMap = singletonMap;
            } else {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap2);
                linkedHashMap3.put(databasePath2, file);
                linkedHashMap = linkedHashMap3;
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                File file2 = (File) entry.getKey();
                File file3 = (File) entry.getValue();
                if (file2.exists()) {
                    if (file3.exists()) {
                        p.d().g(p4.o.f9950a, "Over-writing contents of " + file3);
                    }
                    p.d().a(p4.o.f9950a, file2.renameTo(file3) ? "Migrated " + file2 + "to " + file3 : "Renaming " + file2 + " to " + file3 + " failed");
                }
            }
        }
    }

    public static long t(l1.t tVar, int i10, int i11) {
        tVar.I(i10);
        if (tVar.a() < 5) {
            return -9223372036854775807L;
        }
        int j10 = tVar.j();
        if ((8388608 & j10) != 0 || ((2096896 & j10) >> 8) != i11 || (j10 & 32) == 0 || tVar.w() < 7 || tVar.a() < 7 || (tVar.w() & 16) != 16) {
            return -9223372036854775807L;
        }
        tVar.h(new byte[6], 0, 6);
        return ((r0[0] & 255) << 25) | ((r0[1] & 255) << 17) | ((r0[2] & 255) << 9) | ((r0[3] & 255) << 1) | ((255 & r0[4]) >> 7);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w3.i x(android.media.MediaRoute2Info r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.x(android.media.MediaRoute2Info):w3.i");
    }

    public static String y(t4 t4Var) {
        StringBuilder sb2 = new StringBuilder(t4Var.h());
        for (int i10 = 0; i10 < t4Var.h(); i10++) {
            byte f10 = t4Var.f(i10);
            if (f10 == 34) {
                sb2.append("\\\"");
            } else if (f10 == 39) {
                sb2.append("\\'");
            } else if (f10 != 92) {
                switch (f10) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        sb2.append("\\f");
                        break;
                    case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        sb2.append("\\r");
                        break;
                    default:
                        if (f10 < 32 || f10 > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((f10 >>> 6) & 3) + 48));
                            sb2.append((char) (((f10 >>> 3) & 7) + 48));
                            sb2.append((char) ((f10 & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) f10);
                            break;
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static String z(String str, Object... objArr) {
        int length;
        int indexOf;
        StringBuilder sb2 = new StringBuilder(str.length() + (objArr.length * 16));
        int i10 = 0;
        int i11 = 0;
        while (true) {
            length = objArr.length;
            if (i10 >= length || (indexOf = str.indexOf("%s", i11)) == -1) {
                break;
            }
            sb2.append((CharSequence) str, i11, indexOf);
            sb2.append(A(objArr[i10]));
            i11 = indexOf + 2;
            i10++;
        }
        sb2.append((CharSequence) str, i11, str.length());
        if (i10 < length) {
            String str2 = " [";
            while (i10 < objArr.length) {
                sb2.append(str2);
                sb2.append(A(objArr[i10]));
                i10++;
                str2 = ", ";
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    public boolean e() {
        return false;
    }

    public abstract void r(int i10);

    public abstract void s(Typeface typeface, boolean z10);

    public abstract void v();

    public abstract void w();

    public void u() {
    }
}
