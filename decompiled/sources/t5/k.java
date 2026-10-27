package t5;

import android.os.SystemClock;
import android.util.Log;
import c2.j1;
import j9.w1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import m.d3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements p, r {

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f11952h = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.h f11953a;

    /* renamed from: b, reason: collision with root package name */
    public final w1 f11954b;

    /* renamed from: c, reason: collision with root package name */
    public final v5.c f11955c;

    /* renamed from: d, reason: collision with root package name */
    public final d3 f11956d;

    /* renamed from: e, reason: collision with root package name */
    public final ea.a f11957e;

    /* renamed from: f, reason: collision with root package name */
    public final j1 f11958f;
    public final x4.i g;

    public k(v5.c cVar, p4.p pVar, w5.d dVar, w5.d dVar2, w5.d dVar3, w5.d dVar4) {
        this.f11955c = cVar;
        c.a aVar = new c.a(3, pVar);
        x4.i iVar = new x4.i(15);
        this.g = iVar;
        synchronized (this) {
            synchronized (iVar) {
                iVar.f13556s = this;
            }
        }
        this.f11954b = new w1(18);
        this.f11953a = new com.bumptech.glide.h(2);
        d3 d3Var = new d3();
        d3Var.f8404u = n6.c.a(150, new p4.p(8, d3Var));
        d3Var.f8398o = dVar;
        d3Var.f8399p = dVar2;
        d3Var.f8400q = dVar3;
        d3Var.f8401r = dVar4;
        d3Var.f8402s = this;
        d3Var.f8403t = this;
        this.f11956d = d3Var;
        this.f11958f = new j1(aVar);
        this.f11957e = new ea.a(4);
        cVar.f12678d = this;
    }

    public static void d(String str, long j10, q qVar) {
        StringBuilder a10 = s.e.a(str, " in ");
        a10.append(m6.h.a(j10));
        a10.append("ms, key: ");
        a10.append(qVar);
        Log.v("Engine", a10.toString());
    }

    public static void g(y yVar) {
        if (!(yVar instanceof s)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((s) yVar).b();
    }

    public final x4.m a(com.bumptech.glide.g gVar, Object obj, r5.e eVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.i iVar, j jVar, m6.c cVar, boolean z10, boolean z11, r5.h hVar, boolean z12, boolean z13, i6.f fVar, f.p pVar) {
        long j10;
        if (f11952h) {
            int i12 = m6.h.f9016b;
            j10 = SystemClock.elapsedRealtimeNanos();
        } else {
            j10 = 0;
        }
        this.f11954b.getClass();
        q qVar = new q(obj, eVar, i10, i11, cVar, cls, cls2, hVar);
        synchronized (this) {
            try {
                s c10 = c(qVar, z12, j10);
                if (c10 == null) {
                    return h(gVar, obj, eVar, i10, i11, cls, cls2, iVar, jVar, cVar, z10, z11, hVar, z12, z13, fVar, pVar, qVar, j10);
                }
                fVar.h(c10, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t5.s b(t5.q r10) {
        /*
            r9 = this;
            v5.c r1 = r9.f11955c
            monitor-enter(r1)
            java.io.Serializable r0 = r1.f9021c     // Catch: java.lang.Throwable -> L43
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r0.remove(r10)     // Catch: java.lang.Throwable -> L43
            m6.i r0 = (m6.i) r0     // Catch: java.lang.Throwable -> L43
            r2 = 0
            if (r0 != 0) goto L13
            monitor-exit(r1)
            r0 = r2
            goto L1e
        L13:
            long r3 = r1.f9020b     // Catch: java.lang.Throwable -> L43
            int r5 = r0.f9018b     // Catch: java.lang.Throwable -> L43
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L43
            long r3 = r3 - r5
            r1.f9020b = r3     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r0.f9017a     // Catch: java.lang.Throwable -> L43
            monitor-exit(r1)
        L1e:
            r4 = r0
            t5.y r4 = (t5.y) r4
            if (r4 != 0) goto L26
        L23:
            r8 = r9
            r7 = r10
            goto L38
        L26:
            boolean r0 = r4 instanceof t5.s
            if (r0 == 0) goto L2e
            r2 = r4
            t5.s r2 = (t5.s) r2
            goto L23
        L2e:
            t5.s r3 = new t5.s
            r5 = 1
            r6 = 1
            r8 = r9
            r7 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = r3
        L38:
            if (r2 == 0) goto L42
            r2.a()
            x4.i r10 = r8.g
            r10.a(r7, r2)
        L42:
            return r2
        L43:
            r0 = move-exception
            r8 = r9
        L45:
            r10 = r0
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L48
            throw r10
        L48:
            r0 = move-exception
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.k.b(t5.q):t5.s");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final s c(q qVar, boolean z10, long j10) {
        s sVar;
        if (z10) {
            x4.i iVar = this.g;
            synchronized (iVar) {
                a aVar = (a) ((HashMap) iVar.f13554q).get(qVar);
                if (aVar == null) {
                    sVar = null;
                } else {
                    sVar = (s) aVar.get();
                    if (sVar == null) {
                        iVar.e(aVar);
                    }
                }
            }
            if (sVar != null) {
                sVar.a();
            }
            if (sVar != null) {
                if (f11952h) {
                    d("Loaded resource from active resources", j10, qVar);
                }
                return sVar;
            }
            s b2 = b(qVar);
            if (b2 != null) {
                if (f11952h) {
                    d("Loaded resource from cache", j10, qVar);
                }
                return b2;
            }
        }
        return null;
    }

    public final synchronized void e(o oVar, q qVar, s sVar) {
        if (sVar != null) {
            try {
                if (sVar.f11985o) {
                    this.g.a(qVar, sVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        HashMap hashMap = this.f11953a.f3017a;
        if (oVar.equals(hashMap.get(qVar))) {
            hashMap.remove(qVar);
        }
    }

    public final void f(r5.e eVar, s sVar) {
        x4.i iVar = this.g;
        synchronized (iVar) {
            a aVar = (a) ((HashMap) iVar.f13554q).remove(eVar);
            if (aVar != null) {
                aVar.f11887c = null;
                aVar.clear();
            }
        }
        if (sVar.f11985o) {
        } else {
            this.f11957e.g(sVar, false);
        }
    }

    public final x4.m h(com.bumptech.glide.g gVar, Object obj, r5.e eVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.i iVar, j jVar, Map map, boolean z10, boolean z11, r5.h hVar, boolean z12, boolean z13, i6.f fVar, Executor executor, q qVar, long j10) {
        o oVar = (o) this.f11953a.f3017a.get(qVar);
        if (oVar != null) {
            oVar.a(fVar, executor);
            if (f11952h) {
                d("Added to existing load", j10, qVar);
            }
            return new x4.m(this, fVar, oVar);
        }
        o oVar2 = (o) ((android.support.v4.media.session.a0) this.f11956d.f8404u).v();
        synchronized (oVar2) {
            oVar2.f11975y = qVar;
            oVar2.f11976z = z12;
            oVar2.A = z13;
        }
        j1 j1Var = this.f11958f;
        h hVar2 = (h) ((android.support.v4.media.session.a0) j1Var.f2627r).v();
        int i12 = j1Var.f2625p;
        j1Var.f2625p = i12 + 1;
        g gVar2 = hVar2.f11931o;
        c.a aVar = hVar2.f11934r;
        gVar2.f11916c = gVar;
        gVar2.f11917d = obj;
        gVar2.f11926n = eVar;
        gVar2.f11918e = i10;
        gVar2.f11919f = i11;
        gVar2.f11928p = jVar;
        gVar2.g = cls;
        gVar2.f11920h = aVar;
        gVar2.f11923k = cls2;
        gVar2.f11927o = iVar;
        gVar2.f11921i = hVar;
        gVar2.f11922j = map;
        gVar2.f11929q = z10;
        gVar2.f11930r = z11;
        hVar2.f11938v = gVar;
        hVar2.f11939w = eVar;
        hVar2.f11940x = iVar;
        hVar2.f11941y = qVar;
        hVar2.f11942z = i10;
        hVar2.A = i11;
        hVar2.B = jVar;
        hVar2.C = hVar;
        hVar2.D = oVar2;
        hVar2.E = i12;
        hVar2.T = 1;
        hVar2.G = obj;
        hVar2.H = gVar.f3014h;
        hVar2.I = s4.a.f(hVar.c(h.V));
        com.bumptech.glide.h hVar3 = this.f11953a;
        hVar3.getClass();
        hVar3.f3017a.put(qVar, oVar2);
        oVar2.a(fVar, executor);
        oVar2.k(hVar2);
        if (f11952h) {
            d("Started new load", j10, qVar);
        }
        return new x4.m(this, fVar, oVar2);
    }
}
