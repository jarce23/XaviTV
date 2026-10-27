package o;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f implements Iterable {

    /* renamed from: o, reason: collision with root package name */
    public c f9365o;

    /* renamed from: p, reason: collision with root package name */
    public c f9366p;

    /* renamed from: q, reason: collision with root package name */
    public final WeakHashMap f9367q = new WeakHashMap();

    /* renamed from: r, reason: collision with root package name */
    public int f9368r = 0;

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((o.b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof o.f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            o.f r7 = (o.f) r7
            int r1 = r6.f9368r
            int r3 = r7.f9368r
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            o.b r3 = (o.b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            o.b r4 = (o.b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            o.b r7 = (o.b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.f.equals(java.lang.Object):boolean");
    }

    public c f(Object obj) {
        c cVar = this.f9365o;
        while (cVar != null && !cVar.f9358o.equals(obj)) {
            cVar = cVar.f9360q;
        }
        return cVar;
    }

    public Object g(Object obj) {
        c f10 = f(obj);
        if (f10 == null) {
            return null;
        }
        this.f9368r--;
        WeakHashMap weakHashMap = this.f9367q;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(f10);
            }
        }
        c cVar = f10.f9361r;
        if (cVar != null) {
            cVar.f9360q = f10.f9360q;
        } else {
            this.f9365o = f10.f9360q;
        }
        c cVar2 = f10.f9360q;
        if (cVar2 != null) {
            cVar2.f9361r = cVar;
        } else {
            this.f9366p = cVar;
        }
        f10.f9360q = null;
        f10.f9361r = null;
        return f10.f9359p;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return i10;
            }
            i10 += ((Map.Entry) bVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f9365o, this.f9366p, 0);
        this.f9367q.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(((Map.Entry) bVar.next()).toString());
            if (bVar.hasNext()) {
                sb2.append(", ");
            }
        }
    }
}
