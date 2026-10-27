package x5;

import java.util.ArrayDeque;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayDeque f13662b;

    /* renamed from: a, reason: collision with root package name */
    public Object f13663a;

    static {
        char[] cArr = m6.n.f9027a;
        f13662b = new ArrayDeque(0);
    }

    public static r a(Object obj) {
        r rVar;
        ArrayDeque arrayDeque = f13662b;
        synchronized (arrayDeque) {
            rVar = (r) arrayDeque.poll();
        }
        if (rVar == null) {
            rVar = new r();
        }
        rVar.f13663a = obj;
        return rVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof r) && this.f13663a.equals(((r) obj).f13663a);
    }

    public final int hashCode() {
        return this.f13663a.hashCode();
    }
}
