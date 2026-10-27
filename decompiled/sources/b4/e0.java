package b4;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2214a;

    public /* synthetic */ e0(RecyclerView recyclerView) {
        this.f2214a = recyclerView;
    }

    public void a(a aVar) {
        int i10 = aVar.f2169a;
        RecyclerView recyclerView = this.f2214a;
        if (i10 == 1) {
            recyclerView.B.h0(aVar.f2170b, aVar.f2172d);
            return;
        }
        if (i10 == 2) {
            recyclerView.B.k0(aVar.f2170b, aVar.f2172d);
        } else if (i10 == 4) {
            recyclerView.B.m0(recyclerView, aVar.f2170b, aVar.f2172d);
        } else {
            if (i10 != 8) {
                return;
            }
            recyclerView.B.j0(aVar.f2170b, aVar.f2172d);
        }
    }

    public f1 b(int i10) {
        RecyclerView recyclerView = this.f2214a;
        int P = recyclerView.f1482t.P();
        int i11 = 0;
        f1 f1Var = null;
        while (true) {
            if (i11 >= P) {
                break;
            }
            f1 J = RecyclerView.J(recyclerView.f1482t.O(i11));
            if (J != null && !J.i() && J.f2234c == i10) {
                if (!((ArrayList) recyclerView.f1482t.f232r).contains(J.f2232a)) {
                    f1Var = J;
                    break;
                }
                f1Var = J;
            }
            i11++;
        }
        if (f1Var != null) {
            if (!((ArrayList) recyclerView.f1482t.f232r).contains(f1Var.f2232a)) {
                return f1Var;
            }
        }
        return null;
    }

    public void c(int i10, int i11, Object obj) {
        int i12;
        int i13;
        RecyclerView recyclerView = this.f2214a;
        int P = recyclerView.f1482t.P();
        int i14 = i11 + i10;
        for (int i15 = 0; i15 < P; i15++) {
            View O = recyclerView.f1482t.O(i15);
            f1 J = RecyclerView.J(O);
            if (J != null && !J.p() && (i13 = J.f2234c) >= i10 && i13 < i14) {
                J.a(2);
                if (obj == null) {
                    J.a(1024);
                } else if ((1024 & J.f2240j) == 0) {
                    if (J.f2241k == null) {
                        ArrayList arrayList = new ArrayList();
                        J.f2241k = arrayList;
                        J.f2242l = Collections.unmodifiableList(arrayList);
                    }
                    J.f2241k.add(obj);
                }
                ((p0) O.getLayoutParams()).f2383c = true;
            }
        }
        u0 u0Var = recyclerView.f1476q;
        ArrayList arrayList2 = u0Var.f2425c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            f1 f1Var = (f1) arrayList2.get(size);
            if (f1Var != null && (i12 = f1Var.f2234c) >= i10 && i12 < i14) {
                f1Var.a(2);
                u0Var.h(size);
            }
        }
        recyclerView.f1495z0 = true;
    }

    public void d(int i10, int i11) {
        RecyclerView recyclerView = this.f2214a;
        int P = recyclerView.f1482t.P();
        for (int i12 = 0; i12 < P; i12++) {
            f1 J = RecyclerView.J(recyclerView.f1482t.O(i12));
            if (J != null && !J.p() && J.f2234c >= i10) {
                J.m(i11, false);
                recyclerView.f1487v0.f2190f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1476q.f2425c;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            f1 f1Var = (f1) arrayList.get(i13);
            if (f1Var != null && f1Var.f2234c >= i10) {
                f1Var.m(i11, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f1493y0 = true;
    }

    public void e(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        RecyclerView recyclerView = this.f2214a;
        int P = recyclerView.f1482t.P();
        int i19 = -1;
        if (i10 < i11) {
            i13 = i10;
            i12 = i11;
            i14 = -1;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i20 = 0; i20 < P; i20++) {
            f1 J = RecyclerView.J(recyclerView.f1482t.O(i20));
            if (J != null && (i18 = J.f2234c) >= i13 && i18 <= i12) {
                if (i18 == i10) {
                    J.m(i11 - i10, false);
                } else {
                    J.m(i14, false);
                }
                recyclerView.f1487v0.f2190f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1476q.f2425c;
        if (i10 < i11) {
            i16 = i10;
            i15 = i11;
        } else {
            i15 = i10;
            i16 = i11;
            i19 = 1;
        }
        int size = arrayList.size();
        for (int i21 = 0; i21 < size; i21++) {
            f1 f1Var = (f1) arrayList.get(i21);
            if (f1Var != null && (i17 = f1Var.f2234c) >= i16 && i17 <= i15) {
                if (i17 == i10) {
                    f1Var.m(i11 - i10, false);
                } else {
                    f1Var.m(i19, false);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.f1493y0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(b4.f1 r9, b4.j0 r10, b4.j0 r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f2214a
            r0.getClass()
            r1 = 0
            r9.o(r1)
            b4.k0 r1 = r0.f1462d0
            r2 = r1
            b4.j r2 = (b4.j) r2
            if (r10 == 0) goto L20
            r2.getClass()
            int r4 = r10.f2285b
            int r6 = r11.f2285b
            if (r4 != r6) goto L22
            int r1 = r10.f2286c
            int r3 = r11.f2286c
            if (r1 == r3) goto L20
            goto L22
        L20:
            r3 = r9
            goto L2c
        L22:
            int r5 = r10.f2286c
            int r7 = r11.f2286c
            r3 = r9
            boolean r9 = r2.g(r3, r4, r5, r6, r7)
            goto L3b
        L2c:
            r2.l(r3)
            android.view.View r9 = r3.f2232a
            r10 = 0
            r9.setAlpha(r10)
            java.util.ArrayList r9 = r2.f2274i
            r9.add(r3)
            r9 = 1
        L3b:
            if (r9 == 0) goto L40
            r0.U()
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.e0.f(b4.f1, b4.j0, b4.j0):void");
    }

    public void g(f1 f1Var, j0 j0Var, j0 j0Var2) {
        boolean z10;
        RecyclerView recyclerView = this.f2214a;
        recyclerView.f1476q.m(f1Var);
        recyclerView.f(f1Var);
        f1Var.o(false);
        j jVar = (j) recyclerView.f1462d0;
        jVar.getClass();
        int i10 = j0Var.f2285b;
        int i11 = j0Var.f2286c;
        View view = f1Var.f2232a;
        int left = j0Var2 == null ? view.getLeft() : j0Var2.f2285b;
        int top = j0Var2 == null ? view.getTop() : j0Var2.f2286c;
        if (f1Var.i() || (i10 == left && i11 == top)) {
            jVar.l(f1Var);
            jVar.f2273h.add(f1Var);
            z10 = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            z10 = jVar.g(f1Var, i10, i11, left, top);
        }
        if (z10) {
            recyclerView.U();
        }
    }

    public void h(int i10) {
        RecyclerView recyclerView = this.f2214a;
        View childAt = recyclerView.getChildAt(i10);
        if (childAt != null) {
            RecyclerView.J(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i10);
    }
}
