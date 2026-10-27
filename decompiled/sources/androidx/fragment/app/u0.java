package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public int f830a;

    /* renamed from: b, reason: collision with root package name */
    public int f831b;

    /* renamed from: c, reason: collision with root package name */
    public final s f832c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f833d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f834e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f835f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final p0 f836h;

    public u0(int i10, int i11, p0 p0Var, i0.b bVar) {
        r.a.h(i10, "finalState");
        r.a.h(i11, "lifecycleImpact");
        s sVar = p0Var.f772c;
        za.h.d("fragmentStateManager.fragment", sVar);
        r.a.h(i10, "finalState");
        r.a.h(i11, "lifecycleImpact");
        za.h.e("fragment", sVar);
        this.f830a = i10;
        this.f831b = i11;
        this.f832c = sVar;
        this.f833d = new ArrayList();
        this.f834e = new LinkedHashSet();
        bVar.a(new v0(0, this));
        this.f836h = p0Var;
    }

    public final void a() {
        LinkedHashSet linkedHashSet = this.f834e;
        if (this.f835f) {
            return;
        }
        this.f835f = true;
        if (linkedHashSet.isEmpty()) {
            b();
            return;
        }
        for (i0.b bVar : new LinkedHashSet(linkedHashSet)) {
            synchronized (bVar) {
                try {
                    if (!bVar.f5778a) {
                        bVar.f5778a = true;
                        bVar.f5780c = true;
                        i0.a aVar = bVar.f5779b;
                        if (aVar != null) {
                            try {
                                aVar.onCancel();
                            } catch (Throwable th) {
                                synchronized (bVar) {
                                    bVar.f5780c = false;
                                    bVar.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (bVar) {
                            bVar.f5780c = false;
                            bVar.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void b() {
        if (!this.g) {
            if (i0.F(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            ArrayList arrayList = this.f833d;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((Runnable) obj).run();
            }
        }
        this.f836h.k();
    }

    public final void c(int i10, int i11) {
        r.a.h(i10, "finalState");
        r.a.h(i11, "lifecycleImpact");
        int b2 = s.e.b(i11);
        s sVar = this.f832c;
        if (b2 == 0) {
            if (this.f830a != 1) {
                if (i0.F(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + sVar + " mFinalState = " + android.support.v4.media.d.B(this.f830a) + " -> " + android.support.v4.media.d.B(i10) + '.');
                }
                this.f830a = i10;
                return;
            }
            return;
        }
        if (b2 == 1) {
            if (this.f830a == 1) {
                if (i0.F(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + sVar + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + android.support.v4.media.d.A(this.f831b) + " to ADDING.");
                }
                this.f830a = 2;
                this.f831b = 2;
                return;
            }
            return;
        }
        if (b2 != 2) {
            return;
        }
        if (i0.F(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + sVar + " mFinalState = " + android.support.v4.media.d.B(this.f830a) + " -> REMOVED. mLifecycleImpact  = " + android.support.v4.media.d.A(this.f831b) + " to REMOVING.");
        }
        this.f830a = 1;
        this.f831b = 3;
    }

    public final void d() {
        int i10 = this.f831b;
        p0 p0Var = this.f836h;
        if (i10 != 2) {
            if (i10 == 3) {
                s sVar = p0Var.f772c;
                za.h.d("fragmentStateManager.fragment", sVar);
                View F = sVar.F();
                if (i0.F(2)) {
                    Log.v("FragmentManager", "Clearing focus " + F.findFocus() + " on view " + F + " for Fragment " + sVar);
                }
                F.clearFocus();
                return;
            }
            return;
        }
        s sVar2 = p0Var.f772c;
        za.h.d("fragmentStateManager.fragment", sVar2);
        View findFocus = sVar2.S.findFocus();
        if (findFocus != null) {
            sVar2.g().f793k = findFocus;
            if (i0.F(2)) {
                Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + sVar2);
            }
        }
        View F2 = this.f832c.F();
        if (F2.getParent() == null) {
            p0Var.b();
            F2.setAlpha(0.0f);
        }
        if (F2.getAlpha() == 0.0f && F2.getVisibility() == 0) {
            F2.setVisibility(4);
        }
        r rVar = sVar2.V;
        F2.setAlpha(rVar == null ? 1.0f : rVar.f792j);
    }

    public final String toString() {
        StringBuilder s10 = android.support.v4.media.d.s("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
        s10.append(android.support.v4.media.d.B(this.f830a));
        s10.append(" lifecycleImpact = ");
        s10.append(android.support.v4.media.d.A(this.f831b));
        s10.append(" fragment = ");
        s10.append(this.f832c);
        s10.append('}');
        return s10.toString();
    }
}
