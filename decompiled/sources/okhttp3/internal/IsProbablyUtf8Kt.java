package okhttp3.internal;

import java.io.EOFException;
import rb.l;
import rb.m0;
import rb.n;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class IsProbablyUtf8Kt {
    public static final boolean isProbablyUtf8(n nVar, long j10) {
        h.e("<this>", nVar);
        try {
            m0 peek = nVar.peek();
            for (long j11 = 0; j11 < j10; j11++) {
                if (peek.t()) {
                    return true;
                }
                peek.D(1L);
                l lVar = peek.f11040p;
                byte x6 = lVar.x(0L);
                if ((x6 & 224) == 192) {
                    peek.D(2L);
                } else if ((x6 & 240) == 224) {
                    peek.D(3L);
                } else if ((x6 & 248) == 240) {
                    peek.D(4L);
                }
                int T = lVar.T();
                if (Character.isISOControl(T) && !Character.isWhitespace(T)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean isProbablyUtf8$default(n nVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return isProbablyUtf8(nVar, j10);
    }
}
