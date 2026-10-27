package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f6559a = new ThreadLocal();

    public static f0 a() {
        ThreadLocal threadLocal = f6559a;
        f0 f0Var = (f0) threadLocal.get();
        if (f0Var != null) {
            return f0Var;
        }
        c cVar = new c(Thread.currentThread());
        threadLocal.set(cVar);
        return cVar;
    }
}
