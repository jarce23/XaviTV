package d7;

import android.support.v4.media.d;
import android.util.SparseArray;
import java.util.HashMap;
import p6.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f4230a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f4231b;

    static {
        HashMap hashMap = new HashMap();
        f4231b = hashMap;
        hashMap.put(c.f10025o, 0);
        hashMap.put(c.f10026p, 1);
        hashMap.put(c.f10027q, 2);
        for (c cVar : hashMap.keySet()) {
            f4230a.append(((Integer) f4231b.get(cVar)).intValue(), cVar);
        }
    }

    public static int a(c cVar) {
        Integer num = (Integer) f4231b.get(cVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + cVar);
    }

    public static c b(int i10) {
        c cVar = (c) f4230a.get(i10);
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException(d.m(i10, "Unknown Priority for value "));
    }
}
