package c2;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: d, reason: collision with root package name */
    public static final n1 f2659d = new n1(new i1.u0[0]);

    /* renamed from: a, reason: collision with root package name */
    public final int f2660a;

    /* renamed from: b, reason: collision with root package name */
    public final o9.w0 f2661b;

    /* renamed from: c, reason: collision with root package name */
    public int f2662c;

    static {
        l1.a0.J(0);
    }

    public n1(i1.u0... u0VarArr) {
        o9.w0 o2 = o9.g0.o(u0VarArr);
        this.f2661b = o2;
        this.f2660a = u0VarArr.length;
        int i10 = 0;
        while (i10 < o2.f9688r) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < o2.f9688r; i12++) {
                if (((i1.u0) o2.get(i10)).equals(o2.get(i12))) {
                    l1.b.h("TrackGroupArray", _UrlKt.FRAGMENT_ENCODE_SET, new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i10 = i11;
        }
    }

    public final i1.u0 a(int i10) {
        return (i1.u0) this.f2661b.get(i10);
    }

    public final int b(i1.u0 u0Var) {
        int indexOf = this.f2661b.indexOf(u0Var);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n1.class != obj.getClass()) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return this.f2660a == n1Var.f2660a && this.f2661b.equals(n1Var.f2661b);
    }

    public final int hashCode() {
        if (this.f2662c == 0) {
            this.f2662c = this.f2661b.hashCode();
        }
        return this.f2662c;
    }

    public final String toString() {
        return this.f2661b.toString();
    }
}
