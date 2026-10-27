package l7;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends com.google.android.gms.common.internal.a {
    @Override // o7.c
    public final int a() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastService");
        return queryLocalInterface instanceof j ? (j) queryLocalInterface : new j(iBinder, "com.google.android.gms.cast.internal.ICastService", 2);
    }

    @Override // com.google.android.gms.common.internal.a
    public final n7.c[] f() {
        return g7.y.f5319e;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String k() {
        return "com.google.android.gms.cast.internal.ICastService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String l() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }
}
