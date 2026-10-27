package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends f {
    final /* synthetic */ c0 this$0;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class a extends f {
        final /* synthetic */ c0 this$0;

        public a(c0 c0Var) {
            this.this$0 = c0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            za.h.e("activity", activity);
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            za.h.e("activity", activity);
            c0 c0Var = this.this$0;
            int i10 = c0Var.f1117o + 1;
            c0Var.f1117o = i10;
            if (i10 == 1 && c0Var.f1120r) {
                c0Var.f1122t.d(l.ON_START);
                c0Var.f1120r = false;
            }
        }
    }

    public b0(c0 c0Var) {
        this.this$0 = c0Var;
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        za.h.e("activity", activity);
        if (Build.VERSION.SDK_INT < 29) {
            int i10 = f0.f1126p;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            za.h.c("null cannot be cast to non-null type androidx.lifecycle.ReportFragment", findFragmentByTag);
            ((f0) findFragmentByTag).f1127o = this.this$0.f1124v;
        }
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        za.h.e("activity", activity);
        c0 c0Var = this.this$0;
        int i10 = c0Var.f1118p - 1;
        c0Var.f1118p = i10;
        if (i10 == 0) {
            Handler handler = c0Var.f1121s;
            za.h.b(handler);
            handler.postDelayed(c0Var.f1123u, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        za.h.e("activity", activity);
        a0.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        za.h.e("activity", activity);
        c0 c0Var = this.this$0;
        int i10 = c0Var.f1117o - 1;
        c0Var.f1117o = i10;
        if (i10 == 0 && c0Var.f1119q) {
            c0Var.f1122t.d(l.ON_STOP);
            c0Var.f1120r = true;
        }
    }
}
