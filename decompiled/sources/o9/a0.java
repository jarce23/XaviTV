package o9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f9570a;

    /* renamed from: b, reason: collision with root package name */
    public int f9571b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9572c;

    public a0(int i10) {
        q.b(i10, "initialCapacity");
        this.f9570a = new Object[i10];
        this.f9571b = 0;
    }

    public static int e(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i11 <= i10) {
            return i10;
        }
        int i12 = i10 + (i10 >> 1) + 1;
        if (i12 < i11) {
            i12 = Integer.highestOneBit(i11 - 1) << 1;
        }
        if (i12 < 0) {
            return Integer.MAX_VALUE;
        }
        return i12;
    }

    public final void a(Object obj) {
        obj.getClass();
        d(1);
        Object[] objArr = this.f9570a;
        int i10 = this.f9571b;
        this.f9571b = i10 + 1;
        objArr[i10] = obj;
    }

    public abstract a0 b(Object obj);

    public final void c(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            d(collection.size());
            if (collection instanceof b0) {
                this.f9571b = ((b0) collection).g(this.f9571b, this.f9570a);
                return;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final void d(int i10) {
        Object[] objArr = this.f9570a;
        int e7 = e(objArr.length, this.f9571b + i10);
        if (e7 > objArr.length || this.f9572c) {
            this.f9570a = Arrays.copyOf(this.f9570a, e7);
            this.f9572c = false;
        }
    }
}
