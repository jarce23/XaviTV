package com.bumptech.glide;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: o, reason: collision with root package name */
    public k6.a f2985o;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final boolean b(Object obj) {
        if (obj instanceof a) {
            return m6.n.b(this.f2985o, ((a) obj).f2985o);
        }
        return false;
    }

    public final int c() {
        k6.a aVar = this.f2985o;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b(obj);
    }

    public final int hashCode() {
        return c();
    }
}
