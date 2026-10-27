package l0;

import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: q, reason: collision with root package name */
    public final Object f8064q;

    public e(int i10) {
        super(i10);
        this.f8064q = new Object();
    }

    @Override // l0.d, l0.c
    public final boolean m(Object obj) {
        boolean m10;
        h.e("instance", obj);
        synchronized (this.f8064q) {
            m10 = super.m(obj);
        }
        return m10;
    }

    @Override // l0.d, l0.c
    public final Object v() {
        Object v10;
        synchronized (this.f8064q) {
            v10 = super.v();
        }
        return v10;
    }
}
