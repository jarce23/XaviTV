package ma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class t extends com.google.android.gms.internal.cast.n {
    public static Map A(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return q.f9052o;
        }
        if (size == 1) {
            la.d dVar = (la.d) arrayList.get(0);
            za.h.e("pair", dVar);
            Map singletonMap = Collections.singletonMap(dVar.f8328o, dVar.f8329p);
            za.h.d("singletonMap(...)", singletonMap);
            return singletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(z(arrayList.size()));
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            la.d dVar2 = (la.d) obj;
            linkedHashMap.put(dVar2.f8328o, dVar2.f8329p);
        }
        return linkedHashMap;
    }

    public static final Map B(Map map) {
        za.h.e("<this>", map);
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        za.h.d("with(...)", singletonMap);
        return singletonMap;
    }

    public static int z(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
