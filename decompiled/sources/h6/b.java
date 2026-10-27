package h6;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import m6.l;
import p.e;
import t5.i;
import t5.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final w f5685c = new w(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new f6.d(0), null)), null);

    /* renamed from: a, reason: collision with root package name */
    public final e f5686a = new e(0);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f5687b = new AtomicReference();

    public final void a(Class cls, Class cls2, Class cls3, w wVar) {
        synchronized (this.f5686a) {
            e eVar = this.f5686a;
            l lVar = new l(cls, cls2, cls3);
            if (wVar == null) {
                wVar = f5685c;
            }
            eVar.put(lVar, wVar);
        }
    }
}
