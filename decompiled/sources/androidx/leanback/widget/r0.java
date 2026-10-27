package androidx.leanback.widget;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r0 extends j {

    /* renamed from: j, reason: collision with root package name */
    public b4.p f1067j;

    /* renamed from: k, reason: collision with root package name */
    public int f1068k;

    /* renamed from: l, reason: collision with root package name */
    public Object f1069l;

    /* renamed from: m, reason: collision with root package name */
    public int f1070m;

    @Override // androidx.leanback.widget.j
    public final boolean b(int i10, boolean z10) {
        Object[] objArr = this.f1023a;
        if (this.f1024b.q() == 0 || (!z10 && c(i10))) {
            return false;
        }
        try {
            if (!o(i10, z10)) {
                return q(i10, z10);
            }
            objArr[0] = null;
            this.f1069l = null;
            return true;
        } finally {
            objArr[0] = null;
            this.f1069l = null;
        }
    }

    @Override // androidx.leanback.widget.j
    public final int f(int i10, boolean z10, int[] iArr) {
        int i11;
        int r2 = this.f1024b.r(i10);
        q0 k10 = k(i10);
        int i12 = k10.f1022o;
        if (this.f1025c) {
            i11 = i12;
            int i13 = i11;
            int i14 = 1;
            int i15 = r2;
            for (int i16 = i10 + 1; i14 < this.f1027e && i16 <= this.g; i16++) {
                q0 k11 = k(i16);
                i15 += k11.f1065p;
                int i17 = k11.f1022o;
                if (i17 != i13) {
                    i14++;
                    if (!z10 ? i15 >= r2 : i15 <= r2) {
                        i13 = i17;
                    } else {
                        r2 = i15;
                        i10 = i16;
                        i11 = i17;
                        i13 = i11;
                    }
                }
            }
        } else {
            int i18 = 1;
            int i19 = i12;
            q0 q0Var = k10;
            int i20 = r2;
            r2 = this.f1024b.E(i10) + r2;
            i11 = i19;
            for (int i21 = i10 - 1; i18 < this.f1027e && i21 >= this.f1028f; i21--) {
                i20 -= q0Var.f1065p;
                q0Var = k(i21);
                int i22 = q0Var.f1022o;
                if (i22 != i19) {
                    i18++;
                    int E = this.f1024b.E(i21) + i20;
                    if (!z10 ? E >= r2 : E <= r2) {
                        i19 = i22;
                    } else {
                        r2 = E;
                        i10 = i21;
                        i11 = i22;
                        i19 = i11;
                    }
                }
            }
        }
        if (iArr != null) {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return r2;
    }

    @Override // androidx.leanback.widget.j
    public final int h(int i10, boolean z10, int[] iArr) {
        int i11;
        int r2 = this.f1024b.r(i10);
        q0 k10 = k(i10);
        int i12 = k10.f1022o;
        if (this.f1025c) {
            int i13 = 1;
            i11 = r2 - this.f1024b.E(i10);
            int i14 = i12;
            for (int i15 = i10 - 1; i13 < this.f1027e && i15 >= this.f1028f; i15--) {
                r2 -= k10.f1065p;
                k10 = k(i15);
                int i16 = k10.f1022o;
                if (i16 != i14) {
                    i13++;
                    int E = r2 - this.f1024b.E(i15);
                    if (!z10 ? E >= i11 : E <= i11) {
                        i14 = i16;
                    } else {
                        i11 = E;
                        i10 = i15;
                        i12 = i16;
                        i14 = i12;
                    }
                }
            }
        } else {
            int i17 = i12;
            int i18 = i17;
            int i19 = 1;
            int i20 = r2;
            for (int i21 = i10 + 1; i19 < this.f1027e && i21 <= this.g; i21++) {
                q0 k11 = k(i21);
                i20 += k11.f1065p;
                int i22 = k11.f1022o;
                if (i22 != i18) {
                    i19++;
                    if (!z10 ? i20 >= r2 : i20 <= r2) {
                        i18 = i22;
                    } else {
                        r2 = i20;
                        i10 = i21;
                        i17 = i22;
                        i18 = i17;
                    }
                }
            }
            i11 = r2;
            i12 = i17;
        }
        if (iArr != null) {
            iArr[0] = i12;
            iArr[1] = i10;
        }
        return i11;
    }

    @Override // androidx.leanback.widget.j
    public final b4.p[] j(int i10, int i11) {
        for (int i12 = 0; i12 < this.f1027e; i12++) {
            b4.p pVar = this.f1029h[i12];
            pVar.f2379d = pVar.f2378c;
        }
        if (i10 >= 0) {
            while (i10 <= i11) {
                b4.p pVar2 = this.f1029h[k(i10).f1022o];
                if (pVar2.h() > 0) {
                    int i13 = pVar2.f2378c;
                    int i14 = pVar2.f2379d;
                    if (i13 == i14) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    int[] iArr = (int[]) pVar2.f2377b;
                    int i15 = pVar2.f2380e;
                    if (iArr[(i14 - 1) & i15] == i10 - 1) {
                        if (i13 == i14) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        int i16 = (i14 - 1) & i15;
                        int i17 = iArr[i16];
                        pVar2.f2379d = i16;
                        pVar2.a(i10);
                        i10++;
                    }
                }
                pVar2.a(i10);
                pVar2.a(i10);
                i10++;
            }
        }
        return this.f1029h;
    }

    @Override // androidx.leanback.widget.j
    public final void l(int i10) {
        super.l(i10);
        b4.p pVar = this.f1067j;
        pVar.f((s() - i10) + 1);
        if (pVar.h() == 0) {
            this.f1068k = -1;
        }
    }

    @Override // androidx.leanback.widget.j
    public final boolean m(int i10, boolean z10) {
        Object[] objArr = this.f1023a;
        if (this.f1024b.q() == 0 || (!z10 && d(i10))) {
            return false;
        }
        try {
            if (!w(i10, z10)) {
                return y(i10, z10);
            }
            objArr[0] = null;
            this.f1069l = null;
            return true;
        } finally {
            objArr[0] = null;
            this.f1069l = null;
        }
    }

    public final boolean o(int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        b4.p pVar = this.f1067j;
        if (pVar.h() != 0) {
            int q10 = this.f1024b.q();
            int i14 = this.g;
            if (i14 >= 0) {
                i11 = i14 + 1;
                i12 = this.f1024b.r(i14);
            } else {
                int i15 = this.f1030i;
                i11 = i15 != -1 ? i15 : 0;
                if (i11 > s() + 1 || i11 < this.f1068k) {
                    pVar.g(pVar.h());
                    return false;
                }
                if (i11 <= s()) {
                    i12 = Integer.MAX_VALUE;
                }
            }
            int s10 = s();
            int i16 = i11;
            while (i16 < q10 && i16 <= s10) {
                q0 k10 = k(i16);
                if (i12 != Integer.MAX_VALUE) {
                    i12 += k10.f1065p;
                }
                int i17 = i12;
                int i18 = k10.f1022o;
                a6.n nVar = this.f1024b;
                Object[] objArr = this.f1023a;
                int p10 = nVar.p(i16, true, objArr, false);
                if (p10 != k10.f1066q) {
                    k10.f1066q = p10;
                    pVar.f(s10 - i16);
                    i13 = i16;
                } else {
                    i13 = s10;
                }
                this.g = i16;
                if (this.f1028f < 0) {
                    this.f1028f = i16;
                }
                this.f1024b.b(objArr[0], i16, p10, i18, i17);
                if (z10 || !c(i10)) {
                    i12 = i17 == Integer.MAX_VALUE ? this.f1024b.r(i16) : i17;
                    if (i18 != this.f1027e - 1 || !z10) {
                        i16++;
                        s10 = i13;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int p(int i10, int i11, int i12) {
        int r2;
        b4.p pVar = this.f1067j;
        int i13 = this.g;
        if (i13 >= 0 && (i13 != s() || this.g != i10 - 1)) {
            throw new IllegalStateException();
        }
        int i14 = this.g;
        if (i14 >= 0) {
            r2 = i12 - this.f1024b.r(i14);
        } else if (pVar.h() <= 0 || i10 != s() + 1) {
            r2 = 0;
        } else {
            int s10 = s();
            while (true) {
                if (s10 < this.f1068k) {
                    s10 = s();
                    break;
                }
                if (k(s10).f1022o == i11) {
                    break;
                }
                s10--;
            }
            r2 = this.f1025c ? (-k(s10).f1066q) - this.f1026d : k(s10).f1066q + this.f1026d;
            for (int i15 = s10 + 1; i15 <= s(); i15++) {
                r2 -= k(i15).f1065p;
            }
        }
        q0 q0Var = new q0(i11, r2);
        Object[] objArr = (Object[]) pVar.f2377b;
        int i16 = pVar.f2379d;
        objArr[i16] = q0Var;
        int i17 = pVar.f2380e & (i16 + 1);
        pVar.f2379d = i17;
        if (i17 == pVar.f2378c) {
            pVar.d();
        }
        Object obj = this.f1069l;
        if (obj != null) {
            q0Var.f1066q = this.f1070m;
            this.f1069l = null;
        } else {
            a6.n nVar = this.f1024b;
            Object[] objArr2 = this.f1023a;
            q0Var.f1066q = nVar.p(i10, true, objArr2, false);
            obj = objArr2[0];
        }
        Object obj2 = obj;
        if (pVar.h() == 1) {
            this.g = i10;
            this.f1028f = i10;
            this.f1068k = i10;
        } else {
            int i18 = this.g;
            if (i18 < 0) {
                this.g = i10;
                this.f1028f = i10;
            } else {
                this.g = i18 + 1;
            }
        }
        this.f1024b.b(obj2, i10, q0Var.f1066q, i11, i12);
        return q0Var.f1066q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0136, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.r0.q(int, boolean):boolean");
    }

    public final int r(boolean z10) {
        boolean z11 = false;
        if (z10) {
            for (int i10 = this.g; i10 >= this.f1028f; i10--) {
                int i11 = k(i10).f1022o;
                if (i11 == 0) {
                    z11 = true;
                } else if (z11 && i11 == this.f1027e - 1) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i12 = this.f1028f; i12 <= this.g; i12++) {
            int i13 = k(i12).f1022o;
            if (i13 == this.f1027e - 1) {
                z11 = true;
            } else if (z11 && i13 == 0) {
                return i12;
            }
        }
        return -1;
    }

    public final int s() {
        return (this.f1067j.h() + this.f1068k) - 1;
    }

    @Override // androidx.leanback.widget.j
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final q0 k(int i10) {
        b4.p pVar = this.f1067j;
        int i11 = i10 - this.f1068k;
        if (i11 < 0 || i11 >= pVar.h()) {
            return null;
        }
        if (i11 < 0) {
            pVar.getClass();
        } else if (i11 < pVar.h()) {
            Object obj = ((Object[]) pVar.f2377b)[pVar.f2380e & (pVar.f2378c + i11)];
            za.h.b(obj);
            return (q0) obj;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int u(int i10) {
        int i11;
        q0 k10;
        int i12 = this.f1028f;
        if (i12 < 0) {
            return Integer.MIN_VALUE;
        }
        if (this.f1025c) {
            int r2 = this.f1024b.r(i12);
            if (k(this.f1028f).f1022o == i10) {
                return r2;
            }
            int i13 = this.f1028f;
            do {
                i13++;
                if (i13 <= s()) {
                    k10 = k(i13);
                    r2 += k10.f1065p;
                }
            } while (k10.f1022o != i10);
            return r2;
        }
        int r10 = this.f1024b.r(this.g);
        q0 k11 = k(this.g);
        if (k11.f1022o == i10) {
            i11 = k11.f1066q;
        } else {
            int i14 = this.g;
            do {
                i14--;
                if (i14 >= this.f1068k) {
                    r10 -= k11.f1065p;
                    k11 = k(i14);
                }
            } while (k11.f1022o != i10);
            i11 = k11.f1066q;
        }
        return r10 + i11;
        return Integer.MIN_VALUE;
    }

    public final int v(int i10) {
        q0 k10;
        int i11;
        int i12 = this.f1028f;
        if (i12 < 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.f1025c) {
            int r2 = this.f1024b.r(i12);
            if (k(this.f1028f).f1022o == i10) {
                return r2;
            }
            int i13 = this.f1028f;
            do {
                i13++;
                if (i13 <= s()) {
                    k10 = k(i13);
                    r2 += k10.f1065p;
                }
            } while (k10.f1022o != i10);
            return r2;
        }
        int r10 = this.f1024b.r(this.g);
        q0 k11 = k(this.g);
        if (k11.f1022o == i10) {
            i11 = k11.f1066q;
        } else {
            int i14 = this.g;
            do {
                i14--;
                if (i14 >= this.f1068k) {
                    r10 -= k11.f1065p;
                    k11 = k(i14);
                }
            } while (k11.f1022o != i10);
            i11 = k11.f1066q;
        }
        return r10 - i11;
        return Integer.MAX_VALUE;
    }

    public final boolean w(int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        b4.p pVar = this.f1067j;
        if (pVar.h() != 0) {
            int i14 = this.f1028f;
            if (i14 < 0) {
                int i15 = this.f1030i;
                i11 = i15 != -1 ? i15 : 0;
                if (i11 <= s()) {
                    int i16 = this.f1068k;
                    if (i11 >= i16 - 1) {
                        if (i11 >= i16) {
                            i12 = Integer.MAX_VALUE;
                            i13 = 0;
                        }
                    }
                }
                pVar.g(pVar.h());
                return false;
            }
            i12 = this.f1024b.r(i14);
            i13 = k(this.f1028f).f1065p;
            i11 = this.f1028f - 1;
            int max = Math.max(((p) this.f1024b.f74p).f1059u, this.f1068k);
            for (int i17 = i11; i17 >= max; i17--) {
                q0 k10 = k(i17);
                int i18 = k10.f1022o;
                a6.n nVar = this.f1024b;
                Object[] objArr = this.f1023a;
                int p10 = nVar.p(i17, false, objArr, false);
                if (p10 != k10.f1066q) {
                    pVar.g((i17 + 1) - this.f1068k);
                    this.f1068k = this.f1028f;
                    this.f1069l = objArr[0];
                    this.f1070m = p10;
                    return false;
                }
                this.f1028f = i17;
                if (this.g < 0) {
                    this.g = i17;
                }
                this.f1024b.b(objArr[0], i17, p10, i18, i12 - i13);
                if (z10 || !d(i10)) {
                    i12 = this.f1024b.r(i17);
                    i13 = k10.f1065p;
                    if (i18 != 0 || !z10) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int x(int i10, int i11, int i12) {
        int i13 = this.f1028f;
        if (i13 >= 0 && (i13 != this.f1068k || i13 != i10 + 1)) {
            throw new IllegalStateException();
        }
        int i14 = this.f1068k;
        q0 k10 = i14 >= 0 ? k(i14) : null;
        int r2 = this.f1024b.r(this.f1068k);
        q0 q0Var = new q0(i11, 0);
        b4.p pVar = this.f1067j;
        int i15 = (pVar.f2378c - 1) & pVar.f2380e;
        pVar.f2378c = i15;
        ((Object[]) pVar.f2377b)[i15] = q0Var;
        if (i15 == pVar.f2379d) {
            pVar.d();
        }
        Object obj = this.f1069l;
        if (obj != null) {
            q0Var.f1066q = this.f1070m;
            this.f1069l = null;
        } else {
            a6.n nVar = this.f1024b;
            Object[] objArr = this.f1023a;
            q0Var.f1066q = nVar.p(i10, false, objArr, false);
            obj = objArr[0];
        }
        Object obj2 = obj;
        this.f1028f = i10;
        this.f1068k = i10;
        if (this.g < 0) {
            this.g = i10;
        }
        int i16 = !this.f1025c ? i12 - q0Var.f1066q : i12 + q0Var.f1066q;
        if (k10 != null) {
            k10.f1065p = r2 - i16;
        }
        this.f1024b.b(obj2, i10, q0Var.f1066q, i11, i16);
        return q0Var.f1066q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x012a, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fb A[LOOP:2: B:54:0x00fb->B:68:0x011f, LOOP_START, PHI: r5 r8 r9
  0x00fb: PHI (r5v12 int) = (r5v6 int), (r5v17 int) binds: [B:53:0x00f9, B:68:0x011f] A[DONT_GENERATE, DONT_INLINE]
  0x00fb: PHI (r8v19 int) = (r8v17 int), (r8v20 int) binds: [B:53:0x00f9, B:68:0x011f] A[DONT_GENERATE, DONT_INLINE]
  0x00fb: PHI (r9v8 int) = (r9v6 int), (r9v10 int) binds: [B:53:0x00f9, B:68:0x011f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y(int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.r0.y(int, boolean):boolean");
    }
}
