package io.realm.internal;

import io.realm.RealmFieldType;
import io.realm.exceptions.RealmException;
import io.realm.i0;
import io.realm.l0;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bson.types.ObjectId;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Keep
/* loaded from: classes.dex */
public class OsObject implements h {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;
    private n observerPairs = new n();

    public OsObject(OsSharedRealm osSharedRealm, UncheckedRow uncheckedRow) {
        this.nativePtr = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.f6729q);
        osSharedRealm.context.a(this);
    }

    public static UncheckedRow create(Table table) {
        return new UncheckedRow(table.f6719q.context, table, nativeCreateNewObject(table.f6717o));
    }

    public static long createEmbeddedObject(Table table, long j10, long j11) {
        return nativeCreateEmbeddedObject(table.f6717o, j10, j11);
    }

    public static long createRow(Table table) {
        return nativeCreateRow(table.f6717o);
    }

    public static long createRowWithPrimaryKey(Table table, long j10, Object obj) {
        RealmFieldType h10 = table.h(j10);
        OsSharedRealm osSharedRealm = table.f6719q;
        if (h10 == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return nativeCreateRowWithStringPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, j10, (String) obj);
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj);
        }
        if (h10 == RealmFieldType.INTEGER) {
            return nativeCreateRowWithLongPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, j10, obj == null ? 0L : Long.parseLong(obj.toString()), obj == null);
        }
        if (h10 == RealmFieldType.OBJECT_ID) {
            if (obj == null || (obj instanceof ObjectId)) {
                return nativeCreateRowWithObjectIdPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, j10, obj != null ? obj.toString() : null);
            }
            throw new IllegalArgumentException("Primary key value is not an ObjectId: " + obj);
        }
        if (h10 != RealmFieldType.UUID) {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + h10);
        }
        if (obj == null || (obj instanceof UUID)) {
            return nativeCreateRowWithUUIDPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, j10, obj != null ? obj.toString() : null);
        }
        throw new IllegalArgumentException("Primary key value is not an UUID: " + obj);
    }

    public static UncheckedRow createWithPrimaryKey(Table table, Object obj) {
        long andVerifyPrimaryKeyColumnIndex = getAndVerifyPrimaryKeyColumnIndex(table);
        RealmFieldType h10 = table.h(andVerifyPrimaryKeyColumnIndex);
        OsSharedRealm osSharedRealm = table.f6719q;
        if (h10 == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithStringPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, andVerifyPrimaryKeyColumnIndex, (String) obj));
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj);
        }
        if (h10 == RealmFieldType.INTEGER) {
            return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithLongPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, andVerifyPrimaryKeyColumnIndex, obj == null ? 0L : Long.parseLong(obj.toString()), obj == null));
        }
        if (h10 == RealmFieldType.OBJECT_ID) {
            return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithObjectIdPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, andVerifyPrimaryKeyColumnIndex, obj != null ? obj.toString() : null));
        }
        if (h10 == RealmFieldType.UUID) {
            return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithUUIDPrimaryKey(osSharedRealm.getNativePtr(), table.f6717o, andVerifyPrimaryKeyColumnIndex, obj != null ? obj.toString() : null));
        }
        throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + h10);
    }

    private static long getAndVerifyPrimaryKeyColumnIndex(Table table) {
        String a10 = OsObjectStore.a(table.f6719q, table.d());
        if (a10 != null) {
            return table.f(a10);
        }
        throw new IllegalStateException(table.j() + " has no primary key defined.");
    }

    private static native long nativeCreate(long j10, long j11);

    private static native long nativeCreateEmbeddedObject(long j10, long j11, long j12);

    private static native long nativeCreateNewObject(long j10);

    private static native long nativeCreateNewObjectWithLongPrimaryKey(long j10, long j11, long j12, long j13, boolean z10);

    private static native long nativeCreateNewObjectWithObjectIdPrimaryKey(long j10, long j11, long j12, String str);

    private static native long nativeCreateNewObjectWithStringPrimaryKey(long j10, long j11, long j12, String str);

    private static native long nativeCreateNewObjectWithUUIDPrimaryKey(long j10, long j11, long j12, String str);

    private static native long nativeCreateRow(long j10);

    private static native long nativeCreateRowWithLongPrimaryKey(long j10, long j11, long j12, long j13, boolean z10);

    private static native long nativeCreateRowWithObjectIdPrimaryKey(long j10, long j11, long j12, String str);

    private static native long nativeCreateRowWithStringPrimaryKey(long j10, long j11, long j12, String str);

    private static native long nativeCreateRowWithUUIDPrimaryKey(long j10, long j11, long j12, String str);

    private static native long nativeGetFinalizerPtr();

    private native void nativeStartListening(long j10);

    private native void nativeStopListening(long j10);

    private void notifyChangeListeners(String[] strArr) {
        n nVar = this.observerPairs;
        CopyOnWriteArrayList copyOnWriteArrayList = nVar.f6751a;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (nVar.f6752b) {
                return;
            }
            Object obj = mVar.f6748a.get();
            if (obj == null) {
                copyOnWriteArrayList.remove(mVar);
            } else if (!mVar.f6750c) {
                ((io.realm.r) ((l0) ((o) mVar).f6749b)).getClass();
                throw null;
            }
        }
    }

    public <T extends i0> void addListener(T t3, l0 l0Var) {
        if (this.observerPairs.f6751a.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.a(new o(t3, l0Var));
    }

    @Override // io.realm.internal.h
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.h
    public long getNativePtr() {
        return this.nativePtr;
    }

    public <T extends i0> void removeListener(T t3) {
        this.observerPairs.d(t3);
        if (this.observerPairs.f6751a.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public void setObserverPairs(n nVar) {
        if (!this.observerPairs.f6751a.isEmpty()) {
            throw new IllegalStateException("'observerPairs' is not empty. Listeners have been added before.");
        }
        this.observerPairs = nVar;
        if (nVar.f6751a.isEmpty()) {
            return;
        }
        nativeStartListening(this.nativePtr);
    }

    public <T extends i0> void removeListener(T t3, l0 l0Var) {
        this.observerPairs.c(t3, l0Var);
        if (this.observerPairs.f6751a.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }
}
