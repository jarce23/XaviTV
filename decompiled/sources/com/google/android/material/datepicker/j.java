package com.google.android.material.datepicker;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends m0.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3754d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3755e;

    public /* synthetic */ j(int i10, Object obj) {
        this.f3754d = i10;
        this.f3755e = obj;
    }

    @Override // m0.b
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f3754d) {
            case 2:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f3755e).f3811r);
                break;
            default:
                super.c(view, accessibilityEvent);
                break;
        }
    }

    @Override // m0.b
    public final void d(View view, n0.g gVar) {
        int i10 = this.f3754d;
        Object obj = this.f3755e;
        View.AccessibilityDelegate accessibilityDelegate = this.f8638a;
        switch (i10) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, gVar.f9111a);
                l lVar = (l) obj;
                gVar.b(new n0.d(16, lVar.f3768s0.getVisibility() == 0 ? lVar.l().getString(R.string.mtrl_picker_toggle_to_year_selection) : lVar.l().getString(R.string.mtrl_picker_toggle_to_day_selection)));
                break;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, gVar.f9111a);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i11 = MaterialButtonToggleGroup.E;
                int i12 = -1;
                if (view instanceof MaterialButton) {
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        if (i13 < materialButtonToggleGroup.getChildCount()) {
                            if (materialButtonToggleGroup.getChildAt(i13) == view) {
                                i12 = i14;
                            } else {
                                if ((materialButtonToggleGroup.getChildAt(i13) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i13).getVisibility() != 8) {
                                    i14++;
                                }
                                i13++;
                            }
                        }
                    }
                }
                gVar.k(d.a.a(((MaterialButton) view).C, 0, 1, i12, 1));
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo = gVar.f9111a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f3812s);
                accessibilityNodeInfo.setChecked(checkableImageButton.f3811r);
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo2 = gVar.f9111a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).L);
                break;
        }
    }
}
