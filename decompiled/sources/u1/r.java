package u1;

import android.media.AudioTrack;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final q f12241a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12242b;

    /* renamed from: c, reason: collision with root package name */
    public final p4.p f12243c;

    /* renamed from: d, reason: collision with root package name */
    public int f12244d;

    /* renamed from: e, reason: collision with root package name */
    public long f12245e;

    /* renamed from: f, reason: collision with root package name */
    public long f12246f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public long f12247h;

    /* renamed from: i, reason: collision with root package name */
    public long f12248i;

    public r(AudioTrack audioTrack, p4.p pVar) {
        this.f12241a = new q(audioTrack);
        this.f12242b = audioTrack.getSampleRate();
        this.f12243c = pVar;
        a(0);
    }

    public final void a(int i10) {
        this.f12244d = i10;
        if (i10 == 0) {
            this.g = 0L;
            this.f12247h = -1L;
            this.f12248i = -9223372036854775807L;
            this.f12245e = System.nanoTime() / 1000;
            this.f12246f = 10000L;
            return;
        }
        if (i10 == 1) {
            this.f12246f = 10000L;
            return;
        }
        if (i10 == 2 || i10 == 3) {
            this.f12246f = 10000000L;
        } else {
            if (i10 != 4) {
                throw new IllegalStateException();
            }
            this.f12246f = 500000L;
        }
    }
}
