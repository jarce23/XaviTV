package androidx.emoji2.text;

import android.graphics.Bitmap;
import android.media.VolumeProvider;
import android.os.Build;
import android.util.SparseBooleanArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public int f596a;

    /* renamed from: b, reason: collision with root package name */
    public int f597b;

    /* renamed from: c, reason: collision with root package name */
    public int f598c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f599d;

    /* renamed from: e, reason: collision with root package name */
    public Object f600e;

    /* renamed from: f, reason: collision with root package name */
    public Object f601f;

    public t(x4.m mVar, int i10, int i11, int i12, String str) {
        this.f601f = mVar;
        this.f596a = i10;
        this.f597b = i11;
        this.f598c = i12;
        this.f599d = str;
    }

    public x3.b a() {
        int max;
        x3.b bVar;
        ArrayList arrayList = (ArrayList) this.f601f;
        Bitmap bitmap = (Bitmap) this.f599d;
        if (bitmap == null) {
            throw new AssertionError();
        }
        int i10 = this.f598c;
        int i11 = this.f597b;
        double d6 = -1.0d;
        if (i11 > 0) {
            int height = bitmap.getHeight() * bitmap.getWidth();
            if (height > i11) {
                d6 = Math.sqrt(i11 / height);
            }
        } else if (i10 > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > i10) {
            d6 = i10 / max;
        }
        int i12 = 0;
        Bitmap createScaledBitmap = d6 <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d6), (int) Math.ceil(bitmap.getHeight() * d6), false);
        int width = createScaledBitmap.getWidth();
        int height2 = createScaledBitmap.getHeight();
        int[] iArr = new int[width * height2];
        createScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height2);
        x3.b bVar2 = new x3.b(iArr, this.f596a, arrayList.isEmpty() ? null : (x3.c[]) arrayList.toArray(new x3.c[arrayList.size()]));
        if (createScaledBitmap != bitmap) {
            createScaledBitmap.recycle();
        }
        ArrayList arrayList2 = (ArrayList) bVar2.f13514c;
        ArrayList arrayList3 = (ArrayList) this.f600e;
        x3.b bVar3 = new x3.b(arrayList2, arrayList3);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) bVar3.f13515d;
        int size = arrayList3.size();
        int i13 = 0;
        while (i13 < size) {
            x3.e eVar = (x3.e) arrayList3.get(i13);
            float[] fArr = eVar.f13532c;
            float[] fArr2 = eVar.f13530a;
            int length = fArr.length;
            float f10 = 0.0f;
            float f11 = 0.0f;
            for (int i14 = i12; i14 < length; i14++) {
                float f12 = fArr[i14];
                if (f12 > 0.0f) {
                    f11 += f12;
                }
            }
            if (f11 != 0.0f) {
                int length2 = fArr.length;
                for (int i15 = i12; i15 < length2; i15++) {
                    float f13 = fArr[i15];
                    if (f13 > 0.0f) {
                        fArr[i15] = f13 / f11;
                    }
                }
            }
            p.e eVar2 = (p.e) bVar3.f13514c;
            List list = (List) bVar3.f13512a;
            int size2 = list.size();
            int i16 = i12;
            float f14 = 0.0f;
            x3.d dVar = null;
            while (i16 < size2) {
                x3.d dVar2 = (x3.d) list.get(i16);
                float[] b2 = dVar2.b();
                float f15 = b2[1];
                float f16 = f10;
                float[] fArr3 = eVar.f13531b;
                if (f15 >= fArr2[i16] && f15 <= fArr2[2]) {
                    float f17 = b2[2];
                    if (f17 >= fArr3[i16] && f17 <= fArr3[2] && !sparseBooleanArray.get(dVar2.f13520d)) {
                        float[] b10 = dVar2.b();
                        x3.d dVar3 = (x3.d) bVar3.f13516e;
                        int i17 = dVar3 != null ? dVar3.f13521e : 1;
                        bVar = bVar3;
                        float[] fArr4 = eVar.f13532c;
                        float f18 = fArr4[i16];
                        float abs = f18 > f16 ? (1.0f - Math.abs(b10[1] - fArr2[1])) * f18 : f16;
                        float f19 = fArr4[1];
                        float abs2 = f19 > f16 ? (1.0f - Math.abs(b10[2] - fArr3[1])) * f19 : f16;
                        float f20 = fArr4[2];
                        float f21 = abs + abs2 + (f20 > f16 ? (dVar2.f13521e / i17) * f20 : f16);
                        if (dVar == null || f21 > f14) {
                            dVar = dVar2;
                            f14 = f21;
                        }
                        i16++;
                        bVar3 = bVar;
                        f10 = f16;
                    }
                }
                bVar = bVar3;
                i16++;
                bVar3 = bVar;
                f10 = f16;
            }
            x3.b bVar4 = bVar3;
            if (dVar != null) {
                sparseBooleanArray.append(dVar.f13520d, true);
            }
            eVar2.put(eVar, dVar);
            i13++;
            i12 = i16;
            bVar3 = bVar4;
        }
        x3.b bVar5 = bVar3;
        sparseBooleanArray.clear();
        return bVar5;
    }

    public VolumeProvider b() {
        t tVar;
        if (((VolumeProvider) this.f600e) != null) {
            tVar = this;
        } else if (Build.VERSION.SDK_INT >= 30) {
            tVar = this;
            tVar.f600e = new f1.d(tVar, this.f596a, this.f597b, this.f598c, (String) this.f599d);
        } else {
            tVar = this;
            tVar.f600e = new f1.e(this, tVar.f596a, tVar.f597b, tVar.f598c);
        }
        return (VolumeProvider) tVar.f600e;
    }

    public void c() {
        this.f596a = 1;
        this.f600e = (w) this.f599d;
        this.f598c = 0;
    }

    public boolean d() {
        u0.a b2 = ((w) this.f600e).f612b.b();
        int a10 = b2.a(6);
        return !(a10 == 0 || ((ByteBuffer) b2.f8748r).get(a10 + b2.f8745o) == 0) || this.f597b == 65039;
    }

    public t(Bitmap bitmap) {
        ArrayList arrayList = new ArrayList();
        this.f600e = arrayList;
        this.f596a = 16;
        this.f597b = 12544;
        this.f598c = -1;
        ArrayList arrayList2 = new ArrayList();
        this.f601f = arrayList2;
        if (!bitmap.isRecycled()) {
            arrayList2.add(x3.b.g);
            this.f599d = bitmap;
            arrayList.add(x3.e.f13525d);
            arrayList.add(x3.e.f13526e);
            arrayList.add(x3.e.f13527f);
            arrayList.add(x3.e.g);
            arrayList.add(x3.e.f13528h);
            arrayList.add(x3.e.f13529i);
            return;
        }
        throw new IllegalArgumentException("Bitmap is not valid");
    }

    public t(w wVar) {
        this.f596a = 1;
        this.f599d = wVar;
        this.f600e = wVar;
    }
}
