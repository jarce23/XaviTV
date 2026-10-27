package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import app.shamel.tv.utils.MyGlideModule;
import java.util.Collections;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: s, reason: collision with root package name */
    public final MyGlideModule f2984s = new MyGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: app.shamel.tv.utils.MyGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    @Override // x4.f
    public final void C() {
        this.f2984s.getClass();
    }

    @Override // x4.f
    public final void S(Context context, b bVar, k kVar) {
        kVar.l(new q5.b());
        this.f2984s.S(context, bVar, kVar);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final Set Z() {
        return Collections.EMPTY_SET;
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public final d9.f a0() {
        return new d9.f(10);
    }

    @Override // x4.f
    public final void c() {
        this.f2984s.getClass();
    }
}
