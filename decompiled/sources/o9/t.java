package o9;

import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends m {

    /* renamed from: o, reason: collision with root package name */
    public final Object f9669o;

    /* renamed from: p, reason: collision with root package name */
    public int f9670p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ u f9671q;

    public t(u uVar, int i10) {
        this.f9671q = uVar;
        Object obj = u.f9672x;
        this.f9669o = uVar.i()[i10];
        this.f9670p = i10;
    }

    public final void a() {
        int i10 = this.f9670p;
        Object obj = this.f9669o;
        u uVar = this.f9671q;
        if (i10 != -1 && i10 < uVar.size()) {
            if (com.bumptech.glide.d.k(obj, uVar.i()[this.f9670p])) {
                return;
            }
        }
        Object obj2 = u.f9672x;
        this.f9670p = uVar.d(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9669o;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        u uVar = this.f9671q;
        Map b2 = uVar.b();
        if (b2 != null) {
            return b2.get(this.f9669o);
        }
        a();
        int i10 = this.f9670p;
        if (i10 == -1) {
            return null;
        }
        return uVar.j()[i10];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        u uVar = this.f9671q;
        Map b2 = uVar.b();
        Object obj2 = this.f9669o;
        if (b2 != null) {
            return b2.put(obj2, obj);
        }
        a();
        int i10 = this.f9670p;
        if (i10 == -1) {
            uVar.put(obj2, obj);
            return null;
        }
        Object obj3 = uVar.j()[i10];
        uVar.j()[this.f9670p] = obj;
        return obj3;
    }
}
