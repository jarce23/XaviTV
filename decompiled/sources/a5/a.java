package a5;

import android.os.Handler;
import android.os.Looper;
import b8.e;
import java.util.concurrent.Executor;
import s6.n;
import x4.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f30o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f31p;

    public /* synthetic */ a(int i10, Object obj) {
        this.f30o = i10;
        this.f31p = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f30o) {
            case 0:
                ((Handler) ((i) this.f31p).f13555r).post(runnable);
                break;
            case 1:
                ((e) this.f31p).post(runnable);
                break;
            default:
                ((Executor) this.f31p).execute(new n(runnable, 0));
                break;
        }
    }

    public a() {
        this.f30o = 1;
        e eVar = new e(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f31p = eVar;
    }
}
