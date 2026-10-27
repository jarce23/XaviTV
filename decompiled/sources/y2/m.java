package y2;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends j {

    /* renamed from: b, reason: collision with root package name */
    public final int f13796b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13797c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13798d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f13799e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f13800f;

    public m(int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f13796b = i10;
        this.f13797c = i11;
        this.f13798d = i12;
        this.f13799e = iArr;
        this.f13800f = iArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (this.f13796b == mVar.f13796b && this.f13797c == mVar.f13797c && this.f13798d == mVar.f13798d && Arrays.equals(this.f13799e, mVar.f13799e) && Arrays.equals(this.f13800f, mVar.f13800f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f13800f) + ((Arrays.hashCode(this.f13799e) + ((((((527 + this.f13796b) * 31) + this.f13797c) * 31) + this.f13798d) * 31)) * 31);
    }
}
