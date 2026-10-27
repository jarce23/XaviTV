package c2;

import android.content.Context;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 implements f3.g {

    /* renamed from: o, reason: collision with root package name */
    public long f2772o;

    /* renamed from: p, reason: collision with root package name */
    public long f2773p;

    /* renamed from: q, reason: collision with root package name */
    public Object f2774q;

    /* renamed from: r, reason: collision with root package name */
    public Object f2775r;

    public y0(f.j jVar) {
        this.f2772o = 0L;
        this.f2773p = 0L;
        this.f2774q = jVar.getApplicationContext();
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r23, java.lang.String r24, java.lang.String r25, long r26) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.y0.a(java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    public long b() {
        if (!g()) {
            return this.f2772o;
        }
        i7.h e7 = e();
        if (e7 == null) {
            return this.f2772o;
        }
        long a10 = e7.a();
        this.f2772o = a10;
        return a10;
    }

    public long c() {
        if (!g()) {
            return this.f2773p;
        }
        i7.h e7 = e();
        if (e7 == null || e7.c() == null) {
            return this.f2773p;
        }
        long j10 = e7.c().f3150s;
        this.f2773p = j10;
        return j10;
    }

    @Override // f3.g
    public k2.a0 d() {
        l1.d.g(this.f2772o != -1);
        return new k2.r(0, this.f2772o, (k2.s) this.f2774q);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i7.h e() {
        /*
            r2 = this;
            r0 = 0
            java.lang.Object r1 = r2.f2775r     // Catch: java.lang.Exception -> L7
            h7.i r1 = (h7.i) r1     // Catch: java.lang.Exception -> L7
            if (r1 != 0) goto L9
        L7:
            r1 = r0
            goto Ld
        L9:
            h7.d r1 = r1.c()     // Catch: java.lang.Exception -> L7
        Ld:
            if (r1 == 0) goto L14
            r7.r.b()
            i7.h r0 = r1.f5733j
        L14:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.y0.e():i7.h");
    }

    public void f() {
        try {
            h7.b a10 = h7.b.a((Context) this.f2774q);
            a10.getClass();
            r7.r.b();
            this.f2775r = a10.f5702c;
        } catch (Exception e7) {
            Log.e("CastManager", "Failed to init CastContext: " + e7.getMessage());
        }
    }

    public boolean g() {
        h7.d dVar = null;
        try {
            h7.i iVar = (h7.i) this.f2775r;
            if (iVar != null) {
                dVar = iVar.c();
            }
        } catch (Exception unused) {
        }
        return dVar != null && dVar.a();
    }

    public void h(long j10) {
        i7.h e7;
        if (g() && (e7 = e()) != null) {
            e7.r(new g7.p(j10));
        }
    }

    public void i() {
        try {
            h7.i iVar = (h7.i) this.f2775r;
            if (iVar != null) {
                h7.d dVar = null;
                if (iVar != null) {
                    try {
                        dVar = iVar.c();
                    } catch (Exception unused) {
                    }
                }
                if (dVar != null) {
                    r7.r.b();
                    i7.h hVar = dVar.f5733j;
                    if (hVar != null) {
                        try {
                            this.f2772o = hVar.a();
                            if (hVar.c() != null) {
                                this.f2773p = hVar.c().f3150s;
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    ((h7.i) this.f2775r).b(true);
                }
            }
        } catch (Exception e7) {
            Log.e("CastManager", "stopCasting: " + e7.getMessage());
        }
    }

    @Override // f3.g
    public long p(k2.o oVar) {
        long j10 = this.f2773p;
        if (j10 < 0) {
            return -1L;
        }
        long j11 = -(j10 + 2);
        this.f2773p = -1L;
        return j11;
    }

    @Override // f3.g
    public void u(long j10) {
        long[] jArr = (long[]) ((x4.c) this.f2775r).f13537p;
        this.f2773p = jArr[l1.a0.e(jArr, j10, true)];
    }

    public y0(int i10, long j10) {
        l1.d.g(((g2.a) this.f2774q) == null);
        this.f2772o = j10;
        this.f2773p = j10 + i10;
    }

    public y0(String str, byte[] bArr, long j10, long j11) {
        this.f2774q = str;
        this.f2775r = bArr;
        this.f2772o = j10;
        this.f2773p = j11;
    }
}
