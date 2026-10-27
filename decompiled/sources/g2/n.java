package g2;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    public static final h f5127d = new h(0, -9223372036854775807L, false);

    /* renamed from: e, reason: collision with root package name */
    public static final h f5128e = new h(2, -9223372036854775807L, false);

    /* renamed from: f, reason: collision with root package name */
    public static final h f5129f = new h(3, -9223372036854775807L, false);

    /* renamed from: a, reason: collision with root package name */
    public final h2.b f5130a;

    /* renamed from: b, reason: collision with root package name */
    public j f5131b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f5132c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "ExoPlayer:Loader:"
            java.lang.String r3 = r0.concat(r3)
            int r0 = l1.a0.f8067a
            androidx.emoji2.text.a r0 = new androidx.emoji2.text.a
            r1 = 1
            r0.<init>(r3, r1)
            java.util.concurrent.ExecutorService r3 = java.util.concurrent.Executors.newSingleThreadExecutor(r0)
            a6.a0 r0 = new a6.a0
            r1 = 26
            r0.<init>(r1)
            h2.b r1 = new h2.b
            r1.<init>(r3, r0)
            r2.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.n.<init>(java.lang.String):void");
    }

    public final void a() {
        j jVar = this.f5131b;
        l1.d.h(jVar);
        jVar.a(false);
    }

    public final boolean b() {
        return this.f5131b != null;
    }

    public final void c(l lVar) {
        j jVar = this.f5131b;
        if (jVar != null) {
            jVar.a(true);
        }
        h2.b bVar = this.f5130a;
        if (lVar != null) {
            bVar.execute(new androidx.activity.j(15, lVar));
        }
        bVar.f5520p.accept(bVar.f5519o);
    }

    public final void d(k kVar, i iVar, int i10) {
        Looper myLooper = Looper.myLooper();
        l1.d.h(myLooper);
        this.f5132c = null;
        j jVar = new j(this, myLooper, kVar, iVar, i10, SystemClock.elapsedRealtime());
        l1.d.g(this.f5131b == null);
        this.f5131b = jVar;
        jVar.b();
    }

    public n(h2.b bVar) {
        this.f5130a = bVar;
    }
}
