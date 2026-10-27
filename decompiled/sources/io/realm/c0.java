package io.realm;

import io.realm.internal.objectstore.OsKeyPathMapping;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: e, reason: collision with root package name */
    public static final ArrayList f6633e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f6634f = new ConcurrentLinkedQueue();

    /* renamed from: b, reason: collision with root package name */
    public final String f6636b;

    /* renamed from: c, reason: collision with root package name */
    public f0 f6637c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6635a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f6638d = new AtomicBoolean(false);

    public c0(String str) {
        new HashSet();
        this.f6636b = str;
    }

    public static c0 c(String str, boolean z10) {
        c0 c0Var;
        ArrayList arrayList = f6633e;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                c0Var = null;
                while (it.hasNext()) {
                    c0 c0Var2 = (c0) ((WeakReference) it.next()).get();
                    if (c0Var2 == null) {
                        it.remove();
                    } else if (c0Var2.f6636b.equals(str)) {
                        c0Var = c0Var2;
                    }
                }
                if (c0Var == null && z10) {
                    c0Var = new c0(str);
                    f6633e.add(new WeakReference(c0Var));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized d a(f0 f0Var, Class cls, io.realm.internal.t tVar) {
        d b2;
        f fVar;
        try {
            a0 d6 = d(cls, tVar);
            boolean z10 = e() == 0;
            if (z10) {
                f0Var.getClass();
                io.realm.internal.j jVar = io.realm.internal.j.f6747a;
                new File(f0Var.f6666c).exists();
                this.f6637c = f0Var;
            } else {
                f(f0Var);
            }
            if (!d6.d()) {
                if (cls == u.class) {
                    u uVar = new u(this, tVar);
                    k kVar = uVar.f6840y;
                    kVar.getClass();
                    kVar.f6777e = new OsKeyPathMapping(kVar.f6778f.f6647s.getNativePtr());
                    fVar = uVar;
                } else {
                    if (cls != f.class) {
                        throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
                    }
                    fVar = new f(this, tVar);
                }
                d6.e(fVar);
            }
            ThreadLocal threadLocal = d6.f6626a;
            Integer num = (Integer) threadLocal.get();
            threadLocal.set(Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            b2 = d6.b();
            if (z10) {
                if (io.realm.internal.j.f6747a == null) {
                    io.realm.internal.j jVar2 = io.realm.internal.j.f6747a;
                }
                new u(b2.f6647s);
                f0Var.getClass();
                b2.c();
                b2.a();
                if (b2.O()) {
                    throw new IllegalStateException("Cannot refresh a Realm instance inside a transaction.");
                }
                b2.f6647s.refresh();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b2;
    }

    public final synchronized void b(j5.g gVar) {
        gVar.q(e());
    }

    public final a0 d(Class cls, io.realm.internal.t tVar) {
        z zVar;
        if (cls == u.class) {
            zVar = z.f6898o;
        } else {
            if (cls != f.class) {
                throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
            }
            zVar = z.f6899p;
        }
        ha.a aVar = new ha.a();
        aVar.f5764a = zVar;
        aVar.f5765b = tVar;
        HashMap hashMap = this.f6635a;
        a0 a0Var = (a0) hashMap.get(aVar);
        if (a0Var != null) {
            return a0Var;
        }
        a0 b0Var = tVar.equals(io.realm.internal.t.f6767q) ? new b0() : new y();
        hashMap.put(aVar, b0Var);
        return b0Var;
    }

    public final int e() {
        Iterator it = this.f6635a.values().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((a0) it.next()).f6627b.get();
        }
        return i10;
    }

    public final void f(f0 f0Var) {
        if (this.f6637c.equals(f0Var)) {
            return;
        }
        this.f6637c.getClass();
        f0Var.getClass();
        if (!Arrays.equals((byte[]) null, (byte[]) null)) {
            throw new IllegalArgumentException("Wrong key used to decrypt Realm.");
        }
        this.f6637c.getClass();
        throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. \nCached configuration: \n" + this.f6637c + "\n\nNew configuration: \n" + f0Var);
    }
}
