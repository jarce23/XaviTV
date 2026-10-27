package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements h {

    /* renamed from: o, reason: collision with root package name */
    public final Set f3100o = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.h
    public final void b() {
        ArrayList e7 = m6.n.e(this.f3100o);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            ((j6.c) obj).b();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
        ArrayList e7 = m6.n.e(this.f3100o);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            ((j6.c) obj).j();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
        ArrayList e7 = m6.n.e(this.f3100o);
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            ((j6.c) obj).k();
        }
    }
}
