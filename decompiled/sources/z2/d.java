package z2;

import i1.c0;
import i1.e0;
import i1.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f14058a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14059b;

    public d(int i10, float f10) {
        this.f14058a = f10;
        this.f14059b = i10;
    }

    @Override // i1.e0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f14058a == dVar.f14058a && this.f14059b == dVar.f14059b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f14058a).hashCode() + 527) * 31) + this.f14059b;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.f14058a + ", svcTemporalLayerCount=" + this.f14059b;
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
