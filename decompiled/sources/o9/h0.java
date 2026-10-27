package o9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9618a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9619b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9620c;

    public h0(Object obj, Object obj2, Object obj3) {
        this.f9618a = obj;
        this.f9619b = obj2;
        this.f9620c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb2 = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f9618a;
        sb2.append(obj);
        sb2.append("=");
        sb2.append(this.f9619b);
        sb2.append(" and ");
        sb2.append(obj);
        sb2.append("=");
        sb2.append(this.f9620c);
        return new IllegalArgumentException(sb2.toString());
    }
}
