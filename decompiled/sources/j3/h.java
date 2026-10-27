package j3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.leanback.widget.w0;
import h3.j;
import h3.k;
import java.util.ArrayList;
import java.util.List;
import l1.a0;
import l1.t;
import o9.e0;
import o9.g0;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: v, reason: collision with root package name */
    public static final byte[] f7096v = {0, 7, 8, 15};

    /* renamed from: w, reason: collision with root package name */
    public static final byte[] f7097w = {0, 119, -120, -1};

    /* renamed from: x, reason: collision with root package name */
    public static final byte[] f7098x = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: o, reason: collision with root package name */
    public final Paint f7099o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f7100p;

    /* renamed from: q, reason: collision with root package name */
    public final Canvas f7101q;

    /* renamed from: r, reason: collision with root package name */
    public final b f7102r;

    /* renamed from: s, reason: collision with root package name */
    public final a f7103s;

    /* renamed from: t, reason: collision with root package name */
    public final g f7104t;

    /* renamed from: u, reason: collision with root package name */
    public Bitmap f7105u;

    public h(List list) {
        t tVar = new t((byte[]) list.get(0));
        int C = tVar.C();
        int C2 = tVar.C();
        Paint paint = new Paint();
        this.f7099o = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f7100p = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f7101q = new Canvas();
        this.f7102r = new b(719, 575, 0, 719, 0, 575);
        this.f7103s = new a(0, new int[]{0, -1, -16777216, -8421505}, c(), e());
        this.f7104t = new g(C, C2);
    }

    public static byte[] a(int i10, int i11, i3.f fVar) {
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr[i12] = (byte) fVar.i(i11);
        }
        return bArr;
    }

    public static int[] c() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            if (i10 < 8) {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 127 : 0, (i10 & 2) != 0 ? 127 : 0, (i10 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i10 = 0; i10 < 256; i10++) {
            if (i10 < 8) {
                iArr[i10] = f(63, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) == 0 ? 0 : 255);
            } else {
                int i11 = i10 & 136;
                if (i11 == 0) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 8) {
                    iArr[i10] = f(127, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 128) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 43 : 0) + 127 + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + 127 + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + 127 + ((i10 & 64) == 0 ? 0 : 85));
                } else if (i11 == 136) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 43 : 0) + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + ((i10 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0203 A[LOOP:3: B:86:0x0156->B:98:0x0203, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ff A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(byte[] r21, int[] r22, int r23, int r24, int r25, android.graphics.Paint r26, android.graphics.Canvas r27) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.h.g(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static a h(i3.f fVar, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = 8;
        int i17 = fVar.i(8);
        fVar.t(8);
        int i18 = 2;
        int i19 = i10 - 2;
        int i20 = 0;
        int[] iArr = {0, -1, -16777216, -8421505};
        int[] c10 = c();
        int[] e7 = e();
        while (i19 > 0) {
            int i21 = fVar.i(i16);
            int i22 = fVar.i(i16);
            int[] iArr2 = (i22 & 128) != 0 ? iArr : (i22 & 64) != 0 ? c10 : e7;
            if ((i22 & 1) != 0) {
                i14 = fVar.i(i16);
                i15 = fVar.i(i16);
                i11 = fVar.i(i16);
                i13 = fVar.i(i16);
                i12 = i19 - 6;
            } else {
                int i23 = fVar.i(6) << i18;
                int i24 = fVar.i(4) << 4;
                i11 = fVar.i(4) << 4;
                i12 = i19 - 4;
                i13 = fVar.i(i18) << 6;
                i14 = i23;
                i15 = i24;
            }
            if (i14 == 0) {
                i15 = i20;
                i11 = i15;
                i13 = 255;
            }
            double d6 = i14;
            double d10 = i15 - 128;
            double d11 = i11 - 128;
            iArr2[i21] = f((byte) (255 - (i13 & 255)), a0.i((int) ((1.402d * d10) + d6), 0, 255), a0.i((int) ((d6 - (0.34414d * d11)) - (d10 * 0.71414d)), 0, 255), a0.i((int) ((d11 * 1.772d) + d6), 0, 255));
            i19 = i12;
            i20 = 0;
            i17 = i17;
            e7 = e7;
            i16 = 8;
            i18 = 2;
        }
        return new a(i17, iArr, c10, e7);
    }

    public static c i(i3.f fVar) {
        byte[] bArr;
        int i10 = fVar.i(16);
        fVar.t(4);
        int i11 = fVar.i(2);
        boolean h10 = fVar.h();
        fVar.t(1);
        byte[] bArr2 = a0.f8069c;
        if (i11 == 1) {
            fVar.t(fVar.i(8) * 16);
        } else if (i11 == 0) {
            int i12 = fVar.i(16);
            int i13 = fVar.i(16);
            if (i12 > 0) {
                bArr2 = new byte[i12];
                fVar.l(i12, bArr2);
            }
            if (i13 > 0) {
                bArr = new byte[i13];
                fVar.l(i13, bArr);
                return new c(i10, h10, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(i10, h10, bArr2, bArr);
    }

    @Override // h3.k
    public final /* synthetic */ h3.e b(byte[] bArr, int i10, int i11) {
        return android.support.v4.media.d.a(this, bArr, i11);
    }

    @Override // h3.k
    public final void d(byte[] bArr, int i10, int i11, j jVar, l1.h hVar) {
        g gVar;
        boolean z10;
        h3.a aVar;
        char c10;
        char c11;
        char c12;
        int i12;
        ArrayList arrayList;
        int i13;
        b bVar;
        g gVar2;
        e eVar;
        int i14;
        int i15;
        int i16;
        int i17;
        e eVar2;
        int i18;
        int i19;
        int i20;
        int i21;
        i3.f fVar = new i3.f(i10 + i11, bArr);
        fVar.q(i10);
        while (true) {
            int b2 = fVar.b();
            gVar = this.f7104t;
            z10 = true;
            if (b2 >= 48 && fVar.i(8) == 15) {
                int i22 = fVar.i(8);
                int i23 = fVar.i(16);
                int i24 = fVar.i(16);
                int f10 = fVar.f() + i24;
                if (i24 * 8 > fVar.b()) {
                    l1.b.q("DvbParser", "Data field length exceeds limit");
                    fVar.t(fVar.b());
                } else {
                    switch (i22) {
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                            if (i23 == gVar.f7088a) {
                                w0 w0Var = gVar.f7095i;
                                fVar.i(8);
                                int i25 = fVar.i(4);
                                int i26 = fVar.i(2);
                                fVar.t(2);
                                int i27 = i24 - 2;
                                SparseArray sparseArray = new SparseArray();
                                while (i27 > 0) {
                                    int i28 = fVar.i(8);
                                    fVar.t(8);
                                    i27 -= 6;
                                    sparseArray.put(i28, new d(fVar.i(16), fVar.i(16)));
                                }
                                w0 w0Var2 = new w0();
                                w0Var2.f1087o = i25;
                                w0Var2.f1088p = i26;
                                w0Var2.f1089q = sparseArray;
                                if (i26 != 0) {
                                    gVar.f7095i = w0Var2;
                                    gVar.f7090c.clear();
                                    gVar.f7091d.clear();
                                    gVar.f7092e.clear();
                                    break;
                                } else if (w0Var != null && w0Var.f1087o != i25) {
                                    gVar.f7095i = w0Var2;
                                    break;
                                }
                            }
                            break;
                        case 17:
                            w0 w0Var3 = gVar.f7095i;
                            SparseArray sparseArray2 = gVar.f7090c;
                            if (i23 == gVar.f7088a && w0Var3 != null) {
                                int i29 = fVar.i(8);
                                fVar.t(4);
                                boolean h10 = fVar.h();
                                fVar.t(3);
                                int i30 = fVar.i(16);
                                int i31 = fVar.i(16);
                                fVar.i(3);
                                int i32 = fVar.i(3);
                                fVar.t(2);
                                int i33 = fVar.i(8);
                                int i34 = fVar.i(8);
                                int i35 = fVar.i(4);
                                int i36 = fVar.i(2);
                                fVar.t(2);
                                int i37 = i24 - 10;
                                SparseArray sparseArray3 = new SparseArray();
                                while (i37 > 0) {
                                    int i38 = fVar.i(16);
                                    int i39 = fVar.i(2);
                                    fVar.i(2);
                                    int i40 = fVar.i(12);
                                    fVar.t(4);
                                    int i41 = fVar.i(12);
                                    int i42 = i37 - 6;
                                    if (i39 == 1 || i39 == 2) {
                                        fVar.i(8);
                                        fVar.i(8);
                                        i37 -= 8;
                                    } else {
                                        i37 = i42;
                                    }
                                    sparseArray3.put(i38, new f(i40, i41));
                                }
                                e eVar3 = new e(i29, h10, i30, i31, i32, i33, i34, i35, i36, sparseArray3);
                                if (w0Var3.f1088p == 0 && (eVar2 = (e) sparseArray2.get(i29)) != null) {
                                    SparseArray sparseArray4 = eVar2.f7085j;
                                    for (int i43 = 0; i43 < sparseArray4.size(); i43++) {
                                        eVar3.f7085j.put(sparseArray4.keyAt(i43), (f) sparseArray4.valueAt(i43));
                                    }
                                }
                                sparseArray2.put(eVar3.f7077a, eVar3);
                                break;
                            }
                            break;
                        case 18:
                            if (i23 == gVar.f7088a) {
                                a h11 = h(fVar, i24);
                                gVar.f7091d.put(h11.f7061a, h11);
                                break;
                            } else if (i23 == gVar.f7089b) {
                                a h12 = h(fVar, i24);
                                gVar.f7093f.put(h12.f7061a, h12);
                                break;
                            }
                            break;
                        case 19:
                            if (i23 == gVar.f7088a) {
                                c i44 = i(fVar);
                                gVar.f7092e.put(i44.f7071a, i44);
                                break;
                            } else if (i23 == gVar.f7089b) {
                                c i45 = i(fVar);
                                gVar.g.put(i45.f7071a, i45);
                                break;
                            }
                            break;
                        case 20:
                            if (i23 == gVar.f7088a) {
                                fVar.t(4);
                                boolean h13 = fVar.h();
                                fVar.t(3);
                                int i46 = fVar.i(16);
                                int i47 = fVar.i(16);
                                if (h13) {
                                    int i48 = fVar.i(16);
                                    i18 = fVar.i(16);
                                    i21 = fVar.i(16);
                                    i19 = fVar.i(16);
                                    i20 = i48;
                                } else {
                                    i18 = i46;
                                    i19 = i47;
                                    i20 = 0;
                                    i21 = 0;
                                }
                                gVar.f7094h = new b(i46, i47, i20, i18, i21, i19);
                                break;
                            }
                            break;
                    }
                    fVar.u(f10 - fVar.f());
                }
            }
        }
        w0 w0Var4 = gVar.f7095i;
        if (w0Var4 == null) {
            e0 e0Var = g0.f9617p;
            aVar = new h3.a(-9223372036854775807L, -9223372036854775807L, o9.w0.f9686s);
        } else {
            b bVar2 = gVar.f7094h;
            if (bVar2 == null) {
                bVar2 = this.f7102r;
            }
            Bitmap bitmap = this.f7105u;
            Canvas canvas = this.f7101q;
            if (bitmap == null || bVar2.f7065a + 1 != bitmap.getWidth() || bVar2.f7066b + 1 != this.f7105u.getHeight()) {
                Bitmap createBitmap = Bitmap.createBitmap(bVar2.f7065a + 1, bVar2.f7066b + 1, Bitmap.Config.ARGB_8888);
                this.f7105u = createBitmap;
                canvas.setBitmap(createBitmap);
            }
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray5 = (SparseArray) w0Var4.f1089q;
            int i49 = 0;
            while (i49 < sparseArray5.size()) {
                canvas.save();
                d dVar = (d) sparseArray5.valueAt(i49);
                e eVar4 = (e) gVar.f7090c.get(sparseArray5.keyAt(i49));
                int i50 = dVar.f7075a + bVar2.f7067c;
                int i51 = dVar.f7076b + bVar2.f7069e;
                int i52 = eVar4.f7079c;
                int i53 = eVar4.f7082f;
                int i54 = eVar4.f7080d;
                boolean z11 = z10;
                int i55 = i50 + i52;
                int i56 = i51 + i54;
                SparseArray sparseArray6 = sparseArray5;
                canvas.clipRect(i50, i51, Math.min(i55, bVar2.f7068d), Math.min(i56, bVar2.f7070f));
                a aVar2 = (a) gVar.f7091d.get(i53);
                if (aVar2 == null && (aVar2 = (a) gVar.f7093f.get(i53)) == null) {
                    aVar2 = this.f7103s;
                }
                SparseArray sparseArray7 = eVar4.f7085j;
                int i57 = i49;
                int i58 = 0;
                while (i58 < sparseArray7.size()) {
                    int keyAt = sparseArray7.keyAt(i58);
                    SparseArray sparseArray8 = sparseArray7;
                    f fVar2 = (f) sparseArray7.valueAt(i58);
                    int i59 = i51;
                    c cVar = (c) gVar.f7092e.get(keyAt);
                    if (cVar == null) {
                        cVar = (c) gVar.g.get(keyAt);
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        Paint paint = cVar2.f7072b ? null : this.f7099o;
                        int i60 = i50;
                        int i61 = eVar4.f7081e;
                        gVar2 = gVar;
                        int i62 = i60 + fVar2.f7086a;
                        int i63 = i59 + fVar2.f7087b;
                        int i64 = i54;
                        Paint paint2 = paint;
                        bVar = bVar2;
                        i15 = i52;
                        i14 = i60;
                        arrayList = arrayList2;
                        i13 = i59;
                        e eVar5 = eVar4;
                        int[] iArr = i61 == 3 ? aVar2.f7064d : i61 == 2 ? aVar2.f7063c : aVar2.f7062b;
                        eVar = eVar5;
                        i16 = i58;
                        i17 = i64;
                        g(cVar2.f7073c, iArr, i61, i62, i63, paint2, canvas);
                        g(cVar2.f7074d, iArr, i61, i62, i63 + 1, paint2, canvas);
                    } else {
                        arrayList = arrayList2;
                        i13 = i59;
                        bVar = bVar2;
                        gVar2 = gVar;
                        eVar = eVar4;
                        i14 = i50;
                        i15 = i52;
                        i16 = i58;
                        i17 = i54;
                    }
                    i58 = i16 + 1;
                    i52 = i15;
                    i51 = i13;
                    eVar4 = eVar;
                    i50 = i14;
                    arrayList2 = arrayList;
                    sparseArray7 = sparseArray8;
                    bVar2 = bVar;
                    gVar = gVar2;
                    i54 = i17;
                }
                b bVar3 = bVar2;
                ArrayList arrayList3 = arrayList2;
                g gVar3 = gVar;
                int i65 = i51;
                e eVar6 = eVar4;
                int i66 = i50;
                int i67 = i52;
                int i68 = i54;
                if (eVar6.f7078b) {
                    int i69 = eVar6.f7081e;
                    if (i69 == 3) {
                        i12 = aVar2.f7064d[eVar6.g];
                        c12 = 2;
                    } else {
                        c12 = 2;
                        i12 = i69 == 2 ? aVar2.f7063c[eVar6.f7083h] : aVar2.f7062b[eVar6.f7084i];
                    }
                    Paint paint3 = this.f7100p;
                    paint3.setColor(i12);
                    c10 = c12;
                    c11 = 3;
                    canvas.drawRect(i66, i65, i55, i56, paint3);
                } else {
                    c10 = 2;
                    c11 = 3;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(this.f7105u, i66, i65, i67, i68);
                float f11 = bVar3.f7065a;
                float f12 = bVar3.f7066b;
                arrayList3.add(new k1.b(null, null, null, createBitmap2, i65 / f12, 0, 0, i66 / f11, 0, Integer.MIN_VALUE, -3.4028235E38f, i67 / f11, i68 / f12, false, -16777216, Integer.MIN_VALUE, 0.0f, 0));
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i49 = i57 + 1;
                z10 = z11;
                bVar2 = bVar3;
                arrayList2 = arrayList3;
                gVar = gVar3;
                sparseArray5 = sparseArray6;
            }
            aVar = new h3.a(-9223372036854775807L, -9223372036854775807L, arrayList2);
        }
        hVar.accept(aVar);
    }

    @Override // h3.k
    public final void reset() {
        g gVar = this.f7104t;
        gVar.f7090c.clear();
        gVar.f7091d.clear();
        gVar.f7092e.clear();
        gVar.f7093f.clear();
        gVar.g.clear();
        gVar.f7094h = null;
        gVar.f7095i = null;
    }
}
