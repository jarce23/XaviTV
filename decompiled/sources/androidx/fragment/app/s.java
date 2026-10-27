package androidx.fragment.app;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class s implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.r, androidx.lifecycle.o0, androidx.lifecycle.h, f4.e {

    /* renamed from: g0, reason: collision with root package name */
    public static final Object f799g0 = new Object();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public i0 F;
    public u G;
    public s I;
    public int J;
    public int K;
    public String L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean Q;
    public ViewGroup R;
    public View S;
    public boolean T;
    public r V;
    public boolean W;
    public boolean X;
    public String Y;
    public androidx.lifecycle.m Z;

    /* renamed from: a0, reason: collision with root package name */
    public androidx.lifecycle.t f800a0;

    /* renamed from: b0, reason: collision with root package name */
    public r0 f801b0;

    /* renamed from: c0, reason: collision with root package name */
    public final androidx.lifecycle.y f802c0;

    /* renamed from: d0, reason: collision with root package name */
    public com.bumptech.glide.manager.t f803d0;

    /* renamed from: e0, reason: collision with root package name */
    public final ArrayList f804e0;

    /* renamed from: f0, reason: collision with root package name */
    public final p f805f0;

    /* renamed from: p, reason: collision with root package name */
    public Bundle f807p;

    /* renamed from: q, reason: collision with root package name */
    public SparseArray f808q;

    /* renamed from: r, reason: collision with root package name */
    public Bundle f809r;

    /* renamed from: t, reason: collision with root package name */
    public Bundle f811t;

    /* renamed from: u, reason: collision with root package name */
    public s f812u;

    /* renamed from: w, reason: collision with root package name */
    public int f814w;

    /* renamed from: y, reason: collision with root package name */
    public boolean f816y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f817z;

    /* renamed from: o, reason: collision with root package name */
    public int f806o = -1;

    /* renamed from: s, reason: collision with root package name */
    public String f810s = UUID.randomUUID().toString();

    /* renamed from: v, reason: collision with root package name */
    public String f813v = null;

    /* renamed from: x, reason: collision with root package name */
    public Boolean f815x = null;
    public j0 H = new j0();
    public final boolean P = true;
    public boolean U = true;

    public s() {
        new androidx.activity.j(2, this);
        this.Z = androidx.lifecycle.m.f1148s;
        this.f802c0 = new androidx.lifecycle.y();
        new AtomicInteger();
        this.f804e0 = new ArrayList();
        this.f805f0 = new p(this);
        m();
    }

    public void A() {
        this.Q = true;
    }

    public void B() {
        this.Q = true;
    }

    public void C(Bundle bundle) {
        this.Q = true;
    }

    public void D(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.H.L();
        this.D = true;
        this.f801b0 = new r0(this, e(), new androidx.activity.d(4, this));
        View v10 = v(layoutInflater, viewGroup);
        this.S = v10;
        if (v10 == null) {
            if (this.f801b0.f797r != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f801b0 = null;
            return;
        }
        this.f801b0.c();
        if (i0.F(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.S + " for Fragment " + this);
        }
        View view = this.S;
        r0 r0Var = this.f801b0;
        za.h.e("<this>", view);
        view.setTag(R.id.view_tree_lifecycle_owner, r0Var);
        View view2 = this.S;
        r0 r0Var2 = this.f801b0;
        za.h.e("<this>", view2);
        view2.setTag(R.id.view_tree_view_model_store_owner, r0Var2);
        View view3 = this.S;
        r0 r0Var3 = this.f801b0;
        za.h.e("<this>", view3);
        view3.setTag(R.id.view_tree_saved_state_registry_owner, r0Var3);
        this.f802c0.e(this.f801b0);
    }

    public final Context E() {
        Context i10 = i();
        if (i10 != null) {
            return i10;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View F() {
        View view = this.S;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final void G() {
        Bundle bundle;
        Bundle bundle2 = this.f807p;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.H.R(bundle);
        j0 j0Var = this.H;
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(1);
    }

    public final void H(int i10, int i11, int i12, int i13) {
        if (this.V == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        g().f785b = i10;
        g().f786c = i11;
        g().f787d = i12;
        g().f788e = i13;
    }

    public final void I(Bundle bundle) {
        i0 i0Var = this.F;
        if (i0Var != null && (i0Var.E || i0Var.F)) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f811t = bundle;
    }

    @Override // f4.e
    public final f4.d b() {
        return (f4.d) this.f803d0.f3099d;
    }

    public x4.f c() {
        return new q(this);
    }

    @Override // androidx.lifecycle.h
    public final d1.b d() {
        Application application;
        Context applicationContext = E().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && i0.F(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + E().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        d1.b bVar = new d1.b();
        LinkedHashMap linkedHashMap = (LinkedHashMap) bVar.f2162a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.m0.f1150a, application);
        }
        linkedHashMap.put(androidx.lifecycle.g0.f1128a, this);
        linkedHashMap.put(androidx.lifecycle.g0.f1129b, this);
        Bundle bundle = this.f811t;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.g0.f1130c, bundle);
        }
        return bVar;
    }

    @Override // androidx.lifecycle.o0
    public final androidx.lifecycle.n0 e() {
        if (this.F == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (j() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap hashMap = this.F.L.f734e;
        androidx.lifecycle.n0 n0Var = (androidx.lifecycle.n0) hashMap.get(this.f810s);
        if (n0Var != null) {
            return n0Var;
        }
        androidx.lifecycle.n0 n0Var2 = new androidx.lifecycle.n0();
        hashMap.put(this.f810s, n0Var2);
        return n0Var2;
    }

    @Override // androidx.lifecycle.r
    public final androidx.lifecycle.t f() {
        return this.f800a0;
    }

    public final r g() {
        if (this.V == null) {
            r rVar = new r();
            Object obj = f799g0;
            rVar.g = obj;
            rVar.f790h = obj;
            rVar.f791i = obj;
            rVar.f792j = 1.0f;
            rVar.f793k = null;
            this.V = rVar;
        }
        return this.V;
    }

    public final i0 h() {
        if (this.G != null) {
            return this.H;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Context i() {
        u uVar = this.G;
        if (uVar == null) {
            return null;
        }
        return uVar.f826t;
    }

    public final int j() {
        androidx.lifecycle.m mVar = this.Z;
        return (mVar == androidx.lifecycle.m.f1145p || this.I == null) ? mVar.ordinal() : Math.min(mVar.ordinal(), this.I.j());
    }

    public final i0 k() {
        i0 i0Var = this.F;
        if (i0Var != null) {
            return i0Var;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Resources l() {
        return E().getResources();
    }

    public final void m() {
        this.f800a0 = new androidx.lifecycle.t(this);
        this.f803d0 = new com.bumptech.glide.manager.t(this);
        ArrayList arrayList = this.f804e0;
        p pVar = this.f805f0;
        if (arrayList.contains(pVar)) {
            return;
        }
        if (this.f806o < 0) {
            arrayList.add(pVar);
            return;
        }
        s sVar = pVar.f769a;
        sVar.f803d0.c();
        androidx.lifecycle.g0.a(sVar);
        Bundle bundle = sVar.f807p;
        sVar.f803d0.d(bundle != null ? bundle.getBundle("registryState") : null);
    }

    public final void n() {
        m();
        this.Y = this.f810s;
        this.f810s = UUID.randomUUID().toString();
        this.f816y = false;
        this.f817z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.E = 0;
        this.F = null;
        this.H = new j0();
        this.G = null;
        this.J = 0;
        this.K = 0;
        this.L = null;
        this.M = false;
        this.N = false;
    }

    public final boolean o() {
        return this.G != null && this.f816y;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.Q = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        u uVar = this.G;
        f.j jVar = uVar == null ? null : uVar.f825s;
        if (jVar != null) {
            jVar.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.Q = true;
    }

    public final boolean p() {
        if (this.M) {
            return true;
        }
        i0 i0Var = this.F;
        if (i0Var != null) {
            s sVar = this.I;
            i0Var.getClass();
            if (sVar == null ? false : sVar.p()) {
                return true;
            }
        }
        return false;
    }

    public final boolean q() {
        return this.E > 0;
    }

    public void r() {
        this.Q = true;
    }

    public void s(int i10, int i11, Intent intent) {
        if (i0.F(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i10 + " resultCode: " + i11 + " data: " + intent);
        }
    }

    public void t(Context context) {
        this.Q = true;
        u uVar = this.G;
        if ((uVar == null ? null : uVar.f825s) != null) {
            this.Q = true;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} (");
        sb2.append(this.f810s);
        if (this.J != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.J));
        }
        if (this.L != null) {
            sb2.append(" tag=");
            sb2.append(this.L);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void u(Bundle bundle) {
        this.Q = true;
        G();
        j0 j0Var = this.H;
        if (j0Var.f706s >= 1) {
            return;
        }
        j0Var.E = false;
        j0Var.F = false;
        j0Var.L.f736h = false;
        j0Var.t(1);
    }

    public View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void w() {
        this.Q = true;
    }

    public void x() {
        this.Q = true;
    }

    public LayoutInflater y(Bundle bundle) {
        u uVar = this.G;
        if (uVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        f.j jVar = uVar.f829w;
        LayoutInflater cloneInContext = jVar.getLayoutInflater().cloneInContext(jVar);
        cloneInContext.setFactory2(this.H.f694f);
        return cloneInContext;
    }

    public abstract void z(Bundle bundle);
}
