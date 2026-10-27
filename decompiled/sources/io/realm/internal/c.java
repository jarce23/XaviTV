package io.realm.internal;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6735a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6736b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6737c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6738d;

    public c(int i10, boolean z10) {
        this.f6735a = new HashMap(i10);
        this.f6736b = new HashMap(i10);
        this.f6737c = new HashMap(i10);
        this.f6738d = z10;
    }

    public final long a(String str, String str2, OsObjectSchemaInfo osObjectSchemaInfo) {
        Property b2 = osObjectSchemaInfo.b(str2);
        b bVar = new b(b2);
        this.f6735a.put(str, bVar);
        this.f6736b.put(str2, bVar);
        this.f6737c.put(str, str2);
        return b2.b();
    }

    public abstract void b(c cVar, c cVar2);

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ColumnInfo[");
        sb2.append("mutable=" + this.f6738d);
        sb2.append(",");
        boolean z10 = false;
        HashMap hashMap = this.f6735a;
        if (hashMap != null) {
            sb2.append("JavaFieldNames=[");
            boolean z11 = false;
            for (Map.Entry entry : hashMap.entrySet()) {
                if (z11) {
                    sb2.append(",");
                }
                sb2.append((String) entry.getKey());
                sb2.append("->");
                sb2.append(entry.getValue());
                z11 = true;
            }
            sb2.append("]");
        }
        HashMap hashMap2 = this.f6736b;
        if (hashMap2 != null) {
            sb2.append(", InternalFieldNames=[");
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                if (z10) {
                    sb2.append(",");
                }
                sb2.append((String) entry2.getKey());
                sb2.append("->");
                sb2.append(entry2.getValue());
                z10 = true;
            }
            sb2.append("]");
        }
        sb2.append("]");
        return sb2.toString();
    }
}
