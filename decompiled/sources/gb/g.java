package gb;

import java.util.Iterator;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends ma.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ x4.m f5466o;

    public g(x4.m mVar) {
        this.f5466o = mVar;
    }

    @Override // ma.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof d) {
            return super.contains((d) obj);
        }
        return false;
    }

    @Override // ma.a
    public final int f() {
        return ((Matcher) this.f5466o.f13564p).groupCount() + 1;
    }

    public final d g(int i10) {
        Matcher matcher = (Matcher) this.f5466o.f13564p;
        db.c y8 = k5.a.y(matcher.start(i10), matcher.end(i10));
        if (y8.f4350o < 0) {
            return null;
        }
        String group = matcher.group(i10);
        za.h.d("group(...)", group);
        return new d(group, y8);
    }

    @Override // ma.a, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new fb.k(new fb.e(new fb.i(2, new db.c(0, f() - 1, 1)), new f(0, this)));
    }
}
