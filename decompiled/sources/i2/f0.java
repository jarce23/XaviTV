package i2;

import android.os.SystemClock;
import i1.f1;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final x4.l f6186a;

    /* renamed from: b, reason: collision with root package name */
    public final z f6187b;

    /* renamed from: c, reason: collision with root package name */
    public final e3.a f6188c = new e3.a();

    /* renamed from: d, reason: collision with root package name */
    public final app.shamel.tv.activities.v f6189d = new app.shamel.tv.activities.v();

    /* renamed from: e, reason: collision with root package name */
    public final app.shamel.tv.activities.v f6190e = new app.shamel.tv.activities.v();

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.material.datepicker.m f6191f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public long f6192h;

    /* renamed from: i, reason: collision with root package name */
    public long f6193i;

    /* renamed from: j, reason: collision with root package name */
    public f1 f6194j;

    /* renamed from: k, reason: collision with root package name */
    public long f6195k;

    public f0(x4.l lVar, z zVar) {
        this.f6186a = lVar;
        this.f6187b = zVar;
        com.google.android.material.datepicker.m mVar = new com.google.android.material.datepicker.m();
        int highestOneBit = Integer.bitCount(16) != 1 ? Integer.highestOneBit(15) << 1 : 16;
        mVar.f3771o = 0;
        mVar.f3772p = -1;
        mVar.f3773q = 0;
        mVar.f3775s = new long[highestOneBit];
        mVar.f3774r = highestOneBit - 1;
        this.f6191f = mVar;
        this.g = -9223372036854775807L;
        this.f6194j = f1.f5878d;
        this.f6192h = -9223372036854775807L;
        this.f6193i = -9223372036854775807L;
    }

    public final void a(long j10, long j11) {
        final x4.l lVar = this.f6186a;
        d dVar = (d) lVar.f13562p;
        while (true) {
            com.google.android.material.datepicker.m mVar = this.f6191f;
            int i10 = mVar.f3773q;
            if (i10 == 0) {
                return;
            }
            if (i10 == 0) {
                throw new NoSuchElementException();
            }
            long j12 = ((long[]) mVar.f3775s)[mVar.f3771o];
            Long l10 = (Long) this.f6190e.f(j12);
            z zVar = this.f6187b;
            if (l10 != null && l10.longValue() != this.f6195k) {
                this.f6195k = l10.longValue();
                zVar.f(2);
            }
            long j13 = this.f6195k;
            z zVar2 = this.f6187b;
            e3.a aVar = this.f6188c;
            int a10 = zVar2.a(j12, j10, j11, j13, false, false, aVar);
            if (a10 == 0 || a10 == 1) {
                this.f6192h = j12;
                boolean z10 = a10 == 0;
                long d6 = mVar.d();
                f1 f1Var = (f1) this.f6189d.f(d6);
                if (f1Var != null && !f1Var.equals(f1.f5878d) && !f1Var.equals(this.f6194j)) {
                    this.f6194j = f1Var;
                    i1.o oVar = new i1.o();
                    oVar.f5947t = f1Var.f5879a;
                    oVar.f5948u = f1Var.f5880b;
                    oVar.f5940m = i1.g0.m("video/raw");
                    lVar.f13561o = new i1.p(oVar);
                    dVar.f6151h.execute(new androidx.fragment.app.d(lVar, 6, f1Var));
                }
                long nanoTime = z10 ? System.nanoTime() : aVar.f4416b;
                boolean z11 = zVar.f6308e != 3;
                zVar.f6308e = 3;
                zVar.f6314l.getClass();
                zVar.g = l1.a0.O(SystemClock.elapsedRealtime());
                if (z11 && dVar.f6148d != null) {
                    final int i11 = 0;
                    dVar.f6151h.execute(new Runnable() { // from class: i2.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i11) {
                                case 0:
                                    ((d) lVar.f13562p).g.i();
                                    break;
                                default:
                                    ((d) lVar.f13562p).g.k();
                                    break;
                            }
                        }
                    });
                }
                i1.p pVar = (i1.p) lVar.f13561o;
                dVar.f6152i.d(d6, nanoTime, pVar == null ? new i1.p(new i1.o()) : pVar, null);
                h hVar = (h) dVar.f6147c.remove();
                hVar.f6203c.H0(hVar.f6201a, hVar.f6202b, nanoTime);
            } else if (a10 == 2 || a10 == 3) {
                this.f6192h = j12;
                mVar.d();
                final int i12 = 1;
                dVar.f6151h.execute(new Runnable() { // from class: i2.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i12) {
                            case 0:
                                ((d) lVar.f13562p).g.i();
                                break;
                            default:
                                ((d) lVar.f13562p).g.k();
                                break;
                        }
                    }
                });
                h hVar2 = (h) dVar.f6147c.remove();
                hVar2.f6203c.L0(hVar2.f6201a, hVar2.f6202b);
            } else {
                if (a10 != 4) {
                    if (a10 != 5) {
                        throw new IllegalStateException(String.valueOf(a10));
                    }
                    return;
                }
                this.f6192h = j12;
            }
        }
    }
}
