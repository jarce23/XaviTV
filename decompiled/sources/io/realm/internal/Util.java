package io.realm.internal;

import io.realm.i0;
import io.realm.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class Util {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f6730a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f6731b;

    public static Class a(Class cls) {
        if (cls.equals(i0.class) || cls.equals(k0.class)) {
            throw new IllegalArgumentException("RealmModel or RealmObject was passed as an argument. Only subclasses of these can be used as arguments to methods that accept a Realm model class.");
        }
        Class superclass = cls.getSuperclass();
        return (superclass.equals(Object.class) || superclass.equals(k0.class)) ? cls : superclass;
    }

    public static synchronized boolean b() {
        boolean booleanValue;
        synchronized (Util.class) {
            if (f6731b == null) {
                try {
                    f6731b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f6731b = Boolean.FALSE;
                }
            }
            booleanValue = f6731b.booleanValue();
        }
        return booleanValue;
    }

    public static native String nativeGetTablePrefix();
}
