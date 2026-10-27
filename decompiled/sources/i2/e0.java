package i2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.Surface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final f f6165a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f6166b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f6167c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6168d;

    /* renamed from: e, reason: collision with root package name */
    public Surface f6169e;

    /* renamed from: f, reason: collision with root package name */
    public float f6170f;
    public float g;

    /* renamed from: h, reason: collision with root package name */
    public float f6171h;

    /* renamed from: i, reason: collision with root package name */
    public float f6172i;

    /* renamed from: j, reason: collision with root package name */
    public int f6173j;

    /* renamed from: k, reason: collision with root package name */
    public long f6174k;

    /* renamed from: l, reason: collision with root package name */
    public long f6175l;

    /* renamed from: m, reason: collision with root package name */
    public long f6176m;

    /* renamed from: n, reason: collision with root package name */
    public long f6177n;

    /* renamed from: o, reason: collision with root package name */
    public long f6178o;

    /* renamed from: p, reason: collision with root package name */
    public long f6179p;

    /* renamed from: q, reason: collision with root package name */
    public long f6180q;

    public e0(Context context) {
        DisplayManager displayManager;
        f fVar = new f();
        fVar.f6181a = new e();
        fVar.f6182b = new e();
        fVar.f6184d = -9223372036854775807L;
        this.f6165a = fVar;
        c0 c0Var = (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : new c0(this, displayManager);
        this.f6166b = c0Var;
        this.f6167c = c0Var != null ? d0.f6153s : null;
        this.f6174k = -9223372036854775807L;
        this.f6175l = -9223372036854775807L;
        this.f6170f = -1.0f;
        this.f6172i = 1.0f;
        this.f6173j = 0;
    }

    public static void a(e0 e0Var, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            e0Var.f6174k = refreshRate;
            e0Var.f6175l = (refreshRate * 80) / 100;
        } else {
            l1.b.q("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            e0Var.f6174k = -9223372036854775807L;
            e0Var.f6175l = -9223372036854775807L;
        }
    }

    public final void b() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.f6169e) == null || this.f6173j == Integer.MIN_VALUE || this.f6171h == 0.0f) {
            return;
        }
        this.f6171h = 0.0f;
        try {
            surface.setFrameRate(0.0f, 0);
        } catch (IllegalStateException e7) {
            l1.b.h("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L8d
            android.view.Surface r0 = r9.f6169e
            if (r0 != 0) goto Lc
            goto L8d
        Lc:
            i2.f r0 = r9.f6165a
            i2.e r2 = r0.f6181a
            boolean r2 = r2.a()
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == 0) goto L39
            i2.e r2 = r0.f6181a
            boolean r2 = r2.a()
            if (r2 == 0) goto L37
            i2.e r2 = r0.f6181a
            long r4 = r2.f6162e
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L2b
            goto L2e
        L2b:
            long r6 = r2.f6163f
            long r6 = r6 / r4
        L2e:
            double r4 = (double) r6
            r6 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r6 = r6 / r4
            float r2 = (float) r6
            goto L3b
        L37:
            r2 = r3
            goto L3b
        L39:
            float r2 = r9.f6170f
        L3b:
            float r4 = r9.g
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 != 0) goto L42
            goto L8d
        L42:
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 == 0) goto L80
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 == 0) goto L80
            i2.e r1 = r0.f6181a
            boolean r1 = r1.a()
            if (r1 == 0) goto L71
            i2.e r1 = r0.f6181a
            boolean r1 = r1.a()
            if (r1 == 0) goto L5f
            i2.e r0 = r0.f6181a
            long r0 = r0.f6163f
            goto L64
        L5f:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L64:
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L71
            r0 = 1017370378(0x3ca3d70a, float:0.02)
            goto L73
        L71:
            r0 = 1065353216(0x3f800000, float:1.0)
        L73:
            float r1 = r9.g
            float r1 = r2 - r1
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L8d
            goto L87
        L80:
            if (r5 == 0) goto L83
            goto L87
        L83:
            int r0 = r0.f6185e
            if (r0 < r1) goto L8d
        L87:
            r9.g = r2
            r0 = 0
            r9.d(r0)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.e0.c():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L41
            android.view.Surface r0 = r4.f6169e
            if (r0 == 0) goto L41
            int r1 = r4.f6173j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L41
        L11:
            boolean r1 = r4.f6168d
            r2 = 0
            if (r1 == 0) goto L22
            float r1 = r4.g
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L22
            float r3 = r4.f6172i
            float r1 = r1 * r3
            goto L23
        L22:
            r1 = r2
        L23:
            if (r5 != 0) goto L2c
            float r5 = r4.f6171h
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2c
            goto L41
        L2c:
            r4.f6171h = r1
            int r5 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r5 != 0) goto L34
            r5 = 0
            goto L35
        L34:
            r5 = 1
        L35:
            i2.b0.n(r0, r1, r5)     // Catch: java.lang.IllegalStateException -> L39
            return
        L39:
            r5 = move-exception
            java.lang.String r0 = "VideoFrameReleaseHelper"
            java.lang.String r1 = "Failed to call Surface.setFrameRate"
            l1.b.h(r0, r1, r5)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.e0.d(boolean):void");
    }
}
