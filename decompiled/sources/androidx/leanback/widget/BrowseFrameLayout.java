package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class BrowseFrameLayout extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public View.OnKeyListener f891o;

    public BrowseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        View.OnKeyListener onKeyListener = this.f891o;
        return (onKeyListener == null || dispatchKeyEvent) ? dispatchKeyEvent : onKeyListener.onKey(getRootView(), keyEvent.getKeyCode(), keyEvent);
    }

    public g getOnChildFocusListener() {
        return null;
    }

    public h getOnFocusSearchListener() {
        return null;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i10, Rect rect) {
        return super.onRequestFocusInDescendants(i10, rect);
    }

    public void setOnDispatchKeyListener(View.OnKeyListener onKeyListener) {
        this.f891o = onKeyListener;
    }

    public void setOnChildFocusListener(g gVar) {
    }

    public void setOnFocusSearchListener(h hVar) {
    }
}
