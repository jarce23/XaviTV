package io.realm.internal;

import a6.m0;
import android.os.Looper;
import io.realm.RealmFieldType;
import io.realm.exceptions.RealmError;
import io.realm.f0;
import io.realm.internal.android.AndroidRealmNotifier;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Keep
/* loaded from: classes.dex */
public final class OsSharedRealm implements Closeable, h {
    public static final byte FILE_EXCEPTION_INCOMPATIBLE_SYNC_FILE = 7;
    public static final byte FILE_EXCEPTION_KIND_ACCESS_ERROR = 0;
    public static final byte FILE_EXCEPTION_KIND_BAD_HISTORY = 1;
    public static final byte FILE_EXCEPTION_KIND_EXISTS = 3;
    public static final byte FILE_EXCEPTION_KIND_FORMAT_UPGRADE_REQUIRED = 6;
    public static final byte FILE_EXCEPTION_KIND_INCOMPATIBLE_LOCK_FILE = 5;
    public static final byte FILE_EXCEPTION_KIND_NOT_FOUND = 4;
    public static final byte FILE_EXCEPTION_KIND_PERMISSION_DENIED = 2;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private static final List<OsSharedRealm> sharedRealmsUnderConstruction = new CopyOnWriteArrayList();
    private static volatile File temporaryDirectory;
    public final a capabilities;
    public final g context;
    final List<WeakReference<s>> iterators;
    private final long nativePtr;
    private final OsRealmConfig osRealmConfig;
    private final List<WeakReference<u>> pendingRows;
    public final RealmNotifier realmNotifier;
    private final OsSchemaInfo schemaInfo;
    private final List<OsSharedRealm> tempSharedRealmsForCallback;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    @Keep
    public interface InitializationCallback {
        void onInit(OsSharedRealm osSharedRealm);
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    @Keep
    public interface MigrationCallback {
        void onMigrationNeeded(OsSharedRealm osSharedRealm, long j10, long j11);
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    @Keep
    public interface SchemaChangedCallback {
        void onSchemaChanged();
    }

    private OsSharedRealm(OsRealmConfig osRealmConfig, t tVar) {
        ArrayList arrayList = new ArrayList();
        this.tempSharedRealmsForCallback = arrayList;
        this.pendingRows = new CopyOnWriteArrayList();
        this.iterators = new ArrayList();
        ea.a aVar = new ea.a(0);
        AndroidRealmNotifier androidRealmNotifier = new AndroidRealmNotifier(this, aVar);
        g gVar = osRealmConfig.f6700t;
        this.context = gVar;
        List<OsSharedRealm> list = sharedRealmsUnderConstruction;
        list.add(this);
        try {
            long nativeGetSharedRealm = nativeGetSharedRealm(osRealmConfig.f6699s, tVar.f6768o, tVar.f6769p, androidRealmNotifier);
            this.nativePtr = nativeGetSharedRealm;
            arrayList.clear();
            list.remove(this);
            this.osRealmConfig = osRealmConfig;
            this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(nativeGetSharedRealm));
            gVar.a(this);
            this.capabilities = aVar;
            this.realmNotifier = androidRealmNotifier;
            if (tVar.equals(t.f6767q)) {
                nativeSetAutoRefresh(nativeGetSharedRealm, (((Looper) aVar.f4681c) == null || aVar.f4680b) ? false : true);
            }
        } catch (Throwable th) {
            try {
                for (OsSharedRealm osSharedRealm : this.tempSharedRealmsForCallback) {
                    if (!osSharedRealm.isClosed()) {
                        osSharedRealm.close();
                    }
                }
                throw th;
            } catch (Throwable th2) {
                this.tempSharedRealmsForCallback.clear();
                sharedRealmsUnderConstruction.remove(this);
                throw th2;
            }
        }
    }

    private void detachIterators() {
        Iterator<WeakReference<s>> it = this.iterators.iterator();
        while (it.hasNext()) {
            s sVar = it.next().get();
            if (sVar != null) {
                sVar.f6765o = sVar.f6765o.c();
            }
        }
        this.iterators.clear();
    }

    private void executePendingRowQueries() {
        Iterator<WeakReference<u>> it = this.pendingRows.iterator();
        while (it.hasNext()) {
            if (it.next().get() != null) {
                throw new ClassCastException();
            }
        }
        this.pendingRows.clear();
    }

    public static OsSharedRealm getInstance(f0 f0Var, t tVar) {
        return getInstance(new r(f0Var), tVar);
    }

    public static File getTemporaryDirectory() {
        return temporaryDirectory;
    }

    public static void initialize(File file) {
        if (temporaryDirectory != null) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (!file.isDirectory() && !file.mkdirs() && !file.isDirectory()) {
            throw new m0(r.a.l("failed to create temporary directory: ", absolutePath));
        }
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath.concat("/");
        }
        nativeInit(absolutePath);
        temporaryDirectory = file;
    }

