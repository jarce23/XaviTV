package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f10563a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10564b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10565c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10566d;

    /* renamed from: e, reason: collision with root package name */
    public int f10567e;

    /* renamed from: f, reason: collision with root package name */
    public int f10568f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public long f10569h;

    public l(g0 g0Var) {
        this.f10563a = g0Var;
    }

    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f10565c) {
            int i12 = this.f10568f;
            int i13 = (i10 + 1) - i12;
            if (i13 >= i11) {
                this.f10568f = (i11 - i10) + i12;
            } else {
                this.f10566d = ((bArr[i13] & 192) >> 6) == 0;
                this.f10565c = false;
            }
        }
    }

    public final void b(int i10, long j10, boolean z10) {
        l1.d.g(this.f10569h != -9223372036854775807L);
        if (this.f10567e == 182 && z10 && this.f10564b) {
            this.f10563a.e(this.f10569h, this.f10566d ? 1 : 0, (int) (j10 - this.g), i10, null);
        }
        if (this.f10567e != 179) {
            this.g = j10;
        }
    }
}
