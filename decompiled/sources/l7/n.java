package l7;

import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends q {

    /* renamed from: u, reason: collision with root package name */
    public static final String f8284u;

    /* renamed from: e, reason: collision with root package name */
    public long f8285e;

    /* renamed from: f, reason: collision with root package name */
    public g7.q f8286f;
    public Long g;

    /* renamed from: h, reason: collision with root package name */
    public h5.i f8287h;

    /* renamed from: i, reason: collision with root package name */
    public int f8288i;

    /* renamed from: j, reason: collision with root package name */
    public final p f8289j;

    /* renamed from: k, reason: collision with root package name */
    public final p f8290k;

    /* renamed from: l, reason: collision with root package name */
    public final p f8291l;

    /* renamed from: m, reason: collision with root package name */
    public final p f8292m;

    /* renamed from: n, reason: collision with root package name */
    public final p f8293n;

    /* renamed from: o, reason: collision with root package name */
    public final p f8294o;

    /* renamed from: p, reason: collision with root package name */
    public final p f8295p;

    /* renamed from: q, reason: collision with root package name */
    public final p f8296q;

    /* renamed from: r, reason: collision with root package name */
    public final p f8297r;

    /* renamed from: s, reason: collision with root package name */
    public final p f8298s;

    /* renamed from: t, reason: collision with root package name */
    public final p f8299t;

    static {
        Pattern pattern = a.f8269a;
        f8284u = "urn:x-cast:com.google.cast.media";
    }

    public n() {
        super(f8284u);
        this.f8288i = -1;
        p pVar = new p(86400000L, "load");
        this.f8289j = pVar;
        p pVar2 = new p(86400000L, "pause");
        this.f8290k = pVar2;
        p pVar3 = new p(86400000L, "play");
        this.f8291l = pVar3;
        p pVar4 = new p(86400000L, "stop");
        p pVar5 = new p(10000L, "seek");
        this.f8292m = pVar5;
        p pVar6 = new p(86400000L, "volume");
        this.f8293n = pVar6;
        p pVar7 = new p(86400000L, "mute");
        this.f8294o = pVar7;
        p pVar8 = new p(86400000L, "status");
        this.f8295p = pVar8;
        p pVar9 = new p(86400000L, "activeTracks");
        p pVar10 = new p(86400000L, "trackStyle");
        p pVar11 = new p(86400000L, "queueInsert");
        p pVar12 = new p(86400000L, "queueUpdate");
        this.f8296q = pVar12;
        p pVar13 = new p(86400000L, "queueRemove");
        p pVar14 = new p(86400000L, "queueReorder");
        p pVar15 = new p(86400000L, "queueFetchItemIds");
        this.f8297r = pVar15;
        p pVar16 = new p(86400000L, "queueFetchItemRange");
        this.f8299t = pVar16;
        this.f8298s = new p(86400000L, "queueFetchItems");
        p pVar17 = new p(86400000L, "setPlaybackRate");
        p pVar18 = new p(86400000L, "skipAd");
        a(pVar);
        a(pVar2);
        a(pVar3);
        a(pVar4);
        a(pVar5);
        a(pVar6);
        a(pVar7);
        a(pVar8);
        a(pVar9);
        a(pVar10);
        a(pVar11);
        a(pVar12);
        a(pVar13);
        a(pVar14);
        a(pVar15);
        a(pVar16);
        a(pVar16);
        a(pVar17);
        a(pVar18);
        g();
    }

    public static m f(JSONObject jSONObject) {
        MediaError.b(jSONObject);
        m mVar = new m();
        Pattern pattern = a.f8269a;
        if (jSONObject.has("customData")) {
            jSONObject.optJSONObject("customData");
        }
        return mVar;
    }

    public static int[] m(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            iArr[i10] = jSONArray.getInt(i10);
        }
        return iArr;
    }

    public final void d(o oVar, int i10) {
        JSONObject jSONObject = new JSONObject();
        long b2 = b();
        try {
            jSONObject.put("requestId", b2);
            jSONObject.put("type", "QUEUE_UPDATE");
            jSONObject.put("mediaSessionId", p());
            if (i10 != 0) {
                jSONObject.put("jump", i10);
            }
            int i11 = this.f8288i;
            if (i11 != -1) {
                jSONObject.put("sequenceNumber", i11);
            }
        } catch (JSONException unused) {
        }
        c(b2, jSONObject.toString());
        this.f8296q.a(b2, new x4.c(this, oVar, 11, false));
    }

    public final long e(double d6, long j10, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f8285e;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        if (elapsedRealtime == 0) {
            return j10;
        }
        long j12 = j10 + ((long) (elapsedRealtime * d6));
        if (j11 > 0 && j12 > j11) {
            return j11;
        }
        if (j12 >= 0) {
            return j12;
        }
        return 0L;
    }

    public final void g() {
        this.f8285e = 0L;
        this.f8286f = null;
        Iterator it = this.f8311d.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f(2002);
        }
    }

    public final void h(JSONObject jSONObject, String str) {
        if (jSONObject.has("sequenceNumber")) {
            this.f8288i = jSONObject.optInt("sequenceNumber", -1);
        } else {
            b bVar = this.f8308a;
            Log.w(bVar.f8271a, bVar.d(str.concat(" message is missing a sequence number."), new Object[0]));
        }
    }

    public final void i() {
        h5.i iVar = this.f8287h;
        if (iVar != null) {
            i7.h hVar = (i7.h) iVar.f5610p;
            Iterator it = hVar.f6503h.iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.d.l(it);
            }
            Iterator it2 = hVar.f6504i.iterator();
            while (it2.hasNext()) {
                ((i7.g) it2.next()).b();
            }
        }
    }

    public final void j() {
        h5.i iVar = this.f8287h;
        if (iVar != null) {
            i7.h hVar = (i7.h) iVar.f5610p;
            Iterator it = hVar.f6503h.iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.d.l(it);
            }
            Iterator it2 = hVar.f6504i.iterator();
            while (it2.hasNext()) {
                ((i7.g) it2.next()).c();
            }
        }
    }

    public final void k() {
        h5.i iVar = this.f8287h;
        if (iVar != null) {
            i7.h hVar = (i7.h) iVar.f5610p;
            Iterator it = hVar.f6503h.iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.d.l(it);
            }
            Iterator it2 = hVar.f6504i.iterator();
            while (it2.hasNext()) {
                ((i7.g) it2.next()).d();
            }
        }
    }

    public final void l() {
        h5.i iVar = this.f8287h;
        if (iVar != null) {
            i7.h hVar = (i7.h) iVar.f5610p;
            Iterator it = hVar.f6505j.values().iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                if (hVar.g()) {
                    throw null;
                }
                if (!hVar.g()) {
                    throw null;
                }
                throw null;
            }
            Iterator it2 = hVar.f6503h.iterator();
            if (it2.hasNext()) {
                throw android.support.v4.media.d.l(it2);
            }
            Iterator it3 = hVar.f6504i.iterator();
            while (it3.hasNext()) {
                ((i7.g) it3.next()).e();
            }
        }
    }

    public final void n() {
        synchronized (this.f8311d) {
            try {
                Iterator it = this.f8311d.iterator();
                while (it.hasNext()) {
                    ((p) it.next()).f(2002);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
    }

    public final long o() {
        g7.j jVar;
        g7.q qVar = this.f8286f;
        MediaInfo mediaInfo = qVar == null ? null : qVar.f5276o;
        if (mediaInfo != null && qVar != null) {
            Long l10 = this.g;
            if (l10 != null) {
                if (l10.equals(4294967296000L)) {
                    g7.q qVar2 = this.f8286f;
                    if (qVar2.I != null) {
                        long longValue = l10.longValue();
                        g7.q qVar3 = this.f8286f;
                        if (qVar3 != null && (jVar = qVar3.I) != null) {
                            long j10 = jVar.f5231p;
                            r3 = !jVar.f5233r ? e(1.0d, j10, -1L) : j10;
                        }
                        return Math.min(longValue, r3);
                    }
                    MediaInfo mediaInfo2 = qVar2 == null ? null : qVar2.f5276o;
                    if ((mediaInfo2 != null ? mediaInfo2.f3150s : 0L) >= 0) {
                        long longValue2 = l10.longValue();
                        g7.q qVar4 = this.f8286f;
                        MediaInfo mediaInfo3 = qVar4 != null ? qVar4.f5276o : null;
                        return Math.min(longValue2, mediaInfo3 != null ? mediaInfo3.f3150s : 0L);
                    }
                }
                return l10.longValue();
            }
            if (this.f8285e != 0) {
                double d6 = qVar.f5279r;
                long j11 = qVar.f5282u;
                return (d6 == 0.0d || qVar.f5280s != 2) ? j11 : e(d6, j11, mediaInfo.f3150s);
            }
        }
        return 0L;
    }

    public final long p() {
        g7.q qVar = this.f8286f;
        if (qVar != null) {
            return qVar.f5277p;
        }
        throw new l();
    }
}
