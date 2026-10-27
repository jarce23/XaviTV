package l7;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import j9.g1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends com.google.android.gms.common.internal.a {
    public static final b E = new b("CastClientImplCxless", null);
    public final CastDevice A;
    public final long B;
    public final Bundle C;
    public final String D;

    public x(Context context, Looper looper, g1 g1Var, CastDevice castDevice, long j10, Bundle bundle, String str, p7.k kVar, p7.k kVar2) {
        super(context, looper, 10, g1Var, kVar, kVar2);
        this.A = castDevice;
        this.B = j10;
        this.C = bundle;
        this.D = str;
    }

    @Override // o7.c
    public final int a() {
        return 19390000;
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
        try {
            try {
                ((g) j()).A0();
            } finally {
                super.d();
            }
        } catch (RemoteException | IllegalStateException e7) {
            E.a(e7, "Error while disconnecting the controller interface", new Object[0]);
        }
    }

    @Override // com.google.android.gms.common.internal.a
    public final n7.c[] f() {
        return g7.y.f5319e;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle h() {
        Bundle bundle = new Bundle();
        E.b("getRemoteService()", new Object[0]);
        CastDevice castDevice = this.A;
        castDevice.getClass();
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", castDevice);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.B);
        bundle.putString("connectionless_client_record_id", this.D);
        Bundle bundle2 = this.C;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
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
    public final boolean r() {
        return true;
    }
}
