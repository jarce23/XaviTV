package androidx.activity;

import android.content.Context;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.WorkerParameters;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import ib.h0;
import java.util.Locale;
import l1.a0;
import s1.b1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f288o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f289p;

    public /* synthetic */ d(int i10, Object obj) {
        this.f288o = i10;
        this.f289p = obj;
    }

    private final void a() {
        ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f289p;
        if (constraintTrackingWorker.f1559v.f14111o instanceof z4.a) {
            return;
        }
        Object obj = constraintTrackingWorker.f9507p.f1519b.f9498a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        String str = obj instanceof String ? (String) obj : null;
        o4.p d6 = o4.p.d();
        za.h.d("get()", d6);
        if (str == null || str.length() == 0) {
            d6.b(b5.a.f2473a, "No worker to delegate to.");
            z4.j jVar = constraintTrackingWorker.f1559v;
            za.h.d("future", jVar);
            jVar.i(new o4.k());
            return;
        }
        o4.x xVar = constraintTrackingWorker.f9507p.f1522e;
        Context context = constraintTrackingWorker.f9506o;
        WorkerParameters workerParameters = constraintTrackingWorker.f1556s;
        xVar.getClass();
        o4.o a10 = o4.x.a(context, str, workerParameters);
        constraintTrackingWorker.f1560w = a10;
        if (a10 == null) {
            d6.a(b5.a.f2473a, "No worker to delegate to.");
            z4.j jVar2 = constraintTrackingWorker.f1559v;
            za.h.d("future", jVar2);
            jVar2.i(new o4.k());
            return;
        }
        p4.r b2 = p4.r.b(constraintTrackingWorker.f9506o);
        x4.p t3 = b2.f9959c.t();
        String uuid = constraintTrackingWorker.f9507p.f1518a.toString();
        za.h.d("id.toString()", uuid);
        x4.o i10 = t3.i(uuid);
        if (i10 == null) {
            z4.j jVar3 = constraintTrackingWorker.f1559v;
            za.h.d("future", jVar3);
            String str2 = b5.a.f2473a;
            jVar3.i(new o4.k());
            return;
        }
        x4.i iVar = b2.f9965j;
        za.h.d("workManagerImpl.trackers", iVar);
        a3.f fVar = new a3.f(iVar);
        h0 h0Var = (h0) b2.f9960d.f13554q;
        za.h.d("workManagerImpl.workTask…r.taskCoroutineDispatcher", h0Var);
        constraintTrackingWorker.f1559v.a(new d(8, t4.h.a(fVar, i10, h0Var, constraintTrackingWorker)), new f.p(4));
        if (!fVar.b(i10)) {
            d6.a(b5.a.f2473a, "Constraints not met for delegate " + str + ". Requesting retry.");
            z4.j jVar4 = constraintTrackingWorker.f1559v;
            za.h.d("future", jVar4);
            jVar4.i(new o4.l());
            return;
        }
        d6.a(b5.a.f2473a, "Constraints met for delegate ".concat(str));
        try {
            o4.o oVar = constraintTrackingWorker.f1560w;
            za.h.b(oVar);
            z4.j c10 = oVar.c();
            za.h.d("delegate!!.startWork()", c10);
            c10.a(new androidx.fragment.app.d(constraintTrackingWorker, 1, c10), constraintTrackingWorker.f9507p.f1520c);
        } catch (Throwable th) {
            String str3 = b5.a.f2473a;
            String q10 = android.support.v4.media.d.q("Delegated worker ", str, " threw exception in startWork.");
            if (d6.f9512a <= 3) {
                Log.d(str3, q10, th);
            }
            synchronized (constraintTrackingWorker.f1557t) {
                try {
                    if (!constraintTrackingWorker.f1558u) {
                        z4.j jVar5 = constraintTrackingWorker.f1559v;
                        za.h.d("future", jVar5);
                        jVar5.i(new o4.k());
                    } else {
                        d6.a(str3, "Constraints were unmet, Retrying.");
                        z4.j jVar6 = constraintTrackingWorker.f1559v;
                        za.h.d("future", jVar6);
                        jVar6.i(new o4.l());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private final void b() {
        String D;
        TelephonyManager telephonyManager;
        l1.r rVar = (l1.r) this.f289p;
        g2.f fVar = (g2.f) rVar.f8117a.get();
        if (fVar != null) {
            int b2 = rVar.f8119c.b();
            g2.g gVar = fVar.f5093a;
            synchronized (gVar) {
                int i10 = gVar.f5113n;
                if (i10 == 0 || gVar.f5105e) {
                    if (i10 != b2 || gVar.f5114o == null) {
                        gVar.f5113n = b2;
                        if (b2 != 1 && b2 != 0 && b2 != 8) {
                            if (gVar.f5114o == null) {
                                Context context = gVar.f5101a;
                                int i11 = a0.f8067a;
                                if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                                    if (!TextUtils.isEmpty(networkCountryIso)) {
                                        D = com.bumptech.glide.c.D(networkCountryIso);
                                        gVar.f5114o = D;
                                    }
                                }
                                D = com.bumptech.glide.c.D(Locale.getDefault().getCountry());
                                gVar.f5114o = D;
                            }
                            gVar.f5111l = gVar.a(b2);
                            gVar.f5104d.getClass();
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            gVar.b(gVar.g > 0 ? (int) (elapsedRealtime - gVar.f5107h) : 0, gVar.f5108i, gVar.f5111l);
                            gVar.f5107h = elapsedRealtime;
                            gVar.f5108i = 0L;
                            gVar.f5110k = 0L;
                            gVar.f5109j = 0L;
                            g2.r rVar2 = gVar.f5106f;
                            rVar2.f5143a.clear();
                            rVar2.f5145c = -1;
                            rVar2.f5146d = 0;
                            rVar2.f5147e = 0;
                        }
                    }
                }
            }
        }
    }

    private final void c() {
        b1 b1Var = (b1) this.f289p;
        try {
            synchronized (b1Var) {
            }
            try {
                b1Var.f11224a.c(b1Var.f11226c, b1Var.f11227d);
            } finally {
                b1Var.a(true);
            }
        } catch (s1.l e7) {
            l1.b.h("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e7);
            throw new RuntimeException(e7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e1  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.d.run():void");
    }

    public /* synthetic */ d(s1.h0 h0Var, b1 b1Var) {
        this.f288o = 23;
        this.f289p = b1Var;
    }
}
