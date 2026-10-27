package za;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import ya.q;
import ya.r;
import ya.s;
import ya.t;
import ya.u;
import ya.v;
import ya.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements eb.b, c {

    /* renamed from: a, reason: collision with root package name */
    public final Class f14169a;

    static {
        int i10 = 0;
        List B = ma.i.B(new Class[]{ya.a.class, ya.l.class, ya.p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, ya.b.class, ya.c.class, ya.d.class, ya.e.class, ya.f.class, ya.g.class, ya.h.class, ya.i.class, ya.j.class, ya.k.class, ya.m.class, ya.n.class, ya.o.class});
        ArrayList arrayList = new ArrayList(ma.l.z(B));
        for (Object obj : B) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                ma.k.y();
                throw null;
            }
            arrayList.add(new la.d((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        ma.t.A(arrayList);
    }

    public d(Class cls) {
        this.f14169a = cls;
    }

    @Override // za.c
    public final Class a() {
        return this.f14169a;
    }

    public final String b() {
        String c10;
        Class cls = this.f14169a;
        String str = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String c11 = p.c(cls.getName());
                return c11 == null ? cls.getSimpleName() : c11;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (c10 = p.c(componentType.getName())) != null) {
                str = c10.concat("Array");
            }
            return str == null ? "Array" : str;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return gb.i.m0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor != null) {
            return gb.i.m0(simpleName, enclosingConstructor.getName() + '$');
        }
        int e02 = gb.i.e0(simpleName, '$', 0, 6);
        if (e02 == -1) {
            return simpleName;
        }
        String substring = simpleName.substring(e02 + 1, simpleName.length());
        h.d("substring(...)", substring);
        return substring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && k5.a.p(this).equals(k5.a.p((eb.b) obj));
    }

    public final int hashCode() {
        return k5.a.p(this).hashCode();
    }

    public final String toString() {
        return this.f14169a.toString() + " (Kotlin reflection is not available)";
    }
}
