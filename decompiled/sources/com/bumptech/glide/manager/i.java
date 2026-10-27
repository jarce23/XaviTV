package com.bumptech.glide.manager;

import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ androidx.lifecycle.t f3071o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j5.g f3072p;

    public i(j5.g gVar, androidx.lifecycle.t tVar) {
        this.f3072p = gVar;
        this.f3071o = tVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
        ((HashMap) this.f3072p.f7114o).remove(this.f3071o);
    }

    @Override // com.bumptech.glide.manager.h
    public final void b() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
    }
}
