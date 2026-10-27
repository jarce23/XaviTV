package s1;

import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f11281a;

    /* renamed from: b, reason: collision with root package name */
    public final i1.p f11282b;

    /* renamed from: c, reason: collision with root package name */
    public final i1.p f11283c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11284d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11285e;

    public f(String str, i1.p pVar, i1.p pVar2, int i10, int i11) {
        l1.d.b(i10 == 0 || i11 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f11281a = str;
        pVar.getClass();
        this.f11282b = pVar;
        pVar2.getClass();
        this.f11283c = pVar2;
        this.f11284d = i10;
        this.f11285e = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f11284d == fVar.f11284d && this.f11285e == fVar.f11285e && this.f11281a.equals(fVar.f11281a) && this.f11282b.equals(fVar.f11282b) && this.f11283c.equals(fVar.f11283c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11283c.hashCode() + ((this.f11282b.hashCode() + android.support.v4.media.d.g(this.f11281a, (((527 + this.f11284d) * 31) + this.f11285e) * 31, 31)) * 31);
    }
}
