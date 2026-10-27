package i1;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f5792a;

    /* renamed from: b, reason: collision with root package name */
    public final x f5793b;

    /* renamed from: c, reason: collision with root package name */
    public final w f5794c;

    /* renamed from: d, reason: collision with root package name */
    public final d0 f5795d;

    /* renamed from: e, reason: collision with root package name */
    public final u f5796e;

    /* renamed from: f, reason: collision with root package name */
    public final y f5797f;

    static {
        s sVar = new s();
        o9.e0 e0Var = o9.g0.f9617p;
        o9.w0 w0Var = o9.w0.f9686s;
        List list = Collections.EMPTY_LIST;
        o9.w0 w0Var2 = o9.w0.f9686s;
        v vVar = new v();
        y yVar = y.f6072a;
        sVar.a();
        vVar.a();
        d0 d0Var = d0.B;
        android.support.v4.media.d.t(0, 1, 2, 3, 4);
        l1.a0.J(5);
    }

    public a0(String str, u uVar, x xVar, w wVar, d0 d0Var, y yVar) {
        this.f5792a = str;
        this.f5793b = xVar;
        this.f5794c = wVar;
        this.f5795d = d0Var;
        this.f5796e = uVar;
        this.f5797f = yVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Objects.equals(this.f5792a, a0Var.f5792a) && this.f5796e.equals(a0Var.f5796e) && Objects.equals(this.f5793b, a0Var.f5793b) && this.f5794c.equals(a0Var.f5794c) && Objects.equals(this.f5795d, a0Var.f5795d) && Objects.equals(this.f5797f, a0Var.f5797f);
    }

    public final int hashCode() {
        int hashCode = this.f5792a.hashCode() * 31;
        x xVar = this.f5793b;
        int hashCode2 = (this.f5795d.hashCode() + ((this.f5796e.hashCode() + ((this.f5794c.hashCode() + ((hashCode + (xVar != null ? xVar.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
        this.f5797f.getClass();
        return hashCode2;
    }
}
