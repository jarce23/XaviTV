package t5;

import android.os.SystemClock;
import android.util.Log;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 implements f, e {

    /* renamed from: o, reason: collision with root package name */
    public final g f11896o;

    /* renamed from: p, reason: collision with root package name */
    public final h f11897p;

    /* renamed from: q, reason: collision with root package name */
    public volatile int f11898q;

    /* renamed from: r, reason: collision with root package name */
    public volatile c f11899r;

    /* renamed from: s, reason: collision with root package name */
    public volatile Object f11900s;

    /* renamed from: t, reason: collision with root package name */
    public volatile x5.s f11901t;

    /* renamed from: u, reason: collision with root package name */
    public volatile d f11902u;

    public b0(g gVar, h hVar) {
        this.f11896o = gVar;
        this.f11897p = hVar;
    }

    @Override // t5.e
    public final void a(r5.e eVar, Exception exc, com.bumptech.glide.load.data.d dVar, int i10) {
        this.f11897p.a(eVar, exc, dVar, this.f11901t.f13666c.c());
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (d(r0) == false) goto L16;
     */
    @Override // t5.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f11900s
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L20
            java.lang.Object r0 = r7.f11900s
            r7.f11900s = r1
            boolean r0 = r7.d(r0)     // Catch: java.io.IOException -> L11
            if (r0 != 0) goto L20
            goto L2c
        L11:
            r0 = move-exception
            r3 = 3
            java.lang.String r4 = "SourceGenerator"
            boolean r3 = android.util.Log.isLoggable(r4, r3)
            if (r3 == 0) goto L20
            java.lang.String r3 = "Failed to properly rewind or write data to cache"
            android.util.Log.d(r4, r3, r0)
        L20:
            t5.c r0 = r7.f11899r
            if (r0 == 0) goto L2d
            t5.c r0 = r7.f11899r
            boolean r0 = r0.b()
            if (r0 == 0) goto L2d
        L2c:
            return r2
        L2d:
            r7.f11899r = r1
            r7.f11901t = r1
            r0 = 0
        L32:
            if (r0 != 0) goto L93
            int r1 = r7.f11898q
            t5.g r3 = r7.f11896o
            java.util.ArrayList r3 = r3.b()
            int r3 = r3.size()
            if (r1 >= r3) goto L93
            t5.g r1 = r7.f11896o
            java.util.ArrayList r1 = r1.b()
            int r3 = r7.f11898q
            int r4 = r3 + 1
            r7.f11898q = r4
            java.lang.Object r1 = r1.get(r3)
            x5.s r1 = (x5.s) r1
            r7.f11901t = r1
            x5.s r1 = r7.f11901t
            if (r1 == 0) goto L32
            t5.g r1 = r7.f11896o
            t5.j r1 = r1.f11928p
            x5.s r3 = r7.f11901t
            com.bumptech.glide.load.data.d r3 = r3.f13666c
            int r3 = r3.c()
            boolean r1 = r1.a(r3)
            if (r1 != 0) goto L7c
            t5.g r1 = r7.f11896o
            x5.s r3 = r7.f11901t
            com.bumptech.glide.load.data.d r3 = r3.f13666c
            java.lang.Class r3 = r3.a()
            t5.w r1 = r1.c(r3)
            if (r1 == 0) goto L32
        L7c:
            x5.s r0 = r7.f11901t
            x5.s r1 = r7.f11901t
            com.bumptech.glide.load.data.d r1 = r1.f13666c
            t5.g r3 = r7.f11896o
            com.bumptech.glide.i r3 = r3.f11927o
            x4.c r4 = new x4.c
            r5 = 17
            r6 = 0
            r4.<init>(r7, r0, r5, r6)
            r1.d(r3, r4)
            r0 = r2
            goto L32
        L93:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.b0.b():boolean");
    }

    @Override // t5.e
    public final void c(r5.e eVar, Object obj, com.bumptech.glide.load.data.d dVar, int i10, r5.e eVar2) {
        this.f11897p.c(eVar, obj, dVar, this.f11901t.f13666c.c(), eVar);
    }

    @Override // t5.f
    public final void cancel() {
        x5.s sVar = this.f11901t;
        if (sVar != null) {
            sVar.f13666c.cancel();
        }
    }

    public final boolean d(Object obj) {
        Throwable th;
        int i10 = m6.h.f9016b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        boolean z10 = false;
        try {
            com.bumptech.glide.load.data.f h10 = this.f11896o.f11916c.b().h(obj);
            Object a10 = h10.a();
            r5.b d6 = this.f11896o.d(a10);
            x4.m mVar = new x4.m(d6, a10, this.f11896o.f11921i, 24);
            r5.e eVar = this.f11901t.f13664a;
            g gVar = this.f11896o;
            d dVar = new d(eVar, gVar.f11926n);
            v5.a b2 = gVar.f11920h.b();
            b2.a(dVar, mVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + d6 + ", duration: " + m6.h.a(elapsedRealtimeNanos));
            }
            if (b2.l(dVar) != null) {
                this.f11902u = dVar;
                this.f11899r = new c(Collections.singletonList(this.f11901t.f13664a), this.f11896o, this);
                this.f11901t.f13666c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f11902u + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f11897p.c(this.f11901t.f13664a, h10.a(), this.f11901t.f13666c, this.f11901t.f13666c.c(), this.f11901t.f13664a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                if (z10) {
                    throw th;
                }
                this.f11901t.f13666c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
