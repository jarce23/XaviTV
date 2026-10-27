package b4;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f1 {

    /* renamed from: t, reason: collision with root package name */
    public static final List f2231t = Collections.EMPTY_LIST;

    /* renamed from: a, reason: collision with root package name */
    public final View f2232a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f2233b;

    /* renamed from: j, reason: collision with root package name */
    public int f2240j;

    /* renamed from: r, reason: collision with root package name */
    public RecyclerView f2248r;

    /* renamed from: s, reason: collision with root package name */
    public f0 f2249s;

    /* renamed from: c, reason: collision with root package name */
    public int f2234c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f2235d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f2236e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f2237f = -1;
    public int g = -1;

    /* renamed from: h, reason: collision with root package name */
    public f1 f2238h = null;

    /* renamed from: i, reason: collision with root package name */
    public f1 f2239i = null;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f2241k = null;

    /* renamed from: l, reason: collision with root package name */
    public List f2242l = null;

    /* renamed from: m, reason: collision with root package name */
    public int f2243m = 0;

    /* renamed from: n, reason: collision with root package name */
    public u0 f2244n = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2245o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f2246p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f2247q = -1;

    public f1(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f2232a = view;
    }

    public final void a(int i10) {
        this.f2240j = i10 | this.f2240j;
    }

    public final int b() {
        RecyclerView recyclerView;
        f0 adapter;
        int G;
        if (this.f2249s == null || (recyclerView = this.f2248r) == null || (adapter = recyclerView.getAdapter()) == null || (G = this.f2248r.G(this)) == -1 || this.f2249s != adapter) {
            return -1;
        }
        return G;
    }

    public final int c() {
        int i10 = this.g;
        return i10 == -1 ? this.f2234c : i10;
    }

    public final List d() {
        ArrayList arrayList;
        return ((this.f2240j & 1024) != 0 || (arrayList = this.f2241k) == null || arrayList.size() == 0) ? f2231t : this.f2242l;
    }

    public final boolean e() {
        View view = this.f2232a;
        return (view.getParent() == null || view.getParent() == this.f2248r) ? false : true;
    }

    public final boolean f() {
        return (this.f2240j & 1) != 0;
    }

    public final boolean g() {
        return (this.f2240j & 4) != 0;
    }

    public final boolean h() {
        if ((this.f2240j & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = m0.k0.f8683a;
        return !this.f2232a.hasTransientState();
    }

    public final boolean i() {
        return (this.f2240j & 8) != 0;
    }

    public final boolean j() {
        return this.f2244n != null;
    }

    public final boolean k() {
        return (this.f2240j & 256) != 0;
    }

    public final boolean l() {
        return (this.f2240j & 2) != 0;
    }

    public final void m(int i10, boolean z10) {
        if (this.f2235d == -1) {
            this.f2235d = this.f2234c;
        }
        if (this.g == -1) {
            this.g = this.f2234c;
        }
        if (z10) {
            this.g += i10;
        }
        this.f2234c += i10;
        View view = this.f2232a;
        if (view.getLayoutParams() != null) {
            ((p0) view.getLayoutParams()).f2383c = true;
        }
    }

    public final void n() {
        this.f2240j = 0;
        this.f2234c = -1;
        this.f2235d = -1;
        this.f2236e = -1L;
        this.g = -1;
        this.f2243m = 0;
        this.f2238h = null;
        this.f2239i = null;
        ArrayList arrayList = this.f2241k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f2240j &= -1025;
        this.f2246p = 0;
        this.f2247q = -1;
        RecyclerView.j(this);
    }

    public final void o(boolean z10) {
        int i10 = this.f2243m;
        int i11 = z10 ? i10 - 1 : i10 + 1;
        this.f2243m = i11;
        if (i11 < 0) {
            this.f2243m = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        }
        if (!z10 && i11 == 1) {
            this.f2240j |= 16;
        } else if (z10 && i11 == 0) {
            this.f2240j &= -17;
        }
    }

    public final boolean p() {
        return (this.f2240j & 128) != 0;
    }

    public final boolean q() {
        return (this.f2240j & 32) != 0;
    }

    public final String toString() {
        StringBuilder a10 = s.e.a(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
        a10.append(Integer.toHexString(hashCode()));
        a10.append(" position=");
        a10.append(this.f2234c);
        a10.append(" id=");
        a10.append(this.f2236e);
        a10.append(", oldPos=");
        a10.append(this.f2235d);
        a10.append(", pLpos:");
        a10.append(this.g);
        StringBuilder sb2 = new StringBuilder(a10.toString());
        if (j()) {
            sb2.append(" scrap ");
            sb2.append(this.f2245o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (g()) {
            sb2.append(" invalid");
        }
        if (!f()) {
            sb2.append(" unbound");
        }
        if ((this.f2240j & 2) != 0) {
            sb2.append(" update");
        }
        if (i()) {
            sb2.append(" removed");
        }
        if (p()) {
            sb2.append(" ignored");
        }
        if (k()) {
            sb2.append(" tmpDetached");
        }
        if (!h()) {
            sb2.append(" not recyclable(" + this.f2243m + ")");
        }
        if ((this.f2240j & 512) != 0 || g()) {
            sb2.append(" undefined adapter position");
        }
        if (this.f2232a.getParent() == null) {
            sb2.append(" no parent");
        }
        sb2.append("}");
        return sb2.toString();
    }
}
