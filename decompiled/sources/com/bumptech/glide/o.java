package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.manager.t;
import com.bumptech.glide.manager.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class o implements ComponentCallbacks2, com.bumptech.glide.manager.h {

    /* renamed from: y, reason: collision with root package name */
    public static final i6.e f3103y = (i6.e) ((i6.e) new i6.e().d(Bitmap.class)).j();

    /* renamed from: o, reason: collision with root package name */
    public final b f3104o;

    /* renamed from: p, reason: collision with root package name */
    public final Context f3105p;

    /* renamed from: q, reason: collision with root package name */
    public final com.bumptech.glide.manager.g f3106q;

    /* renamed from: r, reason: collision with root package name */
    public final t f3107r;

    /* renamed from: s, reason: collision with root package name */
    public final com.bumptech.glide.manager.l f3108s;

    /* renamed from: t, reason: collision with root package name */
    public final u f3109t;

    /* renamed from: u, reason: collision with root package name */
    public final androidx.activity.j f3110u;

    /* renamed from: v, reason: collision with root package name */
    public final com.bumptech.glide.manager.b f3111v;

    /* renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList f3112w;

    /* renamed from: x, reason: collision with root package name */
    public i6.e f3113x;

    static {
    }

    public o(b bVar, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.l lVar, Context context) {
        t tVar = new t(2);
        d9.f fVar = bVar.f2993t;
        this.f3109t = new u();
        androidx.activity.j jVar = new androidx.activity.j(13, this);
        this.f3110u = jVar;
        this.f3104o = bVar;
        this.f3106q = gVar;
        this.f3108s = lVar;
        this.f3107r = tVar;
        this.f3105p = context;
        Context applicationContext = context.getApplicationContext();
        n nVar = new n(this, tVar);
        fVar.getClass();
        boolean z10 = n4.a.e(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z10 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        com.bumptech.glide.manager.b cVar = z10 ? new com.bumptech.glide.manager.c(applicationContext, nVar) : new com.bumptech.glide.manager.j();
        this.f3111v = cVar;
        synchronized (bVar.f2994u) {
            if (bVar.f2994u.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            bVar.f2994u.add(this);
        }
        char[] cArr = m6.n.f9027a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gVar.m(this);
        } else {
            m6.n.f().post(jVar);
        }
        gVar.m(cVar);
        this.f3112w = new CopyOnWriteArrayList(bVar.f2990q.f3012e);
        u(bVar.f2990q.a());
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void b() {
        this.f3109t.b();
        s();
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void j() {
        t();
        this.f3109t.j();
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void k() {
        this.f3109t.k();
        p();
        t tVar = this.f3107r;
        ArrayList e7 = m6.n.e((Set) tVar.f3098c);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            tVar.a((i6.c) obj);
        }
        ((HashSet) tVar.f3099d).clear();
        this.f3106q.s(this);
        this.f3106q.s(this.f3111v);
        m6.n.f().removeCallbacks(this.f3110u);
        this.f3104o.d(this);
    }

    public m l(Class cls) {
        return new m(this.f3104o, this, cls, this.f3105p);
    }

    public m m() {
        return l(Bitmap.class).a(f3103y);
    }

    public m n() {
        return l(Drawable.class);
    }

    public final void o(j6.c cVar) {
        if (cVar == null) {
            return;
        }
        boolean v10 = v(cVar);
        i6.c f10 = cVar.f();
        if (v10) {
            return;
        }
        b bVar = this.f3104o;
        synchronized (bVar.f2994u) {
            try {
                ArrayList arrayList = bVar.f2994u;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (((o) obj).v(cVar)) {
                        return;
                    }
                }
                if (f10 != null) {
                    cVar.i(null);
                    f10.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void p() {
        try {
            ArrayList e7 = m6.n.e(this.f3109t.f3100o);
            int size = e7.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = e7.get(i10);
                i10++;
                o((j6.c) obj);
            }
            this.f3109t.f3100o.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public m q(Integer num) {
        return n().H(num);
    }

    public m r(String str) {
        return n().I(str);
    }

    public final synchronized void s() {
        t tVar = this.f3107r;
        tVar.f3097b = true;
        ArrayList e7 = m6.n.e((Set) tVar.f3098c);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            i6.c cVar = (i6.c) obj;
            if (cVar.isRunning()) {
                cVar.pause();
                ((HashSet) tVar.f3099d).add(cVar);
            }
        }
    }

    public final synchronized void t() {
        t tVar = this.f3107r;
        int i10 = 0;
        tVar.f3097b = false;
        ArrayList e7 = m6.n.e((Set) tVar.f3098c);
        int size = e7.size();
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            i6.c cVar = (i6.c) obj;
            if (!cVar.i() && !cVar.isRunning()) {
                cVar.g();
            }
        }
        ((HashSet) tVar.f3099d).clear();
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f3107r + ", treeNode=" + this.f3108s + "}";
    }

    public synchronized void u(i6.e eVar) {
        this.f3113x = (i6.e) ((i6.e) eVar.clone()).b();
    }

    public final synchronized boolean v(j6.c cVar) {
        i6.c f10 = cVar.f();
        if (f10 == null) {
            return true;
        }
        if (!this.f3107r.a(f10)) {
            return false;
        }
        this.f3109t.f3100o.remove(cVar);
        cVar.i(null);
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
    }
}
