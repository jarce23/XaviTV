package i3;

import l1.a0;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6374a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f6375b;

    /* renamed from: c, reason: collision with root package name */
    public int f6376c;

    /* renamed from: d, reason: collision with root package name */
    public int f6377d;

    /* renamed from: e, reason: collision with root package name */
    public int f6378e;

    public f() {
        this.f6374a = 2;
        this.f6375b = a0.f8069c;
    }

    public void a() {
        int i10;
        int i11;
        switch (this.f6374a) {
            case 2:
                int i12 = this.f6376c;
                l1.d.g(i12 >= 0 && (i12 < (i10 = this.f6378e) || (i12 == i10 && this.f6377d == 0)));
                break;
            default:
                int i13 = this.f6377d;
                l1.d.g(i13 >= 0 && (i13 < (i11 = this.f6376c) || (i13 == i11 && this.f6378e == 0)));
                break;
        }
    }

    public int b() {
        return ((this.f6378e - this.f6376c) * 8) - this.f6377d;
    }

    public void c() {
        if (this.f6377d == 0) {
            return;
        }
        this.f6377d = 0;
        this.f6376c++;
        a();
    }

    public boolean d(int i10) {
        int i11 = this.f6377d;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        int i14 = (this.f6378e + i10) - (i12 * 8);
        if (i14 > 7) {
            i13++;
            i14 -= 8;
        }
        while (true) {
            i11++;
            if (i11 > i13 || i13 >= this.f6376c) {
                break;
            }
            if (r(i11)) {
                i13++;
                i11 += 2;
            }
        }
        int i15 = this.f6376c;
        if (i13 >= i15) {
            return i13 == i15 && i14 == 0;
        }
        return true;
    }

    public boolean e() {
        int i10 = this.f6377d;
        int i11 = this.f6378e;
        int i12 = 0;
        while (this.f6377d < this.f6376c && !h()) {
            i12++;
        }
        boolean z10 = this.f6377d == this.f6376c;
        this.f6377d = i10;
        this.f6378e = i11;
        return !z10 && d((i12 * 2) + 1);
    }

    public int f() {
        l1.d.g(this.f6377d == 0);
        return this.f6376c;
    }

    public int g() {
        return (this.f6376c * 8) + this.f6377d;
    }

    public boolean h() {
        switch (this.f6374a) {
            case 1:
                boolean z10 = (((this.f6375b[this.f6377d] & 255) >> this.f6378e) & 1) == 1;
                t(1);
                return z10;
            case 2:
                boolean z11 = (this.f6375b[this.f6376c] & (128 >> this.f6377d)) != 0;
                s();
                return z11;
            default:
                boolean z12 = (this.f6375b[this.f6377d] & (128 >> this.f6378e)) != 0;
                s();
                return z12;
        }
    }

    public int i(int i10) {
        switch (this.f6374a) {
            case 1:
                int i11 = this.f6377d;
                int min = Math.min(i10, 8 - this.f6378e);
                byte[] bArr = this.f6375b;
                int i12 = i11 + 1;
                int i13 = ((bArr[i11] & 255) >> this.f6378e) & (255 >> (8 - min));
                while (min < i10) {
                    i13 |= (bArr[i12] & 255) << min;
                    min += 8;
                    i12++;
                }
                int i14 = i13 & ((-1) >>> (32 - i10));
                t(i10);
                return i14;
            case 2:
                if (i10 == 0) {
                    return 0;
                }
                this.f6377d += i10;
                int i15 = 0;
                while (true) {
                    int i16 = this.f6377d;
                    if (i16 <= 8) {
                        byte[] bArr2 = this.f6375b;
                        int i17 = this.f6376c;
                        int i18 = ((-1) >>> (32 - i10)) & (i15 | ((bArr2[i17] & 255) >> (8 - i16)));
                        if (i16 == 8) {
                            this.f6377d = 0;
                            this.f6376c = i17 + 1;
                        }
                        a();
                        return i18;
                    }
                    int i19 = i16 - 8;
                    this.f6377d = i19;
                    byte[] bArr3 = this.f6375b;
                    int i20 = this.f6376c;
                    this.f6376c = i20 + 1;
                    i15 |= (bArr3[i20] & 255) << i19;
                }
            default:
                this.f6378e += i10;
                int i21 = 0;
                while (true) {
                    int i22 = this.f6378e;
                    if (i22 <= 8) {
                        byte[] bArr4 = this.f6375b;
                        int i23 = this.f6377d;
                        int i24 = ((-1) >>> (32 - i10)) & (i21 | ((bArr4[i23] & 255) >> (8 - i22)));
                        if (i22 == 8) {
                            this.f6378e = 0;
                            this.f6377d = i23 + (r(i23 + 1) ? 2 : 1);
                        }
                        a();
                        return i24;
                    }
                    int i25 = i22 - 8;
                    this.f6378e = i25;
                    byte[] bArr5 = this.f6375b;
                    int i26 = this.f6377d;
                    i21 |= (bArr5[i26] & 255) << i25;
                    if (!r(i26 + 1)) {
                        r3 = 1;
                    }
                    this.f6377d = i26 + r3;
                }
        }
    }

    public void j(int i10, byte[] bArr) {
        int i11 = i10 >> 3;
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArr2 = this.f6375b;
            int i13 = this.f6376c;
            int i14 = i13 + 1;
            this.f6376c = i14;
            byte b2 = bArr2[i13];
            int i15 = this.f6377d;
            byte b10 = (byte) (b2 << i15);
            bArr[i12] = b10;
            bArr[i12] = (byte) (((255 & bArr2[i14]) >> (8 - i15)) | b10);
        }
        int i16 = i10 & 7;
        if (i16 == 0) {
            return;
        }
        byte b11 = (byte) (bArr[i11] & (255 >> i16));
        bArr[i11] = b11;
        int i17 = this.f6377d;
        if (i17 + i16 > 8) {
            byte[] bArr3 = this.f6375b;
            int i18 = this.f6376c;
            this.f6376c = i18 + 1;
            bArr[i11] = (byte) (b11 | ((bArr3[i18] & 255) << i17));
            this.f6377d = i17 - 8;
        }
        int i19 = this.f6377d + i16;
        this.f6377d = i19;
        byte[] bArr4 = this.f6375b;
        int i20 = this.f6376c;
        bArr[i11] = (byte) (((byte) (((255 & bArr4[i20]) >> (8 - i19)) << (8 - i16))) | bArr[i11]);
        if (i19 == 8) {
            this.f6377d = 0;
            this.f6376c = i20 + 1;
        }
        a();
    }

    public long k(int i10) {
        if (i10 <= 32) {
            int i11 = i(i10);
            int i12 = a0.f8067a;
            return 4294967295L & i11;
        }
        int i13 = i(i10 - 32);
        int i14 = i(32);
        int i15 = a0.f8067a;
        return (4294967295L & i14) | ((i13 & 4294967295L) << 32);
    }

    public void l(int i10, byte[] bArr) {
        l1.d.g(this.f6377d == 0);
        System.arraycopy(this.f6375b, this.f6376c, bArr, 0, i10);
        this.f6376c += i10;
        a();
    }

    public int m() {
        int i10 = 0;
        while (!h()) {
            i10++;
        }
        return ((1 << i10) - 1) + (i10 > 0 ? i(i10) : 0);
    }

    public int n() {
        int m10 = m();
        return ((m10 + 1) / 2) * (m10 % 2 == 0 ? -1 : 1);
    }

    public void o(int i10, byte[] bArr) {
        this.f6375b = bArr;
        this.f6376c = 0;
        this.f6377d = 0;
        this.f6378e = i10;
    }

    public void p(t tVar) {
        o(tVar.f8131c, tVar.f8129a);
        q(tVar.f8130b * 8);
    }

    public void q(int i10) {
        int i11 = i10 / 8;
        this.f6376c = i11;
        this.f6377d = i10 - (i11 * 8);
        a();
    }

    public boolean r(int i10) {
        if (2 > i10 || i10 >= this.f6376c) {
            return false;
        }
        byte[] bArr = this.f6375b;
        return bArr[i10] == 3 && bArr[i10 + (-2)] == 0 && bArr[i10 - 1] == 0;
    }

    public void s() {
        switch (this.f6374a) {
            case 2:
                int i10 = this.f6377d + 1;
                this.f6377d = i10;
                if (i10 == 8) {
                    this.f6377d = 0;
                    this.f6376c++;
                }
                a();
                break;
            default:
                int i11 = this.f6378e + 1;
                this.f6378e = i11;
                if (i11 == 8) {
                    this.f6378e = 0;
                    int i12 = this.f6377d;
                    this.f6377d = i12 + (r(i12 + 1) ? 2 : 1);
                }
                a();
                break;
        }
    }

    public void t(int i10) {
        int i11;
        switch (this.f6374a) {
            case 1:
                int i12 = i10 / 8;
                int i13 = this.f6377d + i12;
                this.f6377d = i13;
                int i14 = (i10 - (i12 * 8)) + this.f6378e;
                this.f6378e = i14;
                boolean z10 = true;
                if (i14 > 7) {
                    this.f6377d = i13 + 1;
                    this.f6378e = i14 - 8;
                }
                int i15 = this.f6377d;
                if (i15 < 0 || (i15 >= (i11 = this.f6376c) && (i15 != i11 || this.f6378e != 0))) {
                    z10 = false;
                }
                l1.d.g(z10);
                break;
            case 2:
                int i16 = i10 / 8;
                int i17 = this.f6376c + i16;
                this.f6376c = i17;
                int i18 = (i10 - (i16 * 8)) + this.f6377d;
                this.f6377d = i18;
                if (i18 > 7) {
                    this.f6376c = i17 + 1;
                    this.f6377d = i18 - 8;
                }
                a();
                break;
            default:
                int i19 = this.f6377d;
                int i20 = i10 / 8;
                int i21 = i19 + i20;
                this.f6377d = i21;
                int i22 = (i10 - (i20 * 8)) + this.f6378e;
                this.f6378e = i22;
                if (i22 > 7) {
                    this.f6377d = i21 + 1;
                    this.f6378e = i22 - 8;
                }
                while (true) {
                    i19++;
                    if (i19 > this.f6377d) {
                        a();
                        break;
                    } else if (r(i19)) {
                        this.f6377d++;
                        i19 += 2;
                    }
                }
        }
    }

    public void u(int i10) {
        l1.d.g(this.f6377d == 0);
        this.f6376c += i10;
        a();
    }

    public f(byte[] bArr) {
        this.f6374a = 1;
        this.f6375b = bArr;
        this.f6376c = bArr.length;
    }

    public f(byte[] bArr, int i10, int i11) {
        this.f6374a = 3;
        this.f6375b = bArr;
        this.f6377d = i10;
        this.f6376c = i11;
        this.f6378e = 0;
        a();
    }

    public f(int i10, byte[] bArr) {
        this.f6374a = 2;
        this.f6375b = bArr;
        this.f6378e = i10;
    }

    public f(int i10, int i11) {
        this.f6374a = 0;
        this.f6376c = i10;
        this.f6377d = i11;
        this.f6375b = new byte[(i11 * 2) - 1];
        this.f6378e = 0;
    }
}
