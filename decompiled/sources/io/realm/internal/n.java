package io.realm.internal;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f6751a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f6752b = false;

    public final void a(m mVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f6751a;
        if (!copyOnWriteArrayList.contains(mVar)) {
            copyOnWriteArrayList.add(mVar);
            mVar.f6750c = false;
        }
        if (this.f6752b) {
            this.f6752b = false;
        }
    }

    public final void b(l lVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f6751a;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (this.f6752b) {
                return;
            }
            Object obj = mVar.f6748a.get();
            if (obj == null) {
                copyOnWriteArrayList.remove(mVar);
            } else if (!mVar.f6750c) {
                lVar.a(mVar, obj);
            }
        }
    }

    public final void c(Object obj, Object obj2) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f6751a;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (obj == mVar.f6748a.get() && obj2.equals(mVar.f6749b)) {
                mVar.f6750c = true;
                copyOnWriteArrayList.remove(mVar);
                return;
            }
        }
    }

    public final void d(Object obj) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f6751a;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            Object obj2 = mVar.f6748a.get();
            if (obj2 == null || obj2 == obj) {
                mVar.f6750c = true;
                copyOnWriteArrayList.remove(mVar);
            }
        }
    }
}
