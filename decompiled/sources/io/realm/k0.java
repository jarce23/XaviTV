package io.realm;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.realm.internal.OsObject;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.UncheckedRow;
import io.realm.log.RealmLog;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k0 implements i0 {
    static final String MSG_DELETED_OBJECT = "the object is already deleted.";
    static final String MSG_DYNAMIC_OBJECT = "the object is an instance of DynamicRealmObject. Use DynamicRealmObject.getDynamicRealm() instead.";
    static final String MSG_NULL_OBJECT = "'model' is null.";

    public static <E extends i0> void addChangeListener(E e7, d0 d0Var) {
        throw new IllegalArgumentException("Listener should not be null");
    }

    public static <E extends i0> void removeChangeListener(E e7, d0 d0Var) {
        throw new IllegalArgumentException("Listener should not be null");
    }

    public final <E extends k0> Observable<ia.a> asChangesetObservable() {
        return asChangesetObservable(this);
    }

    public final <E extends k0> Flowable<E> asFlowable() {
        return asFlowable(this);
    }

    public final void deleteFromRealm() {
        deleteFromRealm(this);
    }

    public final <E extends i0> E freeze() {
        return (E) freeze(this);
    }

    public u getRealm() {
        return getRealm(this);
    }

    public final boolean isFrozen() {
        return isFrozen(this);
    }

    public final boolean isLoaded() {
        return isLoaded(this);
    }

    public boolean isManaged() {
        return isManaged(this);
    }

    public final boolean isValid() {
        return isValid(this);
    }

    public final boolean load() {
        return load(this);
    }

    public final void removeAllChangeListeners() {
        removeAllChangeListeners(this);
    }

    public static <E extends i0> Observable<ia.a> asChangesetObservable(E e7) {
        if (!(e7 instanceof io.realm.internal.y)) {
            throw new IllegalArgumentException("Cannot create Observables from unmanaged RealmObjects");
        }
        io.realm.internal.y yVar = (io.realm.internal.y) e7;
        d dVar = (d) yVar.a().f2684e;
        if (dVar instanceof u) {
            ia.g gVar = dVar.f6645q.f6670h;
            if (gVar == null) {
                throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as an implementation dependency. See https://github.com/realm/realm-java/tree/master/examples/rxJavaExample for more details.");
            }
            return ((ia.f) gVar).b((u) dVar, yVar);
        }
        if (!(dVar instanceof f)) {
            throw new UnsupportedOperationException(dVar.getClass() + " does not support RxJava. See https://realm.io/docs/java/latest/#rxjava for more details.");
        }
        f fVar = (f) dVar;
        i iVar = (i) e7;
        ia.g gVar2 = dVar.f6645q.f6670h;
        if (gVar2 != null) {
            return ((ia.f) gVar2).a(fVar, iVar);
        }
        throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as an implementation dependency. See https://github.com/realm/realm-java/tree/master/examples/rxJavaExample for more details.");
    }

    public static <E extends i0> Flowable<E> asFlowable(E e7) {
        if (!(e7 instanceof io.realm.internal.y)) {
            throw new IllegalArgumentException("Cannot create Observables from unmanaged RealmObjects");
        }
        io.realm.internal.y yVar = (io.realm.internal.y) e7;
        d dVar = (d) yVar.a().f2684e;
        if (dVar instanceof u) {
            ia.g gVar = dVar.f6645q.f6670h;
            if (gVar == null) {
                throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as an implementation dependency. See https://github.com/realm/realm-java/tree/master/examples/rxJavaExample for more details.");
            }
            return ((ia.f) gVar).d((u) dVar, yVar);
        }
        if (!(dVar instanceof f)) {
            throw new UnsupportedOperationException(dVar.getClass() + " does not support RxJava. See https://realm.io/docs/java/latest/#rxjava for more details.");
        }
        f fVar = (f) dVar;
        i iVar = (i) e7;
        ia.g gVar2 = dVar.f6645q.f6670h;
        if (gVar2 != null) {
            return ((ia.f) gVar2).c(fVar, iVar);
        }
        throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as an implementation dependency. See https://github.com/realm/realm-java/tree/master/examples/rxJavaExample for more details.");
    }

    public static <E extends i0> void deleteFromRealm(E e7) {
        if (!(e7 instanceof io.realm.internal.y)) {
            throw new IllegalArgumentException("Object not managed by Realm, so it cannot be removed.");
        }
        io.realm.internal.y yVar = (io.realm.internal.y) e7;
        if (((io.realm.internal.a0) yVar.a().f2682c) == null) {
            throw new IllegalStateException("Object malformed: missing object in Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
        }
        if (((d) yVar.a().f2684e) == null) {
            throw new IllegalStateException("Object malformed: missing Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
        }
        ((d) yVar.a().f2684e).c();
        io.realm.internal.a0 a0Var = (io.realm.internal.a0) yVar.a().f2682c;
        a0Var.h().l(a0Var.F());
        yVar.a().f2682c = io.realm.internal.f.f6741o;
    }

    public static <E extends i0> E freeze(E e7) {
        if (!(e7 instanceof io.realm.internal.y)) {
            throw new IllegalArgumentException("It is only possible to freeze valid managed Realm objects.");
        }
        io.realm.internal.y yVar = (io.realm.internal.y) e7;
        d dVar = (d) yVar.a().f2684e;
        d s10 = dVar.N() ? dVar : dVar.s();
        io.realm.internal.a0 D = ((io.realm.internal.a0) yVar.a().f2682c).D(s10.f6647s);
        if (s10 instanceof f) {
            return new i(s10, D);
        }
        if (!(s10 instanceof u)) {
            throw new UnsupportedOperationException("Unknown Realm type: ".concat(s10.getClass().getName()));
        }
        Class<? super Object> superclass = e7.getClass().getSuperclass();
        io.realm.internal.z zVar = s10.f6645q.g;
        io.realm.internal.c a10 = dVar.M().a(superclass);
        List list = Collections.EMPTY_LIST;
        return (E) zVar.i(superclass, s10, D, a10);
    }

    public static u getRealm(i0 i0Var) {
        if (i0Var == null) {
            throw new IllegalArgumentException(MSG_NULL_OBJECT);
        }
        if (i0Var instanceof i) {
            throw new IllegalStateException(MSG_DYNAMIC_OBJECT);
        }
        if (!(i0Var instanceof io.realm.internal.y)) {
            return null;
        }
        d dVar = (d) ((io.realm.internal.y) i0Var).a().f2684e;
        dVar.c();
        if (isValid(i0Var)) {
            return (u) dVar;
        }
        throw new IllegalStateException(MSG_DELETED_OBJECT);
    }

    public static <E extends i0> boolean isFrozen(E e7) {
        if (e7 instanceof io.realm.internal.y) {
            return ((d) ((io.realm.internal.y) e7).a().f2684e).N();
        }
        return false;
    }

    public static <E extends i0> boolean isLoaded(E e7) {
        if (e7 instanceof io.realm.internal.y) {
            io.realm.internal.y yVar = (io.realm.internal.y) e7;
            ((d) yVar.a().f2684e).c();
            ((io.realm.internal.a0) yVar.a().f2682c).getClass();
        }
        return true;
    }

    public static <E extends i0> boolean isManaged(E e7) {
        return e7 instanceof io.realm.internal.y;
    }

    public static <E extends i0> boolean isValid(E e7) {
        if (!(e7 instanceof io.realm.internal.y)) {
            return e7 != null;
        }
        io.realm.internal.a0 a0Var = (io.realm.internal.a0) ((io.realm.internal.y) e7).a().f2682c;
        return a0Var != null && a0Var.isValid();
    }

    public static <E extends i0> boolean load(E e7) {
        if (isLoaded(e7)) {
            return true;
        }
        if (!(e7 instanceof io.realm.internal.y)) {
            return false;
        }
        ((io.realm.internal.y) e7).a().getClass();
        return true;
    }

    public static <E extends i0> void removeAllChangeListeners(E e7) {
        if (!(e7 instanceof io.realm.internal.y)) {
            throw new IllegalArgumentException("Cannot remove listeners from this unmanaged RealmObject (created outside of Realm)");
        }
        io.realm.internal.y yVar = (io.realm.internal.y) e7;
        d dVar = (d) yVar.a().f2684e;
        if (dVar.isClosed()) {
            RealmLog.c("Calling removeChangeListener on a closed Realm %s, make sure to close all listeners before closing the Realm.", dVar.f6645q.f6666c);
        }
        c2.q a10 = yVar.a();
        OsObject osObject = (OsObject) a10.f2683d;
        if (osObject != null) {
            osObject.removeListener((k0) a10.f2681b);
            return;
        }
        io.realm.internal.n nVar = (io.realm.internal.n) a10.g;
        nVar.f6752b = true;
        nVar.f6751a.clear();
    }

    public final <E extends i0> void addChangeListener(l0 l0Var) {
        addChangeListener(this, l0Var);
    }

    public final void removeChangeListener(l0 l0Var) {
        removeChangeListener(this, l0Var);
    }

    public final <E extends i0> void addChangeListener(d0 d0Var) {
        addChangeListener(this, d0Var);
    }

    public final void removeChangeListener(d0 d0Var) {
        removeChangeListener(this, d0Var);
    }

    public static <E extends i0> void addChangeListener(E e7, l0 l0Var) {
        if (e7 == null) {
            throw new IllegalArgumentException("Object should not be null");
        }
        if (l0Var != null) {
            if (e7 instanceof io.realm.internal.y) {
                io.realm.internal.y yVar = (io.realm.internal.y) e7;
                d dVar = (d) yVar.a().f2684e;
                dVar.c();
                ((ea.a) dVar.f6647s.capabilities).c("Listeners cannot be used on current thread.");
                c2.q a10 = yVar.a();
                if (((io.realm.internal.a0) a10.f2682c) instanceof UncheckedRow) {
                    OsSharedRealm osSharedRealm = ((d) a10.f2684e).f6647s;
                    if (osSharedRealm != null && !osSharedRealm.isClosed() && ((io.realm.internal.a0) a10.f2682c).isValid() && ((OsObject) a10.f2683d) == null) {
                        OsObject osObject = new OsObject(((d) a10.f2684e).f6647s, (UncheckedRow) ((io.realm.internal.a0) a10.f2682c));
                        a10.f2683d = osObject;
                        osObject.setObserverPairs((io.realm.internal.n) a10.g);
                        a10.g = null;
                    }
                    OsObject osObject2 = (OsObject) a10.f2683d;
                    if (osObject2 != null) {
                        osObject2.addListener((k0) a10.f2681b, l0Var);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot add listener from this unmanaged RealmObject (created outside of Realm)");
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    public static <E extends i0> void removeChangeListener(E e7, l0 l0Var) {
        if (e7 == null) {
            throw new IllegalArgumentException("Object should not be null");
        }
        if (l0Var != null) {
            if (e7 instanceof io.realm.internal.y) {
                io.realm.internal.y yVar = (io.realm.internal.y) e7;
                d dVar = (d) yVar.a().f2684e;
                if (dVar.isClosed()) {
                    RealmLog.c("Calling removeChangeListener on a closed Realm %s, make sure to close all listeners before closing the Realm.", dVar.f6645q.f6666c);
                }
                c2.q a10 = yVar.a();
                k0 k0Var = (k0) a10.f2681b;
                OsObject osObject = (OsObject) a10.f2683d;
                if (osObject != null) {
                    osObject.removeListener(k0Var, l0Var);
                    return;
                } else {
                    ((io.realm.internal.n) a10.g).c(k0Var, l0Var);
                    return;
                }
            }
            throw new IllegalArgumentException("Cannot remove listener from this unmanaged RealmObject (created outside of Realm)");
        }
        throw new IllegalArgumentException("Listener should not be null");
    }
}
