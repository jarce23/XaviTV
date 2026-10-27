package rb;

import j9.v1;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class u implements Closeable {
    public static final t Companion = new t();
    public static final u RESOURCES;
    public static final u SYSTEM;
    public static final i0 SYSTEM_TEMPORARY_DIRECTORY;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, ya.l] */
    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m155write$default(u uVar, i0 i0Var, boolean z10, ya.l lVar, int i10, Object obj) {
        ?? r32;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        za.h.e("file", i0Var);
        za.h.e("writerAction", lVar);
        l0 b2 = b.b(uVar.sink(i0Var, z10));
        Object th = null;
        try {
            Object invoke = lVar.invoke(b2);
            try {
                b2.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r32 = th;
            th = invoke;
        } catch (Throwable th3) {
            try {
                b2.close();
                r32 = th3;
            } catch (Throwable th4) {
                com.bumptech.glide.f.a(th3, th4);
                r32 = th3;
            }
        }
        if (r32 == 0) {
            return th;
        }
        throw r32;
    }

    static {
        u e0Var;
        try {
            Class.forName("java.nio.file.Files");
            e0Var = new g0();
        } catch (ClassNotFoundException unused) {
            e0Var = new e0();
        }
        SYSTEM = e0Var;
        String str = i0.f11020p;
        String property = System.getProperty("java.io.tmpdir");
        za.h.d("getProperty(...)", property);
        SYSTEM_TEMPORARY_DIRECTORY = v1.u(property);
        ClassLoader classLoader = sb.j.class.getClassLoader();
        za.h.d("getClassLoader(...)", classLoader);
        RESOURCES = new sb.j(classLoader);
    }

    public static /* synthetic */ q0 appendingSink$default(u uVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return uVar.appendingSink(i0Var, z10);
    }

    public static /* synthetic */ void createDirectories$default(u uVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        uVar.createDirectories(i0Var, z10);
    }

    public static /* synthetic */ void createDirectory$default(u uVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        uVar.createDirectory(i0Var, z10);
    }

    public static /* synthetic */ void delete$default(u uVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        uVar.delete(i0Var, z10);
    }

    public static /* synthetic */ void deleteRecursively$default(u uVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        uVar.deleteRecursively(i0Var, z10);
    }

    public static final u get(FileSystem fileSystem) {
        Companion.getClass();
        za.h.e("<this>", fileSystem);
        return new f0(fileSystem);
    }

    public static /* synthetic */ fb.f listRecursively$default(u uVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return uVar.listRecursively(i0Var, z10);
    }

    public static /* synthetic */ r openReadWrite$default(u uVar, i0 i0Var, boolean z10, boolean z11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return uVar.openReadWrite(i0Var, z10, z11);
    }

    public static /* synthetic */ q0 sink$default(u uVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return uVar.sink(i0Var, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, ya.l] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* renamed from: -read, reason: not valid java name */
    public final <T> T m156read(i0 i0Var, ya.l lVar) {
        ?? r42;
        za.h.e("file", i0Var);
        za.h.e("readerAction", lVar);
        m0 c10 = b.c(source(i0Var));
        T th = null;
        try {
            ?? invoke = lVar.invoke(c10);
            try {
                c10.close();
            } catch (Throwable th2) {
                th = th2;
            }
            T t3 = th;
            th = invoke;
            r42 = t3;
        } catch (Throwable th3) {
            try {
                c10.close();
                r42 = th3;
            } catch (Throwable th4) {
                com.bumptech.glide.f.a(th3, th4);
                r42 = th3;
            }
        }
        if (r42 == 0) {
            return th;
        }
        throw r42;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, ya.l] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* renamed from: -write, reason: not valid java name */
    public final <T> T m157write(i0 i0Var, boolean z10, ya.l lVar) {
        ?? r52;
        za.h.e("file", i0Var);
        za.h.e("writerAction", lVar);
        l0 b2 = b.b(sink(i0Var, z10));
        T th = null;
        try {
            ?? invoke = lVar.invoke(b2);
            try {
                b2.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r52 = th;
            th = invoke;
        } catch (Throwable th3) {
            try {
                b2.close();
                r52 = th3;
            } catch (Throwable th4) {
                com.bumptech.glide.f.a(th3, th4);
                r52 = th3;
            }
        }
        if (r52 == 0) {
            return th;
        }
        throw r52;
    }

    public final q0 appendingSink(i0 i0Var) {
        za.h.e("file", i0Var);
        return appendingSink(i0Var, false);
    }

    public abstract q0 appendingSink(i0 i0Var, boolean z10);

    public abstract void atomicMove(i0 i0Var, i0 i0Var2);

    public abstract i0 canonicalize(i0 i0Var);

    public void copy(i0 i0Var, i0 i0Var2) {
        Throwable th;
        Long l10;
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        s0 source = source(i0Var);
        Throwable th2 = null;
        try {
            l0 b2 = b.b(sink$default(this, i0Var2, false, 2, null));
            try {
                l10 = Long.valueOf(b2.d(source));
                try {
                    b2.close();
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                try {
                    b2.close();
                } catch (Throwable th5) {
                    com.bumptech.glide.f.a(th4, th5);
                }
                th = th4;
                l10 = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th7) {
                    com.bumptech.glide.f.a(th2, th7);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        l10.getClass();
        if (source != null) {
            try {
                source.close();
            } catch (Throwable th8) {
                th2 = th8;
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }

    public final void createDirectories(i0 i0Var, boolean z10) {
        za.h.e("dir", i0Var);
        ma.h hVar = new ma.h();
        for (i0 i0Var2 = i0Var; i0Var2 != null && !exists(i0Var2); i0Var2 = i0Var2.b()) {
            hVar.addFirst(i0Var2);
        }
        if (z10 && hVar.isEmpty()) {
            throw new IOException(i0Var + " already exists.");
        }
        Iterator<E> it = hVar.iterator();
        while (it.hasNext()) {
            createDirectory$default(this, (i0) it.next(), false, 2, null);
        }
    }

    public final void createDirectory(i0 i0Var) {
        za.h.e("dir", i0Var);
        createDirectory(i0Var, false);
    }

    public abstract void createDirectory(i0 i0Var, boolean z10);

    public abstract void createSymlink(i0 i0Var, i0 i0Var2);

    public final void delete(i0 i0Var) {
        za.h.e("path", i0Var);
        delete(i0Var, false);
    }

    public abstract void delete(i0 i0Var, boolean z10);

    public void deleteRecursively(i0 i0Var, boolean z10) {
        za.h.e("fileOrDirectory", i0Var);
        sb.d dVar = new sb.d(this, i0Var, null);
        fb.g gVar = new fb.g();
        gVar.f5068r = dVar.create(gVar, gVar);
        while (gVar.hasNext()) {
            delete((i0) gVar.next(), z10 && !gVar.hasNext());
        }
    }

    public final boolean exists(i0 i0Var) {
        za.h.e("path", i0Var);
        return metadataOrNull(i0Var) != null;
    }

    public abstract List list(i0 i0Var);

    public abstract List listOrNull(i0 i0Var);

    public final fb.f listRecursively(i0 i0Var) {
        za.h.e("dir", i0Var);
        return listRecursively(i0Var, false);
    }

    public final s metadata(i0 i0Var) {
        za.h.e("path", i0Var);
        s metadataOrNull = metadataOrNull(i0Var);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
    }

    public abstract s metadataOrNull(i0 i0Var);

    public abstract r openReadOnly(i0 i0Var);

    public final r openReadWrite(i0 i0Var) {
        za.h.e("file", i0Var);
        return openReadWrite(i0Var, false, false);
    }

    public abstract r openReadWrite(i0 i0Var, boolean z10, boolean z11);

    public final q0 sink(i0 i0Var) {
        za.h.e("file", i0Var);
        return sink(i0Var, false);
    }

    public abstract q0 sink(i0 i0Var, boolean z10);

    public abstract s0 source(i0 i0Var);

    public fb.f listRecursively(i0 i0Var, boolean z10) {
        za.h.e("dir", i0Var);
        return new fb.i(new sb.e(i0Var, this, z10, null));
    }

    public final void createDirectories(i0 i0Var) {
        za.h.e("dir", i0Var);
        createDirectories(i0Var, false);
    }

    public final void deleteRecursively(i0 i0Var) {
        za.h.e("fileOrDirectory", i0Var);
        deleteRecursively(i0Var, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
