package y4;

import android.content.Context;
import java.util.UUID;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ z4.j f13853o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ UUID f13854p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ o4.g f13855q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Context f13856r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ s f13857s;

    public r(s sVar, z4.j jVar, UUID uuid, o4.g gVar, Context context) {
        this.f13857s = sVar;
        this.f13853o = jVar;
        this.f13854p = uuid;
        this.f13855q = gVar;
        this.f13856r = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!(this.f13853o.f14111o instanceof z4.a)) {
                String uuid = this.f13854p.toString();
                x4.o i10 = this.f13857s.f13860c.i(uuid);
                if (i10 == null || android.support.v4.media.d.c(i10.f13570b)) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                ((p4.f) this.f13857s.f13859b).i(uuid, this.f13855q);
                this.f13856r.startService(w4.b.a(this.f13856r, com.google.android.gms.internal.cast.n.g(i10), this.f13855q));
            }
            this.f13853o.i(null);
        } catch (Throwable th) {
            this.f13853o.j(th);
        }
    }
}
