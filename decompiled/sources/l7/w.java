package l7;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.internal.BinderWrapper;
import h7.h0;
import j9.g1;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends com.google.android.gms.common.internal.a {
    public static final b T = new b("CastClientImpl", null);
    public static final Object U = new Object();
    public static final Object V = new Object();
    public g7.d A;
    public final CastDevice B;
    public final h0 C;
    public final HashMap D;
    public final long E;
    public final Bundle F;
    public v G;
    public String H;
    public boolean I;
    public boolean J;
    public boolean K;
    public double L;
    public g7.x M;
    public int N;
    public int O;
    public String P;
    public String Q;
    public Bundle R;
    public final HashMap S;

    public w(Context context, Looper looper, g1 g1Var, CastDevice castDevice, long j10, h0 h0Var, Bundle bundle, p7.k kVar, p7.k kVar2) {
        super(context, looper, 10, g1Var, kVar, kVar2);
        this.B = castDevice;
        this.C = h0Var;
        this.E = j10;
        this.F = bundle;
        this.D = new HashMap();
        new AtomicLong(0L);
        this.S = new HashMap();
        this.N = -1;
        this.O = -1;
        this.A = null;
        this.H = null;
        this.L = 0.0d;
        x();
        this.I = false;
        this.M = null;
        x();
    }

    public static void v(w wVar, long j10) {
        synchronized (wVar.S) {
            try {
                if (wVar.S.remove(Long.valueOf(j10)) != null) {
                    throw new ClassCastException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final int a() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final /* synthetic */ IInterface c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new g(iBinder);
    }

    @Override // com.google.android.gms.common.internal.a
    public final void d() {
        Object[] objArr = {this.G, Boolean.valueOf(n())};
        b bVar = T;
        bVar.b("disconnect(); ServiceListener=%s, isConnected=%b", objArr);
        v vVar = this.G;
        w wVar = null;
        this.G = null;
        if (vVar != null) {
            w wVar2 = (w) vVar.f8320c.getAndSet(null);
            if (wVar2 != null) {
                wVar2.N = -1;
                wVar2.O = -1;
                wVar2.A = null;
                wVar2.H = null;
                wVar2.L = 0.0d;
                wVar2.x();
                wVar2.I = false;
                wVar2.M = null;
                wVar = wVar2;
            }
            if (wVar != null) {
                w();
                try {
                    try {
                        ((g) j()).A0();
                    } finally {
                        super.d();
                    }
                } catch (RemoteException | IllegalStateException e7) {
                    bVar.a(e7, "Error while disconnecting the controller interface", new Object[0]);
                }
                return;
            }
        }
        bVar.b("already disposed, so short-circuiting", new Object[0]);
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle g() {
        Bundle bundle = this.R;
        if (bundle == null) {
            return null;
        }
        this.R = null;
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle h() {
        Bundle bundle = new Bundle();
        T.b("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.P, this.Q);
        CastDevice castDevice = this.B;
        castDevice.getClass();
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", castDevice);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.E);
        Bundle bundle2 = this.F;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        v vVar = new v(this);
        this.G = vVar;
        bundle.putParcelable("listener", new BinderWrapper(vVar));
        String str = this.P;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.Q;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String k() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String l() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.a
    public final void p(n7.a aVar) {
        super.p(aVar);
        w();
    }

    @Override // com.google.android.gms.common.internal.a
    public final void q(int i10, IBinder iBinder, Bundle bundle, int i11) {
        T.b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i10));
        if (i10 == 0 || i10 == 2300) {
            this.J = true;
            this.K = true;
        }
        if (i10 == 2300) {
            Bundle bundle2 = new Bundle();
            this.R = bundle2;
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i10 = 0;
        }
        super.q(i10, iBinder, bundle, i11);
    }

    public final void w() {
        T.b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.D) {
            this.D.clear();
        }
    }

    public final void x() {
        CastDevice castDevice = this.B;
        r7.r.f("device should not be null", castDevice);
        if (castDevice.c(2048) || !castDevice.c(4) || castDevice.c(1)) {
            return;
        }
        "Chromecast Audio".equals(castDevice.f3132s);
    }
}
