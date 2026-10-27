package e4;

import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f4573a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4574b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f4575c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f4576d;

    public e(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        h.e("foreignKeys", abstractSet);
        this.f4573a = str;
        this.f4574b = map;
        this.f4575c = abstractSet;
        this.f4576d = abstractSet2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x01dd, code lost:
    
        r9 = i7.e.b(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01e1, code lost:
    
        r3.close();
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final e4.e a(h4.c r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.e.a(h4.c, java.lang.String):e4.e");
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f4573a.equals(eVar.f4573a) || !this.f4574b.equals(eVar.f4574b) || !h.a(this.f4575c, eVar.f4575c)) {
            return false;
        }
        Set set2 = this.f4576d;
        if (set2 == null || (set = eVar.f4576d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.f4575c.hashCode() + ((this.f4574b.hashCode() + (this.f4573a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f4573a + "', columns=" + this.f4574b + ", foreignKeys=" + this.f4575c + ", indices=" + this.f4576d + '}';
    }
}
