package c3;

import k2.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f2857d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2858a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f2859b;

    /* renamed from: c, reason: collision with root package name */
    public int f2860c;

    public static long a(int i10, boolean z10, byte[] bArr) {
        long j10 = bArr[0] & 255;
        if (z10) {
            j10 &= ~f2857d[i10 - 1];
        }
        for (int i11 = 1; i11 < i10; i11++) {
            j10 = (j10 << 8) | (bArr[i11] & 255);
        }
        return j10;
    }

    public final long b(o oVar, boolean z10, boolean z11, int i10) {
        int i11;
        int i12 = this.f2859b;
        byte[] bArr = this.f2858a;
        if (i12 == 0) {
            if (!oVar.b(bArr, 0, 1, z10)) {
                return -1L;
            }
            int i13 = bArr[0] & 255;
            int i14 = 0;
            while (true) {
                if (i14 >= 8) {
                    i11 = -1;
                    break;
                }
                if ((f2857d[i14] & i13) != 0) {
                    i11 = i14 + 1;
                    break;
                }
                i14++;
            }
            this.f2860c = i11;
            if (i11 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f2859b = 1;
        }
        int i15 = this.f2860c;
        if (i15 > i10) {
            this.f2859b = 0;
            return -2L;
        }
        if (i15 != 1) {
            oVar.readFully(bArr, 1, i15 - 1);
        }
        this.f2859b = 0;
        return a(this.f2860c, z11, bArr);
    }
}
