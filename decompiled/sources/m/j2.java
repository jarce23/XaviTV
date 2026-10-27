package m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j2 {

    /* renamed from: a, reason: collision with root package name */
    public int f8443a;

    /* renamed from: b, reason: collision with root package name */
    public int f8444b;

    /* renamed from: c, reason: collision with root package name */
    public int f8445c;

    /* renamed from: d, reason: collision with root package name */
    public int f8446d;

    /* renamed from: e, reason: collision with root package name */
    public int f8447e;

    /* renamed from: f, reason: collision with root package name */
    public int f8448f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8449h;

    public final void a(int i10, int i11) {
        this.f8445c = i10;
        this.f8446d = i11;
        this.f8449h = true;
        if (this.g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f8443a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f8444b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f8443a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f8444b = i11;
        }
    }
}
