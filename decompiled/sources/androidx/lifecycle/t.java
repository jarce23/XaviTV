package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1156a;

    /* renamed from: b, reason: collision with root package name */
    public o.a f1157b;

    /* renamed from: c, reason: collision with root package name */
    public m f1158c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f1159d;

    /* renamed from: e, reason: collision with root package name */
    public int f1160e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1161f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1162h;

    public t(r rVar) {
        new AtomicReference();
        this.f1156a = true;
        this.f1157b = new o.a();
        this.f1158c = m.f1145p;
        this.f1162h = new ArrayList();
        this.f1159d = new WeakReference(rVar);
    }

    public final void a(q qVar) {
        p reflectiveGenericLifecycleObserver;
        Object obj;
        r rVar;
        c("addObserver");
        m mVar = this.f1158c;
        m mVar2 = m.f1144o;
        if (mVar != mVar2) {
            mVar2 = m.f1145p;
        }
        s sVar = new s();
        HashMap hashMap = v.f1164a;
        boolean z10 = qVar instanceof p;
        boolean z11 = qVar instanceof d;
        if (z10 && z11) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) qVar, (p) qVar);
        } else if (z11) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) qVar, null);
        } else if (z10) {
            reflectiveGenericLifecycleObserver = (p) qVar;
        } else {
            Class<?> cls = qVar.getClass();
            if (v.b(cls) == 2) {
                Object obj2 = v.f1165b.get(cls);
                za.h.b(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    v.a((Constructor) list.get(0), qVar);
                    throw null;
                }
                int size = list.size();
                g[] gVarArr = new g[size];
                if (size > 0) {
                    v.a((Constructor) list.get(0), qVar);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(gVarArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(qVar);
            }
        }
        sVar.f1155b = reflectiveGenericLifecycleObserver;
        sVar.f1154a = mVar2;
        o.a aVar = this.f1157b;
        o.c f10 = aVar.f(qVar);
        if (f10 != null) {
            obj = f10.f9359p;
        } else {
            HashMap hashMap2 = aVar.f9354s;
            o.c cVar = new o.c(qVar, sVar);
            aVar.f9368r++;
            o.c cVar2 = aVar.f9366p;
            if (cVar2 == null) {
                aVar.f9365o = cVar;
                aVar.f9366p = cVar;
            } else {
                cVar2.f9360q = cVar;
                cVar.f9361r = cVar2;
                aVar.f9366p = cVar;
            }
            hashMap2.put(qVar, cVar);
            obj = null;
        }
        if (((s) obj) == null && (rVar = (r) this.f1159d.get()) != null) {
            boolean z12 = this.f1160e != 0 || this.f1161f;
            m b2 = b(qVar);
            this.f1160e++;
            while (sVar.f1154a.compareTo(b2) < 0 && this.f1157b.f9354s.containsKey(qVar)) {
                m mVar3 = sVar.f1154a;
                ArrayList arrayList = this.f1162h;
                arrayList.add(mVar3);
                j jVar = l.Companion;
                m mVar4 = sVar.f1154a;
                jVar.getClass();
                za.h.e("state", mVar4);
                int ordinal = mVar4.ordinal();
                l lVar = ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? null : l.ON_RESUME : l.ON_START : l.ON_CREATE;
                if (lVar == null) {
                    throw new IllegalStateException("no event up from " + sVar.f1154a);
                }
                sVar.a(rVar, lVar);
                arrayList.remove(arrayList.size() - 1);
                b2 = b(qVar);
            }
            if (!z12) {
                h();
            }
            this.f1160e--;
        }
    }

    public final m b(q qVar) {
        HashMap hashMap = this.f1157b.f9354s;
        o.c cVar = hashMap.containsKey(qVar) ? ((o.c) hashMap.get(qVar)).f9361r : null;
        m mVar = cVar != null ? ((s) cVar.f9359p).f1154a : null;
        ArrayList arrayList = this.f1162h;
        m mVar2 = arrayList.isEmpty() ? null : (m) arrayList.get(arrayList.size() - 1);
        m mVar3 = this.f1158c;
        za.h.e("state1", mVar3);
        if (mVar == null || mVar.compareTo(mVar3) >= 0) {
            mVar = mVar3;
        }
        return (mVar2 == null || mVar2.compareTo(mVar) >= 0) ? mVar : mVar2;
    }

    public final void c(String str) {
        if (this.f1156a) {
            n.a.w().f9089b.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(android.support.v4.media.d.q("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(l lVar) {
        za.h.e("event", lVar);
        c("handleLifecycleEvent");
        e(lVar.a());
    }

    public final void e(m mVar) {
        m mVar2 = this.f1158c;
        if (mVar2 == mVar) {
            return;
        }
        m mVar3 = m.f1145p;
        m mVar4 = m.f1144o;
        if (mVar2 == mVar3 && mVar == mVar4) {
            throw new IllegalStateException(("no event down from " + this.f1158c + " in component " + this.f1159d.get()).toString());
        }
        this.f1158c = mVar;
        if (this.f1161f || this.f1160e != 0) {
            this.g = true;
            return;
        }
        this.f1161f = true;
        h();
        this.f1161f = false;
        if (this.f1158c == mVar4) {
            this.f1157b = new o.a();
        }
    }

    public final void f(q qVar) {
        za.h.e("observer", qVar);
        c("removeObserver");
        this.f1157b.g(qVar);
    }

    public final void g() {
        c("setCurrentState");
        e(m.f1146q);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        r12.g = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.t.h():void");
    }
}
