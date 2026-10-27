package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3078a;

    public m(t tVar) {
        this.f3078a = tVar;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z10) {
        ArrayList arrayList;
        m6.n.a();
        synchronized (this.f3078a) {
            arrayList = new ArrayList((HashSet) this.f3078a.f3099d);
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((a) obj).a(z10);
        }
    }
}
