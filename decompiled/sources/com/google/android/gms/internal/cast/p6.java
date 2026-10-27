package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class p6 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f3426a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f3427b;

    /* renamed from: c, reason: collision with root package name */
    public static final o6 f3428c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f3429d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f3430e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f3431f;
    public static final boolean g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    static {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.p6.<clinit>():void");
    }

    public static void a(Class cls) {
        if (f3430e) {
            f3428c.f3412a.arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field field;
        Field field2;
        int i10 = q4.f3438a;
        try {
            field = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            field = null;
        }
        if (field != null) {
            return field;
        }
        try {
            field2 = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field2 = null;
        }
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    public static void c(Object obj, long j10, byte b2) {
        o6 o6Var = f3428c;
        long j11 = (-4) & j10;
        int i10 = o6Var.f3412a.getInt(obj, j11);
        int i11 = ((~((int) j10)) & 3) << 3;
        o6Var.f3412a.putInt(obj, j11, ((255 & b2) << i11) | (i10 & (~(255 << i11))));
    }

    public static void d(Object obj, long j10, byte b2) {
        o6 o6Var = f3428c;
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        o6Var.f3412a.putInt(obj, j11, ((255 & b2) << i10) | (o6Var.f3412a.getInt(obj, j11) & (~(255 << i10))));
    }

    public static int e(long j10, Object obj) {
        return f3428c.f3412a.getInt(obj, j10);
    }

    public static long f(long j10, Object obj) {
        return f3428c.f3412a.getLong(obj, j10);
    }

    public static Object g(Class cls) {
        try {
            return f3426a.allocateInstance(cls);
        } catch (InstantiationException e7) {
            throw new IllegalStateException(e7);
        }
    }

    public static Object h(long j10, Object obj) {
        return f3428c.f3412a.getObject(obj, j10);
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new l6());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(int i10, long j10, Object obj) {
        f3428c.f3412a.putInt(obj, j10, i10);
    }

    public static void k(Object obj, long j10, long j11) {
        f3428c.f3412a.putLong(obj, j10, j11);
    }

    public static void l(long j10, Object obj, Object obj2) {
        f3428c.f3412a.putObject(obj, j10, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean m(long j10, Object obj) {
        return ((byte) ((f3428c.f3412a.getInt(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean n(long j10, Object obj) {
        return ((byte) ((f3428c.f3412a.getInt(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean o(Class cls) {
        int i10 = q4.f3438a;
        try {
            Class cls2 = f3427b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int p(Class cls) {
        if (f3430e) {
            return f3428c.f3412a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
