package com.google.android.gms.internal.cast;

import android.content.Context;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3342o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ m f3343p;

    public /* synthetic */ j(m mVar, int i10) {
        this.f3342o = i10;
        this.f3343p = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3342o) {
            case 0:
                m mVar = this.f3343p;
                x4.e eVar = mVar.f3371e;
                if (((w3.b0) eVar.f13543q) == null) {
                    eVar.f13543q = w3.b0.d((Context) eVar.f13542p);
                }
                w3.b0 b0Var = (w3.b0) eVar.f13543q;
                if (b0Var != null) {
                    b0Var.i(mVar);
                    break;
                }
                break;
            default:
                this.f3343p.n();
                break;
        }
    }
}
