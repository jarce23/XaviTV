package y2;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13801b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f13802c;

    public n(String str, byte[] bArr) {
        super("PRIV");
        this.f13801b = str;
        this.f13802c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            if (Objects.equals(this.f13801b, nVar.f13801b) && Arrays.equals(this.f13802c, nVar.f13802c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f13801b;
        return Arrays.hashCode(this.f13802c) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // y2.j
    public final String toString() {
        return this.f13791a + ": owner=" + this.f13801b;
    }
}
