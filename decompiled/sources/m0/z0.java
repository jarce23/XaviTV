package m0;

import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.view.SurfaceControl;
import android.view.WindowInsets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class z0 {
    public static /* bridge */ /* synthetic */ ColorStateListDrawable b(Drawable drawable) {
        return (ColorStateListDrawable) drawable;
    }

    public static /* synthetic */ SurfaceControl.Transaction c() {
        return new SurfaceControl.Transaction();
    }

    public static /* synthetic */ WindowInsets.Builder d() {
        return new WindowInsets.Builder();
    }

    public static /* synthetic */ WindowInsets.Builder e(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    public static /* bridge */ /* synthetic */ boolean t(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }
}
