package oa;

import java.util.Comparator;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: p, reason: collision with root package name */
    public static final a f9700p = new a(0);

    /* renamed from: q, reason: collision with root package name */
    public static final a f9701q = new a(1);

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9702o;

    public /* synthetic */ a(int i10) {
        this.f9702o = i10;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9702o) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                h.e("a", comparable);
                h.e("b", comparable2);
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                h.e("a", comparable3);
                h.e("b", comparable4);
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f9702o) {
            case 0:
                return f9701q;
            default:
                return f9700p;
        }
    }
}
