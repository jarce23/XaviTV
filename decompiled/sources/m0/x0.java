package m0;

import android.os.Build;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public w0 f8738a;

    public x0(int i10, Interpolator interpolator, long j10) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f8738a = new v0(i2.b0.j(i10, interpolator, j10));
        } else {
            this.f8738a = new t0(i10, interpolator, j10);
        }
    }
}
