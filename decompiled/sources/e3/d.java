package e3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4425a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4426b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4427c;

    public u1.f a() {
        if (this.f4425a || !(this.f4426b || this.f4427c)) {
            return new u1.f(this);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }

    public boolean b() {
        return (this.f4427c || this.f4426b) && this.f4425a;
    }
}
