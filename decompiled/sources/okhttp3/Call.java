package okhttp3;

import rb.v0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface Call extends Cloneable {

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    /* renamed from: clone */
    Call mo148clone();

    void enqueue(Callback callback);

    Response execute();

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    <T> T tag(eb.b bVar);

    <T> T tag(eb.b bVar, ya.a aVar);

    <T> T tag(Class<? extends T> cls);

    <T> T tag(Class<T> cls, ya.a aVar);

    v0 timeout();
}
