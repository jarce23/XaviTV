package p7;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import g7.a0;
import g7.d0;
import g7.e0;
import j9.g1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import r7.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements o7.g, o7.h {

    /* renamed from: c, reason: collision with root package name */
    public final o7.c f10054c;

    /* renamed from: d, reason: collision with root package name */
    public final a f10055d;

    /* renamed from: e, reason: collision with root package name */
    public final x4.e f10056e;

    /* renamed from: h, reason: collision with root package name */
    public final int f10058h;

    /* renamed from: i, reason: collision with root package name */
    public final v f10059i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10060j;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f10064n;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f10053b = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f10057f = new HashSet();
    public final HashMap g = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f10061k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public n7.a f10062l = null;

    /* renamed from: m, reason: collision with root package name */
    public int f10063m = 0;

    public k(d dVar, o7.f fVar) {
        this.f10064n = dVar;
        Looper looper = dVar.A.getLooper();
        x4.m a10 = fVar.a();
        g1 g1Var = new g1((p.f) a10.f13564p, (String) a10.f13565q, (String) a10.f13566r);
        x4.f fVar2 = (x4.f) fVar.f9553d.f13561o;
        r7.r.e(fVar2);
        o7.c d6 = fVar2.d(fVar.f9550a, looper, g1Var, fVar.f9554e, this, this);
        p4.p pVar = fVar.f9552c;
        if (pVar == null || !(d6 instanceof com.google.android.gms.common.internal.a)) {
            String str = fVar.f9551b;
            if (str != null && (d6 instanceof com.google.android.gms.common.internal.a)) {
                ((com.google.android.gms.common.internal.a) d6).f3226s = str;
            }
        } else {
            ((com.google.android.gms.common.internal.a) d6).f3227t = pVar;
        }
        this.f10054c = d6;
        this.f10055d = fVar.f9555f;
        this.f10056e = new x4.e(14);
        this.f10058h = fVar.f9556h;
        if (!d6.b()) {
            this.f10059i = null;
            return;
        }
        Context context = dVar.f10042s;
        b8.e eVar = dVar.A;
        x4.m a11 = fVar.a();
        this.f10059i = new v(context, eVar, new g1((p.f) a11.f13564p, (String) a11.f13565q, (String) a11.f13566r));
    }

    @Override // o7.g
    public final void G() {
        d dVar = this.f10064n;
        if (Looper.myLooper() == dVar.A.getLooper()) {
            a();
        } else {
            dVar.A.post(new p0.b(1, this));
        }
    }

    public final void a() {
        o7.c cVar = this.f10054c;
        d dVar = this.f10064n;
        r7.r.a(dVar.A);
        this.f10062l = null;
        i(n7.a.f9212t);
        if (this.f10060j) {
            b8.e eVar = dVar.A;
            a aVar = this.f10055d;
            eVar.removeMessages(11, aVar);
            dVar.A.removeMessages(9, aVar);
            this.f10060j = false;
        }
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            l1.s sVar = ((u) it.next()).f10091a;
            if (j((n7.c[]) sVar.f8124r) != null) {
                it.remove();
            } else {
                try {
                    i8.i iVar = new i8.i();
                    a6.n nVar = (a6.n) ((f3.j) sVar.f8125s).f5007p;
                    nVar.getClass();
                    l7.x xVar = (l7.x) cVar;
                    l7.g gVar = (l7.g) xVar.j();
                    d0 d0Var = ((e0) nVar.f74p).f5206k;
                    Parcel w02 = gVar.w0();
                    com.google.android.gms.internal.cast.u.d(w02, d0Var);
                    gVar.z0(w02, 18);
                    l7.g gVar2 = (l7.g) xVar.j();
                    gVar2.z0(gVar2.w0(), 17);
                    iVar.p(null);
                } catch (DeadObjectException unused) {
                    v(3);
                    ((com.google.android.gms.common.internal.a) cVar).e("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException e7) {
                    e = e7;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                } catch (RuntimeException e8) {
                    e = e8;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                }
            }
        }
        d();
        h();
    }

    public final void b(int i10) {
        r7.r.a(this.f10064n.A);
        this.f10062l = null;
        this.f10060j = true;
        String str = ((com.google.android.gms.common.internal.a) this.f10054c).f3209a;
        x4.e eVar = this.f10056e;
        eVar.getClass();
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (str != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(str);
        }
        eVar.m(true, new Status(20, sb2.toString(), null, null));
        a aVar = this.f10055d;
        d dVar = this.f10064n;
        b8.e eVar2 = dVar.A;
        eVar2.sendMessageDelayed(Message.obtain(eVar2, 9, aVar), 5000L);
        b8.e eVar3 = dVar.A;
        eVar3.sendMessageDelayed(Message.obtain(eVar3, 11, aVar), 120000L);
        SparseIntArray sparseIntArray = (SparseIntArray) dVar.f10044u.f7114o;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((u) it.next()).getClass();
        }
    }

    public final boolean c(n7.a aVar) {
        synchronized (d.E) {
            this.f10064n.getClass();
        }
        return false;
    }

    public final void d() {
        LinkedList linkedList = this.f10053b;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            s sVar = (s) arrayList.get(i10);
            if (!((com.google.android.gms.common.internal.a) this.f10054c).n()) {
                return;
            }
            if (e(sVar)) {
                linkedList.remove(sVar);
            }
        }
    }

    public final boolean e(s sVar) {
        if (sVar == null) {
            x4.e eVar = this.f10056e;
            o7.c cVar = this.f10054c;
            sVar.f(eVar, cVar.b());
            try {
                sVar.g(this);
                return true;
            } catch (DeadObjectException unused) {
                v(1);
                ((com.google.android.gms.common.internal.a) cVar).e("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        n7.c j10 = j(sVar.a(this));
        if (j10 == null) {
            x4.e eVar2 = this.f10056e;
            o7.c cVar2 = this.f10054c;
            sVar.f(eVar2, cVar2.b());
            try {
                sVar.g(this);
                return true;
            } catch (DeadObjectException unused2) {
                v(1);
                ((com.google.android.gms.common.internal.a) cVar2).e("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        String name = this.f10054c.getClass().getName();
        String str = j10.f9221o;
        long b2 = j10.b();
        int length = name.length();
        StringBuilder sb2 = new StringBuilder(length + 53 + String.valueOf(str).length() + 2 + String.valueOf(b2).length() + 2);
        sb2.append(name);
        sb2.append(" could not execute call because it requires feature (");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(b2);
        sb2.append(").");
        Log.w("GoogleApiManager", sb2.toString());
        d dVar = this.f10064n;
        if (!dVar.B || !sVar.b(this)) {
            sVar.e(new o7.k(j10));
            return true;
        }
        int c10 = sVar.c(this);
        l lVar = new l(this.f10055d, j10);
        ArrayList arrayList = this.f10061k;
        int indexOf = arrayList.indexOf(lVar);
        if (indexOf >= 0) {
            l lVar2 = (l) arrayList.get(indexOf);
            dVar.A.removeMessages(15, lVar2);
            dVar.A.sendMessageDelayed(Message.obtain(dVar.A, 15, lVar2), 5000L);
            return false;
        }
        arrayList.add(lVar);
        dVar.A.sendMessageDelayed(Message.obtain(dVar.A, 15, lVar), 5000L);
        dVar.A.sendMessageDelayed(Message.obtain(dVar.A, 16, lVar), 120000L);
        n7.a aVar = new n7.a(1, 2, null, null, Integer.valueOf(c10));
        if (c(aVar)) {
            String str2 = j10.f9221o;
            long b10 = j10.b();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 61 + String.valueOf(b10).length());
            sb3.append("A dialog should be displayed for missing feature: ");
            sb3.append(str2);
            sb3.append(", version: ");
            sb3.append(b10);
            Log.w("GoogleApiManager", sb3.toString());
            return false;
        }
        if (!dVar.f(aVar, this.f10058h)) {
            return false;
        }
        String str3 = j10.f9221o;
        long b11 = j10.b();
        StringBuilder sb4 = new StringBuilder(String.valueOf(str3).length() + 55 + String.valueOf(b11).length());
        sb4.append("Notification displayed for missing feature: ");
        sb4.append(str3);
        sb4.append(", version: ");
        sb4.append(b11);
        Log.w("GoogleApiManager", sb4.toString());
        return false;
    }

    public final void f(Status status, Exception exc, boolean z10) {
        r7.r.a(this.f10064n.A);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f10053b.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (!z10 || sVar.f10087a == 2) {
                if (status != null) {
                    sVar.d(status);
                } else {
                    sVar.e(exc);
                }
                it.remove();
            }
        }
    }

    public final void g(Status status) {
        r7.r.a(this.f10064n.A);
        f(status, null, false);
    }

    public final void h() {
        d dVar = this.f10064n;
        b8.e eVar = dVar.A;
        a aVar = this.f10055d;
        eVar.removeMessages(12, aVar);
        b8.e eVar2 = dVar.A;
        eVar2.sendMessageDelayed(eVar2.obtainMessage(12, aVar), dVar.f10038o);
    }

    public final void i(n7.a aVar) {
        HashSet hashSet = this.f10057f;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
            return;
        }
        if (it.next() != null) {
            throw new ClassCastException();
        }
        if (r7.r.h(aVar, n7.a.f9212t)) {
            com.google.android.gms.common.internal.a aVar2 = (com.google.android.gms.common.internal.a) this.f10054c;
            if (!aVar2.n() || aVar2.f3210b == null) {
                throw new RuntimeException("Failed to connect when checking package");
            }
        }
        throw null;
    }

    public final n7.c j(n7.c[] cVarArr) {
        if (cVarArr != null && cVarArr.length != 0) {
            z zVar = ((com.google.android.gms.common.internal.a) this.f10054c).f3230w;
            n7.c[] cVarArr2 = zVar == null ? null : zVar.f10963p;
            if (cVarArr2 == null) {
                cVarArr2 = new n7.c[0];
            }
            p.e eVar = new p.e(cVarArr2.length);
            for (n7.c cVar : cVarArr2) {
                eVar.put(cVar.f9221o, Long.valueOf(cVar.b()));
            }
            for (n7.c cVar2 : cVarArr) {
                Long l10 = (Long) eVar.get(cVar2.f9221o);
                if (l10 == null || l10.longValue() < cVar2.b()) {
                    return cVar2;
                }
            }
        }
        return null;
    }

    public final void k(n7.a aVar) {
        r7.r.a(this.f10064n.A);
        o7.c cVar = this.f10054c;
        String name = cVar.getClass().getName();
        String valueOf = String.valueOf(aVar);
        StringBuilder sb2 = new StringBuilder(name.length() + 25 + valueOf.length());
        sb2.append("onSignInFailed for ");
        sb2.append(name);
        sb2.append(" with ");
        sb2.append(valueOf);
        ((com.google.android.gms.common.internal.a) cVar).e(sb2.toString());
        l(aVar, null);
    }

    public final void l(n7.a aVar, RuntimeException runtimeException) {
        h8.a aVar2;
        d dVar = this.f10064n;
        r7.r.a(dVar.A);
        v vVar = this.f10059i;
        if (vVar != null && (aVar2 = vVar.f10098h) != null) {
            aVar2.d();
        }
        r7.r.a(this.f10064n.A);
        this.f10062l = null;
        SparseIntArray sparseIntArray = (SparseIntArray) dVar.f10044u.f7114o;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
        i(aVar);
        if ((this.f10054c instanceof t7.e) && aVar.f9214p != 24) {
            dVar.f10039p = true;
            b8.e eVar = dVar.A;
            eVar.sendMessageDelayed(eVar.obtainMessage(19), 300000L);
        }
        int i10 = aVar.f9214p;
        if (i10 == 4) {
            g(d.D);
            return;
        }
        if (i10 == 25) {
            g(d.c(this.f10055d, aVar));
            return;
        }
        LinkedList linkedList = this.f10053b;
        if (linkedList.isEmpty()) {
            this.f10062l = aVar;
            return;
        }
        if (runtimeException != null) {
            r7.r.a(dVar.A);
            f(null, runtimeException, false);
            return;
        }
        if (!dVar.B) {
            g(d.c(this.f10055d, aVar));
            return;
        }
        a aVar3 = this.f10055d;
        f(d.c(aVar3, aVar), null, true);
        if (linkedList.isEmpty() || c(aVar) || dVar.f(aVar, this.f10058h)) {
            return;
        }
        if (aVar.f9214p == 18) {
            this.f10060j = true;
        }
        if (!this.f10060j) {
            g(d.c(aVar3, aVar));
        } else {
            b8.e eVar2 = dVar.A;
            eVar2.sendMessageDelayed(Message.obtain(eVar2, 9, aVar3), 5000L);
        }
    }

    public final void m(s sVar) {
        r7.r.a(this.f10064n.A);
        boolean n10 = ((com.google.android.gms.common.internal.a) this.f10054c).n();
        LinkedList linkedList = this.f10053b;
        if (n10) {
            if (e(sVar)) {
                h();
                return;
            } else {
                linkedList.add(sVar);
                return;
            }
        }
        linkedList.add(sVar);
        n7.a aVar = this.f10062l;
        if (aVar == null || aVar.f9214p == 0 || aVar.f9215q == null) {
            o();
        } else {
            l(aVar, null);
        }
    }

    public final void n() {
        d dVar = this.f10064n;
        r7.r.a(dVar.A);
        Status status = d.C;
        g(status);
        this.f10056e.m(false, status);
        for (f fVar : (f[]) this.g.keySet().toArray(new f[0])) {
            m(new w(fVar, new i8.d()));
        }
        i(new n7.a(4, null, null));
        if (((com.google.android.gms.common.internal.a) this.f10054c).n()) {
            dVar.A.post(new p0.b(2, new p4.p(1, this)));
        }
    }

    public final void o() {
        d dVar = this.f10064n;
        r7.r.a(dVar.A);
        o7.c cVar = this.f10054c;
        com.google.android.gms.common.internal.a aVar = (com.google.android.gms.common.internal.a) cVar;
        if (aVar.n() || aVar.o()) {
            return;
        }
        try {
            int z10 = dVar.f10044u.z(dVar.f10042s, aVar);
            if (z10 != 0) {
                n7.a aVar2 = new n7.a(z10, null, null);
                String name = cVar.getClass().getName();
                String aVar3 = aVar2.toString();
                StringBuilder sb2 = new StringBuilder(name.length() + 35 + aVar3.length());
                sb2.append("The service for ");
                sb2.append(name);
                sb2.append(" is not available: ");
                sb2.append(aVar3);
                Log.w("GoogleApiManager", sb2.toString());
                l(aVar2, null);
                return;
            }
            n nVar = new n(dVar, aVar, this.f10055d);
            if (aVar.b()) {
                v vVar = this.f10059i;
                r7.r.e(vVar);
                h8.a aVar4 = vVar.f10098h;
                if (aVar4 != null) {
                    aVar4.d();
                }
                g1 g1Var = vVar.g;
                g1Var.f7295t = Integer.valueOf(System.identityHashCode(vVar));
                a0 a0Var = vVar.f10096e;
                Context context = vVar.f10094c;
                Handler handler = vVar.f10095d;
                vVar.f10098h = (h8.a) a0Var.d(context, handler.getLooper(), g1Var, (g8.a) g1Var.f7294s, vVar, vVar);
                vVar.f10099i = nVar;
                Set set = vVar.f10097f;
                if (set == null || set.isEmpty()) {
                    handler.post(new p0.b(vVar));
                } else {
                    h8.a aVar5 = vVar.f10098h;
                    aVar5.getClass();
                    r7.g gVar = new r7.g();
                    Objects.requireNonNull(aVar5);
                    gVar.f10916a = aVar5;
                    aVar5.f3217j = gVar;
                    aVar5.u(2, null);
                }
            }
            try {
                aVar.f3217j = nVar;
                aVar.u(2, null);
            } catch (SecurityException e7) {
                l(new n7.a(10, null, null), e7);
            }
        } catch (IllegalStateException e8) {
            l(new n7.a(10, null, null), e8);
        }
    }

    @Override // o7.g
    public final void v(int i10) {
        d dVar = this.f10064n;
        if (Looper.myLooper() == dVar.A.getLooper()) {
            b(i10);
        } else {
            dVar.A.post(new androidx.emoji2.text.j(i10, 5, this));
        }
    }

    @Override // o7.h
    public final void w(n7.a aVar) {
        l(aVar, null);
    }
}
