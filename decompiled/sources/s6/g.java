package s6;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements t9.d {

    /* renamed from: a, reason: collision with root package name */
    public static final g f11602a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final t9.c f11603b;

    /* renamed from: c, reason: collision with root package name */
    public static final t9.c f11604c;

    static {
        w9.a aVar = new w9.a(1);
        HashMap hashMap = new HashMap();
        hashMap.put(w9.d.class, aVar);
        f11603b = new t9.c("startMs", Collections.unmodifiableMap(new HashMap(hashMap)));
        w9.a aVar2 = new w9.a(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(w9.d.class, aVar2);
        f11604c = new t9.c("endMs", Collections.unmodifiableMap(new HashMap(hashMap2)));
    }

    @Override // t9.a
    public final void a(Object obj, Object obj2) {
        w6.g gVar = (w6.g) obj;
        t9.e eVar = (t9.e) obj2;
        eVar.d(f11603b, gVar.f13135a);
        eVar.d(f11604c, gVar.f13136b);
    }
}
