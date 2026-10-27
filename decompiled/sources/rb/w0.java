package rb;

import j9.v1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 extends u {

    /* renamed from: r, reason: collision with root package name */
    public static final i0 f11073r;

    /* renamed from: o, reason: collision with root package name */
    public final i0 f11074o;

    /* renamed from: p, reason: collision with root package name */
    public final u f11075p;

    /* renamed from: q, reason: collision with root package name */
    public final LinkedHashMap f11076q;

    static {
        String str = i0.f11020p;
        f11073r = v1.u("/");
    }

    public w0(i0 i0Var, u uVar, LinkedHashMap linkedHashMap) {
        this.f11074o = i0Var;
        this.f11075p = uVar;
        this.f11076q = linkedHashMap;
    }

    public final List a(i0 i0Var, boolean z10) {
        sb.l lVar = (sb.l) this.f11076q.get(f11073r.e(i0Var, true));
        if (lVar != null) {
            return ma.j.J(lVar.f11725q);
        }
        if (z10) {
            throw new IOException(r.a.e(i0Var, "not a directory: "));
        }
        return null;
    }

    @Override // rb.u
    public final q0 appendingSink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        throw new IOException("zip file systems are read-only");
    }

    @Override // rb.u
    public final void atomicMove(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        throw new IOException("zip file systems are read-only");
    }

    @Override // rb.u
    public final i0 canonicalize(i0 i0Var) {
        za.h.e("path", i0Var);
        i0 i0Var2 = f11073r;
        i0Var2.getClass();
        i0 b2 = sb.f.b(i0Var2, i0Var, true);
        if (this.f11076q.containsKey(b2)) {
            return b2;
        }
        throw new FileNotFoundException(String.valueOf(i0Var));
    }

    @Override // rb.u
    public final void createDirectory(i0 i0Var, boolean z10) {
        za.h.e("dir", i0Var);
        throw new IOException("zip file systems are read-only");
    }

    @Override // rb.u
    public final void createSymlink(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        throw new IOException("zip file systems are read-only");
    }

    @Override // rb.u
    public final void delete(i0 i0Var, boolean z10) {
        za.h.e("path", i0Var);
        throw new IOException("zip file systems are read-only");
    }

    @Override // rb.u
    public final List list(i0 i0Var) {
        za.h.e("dir", i0Var);
        List a10 = a(i0Var, true);
        za.h.b(a10);
        return a10;
    }

    @Override // rb.u
    public final List listOrNull(i0 i0Var) {
        za.h.e("dir", i0Var);
        return a(i0Var, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0125  */
    @Override // rb.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final rb.s metadataOrNull(rb.i0 r26) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.w0.metadataOrNull(rb.i0):rb.s");
    }

    @Override // rb.u
    public final r openReadOnly(i0 i0Var) {
        za.h.e("file", i0Var);
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // rb.u
    public final r openReadWrite(i0 i0Var, boolean z10, boolean z11) {
        za.h.e("file", i0Var);
        throw new IOException("zip entries are not writable");
    }

    @Override // rb.u
    public final q0 sink(i0 i0Var, boolean z10) {
        za.h.e("file", i0Var);
        throw new IOException("zip file systems are read-only");
    }

    @Override // rb.u
    public final s0 source(i0 i0Var) {
        Throwable th;
        m0 m0Var;
        za.h.e("file", i0Var);
        i0 i0Var2 = f11073r;
        i0Var2.getClass();
        sb.l lVar = (sb.l) this.f11076q.get(sb.f.b(i0Var2, i0Var, true));
        if (lVar == null) {
            throw new FileNotFoundException(r.a.e(i0Var, "no such file: "));
        }
        long j10 = lVar.f11715f;
        r openReadOnly = this.f11075p.openReadOnly(this.f11074o);
        try {
            m0Var = b.c(openReadOnly.s(lVar.f11716h));
            try {
                openReadOnly.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th4) {
                    com.bumptech.glide.f.a(th3, th4);
                }
            }
            th = th3;
            m0Var = null;
        }
        if (th != null) {
            throw th;
        }
        za.h.e("<this>", m0Var);
        sb.b.h(m0Var, null);
        return lVar.g == 0 ? new sb.i(m0Var, j10, true) : new sb.i(new c0(new sb.i(m0Var, lVar.f11714e, true), new Inflater(true)), j10, false);
    }
}
