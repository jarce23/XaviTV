package f1;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public c f4860a;

    public a(String str, int i10, int i11) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT < 28) {
            this.f4860a = new c(str, i10, i11);
            return;
        }
        b bVar = new b(str, i10, i11);
        a6.c.w(str, i10, i11);
        this.f4860a = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.f4860a.equals(((a) obj).f4860a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4860a.hashCode();
    }
}
