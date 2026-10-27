package p1;

import android.os.ConditionVariable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends Thread {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ConditionVariable f9863o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ s f9864p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, ConditionVariable conditionVariable) {
        super("ExoPlayer:SimpleCacheInit");
        this.f9864p = sVar;
        this.f9863o = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        synchronized (this.f9864p) {
            this.f9863o.open();
            s.a(this.f9864p);
            this.f9864p.f9867b.getClass();
        }
    }
}
