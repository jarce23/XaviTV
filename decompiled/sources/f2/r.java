package f2;

import android.content.Context;
import android.media.Spatializer;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import c2.n1;
import i1.u0;
import i1.x0;
import i1.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import l1.a0;
import o9.g0;
import o9.v0;
import o9.w0;
import s1.h0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends w {

    /* renamed from: l, reason: collision with root package name */
    public static final v0 f4938l = new o9.v(new c(1));

    /* renamed from: d, reason: collision with root package name */
    public final Object f4939d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f4940e;

    /* renamed from: f, reason: collision with root package name */
    public final d9.f f4941f;
    public k g;

    /* renamed from: h, reason: collision with root package name */
    public Thread f4942h;

    /* renamed from: i, reason: collision with root package name */
    public c4.e f4943i;

    /* renamed from: j, reason: collision with root package name */
    public i1.d f4944j;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f4945k;

    public r(f.j jVar) {
        d9.f fVar = new d9.f(18);
        k kVar = k.f4907x0;
        this.f4939d = new Object();
        this.f4940e = jVar.getApplicationContext();
        this.f4941f = fVar;
        if (kVar != null) {
            this.g = kVar;
        } else {
            kVar.getClass();
            j jVar2 = new j(kVar);
            jVar2.c(kVar);
            this.g = new k(jVar2);
        }
        this.f4944j = i1.d.f5843b;
        boolean z10 = this.g.f4912s0;
    }

    public static void c(n1 n1Var, k kVar, HashMap hashMap) {
        for (int i10 = 0; i10 < n1Var.f2660a; i10++) {
            i1.v0 v0Var = (i1.v0) kVar.D.get(n1Var.a(i10));
            if (v0Var != null) {
                u0 u0Var = v0Var.f6051a;
                i1.v0 v0Var2 = (i1.v0) hashMap.get(Integer.valueOf(u0Var.f6041c));
                if (v0Var2 == null || (v0Var2.f6052b.isEmpty() && !v0Var.f6052b.isEmpty())) {
                    hashMap.put(Integer.valueOf(u0Var.f6041c), v0Var);
                }
            }
        }
    }

    public static int d(i1.p pVar, String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(pVar.f5982d)) {
            return 4;
        }
        String g = g(str);
        String g6 = g(pVar.f5982d);
        if (g6 == null || g == null) {
            return (z10 && g6 == null) ? 1 : 0;
        }
        if (g6.startsWith(g) || g.startsWith(g6)) {
            return 3;
        }
        int i10 = a0.f8067a;
        return g6.split("-", 2)[0].equals(g.split("-", 2)[0]) ? 2 : 0;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean i(k kVar, int i10, i1.p pVar) {
        if ((i10 & 3584) == 0) {
            return false;
        }
        x0 x0Var = kVar.f6130u;
        if (x0Var.f6071c && (i10 & 2048) == 0) {
            return false;
        }
        if (x0Var.f6070b) {
            boolean z10 = (pVar.I == 0 && pVar.J == 0) ? false : true;
            boolean z11 = (i10 & 1024) != 0;
            if (z10 && !z11) {
                return false;
            }
        }
        return true;
    }

    public static Pair j(int i10, v vVar, int[][][] iArr, o oVar, Comparator comparator) {
        int i11;
        RandomAccess randomAccess;
        v vVar2 = vVar;
        ArrayList arrayList = new ArrayList();
        int i12 = vVar2.f4948a;
        int i13 = 0;
        while (i13 < i12) {
            if (i10 == vVar2.f4949b[i13]) {
                n1 n1Var = vVar2.f4950c[i13];
                for (int i14 = 0; i14 < n1Var.f2660a; i14++) {
                    u0 a10 = n1Var.a(i14);
                    w0 b2 = oVar.b(i13, a10, iArr[i13][i14]);
                    int i15 = a10.f6039a;
                    boolean[] zArr = new boolean[i15];
                    int i16 = 0;
                    while (i16 < i15) {
                        p pVar = (p) b2.get(i16);
                        int a11 = pVar.a();
                        if (zArr[i16] || a11 == 0) {
                            i11 = i12;
                        } else {
                            if (a11 == 1) {
                                randomAccess = g0.r(pVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(pVar);
                                int i17 = i16 + 1;
                                while (i17 < i15) {
                                    p pVar2 = (p) b2.get(i17);
                                    int i18 = i12;
                                    if (pVar2.a() == 2 && pVar.b(pVar2)) {
                                        arrayList2.add(pVar2);
                                        zArr[i17] = true;
                                    }
                                    i17++;
                                    i12 = i18;
                                }
                                randomAccess = arrayList2;
                            }
                            i11 = i12;
                            arrayList.add(randomAccess);
                        }
                        i16++;
                        i12 = i11;
                    }
                }
            }
            i13++;
            vVar2 = vVar;
            i12 = i12;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i19 = 0; i19 < list.size(); i19++) {
            iArr2[i19] = ((p) list.get(i19)).f4928q;
        }
        p pVar3 = (p) list.get(0);
        return Pair.create(new s(0, pVar3.f4927p, iArr2), Integer.valueOf(pVar3.f4926o));
    }

    @Override // f2.w
    public final void a() {
        c4.e eVar;
        m mVar;
        synchronized (this.f4939d) {
            try {
                Thread thread = this.f4942h;
                if (thread != null) {
                    l1.d.f("DefaultTrackSelector is accessed on the wrong thread.", thread == Thread.currentThread());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (eVar = this.f4943i) != null) {
            Handler handler = (Handler) eVar.f2877q;
            Spatializer spatializer = (Spatializer) eVar.f2876p;
            if (spatializer != null && (mVar = (m) eVar.f2878r) != null && handler != null) {
                spatializer.removeOnSpatializerStateChangedListener(mVar);
                handler.removeCallbacksAndMessages(null);
            }
            this.f4943i = null;
        }
        this.f4954a = null;
        this.f4955b = null;
    }

    @Override // f2.w
    public final void b(z0 z0Var) {
        if (z0Var instanceof k) {
            k((k) z0Var);
        }
        j jVar = new j(e());
        jVar.c(z0Var);
        k(new k(jVar));
    }

    public final k e() {
        k kVar;
        synchronized (this.f4939d) {
            kVar = this.g;
        }
        return kVar;
    }

    public final void f() {
        boolean z10;
        h0 h0Var;
        c4.e eVar;
        synchronized (this.f4939d) {
            try {
                z10 = this.g.f4912s0 && Build.VERSION.SDK_INT >= 32 && (eVar = this.f4943i) != null && eVar.f2875o;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z10 || (h0Var = this.f4954a) == null) {
            return;
        }
        h0Var.f11343v.e(10);
    }

    public final void h() {
        synchronized (this.f4939d) {
            this.g.getClass();
        }
    }

    public final void k(k kVar) {
        boolean equals;
        kVar.getClass();
        synchronized (this.f4939d) {
            equals = this.g.equals(kVar);
            this.g = kVar;
        }
        if (equals) {
            return;
        }
        if (kVar.f4912s0 && this.f4940e == null) {
            l1.b.q("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        h0 h0Var = this.f4954a;
        if (h0Var != null) {
            h0Var.f11343v.e(10);
        }
    }
}
