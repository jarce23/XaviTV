package y2;

import i1.c0;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13764b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13765c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13766d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f13767e;

    public a(String str, String str2, int i10, byte[] bArr) {
        super("APIC");
        this.f13764b = str;
        this.f13765c = str2;
        this.f13766d = i10;
        this.f13767e = bArr;
    }

    @Override // y2.j, i1.e0
    public final void c(c0 c0Var) {
        c0Var.a(this.f13766d, this.f13767e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f13766d == aVar.f13766d && Objects.equals(this.f13764b, aVar.f13764b) && Objects.equals(this.f13765c, aVar.f13765c) && Arrays.equals(this.f13767e, aVar.f13767e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = (527 + this.f13766d) * 31;
        String str = this.f13764b;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13765c;
        return Arrays.hashCode(this.f13767e) + ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // y2.j
    public final String toString() {
        return this.f13791a + ": mimeType=" + this.f13764b + ", description=" + this.f13765c;
    }
}