    private static native void nativeBeginTransaction(long j10);

    private static native void nativeCancelTransaction(long j10);

    private static native void nativeCloseSharedRealm(long j10);

    private static native void nativeCommitTransaction(long j10);

    private static native boolean nativeCompact(long j10);

    private static native long nativeCreateTable(long j10, String str);

    private static native long nativeCreateTableWithPrimaryKeyField(long j10, String str, String str2, int i10, boolean z10);

    private static native long nativeFreeze(long j10);

    private static native long nativeGetActiveSubscriptionSet(long j10);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetLatestSubscriptionSet(long j10);

    private static native long nativeGetSchemaInfo(long j10);

    private static native long nativeGetSharedRealm(long j10, long j11, long j12, RealmNotifier realmNotifier);

    private static native long nativeGetTableRef(long j10, String str);

    private static native String[] nativeGetTablesName(long j10);

    private static native long[] nativeGetVersionID(long j10);

    private static native boolean nativeHasTable(long j10, String str);

    private static native void nativeInit(String str);

    private static native boolean nativeIsAutoRefresh(long j10);

    private static native boolean nativeIsClosed(long j10);

    private static native boolean nativeIsEmpty(long j10);

    private static native boolean nativeIsFrozen(long j10);

    private static native boolean nativeIsInTransaction(long j10);

    private static native long nativeNumberOfVersions(long j10);

    private static native void nativeRefresh(long j10);

    private static native void nativeRegisterSchemaChangedCallback(long j10, SchemaChangedCallback schemaChangedCallback);

    private static native void nativeRenameTable(long j10, String str, String str2);

    private static native void nativeSetAutoRefresh(long j10, boolean z10);

    private static native long nativeSize(long j10);

    private static native void nativeStopWaitForChange(long j10);

    private static native boolean nativeWaitForChange(long j10);

    private static native void nativeWriteCopy(long j10, String str, byte[] bArr);

    private static void runInitializationCallback(long j10, OsRealmConfig osRealmConfig, InitializationCallback initializationCallback) {
        initializationCallback.onInit(new OsSharedRealm(j10, osRealmConfig));
    }

    private static void runMigrationCallback(long j10, OsRealmConfig osRealmConfig, MigrationCallback migrationCallback, long j11) {
        migrationCallback.onMigrationNeeded(new OsSharedRealm(j10, osRealmConfig), j11, osRealmConfig.f6697q.f6667d);
    }

    public void addIterator(s sVar) {
        this.iterators.add(new WeakReference<>(sVar));
    }

    public void addPendingRow(u uVar) {
        this.pendingRows.add(new WeakReference<>(uVar));
    }

    public void beginTransaction() {
        detachIterators();
        executePendingRowQueries();
        nativeBeginTransaction(this.nativePtr);
    }

