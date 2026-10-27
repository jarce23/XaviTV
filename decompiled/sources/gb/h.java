package gb;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final Pattern f5467o;

    public h(String str) {
        Pattern compile = Pattern.compile(str);
        za.h.d("compile(...)", compile);
        this.f5467o = compile;
    }

    public final x4.m a(int i10, String str) {
        za.h.e("input", str);
        Matcher region = this.f5467o.matcher(str).useAnchoringBounds(false).useTransparentBounds(true).region(i10, str.length());
        if (region.lookingAt()) {
            return new x4.m(region, str);
        }
        return null;
    }

    public final String toString() {
        String pattern = this.f5467o.toString();
        za.h.d("toString(...)", pattern);
        return pattern;
    }
}
