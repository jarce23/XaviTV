package z6;

import a7.l;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.media.session.a0;
import j9.n;
import java.util.Objects;
import s1.v;
import s6.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ n f14132o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ i f14133p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f14134q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Runnable f14135r;

    public /* synthetic */ d(n nVar, i iVar, int i10, Runnable runnable) {
        this.f14132o = nVar;
        this.f14133p = iVar;
        this.f14134q = i10;
        this.f14135r = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f14133p;
        int i10 = this.f14134q;
        Runnable runnable = this.f14135r;
        n nVar = this.f14132o;
        b7.c cVar = (b7.c) nVar.f7387u;
        try {
            try {
                a7.d dVar = (a7.d) nVar.f7384r;
                Objects.requireNonNull(dVar);
                ((l) cVar).x(new e(0, dVar));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ((Context) nVar.f7390x).getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    ((l) cVar).x(new v(nVar, iVar, i10));
                } else {
                    nVar.a(iVar, i10);
                }
                runnable.run();
            } catch (b7.a unused) {
                ((a0) nVar.f7385s).V(iVar, i10 + 1, false);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }
}
