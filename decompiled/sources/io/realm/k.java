package io.realm;

import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Table;
import io.realm.internal.Util;
import io.realm.internal.objectstore.OsKeyPathMapping;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6773a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6774b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6775c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f6776d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public OsKeyPathMapping f6777e = null;

    /* renamed from: f, reason: collision with root package name */
    public final d f6778f;
    public final x4.i g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f6779h;

    public k(d dVar, x4.i iVar, int i10) {
        this.f6779h = i10;
        this.f6778f = dVar;
        this.g = iVar;
    }

    public final io.realm.internal.c a(Class cls) {
        x4.i iVar = this.g;
        if (iVar == null) {
            throw new IllegalStateException("Attempt to use column key before set.");
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) iVar.f13553p;
        io.realm.internal.c cVar = (io.realm.internal.c) concurrentHashMap.get(cls);
        if (cVar != null) {
            return cVar;
        }
        io.realm.internal.c a10 = ((io.realm.internal.z) iVar.f13555r).a(cls, (OsSchemaInfo) iVar.f13556s);
        concurrentHashMap.put(cls, a10);
        return a10;
    }

    public final Table b(Class cls) {
        HashMap hashMap = this.f6774b;
        Table table = (Table) hashMap.get(cls);
        if (table != null) {
            return table;
        }
        Class a10 = Util.a(cls);
        if (a10.equals(cls)) {
            table = (Table) hashMap.get(a10);
        }
        if (table == null) {
            d dVar = this.f6778f;
            io.realm.internal.z zVar = dVar.f6645q.g;
            zVar.getClass();
            table = dVar.f6647s.getTable(Table.k(zVar.g(Util.a(a10))));
            hashMap.put(a10, table);
        }
        if (a10.equals(cls)) {
            hashMap.put(cls, table);
        }
        return table;
    }
}
