package e0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i extends g {
    public final Method A;
    public final Method B;

    /* renamed from: v, reason: collision with root package name */
    public final Class f4404v;

    /* renamed from: w, reason: collision with root package name */
    public final Constructor f4405w;

    /* renamed from: x, reason: collision with root package name */
    public final Method f4406x;

    /* renamed from: y, reason: collision with root package name */
    public final Method f4407y;

    /* renamed from: z, reason: collision with root package name */
    public final Method f4408z;

    public i() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            method2 = G(cls2);
            Class<?> cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method4 = cls2.getMethod("freeze", null);
            method5 = cls2.getMethod("abortCreation", null);
            method = H(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e7) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e7.getClass().getName()), e7);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f4404v = cls;
        this.f4405w = constructor;
        this.f4406x = method2;
        this.f4407y = method3;
        this.f4408z = method4;
        this.A = method5;
        this.B = method;
    }

    public static Method G(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean D(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f4406x.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface E(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f4404v, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.B.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean F(Object obj) {
        try {
            return ((Boolean) this.f4408z.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method H(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // e0.g, w7.b
    public final Typeface i(Context context, d0.e eVar, Resources resources, int i10) {
        Object obj;
        Method method = this.f4406x;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.i(context, eVar, resources, i10);
        }
        try {
            obj = this.f4405w.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            d0.f[] fVarArr = eVar.f3962a;
            int length = fVarArr.length;
            int i11 = 0;
            while (true) {
                if (i11 < length) {
                    d0.f fVar = fVarArr[i11];
                    Context context2 = context;
                    if (D(context2, obj, fVar.f3963a, fVar.f3967e, fVar.f3964b, fVar.f3965c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fVar.f3966d))) {
                        i11++;
                        context = context2;
                    } else {
                        try {
                            this.A.invoke(obj, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                } else if (F(obj)) {
                    return E(obj);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e A[SYNTHETIC] */
    @Override // e0.g, w7.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Typeface j(android.content.Context r18, j0.j[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.i.j(android.content.Context, j0.j[], int):android.graphics.Typeface");
    }

    @Override // w7.b
    public final Typeface o(Context context, Resources resources, int i10, String str, int i11) {
        Object obj;
        Method method = this.f4406x;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.o(context, resources, i10, str, i11);
        }
        try {
            obj = this.f4405w.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            if (!D(context, obj, str, 0, -1, -1, null)) {
                try {
                    this.A.invoke(obj, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (F(obj)) {
                return E(obj);
            }
        }
        return null;
    }
}
