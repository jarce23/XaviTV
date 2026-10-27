package com.google.android.gms.internal.cast;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z3 extends y7.d {

    /* renamed from: d, reason: collision with root package name */
    public static final Unsafe f3635d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f3636e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f3637f;
    public static final long g;

    /* renamed from: h, reason: collision with root package name */
    public static final long f3638h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f3639i;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e7) {
                throw new RuntimeException("Could not initialize intrinsics", e7.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new y3());
        }
        try {
            f3637f = unsafe.objectFieldOffset(b4.class.getDeclaredField("r"));
            f3636e = unsafe.objectFieldOffset(b4.class.getDeclaredField("q"));
            g = unsafe.objectFieldOffset(b4.class.getDeclaredField("p"));
            f3638h = unsafe.objectFieldOffset(a4.class.getDeclaredField("a"));
            f3639i = unsafe.objectFieldOffset(a4.class.getDeclaredField("b"));
            f3635d = unsafe;
        } catch (NoSuchFieldException e8) {
            throw new RuntimeException(e8);
        } catch (RuntimeException e10) {
            throw e10;
        }
    }

    @Override // y7.d
    public final v3 B(b4 b4Var) {
        v3 v3Var;
        v3 v3Var2 = v3.f3528d;
        do {
            v3Var = b4Var.f3267q;
            if (v3Var2 == v3Var) {
                break;
            }
        } while (!J(b4Var, v3Var, v3Var2));
        return v3Var;
    }

    @Override // y7.d
    public final a4 F(b4 b4Var) {
        a4 a4Var;
        a4 a4Var2 = a4.f3250c;
        do {
            a4Var = b4Var.f3268r;
            if (a4Var2 == a4Var) {
                break;
            }
        } while (!L(b4Var, a4Var, a4Var2));
        return a4Var;
    }

    @Override // y7.d
    public final void H(a4 a4Var, a4 a4Var2) {
        f3635d.putObject(a4Var, f3639i, a4Var2);
    }

    @Override // y7.d
    public final void I(a4 a4Var, Thread thread) {
        f3635d.putObject(a4Var, f3638h, thread);
    }

    @Override // y7.d
    public final boolean J(b4 b4Var, v3 v3Var, v3 v3Var2) {
        return d4.a(f3635d, b4Var, f3636e, v3Var, v3Var2);
    }

    @Override // y7.d
    public final boolean K(b4 b4Var, Object obj, Object obj2) {
        return d4.a(f3635d, b4Var, g, obj, obj2);
    }

    @Override // y7.d
    public final boolean L(b4 b4Var, a4 a4Var, a4 a4Var2) {
        return d4.a(f3635d, b4Var, f3637f, a4Var, a4Var2);
    }
}
