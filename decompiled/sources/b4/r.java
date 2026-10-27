package b4;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    public static final ThreadLocal f2394s = new ThreadLocal();

    /* renamed from: t, reason: collision with root package name */
    public static final o f2395t = new o(0);

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f2396o;

    /* renamed from: p, reason: collision with root package name */
    public long f2397p;

    /* renamed from: q, reason: collision with root package name */
    public long f2398q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f2399r;

    public static f1 c(RecyclerView recyclerView, int i10, long j10) {
        int P = recyclerView.f1482t.P();
        for (int i11 = 0; i11 < P; i11++) {
            f1 J = RecyclerView.J(recyclerView.f1482t.O(i11));
            if (J.f2234c == i10 && !J.g()) {
                return null;
            }
        }
        u0 u0Var = recyclerView.f1476q;
        try {
            recyclerView.R();
            f1 l10 = u0Var.l(i10, j10);
            if (l10 != null) {
                if (!l10.f() || l10.g()) {
                    u0Var.a(l10, false);
                } else {
                    u0Var.i(l10.f2232a);
                }
            }
            recyclerView.S(false);
            return l10;
        } catch (Throwable th) {
            recyclerView.S(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.H && this.f2397p == 0) {
            this.f2397p = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        p pVar = recyclerView.f1485u0;
        pVar.f2378c = i10;
        pVar.f2379d = i11;
    }

    public final void b(long j10) {
        q qVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        q qVar2;
        ArrayList arrayList = this.f2399r;
        ArrayList arrayList2 = this.f2396o;
        int size = arrayList2.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList2.get(i11);
            int windowVisibility = recyclerView3.getWindowVisibility();
            p pVar = recyclerView3.f1485u0;
            if (windowVisibility == 0) {
                pVar.c(recyclerView3, false);
                i10 += pVar.f2380e;
            }
        }
        arrayList.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList2.get(i13);
            if (recyclerView4.getWindowVisibility() == 0) {
                p pVar2 = recyclerView4.f1485u0;
                int abs = Math.abs(pVar2.f2379d) + Math.abs(pVar2.f2378c);
                for (int i14 = 0; i14 < pVar2.f2380e * 2; i14 += 2) {
                    if (i12 >= arrayList.size()) {
                        qVar2 = new q();
                        arrayList.add(qVar2);
                    } else {
                        qVar2 = (q) arrayList.get(i12);
                    }
                    int[] iArr = (int[]) pVar2.f2377b;
                    int i15 = iArr[i14 + 1];
                    qVar2.f2389a = i15 <= abs;
                    qVar2.f2390b = abs;
                    qVar2.f2391c = i15;
                    qVar2.f2392d = recyclerView4;
                    qVar2.f2393e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(arrayList, f2395t);
        for (int i16 = 0; i16 < arrayList.size() && (recyclerView = (qVar = (q) arrayList.get(i16)).f2392d) != null; i16++) {
            f1 c10 = c(recyclerView, qVar.f2393e, qVar.f2389a ? Long.MAX_VALUE : j10);
            if (c10 != null && c10.f2233b != null && c10.f() && !c10.g() && (recyclerView2 = (RecyclerView) c10.f2233b.get()) != null) {
                if (recyclerView2.R && recyclerView2.f1482t.P() != 0) {
                    u0 u0Var = recyclerView2.f1476q;
                    k0 k0Var = recyclerView2.f1462d0;
                    if (k0Var != null) {
                        k0Var.e();
                    }
                    o0 o0Var = recyclerView2.B;
                    if (o0Var != null) {
                        o0Var.v0(u0Var);
                        recyclerView2.B.w0(u0Var);
                    }
                    u0Var.f2423a.clear();
                    u0Var.g();
                }
                p pVar3 = recyclerView2.f1485u0;
                pVar3.c(recyclerView2, true);
                if (pVar3.f2380e != 0) {
                    try {
                        int i17 = i0.j.f5790a;
                        Trace.beginSection("RV Nested Prefetch");
                        b1 b1Var = recyclerView2.f1487v0;
                        f0 f0Var = recyclerView2.A;
                        b1Var.f2188d = 1;
                        b1Var.f2189e = f0Var.a();
                        b1Var.g = false;
                        b1Var.f2191h = false;
                        b1Var.f2192i = false;
                        for (int i18 = 0; i18 < pVar3.f2380e * 2; i18 += 2) {
                            c(recyclerView2, ((int[]) pVar3.f2377b)[i18], j10);
                        }
                        Trace.endSection();
                        qVar.f2389a = false;
                        qVar.f2390b = 0;
                        qVar.f2391c = 0;
                        qVar.f2392d = null;
                        qVar.f2393e = 0;
                    } catch (Throwable th) {
                        int i19 = i0.j.f5790a;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            qVar.f2389a = false;
            qVar.f2390b = 0;
            qVar.f2391c = 0;
            qVar.f2392d = null;
            qVar.f2393e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f2396o;
        try {
            int i10 = i0.j.f5790a;
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long j10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i11);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j10) + this.f2398q);
                }
            }
            this.f2397p = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.f2397p = 0L;
            int i12 = i0.j.f5790a;
            Trace.endSection();
            throw th;
        }
    }
}
