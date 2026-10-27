package w3;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final y f13069a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13070b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13071c;

    /* renamed from: d, reason: collision with root package name */
    public String f13072d;

    /* renamed from: e, reason: collision with root package name */
    public String f13073e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f13074f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public int f13075h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13076i;

    /* renamed from: k, reason: collision with root package name */
    public int f13078k;

    /* renamed from: l, reason: collision with root package name */
    public int f13079l;

    /* renamed from: m, reason: collision with root package name */
    public int f13080m;

    /* renamed from: n, reason: collision with root package name */
    public int f13081n;

    /* renamed from: o, reason: collision with root package name */
    public int f13082o;

    /* renamed from: p, reason: collision with root package name */
    public int f13083p;

    /* renamed from: r, reason: collision with root package name */
    public Bundle f13085r;

    /* renamed from: s, reason: collision with root package name */
    public IntentSender f13086s;

    /* renamed from: t, reason: collision with root package name */
    public i f13087t;

    /* renamed from: v, reason: collision with root package name */
    public p.e f13089v;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f13077j = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public int f13084q = -1;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f13088u = new ArrayList();

    public z(y yVar, String str, String str2) {
        this.f13069a = yVar;
        this.f13070b = str;
        this.f13071c = str2;
    }

    public static l a() {
        b0.b();
        m mVar = b0.c().f13049u;
        if (mVar instanceof l) {
            return (l) mVar;
        }
        return null;
    }

    public final p4.p b(z zVar) {
        if (zVar == null) {
            throw new NullPointerException("route must not be null");
        }
        String str = zVar.f13071c;
        p.e eVar = this.f13089v;
        if (eVar == null || !eVar.containsKey(str)) {
            return null;
        }
        return new p4.p(27, (k) this.f13089v.get(str));
    }

    public final n c() {
        y yVar = this.f13069a;
        yVar.getClass();
        b0.b();
        return yVar.f13064a;
    }

    public final boolean d() {
        b0.b();
        z zVar = b0.c().f13046r;
        if (zVar != null) {
            return zVar == this || this.f13080m == 3 || (TextUtils.equals(((ComponentName) c().f12968b.f9953p).getPackageName(), "android") && m("android.media.intent.category.LIVE_AUDIO") && !m("android.media.intent.category.LIVE_VIDEO"));
        }
        throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
    }

    public final boolean e() {
        return Collections.unmodifiableList(this.f13088u).size() >= 1;
    }

    public final boolean f() {
        return this.f13087t != null && this.g;
    }

    public final boolean g() {
        b0.b();
        return b0.c().e() == this;
    }

    public final boolean h(o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        b0.b();
        ArrayList arrayList = this.f13077j;
        if (arrayList != null) {
            oVar.a();
            if (!oVar.f12983b.isEmpty()) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    IntentFilter intentFilter = (IntentFilter) obj;
                    if (intentFilter != null) {
                        Iterator it = oVar.f12983b.iterator();
                        while (it.hasNext()) {
                            if (intentFilter.hasCategory((String) it.next())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0102, code lost:
    
        if (r5.hasNext() == false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(w3.i r18) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.z.i(w3.i):int");
    }

    public final void j(int i10) {
        m mVar;
        m mVar2;
        b0.b();
        w c10 = b0.c();
        int min = Math.min(this.f13083p, Math.max(0, i10));
        HashMap hashMap = c10.f13052x;
        if (this == c10.f13048t && (mVar2 = c10.f13049u) != null) {
            mVar2.f(min);
        } else {
            if (hashMap.isEmpty() || (mVar = (m) hashMap.get(this.f13071c)) == null) {
                return;
            }
            mVar.f(min);
        }
    }

    public final void k(int i10) {
        m mVar;
        m mVar2;
        b0.b();
        if (i10 != 0) {
            w c10 = b0.c();
            HashMap hashMap = c10.f13052x;
            if (this == c10.f13048t && (mVar2 = c10.f13049u) != null) {
                mVar2.i(i10);
            } else {
                if (hashMap.isEmpty() || (mVar = (m) hashMap.get(this.f13071c)) == null) {
                    return;
                }
                mVar.i(i10);
            }
        }
    }

    public final void l() {
        b0.b();
        b0.c().j(this, 3);
    }

    public final boolean m(String str) {
        b0.b();
        ArrayList arrayList = this.f13077j;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((IntentFilter) arrayList.get(i10)).hasCategory(str)) {
                return true;
            }
        }
        return false;
    }

    public final void n(Collection collection) {
        this.f13088u.clear();
        if (this.f13089v == null) {
            this.f13089v = new p.e(0);
        }
        this.f13089v.clear();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            z a10 = this.f13069a.a(kVar.f12948a.d());
            if (a10 != null) {
                this.f13089v.put(a10.f13071c, kVar);
                int i10 = kVar.f12949b;
                if (i10 == 2 || i10 == 3) {
                    this.f13088u.add(a10);
                }
            }
        }
        b0.c().f13042n.b(259, this);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MediaRouter.RouteInfo{ uniqueId=");
        sb2.append(this.f13071c);
        sb2.append(", name=");
        sb2.append(this.f13072d);
        sb2.append(", description=");
        sb2.append(this.f13073e);
        sb2.append(", iconUri=");
        sb2.append(this.f13074f);
        sb2.append(", enabled=");
        sb2.append(this.g);
        sb2.append(", connectionState=");
        sb2.append(this.f13075h);
        sb2.append(", canDisconnect=");
        sb2.append(this.f13076i);
        sb2.append(", playbackType=");
        sb2.append(this.f13078k);
        sb2.append(", playbackStream=");
        sb2.append(this.f13079l);
        sb2.append(", deviceType=");
        sb2.append(this.f13080m);
        sb2.append(", volumeHandling=");
        sb2.append(this.f13081n);
        sb2.append(", volume=");
        sb2.append(this.f13082o);
        sb2.append(", volumeMax=");
        sb2.append(this.f13083p);
        sb2.append(", presentationDisplayId=");
        sb2.append(this.f13084q);
        sb2.append(", extras=");
        sb2.append(this.f13085r);
        sb2.append(", settingsIntent=");
        sb2.append(this.f13086s);
        sb2.append(", providerPackageName=");
        sb2.append(((ComponentName) this.f13069a.f13067d.f9953p).getPackageName());
        if (e()) {
            sb2.append(", members=[");
            int size = this.f13088u.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 > 0) {
                    sb2.append(", ");
                }
                if (this.f13088u.get(i10) != this) {
                    sb2.append(((z) this.f13088u.get(i10)).f13071c);
                }
            }
            sb2.append(']');
        }
        sb2.append(" }");
        return sb2.toString();
    }
}
