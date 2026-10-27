package m0;

import android.os.Build;
import androidx.core.widget.NestedScrollView;
import j9.v1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final q f8707a;

    public r(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f8707a = new p(nestedScrollView);
        } else {
            this.f8707a = new v1(5);
        }
    }
}
