package rb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class v extends u {
    private final u delegate;

    public v(u uVar) {
        za.h.e("delegate", uVar);
        this.delegate = uVar;
    }

    @Override // rb.u
    public q0 appendingSink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        return this.delegate.appendingSink(onPathParameter(i0Var, "appendingSink", "file"), z10);
    }

    @Override // rb.u
    public void atomicMove(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        this.delegate.atomicMove(onPathParameter(i0Var, "atomicMove", "source"), onPathParameter(i0Var2, "atomicMove", "target"));
    }

    @Override // rb.u
    public i0 canonicalize(i0 i0Var) {
        za.h.e("path", i0Var);
        return onPathResult(this.delegate.canonicalize(onPathParameter(i0Var, "canonicalize", "path")), "canonicalize");
    }

    @Override // rb.u, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // rb.u
    public void createDirectory(i0 i0Var, boolean z10) {
        za.h.e("dir", i0Var);
        this.delegate.createDirectory(onPathParameter(i0Var, "createDirectory", "dir"), z10);
    }

    @Override // rb.u
    public void createSymlink(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        this.delegate.createSymlink(onPathParameter(i0Var, "createSymlink", "source"), onPathParameter(i0Var2, "createSymlink", "target"));
    }

    public final u delegate() {
        return this.delegate;
    }

    @Override // rb.u
    public void delete(i0 i0Var, boolean z10) {
        za.h.e("path", i0Var);
        this.delegate.delete(onPathParameter(i0Var, "delete", "path"), z10);
    }

    @Override // rb.u
    public List<i0> list(i0 i0Var) {
        za.h.e("dir", i0Var);
        List list = this.delegate.list(onPathParameter(i0Var, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((i0) it.next(), "list"));
        }
        ma.n.A(arrayList);
        return arrayList;
    }

    @Override // rb.u
    public List<i0> listOrNull(i0 i0Var) {
        za.h.e("dir", i0Var);
        List listOrNull = this.delegate.listOrNull(onPathParameter(i0Var, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((i0) it.next(), "listOrNull"));
        }
        ma.n.A(arrayList);
        return arrayList;
    }

    @Override // rb.u
    public fb.f listRecursively(i0 i0Var, boolean z10) {
        za.h.e("dir", i0Var);
        fb.f listRecursively = this.delegate.listRecursively(onPathParameter(i0Var, "listRecursively", "dir"), z10);
        gb.f fVar = new gb.f(3, this);
        za.h.e("<this>", listRecursively);
        return new fb.e(listRecursively, fVar);
    }

    @Override // rb.u
    public s metadataOrNull(i0 i0Var) {
        za.h.e("path", i0Var);
        s metadataOrNull = this.delegate.metadataOrNull(onPathParameter(i0Var, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        i0 i0Var2 = metadataOrNull.f11068c;
        if (i0Var2 == null) {
            return metadataOrNull;
        }
        i0 onPathResult = onPathResult(i0Var2, "metadataOrNull");
        boolean z10 = metadataOrNull.f11066a;
        boolean z11 = metadataOrNull.f11067b;
        Long l10 = metadataOrNull.f11069d;
        Long l11 = metadataOrNull.f11070e;
        Long l12 = metadataOrNull.f11071f;
        Long l13 = metadataOrNull.g;
        Map map = metadataOrNull.f11072h;
        za.h.e("extras", map);
        return new s(z10, z11, onPathResult, l10, l11, l12, l13, map);
    }

    public i0 onPathParameter(i0 i0Var, String str, String str2) {
        za.h.e("path", i0Var);
        za.h.e("functionName", str);
        za.h.e("parameterName", str2);
        return i0Var;
    }

    public i0 onPathResult(i0 i0Var, String str) {
        za.h.e("path", i0Var);
        za.h.e("functionName", str);
        return i0Var;
    }

    @Override // rb.u
    public r openReadOnly(i0 i0Var) {
        za.h.e("file", i0Var);
        return this.delegate.openReadOnly(onPathParameter(i0Var, "openReadOnly", "file"));
    }

    @Override // rb.u
    public r openReadWrite(i0 i0Var, boolean z10, boolean z11) {
        za.h.e("file", i0Var);
        return this.delegate.openReadWrite(onPathParameter(i0Var, "openReadWrite", "file"), z10, z11);
    }

    @Override // rb.u
    public q0 sink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        return this.delegate.sink(onPathParameter(i0Var, "sink", "file"), z10);
    }

    @Override // rb.u
    public s0 source(i0 i0Var) {
        za.h.e("file", i0Var);
        return this.delegate.source(onPathParameter(i0Var, "source", "file"));
    }

    public String toString() {
        return za.n.a(getClass()).b() + '(' + this.delegate + ')';
    }
}
