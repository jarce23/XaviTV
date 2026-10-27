package m1;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8758o;

    /* renamed from: p, reason: collision with root package name */
    public int f8759p;

    public static String c(int i10) {
        return _UrlKt.FRAGMENT_ENCODE_SET + ((char) ((i10 >> 24) & 255)) + ((char) ((i10 >> 16) & 255)) + ((char) ((i10 >> 8) & 255)) + ((char) (i10 & 255));
    }

    public void b(int i10) {
        this.f8759p = i10 | this.f8759p;
    }

    public boolean d(int i10) {
        return (this.f8759p & i10) == i10;
    }

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public String toString() {
        switch (this.f8758o) {
            case 0:
                return c(this.f8759p);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ e(int i10, int i11) {
        this.f8758o = i11;
        this.f8759p = i10;
    }
}
