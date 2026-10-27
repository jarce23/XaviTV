package s0;

import android.graphics.Rect;
import j9.w1;
import java.util.Comparator;
import n0.g;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Comparator {

    /* renamed from: o, reason: collision with root package name */
    public final Rect f11155o = new Rect();

    /* renamed from: p, reason: collision with root package name */
    public final Rect f11156p = new Rect();

    /* renamed from: q, reason: collision with root package name */
    public final boolean f11157q;

    /* renamed from: r, reason: collision with root package name */
    public final w1 f11158r;

    public c(boolean z10, w1 w1Var) {
        this.f11157q = z10;
        this.f11158r = w1Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f11158r.getClass();
        Rect rect = this.f11155o;
        ((g) obj).f(rect);
        Rect rect2 = this.f11156p;
        ((g) obj2).f(rect2);
        int i10 = rect.top;
        int i11 = rect2.top;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        int i12 = rect.left;
        int i13 = rect2.left;
        boolean z10 = this.f11157q;
        if (i12 < i13) {
            return z10 ? 1 : -1;
        }
        if (i12 > i13) {
            return z10 ? -1 : 1;
        }
        int i14 = rect.bottom;
        int i15 = rect2.bottom;
        if (i14 < i15) {
            return -1;
        }
        if (i14 > i15) {
            return 1;
        }
        int i16 = rect.right;
        int i17 = rect2.right;
        if (i16 < i17) {
            return z10 ? 1 : -1;
        }
        if (i16 > i17) {
            return z10 ? -1 : 1;
        }
        return 0;
    }
}
