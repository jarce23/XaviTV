package s1;

import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f11264a;

    /* renamed from: b, reason: collision with root package name */
    public int f11265b;

    /* renamed from: c, reason: collision with root package name */
    public int f11266c;

    /* renamed from: d, reason: collision with root package name */
    public int f11267d;

    /* renamed from: e, reason: collision with root package name */
    public int f11268e;

    /* renamed from: f, reason: collision with root package name */
    public int f11269f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f11270h;

    /* renamed from: i, reason: collision with root package name */
    public int f11271i;

    /* renamed from: j, reason: collision with root package name */
    public int f11272j;

    /* renamed from: k, reason: collision with root package name */
    public long f11273k;

    /* renamed from: l, reason: collision with root package name */
    public int f11274l;

    public final String toString() {
        int i10 = this.f11264a;
        int i11 = this.f11265b;
        int i12 = this.f11266c;
        int i13 = this.f11267d;
        int i14 = this.f11268e;
        int i15 = this.f11269f;
        int i16 = this.g;
        int i17 = this.f11270h;
        int i18 = this.f11271i;
        int i19 = this.f11272j;
        long j10 = this.f11273k;
        int i20 = this.f11274l;
        int i21 = l1.a0.f8067a;
        Locale locale = Locale.US;
        StringBuilder g = r.a.g("DecoderCounters {\n decoderInits=", i10, ",\n decoderReleases=", i11, "\n queuedInputBuffers=");
        g.append(i12);
        g.append("\n skippedInputBuffers=");
        g.append(i13);
        g.append("\n renderedOutputBuffers=");
        g.append(i14);
        g.append("\n skippedOutputBuffers=");
        g.append(i15);
        g.append("\n droppedBuffers=");
        g.append(i16);
        g.append("\n droppedInputBuffers=");
        g.append(i17);
        g.append("\n maxConsecutiveDroppedBuffers=");
        g.append(i18);
        g.append("\n droppedToKeyframeEvents=");
        g.append(i19);
        g.append("\n totalVideoFrameProcessingOffsetUs=");
        g.append(j10);
        g.append("\n videoFrameProcessingOffsetCount=");
        g.append(i20);
        g.append("\n}");
        return g.toString();
    }
}
