package o1;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements h {

    /* renamed from: o, reason: collision with root package name */
    public final h f9388o;

    /* renamed from: p, reason: collision with root package name */
    public long f9389p;

    /* renamed from: q, reason: collision with root package name */
    public Uri f9390q;

    public c0(h hVar) {
        hVar.getClass();
        this.f9388o = hVar;
        this.f9390q = Uri.EMPTY;
        Map map = Collections.EMPTY_MAP;
    }

    @Override // o1.h
    public final void close() {
        this.f9388o.close();
    }

    @Override // o1.h
    public final Map e() {
        return this.f9388o.e();
    }

    @Override // o1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f9388o.g(e0Var);
    }

    @Override // o1.h
    public final long j(l lVar) {
        h hVar = this.f9388o;
        this.f9390q = lVar.f9428a;
        Map map = Collections.EMPTY_MAP;
        try {
            return hVar.j(lVar);
        } finally {
            Uri l10 = hVar.l();
            if (l10 != null) {
                this.f9390q = l10;
            }
            hVar.e();
        }
    }

    @Override // o1.h
    public final Uri l() {
        return this.f9388o.l();
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        int read = this.f9388o.read(bArr, i10, i11);
        if (read != -1) {
            this.f9389p += read;
        }
        return read;
    }
}
