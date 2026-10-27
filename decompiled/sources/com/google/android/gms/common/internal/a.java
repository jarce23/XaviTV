package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.AttributionSource;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import c4.l;
import com.google.android.gms.common.api.Scope;
import j9.g1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import l7.t;
import n7.d;
import o7.c;
import o7.h;
import p4.p;
import r7.a0;
import r7.b;
import r7.d0;
import r7.e;
import r7.g;
import r7.q;
import r7.r;
import r7.u;
import r7.v;
import r7.w;
import r7.x;
import r7.y;
import r7.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements c {

    /* renamed from: z, reason: collision with root package name */
    public static final n7.c[] f3208z = new n7.c[0];

    /* renamed from: a, reason: collision with root package name */
    public volatile String f3209a;

    /* renamed from: b, reason: collision with root package name */
    public l f3210b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f3211c;

    /* renamed from: d, reason: collision with root package name */
    public final Looper f3212d;

    /* renamed from: e, reason: collision with root package name */
    public final d0 f3213e;

    /* renamed from: f, reason: collision with root package name */
    public final u f3214f;
    public final Object g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3215h;

    /* renamed from: i, reason: collision with root package name */
    public q f3216i;

    /* renamed from: j, reason: collision with root package name */
    public b f3217j;

    /* renamed from: k, reason: collision with root package name */
    public IInterface f3218k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f3219l;

    /* renamed from: m, reason: collision with root package name */
    public w f3220m;

    /* renamed from: n, reason: collision with root package name */
    public int f3221n;

    /* renamed from: o, reason: collision with root package name */
    public final g f3222o;

    /* renamed from: p, reason: collision with root package name */
    public final g f3223p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3224q;

    /* renamed from: r, reason: collision with root package name */
    public final String f3225r;

    /* renamed from: s, reason: collision with root package name */
    public volatile String f3226s;

    /* renamed from: t, reason: collision with root package name */
    public volatile p f3227t;

    /* renamed from: u, reason: collision with root package name */
    public n7.a f3228u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3229v;

    /* renamed from: w, reason: collision with root package name */
    public volatile z f3230w;

    /* renamed from: x, reason: collision with root package name */
    public final AtomicInteger f3231x;

    /* renamed from: y, reason: collision with root package name */
    public final Set f3232y;

    public a(Context context, Looper looper, int i10, g1 g1Var, o7.g gVar, h hVar) {
        synchronized (d0.g) {
            try {
                if (d0.f10897h == null) {
                    d0.f10897h = new d0(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        d0 d0Var = d0.f10897h;
        Object obj = d.f9225d;
        r.e(gVar);
        r.e(hVar);
        g gVar2 = new g(gVar);
        g gVar3 = new g(hVar);
        String str = (String) g1Var.f7293r;
        this.f3209a = null;
        this.g = new Object();
        this.f3215h = new Object();
        this.f3219l = new ArrayList();
        this.f3221n = 1;
        this.f3228u = null;
        this.f3229v = false;
        this.f3230w = null;
        this.f3231x = new AtomicInteger(0);
        r.f("Context must not be null", context);
        this.f3211c = context;
        r.f("Looper must not be null", looper);
        this.f3212d = looper;
        r.f("Supervisor must not be null", d0Var);
        this.f3213e = d0Var;
        this.f3214f = new u(this, looper);
        this.f3224q = i10;
        this.f3222o = gVar2;
        this.f3223p = gVar3;
        this.f3225r = str;
        Set set = (Set) g1Var.f7291p;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f3232y = set;
    }

    @Override // o7.c
    public boolean b() {
        return false;
    }

    public abstract IInterface c(IBinder iBinder);

    public void d() {
        this.f3231x.incrementAndGet();
        ArrayList arrayList = this.f3219l;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((r7.p) arrayList.get(i10)).d();
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f3215h) {
            this.f3216i = null;
        }
        u(1, null);
    }

    public final void e(String str) {
        this.f3209a = str;
        d();
    }

    public n7.c[] f() {
        return f3208z;
    }

    public Bundle g() {
        return null;
    }

    public Bundle h() {
        return new Bundle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(e eVar, Set set) {
        String attributionTag;
        String attributionTag2;
        Bundle h10 = h();
        if (Build.VERSION.SDK_INT < 31) {
            attributionTag2 = this.f3226s;
        } else if (this.f3227t == null) {
            attributionTag2 = this.f3226s;
        } else {
            AttributionSource attributionSource = (AttributionSource) this.f3227t.f9953p;
            if (attributionSource == null) {
                attributionTag2 = this.f3226s;
            } else {
                attributionTag = attributionSource.getAttributionTag();
                attributionTag2 = attributionTag == null ? this.f3226s : attributionSource.getAttributionTag();
            }
        }
        String str = attributionTag2;
        int i10 = this.f3224q;
        int i11 = n7.e.f9228a;
        Scope[] scopeArr = r7.d.C;
        Bundle bundle = new Bundle();
        n7.c[] cVarArr = r7.d.D;
        r7.d dVar = new r7.d(6, i10, i11, null, null, scopeArr, bundle, null, cVarArr, cVarArr, true, 0, false, str);
        dVar.f10888r = this.f3211c.getPackageName();
        dVar.f10891u = h10;
        if (set != null) {
            dVar.f10890t = (Scope[]) set.toArray(new Scope[0]);
        }
        if (b()) {
            dVar.f10892v = new Account("<<default account>>", "com.google");
            if (eVar != 0) {
                dVar.f10889s = ((b8.a) eVar).f2477c;
            }
        }
        dVar.f10893w = f3208z;
        dVar.f10894x = f();
        if (r()) {
            dVar.A = true;
        }
        try {
            synchronized (this.f3215h) {
                try {
                    q qVar = this.f3216i;
                    if (qVar != null) {
                        qVar.v(new v(this, this.f3231x.get()), dVar);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e7) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e7);
            int i12 = this.f3231x.get();
            u uVar = this.f3214f;
            uVar.sendMessage(uVar.obtainMessage(6, i12, 3));
        } catch (RemoteException e8) {
            e = e8;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            q(8, null, null, this.f3231x.get());
        } catch (SecurityException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            q(8, null, null, this.f3231x.get());
        }
    }

    public final IInterface j() {
        IInterface iInterface;
        synchronized (this.g) {
            try {
                if (this.f3221n == 5) {
                    throw new DeadObjectException();
                }
                if (!n()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f3218k;
                r.f("Client is connected but service is null", iInterface);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String k();

    public abstract String l();

    public boolean m() {
        return a() >= 211700000;
    }

    public final boolean n() {
        boolean z10;
        synchronized (this.g) {
            z10 = this.f3221n == 4;
        }
        return z10;
    }

    public final boolean o() {
        boolean z10;
        synchronized (this.g) {
            int i10 = this.f3221n;
            z10 = true;
            if (i10 != 2 && i10 != 3) {
                z10 = false;
            }
        }
        return z10;
    }

    public void p(n7.a aVar) {
        aVar.getClass();
        System.currentTimeMillis();
    }

    public void q(int i10, IBinder iBinder, Bundle bundle, int i11) {
        x xVar = new x(this, i10, iBinder, bundle);
        u uVar = this.f3214f;
        uVar.sendMessage(uVar.obtainMessage(1, i11, -1, xVar));
    }

    public boolean r() {
        return this instanceof t;
    }

    public final /* synthetic */ boolean s(int i10, int i11, IInterface iInterface) {
        synchronized (this.g) {
            try {
                if (this.f3221n != i10) {
                    return false;
                }
                u(i11, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void t() {
        int i10;
        int i11;
        synchronized (this.g) {
            i10 = this.f3221n;
        }
        if (i10 == 3) {
            this.f3229v = true;
            i11 = 5;
        } else {
            i11 = 4;
        }
        u uVar = this.f3214f;
        uVar.sendMessage(uVar.obtainMessage(i11, this.f3231x.get(), 16));
    }

    public final void u(int i10, IInterface iInterface) {
        l lVar;
        if ((i10 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.g) {
            try {
                this.f3221n = i10;
                this.f3218k = iInterface;
                Bundle bundle = null;
                if (i10 == 1) {
                    w wVar = this.f3220m;
                    if (wVar != null) {
                        d0 d0Var = this.f3213e;
                        String str = this.f3210b.f2909a;
                        r.e(str);
                        this.f3210b.getClass();
                        if (this.f3225r == null) {
                            this.f3211c.getClass();
                        }
                        d0Var.c(str, wVar, this.f3210b.f2910b);
                        this.f3220m = null;
                    }
                } else if (i10 == 2 || i10 == 3) {
                    w wVar2 = this.f3220m;
                    if (wVar2 != null && (lVar = this.f3210b) != null) {
                        String str2 = lVar.f2909a;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 70 + "com.google.android.gms".length());
                        sb2.append("Calling connect() while still connected, missing disconnect() for ");
                        sb2.append(str2);
                        sb2.append(" on com.google.android.gms");
                        Log.e("GmsClient", sb2.toString());
                        d0 d0Var2 = this.f3213e;
                        String str3 = this.f3210b.f2909a;
                        r.e(str3);
                        this.f3210b.getClass();
                        if (this.f3225r == null) {
                            this.f3211c.getClass();
                        }
                        d0Var2.c(str3, wVar2, this.f3210b.f2910b);
                        this.f3231x.incrementAndGet();
                    }
                    w wVar3 = new w(this, this.f3231x.get());
                    this.f3220m = wVar3;
                    String l10 = l();
                    boolean m10 = m();
                    this.f3210b = new l(l10, m10);
                    if (m10 && a() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f3210b.f2909a)));
                    }
                    d0 d0Var3 = this.f3213e;
                    String str4 = this.f3210b.f2909a;
                    r.e(str4);
                    this.f3210b.getClass();
                    String str5 = this.f3225r;
                    if (str5 == null) {
                        str5 = this.f3211c.getClass().getName();
                    }
                    n7.a b2 = d0Var3.b(new a0(str4, this.f3210b.f2910b), wVar3, str5);
                    if (!(b2.f9214p == 0)) {
                        String str6 = this.f3210b.f2909a;
                        StringBuilder sb3 = new StringBuilder(String.valueOf(str6).length() + 34 + "com.google.android.gms".length());
                        sb3.append("unable to connect to service: ");
                        sb3.append(str6);
                        sb3.append(" on com.google.android.gms");
                        Log.w("GmsClient", sb3.toString());
                        int i11 = b2.f9214p;
                        if (i11 == -1) {
                            i11 = 16;
                        }
                        if (b2.f9215q != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", b2.f9215q);
                        }
                        int i12 = this.f3231x.get();
                        y yVar = new y(this, i11, bundle);
                        u uVar = this.f3214f;
                        uVar.sendMessage(uVar.obtainMessage(7, i12, -1, yVar));
                    }
                } else if (i10 == 4) {
                    r.e(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }
}
