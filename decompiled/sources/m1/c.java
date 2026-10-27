package m1;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: q, reason: collision with root package name */
    public final long f8754q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f8755r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f8756s;

    public c(int i10, long j10) {
        super(i10, 0);
        this.f8754q = j10;
        this.f8755r = new ArrayList();
        this.f8756s = new ArrayList();
    }

    public final c j(int i10) {
        ArrayList arrayList = this.f8756s;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) arrayList.get(i11);
            if (cVar.f8759p == i10) {
                return cVar;
            }
        }
        return null;
    }

    public final d k(int i10) {
        ArrayList arrayList = this.f8755r;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            d dVar = (d) arrayList.get(i11);
            if (dVar.f8759p == i10) {
                return dVar;
            }
        }
        return null;
    }

    @Override // m1.e
    public final String toString() {
        return e.c(this.f8759p) + " leaves: " + Arrays.toString(this.f8755r.toArray()) + " containers: " + Arrays.toString(this.f8756s.toArray());
    }
}
