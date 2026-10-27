package m0;

import android.view.View;
import android.view.Window;
import j9.w1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class r1 extends y7.d {

    /* renamed from: d, reason: collision with root package name */
    public final Window f8713d;

    public r1(Window window, w1 w1Var) {
        this.f8713d = window;
    }

    public final void M(int i10) {
        View decorView = this.f8713d.getDecorView();
        decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
    }

    @Override // y7.d
    public final void n(boolean z10) {
        if (!z10) {
            M(8192);
            return;
        }
        Window window = this.f8713d;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(8192 | decorView.getSystemUiVisibility());
    }
}
