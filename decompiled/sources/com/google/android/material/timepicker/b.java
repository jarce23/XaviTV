package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3896o;

    public b(ClockFaceView clockFaceView) {
        this.f3896o = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f3896o;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.J.f3886r) - clockFaceView.R;
        if (height != clockFaceView.H) {
            clockFaceView.H = height;
            clockFaceView.m();
            ClockHandView clockHandView = clockFaceView.J;
            clockHandView.f3894z = clockFaceView.H;
            clockHandView.invalidate();
        }
        return true;
    }
}
