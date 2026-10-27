package s;

import java.util.Arrays;
import okhttp3.internal.url._UrlKt;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public final b f11097b;

    /* renamed from: c, reason: collision with root package name */
    public final m f11098c;

    /* renamed from: a, reason: collision with root package name */
    public int f11096a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f11099d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f11100e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f11101f = new int[8];
    public float[] g = new float[8];

    /* renamed from: h, reason: collision with root package name */
    public int f11102h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f11103i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11104j = false;

    public a(b bVar, m mVar) {
        this.f11097b = bVar;
        this.f11098c = mVar;
    }

    public final void a(f fVar, float f10, boolean z10) {
        if (f10 <= -0.001f || f10 >= 0.001f) {
            int i10 = this.f11102h;
            b bVar = this.f11097b;
            if (i10 == -1) {
                this.f11102h = 0;
                this.g[0] = f10;
                this.f11100e[0] = fVar.f11131p;
                this.f11101f[0] = -1;
                fVar.f11140y++;
                fVar.a(bVar);
                this.f11096a++;
                if (this.f11104j) {
                    return;
                }
                int i11 = this.f11103i + 1;
                this.f11103i = i11;
                int[] iArr = this.f11100e;
                if (i11 >= iArr.length) {
                    this.f11104j = true;
                    this.f11103i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f11096a; i13++) {
                int i14 = this.f11100e[i10];
                int i15 = fVar.f11131p;
                if (i14 == i15) {
                    float[] fArr = this.g;
                    float f11 = fArr[i10] + f10;
                    if (f11 > -0.001f && f11 < 0.001f) {
                        f11 = 0.0f;
                    }
                    fArr[i10] = f11;
                    if (f11 == 0.0f) {
                        if (i10 == this.f11102h) {
                            this.f11102h = this.f11101f[i10];
                        } else {
                            int[] iArr2 = this.f11101f;
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z10) {
                            fVar.b(bVar);
                        }
                        if (this.f11104j) {
                            this.f11103i = i10;
                        }
                        fVar.f11140y--;
                        this.f11096a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.f11101f[i10];
            }
            int i16 = this.f11103i;
            int i17 = i16 + 1;
            if (this.f11104j) {
                int[] iArr3 = this.f11100e;
                if (iArr3[i16] != -1) {
                    i16 = iArr3.length;
                }
            } else {
                i16 = i17;
            }
            int[] iArr4 = this.f11100e;
            if (i16 >= iArr4.length && this.f11096a < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.f11100e;
                    if (i18 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i18] == -1) {
                        i16 = i18;
                        break;
                    }
                    i18++;
                }
            }
            int[] iArr6 = this.f11100e;
            if (i16 >= iArr6.length) {
                i16 = iArr6.length;
                int i19 = this.f11099d * 2;
                this.f11099d = i19;
                this.f11104j = false;
                this.f11103i = i16 - 1;
                this.g = Arrays.copyOf(this.g, i19);
                this.f11100e = Arrays.copyOf(this.f11100e, this.f11099d);
                this.f11101f = Arrays.copyOf(this.f11101f, this.f11099d);
            }
            this.f11100e[i16] = fVar.f11131p;
            this.g[i16] = f10;
            if (i12 != -1) {
                int[] iArr7 = this.f11101f;
                iArr7[i16] = iArr7[i12];
                iArr7[i12] = i16;
            } else {
                this.f11101f[i16] = this.f11102h;
                this.f11102h = i16;
            }
            fVar.f11140y++;
            fVar.a(bVar);
            this.f11096a++;
            if (!this.f11104j) {
                this.f11103i++;
            }
            int i20 = this.f11103i;
            int[] iArr8 = this.f11100e;
            if (i20 >= iArr8.length) {
                this.f11104j = true;
                this.f11103i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i10 = this.f11102h;
        for (int i11 = 0; i10 != -1 && i11 < this.f11096a; i11++) {
            f fVar = ((f[]) this.f11098c.f13566r)[this.f11100e[i10]];
            if (fVar != null) {
                fVar.b(this.f11097b);
            }
            i10 = this.f11101f[i10];
        }
        this.f11102h = -1;
        this.f11103i = -1;
        this.f11104j = false;
        this.f11096a = 0;
    }

    public final float c(f fVar) {
        int i10 = this.f11102h;
        for (int i11 = 0; i10 != -1 && i11 < this.f11096a; i11++) {
            if (this.f11100e[i10] == fVar.f11131p) {
                return this.g[i10];
            }
            i10 = this.f11101f[i10];
        }
        return 0.0f;
    }

    public final int d() {
        return this.f11096a;
    }

    public final f e(int i10) {
        int i11 = this.f11102h;
        for (int i12 = 0; i11 != -1 && i12 < this.f11096a; i12++) {
            if (i12 == i10) {
                return ((f[]) this.f11098c.f13566r)[this.f11100e[i11]];
            }
            i11 = this.f11101f[i11];
        }
        return null;
    }

    public final float f(int i10) {
        int i11 = this.f11102h;
        for (int i12 = 0; i11 != -1 && i12 < this.f11096a; i12++) {
            if (i12 == i10) {
                return this.g[i11];
            }
            i11 = this.f11101f[i11];
        }
        return 0.0f;
    }

    public final void g(f fVar, float f10) {
        if (f10 == 0.0f) {
            h(fVar, true);
            return;
        }
        int i10 = this.f11102h;
        b bVar = this.f11097b;
        if (i10 == -1) {
            this.f11102h = 0;
            this.g[0] = f10;
            this.f11100e[0] = fVar.f11131p;
            this.f11101f[0] = -1;
            fVar.f11140y++;
            fVar.a(bVar);
            this.f11096a++;
            if (this.f11104j) {
                return;
            }
            int i11 = this.f11103i + 1;
            this.f11103i = i11;
            int[] iArr = this.f11100e;
            if (i11 >= iArr.length) {
                this.f11104j = true;
                this.f11103i = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f11096a; i13++) {
            int i14 = this.f11100e[i10];
            int i15 = fVar.f11131p;
            if (i14 == i15) {
                this.g[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f11101f[i10];
        }
        int i16 = this.f11103i;
        int i17 = i16 + 1;
        if (this.f11104j) {
            int[] iArr2 = this.f11100e;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.f11100e;
        if (i16 >= iArr3.length && this.f11096a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f11100e;
                if (i18 >= iArr4.length) {
                    break;
                }
                if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr5 = this.f11100e;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.f11099d * 2;
            this.f11099d = i19;
            this.f11104j = false;
            this.f11103i = i16 - 1;
            this.g = Arrays.copyOf(this.g, i19);
            this.f11100e = Arrays.copyOf(this.f11100e, this.f11099d);
            this.f11101f = Arrays.copyOf(this.f11101f, this.f11099d);
        }
        this.f11100e[i16] = fVar.f11131p;
        this.g[i16] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f11101f;
            iArr6[i16] = iArr6[i12];
            iArr6[i12] = i16;
        } else {
            this.f11101f[i16] = this.f11102h;
            this.f11102h = i16;
        }
        fVar.f11140y++;
        fVar.a(bVar);
        int i20 = this.f11096a + 1;
        this.f11096a = i20;
        if (!this.f11104j) {
            this.f11103i++;
        }
        int[] iArr7 = this.f11100e;
        if (i20 >= iArr7.length) {
            this.f11104j = true;
        }
        if (this.f11103i >= iArr7.length) {
            this.f11104j = true;
            this.f11103i = iArr7.length - 1;
        }
    }

    public final float h(f fVar, boolean z10) {
        int i10 = this.f11102h;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f11096a) {
            if (this.f11100e[i10] == fVar.f11131p) {
                if (i10 == this.f11102h) {
                    this.f11102h = this.f11101f[i10];
                } else {
                    int[] iArr = this.f11101f;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    fVar.b(this.f11097b);
                }
                fVar.f11140y--;
                this.f11096a--;
                this.f11100e[i10] = -1;
                if (this.f11104j) {
                    this.f11103i = i10;
                }
                return this.g[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f11101f[i10];
        }
        return 0.0f;
    }

    public final String toString() {
        int i10 = this.f11102h;
        String str = _UrlKt.FRAGMENT_ENCODE_SET;
        for (int i11 = 0; i10 != -1 && i11 < this.f11096a; i11++) {
            str = (r.a.c(str, " -> ") + this.g[i10] + " : ") + ((f[]) this.f11098c.f13566r)[this.f11100e[i10]];
            i10 = this.f11101f[i10];
        }
        return str;
    }
}
