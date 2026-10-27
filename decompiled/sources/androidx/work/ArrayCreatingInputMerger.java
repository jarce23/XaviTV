package androidx.work;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import o4.f;
import o4.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends h {
    @Override // o4.h
    public final f a(ArrayList arrayList) {
        Object newInstance;
        com.bumptech.glide.h hVar = new com.bumptech.glide.h(1);
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Map unmodifiableMap = Collections.unmodifiableMap(((f) obj).f9498a);
            za.h.d("input.keyValueMap", unmodifiableMap);
            for (Map.Entry entry : unmodifiableMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : String.class;
                Object obj2 = hashMap.get(str);
                za.h.d("key", str);
                if (obj2 != null) {
                    Class<?> cls2 = obj2.getClass();
                    if (cls2.equals(cls)) {
                        za.h.d("value", value);
                        int length = Array.getLength(obj2);
                        int length2 = Array.getLength(value);
                        Class<?> componentType = obj2.getClass().getComponentType();
                        za.h.b(componentType);
                        Object newInstance2 = Array.newInstance(componentType, length + length2);
                        System.arraycopy(obj2, 0, newInstance2, 0, length);
                        System.arraycopy(value, 0, newInstance2, length, length2);
                        za.h.d("newArray", newInstance2);
                        value = newInstance2;
                        za.h.d("if (existingValue == nul…      }\n                }", value);
                        hashMap.put(str, value);
                    } else {
                        if (!za.h.a(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        int length3 = Array.getLength(obj2);
                        newInstance = Array.newInstance(cls, length3 + 1);
                        System.arraycopy(obj2, 0, newInstance, 0, length3);
                        Array.set(newInstance, length3, value);
                        za.h.d("newArray", newInstance);
                        value = newInstance;
                        za.h.d("if (existingValue == nul…      }\n                }", value);
                        hashMap.put(str, value);
                    }
                } else if (cls.isArray()) {
                    za.h.d("if (existingValue == nul…      }\n                }", value);
                    hashMap.put(str, value);
                } else {
                    newInstance = Array.newInstance(cls, 1);
                    Array.set(newInstance, 0, value);
                    za.h.d("newArray", newInstance);
                    value = newInstance;
                    za.h.d("if (existingValue == nul…      }\n                }", value);
                    hashMap.put(str, value);
                }
            }
        }
        hVar.a(hashMap);
        f fVar = new f(hVar.f3017a);
        f.b(fVar);
        return fVar;
    }
}
