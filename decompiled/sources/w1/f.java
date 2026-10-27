package w1;

import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements d2.c {

    /* renamed from: o, reason: collision with root package name */
    public final long f12766o;

    /* renamed from: p, reason: collision with root package name */
    public long f12767p = -1;

    /* renamed from: q, reason: collision with root package name */
    public final List f12768q;

    /* renamed from: r, reason: collision with root package name */
    public final long f12769r;

    public f(long j10, List list) {
        this.f12766o = list.size() - 1;
        this.f12769r = j10;
        this.f12768q = list;
    }

    @Override // d2.c
    public final long a() {
        long j10 = this.f12767p;
        if (j10 < 0 || j10 > this.f12766o) {
            throw new NoSuchElementException();
        }
        x1.j jVar = (x1.j) this.f12768q.get((int) j10);
        return this.f12769r + jVar.f13400s + jVar.f13398q;
    }

    @Override // d2.c
    public final long d() {
        long j10 = this.f12767p;
        if (j10 < 0 || j10 > this.f12766o) {
            throw new NoSuchElementException();
        }
        return this.f12769r + ((x1.j) this.f12768q.get((int) j10)).f13400s;
    }

    @Override // d2.c
    public final boolean next() {
        long j10 = this.f12767p + 1;
        this.f12767p = j10;
        return !(j10 > this.f12766o);
    }
}
