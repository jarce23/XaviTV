package androidx.work.impl;

import android.database.Cursor;
import android.os.Looper;
import c4.b;
import c4.g;
import h4.c;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import ma.p;
import ma.q;
import ma.r;
import x4.e;
import x4.i;
import x4.l;
import x4.m;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class WorkDatabase {

    /* renamed from: a, reason: collision with root package name */
    public volatile c f1523a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f1524b;

    /* renamed from: c, reason: collision with root package name */
    public g4.c f1525c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1527e;

    /* renamed from: f, reason: collision with root package name */
    public List f1528f;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f1531j;

    /* renamed from: d, reason: collision with root package name */
    public final g f1526d = d();
    public final LinkedHashMap g = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final ReentrantReadWriteLock f1529h = new ReentrantReadWriteLock();

    /* renamed from: i, reason: collision with root package name */
    public final ThreadLocal f1530i = new ThreadLocal();

    public WorkDatabase() {
        h.d("synchronizedMap(mutableMapOf())", Collections.synchronizedMap(new LinkedHashMap()));
        this.f1531j = new LinkedHashMap();
    }

    public static Object q(Class cls, g4.c cVar) {
        if (cls.isInstance(cVar)) {
            return cVar;
        }
        if (cVar instanceof c4.c) {
            return q(cls, ((c4.c) cVar).a());
        }
        return null;
    }

    public final void a() {
        if (!this.f1527e && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!h().getWritableDatabase().M() && this.f1530i.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void c() {
        a();
        a();
        c writableDatabase = h().getWritableDatabase();
        this.f1526d.c(writableDatabase);
        if (writableDatabase.N()) {
            writableDatabase.c();
        } else {
            writableDatabase.a();
        }
    }

    public abstract g d();

    public abstract g4.c e(b bVar);

    public abstract x4.c f();

    public List g(Map map) {
        h.e("autoMigrationSpecs", map);
        return p.f9051o;
    }

    public final g4.c h() {
        g4.c cVar = this.f1525c;
        if (cVar != null) {
            return cVar;
        }
        h.h("internalOpenHelper");
        throw null;
    }

    public Set i() {
        return r.f9053o;
    }

    public Map j() {
        return q.f9052o;
    }

    public final void k() {
        h().getWritableDatabase().s();
        if (h().getWritableDatabase().M()) {
            return;
        }
        g gVar = this.f1526d;
        if (gVar.f2884e.compareAndSet(false, true)) {
            Executor executor = gVar.f2880a.f1524b;
            if (executor != null) {
                executor.execute(gVar.f2890l);
            } else {
                h.h("internalQueryExecutor");
                throw null;
            }
        }
    }

    public abstract e l();

    public final Cursor m(g4.e eVar) {
        a();
        b();
        return h().getWritableDatabase().O(eVar);
    }

    public final Object n(Callable callable) {
        c();
        try {
            Object call = callable.call();
            o();
            return call;
        } finally {
            k();
        }
    }

    public final void o() {
        h().getWritableDatabase().Q();
    }

    public abstract i p();

    public abstract l r();

    public abstract m s();

    public abstract x4.p t();

    public abstract x4.r u();
}
