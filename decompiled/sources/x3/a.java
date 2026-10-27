package x3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f13502a;

    /* renamed from: b, reason: collision with root package name */
    public int f13503b;

    /* renamed from: c, reason: collision with root package name */
    public int f13504c;

    /* renamed from: d, reason: collision with root package name */
    public int f13505d;

    /* renamed from: e, reason: collision with root package name */
    public int f13506e;

    /* renamed from: f, reason: collision with root package name */
    public int f13507f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f13508h;

    /* renamed from: i, reason: collision with root package name */
    public int f13509i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b f13510j;

    public a(b bVar, int i10, int i11) {
        this.f13510j = bVar;
        this.f13502a = i10;
        this.f13503b = i11;
        a();
    }

    public final void a() {
        b bVar = this.f13510j;
        int[] iArr = (int[]) bVar.f13512a;
        int[] iArr2 = (int[]) bVar.f13513b;
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MIN_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = Integer.MAX_VALUE;
        int i16 = Integer.MIN_VALUE;
        for (int i17 = this.f13502a; i17 <= this.f13503b; i17++) {
            int i18 = iArr[i17];
            i13 += iArr2[i18];
            int i19 = (i18 >> 10) & 31;
            int i20 = (i18 >> 5) & 31;
            int i21 = i18 & 31;
            if (i19 > i16) {
                i16 = i19;
            }
            if (i19 < i10) {
                i10 = i19;
            }
            if (i20 > i11) {
                i11 = i20;
            }
            if (i20 < i14) {
                i14 = i20;
            }
            if (i21 > i12) {
                i12 = i21;
            }
            if (i21 < i15) {
                i15 = i21;
            }
        }
        this.f13505d = i10;
        this.f13506e = i16;
        this.f13507f = i14;
        this.g = i11;
        this.f13508h = i15;
        this.f13509i = i12;
        this.f13504c = i13;
    }

    public final int b() {
        return ((this.f13509i - this.f13508h) + 1) * ((this.g - this.f13507f) + 1) * ((this.f13506e - this.f13505d) + 1);
    }
}
