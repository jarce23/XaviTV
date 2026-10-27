package p7;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: s, reason: collision with root package name */
    public static final b f10033s = new b();

    /* renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f10034o = new AtomicBoolean();

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f10035p = new AtomicBoolean();

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f10036q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public boolean f10037r = false;

    public final void a(j jVar) {
        synchronized (f10033s) {
            this.f10036q.add(jVar);
        }
    }

    public final void b(boolean z10) {
        synchronized (f10033s) {
            try {
                ArrayList arrayList = this.f10036q;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    Boolean valueOf = Boolean.valueOf(z10);
                    d dVar = ((j) obj).f10052a;
                    dVar.A.sendMessage(dVar.A.obtainMessage(1, valueOf));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f10034o.compareAndSet(true, false);
        this.f10035p.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f10034o.compareAndSet(true, false);
        this.f10035p.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f10034o.compareAndSet(false, true)) {
            this.f10035p.set(true);
            b(true);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
