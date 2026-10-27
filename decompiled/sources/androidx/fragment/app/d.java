package androidx.fragment.app;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.view.Surface;
import android.view.View;
import androidx.media3.ui.PlayerView;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import i1.f1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import s1.c1;
import s1.y0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f666o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f667p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f668q;

    public /* synthetic */ d(Object obj, int i10, Object obj2) {
        this.f666o = i10;
        this.f667p = obj;
        this.f668q = obj2;
    }

    private final void a() {
        p4.f fVar = (p4.f) this.f667p;
        x4.j jVar = (x4.j) this.f668q;
        synchronized (fVar.f9926k) {
            try {
                ArrayList arrayList = fVar.f9925j;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((p4.c) obj).b(jVar, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        long j10;
        boolean z10;
        int i10 = 0;
        int i11 = 3;
        int i12 = 1;
        switch (this.f666o) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f667p;
                u0 u0Var = (u0) this.f668q;
                if (arrayList.contains(u0Var)) {
                    arrayList.remove(u0Var);
                    View view = u0Var.f832c.S;
                    int i13 = u0Var.f830a;
                    za.h.d("view", view);
                    android.support.v4.media.d.b(view, i13);
                    return;
                }
                return;
            case 1:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f667p;
                s9.b bVar = (s9.b) this.f668q;
                synchronized (constraintTrackingWorker.f1557t) {
                    try {
                        if (constraintTrackingWorker.f1558u) {
                            z4.j jVar = constraintTrackingWorker.f1559v;
                            za.h.d("future", jVar);
                            String str = b5.a.f2473a;
                            jVar.i(new o4.l());
                        } else {
                            constraintTrackingWorker.f1559v.k(bVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 2:
                ((l1.h) this.f667p).accept(this.f668q);
                return;
            case 3:
                ((c2.u0) this.f667p).E((k2.a0) this.f668q);
                return;
            case 4:
                ((d0.b) this.f667p).j((Typeface) this.f668q);
                return;
            case 5:
                f.o oVar = (f.o) this.f667p;
                Runnable runnable = (Runnable) this.f668q;
                oVar.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    oVar.c();
                }
            case 6:
                ((i2.d) ((x4.l) this.f667p).f13562p).g.a((f1) this.f668q);
                return;
            case 7:
                i2.k0 k0Var = (i2.k0) this.f667p;
                f1 f1Var = (f1) this.f668q;
                s1.x xVar = k0Var.f6227c;
                int i14 = l1.a0.f8067a;
                s1.a0 a0Var = xVar.f11482o;
                a0Var.f11199j0 = f1Var;
                a0Var.f11204m.e(25, new v0(24, f1Var));
                return;
            case 8:
                i2.k0 k0Var2 = (i2.k0) this.f667p;
                Exception exc = (Exception) this.f668q;
                s1.x xVar2 = k0Var2.f6227c;
                int i15 = l1.a0.f8067a;
                t1.o oVar2 = xVar2.f11482o.f11212s;
                t1.a N = oVar2.N();
                oVar2.O(N, 1030, new h3.b(N, exc, 20));
                return;
            case 9:
                i2.k0 k0Var3 = (i2.k0) this.f667p;
                String str2 = (String) this.f668q;
                s1.x xVar3 = k0Var3.f6227c;
                int i16 = l1.a0.f8067a;
                t1.o oVar3 = xVar3.f11482o.f11212s;
                t1.a N2 = oVar3.N();
                oVar3.O(N2, 1019, new t1.f(N2, str2, i12));
                return;
            case 10:
                Context context = (Context) this.f667p;
                l1.g gVar = (l1.g) this.f668q;
                j1.c.f6945a = (AudioManager) context.getSystemService("audio");
                gVar.f();
                return;
            case 11:
                j2.k kVar = (j2.k) this.f667p;
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.f668q;
                SurfaceTexture surfaceTexture2 = kVar.f7050u;
                Surface surface = kVar.f7051v;
                Surface surface2 = new Surface(surfaceTexture);
                kVar.f7050u = surfaceTexture;
                kVar.f7051v = surface2;
                Iterator it = kVar.f7044o.iterator();
                while (it.hasNext()) {
                    ((s1.x) it.next()).f11482o.X(surface2);
                }
                if (surfaceTexture2 != null) {
                    surfaceTexture2.release();
                }
                if (surface != null) {
                    surface.release();
                    return;
                }
                return;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                b4.b bVar2 = (b4.b) this.f667p;
                Object apply = ((s1.t) this.f668q).apply(bVar2.f2180f);
                bVar2.f2180f = apply;
                l1.c cVar = new l1.c(bVar2, apply, i12);
                l1.x xVar4 = (l1.x) bVar2.f2177c;
                if (xVar4.f8138a.getLooper().getThread().isAlive()) {
                    xVar4.c(cVar);
                    return;
                }
                return;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                l1.s sVar = (l1.s) this.f667p;
                Context context2 = (Context) this.f668q;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context2.registerReceiver(new com.bumptech.glide.manager.q(i11, sVar), intentFilter);
                return;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                com.bumptech.glide.manager.q qVar = (com.bumptech.glide.manager.q) this.f667p;
                Context context3 = (Context) this.f668q;
                l1.s sVar2 = (l1.s) qVar.f3085b;
                ConnectivityManager connectivityManager = (ConnectivityManager) context3.getSystemService("connectivity");
                if (connectivityManager != null) {
                    try {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            int type = activeNetworkInfo.getType();
                            if (type != 0) {
                                if (type != 1) {
                                    if (type != 4 && type != 5) {
                                        if (type != 6) {
                                            i10 = type != 9 ? 8 : 7;
                                        }
                                        i10 = 5;
                                    }
                                }
                                i10 = 2;
                            }
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                    i10 = 3;
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                                case 17:
                                    i10 = 4;
                                    break;
                                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                                    i10 = 5;
                                    break;
                                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                                case 19:
                                default:
                                    i10 = 6;
                                    break;
                                case 18:
                                    i10 = 2;
                                    break;
                                case 20:
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        i10 = 9;
                                        break;
                                    }
                                    break;
                            }
                        } else {
                            i10 = 1;
                        }
                    } catch (SecurityException unused) {
                    }
                }
                if (Build.VERSION.SDK_INT < 31 || i10 != 5) {
                    sVar2.c(i10);
                    return;
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context3.getSystemService("phone");
                    telephonyManager.getClass();
                    l1.q qVar2 = new l1.q(sVar2);
                    telephonyManager.registerTelephonyCallback((Executor) sVar2.f8123q, qVar2);
                    telephonyManager.unregisterTelephonyCallback(qVar2);
                    return;
                } catch (RuntimeException unused2) {
                    sVar2.c(5);
                    return;
                }
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                a();
                return;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                p4.s sVar3 = (p4.s) this.f667p;
                s9.b bVar3 = (s9.b) this.f668q;
                if (sVar3.D.f14111o instanceof z4.a) {
                    bVar3.cancel(true);
                    return;
                }
                return;
            case 17:
                q4.d dVar = (q4.d) this.f667p;
                p4.l lVar = (p4.l) this.f668q;
                za.h.e("this$0", dVar);
                za.h.e("$token", lVar);
                ((x4.c) dVar.f10335q).e0(lVar, 3);
                return;
            case 18:
                s1.a0 a0Var2 = (s1.a0) this.f667p;
                b4.u uVar = (b4.u) this.f668q;
                int i17 = a0Var2.I - uVar.f2418b;
                a0Var2.I = i17;
                if (uVar.f2420d) {
                    a0Var2.J = uVar.f2421e;
                    a0Var2.K = true;
                }
                if (i17 == 0) {
                    i1.t0 t0Var = ((y0) uVar.f2422f).f11493a;
                    if (!a0Var2.f11203l0.f11493a.p() && t0Var.p()) {
                        a0Var2.f11205m0 = -1;
                        a0Var2.f11207n0 = 0L;
                    }
                    if (!t0Var.p()) {
                        List asList = Arrays.asList(((c1) t0Var).f11245h);
                        l1.d.g(asList.size() == a0Var2.f11209p.size());
                        for (int i18 = 0; i18 < asList.size(); i18++) {
                            ((s1.z) a0Var2.f11209p.get(i18)).f11513b = (i1.t0) asList.get(i18);
                        }
                    }
                    long j11 = -9223372036854775807L;
                    if (a0Var2.K) {
                        if (((y0) uVar.f2422f).f11494b.equals(a0Var2.f11203l0.f11494b) && ((y0) uVar.f2422f).f11496d == a0Var2.f11203l0.f11510s) {
                            i12 = 0;
                        }
                        if (i12 != 0) {
                            if (t0Var.p() || ((y0) uVar.f2422f).f11494b.b()) {
                                j11 = ((y0) uVar.f2422f).f11496d;
                            } else {
                                y0 y0Var = (y0) uVar.f2422f;
                                c2.d0 d0Var = y0Var.f11494b;
                                long j12 = y0Var.f11496d;
                                Object obj = d0Var.f2539a;
                                i1.r0 r0Var = a0Var2.f11208o;
                                t0Var.g(obj, r0Var);
                                j11 = j12 + r0Var.f6016e;
                            }
                        }
                        j10 = j11;
                        z10 = i12;
                    } else {
                        j10 = -9223372036854775807L;
                        z10 = 0;
                    }
                    a0Var2.K = false;
                    a0Var2.d0((y0) uVar.f2422f, 1, z10, a0Var2.J, j10, -1, false);
                    return;
                }
                return;
            case 19:
                ((t1.t) this.f667p).f11848d.reportTrackChangeEvent((TrackChangeEvent) this.f668q);
                return;
            case 20:
                ((t1.t) this.f667p).f11848d.reportNetworkEvent((NetworkEvent) this.f668q);
                return;
            case 21:
                ((t1.t) this.f667p).f11848d.reportPlaybackErrorEvent((PlaybackErrorEvent) this.f668q);
                return;
            case 22:
                ((t1.t) this.f667p).f11848d.reportPlaybackMetrics((PlaybackMetrics) this.f668q);
                return;
            case 23:
                ((t1.t) this.f667p).f11848d.reportPlaybackStateEvent((PlaybackStateEvent) this.f668q);
                return;
            case 24:
                i2.k0 k0Var4 = (i2.k0) this.f667p;
                String str3 = (String) this.f668q;
                s1.x xVar5 = k0Var4.f6227c;
                int i19 = l1.a0.f8067a;
                t1.o oVar4 = xVar5.f11482o.f11212s;
                t1.a N3 = oVar4.N();
                oVar4.O(N3, 1012, new t1.f(N3, str3, i11));
                return;
            case 25:
                p4.p pVar = (p4.p) this.f667p;
                u1.l lVar2 = (u1.l) this.f668q;
                i2.k0 k0Var5 = ((u1.b0) pVar.f9953p).V0;
                Handler handler = k0Var5.f6226b;
                if (handler != null) {
                    handler.post(new u1.i(k0Var5, lVar2, i12));
                    return;
                }
                return;
            case 26:
                PlayerView.a((PlayerView) this.f667p, (Bitmap) this.f668q);
                return;
            case 27:
                List list = (List) this.f667p;
                v4.f fVar = (v4.f) this.f668q;
                za.h.e("$listenersList", list);
                za.h.e("this$0", fVar);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((u4.c) it2.next()).a(fVar.f12671e);
                }
                return;
            case 28:
                ((x1.b) ((w1.k) ((w1.r) this.f667p).f12859q.f9953p).f12809p.f13346r.get(((w1.j) this.f668q).f12794m)).e(true);
                return;
            default:
                x1.b bVar4 = (x1.b) this.f667p;
                Uri uri = (Uri) this.f668q;
                bVar4.f13339w = false;
                bVar4.f(uri);
                return;
        }
    }

    public /* synthetic */ d(ArrayList arrayList, u0 u0Var, k kVar) {
        this.f666o = 0;
        this.f667p = arrayList;
        this.f668q = u0Var;
    }
}
