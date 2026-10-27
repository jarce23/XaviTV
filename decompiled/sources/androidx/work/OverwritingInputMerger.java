package androidx.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import o4.f;
import o4.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class OverwritingInputMerger extends h {
    @Override // o4.h
    public final f a(ArrayList arrayList) {
        com.bumptech.glide.h hVar = new com.bumptech.glide.h(1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Map unmodifiableMap = Collections.unmodifiableMap(((f) obj).f9498a);
            za.h.d("input.keyValueMap", unmodifiableMap);
            linkedHashMap.putAll(unmodifiableMap);
        }
        hVar.a(linkedHashMap);
        f fVar = new f(hVar.f3017a);
        f.b(fVar);
        return fVar;
    }
}
