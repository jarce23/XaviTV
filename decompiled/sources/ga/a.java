package ga;

import io.realm.exceptions.RealmException;
import io.realm.i0;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Util;
import io.realm.internal.a0;
import io.realm.internal.c;
import io.realm.internal.z;
import io.realm.u;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5442a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5443b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5444c;

    public a(z zVar, HashSet hashSet) {
        this.f5442a = 1;
        this.f5443b = zVar;
        HashSet hashSet2 = new HashSet();
        if (zVar != null) {
            Set e7 = zVar.e();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Class cls = (Class) it.next();
                if (e7.contains(cls)) {
                    hashSet2.add(cls);
                }
            }
        }
        this.f5444c = Collections.unmodifiableSet(hashSet2);
    }

    @Override // io.realm.internal.z
    public final c a(Class cls, OsSchemaInfo osSchemaInfo) {
        switch (this.f5442a) {
            case 0:
                return l(cls).a(cls, osSchemaInfo);
            default:
                k(cls);
                return ((z) this.f5443b).a(cls, osSchemaInfo);
        }
    }

    @Override // io.realm.internal.z
    public final Class b(String str) {
        switch (this.f5442a) {
            case 0:
                return l((Class) ((HashMap) this.f5444c).get(str)).b(str);
            default:
                return ((z) this.f5443b).b(str);
        }
    }

    @Override // io.realm.internal.z
    public final HashMap c() {
        switch (this.f5442a) {
            case 0:
                HashMap hashMap = new HashMap();
                Iterator it = ((Map) this.f5443b).values().iterator();
                while (it.hasNext()) {
                    hashMap.putAll(((z) it.next()).c());
                }
                return hashMap;
            default:
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry : ((z) this.f5443b).c().entrySet()) {
                    if (((Set) this.f5444c).contains(entry.getKey())) {
                        hashMap2.put((Class) entry.getKey(), (OsObjectSchemaInfo) entry.getValue());
                    }
                }
                return hashMap2;
        }
    }

    @Override // io.realm.internal.z
    public final Set e() {
        switch (this.f5442a) {
            case 0:
                return ((Map) this.f5443b).keySet();
            default:
                return (Set) this.f5444c;
        }
    }

    @Override // io.realm.internal.z
    public final String g(Class cls) {
        switch (this.f5442a) {
            case 0:
                return l(cls).g(Util.a(cls));
            default:
                k(cls);
                z zVar = (z) this.f5443b;
                zVar.getClass();
                return zVar.g(Util.a(cls));
        }
    }

    @Override // io.realm.internal.z
    public final void h(u uVar, Collection collection) {
        switch (this.f5442a) {
            case 0:
                l(Util.a(Util.a(((i0) collection.iterator().next()).getClass()))).h(uVar, collection);
                break;
            default:
                k(Util.a(((i0) collection.iterator().next()).getClass()));
                ((z) this.f5443b).h(uVar, collection);
                break;
        }
    }

    @Override // io.realm.internal.z
    public final i0 i(Class cls, Object obj, a0 a0Var, c cVar) {
        switch (this.f5442a) {
            case 0:
                List list = Collections.EMPTY_LIST;
                return l(cls).i(cls, obj, a0Var, cVar);
            default:
                List list2 = Collections.EMPTY_LIST;
                k(cls);
                return ((z) this.f5443b).i(cls, obj, a0Var, cVar);
        }
    }

    @Override // io.realm.internal.z
    public final boolean j() {
        switch (this.f5442a) {
            case 0:
                Iterator it = ((Map) this.f5443b).entrySet().iterator();
                while (it.hasNext()) {
                    if (!((z) ((Map.Entry) it.next()).getValue()).j()) {
                        return false;
                    }
                }
                return true;
            default:
                z zVar = (z) this.f5443b;
                if (zVar == null) {
                    return true;
                }
                return zVar.j();
        }
    }

    public void k(Class cls) {
        if (!((Set) this.f5444c).contains(cls)) {
            throw new IllegalArgumentException(cls.getSimpleName().concat(" is not part of the schema for this Realm"));
        }
    }

    public z l(Class cls) {
        z zVar = (z) ((Map) this.f5443b).get(Util.a(cls));
        if (zVar != null) {
            return zVar;
        }
        throw new RealmException(cls.getSimpleName().concat(" is not part of the schema for this Realm"));
    }

    public a(z[] zVarArr) {
        this.f5442a = 0;
        this.f5444c = new HashMap();
        HashMap hashMap = new HashMap();
        for (z zVar : zVarArr) {
            for (Class cls : zVar.e()) {
                String f10 = zVar.f(cls);
                Class cls2 = (Class) ((HashMap) this.f5444c).get(f10);
                if (cls2 != null && !cls2.equals(cls)) {
                    throw new IllegalStateException(String.format("It is not allowed for two different model classes to share the same internal name in Realm. The classes %s and %s are being included from the modules '%s' and '%s' and they share the same internal name '%s'.", cls2, cls, hashMap.get(cls2), zVar, f10));
                }
                hashMap.put(cls, zVar);
                ((HashMap) this.f5444c).put(f10, cls);
            }
        }
        this.f5443b = Collections.unmodifiableMap(hashMap);
    }
}
