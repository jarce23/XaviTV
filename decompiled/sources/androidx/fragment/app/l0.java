package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 extends androidx.lifecycle.l0 {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f735f;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f732c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f733d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f734e = new HashMap();
    public boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f736h = false;

    public l0(boolean z10) {
        this.f735f = z10;
    }

    @Override // androidx.lifecycle.l0
    public final void a() {
        if (i0.F(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.g = true;
    }

    public final void b(s sVar) {
        if (i0.F(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + sVar);
        }
        c(sVar.f810s);
    }

    public final void c(String str) {
        HashMap hashMap = this.f733d;
        l0 l0Var = (l0) hashMap.get(str);
        if (l0Var != null) {
            l0Var.a();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f734e;
        androidx.lifecycle.n0 n0Var = (androidx.lifecycle.n0) hashMap2.get(str);
        if (n0Var != null) {
            n0Var.a();
            hashMap2.remove(str);
        }
    }

    public final void d(s sVar) {
        if (this.f736h) {
            if (i0.F(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f732c.remove(sVar.f810s) == null || !i0.F(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + sVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l0.class == obj.getClass()) {
            l0 l0Var = (l0) obj;
            if (this.f732c.equals(l0Var.f732c) && this.f733d.equals(l0Var.f733d) && this.f734e.equals(l0Var.f734e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f734e.hashCode() + ((this.f733d.hashCode() + (this.f732c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f732c.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f733d.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f734e.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
