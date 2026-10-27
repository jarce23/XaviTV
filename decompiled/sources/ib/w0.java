package ib;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 implements j0 {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6608b = AtomicIntegerFieldUpdater.newUpdater(w0.class, "_isCompleting$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6609c = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_rootCause$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6610d = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final z0 f6611a;

    public w0(z0 z0Var, Throwable th) {
        this.f6611a = z0Var;
        this._rootCause$volatile = th;
    }

    @Override // ib.j0
    public final boolean a() {
        return c() == null;
    }

    public final void b(Throwable th) {
        Throwable c10 = c();
        if (c10 == null) {
            f6609c.set(this, th);
            return;
        }
        if (th == c10) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6610d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    public final Throwable c() {
        return (Throwable) f6609c.get(this);
    }

    public final boolean d() {
        return c() != null;
    }

    @Override // ib.j0
    public final z0 e() {
        return this.f6611a;
    }

    public final boolean f() {
        return f6608b.get(this) != 0;
    }

    public final ArrayList g(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6610d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable c10 = c();
        if (c10 != null) {
            arrayList.add(0, c10);
        }
        if (th != null && !th.equals(c10)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, v.g);
        return arrayList;
    }

    public final String toString() {
        return "Finishing[cancelling=" + d() + ", completing=" + f() + ", rootCause=" + c() + ", exceptions=" + f6610d.get(this) + ", list=" + this.f6611a + ']';
    }
}
