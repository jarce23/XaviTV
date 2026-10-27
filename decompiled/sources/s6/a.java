package s6;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements t9.d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f11585a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final t9.c f11586b;

    /* renamed from: c, reason: collision with root package name */
    public static final t9.c f11587c;

    /* renamed from: d, reason: collision with root package name */
    public static final t9.c f11588d;

    /* renamed from: e, reason: collision with root package name */
    public static final t9.c f11589e;

    static {
        w9.a aVar = new w9.a(1);
        HashMap hashMap = new HashMap();
        hashMap.put(w9.d.class, aVar);
        f11586b = new t9.c("window", Collections.unmodifiableMap(new HashMap(hashMap)));
        w9.a aVar2 = new w9.a(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(w9.d.class, aVar2);
        f11587c = new t9.c("logSourceMetrics", Collections.unmodifiableMap(new HashMap(hashMap2)));
        w9.a aVar3 = new w9.a(3);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(w9.d.class, aVar3);
        f11588d = new t9.c("globalMetrics", Collections.unmodifiableMap(new HashMap(hashMap3)));
        w9.a aVar4 = new w9.a(4);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(w9.d.class, aVar4);
        f11589e = new t9.c("appNamespace", Collections.unmodifiableMap(new HashMap(hashMap4)));
    }

    @Override // t9.a
    public final void a(Object obj, Object obj2) {
        w6.a aVar = (w6.a) obj;
        t9.e eVar = (t9.e) obj2;
        eVar.a(f11586b, aVar.f13114a);
        eVar.a(f11587c, aVar.f13115b);
        eVar.a(f11588d, aVar.f13116c);
        eVar.a(f11589e, aVar.f13117d);
    }
}
