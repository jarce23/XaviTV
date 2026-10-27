package io.realm;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final x f6868a;

    public w(x xVar) {
        this.f6868a = xVar;
    }

    public static w a(String str) {
        x eVar;
        if (str == null) {
            v vVar = v.OBJECT;
            eVar = new n();
        } else {
            v vVar2 = v.OBJECT;
            eVar = new e(4, str);
        }
        return new w(eVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            return this.f6868a.equals(((w) obj).f6868a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6868a.hashCode();
    }

    public final String toString() {
        return this.f6868a.toString();
    }
}
