package u8;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: o, reason: collision with root package name */
    public final Dialog f12562o;

    /* renamed from: p, reason: collision with root package name */
    public final int f12563p;

    /* renamed from: q, reason: collision with root package name */
    public final int f12564q;

    /* renamed from: r, reason: collision with root package name */
    public final int f12565r;

    public a(Dialog dialog, Rect rect) {
        this.f12562o = dialog;
        this.f12563p = rect.left;
        this.f12564q = rect.top;
        this.f12565r = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = findViewById.getLeft() + this.f12563p;
        int width = findViewById.getWidth() + left;
        if (new RectF(left, findViewById.getTop() + this.f12564q, width, findViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i10 = this.f12565r;
            obtain.setLocation((-i10) - 1, (-i10) - 1);
        }
        view.performClick();
        return this.f12562o.onTouchEvent(obtain);
    }
}
