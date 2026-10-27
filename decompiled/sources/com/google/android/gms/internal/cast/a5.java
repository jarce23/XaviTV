package com.google.android.gms.internal.cast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a5 extends o4 {
    private static final Map zzb = new ConcurrentHashMap();
    protected g6 zzc;
    private int zzd;

    public a5() {
        this.zza = 0;
        this.zzd = -1;
        this.zzc = g6.f3314e;
    }

    public static f5 b(f5 f5Var) {
        int size = f5Var.size();
        return f5Var.c(size == 0 ? 10 : size + size);
    }

    public static Object c(Method method, a5 a5Var, Object... objArr) {
        try {
            return method.invoke(a5Var, objArr);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e7);
        } catch (InvocationTargetException e8) {
            Throwable cause = e8.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void e(Class cls, a5 a5Var) {
        a5Var.d();
        zzb.put(cls, a5Var);
    }

    public static a5 k(Class cls) {
        Map map = zzb;
        a5 a5Var = (a5) map.get(cls);
        if (a5Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                a5Var = (a5) map.get(cls);
            } catch (ClassNotFoundException e7) {
                throw new IllegalStateException("Class initialization cannot fail.", e7);
            }
        }
        if (a5Var != null) {
            return a5Var;
        }
        a5 a5Var2 = (a5) ((a5) p6.g(cls)).h(6, null);
        if (a5Var2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, a5Var2);
        return a5Var2;
    }

    @Override // com.google.android.gms.internal.cast.o4
    public final int a(d6 d6Var) {
        if (g()) {
            int f10 = d6Var.f(this);
            if (f10 >= 0) {
                return f10;
            }
            throw new IllegalStateException(android.support.v4.media.d.m(f10, "serialized size must be non-negative, was "));
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int f11 = d6Var.f(this);
        if (f11 < 0) {
            throw new IllegalStateException(android.support.v4.media.d.m(f11, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | f11;
        return f11;
    }

    public final void d() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return a6.f3253c.a(getClass()).b(this, (a5) obj);
    }

    public final void f() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean g() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object h(int i10, a5 a5Var);

    public final int hashCode() {
        if (g()) {
            return a6.f3253c.a(getClass()).a(this);
        }
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int a10 = a6.f3253c.a(getClass()).a(this);
        this.zza = a10;
        return a10;
    }

    public final int i() {
        if (g()) {
            int f10 = a6.f3253c.a(getClass()).f(this);
            if (f10 >= 0) {
                return f10;
            }
            throw new IllegalStateException(android.support.v4.media.d.m(f10, "serialized size must be non-negative, was "));
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int f11 = a6.f3253c.a(getClass()).f(this);
        if (f11 < 0) {
            throw new IllegalStateException(android.support.v4.media.d.m(f11, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | f11;
        return f11;
    }

    public final z4 j() {
        return (z4) h(5, null);
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = t5.f3479a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(obj);
        t5.c(this, sb2, 0);
        return sb2.toString();
    }
}
