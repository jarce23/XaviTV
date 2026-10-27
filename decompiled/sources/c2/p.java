package c2;

import android.content.Context;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements n9.h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2675o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f2676p;

    public /* synthetic */ p(int i10, Object obj) {
        this.f2675o = i10;
        this.f2676p = obj;
    }

    @Override // n9.h
    public final Object get() {
        switch (this.f2675o) {
            case 0:
                try {
                    return (c0) ((Class) this.f2676p).getConstructor(null).newInstance(null);
                } catch (Exception e7) {
                    throw new IllegalStateException(e7);
                }
            case 1:
                return j1.c.k((Context) this.f2676p);
            case 2:
                return (f2.w) this.f2676p;
            case 3:
                return (r) this.f2676p;
            default:
                return (s1.j) this.f2676p;
        }
    }
}
