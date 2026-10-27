package io.realm.internal;

import d5.l0;
import d5.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6745a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6746b;

    public /* synthetic */ i() {
        this.f6745a = 0;
    }

    @Override // io.realm.internal.l
    public void a(m mVar, Object obj) {
        OsSharedRealm osSharedRealm;
        OsSharedRealm osSharedRealm2;
        switch (this.f6745a) {
            case 1:
                OsCollectionChangeSet osCollectionChangeSet = (OsCollectionChangeSet) this.f6746b;
                Object obj2 = ((k) mVar).f6749b;
                if (!(obj2 instanceof l0)) {
                    throw new RuntimeException("Unsupported listener type: " + obj2);
                }
                l0 l0Var = (l0) obj2;
                char c10 = osCollectionChangeSet.e() ? (char) 1 : (char) 2;
                x0 x0Var = l0Var.f4132a;
                if (c10 == 1) {
                    x0Var.d();
                    return;
                }
                return;
            default:
                x xVar = (x) mVar;
                RealmNotifier realmNotifier = (RealmNotifier) this.f6746b;
                osSharedRealm = realmNotifier.sharedRealm;
                if (osSharedRealm != null) {
                    osSharedRealm2 = realmNotifier.sharedRealm;
                    if (osSharedRealm2.isClosed()) {
                        return;
                    }
                    xVar.f6749b.getClass();
                    throw new ClassCastException();
                }
                return;
        }
    }

    public synchronized void b(NativeObjectReference nativeObjectReference) {
        try {
            NativeObjectReference nativeObjectReference2 = nativeObjectReference.f6683e;
            NativeObjectReference nativeObjectReference3 = nativeObjectReference.f6682d;
            nativeObjectReference.f6683e = null;
            nativeObjectReference.f6682d = null;
            if (nativeObjectReference3 != null) {
                nativeObjectReference3.f6683e = nativeObjectReference2;
            } else {
                this.f6746b = nativeObjectReference2;
            }
            if (nativeObjectReference2 != null) {
                nativeObjectReference2.f6682d = nativeObjectReference3;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ i(int i10, Object obj) {
        this.f6745a = i10;
        this.f6746b = obj;
    }
}
