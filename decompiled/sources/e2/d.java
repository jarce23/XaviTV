package e2;

import android.os.Bundle;
import java.util.ArrayList;
import o9.e0;
import o9.g0;
import o9.q;
import o9.w0;
import r5.k;
import w3.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4413a;

    public d(int i10) {
        switch (i10) {
            case 1:
                this.f4413a = new ArrayList();
                break;
            case 2:
                this.f4413a = new ArrayList();
                break;
            case 3:
                this.f4413a = new ArrayList();
                break;
            case 4:
                this.f4413a = new ArrayList();
                break;
            default:
                this.f4413a = new ArrayList();
                break;
        }
    }

    @Override // e2.a
    public g0 a(long j10) {
        int i10 = i(j10);
        if (i10 == 0) {
            e0 e0Var = g0.f9617p;
            return w0.f9686s;
        }
        h3.a aVar = (h3.a) this.f4413a.get(i10 - 1);
        long j11 = aVar.f5524d;
        if (j11 == -9223372036854775807L || j10 < j11) {
            return aVar.f5521a;
        }
        e0 e0Var2 = g0.f9617p;
        return w0.f9686s;
    }

    @Override // e2.a
    public long b(long j10) {
        ArrayList arrayList = this.f4413a;
        if (arrayList.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j10 < ((h3.a) arrayList.get(0)).f5522b) {
            return ((h3.a) arrayList.get(0)).f5522b;
        }
        for (int i10 = 1; i10 < arrayList.size(); i10++) {
            h3.a aVar = (h3.a) arrayList.get(i10);
            long j11 = aVar.f5522b;
            long j12 = aVar.f5522b;
            if (j10 < j11) {
                long j13 = ((h3.a) arrayList.get(i10 - 1)).f5524d;
                return (j13 == -9223372036854775807L || j13 <= j10 || j13 >= j12) ? j12 : j13;
            }
        }
        long j14 = ((h3.a) q.g(arrayList)).f5524d;
        if (j14 == -9223372036854775807L || j10 >= j14) {
            return Long.MIN_VALUE;
        }
        return j14;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    @Override // e2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(h3.a r11, long r12) {
        /*
            r10 = this;
            java.util.ArrayList r0 = r10.f4413a
            long r1 = r11.f5522b
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L11
            r5 = r7
            goto L12
        L11:
            r5 = r6
        L12:
            l1.d.b(r5)
            int r5 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r5 > 0) goto L25
            long r8 = r11.f5524d
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 == 0) goto L23
            int r3 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r3 >= 0) goto L25
        L23:
            r3 = r7
            goto L26
        L25:
            r3 = r6
        L26:
            int r4 = r0.size()
            int r4 = r4 - r7
        L2b:
            if (r4 < 0) goto L4e
            java.lang.Object r5 = r0.get(r4)
            h3.a r5 = (h3.a) r5
            long r8 = r5.f5522b
            int r5 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r5 < 0) goto L3e
            int r4 = r4 + r7
            r0.add(r4, r11)
            return r3
        L3e:
            java.lang.Object r5 = r0.get(r4)
            h3.a r5 = (h3.a) r5
            long r8 = r5.f5522b
            int r5 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r5 > 0) goto L4b
            r3 = r6
        L4b:
            int r4 = r4 + (-1)
            goto L2b
        L4e:
            r0.add(r6, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.d.c(h3.a, long):boolean");
    }

    @Override // e2.a
    public void clear() {
        this.f4413a.clear();
    }

    @Override // e2.a
    public long d(long j10) {
        ArrayList arrayList = this.f4413a;
        if (arrayList.isEmpty() || j10 < ((h3.a) arrayList.get(0)).f5522b) {
            return -9223372036854775807L;
        }
        for (int i10 = 1; i10 < arrayList.size(); i10++) {
            long j11 = ((h3.a) arrayList.get(i10)).f5522b;
            if (j10 == j11) {
                return j11;
            }
            if (j10 < j11) {
                h3.a aVar = (h3.a) arrayList.get(i10 - 1);
                long j12 = aVar.f5524d;
                return (j12 == -9223372036854775807L || j12 > j10) ? aVar.f5522b : j12;
            }
        }
        h3.a aVar2 = (h3.a) q.g(arrayList);
        long j13 = aVar2.f5524d;
        return (j13 == -9223372036854775807L || j10 < j13) ? aVar2.f5522b : j13;
    }

    @Override // e2.a
    public void e(long j10) {
        ArrayList arrayList = this.f4413a;
        int i10 = i(j10);
        if (i10 == 0) {
            return;
        }
        long j11 = ((h3.a) arrayList.get(i10 - 1)).f5524d;
        if (j11 == -9223372036854775807L || j11 >= j10) {
            i10--;
        }
        arrayList.subList(0, i10).clear();
    }

    public o f() {
        if (this.f4413a == null) {
            return o.f12981c;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("controlCategories", this.f4413a);
        return new o(bundle, this.f4413a);
    }

    public synchronized f6.b g(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return f6.d.f5029p;
        }
        ArrayList arrayList = this.f4413a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            f6.c cVar = (f6.c) obj;
            if (cVar.f5026a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f5027b)) {
                return cVar.f5028c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized k h(Class cls) {
        int size = this.f4413a.size();
        for (int i10 = 0; i10 < size; i10++) {
            h6.d dVar = (h6.d) this.f4413a.get(i10);
            if (dVar.f5691a.isAssignableFrom(cls)) {
                return dVar.f5692b;
            }
        }
        return null;
    }

    public int i(long j10) {
        ArrayList arrayList = this.f4413a;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (j10 < ((h3.a) arrayList.get(i10)).f5522b) {
                return i10;
            }
        }
        return arrayList.size();
    }

    public synchronized ArrayList j(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        ArrayList arrayList2 = this.f4413a;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            f6.c cVar = (f6.c) obj;
            if ((cVar.f5026a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f5027b)) && !arrayList.contains(cVar.f5027b)) {
                arrayList.add(cVar.f5027b);
            }
        }
        return arrayList;
    }
}
