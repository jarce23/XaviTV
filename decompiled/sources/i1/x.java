package i1;

import android.net.Uri;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f6061a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6062b;

    /* renamed from: c, reason: collision with root package name */
    public final List f6063c;

    /* renamed from: d, reason: collision with root package name */
    public final o9.g0 f6064d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6065e;

    static {
        android.support.v4.media.d.t(0, 1, 2, 3, 4);
        l1.a0.J(5);
        l1.a0.J(6);
        l1.a0.J(7);
    }

    public x(Uri uri, String str, n4.a aVar, List list, o9.g0 g0Var, long j10) {
        this.f6061a = uri;
        this.f6062b = g0.m(str);
        this.f6063c = list;
        this.f6064d = g0Var;
        o9.d0 m10 = o9.g0.m();
        for (int i10 = 0; i10 < g0Var.size(); i10++) {
            ((z) g0Var.get(i10)).getClass();
            m10.a(new z());
        }
        m10.f();
        this.f6065e = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f6061a.equals(xVar.f6061a) && Objects.equals(this.f6062b, xVar.f6062b) && Objects.equals(null, null) && this.f6063c.equals(xVar.f6063c) && this.f6064d.equals(xVar.f6064d) && this.f6065e == xVar.f6065e;
    }

    public final int hashCode() {
        int hashCode = this.f6061a.hashCode() * 31;
        return (int) (((this.f6064d.hashCode() + ((this.f6063c.hashCode() + ((hashCode + (this.f6062b == null ? 0 : r1.hashCode())) * 29791)) * 961)) * 31 * 31) + this.f6065e);
    }
}
