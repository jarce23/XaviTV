package e0;

import android.graphics.Insets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f4384e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f4385a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4386b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4387c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4388d;

    public c(int i10, int i11, int i12, int i13) {
        this.f4385a = i10;
        this.f4386b = i11;
        this.f4387c = i12;
        this.f4388d = i13;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f4385a, cVar2.f4385a), Math.max(cVar.f4386b, cVar2.f4386b), Math.max(cVar.f4387c, cVar2.f4387c), Math.max(cVar.f4388d, cVar2.f4388d));
    }

    public static c b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f4384e : new c(i10, i11, i12, i13);
    }

    public static c c(Insets insets) {
        int i10;
        int i11;
        int i12;
        int i13;
        i10 = insets.left;
        i11 = insets.top;
        i12 = insets.right;
        i13 = insets.bottom;
        return b(i10, i11, i12, i13);
    }

    public final Insets d() {
        return b.a(this.f4385a, this.f4386b, this.f4387c, this.f4388d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f4388d == cVar.f4388d && this.f4385a == cVar.f4385a && this.f4387c == cVar.f4387c && this.f4386b == cVar.f4386b;
    }

    public final int hashCode() {
        return (((((this.f4385a * 31) + this.f4386b) * 31) + this.f4387c) * 31) + this.f4388d;
    }

    public final String toString() {
        return "Insets{left=" + this.f4385a + ", top=" + this.f4386b + ", right=" + this.f4387c + ", bottom=" + this.f4388d + '}';
    }
}
