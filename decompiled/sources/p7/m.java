package p7;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.StrictMode;
import android.util.Log;
import ib.h0;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import r7.e0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f10067o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f10068p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f10069q;

    public /* synthetic */ m(Object obj, int i10, Object obj2) {
        this.f10067o = i10;
        this.f10068p = obj2;
        this.f10069q = obj;
    }

    private final void a() {
        try {
            ((Runnable) this.f10069q).run();
            synchronized (((f.o) this.f10068p).f4833r) {
                ((f.o) this.f10068p).c();
            }
        } catch (Throwable th) {
            synchronized (((f.o) this.f10068p).f4833r) {
                ((f.o) this.f10068p).c();
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        r7.e eVar;
        r7.e e0Var;
        switch (this.f10067o) {
            case 0:
                n7.a aVar = (n7.a) this.f10068p;
                n nVar = (n) this.f10069q;
                d dVar = (d) nVar.f10075f;
                o7.c cVar = (o7.c) nVar.f10071b;
                k kVar = (k) dVar.f10047x.get((a) nVar.f10072c);
                if (kVar == null) {
                    return;
                }
                if (aVar.f9214p != 0) {
                    kVar.l(aVar, null);
                    return;
                }
                nVar.f10070a = true;
                if (cVar.b()) {
                    if (!nVar.f10070a || (eVar = (r7.e) nVar.f10073d) == null) {
                        return;
                    }
                    ((com.google.android.gms.common.internal.a) cVar).i(eVar, (Set) nVar.f10074e);
                    return;
                }
                try {
                    com.google.android.gms.common.internal.a aVar2 = (com.google.android.gms.common.internal.a) cVar;
                    ((com.google.android.gms.common.internal.a) cVar).i(null, aVar2.b() ? aVar2.f3232y : Collections.EMPTY_SET);
                    return;
                } catch (SecurityException e7) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e7);
                    ((com.google.android.gms.common.internal.a) cVar).e("Failed to get service from broker.");
                    kVar.l(new n7.a(10, null, null), null);
                    return;
                }
            case 1:
                v vVar = (v) this.f10069q;
                h8.e eVar2 = (h8.e) this.f10068p;
                vVar.getClass();
                n7.a aVar3 = eVar2.f5762p;
                if (aVar3.f9214p == 0) {
                    r7.o oVar = eVar2.f5763q;
                    r7.r.e(oVar);
                    n7.a aVar4 = oVar.f10941q;
                    if (aVar4.f9214p != 0) {
                        Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(aVar4)), new Exception());
                        vVar.f10099i.d(aVar4);
                        vVar.f10098h.d();
                        return;
                    }
                    n nVar2 = vVar.f10099i;
                    IBinder iBinder = oVar.f10940p;
                    if (iBinder == null) {
                        e0Var = null;
                    } else {
                        int i10 = r7.a.f10868c;
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        e0Var = queryLocalInterface instanceof r7.e ? (r7.e) queryLocalInterface : new e0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                    }
                    Set set = vVar.f10097f;
                    nVar2.getClass();
                    if (e0Var == null || set == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        nVar2.d(new n7.a(4, null, null));
                    } else {
                        nVar2.f10073d = e0Var;
                        nVar2.f10074e = set;
                        if (nVar2.f10070a) {
                            ((com.google.android.gms.common.internal.a) ((o7.c) nVar2.f10071b)).i(e0Var, set);
                        }
                    }
                } else {
                    vVar.f10099i.d(aVar3);
                }
                vVar.f10098h.d();
                return;
            case 2:
                o4.p d6 = o4.p.d();
                String str = q4.a.f10314e;
                StringBuilder sb2 = new StringBuilder("Scheduling work ");
                x4.o oVar2 = (x4.o) this.f10068p;
                sb2.append(oVar2.f13569a);
                d6.a(str, sb2.toString());
                ((q4.a) this.f10069q).f10315a.a(oVar2);
                return;
            case 3:
                x4.o c10 = ((w4.b) this.f10069q).f13091o.f9962f.c((String) this.f10068p);
                if (c10 == null || !c10.b()) {
                    return;
                }
                synchronized (((w4.b) this.f10069q).f13093q) {
                    ((w4.b) this.f10069q).f13096t.put(com.google.android.gms.internal.cast.n.g(c10), c10);
                    w4.b bVar = (w4.b) this.f10069q;
                    ((w4.b) this.f10069q).f13097u.put(com.google.android.gms.internal.cast.n.g(c10), t4.h.a(bVar.f13098v, c10, (h0) bVar.f13092p.f13554q, bVar));
                }
                return;
            case 4:
                w5.b bVar2 = (w5.b) this.f10069q;
                if (bVar2.f13107d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    ((Runnable) this.f10068p).run();
                    return;
                } catch (Throwable th) {
                    bVar2.f13106c.getClass();
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                        return;
                    }
                    return;
                }
            case 5:
                a();
                return;
            default:
                if (((y4.q) this.f10069q).f13847o.f14111o instanceof z4.a) {
                    return;
                }
                try {
                    o4.g gVar = (o4.g) ((z4.j) this.f10068p).get();
                    if (gVar == null) {
                        throw new IllegalStateException("Worker was marked important (" + ((y4.q) this.f10069q).f13849q.f13571c + ") but did not provide ForegroundInfo");
                    }
                    o4.p.d().a(y4.q.f13846u, "Updating notification for " + ((y4.q) this.f10069q).f13849q.f13571c);
                    y4.q qVar = (y4.q) this.f10069q;
                    z4.j jVar = qVar.f13847o;
                    y4.s sVar = qVar.f13851s;
                    Context context = qVar.f13848p;
                    UUID uuid = qVar.f13850r.f9507p.f1518a;
                    sVar.getClass();
                    z4.j jVar2 = new z4.j();
                    sVar.f13858a.g(new y4.r(sVar, jVar2, uuid, gVar, context));
                    jVar.k(jVar2);
                    return;
                } catch (Throwable th2) {
                    ((y4.q) this.f10069q).f13847o.j(th2);
                    return;
                }
        }
    }

    public m(f.o oVar, Runnable runnable) {
        this.f10067o = 5;
        this.f10068p = oVar;
        this.f10069q = runnable;
    }
}
