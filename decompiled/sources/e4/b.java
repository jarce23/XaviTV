package e4;

import java.util.List;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f4560a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4561b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4562c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4563d;

    /* renamed from: e, reason: collision with root package name */
    public final List f4564e;

    public b(String str, String str2, String str3, List list, List list2) {
        h.e("columnNames", list);
        h.e("referenceColumnNames", list2);
        this.f4560a = str;
        this.f4561b = str2;
        this.f4562c = str3;
        this.f4563d = list;
        this.f4564e = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (h.a(this.f4560a, bVar.f4560a) && h.a(this.f4561b, bVar.f4561b) && h.a(this.f4562c, bVar.f4562c) && h.a(this.f4563d, bVar.f4563d)) {
            return h.a(this.f4564e, bVar.f4564e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4564e.hashCode() + ((this.f4563d.hashCode() + android.support.v4.media.d.g(this.f4562c, android.support.v4.media.d.g(this.f4561b, this.f4560a.hashCode() * 31, 31), 31)) * 31);
    }

    public final String toString() {
        return "ForeignKey{referenceTable='" + this.f4560a + "', onDelete='" + this.f4561b + " +', onUpdate='" + this.f4562c + "', columnNames=" + this.f4563d + ", referenceColumnNames=" + this.f4564e + '}';
    }
}
