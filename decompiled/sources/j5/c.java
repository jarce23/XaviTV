package j5;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import m5.i;
import m5.p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends i {
    public final Object B;
    public final b C;
    public final String D;

    public c(String str, String str2, b bVar, b bVar2) {
        super(1, str, bVar2);
        this.B = new Object();
        this.C = bVar;
        this.D = str2;
    }

    @Override // m5.i
    public final void b(Object obj) {
        b bVar;
        synchronized (this.B) {
            bVar = this.C;
        }
        if (bVar != null) {
            bVar.a(obj);
        }
    }

    @Override // m5.i
    public final byte[] d() {
        String str = this.D;
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Log.wtf("Volley", p.a("Unsupported Encoding while trying to get the bytes of %s using %s", str, "utf-8"));
            return null;
        }
    }

    @Override // m5.i
    public final String e() {
        return "application/json; charset=utf-8";
    }

    @Override // m5.i
    public final Map g() {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", "samsung-agent/1");
        return hashMap;
    }

    @Override // m5.i
    public final c4.e l(c4.e eVar) {
        try {
            return new c4.e(new JSONObject(new String((byte[]) eVar.f2876p, x4.f.I("utf-8", (Map) eVar.f2877q))), x4.f.H(eVar));
        } catch (UnsupportedEncodingException e7) {
            return new c4.e(new m5.a(e7));
        } catch (JSONException e8) {
            return new c4.e(new m5.a(e8));
        }
    }
}
