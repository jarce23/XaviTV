package t7;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import j9.g1;
import p7.k;
import r7.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends com.google.android.gms.common.internal.a {
    public final j A;

    public e(Context context, Looper looper, g1 g1Var, j jVar, k kVar, k kVar2) {
        super(context, looper, 270, g1Var, kVar, kVar2);
        this.A = jVar;
    }

    @Override // o7.c
    public final int a() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof c ? (c) queryLocalInterface : new c(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final n7.c[] f() {
        return b8.c.f2482c;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle h() {
        this.A.getClass();
        return new Bundle();
    }

    @Override // com.google.android.gms.common.internal.a
    public final String k() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String l() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean m() {
        return true;
    }
}
