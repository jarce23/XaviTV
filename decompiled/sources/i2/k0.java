package i2;

import android.os.Handler;
import i1.f1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6225a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f6226b;

    /* renamed from: c, reason: collision with root package name */
    public final s1.x f6227c;

    public k0(Handler handler, s1.x xVar, int i10) {
        this.f6225a = i10;
        switch (i10) {
            case 1:
                this.f6226b = handler;
                this.f6227c = xVar;
                break;
            default:
                if (xVar != null) {
                    handler.getClass();
                } else {
                    handler = null;
                }
                this.f6226b = handler;
                this.f6227c = xVar;
                break;
        }
    }

    private final void b(s1.e eVar) {
        synchronized (eVar) {
        }
        Handler handler = this.f6226b;
        if (handler != null) {
            handler.post(new j0(this, eVar, 1));
        }
    }

    public final void a(s1.e eVar) {
        switch (this.f6225a) {
            case 0:
                b(eVar);
                break;
            default:
                synchronized (eVar) {
                }
                Handler handler = this.f6226b;
                if (handler != null) {
                    handler.post(new u1.j(this, eVar, 1));
                    break;
                }
                break;
        }
    }

    public void c(f1 f1Var) {
        Handler handler = this.f6226b;
        if (handler != null) {
            handler.post(new androidx.fragment.app.d(this, 7, f1Var));
        }
    }
}
