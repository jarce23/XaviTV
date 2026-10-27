package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k4 extends b4 implements Runnable {

    /* renamed from: w, reason: collision with root package name */
    public final Runnable f3352w;

    public k4(Runnable runnable) {
        runnable.getClass();
        this.f3352w = runnable;
    }

    @Override // com.google.android.gms.internal.cast.b4
    public final String F() {
        return android.support.v4.media.d.q("task=[", this.f3352w.toString(), "]");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3352w.run();
        } catch (Error | RuntimeException e7) {
            if (b4.f3264u.K(this, null, new u3(e7))) {
                b4.J(this);
            }
            throw e7;
        }
    }
}
