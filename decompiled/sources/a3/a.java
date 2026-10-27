package a3;

import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20c;

    public a(int i10, long j10, long j11) {
        this.f18a = i10;
        switch (i10) {
            case 1:
                this.f19b = j10;
                this.f20c = j11;
                break;
            default:
                this.f19b = j11;
                this.f20c = j10;
                break;
        }
    }

    public static long d(long j10, t tVar) {
        long w10 = tVar.w();
        if ((128 & w10) != 0) {
            return 8589934591L & ((((w10 & 1) << 32) | tVar.y()) + j10);
        }
        return -9223372036854775807L;
    }

    @Override // a3.b
    public final String toString() {
        switch (this.f18a) {
            case 0:
                return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.f19b + ", identifier= " + this.f20c + " }";
            default:
                return "SCTE-35 TimeSignalCommand { ptsTime=" + this.f19b + ", playbackPositionUs= " + this.f20c + " }";
        }
    }
}
