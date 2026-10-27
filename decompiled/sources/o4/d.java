package o4;

import android.os.Build;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: i, reason: collision with root package name */
    public static final d f9486i = new d(1, false, false, false, false, -1, -1, ma.r.f9053o);

    /* renamed from: a, reason: collision with root package name */
    public final int f9487a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9488b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9489c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9490d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9491e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9492f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final Set f9493h;

    public d(int i10, boolean z10, boolean z11, boolean z12, boolean z13, long j10, long j11, Set set) {
        r.a.h(i10, "requiredNetworkType");
        za.h.e("contentUriTriggers", set);
        this.f9487a = i10;
        this.f9488b = z10;
        this.f9489c = z11;
        this.f9490d = z12;
        this.f9491e = z13;
        this.f9492f = j10;
        this.g = j11;
        this.f9493h = set;
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT < 24 || !this.f9493h.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !d.class.equals(obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f9488b == dVar.f9488b && this.f9489c == dVar.f9489c && this.f9490d == dVar.f9490d && this.f9491e == dVar.f9491e && this.f9492f == dVar.f9492f && this.g == dVar.g && this.f9487a == dVar.f9487a) {
            return za.h.a(this.f9493h, dVar.f9493h);
        }
        return false;
    }

    public final int hashCode() {
        int b2 = ((((((((s.e.b(this.f9487a) * 31) + (this.f9488b ? 1 : 0)) * 31) + (this.f9489c ? 1 : 0)) * 31) + (this.f9490d ? 1 : 0)) * 31) + (this.f9491e ? 1 : 0)) * 31;
        long j10 = this.f9492f;
        int i10 = (b2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.g;
        return this.f9493h.hashCode() + ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31);
    }

    public final String toString() {
        return "Constraints{requiredNetworkType=" + android.support.v4.media.d.C(this.f9487a) + ", requiresCharging=" + this.f9488b + ", requiresDeviceIdle=" + this.f9489c + ", requiresBatteryNotLow=" + this.f9490d + ", requiresStorageNotLow=" + this.f9491e + ", contentTriggerUpdateDelayMillis=" + this.f9492f + ", contentTriggerMaxDelayMillis=" + this.g + ", contentUriTriggers=" + this.f9493h + ", }";
    }

    public d(d dVar) {
        za.h.e("other", dVar);
        this.f9488b = dVar.f9488b;
        this.f9489c = dVar.f9489c;
        this.f9487a = dVar.f9487a;
        this.f9490d = dVar.f9490d;
        this.f9491e = dVar.f9491e;
        this.f9493h = dVar.f9493h;
        this.f9492f = dVar.f9492f;
        this.g = dVar.g;
    }
}
