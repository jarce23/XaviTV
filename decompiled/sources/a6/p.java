package a6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    public static final p f84b = new p(2);

    /* renamed from: c, reason: collision with root package name */
    public static final p f85c = new p(0);

    /* renamed from: d, reason: collision with root package name */
    public static final p f86d;

    /* renamed from: e, reason: collision with root package name */
    public static final p f87e;

    /* renamed from: f, reason: collision with root package name */
    public static final p f88f;
    public static final r5.g g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f89h;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f90a;

    static {
        p pVar = new p(1);
        f86d = pVar;
        f87e = new p(3);
        f88f = pVar;
        g = r5.g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", pVar);
        f89h = true;
    }

    public /* synthetic */ p(int i10) {
        this.f90a = i10;
    }

    public final int a(int i10, int i11, int i12, int i13) {
        switch (this.f90a) {
            case 0:
                if (b(i10, i11, i12, i13) != 1.0f) {
                    break;
                }
                break;
            case 2:
                if (f89h) {
                }
                break;
        }
        return 2;
    }

    public final float b(int i10, int i11, int i12, int i13) {
        switch (this.f90a) {
            case 0:
                return Math.min(1.0f, f84b.b(i10, i11, i12, i13));
            case 1:
                return Math.max(i12 / i10, i13 / i11);
            case 2:
                if (f89h) {
                    return Math.min(i12 / i10, i13 / i11);
                }
                if (Math.max(i11 / i13, i10 / i12) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
