package z3;

import android.view.Choreographer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d {
    public static void a(Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new t0.b(runnable, 1));
    }
}
