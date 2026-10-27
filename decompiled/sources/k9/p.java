package k9;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f7854a;

    public /* synthetic */ p(q qVar) {
        this.f7854a = qVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        q qVar = this.f7854a;
        qVar.f7857b.h("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        qVar.a().post(new j9.f(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        q qVar = this.f7854a;
        qVar.f7857b.h("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        qVar.a().post(new o(1, this));
    }
}
