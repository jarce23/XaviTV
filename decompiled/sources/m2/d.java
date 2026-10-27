package m2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f8839a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8840b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8841c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8842d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8843e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8844f;

    public d(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f8839a = i10;
        this.f8840b = i11;
        this.f8841c = i12;
        this.f8842d = i13;
        this.f8843e = i14;
        this.f8844f = i15;
    }

    @Override // m2.a
    public final int a() {
        return 1752331379;
    }

    public final int b() {
        int i10 = this.f8839a;
        if (i10 == 1935960438) {
            return 2;
        }
        if (i10 == 1935963489) {
            return 1;
        }
        if (i10 == 1937012852) {
            return 3;
        }
        l1.b.q("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(i10));
        return -1;
    }
}
