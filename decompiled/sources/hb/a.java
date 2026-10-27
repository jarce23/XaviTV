package hb;

import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements Comparable {

    /* renamed from: o, reason: collision with root package name */
    public static final long f5766o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f5767p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f5768q = 0;

    static {
        int i10 = b.f5769a;
        f5766o = Long.MAX_VALUE;
        f5767p = -9223372036854775805L;
    }

    public static final long a(long j10, c cVar) {
        h.e("unit", cVar);
        if (j10 == f5766o) {
            return Long.MAX_VALUE;
        }
        if (j10 == f5767p) {
            return Long.MIN_VALUE;
        }
        long j11 = j10 >> 1;
        c cVar2 = (((int) j10) & 1) == 0 ? c.f5770p : c.f5771q;
        h.e("sourceUnit", cVar2);
        return cVar.f5774o.convert(j11, cVar2.f5774o);
    }
}
