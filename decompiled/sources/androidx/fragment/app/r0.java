package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r0 implements androidx.lifecycle.h, f4.e, androidx.lifecycle.o0 {

    /* renamed from: o, reason: collision with root package name */
    public final s f794o;

    /* renamed from: p, reason: collision with root package name */
    public final androidx.lifecycle.n0 f795p;

    /* renamed from: q, reason: collision with root package name */
    public final androidx.activity.d f796q;

    /* renamed from: r, reason: collision with root package name */
    public androidx.lifecycle.t f797r = null;

    /* renamed from: s, reason: collision with root package name */
    public com.bumptech.glide.manager.t f798s = null;

    public r0(s sVar, androidx.lifecycle.n0 n0Var, androidx.activity.d dVar) {
        this.f794o = sVar;
        this.f795p = n0Var;
        this.f796q = dVar;
    }

    public final void a(androidx.lifecycle.l lVar) {
        this.f797r.d(lVar);
    }

    @Override // f4.e
    public final f4.d b() {
        c();
        return (f4.d) this.f798s.f3099d;
    }

    public final void c() {
        if (this.f797r == null) {
            this.f797r = new androidx.lifecycle.t(this);
            com.bumptech.glide.manager.t tVar = new com.bumptech.glide.manager.t(this);
            this.f798s = tVar;
            tVar.c();
            this.f796q.run();
        }
    }

    @Override // androidx.lifecycle.h
    public final d1.b d() {
        Application application;
        s sVar = this.f794o;
        Context applicationContext = sVar.E().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        d1.b bVar = new d1.b();
        LinkedHashMap linkedHashMap = (LinkedHashMap) bVar.f2162a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.m0.f1150a, application);
        }
        linkedHashMap.put(androidx.lifecycle.g0.f1128a, sVar);
        linkedHashMap.put(androidx.lifecycle.g0.f1129b, this);
        Bundle bundle = sVar.f811t;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.g0.f1130c, bundle);
        }
        return bVar;
    }

    @Override // androidx.lifecycle.o0
    public final androidx.lifecycle.n0 e() {
        c();
        return this.f795p;
    }

    @Override // androidx.lifecycle.r
    public final androidx.lifecycle.t f() {
        c();
        return this.f797r;
    }
}
