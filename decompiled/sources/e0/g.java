package e0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class g extends w7.b {

    /* renamed from: q, reason: collision with root package name */
    public static Class f4395q = null;

    /* renamed from: r, reason: collision with root package name */
    public static Constructor f4396r = null;

    /* renamed from: s, reason: collision with root package name */
    public static Method f4397s = null;

    /* renamed from: t, reason: collision with root package name */
    public static Method f4398t = null;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f4399u = false;

    public static boolean B(Object obj, String str, int i10, boolean z10) {
        C();
        try {
            try {
                return ((Boolean) f4397s.invoke(obj, str, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
            } catch (InvocationTargetException e7) {
                e = e7;
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InvocationTargetException e8) {
            e = e8;
        }
    }

    public static void C() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f4399u) {
            return;
        }
        f4399u = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e7) {
            Log.e("TypefaceCompatApi21Impl", e7.getClass().getName(), e7);
            method = null;
            cls = null;
            method2 = null;
        }
        f4396r = constructor;
        f4395q = cls;
        f4397s = method2;
        f4398t = method;
    }

    @Override // w7.b
    public Typeface i(Context context, d0.e eVar, Resources resources, int i10) {
        C();
        try {
            Object newInstance = f4396r.newInstance(null);
            for (d0.f fVar : eVar.f3962a) {
                File A = x4.f.A(context);
                if (A == null) {
                    return null;
                }
                try {
                    if (!x4.f.k(A, resources, fVar.f3968f)) {
                        return null;
                    }
                    if (!B(newInstance, A.getPath(), fVar.f3964b, fVar.f3965c)) {
                        return null;
                    }
                    A.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    A.delete();
                }
            }
            C();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) f4395q, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f4398t.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e7) {
                throw new RuntimeException(e7);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // w7.b
    public Typeface j(Context context, j0.j[] jVarArr, int i10) {
        File file;
        String readlink;
        if (jVarArr.length >= 1) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(p(jVarArr, i10).f6930a, "r", null);
                if (openFileDescriptor != null) {
                    try {
                        try {
                            readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    try {
                        if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                            file = new File(readlink);
                            if (file != null && file.canRead()) {
                                Typeface createFromFile = Typeface.createFromFile(file);
                                openFileDescriptor.close();
                                return createFromFile;
                            }
                            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                            Typeface l10 = l(context, fileInputStream);
                            fileInputStream.close();
                            openFileDescriptor.close();
                            return l10;
                        }
                        Typeface l102 = l(context, fileInputStream);
                        fileInputStream.close();
                        openFileDescriptor.close();
                        return l102;
                    } finally {
                    }
                    file = null;
                    if (file != null) {
                        Typeface createFromFile2 = Typeface.createFromFile(file);
                        openFileDescriptor.close();
                        return createFromFile2;
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
                } else if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                    return null;
                }
            } catch (IOException unused2) {
            }
        }
        return null;
    }
}
