package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o5 implements s5 {

    /* renamed from: a, reason: collision with root package name */
    public final s5[] f3411a;

    public o5(s5... s5VarArr) {
        this.f3411a = s5VarArr;
    }

    @Override // com.google.android.gms.internal.cast.s5
    public final c6 a(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            s5 s5Var = this.f3411a[i10];
            if (s5Var.b(cls)) {
                return s5Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.cast.s5
    public final boolean b(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (this.f3411a[i10].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
