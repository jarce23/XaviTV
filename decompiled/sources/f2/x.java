package f2;

import i1.b1;
import java.util.Objects;
import s1.d1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f4957a;

    /* renamed from: b, reason: collision with root package name */
    public final d1[] f4958b;

    /* renamed from: c, reason: collision with root package name */
    public final t[] f4959c;

    /* renamed from: d, reason: collision with root package name */
    public final b1 f4960d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4961e;

    public x(d1[] d1VarArr, t[] tVarArr, b1 b1Var, Object obj) {
        l1.d.b(d1VarArr.length == tVarArr.length);
        this.f4958b = d1VarArr;
        this.f4959c = (t[]) tVarArr.clone();
        this.f4960d = b1Var;
        this.f4961e = obj;
        this.f4957a = d1VarArr.length;
    }

    public final boolean a(x xVar, int i10) {
        return xVar != null && Objects.equals(this.f4958b[i10], xVar.f4958b[i10]) && Objects.equals(this.f4959c[i10], xVar.f4959c[i10]);
    }

    public final boolean b(int i10) {
        return this.f4958b[i10] != null;
    }
}
