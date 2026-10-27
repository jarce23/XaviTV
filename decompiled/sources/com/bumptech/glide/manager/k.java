package com.bumptech.glide.manager;

import a6.b0;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.j0;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements Handler.Callback {

    /* renamed from: s, reason: collision with root package name */
    public static final d9.f f3073s = new d9.f(14);

    /* renamed from: o, reason: collision with root package name */
    public volatile com.bumptech.glide.o f3074o;

    /* renamed from: p, reason: collision with root package name */
    public final d9.f f3075p;

    /* renamed from: q, reason: collision with root package name */
    public final f f3076q;

    /* renamed from: r, reason: collision with root package name */
    public final j5.g f3077r;

    public k(d9.f fVar) {
        fVar = fVar == null ? f3073s : fVar;
        this.f3075p = fVar;
        j5.g gVar = new j5.g();
        gVar.f7114o = new HashMap();
        gVar.f7115p = fVar;
        this.f3077r = gVar;
        this.f3076q = (b0.f40f && b0.f39e) ? new e() : new n7.i(12);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final com.bumptech.glide.o b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = m6.n.f9027a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof f.j) {
                return c((f.j) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f3074o == null) {
            synchronized (this) {
                try {
                    if (this.f3074o == null) {
                        this.f3074o = this.f3075p.e(com.bumptech.glide.b.a(context.getApplicationContext()), new n7.i(11), new d9.f(13), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f3074o;
    }

    public final com.bumptech.glide.o c(f.j jVar) {
        char[] cArr = m6.n.f9027a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return b(jVar.getApplicationContext());
        }
        if (jVar.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f3076q.e(jVar);
        Activity a10 = a(jVar);
        boolean z10 = a10 == null || !a10.isFinishing();
        com.bumptech.glide.b a11 = com.bumptech.glide.b.a(jVar.getApplicationContext());
        androidx.lifecycle.t tVar = jVar.f310r;
        j0 n10 = jVar.n();
        j5.g gVar = this.f3077r;
        gVar.getClass();
        HashMap hashMap = (HashMap) gVar.f7114o;
        m6.n.a();
        m6.n.a();
        com.bumptech.glide.o oVar = (com.bumptech.glide.o) hashMap.get(tVar);
        if (oVar != null) {
            return oVar;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(tVar);
        com.bumptech.glide.o e7 = ((d9.f) gVar.f7115p).e(a11, lifecycleLifecycle, new n7.i(gVar, n10), jVar);
        hashMap.put(tVar, e7);
        lifecycleLifecycle.m(new i(gVar, tVar));
        if (z10) {
            e7.j();
        }
        return e7;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return false;
    }
}
