package p;

import java.util.ConcurrentModificationException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9777a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9778b = new Object();

    public static final void a(f fVar, int i10) {
        fVar.f9770o = new int[i10];
        fVar.f9771p = new Object[i10];
    }

    public static final int b(f fVar, Object obj, int i10) {
        int i11 = fVar.f9772q;
        if (i11 == 0) {
            return -1;
        }
        try {
            int a10 = q.a.a(i11, i10, fVar.f9770o);
            if (a10 < 0 || za.h.a(obj, fVar.f9771p[a10])) {
                return a10;
            }
            int i12 = a10 + 1;
            while (i12 < i11 && fVar.f9770o[i12] == i10) {
                if (za.h.a(obj, fVar.f9771p[i12])) {
                    return i12;
                }
                i12++;
            }
            for (int i13 = a10 - 1; i13 >= 0 && fVar.f9770o[i13] == i10; i13--) {
                if (za.h.a(obj, fVar.f9771p[i13])) {
                    return i13;
                }
            }
            return ~i12;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