    public void cancelTransaction() {
        nativeCancelTransaction(this.nativePtr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RealmNotifier realmNotifier = this.realmNotifier;
        if (realmNotifier != null) {
            realmNotifier.close();
        }
        synchronized (this.context) {
            nativeCloseSharedRealm(this.nativePtr);
        }
    }

    public void commitTransaction() {
        nativeCommitTransaction(this.nativePtr);
    }

    public boolean compact() {
        return nativeCompact(this.nativePtr);
    }

    public Table createTable(String str) {
        return new Table(this, nativeCreateTable(this.nativePtr, str));
    }

    public Table createTableWithPrimaryKey(String str, String str2, RealmFieldType realmFieldType, boolean z10) {
        return new Table(this, nativeCreateTableWithPrimaryKeyField(this.nativePtr, str, str2, realmFieldType.getNativeValue(), z10));
    }

    public OsSharedRealm freeze() {
        return new OsSharedRealm(this.osRealmConfig, getVersionID());
    }

    public f0 getConfiguration() {
        return this.osRealmConfig.f6697q;
    }

    @Override // io.realm.internal.h
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.h
    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNumberOfVersions() {
        return nativeNumberOfVersions(this.nativePtr);
    }

    public String getPath() {
        return this.osRealmConfig.f6697q.f6666c;
    }

    public OsSchemaInfo getSchemaInfo() {
        return this.schemaInfo;
    }

    public Table getTable(String str) {
        return new Table(this, nativeGetTableRef(this.nativePtr, str));
    }

    public String[] getTablesNames() {
        String[] nativeGetTablesName = nativeGetTablesName(this.nativePtr);
        return nativeGetTablesName != null ? nativeGetTablesName : new String[0];
    }

    public t getVersionID() {
        long[] nativeGetVersionID = nativeGetVersionID(this.nativePtr);
        if (nativeGetVersionID != null) {
            return new t(nativeGetVersionID[0], nativeGetVersionID[1]);
        }
        throw new IllegalStateException("Cannot get versionId, this could be related to a non existing read/write transaction");
    }

    public boolean hasTable(String str) {
        return nativeHasTable(this.nativePtr, str);
    }

    public void invalidateIterators() {
        Iterator<WeakReference<s>> it = this.iterators.iterator();
        while (it.hasNext()) {
            s sVar = it.next().get();
            if (sVar != null) {
                sVar.f6765o = null;
            }
        }
        this.iterators.clear();
    }

    public boolean isAutoRefresh() {
        return nativeIsAutoRefresh(this.nativePtr);
    }

    public boolean isClosed() {
        return nativeIsClosed(this.nativePtr);
    }

    public boolean isEmpty() {
        return nativeIsEmpty(this.nativePtr);
    }

    public boolean isFrozen() {
        return nativeIsFrozen(this.nativePtr);
    }

    public boolean isInTransaction() {
        return nativeIsInTransaction(this.nativePtr);
    }

    public boolean isSyncRealm() {
        return this.osRealmConfig.f6698r != null;
    }

    public void refresh() {
        if (isFrozen()) {
            throw new IllegalStateException("It is not possible to refresh frozen Realms.");
        }
        nativeRefresh(this.nativePtr);
    }

    public void registerSchemaChangedCallback(SchemaChangedCallback schemaChangedCallback) {
        nativeRegisterSchemaChangedCallback(this.nativePtr, schemaChangedCallback);
    }

    public void removePendingRow(u uVar) {
        for (WeakReference<u> weakReference : this.pendingRows) {
            if (weakReference.get() != null) {
                throw new ClassCastException();
            }
            this.pendingRows.remove(weakReference);
        }
    }

    public void renameTable(String str, String str2) {
        try {
            nativeRenameTable(this.nativePtr, str, str2);
        } catch (IllegalArgumentException e7) {
            throw new RealmError(e7.getMessage());
        }
    }

    public void setAutoRefresh(boolean z10) {
        ((ea.a) this.capabilities).c(null);
        nativeSetAutoRefresh(this.nativePtr, z10);
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public void stopWaitForChange() {
        nativeStopWaitForChange(this.nativePtr);
    }

    public boolean waitForChange() {
        return nativeWaitForChange(this.nativePtr);
    }

    public void writeCopy(File file, byte[] bArr) {
        if (file.isFile() && file.exists()) {
            throw new IllegalArgumentException("The destination file must not exist");
        }
        if (isSyncRealm()) {
            Looper myLooper = Looper.myLooper();
            String name = Thread.currentThread().getName();
            if (name != null) {
                name.startsWith("IntentService[");
            }
            if (myLooper != null && myLooper == Looper.getMainLooper()) {
                throw new IllegalStateException("writeCopyTo() cannot be called from the main thread when using synchronized Realms.");
            }
        }
        try {
            nativeWriteCopy(this.nativePtr, file.getAbsolutePath(), bArr);
        } catch (RuntimeException e7) {
            String message = e7.getMessage();
            if (!message.contains("Could not write file as not all client changes are integrated in server")) {
                throw e7;
            }
            throw new IllegalStateException(message);
        }
    }

    public static OsSharedRealm getInstance(r rVar, t tVar) {
        rVar.getClass();
        OsRealmConfig osRealmConfig = new OsRealmConfig(rVar.f6761a, rVar.f6764d, rVar.f6763c, rVar.f6762b, null);
        if (j.f6747a == null) {
            j jVar = j.f6747a;
        }
        return new OsSharedRealm(osRealmConfig, tVar);
    }

    public OsSharedRealm(long j10, OsRealmConfig osRealmConfig, g gVar) {
        this.tempSharedRealmsForCallback = new ArrayList();
        this.pendingRows = new CopyOnWriteArrayList();
        this.iterators = new ArrayList();
        this.nativePtr = j10;
        this.osRealmConfig = osRealmConfig;
        this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(j10));
        this.context = gVar;
        gVar.a(this);
        this.capabilities = new ea.a(0);
        this.realmNotifier = null;
        nativeSetAutoRefresh(j10, false);
    }

    public OsSharedRealm(long j10, OsRealmConfig osRealmConfig) {
        this(j10, osRealmConfig, osRealmConfig.f6700t);
        for (OsSharedRealm osSharedRealm : sharedRealmsUnderConstruction) {
            if (osSharedRealm.context == osRealmConfig.f6700t) {
                osSharedRealm.tempSharedRealmsForCallback.add(this);
                return;
            }
        }
        throw new IllegalStateException("Cannot find the parent 'OsSharedRealm' which is under construction.");
    }
}
