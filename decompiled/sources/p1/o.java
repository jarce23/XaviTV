package p1;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: c, reason: collision with root package name */
    public static final o f9859c = new o(Collections.EMPTY_MAP);

    /* renamed from: a, reason: collision with root package name */
    public int f9860a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f9861b;

    public o(Map map) {
        this.f9861b = Collections.unmodifiableMap(map);
    }

    public static boolean b(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final o a(g gVar) {
        byte[] bArr;
        Map map = this.f9861b;
        HashMap hashMap = new HashMap(map);
        List unmodifiableList = Collections.unmodifiableList(new ArrayList((ArrayList) gVar.f9839b));
        for (int i10 = 0; i10 < unmodifiableList.size(); i10++) {
            hashMap.remove(unmodifiableList.get(i10));
        }
        HashMap hashMap2 = new HashMap((HashMap) gVar.f9838a);
        for (Map.Entry entry : hashMap2.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr2 = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr2, bArr2.length));
            }
        }
        for (Map.Entry entry2 : Collections.unmodifiableMap(hashMap2).entrySet()) {
            String str = (String) entry2.getKey();
            Object value2 = entry2.getValue();
            if (value2 instanceof Long) {
                bArr = ByteBuffer.allocate(8).putLong(((Long) value2).longValue()).array();
            } else if (value2 instanceof String) {
                bArr = ((String) value2).getBytes(StandardCharsets.UTF_8);
            } else {
                if (!(value2 instanceof byte[])) {
                    throw new IllegalArgumentException();
                }
                bArr = (byte[]) value2;
            }
            hashMap.put(str, bArr);
        }
        return b(map, hashMap) ? this : new o(hashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return b(this.f9861b, ((o) obj).f9861b);
    }

    public final int hashCode() {
        if (this.f9860a == 0) {
            int i10 = 0;
            for (Map.Entry entry : this.f9861b.entrySet()) {
                i10 += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.f9860a = i10;
        }
        return this.f9860a;
    }
}
