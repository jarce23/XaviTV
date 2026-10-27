package m0;

import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s1 extends r1 {
    @Override // y7.d
    public final void m(boolean z10) {
        if (!z10) {
            M(16);
            return;
        }
        Window window = this.f8713d;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(16 | decorView.getSystemUiVisibility());
    }
}
