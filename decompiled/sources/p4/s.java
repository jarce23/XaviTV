package p4;

import android.content.Context;
import android.database.Cursor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.LinkedList;
import m.d3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements Runnable {
    public static final String F = o4.p.f("WorkerWrapper");
    public final ArrayList A;
    public String B;

    /* renamed from: o, reason: collision with root package name */
    public final Context f9966o;

    /* renamed from: p, reason: collision with root package name */
    public final String f9967p;

    /* renamed from: q, reason: collision with root package name */
    public final x4.o f9968q;

    /* renamed from: r, reason: collision with root package name */
    public o4.o f9969r;

    /* renamed from: s, reason: collision with root package name */
    public final x4.i f9970s;

    /* renamed from: u, reason: collision with root package name */
    public final o4.a f9972u;

    /* renamed from: v, reason: collision with root package name */
    public final o4.q f9973v;

    /* renamed from: w, reason: collision with root package name */
    public final f f9974w;

    /* renamed from: x, reason: collision with root package name */
    public final WorkDatabase f9975x;

    /* renamed from: y, reason: collision with root package name */
    public final x4.p f9976y;

    /* renamed from: z, reason: collision with root package name */
    public final x4.c f9977z;

    /* renamed from: t, reason: collision with root package name */
    public o4.n f9971t = new o4.k();
    public final z4.j C = new z4.j();
    public final z4.j D = new z4.j();
    public volatile int E = -256;

    public s(d3 d3Var) {
        this.f9966o = (Context) d3Var.f8398o;
        this.f9970s = (x4.i) d3Var.f8400q;
        this.f9974w = (f) d3Var.f8399p;
        x4.o oVar = (x4.o) d3Var.f8403t;
        this.f9968q = oVar;
        this.f9967p = oVar.f13569a;
        this.f9969r = null;
        o4.a aVar = (o4.a) d3Var.f8401r;
        this.f9972u = aVar;
        this.f9973v = (o4.q) aVar.g;
        WorkDatabase workDatabase = (WorkDatabase) d3Var.f8402s;
        this.f9975x = workDatabase;
        this.f9976y = workDatabase.t();
        this.f9977z = workDatabase.f();
        this.A = (ArrayList) d3Var.f8404u;
    }

    public final void a(o4.n nVar) {
        boolean z10 = nVar instanceof o4.m;
        x4.o oVar = this.f9968q;
        String str = F;
        if (!z10) {
            if (nVar instanceof o4.l) {
                o4.p.d().e(str, "Worker result RETRY for " + this.B);
                c();
                return;
            }
            o4.p.d().e(str, "Worker result FAILURE for " + this.B);
            if (oVar.c()) {
                d();
                return;
            } else {
                g();
                return;
            }
        }
        o4.p.d().e(str, "Worker result SUCCESS for " + this.B);
        if (oVar.c()) {
            d();
            return;
        }
        x4.c cVar = this.f9977z;
        String str2 = this.f9967p;
        x4.p pVar = this.f9976y;
        WorkDatabase workDatabase = this.f9975x;
        workDatabase.c();
        try {
            pVar.o(3, str2);
            pVar.n(str2, ((o4.m) this.f9971t).f9505a);
            this.f9973v.getClass();
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList S = cVar.S(str2);
            int size = S.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = S.get(i10);
                i10++;
                String str3 = (String) obj;
                if (pVar.g(str3) == 5) {
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) cVar.f13537p;
                    c4.m a10 = c4.m.a(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
                    if (str3 == null) {
                        a10.o(1);
                    } else {
                        a10.j(1, str3);
                    }
                    workDatabase_Impl.b();
                    Cursor m10 = workDatabase_Impl.m(a10);
                    try {
                        if (m10.moveToFirst() && m10.getInt(0) != 0) {
                            o4.p.d().e(str, "Setting status to enqueued for " + str3);
                            pVar.o(1, str3);
                            pVar.m(currentTimeMillis, str3);
                        }
                    } finally {
                        m10.close();
                        a10.s();
                    }
                }
            }
            workDatabase.o();
            workDatabase.k();
            e(false);
        } catch (Throwable th) {
            workDatabase.k();
            e(false);
            throw th;
        }
    }

    public final void b() {
        if (h()) {
            return;
        }
        this.f9975x.c();
        try {
            int g = this.f9976y.g(this.f9967p);
            x4.m s10 = this.f9975x.s();
            String str = this.f9967p;
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) s10.f13564p;
            workDatabase_Impl.b();
            x4.h hVar = (x4.h) s10.f13565q;
            h4.i a10 = hVar.a();
            if (str == null) {
                a10.o(1);
            } else {
                a10.j(1, str);
            }
            workDatabase_Impl.c();
            try {
                a10.a();
                workDatabase_Impl.o();
                if (g == 0) {
                    e(false);
                } else if (g == 2) {
                    a(this.f9971t);
                } else if (!android.support.v4.media.d.c(g)) {
                    this.E = -512;
                    c();
                }
                this.f9975x.o();
                this.f9975x.k();
            } finally {
                workDatabase_Impl.k();
                hVar.d(a10);
            }
        } catch (Throwable th) {
            this.f9975x.k();
            throw th;
        }
    }

    public final void c() {
        String str = this.f9967p;
        x4.p pVar = this.f9976y;
        WorkDatabase workDatabase = this.f9975x;
        workDatabase.c();
        try {
            pVar.o(1, str);
            this.f9973v.getClass();
            pVar.m(System.currentTimeMillis(), str);
            pVar.l(this.f9968q.f13589v, str);
            pVar.k(-1L, str);
            workDatabase.o();
        } finally {
            workDatabase.k();
            e(true);
        }
    }

    public final void d() {
        String str = this.f9967p;
        x4.p pVar = this.f9976y;
        WorkDatabase workDatabase = this.f9975x;
        workDatabase.c();
        try {
            this.f9973v.getClass();
            pVar.m(System.currentTimeMillis(), str);
            WorkDatabase_Impl workDatabase_Impl = pVar.f13591a;
            pVar.o(1, str);
            workDatabase_Impl.b();
            x4.h hVar = pVar.f13599j;
            h4.i a10 = hVar.a();
            if (str == null) {
                a10.o(1);
            } else {
                a10.j(1, str);
            }
            workDatabase_Impl.c();
            try {
                a10.a();
                workDatabase_Impl.o();
                workDatabase_Impl.k();
                hVar.d(a10);
                pVar.l(this.f9968q.f13589v, str);
                workDatabase_Impl.b();
                x4.h hVar2 = pVar.f13596f;
                h4.i a11 = hVar2.a();
                if (str == null) {
                    a11.o(1);
                } else {
                    a11.j(1, str);
                }
                workDatabase_Impl.c();
                try {
                    a11.a();
                    workDatabase_Impl.o();
                    workDatabase_Impl.k();
                    hVar2.d(a11);
                    pVar.k(-1L, str);
                    workDatabase.o();
                } catch (Throwable th) {
                    workDatabase_Impl.k();
                    hVar2.d(a11);
                    throw th;
                }
            } catch (Throwable th2) {
                workDatabase_Impl.k();
                hVar.d(a10);
                throw th2;
            }
        } finally {
            workDatabase.k();
            e(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0005, B:10:0x0030, B:12:0x0038, B:14:0x0044, B:15:0x005d, B:22:0x0071, B:23:0x0077, B:5:0x001e, B:7:0x0025), top: B:2:0x0005, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0005, B:10:0x0030, B:12:0x0038, B:14:0x0044, B:15:0x005d, B:22:0x0071, B:23:0x0077, B:5:0x001e, B:7:0x0025), top: B:2:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(boolean r6) {
        /*
            r5 = this;
            androidx.work.impl.WorkDatabase r0 = r5.f9975x
            r0.c()
            androidx.work.impl.WorkDatabase r0 = r5.f9975x     // Catch: java.lang.Throwable -> L40
            x4.p r0 = r0.t()     // Catch: java.lang.Throwable -> L40
            r0.getClass()     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"
            r2 = 0
            c4.m r1 = c4.m.a(r2, r1)     // Catch: java.lang.Throwable -> L40
            androidx.work.impl.WorkDatabase_Impl r0 = r0.f13591a     // Catch: java.lang.Throwable -> L40
            r0.b()     // Catch: java.lang.Throwable -> L40
            android.database.Cursor r0 = r0.m(r1)     // Catch: java.lang.Throwable -> L40
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2d
            r4 = 1
            if (r3 == 0) goto L2f
            int r3 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L2f
            r3 = r4
            goto L30
        L2d:
            r6 = move-exception
            goto L71
        L2f:
            r3 = r2
        L30:
            r0.close()     // Catch: java.lang.Throwable -> L40
            r1.s()     // Catch: java.lang.Throwable -> L40
            if (r3 != 0) goto L42
            android.content.Context r0 = r5.f9966o     // Catch: java.lang.Throwable -> L40
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r1 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            y4.k.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L40
            goto L42
        L40:
            r6 = move-exception
            goto L78
        L42:
            if (r6 == 0) goto L5d
            x4.p r0 = r5.f9976y     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r5.f9967p     // Catch: java.lang.Throwable -> L40
            r0.o(r4, r1)     // Catch: java.lang.Throwable -> L40
            x4.p r0 = r5.f9976y     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r5.f9967p     // Catch: java.lang.Throwable -> L40
            int r2 = r5.E     // Catch: java.lang.Throwable -> L40
            r0.p(r2, r1)     // Catch: java.lang.Throwable -> L40
            x4.p r0 = r5.f9976y     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r5.f9967p     // Catch: java.lang.Throwable -> L40
            r2 = -1
            r0.k(r2, r1)     // Catch: java.lang.Throwable -> L40
        L5d:
            androidx.work.impl.WorkDatabase r0 = r5.f9975x     // Catch: java.lang.Throwable -> L40
            r0.o()     // Catch: java.lang.Throwable -> L40
            androidx.work.impl.WorkDatabase r0 = r5.f9975x
            r0.k()
            z4.j r0 = r5.C
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r0.i(r6)
            return
        L71:
            r0.close()     // Catch: java.lang.Throwable -> L40
            r1.s()     // Catch: java.lang.Throwable -> L40
            throw r6     // Catch: java.lang.Throwable -> L40
        L78:
            androidx.work.impl.WorkDatabase r0 = r5.f9975x
            r0.k()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.s.e(boolean):void");
    }

    public final void f() {
        x4.p pVar = this.f9976y;
        String str = this.f9967p;
        int g = pVar.g(str);
        String str2 = F;
        if (g == 2) {
            o4.p.d().a(str2, "Status for " + str + " is RUNNING; not doing any work and rescheduling for later execution");
            e(true);
            return;
        }
        o4.p d6 = o4.p.d();
        StringBuilder s10 = android.support.v4.media.d.s("Status for ", str, " is ");
        s10.append(android.support.v4.media.d.D(g));
        s10.append(" ; not doing any work");
        d6.a(str2, s10.toString());
        e(false);
    }

    public final void g() {
        String str = this.f9967p;
        WorkDatabase workDatabase = this.f9975x;
        workDatabase.c();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean isEmpty = linkedList.isEmpty();
                x4.p pVar = this.f9976y;
                if (isEmpty) {
                    o4.f fVar = ((o4.k) this.f9971t).f9504a;
                    pVar.l(this.f9968q.f13589v, str);
                    pVar.n(str, fVar);
                    workDatabase.o();
                    return;
                }
                String str2 = (String) linkedList.remove();
                if (pVar.g(str2) != 6) {
                    pVar.o(4, str2);
                }
                linkedList.addAll(this.f9977z.S(str2));
            }
        } finally {
            workDatabase.k();
            e(false);
        }
    }

    public final boolean h() {
        if (this.E == -256) {
            return false;
        }
        o4.p.d().a(F, "Work interrupted for " + this.B);
        if (this.f9976y.g(this.f9967p) == 0) {
            e(false);
            return true;
        }
        e(!android.support.v4.media.d.c(r0));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
    
        if ((r4.f13570b == 1 && r4.f13578k > 0) != false) goto L30;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.s.run():void");
    }
}
