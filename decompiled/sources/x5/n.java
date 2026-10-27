package x5;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements k {

    /* renamed from: b, reason: collision with root package name */
    public final Map f13654b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Map f13655c;

    public n(Map map) {
        this.f13654b = Collections.unmodifiableMap(map);
    }

    @Override // x5.k
    public final Map a() {
        if (this.f13655c == null) {
            synchronized (this) {
                try {
                    if (this.f13655c == null) {
                        this.f13655c = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.f13655c;
    }

    public final HashMap b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f13654b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str = ((m) list.get(i10)).f13653a;
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(str);
                    if (i10 != list.size() - 1) {
                        sb2.append(',');
                    }
                }
            }
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(sb3)) {
                hashMap.put((String) entry.getKey(), sb3);
            }
        }
        return hashMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f13654b.equals(((n) obj).f13654b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13654b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f13654b + '}';
    }
}
