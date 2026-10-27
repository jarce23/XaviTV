package rb;

import j9.v1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 extends g0 {

    /* renamed from: o, reason: collision with root package name */
    public final FileSystem f11010o;

    public f0(FileSystem fileSystem) {
        this.f11010o = fileSystem;
    }

    @Override // rb.e0, rb.u
    public final q0 appendingSink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        na.c g = com.bumptech.glide.f.g();
        g.add(StandardOpenOption.APPEND);
        if (!z10) {
            g.add(StandardOpenOption.CREATE);
        }
        na.c b2 = com.bumptech.glide.f.b(g);
        Path x6 = x(i0Var);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) b2.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream newOutputStream = Files.newOutputStream(x6, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        za.h.d("newOutputStream(...)", newOutputStream);
        return new e(newOutputStream, 1, new v0());
    }

    @Override // rb.g0, rb.e0, rb.u
    public final void atomicMove(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        try {
            za.h.d("move(...)", Files.move(x(i0Var), x(i0Var2), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)));
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e7) {
            throw new FileNotFoundException(e7.getMessage());
        }
    }

    @Override // rb.e0, rb.u
    public final i0 canonicalize(i0 i0Var) {
        za.h.e("path", i0Var);
        try {
            String str = i0.f11020p;
            Path realPath = x(i0Var).toRealPath(new LinkOption[0]);
            za.h.d("toRealPath(...)", realPath);
            return v1.w(realPath);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
    }

    @Override // rb.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11010o.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r0.f11067b == true) goto L8;
     */
    @Override // rb.e0, rb.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void createDirectory(rb.i0 r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "dir"
            za.h.e(r0, r4)
            rb.s r0 = r3.metadataOrNull(r4)
            r1 = 0
            if (r0 == 0) goto L12
            boolean r0 = r0.f11067b
            r2 = 1
            if (r0 != r2) goto L12
            goto L13
        L12:
            r2 = r1
        L13:
            if (r2 == 0) goto L2f
            if (r5 != 0) goto L18
            goto L2f
        L18:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " already exists."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L2f:
            java.nio.file.Path r5 = r3.x(r4)     // Catch: java.io.IOException -> L45
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]     // Catch: java.io.IOException -> L45
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch: java.io.IOException -> L45
            java.nio.file.attribute.FileAttribute[] r0 = (java.nio.file.attribute.FileAttribute[]) r0     // Catch: java.io.IOException -> L45
            java.nio.file.Path r5 = java.nio.file.Files.createDirectory(r5, r0)     // Catch: java.io.IOException -> L45
            java.lang.String r0 = "createDirectory(...)"
            za.h.d(r0, r5)     // Catch: java.io.IOException -> L45
            return
        L45:
            r5 = move-exception
            if (r2 == 0) goto L49
            return
        L49:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "failed to create directory: "
            java.lang.String r4 = r.a.e(r4, r1)
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.f0.createDirectory(rb.i0, boolean):void");
    }

    @Override // rb.g0, rb.e0, rb.u
    public final void createSymlink(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        za.h.d("createSymbolicLink(...)", Files.createSymbolicLink(x(i0Var), x(i0Var2), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)));
    }

    @Override // rb.e0, rb.u
    public final void delete(i0 i0Var, boolean z10) {
        za.h.e("path", i0Var);
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        Path x6 = x(i0Var);
        try {
            Files.delete(x6);
        } catch (NoSuchFileException unused) {
            if (z10) {
                throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
            }
        } catch (IOException unused2) {
            if (Files.exists(x6, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(r.a.e(i0Var, "failed to delete "));
            }
        }
    }

    @Override // rb.e0, rb.u
    public final List list(i0 i0Var) {
        za.h.e("dir", i0Var);
        ArrayList s10 = s(i0Var, true);
        za.h.b(s10);
        return s10;
    }

    @Override // rb.e0, rb.u
    public final List listOrNull(i0 i0Var) {
        za.h.e("dir", i0Var);
        return s(i0Var, false);
    }

    @Override // rb.g0, rb.e0, rb.u
    public final s metadataOrNull(i0 i0Var) {
        za.h.e("path", i0Var);
        return g0.c(x(i0Var));
    }

    @Override // rb.e0, rb.u
    public final r openReadOnly(i0 i0Var) {
        za.h.e("file", i0Var);
        try {
            FileChannel open = FileChannel.open(x(i0Var), StandardOpenOption.READ);
            za.h.b(open);
            return new d0(open, 1);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
    }

    @Override // rb.e0, rb.u
    public final r openReadWrite(i0 i0Var, boolean z10, boolean z11) {
        za.h.e("file", i0Var);
        if (z10 && z11) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        na.c g = com.bumptech.glide.f.g();
        g.add(StandardOpenOption.READ);
        g.add(StandardOpenOption.WRITE);
        if (z10) {
            g.add(StandardOpenOption.CREATE_NEW);
        } else if (!z11) {
            g.add(StandardOpenOption.CREATE);
        }
        na.c b2 = com.bumptech.glide.f.b(g);
        try {
            Path x6 = x(i0Var);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) b2.toArray(new StandardOpenOption[0]);
            FileChannel open = FileChannel.open(x6, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            za.h.b(open);
            return new d0(open, 1);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
    }

    public final ArrayList s(i0 i0Var, boolean z10) {
        Path x6 = x(i0Var);
        try {
            DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(x6, "*");
            try {
                za.h.b(newDirectoryStream);
                List<Path> J = ma.j.J(newDirectoryStream);
                com.bumptech.glide.f.d(newDirectoryStream, null);
                ArrayList arrayList = new ArrayList();
                for (Path path : J) {
                    String str = i0.f11020p;
                    arrayList.add(v1.w(path));
                }
                ma.n.A(arrayList);
                return arrayList;
            } finally {
            }
        } catch (Exception unused) {
            if (!z10) {
                return null;
            }
            if (Files.exists(x6, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(r.a.e(i0Var, "failed to list "));
            }
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
    }

    @Override // rb.e0, rb.u
    public final q0 sink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        na.c g = com.bumptech.glide.f.g();
        if (z10) {
            g.add(StandardOpenOption.CREATE_NEW);
        }
        na.c b2 = com.bumptech.glide.f.b(g);
        try {
            Path x6 = x(i0Var);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) b2.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream newOutputStream = Files.newOutputStream(x6, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            za.h.d("newOutputStream(...)", newOutputStream);
            return new e(newOutputStream, 1, new v0());
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
    }

    @Override // rb.e0, rb.u
    public final s0 source(i0 i0Var) {
        za.h.e("file", i0Var);
        try {
            InputStream newInputStream = Files.newInputStream(x(i0Var), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            za.h.d("newInputStream(...)", newInputStream);
            return b.h(newInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
    }

    @Override // rb.g0, rb.e0
    public final String toString() {
        String b2 = za.n.a(this.f11010o.getClass()).b();
        za.h.b(b2);
        return b2;
    }

    public final Path x(i0 i0Var) {
        Path path;
        path = this.f11010o.getPath(i0Var.f11021o.r(), new String[0]);
        za.h.d("getPath(...)", path);
        return path;
    }
}
