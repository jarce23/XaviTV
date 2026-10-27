package y2;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13774b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13775c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13776d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f13777e;

    /* renamed from: f, reason: collision with root package name */
    public final j[] f13778f;

    public d(String str, boolean z10, boolean z11, String[] strArr, j[] jVarArr) {
        super("CTOC");
        this.f13774b = str;
        this.f13775c = z10;
        this.f13776d = z11;
        this.f13777e = strArr;
        this.f13778f = jVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f13775c == dVar.f13775c && this.f13776d == dVar.f13776d && Objects.equals(this.f13774b, dVar.f13774b) && Arrays.equals(this.f13777e, dVar.f13777e) && Arrays.equals(this.f13778f, dVar.f13778f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = (((527 + (this.f13775c ? 1 : 0)) * 31) + (this.f13776d ? 1 : 0)) * 31;
        String str = this.f13774b;
        return i10 + (str != null ? str.hashCode() : 0);
    }
}
