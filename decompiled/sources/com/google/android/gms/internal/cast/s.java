package com.google.android.gms.internal.cast;

import android.util.Log;
import okhttp3.internal.http.HttpStatusCodesKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3445o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ t f3446p;

    public /* synthetic */ s(t tVar, int i10) {
        this.f3445o = i10;
        this.f3446p = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f3445o;
        t tVar = this.f3446p;
        switch (i10) {
            case 0:
                l7.b bVar = t.f3467i;
                Log.i(bVar.f8271a, bVar.d("transfer with type = %d has timed out", Integer.valueOf(tVar.f3472e)));
                tVar.b(HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS);
                break;
            default:
                r rVar = new r(tVar);
                h7.i iVar = tVar.f3473f;
                r7.r.e(iVar);
                iVar.a(rVar);
                break;
        }
    }
}
