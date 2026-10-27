package app.shamel.tv.activities;

import android.util.Base64;
import android.util.Log;
import app.shamel.tv.models.AppInfoModel;
import c2.j1;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements h5.t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ h5.u f2035o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ AppInfoModel.UrlModel f2036p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ ChangePlaylistActivity f2037q;

    public o(ChangePlaylistActivity changePlaylistActivity, h5.u uVar, AppInfoModel.UrlModel urlModel) {
        this.f2037q = changePlaylistActivity;
        this.f2035o = uVar;
        this.f2036p = urlModel;
    }

    @Override // h5.t
    public final void a() {
        this.f2035o.J(false, false);
        ChangePlaylistActivity changePlaylistActivity = this.f2037q;
        String lowerCase = changePlaylistActivity.f1606k0.r().toLowerCase();
        String id = this.f2036p.getId();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac_address", lowerCase);
            jSONObject.put("playlist_id", id);
            jSONObject.put("app_type", "android");
        } catch (Exception e7) {
            Log.e("Security", "getDeleteData", e7);
        }
        String trim = new String(Base64.encode(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 0)).trim();
        int nextInt = new Random().nextInt(20);
        int nextInt2 = new Random().nextInt(trim.length());
        if (nextInt2 > 42) {
            nextInt2 = 42;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(trim.substring(0, nextInt2) + com.google.android.gms.internal.cast.n.j(nextInt) + trim.substring(nextInt2));
        sb2.append(com.google.android.gms.internal.cast.n.k(nextInt2));
        sb2.append(com.google.android.gms.internal.cast.n.k(nextInt));
        String sb3 = sb2.toString();
        j1 j1Var = new j1(changePlaylistActivity, 2000);
        j1Var.i(com.google.android.gms.internal.cast.n.l(sb3), e5.l.f4610e);
        j1Var.f2627r = changePlaylistActivity;
    }

    @Override // h5.t
    public final void e() {
    }
}
