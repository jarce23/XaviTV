package w3;

import android.os.Bundle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends m implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f12974a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12975b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12976c;

    /* renamed from: d, reason: collision with root package name */
    public int f12977d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f12978e;

    /* renamed from: f, reason: collision with root package name */
    public j0 f12979f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o0 f12980h;

    public n0(o0 o0Var, String str, String str2) {
        this.f12980h = o0Var;
        this.f12974a = str;
        this.f12975b = str2;
    }

    @Override // w3.k0
    public final int a() {
        return this.g;
    }

    @Override // w3.k0
    public final void b() {
        j0 j0Var = this.f12979f;
        if (j0Var != null) {
            int i10 = this.g;
            int i11 = j0Var.f12943d;
            j0Var.f12943d = i11 + 1;
            j0Var.b(4, i11, i10, null, null);
            this.f12979f = null;
            this.g = 0;
        }
    }

    @Override // w3.k0
    public final void c(j0 j0Var) {
        this.f12979f = j0Var;
        int i10 = j0Var.f12944e;
        j0Var.f12944e = i10 + 1;
        Bundle bundle = new Bundle();
        bundle.putString("routeId", this.f12974a);
        bundle.putString("routeGroupId", this.f12975b);
        int i11 = j0Var.f12943d;
        j0Var.f12943d = i11 + 1;
        j0Var.b(3, i11, i10, null, bundle);
        this.g = i10;
        if (this.f12976c) {
            j0Var.a(i10);
            int i12 = this.f12977d;
            if (i12 >= 0) {
                j0Var.c(this.g, i12);
                this.f12977d = -1;
            }
            int i13 = this.f12978e;
            if (i13 != 0) {
                j0Var.d(this.g, i13);
                this.f12978e = 0;
            }
        }
    }

    @Override // w3.m
    public final void d() {
        o0 o0Var = this.f12980h;
        o0Var.f12987k.remove(this);
        b();
        o0Var.m();
    }

    @Override // w3.m
    public final void e() {
        this.f12976c = true;
        j0 j0Var = this.f12979f;
        if (j0Var != null) {
            j0Var.a(this.g);
        }
    }

    @Override // w3.m
    public final void f(int i10) {
        j0 j0Var = this.f12979f;
        if (j0Var != null) {
            j0Var.c(this.g, i10);
        } else {
            this.f12977d = i10;
            this.f12978e = 0;
        }
    }

    @Override // w3.m
    public final void g() {
        h(0);
    }

    @Override // w3.m
    public final void h(int i10) {
        this.f12976c = false;
        j0 j0Var = this.f12979f;
        if (j0Var != null) {
            int i11 = this.g;
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i10);
            int i12 = j0Var.f12943d;
            j0Var.f12943d = i12 + 1;
            j0Var.b(6, i12, i11, null, bundle);
        }
    }

    @Override // w3.m
    public final void i(int i10) {
        j0 j0Var = this.f12979f;
        if (j0Var != null) {
            j0Var.d(this.g, i10);
        } else {
            this.f12978e += i10;
        }
    }
}
