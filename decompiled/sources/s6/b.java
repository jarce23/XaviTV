package s6;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements t9.d {

    /* renamed from: a, reason: collision with root package name */
    public static final b f11590a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final t9.c f11591b;

    static {
        w9.a aVar = new w9.a(1);
        HashMap hashMap = new HashMap();
        hashMap.put(w9.d.class, aVar);
        f11591b = new t9.c("storageMetrics", Collections.unmodifiableMap(new HashMap(hashMap)));
    }

    @Override // t9.a
    public final void a(Object obj, Object obj2) {
        ((t9.e) obj2).a(f11591b, ((w6.b) obj).f13118a);
    }
}
