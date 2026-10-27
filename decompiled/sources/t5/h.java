package t5;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements e, Runnable, Comparable, n6.b {
    public static final r5.g V = new r5.g("glide_thread_priority_override", null, r5.g.f10790e);
    public int A;
    public j B;
    public r5.h C;
    public o D;
    public int E;
    public long F;
    public Object G;
    public a6.n H;
    public Supplier I;
    public Thread J;
    public r5.e K;
    public r5.e L;
    public Object M;
    public com.bumptech.glide.load.data.d N;
    public volatile f O;
    public volatile boolean P;
    public volatile boolean Q;
    public boolean R;
    public int S;
    public int T;
    public int U;

    /* renamed from: r, reason: collision with root package name */
    public final c.a f11934r;

    /* renamed from: s, reason: collision with root package name */
    public final l0.c f11935s;

    /* renamed from: v, reason: collision with root package name */
    public com.bumptech.glide.g f11938v;

    /* renamed from: w, reason: collision with root package name */
    public r5.e f11939w;

    /* renamed from: x, reason: collision with root package name */
    public com.bumptech.glide.i f11940x;

    /* renamed from: y, reason: collision with root package name */
    public q f11941y;

    /* renamed from: z, reason: collision with root package name */
    public int f11942z;

    /* renamed from: o, reason: collision with root package name */
    public final g f11931o = new g();

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f11932p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public final n6.d f11933q = new n6.d();

    /* renamed from: t, reason: collision with root package name */
    public final android.support.v4.media.session.a0 f11936t = new android.support.v4.media.session.a0(23, false);

    /* renamed from: u, reason: collision with root package name */
    public final e3.d f11937u = new e3.d();

    public h(c.a aVar, android.support.v4.media.session.a0 a0Var) {
        this.f11934r = aVar;
        this.f11935s = a0Var;
    }

    @Override // t5.e
    public final void a(r5.e eVar, Exception exc, com.bumptech.glide.load.data.d dVar, int i10) {
        dVar.b();
        u uVar = new u("Fetching data failed", Collections.singletonList(exc));
        Class a10 = dVar.a();
        uVar.f11996p = eVar;
        uVar.f11997q = i10;
        uVar.f11998r = a10;
        this.f11932p.add(uVar);
        if (Thread.currentThread() != this.J) {
            o(2);
        } else {
            q();
        }
    }

    @Override // n6.b
    public final n6.d b() {
        return this.f11933q;
    }

    @Override // t5.e
    public final void c(r5.e eVar, Object obj, com.bumptech.glide.load.data.d dVar, int i10, r5.e eVar2) {
        this.K = eVar;
        this.M = obj;
        this.N = dVar;
        this.U = i10;
        this.L = eVar2;
        this.R = eVar != this.f11931o.a().get(0);
        if (Thread.currentThread() != this.J) {
            o(3);
        } else {
            f();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        h hVar = (h) obj;
        int ordinal = this.f11940x.ordinal() - hVar.f11940x.ordinal();
        return ordinal == 0 ? this.E - hVar.E : ordinal;
    }

    public final y d(com.bumptech.glide.load.data.d dVar, Object obj, int i10) {
        if (obj == null) {
            return null;
        }
        try {
            int i11 = m6.h.f9016b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            y e7 = e(i10, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                i(elapsedRealtimeNanos, "Decoded result " + e7, null);
            }
            return e7;
        } finally {
            dVar.b();
        }
    }

    public final y e(int i10, Object obj) {
        Class<?> cls = obj.getClass();
        g gVar = this.f11931o;
        w c10 = gVar.c(cls);
        r5.h hVar = this.C;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z10 = i10 == 4 || gVar.f11930r;
            r5.g gVar2 = a6.s.f93i;
            Boolean bool = (Boolean) hVar.c(gVar2);
            if (bool == null || (bool.booleanValue() && !z10)) {
                hVar = new r5.h();
                m6.c cVar = this.C.f10795b;
                m6.c cVar2 = hVar.f10795b;
                cVar2.g(cVar);
                cVar2.put(gVar2, Boolean.valueOf(z10));
            }
        }
        r5.h hVar2 = hVar;
        com.bumptech.glide.load.data.f h10 = this.f11938v.b().h(obj);
        try {
            return c10.a(this.f11942z, this.A, new app.shamel.tv.b(i10, 12, this), h10, hVar2);
        } finally {
            h10.b();
        }
    }

    public final void f() {
        y yVar;
        boolean b2;
        Supplier supplier;
        Object obj;
        Object obj2;
        if (Log.isLoggable("DecodeJob", 2)) {
            i(this.F, "Retrieved data", "data: " + this.M + ", cache key: " + this.K + ", fetcher: " + this.N);
        }
        x xVar = null;
        if (((Map) this.H.f74p).containsKey(com.bumptech.glide.e.class) && (supplier = this.I) != null) {
            obj = supplier.get();
            if (obj != null) {
                try {
                    int myTid = Process.myTid();
                    obj2 = this.I.get();
                    Process.setThreadPriority(myTid, ((Integer) obj2).intValue());
                } catch (IllegalArgumentException | SecurityException e7) {
                    this.I = null;
                    if (Log.isLoggable("DecodeJob", 2)) {
                        Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e7);
                    }
                }
            }
        }
        try {
            yVar = d(this.N, this.M, this.U);
        } catch (u e8) {
            r5.e eVar = this.L;
            int i10 = this.U;
            e8.f11996p = eVar;
            e8.f11997q = i10;
            e8.f11998r = null;
            this.f11932p.add(e8);
            yVar = null;
        }
        if (yVar == null) {
            q();
            return;
        }
        int i11 = this.U;
        boolean z10 = this.R;
        if (yVar instanceof v) {
            ((v) yVar).a();
        }
        if (((x) this.f11936t.f232r) != null) {
            xVar = (x) x.f12003s.v();
            xVar.f12007r = false;
            xVar.f12006q = true;
            xVar.f12005p = yVar;
            yVar = xVar;
        }
        j(yVar, i11, z10);
        this.S = 5;
        try {
            android.support.v4.media.session.a0 a0Var = this.f11936t;
            if (((x) a0Var.f232r) != null) {
                c.a aVar = this.f11934r;
                r5.h hVar = this.C;
                a0Var.getClass();
                try {
                    aVar.b().a((r5.e) a0Var.f230p, new x4.m((r5.k) a0Var.f231q, (x) a0Var.f232r, hVar, 24));
                    ((x) a0Var.f232r).a();
                } catch (Throwable th) {
                    ((x) a0Var.f232r).a();
                    throw th;
                }
            }
            e3.d dVar = this.f11937u;
            synchronized (dVar) {
                dVar.f4426b = true;
                b2 = dVar.b();
            }
            if (b2) {
                n();
            }
        } finally {
            if (xVar != null) {
                xVar.a();
            }
        }
    }

    public final f g() {
        int b2 = s.e.b(this.S);
        g gVar = this.f11931o;
        if (b2 == 1) {
            return new z(gVar, this);
        }
        if (b2 == 2) {
            return new c(gVar.a(), gVar, this);
        }
        if (b2 == 3) {
            return new b0(gVar, this);
        }
        if (b2 == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(r.a.o(this.S)));
    }

    public final int h(int i10) {
        boolean z10;
        boolean z11;
        int b2 = s.e.b(i10);
        if (b2 == 0) {
            switch (this.B.f11951a) {
                case 0:
                case 1:
                    z10 = false;
                    break;
                default:
                    z10 = true;
                    break;
            }
            if (z10) {
                return 2;
            }
            return h(2);
        }
        if (b2 != 1) {
            if (b2 == 2) {
                return 4;
            }
            if (b2 == 3 || b2 == 5) {
                return 6;
            }
            throw new IllegalArgumentException("Unrecognized stage: ".concat(r.a.o(i10)));
        }
        switch (this.B.f11951a) {
            case 0:
                z11 = false;
                break;
            case 1:
            default:
                z11 = true;
                break;
        }
        if (z11) {
            return 3;
        }
        return h(3);
    }

    public final void i(long j10, String str, String str2) {
        StringBuilder a10 = s.e.a(str, " in ");
        a10.append(m6.h.a(j10));
        a10.append(", load key: ");
        a10.append(this.f11941y);
        a10.append(str2 != null ? ", ".concat(str2) : _UrlKt.FRAGMENT_ENCODE_SET);
        a10.append(", thread: ");
        a10.append(Thread.currentThread().getName());
        Log.v("DecodeJob", a10.toString());
    }

    public final void j(y yVar, int i10, boolean z10) {
        if (((Map) this.H.f74p).containsKey(com.bumptech.glide.e.class)) {
            p();
        }
        s();
        o oVar = this.D;
        synchronized (oVar) {
            oVar.B = yVar;
            oVar.C = i10;
            oVar.J = z10;
        }
        oVar.h();
    }

    public final void k() {
        if (((Map) this.H.f74p).containsKey(com.bumptech.glide.e.class)) {
            p();
        }
        s();
        u uVar = new u("Failed to load resource", new ArrayList(this.f11932p));
        o oVar = this.D;
        synchronized (oVar) {
            oVar.E = uVar;
        }
        oVar.g();
        l();
    }

    public final void l() {
        boolean b2;
        e3.d dVar = this.f11937u;
        synchronized (dVar) {
            dVar.f4427c = true;
            b2 = dVar.b();
        }
        if (b2) {
            n();
        }
    }

    public final void m() {
        boolean b2;
        e3.d dVar = this.f11937u;
        synchronized (dVar) {
            dVar.f4425a = true;
            b2 = dVar.b();
        }
        if (b2) {
            n();
        }
    }

    public final void n() {
        e3.d dVar = this.f11937u;
        synchronized (dVar) {
            dVar.f4426b = false;
            dVar.f4425a = false;
            dVar.f4427c = false;
        }
        android.support.v4.media.session.a0 a0Var = this.f11936t;
        a0Var.f230p = null;
        a0Var.f231q = null;
        a0Var.f232r = null;
        g gVar = this.f11931o;
        gVar.f11916c = null;
        gVar.f11917d = null;
        gVar.f11926n = null;
        gVar.g = null;
        gVar.f11923k = null;
        gVar.f11921i = null;
        gVar.f11927o = null;
        gVar.f11922j = null;
        gVar.f11928p = null;
        gVar.f11914a.clear();
        gVar.f11924l = false;
        gVar.f11915b.clear();
        gVar.f11925m = false;
        this.P = false;
        this.f11938v = null;
        this.f11939w = null;
        this.C = null;
        this.f11940x = null;
        this.f11941y = null;
        this.D = null;
        this.S = 0;
        this.O = null;
        this.J = null;
        this.K = null;
        this.M = null;
        this.U = 0;
        this.N = null;
        this.F = 0L;
        this.Q = false;
        this.G = null;
        this.f11932p.clear();
        this.f11935s.m(this);
    }

    public final void o(int i10) {
        this.T = i10;
        o oVar = this.D;
        (oVar.A ? oVar.f11973w : oVar.f11972v).execute(this);
    }

    public final void p() {
        Object obj;
        if (!((Map) this.H.f74p).containsKey(com.bumptech.glide.e.class)) {
            throw new IllegalStateException("OverrideGlideThreadPriority experiment is not enabled.");
        }
        Supplier supplier = this.I;
        if (supplier != null) {
            obj = supplier.get();
            if (obj != null) {
                try {
                    Process.setThreadPriority(Process.myTid(), 9);
                } catch (IllegalArgumentException | SecurityException e7) {
                    this.I = null;
                    if (Log.isLoggable("DecodeJob", 2)) {
                        Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e7);
                    }
                }
            }
        }
    }

    public final void q() {
        this.J = Thread.currentThread();
        int i10 = m6.h.f9016b;
        this.F = SystemClock.elapsedRealtimeNanos();
        boolean z10 = false;
        while (!this.Q && this.O != null && !(z10 = this.O.b())) {
            this.S = h(this.S);
            this.O = g();
            if (this.S == 4) {
                o(2);
                return;
            }
        }
        if ((this.S == 6 || this.Q) && !z10) {
            k();
        }
    }

    public final void r() {
        int b2 = s.e.b(this.T);
        if (b2 == 0) {
            this.S = h(1);
            this.O = g();
            q();
        } else if (b2 == 1) {
            q();
        } else if (b2 == 2) {
            f();
        } else {
            int i10 = this.T;
            throw new IllegalStateException("Unrecognized run reason: ".concat(i10 != 1 ? i10 != 2 ? i10 != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.d dVar = this.N;
        try {
            try {
                if (this.Q) {
                    k();
                    if (dVar != null) {
                        dVar.b();
                        return;
                    }
                    return;
                }
                r();
                if (dVar != null) {
                    dVar.b();
                }
            } catch (Throwable th) {
                if (dVar != null) {
                    dVar.b();
                }
                throw th;
            }
        } catch (b e7) {
            throw e7;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.Q + ", stage: " + r.a.o(this.S), th2);
            }
            if (this.S != 5) {
                this.f11932p.add(th2);
                k();
            }
            if (!this.Q) {
                throw th2;
            }
            throw th2;
        }
    }

    public final void s() {
        Throwable th;
        this.f11933q.a();
        if (!this.P) {
            this.P = true;
            return;
        }
        if (this.f11932p.isEmpty()) {
            th = null;
        } else {
            ArrayList arrayList = this.f11932p;
            th = (Throwable) arrayList.get(arrayList.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }
}
