package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends m0.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3897d;

    public c(ClockFaceView clockFaceView) {
        this.f3897d = clockFaceView;
    }

    @Override // m0.b
    public final void d(View view, n0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f9111a;
        this.f8638a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (intValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.f3897d.N.get(intValue - 1));
        }
        gVar.k(d.a.a(view.isSelected(), 0, 1, intValue, 1));
        accessibilityNodeInfo.setClickable(true);
        gVar.b(n0.d.f9097e);
    }

    @Override // m0.b
    public final boolean g(View view, int i10, Bundle bundle) {
        if (i10 != 16) {
            return super.g(view, i10, bundle);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.f3897d;
        view.getHitRect(clockFaceView.K);
        float centerX = clockFaceView.K.centerX();
        float centerY = clockFaceView.K.centerY();
        clockFaceView.J.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
        clockFaceView.J.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
        return true;
    }
}
