package pa;

import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import okhttp3.internal.url._UrlKt;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements i, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final i f10143o;

    /* renamed from: p, reason: collision with root package name */
    public final g f10144p;

    public c(g gVar, i iVar) {
        za.h.e("left", iVar);
        za.h.e("element", gVar);
        this.f10143o = iVar;
        this.f10144p = gVar;
    }

    @Override // pa.i
    public final /* bridge */ i K(i iVar) {
        return n.q(this, iVar);
    }

    public final boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            int i10 = 2;
            c cVar2 = cVar;
            int i11 = 2;
            while (true) {
                i iVar = cVar2.f10143o;
                cVar2 = iVar instanceof c ? (c) iVar : null;
                if (cVar2 == null) {
                    break;
                }
                i11++;
            }
            c cVar3 = this;
            while (true) {
                i iVar2 = cVar3.f10143o;
                cVar3 = iVar2 instanceof c ? (c) iVar2 : null;
                if (cVar3 == null) {
                    break;
                }
                i10++;
            }
            if (i11 == i10) {
                c cVar4 = this;
                while (true) {
                    g gVar = cVar4.f10144p;
                    if (!za.h.a(cVar.s(gVar.getKey()), gVar)) {
                        z10 = false;
                        break;
                    }
                    i iVar3 = cVar4.f10143o;
                    if (!(iVar3 instanceof c)) {
                        za.h.c("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element", iVar3);
                        g gVar2 = (g) iVar3;
                        z10 = za.h.a(cVar.s(gVar2.getKey()), gVar2);
                        break;
                    }
                    cVar4 = (c) iVar3;
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10144p.hashCode() + this.f10143o.hashCode();
    }

    @Override // pa.i
    public final i n(h hVar) {
        za.h.e("key", hVar);
        g gVar = this.f10144p;
        g s10 = gVar.s(hVar);
        i iVar = this.f10143o;
        if (s10 != null) {
            return iVar;
        }
        i n10 = iVar.n(hVar);
        return n10 == iVar ? this : n10 == j.f10146o ? gVar : new c(gVar, n10);
    }

    @Override // pa.i
    public final g s(h hVar) {
        za.h.e("key", hVar);
        c cVar = this;
        while (true) {
            g s10 = cVar.f10144p.s(hVar);
            if (s10 != null) {
                return s10;
            }
            i iVar = cVar.f10143o;
            if (!(iVar instanceof c)) {
                return iVar.s(hVar);
            }
            cVar = (c) iVar;
        }
    }

    public final String toString() {
        return "[" + ((String) x(_UrlKt.FRAGMENT_ENCODE_SET, new b(0))) + ']';
    }

    @Override // pa.i
    public final Object x(Object obj, p pVar) {
        return pVar.b(this.f10143o.x(obj, pVar), this.f10144p);
    }
}
