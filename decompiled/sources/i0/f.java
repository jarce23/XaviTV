package i0;

import android.os.Build;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final f f5784b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    public final h f5785a;

    public f(h hVar) {
        this.f5785a = hVar;
    }

    public static f a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new f(new i(c.a(localeArr))) : new f(new g(localeArr));
    }

    public static f b(String str) {
        if (str == null || str.isEmpty()) {
            return f5784b;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = split[i10];
            int i11 = e.f5783a;
            localeArr[i10] = Locale.forLanguageTag(str2);
        }
        return a(localeArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f5785a.equals(((f) obj).f5785a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5785a.hashCode();
    }

    public final String toString() {
        return this.f5785a.toString();
    }
}
