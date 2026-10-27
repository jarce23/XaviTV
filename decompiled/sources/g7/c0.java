package g7;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import com.google.android.play.core.assetpacks.bs;
import j9.u0;
import j9.x1;
import java.util.HashMap;
import m0.t0;
import m0.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5188o;

    /* renamed from: p, reason: collision with root package name */
    public Object f5189p;

    /* renamed from: q, reason: collision with root package name */
    public Object f5190q;

    /* renamed from: r, reason: collision with root package name */
    public Object f5191r;

    public /* synthetic */ c0() {
        this.f5188o = 1;
    }

    private final void a() {
        f fVar;
        synchronized (((l7.w) this.f5189p).D) {
            fVar = (f) ((l7.w) this.f5189p).D.get((String) this.f5190q);
        }
        if (fVar != null) {
            ((i7.h) fVar).n((String) this.f5191r);
        } else {
            l7.w.T.b("Discarded message for unknown namespace '%s'", (String) this.f5190q);
        }
    }

    private final void b() {
        m5.k kVar;
        ((m5.i) this.f5189p).i();
        c4.e eVar = (c4.e) this.f5190q;
        if (((m5.m) eVar.f2878r) == null) {
            ((m5.i) this.f5189p).b(eVar.f2876p);
        } else {
            m5.i iVar = (m5.i) this.f5189p;
            synchronized (iVar.f8978s) {
                kVar = iVar.f8979t;
            }
            if (kVar != null) {
                kVar.g();
            }
        }
        if (((c4.e) this.f5190q).f2875o) {
            ((m5.i) this.f5189p).a("intermediate-response");
        } else {
            ((m5.i) this.f5189p).c("done");
        }
        Runnable runnable = (Runnable) this.f5191r;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        f fVar;
        int i10 = 9;
        boolean z10 = false;
        switch (this.f5188o) {
            case 0:
                d0 d0Var = (d0) this.f5189p;
                HashMap hashMap = d0Var.f5201c.C;
                String str = (String) this.f5190q;
                synchronized (hashMap) {
                    fVar = (f) d0Var.f5201c.C.get(str);
                }
                if (fVar != null) {
                    ((i7.h) fVar).n((String) this.f5191r);
                    return;
                } else {
                    e0.G.b("Discarded message for unknown namespace '%s'", str);
                    return;
                }
            case 1:
                try {
                    obj = ((j0.e) this.f5189p).call();
                } catch (Exception unused) {
                    obj = null;
                }
                ((Handler) this.f5191r).post(new app.shamel.tv.activities.y((j0.f) this.f5190q, obj, 17, z10));
                return;
            case 2:
                j9.m mVar = (j9.m) this.f5189p;
                Bundle bundle = (Bundle) this.f5190q;
                bs bsVar = (bs) this.f5191r;
                u0 u0Var = mVar.g;
                u0Var.getClass();
                if (((Boolean) u0Var.b(new x4.e(u0Var, i10, bundle))).booleanValue()) {
                    mVar.f7367l.post(new androidx.activity.j(mVar, bsVar, 21));
                    ((x1) mVar.f7368m.c()).f();
                    return;
                }
                return;
            case 3:
                j9.f0 f0Var = (j9.f0) this.f5189p;
                Bundle bundle2 = (Bundle) this.f5190q;
                bs bsVar2 = (bs) this.f5191r;
                u0 u0Var2 = f0Var.f7267a;
                u0Var2.getClass();
                if (((Boolean) u0Var2.b(new x4.e(u0Var2, i10, bundle2))).booleanValue()) {
                    j9.o oVar = f0Var.f7271e;
                    oVar.getClass();
                    oVar.f7398b.post(new androidx.activity.j(oVar, bsVar2, 22));
                    ((x1) f0Var.g.c()).f();
                    return;
                }
                return;
            case 4:
                a();
                return;
            case 5:
                t0.h((View) this.f5189p, (x4.e) this.f5190q);
                ((ValueAnimator) this.f5191r).start();
                return;
            case 6:
                b();
                return;
            case 7:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f5191r;
                Context context = (Context) this.f5190q;
                Intent intent = (Intent) this.f5189p;
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    o4.p.d().a(ConstraintProxyUpdateReceiver.f1539a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                    y4.k.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    y4.k.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    y4.k.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    y4.k.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            default:
                ((p4.f) this.f5189p).j((p4.l) this.f5190q, (x4.c) this.f5191r);
                return;
        }
    }

    public /* synthetic */ c0(Object obj, Object obj2, Object obj3, int i10) {
        this.f5188o = i10;
        this.f5189p = obj;
        this.f5190q = obj2;
        this.f5191r = obj3;
    }

    public c0(p4.f fVar, p4.l lVar, x4.c cVar) {
        this.f5188o = 8;
        za.h.e("processor", fVar);
        this.f5189p = fVar;
        this.f5190q = lVar;
        this.f5191r = cVar;
    }

    public c0(View view, x0 x0Var, x4.e eVar, ValueAnimator valueAnimator) {
        this.f5188o = 5;
        this.f5189p = view;
        this.f5190q = eVar;
        this.f5191r = valueAnimator;
    }
}
