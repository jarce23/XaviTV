package g7;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import j9.g1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 extends x4.f {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f5171s;

    @Override // x4.f
    public o7.c d(Context context, Looper looper, g1 g1Var, Object obj, o7.g gVar, o7.h hVar) {
        switch (this.f5171s) {
            case 0:
                e eVar = (e) obj;
                r7.r.f("Setting the API options is required.", eVar);
                return new l7.x(context, looper, g1Var, eVar.f5202b, 0, eVar.f5204d, eVar.f5205e, (p7.k) gVar, (p7.k) hVar);
            case 1:
                e eVar2 = (e) obj;
                r7.r.f("Setting the API options is required.", eVar2);
                return new l7.w(context, looper, g1Var, eVar2.f5202b, 0, eVar2.f5203c, eVar2.f5204d, (p7.k) gVar, (p7.k) hVar);
            case 2:
                g1Var.getClass();
                Integer num = (Integer) g1Var.f7295t;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new h8.a(context, looper, g1Var, bundle, gVar, hVar);
            case 3:
                obj.getClass();
                throw new ClassCastException();
            case 4:
                return new l7.t(context, looper, 161, g1Var, gVar, hVar);
            default:
                return super.d(context, looper, g1Var, obj, gVar, hVar);
        }
    }

    @Override // x4.f
    public o7.c g(Context context, Looper looper, g1 g1Var, Object obj, p7.k kVar, p7.k kVar2) {
        switch (this.f5171s) {
            case 5:
                return new t7.a(context, looper, 449, g1Var, kVar, kVar2);
            case 6:
                return new t7.e(context, looper, g1Var, (r7.j) obj, kVar, kVar2);
            default:
                return super.g(context, looper, g1Var, obj, kVar, kVar2);
        }
    }
}
