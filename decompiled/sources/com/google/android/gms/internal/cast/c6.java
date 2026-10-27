package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c6 {

    /* renamed from: a, reason: collision with root package name */
    public final o4 f3287a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3288b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f3289c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3290d;

    public c6(o4 o4Var, String str, Object[] objArr) {
        this.f3287a = o4Var;
        this.f3288b = str;
        this.f3289c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f3290d = charAt;
            return;
        }
        int i10 = charAt & 8191;
        int i11 = 1;
        int i12 = 13;
        while (true) {
            int i13 = i11 + 1;
            char charAt2 = str.charAt(i11);
            if (charAt2 < 55296) {
                this.f3290d = i10 | (charAt2 << i12);
                return;
            } else {
                i10 |= (charAt2 & 8191) << i12;
                i12 += 13;
                i11 = i13;
            }
        }
    }

    public final int a() {
        int i10 = this.f3290d;
        if ((i10 & 1) != 0) {
            return 1;
        }
        return (i10 & 4) == 4 ? 3 : 2;
    }
}
