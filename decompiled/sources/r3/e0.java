package r3;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f10508a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10509b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10510c;

    /* renamed from: d, reason: collision with root package name */
    public int f10511d;

    /* renamed from: e, reason: collision with root package name */
    public String f10512e;

    public e0(int i10, int i11) {
        this(Integer.MIN_VALUE, i10, i11);
    }

    public final void a() {
        int i10 = this.f10511d;
        this.f10511d = i10 == Integer.MIN_VALUE ? this.f10509b : i10 + this.f10510c;
        this.f10512e = this.f10508a + this.f10511d;
    }

    public final void b() {
        if (this.f10511d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public e0(int i10, int i11, int i12) {
        String str;
        if (i10 != Integer.MIN_VALUE) {
            str = i10 + "/";
        } else {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        this.f10508a = str;
        this.f10509b = i11;
        this.f10510c = i12;
        this.f10511d = Integer.MIN_VALUE;
        this.f10512e = _UrlKt.FRAGMENT_ENCODE_SET;
    }
}
