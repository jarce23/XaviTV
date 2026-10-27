package j5;

import android.util.Log;
import c2.j1;
import m5.k;
import m5.l;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l, k {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ j1 f7111o;

    @Override // m5.l
    public void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        j1 j1Var = this.f7111o;
        int i10 = j1Var.f2625p;
        try {
            ((d) j1Var.f2627r).a(jSONObject, i10);
        } catch (Exception e7) {
            ((d) j1Var.f2627r).a(null, i10);
            Log.e("GetDataRequest", "getResponse", e7);
        }
    }

    @Override // m5.k
    public void g() {
        j1 j1Var = this.f7111o;
        ((d) j1Var.f2627r).a(null, j1Var.f2625p);
    }
}
