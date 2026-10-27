package e0;

import android.graphics.Path;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public char f4390a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f4391b;

    public e(char c10, float[] fArr) {
        this.f4390a = c10;
        this.f4391b = fArr;
    }

    public static void a(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
        double d6;
        double d10;
        double radians = Math.toRadians(f16);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d11 = f10;
        double d12 = f11;
        double d13 = f14;
        double d14 = ((d12 * sin) + (d11 * cos)) / d13;
        double d15 = f15;
        double d16 = ((d12 * cos) + ((-f10) * sin)) / d15;
        double d17 = f13;
        double d18 = ((d17 * sin) + (f12 * cos)) / d13;
        double d19 = ((d17 * cos) + ((-f12) * sin)) / d15;
        double d20 = d14 - d18;
        double d21 = d16 - d19;
        double d22 = (d14 + d18) / 2.0d;
        double d23 = (d16 + d19) / 2.0d;
        double d24 = (d21 * d21) + (d20 * d20);
        if (d24 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d25 = (1.0d / d24) - 0.25d;
        if (d25 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d24);
            float sqrt = (float) (Math.sqrt(d24) / 1.99999d);
            a(path, f10, f11, f12, f13, f14 * sqrt, sqrt * f15, f16, z10, z11);
            return;
        }
        double sqrt2 = Math.sqrt(d25);
        double d26 = sqrt2 * d20;
        double d27 = sqrt2 * d21;
        if (z10 == z11) {
            d6 = d22 - d27;
            d10 = d23 + d26;
        } else {
            d6 = d22 + d27;
            d10 = d23 - d26;
        }
        double atan2 = Math.atan2(d16 - d10, d14 - d6);
        double atan22 = Math.atan2(d19 - d10, d18 - d6) - atan2;
        if (z11 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d28 = d6 * d13;
        double d29 = d10 * d15;
        double d30 = (d28 * cos) - (d29 * sin);
        double d31 = (d29 * cos) + (d28 * sin);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(radians);
        double sin2 = Math.sin(radians);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d32 = -d13;
        double d33 = d32 * cos2;
        double d34 = d15 * sin2;
        double d35 = (d33 * sin3) - (d34 * cos3);
        double d36 = d32 * sin2;
        double d37 = d15 * cos2;
        double d38 = atan22 / ceil;
        double d39 = (cos3 * d37) + (sin3 * d36);
        double d40 = d11;
        double d41 = d12;
        int i10 = 0;
        double d42 = atan2;
        while (i10 < ceil) {
            double d43 = d42 + d38;
            double sin4 = Math.sin(d43);
            double cos4 = Math.cos(d43);
            int i11 = ceil;
            double d44 = (((d13 * cos2) * cos4) + d30) - (d34 * sin4);
            double d45 = (d37 * sin4) + (d13 * sin2 * cos4) + d31;
            double d46 = (d33 * sin4) - (d34 * cos4);
            double d47 = (cos4 * d37) + (sin4 * d36);
            double d48 = d43 - d42;
            double tan = Math.tan(d48 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d35 * sqrt3) + d40), (float) ((d39 * sqrt3) + d41), (float) (d44 - (sqrt3 * d46)), (float) (d45 - (sqrt3 * d47)), (float) d44, (float) d45);
            i10++;
            d41 = d45;
            cos2 = cos2;
            d36 = d36;
            d42 = d43;
            d39 = d47;
            d40 = d44;
            ceil = i11;
            d35 = d46;
            d38 = d38;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(e[] eVarArr, Path path) {
        int i10;
        float[] fArr;
        int i11;
        e eVar;
        int i12;
        char c10;
        float f10;
        float f11;
        e eVar2;
        boolean z10;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        e[] eVarArr2 = eVarArr;
        Path path2 = path;
        float[] fArr2 = new float[6];
        int length = eVarArr2.length;
        int i13 = 0;
        int i14 = 0;
        char c11 = 'm';
        while (i14 < length) {
            e eVar3 = eVarArr2[i14];
            char c12 = eVar3.f4390a;
            float[] fArr3 = eVar3.f4391b;
            float f20 = fArr2[i13];
            float f21 = fArr2[1];
            float f22 = fArr2[2];
            float f23 = fArr2[3];
            float f24 = fArr2[4];
            int i15 = i13;
            float f25 = fArr2[5];
            switch (c12) {
                case 'A':
                case 'a':
                    i10 = 7;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i10 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i10 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f24, f25);
                    f20 = f24;
                    f22 = f20;
                    f21 = f25;
                    f23 = f21;
                default:
                    i10 = 2;
                    break;
            }
            float f26 = f24;
            float f27 = f25;
            float f28 = f20;
            float f29 = f21;
            int i16 = i15;
            while (i16 < fArr3.length) {
                if (c12 == 'A') {
                    fArr = fArr3;
                    i11 = i16;
                    eVar = eVar3;
                    float f30 = f28;
                    float f31 = f29;
                    i12 = i14;
                    c10 = c12;
                    int i17 = i11 + 5;
                    int i18 = i11 + 6;
                    a(path, f30, f31, fArr[i17], fArr[i18], fArr[i11], fArr[i11 + 1], fArr[i11 + 2], fArr[i11 + 3] != 0.0f ? 1 : i15, fArr[i11 + 4] != 0.0f ? 1 : i15);
                    f22 = fArr[i17];
                    f10 = fArr[i18];
                    f23 = f10;
                    f11 = f22;
                } else if (c12 == 'C') {
                    fArr = fArr3;
                    i11 = i16;
                    i12 = i14;
                    eVar = eVar3;
                    c10 = c12;
                    int i19 = i11 + 2;
                    int i20 = i11 + 3;
                    int i21 = i11 + 4;
                    int i22 = i11 + 5;
                    path2.cubicTo(fArr[i11], fArr[i11 + 1], fArr[i19], fArr[i20], fArr[i21], fArr[i22]);
                    float f32 = fArr[i21];
                    float f33 = fArr[i22];
                    f22 = fArr[i19];
                    f23 = fArr[i20];
                    f10 = f33;
                    f11 = f32;
                } else if (c12 == 'H') {
                    fArr = fArr3;
                    i11 = i16;
                    eVar = eVar3;
                    c10 = c12;
                    f10 = f29;
                    i12 = i14;
                    path2.lineTo(fArr[i11], f10);
                    f11 = fArr[i11];
                } else if (c12 == 'Q') {
                    fArr = fArr3;
                    i11 = i16;
                    i12 = i14;
                    eVar = eVar3;
                    c10 = c12;
                    int i23 = i11 + 1;
                    int i24 = i11 + 2;
                    int i25 = i11 + 3;
                    path2.quadTo(fArr[i11], fArr[i23], fArr[i24], fArr[i25]);
                    float f34 = fArr[i11];
                    float f35 = fArr[i23];
                    float f36 = fArr[i24];
                    float f37 = fArr[i25];
                    f22 = f34;
                    f23 = f35;
                    f11 = f36;
                    f10 = f37;
                } else if (c12 == 'V') {
                    fArr = fArr3;
                    i11 = i16;
                    i12 = i14;
                    eVar = eVar3;
                    f11 = f28;
                    c10 = c12;
                    path2.lineTo(f11, fArr[i11]);
                    f10 = fArr[i11];
                } else if (c12 != 'a') {
                    if (c12 == 'c') {
                        fArr = fArr3;
                        i11 = i16;
                        int i26 = i11 + 2;
                        int i27 = i11 + 3;
                        int i28 = i11 + 4;
                        int i29 = i11 + 5;
                        path2.rCubicTo(fArr[i11], fArr[i11 + 1], fArr[i26], fArr[i27], fArr[i28], fArr[i29]);
                        float f38 = fArr[i26] + f28;
                        float f39 = fArr[i27] + f29;
                        f28 += fArr[i28];
                        f29 += fArr[i29];
                        f22 = f38;
                        f23 = f39;
                    } else if (c12 != 'h') {
                        if (c12 != 'q') {
                            if (c12 != 'v') {
                                if (c12 == 'L') {
                                    fArr = fArr3;
                                    i11 = i16;
                                    int i30 = i11 + 1;
                                    path2.lineTo(fArr[i11], fArr[i30]);
                                    f11 = fArr[i11];
                                    f10 = fArr[i30];
                                } else if (c12 == 'M') {
                                    fArr = fArr3;
                                    i11 = i16;
                                    f11 = fArr[i11];
                                    f10 = fArr[i11 + 1];
                                    if (i11 > 0) {
                                        path2.lineTo(f11, f10);
                                    } else {
                                        path2.moveTo(f11, f10);
                                        f26 = f11;
                                        f27 = f10;
                                    }
                                } else if (c12 != 'S') {
                                    if (c12 == 'T') {
                                        fArr = fArr3;
                                        i11 = i16;
                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                            f28 = (f28 * 2.0f) - f22;
                                            f29 = (f29 * 2.0f) - f23;
                                        }
                                        int i31 = i11 + 1;
                                        path2.quadTo(f28, f29, fArr[i11], fArr[i31]);
                                        f11 = fArr[i11];
                                        f10 = fArr[i31];
                                        eVar = eVar3;
                                        f22 = f28;
                                        f23 = f29;
                                    } else if (c12 == 'l') {
                                        fArr = fArr3;
                                        i11 = i16;
                                        int i32 = i11 + 1;
                                        path2.rLineTo(fArr[i11], fArr[i32]);
                                        f28 += fArr[i11];
                                        f15 = fArr[i32];
                                    } else if (c12 == 'm') {
                                        fArr = fArr3;
                                        i11 = i16;
                                        float f40 = fArr[i11];
                                        f28 += f40;
                                        float f41 = fArr[i11 + 1];
                                        f29 += f41;
                                        if (i11 > 0) {
                                            path2.rLineTo(f40, f41);
                                        } else {
                                            path2.rMoveTo(f40, f41);
                                            eVar = eVar3;
                                            f11 = f28;
                                            f26 = f11;
                                            f10 = f29;
                                            f27 = f10;
                                        }
                                    } else if (c12 != 's') {
                                        if (c12 != 't') {
                                            fArr = fArr3;
                                            i11 = i16;
                                            eVar = eVar3;
                                            f11 = f28;
                                        } else {
                                            if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                f18 = f28 - f22;
                                                f19 = f29 - f23;
                                            } else {
                                                f19 = 0.0f;
                                                f18 = 0.0f;
                                            }
                                            int i33 = i16 + 1;
                                            path2.rQuadTo(f18, f19, fArr3[i16], fArr3[i33]);
                                            float f42 = f18 + f28;
                                            float f43 = f19 + f29;
                                            float f44 = f28 + fArr3[i16];
                                            f29 += fArr3[i33];
                                            f23 = f43;
                                            fArr = fArr3;
                                            i11 = i16;
                                            eVar = eVar3;
                                            f11 = f44;
                                            f22 = f42;
                                        }
                                        f10 = f29;
                                    } else {
                                        if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                            f16 = f29 - f23;
                                            f17 = f28 - f22;
                                        } else {
                                            f17 = 0.0f;
                                            f16 = 0.0f;
                                        }
                                        int i34 = i16;
                                        int i35 = i34 + 1;
                                        int i36 = i34 + 2;
                                        int i37 = i34 + 3;
                                        fArr = fArr3;
                                        i11 = i34;
                                        path2.rCubicTo(f17, f16, fArr3[i34], fArr3[i35], fArr3[i36], fArr3[i37]);
                                        f12 = fArr[i11] + f28;
                                        f13 = fArr[i35] + f29;
                                        f28 += fArr[i36];
                                        f14 = fArr[i37];
                                    }
                                    i12 = i14;
                                    c10 = c12;
                                } else {
                                    fArr = fArr3;
                                    i11 = i16;
                                    if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                        f28 = (f28 * 2.0f) - f22;
                                        f29 = (f29 * 2.0f) - f23;
                                    }
                                    float f45 = f28;
                                    float f46 = f29;
                                    int i38 = i11 + 1;
                                    int i39 = i11 + 2;
                                    int i40 = i11 + 3;
                                    path2.cubicTo(f45, f46, fArr[i11], fArr[i38], fArr[i39], fArr[i40]);
                                    f22 = fArr[i11];
                                    f23 = fArr[i38];
                                    f11 = fArr[i39];
                                    f10 = fArr[i40];
                                }
                                i12 = i14;
                                eVar = eVar3;
                                c10 = c12;
                            } else {
                                fArr = fArr3;
                                i11 = i16;
                                path2.rLineTo(0.0f, fArr[i11]);
                                f15 = fArr[i11];
                            }
                            f29 += f15;
                        } else {
                            fArr = fArr3;
                            i11 = i16;
                            int i41 = i11 + 1;
                            int i42 = i11 + 2;
                            int i43 = i11 + 3;
                            path2.rQuadTo(fArr[i11], fArr[i41], fArr[i42], fArr[i43]);
                            f12 = fArr[i11] + f28;
                            f13 = fArr[i41] + f29;
                            f28 += fArr[i42];
                            f14 = fArr[i43];
                        }
                        f29 += f14;
                        f22 = f12;
                        f23 = f13;
                    } else {
                        fArr = fArr3;
                        i11 = i16;
                        path2.rLineTo(fArr[i11], 0.0f);
                        f28 += fArr[i11];
                    }
                    eVar = eVar3;
                    f11 = f28;
                    f10 = f29;
                    i12 = i14;
                    c10 = c12;
                } else {
                    fArr = fArr3;
                    i11 = i16;
                    int i44 = i11 + 5;
                    float f47 = fArr[i44] + f28;
                    int i45 = i11 + 6;
                    float f48 = fArr[i45] + f29;
                    float f49 = fArr[i11];
                    float f50 = fArr[i11 + 1];
                    float f51 = fArr[i11 + 2];
                    if (fArr[i11 + 3] != 0.0f) {
                        eVar2 = eVar3;
                        z10 = 1;
                    } else {
                        eVar2 = eVar3;
                        z10 = i15;
                    }
                    eVar = eVar2;
                    float f52 = f28;
                    c10 = c12;
                    float f53 = f29;
                    i12 = i14;
                    a(path, f52, f53, f47, f48, f49, f50, f51, z10, fArr[i11 + 4] != 0.0f ? 1 : i15);
                    f11 = f52 + fArr[i44];
                    f10 = f53 + fArr[i45];
                    f22 = f11;
                    f23 = f10;
                }
                i16 = i11 + i10;
                path2 = path;
                eVar3 = eVar;
                c12 = c10;
                i14 = i12;
                f28 = f11;
                f29 = f10;
                c11 = c12;
                fArr3 = fArr;
            }
            fArr2[i15] = f28;
            fArr2[1] = f29;
            fArr2[2] = f22;
            fArr2[3] = f23;
            fArr2[4] = f26;
            fArr2[5] = f27;
            c11 = eVar3.f4390a;
            i14++;
            eVarArr2 = eVarArr;
            path2 = path;
            i13 = i15;
        }
    }

    public e(e eVar) {
        this.f4390a = eVar.f4390a;
        float[] fArr = eVar.f4391b;
        this.f4391b = n4.a.h(fArr, fArr.length);
    }
}
