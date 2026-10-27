package app.shamel.tv.activities;

import android.app.Application;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.work.Worker;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import com.google.android.material.behavior.SwipeDismissBehavior;
import io.realm.exceptions.RealmException;
import j9.e1;
import j9.f1;
import j9.m1;
import j9.n1;
import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2075o;

    /* renamed from: p, reason: collision with root package name */
    public Object f2076p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f2077q;

    public /* synthetic */ y(Object obj, int i10, Object obj2) {
        this.f2075o = i10;
        this.f2077q = obj;
        this.f2076p = obj2;
    }

    private final void a() {
        i8.g gVar = (i8.g) this.f2077q;
        synchronized (gVar.f6527c) {
            i8.b bVar = (i8.b) gVar.f6528d;
            Exception k10 = ((i8.i) this.f2076p).k();
            r7.r.e(k10);
            bVar.w(k10);
        }
    }

    private final void b() {
        i8.g gVar = (i8.g) this.f2077q;
        synchronized (gVar.f6527c) {
            ((i8.c) gVar.f6528d).l(((i8.i) this.f2076p).l());
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i10 = 0;
        switch (this.f2075o) {
            case 0:
                LiveActivity liveActivity = (LiveActivity) this.f2077q;
                int i11 = liveActivity.f1646a0;
                if (i11 == 0) {
                    liveActivity.A((String) this.f2076p);
                    return;
                } else {
                    liveActivity.f1646a0 = i11 - 1;
                    liveActivity.f1667l1.postAtTime(liveActivity.Z, SystemClock.uptimeMillis() + 500);
                    return;
                }
            case 1:
                LiveChannelActivity liveChannelActivity = (LiveChannelActivity) this.f2077q;
                int i12 = liveChannelActivity.Z;
                if (i12 == 0) {
                    liveChannelActivity.z((String) this.f2076p);
                    return;
                } else {
                    liveChannelActivity.Z = i12 - 1;
                    liveChannelActivity.f1701i1.postAtTime(liveChannelActivity.Y, SystemClock.uptimeMillis() + 500);
                    return;
                }
            case 2:
                ((b0.a) this.f2076p).f2122o = this.f2077q;
                return;
            case 3:
                ((Application) this.f2076p).unregisterActivityLifecycleCallbacks((b0.a) this.f2077q);
                return;
            case 4:
                Object obj = this.f2077q;
                Object obj2 = this.f2076p;
                try {
                    Method method = b0.b.f2131d;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        b0.b.f2132e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e7) {
                    if (e7.getClass() == RuntimeException.class && e7.getMessage() != null && e7.getMessage().startsWith("Unable to stop")) {
                        throw e7;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 5:
                LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) this.f2077q;
                int i13 = liveChannelMobileActivity.f1933m0;
                if (i13 == 0) {
                    LiveChannelMobileActivity.u(liveChannelMobileActivity, (String) this.f2076p);
                    return;
                } else {
                    liveChannelMobileActivity.f1933m0 = i13 - 1;
                    liveChannelMobileActivity.W0.postAtTime(liveChannelMobileActivity.f1931k0, SystemClock.uptimeMillis() + 500);
                    return;
                }
            case 6:
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) this.f2077q;
                int i14 = liveMobileActivity.f1968m0;
                if (i14 == 0) {
                    LiveMobileActivity.u(liveMobileActivity, (String) this.f2076p);
                    return;
                } else {
                    liveMobileActivity.f1968m0 = i14 - 1;
                    liveMobileActivity.X0.postAtTime(liveMobileActivity.f1967l0, SystemClock.uptimeMillis() + 500);
                    return;
                }
            case 7:
                a6.b0 a10 = a6.b0.a();
                a10.getClass();
                m6.n.a();
                a10.f45d.set(true);
                ((com.bumptech.glide.manager.d) this.f2077q).f3068p.f3070p = true;
                ((com.bumptech.glide.manager.d) this.f2077q).f3067o.getViewTreeObserver().removeOnDrawListener((com.bumptech.glide.manager.d) this.f2076p);
                ((com.bumptech.glide.manager.d) this.f2077q).f3068p.f3069o.clear();
                return;
            case 8:
                ((com.google.android.gms.internal.cast.q) this.f2076p).A0((w3.o) this.f2077q);
                return;
            case 9:
                g7.e0 e0Var = ((g7.d0) this.f2076p).f5201c;
                l7.e eVar = (l7.e) this.f2077q;
                l7.b bVar = g7.e0.G;
                g7.d dVar = eVar.f8279r;
                g7.x xVar = eVar.f8281t;
                g7.d dVar2 = e0Var.f5215t;
                h7.h0 h0Var = e0Var.D;
                if (!l7.a.d(dVar, dVar2)) {
                    e0Var.f5215t = dVar;
                    h0Var.c();
                }
                double d6 = eVar.f8276o;
                if (Double.isNaN(d6) || Math.abs(d6 - e0Var.f5217v) <= 1.0E-7d) {
                    z10 = false;
                } else {
                    e0Var.f5217v = d6;
                    z10 = true;
                }
                boolean z18 = eVar.f8277p;
                if (z18 != e0Var.f5218w) {
                    e0Var.f5218w = z18;
                    z10 = true;
                }
                l7.b bVar2 = g7.e0.G;
                bVar2.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(e0Var.f5208m));
                if (h0Var != null && (z10 || e0Var.f5208m)) {
                    h0Var.f();
                }
                Double.isNaN(eVar.f8282u);
                int i15 = eVar.f8278q;
                if (i15 != e0Var.f5219x) {
                    e0Var.f5219x = i15;
                    z11 = true;
                } else {
                    z11 = false;
                }
                bVar2.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(e0Var.f5208m));
                if (h0Var != null && (z11 || e0Var.f5208m)) {
                    h0Var.a();
                }
                int i16 = eVar.f8280s;
                if (i16 != e0Var.f5220y) {
                    e0Var.f5220y = i16;
                    z12 = true;
                } else {
                    z12 = false;
                }
                bVar2.b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(e0Var.f5208m));
                if (h0Var != null && (z12 || e0Var.f5208m)) {
                    h0Var.e();
                }
                if (!l7.a.d(e0Var.f5221z, xVar)) {
                    e0Var.f5221z = xVar;
                }
                e0Var.f5208m = false;
                return;
            case 10:
                g7.e0 e0Var2 = ((g7.d0) this.f2076p).f5201c;
                l7.c cVar = (l7.c) this.f2077q;
                l7.b bVar3 = g7.e0.G;
                String str = cVar.f8274o;
                if (l7.a.d(str, e0Var2.f5216u)) {
                    z13 = false;
                } else {
                    e0Var2.f5216u = str;
                    z13 = true;
                }
                g7.e0.G.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z13), Boolean.valueOf(e0Var2.f5209n));
                h7.h0 h0Var2 = e0Var2.D;
                if (h0Var2 != null && (z13 || e0Var2.f5209n)) {
                    h0Var2.d();
                }
                e0Var2.f5209n = false;
                return;
            case 11:
                i8.g gVar = (i8.g) this.f2077q;
                synchronized (gVar.f6527c) {
                    ((i8.a) gVar.f6528d).z((i8.i) this.f2076p);
                }
                return;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                a();
                return;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                b();
                return;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                io.realm.s sVar = (io.realm.s) this.f2077q;
                androidx.fragment.app.v0 v0Var = sVar.f6823r;
                io.realm.u uVar = sVar.f6825t;
                if (uVar.isClosed()) {
                    v0Var.j();
                    return;
                }
                io.realm.internal.t versionID = uVar.f6647s.getVersionID();
                io.realm.internal.t tVar = (io.realm.internal.t) this.f2076p;
                long j10 = versionID.f6768o;
                long j11 = tVar.f6768o;
                if (j10 <= j11 && j10 < j11) {
                    uVar.f6647s.realmNotifier.addTransactionCallback(new androidx.activity.j(19, this));
                    return;
                } else {
                    v0Var.j();
                    return;
                }
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((io.realm.s) this.f2077q).getClass();
                throw new RealmException("Async transaction failed", (Throwable) this.f2076p);
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                a6.n nVar = (a6.n) this.f2076p;
                Typeface typeface = (Typeface) this.f2077q;
                d0.b bVar4 = (d0.b) nVar.f74p;
                if (bVar4 != null) {
                    bVar4.j(typeface);
                    return;
                }
                return;
            case 17:
                ((j0.f) this.f2076p).accept(this.f2077q);
                return;
            case 18:
                j9.m mVar = (j9.m) this.f2076p;
                Bundle bundle = (Bundle) this.f2077q;
                j9.u0 u0Var = mVar.g;
                u0Var.getClass();
                if (((Boolean) u0Var.b(new x4.c(u0Var, 9, bundle))).booleanValue()) {
                    mVar.f7363h.a();
                    return;
                }
                return;
            case 19:
                ((j9.y0) this.f2076p).f7492b.b((Intent) this.f2077q);
                return;
            case 20:
                f1 f1Var = (f1) this.f2076p;
                e1 e1Var = (e1) this.f2077q;
                f1Var.f7274a.a(e1Var.f7260c, e1Var.f7474b, e1Var.f7261d);
                return;
            case 21:
                n1 n1Var = (n1) this.f2076p;
                m1 m1Var = (m1) this.f2077q;
                n1Var.f7392a.a(m1Var.f7379d, m1Var.f7474b, m1Var.f7380e);
                return;
            case 22:
                l7.w wVar = (l7.w) this.f2076p;
                l7.e eVar2 = (l7.e) this.f2077q;
                l7.b bVar5 = l7.w.T;
                g7.d dVar3 = eVar2.f8279r;
                g7.x xVar2 = eVar2.f8281t;
                g7.d dVar4 = wVar.A;
                h7.h0 h0Var3 = wVar.C;
                if (!l7.a.d(dVar3, dVar4)) {
                    wVar.A = dVar3;
                    h0Var3.c();
                }
                double d10 = eVar2.f8276o;
                if (Double.isNaN(d10) || Math.abs(d10 - wVar.L) <= 1.0E-7d) {
                    z14 = false;
                } else {
                    wVar.L = d10;
                    z14 = true;
                }
                boolean z19 = eVar2.f8277p;
                if (z19 != wVar.I) {
                    wVar.I = z19;
                    z14 = true;
                }
                Double.isNaN(eVar2.f8282u);
                l7.b bVar6 = l7.w.T;
                bVar6.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z14), Boolean.valueOf(wVar.K));
                if (h0Var3 != null && (z14 || wVar.K)) {
                    h0Var3.f();
                }
                int i17 = eVar2.f8278q;
                if (i17 != wVar.N) {
                    wVar.N = i17;
                    z15 = true;
                } else {
                    z15 = false;
                }
                bVar6.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z15), Boolean.valueOf(wVar.K));
                if (h0Var3 != null && (z15 || wVar.K)) {
                    h0Var3.a();
                }
                int i18 = eVar2.f8280s;
                if (i18 != wVar.O) {
                    wVar.O = i18;
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar6.b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z16), Boolean.valueOf(wVar.K));
                if (h0Var3 != null && (z16 || wVar.K)) {
                    h0Var3.e();
                }
                if (!l7.a.d(wVar.M, xVar2)) {
                    wVar.M = xVar2;
                }
                wVar.K = false;
                return;
            case 23:
                l7.w wVar2 = (l7.w) this.f2076p;
                l7.c cVar2 = (l7.c) this.f2077q;
                l7.b bVar7 = l7.w.T;
                String str2 = cVar2.f8274o;
                if (l7.a.d(str2, wVar2.H)) {
                    z17 = false;
                } else {
                    wVar2.H = str2;
                    z17 = true;
                }
                l7.w.T.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z17), Boolean.valueOf(wVar2.J));
                h7.h0 h0Var4 = wVar2.C;
                if (h0Var4 != null && (z17 || wVar2.J)) {
                    h0Var4.d();
                }
                wVar2.J = false;
                return;
            case 24:
                try {
                    ((m5.c) this.f2077q).f8959p.put((m5.i) this.f2076p);
                    return;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            case 25:
                s0.d dVar5 = ((SwipeDismissBehavior) this.f2077q).f3674a;
                if (dVar5 == null || !dVar5.f()) {
                    return;
                }
                ((View) this.f2076p).postOnAnimation(this);
                return;
            case 26:
                nb.i iVar = (nb.i) this.f2077q;
                ib.q qVar = iVar.f9324q;
                while (true) {
                    try {
                        ((Runnable) this.f2076p).run();
                    } catch (Throwable th2) {
                        ib.v.d(pa.j.f10146o, th2);
                    }
                    Runnable P = iVar.P();
                    if (P == null) {
                        return;
                    }
                    this.f2076p = P;
                    i10++;
                    if (i10 >= 16 && qVar.O()) {
                        qVar.M(iVar, this);
                        return;
                    }
                }
                break;
            case 27:
                z4.j jVar = (z4.j) this.f2076p;
                try {
                    jVar.i(((Worker) this.f2077q).g());
                    return;
                } catch (Throwable th3) {
                    jVar.j(th3);
                    return;
                }
            case 28:
                if (((p4.s) this.f2077q).D.f14111o instanceof z4.a) {
                    return;
                }
                try {
                    ((s9.b) this.f2076p).get();
                    o4.p.d().a(p4.s.F, "Starting work for " + ((p4.s) this.f2077q).f9968q.f13571c);
                    p4.s sVar2 = (p4.s) this.f2077q;
                    sVar2.D.k(sVar2.f9969r.c());
                    return;
                } catch (Throwable th4) {
                    ((p4.s) this.f2077q).D.j(th4);
                    return;
                }
            default:
                String str3 = (String) this.f2076p;
                p4.s sVar3 = (p4.s) this.f2077q;
                x4.o oVar = sVar3.f9968q;
                try {
                    try {
                        o4.n nVar2 = (o4.n) sVar3.D.get();
                        if (nVar2 == null) {
                            o4.p.d().b(p4.s.F, oVar.f13571c + " returned a null result. Treating it as a failure.");
                        } else {
                            o4.p.d().a(p4.s.F, oVar.f13571c + " returned a " + nVar2 + ".");
                            sVar3.f9971t = nVar2;
                        }
                    } catch (Throwable th5) {
                        sVar3.b();
                        throw th5;
                    }
                } catch (InterruptedException e8) {
                    e = e8;
                    o4.p.d().c(p4.s.F, str3 + " failed because it threw an exception/error", e);
                } catch (CancellationException e10) {
                    o4.p d11 = o4.p.d();
                    String str4 = p4.s.F;
                    String str5 = str3 + " was cancelled";
                    if (d11.f9512a <= 4) {
                        Log.i(str4, str5, e10);
                    }
                } catch (ExecutionException e11) {
                    e = e11;
                    o4.p.d().c(p4.s.F, str3 + " failed because it threw an exception/error", e);
                }
                sVar3.b();
                return;
        }
    }

    public /* synthetic */ y(Object obj, Object obj2, int i10, boolean z10) {
        this.f2075o = i10;
        this.f2076p = obj;
        this.f2077q = obj2;
    }

    public y(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z10) {
        this.f2075o = 25;
        this.f2077q = swipeDismissBehavior;
        this.f2076p = view;
    }
}
