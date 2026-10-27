package y4;

import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: e, reason: collision with root package name */
    public static final String f13863e = o4.p.f("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final h5.i f13864a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13865b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f13866c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f13867d = new Object();

    public w(h5.i iVar) {
        this.f13864a = iVar;
    }

    public final void a(x4.j jVar) {
        synchronized (this.f13867d) {
            try {
                if (((v) this.f13865b.remove(jVar)) != null) {
                    o4.p.d().a(f13863e, "Stopping timer for " + jVar);
                    this.f13866c.remove(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
