package okhttp3.internal.cache2;

import j9.w1;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.concurrent.Lockable;
import rb.l;
import rb.o;
import rb.s0;
import rb.v0;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Relay implements Lockable {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final o PREFIX_CLEAN;
    public static final o PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final l buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final o metadata;
    private int sourceCount;
    private s0 upstream;
    private final l upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Relay edit(File file, s0 s0Var, o oVar, long j10) {
            h.e("file", file);
            h.e("upstream", s0Var);
            h.e("metadata", oVar);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, s0Var, 0L, oVar, j10, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) {
            h.e("file", file);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            h.d("getChannel(...)", channel);
            FileOperator fileOperator = new FileOperator(channel);
            l lVar = new l();
            fileOperator.read(0L, lVar, Relay.FILE_HEADER_SIZE);
            if (!h.a(lVar.i(r11.d()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long readLong = lVar.readLong();
            long readLong2 = lVar.readLong();
            l lVar2 = new l();
            fileOperator.read(Relay.FILE_HEADER_SIZE + readLong, lVar2, readLong2);
            return new Relay(randomAccessFile, null, readLong, lVar2.i(lVar2.f11035p), 0L, null);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class RelaySource implements s0 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final v0 timeout = new v0();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            h.b(file);
            FileChannel channel = file.getChannel();
            h.d("getChannel(...)", channel);
            this.fileOperator = new FileOperator(channel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            Relay relay = Relay.this;
            synchronized (relay) {
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (relay.getSourceCount() == 0) {
                    RandomAccessFile file = relay.getFile();
                    relay.setFile(null);
                    randomAccessFile = file;
                }
            }
            if (randomAccessFile != null) {
                _UtilCommonKt.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        
            if (r0 != 2) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        
            r6 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
            za.h.b(r2);
            r2.read(r19.sourcePos + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r20, r6);
            r19.sourcePos += r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0073, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        
            r0 = r19.this$0.getUpstream();
            za.h.b(r0);
            r11 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
        
            if (r11 != (-1)) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
        
            r0 = r19.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x009b, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
        
            r6 = java.lang.Math.min(r11, r21);
            r19.this$0.getUpstreamBuffer().s(0, r20, r6);
            r19.sourcePos += r6;
            r13 = r19.fileOperator;
            za.h.b(r13);
            r13.write(r19.this$0.getUpstreamPos() + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r19.this$0.getUpstreamBuffer().clone(), r11);
            r4 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e2, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00e3, code lost:
        
            r4.getBuffer().write(r4.getUpstreamBuffer(), r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00fa, code lost:
        
            if (r4.getBuffer().f11035p <= r4.getBufferMaxSize()) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00fc, code lost:
        
            r4.getBuffer().skip(r4.getBuffer().f11035p - r4.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0111, code lost:
        
            r4.setUpstreamPos(r4.getUpstreamPos() + r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0119, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x011a, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x011c, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x011d, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0123, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0124, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x010f, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0129, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x012a, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x012c, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x012d, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0134, code lost:
        
            throw r0;
         */
        @Override // rb.s0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long read(rb.l r20, long r21) {
            /*
                Method dump skipped, instructions count: 352
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(rb.l, long):long");
        }

        @Override // rb.s0
        public v0 timeout() {
            return this.timeout;
        }
    }

    static {
        o oVar = o.f11048r;
        PREFIX_CLEAN = w1.F("OkHttp cache v1\n");
        PREFIX_DIRTY = w1.F("OkHttp DIRTY :(\n");
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, s0 s0Var, long j10, o oVar, long j11, e eVar) {
        this(randomAccessFile, s0Var, j10, oVar, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(o oVar, long j10, long j11) {
        l lVar = new l();
        lVar.W(oVar);
        lVar.b0(j10);
        lVar.b0(j11);
        if (lVar.f11035p != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        RandomAccessFile randomAccessFile = this.file;
        h.b(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        h.d("getChannel(...)", channel);
        new FileOperator(channel).write(0L, lVar, FILE_HEADER_SIZE);
    }

    private final void writeMetadata(long j10) {
        l lVar = new l();
        lVar.W(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        h.b(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        h.d("getChannel(...)", channel);
        new FileOperator(channel).write(FILE_HEADER_SIZE + j10, lVar, this.metadata.d());
    }

    public final void commit(long j10) {
        writeMetadata(j10);
        RandomAccessFile randomAccessFile = this.file;
        h.b(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j10, this.metadata.d());
        RandomAccessFile randomAccessFile2 = this.file;
        h.b(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        s0 s0Var = this.upstream;
        if (s0Var != null) {
            _UtilCommonKt.closeQuietly(s0Var);
        }
        this.upstream = null;
    }

    public final l getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final s0 getUpstream() {
        return this.upstream;
    }

    public final l getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final o metadata() {
        return this.metadata;
    }

    public final s0 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z10) {
        this.complete = z10;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i10) {
        this.sourceCount = i10;
    }

    public final void setUpstream(s0 s0Var) {
        this.upstream = s0Var;
    }

    public final void setUpstreamPos(long j10) {
        this.upstreamPos = j10;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    private Relay(RandomAccessFile randomAccessFile, s0 s0Var, long j10, o oVar, long j11) {
        this.file = randomAccessFile;
        this.upstream = s0Var;
        this.upstreamPos = j10;
        this.metadata = oVar;
        this.bufferMaxSize = j11;
        this.upstreamBuffer = new l();
        this.complete = s0Var == null;
        this.buffer = new l();
    }
}
