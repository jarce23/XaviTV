package z1;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends Exception {

    /* renamed from: o, reason: collision with root package name */
    public final String f14011o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f14012p;

    /* renamed from: q, reason: collision with root package name */
    public final p f14013q;

    /* renamed from: r, reason: collision with root package name */
    public final String f14014r;

    public q(i1.p pVar, u uVar, boolean z10, int i10) {
        this("Decoder init failed: [" + i10 + "], " + pVar, uVar, pVar.f5991n, z10, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i10 < 0 ? "neg_" : _UrlKt.FRAGMENT_ENCODE_SET) + Math.abs(i10));
    }

    public q(String str, Throwable th, String str2, boolean z10, p pVar, String str3) {
        super(str, th);
        this.f14011o = str2;
        this.f14012p = z10;
        this.f14013q = pVar;
        this.f14014r = str3;
    }
}
