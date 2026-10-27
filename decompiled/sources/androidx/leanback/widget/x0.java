package androidx.leanback.widget;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: c, reason: collision with root package name */
    public int f1092c;

    /* renamed from: d, reason: collision with root package name */
    public int f1093d;

    /* renamed from: i, reason: collision with root package name */
    public int f1097i;

    /* renamed from: j, reason: collision with root package name */
    public int f1098j;

    /* renamed from: k, reason: collision with root package name */
    public int f1099k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1100l;

    /* renamed from: e, reason: collision with root package name */
    public int f1094e = 2;

    /* renamed from: f, reason: collision with root package name */
    public int f1095f = 3;
    public int g = 0;

    /* renamed from: h, reason: collision with root package name */
    public float f1096h = 50.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f1091b = Integer.MIN_VALUE;

    /* renamed from: a, reason: collision with root package name */
    public int f1090a = Integer.MAX_VALUE;

    public final int a() {
        if (this.f1100l) {
            int i10 = this.g;
            int i11 = i10 >= 0 ? this.f1097i - i10 : -i10;
            float f10 = this.f1096h;
            return f10 != -1.0f ? i11 - ((int) ((this.f1097i * f10) / 100.0f)) : i11;
        }
        int i12 = this.g;
        if (i12 < 0) {
            i12 += this.f1097i;
        }
        float f11 = this.f1096h;
        return f11 != -1.0f ? i12 + ((int) ((this.f1097i * f11) / 100.0f)) : i12;
    }

    public final int b(int i10) {
        int i11;
        int i12;
        int i13 = this.f1097i;
        int a10 = a();
        int i14 = this.f1091b;
        boolean z10 = i14 == Integer.MIN_VALUE;
        int i15 = this.f1090a;
        boolean z11 = i15 == Integer.MAX_VALUE;
        if (!z10) {
            int i16 = this.f1098j;
            int i17 = a10 - i16;
            if (this.f1100l ? (this.f1095f & 2) != 0 : (this.f1095f & 1) != 0) {
                if (i10 - i14 <= i17) {
                    int i18 = i14 - i16;
                    return (z11 || i18 <= (i12 = this.f1092c)) ? i18 : i12;
                }
            }
        }
        if (!z11) {
            int i19 = this.f1099k;
            int i20 = (i13 - a10) - i19;
            if (this.f1100l ? (1 & this.f1095f) != 0 : (this.f1095f & 2) != 0) {
                if (i15 - i10 <= i20) {
                    int i21 = i15 - (i13 - i19);
                    return (z10 || i21 >= (i11 = this.f1093d)) ? i21 : i11;
                }
            }
        }
        return i10 - a10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        r6.f1093d = r0 - r6.f1098j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r6.f1092c = (r4 - r6.f1098j) - r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r7, int r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.x0.c(int, int, int, int):void");
    }

    public final String toString() {
        return " min:" + this.f1091b + " " + this.f1093d + " max:" + this.f1090a + " " + this.f1092c;
    }
}
