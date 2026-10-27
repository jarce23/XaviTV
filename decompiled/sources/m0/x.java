package m0;

import android.text.TextUtils;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends z {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f8737s;

    public x(int i10, Class cls, int i11, int i12, int i13) {
        this.f8737s = i13;
        this.f8745o = i10;
        this.f8748r = cls;
        this.f8747q = i11;
        this.f8746p = i12;
    }

    @Override // m0.z
    public final Object c(View view) {
        switch (this.f8737s) {
            case 0:
                return Boolean.valueOf(f0.c(view));
            case 1:
                return f0.a(view);
            case 2:
                return h0.b(view);
            default:
                return Boolean.valueOf(f0.b(view));
        }
    }

    @Override // m0.z
    public final void d(View view, Object obj) {
        switch (this.f8737s) {
            case 0:
                f0.f(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                f0.e(view, (CharSequence) obj);
                break;
            case 2:
                h0.c(view, (CharSequence) obj);
                break;
            default:
                f0.d(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // m0.z
    public final boolean g(Object obj, Object obj2) {
        boolean equals;
        switch (this.f8737s) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
        return !equals;
    }
}
