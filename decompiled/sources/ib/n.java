package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends za.i implements ya.p {

    /* renamed from: q, reason: collision with root package name */
    public static final n f6577q;

    /* renamed from: r, reason: collision with root package name */
    public static final n f6578r;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f6579p;

    static {
        int i10 = 2;
        f6577q = new n(i10, 0);
        f6578r = new n(i10, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(int i10, int i11) {
        super(i10);
        this.f6579p = i11;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        switch (this.f6579p) {
            case 0:
                return ((pa.i) obj).K((pa.g) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            default:
                return ((pa.i) obj).K((pa.g) obj2);
        }
    }
}
