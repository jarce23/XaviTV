package e4;

import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Comparable {

    /* renamed from: o, reason: collision with root package name */
    public final int f4565o;

    /* renamed from: p, reason: collision with root package name */
    public final int f4566p;

    /* renamed from: q, reason: collision with root package name */
    public final String f4567q;

    /* renamed from: r, reason: collision with root package name */
    public final String f4568r;

    public c(String str, String str2, int i10, int i11) {
        this.f4565o = i10;
        this.f4566p = i11;
        this.f4567q = str;
        this.f4568r = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c cVar = (c) obj;
        h.e("other", cVar);
        int i10 = this.f4565o - cVar.f4565o;
        return i10 == 0 ? this.f4566p - cVar.f4566p : i10;
    }
}
