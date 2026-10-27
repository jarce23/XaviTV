package com.bumptech.glide;

import com.bumptech.glide.manager.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements com.bumptech.glide.manager.a {

    /* renamed from: a, reason: collision with root package name */
    public final t f3101a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f3102b;

    public n(o oVar, t tVar) {
        this.f3102b = oVar;
        this.f3101a = tVar;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z10) {
        if (z10) {
            synchronized (this.f3102b) {
                t tVar = this.f3101a;
                ArrayList e7 = m6.n.e((Set) tVar.f3098c);
                int size = e7.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = e7.get(i10);
                    i10++;
                    i6.c cVar = (i6.c) obj;
                    if (!cVar.i() && !cVar.e()) {
                        cVar.clear();
                        if (tVar.f3097b) {
                            ((HashSet) tVar.f3099d).add(cVar);
                        } else {
                            cVar.g();
                        }
                    }
                }
            }
        }
    }
}
