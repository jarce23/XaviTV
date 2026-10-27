package w1;

import android.os.SystemClock;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends f2.d {
    public int g;

    @Override // f2.t
    public final void i(long j10, long j11, long j12, List list, d2.c[] cVarArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (b(this.g, elapsedRealtime)) {
            for (int i10 = this.f4884b - 1; i10 >= 0; i10--) {
                if (!b(i10, elapsedRealtime)) {
                    this.g = i10;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    @Override // f2.t
    public final int m() {
        return 0;
    }

    @Override // f2.t
    public final int n() {
        return this.g;
    }

    @Override // f2.t
    public final Object q() {
        return null;
    }
}
