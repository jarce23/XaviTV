package x;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int[] f13229a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f13230b;

    /* renamed from: c, reason: collision with root package name */
    public int f13231c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f13232d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f13233e;

    /* renamed from: f, reason: collision with root package name */
    public int f13234f;
    public int[] g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f13235h;

    /* renamed from: i, reason: collision with root package name */
    public int f13236i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f13237j;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f13238k;

    /* renamed from: l, reason: collision with root package name */
    public int f13239l;

    public final void a(int i10, float f10) {
        int i11 = this.f13234f;
        int[] iArr = this.f13232d;
        if (i11 >= iArr.length) {
            this.f13232d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f13233e;
            this.f13233e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f13232d;
        int i12 = this.f13234f;
        iArr2[i12] = i10;
        float[] fArr2 = this.f13233e;
        this.f13234f = i12 + 1;
        fArr2[i12] = f10;
    }

    public final void b(int i10, int i11) {
        int i12 = this.f13231c;
        int[] iArr = this.f13229a;
        if (i12 >= iArr.length) {
            this.f13229a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f13230b;
            this.f13230b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f13229a;
        int i13 = this.f13231c;
        iArr3[i13] = i10;
        int[] iArr4 = this.f13230b;
        this.f13231c = i13 + 1;
        iArr4[i13] = i11;
    }

    public final void c(int i10, String str) {
        int i11 = this.f13236i;
        int[] iArr = this.g;
        if (i11 >= iArr.length) {
            this.g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f13235h;
            this.f13235h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.g;
        int i12 = this.f13236i;
        iArr2[i12] = i10;
        String[] strArr2 = this.f13235h;
        this.f13236i = i12 + 1;
        strArr2[i12] = str;
    }

    public final void d(int i10, boolean z10) {
        int i11 = this.f13239l;
        int[] iArr = this.f13237j;
        if (i11 >= iArr.length) {
            this.f13237j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f13238k;
            this.f13238k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f13237j;
        int i12 = this.f13239l;
        iArr2[i12] = i10;
        boolean[] zArr2 = this.f13238k;
        this.f13239l = i12 + 1;
        zArr2[i12] = z10;
    }
}
