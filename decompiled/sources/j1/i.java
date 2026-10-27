package j1;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f6962a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6963b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6964c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6965d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6966e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6967f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6968h;

    /* renamed from: i, reason: collision with root package name */
    public final short[] f6969i;

    /* renamed from: j, reason: collision with root package name */
    public short[] f6970j;

    /* renamed from: k, reason: collision with root package name */
    public int f6971k;

    /* renamed from: l, reason: collision with root package name */
    public short[] f6972l;

    /* renamed from: m, reason: collision with root package name */
    public int f6973m;

    /* renamed from: n, reason: collision with root package name */
    public short[] f6974n;

    /* renamed from: o, reason: collision with root package name */
    public int f6975o;

    /* renamed from: p, reason: collision with root package name */
    public int f6976p;

    /* renamed from: q, reason: collision with root package name */
    public int f6977q;

    /* renamed from: r, reason: collision with root package name */
    public int f6978r;

    /* renamed from: s, reason: collision with root package name */
    public int f6979s;

    /* renamed from: t, reason: collision with root package name */
    public int f6980t;

    /* renamed from: u, reason: collision with root package name */
    public int f6981u;

    /* renamed from: v, reason: collision with root package name */
    public int f6982v;

    /* renamed from: w, reason: collision with root package name */
    public double f6983w;

    public i(int i10, int i11, float f10, float f11, int i12) {
        this.f6962a = i10;
        this.f6963b = i11;
        this.f6964c = f10;
        this.f6965d = f11;
        this.f6966e = i10 / i12;
        this.f6967f = i10 / 400;
        int i13 = i10 / 65;
        this.g = i13;
        int i14 = i13 * 2;
        this.f6968h = i14;
        this.f6969i = new short[i14];
        this.f6970j = new short[i14 * i11];
        this.f6972l = new short[i14 * i11];
        this.f6974n = new short[i14 * i11];
    }

    public static void e(int i10, int i11, short[] sArr, int i12, short[] sArr2, int i13, short[] sArr3, int i14) {
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i12 * i11) + i15;
            int i17 = (i14 * i11) + i15;
            int i18 = (i13 * i11) + i15;
            for (int i19 = 0; i19 < i10; i19++) {
                sArr[i16] = (short) (((sArr3[i17] * i19) + ((i10 - i19) * sArr2[i18])) / i10);
                i16 += i11;
                i18 += i11;
                i17 += i11;
            }
        }
    }

    public final void a(short[] sArr, int i10, int i11) {
        short[] c10 = c(this.f6972l, this.f6973m, i11);
        this.f6972l = c10;
        int i12 = this.f6963b;
        System.arraycopy(sArr, i10 * i12, c10, this.f6973m * i12, i12 * i11);
        this.f6973m += i11;
    }

    public final void b(short[] sArr, int i10, int i11) {
        int i12 = this.f6968h / i11;
        int i13 = this.f6963b;
        int i14 = i11 * i13;
        int i15 = i10 * i13;
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                i17 += sArr[(i16 * i14) + i15 + i18];
            }
            this.f6969i[i16] = (short) (i17 / i14);
        }
    }

    public final short[] c(short[] sArr, int i10, int i11) {
        int length = sArr.length;
        int i12 = this.f6963b;
        int i13 = length / i12;
        return i10 + i11 <= i13 ? sArr : Arrays.copyOf(sArr, (((i13 * 3) / 2) + i11) * i12);
    }

    public final int d(short[] sArr, int i10, int i11, int i12) {
        int i13 = i10 * this.f6963b;
        int i14 = 255;
        int i15 = 1;
        int i16 = 0;
        int i17 = 0;
        while (i11 <= i12) {
            int i18 = 0;
            for (int i19 = 0; i19 < i11; i19++) {
                i18 += Math.abs(sArr[i13 + i19] - sArr[(i13 + i11) + i19]);
            }
            if (i18 * i16 < i15 * i11) {
                i16 = i11;
                i15 = i18;
            }
            if (i18 * i14 > i17 * i11) {
                i14 = i11;
                i17 = i18;
            }
            i11++;
        }
        this.f6981u = i15 / i16;
        this.f6982v = i17 / i14;
        return i16;
    }

    public final void f() {
        float f10;
        double d6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        long j10;
        long j11;
        int i18 = this.f6973m;
        float f11 = this.f6964c;
        float f12 = this.f6965d;
        double d10 = f11 / f12;
        float f13 = this.f6966e * f12;
        int i19 = this.f6962a;
        int i20 = 1;
        int i21 = this.f6963b;
        int i22 = 0;
        if (d10 > 1.0000100135803223d || d10 < 0.9999899864196777d) {
            int i23 = this.f6971k;
            int i24 = this.f6968h;
            if (i23 >= i24) {
                int i25 = 0;
                while (true) {
                    int i26 = this.f6978r;
                    if (i26 > 0) {
                        int min = Math.min(i24, i26);
                        a(this.f6970j, i25, min);
                        this.f6978r -= min;
                        i25 += min;
                        f10 = f13;
                        d6 = d10;
                        i12 = i24;
                    } else {
                        short[] sArr = this.f6970j;
                        int i27 = i19 > 4000 ? i19 / 4000 : i20;
                        int i28 = this.g;
                        int i29 = this.f6967f;
                        if (i21 == i20 && i27 == i20) {
                            i10 = d(sArr, i25, i29, i28);
                            f10 = f13;
                            d6 = d10;
                        } else {
                            b(sArr, i25, i27);
                            f10 = f13;
                            d6 = d10;
                            short[] sArr2 = this.f6969i;
                            int d11 = d(sArr2, i22, i29 / i27, i28 / i27);
                            if (i27 != 1) {
                                int i30 = d11 * i27;
                                int i31 = i27 * 4;
                                int i32 = i30 - i31;
                                int i33 = i30 + i31;
                                if (i32 >= i29) {
                                    i29 = i32;
                                }
                                if (i33 <= i28) {
                                    i28 = i33;
                                }
                                if (i21 == 1) {
                                    i10 = d(sArr, i25, i29, i28);
                                } else {
                                    b(sArr, i25, 1);
                                    i10 = d(sArr2, i22, i29, i28);
                                }
                            } else {
                                i10 = d11;
                            }
                        }
                        int i34 = this.f6981u;
                        int i35 = this.f6982v;
                        if (i34 == 0 || (i11 = this.f6979s) == 0 || i35 > i34 * 3 || i34 * 2 <= this.f6980t * 3) {
                            i11 = i10;
                        }
                        this.f6980t = i34;
                        this.f6979s = i10;
                        if (d6 > 1.0d) {
                            short[] sArr3 = this.f6970j;
                            if (d6 >= 2.0d) {
                                i12 = i24;
                                double d12 = (i11 / (d6 - 1.0d)) + this.f6983w;
                                i14 = (int) Math.round(d12);
                                this.f6983w = d12 - i14;
                            } else {
                                i12 = i24;
                                double d13 = (((2.0d - d6) * i11) / (d6 - 1.0d)) + this.f6983w;
                                int round = (int) Math.round(d13);
                                this.f6978r = round;
                                this.f6983w = d13 - round;
                                i14 = i11;
                            }
                            short[] c10 = c(this.f6972l, this.f6973m, i14);
                            this.f6972l = c10;
                            int i36 = i25 + i11;
                            int i37 = i25;
                            int i38 = i14;
                            e(i38, this.f6963b, c10, this.f6973m, sArr3, i37, sArr3, i36);
                            this.f6973m += i38;
                            i25 = i11 + i38 + i37;
                        } else {
                            i12 = i24;
                            int i39 = i25;
                            short[] sArr4 = this.f6970j;
                            if (d6 < 0.5d) {
                                double d14 = ((i11 * d6) / (1.0d - d6)) + this.f6983w;
                                int round2 = (int) Math.round(d14);
                                this.f6983w = d14 - round2;
                                i13 = round2;
                            } else {
                                double d15 = ((((d6 * 2.0d) - 1.0d) * i11) / (1.0d - d6)) + this.f6983w;
                                int round3 = (int) Math.round(d15);
                                this.f6978r = round3;
                                this.f6983w = d15 - round3;
                                i13 = i11;
                            }
                            int i40 = i11 + i13;
                            short[] c11 = c(this.f6972l, this.f6973m, i40);
                            this.f6972l = c11;
                            System.arraycopy(sArr4, i39 * i21, c11, this.f6973m * i21, i11 * i21);
                            e(i13, this.f6963b, this.f6972l, this.f6973m + i11, sArr4, i39 + i11, sArr4, i39);
                            this.f6973m += i40;
                            i25 = i39 + i13;
                        }
                    }
                    if (i25 + i12 > i23) {
                        break;
                    }
                    i22 = 0;
                    i24 = i12;
                    i20 = 1;
                    f13 = f10;
                    d10 = d6;
                }
                int i41 = this.f6971k - i25;
                short[] sArr5 = this.f6970j;
                System.arraycopy(sArr5, i25 * i21, sArr5, 0, i41 * i21);
                this.f6971k = i41;
                if (f10 != 1.0f || this.f6973m == i18) {
                }
                long j12 = (long) (i19 / f10);
                long j13 = i19;
                while (j12 != 0 && j13 != 0 && j12 % 2 == 0 && j13 % 2 == 0) {
                    j12 /= 2;
                    j13 /= 2;
                }
                int i42 = this.f6973m - i18;
                short[] c12 = c(this.f6974n, this.f6975o, i42);
                this.f6974n = c12;
                System.arraycopy(this.f6972l, i18 * i21, c12, this.f6975o * i21, i42 * i21);
                this.f6973m = i18;
                this.f6975o += i42;
                int i43 = 0;
                while (true) {
                    i15 = this.f6975o;
                    i16 = i15 - 1;
                    if (i43 >= i16) {
                        break;
                    }
                    while (true) {
                        i17 = this.f6976p + 1;
                        j10 = i17;
                        long j14 = j10 * j12;
                        j11 = this.f6977q;
                        if (j14 <= j11 * j13) {
                            break;
                        }
                        this.f6972l = c(this.f6972l, this.f6973m, 1);
                        int i44 = 0;
                        while (i44 < i21) {
                            short[] sArr6 = this.f6972l;
                            int i45 = (this.f6973m * i21) + i44;
                            short[] sArr7 = this.f6974n;
                            int i46 = (i43 * i21) + i44;
                            short s10 = sArr7[i46];
                            short s11 = sArr7[i46 + i21];
                            long j15 = j12;
                            int i47 = i43;
                            long j16 = (r12 + 1) * j15;
                            long j17 = j16 - (this.f6977q * j13);
                            long j18 = j16 - (this.f6976p * j15);
                            sArr6[i45] = (short) ((((j18 - j17) * s11) + (s10 * j17)) / j18);
                            i44++;
                            i43 = i47;
                            j12 = j15;
                        }
                        this.f6977q++;
                        this.f6973m++;
                        i43 = i43;
                        j12 = j12;
                    }
                    long j19 = j12;
                    int i48 = i43;
                    this.f6976p = i17;
                    if (j10 == j13) {
                        this.f6976p = 0;
                        l1.d.g(j11 == j19);
                        this.f6977q = 0;
                    }
                    i43 = i48 + 1;
                    j12 = j19;
                }
                if (i16 == 0) {
                    return;
                }
                short[] sArr8 = this.f6974n;
                System.arraycopy(sArr8, i16 * i21, sArr8, 0, (i15 - i16) * i21);
                this.f6975o -= i16;
                return;
            }
        } else {
            a(this.f6970j, 0, this.f6971k);
            this.f6971k = 0;
        }
        f10 = f13;
        if (f10 != 1.0f) {
        }
    }
}
