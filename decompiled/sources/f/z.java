package f;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z extends ContentFrameLayout {

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b0 f4859w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(b0 b0Var, k.c cVar) {
        super(cVar, null);
        this.f4859w = b0Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f4859w.t(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x6 = (int) motionEvent.getX();
            int y8 = (int) motionEvent.getY();
            if (x6 < -5 || y8 < -5 || x6 > getWidth() + 5 || y8 > getHeight() + 5) {
                b0 b0Var = this.f4859w;
                b0Var.q(b0Var.z(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i10) {
        setBackgroundDrawable(n4.a.o(getContext(), i10));
    }
}
