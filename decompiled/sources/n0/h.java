package n0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class h extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final h5.i f9113a;

    public h(h5.i iVar) {
        this.f9113a = iVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
        g z10 = this.f9113a.z(i10);
        if (z10 == null) {
            return null;
        }
        return z10.f9111a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i10) {
        this.f9113a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i10) {
        g A = this.f9113a.A(i10);
        if (A == null) {
            return null;
        }
        return A.f9111a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i10, int i11, Bundle bundle) {
        return this.f9113a.G(i10, i11, bundle);
    }
}
