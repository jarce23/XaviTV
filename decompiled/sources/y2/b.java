package y2;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends j {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f13768b;

    public b(String str, byte[] bArr) {
        super(str);
        this.f13768b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f13791a.equals(bVar.f13791a) && Arrays.equals(this.f13768b, bVar.f13768b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f13768b) + android.support.v4.media.d.g(this.f13791a, 527, 31);
    }
}
