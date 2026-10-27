package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f1128a = new m0();

    /* renamed from: b, reason: collision with root package name */
    public static final m0 f1129b = new m0();

    /* renamed from: c, reason: collision with root package name */
    public static final m0 f1130c = new m0();

    public static final void a(f4.e eVar) {
        f4.c cVar;
        m mVar = eVar.f().f1158c;
        if (mVar != m.f1145p && mVar != m.f1146q) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        f4.d b2 = eVar.b();
        b2.getClass();
        Iterator it = ((o.f) b2.f5020d).iterator();
        while (true) {
            o.b bVar = (o.b) it;
            if (!bVar.hasNext()) {
                cVar = null;
                break;
            }
            Map.Entry entry = (Map.Entry) bVar.next();
            za.h.d("components", entry);
            String str = (String) entry.getKey();
            cVar = (f4.c) entry.getValue();
            if (za.h.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                break;
            }
        }
        if (cVar == null) {
            i0 i0Var = new i0(eVar.b(), (o0) eVar);
            eVar.b().e("androidx.lifecycle.internal.SavedStateHandlesProvider", i0Var);
            eVar.f().a(new SavedStateHandleAttacher(i0Var));
        }
    }
}
