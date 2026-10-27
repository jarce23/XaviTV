package b4;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public int f2467a;

    /* renamed from: b, reason: collision with root package name */
    public int f2468b;

    /* renamed from: c, reason: collision with root package name */
    public int f2469c;

    /* renamed from: d, reason: collision with root package name */
    public int f2470d;

    /* renamed from: e, reason: collision with root package name */
    public Interpolator f2471e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2472f;
    public int g;

    public final void a(RecyclerView recyclerView) {
        int i10 = this.f2470d;
        if (i10 >= 0) {
            this.f2470d = -1;
            recyclerView.O(i10);
            this.f2472f = false;
            return;
        }
        if (!this.f2472f) {
            this.g = 0;
            return;
        }
        Interpolator interpolator = this.f2471e;
        if (interpolator != null && this.f2469c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i11 = this.f2469c;
        if (i11 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.f1481s0.c(this.f2467a, this.f2468b, i11, interpolator);
        int i12 = this.g + 1;
        this.g = i12;
        if (i12 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f2472f = false;
    }
}
