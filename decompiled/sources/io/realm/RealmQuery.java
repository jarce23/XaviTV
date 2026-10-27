package io.realm;

import io.realm.internal.OsResults;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableQuery;
import io.realm.internal.Util;
import io.realm.internal.objectstore.OsKeyPathMapping;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class RealmQuery<E> {

    /* renamed from: a, reason: collision with root package name */
    public final u f6621a;

    /* renamed from: b, reason: collision with root package name */
    public final TableQuery f6622b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f6623c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6624d;

    public RealmQuery(u uVar, Class cls) {
        this.f6621a = uVar;
        this.f6623c = cls;
        boolean isAssignableFrom = i0.class.isAssignableFrom(cls);
        this.f6624d = !isAssignableFrom;
        if (!isAssignableFrom) {
            throw new UnsupportedOperationException("Queries on primitive lists are not yet supported");
        }
        k kVar = uVar.f6840y;
        HashMap hashMap = kVar.f6775c;
        m0 m0Var = (m0) hashMap.get(cls);
        if (m0Var == null) {
            Class a10 = Util.a(cls);
            m0Var = a10.equals(cls) ? (m0) hashMap.get(a10) : m0Var;
            if (m0Var == null) {
                Table b2 = kVar.b(cls);
                d dVar = kVar.f6778f;
                kVar.a(a10);
                j jVar = new j(dVar, b2);
                hashMap.put(a10, jVar);
                m0Var = jVar;
            }
            if (a10.equals(cls)) {
                hashMap.put(cls, m0Var);
            }
        }
        this.f6622b = m0Var.f6782b.m();
    }

    public final void a(String str, int i10, String str2) {
        u uVar = this.f6621a;
        k kVar = uVar.f6840y;
        if (str2 == null) {
            throw new IllegalArgumentException("Nonnull 'value' required.");
        }
        uVar.c();
        w a10 = w.a(str2);
        uVar.c();
        TableQuery tableQuery = this.f6622b;
        if (i10 == 1) {
            OsKeyPathMapping osKeyPathMapping = kVar.f6777e;
            n7.i iVar = tableQuery.f6723q;
            n7.i.z(tableQuery, osKeyPathMapping, str.replace(" ", "\\ ") + " CONTAINS $0", a10);
            tableQuery.f6724r = false;
            return;
        }
        OsKeyPathMapping osKeyPathMapping2 = kVar.f6777e;
        n7.i iVar2 = tableQuery.f6723q;
        n7.i.z(tableQuery, osKeyPathMapping2, str.replace(" ", "\\ ") + " CONTAINS[c] $0", a10);
        tableQuery.f6724r = false;
    }

    public final void b(String str) {
        Boolean bool = Boolean.TRUE;
        u uVar = this.f6621a;
        uVar.c();
        OsKeyPathMapping osKeyPathMapping = uVar.f6840y.f6777e;
        v vVar = v.OBJECT;
        this.f6622b.c(osKeyPathMapping, str, new w(new e(1, bool)));
    }

    public final void c(String str, String str2) {
        u uVar = this.f6621a;
        uVar.c();
        w a10 = w.a(str2);
        uVar.c();
        this.f6622b.c(uVar.f6840y.f6777e, str, a10);
    }

    public final n0 d() {
        u uVar = this.f6621a;
        uVar.c();
        uVar.a();
        OsSharedRealm osSharedRealm = uVar.f6647s;
        int i10 = OsResults.f6702v;
        TableQuery tableQuery = this.f6622b;
        tableQuery.j();
        OsResults osResults = new OsResults(osSharedRealm, tableQuery.f6721o, OsResults.nativeCreateResults(osSharedRealm.getNativePtr(), tableQuery.f6722p));
        n0 n0Var = new n0(uVar, osResults, new x4.m(uVar, osResults, this.f6623c, 11));
        n0Var.f6783o.c();
        n0Var.f6784p.f();
        return n0Var;
    }

    public final i0 e() {
        u uVar = this.f6621a;
        uVar.c();
        uVar.a();
        if (!this.f6624d) {
            long e7 = this.f6622b.e();
            if (e7 >= 0) {
                return uVar.K(this.f6623c, null, e7);
            }
        }
        return null;
    }

    public final void f() {
        this.f6621a.c();
        this.f6622b.f();
    }

    public final void g(String str) {
        u uVar = this.f6621a;
        uVar.c();
        w a10 = w.a(str);
        uVar.c();
        OsKeyPathMapping osKeyPathMapping = uVar.f6840y.f6777e;
        TableQuery tableQuery = this.f6622b;
        n7.i iVar = tableQuery.f6723q;
        n7.i.z(tableQuery, osKeyPathMapping, "category_id".replace(" ", "\\ ") + " != $0", a10);
        tableQuery.f6724r = false;
    }

    public final void h(int i10, String str) {
        u uVar = this.f6621a;
        uVar.c();
        uVar.c();
        OsKeyPathMapping osKeyPathMapping = uVar.f6840y.f6777e;
        this.f6622b.i(osKeyPathMapping, new String[]{str}, new int[]{i10});
    }

    public final void i(String str) {
        this.f6621a.c();
        h(1, str);
    }
}
