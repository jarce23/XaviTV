package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class u extends Service implements r {

    /* renamed from: o, reason: collision with root package name */
    public final x4.m f1163o = new x4.m(this);

    @Override // androidx.lifecycle.r
    public final t f() {
        return (t) this.f1163o.f13564p;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        za.h.e("intent", intent);
        this.f1163o.E(l.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f1163o.E(l.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        l lVar = l.ON_STOP;
        x4.m mVar = this.f1163o;
        mVar.E(lVar);
        mVar.E(l.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i10) {
        this.f1163o.E(l.ON_START);
        super.onStart(intent, i10);
    }
}
