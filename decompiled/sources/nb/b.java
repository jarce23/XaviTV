package nb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b extends q {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9311a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus$volatile");
    private volatile /* synthetic */ Object _consensus$volatile = a.f9305a;

    @Override // nb.q
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9311a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        androidx.emoji2.text.s sVar = a.f9305a;
        if (obj2 == sVar) {
            androidx.emoji2.text.s c10 = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == sVar) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, sVar, c10)) {
                        obj2 = c10;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != sVar) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract androidx.emoji2.text.s c(Object obj);
}
