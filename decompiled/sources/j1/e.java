package j1;

import java.util.Objects;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final e f6950e = new e(-1, -1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final int f6951a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6952b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6953c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6954d;

    public e(int i10, int i11, int i12) {
        this.f6951a = i10;
        this.f6952b = i11;
        this.f6953c = i12;
        this.f6954d = a0.K(i12) ? a0.s(i12) * i11 : -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6951a == eVar.f6951a && this.f6952b == eVar.f6952b && this.f6953c == eVar.f6953c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6951a), Integer.valueOf(this.f6952b), Integer.valueOf(this.f6953c));
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.f6951a + ", channelCount=" + this.f6952b + ", encoding=" + this.f6953c + ']';
    }
}
