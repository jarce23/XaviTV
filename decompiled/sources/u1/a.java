package u1;

import android.os.Build;
import java.util.Objects;
import java.util.Set;
import o9.i0;
import o9.j0;
import o9.k1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f12146d;

    /* renamed from: a, reason: collision with root package name */
    public final int f12147a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12148b;

    /* renamed from: c, reason: collision with root package name */
    public final j0 f12149c;

    static {
        a aVar;
        if (Build.VERSION.SDK_INT >= 33) {
            i0 i0Var = new i0(4);
            for (int i10 = 1; i10 <= 10; i10++) {
                i0Var.a(Integer.valueOf(l1.a0.r(i10)));
            }
            aVar = new a(2, i0Var.f());
        } else {
            aVar = new a(2, 10);
        }
        f12146d = aVar;
    }

    public a(int i10, Set set) {
        this.f12147a = i10;
        j0 n10 = j0.n(set);
        this.f12149c = n10;
        k1 it = n10.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 = Math.max(i11, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.f12148b = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12147a == aVar.f12147a && this.f12148b == aVar.f12148b && Objects.equals(this.f12149c, aVar.f12149c);
    }

    public final int hashCode() {
        int i10 = ((this.f12147a * 31) + this.f12148b) * 31;
        j0 j0Var = this.f12149c;
        return i10 + (j0Var == null ? 0 : j0Var.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.f12147a + ", maxChannelCount=" + this.f12148b + ", channelMasks=" + this.f12149c + "]";
    }

    public a(int i10, int i11) {
        this.f12147a = i10;
        this.f12148b = i11;
        this.f12149c = null;
    }
}
