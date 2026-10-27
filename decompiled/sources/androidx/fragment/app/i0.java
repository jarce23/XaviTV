package androidx.fragment.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i0 {
    public androidx.activity.result.d A;
    public androidx.activity.result.d B;
    public ArrayDeque C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public l0 L;
    public final androidx.activity.j M;

    /* renamed from: b, reason: collision with root package name */
    public boolean f690b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f692d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f693e;
    public androidx.activity.y g;

    /* renamed from: l, reason: collision with root package name */
    public final x4.c f699l;

    /* renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArrayList f700m;

    /* renamed from: n, reason: collision with root package name */
    public final y f701n;

    /* renamed from: o, reason: collision with root package name */
    public final y f702o;

    /* renamed from: p, reason: collision with root package name */
    public final y f703p;

    /* renamed from: q, reason: collision with root package name */
    public final y f704q;

    /* renamed from: r, reason: collision with root package name */
    public final b0 f705r;

    /* renamed from: s, reason: collision with root package name */
    public int f706s;

    /* renamed from: t, reason: collision with root package name */
    public u f707t;

    /* renamed from: u, reason: collision with root package name */
    public x4.f f708u;

    /* renamed from: v, reason: collision with root package name */
    public s f709v;

    /* renamed from: w, reason: collision with root package name */
    public s f710w;

    /* renamed from: x, reason: collision with root package name */
    public final c0 f711x;

    /* renamed from: y, reason: collision with root package name */
    public final n7.i f712y;

    /* renamed from: z, reason: collision with root package name */
    public androidx.activity.result.d f713z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f689a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final x4.i f691c = new x4.i(3);

    /* renamed from: f, reason: collision with root package name */
    public final x f694f = new x(this);

    /* renamed from: h, reason: collision with root package name */
    public final a0 f695h = new a0(this);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f696i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map f697j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    public final Map f698k = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.y] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.y] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.y] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.y] */
    public i0() {
        Collections.synchronizedMap(new HashMap());
        this.f699l = new x4.c(this);
        this.f700m = new CopyOnWriteArrayList();
        final int i10 = 0;
        this.f701n = new l0.a(this) { // from class: androidx.fragment.app.y

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i0 f849b;

            {
                this.f849b = this;
            }

            @Override // l0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        i0 i0Var = this.f849b;
                        if (i0Var.H()) {
                            i0Var.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        i0 i0Var2 = this.f849b;
                        if (i0Var2.H() && num.intValue() == 80) {
                            i0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        b0.f fVar = (b0.f) obj;
                        i0 i0Var3 = this.f849b;
                        if (i0Var3.H()) {
                            boolean z10 = fVar.f2136a;
                            i0Var3.m(false);
                            break;
                        }
                        break;
                    default:
                        b0.q qVar = (b0.q) obj;
                        i0 i0Var4 = this.f849b;
                        if (i0Var4.H()) {
                            boolean z11 = qVar.f2164a;
                            i0Var4.r(false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i11 = 1;
        this.f702o = new l0.a(this) { // from class: androidx.fragment.app.y

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i0 f849b;

            {
                this.f849b = this;
            }

            @Override // l0.a
            public final void accept(Object obj) {
                switch (i11) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        i0 i0Var = this.f849b;
                        if (i0Var.H()) {
                            i0Var.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        i0 i0Var2 = this.f849b;
                        if (i0Var2.H() && num.intValue() == 80) {
                            i0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        b0.f fVar = (b0.f) obj;
                        i0 i0Var3 = this.f849b;
                        if (i0Var3.H()) {
                            boolean z10 = fVar.f2136a;
                            i0Var3.m(false);
                            break;
                        }
                        break;
                    default:
                        b0.q qVar = (b0.q) obj;
                        i0 i0Var4 = this.f849b;
                        if (i0Var4.H()) {
                            boolean z11 = qVar.f2164a;
                            i0Var4.r(false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i12 = 2;
        this.f703p = new l0.a(this) { // from class: androidx.fragment.app.y

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i0 f849b;

            {
                this.f849b = this;
            }

            @Override // l0.a
            public final void accept(Object obj) {
                switch (i12) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        i0 i0Var = this.f849b;
                        if (i0Var.H()) {
                            i0Var.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        i0 i0Var2 = this.f849b;
                        if (i0Var2.H() && num.intValue() == 80) {
                            i0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        b0.f fVar = (b0.f) obj;
                        i0 i0Var3 = this.f849b;
                        if (i0Var3.H()) {
                            boolean z10 = fVar.f2136a;
                            i0Var3.m(false);
                            break;
                        }
                        break;
                    default:
                        b0.q qVar = (b0.q) obj;
                        i0 i0Var4 = this.f849b;
                        if (i0Var4.H()) {
                            boolean z11 = qVar.f2164a;
                            i0Var4.r(false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i13 = 3;
        this.f704q = new l0.a(this) { // from class: androidx.fragment.app.y

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i0 f849b;

            {
                this.f849b = this;
            }

            @Override // l0.a
            public final void accept(Object obj) {
                switch (i13) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        i0 i0Var = this.f849b;
                        if (i0Var.H()) {
                            i0Var.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        i0 i0Var2 = this.f849b;
                        if (i0Var2.H() && num.intValue() == 80) {
                            i0Var2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        b0.f fVar = (b0.f) obj;
                        i0 i0Var3 = this.f849b;
                        if (i0Var3.H()) {
                            boolean z10 = fVar.f2136a;
                            i0Var3.m(false);
                            break;
                        }
                        break;
                    default:
                        b0.q qVar = (b0.q) obj;
                        i0 i0Var4 = this.f849b;
                        if (i0Var4.H()) {
                            boolean z11 = qVar.f2164a;
                            i0Var4.r(false);
                            break;
                        }
                        break;
                }
            }
        };
        this.f705r = new b0(this);
        this.f706s = -1;
        this.f711x = new c0(this);
        this.f712y = new n7.i(6);
        this.C = new ArrayDeque();
        this.M = new androidx.activity.j(3, this);
    }

    public static boolean F(int i10) {
        return Log.isLoggable("FragmentManager", i10);
    }

    public static boolean G(s sVar) {
        sVar.getClass();
        ArrayList l10 = sVar.H.f691c.l();
        int size = l10.size();
        boolean z10 = false;
        int i10 = 0;
        while (i10 < size) {
            Object obj = l10.get(i10);
            i10++;
            s sVar2 = (s) obj;
            if (sVar2 != null) {
                z10 = G(sVar2);
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public static boolean I(s sVar) {
        if (sVar == null) {
            return true;
        }
        if (sVar.P) {
            return sVar.F == null || I(sVar.I);
        }
        return false;
    }

    public static boolean J(s sVar) {
        if (sVar == null) {
            return true;
        }
        i0 i0Var = sVar.F;
        return sVar.equals(i0Var.f710w) && J(i0Var.f709v);
    }

    public static void Y(s sVar) {
        if (F(2)) {
            Log.v("FragmentManager", "show: " + sVar);
        }
        if (sVar.M) {
            sVar.M = false;
            sVar.W = !sVar.W;
        }
    }

    public final s A(String str) {
        x4.i iVar = this.f691c;
        ArrayList arrayList = (ArrayList) iVar.f13553p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            s sVar = (s) arrayList.get(size);
            if (sVar != null && str.equals(sVar.L)) {
                return sVar;
            }
        }
        for (p0 p0Var : ((HashMap) iVar.f13554q).values()) {
            if (p0Var != null) {
                s sVar2 = p0Var.f772c;
                if (str.equals(sVar2.L)) {
                    return sVar2;
                }
            }
        }
        return null;
    }

    public final ViewGroup B(s sVar) {
        ViewGroup viewGroup = sVar.R;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (sVar.K <= 0 || !this.f708u.G()) {
            return null;
        }
        View F = this.f708u.F(sVar.K);
        if (F instanceof ViewGroup) {
            return (ViewGroup) F;
        }
        return null;
    }

    public final c0 C() {
        s sVar = this.f709v;
        return sVar != null ? sVar.F.C() : this.f711x;
    }

    public final n7.i D() {
        s sVar = this.f709v;
        return sVar != null ? sVar.F.D() : this.f712y;
    }

    public final void E(s sVar) {
        if (F(2)) {
            Log.v("FragmentManager", "hide: " + sVar);
        }
        if (sVar.M) {
            return;
        }
        sVar.M = true;
        sVar.W = true ^ sVar.W;
        X(sVar);
    }

    public final boolean H() {
        s sVar = this.f709v;
        if (sVar == null) {
            return true;
        }
        return sVar.o() && this.f709v.k().H();
    }

    public final void K(int i10, boolean z10) {
        u uVar;
        if (this.f707t == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f706s) {
            this.f706s = i10;
            x4.i iVar = this.f691c;
            HashMap hashMap = (HashMap) iVar.f13554q;
            ArrayList arrayList = (ArrayList) iVar.f13553p;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                p0 p0Var = (p0) hashMap.get(((s) obj).f810s);
                if (p0Var != null) {
                    p0Var.k();
                }
            }
            for (p0 p0Var2 : hashMap.values()) {
                if (p0Var2 != null) {
                    p0Var2.k();
                    s sVar = p0Var2.f772c;
                    if (sVar.f817z && !sVar.q()) {
                        iVar.q(p0Var2);
                    }
                }
            }
            Z();
            if (this.D && (uVar = this.f707t) != null && this.f706s == 7) {
                uVar.f829w.invalidateOptionsMenu();
                this.D = false;
            }
        }
    }

    public final void L() {
        if (this.f707t == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.L.f736h = false;
        for (s sVar : this.f691c.m()) {
            if (sVar != null) {
                sVar.H.L();
            }
        }
    }

    public final boolean M() {
        return N(-1, 0);
    }

    public final boolean N(int i10, int i11) {
        x(false);
        w(true);
        s sVar = this.f710w;
        if (sVar != null && i10 < 0 && sVar.h().M()) {
            return true;
        }
        boolean O = O(this.I, this.J, i10, i11);
        if (O) {
            this.f690b = true;
            try {
                Q(this.I, this.J);
            } finally {
                d();
            }
        }
        b0();
        if (this.H) {
            this.H = false;
            Z();
        }
        ((HashMap) this.f691c.f13554q).values().removeAll(Collections.singleton(null));
        return O;
    }

    public final boolean O(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        boolean z10 = (i11 & 1) != 0;
        ArrayList arrayList3 = this.f692d;
        int i12 = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i10 < 0) {
                i12 = z10 ? 0 : this.f692d.size() - 1;
            } else {
                int size = this.f692d.size() - 1;
                while (size >= 0) {
                    a aVar = (a) this.f692d.get(size);
                    if (i10 >= 0 && i10 == aVar.f643s) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    i12 = size;
                } else if (z10) {
                    i12 = size;
                    while (i12 > 0) {
                        a aVar2 = (a) this.f692d.get(i12 - 1);
                        if (i10 < 0 || i10 != aVar2.f643s) {
                            break;
                        }
                        i12--;
                    }
                } else if (size != this.f692d.size() - 1) {
                    i12 = size + 1;
                }
            }
        }
        if (i12 < 0) {
            return false;
        }
        for (int size2 = this.f692d.size() - 1; size2 >= i12; size2--) {
            arrayList.add((a) this.f692d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void P(s sVar) {
        if (F(2)) {
            Log.v("FragmentManager", "remove: " + sVar + " nesting=" + sVar.E);
        }
        boolean q10 = sVar.q();
        if (sVar.N && q10) {
            return;
        }
        x4.i iVar = this.f691c;
        synchronized (((ArrayList) iVar.f13553p)) {
            ((ArrayList) iVar.f13553p).remove(sVar);
        }
        sVar.f816y = false;
        if (G(sVar)) {
            this.D = true;
        }
        sVar.f817z = true;
        X(sVar);
    }

    public final void Q(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!((a) arrayList.get(i10)).f640p) {
                if (i11 != i10) {
                    y(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                    while (i11 < size && ((Boolean) arrayList2.get(i11)).booleanValue() && !((a) arrayList.get(i11)).f640p) {
                        i11++;
                    }
                }
                y(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            y(arrayList, arrayList2, i11, size);
        }
    }

    public final void R(Bundle bundle) {
        x4.c cVar;
        int i10;
        int i11;
        Bundle bundle2;
        p0 p0Var;
        Bundle bundle3;
        Bundle bundle4;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle4 = bundle.getBundle(str)) != null) {
                bundle4.setClassLoader(this.f707t.f826t.getClassLoader());
                this.f698k.put(str.substring(7), bundle4);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle3 = bundle.getBundle(str2)) != null) {
                bundle3.setClassLoader(this.f707t.f826t.getClassLoader());
                hashMap.put(str2.substring(9), bundle3);
            }
        }
        x4.i iVar = this.f691c;
        HashMap hashMap2 = (HashMap) iVar.f13555r;
        HashMap hashMap3 = (HashMap) iVar.f13554q;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        k0 k0Var = (k0) bundle.getParcelable("state");
        if (k0Var == null) {
            return;
        }
        hashMap3.clear();
        ArrayList arrayList = k0Var.f723o;
        int size = arrayList.size();
        int i12 = 0;
        while (true) {
            cVar = this.f699l;
            if (i12 >= size) {
                break;
            }
            Object obj = arrayList.get(i12);
            i12++;
            Bundle y8 = iVar.y((String) obj, null);
            if (y8 != null) {
                s sVar = (s) this.L.f732c.get(((n0) y8.getParcelable("state")).f741p);
                if (sVar != null) {
                    if (F(2)) {
                        i11 = 2;
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + sVar);
                    } else {
                        i11 = 2;
                    }
                    p0Var = new p0(cVar, iVar, sVar, y8);
                    bundle2 = y8;
                } else {
                    i11 = 2;
                    bundle2 = y8;
                    p0Var = new p0(this.f699l, this.f691c, this.f707t.f826t.getClassLoader(), C(), y8);
                }
                s sVar2 = p0Var.f772c;
                sVar2.f807p = bundle2;
                sVar2.F = this;
                if (F(i11)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + sVar2.f810s + "): " + sVar2);
                }
                p0Var.m(this.f707t.f826t.getClassLoader());
                iVar.p(p0Var);
                p0Var.f774e = this.f706s;
            }
        }
        l0 l0Var = this.L;
        l0Var.getClass();
        ArrayList arrayList2 = new ArrayList(l0Var.f732c.values());
        int size2 = arrayList2.size();
        int i13 = 0;
        while (i13 < size2) {
            Object obj2 = arrayList2.get(i13);
            i13++;
            s sVar3 = (s) obj2;
            if (hashMap3.get(sVar3.f810s) == null) {
                if (F(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + sVar3 + " that was not found in the set of active Fragments " + k0Var.f723o);
                }
                this.L.d(sVar3);
                sVar3.F = this;
                p0 p0Var2 = new p0(cVar, iVar, sVar3);
                p0Var2.f774e = 1;
                p0Var2.k();
                sVar3.f817z = true;
                p0Var2.k();
            }
        }
        ArrayList arrayList3 = k0Var.f724p;
        ((ArrayList) iVar.f13553p).clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i14 = 0;
            while (i14 < size3) {
                Object obj3 = arrayList3.get(i14);
                i14++;
                String str3 = (String) obj3;
                s h10 = iVar.h(str3);
                if (h10 == null) {
                    throw new IllegalStateException(android.support.v4.media.d.q("No instantiated fragment for (", str3, ")"));
                }
                if (F(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + h10);
                }
                iVar.c(h10);
            }
        }
        if (k0Var.f725q != null) {
            this.f692d = new ArrayList(k0Var.f725q.length);
            int i15 = 0;
            while (true) {
                b[] bVarArr = k0Var.f725q;
                if (i15 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i15];
                ArrayList arrayList4 = bVar.f650p;
                a aVar = new a(this);
                int[] iArr = bVar.f649o;
                int i16 = 0;
                int i17 = 0;
                while (i16 < iArr.length) {
                    q0 q0Var = new q0();
                    int i18 = i16 + 1;
                    q0Var.f776a = iArr[i16];
                    if (F(2)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i17 + " base fragment #" + iArr[i18]);
                    }
                    q0Var.f782h = androidx.lifecycle.m.values()[bVar.f651q[i17]];
                    q0Var.f783i = androidx.lifecycle.m.values()[bVar.f652r[i17]];
                    int i19 = i16 + 2;
                    q0Var.f778c = iArr[i18] != 0;
                    int i20 = iArr[i19];
                    q0Var.f779d = i20;
                    int i21 = iArr[i16 + 3];
                    q0Var.f780e = i21;
                    int i22 = i16 + 5;
                    int i23 = iArr[i16 + 4];
                    q0Var.f781f = i23;
                    i16 += 6;
                    int[] iArr2 = iArr;
                    int i24 = iArr2[i22];
                    q0Var.g = i24;
                    aVar.f627b = i20;
                    aVar.f628c = i21;
                    aVar.f629d = i23;
                    aVar.f630e = i24;
                    aVar.b(q0Var);
                    i17++;
                    iArr = iArr2;
                }
                aVar.f631f = bVar.f653s;
                aVar.f633i = bVar.f654t;
                aVar.g = true;
                aVar.f634j = bVar.f656v;
                aVar.f635k = bVar.f657w;
                aVar.f636l = bVar.f658x;
                aVar.f637m = bVar.f659y;
                aVar.f638n = bVar.f660z;
                aVar.f639o = bVar.A;
                aVar.f640p = bVar.B;
                aVar.f643s = bVar.f655u;
                for (int i25 = 0; i25 < arrayList4.size(); i25++) {
                    String str4 = (String) arrayList4.get(i25);
                    if (str4 != null) {
                        ((q0) aVar.f626a.get(i25)).f777b = iVar.h(str4);
                    }
                }
                aVar.d(1);
                if (F(2)) {
                    StringBuilder f10 = r.a.f("restoreAllState: back stack #", i15, " (index ");
                    f10.append(aVar.f643s);
                    f10.append("): ");
                    f10.append(aVar);
                    Log.v("FragmentManager", f10.toString());
                    PrintWriter printWriter = new PrintWriter(new s0());
                    aVar.g("  ", printWriter, false);
                    printWriter.close();
                }
                this.f692d.add(aVar);
                i15++;
            }
            i10 = 0;
        } else {
            i10 = 0;
            this.f692d = null;
        }
        this.f696i.set(k0Var.f726r);
        String str5 = k0Var.f727s;
        if (str5 != null) {
            s h11 = iVar.h(str5);
            this.f710w = h11;
            q(h11);
        }
        ArrayList arrayList5 = k0Var.f728t;
        if (arrayList5 != null) {
            for (int i26 = i10; i26 < arrayList5.size(); i26++) {
                this.f697j.put((String) arrayList5.get(i26), (c) k0Var.f729u.get(i26));
            }
        }
        this.C = new ArrayDeque(k0Var.f730v);
    }

    public final Bundle S() {
        int i10;
        ArrayList arrayList;
        b[] bVarArr;
        int size;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k kVar = (k) it.next();
            if (kVar.f722e) {
                if (F(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                kVar.f722e = false;
                kVar.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((k) it2.next()).e();
        }
        x(true);
        this.E = true;
        this.L.f736h = true;
        x4.i iVar = this.f691c;
        iVar.getClass();
        HashMap hashMap = (HashMap) iVar.f13554q;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (p0 p0Var : hashMap.values()) {
            if (p0Var != null) {
                s sVar = p0Var.f772c;
                String str = sVar.f810s;
                Bundle bundle3 = new Bundle();
                s sVar2 = p0Var.f772c;
                if (sVar2.f806o == -1 && (bundle = sVar2.f807p) != null) {
                    bundle3.putAll(bundle);
                }
                bundle3.putParcelable("state", new n0(sVar2));
                if (sVar2.f806o > -1) {
                    Bundle bundle4 = new Bundle();
                    sVar2.z(bundle4);
                    if (!bundle4.isEmpty()) {
                        bundle3.putBundle("savedInstanceState", bundle4);
                    }
                    p0Var.f770a.M(false);
                    Bundle bundle5 = new Bundle();
                    sVar2.f803d0.e(bundle5);
                    if (!bundle5.isEmpty()) {
                        bundle3.putBundle("registryState", bundle5);
                    }
                    Bundle S = sVar2.H.S();
                    if (!S.isEmpty()) {
                        bundle3.putBundle("childFragmentManager", S);
                    }
                    if (sVar2.S != null) {
                        p0Var.o();
                    }
                    SparseArray<? extends Parcelable> sparseArray = sVar2.f808q;
                    if (sparseArray != null) {
                        bundle3.putSparseParcelableArray("viewState", sparseArray);
                    }
                    Bundle bundle6 = sVar2.f809r;
                    if (bundle6 != null) {
                        bundle3.putBundle("viewRegistryState", bundle6);
                    }
                }
                Bundle bundle7 = sVar2.f811t;
                if (bundle7 != null) {
                    bundle3.putBundle("arguments", bundle7);
                }
                iVar.y(str, bundle3);
                arrayList2.add(sVar.f810s);
                if (F(2)) {
                    Log.v("FragmentManager", "Saved state of " + sVar + ": " + sVar.f807p);
                }
            }
        }
        HashMap hashMap2 = (HashMap) this.f691c.f13555r;
        if (!hashMap2.isEmpty()) {
            x4.i iVar2 = this.f691c;
            synchronized (((ArrayList) iVar2.f13553p)) {
                try {
                    if (((ArrayList) iVar2.f13553p).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) iVar2.f13553p).size());
                        ArrayList arrayList3 = (ArrayList) iVar2.f13553p;
                        int size2 = arrayList3.size();
                        int i11 = 0;
                        while (i11 < size2) {
                            Object obj = arrayList3.get(i11);
                            i11++;
                            s sVar3 = (s) obj;
                            arrayList.add(sVar3.f810s);
                            if (F(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + sVar3.f810s + "): " + sVar3);
                            }
                        }
                    }
                } finally {
                }
            }
            ArrayList arrayList4 = this.f692d;
            if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
                bVarArr = null;
            } else {
                bVarArr = new b[size];
                for (i10 = 0; i10 < size; i10++) {
                    bVarArr[i10] = new b((a) this.f692d.get(i10));
                    if (F(2)) {
                        StringBuilder f10 = r.a.f("saveAllState: adding back stack #", i10, ": ");
                        f10.append(this.f692d.get(i10));
                        Log.v("FragmentManager", f10.toString());
                    }
                }
            }
            k0 k0Var = new k0();
            k0Var.f727s = null;
            ArrayList arrayList5 = new ArrayList();
            k0Var.f728t = arrayList5;
            ArrayList arrayList6 = new ArrayList();
            k0Var.f729u = arrayList6;
            k0Var.f723o = arrayList2;
            k0Var.f724p = arrayList;
            k0Var.f725q = bVarArr;
            k0Var.f726r = this.f696i.get();
            s sVar4 = this.f710w;
            if (sVar4 != null) {
                k0Var.f727s = sVar4.f810s;
            }
            arrayList5.addAll(this.f697j.keySet());
            arrayList6.addAll(this.f697j.values());
            k0Var.f730v = new ArrayList(this.C);
            bundle2.putParcelable("state", k0Var);
            for (String str2 : this.f698k.keySet()) {
                bundle2.putBundle(r.a.l("result_", str2), (Bundle) this.f698k.get(str2));
            }
            for (String str3 : hashMap2.keySet()) {
                bundle2.putBundle(r.a.l("fragment_", str3), (Bundle) hashMap2.get(str3));
            }
        } else if (F(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle2;
        }
        return bundle2;
    }

    public final void T() {
        synchronized (this.f689a) {
            try {
                if (this.f689a.size() == 1) {
                    this.f707t.f827u.removeCallbacks(this.M);
                    this.f707t.f827u.post(this.M);
                    b0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void U(s sVar, boolean z10) {
        ViewGroup B = B(sVar);
        if (B == null || !(B instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) B).setDrawDisappearingViewsLast(!z10);
    }

    public final void V(s sVar, androidx.lifecycle.m mVar) {
        if (sVar.equals(this.f691c.h(sVar.f810s)) && (sVar.G == null || sVar.F == this)) {
            sVar.Z = mVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + sVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void W(s sVar) {
        if (sVar != null) {
            if (!sVar.equals(this.f691c.h(sVar.f810s)) || (sVar.G != null && sVar.F != this)) {
                throw new IllegalArgumentException("Fragment " + sVar + " is not an active fragment of FragmentManager " + this);
            }
        }
        s sVar2 = this.f710w;
        this.f710w = sVar;
        q(sVar2);
        q(this.f710w);
    }

    public final void X(s sVar) {
        ViewGroup B = B(sVar);
        if (B != null) {
            r rVar = sVar.V;
            if ((rVar == null ? 0 : rVar.f788e) + (rVar == null ? 0 : rVar.f787d) + (rVar == null ? 0 : rVar.f786c) + (rVar == null ? 0 : rVar.f785b) > 0) {
                if (B.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    B.setTag(R.id.visible_removing_fragment_view_tag, sVar);
                }
                s sVar2 = (s) B.getTag(R.id.visible_removing_fragment_view_tag);
                r rVar2 = sVar.V;
                boolean z10 = rVar2 != null ? rVar2.f784a : false;
                if (sVar2.V == null) {
                    return;
                }
                sVar2.g().f784a = z10;
            }
        }
    }

    public final void Z() {
        ArrayList k10 = this.f691c.k();
        int size = k10.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = k10.get(i10);
            i10++;
            p0 p0Var = (p0) obj;
            s sVar = p0Var.f772c;
            if (sVar.T) {
                if (this.f690b) {
                    this.H = true;
                } else {
                    sVar.T = false;
                    p0Var.k();
                }
            }
        }
    }

    public final p0 a(s sVar) {
        String str = sVar.Y;
        if (str != null) {
            y0.c.c(sVar, str);
        }
        if (F(2)) {
            Log.v("FragmentManager", "add: " + sVar);
        }
        p0 f10 = f(sVar);
        sVar.F = this;
        x4.i iVar = this.f691c;
        iVar.p(f10);
        if (!sVar.N) {
            iVar.c(sVar);
            sVar.f817z = false;
            if (sVar.S == null) {
                sVar.W = false;
            }
            if (G(sVar)) {
                this.D = true;
            }
        }
        return f10;
    }

    public final void a0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new s0());
        u uVar = this.f707t;
        if (uVar == null) {
            try {
                u("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e7) {
                Log.e("FragmentManager", "Failed dumping state", e7);
                throw illegalStateException;
            }
        }
        try {
            uVar.f829w.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e8) {
            Log.e("FragmentManager", "Failed dumping state", e8);
            throw illegalStateException;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(u uVar, x4.f fVar, s sVar) {
        l0 l0Var;
        if (this.f707t != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f707t = uVar;
        this.f708u = fVar;
        this.f709v = sVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f700m;
        if (sVar != 0) {
            copyOnWriteArrayList.add(new d0(sVar));
        } else if (uVar != null) {
            copyOnWriteArrayList.add(uVar);
        }
        if (this.f709v != null) {
            b0();
        }
        if (uVar != null) {
            androidx.activity.y j10 = uVar.f829w.j();
            this.g = j10;
            j10.a(sVar != 0 ? sVar : uVar, this.f695h);
        }
        if (sVar != 0) {
            l0 l0Var2 = sVar.F.L;
            HashMap hashMap = l0Var2.f733d;
            l0 l0Var3 = (l0) hashMap.get(sVar.f810s);
            if (l0Var3 == null) {
                l0Var3 = new l0(l0Var2.f735f);
                hashMap.put(sVar.f810s, l0Var3);
            }
            this.L = l0Var3;
        } else if (uVar != null) {
            androidx.lifecycle.n0 e7 = uVar.f829w.e();
            za.h.e("store", e7);
            d1.a aVar = d1.a.f3994b;
            za.h.e("defaultCreationExtras", aVar);
            String canonicalName = l0.class.getCanonicalName();
            if (canonicalName == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            String concat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
            za.h.e("key", concat);
            LinkedHashMap linkedHashMap = e7.f1152a;
            androidx.lifecycle.l0 l0Var4 = (androidx.lifecycle.l0) linkedHashMap.get(concat);
            if (l0.class.isInstance(l0Var4)) {
                za.h.c("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get", l0Var4);
            } else {
                ((LinkedHashMap) new d1.b(aVar).f2162a).put(androidx.lifecycle.m0.f1151b, concat);
                try {
                    l0Var = new l0(true);
                } catch (AbstractMethodError unused) {
                    l0Var = new l0(true);
                }
                l0Var4 = l0Var;
                androidx.lifecycle.l0 l0Var5 = (androidx.lifecycle.l0) linkedHashMap.put(concat, l0Var4);
                if (l0Var5 != null) {
                    l0Var5.a();
                }
            }
            this.L = (l0) l0Var4;
        } else {
            this.L = new l0(false);
        }
        l0 l0Var6 = this.L;
        l0Var6.f736h = this.E || this.F;
        this.f691c.f13556s = l0Var6;
        u uVar2 = this.f707t;
        if (uVar2 != null && sVar == 0) {
            f4.d b2 = uVar2.b();
            b2.e("android:support:fragments", new androidx.activity.f(2, (j0) this));
            Bundle c10 = b2.c("android:support:fragments");
            if (c10 != null) {
                R(c10);
            }
        }
        u uVar3 = this.f707t;
        if (uVar3 != null) {
            androidx.activity.i iVar = uVar3.f829w.f317y;
            String l10 = r.a.l("FragmentManager:", sVar != 0 ? android.support.v4.media.d.r(new StringBuilder(), sVar.f810s, ":") : _UrlKt.FRAGMENT_ENCODE_SET);
            j0 j0Var = (j0) this;
            this.f713z = iVar.d(r.a.c(l10, "StartActivityForResult"), new e0(2), new z(j0Var, 1));
            this.A = iVar.d(r.a.c(l10, "StartIntentSenderForResult"), new e0(0), new z(j0Var, 2));
            this.B = iVar.d(r.a.c(l10, "RequestPermissions"), new e0(1), new z(j0Var, 0));
        }
        u uVar4 = this.f707t;
        if (uVar4 != null) {
            uVar4.f829w.h(this.f701n);
        }
        u uVar5 = this.f707t;
        if (uVar5 != null) {
            uVar5.f829w.A.add(this.f702o);
        }
        u uVar6 = this.f707t;
        if (uVar6 != null) {
            uVar6.f829w.C.add(this.f703p);
        }
        u uVar7 = this.f707t;
        if (uVar7 != null) {
            uVar7.f829w.D.add(this.f704q);
        }
        u uVar8 = this.f707t;
        if (uVar8 == null || sVar != 0) {
            return;
        }
        x4.m mVar = uVar8.f829w.f309q;
        ((CopyOnWriteArrayList) mVar.f13565q).add(this.f705r);
        ((Runnable) mVar.f13564p).run();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [ya.a, za.g] */
    /* JADX WARN: Type inference failed for: r1v10, types: [ya.a, za.g] */
    public final void b0() {
        synchronized (this.f689a) {
            try {
                if (!this.f689a.isEmpty()) {
                    a0 a0Var = this.f695h;
                    a0Var.f644a = true;
                    ?? r12 = a0Var.f646c;
                    if (r12 != 0) {
                        r12.invoke();
                    }
                    return;
                }
                a0 a0Var2 = this.f695h;
                ArrayList arrayList = this.f692d;
                a0Var2.f644a = (arrayList != null ? arrayList.size() : 0) > 0 && J(this.f709v);
                ?? r02 = a0Var2.f646c;
                if (r02 != 0) {
                    r02.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(s sVar) {
        if (F(2)) {
            Log.v("FragmentManager", "attach: " + sVar);
        }
        if (sVar.N) {
            sVar.N = false;
            if (sVar.f816y) {
                return;
            }
            this.f691c.c(sVar);
            if (F(2)) {
                Log.v("FragmentManager", "add from attach: " + sVar);
            }
            if (G(sVar)) {
                this.D = true;
            }
        }
    }

    public final void d() {
        this.f690b = false;
        this.J.clear();
        this.I.clear();
    }

    public final HashSet e() {
        k kVar;
        HashSet hashSet = new HashSet();
        ArrayList k10 = this.f691c.k();
        int size = k10.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = k10.get(i10);
            i10++;
            ViewGroup viewGroup = ((p0) obj).f772c.R;
            if (viewGroup != null) {
                za.h.e("factory", D());
                Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
                if (tag instanceof k) {
                    kVar = (k) tag;
                } else {
                    kVar = new k(viewGroup);
                    viewGroup.setTag(R.id.special_effects_controller_view_tag, kVar);
                }
                hashSet.add(kVar);
            }
        }
        return hashSet;
    }

    public final p0 f(s sVar) {
        String str = sVar.f810s;
        x4.i iVar = this.f691c;
        p0 p0Var = (p0) ((HashMap) iVar.f13554q).get(str);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(this.f699l, iVar, sVar);
        p0Var2.m(this.f707t.f826t.getClassLoader());
        p0Var2.f774e = this.f706s;
        return p0Var2;
    }

    public final void g(s sVar) {
        if (F(2)) {
            Log.v("FragmentManager", "detach: " + sVar);
        }
        if (sVar.N) {
            return;
        }
        sVar.N = true;
        if (sVar.f816y) {
            if (F(2)) {
                Log.v("FragmentManager", "remove from detach: " + sVar);
            }
            x4.i iVar = this.f691c;
            synchronized (((ArrayList) iVar.f13553p)) {
                ((ArrayList) iVar.f13553p).remove(sVar);
            }
            sVar.f816y = false;
            if (G(sVar)) {
                this.D = true;
            }
            X(sVar);
        }
    }

    public final void h(boolean z10, Configuration configuration) {
        if (z10 && this.f707t != null) {
            a0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (s sVar : this.f691c.m()) {
            if (sVar != null) {
                sVar.onConfigurationChanged(configuration);
                if (z10) {
                    sVar.H.h(true, configuration);
                }
            }
        }
    }

    public final boolean i() {
        if (this.f706s >= 1) {
            for (s sVar : this.f691c.m()) {
                if (sVar != null) {
                    if (!sVar.M ? sVar.H.i() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean j() {
        if (this.f706s < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (s sVar : this.f691c.m()) {
            if (sVar != null && I(sVar)) {
                if (!sVar.M ? sVar.H.j() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(sVar);
                    z10 = true;
                }
            }
        }
        if (this.f693e != null) {
            for (int i10 = 0; i10 < this.f693e.size(); i10++) {
                s sVar2 = (s) this.f693e.get(i10);
                if (arrayList == null || !arrayList.contains(sVar2)) {
                    sVar2.getClass();
                }
            }
        }
        this.f693e = arrayList;
        return z10;
    }

    public final void k() {
        boolean z10;
        this.G = true;
        x(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((k) it.next()).e();
        }
        u uVar = this.f707t;
        x4.i iVar = this.f691c;
        if (uVar != null) {
            z10 = ((l0) iVar.f13556s).g;
        } else {
            z10 = r.a.k(uVar.f826t) ? !r1.isChangingConfigurations() : true;
        }
        if (z10) {
            Iterator it2 = this.f697j.values().iterator();
            while (it2.hasNext()) {
                ArrayList arrayList = ((c) it2.next()).f662o;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    String str = (String) obj;
                    l0 l0Var = (l0) iVar.f13556s;
                    l0Var.getClass();
                    if (F(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    l0Var.c(str);
                }
            }
        }
        t(-1);
        u uVar2 = this.f707t;
        if (uVar2 != null) {
            uVar2.f829w.A.remove(this.f702o);
        }
        u uVar3 = this.f707t;
        if (uVar3 != null) {
            uVar3.f829w.f318z.remove(this.f701n);
        }
        u uVar4 = this.f707t;
        if (uVar4 != null) {
            uVar4.f829w.C.remove(this.f703p);
        }
        u uVar5 = this.f707t;
        if (uVar5 != null) {
            uVar5.f829w.D.remove(this.f704q);
        }
        u uVar6 = this.f707t;
        if ((uVar6 != null) && this.f709v == null) {
            x4.m mVar = uVar6.f829w.f309q;
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) mVar.f13565q;
            b0 b0Var = this.f705r;
            copyOnWriteArrayList.remove(b0Var);
            if (((HashMap) mVar.f13566r).remove(b0Var) != null) {
                throw new ClassCastException();
            }
            ((Runnable) mVar.f13564p).run();
        }
        this.f707t = null;
        this.f708u = null;
        this.f709v = null;
        if (this.g != null) {
            Iterator it3 = this.f695h.f645b.iterator();
            while (it3.hasNext()) {
                ((androidx.activity.c) it3.next()).cancel();
            }
            this.g = null;
        }
        androidx.activity.result.d dVar = this.f713z;
        if (dVar != null) {
            dVar.z();
            this.A.z();
            this.B.z();
        }
    }

    public final void l(boolean z10) {
        if (z10 && this.f707t != null) {
            a0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (s sVar : this.f691c.m()) {
            if (sVar != null) {
                sVar.Q = true;
                if (z10) {
                    sVar.H.l(true);
                }
            }
        }
    }

    public final void m(boolean z10) {
        if (z10 && this.f707t != null) {
            a0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (s sVar : this.f691c.m()) {
            if (sVar != null && z10) {
                sVar.H.m(true);
            }
        }
    }

    public final void n() {
        ArrayList l10 = this.f691c.l();
        int size = l10.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = l10.get(i10);
            i10++;
            s sVar = (s) obj;
            if (sVar != null) {
                sVar.p();
                sVar.H.n();
            }
        }
    }

    public final boolean o() {
        if (this.f706s >= 1) {
            for (s sVar : this.f691c.m()) {
                if (sVar != null) {
                    if (!sVar.M ? sVar.H.o() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void p() {
        if (this.f706s < 1) {
            return;
        }
        for (s sVar : this.f691c.m()) {
            if (sVar != null && !sVar.M) {
                sVar.H.p();
            }
        }
    }

    public final void q(s sVar) {
        if (sVar != null) {
            if (sVar.equals(this.f691c.h(sVar.f810s))) {
                sVar.F.getClass();
                boolean J = J(sVar);
                Boolean bool = sVar.f815x;
                if (bool == null || bool.booleanValue() != J) {
                    sVar.f815x = Boolean.valueOf(J);
                    j0 j0Var = sVar.H;
                    j0Var.b0();
                    j0Var.q(j0Var.f710w);
                }
            }
        }
    }

    public final void r(boolean z10) {
        if (z10 && this.f707t != null) {
            a0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (s sVar : this.f691c.m()) {
            if (sVar != null && z10) {
                sVar.H.r(true);
            }
        }
    }

    public final boolean s() {
        if (this.f706s < 1) {
            return false;
        }
        boolean z10 = false;
        for (s sVar : this.f691c.m()) {
            if (sVar != null && I(sVar)) {
                if (!sVar.M ? sVar.H.s() : false) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final void t(int i10) {
        try {
            this.f690b = true;
            for (p0 p0Var : ((HashMap) this.f691c.f13554q).values()) {
                if (p0Var != null) {
                    p0Var.f774e = i10;
                }
            }
            K(i10, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((k) it.next()).e();
            }
            this.f690b = false;
            x(true);
        } catch (Throwable th) {
            this.f690b = false;
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        s sVar = this.f709v;
        if (sVar != null) {
            sb2.append(sVar.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f709v)));
            sb2.append("}");
        } else {
            u uVar = this.f707t;
            if (uVar != null) {
                sb2.append(uVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f707t)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        e1.a aVar;
        String str2;
        String c10 = r.a.c(str, "    ");
        x4.i iVar = this.f691c;
        ArrayList arrayList = (ArrayList) iVar.f13553p;
        String c11 = r.a.c(str, "    ");
        HashMap hashMap = (HashMap) iVar.f13554q;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p0 p0Var : hashMap.values()) {
                printWriter.print(str);
                if (p0Var != null) {
                    s sVar = p0Var.f772c;
                    printWriter.println(sVar);
                    sVar.getClass();
                    printWriter.print(c11);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(sVar.J));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(sVar.K));
                    printWriter.print(" mTag=");
                    printWriter.println(sVar.L);
                    printWriter.print(c11);
                    printWriter.print("mState=");
                    printWriter.print(sVar.f806o);
                    printWriter.print(" mWho=");
                    printWriter.print(sVar.f810s);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(sVar.E);
                    printWriter.print(c11);
                    printWriter.print("mAdded=");
                    printWriter.print(sVar.f816y);
                    printWriter.print(" mRemoving=");
                    printWriter.print(sVar.f817z);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(sVar.A);
                    printWriter.print(" mInLayout=");
                    printWriter.println(sVar.B);
                    printWriter.print(c11);
                    printWriter.print("mHidden=");
                    printWriter.print(sVar.M);
                    printWriter.print(" mDetached=");
                    printWriter.print(sVar.N);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(sVar.P);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(c11);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(sVar.O);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(sVar.U);
                    if (sVar.F != null) {
                        printWriter.print(c11);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(sVar.F);
                    }
                    if (sVar.G != null) {
                        printWriter.print(c11);
                        printWriter.print("mHost=");
                        printWriter.println(sVar.G);
                    }
                    if (sVar.I != null) {
                        printWriter.print(c11);
                        printWriter.print("mParentFragment=");
                        printWriter.println(sVar.I);
                    }
                    if (sVar.f811t != null) {
                        printWriter.print(c11);
                        printWriter.print("mArguments=");
                        printWriter.println(sVar.f811t);
                    }
                    if (sVar.f807p != null) {
                        printWriter.print(c11);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(sVar.f807p);
                    }
                    if (sVar.f808q != null) {
                        printWriter.print(c11);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(sVar.f808q);
                    }
                    if (sVar.f809r != null) {
                        printWriter.print(c11);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(sVar.f809r);
                    }
                    Object obj = sVar.f812u;
                    if (obj == null) {
                        i0 i0Var = sVar.F;
                        obj = (i0Var == null || (str2 = sVar.f813v) == null) ? null : i0Var.f691c.h(str2);
                    }
                    if (obj != null) {
                        printWriter.print(c11);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(sVar.f814w);
                    }
                    printWriter.print(c11);
                    printWriter.print("mPopDirection=");
                    r rVar = sVar.V;
                    printWriter.println(rVar == null ? false : rVar.f784a);
                    r rVar2 = sVar.V;
                    if ((rVar2 == null ? 0 : rVar2.f785b) != 0) {
                        printWriter.print(c11);
                        printWriter.print("getEnterAnim=");
                        r rVar3 = sVar.V;
                        printWriter.println(rVar3 == null ? 0 : rVar3.f785b);
                    }
                    r rVar4 = sVar.V;
                    if ((rVar4 == null ? 0 : rVar4.f786c) != 0) {
                        printWriter.print(c11);
                        printWriter.print("getExitAnim=");
                        r rVar5 = sVar.V;
                        printWriter.println(rVar5 == null ? 0 : rVar5.f786c);
                    }
                    r rVar6 = sVar.V;
                    if ((rVar6 == null ? 0 : rVar6.f787d) != 0) {
                        printWriter.print(c11);
                        printWriter.print("getPopEnterAnim=");
                        r rVar7 = sVar.V;
                        printWriter.println(rVar7 == null ? 0 : rVar7.f787d);
                    }
                    r rVar8 = sVar.V;
                    if ((rVar8 == null ? 0 : rVar8.f788e) != 0) {
                        printWriter.print(c11);
                        printWriter.print("getPopExitAnim=");
                        r rVar9 = sVar.V;
                        printWriter.println(rVar9 == null ? 0 : rVar9.f788e);
                    }
                    if (sVar.R != null) {
                        printWriter.print(c11);
                        printWriter.print("mContainer=");
                        printWriter.println(sVar.R);
                    }
                    if (sVar.S != null) {
                        printWriter.print(c11);
                        printWriter.print("mView=");
                        printWriter.println(sVar.S);
                    }
                    if (sVar.i() != null) {
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
                            printWriter.print(c11);
                            printWriter.println("Loaders:");
                            if (jVar.f9784q > 0) {
                                if (jVar.f9783p[0] != null) {
                                    throw new ClassCastException();
                                }
                                printWriter.print(c11);
                                printWriter.print("  #");
                                printWriter.print(jVar.f9782o[0]);
                                printWriter.print(": ");
                                throw null;
                            }
                        }
                    }
                    printWriter.print(c11);
                    printWriter.println("Child " + sVar.H + ":");
                    sVar.H.u(r.a.c(c11, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size3; i10++) {
                s sVar2 = (s) arrayList.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(sVar2.toString());
            }
        }
        ArrayList arrayList2 = this.f693e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i11 = 0; i11 < size2; i11++) {
                s sVar3 = (s) this.f693e.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(sVar3.toString());
            }
        }
        ArrayList arrayList3 = this.f692d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i12 = 0; i12 < size; i12++) {
                a aVar3 = (a) this.f692d.get(i12);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(": ");
                printWriter.println(aVar3.toString());
                aVar3.g(c10, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f696i.get());
        synchronized (this.f689a) {
            try {
                int size4 = this.f689a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i13 = 0; i13 < size4; i13++) {
                        Object obj2 = (g0) this.f689a.get(i13);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i13);
                        printWriter.print(": ");
                        printWriter.println(obj2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f707t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f708u);
        if (this.f709v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f709v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f706s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public final void v(g0 g0Var, boolean z10) {
        if (!z10) {
            if (this.f707t == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.E || this.F) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f689a) {
            try {
                if (this.f707t == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f689a.add(g0Var);
                    T();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z10) {
        if (this.f690b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f707t == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f707t.f827u.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10 && (this.E || this.F)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.I == null) {
            this.I = new ArrayList();
            this.J = new ArrayList();
        }
    }

    public final boolean x(boolean z10) {
        boolean z11;
        w(z10);
        boolean z12 = false;
        while (true) {
            ArrayList arrayList = this.I;
            ArrayList arrayList2 = this.J;
            synchronized (this.f689a) {
                if (this.f689a.isEmpty()) {
                    z11 = false;
                } else {
                    try {
                        int size = this.f689a.size();
                        z11 = false;
                        for (int i10 = 0; i10 < size; i10++) {
                            z11 |= ((g0) this.f689a.get(i10)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!z11) {
                break;
            }
            z12 = true;
            this.f690b = true;
            try {
                Q(this.I, this.J);
            } finally {
                d();
            }
        }
        b0();
        if (this.H) {
            this.H = false;
            Z();
        }
        ((HashMap) this.f691c.f13554q).values().removeAll(Collections.singleton(null));
        return z12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:256:0x04be, code lost:
    
        r10 = (androidx.fragment.app.u0) r10;
        r7.f722e = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.util.ArrayList r24, java.util.ArrayList r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i0.y(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final s z(int i10) {
        x4.i iVar = this.f691c;
        ArrayList arrayList = (ArrayList) iVar.f13553p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            s sVar = (s) arrayList.get(size);
            if (sVar != null && sVar.J == i10) {
                return sVar;
            }
        }
        for (p0 p0Var : ((HashMap) iVar.f13554q).values()) {
            if (p0Var != null) {
                s sVar2 = p0Var.f772c;
                if (sVar2.J == i10) {
                    return sVar2;
                }
            }
        }
        return null;
    }
}
