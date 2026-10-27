package c2;

import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements l1.h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ j0 f2593o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u f2594p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ z f2595q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ IOException f2596r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ boolean f2597s;

    public /* synthetic */ h0(j0 j0Var, u uVar, z zVar, IOException iOException, boolean z10) {
        this.f2593o = j0Var;
        this.f2594p = uVar;
        this.f2595q = zVar;
        this.f2596r = iOException;
        this.f2597s = z10;
    }

    @Override // l1.h
    public final void accept(Object obj) {
        k0 k0Var = (k0) obj;
        j0 j0Var = this.f2593o;
        k0Var.p(j0Var.f2621a, j0Var.f2622b, this.f2594p, this.f2595q, this.f2596r, this.f2597s);
    }
}
