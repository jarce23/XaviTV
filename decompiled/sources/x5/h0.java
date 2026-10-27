package x5;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 implements t {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f13642b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    public final t f13643a;

    public h0(t tVar) {
        this.f13643a = tVar;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, r5.h hVar) {
        return this.f13643a.a(new j(((Uri) obj).toString()), i10, i11, hVar);
    }

    @Override // x5.t
    public final boolean b(Object obj) {
        return f13642b.contains(((Uri) obj).getScheme());
    }
}
