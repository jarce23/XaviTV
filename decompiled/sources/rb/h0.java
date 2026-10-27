package rb;

import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 extends ma.d implements RandomAccess {

    /* renamed from: o, reason: collision with root package name */
    public final o[] f11011o;

    /* renamed from: p, reason: collision with root package name */
    public final int[] f11012p;

    public h0(o[] oVarArr, int[] iArr) {
        this.f11011o = oVarArr;
        this.f11012p = iArr;
    }

    @Override // ma.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof o) {
            return super.contains((o) obj);
        }
        return false;
    }

    @Override // ma.a
    public final int f() {
        return this.f11011o.length;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        return this.f11011o[i10];
    }

    @Override // ma.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof o) {
            return super.indexOf((o) obj);
        }
        return -1;
    }

    @Override // ma.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof o) {
            return super.lastIndexOf((o) obj);
        }
        return -1;
    }
}
