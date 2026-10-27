package i8;

import com.bumptech.glide.manager.t;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final i f6520a = new i();

    public final void a(Exception exc) {
        this.f6520a.q(exc);
    }

    public final void b(Object obj) {
        this.f6520a.p(obj);
    }

    public final void c(Exception exc) {
        i iVar = this.f6520a;
        iVar.getClass();
        r.f("Exception must not be null", exc);
        synchronized (iVar.f6530b) {
            try {
                if (iVar.f6529a) {
                    return;
                }
                iVar.f6529a = true;
                iVar.f6533e = exc;
                ((t) iVar.f6532d).g(iVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(Object obj) {
        i iVar = this.f6520a;
        synchronized (iVar.f6530b) {
            try {
                if (iVar.f6529a) {
                    return;
                }
                iVar.f6529a = true;
                iVar.f6531c = obj;
                ((t) iVar.f6532d).g(iVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
