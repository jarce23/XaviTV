package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final x4.c f770a;

    /* renamed from: b, reason: collision with root package name */
    public final x4.i f771b;

    /* renamed from: c, reason: collision with root package name */
    public final s f772c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f773d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f774e = -1;

    public p0(x4.c cVar, x4.i iVar, s sVar) {
        this.f770a = cVar;
        this.f771b = iVar;
        this.f772c = sVar;
    }

    public final void a() {
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + sVar);
        }
        Bundle bundle = sVar.f807p;
        if (bundle != null) {
            bundle.getBundle("savedInstanceState");
        }
        sVar.H.L();
        sVar.f806o = 3;
        sVar.Q = false;
        sVar.r();
        if (!sVar.Q) {
            throw new x0("Fragment " + sVar + " did not call through to super.onActivityCreated()");
        }
        if (i0.F(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + sVar);
        }
        if (sVar.S != null) {
            Bundle bundle2 = sVar.f807p;
            Bundle bundle3 = bundle2 != null ? bundle2.getBundle("savedInstanceState") : null;
            SparseArray<Parcelable> sparseArray = sVar.f808q;
            if (sparseArray != null) {
                sVar.S.restoreHierarchyState(sparseArray);
                sVar.f808q = null;
            }
            sVar.Q = false;
            sVar.C(bundle3);
            if (!sVar.Q) {
                throw new x0("Fragment " + sVar + " did not call through to super.onViewStateRestored()");
            }
            if (sVar.S != null) {
                sVar.f801b0.a(androidx.lifecycle.l.ON_CREATE);
            }
        }
        sVar.f807p = null;
        j0 j0Var = sVar.H;
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(4);
        this.f770a.D(false);
    }

    public final void b() {
        s sVar;
        View view;
        View view2;
        s sVar2 = this.f772c;
        View view3 = sVar2.R;
        while (true) {
            sVar = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(R.id.fragment_container_view_tag);
            s sVar3 = tag instanceof s ? (s) tag : null;
            if (sVar3 != null) {
                sVar = sVar3;
                break;
            } else {
                Object parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        s sVar4 = sVar2.I;
        if (sVar != null && !sVar.equals(sVar4)) {
            int i10 = sVar2.K;
            y0.b bVar = y0.c.f13756a;
            StringBuilder sb2 = new StringBuilder("Attempting to nest fragment ");
            sb2.append(sVar2);
            sb2.append(" within the view of parent fragment ");
            sb2.append(sVar);
            sb2.append(" via container with ID ");
            y0.c.b(new y0.a(sVar2, r.a.d(sb2, i10, " without using parent's childFragmentManager")));
            y0.c.a(sVar2).getClass();
        }
        ArrayList arrayList = (ArrayList) this.f771b.f13553p;
        ViewGroup viewGroup = sVar2.R;
        int i11 = -1;
        if (viewGroup != null) {
            int indexOf = arrayList.indexOf(sVar2);
            int i12 = indexOf - 1;
            while (true) {
                if (i12 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        s sVar5 = (s) arrayList.get(indexOf);
                        if (sVar5.R == viewGroup && (view = sVar5.S) != null) {
                            i11 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    s sVar6 = (s) arrayList.get(i12);
                    if (sVar6.R == viewGroup && (view2 = sVar6.S) != null) {
                        i11 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i12--;
                }
            }
        }
        sVar2.R.addView(sVar2.S, i11);
    }

    public final void c() {
        p0 p0Var;
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "moveto ATTACHED: " + sVar);
        }
        s sVar2 = sVar.f812u;
        x4.i iVar = this.f771b;
        if (sVar2 != null) {
            p0Var = (p0) ((HashMap) iVar.f13554q).get(sVar2.f810s);
            if (p0Var == null) {
                throw new IllegalStateException("Fragment " + sVar + " declared target fragment " + sVar.f812u + " that does not belong to this FragmentManager!");
            }
            sVar.f813v = sVar.f812u.f810s;
            sVar.f812u = null;
        } else {
            String str = sVar.f813v;
            if (str != null) {
                p0Var = (p0) ((HashMap) iVar.f13554q).get(str);
                if (p0Var == null) {
                    StringBuilder sb2 = new StringBuilder("Fragment ");
                    sb2.append(sVar);
                    sb2.append(" declared target fragment ");
                    throw new IllegalStateException(android.support.v4.media.d.r(sb2, sVar.f813v, " that does not belong to this FragmentManager!"));
                }
            } else {
                p0Var = null;
            }
        }
        if (p0Var != null) {
            p0Var.k();
        }
        i0 i0Var = sVar.F;
        sVar.G = i0Var.f707t;
        sVar.I = i0Var.f709v;
        x4.c cVar = this.f770a;
        cVar.J(false);
        ArrayList arrayList = sVar.f804e0;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            s sVar3 = ((p) obj).f769a;
            sVar3.f803d0.c();
            androidx.lifecycle.g0.a(sVar3);
            Bundle bundle = sVar3.f807p;
            sVar3.f803d0.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
        arrayList.clear();
        sVar.H.b(sVar.G, sVar.c(), sVar);
        sVar.f806o = 0;
        sVar.Q = false;
        sVar.t(sVar.G.f826t);
        if (!sVar.Q) {
            throw new x0("Fragment " + sVar + " did not call through to super.onAttach()");
        }
        Iterator it = sVar.F.f700m.iterator();
        while (it.hasNext()) {
            ((m0) it.next()).a();
        }
        j0 j0Var = sVar.H;
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(0);
        cVar.E(false);
    }

    public final int d() {
        int i10;
        Object obj;
        s sVar = this.f772c;
        if (sVar.F == null) {
            return sVar.f806o;
        }
        int i11 = this.f774e;
        int ordinal = sVar.Z.ordinal();
        if (ordinal == 1) {
            i11 = Math.min(i11, 0);
        } else if (ordinal == 2) {
            i11 = Math.min(i11, 1);
        } else if (ordinal == 3) {
            i11 = Math.min(i11, 5);
        } else if (ordinal != 4) {
            i11 = Math.min(i11, -1);
        }
        if (sVar.A) {
            if (sVar.B) {
                i11 = Math.max(this.f774e, 2);
                View view = sVar.S;
                if (view != null && view.getParent() == null) {
                    i11 = Math.min(i11, 2);
                }
            } else {
                i11 = this.f774e < 4 ? Math.min(i11, sVar.f806o) : Math.min(i11, 1);
            }
        }
        if (!sVar.f816y) {
            i11 = Math.min(i11, 1);
        }
        ViewGroup viewGroup = sVar.R;
        if (viewGroup != null) {
            k f10 = k.f(viewGroup, sVar.k());
            u0 d6 = f10.d(sVar);
            int i12 = d6 != null ? d6.f831b : 0;
            ArrayList arrayList = f10.f720c;
            int size = arrayList.size();
            int i13 = 0;
            while (true) {
                if (i13 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i13);
                i13++;
                u0 u0Var = (u0) obj;
                if (za.h.a(u0Var.f832c, sVar) && !u0Var.f835f) {
                    break;
                }
            }
            u0 u0Var2 = (u0) obj;
            i10 = u0Var2 != null ? u0Var2.f831b : 0;
            int i14 = i12 == 0 ? -1 : w0.f846a[s.e.b(i12)];
            if (i14 != -1 && i14 != 1) {
                i10 = i12;
            }
        } else {
            i10 = 0;
        }
        if (i10 == 2) {
            i11 = Math.min(i11, 6);
        } else if (i10 == 3) {
            i11 = Math.max(i11, 3);
        } else if (sVar.f817z) {
            i11 = sVar.q() ? Math.min(i11, 1) : Math.min(i11, -1);
        }
        if (sVar.T && sVar.f806o < 5) {
            i11 = Math.min(i11, 4);
        }
        if (i0.F(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i11 + " for " + sVar);
        }
        return i11;
    }

    public final void e() {
        boolean F = i0.F(3);
        final s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "moveto CREATED: " + sVar);
        }
        Bundle bundle = sVar.f807p;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        if (sVar.X) {
            sVar.f806o = 1;
            sVar.G();
            return;
        }
        x4.c cVar = this.f770a;
        cVar.K(false);
        sVar.H.L();
        sVar.f806o = 1;
        sVar.Q = false;
        sVar.f800a0.a(new androidx.lifecycle.p() { // from class: androidx.fragment.app.Fragment$6
            @Override // androidx.lifecycle.p
            public final void a(androidx.lifecycle.r rVar, androidx.lifecycle.l lVar) {
                View view;
                if (lVar != androidx.lifecycle.l.ON_STOP || (view = s.this.S) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        sVar.u(bundle2);
        sVar.X = true;
        if (sVar.Q) {
            sVar.f800a0.d(androidx.lifecycle.l.ON_CREATE);
            cVar.F(false);
        } else {
            throw new x0("Fragment " + sVar + " did not call through to super.onCreate()");
        }
    }

    public final void f() {
        String str;
        s sVar = this.f772c;
        if (sVar.A) {
            return;
        }
        if (i0.F(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + sVar);
        }
        Bundle bundle = sVar.f807p;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater y8 = sVar.y(bundle2);
        ViewGroup viewGroup2 = sVar.R;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = sVar.K;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + sVar + " for a container view with no id");
                }
                viewGroup = (ViewGroup) sVar.F.f708u.F(i10);
                if (viewGroup == null) {
                    if (!sVar.C) {
                        try {
                            str = sVar.l().getResourceName(sVar.K);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(sVar.K) + " (" + str + ") for fragment " + sVar);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    y0.b bVar = y0.c.f13756a;
                    y0.c.b(new y0.a(sVar, "Attempting to add fragment " + sVar + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    y0.c.a(sVar).getClass();
                }
            }
        }
        sVar.R = viewGroup;
        sVar.D(y8, viewGroup, bundle2);
        if (sVar.S != null) {
            if (i0.F(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + sVar);
            }
            sVar.S.setSaveFromParentEnabled(false);
            sVar.S.setTag(R.id.fragment_container_view_tag, sVar);
            if (viewGroup != null) {
                b();
            }
            if (sVar.M) {
                sVar.S.setVisibility(8);
            }
            View view = sVar.S;
            WeakHashMap weakHashMap = m0.k0.f8683a;
            if (view.isAttachedToWindow()) {
                m0.a0.c(sVar.S);
            } else {
                View view2 = sVar.S;
                view2.addOnAttachStateChangeListener(new o0(0, view2));
            }
            Bundle bundle3 = sVar.f807p;
            if (bundle3 != null) {
                bundle3.getBundle("savedInstanceState");
            }
            sVar.H.t(2);
            this.f770a.P(false);
            int visibility = sVar.S.getVisibility();
            sVar.g().f792j = sVar.S.getAlpha();
            if (sVar.R != null && visibility == 0) {
                View findFocus = sVar.S.findFocus();
                if (findFocus != null) {
                    sVar.g().f793k = findFocus;
                    if (i0.F(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + sVar);
                    }
                }
                sVar.S.setAlpha(0.0f);
            }
        }
        sVar.f806o = 2;
    }

    public final void g() {
        s h10;
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "movefrom CREATED: " + sVar);
        }
        boolean z10 = true;
        int i10 = 0;
        boolean z11 = sVar.f817z && !sVar.q();
        x4.i iVar = this.f771b;
        if (z11) {
            iVar.y(sVar.f810s, null);
        }
        if (!z11) {
            l0 l0Var = (l0) iVar.f13556s;
            if (!((l0Var.f732c.containsKey(sVar.f810s) && l0Var.f735f) ? l0Var.g : true)) {
                String str = sVar.f813v;
                if (str != null && (h10 = iVar.h(str)) != null && h10.O) {
                    sVar.f812u = h10;
                }
                sVar.f806o = 0;
                return;
            }
        }
        u uVar = sVar.G;
        if (uVar != null) {
            z10 = ((l0) iVar.f13556s).g;
        } else {
            f.j jVar = uVar.f826t;
            if (r.a.k(jVar)) {
                z10 = true ^ jVar.isChangingConfigurations();
            }
        }
        if (z11 || z10) {
            ((l0) iVar.f13556s).b(sVar);
        }
        sVar.H.k();
        sVar.f800a0.d(androidx.lifecycle.l.ON_DESTROY);
        sVar.f806o = 0;
        sVar.Q = false;
        sVar.X = false;
        sVar.Q = true;
        if (!sVar.Q) {
            throw new x0("Fragment " + sVar + " did not call through to super.onDestroy()");
        }
        this.f770a.G(false);
        ArrayList k10 = iVar.k();
        int size = k10.size();
        while (i10 < size) {
            Object obj = k10.get(i10);
            i10++;
            p0 p0Var = (p0) obj;
            if (p0Var != null) {
                s sVar2 = p0Var.f772c;
                if (sVar.f810s.equals(sVar2.f813v)) {
                    sVar2.f812u = sVar;
                    sVar2.f813v = null;
                }
            }
        }
        String str2 = sVar.f813v;
        if (str2 != null) {
            sVar.f812u = iVar.h(str2);
        }
        iVar.q(this);
    }

    public final void h() {
        e1.a aVar;
        View view;
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + sVar);
        }
        ViewGroup viewGroup = sVar.R;
        if (viewGroup != null && (view = sVar.S) != null) {
            viewGroup.removeView(view);
        }
        sVar.H.t(1);
        if (sVar.S != null) {
            r0 r0Var = sVar.f801b0;
            r0Var.c();
            if (r0Var.f797r.f1158c.compareTo(androidx.lifecycle.m.f1146q) >= 0) {
                sVar.f801b0.a(androidx.lifecycle.l.ON_DESTROY);
            }
        }
        sVar.f806o = 1;
        sVar.Q = false;
        sVar.w();
        if (!sVar.Q) {
            throw new x0("Fragment " + sVar + " did not call through to super.onDestroyView()");
        }
        androidx.lifecycle.n0 e7 = sVar.e();
        za.h.e("store", e7);
        d1.a aVar2 = d1.a.f3994b;
        za.h.e("defaultCreationExtras", aVar2);
        String canonicalName = e1.a.class.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        String concat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
        za.h.e("key", concat);
        LinkedHashMap linkedHashMap = e7.f1152a;
        androidx.lifecycle.l0 l0Var = (androidx.lifecycle.l0) linkedHashMap.get(concat);
        if (e1.a.class.isInstance(l0Var)) {
            za.h.c("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get", l0Var);
        } else {
            ((LinkedHashMap) new d1.b(aVar2).f2162a).put(androidx.lifecycle.m0.f1151b, concat);
            try {
                aVar = new e1.a();
            } catch (AbstractMethodError unused) {
                aVar = new e1.a();
            }
            l0Var = aVar;
            androidx.lifecycle.l0 l0Var2 = (androidx.lifecycle.l0) linkedHashMap.put(concat, l0Var);
            if (l0Var2 != null) {
                l0Var2.a();
            }
        }
        p.j jVar = ((e1.a) l0Var).f4409c;
        if (jVar.f9784q > 0) {
            jVar.f9783p[0].getClass();
            throw new ClassCastException();
        }
        sVar.D = false;
        this.f770a.Q(false);
        sVar.R = null;
        sVar.S = null;
        sVar.f801b0 = null;
        sVar.f802c0.e(null);
        sVar.B = false;
    }

    public final void i() {
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + sVar);
        }
        sVar.f806o = -1;
        sVar.Q = false;
        sVar.x();
        if (!sVar.Q) {
            throw new x0("Fragment " + sVar + " did not call through to super.onDetach()");
        }
        j0 j0Var = sVar.H;
        if (!j0Var.G) {
            j0Var.k();
            sVar.H = new j0();
        }
        this.f770a.H(false);
        sVar.f806o = -1;
        sVar.G = null;
        sVar.I = null;
        sVar.F = null;
        if (!sVar.f817z || sVar.q()) {
            l0 l0Var = (l0) this.f771b.f13556s;
            if (!((l0Var.f732c.containsKey(sVar.f810s) && l0Var.f735f) ? l0Var.g : true)) {
                return;
            }
        }
        if (i0.F(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + sVar);
        }
        sVar.n();
    }

    public final void j() {
        s sVar = this.f772c;
        if (sVar.A && sVar.B && !sVar.D) {
            if (i0.F(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + sVar);
            }
            Bundle bundle = sVar.f807p;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            sVar.D(sVar.y(bundle2), null, bundle2);
            View view = sVar.S;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                sVar.S.setTag(R.id.fragment_container_view_tag, sVar);
                if (sVar.M) {
                    sVar.S.setVisibility(8);
                }
                Bundle bundle3 = sVar.f807p;
                if (bundle3 != null) {
                    bundle3.getBundle("savedInstanceState");
                }
                sVar.H.t(2);
                this.f770a.P(false);
                sVar.f806o = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        x4.i iVar = this.f771b;
        boolean z10 = this.f773d;
        s sVar = this.f772c;
        if (z10) {
            if (i0.F(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + sVar);
                return;
            }
            return;
        }
        try {
            this.f773d = true;
            boolean z11 = false;
            while (true) {
                int d6 = d();
                int i10 = sVar.f806o;
                int i11 = 3;
                if (d6 == i10) {
                    if (!z11 && i10 == -1 && sVar.f817z && !sVar.q()) {
                        if (i0.F(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + sVar);
                        }
                        ((l0) iVar.f13556s).b(sVar);
                        iVar.q(this);
                        if (i0.F(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + sVar);
                        }
                        sVar.n();
                    }
                    if (sVar.W) {
                        if (sVar.S != null && (viewGroup = sVar.R) != null) {
                            k f10 = k.f(viewGroup, sVar.k());
                            if (sVar.M) {
                                if (i0.F(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + sVar);
                                }
                                f10.a(3, 1, this);
                            } else {
                                if (i0.F(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + sVar);
                                }
                                f10.a(2, 1, this);
                            }
                        }
                        i0 i0Var = sVar.F;
                        if (i0Var != null && sVar.f816y && i0.G(sVar)) {
                            i0Var.D = true;
                        }
                        sVar.W = false;
                        sVar.H.n();
                    }
                    this.f773d = false;
                    return;
                }
                if (d6 <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            sVar.f806o = 1;
                            break;
                        case 2:
                            sVar.B = false;
                            sVar.f806o = 2;
                            break;
                        case 3:
                            if (i0.F(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + sVar);
                            }
                            if (sVar.S != null && sVar.f808q == null) {
                                o();
                            }
                            if (sVar.S != null && (viewGroup2 = sVar.R) != null) {
                                k f11 = k.f(viewGroup2, sVar.k());
                                if (i0.F(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + sVar);
                                }
                                f11.a(1, 3, this);
                            }
                            sVar.f806o = 3;
                            break;
                        case 4:
                            q();
                            break;
                        case 5:
                            sVar.f806o = 5;
                            break;
                        case 6:
                            l();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (sVar.S != null && (viewGroup3 = sVar.R) != null) {
                                k f12 = k.f(viewGroup3, sVar.k());
                                int visibility = sVar.S.getVisibility();
                                if (visibility == 0) {
                                    i11 = 2;
                                } else if (visibility == 4) {
                                    i11 = 4;
                                } else if (visibility != 8) {
                                    throw new IllegalArgumentException("Unknown visibility " + visibility);
                                }
                                r.a.h(i11, "finalState");
                                if (i0.F(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + sVar);
                                }
                                f12.a(i11, 2, this);
                            }
                            sVar.f806o = 4;
                            break;
                        case 5:
                            p();
                            break;
                        case 6:
                            sVar.f806o = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
                z11 = true;
            }
        } catch (Throwable th) {
            this.f773d = false;
            throw th;
        }
    }

    public final void l() {
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "movefrom RESUMED: " + sVar);
        }
        sVar.H.t(5);
        if (sVar.S != null) {
            sVar.f801b0.a(androidx.lifecycle.l.ON_PAUSE);
        }
        sVar.f800a0.d(androidx.lifecycle.l.ON_PAUSE);
        sVar.f806o = 6;
        sVar.Q = true;
        this.f770a.I(false);
    }

    public final void m(ClassLoader classLoader) {
        s sVar = this.f772c;
        Bundle bundle = sVar.f807p;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (sVar.f807p.getBundle("savedInstanceState") == null) {
            sVar.f807p.putBundle("savedInstanceState", new Bundle());
        }
        sVar.f808q = sVar.f807p.getSparseParcelableArray("viewState");
        sVar.f809r = sVar.f807p.getBundle("viewRegistryState");
        n0 n0Var = (n0) sVar.f807p.getParcelable("state");
        if (n0Var != null) {
            sVar.f813v = n0Var.f751z;
            sVar.f814w = n0Var.A;
            sVar.U = n0Var.B;
        }
        if (sVar.U) {
            return;
        }
        sVar.T = true;
    }

    public final void n() {
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "moveto RESUMED: " + sVar);
        }
        r rVar = sVar.V;
        View view = rVar == null ? null : rVar.f793k;
        if (view != null) {
            if (view != sVar.S) {
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != sVar.S) {
                    }
                }
            }
            boolean requestFocus = view.requestFocus();
            if (i0.F(2)) {
                StringBuilder sb2 = new StringBuilder("requestFocus: Restoring focused view ");
                sb2.append(view);
                sb2.append(" ");
                sb2.append(requestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(sVar);
                sb2.append(" resulting in focused view ");
                sb2.append(sVar.S.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        sVar.g().f793k = null;
        sVar.H.L();
        sVar.H.x(true);
        sVar.f806o = 7;
        sVar.Q = false;
        sVar.Q = true;
        if (!sVar.Q) {
            throw new x0("Fragment " + sVar + " did not call through to super.onResume()");
        }
        androidx.lifecycle.t tVar = sVar.f800a0;
        androidx.lifecycle.l lVar = androidx.lifecycle.l.ON_RESUME;
        tVar.d(lVar);
        if (sVar.S != null) {
            sVar.f801b0.f797r.d(lVar);
        }
        j0 j0Var = sVar.H;
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(7);
        this.f770a.L(false);
        this.f771b.y(sVar.f810s, null);
        sVar.f807p = null;
        sVar.f808q = null;
        sVar.f809r = null;
    }

    public final void o() {
        s sVar = this.f772c;
        if (sVar.S == null) {
            return;
        }
        if (i0.F(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + sVar + " with view " + sVar.S);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        sVar.S.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            sVar.f808q = sparseArray;
        }
        Bundle bundle = new Bundle();
        sVar.f801b0.f798s.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        sVar.f809r = bundle;
    }

    public final void p() {
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "moveto STARTED: " + sVar);
        }
        sVar.H.L();
        sVar.H.x(true);
        sVar.f806o = 5;
        sVar.Q = false;
        sVar.A();
        if (!sVar.Q) {
            throw new x0("Fragment " + sVar + " did not call through to super.onStart()");
        }
        androidx.lifecycle.t tVar = sVar.f800a0;
        androidx.lifecycle.l lVar = androidx.lifecycle.l.ON_START;
        tVar.d(lVar);
        if (sVar.S != null) {
            sVar.f801b0.f797r.d(lVar);
        }
        j0 j0Var = sVar.H;
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(5);
        this.f770a.N(false);
    }

    public final void q() {
        boolean F = i0.F(3);
        s sVar = this.f772c;
        if (F) {
            Log.d("FragmentManager", "movefrom STARTED: " + sVar);
        }
        j0 j0Var = sVar.H;
        j0Var.F = true;
        j0Var.L.f736h = true;
        j0Var.t(4);
        if (sVar.S != null) {
            sVar.f801b0.a(androidx.lifecycle.l.ON_STOP);
        }
        sVar.f800a0.d(androidx.lifecycle.l.ON_STOP);
        sVar.f806o = 4;
        sVar.Q = false;
        sVar.B();
        if (sVar.Q) {
            this.f770a.O(false);
            return;
        }
        throw new x0("Fragment " + sVar + " did not call through to super.onStop()");
    }

    public p0(x4.c cVar, x4.i iVar, ClassLoader classLoader, c0 c0Var, Bundle bundle) {
        this.f770a = cVar;
        this.f771b = iVar;
        n0 n0Var = (n0) bundle.getParcelable("state");
        s a10 = c0Var.a(n0Var.f740o);
        a10.f810s = n0Var.f741p;
        a10.A = n0Var.f742q;
        a10.C = true;
        a10.J = n0Var.f743r;
        a10.K = n0Var.f744s;
        a10.L = n0Var.f745t;
        a10.O = n0Var.f746u;
        a10.f817z = n0Var.f747v;
        a10.N = n0Var.f748w;
        a10.M = n0Var.f749x;
        a10.Z = androidx.lifecycle.m.values()[n0Var.f750y];
        a10.f813v = n0Var.f751z;
        a10.f814w = n0Var.A;
        a10.U = n0Var.B;
        this.f772c = a10;
        a10.f807p = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        a10.I(bundle2);
        if (i0.F(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a10);
        }
    }

    public p0(x4.c cVar, x4.i iVar, s sVar, Bundle bundle) {
        this.f770a = cVar;
        this.f771b = iVar;
        this.f772c = sVar;
        sVar.f808q = null;
        sVar.f809r = null;
        sVar.E = 0;
        sVar.B = false;
        sVar.f816y = false;
        s sVar2 = sVar.f812u;
        sVar.f813v = sVar2 != null ? sVar2.f810s : null;
        sVar.f812u = null;
        sVar.f807p = bundle;
        sVar.f811t = bundle.getBundle("arguments");
    }
}
