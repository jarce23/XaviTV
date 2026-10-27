package c4;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2908a;

    public k(int i10) {
        switch (i10) {
            case 1:
                this.f2908a = new LinkedHashMap();
                break;
            case 2:
                this.f2908a = new LinkedHashMap(0, 0.75f, true);
                break;
            default:
                this.f2908a = new LinkedHashMap();
                break;
        }
    }

    public void a(k2.j jVar) {
        long[] jArr = jVar.f7746e;
        if (jArr.length > 0) {
            Long valueOf = Long.valueOf(jArr[0]);
            LinkedHashMap linkedHashMap = this.f2908a;
            if (linkedHashMap.containsKey(valueOf)) {
                return;
            }
            linkedHashMap.put(Long.valueOf(jVar.f7746e[0]), jVar);
        }
    }

    public void b(d4.a... aVarArr) {
        za.h.e("migrations", aVarArr);
        for (d4.a aVar : aVarArr) {
            int i10 = aVar.f4050a;
            int i11 = aVar.f4051b;
            Integer valueOf = Integer.valueOf(i10);
            LinkedHashMap linkedHashMap = this.f2908a;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new TreeMap();
                linkedHashMap.put(valueOf, obj);
            }
            TreeMap treeMap = (TreeMap) obj;
            if (treeMap.containsKey(Integer.valueOf(i11))) {
                Log.w("ROOM", "Overriding migration " + treeMap.get(Integer.valueOf(i11)) + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i11), aVar);
        }
    }
}
