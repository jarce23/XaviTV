package c2;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends s {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f2743e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Object f2744c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2745d;

    public w(i1.t0 t0Var, Object obj, Object obj2) {
        super(t0Var);
        this.f2744c = obj;
        this.f2745d = obj2;
    }

    @Override // c2.s, i1.t0
    public final int b(Object obj) {
        Object obj2;
        if (f2743e.equals(obj) && (obj2 = this.f2745d) != null) {
            obj = obj2;
        }
        return this.f2707b.b(obj);
    }

    @Override // c2.s, i1.t0
    public final i1.r0 f(int i10, i1.r0 r0Var, boolean z10) {
        this.f2707b.f(i10, r0Var, z10);
        if (Objects.equals(r0Var.f6013b, this.f2745d) && z10) {
            r0Var.f6013b = f2743e;
        }
        return r0Var;
    }

    @Override // c2.s, i1.t0
    public final Object l(int i10) {
        Object l10 = this.f2707b.l(i10);
        return Objects.equals(l10, this.f2745d) ? f2743e : l10;
    }

    @Override // c2.s, i1.t0
    public final i1.s0 m(int i10, i1.s0 s0Var, long j10) {
        this.f2707b.m(i10, s0Var, j10);
        if (Objects.equals(s0Var.f6021a, this.f2744c)) {
            s0Var.f6021a = i1.s0.f6019q;
        }
        return s0Var;
    }
}
