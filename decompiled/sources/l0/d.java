package l0;

import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: o, reason: collision with root package name */
    public final Object[] f8062o;

    /* renamed from: p, reason: collision with root package name */
    public int f8063p;

    public d(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f8062o = new Object[i10];
    }

    public void a(s.b bVar) {
        int i10 = this.f8063p;
        Object[] objArr = this.f8062o;
        if (i10 < objArr.length) {
            objArr[i10] = bVar;
            this.f8063p = i10 + 1;
        }
    }

    @Override // l0.c
    public boolean m(Object obj) {
        Object[] objArr;
        boolean z10;
        h.e("instance", obj);
        int i10 = this.f8063p;
        int i11 = 0;
        while (true) {
            objArr = this.f8062o;
            if (i11 >= i10) {
                z10 = false;
                break;
            }
            if (objArr[i11] == obj) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i12 = this.f8063p;
        if (i12 >= objArr.length) {
            return false;
        }
        objArr[i12] = obj;
        this.f8063p = i12 + 1;
        return true;
    }

    @Override // l0.c
    public Object v() {
        int i10 = this.f8063p;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f8062o;
        Object obj = objArr[i11];
        h.c("null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool", obj);
        objArr[i11] = null;
        this.f8063p--;
        return obj;
    }

    public d() {
        this.f8062o = new Object[256];
    }
}
