package rb;

import j9.v1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class e0 extends u {
    public static ArrayList a(i0 i0Var, boolean z10) {
        File file = i0Var.toFile();
        String[] list = file.list();
        if (list == null) {
            if (!z10) {
                return null;
            }
            if (file.exists()) {
                throw new IOException(r.a.e(i0Var, "failed to list "));
            }
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            za.h.b(str);
            arrayList.add(i0Var.d(str));
        }
        ma.n.A(arrayList);
        return arrayList;
    }

    @Override // rb.u
    public q0 appendingSink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        if (!z10 || exists(i0Var)) {
            return new e(new FileOutputStream(i0Var.toFile(), true), 1, new v0());
        }
        throw new IOException(i0Var + " doesn't exist.");
    }

    @Override // rb.u
    public void atomicMove(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        if (i0Var.toFile().renameTo(i0Var2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + i0Var + " to " + i0Var2);
    }

    @Override // rb.u
    public i0 canonicalize(i0 i0Var) {
        za.h.e("path", i0Var);
        File canonicalFile = i0Var.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        String str = i0.f11020p;
        return v1.v(canonicalFile);
    }

    @Override // rb.u
    public void createDirectory(i0 i0Var, boolean z10) {
        za.h.e("dir", i0Var);
        if (i0Var.toFile().mkdir()) {
            return;
        }
        s metadataOrNull = metadataOrNull(i0Var);
        if (metadataOrNull == null || !metadataOrNull.f11067b) {
            throw new IOException(r.a.e(i0Var, "failed to create directory: "));
        }
        if (z10) {
            throw new IOException(i0Var + " already exists.");
        }
    }

    @Override // rb.u
    public void createSymlink(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        throw new IOException("unsupported");
    }

    @Override // rb.u
    public void delete(i0 i0Var, boolean z10) {
        za.h.e("path", i0Var);
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = i0Var.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException(r.a.e(i0Var, "failed to delete "));
        }
        if (z10) {
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
    }

    @Override // rb.u
    public List list(i0 i0Var) {
        za.h.e("dir", i0Var);
        ArrayList a10 = a(i0Var, true);
        za.h.b(a10);
        return a10;
    }

    @Override // rb.u
    public List listOrNull(i0 i0Var) {
        za.h.e("dir", i0Var);
        return a(i0Var, false);
    }

    @Override // rb.u
    public s metadataOrNull(i0 i0Var) {
        za.h.e("path", i0Var);
        File file = i0Var.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (isFile || isDirectory || lastModified != 0 || length != 0 || file.exists()) {
            return new s(isFile, isDirectory, null, Long.valueOf(length), null, Long.valueOf(lastModified), null);
        }
        return null;
    }

    @Override // rb.u
    public r openReadOnly(i0 i0Var) {
        za.h.e("file", i0Var);
        return new d0(new RandomAccessFile(i0Var.toFile(), "r"), 0);
    }

    @Override // rb.u
    public r openReadWrite(i0 i0Var, boolean z10, boolean z11) {
        za.h.e("file", i0Var);
        if (z10 && z11) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z10 && exists(i0Var)) {
            throw new IOException(i0Var + " already exists.");
        }
        if (!z11 || exists(i0Var)) {
            return new d0(new RandomAccessFile(i0Var.toFile(), "rw"), 0);
        }
        throw new IOException(i0Var + " doesn't exist.");
    }

    @Override // rb.u
    public q0 sink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        if (!z10 || !exists(i0Var)) {
            return new e(new FileOutputStream(i0Var.toFile(), false), 1, new v0());
        }
        throw new IOException(i0Var + " already exists.");
    }

    @Override // rb.u
    public s0 source(i0 i0Var) {
        za.h.e("file", i0Var);
        return new f(new FileInputStream(i0Var.toFile()), v0.NONE);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
