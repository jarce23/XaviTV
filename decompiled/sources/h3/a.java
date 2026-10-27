package h3;

import java.util.List;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f5521a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5522b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5523c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5524d;

    public a(long j10, long j11, List list) {
        this.f5521a = g0.n(list);
        this.f5522b = j10;
        this.f5523c = j11;
        long j12 = -9223372036854775807L;
        if (j10 != -9223372036854775807L && j11 != -9223372036854775807L) {
            j12 = j10 + j11;
        }
        this.f5524d = j12;
    }
}
