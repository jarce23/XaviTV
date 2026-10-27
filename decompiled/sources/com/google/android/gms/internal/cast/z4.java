package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class z4 implements Cloneable {

    /* renamed from: o, reason: collision with root package name */
    public final a5 f3640o;

    /* renamed from: p, reason: collision with root package name */
    public a5 f3641p;

    public z4(a5 a5Var) {
        this.f3640o = a5Var;
        if (a5Var.g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f3641p = (a5) a5Var.h(4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        if (r3 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.cast.a5 a() {
        /*
            r5 = this;
            com.google.android.gms.internal.cast.a5 r0 = r5.b()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.h(r1, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L13
            goto L2d
        L13:
            if (r3 == 0) goto L2e
            com.google.android.gms.internal.cast.a6 r3 = com.google.android.gms.internal.cast.a6.f3253c
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.cast.d6 r3 = r3.a(r4)
            boolean r3 = r3.e(r0)
            if (r1 == r3) goto L26
            goto L27
        L26:
            r2 = r0
        L27:
            r1 = 2
            r0.h(r1, r2)
            if (r3 == 0) goto L2e
        L2d:
            return r0
        L2e:
            a6.m0 r0 = new a6.m0
            java.lang.String r1 = "Message was missing required fields.  (Lite runtime could not determine which fields were missing)."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.z4.a():com.google.android.gms.internal.cast.a5");
    }

    public final a5 b() {
        if (!this.f3641p.g()) {
            return this.f3641p;
        }
        a5 a5Var = this.f3641p;
        a5Var.getClass();
        a6.f3253c.a(a5Var.getClass()).d(a5Var);
        a5Var.d();
        return this.f3641p;
    }

    public final void c() {
        if (this.f3641p.g()) {
            return;
        }
        a5 a5Var = (a5) this.f3640o.h(4, null);
        a6.f3253c.a(a5Var.getClass()).g(a5Var, this.f3641p);
        this.f3641p = a5Var;
    }

    public final Object clone() {
        z4 z4Var = (z4) this.f3640o.h(5, null);
        z4Var.f3641p = b();
        return z4Var;
    }
}
