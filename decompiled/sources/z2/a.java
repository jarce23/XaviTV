package z2;

import i1.c0;
import i1.e0;
import i1.p;
import i7.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f14049a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14050b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14051c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14052d;

    /* renamed from: e, reason: collision with root package name */
    public final long f14053e;

    public a(long j10, long j11, long j12, long j13, long j14) {
        this.f14049a = j10;
        this.f14050b = j11;
        this.f14051c = j12;
        this.f14052d = j13;
        this.f14053e = j14;
    }

    @Override // i1.e0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f14049a == aVar.f14049a && this.f14050b == aVar.f14050b && this.f14051c == aVar.f14051c && this.f14052d == aVar.f14052d && this.f14053e == aVar.f14053e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return e.q(this.f14053e) + ((e.q(this.f14052d) + ((e.q(this.f14051c) + ((e.q(this.f14050b) + ((e.q(this.f14049a) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f14049a + ", photoSize=" + this.f14050b + ", photoPresentationTimestampUs=" + this.f14051c + ", videoStartPosition=" + this.f14052d + ", videoSize=" + this.f14053e;
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
