package o9;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 extends v0 implements Serializable {

    /* renamed from: p, reason: collision with root package name */
    public static final u0 f9682p = new u0(0);

    /* renamed from: q, reason: collision with root package name */
    public static final u0 f9683q = new u0(1);

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9684o;

    public /* synthetic */ u0(int i10) {
        this.f9684o = i10;
    }

    @Override // o9.v0
    public final v0 a() {
        switch (this.f9684o) {
            case 0:
                return f9683q;
            default:
                return f9682p;
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9684o) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                comparable3.getClass();
                if (comparable3 == comparable4) {
                    return 0;
                }
                return comparable4.compareTo(comparable3);
        }
    }

    public final String toString() {
        switch (this.f9684o) {
            case 0:
                return "Ordering.natural()";
            default:
                return "Ordering.natural().reverse()";
        }
    }
}
