package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l5 extends m5 {
    @Override // com.google.android.gms.internal.cast.m5
    public final void a(long j10, Object obj) {
        p4 p4Var = (p4) ((f5) p6.h(j10, obj));
        if (p4Var.f3423o) {
            p4Var.f3423o = false;
        }
    }

    @Override // com.google.android.gms.internal.cast.m5
    public final void b(long j10, Object obj, Object obj2) {
        f5 f5Var = (f5) p6.h(j10, obj);
        f5 f5Var2 = (f5) p6.h(j10, obj2);
        int size = f5Var.size();
        int size2 = f5Var2.size();
        if (size > 0 && size2 > 0) {
            if (!((p4) f5Var).f3423o) {
                f5Var = f5Var.c(size2 + size);
            }
            f5Var.addAll(f5Var2);
        }
        if (size > 0) {
            f5Var2 = f5Var;
        }
        p6.l(j10, obj, f5Var2);
    }
}
