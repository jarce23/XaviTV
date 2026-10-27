package w3;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import s1.g1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {
    public int A;
    public com.google.android.gms.internal.cast.p B;
    public x C;
    public x4.m D;
    public android.support.v4.media.session.a0 E;
    public final s F;

    /* renamed from: a, reason: collision with root package name */
    public final Context f13030a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13031b;

    /* renamed from: c, reason: collision with root package name */
    public v0 f13032c;

    /* renamed from: d, reason: collision with root package name */
    public q0 f13033d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13034e;

    /* renamed from: f, reason: collision with root package name */
    public g f13035f;
    public final ArrayList g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f13036h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f13037i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f13038j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f13039k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final com.google.android.material.datepicker.m f13040l;

    /* renamed from: m, reason: collision with root package name */
    public final s f13041m;

    /* renamed from: n, reason: collision with root package name */
    public final t f13042n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f13043o;

    /* renamed from: p, reason: collision with root package name */
    public g1 f13044p;

    /* renamed from: q, reason: collision with root package name */
    public g0 f13045q;

    /* renamed from: r, reason: collision with root package name */
    public z f13046r;

    /* renamed from: s, reason: collision with root package name */
    public z f13047s;

    /* renamed from: t, reason: collision with root package name */
    public z f13048t;

    /* renamed from: u, reason: collision with root package name */
    public m f13049u;

    /* renamed from: v, reason: collision with root package name */
    public z f13050v;

    /* renamed from: w, reason: collision with root package name */
    public l f13051w;

    /* renamed from: x, reason: collision with root package name */
    public final HashMap f13052x;

    /* renamed from: y, reason: collision with root package name */
    public j f13053y;

    /* renamed from: z, reason: collision with root package name */
    public j f13054z;

    public w(Context context) {
        com.google.android.material.datepicker.m mVar = new com.google.android.material.datepicker.m();
        mVar.f3773q = 0;
        mVar.f3774r = 3;
        this.f13040l = mVar;
        this.f13041m = new s(this);
        this.f13042n = new t(this);
        this.f13052x = new HashMap();
        this.F = new s(this);
        this.f13030a = context;
        this.f13043o = ((ActivityManager) context.getSystemService("activity")).isLowRamDevice();
    }

    public final void a(n nVar, boolean z10) {
        if (d(nVar) == null) {
            y yVar = new y(nVar, z10);
            this.f13038j.add(yVar);
            w wVar = b0.f12895c;
            this.f13042n.b(513, yVar);
            n(yVar, nVar.g);
            b0.b();
            nVar.f12970d = this.f13041m;
            nVar.h(this.f13053y);
        }
    }

    public final String b(y yVar, String str) {
        String str2;
        String flattenToShortString = ((ComponentName) yVar.f13067d.f9953p).flattenToShortString();
        boolean z10 = yVar.f13066c;
        if (z10) {
            str2 = str;
        } else {
            str2 = flattenToShortString + ":" + str;
        }
        HashMap hashMap = this.f13037i;
        if (!z10) {
            ArrayList arrayList = this.f13036h;
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                }
                if (((z) arrayList.get(i10)).f13071c.equals(str2)) {
                    break;
                }
                i10++;
            }
            if (i10 >= 0) {
                Log.w("MediaRouter", "Either " + str + " isn't unique in " + flattenToShortString + " or we're trying to assign a unique ID for an already added route");
                int i11 = 2;
                while (true) {
                    Locale locale = Locale.US;
                    String str3 = str2 + "_" + i11;
                    int size2 = arrayList.size();
                    int i12 = 0;
                    while (true) {
                        if (i12 >= size2) {
                            i12 = -1;
                            break;
                        }
                        if (((z) arrayList.get(i12)).f13071c.equals(str3)) {
                            break;
                        }
                        i12++;
                    }
                    if (i12 < 0) {
                        hashMap.put(new l0.b(flattenToShortString, str), str3);
                        return str3;
                    }
                    i11++;
                }
            }
        }
        hashMap.put(new l0.b(flattenToShortString, str), str2);
        return str2;
    }

    public final z c() {
        ArrayList arrayList = this.f13036h;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            z zVar = (z) obj;
            if (zVar != this.f13046r && zVar.c() == this.f13032c && zVar.m("android.media.intent.category.LIVE_AUDIO") && !zVar.m("android.media.intent.category.LIVE_VIDEO") && zVar.f()) {
                return zVar;
            }
        }
        return this.f13046r;
    }

    public final y d(n nVar) {
        ArrayList arrayList = this.f13038j;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((y) arrayList.get(i10)).f13064a == nVar) {
                return (y) arrayList.get(i10);
            }
        }
        return null;
    }

    public final z e() {
        z zVar = this.f13048t;
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
    }

    public final boolean f() {
        if (!this.f13034e) {
            return false;
        }
        g0 g0Var = this.f13045q;
        return g0Var == null || g0Var.f12925a;
    }

    public final void g() {
        if (this.f13048t.e()) {
            List<z> unmodifiableList = Collections.unmodifiableList(this.f13048t.f13088u);
            HashSet hashSet = new HashSet();
            Iterator it = unmodifiableList.iterator();
            while (it.hasNext()) {
                hashSet.add(((z) it.next()).f13071c);
            }
            HashMap hashMap = this.f13052x;
            Iterator it2 = hashMap.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet.contains(entry.getKey())) {
                    m mVar = (m) entry.getValue();
                    mVar.h(0);
                    mVar.d();
                    it2.remove();
                }
            }
            for (z zVar : unmodifiableList) {
                if (!hashMap.containsKey(zVar.f13071c)) {
                    m e7 = zVar.c().e(zVar.f13070b, this.f13048t.f13070b);
                    e7.e();
                    hashMap.put(zVar.f13071c, e7);
                }
            }
        }
    }

    public final void h(w wVar, z zVar, m mVar, int i10, z zVar2, Collection collection) {
        com.google.android.gms.internal.cast.p pVar;
        x xVar = this.C;
        if (xVar != null) {
            xVar.a();
            this.C = null;
        }
        x xVar2 = new x(wVar, zVar, mVar, i10, zVar2, collection);
        this.C = xVar2;
        if (xVar2.f13056b != 3 || (pVar = this.B) == null) {
            xVar2.b();
            return;
        }
        z zVar3 = this.f13048t;
        l7.b bVar = com.google.android.gms.internal.cast.p.f3413c;
        int i11 = 2;
        z zVar4 = xVar2.f13058d;
        bVar.b("Prepare transfer from Route(%s) to Route(%s)", zVar3, zVar4);
        r.i iVar = new r.i();
        iVar.f10401c = new r.l();
        r.k kVar = new r.k(iVar);
        r.j jVar = kVar.f10405p;
        iVar.f10400b = kVar;
        iVar.f10399a = com.google.android.gms.internal.cast.n.class;
        try {
            iVar.f10399a = Boolean.valueOf(pVar.f3415b.post(new com.google.android.gms.internal.cast.o(pVar, zVar3, zVar4, iVar)));
        } catch (Exception e7) {
            jVar.getClass();
            if (r.h.f10394t.f(jVar, null, new r.c(e7))) {
                r.h.c(jVar);
            }
        }
        x xVar3 = this.C;
        w wVar2 = (w) xVar3.g.get();
        if (wVar2 == null || wVar2.C != xVar3) {
            Log.w("MediaRouter", "Router is released. Cancel transfer");
            xVar3.a();
        } else {
            if (xVar3.f13061h != null) {
                throw new IllegalStateException("future is already set");
            }
            xVar3.f13061h = kVar;
            w1.o oVar = new w1.o(i11, xVar3);
            t tVar = wVar2.f13042n;
            Objects.requireNonNull(tVar);
            jVar.a(oVar, new u1.x(tVar, 1));
        }
    }

    public final void i(n nVar) {
        y d6 = d(nVar);
        if (d6 != null) {
            nVar.getClass();
            b0.b();
            nVar.f12970d = null;
            nVar.h(null);
            n(d6, null);
            this.f13042n.b(514, d6);
            this.f13038j.remove(d6);
        }
    }

    public final void j(z zVar, int i10) {
        if (!this.f13036h.contains(zVar)) {
            Log.w("MediaRouter", "Ignoring attempt to select removed route: " + zVar);
            return;
        }
        if (!zVar.g) {
            Log.w("MediaRouter", "Ignoring attempt to select disabled route: " + zVar);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            n c10 = zVar.c();
            g gVar = this.f13035f;
            if (c10 == gVar && this.f13048t != zVar) {
                String str = zVar.f13070b;
                MediaRoute2Info i11 = gVar.i(str);
                if (i11 != null) {
                    gVar.f12916i.transferTo(i11);
                    return;
                }
                Log.w("MR2Provider", "transferTo: Specified route not found. routeId=" + str);
                return;
            }
        }
        k(zVar, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r0 == r11) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(w3.z r11, int r12) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.w.k(w3.z, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0149, code lost:
    
        if (r24.f13054z.b() == r1) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.w.l():void");
    }

    public final void m() {
        MediaRouter2.RoutingController routingController;
        z zVar = this.f13048t;
        if (zVar == null) {
            x4.m mVar = this.D;
            if (mVar != null) {
                mVar.u();
                return;
            }
            return;
        }
        int i10 = zVar.f13082o;
        com.google.android.material.datepicker.m mVar2 = this.f13040l;
        mVar2.f3771o = i10;
        mVar2.f3772p = zVar.f13083p;
        mVar2.f3773q = (!zVar.e() || b0.h()) ? zVar.f13081n : 0;
        mVar2.f3774r = this.f13048t.f13079l;
        if (f() && this.f13048t.c() == this.f13035f) {
            m mVar3 = this.f13049u;
            int i11 = g.f12915r;
            mVar2.f3775s = ((mVar3 instanceof c) && (routingController = ((c) mVar3).g) != null) ? routingController.getId() : null;
        } else {
            mVar2.f3775s = null;
        }
        ArrayList arrayList = this.f13039k;
        if (arrayList.size() > 0) {
            ((v) arrayList.get(0)).getClass();
            throw null;
        }
        x4.m mVar4 = this.D;
        if (mVar4 != null) {
            z zVar2 = this.f13048t;
            z zVar3 = this.f13046r;
            if (zVar3 == null) {
                throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
            }
            if (zVar2 == zVar3 || zVar2 == this.f13047s) {
                mVar4.u();
                return;
            }
            int i12 = mVar2.f3773q == 1 ? 2 : 0;
            int i13 = mVar2.f3772p;
            int i14 = mVar2.f3771o;
            String str = (String) mVar2.f3775s;
            android.support.v4.media.session.a0 a0Var = (android.support.v4.media.session.a0) mVar4.f13564p;
            if (a0Var != null) {
                androidx.emoji2.text.t tVar = (androidx.emoji2.text.t) mVar4.f13565q;
                if (tVar != null && i12 == 0 && i13 == 0) {
                    tVar.f598c = i14;
                    f1.f.a(tVar.b(), i14);
                } else {
                    androidx.emoji2.text.t tVar2 = new androidx.emoji2.text.t(mVar4, i12, i13, i14, str);
                    mVar4.f13565q = tVar2;
                    ((android.support.v4.media.session.u) a0Var.f230p).f261a.setPlaybackToRemote(tVar2.b());
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r20 == r18.f13032c.g) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0178 A[LOOP:5: B:87:0x0176->B:88:0x0178, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0193 A[LOOP:6: B:91:0x0191->B:92:0x0193, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(w3.y r19, ea.a r20) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.w.n(w3.y, ea.a):void");
    }

    public final int o(z zVar, i iVar) {
        int i10 = zVar.i(iVar);
        if (i10 != 0) {
            int i11 = i10 & 1;
            t tVar = this.f13042n;
            if (i11 != 0) {
                w wVar = b0.f12895c;
                tVar.b(259, zVar);
            }
            if ((i10 & 2) != 0) {
                w wVar2 = b0.f12895c;
                tVar.b(260, zVar);
            }
            if ((i10 & 4) != 0) {
                w wVar3 = b0.f12895c;
                tVar.b(261, zVar);
            }
        }
        return i10;
    }

    public final void p(boolean z10) {
        z zVar = this.f13046r;
        if (zVar != null && !zVar.f()) {
            Log.i("MediaRouter", "Clearing the default route because it is no longer selectable: " + this.f13046r);
            this.f13046r = null;
        }
        z zVar2 = this.f13046r;
        ArrayList arrayList = this.f13036h;
        if (zVar2 == null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                z zVar3 = (z) obj;
                if (zVar3.c() == this.f13032c && zVar3.f13070b.equals("DEFAULT_ROUTE") && zVar3.f()) {
                    this.f13046r = zVar3;
                    Log.i("MediaRouter", "Found default route: " + this.f13046r);
                    break;
                }
            }
        }
        z zVar4 = this.f13047s;
        if (zVar4 != null && !zVar4.f()) {
            Log.i("MediaRouter", "Clearing the bluetooth route because it is no longer selectable: " + this.f13047s);
            this.f13047s = null;
        }
        if (this.f13047s == null && !arrayList.isEmpty()) {
            int size2 = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size2) {
                    break;
                }
                Object obj2 = arrayList.get(i11);
                i11++;
                z zVar5 = (z) obj2;
                if (zVar5.c() == this.f13032c && zVar5.m("android.media.intent.category.LIVE_AUDIO") && !zVar5.m("android.media.intent.category.LIVE_VIDEO") && zVar5.f()) {
                    this.f13047s = zVar5;
                    Log.i("MediaRouter", "Found bluetooth route: " + this.f13047s);
                    break;
                }
            }
        }
        z zVar6 = this.f13048t;
        if (zVar6 == null || !zVar6.g) {
            Log.i("MediaRouter", "Unselecting the current route because it is no longer selectable: " + this.f13048t);
            k(c(), 0);
            return;
        }
        if (z10) {
            g();
            m();
        }
    }
}
