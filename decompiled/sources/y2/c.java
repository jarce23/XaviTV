package y2;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13769b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13770c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13771d;

    /* renamed from: e, reason: collision with root package name */
    public final long f13772e;

    /* renamed from: f, reason: collision with root package name */
    public final long f13773f;
    public final j[] g;

    public c(String str, int i10, int i11, long j10, long j11, j[] jVarArr) {
        super("CHAP");
        this.f13769b = str;
        this.f13770c = i10;
        this.f13771d = i11;
        this.f13772e = j10;
        this.f13773f = j11;
        this.g = jVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f13770c == cVar.f13770c && this.f13771d == cVar.f13771d && this.f13772e == cVar.f13772e && this.f13773f == cVar.f13773f && Objects.equals(this.f13769b, cVar.f13769b) && Arrays.equals(this.g, cVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = (((((((527 + this.f13770c) * 31) + this.f13771d) * 31) + ((int) this.f13772e)) * 31) + ((int) this.f13773f)) * 31;
        String str = this.f13769b;
        return i10 + (str != null ? str.hashCode() : 0);
    }
}
