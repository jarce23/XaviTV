package e0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends w7.b {

    /* renamed from: q, reason: collision with root package name */
    public static final Class f4400q;

    /* renamed from: r, reason: collision with root package name */
    public static final Constructor f4401r;

    /* renamed from: s, reason: collision with root package name */
    public static final Method f4402s;

    /* renamed from: t, reason: collision with root package name */
    public static final Method f4403t;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e7) {
            Log.e("TypefaceCompatApi24Impl", e7.getClass().getName(), e7);
            cls = null;
            method = null;
            method2 = null;
        }
        f4401r = constructor;
        f4400q = cls;
        f4402s = method2;
        f4403t = method;
    }

    public static boolean B(Object obj, ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        try {
            return ((Boolean) f4402s.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface C(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f4400q, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f4403t.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // w7.b
    public final Typeface i(Context context, d0.e eVar, Resources resources, int i10) {
        Object obj;
        int i11;
        MappedByteBuffer mappedByteBuffer;
        FileInputStream fileInputStream;
        try {
            obj = f4401r.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            for (d0.f fVar : eVar.f3962a) {
                int i12 = fVar.f3968f;
                File A = x4.f.A(context);
                if (A != null) {
                    try {
                        if (x4.f.k(A, resources, i12)) {
                            try {
                                fileInputStream = new FileInputStream(A);
                            } catch (IOException unused2) {
                                mappedByteBuffer = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                i11 = (mappedByteBuffer != null && B(obj, mappedByteBuffer, fVar.f3967e, fVar.f3964b, fVar.f3965c)) ? i11 + 1 : 0;
                            } finally {
                            }
                        }
                    } finally {
                        A.delete();
                    }
                }
                mappedByteBuffer = null;
                if (mappedByteBuffer != null) {
                }
            }
            return C(obj);
        }
        return null;
    }

    @Override // w7.b
    public final Typeface j(Context context, j0.j[] jVarArr, int i10) {
        Object obj;
        try {
            obj = f4401r.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            int i11 = 0;
            p.i iVar = new p.i(0);
            int length = jVarArr.length;
            while (true) {
                if (i11 < length) {
                    j0.j jVar = jVarArr[i11];
                    Uri uri = jVar.f6930a;
                    ByteBuffer byteBuffer = (ByteBuffer) iVar.get(uri);
                    if (byteBuffer == null) {
                        byteBuffer = x4.f.E(context, uri);
                        iVar.put(uri, byteBuffer);
                    }
                    if (byteBuffer == null || !B(obj, byteBuffer, jVar.f6931b, jVar.f6932c, jVar.f6933d)) {
                        break;
                    }
                    i11++;
                } else {
                    Typeface C = C(obj);
                    if (C != null) {
                        return Typeface.create(C, i10);
                    }
                }
            }
        }
        return null;
    }
}
