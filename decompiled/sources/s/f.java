package s;

import java.util.Arrays;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements Comparable {

    /* renamed from: o, reason: collision with root package name */
    public boolean f11130o;

    /* renamed from: s, reason: collision with root package name */
    public float f11134s;

    /* renamed from: z, reason: collision with root package name */
    public int f11141z;

    /* renamed from: p, reason: collision with root package name */
    public int f11131p = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f11132q = -1;

    /* renamed from: r, reason: collision with root package name */
    public int f11133r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f11135t = false;

    /* renamed from: u, reason: collision with root package name */
    public final float[] f11136u = new float[9];

    /* renamed from: v, reason: collision with root package name */
    public final float[] f11137v = new float[9];

    /* renamed from: w, reason: collision with root package name */
    public b[] f11138w = new b[16];

    /* renamed from: x, reason: collision with root package name */
    public int f11139x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f11140y = 0;

    public f(int i10) {
        this.f11141z = i10;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f11139x;
            if (i10 >= i11) {
                b[] bVarArr = this.f11138w;
                if (i11 >= bVarArr.length) {
                    this.f11138w = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f11138w;
                int i12 = this.f11139x;
                bVarArr2[i12] = bVar;
                this.f11139x = i12 + 1;
                return;
            }
            if (this.f11138w[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void b(b bVar) {
        int i10 = this.f11139x;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f11138w[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f11138w;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f11139x--;
                return;
            }
            i11++;
        }
    }

    public final void c() {
        this.f11141z = 5;
        this.f11133r = 0;
        this.f11131p = -1;
        this.f11132q = -1;
        this.f11134s = 0.0f;
        this.f11135t = false;
        int i10 = this.f11139x;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11138w[i11] = null;
        }
        this.f11139x = 0;
        this.f11140y = 0;
        this.f11130o = false;
        Arrays.fill(this.f11137v, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f11131p - ((f) obj).f11131p;
    }

    public final void d(c cVar, float f10) {
        this.f11134s = f10;
        this.f11135t = true;
        int i10 = this.f11139x;
        this.f11132q = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11138w[i11].h(cVar, this, false);
        }
        this.f11139x = 0;
    }

    public final void e(c cVar, b bVar) {
        int i10 = this.f11139x;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11138w[i11].i(cVar, bVar, false);
        }
        this.f11139x = 0;
    }

    public final String toString() {
        return _UrlKt.FRAGMENT_ENCODE_SET + this.f11131p;
    }
}
