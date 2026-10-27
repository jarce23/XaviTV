package q4;

import android.os.Handler;
import android.util.Log;
import h5.i;
import j5.g;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import p4.l;
import r5.e;
import x4.m;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements v5.a {

    /* renamed from: o, reason: collision with root package name */
    public final long f10333o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f10334p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f10335q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f10336r;

    /* renamed from: s, reason: collision with root package name */
    public Object f10337s;

    public d(i iVar, x4.c cVar) {
        h.e("runnableScheduler", iVar);
        long millis = TimeUnit.MINUTES.toMillis(90L);
        this.f10334p = iVar;
        this.f10335q = cVar;
        this.f10333o = millis;
        this.f10336r = new Object();
        this.f10337s = new LinkedHashMap();
    }

    @Override // v5.a
    public void a(e eVar, m mVar) {
        v5.b bVar;
        boolean z10;
        String T = ((x4.c) this.f10334p).T(eVar);
        g gVar = (g) this.f10336r;
        synchronized (gVar) {
            try {
                bVar = (v5.b) ((HashMap) gVar.f7114o).get(T);
                if (bVar == null) {
                    bVar = ((e6.a) gVar.f7115p).a();
                    ((HashMap) gVar.f7114o).put(T, bVar);
                }
                bVar.f12677b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.f12676a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + T + " for for Key: " + eVar);
            }
            try {
                o5.c c10 = c();
                if (c10.K(T) == null) {
                    c4.e s10 = c10.s(T);
                    if (s10 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: ".concat(T));
                    }
                    try {
                        if (((r5.b) mVar.f13564p).l(mVar.f13565q, s10.e(), (r5.h) mVar.f13566r)) {
                            o5.c.a((o5.c) s10.f2878r, s10, true);
                            s10.f2875o = true;
                        }
                        if (!z10) {
                            try {
                                s10.c();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!s10.f2875o) {
                            try {
                                s10.c();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException e7) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e7);
                }
            }
        } finally {
            ((g) this.f10336r).r(T);
        }
    }

    public void b(l lVar) {
        Runnable runnable;
        h.e("token", lVar);
        synchronized (this.f10336r) {
            runnable = (Runnable) ((LinkedHashMap) this.f10337s).remove(lVar);
        }
        if (runnable != null) {
            ((Handler) ((i) this.f10334p).f5610p).removeCallbacks(runnable);
        }
    }

    public synchronized o5.c c() {
        try {
            if (((o5.c) this.f10337s) == null) {
                this.f10337s = o5.c.N((File) this.f10335q, this.f10333o);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (o5.c) this.f10337s;
    }

    public void d(l lVar) {
        androidx.fragment.app.d dVar = new androidx.fragment.app.d(this, 17, lVar);
        synchronized (this.f10336r) {
        }
        i iVar = (i) this.f10334p;
        ((Handler) iVar.f5610p).postDelayed(dVar, this.f10333o);
    }

    @Override // v5.a
    public File l(e eVar) {
        String T = ((x4.c) this.f10334p).T(eVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + T + " for for Key: " + eVar);
        }
        try {
            i K = c().K(T);
            if (K != null) {
                return ((File[]) K.f5610p)[0];
            }
            return null;
        } catch (IOException e7) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e7);
            return null;
        }
    }

    public d(File file) {
        this.f10336r = new g(19);
        this.f10335q = file;
        this.f10333o = 262144000L;
        this.f10334p = new x4.c(19);
    }
}
