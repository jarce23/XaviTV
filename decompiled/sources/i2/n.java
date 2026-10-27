package i2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends Surface {

    /* renamed from: r, reason: collision with root package name */
    public static int f6260r;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f6261s;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f6262o;

    /* renamed from: p, reason: collision with root package name */
    public final m f6263p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6264q;

    public n(m mVar, SurfaceTexture surfaceTexture, boolean z10) {
        super(surfaceTexture);
        this.f6263p = mVar;
        this.f6262o = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0039 A[Catch: j -> 0x0045, TRY_LEAVE, TryCatch #0 {j -> 0x0045, blocks: (B:3:0x0001, B:7:0x0039, B:16:0x000d, B:18:0x0017, B:22:0x0024, B:25:0x0031), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r5) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: l1.j -> L45
            r2 = 24
            if (r1 >= r2) goto L9
        L7:
            r5 = r0
            goto L37
        L9:
            r2 = 26
            if (r1 >= r2) goto L22
            java.lang.String r3 = "samsung"
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch: l1.j -> L45
            boolean r3 = r3.equals(r4)     // Catch: l1.j -> L45
            if (r3 != 0) goto L7
            java.lang.String r3 = "XT1650"
            java.lang.String r4 = android.os.Build.MODEL     // Catch: l1.j -> L45
            boolean r3 = r3.equals(r4)     // Catch: l1.j -> L45
            if (r3 == 0) goto L22
            goto L7
        L22:
            if (r1 >= r2) goto L31
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: l1.j -> L45
            java.lang.String r1 = "android.hardware.vr.high_performance"
            boolean r5 = r5.hasSystemFeature(r1)     // Catch: l1.j -> L45
            if (r5 != 0) goto L31
            goto L7
        L31:
            java.lang.String r5 = "EGL_EXT_protected_content"
            boolean r5 = l1.b.m(r5)     // Catch: l1.j -> L45
        L37:
            if (r5 == 0) goto L47
            java.lang.String r5 = "EGL_KHR_surfaceless_context"
            boolean r5 = l1.b.m(r5)     // Catch: l1.j -> L45
            if (r5 == 0) goto L43
            r5 = 1
            return r5
        L43:
            r5 = 2
            return r5
        L45:
            r5 = move-exception
            goto L48
        L47:
            return r0
        L48:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to determine secure mode due to GL error: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "PlaceholderSurface"
            l1.b.g(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.n.a(android.content.Context):int");
    }

    public static synchronized boolean b(Context context) {
        boolean z10;
        synchronized (n.class) {
            try {
                if (!f6261s) {
                    f6260r = a(context);
                    f6261s = true;
                }
                z10 = f6260r != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f6263p) {
            try {
                if (!this.f6264q) {
                    m mVar = this.f6263p;
                    mVar.f6255p.getClass();
                    mVar.f6255p.sendEmptyMessage(2);
                    this.f6264q = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
