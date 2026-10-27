package w3;

import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends m {

    /* renamed from: a, reason: collision with root package name */
    public final String f12908a;

    /* renamed from: b, reason: collision with root package name */
    public final c f12909b;

    public d(String str, c cVar) {
        this.f12908a = str;
        this.f12909b = cVar;
    }

    @Override // w3.m
    public final void f(int i10) {
        c cVar;
        boolean isReleased;
        String str = this.f12908a;
        if (str == null || (cVar = this.f12909b) == null) {
            return;
        }
        Messenger messenger = cVar.f12899h;
        MediaRouter2.RoutingController routingController = cVar.g;
        if (routingController != null) {
            isReleased = routingController.isReleased();
            if (isReleased || messenger == null) {
                return;
            }
            int andIncrement = cVar.f12903l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i10);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = cVar.f12900i;
            try {
                messenger.send(obtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e7) {
                Log.e("MR2Provider", "Could not send control request to service.", e7);
            }
        }
    }

    @Override // w3.m
    public final void i(int i10) {
        c cVar;
        boolean isReleased;
        String str = this.f12908a;
        if (str == null || (cVar = this.f12909b) == null) {
            return;
        }
        Messenger messenger = cVar.f12899h;
        MediaRouter2.RoutingController routingController = cVar.g;
        if (routingController != null) {
            isReleased = routingController.isReleased();
            if (isReleased || messenger == null) {
                return;
            }
            int andIncrement = cVar.f12903l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 8;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i10);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = cVar.f12900i;
            try {
                messenger.send(obtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e7) {
                Log.e("MR2Provider", "Could not send control request to service.", e7);
            }
        }
    }
}
