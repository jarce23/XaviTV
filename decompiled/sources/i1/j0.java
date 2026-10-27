package i1;

import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: d, reason: collision with root package name */
    public static final j0 f5905d = new j0(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f5906a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5907b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5908c;

    static {
        l1.a0.J(0);
        l1.a0.J(1);
    }

    public j0(float f10, float f11) {
        l1.d.b(f10 > 0.0f);
        l1.d.b(f11 > 0.0f);
        this.f5906a = f10;
        this.f5907b = f11;
        this.f5908c = Math.round(f10 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j0.class == obj.getClass()) {
            j0 j0Var = (j0) obj;
            if (this.f5906a == j0Var.f5906a && this.f5907b == j0Var.f5907b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f5907b) + ((Float.floatToRawIntBits(this.f5906a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.f5906a), Float.valueOf(this.f5907b)};
        int i10 = l1.a0.f8067a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }
}
