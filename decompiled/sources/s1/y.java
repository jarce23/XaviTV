package s1;

import android.media.MediaFormat;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y implements i2.y, j2.a, a1 {

    /* renamed from: o, reason: collision with root package name */
    public i2.y f11488o;

    /* renamed from: p, reason: collision with root package name */
    public j2.a f11489p;

    /* renamed from: q, reason: collision with root package name */
    public i2.y f11490q;

    /* renamed from: r, reason: collision with root package name */
    public j2.a f11491r;

    @Override // j2.a
    public final void a(long j10, float[] fArr) {
        j2.a aVar = this.f11491r;
        if (aVar != null) {
            aVar.a(j10, fArr);
        }
        j2.a aVar2 = this.f11489p;
        if (aVar2 != null) {
            aVar2.a(j10, fArr);
        }
    }

    @Override // j2.a
    public final void b() {
        j2.a aVar = this.f11491r;
        if (aVar != null) {
            aVar.b();
        }
        j2.a aVar2 = this.f11489p;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // s1.a1
    public final void c(int i10, Object obj) {
        if (i10 == 7) {
            this.f11488o = (i2.y) obj;
            return;
        }
        if (i10 == 8) {
            this.f11489p = (j2.a) obj;
            return;
        }
        if (i10 != 10000) {
            return;
        }
        j2.k kVar = (j2.k) obj;
        if (kVar == null) {
            this.f11490q = null;
            this.f11491r = null;
        } else {
            this.f11490q = kVar.getVideoFrameMetadataListener();
            this.f11491r = kVar.getCameraMotionListener();
        }
    }

    @Override // i2.y
    public final void d(long j10, long j11, i1.p pVar, MediaFormat mediaFormat) {
        long j12;
        long j13;
        i1.p pVar2;
        MediaFormat mediaFormat2;
        i2.y yVar = this.f11490q;
        if (yVar != null) {
            yVar.d(j10, j11, pVar, mediaFormat);
            mediaFormat2 = mediaFormat;
            pVar2 = pVar;
            j13 = j11;
            j12 = j10;
        } else {
            j12 = j10;
            j13 = j11;
            pVar2 = pVar;
            mediaFormat2 = mediaFormat;
        }
        i2.y yVar2 = this.f11488o;
        if (yVar2 != null) {
            yVar2.d(j12, j13, pVar2, mediaFormat2);
        }
    }
}
