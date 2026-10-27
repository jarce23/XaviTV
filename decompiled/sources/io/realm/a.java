package io.realm;

import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.objectstore.OsKeyPathMapping;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements OsSharedRealm.SchemaChangedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f6625a;

    public a(d dVar) {
        this.f6625a = dVar;
    }

    @Override // io.realm.internal.OsSharedRealm.SchemaChangedCallback
    public final void onSchemaChanged() {
        d dVar = this.f6625a;
        k M = dVar.M();
        if (M != null) {
            x4.i iVar = M.g;
            if (iVar != null) {
                for (Map.Entry entry : ((ConcurrentHashMap) iVar.f13553p).entrySet()) {
                    io.realm.internal.c a10 = ((io.realm.internal.z) iVar.f13555r).a((Class) entry.getKey(), (OsSchemaInfo) iVar.f13556s);
                    io.realm.internal.c cVar = (io.realm.internal.c) entry.getValue();
                    HashMap hashMap = cVar.f6737c;
                    HashMap hashMap2 = cVar.f6736b;
                    HashMap hashMap3 = cVar.f6735a;
                    if (!cVar.f6738d) {
                        throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
                    }
                    if (a10 == null) {
                        throw new NullPointerException("Attempt to copy null ColumnInfo");
                    }
                    hashMap3.clear();
                    hashMap3.putAll(a10.f6735a);
                    hashMap2.clear();
                    hashMap2.putAll(a10.f6736b);
                    hashMap.clear();
                    hashMap.putAll(a10.f6737c);
                    cVar.b(a10, cVar);
                }
            }
            M.f6773a.clear();
            M.f6774b.clear();
            M.f6775c.clear();
            M.f6776d.clear();
        }
        if (dVar instanceof u) {
            M.getClass();
            M.f6777e = new OsKeyPathMapping(M.f6778f.f6647s.getNativePtr());
        }
    }
}
