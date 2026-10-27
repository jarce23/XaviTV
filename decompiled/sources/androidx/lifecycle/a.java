package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1109a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1110b;

    public a(HashMap hashMap) {
        this.f1110b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            l lVar = (l) entry.getValue();
            List list = (List) this.f1109a.get(lVar);
            if (list == null) {
                list = new ArrayList();
                this.f1109a.put(lVar, list);
            }
            list.add((b) entry.getKey());
        }
    }

    public static void a(List list, r rVar, l lVar, q qVar) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                b bVar = (b) list.get(size);
                Method method = bVar.f1112b;
                try {
                    int i10 = bVar.f1111a;
                    if (i10 == 0) {
                        method.invoke(qVar, null);
                    } else if (i10 == 1) {
                        method.invoke(qVar, rVar);
                    } else if (i10 == 2) {
                        method.invoke(qVar, rVar, lVar);
                    }
                } catch (IllegalAccessException e7) {
                    throw new RuntimeException(e7);
                } catch (InvocationTargetException e8) {
                    throw new RuntimeException("Failed to call observer method", e8.getCause());
                }
            }
        }
    }
}
