package m0;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class n1 {

    /* renamed from: b, reason: collision with root package name */
    public static final q1 f8696b;

    /* renamed from: a, reason: collision with root package name */
    public final q1 f8697a;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f8696b = (i10 >= 34 ? new d1() : i10 >= 31 ? new c1() : i10 >= 30 ? new b1() : i10 >= 29 ? new a1() : new y0()).b().f8706a.a().f8706a.b().f8706a.c();
    }

    public n1(q1 q1Var) {
        this.f8697a = q1Var;
    }

    public q1 a() {
        return this.f8697a;
    }

    public q1 b() {
        return this.f8697a;
    }

    public q1 c() {
        return this.f8697a;
    }

    public h e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return n() == n1Var.n() && m() == n1Var.m() && Objects.equals(j(), n1Var.j()) && Objects.equals(h(), n1Var.h()) && Objects.equals(e(), n1Var.e());
    }

    public e0.c f(int i10) {
        return e0.c.f4384e;
    }

    public e0.c g() {
        return j();
    }

    public e0.c h() {
        return e0.c.f4384e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public e0.c i() {
        return j();
    }

    public e0.c j() {
        return e0.c.f4384e;
    }

    public e0.c k() {
        return j();
    }

    public q1 l(int i10, int i11, int i12, int i13) {
        return f8696b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void d(View view) {
    }

    public void o(e0.c[] cVarArr) {
    }

    public void p(q1 q1Var) {
    }

    public void q(e0.c cVar) {
    }

    public void r(int i10) {
    }
}
