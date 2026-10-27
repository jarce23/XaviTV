package p1;

import java.util.ArrayList;
import java.util.TreeSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f9849a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9850b;

    /* renamed from: c, reason: collision with root package name */
    public final TreeSet f9851c = new TreeSet();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f9852d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public o f9853e;

    public k(int i10, String str, o oVar) {
        this.f9849a = i10;
        this.f9850b = str;
        this.f9853e = oVar;
    }

    public final boolean a(long j10, long j11) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f9852d;
            if (i10 >= arrayList.size()) {
                return false;
            }
            j jVar = (j) arrayList.get(i10);
            long j12 = jVar.f9847a;
            long j13 = jVar.f9848b;
            if (j13 == -1) {
                if (j10 >= j12) {
                    return true;
                }
            } else if (j11 != -1 && j12 <= j10 && j10 + j11 <= j12 + j13) {
                return true;
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (this.f9849a == kVar.f9849a && this.f9850b.equals(kVar.f9850b) && this.f9851c.equals(kVar.f9851c) && this.f9853e.equals(kVar.f9853e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9853e.hashCode() + android.support.v4.media.d.g(this.f9850b, this.f9849a * 31, 31);
    }
}
