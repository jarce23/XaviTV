package w3;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final Messenger f12940a;

    /* renamed from: b, reason: collision with root package name */
    public final f.c f12941b;

    /* renamed from: c, reason: collision with root package name */
    public final Messenger f12942c;

    /* renamed from: f, reason: collision with root package name */
    public int f12945f;
    public int g;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o0 f12947i;

    /* renamed from: d, reason: collision with root package name */
    public int f12943d = 1;

    /* renamed from: e, reason: collision with root package name */
    public int f12944e = 1;

    /* renamed from: h, reason: collision with root package name */
    public final SparseArray f12946h = new SparseArray();

    public j0(o0 o0Var, Messenger messenger) {
        this.f12947i = o0Var;
        this.f12940a = messenger;
        f.c cVar = new f.c(this);
        this.f12941b = cVar;
        this.f12942c = new Messenger(cVar);
    }

    public final void a(int i10) {
        int i11 = this.f12943d;
        this.f12943d = i11 + 1;
        b(5, i11, i10, null, null);
    }

    public final boolean b(int i10, int i11, int i12, Bundle bundle, Bundle bundle2) {
        Message obtain = Message.obtain();
        obtain.what = i10;
        obtain.arg1 = i11;
        obtain.arg2 = i12;
        obtain.obj = bundle;
        obtain.setData(bundle2);
        obtain.replyTo = this.f12942c;
        try {
            this.f12940a.send(obtain);
            return true;
        } catch (DeadObjectException unused) {
            return false;
        } catch (RemoteException e7) {
            if (i10 == 2) {
                return false;
            }
            Log.e("MediaRouteProviderProxy", "Could not send message to service.", e7);
            return false;
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        this.f12947i.f12986j.post(new i0(this, 1));
    }

    public final void c(int i10, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i11);
        int i12 = this.f12943d;
        this.f12943d = i12 + 1;
        b(7, i12, i10, null, bundle);
    }

    public final void d(int i10, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i11);
        int i12 = this.f12943d;
        this.f12943d = i12 + 1;
        b(8, i12, i10, null, bundle);
    }
}
