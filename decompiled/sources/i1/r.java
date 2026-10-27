package i1;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    public static final String f6008c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f6009d;

    /* renamed from: a, reason: collision with root package name */
    public final String f6010a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6011b;

    static {
        int i10 = l1.a0.f8067a;
        f6008c = Integer.toString(0, 36);
        f6009d = Integer.toString(1, 36);
    }

    public r(String str, String str2) {
        this.f6010a = l1.a0.P(str);
        this.f6011b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && r.class == obj.getClass()) {
            r rVar = (r) obj;
            if (Objects.equals(this.f6010a, rVar.f6010a) && Objects.equals(this.f6011b, rVar.f6011b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f6011b.hashCode() * 31;
        String str = this.f6010a;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
