package y4;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final x4.r f13817o = new x4.r(12);

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f13818p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ p4.r f13819q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f13820r;

    public b(p4.r rVar, Object obj, int i10) {
        this.f13818p = i10;
        this.f13819q = rVar;
        this.f13820r = obj;
    }

    public static void a(p4.r rVar, String str) {
        p4.s b2;
        WorkDatabase workDatabase = rVar.f9959c;
        x4.p t3 = workDatabase.t();
        x4.c f10 = workDatabase.f();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            int g = t3.g(str2);
            if (g != 3 && g != 4) {
                WorkDatabase_Impl workDatabase_Impl = t3.f13591a;
                workDatabase_Impl.b();
                x4.h hVar = t3.f13595e;
                h4.i a10 = hVar.a();
                if (str2 == null) {
                    a10.o(1);
                } else {
                    a10.j(1, str2);
                }
                workDatabase_Impl.c();
                try {
                    a10.a();
                    workDatabase_Impl.o();
                } finally {
                    workDatabase_Impl.k();
                    hVar.d(a10);
                }
            }
            linkedList.addAll(f10.S(str2));
        }
        p4.f fVar = rVar.f9962f;
        synchronized (fVar.f9926k) {
            o4.p.d().a(p4.f.f9916l, "Processor cancelling " + str);
            fVar.f9924i.add(str);
            b2 = fVar.b(str);
        }
        p4.f.e(str, b2, 1);
        Iterator it = rVar.f9961e.iterator();
        while (it.hasNext()) {
            ((p4.h) it.next()).c(str);
        }
    }

    public final void b() {
        WorkDatabase workDatabase;
        switch (this.f13818p) {
            case 0:
                p4.r rVar = this.f13819q;
                workDatabase = rVar.f9959c;
                workDatabase.c();
                try {
                    a(rVar, ((UUID) this.f13820r).toString());
                    workDatabase.o();
                    workDatabase.k();
                    p4.k.b(rVar.f9958b, rVar.f9959c, rVar.f9961e);
                    return;
                } finally {
                    workDatabase.k();
                }
            default:
                p4.r rVar2 = this.f13819q;
                workDatabase = rVar2.f9959c;
                workDatabase.c();
                try {
                    ArrayList h10 = workDatabase.t().h((String) this.f13820r);
                    int size = h10.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = h10.get(i10);
                        i10++;
                        a(rVar2, (String) obj);
                    }
                    workDatabase.o();
                    return;
                } catch (Throwable th) {
                    throw th;
                }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        x4.r rVar = this.f13817o;
        try {
            b();
            rVar.k(o4.v.f9518l);
        } catch (Throwable th) {
            rVar.k(new o4.s(th));
        }
    }
}
