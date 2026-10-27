package w9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements t9.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13160a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13161b = false;

    /* renamed from: c, reason: collision with root package name */
    public t9.c f13162c;

    /* renamed from: d, reason: collision with root package name */
    public final e f13163d;

    public g(e eVar) {
        this.f13163d = eVar;
    }

    @Override // t9.g
    public final t9.g b(String str) {
        if (this.f13160a) {
            throw new t9.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f13160a = true;
        this.f13163d.c(this.f13162c, str, this.f13161b);
        return this;
    }

    @Override // t9.g
    public final t9.g c(boolean z10) {
        if (this.f13160a) {
            throw new t9.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f13160a = true;
        this.f13163d.b(this.f13162c, z10 ? 1 : 0, this.f13161b);
        return this;
    }
}
