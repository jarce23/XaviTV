package i7;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends n {

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f6506r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ h f6507s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(h hVar, int i10) {
        super(hVar, false);
        this.f6506r = i10;
        this.f6507s = hVar;
    }

    @Override // i7.n
    public final void V() {
        switch (this.f6506r) {
            case 0:
                l7.n nVar = this.f6507s.f6499c;
                l7.o W = W();
                nVar.getClass();
                JSONObject jSONObject = new JSONObject();
                long b2 = nVar.b();
                try {
                    jSONObject.put("requestId", b2);
                    jSONObject.put("type", "GET_STATUS");
                    g7.q qVar = nVar.f8286f;
                    if (qVar != null) {
                        jSONObject.put("mediaSessionId", qVar.f5277p);
                    }
                } catch (JSONException unused) {
                }
                nVar.c(b2, jSONObject.toString());
                nVar.f8295p.a(b2, W);
                break;
            case 1:
                this.f6507s.f6499c.d(W(), -1);
                break;
            case 2:
                this.f6507s.f6499c.d(W(), 1);
                break;
            case 3:
                l7.n nVar2 = this.f6507s.f6499c;
                l7.o W2 = W();
                nVar2.getClass();
                JSONObject jSONObject2 = new JSONObject();
                long b10 = nVar2.b();
                try {
                    jSONObject2.put("requestId", b10);
                    jSONObject2.put("type", "QUEUE_GET_ITEM_IDS");
                    jSONObject2.put("mediaSessionId", nVar2.p());
                } catch (JSONException unused2) {
                }
                nVar2.c(b10, jSONObject2.toString());
                nVar2.f8297r.a(b10, W2);
                break;
            case 4:
                l7.n nVar3 = this.f6507s.f6499c;
                l7.o W3 = W();
                nVar3.getClass();
                JSONObject jSONObject3 = new JSONObject();
                long b11 = nVar3.b();
                try {
                    jSONObject3.put("requestId", b11);
                    jSONObject3.put("type", "PAUSE");
                    jSONObject3.put("mediaSessionId", nVar3.p());
                } catch (JSONException unused3) {
                }
                nVar3.c(b11, jSONObject3.toString());
                nVar3.f8290k.a(b11, W3);
                break;
            default:
                l7.n nVar4 = this.f6507s.f6499c;
                l7.o W4 = W();
                nVar4.getClass();
                JSONObject jSONObject4 = new JSONObject();
                long b12 = nVar4.b();
                try {
                    jSONObject4.put("requestId", b12);
                    jSONObject4.put("type", "PLAY");
                    jSONObject4.put("mediaSessionId", nVar4.p());
                } catch (JSONException unused4) {
                }
                nVar4.c(b12, jSONObject4.toString());
                nVar4.f8291l.a(b12, W4);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar) {
        super(hVar, true);
        this.f6506r = 3;
        this.f6507s = hVar;
    }
}
