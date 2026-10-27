package io.realm;

import android.content.Context;
import android.os.Looper;
import io.realm.exceptions.RealmException;
import io.realm.internal.CheckedRow;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import io.realm.log.RealmLog;
import java.io.Closeable;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d implements Closeable {

    /* renamed from: u, reason: collision with root package name */
    public static volatile Context f6639u;

    /* renamed from: v, reason: collision with root package name */
    public static final fa.b f6640v;

    /* renamed from: w, reason: collision with root package name */
    public static final fa.b f6641w;

    /* renamed from: x, reason: collision with root package name */
    public static final bb.b f6642x;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f6643o;

    /* renamed from: p, reason: collision with root package name */
    public final long f6644p;

    /* renamed from: q, reason: collision with root package name */
    public final f0 f6645q;

    /* renamed from: r, reason: collision with root package name */
    public c0 f6646r;

    /* renamed from: s, reason: collision with root package name */
    public OsSharedRealm f6647s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f6648t;

    static {
        int i10 = fa.b.f5051p;
        f6640v = new fa.b(i10, i10);
        f6641w = new fa.b(1, 1);
        f6642x = new bb.b(4);
    }

    public d(OsSharedRealm osSharedRealm) {
        new a(this);
        this.f6644p = Thread.currentThread().getId();
        this.f6645q = osSharedRealm.getConfiguration();
        this.f6646r = null;
        this.f6647s = osSharedRealm;
        this.f6643o = osSharedRealm.isFrozen();
        this.f6648t = false;
    }

    public final i0 K(Class cls, String str, long j10) {
        Table b2;
        boolean z10 = str != null;
        if (z10) {
            k M = M();
            M.getClass();
            String k10 = Table.k(str);
            HashMap hashMap = M.f6773a;
            b2 = (Table) hashMap.get(k10);
            if (b2 == null) {
                b2 = M.f6778f.f6647s.getTable(k10);
                hashMap.put(k10, b2);
            }
        } else {
            b2 = M().b(cls);
        }
        io.realm.internal.a0 a0Var = io.realm.internal.f.f6741o;
        if (z10) {
            if (j10 != -1) {
                io.realm.internal.g gVar = b2.f6718p;
                int i10 = CheckedRow.f6677t;
                a0Var = new CheckedRow(gVar, b2, b2.nativeGetRowPtr(b2.f6717o, j10));
            }
            return new i(this, a0Var);
        }
        io.realm.internal.z zVar = this.f6645q.g;
        if (j10 != -1) {
            io.realm.internal.g gVar2 = b2.f6718p;
            int i11 = UncheckedRow.f6726s;
            a0Var = new UncheckedRow(gVar2, b2, b2.nativeGetRowPtr(b2.f6717o, j10));
        }
        io.realm.internal.c a10 = M().a(cls);
        List list = Collections.EMPTY_LIST;
        return zVar.i(cls, this, a0Var, a10);
    }

    public abstract k M();

    public final boolean N() {
        OsSharedRealm osSharedRealm = this.f6647s;
        if (osSharedRealm == null || osSharedRealm.isClosed()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        }
        return this.f6643o;
    }

    public final boolean O() {
        c();
        return this.f6647s.isInTransaction();
    }

    public final void a() {
        Looper looper = (Looper) ((ea.a) this.f6647s.capabilities).f4681c;
        if (looper != null && looper == Looper.getMainLooper() && !this.f6645q.f6673k) {
            throw new RealmException("Queries on the UI thread have been disabled. They can be enabled by setting 'RealmConfiguration.Builder.allowQueriesOnUiThread(true)'.");
        }
    }

    public final void c() {
        OsSharedRealm osSharedRealm = this.f6647s;
        if (osSharedRealm == null || osSharedRealm.isClosed()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        }
        if (this.f6643o) {
            return;
        }
        if (this.f6644p != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d dVar;
        if (!this.f6643o && this.f6644p != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
        }
        c0 c0Var = this.f6646r;
        if (c0Var == null) {
            this.f6646r = null;
            OsSharedRealm osSharedRealm = this.f6647s;
            if (osSharedRealm == null || !this.f6648t) {
                return;
            }
            osSharedRealm.close();
            this.f6647s = null;
            return;
        }
        synchronized (c0Var) {
            try {
                String str = this.f6645q.f6666c;
                a0 d6 = c0Var.d(getClass(), N() ? this.f6647s.getVersionID() : io.realm.internal.t.f6767q);
                int c10 = d6.c();
                int i10 = 0;
                if (c10 <= 0) {
                    RealmLog.c("%s has been closed already. refCount is %s", str, Integer.valueOf(c10));
                    return;
                }
                int i11 = c10 - 1;
                if (i11 == 0) {
                    d6.a();
                    this.f6646r = null;
                    OsSharedRealm osSharedRealm2 = this.f6647s;
                    if (osSharedRealm2 != null && this.f6648t) {
                        osSharedRealm2.close();
                        this.f6647s = null;
                    }
                    for (a0 a0Var : c0Var.f6635a.values()) {
                        if (a0Var instanceof b0) {
                            i10 = a0Var.f6627b.get() + i10;
                        }
                    }
                    if (i10 == 0) {
                        c0Var.f6637c = null;
                        for (a0 a0Var2 : c0Var.f6635a.values()) {
                            if ((a0Var2 instanceof y) && (dVar = ((y) a0Var2).f6894c) != null) {
                                while (!dVar.isClosed()) {
                                    dVar.close();
                                }
                            }
                        }
                        this.f6645q.getClass();
                        io.realm.internal.j jVar = io.realm.internal.j.f6747a;
                    }
                } else {
                    d6.f6626a.set(Integer.valueOf(i11));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() {
        OsSharedRealm osSharedRealm;
        if (this.f6648t && (osSharedRealm = this.f6647s) != null && !osSharedRealm.isClosed()) {
            RealmLog.c("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.f6645q.f6666c);
            c0 c0Var = this.f6646r;
            if (c0Var != null && !c0Var.f6638d.getAndSet(true)) {
                c0.f6634f.add(c0Var);
            }
        }
        super.finalize();
    }

    public final boolean isClosed() {
        if (!this.f6643o) {
            if (this.f6644p != Thread.currentThread().getId()) {
                throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
            }
        }
        OsSharedRealm osSharedRealm = this.f6647s;
        return osSharedRealm == null || osSharedRealm.isClosed();
    }

    public final void n() {
        LinkedHashSet<m0> linkedHashSet;
        j jVar;
        m mVar;
        c();
        k M = M();
        switch (M.f6779h) {
            case 0:
                d dVar = M.f6778f;
                io.realm.internal.z zVar = dVar.f6645q.g;
                Set e7 = zVar.e();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(e7.size());
                Iterator it = e7.iterator();
                while (it.hasNext()) {
                    String f10 = zVar.f((Class) it.next());
                    if (f10 == null || f10.isEmpty()) {
                        throw new IllegalArgumentException("Null or empty class names are not allowed");
                    }
                    String k10 = Table.k(f10);
                    if (dVar.f6647s.hasTable(k10)) {
                        Table table = dVar.f6647s.getTable(k10);
                        x4.i iVar = M.g;
                        if (iVar == null) {
                            throw new IllegalStateException("Attempt to use column key before set.");
                        }
                        io.realm.internal.z zVar2 = (io.realm.internal.z) iVar.f13555r;
                        HashMap hashMap = (HashMap) iVar.f13554q;
                        io.realm.internal.c cVar = (io.realm.internal.c) hashMap.get(f10);
                        if (cVar == null) {
                            Iterator it2 = zVar2.e().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Class cls = (Class) it2.next();
                                    if (zVar2.f(cls).equals(f10)) {
                                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) iVar.f13553p;
                                        cVar = (io.realm.internal.c) concurrentHashMap.get(cls);
                                        if (cVar == null) {
                                            io.realm.internal.c a10 = ((io.realm.internal.z) iVar.f13555r).a(cls, (OsSchemaInfo) iVar.f13556s);
                                            concurrentHashMap.put(cls, a10);
                                            cVar = a10;
                                        }
                                        hashMap.put(f10, cVar);
                                    }
                                }
                            }
                        }
                        if (cVar == null) {
                            Locale locale = Locale.US;
                            throw new RealmException(android.support.v4.media.d.q("'", f10, "' doesn't exist in current schema."));
                        }
                        jVar = new j(dVar, table);
                    } else {
                        jVar = null;
                    }
                    linkedHashSet2.add(jVar);
                }
                linkedHashSet = linkedHashSet2;
                break;
            default:
                d dVar2 = M.f6778f;
                String[] tablesNames = dVar2.f6647s.getTablesNames();
                linkedHashSet = new LinkedHashSet(tablesNames.length);
                for (String str : tablesNames) {
                    String e8 = Table.e(str);
                    if (e8 == null || e8.isEmpty()) {
                        throw new IllegalArgumentException("Null or empty class names are not allowed");
                    }
                    String k11 = Table.k(e8);
                    if (dVar2.f6647s.hasTable(k11)) {
                        Table table2 = dVar2.f6647s.getTable(k11);
                        new HashMap(0);
                        new HashMap(0);
                        new HashMap(0);
                        mVar = new m(dVar2, table2);
                    } else {
                        mVar = null;
                    }
                    if (mVar != null) {
                        linkedHashSet.add(mVar);
                    }
                }
                break;
        }
        for (m0 m0Var : linkedHashSet) {
            k M2 = M();
            String d6 = m0Var.f6782b.d();
            M2.getClass();
            String k12 = Table.k(d6);
            HashMap hashMap2 = M2.f6773a;
            Table table3 = (Table) hashMap2.get(k12);
            if (table3 == null) {
                table3 = M2.f6778f.f6647s.getTable(k12);
                hashMap2.put(k12, table3);
            }
            table3.b();
        }
    }

    public abstract d s();

    public final i0 x(Class cls, UncheckedRow uncheckedRow) {
        io.realm.internal.z zVar = this.f6645q.g;
        io.realm.internal.c a10 = M().a(cls);
        List list = Collections.EMPTY_LIST;
        return zVar.i(cls, this, uncheckedRow, a10);
    }

    public d(c0 c0Var, OsSchemaInfo osSchemaInfo, io.realm.internal.t tVar) {
        f0 f0Var = c0Var.f6637c;
        a aVar = new a(this);
        this.f6644p = Thread.currentThread().getId();
        this.f6645q = f0Var;
        this.f6646r = null;
        if (osSchemaInfo != null) {
            f0Var.getClass();
        }
        f0Var.getClass();
        io.realm.internal.r rVar = new io.realm.internal.r(f0Var);
        rVar.f6764d = new File(f6639u.getFilesDir(), ".realm.temp").getAbsolutePath();
        rVar.f6763c = true;
        rVar.f6762b = osSchemaInfo;
        OsSharedRealm osSharedRealm = OsSharedRealm.getInstance(rVar, tVar);
        this.f6647s = osSharedRealm;
        this.f6643o = osSharedRealm.isFrozen();
        this.f6648t = true;
        this.f6647s.registerSchemaChangedCallback(aVar);
        this.f6646r = c0Var;
    }
}
