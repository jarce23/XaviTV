package i7;

import android.util.Log;
import com.google.android.gms.cast.MediaInfo;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f6508r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ h f6509s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ Object f6510t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(h hVar, Object obj, int i10) {
        super(hVar, false);
        this.f6508r = i10;
        this.f6509s = hVar;
        this.f6510t = obj;
    }

    @Override // i7.n
    public final void V() {
        JSONObject jSONObject;
        int i10 = this.f6508r;
        Object obj = this.f6510t;
        h hVar = this.f6509s;
        boolean z10 = false;
        switch (i10) {
            case 0:
                l7.n nVar = hVar.f6499c;
                l7.o W = W();
                int[] iArr = (int[]) obj;
                nVar.getClass();
                JSONObject jSONObject2 = new JSONObject();
                long b2 = nVar.b();
                try {
                    jSONObject2.put("requestId", b2);
                    jSONObject2.put("type", "QUEUE_GET_ITEMS");
                    jSONObject2.put("mediaSessionId", nVar.p());
                    JSONArray jSONArray = new JSONArray();
                    for (int i11 : iArr) {
                        jSONArray.put(i11);
                    }
                    jSONObject2.put("itemIds", jSONArray);
                } catch (JSONException unused) {
                }
                nVar.c(b2, jSONObject2.toString());
                nVar.f8298s.a(b2, W);
                return;
            case 1:
                l7.n nVar2 = hVar.f6499c;
                l7.o W2 = W();
                g7.k kVar = (g7.k) obj;
                nVar2.getClass();
                MediaInfo mediaInfo = kVar.f5234o;
                g7.n nVar3 = kVar.f5235p;
                if (mediaInfo == null && nVar3 == null) {
                    throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
                }
                long[] jArr = kVar.f5239t;
                JSONObject jSONObject3 = new JSONObject();
                try {
                    MediaInfo mediaInfo2 = kVar.f5234o;
                    if (mediaInfo2 != null) {
                        jSONObject3.put("media", mediaInfo2.b());
                    }
                    if (nVar3 != null) {
                        jSONObject3.put("queueData", nVar3.b());
                    }
                    jSONObject3.putOpt("autoplay", kVar.f5236q);
                    long j10 = kVar.f5237r;
                    if (j10 != -1) {
                        Pattern pattern = l7.a.f8269a;
                        jSONObject3.put("currentTime", j10 / 1000.0d);
                    }
                    jSONObject3.put("playbackRate", kVar.f5238s);
                    jSONObject3.putOpt("credentials", kVar.f5242w);
                    jSONObject3.putOpt("credentialsType", kVar.f5243x);
                    jSONObject3.putOpt("atvCredentials", kVar.f5244y);
                    jSONObject3.putOpt("atvCredentialsType", kVar.f5245z);
                    if (jArr != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i12 = 0; i12 < jArr.length; i12++) {
                            jSONArray2.put(i12, jArr[i12]);
                        }
                        jSONObject3.put("activeTrackIds", jSONArray2);
                    }
                    jSONObject3.putOpt("customData", kVar.f5241v);
                    jSONObject3.put("requestId", kVar.A);
                    jSONObject = jSONObject3;
                } catch (JSONException e7) {
                    l7.b bVar = g7.k.B;
                    Log.e(bVar.f8271a, bVar.d("Error transforming MediaLoadRequestData into JSONObject", e7));
                    jSONObject = new JSONObject();
                }
                long b10 = nVar2.b();
                try {
                    jSONObject.put("requestId", b10);
                    jSONObject.put("type", "LOAD");
                } catch (JSONException unused2) {
                }
                nVar2.c(b10, jSONObject.toString());
                nVar2.f8289j.a(b10, W2);
                return;
            default:
                l7.n nVar4 = hVar.f6499c;
                l7.o W3 = W();
                nVar4.getClass();
                JSONObject jSONObject4 = new JSONObject();
                long b11 = nVar4.b();
                long j11 = ((g7.p) obj).f5275a;
                try {
                    jSONObject4.put("requestId", b11);
                    jSONObject4.put("type", "SEEK");
                    jSONObject4.put("mediaSessionId", nVar4.p());
                    Pattern pattern2 = l7.a.f8269a;
                    jSONObject4.put("currentTime", j11 / 1000.0d);
                } catch (JSONException unused3) {
                }
                nVar4.c(b11, jSONObject4.toString());
                nVar4.g = Long.valueOf(j11);
                nVar4.f8292m.a(b11, new j5.g(nVar4, W3, z10 ? 1 : 0));
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int[] iArr) {
        super(hVar, true);
        this.f6508r = 0;
        this.f6509s = hVar;
        this.f6510t = iArr;
    }
}
