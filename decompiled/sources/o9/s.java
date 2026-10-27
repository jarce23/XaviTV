package o9;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends AbstractSet {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9664o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Map f9665p;

    public /* synthetic */ s(Map map, int i10) {
        this.f9664o = i10;
        this.f9665p = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f9664o) {
            case 0:
                ((u) this.f9665p).clear();
                break;
            case 1:
                ((u) this.f9665p).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f9664o) {
            case 0:
                u uVar = (u) this.f9665p;
                Map b2 = uVar.b();
                if (b2 != null) {
                    return b2.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int d6 = uVar.d(entry.getKey());
                    if (d6 != -1 && com.bumptech.glide.d.k(uVar.j()[d6], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            case 1:
                return ((u) this.f9665p).containsKey(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f9664o) {
            case 0:
                u uVar = (u) this.f9665p;
                Map b2 = uVar.b();
                return b2 != null ? b2.entrySet().iterator() : new r(uVar, 1);
            case 1:
                u uVar2 = (u) this.f9665p;
                Map b10 = uVar2.b();
                return b10 != null ? b10.keySet().iterator() : new r(uVar2, 0);
            default:
                return new p.c((p.e) this.f9665p);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f9664o) {
            case 0:
                u uVar = (u) this.f9665p;
                Map b2 = uVar.b();
                if (b2 != null) {
                    return b2.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!uVar.f()) {
                        int c10 = uVar.c();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object obj2 = uVar.f9673o;
                        Objects.requireNonNull(obj2);
                        int k10 = q.k(key, value, c10, obj2, uVar.h(), uVar.i(), uVar.j());
                        if (k10 != -1) {
                            uVar.e(k10, c10);
                            uVar.f9678t--;
                            uVar.f9677s += 32;
                            return true;
                        }
                    }
                }
                return false;
            case 1:
                u uVar2 = (u) this.f9665p;
                Map b10 = uVar2.b();
                return b10 != null ? b10.keySet().remove(obj) : uVar2.g(obj) != u.f9672x;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f9664o) {
            case 0:
                return ((u) this.f9665p).size();
            case 1:
                return ((u) this.f9665p).size();
            default:
                return ((p.e) this.f9665p).f9781q;
        }
    }
}
