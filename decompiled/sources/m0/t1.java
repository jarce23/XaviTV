package m0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import j9.w1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class t1 extends y7.d {

    /* renamed from: d, reason: collision with root package name */
    public final WindowInsetsController f8720d;

    /* renamed from: e, reason: collision with root package name */
    public Window f8721e;

    public t1(WindowInsetsController windowInsetsController, w1 w1Var) {
        this.f8720d = windowInsetsController;
    }

    @Override // y7.d
    public final void m(boolean z10) {
        Window window = this.f8721e;
        if (z10) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f8720d.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f8720d.setSystemBarsAppearance(0, 16);
    }

    @Override // y7.d
    public final void n(boolean z10) {
        Window window = this.f8721e;
        if (z10) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.f8720d.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f8720d.setSystemBarsAppearance(0, 8);
    }
}
