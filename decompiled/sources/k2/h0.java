package k2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7734a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    public boolean f7735b;

    /* renamed from: c, reason: collision with root package name */
    public int f7736c;

    /* renamed from: d, reason: collision with root package name */
    public long f7737d;

    /* renamed from: e, reason: collision with root package name */
    public int f7738e;

    /* renamed from: f, reason: collision with root package name */
    public int f7739f;
    public int g;

    public final void a(g0 g0Var, f0 f0Var) {
        if (this.f7736c > 0) {
            g0Var.e(this.f7737d, this.f7738e, this.f7739f, this.g, f0Var);
            this.f7736c = 0;
        }
    }

    public final void b(g0 g0Var, long j10, int i10, int i11, int i12, f0 f0Var) {
        l1.d.f("TrueHD chunk samples must be contiguous in the sample queue.", this.g <= i11 + i12);
        if (this.f7735b) {
            int i13 = this.f7736c;
            int i14 = i13 + 1;
            this.f7736c = i14;
            if (i13 == 0) {
                this.f7737d = j10;
                this.f7738e = i10;
                this.f7739f = 0;
            }
            this.f7739f += i11;
            this.g = i12;
            if (i14 >= 16) {
                a(g0Var, f0Var);
            }
        }
    }

    public final void c(o oVar) {
        if (this.f7735b) {
            return;
        }
        byte[] bArr = this.f7734a;
        oVar.o(bArr, 0, 10);
        oVar.h();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                r2 = 40 << ((bArr[((b2 & 255) == 187 ? 1 : 0) != 0 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        if (r2 == 0) {
            return;
        }
        this.f7735b = true;
    }
}
