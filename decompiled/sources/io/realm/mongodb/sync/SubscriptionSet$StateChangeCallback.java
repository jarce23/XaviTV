package io.realm.mongodb.sync;

import io.realm.internal.Keep;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Keep
/* loaded from: classes.dex */
public interface SubscriptionSet$StateChangeCallback {
    void onError(Throwable th);

    void onStateChange(SubscriptionSet subscriptionSet);
}
