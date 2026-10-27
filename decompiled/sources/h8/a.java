package h8;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import j9.g1;
import o7.g;
import o7.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends com.google.android.gms.common.internal.a implements o7.c {
    public final boolean A;
    public final g1 B;
    public final Bundle C;
    public final Integer D;

    public a(Context context, Looper looper, g1 g1Var, Bundle bundle, g gVar, h hVar) {
        super(context, looper, 44, g1Var, gVar, hVar);
        this.A = true;
        this.B = g1Var;
        this.C = bundle;
        this.D = (Integer) g1Var.f7295t;
    }

    @Override // o7.c
    public final int a() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a, o7.c
    public final boolean b() {
        return this.A;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof c ? (c) queryLocalInterface : new c(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle h() {
        g1 g1Var = this.B;
        boolean equals = this.f3211c.getPackageName().equals((String) g1Var.f7292q);
        Bundle bundle = this.C;
        if (!equals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) g1Var.f7292q);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String k() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String l() {
        return "com.google.android.gms.signin.service.START";
    }
}
