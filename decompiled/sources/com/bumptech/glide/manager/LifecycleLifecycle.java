package com.bumptech.glide.manager;

import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class LifecycleLifecycle implements g, androidx.lifecycle.q {

    /* renamed from: o, reason: collision with root package name */
    public final HashSet f3063o = new HashSet();

    /* renamed from: p, reason: collision with root package name */
    public final androidx.lifecycle.t f3064p;

    public LifecycleLifecycle(androidx.lifecycle.t tVar) {
        this.f3064p = tVar;
        tVar.a(this);
    }

    @Override // com.bumptech.glide.manager.g
    public final void m(h hVar) {
        this.f3063o.add(hVar);
        androidx.lifecycle.m mVar = this.f3064p.f1158c;
        if (mVar == androidx.lifecycle.m.f1144o) {
            hVar.k();
        } else if (mVar.compareTo(androidx.lifecycle.m.f1147r) >= 0) {
            hVar.j();
        } else {
            hVar.b();
        }
    }

    @z(androidx.lifecycle.l.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.r rVar) {
        ArrayList e7 = m6.n.e(this.f3063o);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            ((h) obj).k();
        }
        rVar.f().f(this);
    }

    @z(androidx.lifecycle.l.ON_START)
    public void onStart(androidx.lifecycle.r rVar) {
        ArrayList e7 = m6.n.e(this.f3063o);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            ((h) obj).j();
        }
    }

    @z(androidx.lifecycle.l.ON_STOP)
    public void onStop(androidx.lifecycle.r rVar) {
        ArrayList e7 = m6.n.e(this.f3063o);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            ((h) obj).b();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void s(h hVar) {
        this.f3063o.remove(hVar);
    }
}
