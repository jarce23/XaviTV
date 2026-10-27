package r;

import com.google.android.gms.internal.cast.t3;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f10399a;

    /* renamed from: b, reason: collision with root package name */
    public k f10400b;

    /* renamed from: c, reason: collision with root package name */
    public l f10401c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10402d;

    public final void a() {
        this.f10402d = true;
        k kVar = this.f10400b;
        if (kVar != null) {
            j jVar = kVar.f10405p;
            jVar.getClass();
            if (h.f10394t.f(jVar, null, h.f10395u)) {
                h.c(jVar);
                this.f10399a = null;
                this.f10400b = null;
                this.f10401c = null;
            }
        }
    }

    public final void finalize() {
        l lVar;
        k kVar = this.f10400b;
        if (kVar != null) {
            j jVar = kVar.f10405p;
            if (!jVar.isDone()) {
                t3 t3Var = new t3("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f10399a, 2);
                jVar.getClass();
                if (h.f10394t.f(jVar, null, new c(t3Var))) {
                    h.c(jVar);
                }
            }
        }
        if (this.f10402d || (lVar = this.f10401c) == null) {
            return;
        }
        lVar.i(null);
    }
}
