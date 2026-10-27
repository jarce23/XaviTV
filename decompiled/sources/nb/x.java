package nb;

import ib.e1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends za.i implements ya.p {

    /* renamed from: q, reason: collision with root package name */
    public static final x f9347q;

    /* renamed from: r, reason: collision with root package name */
    public static final x f9348r;

    /* renamed from: s, reason: collision with root package name */
    public static final x f9349s;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f9350p;

    static {
        int i10 = 2;
        f9347q = new x(i10, 0);
        f9348r = new x(i10, 1);
        f9349s = new x(i10, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(int i10, int i11) {
        super(i10);
        this.f9350p = i11;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        switch (this.f9350p) {
            case 0:
                pa.g gVar = (pa.g) obj2;
                if (!(gVar instanceof e1)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? gVar : Integer.valueOf(intValue + 1);
            case 1:
                e1 e1Var = (e1) obj;
                pa.g gVar2 = (pa.g) obj2;
                if (e1Var != null) {
                    return e1Var;
                }
                if (gVar2 instanceof e1) {
                    return (e1) gVar2;
                }
                return null;
            default:
                return (z) obj;
        }
    }
}
