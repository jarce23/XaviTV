package o1;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c implements h {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f9384o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f9385p = new ArrayList(1);

    /* renamed from: q, reason: collision with root package name */
    public int f9386q;

    /* renamed from: r, reason: collision with root package name */
    public l f9387r;

    public c(boolean z10) {
        this.f9384o = z10;
    }

    @Override // o1.h
    public Map e() {
        return Collections.EMPTY_MAP;
    }

    public final void f(int i10) {
        l lVar = this.f9387r;
        int i11 = l1.a0.f8067a;
        for (int i12 = 0; i12 < this.f9386q; i12++) {
            e0 e0Var = (e0) this.f9385p.get(i12);
            boolean z10 = this.f9384o;
            g2.g gVar = (g2.g) e0Var;
            synchronized (gVar) {
                w0 w0Var = g2.g.f5094p;
                if (z10 && (lVar.f9435i & 8) != 8) {
                    gVar.f5108i += i10;
                }
            }
        }
    }

    @Override // o1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        ArrayList arrayList = this.f9385p;
        if (arrayList.contains(e0Var)) {
            return;
        }
        arrayList.add(e0Var);
        this.f9386q++;
    }

    public final void q() {
        l lVar = this.f9387r;
        int i10 = l1.a0.f8067a;
        for (int i11 = 0; i11 < this.f9386q; i11++) {
            e0 e0Var = (e0) this.f9385p.get(i11);
            boolean z10 = this.f9384o;
            g2.g gVar = (g2.g) e0Var;
            synchronized (gVar) {
                try {
                    w0 w0Var = g2.g.f5094p;
                    if (z10 && (lVar.f9435i & 8) != 8) {
                        l1.d.g(gVar.g > 0);
                        gVar.f5104d.getClass();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        int i12 = (int) (elapsedRealtime - gVar.f5107h);
                        gVar.f5109j += i12;
                        long j10 = gVar.f5110k;
                        long j11 = gVar.f5108i;
                        gVar.f5110k = j10 + j11;
                        if (i12 > 0) {
                            gVar.f5106f.a((int) Math.sqrt(j11), (j11 * 8000.0f) / i12);
                            if (gVar.f5109j < 2000) {
                                if (gVar.f5110k >= 524288) {
                                }
                                gVar.b(i12, gVar.f5108i, gVar.f5111l);
                                gVar.f5107h = elapsedRealtime;
                                gVar.f5108i = 0L;
                            }
                            gVar.f5111l = (long) gVar.f5106f.b();
                            gVar.b(i12, gVar.f5108i, gVar.f5111l);
                            gVar.f5107h = elapsedRealtime;
                            gVar.f5108i = 0L;
                        }
                        gVar.g--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f9387r = null;
    }

    public final void r() {
        for (int i10 = 0; i10 < this.f9386q; i10++) {
            ((e0) this.f9385p.get(i10)).getClass();
        }
    }

    public final void s(l lVar) {
        this.f9387r = lVar;
        for (int i10 = 0; i10 < this.f9386q; i10++) {
            e0 e0Var = (e0) this.f9385p.get(i10);
            boolean z10 = this.f9384o;
            g2.g gVar = (g2.g) e0Var;
            synchronized (gVar) {
                try {
                    w0 w0Var = g2.g.f5094p;
                    if (z10 && (lVar.f9435i & 8) != 8) {
                        if (gVar.g == 0) {
                            gVar.f5104d.getClass();
                            gVar.f5107h = SystemClock.elapsedRealtime();
                        }
                        gVar.g++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
