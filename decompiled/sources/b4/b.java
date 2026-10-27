package b4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.WeakHashMap;
import m.p2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f2175a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2176b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2177c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2178d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2179e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2180f;

    public b(View view) {
        this.f2175a = -1;
        this.f2176b = view;
        this.f2177c = m.r.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (r9 < r2.f8820p) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r9, l1.t r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f2178d
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0
            java.lang.Object r1 = r8.f2179e
            java.util.PriorityQueue r1 = (java.util.PriorityQueue) r1
            int r2 = r8.f2175a
            if (r2 == 0) goto L9e
            r3 = -1
            if (r2 == r3) goto L27
            int r2 = r1.size()
            int r4 = r8.f2175a
            if (r2 < r4) goto L27
            java.lang.Object r2 = r1.peek()
            m1.r r2 = (m1.r) r2
            int r4 = l1.a0.f8067a
            long r4 = r2.f8820p
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 >= 0) goto L27
            goto L9e
        L27:
            java.lang.Object r2 = r8.f2177c
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L37
            l1.t r2 = new l1.t
            r2.<init>()
            goto L3d
        L37:
            java.lang.Object r2 = r2.pop()
            l1.t r2 = (l1.t) r2
        L3d:
            int r4 = r11.a()
            r2.F(r4)
            byte[] r4 = r11.f8129a
            int r11 = r11.f8130b
            byte[] r5 = r2.f8129a
            int r6 = r2.a()
            r7 = 0
            java.lang.System.arraycopy(r4, r11, r5, r7, r6)
            java.lang.Object r11 = r8.f2180f
            m1.r r11 = (m1.r) r11
            if (r11 == 0) goto L64
            long r4 = r11.f8820p
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 != 0) goto L64
            java.util.ArrayList r9 = r11.f8819o
            r9.add(r2)
            return
        L64:
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L70
            m1.r r11 = new m1.r
            r11.<init>()
            goto L76
        L70:
            java.lang.Object r11 = r0.pop()
            m1.r r11 = (m1.r) r11
        L76:
            java.util.ArrayList r0 = r11.f8819o
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 == 0) goto L82
            r7 = 1
        L82:
            l1.d.b(r7)
            boolean r4 = r0.isEmpty()
            l1.d.g(r4)
            r11.f8820p = r9
            r0.add(r2)
            r1.add(r11)
            r8.f2180f = r11
            int r9 = r8.f2175a
            if (r9 == r3) goto L9d
            r8.i(r9)
        L9d:
            return
        L9e:
            java.lang.Object r0 = r8.f2176b
            m1.s r0 = (m1.s) r0
            r0.a(r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.b.a(long, l1.t):void");
    }

    public void b() {
        View view = (View) this.f2176b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((p2) this.f2178d) != null) {
                if (((p2) this.f2180f) == null) {
                    this.f2180f = new p2();
                }
                p2 p2Var = (p2) this.f2180f;
                p2Var.f8517a = null;
                p2Var.f8520d = false;
                p2Var.f8518b = null;
                p2Var.f8519c = false;
                WeakHashMap weakHashMap = m0.k0.f8683a;
                ColorStateList c10 = m0.c0.c(view);
                if (c10 != null) {
                    p2Var.f8520d = true;
                    p2Var.f8517a = c10;
                }
                PorterDuff.Mode d6 = m0.c0.d(view);
                if (d6 != null) {
                    p2Var.f8519c = true;
                    p2Var.f8518b = d6;
                }
                if (p2Var.f8520d || p2Var.f8519c) {
                    m.r.e(background, p2Var, view.getDrawableState());
                    return;
                }
            }
            p2 p2Var2 = (p2) this.f2179e;
            if (p2Var2 != null) {
                m.r.e(background, p2Var2, view.getDrawableState());
                return;
            }
            p2 p2Var3 = (p2) this.f2178d;
            if (p2Var3 != null) {
                m.r.e(background, p2Var3, view.getDrawableState());
            }
        }
    }

    public boolean c(int i10) {
        ArrayList arrayList = (ArrayList) this.f2178d;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = (a) arrayList.get(i11);
            int i12 = aVar.f2169a;
            if (i12 != 8) {
                if (i12 == 1) {
                    int i13 = aVar.f2170b;
                    int i14 = aVar.f2172d + i13;
                    while (i13 < i14) {
                        if (h(i13, i11 + 1) == i10) {
                            return true;
                        }
                        i13++;
                    }
                } else {
                    continue;
                }
            } else {
                if (h(aVar.f2172d, i11 + 1) == i10) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d() {
        ArrayList arrayList = (ArrayList) this.f2178d;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e0) this.f2179e).a((a) arrayList.get(i10));
        }
        s(arrayList);
        this.f2175a = 0;
    }

    public void e() {
        e0 e0Var = (e0) this.f2179e;
        d();
        ArrayList arrayList = (ArrayList) this.f2177c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) arrayList.get(i10);
            int i11 = aVar.f2169a;
            if (i11 == 1) {
                e0Var.a(aVar);
                e0Var.d(aVar.f2170b, aVar.f2172d);
            } else if (i11 == 2) {
                e0Var.a(aVar);
                int i12 = aVar.f2170b;
                int i13 = aVar.f2172d;
                RecyclerView recyclerView = e0Var.f2214a;
                recyclerView.Q(i12, i13, true);
                recyclerView.f1493y0 = true;
                recyclerView.f1487v0.f2187c += i13;
            } else if (i11 == 4) {
                e0Var.a(aVar);
                e0Var.c(aVar.f2170b, aVar.f2172d, aVar.f2171c);
            } else if (i11 == 8) {
                e0Var.a(aVar);
                e0Var.e(aVar.f2170b, aVar.f2172d);
            }
        }
        s(arrayList);
        this.f2175a = 0;
    }

    public void f(a aVar) {
        int i10;
        l0.d dVar = (l0.d) this.f2176b;
        int i11 = aVar.f2169a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int y8 = y(aVar.f2170b, i11);
        int i12 = aVar.f2170b;
        int i13 = aVar.f2169a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + aVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < aVar.f2172d; i15++) {
            int y10 = y((i10 * i15) + aVar.f2170b, aVar.f2169a);
            int i16 = aVar.f2169a;
            if (i16 == 2 ? y10 != y8 : !(i16 == 4 && y10 == y8 + 1)) {
                a n10 = n(aVar.f2171c, i16, y8, i14);
                g(n10, i12);
                n10.f2171c = null;
                dVar.m(n10);
                if (aVar.f2169a == 4) {
                    i12 += i14;
                }
                i14 = 1;
                y8 = y10;
            } else {
                i14++;
            }
        }
        Object obj = aVar.f2171c;
        aVar.f2171c = null;
        dVar.m(aVar);
        if (i14 > 0) {
            a n11 = n(obj, aVar.f2169a, y8, i14);
            g(n11, i12);
            n11.f2171c = null;
            dVar.m(n11);
        }
    }

    public void g(a aVar, int i10) {
        e0 e0Var = (e0) this.f2179e;
        e0Var.a(aVar);
        int i11 = aVar.f2169a;
        if (i11 != 2) {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            e0Var.c(i10, aVar.f2172d, aVar.f2171c);
        } else {
            int i12 = aVar.f2172d;
            RecyclerView recyclerView = e0Var.f2214a;
            recyclerView.Q(i10, i12, true);
            recyclerView.f1493y0 = true;
            recyclerView.f1487v0.f2187c += i12;
        }
    }

    public int h(int i10, int i11) {
        ArrayList arrayList = (ArrayList) this.f2178d;
        int size = arrayList.size();
        while (i11 < size) {
            a aVar = (a) arrayList.get(i11);
            int i12 = aVar.f2169a;
            if (i12 == 8) {
                int i13 = aVar.f2170b;
                if (i13 == i10) {
                    i10 = aVar.f2172d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (aVar.f2172d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = aVar.f2170b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = aVar.f2172d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += aVar.f2172d;
                }
            }
            i11++;
        }
        return i10;
    }

    public void i(int i10) {
        ArrayList arrayList;
        PriorityQueue priorityQueue = (PriorityQueue) this.f2179e;
        while (priorityQueue.size() > i10) {
            m1.r rVar = (m1.r) priorityQueue.poll();
            int i11 = l1.a0.f8067a;
            int i12 = 0;
            while (true) {
                arrayList = rVar.f8819o;
                if (i12 >= arrayList.size()) {
                    break;
                }
                ((m1.s) this.f2176b).a(rVar.f8820p, (l1.t) arrayList.get(i12));
                ((ArrayDeque) this.f2177c).push((l1.t) arrayList.get(i12));
                i12++;
            }
            arrayList.clear();
            m1.r rVar2 = (m1.r) this.f2180f;
            if (rVar2 != null && rVar2.f8820p == rVar.f8820p) {
                this.f2180f = null;
            }
            ((ArrayDeque) this.f2178d).push(rVar);
        }
    }

    public ColorStateList j() {
        p2 p2Var = (p2) this.f2179e;
        if (p2Var != null) {
            return p2Var.f8517a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        p2 p2Var = (p2) this.f2179e;
        if (p2Var != null) {
            return p2Var.f8518b;
        }
        return null;
    }

    public boolean l() {
        return ((ArrayList) this.f2177c).size() > 0;
    }

    public void m(AttributeSet attributeSet, int i10) {
        ColorStateList i11;
        View view = (View) this.f2176b;
        Context context = view.getContext();
        int[] iArr = e.a.f4382z;
        android.support.v4.media.session.a0 T = android.support.v4.media.session.a0.T(context, attributeSet, iArr, i10);
        TypedArray typedArray = (TypedArray) T.f231q;
        View view2 = (View) this.f2176b;
        m0.k0.l(view2, view2.getContext(), iArr, attributeSet, (TypedArray) T.f231q, i10);
        try {
            if (typedArray.hasValue(0)) {
                this.f2175a = typedArray.getResourceId(0, -1);
                m.r rVar = (m.r) this.f2177c;
                Context context2 = view.getContext();
                int i12 = this.f2175a;
                synchronized (rVar) {
                    i11 = rVar.f8529a.i(context2, i12);
                }
                if (i11 != null) {
                    u(i11);
                }
            }
            if (typedArray.hasValue(1)) {
                m0.c0.g(view, T.J(1));
            }
            if (typedArray.hasValue(2)) {
                m0.c0.h(view, m.i1.c(typedArray.getInt(2, -1), null));
            }
            T.U();
        } catch (Throwable th) {
            T.U();
            throw th;
        }
    }

    public a n(Object obj, int i10, int i11, int i12) {
        a aVar = (a) ((l0.d) this.f2176b).v();
        if (aVar != null) {
            aVar.f2169a = i10;
            aVar.f2170b = i11;
            aVar.f2172d = i12;
            aVar.f2171c = obj;
            return aVar;
        }
        a aVar2 = new a();
        aVar2.f2169a = i10;
        aVar2.f2170b = i11;
        aVar2.f2172d = i12;
        aVar2.f2171c = obj;
        return aVar2;
    }

    public void o() {
        this.f2175a = -1;
        u(null);
        b();
    }

    public void p(int i10) {
        ColorStateList colorStateList;
        this.f2175a = i10;
        m.r rVar = (m.r) this.f2177c;
        if (rVar != null) {
            Context context = ((View) this.f2176b).getContext();
            synchronized (rVar) {
                colorStateList = rVar.f8529a.i(context, i10);
            }
        } else {
            colorStateList = null;
        }
        u(colorStateList);
        b();
    }

    public void q(a aVar) {
        e0 e0Var = (e0) this.f2179e;
        ((ArrayList) this.f2178d).add(aVar);
        int i10 = aVar.f2169a;
        if (i10 == 1) {
            e0Var.d(aVar.f2170b, aVar.f2172d);
            return;
        }
        if (i10 == 2) {
            int i11 = aVar.f2170b;
            int i12 = aVar.f2172d;
            RecyclerView recyclerView = e0Var.f2214a;
            recyclerView.Q(i11, i12, false);
            recyclerView.f1493y0 = true;
            return;
        }
        if (i10 == 4) {
            e0Var.c(aVar.f2170b, aVar.f2172d, aVar.f2171c);
        } else if (i10 == 8) {
            e0Var.e(aVar.f2170b, aVar.f2172d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r() {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.b.r():void");
    }

    public void s(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) arrayList.get(i10);
            aVar.f2171c = null;
            ((l0.d) this.f2176b).m(aVar);
        }
        arrayList.clear();
    }

    public void t(Runnable runnable) {
        l1.x xVar = (l1.x) this.f2176b;
        if (xVar.f8138a.getLooper().getThread().isAlive()) {
            xVar.c(runnable);
        }
    }

    public void u(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((p2) this.f2178d) == null) {
                this.f2178d = new p2();
            }
            p2 p2Var = (p2) this.f2178d;
            p2Var.f8517a = colorStateList;
            p2Var.f8520d = true;
        } else {
            this.f2178d = null;
        }
        b();
    }

    public void v(int i10) {
        l1.d.g(i10 >= 0);
        this.f2175a = i10;
        i(i10);
    }

    public void w(ColorStateList colorStateList) {
        if (((p2) this.f2179e) == null) {
            this.f2179e = new p2();
        }
        p2 p2Var = (p2) this.f2179e;
        p2Var.f8517a = colorStateList;
        p2Var.f8520d = true;
        b();
    }

    public void x(PorterDuff.Mode mode) {
        if (((p2) this.f2179e) == null) {
            this.f2179e = new p2();
        }
        p2 p2Var = (p2) this.f2179e;
        p2Var.f8518b = mode;
        p2Var.f8519c = true;
        b();
    }

    public int y(int i10, int i11) {
        int i12;
        int i13;
        l0.d dVar = (l0.d) this.f2176b;
        ArrayList arrayList = (ArrayList) this.f2178d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            int i14 = aVar.f2169a;
            if (i14 == 8) {
                int i15 = aVar.f2170b;
                int i16 = aVar.f2172d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            aVar.f2170b = i15 + 1;
                            aVar.f2172d = i16 + 1;
                        } else if (i11 == 2) {
                            aVar.f2170b = i15 - 1;
                            aVar.f2172d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        aVar.f2172d = i16 + 1;
                    } else if (i11 == 2) {
                        aVar.f2172d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        aVar.f2170b = i15 + 1;
                    } else if (i11 == 2) {
                        aVar.f2170b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = aVar.f2170b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= aVar.f2172d;
                    } else if (i14 == 2) {
                        i10 += aVar.f2172d;
                    }
                } else if (i11 == 1) {
                    aVar.f2170b = i17 + 1;
                } else if (i11 == 2) {
                    aVar.f2170b = i17 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            a aVar2 = (a) arrayList.get(size2);
            if (aVar2.f2169a == 8) {
                int i18 = aVar2.f2172d;
                if (i18 == aVar2.f2170b || i18 < 0) {
                    arrayList.remove(size2);
                    aVar2.f2171c = null;
                    dVar.m(aVar2);
                }
            } else if (aVar2.f2172d <= 0) {
                arrayList.remove(size2);
                aVar2.f2171c = null;
                dVar.m(aVar2);
            }
        }
        return i10;
    }

    public void z(Object obj) {
        Object obj2 = this.f2179e;
        this.f2179e = obj;
        if (obj2.equals(obj)) {
            return;
        }
        s1.a0 a0Var = ((s1.s) this.f2178d).f11449o;
        ((Integer) obj2).getClass();
        Integer num = (Integer) obj;
        int intValue = num.intValue();
        a0Var.f0();
        a0Var.R(1, 10, num);
        a0Var.R(2, 10, num);
        a0Var.f11204m.e(21, new s1.t(intValue, 1));
    }

    public b(m1.s sVar) {
        this.f2176b = sVar;
        this.f2177c = new ArrayDeque();
        this.f2178d = new ArrayDeque();
        this.f2179e = new PriorityQueue();
        this.f2175a = -1;
    }

    public b(e0 e0Var) {
        this.f2176b = new l0.d(30);
        this.f2177c = new ArrayList();
        this.f2178d = new ArrayList();
        this.f2175a = 0;
        this.f2179e = e0Var;
        this.f2180f = new a6.n(14, this);
    }

    public b(Object obj, Looper looper, Looper looper2, l1.v vVar, s1.s sVar) {
        this.f2176b = vVar.a(looper, null);
        this.f2177c = vVar.a(looper2, null);
        this.f2179e = obj;
        this.f2180f = obj;
        this.f2178d = sVar;
    }
}
