package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements View.OnTouchListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f3902o;

    public l(GestureDetector gestureDetector) {
        this.f3902o = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f3902o.onTouchEvent(motionEvent);
        }
        return false;
    }
}
