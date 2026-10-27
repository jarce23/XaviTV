package i2;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public long f6158a;

    /* renamed from: b, reason: collision with root package name */
    public long f6159b;

    /* renamed from: c, reason: collision with root package name */
    public long f6160c;

    /* renamed from: d, reason: collision with root package name */
    public long f6161d;

    /* renamed from: e, reason: collision with root package name */
    public long f6162e;

    /* renamed from: f, reason: collision with root package name */
    public long f6163f;
    public final boolean[] g = new boolean[15];

    /* renamed from: h, reason: collision with root package name */
    public int f6164h;

    public final boolean a() {
        return this.f6161d > 15 && this.f6164h == 0;
    }

    public final void b(long j10) {
        long j11 = this.f6161d;
        if (j11 == 0) {
            this.f6158a = j10;
        } else if (j11 == 1) {
            long j12 = j10 - this.f6158a;
            this.f6159b = j12;
            this.f6163f = j12;
            this.f6162e = 1L;
        } else {
            long j13 = j10 - this.f6160c;
            int i10 = (int) (j11 % 15);
            long abs = Math.abs(j13 - this.f6159b);
            boolean[] zArr = this.g;
            if (abs <= 1000000) {
                this.f6162e++;
                this.f6163f += j13;
                if (zArr[i10]) {
                    zArr[i10] = false;
                    this.f6164h--;
                }
            } else if (!zArr[i10]) {
                zArr[i10] = true;
                this.f6164h++;
            }
        }
        this.f6161d++;
        this.f6160c = j10;
    }

    public final void c() {
        this.f6161d = 0L;
        this.f6162e = 0L;
        this.f6163f = 0L;
        this.f6164h = 0;
        Arrays.fill(this.g, false);
    }
}
