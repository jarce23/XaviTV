package w3;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 extends l implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final String f12959f;
    public String g;

    /* renamed from: h, reason: collision with root package name */
    public String f12960h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12961i;

    /* renamed from: k, reason: collision with root package name */
    public int f12963k;

    /* renamed from: l, reason: collision with root package name */
    public j0 f12964l;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ o0 f12966n;

    /* renamed from: j, reason: collision with root package name */
    public int f12962j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f12965m = -1;

    public m0(o0 o0Var, String str) {
        this.f12966n = o0Var;
        this.f12959f = str;
    }

    @Override // w3.k0
    public final int a() {
        return this.f12965m;
    }

    @Override // w3.k0
    public final void b() {
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            int i10 = this.f12965m;
            int i11 = j0Var.f12943d;
            j0Var.f12943d = i11 + 1;
            j0Var.b(4, i11, i10, null, null);
            this.f12964l = null;
            this.f12965m = 0;
        }
    }

    @Override // w3.k0
    public final void c(j0 j0Var) {
        l0 l0Var = new l0(this);
        this.f12964l = j0Var;
        int i10 = j0Var.f12944e;
        j0Var.f12944e = i10 + 1;
        int i11 = j0Var.f12943d;
        j0Var.f12943d = i11 + 1;
        Bundle bundle = new Bundle();
        bundle.putString("memberRouteId", this.f12959f);
        j0Var.b(11, i11, i10, null, bundle);
        j0Var.f12946h.put(i11, l0Var);
        this.f12965m = i10;
        if (this.f12961i) {
            j0Var.a(i10);
            int i12 = this.f12962j;
            if (i12 >= 0) {
                j0Var.c(this.f12965m, i12);
                this.f12962j = -1;
            }
            int i13 = this.f12963k;
            if (i13 != 0) {
                j0Var.d(this.f12965m, i13);
                this.f12963k = 0;
            }
        }
    }

    @Override // w3.m
    public final void d() {
        o0 o0Var = this.f12966n;
        o0Var.f12987k.remove(this);
        b();
        o0Var.m();
    }

    @Override // w3.m
    public final void e() {
        this.f12961i = true;
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            j0Var.a(this.f12965m);
        }
    }

    @Override // w3.m
    public final void f(int i10) {
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            j0Var.c(this.f12965m, i10);
        } else {
            this.f12962j = i10;
            this.f12963k = 0;
        }
    }

    @Override // w3.m
    public final void g() {
        h(0);
    }

    @Override // w3.m
    public final void h(int i10) {
        this.f12961i = false;
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            int i11 = this.f12965m;
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i10);
            int i12 = j0Var.f12943d;
            j0Var.f12943d = i12 + 1;
            j0Var.b(6, i12, i11, null, bundle);
        }
    }

    @Override // w3.m
    public final void i(int i10) {
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            j0Var.d(this.f12965m, i10);
        } else {
            this.f12963k += i10;
        }
    }

    @Override // w3.l
    public final String j() {
        return this.g;
    }

    @Override // w3.l
    public final String k() {
        return this.f12960h;
    }

    @Override // w3.l
    public final void m(String str) {
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            int i10 = this.f12965m;
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = j0Var.f12943d;
            j0Var.f12943d = i11 + 1;
            j0Var.b(12, i11, i10, null, bundle);
        }
    }

    @Override // w3.l
    public final void n(String str) {
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            int i10 = this.f12965m;
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = j0Var.f12943d;
            j0Var.f12943d = i11 + 1;
            j0Var.b(13, i11, i10, null, bundle);
        }
    }

    @Override // w3.l
    public final void o(List list) {
        j0 j0Var = this.f12964l;
        if (j0Var != null) {
            int i10 = this.f12965m;
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("memberRouteIds", new ArrayList<>(list));
            int i11 = j0Var.f12943d;
            j0Var.f12943d = i11 + 1;
            j0Var.b(14, i11, i10, null, bundle);
        }
    }
}
