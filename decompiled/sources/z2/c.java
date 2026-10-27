package z2;

import i1.c0;
import i1.e0;
import i1.p;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14057a;

    public c(ArrayList arrayList) {
        this.f14057a = arrayList;
        boolean z10 = false;
        if (!arrayList.isEmpty()) {
            long j10 = ((b) arrayList.get(0)).f14055b;
            int i10 = 1;
            while (true) {
                if (i10 >= arrayList.size()) {
                    break;
                }
                if (((b) arrayList.get(i10)).f14054a < j10) {
                    z10 = true;
                    break;
                } else {
                    j10 = ((b) arrayList.get(i10)).f14055b;
                    i10++;
                }
            }
        }
        l1.d.b(!z10);
    }

    @Override // i1.e0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f14057a.equals(((c) obj).f14057a);
    }

    public final int hashCode() {
        return this.f14057a.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.f14057a;
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
