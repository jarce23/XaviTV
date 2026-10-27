package b4;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import j9.w1;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2350a;

    /* renamed from: b, reason: collision with root package name */
    public int f2351b;

    /* renamed from: c, reason: collision with root package name */
    public int f2352c;

    /* renamed from: d, reason: collision with root package name */
    public int f2353d;

    /* renamed from: e, reason: collision with root package name */
    public int f2354e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f2355f;
    public final Object g;

    public n1(int i10) {
        this.f2350a = 1;
        this.f2351b = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2355f = new c4.k(2);
        this.g = new w1(11);
    }

    public void a() {
        View view = (View) ((ArrayList) this.f2355f).get(r0.size() - 1);
        k1 k1Var = (k1) view.getLayoutParams();
        this.f2352c = ((StaggeredGridLayoutManager) this.g).f1498r.b(view);
        k1Var.getClass();
    }

    public void b() {
        ((ArrayList) this.f2355f).clear();
        this.f2351b = Integer.MIN_VALUE;
        this.f2352c = Integer.MIN_VALUE;
        this.f2353d = 0;
    }

    public int c() {
        return ((StaggeredGridLayoutManager) this.g).f1503w ? e(r0.size() - 1, -1) : e(0, ((ArrayList) this.f2355f).size());
    }

    public int d() {
        return ((StaggeredGridLayoutManager) this.g).f1503w ? e(0, ((ArrayList) this.f2355f).size()) : e(r0.size() - 1, -1);
    }

    public int e(int i10, int i11) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        int k10 = staggeredGridLayoutManager.f1498r.k();
        int g = staggeredGridLayoutManager.f1498r.g();
        int i12 = i11 > i10 ? 1 : -1;
        while (i10 != i11) {
            View view = (View) ((ArrayList) this.f2355f).get(i10);
            int e7 = staggeredGridLayoutManager.f1498r.e(view);
            int b2 = staggeredGridLayoutManager.f1498r.b(view);
            boolean z10 = e7 <= g;
            boolean z11 = b2 >= k10;
            if (z10 && z11 && (e7 < k10 || b2 > g)) {
                return o0.N(view);
            }
            i10 += i12;
        }
        return -1;
    }

    public Object f(Object obj) {
        za.h.e("key", obj);
        synchronized (((w1) this.g)) {
            c4.k kVar = (c4.k) this.f2355f;
            kVar.getClass();
            Object obj2 = kVar.f2908a.get(obj);
            if (obj2 != null) {
                this.f2353d++;
                return obj2;
            }
            this.f2354e++;
            return null;
        }
    }

    public int g(int i10) {
        int i11 = this.f2352c;
        if (i11 != Integer.MIN_VALUE) {
            return i11;
        }
        if (((ArrayList) this.f2355f).size() == 0) {
            return i10;
        }
        a();
        return this.f2352c;
    }

    public View h(int i10, int i11) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        ArrayList arrayList = (ArrayList) this.f2355f;
        View view = null;
        if (i11 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f1503w && o0.N(view2) >= i10) || ((!staggeredGridLayoutManager.f1503w && o0.N(view2) <= i10) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i12 = 0;
        while (i12 < size2) {
            View view3 = (View) arrayList.get(i12);
            if ((staggeredGridLayoutManager.f1503w && o0.N(view3) <= i10) || ((!staggeredGridLayoutManager.f1503w && o0.N(view3) >= i10) || !view3.hasFocusable())) {
                break;
            }
            i12++;
            view = view3;
        }
        return view;
    }

    public int i(int i10) {
        ArrayList arrayList = (ArrayList) this.f2355f;
        int i11 = this.f2351b;
        if (i11 != Integer.MIN_VALUE) {
            return i11;
        }
        if (arrayList.size() == 0) {
            return i10;
        }
        View view = (View) arrayList.get(0);
        k1 k1Var = (k1) view.getLayoutParams();
        this.f2351b = ((StaggeredGridLayoutManager) this.g).f1498r.e(view);
        k1Var.getClass();
        return this.f2351b;
    }

    public int j() {
        int i10;
        synchronized (((w1) this.g)) {
            i10 = this.f2351b;
        }
        return i10;
    }

    public Object k(Object obj, Object obj2) {
        Object put;
        za.h.e("key", obj);
        za.h.e("value", obj2);
        synchronized (((w1) this.g)) {
            this.f2352c++;
            c4.k kVar = (c4.k) this.f2355f;
            kVar.getClass();
            put = kVar.f2908a.put(obj, obj2);
            if (put != null) {
                this.f2352c--;
            }
        }
        n(this.f2351b);
        return put;
    }

    public Object l(String str) {
        Object remove;
        za.h.e("key", str);
        synchronized (((w1) this.g)) {
            c4.k kVar = (c4.k) this.f2355f;
            kVar.getClass();
            remove = kVar.f2908a.remove(str);
            if (remove != null) {
                this.f2352c--;
            }
        }
        return remove;
    }

    public int m() {
        int i10;
        synchronized (((w1) this.g)) {
            i10 = this.f2352c;
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0096, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(int r6) {
        /*
            r5 = this;
        L0:
            java.lang.Object r0 = r5.g
            j9.w1 r0 = (j9.w1) r0
            monitor-enter(r0)
            int r1 = r5.f2352c     // Catch: java.lang.Throwable -> L1a
            if (r1 < 0) goto L8f
            java.lang.Object r1 = r5.f2355f     // Catch: java.lang.Throwable -> L1a
            c4.k r1 = (c4.k) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f2908a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1d
            int r1 = r5.f2352c     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L8f
            goto L1d
        L1a:
            r6 = move-exception
            goto L97
        L1d:
            int r1 = r5.f2352c     // Catch: java.lang.Throwable -> L1a
            if (r1 <= r6) goto L8d
            java.lang.Object r1 = r5.f2355f     // Catch: java.lang.Throwable -> L1a
            c4.k r1 = (c4.k) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f2908a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L2e
            goto L8d
        L2e:
            java.lang.Object r1 = r5.f2355f     // Catch: java.lang.Throwable -> L1a
            c4.k r1 = (c4.k) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f2908a     // Catch: java.lang.Throwable -> L1a
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "map.entries"
            za.h.d(r2, r1)     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L1a
            r3 = 0
            if (r2 == 0) goto L51
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r2 == 0) goto L4b
            goto L60
        L4b:
            r2 = 0
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L1a
            goto L60
        L51:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L5c
            goto L60
        L5c:
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L1a
        L60:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L66
            monitor-exit(r0)
            return
        L66:
            java.lang.Object r1 = r3.getKey()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r2 = r3.getValue()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r3 = r5.f2355f     // Catch: java.lang.Throwable -> L1a
            c4.k r3 = (c4.k) r3     // Catch: java.lang.Throwable -> L1a
            r3.getClass()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "key"
            za.h.e(r4, r1)     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r3 = r3.f2908a     // Catch: java.lang.Throwable -> L1a
            r3.remove(r1)     // Catch: java.lang.Throwable -> L1a
            int r1 = r5.f2352c     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "value"
            za.h.e(r3, r2)     // Catch: java.lang.Throwable -> L1a
            int r1 = r1 + (-1)
            r5.f2352c = r1     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r0)
            goto L0
        L8d:
            monitor-exit(r0)
            return
        L8f:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L1a
            throw r1     // Catch: java.lang.Throwable -> L1a
        L97:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.n1.n(int):void");
    }

    public String toString() {
        String str;
        switch (this.f2350a) {
            case 1:
                synchronized (((w1) this.g)) {
                    try {
                        int i10 = this.f2353d;
                        int i11 = this.f2354e + i10;
                        str = "LruCache[maxSize=" + this.f2351b + ",hits=" + this.f2353d + ",misses=" + this.f2354e + ",hitRate=" + (i11 != 0 ? (i10 * 100) / i11 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public n1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i10) {
        this.f2350a = 0;
        this.g = staggeredGridLayoutManager;
        this.f2355f = new ArrayList();
        this.f2351b = Integer.MIN_VALUE;
        this.f2352c = Integer.MIN_VALUE;
        this.f2353d = 0;
        this.f2354e = i10;
    }
}
