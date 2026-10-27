package io.realm.internal;

import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f6748a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6749b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6750c = false;

    public m(Object obj, Object obj2) {
        this.f6749b = obj2;
        this.f6748a = new WeakReference(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.f6749b.equals(mVar.f6749b) && this.f6748a.get() == mVar.f6748a.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f6748a.get();
        int hashCode = (527 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.f6749b;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }
}
