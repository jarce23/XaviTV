package t1;

import c2.d0;
import i1.t0;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f11780a;

    /* renamed from: b, reason: collision with root package name */
    public final t0 f11781b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11782c;

    /* renamed from: d, reason: collision with root package name */
    public final d0 f11783d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11784e;

    /* renamed from: f, reason: collision with root package name */
    public final t0 f11785f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final d0 f11786h;

    /* renamed from: i, reason: collision with root package name */
    public final long f11787i;

    /* renamed from: j, reason: collision with root package name */
    public final long f11788j;

    public a(long j10, t0 t0Var, int i10, d0 d0Var, long j11, t0 t0Var2, int i11, d0 d0Var2, long j12, long j13) {
        this.f11780a = j10;
        this.f11781b = t0Var;
        this.f11782c = i10;
        this.f11783d = d0Var;
        this.f11784e = j11;
        this.f11785f = t0Var2;
        this.g = i11;
        this.f11786h = d0Var2;
        this.f11787i = j12;
        this.f11788j = j13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f11780a == aVar.f11780a && this.f11782c == aVar.f11782c && this.f11784e == aVar.f11784e && this.g == aVar.g && this.f11787i == aVar.f11787i && this.f11788j == aVar.f11788j && Objects.equals(this.f11781b, aVar.f11781b) && Objects.equals(this.f11783d, aVar.f11783d) && Objects.equals(this.f11785f, aVar.f11785f) && Objects.equals(this.f11786h, aVar.f11786h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f11780a), this.f11781b, Integer.valueOf(this.f11782c), this.f11783d, Long.valueOf(this.f11784e), this.f11785f, Integer.valueOf(this.g), this.f11786h, Long.valueOf(this.f11787i), Long.valueOf(this.f11788j));
    }
}
