package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class y {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f1170k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f1171a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final o.f f1172b = new o.f();

    /* renamed from: c, reason: collision with root package name */
    public int f1173c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1174d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f1175e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f1176f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1177h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1178i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.activity.j f1179j;

    public y() {
        Object obj = f1170k;
        this.f1176f = obj;
        this.f1179j = new androidx.activity.j(6, this);
        this.f1175e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        n.a.w().f9089b.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(android.support.v4.media.d.q("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(x xVar) {
        if (xVar.f1167p) {
            if (!xVar.e()) {
                xVar.c(false);
                return;
            }
            int i10 = xVar.f1168q;
            int i11 = this.g;
            if (i10 >= i11) {
                return;
            }
            xVar.f1168q = i11;
            a6.n nVar = xVar.f1166o;
            Object obj = this.f1175e;
            nVar.getClass();
            r rVar = (r) obj;
            androidx.fragment.app.o oVar = (androidx.fragment.app.o) nVar.f74p;
            if (rVar == null || !oVar.f758o0) {
                return;
            }
            View F = oVar.F();
            if (F.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (oVar.f762s0 != null) {
                if (androidx.fragment.app.i0.F(3)) {
                    Log.d("FragmentManager", "DialogFragment " + nVar + " setting the content view on " + oVar.f762s0);
                }
                oVar.f762s0.setContentView(F);
            }
        }
    }

    public final void c(x xVar) {
        if (this.f1177h) {
            this.f1178i = true;
            return;
        }
        this.f1177h = true;
        do {
            this.f1178i = false;
            if (xVar != null) {
                b(xVar);
                xVar = null;
            } else {
                o.f fVar = this.f1172b;
                fVar.getClass();
                o.d dVar = new o.d(fVar);
                fVar.f9367q.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((x) ((Map.Entry) dVar.next()).getValue());
                    if (this.f1178i) {
                        break;
                    }
                }
            }
        } while (this.f1178i);
        this.f1177h = false;
    }

    public final void d(a6.n nVar) {
        Object obj;
        a("observeForever");
        w wVar = new w(this, nVar);
        o.f fVar = this.f1172b;
        o.c f10 = fVar.f(nVar);
        if (f10 != null) {
            obj = f10.f9359p;
        } else {
            o.c cVar = new o.c(nVar, wVar);
            fVar.f9368r++;
            o.c cVar2 = fVar.f9366p;
            if (cVar2 == null) {
                fVar.f9365o = cVar;
                fVar.f9366p = cVar;
            } else {
                cVar2.f9360q = cVar;
                cVar.f9361r = cVar2;
                fVar.f9366p = cVar;
            }
            obj = null;
        }
        x xVar = (x) obj;
        if (xVar instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (xVar != null) {
            return;
        }
        wVar.c(true);
    }

    public final void e(Object obj) {
        a("setValue");
        this.g++;
        this.f1175e = obj;
        c(null);
    }
}
