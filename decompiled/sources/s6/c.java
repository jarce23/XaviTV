package s6;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements t9.d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f11592a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final t9.c f11593b;

    /* renamed from: c, reason: collision with root package name */
    public static final t9.c f11594c;

    static {
        w9.a aVar = new w9.a(1);
        HashMap hashMap = new HashMap();
        hashMap.put(w9.d.class, aVar);
        f11593b = new t9.c("eventsDroppedCount", Collections.unmodifiableMap(new HashMap(hashMap)));
        w9.a aVar2 = new w9.a(3);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(w9.d.class, aVar2);
        f11594c = new t9.c("reason", Collections.unmodifiableMap(new HashMap(hashMap2)));
    }

    @Override // t9.a
    public final void a(Object obj, Object obj2) {
        w6.d dVar = (w6.d) obj;
        t9.e eVar = (t9.e) obj2;
        eVar.d(f11593b, dVar.f13128a);
        eVar.a(f11594c, dVar.f13129b);
    }
}
