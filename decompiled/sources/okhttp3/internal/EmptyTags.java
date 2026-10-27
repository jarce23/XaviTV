package okhttp3.internal;

import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class EmptyTags extends Tags {
    public static final EmptyTags INSTANCE = new EmptyTags();

    private EmptyTags() {
        super(null);
    }

    @Override // okhttp3.internal.Tags
    public <T> T get(eb.b bVar) {
        h.e("key", bVar);
        return null;
    }

    @Override // okhttp3.internal.Tags
    public <T> Tags plus(eb.b bVar, T t3) {
        h.e("key", bVar);
        return t3 != null ? new LinkedTags(bVar, t3, this) : this;
    }

    public String toString() {
        return "{}";
    }
}
