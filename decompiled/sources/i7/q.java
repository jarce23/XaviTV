package i7;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayDeque;
import java.util.TimerTask;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends TimerTask {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c f6518o;

    public q(c cVar) {
        this.f6518o = cVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        BasePendingResult basePendingResult;
        c cVar = this.f6518o;
        ArrayDeque arrayDeque = cVar.f6475h;
        if (arrayDeque.isEmpty() || cVar.f6478k != null || cVar.f6470b == 0) {
            return;
        }
        h hVar = cVar.f6471c;
        int[] e7 = l7.a.e(arrayDeque);
        hVar.getClass();
        r7.r.b();
        if (hVar.x()) {
            j jVar = new j(hVar, e7);
            h.y(jVar);
            basePendingResult = jVar;
        } else {
            basePendingResult = h.u();
        }
        cVar.f6478k = basePendingResult;
        basePendingResult.S(new p(cVar, 1));
        arrayDeque.clear();
    }
}
