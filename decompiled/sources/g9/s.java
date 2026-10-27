package g9;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5387a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5388b;

    public /* synthetic */ s(int i10, Object obj) {
        this.f5387a = i10;
        this.f5388b = obj;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f5387a) {
            case 1:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(SeekBar.class.getName());
                CastSeekBar castSeekBar = (CastSeekBar) this.f5388b;
                castSeekBar.f3177o.getClass();
                accessibilityEvent.setItemCount(1);
                accessibilityEvent.setCurrentItemIndex(castSeekBar.getProgress());
                break;
            default:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        switch (this.f5387a) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                EditText editText = ((t) this.f5388b).f5395h.getEditText();
                if (editText != null) {
                    accessibilityNodeInfo.setLabeledBy(editText);
                    break;
                }
                break;
            default:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName(SeekBar.class.getName());
                if (view.isEnabled()) {
                    accessibilityNodeInfo.addAction(4096);
                    accessibilityNodeInfo.addAction(8192);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        switch (this.f5387a) {
            case 1:
                CastSeekBar castSeekBar = (CastSeekBar) this.f5388b;
                k7.a aVar = castSeekBar.f3177o;
                if (!view.isEnabled()) {
                    return false;
                }
                if (super.performAccessibilityAction(view, i10, bundle)) {
                    return true;
                }
                if (i10 != 4096 && i10 != 8192) {
                    return false;
                }
                int i11 = CastSeekBar.f3176x;
                aVar.getClass();
                castSeekBar.getProgress();
                aVar.getClass();
                return false;
            default:
                return super.performAccessibilityAction(view, i10, bundle);
        }
    }
}
