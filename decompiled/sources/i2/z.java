package i2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.SystemClock;
import android.view.Surface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final l f6304a;

    /* renamed from: b, reason: collision with root package name */
    public final e0 f6305b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6306c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6307d;
    public long g;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6312j;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6315m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6316n;

    /* renamed from: e, reason: collision with root package name */
    public int f6308e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f6309f = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f6310h = -9223372036854775807L;

    /* renamed from: i, reason: collision with root package name */
    public long f6311i = -9223372036854775807L;

    /* renamed from: k, reason: collision with root package name */
    public float f6313k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    public l1.v f6314l = l1.v.f8135a;

    public z(Context context, l lVar, long j10) {
        this.f6304a = lVar;
        this.f6306c = j10;
        this.f6305b = new e0(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0149, code lost:
    
        if (r4 > 100000) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0155, code lost:
    
        if (r29 >= r33) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x007a, code lost:
    
        if ((r9 == 0 ? false : r7.g[(int) ((r9 - 1) % 15)]) != false) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(long r27, long r29, long r31, long r33, boolean r35, boolean r36, e3.a r37) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.z.a(long, long, long, long, boolean, boolean, e3.a):int");
    }

    public final boolean b(boolean z10) {
        if (z10 && (this.f6308e == 3 || (!this.f6315m && this.f6316n))) {
            this.f6311i = -9223372036854775807L;
            return true;
        }
        if (this.f6311i == -9223372036854775807L) {
            return false;
        }
        this.f6314l.getClass();
        if (SystemClock.elapsedRealtime() < this.f6311i) {
            return true;
        }
        this.f6311i = -9223372036854775807L;
        return false;
    }

    public final void c(boolean z10) {
        long j10;
        this.f6312j = z10;
        long j11 = this.f6306c;
        if (j11 > 0) {
            this.f6314l.getClass();
            j10 = SystemClock.elapsedRealtime() + j11;
        } else {
            j10 = -9223372036854775807L;
        }
        this.f6311i = j10;
    }

    public final void d() {
        this.f6307d = true;
        this.f6314l.getClass();
        this.g = l1.a0.O(SystemClock.elapsedRealtime());
        e0 e0Var = this.f6305b;
        e0Var.f6168d = true;
        e0Var.f6176m = 0L;
        e0Var.f6179p = -1L;
        e0Var.f6177n = -1L;
        c0 c0Var = e0Var.f6166b;
        if (c0Var != null) {
            DisplayManager displayManager = c0Var.f6143a;
            d0 d0Var = e0Var.f6167c;
            d0Var.getClass();
            d0Var.f6155p.sendEmptyMessage(2);
            displayManager.registerDisplayListener(c0Var, l1.a0.n(null));
            e0.a(c0Var.f6144b, displayManager.getDisplay(0));
        }
        e0Var.d(false);
    }

    public final void e() {
        this.f6307d = false;
        this.f6311i = -9223372036854775807L;
        e0 e0Var = this.f6305b;
        e0Var.f6168d = false;
        c0 c0Var = e0Var.f6166b;
        if (c0Var != null) {
            c0Var.f6143a.unregisterDisplayListener(c0Var);
            d0 d0Var = e0Var.f6167c;
            d0Var.getClass();
            d0Var.f6155p.sendEmptyMessage(3);
        }
        e0Var.b();
    }

    public final void f(int i10) {
        if (i10 == 0) {
            this.f6308e = 1;
        } else if (i10 == 1) {
            this.f6308e = 0;
        } else {
            if (i10 != 2) {
                throw new IllegalStateException();
            }
            this.f6308e = Math.min(this.f6308e, 2);
        }
    }

    public final void g(float f10) {
        e0 e0Var = this.f6305b;
        e0Var.f6170f = f10;
        f fVar = e0Var.f6165a;
        fVar.f6181a.c();
        fVar.f6182b.c();
        fVar.f6183c = false;
        fVar.f6184d = -9223372036854775807L;
        fVar.f6185e = 0;
        e0Var.c();
    }

    public final void h(Surface surface) {
        this.f6315m = surface != null;
        this.f6316n = false;
        e0 e0Var = this.f6305b;
        if (e0Var.f6169e != surface) {
            e0Var.b();
            e0Var.f6169e = surface;
            e0Var.d(true);
        }
        this.f6308e = Math.min(this.f6308e, 1);
    }

    public final void i(float f10) {
        l1.d.b(f10 > 0.0f);
        if (f10 == this.f6313k) {
            return;
        }
        this.f6313k = f10;
        e0 e0Var = this.f6305b;
        e0Var.f6172i = f10;
        e0Var.f6176m = 0L;
        e0Var.f6179p = -1L;
        e0Var.f6177n = -1L;
        e0Var.d(false);
    }
}
