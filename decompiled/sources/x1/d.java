package x1;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f13355a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13356b;

    /* renamed from: c, reason: collision with root package name */
    public final double f13357c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13358d;

    public d(String str, double d6) {
        this.f13355a = str;
        this.f13356b = 2;
        this.f13357c = d6;
        this.f13358d = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f13356b == dVar.f13356b && Double.compare(this.f13357c, dVar.f13357c) == 0 && Objects.equals(this.f13355a, dVar.f13355a) && Objects.equals(this.f13358d, dVar.f13358d);
    }

    public final int hashCode() {
        return Objects.hash(this.f13355a, Integer.valueOf(this.f13356b), Double.valueOf(this.f13357c), this.f13358d);
    }

    public d(String str, int i10, String str2) {
        boolean z10 = true;
        if (i10 == 1 && !str2.startsWith("0x") && !str2.startsWith("0X")) {
            z10 = false;
        }
        l1.d.g(z10);
        this.f13355a = str;
        this.f13356b = i10;
        this.f13358d = str2;
        this.f13357c = 0.0d;
    }
}
