package s1;

import android.os.Looper;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    public final a1 f11224a;

    /* renamed from: b, reason: collision with root package name */
    public final z0 f11225b;

    /* renamed from: c, reason: collision with root package name */
    public int f11226c;

    /* renamed from: d, reason: collision with root package name */
    public Object f11227d;

    /* renamed from: e, reason: collision with root package name */
    public final Looper f11228e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11229f;

    public b1(z0 z0Var, a1 a1Var, i1.t0 t0Var, int i10, Looper looper) {
        this.f11225b = z0Var;
        this.f11224a = a1Var;
        this.f11228e = looper;
    }

    public final synchronized void a(boolean z10) {
        notifyAll();
    }

    public final void b() {
        l1.d.g(!this.f11229f);
        this.f11229f = true;
        h0 h0Var = (h0) this.f11225b;
        if (!h0Var.V && h0Var.f11345x.getThread().isAlive()) {
            h0Var.f11343v.a(14, this).b();
        } else {
            l1.b.q("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            a(false);
        }
    }
}
