package a3;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public final long f24a;

    /* renamed from: b, reason: collision with root package name */
    public final long f25b;

    /* renamed from: c, reason: collision with root package name */
    public final List f26c;

    public d(long j10, long j11, List list) {
        this.f24a = j10;
        this.f25b = j11;
        this.f26c = Collections.unmodifiableList(list);
    }

    @Override // a3.b
    public final String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f24a + ", programSplicePlaybackPositionUs= " + this.f25b + " }";
    }
}
