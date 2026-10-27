package za;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i implements f, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final int f14173o;

    public i(int i10) {
        this.f14173o = i10;
    }

    @Override // za.f
    public final int a() {
        return this.f14173o;
    }

    public final String toString() {
        n.f14178a.getClass();
        String a10 = o.a(this);
        h.d("renderLambdaToString(...)", a10);
        return a10;
    }
}
