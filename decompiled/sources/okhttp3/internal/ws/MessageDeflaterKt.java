package okhttp3.internal.ws;

import j9.w1;
import rb.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class MessageDeflaterKt {
    private static final o EMPTY_DEFLATE_BLOCK;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    static {
        o oVar = o.f11048r;
        EMPTY_DEFLATE_BLOCK = w1.E("000000ffff");
    }
}
