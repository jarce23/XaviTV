package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements p {

    /* renamed from: o, reason: collision with root package name */
    public final q f1105o;

    /* renamed from: p, reason: collision with root package name */
    public final a f1106p;

    public ReflectiveGenericLifecycleObserver(q qVar) {
        this.f1105o = qVar;
        c cVar = c.f1113c;
        Class<?> cls = qVar.getClass();
        a aVar = (a) cVar.f1114a.get(cls);
        this.f1106p = aVar == null ? cVar.a(cls, null) : aVar;
    }

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        HashMap hashMap = this.f1106p.f1109a;
        List list = (List) hashMap.get(lVar);
        q qVar = this.f1105o;
        a.a(list, rVar, lVar, qVar);
        a.a((List) hashMap.get(l.ON_ANY), rVar, lVar, qVar);
    }
}
