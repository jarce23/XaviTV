package com.bumptech.glide.manager;

import android.view.View;
import android.view.ViewTreeObserver;
import app.shamel.tv.activities.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements ViewTreeObserver.OnDrawListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ View f3067o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ e f3068p;

    public d(e eVar, View view) {
        this.f3068p = eVar;
        this.f3067o = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        m6.n.f().post(new y(this, 7, this));
    }
}
