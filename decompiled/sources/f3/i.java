package f3;

import k2.g0;
import k2.p;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    public g0 f4995b;

    /* renamed from: c, reason: collision with root package name */
    public p f4996c;

    /* renamed from: d, reason: collision with root package name */
    public g f4997d;

    /* renamed from: e, reason: collision with root package name */
    public long f4998e;

    /* renamed from: f, reason: collision with root package name */
    public long f4999f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public int f5000h;

    /* renamed from: i, reason: collision with root package name */
    public int f5001i;

    /* renamed from: k, reason: collision with root package name */
    public long f5003k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5004l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5005m;

    /* renamed from: a, reason: collision with root package name */
    public final e f4994a = new e(0);

    /* renamed from: j, reason: collision with root package name */
    public x4.e f5002j = new x4.e(6, false);

    public void a(long j10) {
        this.g = j10;
    }

    public abstract long b(t tVar);

    public abstract boolean c(t tVar, long j10, x4.e eVar);

    public void d(boolean z10) {
        if (z10) {
            this.f5002j = new x4.e(6, false);
            this.f4999f = 0L;
            this.f5000h = 0;
        } else {
            this.f5000h = 1;
        }
        this.f4998e = -1L;
        this.g = 0L;
    }
}
