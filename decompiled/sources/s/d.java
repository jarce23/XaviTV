package s;

import b4.o;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: f, reason: collision with root package name */
    public f[] f11126f;
    public f[] g;

    /* renamed from: h, reason: collision with root package name */
    public int f11127h;

    /* renamed from: i, reason: collision with root package name */
    public x4.c f11128i;

    @Override // s.b
    public final f d(boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f11127h; i11++) {
            f[] fVarArr = this.f11126f;
            f fVar = fVarArr[i11];
            if (!zArr[fVar.f11131p]) {
                x4.c cVar = this.f11128i;
                cVar.f13537p = fVar;
                int i12 = 8;
                if (i10 == -1) {
                    while (i12 >= 0) {
                        float f10 = ((f) cVar.f13537p).f11137v[i12];
                        if (f10 <= 0.0f) {
                            if (f10 < 0.0f) {
                                i10 = i11;
                                break;
                            }
                            i12--;
                        }
                    }
                } else {
                    f fVar2 = fVarArr[i10];
                    while (true) {
                        if (i12 >= 0) {
                            float f11 = fVar2.f11137v[i12];
                            float f12 = ((f) cVar.f13537p).f11137v[i12];
                            if (f12 == f11) {
                                i12--;
                            } else if (f12 >= f11) {
                            }
                        }
                    }
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f11126f[i10];
    }

    @Override // s.b
    public final boolean e() {
        return this.f11127h == 0;
    }

    @Override // s.b
    public final void i(c cVar, b bVar, boolean z10) {
        f fVar = bVar.f11105a;
        if (fVar == null) {
            return;
        }
        float[] fArr = fVar.f11137v;
        a aVar = bVar.f11108d;
        int d6 = aVar.d();
        for (int i10 = 0; i10 < d6; i10++) {
            f e7 = aVar.e(i10);
            float f10 = aVar.f(i10);
            x4.c cVar2 = this.f11128i;
            cVar2.f13537p = e7;
            if (e7.f11130o) {
                boolean z11 = true;
                for (int i11 = 0; i11 < 9; i11++) {
                    float[] fArr2 = ((f) cVar2.f13537p).f11137v;
                    float f11 = (fArr[i11] * f10) + fArr2[i11];
                    fArr2[i11] = f11;
                    if (Math.abs(f11) < 1.0E-4f) {
                        ((f) cVar2.f13537p).f11137v[i11] = 0.0f;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    ((d) cVar2.f13538q).k((f) cVar2.f13537p);
                }
            } else {
                for (int i12 = 0; i12 < 9; i12++) {
                    float f12 = fArr[i12];
                    if (f12 != 0.0f) {
                        float f13 = f12 * f10;
                        if (Math.abs(f13) < 1.0E-4f) {
                            f13 = 0.0f;
                        }
                        ((f) cVar2.f13537p).f11137v[i12] = f13;
                    } else {
                        ((f) cVar2.f13537p).f11137v[i12] = 0.0f;
                    }
                }
                j(e7);
            }
            this.f11106b = (bVar.f11106b * f10) + this.f11106b;
        }
        k(fVar);
    }

    public final void j(f fVar) {
        int i10;
        int i11 = this.f11127h + 1;
        f[] fVarArr = this.f11126f;
        if (i11 > fVarArr.length) {
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
            this.f11126f = fVarArr2;
            this.g = (f[]) Arrays.copyOf(fVarArr2, fVarArr2.length * 2);
        }
        f[] fVarArr3 = this.f11126f;
        int i12 = this.f11127h;
        fVarArr3[i12] = fVar;
        int i13 = i12 + 1;
        this.f11127h = i13;
        if (i13 > 1 && fVarArr3[i12].f11131p > fVar.f11131p) {
            int i14 = 0;
            while (true) {
                i10 = this.f11127h;
                if (i14 >= i10) {
                    break;
                }
                this.g[i14] = this.f11126f[i14];
                i14++;
            }
            Arrays.sort(this.g, 0, i10, new o(3));
            for (int i15 = 0; i15 < this.f11127h; i15++) {
                this.f11126f[i15] = this.g[i15];
            }
        }
        fVar.f11130o = true;
        fVar.a(this);
    }

    public final void k(f fVar) {
        int i10 = 0;
        while (i10 < this.f11127h) {
            if (this.f11126f[i10] == fVar) {
                while (true) {
                    int i11 = this.f11127h;
                    if (i10 >= i11 - 1) {
                        this.f11127h = i11 - 1;
                        fVar.f11130o = false;
                        return;
                    } else {
                        f[] fVarArr = this.f11126f;
                        int i12 = i10 + 1;
                        fVarArr[i10] = fVarArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // s.b
    public final String toString() {
        x4.c cVar = this.f11128i;
        String str = " goal -> (" + this.f11106b + ") : ";
        for (int i10 = 0; i10 < this.f11127h; i10++) {
            cVar.f13537p = this.f11126f[i10];
            str = str + cVar + " ";
        }
        return str;
    }
}
