package androidx.emoji2.text;

import android.view.AttachedSurfaceControl;
import android.view.SurfaceView;
import android.view.View;
import android.window.SurfaceSyncGroup;
import i1.r0;
import i2.k0;
import j9.g1;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import m0.z0;
import o9.g0;
import o9.w0;
import s1.o0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f585o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f586p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f587q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f588r;

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, int i10) {
        this.f585o = i10;
        this.f586p = obj;
        this.f587q = obj2;
        this.f588r = obj3;
    }

    private final void a() {
        boolean z10;
        p4.f fVar = (p4.f) this.f586p;
        s9.b bVar = (s9.b) this.f587q;
        p4.s sVar = (p4.s) this.f588r;
        try {
            z10 = ((Boolean) bVar.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            z10 = true;
        }
        synchronized (fVar.f9926k) {
            try {
                x4.j g = com.google.android.gms.internal.cast.n.g(sVar.f9968q);
                String str = g.f13557a;
                if (fVar.d(str) == sVar) {
                    fVar.b(str);
                }
                o4.p.d().a(p4.f.f9916l, p4.f.class.getSimpleName() + " " + str + " executed; reschedule = " + z10);
                ArrayList arrayList = fVar.f9925j;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((p4.c) obj).b(g, z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AttachedSurfaceControl rootSurfaceControl;
        boolean add;
        final int i10 = 0;
        switch (this.f585o) {
            case 0:
                o oVar = (o) this.f586p;
                j1.c cVar = (j1.c) this.f587q;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f588r;
                try {
                    v e7 = i7.e.e(oVar.f591o);
                    if (e7 == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    u uVar = (u) ((k) e7.f570b);
                    synchronized (uVar.f605r) {
                        uVar.f607t = threadPoolExecutor;
                    }
                    ((k) e7.f570b).a(new n(cVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    cVar.m(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                androidx.fragment.app.k kVar = (androidx.fragment.app.k) this.f586p;
                View view = (View) this.f587q;
                androidx.fragment.app.f fVar = (androidx.fragment.app.f) this.f588r;
                za.h.e("this$0", kVar);
                za.h.e("$animationInfo", fVar);
                kVar.f718a.endViewTransition(view);
                fVar.d();
                return;
            case 2:
                k0 k0Var = (k0) this.f586p;
                final i1.p pVar = (i1.p) this.f587q;
                final s1.f fVar2 = (s1.f) this.f588r;
                s1.x xVar = k0Var.f6227c;
                int i11 = l1.a0.f8067a;
                t1.o oVar2 = xVar.f11482o.f11212s;
                final t1.a N = oVar2.N();
                oVar2.O(N, 1017, new l1.m(N, pVar, fVar2, i10) { // from class: t1.l

                    /* renamed from: o, reason: collision with root package name */
                    public final /* synthetic */ int f11812o;

                    /* renamed from: p, reason: collision with root package name */
                    public final /* synthetic */ a f11813p;

                    /* renamed from: q, reason: collision with root package name */
                    public final /* synthetic */ i1.p f11814q;

                    {
                        this.f11812o = i10;
                    }

                    @Override // l1.m
                    public final void invoke(Object obj) {
                        switch (this.f11812o) {
                            case 0:
                                ((b) obj).b(this.f11813p, this.f11814q);
                                break;
                            default:
                                ((b) obj).N(this.f11813p, this.f11814q);
                                break;
                        }
                    }
                });
                return;
            case 3:
                a();
                return;
            case 4:
                o0 o0Var = (o0) this.f586p;
                o9.d0 d0Var = (o9.d0) this.f587q;
                c2.d0 d0Var2 = (c2.d0) this.f588r;
                t1.o oVar3 = o0Var.f11425c;
                w0 f10 = d0Var.f();
                g1 g1Var = oVar3.f11825r;
                i1.o0 o0Var2 = oVar3.f11828u;
                o0Var2.getClass();
                g1Var.getClass();
                g1Var.f7291p = g0.n(f10);
                if (!f10.isEmpty()) {
                    g1Var.f7294s = (c2.d0) f10.get(0);
                    d0Var2.getClass();
                    g1Var.f7295t = d0Var2;
                }
                if (((c2.d0) g1Var.f7293r) == null) {
                    g1Var.f7293r = g1.i(o0Var2, (g0) g1Var.f7291p, (c2.d0) g1Var.f7294s, (r0) g1Var.f7290o);
                }
                g1Var.s(((s1.a0) o0Var2).A());
                return;
            case 5:
                k0 k0Var2 = (k0) this.f586p;
                final i1.p pVar2 = (i1.p) this.f587q;
                final s1.f fVar3 = (s1.f) this.f588r;
                s1.x xVar2 = k0Var2.f6227c;
                int i12 = l1.a0.f8067a;
                t1.o oVar4 = xVar2.f11482o.f11212s;
                final t1.a N2 = oVar4.N();
                final int i13 = 1;
                oVar4.O(N2, 1009, new l1.m(N2, pVar2, fVar3, i13) { // from class: t1.l

                    /* renamed from: o, reason: collision with root package name */
                    public final /* synthetic */ int f11812o;

                    /* renamed from: p, reason: collision with root package name */
                    public final /* synthetic */ a f11813p;

                    /* renamed from: q, reason: collision with root package name */
                    public final /* synthetic */ i1.p f11814q;

                    {
                        this.f11812o = i13;
                    }

                    @Override // l1.m
                    public final void invoke(Object obj) {
                        switch (this.f11812o) {
                            case 0:
                                ((b) obj).b(this.f11813p, this.f11814q);
                                break;
                            default:
                                ((b) obj).N(this.f11813p, this.f11814q);
                                break;
                        }
                    }
                });
                return;
            case 6:
                p4.p pVar3 = (p4.p) this.f586p;
                SurfaceView surfaceView = (SurfaceView) this.f587q;
                androidx.activity.d dVar = (androidx.activity.d) this.f588r;
                pVar3.getClass();
                rootSurfaceControl = surfaceView.getRootSurfaceControl();
                if (rootSurfaceControl == null) {
                    return;
                }
                SurfaceSyncGroup g = a6.y.g();
                pVar3.f9953p = g;
                add = g.add(rootSurfaceControl, new u3.y(0));
                l1.d.g(add);
                dVar.run();
                rootSurfaceControl.applyTransactionOnDraw(z0.c());
                return;
            default:
                y6.a aVar = (y6.a) this.f586p;
                s6.i iVar = (s6.i) this.f587q;
                String str = iVar.f11611a;
                s6.h hVar = (s6.h) this.f588r;
                aVar.getClass();
                Logger logger = y6.a.f13887f;
                try {
                    t6.e a10 = aVar.f13890c.a(str);
                    if (a10 == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        new IllegalArgumentException(str2);
                    } else {
                        ((a7.l) aVar.f13892e).x(new a7.f(aVar, iVar, ((q6.b) a10).a(hVar)));
                    }
                    return;
                } catch (Exception e8) {
                    logger.warning("Error scheduling event " + e8.getMessage());
                    return;
                }
        }
    }

    public /* synthetic */ m(y6.a aVar, s6.i iVar, h3.b bVar, s6.h hVar) {
        this.f585o = 7;
        this.f586p = aVar;
        this.f587q = iVar;
        this.f588r = hVar;
    }
}
