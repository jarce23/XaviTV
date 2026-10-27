package y4;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: q, reason: collision with root package name */
    public static final String f13821q = o4.p.f("EnqueueRunnable");

    /* renamed from: o, reason: collision with root package name */
    public final p4.m f13822o;

    /* renamed from: p, reason: collision with root package name */
    public final x4.r f13823p;

    public c(p4.m mVar) {
        x4.r rVar = new x4.r(12);
        this.f13822o = mVar;
        this.f13823p = rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x032c  */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(p4.m r59) {
        /*
            Method dump skipped, instructions count: 918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.a(p4.m):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        x4.r rVar = this.f13823p;
        p4.m mVar = this.f13822o;
        try {
            mVar.getClass();
            p4.r rVar2 = mVar.f9941q;
            HashSet hashSet = new HashSet();
            hashSet.addAll(mVar.f9945u);
            HashSet C = p4.m.C(mVar);
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.removeAll(mVar.f9945u);
                    z10 = false;
                    break;
                } else if (C.contains((String) it.next())) {
                    z10 = true;
                    break;
                }
            }
            if (z10) {
                throw new IllegalStateException("WorkContinuation has cycles (" + mVar + ")");
            }
            WorkDatabase workDatabase = rVar2.f9959c;
            workDatabase.c();
            try {
                n4.a.d(workDatabase, rVar2.f9958b, mVar);
                boolean a10 = a(mVar);
                workDatabase.o();
                if (a10) {
                    k.a(rVar2.f9957a, RescheduleReceiver.class, true);
                    p4.k.b(rVar2.f9958b, rVar2.f9959c, rVar2.f9961e);
                }
                rVar.k(o4.v.f9518l);
            } finally {
                workDatabase.k();
            }
        } catch (Throwable th) {
            rVar.k(new o4.s(th));
        }
    }
}
