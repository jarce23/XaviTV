package app.shamel.tv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.leanback.widget.HorizontalGridView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class LiveHorizontalGridView extends HorizontalGridView {

    /* renamed from: o1, reason: collision with root package name */
    public int f2111o1;

    /* renamed from: p1, reason: collision with root package name */
    public boolean f2112p1;

    public LiveHorizontalGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2111o1 = 0;
        this.f2112p1 = true;
    }

    @Override // androidx.leanback.widget.f, android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int selectedPosition = getSelectedPosition();
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode == 22 && selectedPosition != -1 && getAdapter() != null && selectedPosition == getAdapter().a() - 1 && this.f2112p1) {
                    setSelectedPosition(0);
                    return true;
                }
            } else if (selectedPosition != -1 && getAdapter() != null) {
                int a10 = getAdapter().a();
                if (selectedPosition != 0 || !this.f2112p1) {
                    return false;
                }
                setSelectedPosition(a10 - 1);
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int getPage() {
        return this.f2111o1;
    }

    public void setLoop(boolean z10) {
        this.f2112p1 = z10;
    }

    public void setPage(int i10) {
        this.f2111o1 = i10;
    }
}
