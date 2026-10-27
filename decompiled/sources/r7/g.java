package r7;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements b {

    /* renamed from: b, reason: collision with root package name */
    public static g f10914b;

    /* renamed from: c, reason: collision with root package name */
    public static final h f10915c = new h(0, false, false, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public Object f10916a;

    public /* synthetic */ g(Object obj) {
        this.f10916a = obj;
    }

    public static synchronized g b() {
        g gVar;
        synchronized (g.class) {
            try {
                if (f10914b == null) {
                    f10914b = new g();
                }
                gVar = f10914b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // r7.b
    public void a(n7.a aVar) {
        com.google.android.gms.common.internal.a aVar2 = (com.google.android.gms.common.internal.a) this.f10916a;
        if (aVar.f9214p == 0) {
            aVar2.i(null, aVar2.f3232y);
            return;
        }
        g gVar = aVar2.f3223p;
        if (gVar != null) {
            ((o7.h) gVar.f10916a).w(aVar);
        }
    }
}
