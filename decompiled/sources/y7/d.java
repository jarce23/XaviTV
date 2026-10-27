package y7;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.transition.FadeAndShortSlide;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.google.android.gms.cast.framework.media.internal.ResourceProvider;
import com.google.android.gms.internal.cast.a4;
import com.google.android.gms.internal.cast.b4;
import com.google.android.gms.internal.cast.v3;
import gb.p;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import m5.i;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static ClassLoader f13904a;

    /* renamed from: b, reason: collision with root package name */
    public static Thread f13905b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f13906c;

    public static int A(String str) {
        Integer num;
        try {
            Map map = ResourceProvider.f3175a;
            num = (Integer) ResourceProvider.class.getMethod("findResourceByName", String.class).invoke(null, str);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00b0, code lost:
    
        if (r2 == null) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.ClassLoader C() {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.d.C():java.lang.ClassLoader");
    }

    public static void D(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | (i11 << 16));
    }

    public static int E(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void G(Parcel parcel, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(dataPosition - i10);
        parcel.setDataPosition(dataPosition);
    }

    public static void a(String str, boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void b(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(long j10, String str) {
        if (j10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " (" + j10 + ") must be >= 0");
    }

    public static void d(String str, Object obj) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static final int e(Cursor cursor, String str) {
        String str2;
        za.h.e("c", cursor);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
                    String[] columnNames = cursor.getColumnNames();
                    za.h.d("columnNames", columnNames);
                    String concat = ".".concat(str);
                    String str3 = "." + str + '`';
                    int length = columnNames.length;
                    int i10 = 0;
                    int i11 = 0;
                    while (i11 < length) {
                        String str4 = columnNames[i11];
                        int i12 = i10 + 1;
                        if (str4.length() >= str.length() + 2 && (p.R(str4, concat, false) || (str4.charAt(0) == '`' && p.R(str4, str3, false)))) {
                            columnIndex = i10;
                            break;
                        }
                        i11++;
                        i10 = i12;
                    }
                }
                columnIndex = -1;
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames2 = cursor.getColumnNames();
            za.h.d("c.columnNames", columnNames2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append((CharSequence) _UrlKt.FRAGMENT_ENCODE_SET);
            int i13 = 0;
            for (String str5 : columnNames2) {
                i13++;
                if (i13 > 1) {
                    sb2.append((CharSequence) ", ");
                }
                com.bumptech.glide.d.b(sb2, str5, null);
            }
            sb2.append((CharSequence) _UrlKt.FRAGMENT_ENCODE_SET);
            str2 = sb2.toString();
        } catch (Exception e7) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e7);
            str2 = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }

    public static c4.e h(i iVar, List list) {
        m5.b bVar = iVar.f8985z;
        if (bVar == null) {
            return new c4.e((byte[]) null, true, list);
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((m5.e) it.next()).f8964a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = bVar.f8956h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (m5.e eVar : bVar.f8956h) {
                    if (!treeSet.contains(eVar.f8964a)) {
                        arrayList.add(eVar);
                    }
                }
            }
        } else if (!bVar.g.isEmpty()) {
            for (Map.Entry entry : bVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new m5.e((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return new c4.e(bVar.f8950a, true, (List) arrayList);
    }

    public static String i(String str, String str2) {
        za.h.e("tableName", str);
        za.h.e("triggerType", str2);
        return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
    }

    public static byte[] j(InputStream inputStream, int i10, n5.a aVar) {
        byte[] bArr;
        n5.e eVar = new n5.e(aVar, i10);
        try {
            bArr = aVar.a(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    eVar.write(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        m5.p.d("Error occurred when closing InputStream", new Object[0]);
                    }
                    aVar.b(bArr);
                    eVar.close();
                    throw th;
                }
            }
            byte[] byteArray = eVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                m5.p.d("Error occurred when closing InputStream", new Object[0]);
            }
            aVar.b(bArr);
            eVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArr = null;
        }
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static OkHttpGlideModule l(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object newInstance = cls.getDeclaredConstructor(null).newInstance(null);
                if (newInstance instanceof OkHttpGlideModule) {
                    return (OkHttpGlideModule) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (IllegalAccessException e7) {
                o(cls, e7);
                throw null;
            } catch (InstantiationException e8) {
                o(cls, e8);
                throw null;
            } catch (NoSuchMethodException e10) {
                o(cls, e10);
                throw null;
            } catch (InvocationTargetException e11) {
                o(cls, e11);
                throw null;
            }
        } catch (ClassNotFoundException e12) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e12);
        }
    }

    public static void o(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    public static void p(Parcel parcel, int i10, Boolean bool) {
        if (bool == null) {
            return;
        }
        D(parcel, i10, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public static void q(Parcel parcel, int i10, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int E = E(parcel, i10);
        parcel.writeBundle(bundle);
        G(parcel, E);
    }

    public static void r(Parcel parcel, int i10, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int E = E(parcel, i10);
        parcel.writeStrongBinder(iBinder);
        G(parcel, E);
    }

    public static void s(Parcel parcel, int i10, int[] iArr) {
        if (iArr == null) {
            return;
        }
        int E = E(parcel, i10);
        parcel.writeIntArray(iArr);
        G(parcel, E);
    }

    public static void t(Parcel parcel, int i10, Integer num) {
        if (num == null) {
            return;
        }
        D(parcel, i10, 4);
        parcel.writeInt(num.intValue());
    }

    public static void u(Parcel parcel, int i10, long[] jArr) {
        if (jArr == null) {
            return;
        }
        int E = E(parcel, i10);
        parcel.writeLongArray(jArr);
        G(parcel, E);
    }

    public static void v(Parcel parcel, int i10, Parcelable parcelable, int i11) {
        if (parcelable == null) {
            return;
        }
        int E = E(parcel, i10);
        parcelable.writeToParcel(parcel, i11);
        G(parcel, E);
    }

    public static void w(Parcel parcel, int i10, String str) {
        if (str == null) {
            return;
        }
        int E = E(parcel, i10);
        parcel.writeString(str);
        G(parcel, E);
    }

    public static void x(Parcel parcel, int i10, List list) {
        if (list == null) {
            return;
        }
        int E = E(parcel, i10);
        parcel.writeStringList(list);
        G(parcel, E);
    }

    public static void y(Parcel parcel, int i10, Parcelable[] parcelableArr, int i11) {
        if (parcelableArr == null) {
            return;
        }
        int E = E(parcel, i10);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i11);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        G(parcel, E);
    }

    public static void z(Parcel parcel, int i10, List list) {
        if (list == null) {
            return;
        }
        int E = E(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcelable parcelable = (Parcelable) list.get(i11);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        G(parcel, E);
    }

    public abstract v3 B(b4 b4Var);

    public abstract a4 F(b4 b4Var);

    public abstract void H(a4 a4Var, a4 a4Var2);

    public abstract void I(a4 a4Var, Thread thread);

    public abstract boolean J(b4 b4Var, v3 v3Var, v3 v3Var2);

    public abstract boolean K(b4 b4Var, Object obj, Object obj2);

    public abstract boolean L(b4 b4Var, a4 a4Var, a4 a4Var2);

    public float f(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        return view.getTranslationX();
    }

    public float g(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        return view.getTranslationY();
    }

    public abstract void n(boolean z10);

    public void m(boolean z10) {
    }
}
