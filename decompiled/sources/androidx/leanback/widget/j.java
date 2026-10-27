package androidx.leanback.widget;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: b, reason: collision with root package name */
    public a6.n f1024b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1025c;

    /* renamed from: d, reason: collision with root package name */
    public int f1026d;

    /* renamed from: e, reason: collision with root package name */
    public int f1027e;

    /* renamed from: h, reason: collision with root package name */
    public b4.p[] f1029h;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1023a = new Object[1];

    /* renamed from: f, reason: collision with root package name */
    public int f1028f = -1;
    public int g = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1030i = -1;

    public final boolean a() {
        return b(this.f1025c ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    public abstract boolean b(int i10, boolean z10);

    public final boolean c(int i10) {
        return this.g >= 0 && (!this.f1025c ? g(false, null) < i10 - this.f1026d : i(true, null) > i10 + this.f1026d);
    }

    public final boolean d(int i10) {
        return this.g >= 0 && (!this.f1025c ? i(true, null) > i10 + this.f1026d : g(false, null) < i10 - this.f1026d);
    }

    public abstract int f(int i10, boolean z10, int[] iArr);

    public final int g(boolean z10, int[] iArr) {
        return f(this.f1025c ? this.f1028f : this.g, z10, iArr);
    }

    public abstract int h(int i10, boolean z10, int[] iArr);

    public final int i(boolean z10, int[] iArr) {
        return h(this.f1025c ? this.g : this.f1028f, z10, iArr);
    }

    public abstract b4.p[] j(int i10, int i11);

    public abstract i k(int i10);

    public void l(int i10) {
        int i11;
        if (i10 >= 0 && (i11 = this.g) >= 0) {
            if (i11 >= i10) {
                this.g = i10 - 1;
            }
            if (this.g < this.f1028f) {
                this.g = -1;
                this.f1028f = -1;
            }
            if (this.f1028f < 0) {
                this.f1030i = i10;
            }
        }
    }

    public abstract boolean m(int i10, boolean z10);

    public final void n(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.f1027e == i10) {
            return;
        }
        this.f1027e = i10;
        this.f1029h = new b4.p[i10];
        for (int i11 = 0; i11 < this.f1027e; i11++) {
            this.f1029h[i11] = new b4.p();
        }
    }

    public void e(int i10, int i11, b4.p pVar) {
    }
}
