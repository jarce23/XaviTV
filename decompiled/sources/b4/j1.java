package b4;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2287a;

    /* renamed from: b, reason: collision with root package name */
    public int f2288b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2289c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2290d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2291e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f2292f;
    public final /* synthetic */ StaggeredGridLayoutManager g;

    public j1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f2287a = -1;
        this.f2288b = Integer.MIN_VALUE;
        this.f2289c = false;
        this.f2290d = false;
        this.f2291e = false;
        int[] iArr = this.f2292f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
