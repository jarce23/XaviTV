package pa;

import java.io.Serializable;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements i, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public static final j f10146o = new j();

    @Override // pa.i
    public final i K(i iVar) {
        za.h.e("context", iVar);
        return iVar;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // pa.i
    public final i n(h hVar) {
        za.h.e("key", hVar);
        return this;
    }

    @Override // pa.i
    public final g s(h hVar) {
        za.h.e("key", hVar);
        return null;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // pa.i
    public final Object x(Object obj, p pVar) {
        return obj;
    }
}
