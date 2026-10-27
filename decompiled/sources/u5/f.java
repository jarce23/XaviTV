package u5;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final x4.c f12533a = new x4.c(18);

    /* renamed from: b, reason: collision with root package name */
    public final e f12534b = new e(0);

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12535c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f12536d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final int f12537e;

    /* renamed from: f, reason: collision with root package name */
    public int f12538f;

    public f(int i10) {
        this.f12537e = i10;
    }

    public final synchronized void a() {
        c(0);
    }

    public final void b(int i10, Class cls) {
        NavigableMap g = g(cls);
        Integer num = (Integer) g.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                g.remove(Integer.valueOf(i10));
                return;
            } else {
                g.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    public final void c(int i10) {
        while (this.f12538f > i10) {
            Object c02 = this.f12533a.c0();
            m6.f.b(c02);
            b e7 = e(c02.getClass());
            this.f12538f -= e7.b() * e7.a(c02);
            b(e7.a(c02), c02.getClass());
            if (Log.isLoggable(e7.c(), 2)) {
                Log.v(e7.c(), "evicted: " + e7.a(c02));
            }
        }
    }

    public final synchronized Object d(int i10, Class cls) {
        d dVar;
        int i11;
        try {
            Integer num = (Integer) g(cls).ceilingKey(Integer.valueOf(i10));
            if (num == null || ((i11 = this.f12538f) != 0 && this.f12537e / i11 < 2 && num.intValue() > i10 * 8)) {
                e eVar = this.f12534b;
                h hVar = (h) ((ArrayDeque) eVar.f2162a).poll();
                if (hVar == null) {
                    hVar = eVar.q();
                }
                dVar = (d) hVar;
                dVar.f12530b = i10;
                dVar.f12531c = cls;
            }
            e eVar2 = this.f12534b;
            int intValue = num.intValue();
            h hVar2 = (h) ((ArrayDeque) eVar2.f2162a).poll();
            if (hVar2 == null) {
                hVar2 = eVar2.q();
            }
            dVar = (d) hVar2;
            dVar.f12530b = intValue;
            dVar.f12531c = cls;
        } catch (Throwable th) {
            throw th;
        }
        return f(dVar, cls);
    }

    public final b e(Class cls) {
        b bVar;
        HashMap hashMap = this.f12536d;
        b bVar2 = (b) hashMap.get(cls);
        if (bVar2 != null) {
            return bVar2;
        }
        if (cls.equals(int[].class)) {
            bVar = new b(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            bVar = new b(0);
        }
        hashMap.put(cls, bVar);
        return bVar;
    }

    public final Object f(d dVar, Class cls) {
        b e7 = e(cls);
        Object R = this.f12533a.R(dVar);
        if (R != null) {
            this.f12538f -= e7.b() * e7.a(R);
            b(e7.a(R), cls);
        }
        if (R != null) {
            return R;
        }
        if (Log.isLoggable(e7.c(), 2)) {
            Log.v(e7.c(), "Allocated " + dVar.f12530b + " bytes");
        }
        int i10 = dVar.f12530b;
        switch (e7.f12524a) {
            case 0:
                return new byte[i10];
            default:
                return new int[i10];
        }
    }

    public final NavigableMap g(Class cls) {
        HashMap hashMap = this.f12535c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void h(Object obj) {
        Class<?> cls = obj.getClass();
        b e7 = e(cls);
        int a10 = e7.a(obj);
        int b2 = e7.b() * a10;
        if (b2 <= this.f12537e / 2) {
            e eVar = this.f12534b;
            h hVar = (h) ((ArrayDeque) eVar.f2162a).poll();
            if (hVar == null) {
                hVar = eVar.q();
            }
            d dVar = (d) hVar;
            dVar.f12530b = a10;
            dVar.f12531c = cls;
            this.f12533a.a0(dVar, obj);
            NavigableMap g = g(cls);
            Integer num = (Integer) g.get(Integer.valueOf(dVar.f12530b));
            Integer valueOf = Integer.valueOf(dVar.f12530b);
            int i10 = 1;
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            g.put(valueOf, Integer.valueOf(i10));
            this.f12538f += b2;
            c(this.f12537e);
        }
    }

    public final synchronized void i(int i10) {
        try {
            if (i10 >= 40) {
                a();
            } else if (i10 >= 20 || i10 == 15) {
                c(this.f12537e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
