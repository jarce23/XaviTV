package s1;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: b, reason: collision with root package name */
    public static final e1 f11279b;

    /* renamed from: a, reason: collision with root package name */
    public final o9.j0 f11280a;

    static {
        p4.p pVar = new p4.p(4, false);
        pVar.f9953p = o9.j0.m(2, 1, 5);
        f11279b = new e1(pVar);
    }

    public e1(p4.p pVar) {
        this.f11280a = (o9.j0) pVar.f9953p;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e1) && this.f11280a.equals(((e1) obj).f11280a);
    }

    public final int hashCode() {
        Boolean bool = Boolean.TRUE;
        return Objects.hash(this.f11280a, null, null, bool, bool, bool, bool);
    }
}
