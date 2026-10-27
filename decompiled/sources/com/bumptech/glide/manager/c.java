package com.bumptech.glide.manager;

import android.content.Context;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: o, reason: collision with root package name */
    public final Context f3065o;

    /* renamed from: p, reason: collision with root package name */
    public final com.bumptech.glide.n f3066p;

    public c(Context context, com.bumptech.glide.n nVar) {
        this.f3065o = context.getApplicationContext();
        this.f3066p = nVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void b() {
        t b2 = t.b(this.f3065o);
        com.bumptech.glide.n nVar = this.f3066p;
        synchronized (b2) {
            ((HashSet) b2.f3099d).remove(nVar);
            if (b2.f3097b && ((HashSet) b2.f3099d).isEmpty()) {
                ((n) b2.f3098c).a();
                b2.f3097b = false;
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
        t b2 = t.b(this.f3065o);
        com.bumptech.glide.n nVar = this.f3066p;
        synchronized (b2) {
            ((HashSet) b2.f3099d).add(nVar);
            if (!b2.f3097b && !((HashSet) b2.f3099d).isEmpty()) {
                b2.f3097b = ((n) b2.f3098c).b();
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
    }
}
