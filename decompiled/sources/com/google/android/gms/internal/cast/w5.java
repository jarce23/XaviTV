package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w5 implements d6 {

    /* renamed from: a, reason: collision with root package name */
    public final o4 f3557a;

    /* renamed from: b, reason: collision with root package name */
    public final h6 f3558b;

    /* renamed from: c, reason: collision with root package name */
    public final v4 f3559c;

    public w5(h6 h6Var, v4 v4Var, o4 o4Var) {
        this.f3558b = h6Var;
        this.f3559c = v4Var;
        this.f3557a = o4Var;
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final int a(a5 a5Var) {
        this.f3558b.getClass();
        a5Var.zzc.getClass();
        return 506991;
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final boolean b(a5 a5Var, a5 a5Var2) {
        this.f3558b.getClass();
        return a5Var.zzc.equals(a5Var2.zzc);
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final void c(Object obj, p5 p5Var) {
        this.f3559c.getClass();
        r.a.j(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final void d(Object obj) {
        this.f3558b.getClass();
        g6 g6Var = ((a5) obj).zzc;
        if (g6Var.f3318d) {
            g6Var.f3318d = false;
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final boolean e(Object obj) {
        this.f3559c.getClass();
        r.a.j(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final int f(o4 o4Var) {
        this.f3558b.getClass();
        g6 g6Var = ((a5) o4Var).zzc;
        int i10 = g6Var.f3317c;
        if (i10 != -1) {
            return i10;
        }
        g6Var.f3317c = 0;
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final void g(Object obj, Object obj2) {
        e6.o(this.f3558b, obj, obj2);
    }

    @Override // com.google.android.gms.internal.cast.d6
    public final a5 h() {
        o4 o4Var = this.f3557a;
        return o4Var instanceof a5 ? (a5) ((a5) o4Var).h(4, null) : ((z4) ((a5) o4Var).h(5, null)).b();
    }
}
