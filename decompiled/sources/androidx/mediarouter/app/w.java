package androidx.mediarouter.app;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1421a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1422b;

    public w(Object obj) {
        this.f1421a = obj;
        if (obj instanceof String) {
            this.f1422b = 1;
        } else {
            if (!(obj instanceof w3.z)) {
                throw new IllegalArgumentException();
            }
            this.f1422b = 2;
        }
    }
}
