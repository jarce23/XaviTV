package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 extends g0 {

    /* renamed from: r, reason: collision with root package name */
    public final transient o0 f3349r;

    /* renamed from: s, reason: collision with root package name */
    public final transient Object[] f3350s;

    /* renamed from: t, reason: collision with root package name */
    public final transient int f3351t;

    public k0(o0 o0Var, Object[] objArr, int i10) {
        this.f3349r = o0Var;
        this.f3350s = objArr;
        this.f3351t = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f3349r.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int f(Object[] objArr) {
        e0 e0Var = this.f3311p;
        if (e0Var == null) {
            e0Var = l();
            this.f3311p = e0Var;
        }
        return e0Var.f(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        e0 e0Var = this.f3311p;
        if (e0Var == null) {
            e0Var = l();
            this.f3311p = e0Var;
        }
        return e0Var.listIterator(0);
    }

    public final e0 l() {
        return new j0(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3351t;
    }
}
