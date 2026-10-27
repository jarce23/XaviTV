package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import d.a;
import d9.f;
import f9.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: h, reason: collision with root package name */
    public final f f3837h;

    public BaseTransientBottomBar$Behavior() {
        f fVar = new f(19);
        this.f3678e = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f3679f = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f3677d = 0;
        this.f3837h = fVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, z.a
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f3837h.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (a.f3947b == null) {
                    a.f3947b = new a();
                }
                synchronized (a.f3947b.f3948a) {
                }
            }
        } else if (coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (a.f3947b == null) {
                a.f3947b = new a();
            }
            a.f3947b.b();
        }
        return super.f(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean r(View view) {
        this.f3837h.getClass();
        return view instanceof c;
    }
}
