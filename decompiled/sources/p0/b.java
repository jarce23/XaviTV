package p0;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import java.lang.ref.ReferenceQueue;
import java.util.Objects;
import java.util.WeakHashMap;
import m.o1;
import m0.k0;
import p4.p;
import p7.v;
import w3.q0;
import w3.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9793o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f9794p;

    public /* synthetic */ b(int i10, Object obj) {
        this.f9793o = i10;
        this.f9794p = obj;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f9793o;
        Object obj = this.f9794p;
        switch (i10) {
            case 0:
                e eVar = (e) obj;
                o1 o1Var = eVar.f9797q;
                a aVar = eVar.f9795o;
                if (eVar.C) {
                    if (eVar.A) {
                        eVar.A = false;
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f9789e = currentAnimationTimeMillis;
                        aVar.g = -1L;
                        aVar.f9790f = currentAnimationTimeMillis;
                        aVar.f9791h = 0.5f;
                    }
                    if ((aVar.g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar.g + aVar.f9792i) || !eVar.e()) {
                        eVar.C = false;
                        return;
                    }
                    if (eVar.B) {
                        eVar.B = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        o1Var.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (aVar.f9790f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a10 = aVar.a(currentAnimationTimeMillis2);
                    long j10 = currentAnimationTimeMillis2 - aVar.f9790f;
                    aVar.f9790f = currentAnimationTimeMillis2;
                    eVar.E.scrollListBy((int) (j10 * ((a10 * 4.0f) + ((-4.0f) * a10 * a10)) * aVar.f9788d));
                    WeakHashMap weakHashMap = k0.f8683a;
                    o1Var.postOnAnimation(this);
                    return;
                }
                return;
            case 1:
                ((p7.k) obj).a();
                return;
            case 2:
                p7.k kVar = (p7.k) ((p) obj).f9953p;
                ((com.google.android.gms.common.internal.a) kVar.f10054c).e(kVar.f10054c.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 3:
                ((v) obj).f10099i.d(new n7.a(4, null, null));
                return;
            case 4:
                throw null;
            case 5:
                ((s0.d) obj).n(0);
                return;
            case 6:
                x4.i iVar = (x4.i) obj;
                iVar.getClass();
                while (true) {
                    try {
                        iVar.e((t5.a) ((ReferenceQueue) iVar.f13555r).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            case 7:
                ((w) obj).l();
                return;
            default:
                ((q0) obj).c();
                return;
        }
    }

    public b(p7.i iVar, app.shamel.tv.b bVar) {
        this.f9793o = 4;
        Objects.requireNonNull(iVar);
        this.f9794p = bVar;
    }

    public b(v vVar) {
        this.f9793o = 3;
        Objects.requireNonNull(vVar);
        this.f9794p = vVar;
    }
}
