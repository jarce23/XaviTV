package gb;

import java.util.regex.Matcher;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends ma.d {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ x4.m f5463o;

    public e(x4.m mVar) {
        this.f5463o = mVar;
    }

    @Override // ma.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // ma.a
    public final int f() {
        return ((Matcher) this.f5463o.f13564p).groupCount() + 1;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        String group = ((Matcher) this.f5463o.f13564p).group(i10);
        return group == null ? _UrlKt.FRAGMENT_ENCODE_SET : group;
    }

    @Override // ma.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // ma.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
