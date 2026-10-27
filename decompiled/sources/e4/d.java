package e4;

import gb.p;
import java.util.ArrayList;
import java.util.List;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f4569a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4570b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4571c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4572d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
    public d(String str, boolean z10, List list, List list2) {
        h.e("columns", list);
        h.e("orders", list2);
        this.f4569a = str;
        this.f4570b = z10;
        this.f4571c = list;
        this.f4572d = list2;
        if (list2.isEmpty()) {
            int size = list.size();
            list2 = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                list2.add("ASC");
            }
        }
        this.f4572d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = dVar.f4569a;
            if (this.f4570b == dVar.f4570b && h.a(this.f4571c, dVar.f4571c) && h.a(this.f4572d, dVar.f4572d)) {
                String str2 = this.f4569a;
                return p.Y(str2, "index_", false) ? p.Y(str, "index_", false) : str2.equals(str);
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f4569a;
        return this.f4572d.hashCode() + ((this.f4571c.hashCode() + ((((p.Y(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f4570b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Index{name='" + this.f4569a + "', unique=" + this.f4570b + ", columns=" + this.f4571c + ", orders=" + this.f4572d + "'}";
    }
}
