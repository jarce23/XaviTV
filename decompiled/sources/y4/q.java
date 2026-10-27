package y4;

import android.content.Context;
import android.os.Build;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: u, reason: collision with root package name */
    public static final String f13846u = o4.p.f("WorkForegroundRunnable");

    /* renamed from: o, reason: collision with root package name */
    public final z4.j f13847o = new z4.j();

    /* renamed from: p, reason: collision with root package name */
    public final Context f13848p;

    /* renamed from: q, reason: collision with root package name */
    public final x4.o f13849q;

    /* renamed from: r, reason: collision with root package name */
    public final o4.o f13850r;

    /* renamed from: s, reason: collision with root package name */
    public final s f13851s;

    /* renamed from: t, reason: collision with root package name */
    public final x4.i f13852t;

    public q(Context context, x4.o oVar, o4.o oVar2, s sVar, x4.i iVar) {
        this.f13848p = context;
        this.f13849q = oVar;
        this.f13850r = oVar2;
        this.f13851s = sVar;
        this.f13852t = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f13849q.f13584q || Build.VERSION.SDK_INT >= 31) {
            this.f13847o.i(null);
            return;
        }
        z4.j jVar = new z4.j();
        x4.i iVar = this.f13852t;
        ((a5.a) iVar.f13556s).execute(new p(this, 0, jVar));
        jVar.a(new p7.m(this, 6, jVar), (a5.a) iVar.f13556s);
    }
}
