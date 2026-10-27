package t5;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final i6.f f11962a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f11963b;

    public m(i6.f fVar, Executor executor) {
        this.f11962a = fVar;
        this.f11963b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f11962a.equals(((m) obj).f11962a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11962a.hashCode();
    }
}
