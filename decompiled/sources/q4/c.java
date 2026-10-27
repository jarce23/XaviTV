package q4;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.internal.cast.n;
import g7.c0;
import ib.h0;
import ib.p0;
import j5.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import o4.p;
import o4.q;
import p4.f;
import p4.h;
import p7.m;
import t4.e;
import x4.i;
import x4.j;
import x4.o;
import y4.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements h, e, p4.c {
    public static final String C = p.f("GreedyScheduler");
    public final i A;
    public final d B;

    /* renamed from: o, reason: collision with root package name */
    public final Context f10321o;

    /* renamed from: q, reason: collision with root package name */
    public final a f10323q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10324r;

    /* renamed from: u, reason: collision with root package name */
    public final f f10327u;

    /* renamed from: v, reason: collision with root package name */
    public final x4.c f10328v;

    /* renamed from: w, reason: collision with root package name */
    public final o4.a f10329w;

    /* renamed from: y, reason: collision with root package name */
    public Boolean f10331y;

    /* renamed from: z, reason: collision with root package name */
    public final a3.f f10332z;

    /* renamed from: p, reason: collision with root package name */
    public final HashMap f10322p = new HashMap();

    /* renamed from: s, reason: collision with root package name */
    public final Object f10325s = new Object();

    /* renamed from: t, reason: collision with root package name */
    public final g f10326t = new g(14);

    /* renamed from: x, reason: collision with root package name */
    public final HashMap f10330x = new HashMap();

    public c(Context context, o4.a aVar, i iVar, f fVar, x4.c cVar, i iVar2) {
        this.f10321o = context;
        h5.i iVar3 = (h5.i) aVar.f9481j;
        this.f10323q = new a(this, iVar3, (q) aVar.g);
        this.B = new d(iVar3, cVar);
        this.A = iVar2;
        this.f10332z = new a3.f(iVar);
        this.f10329w = aVar;
        this.f10327u = fVar;
        this.f10328v = cVar;
    }

    @Override // p4.h
    public final void a(o... oVarArr) {
        if (this.f10331y == null) {
            this.f10331y = Boolean.valueOf(l.a(this.f10321o, this.f10329w));
        }
        if (!this.f10331y.booleanValue()) {
            p.d().e(C, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f10324r) {
            this.f10327u.a(this);
            this.f10324r = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            if (!this.f10326t.i(n.g(oVar))) {
                long max = Math.max(oVar.a(), g(oVar));
                ((q) this.f10329w.g).getClass();
                long currentTimeMillis = System.currentTimeMillis();
                if (oVar.f13570b == 1) {
                    if (currentTimeMillis < max) {
                        a aVar = this.f10323q;
                        if (aVar != null) {
                            h5.i iVar = aVar.f10316b;
                            HashMap hashMap = aVar.f10318d;
                            Runnable runnable = (Runnable) hashMap.remove(oVar.f13569a);
                            if (runnable != null) {
                                ((Handler) iVar.f5610p).removeCallbacks(runnable);
                            }
                            m mVar = new m(aVar, 2, oVar);
                            hashMap.put(oVar.f13569a, mVar);
                            aVar.f10317c.getClass();
                            ((Handler) iVar.f5610p).postDelayed(mVar, max - System.currentTimeMillis());
                        }
                    } else if (oVar.b()) {
                        int i10 = Build.VERSION.SDK_INT;
                        o4.d dVar = oVar.f13577j;
                        if (dVar.f9489c) {
                            p.d().a(C, "Ignoring " + oVar + ". Requires device idle.");
                        } else if (i10 < 24 || !dVar.a()) {
                            hashSet.add(oVar);
                            hashSet2.add(oVar.f13569a);
                        } else {
                            p.d().a(C, "Ignoring " + oVar + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.f10326t.i(n.g(oVar))) {
                        p.d().a(C, "Starting work for " + oVar.f13569a);
                        g gVar = this.f10326t;
                        gVar.getClass();
                        p4.l x6 = gVar.x(n.g(oVar));
                        this.B.d(x6);
                        x4.c cVar = this.f10328v;
                        ((i) cVar.f13538q).g(new c0((f) cVar.f13537p, x6, null));
                    }
                }
            }
        }
        synchronized (this.f10325s) {
            try {
                if (!hashSet.isEmpty()) {
                    p.d().a(C, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        o oVar2 = (o) it.next();
                        j g = n.g(oVar2);
                        if (!this.f10322p.containsKey(g)) {
                            this.f10322p.put(g, t4.h.a(this.f10332z, oVar2, (h0) this.A.f13554q, this));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p4.c
    public final void b(j jVar, boolean z10) {
        p4.l w10 = this.f10326t.w(jVar);
        if (w10 != null) {
            this.B.b(w10);
        }
        f(jVar);
        if (z10) {
            return;
        }
        synchronized (this.f10325s) {
            this.f10330x.remove(jVar);
        }
    }

    @Override // p4.h
    public final void c(String str) {
        Runnable runnable;
        if (this.f10331y == null) {
            this.f10331y = Boolean.valueOf(l.a(this.f10321o, this.f10329w));
        }
        boolean booleanValue = this.f10331y.booleanValue();
        String str2 = C;
        if (!booleanValue) {
            p.d().e(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f10324r) {
            this.f10327u.a(this);
            this.f10324r = true;
        }
        p.d().a(str2, "Cancelling work ID " + str);
        a aVar = this.f10323q;
        if (aVar != null && (runnable = (Runnable) aVar.f10318d.remove(str)) != null) {
            ((Handler) aVar.f10316b.f5610p).removeCallbacks(runnable);
        }
        for (p4.l lVar : this.f10326t.s(str)) {
            this.B.b(lVar);
            x4.c cVar = this.f10328v;
            cVar.getClass();
            cVar.e0(lVar, -512);
        }
    }

    @Override // p4.h
    public final boolean d() {
        return false;
    }

    @Override // t4.e
    public final void e(o oVar, t4.c cVar) {
        j g = n.g(oVar);
        boolean z10 = cVar instanceof t4.a;
        x4.c cVar2 = this.f10328v;
        d dVar = this.B;
        String str = C;
        g gVar = this.f10326t;
        if (z10) {
            if (gVar.i(g)) {
                return;
            }
            p.d().a(str, "Constraints met: Scheduling work ID " + g);
            p4.l x6 = gVar.x(g);
            dVar.d(x6);
            ((i) cVar2.f13538q).g(new c0((f) cVar2.f13537p, x6, null));
            return;
        }
        p.d().a(str, "Constraints not met: Cancelling work ID " + g);
        p4.l w10 = gVar.w(g);
        if (w10 != null) {
            dVar.b(w10);
            int i10 = ((t4.b) cVar).f11875a;
            cVar2.getClass();
            cVar2.e0(w10, i10);
        }
    }

    public final void f(j jVar) {
        p0 p0Var;
        synchronized (this.f10325s) {
            p0Var = (p0) this.f10322p.remove(jVar);
        }
        if (p0Var != null) {
            p.d().a(C, "Stopping tracking for " + jVar);
            p0Var.c(null);
        }
    }

    public final long g(o oVar) {
        long max;
        synchronized (this.f10325s) {
            try {
                j g = n.g(oVar);
                b bVar = (b) this.f10330x.get(g);
                if (bVar == null) {
                    int i10 = oVar.f13578k;
                    ((q) this.f10329w.g).getClass();
                    bVar = new b(i10, System.currentTimeMillis());
                    this.f10330x.put(g, bVar);
                }
                max = (Math.max((oVar.f13578k - bVar.f10319a) - 5, 0) * 30000) + bVar.f10320b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return max;
    }
}
