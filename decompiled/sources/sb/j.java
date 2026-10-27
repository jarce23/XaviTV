package sb;

import j9.v1;
import j9.w1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import rb.i0;
import rb.q0;
import rb.r;
import rb.s;
import rb.s0;
import rb.u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends u {

    /* renamed from: r, reason: collision with root package name */
    public static final i0 f11705r;

    /* renamed from: o, reason: collision with root package name */
    public final ClassLoader f11706o;

    /* renamed from: p, reason: collision with root package name */
    public final u f11707p;

    /* renamed from: q, reason: collision with root package name */
    public final la.g f11708q;

    static {
        String str = i0.f11020p;
        f11705r = v1.u("/");
    }

    public j(ClassLoader classLoader) {
        u uVar = u.SYSTEM;
        za.h.e("systemFileSystem", uVar);
        this.f11706o = classLoader;
        this.f11707p = uVar;
        this.f11708q = new la.g(new androidx.activity.e(8, this));
    }

    public static String a(i0 i0Var) {
        i0 i0Var2 = f11705r;
        return i0Var2.e(i0Var, true).c(i0Var2).f11021o.r();
    }

    @Override // rb.u
    public final q0 appendingSink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        throw new IOException(this + " is read-only");
    }

    @Override // rb.u
    public final void atomicMove(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        throw new IOException(this + " is read-only");
    }

    @Override // rb.u
    public final i0 canonicalize(i0 i0Var) {
        za.h.e("path", i0Var);
        return f11705r.e(i0Var, true);
    }

    @Override // rb.u
    public final void createDirectory(i0 i0Var, boolean z10) {
        za.h.e("dir", i0Var);
        throw new IOException(this + " is read-only");
    }

    @Override // rb.u
    public final void createSymlink(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        throw new IOException(this + " is read-only");
    }

    @Override // rb.u
    public final void delete(i0 i0Var, boolean z10) {
        za.h.e("path", i0Var);
        throw new IOException(this + " is read-only");
    }

    @Override // rb.u
    public final List list(i0 i0Var) {
        za.h.e("dir", i0Var);
        String a10 = a(i0Var);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z10 = false;
        for (la.d dVar : (List) this.f11708q.a()) {
            u uVar = (u) dVar.f8328o;
            i0 i0Var2 = (i0) dVar.f8329p;
            try {
                List list = uVar.list(i0Var2.d(a10));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (w1.B((i0) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(ma.l.z(arrayList));
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    arrayList2.add(w1.K((i0) obj2, i0Var2));
                }
                ma.j.B(linkedHashSet, arrayList2);
                z10 = true;
            } catch (IOException unused) {
            }
        }
        if (z10) {
            return ma.j.J(linkedHashSet);
        }
        throw new FileNotFoundException(r.a.e(i0Var, "file not found: "));
    }

    @Override // rb.u
    public final List listOrNull(i0 i0Var) {
        za.h.e("dir", i0Var);
        String a10 = a(i0Var);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = ((List) this.f11708q.a()).iterator();
        boolean z10 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            la.d dVar = (la.d) it.next();
            u uVar = (u) dVar.f8328o;
            i0 i0Var2 = (i0) dVar.f8329p;
            List listOrNull = uVar.listOrNull(i0Var2.d(a10));
            if (listOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listOrNull) {
                    if (w1.B((i0) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(ma.l.z(arrayList2));
                int size = arrayList2.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList2.get(i10);
                    i10++;
                    arrayList3.add(w1.K((i0) obj2, i0Var2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                ma.j.B(linkedHashSet, arrayList);
                z10 = true;
            }
        }
        if (z10) {
            return ma.j.J(linkedHashSet);
        }
        return null;
    }

    @Override // rb.u
    public final s metadataOrNull(i0 i0Var) {
        za.h.e("path", i0Var);
        if (!w1.B(i0Var)) {
            return null;
        }
        String a10 = a(i0Var);
        for (la.d dVar : (List) this.f11708q.a()) {
            s metadataOrNull = ((u) dVar.f8328o).metadataOrNull(((i0) dVar.f8329p).d(a10));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    @Override // rb.u
    public final r openReadOnly(i0 i0Var) {
        za.h.e("file", i0Var);
        if (!w1.B(i0Var)) {
            throw new FileNotFoundException(r.a.e(i0Var, "file not found: "));
        }
        String a10 = a(i0Var);
        for (la.d dVar : (List) this.f11708q.a()) {
            try {
                return ((u) dVar.f8328o).openReadOnly(((i0) dVar.f8329p).d(a10));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(r.a.e(i0Var, "file not found: "));
    }

    @Override // rb.u
    public final r openReadWrite(i0 i0Var, boolean z10, boolean z11) {
        za.h.e("file", i0Var);
        throw new IOException("resources are not writable");
    }

    @Override // rb.u
    public final q0 sink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        throw new IOException(this + " is read-only");
    }

    @Override // rb.u
    public final s0 source(i0 i0Var) {
        za.h.e("file", i0Var);
        if (!w1.B(i0Var)) {
            throw new FileNotFoundException(r.a.e(i0Var, "file not found: "));
        }
        i0 i0Var2 = f11705r;
        i0Var2.getClass();
        URL resource = this.f11706o.getResource(f.b(i0Var2, i0Var, false).c(i0Var2).f11021o.r());
        if (resource == null) {
            throw new FileNotFoundException(r.a.e(i0Var, "file not found: "));
        }
        URLConnection openConnection = resource.openConnection();
        if (openConnection instanceof JarURLConnection) {
            ((JarURLConnection) openConnection).setUseCaches(false);
        }
        InputStream inputStream = openConnection.getInputStream();
        za.h.d("getInputStream(...)", inputStream);
        return rb.b.h(inputStream);
    }
}
