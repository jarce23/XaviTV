package i1;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: c, reason: collision with root package name */
    public static final String f6049c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f6050d;

    /* renamed from: a, reason: collision with root package name */
    public final u0 f6051a;

    /* renamed from: b, reason: collision with root package name */
    public final o9.g0 f6052b;

    static {
        int i10 = l1.a0.f8067a;
        f6049c = Integer.toString(0, 36);
        f6050d = Integer.toString(1, 36);
    }

    public v0(u0 u0Var, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= u0Var.f6039a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f6051a = u0Var;
        this.f6052b = o9.g0.n(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v0.class == obj.getClass()) {
            v0 v0Var = (v0) obj;
            if (this.f6051a.equals(v0Var.f6051a) && this.f6052b.equals(v0Var.f6052b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f6052b.hashCode() * 31) + this.f6051a.hashCode();
    }
}
