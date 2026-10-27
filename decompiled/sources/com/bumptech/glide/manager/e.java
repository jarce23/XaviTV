package com.bumptech.glide.manager;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: o, reason: collision with root package name */
    public final Set f3069o = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f3070p;

    @Override // com.bumptech.glide.manager.f
    public final void e(f.j jVar) {
        if (!this.f3070p && this.f3069o.add(jVar)) {
            View decorView = jVar.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new d(this, decorView));
        }
    }
}
