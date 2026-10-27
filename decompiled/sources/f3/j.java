package f3;

import android.opengl.GLES20;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.gms.internal.cast.v;
import j9.v1;
import j9.w1;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import k2.p;
import l1.t;
import l1.y;
import r3.a0;
import r3.c0;
import r3.d0;
import r3.e0;
import r3.f0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements a0 {

    /* renamed from: o, reason: collision with root package name */
    public int f5006o;

    /* renamed from: p, reason: collision with root package name */
    public Object f5007p;

    /* renamed from: q, reason: collision with root package name */
    public Object f5008q;

    /* renamed from: r, reason: collision with root package name */
    public Object f5009r;

    /* renamed from: s, reason: collision with root package name */
    public Object f5010s;

    public j(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.f5006o = glCreateProgram;
        l1.b.c();
        a(str, glCreateProgram, 35633);
        a(str2, glCreateProgram, 35632);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        l1.b.d("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram), iArr[0] == 1);
        GLES20.glUseProgram(glCreateProgram);
        this.f5009r = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f5007p = new v1[iArr2[0]];
        for (int i10 = 0; i10 < iArr2[0]; i10++) {
            int i11 = this.f5006o;
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(i11, 35722, iArr3, 0);
            int i12 = iArr3[0];
            byte[] bArr = new byte[i12];
            GLES20.glGetActiveAttrib(i11, i10, i12, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            int i13 = 0;
            while (true) {
                if (i13 >= i12) {
                    break;
                }
                if (bArr[i13] == 0) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
            String str3 = new String(bArr, 0, i12);
            GLES20.glGetAttribLocation(i11, str3);
            v1 v1Var = new v1(3);
            ((v1[]) this.f5007p)[i10] = v1Var;
            ((HashMap) this.f5009r).put(str3, v1Var);
        }
        this.f5010s = new HashMap();
        int[] iArr4 = new int[1];
        GLES20.glGetProgramiv(this.f5006o, 35718, iArr4, 0);
        this.f5008q = new w1[iArr4[0]];
        for (int i14 = 0; i14 < iArr4[0]; i14++) {
            int i15 = this.f5006o;
            int[] iArr5 = new int[1];
            GLES20.glGetProgramiv(i15, 35719, iArr5, 0);
            int i16 = iArr5[0];
            byte[] bArr2 = new byte[i16];
            GLES20.glGetActiveUniform(i15, i14, i16, new int[1], 0, new int[1], 0, new int[1], 0, bArr2, 0);
            int i17 = 0;
            while (true) {
                if (i17 >= i16) {
                    break;
                }
                if (bArr2[i17] == 0) {
                    i16 = i17;
                    break;
                }
                i17++;
            }
            String str4 = new String(bArr2, 0, i16);
            GLES20.glGetUniformLocation(i15, str4);
            w1 w1Var = new w1(3);
            ((w1[]) this.f5008q)[i14] = w1Var;
            ((HashMap) this.f5010s).put(str4, w1Var);
        }
        l1.b.c();
    }

    public static void a(String str, int i10, int i11) {
        int glCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        l1.b.d(GLES20.glGetShaderInfoLog(glCreateShader) + ", source: \n" + str, iArr[0] == 1);
        GLES20.glAttachShader(i10, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        l1.b.c();
    }

    @Override // r3.a0
    public void b(t tVar) {
        y yVar;
        y yVar2;
        SparseArray sparseArray;
        int i10;
        i3.f fVar;
        char c10;
        int i11;
        int i12;
        y yVar3;
        SparseArray sparseArray2 = (SparseArray) this.f5008q;
        SparseIntArray sparseIntArray = (SparseIntArray) this.f5009r;
        i3.f fVar2 = (i3.f) this.f5007p;
        c0 c0Var = (c0) this.f5010s;
        SparseArray sparseArray3 = c0Var.f10462h;
        SparseBooleanArray sparseBooleanArray = c0Var.f10463i;
        j0.i iVar = c0Var.f10461f;
        List list = c0Var.f10458c;
        int i13 = c0Var.f10456a;
        if (tVar.w() == 2) {
            if (i13 == 1 || i13 == 2 || c0Var.f10468n == 1) {
                yVar = (y) list.get(0);
            } else {
                yVar = new y(((y) list.get(0)).d());
                list.add(yVar);
            }
            if ((tVar.w() & 128) != 0) {
                tVar.J(1);
                int C = tVar.C();
                tVar.J(3);
                tVar.h(fVar2.f6375b, 0, 2);
                fVar2.q(0);
                fVar2.t(3);
                c0Var.f10474t = fVar2.i(13);
                tVar.h(fVar2.f6375b, 0, 2);
                fVar2.q(0);
                fVar2.t(4);
                tVar.J(fVar2.i(12));
                if (i13 == 2 && c0Var.f10472r == null) {
                    f0 a10 = iVar.a(21, new v(21, null, 0, null, l1.a0.f8069c));
                    c0Var.f10472r = a10;
                    if (a10 != null) {
                        a10.d(yVar, c0Var.f10467m, new e0(C, 21, 8192));
                    }
                }
                sparseArray2.clear();
                sparseIntArray.clear();
                int a11 = tVar.a();
                while (a11 > 0) {
                    tVar.h(fVar2.f6375b, 0, 5);
                    fVar2.q(0);
                    int i14 = fVar2.i(8);
                    fVar2.t(3);
                    int i15 = fVar2.i(13);
                    fVar2.t(4);
                    int i16 = fVar2.i(12);
                    int i17 = tVar.f8130b;
                    int i18 = i17 + i16;
                    int i19 = -1;
                    String str = null;
                    ArrayList arrayList = null;
                    int i20 = 0;
                    int i21 = a11;
                    while (true) {
                        if (tVar.f8130b >= i18) {
                            fVar = fVar2;
                            break;
                        }
                        int w10 = tVar.w();
                        fVar = fVar2;
                        int w11 = tVar.f8130b + tVar.w();
                        if (w11 > i18) {
                            break;
                        }
                        SparseArray sparseArray4 = sparseArray3;
                        if (w10 == 5) {
                            long y8 = tVar.y();
                            if (y8 == 1094921523) {
                                i19 = 129;
                            } else if (y8 == 1161904947) {
                                i19 = 135;
                            } else {
                                if (y8 != 1094921524) {
                                    if (y8 == 1212503619) {
                                        i19 = 36;
                                    }
                                }
                                i19 = 172;
                            }
                            i11 = w11;
                            i12 = C;
                            yVar3 = yVar;
                        } else if (w10 == 106) {
                            i11 = w11;
                            i12 = C;
                            yVar3 = yVar;
                            i19 = 129;
                        } else if (w10 == 122) {
                            i12 = C;
                            yVar3 = yVar;
                            i19 = 135;
                            i11 = w11;
                        } else {
                            if (w10 == 127) {
                                int w12 = tVar.w();
                                if (w12 != 21) {
                                    if (w12 == 14) {
                                        i19 = 136;
                                    } else if (w12 == 33) {
                                        i19 = 139;
                                    }
                                }
                                i19 = 172;
                            } else if (w10 == 123) {
                                i19 = 138;
                            } else if (w10 == 10) {
                                str = tVar.u(3, StandardCharsets.UTF_8).trim();
                                i11 = w11;
                                i20 = tVar.w();
                                i12 = C;
                                yVar3 = yVar;
                            } else {
                                if (w10 == 89) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (tVar.f8130b < w11) {
                                        String trim = tVar.u(3, StandardCharsets.UTF_8).trim();
                                        tVar.w();
                                        y yVar4 = yVar;
                                        byte[] bArr = new byte[4];
                                        tVar.h(bArr, 0, 4);
                                        arrayList2.add(new d0(trim, bArr));
                                        yVar = yVar4;
                                        w11 = w11;
                                        C = C;
                                    }
                                    i11 = w11;
                                    i12 = C;
                                    yVar3 = yVar;
                                    arrayList = arrayList2;
                                    i19 = 89;
                                } else {
                                    i11 = w11;
                                    i12 = C;
                                    yVar3 = yVar;
                                    if (w10 == 111) {
                                        i19 = 257;
                                    }
                                }
                                tVar.J(i11 - tVar.f8130b);
                                yVar = yVar3;
                                fVar2 = fVar;
                                sparseArray3 = sparseArray4;
                                C = i12;
                            }
                            i11 = w11;
                            i12 = C;
                            yVar3 = yVar;
                        }
                        tVar.J(i11 - tVar.f8130b);
                        yVar = yVar3;
                        fVar2 = fVar;
                        sparseArray3 = sparseArray4;
                        C = i12;
                    }
                    SparseArray sparseArray5 = sparseArray3;
                    int i22 = C;
                    y yVar5 = yVar;
                    tVar.I(i18);
                    v vVar = new v(i19, str, i20, arrayList, Arrays.copyOfRange(tVar.f8129a, i17, i18));
                    if (i14 == 6 || i14 == 5) {
                        i14 = i19;
                    }
                    int i23 = i21 - (i16 + 5);
                    int i24 = i13 == 2 ? i14 : i15;
                    if (sparseBooleanArray.get(i24)) {
                        c10 = 21;
                    } else {
                        c10 = 21;
                        f0 a12 = (i13 == 2 && i14 == 21) ? c0Var.f10472r : iVar.a(i14, vVar);
                        if (i13 != 2 || i15 < sparseIntArray.get(i24, 8192)) {
                            sparseIntArray.put(i24, i15);
                            sparseArray2.put(i24, a12);
                        }
                    }
                    a11 = i23;
                    yVar = yVar5;
                    fVar2 = fVar;
                    sparseArray3 = sparseArray5;
                    C = i22;
                }
                SparseArray sparseArray6 = sparseArray3;
                int i25 = C;
                y yVar6 = yVar;
                int size = sparseIntArray.size();
                int i26 = 0;
                while (i26 < size) {
                    int keyAt = sparseIntArray.keyAt(i26);
                    int valueAt = sparseIntArray.valueAt(i26);
                    sparseBooleanArray.put(keyAt, true);
                    c0Var.f10464j.put(valueAt, true);
                    f0 f0Var = (f0) sparseArray2.valueAt(i26);
                    if (f0Var != null) {
                        if (f0Var != c0Var.f10472r) {
                            i10 = i25;
                            yVar2 = yVar6;
                            f0Var.d(yVar2, c0Var.f10467m, new e0(i10, keyAt, 8192));
                        } else {
                            yVar2 = yVar6;
                            i10 = i25;
                        }
                        sparseArray = sparseArray6;
                        sparseArray.put(valueAt, f0Var);
                    } else {
                        yVar2 = yVar6;
                        sparseArray = sparseArray6;
                        i10 = i25;
                    }
                    i26++;
                    sparseArray6 = sparseArray;
                    i25 = i10;
                    yVar6 = yVar2;
                }
                SparseArray sparseArray7 = sparseArray6;
                if (i13 == 2) {
                    if (c0Var.f10469o) {
                        return;
                    }
                    c0Var.f10467m.f();
                    c0Var.f10468n = 0;
                    c0Var.f10469o = true;
                    return;
                }
                sparseArray7.remove(this.f5006o);
                int i27 = i13 == 1 ? 0 : c0Var.f10468n - 1;
                c0Var.f10468n = i27;
                if (i27 == 0) {
                    c0Var.f10467m.f();
                    c0Var.f10469o = true;
                }
            }
        }
    }

    public int c(String str) {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f5006o, str);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        l1.b.c();
        return glGetAttribLocation;
    }

    @Override // r3.a0
    public void d(y yVar, p pVar, e0 e0Var) {
    }
}
