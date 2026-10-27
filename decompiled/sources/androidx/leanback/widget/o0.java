package androidx.leanback.widget;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o0 extends j {

    /* renamed from: j, reason: collision with root package name */
    public final i f1049j = new i(0);

    public o0() {
        n(1);
    }

    @Override // androidx.leanback.widget.j
    public final boolean b(int i10, boolean z10) {
        int min;
        int i11;
        if (this.f1024b.q() == 0 || (!z10 && c(i10))) {
            return false;
        }
        int i12 = this.g;
        if (i12 >= 0) {
            min = i12 + 1;
        } else {
            int i13 = this.f1030i;
            min = i13 != -1 ? Math.min(i13, this.f1024b.q() - 1) : 0;
        }
        int i14 = min;
        boolean z11 = false;
        while (i14 < this.f1024b.q()) {
            a6.n nVar = this.f1024b;
            Object[] objArr = this.f1023a;
            int p10 = nVar.p(i14, true, objArr, false);
            if (this.f1028f < 0 || this.g < 0) {
                i11 = this.f1025c ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                this.f1028f = i14;
                this.g = i14;
            } else {
                if (this.f1025c) {
                    int i15 = i14 - 1;
                    i11 = (this.f1024b.r(i15) - this.f1024b.E(i15)) - this.f1026d;
                } else {
                    int i16 = i14 - 1;
                    i11 = this.f1026d + this.f1024b.E(i16) + this.f1024b.r(i16);
                }
                this.g = i14;
            }
            this.f1024b.b(objArr[0], i14, p10, 0, i11);
            if (z10 || c(i10)) {
                return true;
            }
            i14++;
            z11 = true;
        }
        return z11;
    }

    @Override // androidx.leanback.widget.j
    public final void e(int i10, int i11, b4.p pVar) {
        int o2;
        int r2;
        if (!this.f1025c ? i11 < 0 : i11 > 0) {
            if (this.g == this.f1024b.q() - 1) {
                return;
            }
            int i12 = this.g;
            if (i12 >= 0) {
                o2 = i12 + 1;
            } else {
                int i13 = this.f1030i;
                o2 = i13 != -1 ? Math.min(i13, this.f1024b.q() - 1) : 0;
            }
            int E = this.f1024b.E(this.g) + this.f1026d;
            int r10 = this.f1024b.r(this.g);
            if (this.f1025c) {
                E = -E;
            }
            r2 = E + r10;
        } else {
            if (this.f1028f == 0) {
                return;
            }
            o2 = o();
            r2 = this.f1024b.r(this.f1028f) + (this.f1025c ? this.f1026d : -this.f1026d);
        }
        pVar.b(o2, Math.abs(r2 - i10));
    }

    @Override // androidx.leanback.widget.j
    public final int f(int i10, boolean z10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        if (this.f1025c) {
            return this.f1024b.r(i10);
        }
        return this.f1024b.E(i10) + this.f1024b.r(i10);
    }

    @Override // androidx.leanback.widget.j
    public final int h(int i10, boolean z10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        return this.f1025c ? this.f1024b.r(i10) - this.f1024b.E(i10) : this.f1024b.r(i10);
    }

    @Override // androidx.leanback.widget.j
    public final b4.p[] j(int i10, int i11) {
        b4.p pVar = this.f1029h[0];
        pVar.f2379d = pVar.f2378c;
        pVar.a(i10);
        this.f1029h[0].a(i11);
        return this.f1029h;
    }

    @Override // androidx.leanback.widget.j
    public final i k(int i10) {
        return this.f1049j;
    }

    @Override // androidx.leanback.widget.j
    public final boolean m(int i10, boolean z10) {
        int i11;
        if (this.f1024b.q() == 0 || (!z10 && d(i10))) {
            return false;
        }
        int i12 = ((p) this.f1024b.f74p).f1059u;
        boolean z11 = false;
        for (int o2 = o(); o2 >= i12; o2--) {
            a6.n nVar = this.f1024b;
            Object[] objArr = this.f1023a;
            int p10 = nVar.p(o2, false, objArr, false);
            if (this.f1028f < 0 || this.g < 0) {
                i11 = this.f1025c ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                this.f1028f = o2;
                this.g = o2;
            } else {
                i11 = this.f1025c ? this.f1024b.r(o2 + 1) + this.f1026d + p10 : (this.f1024b.r(o2 + 1) - this.f1026d) - p10;
                this.f1028f = o2;
            }
            this.f1024b.b(objArr[0], o2, p10, 0, i11);
            z11 = true;
            if (z10 || d(i10)) {
                break;
            }
        }
        return z11;
    }

    public final int o() {
        int i10 = this.f1028f;
        if (i10 >= 0) {
            return i10 - 1;
        }
        int i11 = this.f1030i;
        return i11 != -1 ? Math.min(i11, this.f1024b.q() - 1) : this.f1024b.q() - 1;
    }
}
