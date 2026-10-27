package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: b, reason: collision with root package name */
    public static final p.i f664b = new p.i(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f665a;

    public c0(i0 i0Var) {
        this.f665a = i0Var;
    }

    public static Class b(ClassLoader classLoader, String str) {
        p.i iVar = f664b;
        p.i iVar2 = (p.i) iVar.get(classLoader);
        if (iVar2 == null) {
            iVar2 = new p.i(0);
            iVar.put(classLoader, iVar2);
        }
        Class cls = (Class) iVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        iVar2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e7) {
            throw new a6.m0(android.support.v4.media.d.q("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e7);
        } catch (ClassNotFoundException e8) {
            throw new a6.m0(android.support.v4.media.d.q("Unable to instantiate fragment ", str, ": make sure class name exists"), e8);
        }
    }

    public final s a(String str) {
        try {
            return (s) c(this.f665a.f707t.f826t.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e7) {
            throw new a6.m0(android.support.v4.media.d.q("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e7);
        } catch (InstantiationException e8) {
            throw new a6.m0(android.support.v4.media.d.q("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e8);
        } catch (NoSuchMethodException e10) {
            throw new a6.m0(android.support.v4.media.d.q("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e10);
        } catch (InvocationTargetException e11) {
            throw new a6.m0(android.support.v4.media.d.q("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e11);
        }
    }
}
