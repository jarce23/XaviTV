package p7;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import okhttp3.internal.http.HttpStatusCodesKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements i8.a {

    /* renamed from: o, reason: collision with root package name */
    public final d f10078o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10079p;

    /* renamed from: q, reason: collision with root package name */
    public final a f10080q;

    /* renamed from: r, reason: collision with root package name */
    public final long f10081r;

    /* renamed from: s, reason: collision with root package name */
    public final long f10082s;

    public q(d dVar, int i10, a aVar, long j10, long j11) {
        this.f10078o = dVar;
        this.f10079p = i10;
        this.f10080q = aVar;
        this.f10081r = j10;
        this.f10082s = j11;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0031 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static r7.c a(p7.k r4, com.google.android.gms.common.internal.a r5, int r6) {
        /*
            r7.z r5 = r5.f3230w
            r0 = 0
            if (r5 != 0) goto L7
            r5 = r0
            goto L9
        L7:
            r7.c r5 = r5.f10965r
        L9:
            if (r5 == 0) goto L35
            boolean r1 = r5.f10879p
            if (r1 == 0) goto L35
            int[] r1 = r5.f10881r
            r2 = 0
            if (r1 != 0) goto L24
            int[] r1 = r5.f10883t
            if (r1 != 0) goto L19
            goto L2b
        L19:
            int r3 = r1.length
            if (r2 >= r3) goto L2b
            r3 = r1[r2]
            if (r3 != r6) goto L21
            goto L35
        L21:
            int r2 = r2 + 1
            goto L19
        L24:
            int r3 = r1.length
            if (r2 >= r3) goto L35
            r3 = r1[r2]
            if (r3 != r6) goto L32
        L2b:
            int r4 = r4.f10063m
            int r6 = r5.f10882s
            if (r4 >= r6) goto L35
            return r5
        L32:
            int r2 = r2 + 1
            goto L24
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.q.a(p7.k, com.google.android.gms.common.internal.a, int):r7.c");
    }

    @Override // i8.a
    public final void z(i8.i iVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j10;
        long j11;
        d dVar = this.f10078o;
        if (dVar.e()) {
            r7.h hVar = (r7.h) r7.g.b().f10916a;
            if (hVar == null || hVar.f10918p) {
                k kVar = (k) dVar.f10047x.get(this.f10080q);
                if (kVar != null) {
                    o7.c cVar = kVar.f10054c;
                    if (cVar instanceof com.google.android.gms.common.internal.a) {
                        com.google.android.gms.common.internal.a aVar = (com.google.android.gms.common.internal.a) cVar;
                        long j12 = this.f10081r;
                        int i15 = 0;
                        boolean z10 = j12 > 0;
                        int i16 = aVar.f3224q;
                        if (hVar != null) {
                            z10 &= hVar.f10919q;
                            i10 = hVar.f10920r;
                            i11 = hVar.f10921s;
                            i12 = hVar.f10917o;
                            if (aVar.f3230w != null && !aVar.o()) {
                                r7.c a10 = a(kVar, aVar, this.f10079p);
                                if (a10 == null) {
                                    return;
                                }
                                boolean z11 = a10.f10880q && j12 > 0;
                                i11 = a10.f10882s;
                                z10 = z11;
                            }
                        } else {
                            i10 = 5000;
                            i11 = 100;
                            i12 = 0;
                        }
                        int i17 = i10;
                        int i18 = i11;
                        int i19 = -1;
                        if (iVar.n()) {
                            i14 = 0;
                        } else {
                            Exception k10 = iVar.k();
                            if (k10 instanceof o7.d) {
                                Status status = ((o7.d) k10).f9546o;
                                i13 = status.f3193o;
                                n7.a aVar2 = status.f3196r;
                                if (aVar2 != null) {
                                    i14 = i13;
                                    i15 = aVar2.f9214p;
                                }
                            } else {
                                i13 = HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS;
                            }
                            i14 = i13;
                            i15 = -1;
                        }
                        if (z10) {
                            long j13 = this.f10082s;
                            long currentTimeMillis = System.currentTimeMillis();
                            i19 = (int) (SystemClock.elapsedRealtime() - j13);
                            j10 = j12;
                            j11 = currentTimeMillis;
                        } else {
                            j10 = 0;
                            j11 = 0;
                        }
                        r rVar = new r(new r7.f(this.f10079p, i14, i15, j10, j11, null, null, i16, i19), i12, i17, i18);
                        b8.e eVar = dVar.A;
                        eVar.sendMessage(eVar.obtainMessage(18, rVar));
                    }
                }
            }
        }
    }
}
