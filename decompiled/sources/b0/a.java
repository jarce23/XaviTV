package b0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import app.shamel.tv.activities.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: o, reason: collision with root package name */
    public Object f2122o;

    /* renamed from: p, reason: collision with root package name */
    public Activity f2123p;

    /* renamed from: q, reason: collision with root package name */
    public final int f2124q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2125r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2126s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2127t = false;

    public a(Activity activity) {
        this.f2123p = activity;
        this.f2124q = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f2123p == activity) {
            this.f2123p = null;
            this.f2126s = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.f2126s || this.f2127t || this.f2125r) {
            return;
        }
        Object obj = this.f2122o;
        try {
            Object obj2 = b.f2130c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.f2124q) {
                b.g.postAtFrontOfQueue(new y(b.f2129b.get(activity), obj2, 4, false));
                this.f2127t = true;
                this.f2122o = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f2123p == activity) {
            this.f2125r = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
