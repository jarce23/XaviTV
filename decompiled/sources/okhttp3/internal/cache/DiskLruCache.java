package okhttp3.internal.cache;

import a6.m0;
import android.support.v4.media.d;
import gb.f;
import gb.h;
import gb.p;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import la.i;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import rb.b;
import rb.i0;
import rb.l0;
import rb.m;
import rb.q0;
import rb.s0;
import rb.u;
import rb.v;
import rb.x;
import ya.l;
import za.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable, Lockable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final i0 directory;
    private final u fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final i0 journalFile;
    private final i0 journalFileBackup;
    private final i0 journalFileTmp;
    private m journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final h LEGAL_KEY_PATTERN = new h("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            za.h.e("entry", entry);
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final i newSink$lambda$0$0(DiskLruCache diskLruCache, Editor editor, IOException iOException) {
            za.h.e("it", iOException);
            synchronized (diskLruCache) {
                editor.detach$okhttp();
            }
            return i.f8335a;
        }

        public final void abort() {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (za.h.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void commit() {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (za.h.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void detach$okhttp() {
            if (za.h.a(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final q0 newSink(int i10) {
            final DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (!za.h.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        return new rb.h();
                    }
                    if (!this.entry.getReadable$okhttp()) {
                        boolean[] zArr = this.written;
                        za.h.b(zArr);
                        zArr[i10] = true;
                    }
                    try {
                        return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i10)), new l() { // from class: okhttp3.internal.cache.a
                            @Override // ya.l
                            public final Object invoke(Object obj) {
                                i newSink$lambda$0$0;
                                newSink$lambda$0$0 = DiskLruCache.Editor.newSink$lambda$0$0(DiskLruCache.this, this, (IOException) obj);
                                return newSink$lambda$0$0;
                            }
                        });
                    } catch (FileNotFoundException unused) {
                        return new rb.h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final s0 newSource(int i10) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                s0 s0Var = null;
                if (!this.entry.getReadable$okhttp() || !za.h.a(this.entry.getCurrentEditor$okhttp(), this) || this.entry.getZombie$okhttp()) {
                    return null;
                }
                try {
                    s0Var = diskLruCache.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i10));
                } catch (FileNotFoundException unused) {
                }
                return s0Var;
            }
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class Entry {
        private final List<i0> cleanFiles;
        private Editor currentEditor;
        private final List<i0> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache diskLruCache, String str) {
            za.h.e("key", str);
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i10 = 0; i10 < valueCount$okhttp; i10++) {
                sb2.append(i10);
                List<i0> list = this.cleanFiles;
                i0 directory = this.this$0.getDirectory();
                String sb3 = sb2.toString();
                za.h.d("toString(...)", sb3);
                list.add(directory.d(sb3));
                sb2.append(".tmp");
                List<i0> list2 = this.dirtyFiles;
                i0 directory2 = this.this$0.getDirectory();
                String sb4 = sb2.toString();
                za.h.d("toString(...)", sb4);
                list2.add(directory2.d(sb4));
                sb2.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) {
            throw new IOException("unexpected journal line: " + list);
        }

        private final s0 newSource(int i10) {
            final s0 source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i10));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            final DiskLruCache diskLruCache = this.this$0;
            return new x(source) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;

                @Override // rb.x, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    DiskLruCache diskLruCache2 = diskLruCache;
                    DiskLruCache.Entry entry = this;
                    synchronized (diskLruCache2) {
                        entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                        if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                            diskLruCache2.removeEntry$okhttp(entry);
                        }
                    }
                }
            };
        }

        public final List<i0> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<i0> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) {
            za.h.e("strings", list);
            if (list.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(list);
                throw new m0();
            }
            try {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.lengths[i10] = Long.parseLong(list.get(i10));
                }
            } catch (NumberFormatException unused) {
                invalidLengths(list);
                throw new m0();
            }
        }

        public final void setLockingSourceCount$okhttp(int i10) {
            this.lockingSourceCount = i10;
        }

        public final void setReadable$okhttp(boolean z10) {
            this.readable = z10;
        }

        public final void setSequenceNumber$okhttp(long j10) {
            this.sequenceNumber = j10;
        }

        public final void setZombie$okhttp(boolean z10) {
            this.zombie = z10;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            }
            if (!this.readable) {
                return null;
            }
            if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            int i10 = 0;
            try {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i11 = 0; i11 < valueCount$okhttp; i11++) {
                    arrayList.add(newSource(i11));
                }
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    _UtilCommonKt.closeQuietly((s0) obj);
                }
                try {
                    this.this$0.removeEntry$okhttp(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(m mVar) {
            za.h.e("writer", mVar);
            for (long j10 : this.lengths) {
                mVar.writeByte(32).F(j10);
            }
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<s0> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String str, long j10, List<? extends s0> list, long[] jArr) {
            za.h.e("key", str);
            za.h.e("sources", list);
            za.h.e("lengths", jArr);
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j10;
            this.sources = list;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<s0> it = this.sources.iterator();
            while (it.hasNext()) {
                _UtilCommonKt.closeQuietly(it.next());
            }
        }

        public final Editor edit() {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i10) {
            return this.lengths[i10];
        }

        public final s0 getSource(int i10) {
            return this.sources.get(i10);
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(final u uVar, i0 i0Var, int i10, int i11, long j10, TaskRunner taskRunner) {
        za.h.e("fileSystem", uVar);
        za.h.e("directory", i0Var);
        za.h.e("taskRunner", taskRunner);
        this.directory = i0Var;
        this.appVersion = i10;
        this.valueCount = i11;
        this.fileSystem = new v(uVar) { // from class: okhttp3.internal.cache.DiskLruCache$fileSystem$1
            @Override // rb.v, rb.u
            public q0 sink(i0 i0Var2, boolean z10) {
                za.h.e("file", i0Var2);
                i0 b2 = i0Var2.b();
                if (b2 != null) {
                    createDirectories(b2);
                }
                return super.sink(i0Var2, z10);
            }
        };
        this.maxSize = j10;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        final String r2 = d.r(new StringBuilder(), _UtilJvmKt.okHttpName, " Cache");
        this.cleanupTask = new Task(r2) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z10;
                m mVar;
                boolean journalRebuildRequired;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    z10 = diskLruCache.initialized;
                    if (!z10 || diskLruCache.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        journalRebuildRequired = diskLruCache.journalRebuildRequired();
                        if (journalRebuildRequired) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        mVar = diskLruCache.journalWriter;
                        if (mVar != null) {
                            _UtilCommonKt.closeQuietly(mVar);
                        }
                        diskLruCache.journalWriter = b.b(new rb.h());
                    }
                    return -1L;
                }
            }
        };
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = i0Var.d(JOURNAL_FILE);
        this.journalFileTmp = i0Var.d(JOURNAL_FILE_TEMP);
        this.journalFileBackup = i0Var.d(JOURNAL_FILE_BACKUP);
    }

    private final synchronized void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i10 = this.redundantOpCount;
        return i10 >= 2000 && i10 >= this.lruEntries.size();
    }

    private final m newJournalWriter() {
        return b.b(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new f(2, this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i newJournalWriter$lambda$0(DiskLruCache diskLruCache, IOException iOException) {
        za.h.e("it", iOException);
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
            diskLruCache.hasJournalErrors = true;
            return i.f8335a;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
    }

    private final void processJournal() {
        _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            za.h.d("next(...)", next);
            Entry entry = next;
            int i10 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i11 = this.valueCount;
                while (i10 < i11) {
                    this.size += entry.getLengths$okhttp()[i10];
                    i10++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i12 = this.valueCount;
                while (i10 < i12) {
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i10));
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getDirtyFiles$okhttp().get(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void readJournal() {
        /*
            r11 = this;
            java.lang.String r0 = ", "
            java.lang.String r1 = "unexpected journal header: ["
            rb.u r2 = r11.fileSystem
            rb.i0 r3 = r11.journalFile
            rb.s0 r2 = r2.source(r3)
            rb.m0 r2 = rb.b.c(r2)
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.String r5 = r2.y(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r2.y(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r2.y(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r8 = r2.y(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r9 = r2.y(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = okhttp3.internal.cache.DiskLruCache.MAGIC     // Catch: java.lang.Throwable -> L62
            boolean r10 = za.h.a(r10, r5)     // Catch: java.lang.Throwable -> L62
            if (r10 == 0) goto L8b
            java.lang.String r10 = okhttp3.internal.cache.DiskLruCache.VERSION_1     // Catch: java.lang.Throwable -> L62
            boolean r10 = za.h.a(r10, r6)     // Catch: java.lang.Throwable -> L62
            if (r10 == 0) goto L8b
            int r10 = r11.appVersion     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L62
            boolean r7 = za.h.a(r10, r7)     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L8b
            int r7 = r11.valueCount     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L62
            boolean r7 = za.h.a(r7, r8)     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L8b
            int r7 = r9.length()     // Catch: java.lang.Throwable -> L62
            if (r7 > 0) goto L8b
            r0 = 0
        L58:
            java.lang.String r1 = r2.y(r3)     // Catch: java.lang.Throwable -> L62 java.io.EOFException -> L64
            r11.readJournalLine(r1)     // Catch: java.lang.Throwable -> L62 java.io.EOFException -> L64
            int r0 = r0 + 1
            goto L58
        L62:
            r0 = move-exception
            goto Lb4
        L64:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r1 = r11.lruEntries     // Catch: java.lang.Throwable -> L62
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L62
            int r0 = r0 - r1
            r11.redundantOpCount = r0     // Catch: java.lang.Throwable -> L62
            boolean r0 = r2.t()     // Catch: java.lang.Throwable -> L62
            if (r0 != 0) goto L77
            r11.rebuildJournal$okhttp()     // Catch: java.lang.Throwable -> L62
            goto L84
        L77:
            rb.m r0 = r11.journalWriter     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L7e
            okhttp3.internal._UtilCommonKt.closeQuietly(r0)     // Catch: java.lang.Throwable -> L62
        L7e:
            rb.m r0 = r11.newJournalWriter()     // Catch: java.lang.Throwable -> L62
            r11.journalWriter = r0     // Catch: java.lang.Throwable -> L62
        L84:
            r2.close()     // Catch: java.lang.Throwable -> L89
            r0 = 0
            goto Lbc
        L89:
            r0 = move-exception
            goto Lbc
        L8b:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L62
            r4.append(r5)     // Catch: java.lang.Throwable -> L62
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            r4.append(r6)     // Catch: java.lang.Throwable -> L62
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            r4.append(r8)     // Catch: java.lang.Throwable -> L62
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            r4.append(r9)     // Catch: java.lang.Throwable -> L62
            r0 = 93
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L62
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L62
            throw r3     // Catch: java.lang.Throwable -> L62
        Lb4:
            r2.close()     // Catch: java.lang.Throwable -> Lb8
            goto Lbc
        Lb8:
            r1 = move-exception
            com.bumptech.glide.f.a(r0, r1)
        Lbc:
            if (r0 != 0) goto Lbf
            return
        Lbf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final void readJournalLine(String str) {
        String substring;
        int e02 = gb.i.e0(str, ' ', 0, 6);
        if (e02 == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i10 = e02 + 1;
        int e03 = gb.i.e0(str, ' ', i10, 4);
        if (e03 == -1) {
            substring = str.substring(i10);
            za.h.d("substring(...)", substring);
            String str2 = REMOVE;
            if (e02 == str2.length() && p.Y(str, str2, false)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, e03);
            za.h.d("substring(...)", substring);
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(this, substring);
            this.lruEntries.put(substring, entry);
        }
        if (e03 != -1) {
            String str3 = CLEAN;
            if (e02 == str3.length() && p.Y(str, str3, false)) {
                String substring2 = str.substring(e03 + 1);
                za.h.d("substring(...)", substring2);
                List<String> l02 = gb.i.l0(substring2, new char[]{' '});
                entry.setReadable$okhttp(true);
                entry.setCurrentEditor$okhttp(null);
                entry.setLengths$okhttp(l02);
                return;
            }
        }
        if (e03 == -1) {
            String str4 = DIRTY;
            if (e02 == str4.length() && p.Y(str, str4, false)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
                return;
            }
        }
        if (e03 == -1) {
            String str5 = READ;
            if (e02 == str5.length() && p.Y(str, str5, false)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            za.h.d("next(...)", entry);
            Entry entry2 = entry;
            if (!entry2.getZombie$okhttp()) {
                removeEntry$okhttp(entry2);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        h hVar = LEGAL_KEY_PATTERN;
        hVar.getClass();
        za.h.e("input", str);
        if (hVar.f5467o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Editor currentEditor$okhttp;
        try {
            if (this.initialized && !this.closed) {
                Collection<Entry> values = this.lruEntries.values();
                za.h.d("<get-values>(...)", values);
                for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
                    za.h.b(entry);
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                m mVar = this.journalWriter;
                if (mVar != null) {
                    _UtilCommonKt.closeQuietly(mVar);
                }
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z10) {
        za.h.e("editor", editor);
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!za.h.a(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        if (z10 && !entry$okhttp.getReadable$okhttp()) {
            int i10 = this.valueCount;
            for (int i11 = 0; i11 < i10; i11++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                za.h.b(written$okhttp);
                if (!written$okhttp[i11]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                }
                if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i11))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i12 = this.valueCount;
        for (int i13 = 0; i13 < i12; i13++) {
            i0 i0Var = entry$okhttp.getDirtyFiles$okhttp().get(i13);
            if (!z10 || entry$okhttp.getZombie$okhttp()) {
                _UtilCommonKt.deleteIfExists(this.fileSystem, i0Var);
            } else if (this.fileSystem.exists(i0Var)) {
                i0 i0Var2 = entry$okhttp.getCleanFiles$okhttp().get(i13);
                this.fileSystem.atomicMove(i0Var, i0Var2);
                long j10 = entry$okhttp.getLengths$okhttp()[i13];
                Long l10 = this.fileSystem.metadata(i0Var2).f11069d;
                long longValue = l10 != null ? l10.longValue() : 0L;
                entry$okhttp.getLengths$okhttp()[i13] = longValue;
                this.size = (this.size - j10) + longValue;
            }
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        m mVar = this.journalWriter;
        za.h.b(mVar);
        if (!entry$okhttp.getReadable$okhttp() && !z10) {
            this.lruEntries.remove(entry$okhttp.getKey$okhttp());
            mVar.E(REMOVE).writeByte(32);
            mVar.E(entry$okhttp.getKey$okhttp());
            mVar.writeByte(10);
            mVar.flush();
            if (this.size <= this.maxSize || journalRebuildRequired()) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            }
        }
        entry$okhttp.setReadable$okhttp(true);
        mVar.E(CLEAN).writeByte(32);
        mVar.E(entry$okhttp.getKey$okhttp());
        entry$okhttp.writeLengths$okhttp(mVar);
        mVar.writeByte(10);
        if (z10) {
            long j11 = this.nextSequenceNumber;
            this.nextSequenceNumber = 1 + j11;
            entry$okhttp.setSequenceNumber$okhttp(j11);
        }
        mVar.flush();
        if (this.size <= this.maxSize) {
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    public final void delete() {
        close();
        _UtilCommonKt.deleteContents(this.fileSystem, this.directory);
    }

    public final Editor edit(String str) {
        za.h.e("key", str);
        return edit$default(this, str, 0L, 2, null);
    }

    public final synchronized void evictAll() {
        try {
            initialize();
            Collection<Entry> values = this.lruEntries.values();
            za.h.d("<get-values>(...)", values);
            for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
                za.h.b(entry);
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            m mVar = this.journalWriter;
            za.h.b(mVar);
            mVar.flush();
        }
    }

    public final synchronized Snapshot get(String str) {
        za.h.e("key", str);
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        m mVar = this.journalWriter;
        za.h.b(mVar);
        mVar.E(READ).writeByte(32).E(str).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final i0 getDirectory() {
        return this.directory;
    }

    public final u getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() {
        try {
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
            }
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = _UtilCommonKt.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e7) {
                    Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e7.getMessage() + ", removing", 5, e7);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() {
        Throwable th;
        try {
            m mVar = this.journalWriter;
            if (mVar != null) {
                mVar.close();
            }
            l0 b2 = b.b(this.fileSystem.sink(this.journalFileTmp, false));
            try {
                b2.E(MAGIC);
                b2.writeByte(10);
                b2.E(VERSION_1);
                b2.writeByte(10);
                b2.F(this.appVersion);
                b2.writeByte(10);
                b2.F(this.valueCount);
                b2.writeByte(10);
                b2.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    za.h.d("next(...)", entry);
                    Entry entry2 = entry;
                    if (entry2.getCurrentEditor$okhttp() != null) {
                        b2.E(DIRTY);
                        b2.writeByte(32);
                        b2.E(entry2.getKey$okhttp());
                        b2.writeByte(10);
                    } else {
                        b2.E(CLEAN);
                        b2.writeByte(32);
                        b2.E(entry2.getKey$okhttp());
                        entry2.writeLengths$okhttp(b2);
                        b2.writeByte(10);
                    }
                }
                try {
                    b2.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    b2.close();
                } catch (Throwable th4) {
                    com.bumptech.glide.f.a(th3, th4);
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            m mVar2 = this.journalWriter;
            if (mVar2 != null) {
                _UtilCommonKt.closeQuietly(mVar2);
            }
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final synchronized boolean remove(String str) {
        za.h.e("key", str);
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(Entry entry) {
        m mVar;
        za.h.e("entry", entry);
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (mVar = this.journalWriter) != null) {
                mVar.E(DIRTY);
                mVar.writeByte(32);
                mVar.E(entry.getKey$okhttp());
                mVar.writeByte(10);
                mVar.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i10 = this.valueCount;
        for (int i11 = 0; i11 < i10; i11++) {
            _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i11));
            this.size -= entry.getLengths$okhttp()[i11];
            entry.getLengths$okhttp()[i11] = 0;
        }
        this.redundantOpCount++;
        m mVar2 = this.journalWriter;
        if (mVar2 != null) {
            mVar2.E(REMOVE);
            mVar2.writeByte(32);
            mVar2.E(entry.getKey$okhttp());
            mVar2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z10) {
        this.closed = z10;
    }

    public final synchronized void setMaxSize(long j10) {
        this.maxSize = j10;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    public final synchronized Editor edit(String str, long j10) {
        za.h.e("key", str);
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j10 != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j10)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            m mVar = this.journalWriter;
            za.h.b(mVar);
            mVar.E(DIRTY).writeByte(32).E(str).writeByte(10);
            mVar.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, str);
                this.lruEntries.put(str, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }
}
