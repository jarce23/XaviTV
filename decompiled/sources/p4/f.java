package p4;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import m.d3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements w4.a {

    /* renamed from: l, reason: collision with root package name */
    public static final String f9916l = o4.p.f("Processor");

    /* renamed from: b, reason: collision with root package name */
    public final Context f9918b;

    /* renamed from: c, reason: collision with root package name */
    public final o4.a f9919c;

    /* renamed from: d, reason: collision with root package name */
    public final x4.i f9920d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkDatabase f9921e;
    public final HashMap g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f9922f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f9924i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f9925j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f9917a = null;

    /* renamed from: k, reason: collision with root package name */
    public final Object f9926k = new Object();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f9923h = new HashMap();

    public f(Context context, o4.a aVar, x4.i iVar, WorkDatabase workDatabase) {
        this.f9918b = context;
        this.f9919c = aVar;
        this.f9920d = iVar;
        this.f9921e = workDatabase;
    }

    public static boolean e(String str, s sVar, int i10) {
        if (sVar == null) {
            o4.p.d().a(f9916l, "WorkerWrapper could not be found for " + str);
            return false;
        }
        sVar.E = i10;
        sVar.h();
        sVar.D.cancel(true);
        if (sVar.f9969r == null || !(sVar.D.f14111o instanceof z4.a)) {
            o4.p.d().a(s.F, "WorkSpec " + sVar.f9968q + " is already done. Not interrupting.");
        } else {
            sVar.f9969r.d(i10);
        }
        o4.p.d().a(f9916l, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(c cVar) {
        synchronized (this.f9926k) {
            this.f9925j.add(cVar);
        }
    }

    public final s b(String str) {
        s sVar = (s) this.f9922f.remove(str);
        boolean z10 = sVar != null;
        if (!z10) {
            sVar = (s) this.g.remove(str);
        }
        this.f9923h.remove(str);
        if (z10) {
            synchronized (this.f9926k) {
                try {
                    if (this.f9922f.isEmpty()) {
                        Context context = this.f9918b;
                        String str2 = w4.b.f13090x;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        try {
                            this.f9918b.startService(intent);
                        } catch (Throwable th) {
                            o4.p.d().c(f9916l, "Unable to stop foreground service", th);
                        }
                        PowerManager.WakeLock wakeLock = this.f9917a;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.f9917a = null;
                        }
                    }
                } finally {
                }
            }
        }
        return sVar;
    }

    public final x4.o c(String str) {
        synchronized (this.f9926k) {
            try {
                s d6 = d(str);
                if (d6 == null) {
                    return null;
                }
                return d6.f9968q;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final s d(String str) {
        s sVar = (s) this.f9922f.get(str);
        return sVar == null ? (s) this.g.get(str) : sVar;
    }

    public final boolean f(String str) {
        boolean contains;
        synchronized (this.f9926k) {
            contains = this.f9924i.contains(str);
        }
        return contains;
    }

    public final boolean g(String str) {
        boolean z10;
        synchronized (this.f9926k) {
            z10 = d(str) != null;
        }
        return z10;
    }

    public final void h(c cVar) {
        synchronized (this.f9926k) {
            this.f9925j.remove(cVar);
        }
    }

    public final void i(String str, o4.g gVar) {
        synchronized (this.f9926k) {
            try {
                o4.p.d().e(f9916l, "Moving WorkSpec (" + str + ") to the foreground");
                s sVar = (s) this.g.remove(str);
                if (sVar != null) {
                    if (this.f9917a == null) {
                        PowerManager.WakeLock a10 = y4.n.a(this.f9918b, "ProcessorForegroundLck");
                        this.f9917a = a10;
                        a10.acquire();
                    }
                    this.f9922f.put(str, sVar);
                    Intent c10 = w4.b.c(this.f9918b, com.google.android.gms.internal.cast.n.g(sVar.f9968q), gVar);
                    Context context = this.f9918b;
                    if (Build.VERSION.SDK_INT >= 26) {
                        c0.a.l(context, c10);
                    } else {
                        context.startService(c10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean j(l lVar, x4.c cVar) {
        x4.j jVar = lVar.f9939a;
        final String str = jVar.f13557a;
        final ArrayList arrayList = new ArrayList();
        x4.o oVar = (x4.o) this.f9921e.n(new Callable() { // from class: p4.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase = f.this.f9921e;
                x4.r u10 = workDatabase.u();
                String str2 = str;
                arrayList.addAll(u10.j(str2));
                return workDatabase.t().i(str2);
            }
        });
        if (oVar == null) {
            o4.p.d().g(f9916l, "Didn't find WorkSpec for id " + jVar);
            ((a5.a) this.f9920d.f13556s).execute(new androidx.fragment.app.d(this, 15, jVar));
            return false;
        }
        synchronized (this.f9926k) {
            try {
                if (g(str)) {
                    Set set = (Set) this.f9923h.get(str);
                    if (((l) set.iterator().next()).f9939a.f13558b == jVar.f13558b) {
                        set.add(lVar);
                        o4.p.d().a(f9916l, "Work " + jVar + " is already enqueued for processing");
                    } else {
                        ((a5.a) this.f9920d.f13556s).execute(new androidx.fragment.app.d(this, 15, jVar));
                    }
                    return false;
                }
                if (oVar.f13587t != jVar.f13558b) {
                    ((a5.a) this.f9920d.f13556s).execute(new androidx.fragment.app.d(this, 15, jVar));
                    return false;
                }
                Context context = this.f9918b;
                o4.a aVar = this.f9919c;
                x4.i iVar = this.f9920d;
                WorkDatabase workDatabase = this.f9921e;
                d3 d3Var = new d3();
                new x4.c(13);
                d3Var.f8398o = context.getApplicationContext();
                d3Var.f8400q = iVar;
                d3Var.f8399p = this;
                d3Var.f8401r = aVar;
                d3Var.f8402s = workDatabase;
                d3Var.f8403t = oVar;
                d3Var.f8404u = arrayList;
                s sVar = new s(d3Var);
                z4.j jVar2 = sVar.C;
                jVar2.a(new androidx.emoji2.text.m(this, jVar2, sVar, 3), (a5.a) this.f9920d.f13556s);
                this.g.put(str, sVar);
                HashSet hashSet = new HashSet();
                hashSet.add(lVar);
                this.f9923h.put(str, hashSet);
                ((f.o) this.f9920d.f13553p).execute(sVar);
                o4.p.d().a(f9916l, f.class.getSimpleName() + ": processing " + jVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k(l lVar, int i10) {
        String str = lVar.f9939a.f13557a;
        synchronized (this.f9926k) {
            try {
                if (this.f9922f.get(str) == null) {
                    Set set = (Set) this.f9923h.get(str);
                    if (set != null && set.contains(lVar)) {
                        return e(str, b(str), i10);
                    }
                    return false;
                }
                o4.p.d().a(f9916l, "Ignored stopWork. WorkerWrapper " + str + " is in foreground");
                return false;
            } finally {
            }
        }
    }
}
