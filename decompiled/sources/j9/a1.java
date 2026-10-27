package j9;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f7212a = new byte[4096];

    /* renamed from: b, reason: collision with root package name */
    public int f7213b = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f7216e = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f7214c = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7218h = false;

    /* renamed from: f, reason: collision with root package name */
    public int f7217f = 30;

    /* renamed from: d, reason: collision with root package name */
    public long f7215d = -1;
    public int g = -1;

    /* renamed from: i, reason: collision with root package name */
    public String f7219i = null;

    public final int a(byte[] bArr, int i10, int i11) {
        int c10 = c(30, i10, i11, bArr);
        if (c10 != -1) {
            if (this.f7214c == -1) {
                byte[] bArr2 = this.f7212a;
                long a10 = ((k0.a(2, bArr2) << 16) | k0.a(0, bArr2)) & 4294967295L;
                this.f7214c = a10;
                if (a10 == 67324752) {
                    this.f7218h = false;
                    byte[] bArr3 = this.f7212a;
                    this.f7215d = ((k0.a(20, bArr3) << 16) | k0.a(18, bArr3)) & 4294967295L;
                    this.g = k0.a(8, this.f7212a);
                    this.f7216e = k0.a(26, this.f7212a);
                    int a11 = this.f7216e + 30 + k0.a(28, this.f7212a);
                    this.f7217f = a11;
                    int length = this.f7212a.length;
                    if (length < a11) {
                        do {
                            length += length;
                        } while (length < a11);
                        this.f7212a = Arrays.copyOf(this.f7212a, length);
                    }
                } else {
                    this.f7218h = true;
                }
            }
            int c11 = c(this.f7217f, i10 + c10, i11 - c10, bArr);
            if (c11 != -1) {
                int i12 = c10 + c11;
                if (!this.f7218h && this.f7219i == null) {
                    this.f7219i = new String(this.f7212a, 30, this.f7216e);
                }
                return i12;
            }
        }
        return -1;
    }

    public final u b() {
        int i10 = this.f7213b;
        int i11 = this.f7217f;
        if (i10 < i11) {
            return new u(this.f7219i, this.f7215d, this.g, true, this.f7218h, Arrays.copyOf(this.f7212a, i10));
        }
        u uVar = new u(this.f7219i, this.f7215d, this.g, false, this.f7218h, Arrays.copyOf(this.f7212a, i11));
        this.f7213b = 0;
        this.f7216e = -1;
        this.f7214c = -1L;
        this.f7218h = false;
        this.f7217f = 30;
        this.f7215d = -1L;
        this.g = -1;
        this.f7219i = null;
        return uVar;
    }

    public final int c(int i10, int i11, int i12, byte[] bArr) {
        int i13 = this.f7213b;
        if (i13 >= i10) {
            return 0;
        }
        int min = Math.min(i12, i10 - i13);
        System.arraycopy(bArr, i11, this.f7212a, this.f7213b, min);
        int i14 = this.f7213b + min;
        this.f7213b = i14;
        if (i14 < i10) {
            return -1;
        }
        return min;
    }
}
