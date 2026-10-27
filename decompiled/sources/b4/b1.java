package b4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2185a;

    /* renamed from: b, reason: collision with root package name */
    public int f2186b;

    /* renamed from: c, reason: collision with root package name */
    public int f2187c;

    /* renamed from: d, reason: collision with root package name */
    public int f2188d;

    /* renamed from: e, reason: collision with root package name */
    public int f2189e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2190f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2191h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2192i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2193j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2194k;

    /* renamed from: l, reason: collision with root package name */
    public int f2195l;

    /* renamed from: m, reason: collision with root package name */
    public long f2196m;

    /* renamed from: n, reason: collision with root package name */
    public int f2197n;

    /* renamed from: o, reason: collision with root package name */
    public int f2198o;

    /* renamed from: p, reason: collision with root package name */
    public int f2199p;

    public final void a(int i10) {
        if ((this.f2188d & i10) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f2188d));
    }

    public final int b() {
        return this.g ? this.f2186b - this.f2187c : this.f2189e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f2185a + ", mData=null, mItemCount=" + this.f2189e + ", mIsMeasuring=" + this.f2192i + ", mPreviousLayoutItemCount=" + this.f2186b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2187c + ", mStructureChanged=" + this.f2190f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.f2193j + ", mRunPredictiveAnimations=" + this.f2194k + '}';
    }
}
