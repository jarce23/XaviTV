package i2;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.fragment.app.v0;
import i1.f1;
import i1.r0;
import i1.t0;
import j9.g1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import o9.w0;
import okhttp3.internal.ws.WebSocketProtocol;
import s1.d1;
import s1.e1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends z1.s {
    public static final int[] K1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean L1;
    public static boolean M1;
    public f1 A1;
    public int B1;
    public boolean C1;
    public int D1;
    public k E1;
    public y F1;
    public long G1;
    public long H1;
    public boolean I1;
    public int J1;
    public final Context U0;
    public final boolean V0;
    public final k0 W0;
    public final int X0;
    public final boolean Y0;
    public final z Z0;

    /* renamed from: a1, reason: collision with root package name */
    public final e3.a f6228a1;

    /* renamed from: b1, reason: collision with root package name */
    public final long f6229b1;

    /* renamed from: c1, reason: collision with root package name */
    public final PriorityQueue f6230c1;

    /* renamed from: d1, reason: collision with root package name */
    public j f6231d1;

    /* renamed from: e1, reason: collision with root package name */
    public boolean f6232e1;

    /* renamed from: f1, reason: collision with root package name */
    public boolean f6233f1;

    /* renamed from: g1, reason: collision with root package name */
    public n0 f6234g1;
    public boolean h1;

    /* renamed from: i1, reason: collision with root package name */
    public int f6235i1;

    /* renamed from: j1, reason: collision with root package name */
    public List f6236j1;

    /* renamed from: k1, reason: collision with root package name */
    public Surface f6237k1;

    /* renamed from: l1, reason: collision with root package name */
    public n f6238l1;

    /* renamed from: m1, reason: collision with root package name */
    public l1.u f6239m1;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f6240n1;

    /* renamed from: o1, reason: collision with root package name */
    public int f6241o1;

    /* renamed from: p1, reason: collision with root package name */
    public int f6242p1;

    /* renamed from: q1, reason: collision with root package name */
    public long f6243q1;

    /* renamed from: r1, reason: collision with root package name */
    public int f6244r1;

    /* renamed from: s1, reason: collision with root package name */
    public int f6245s1;

    /* renamed from: t1, reason: collision with root package name */
    public int f6246t1;

    /* renamed from: u1, reason: collision with root package name */
    public e1 f6247u1;

    /* renamed from: v1, reason: collision with root package name */
    public boolean f6248v1;

    /* renamed from: w1, reason: collision with root package name */
    public long f6249w1;

    /* renamed from: x1, reason: collision with root package name */
    public int f6250x1;

    /* renamed from: y1, reason: collision with root package name */
    public long f6251y1;

    /* renamed from: z1, reason: collision with root package name */
    public f1 f6252z1;

    public l(i iVar) {
        super(2, iVar.f6209c, 30.0f);
        Context applicationContext = iVar.f6207a.getApplicationContext();
        this.U0 = applicationContext;
        this.X0 = iVar.g;
        this.f6234g1 = null;
        this.W0 = new k0(iVar.f6211e, iVar.f6212f, 0);
        this.V0 = this.f6234g1 == null;
        this.Z0 = new z(applicationContext, this, iVar.f6210d);
        this.f6228a1 = new e3.a();
        this.Y0 = "NVIDIA".equals(Build.MANUFACTURER);
        this.f6239m1 = l1.u.f8132c;
        this.f6241o1 = 1;
        this.f6242p1 = 0;
        this.f6252z1 = f1.f5878d;
        this.D1 = 0;
        this.A1 = null;
        this.B1 = -1000;
        this.G1 = -9223372036854775807L;
        this.H1 = -9223372036854775807L;
        this.f6230c1 = new PriorityQueue();
        this.f6229b1 = -9223372036854775807L;
        this.f6247u1 = null;
    }

    public static int A0(z1.p pVar, i1.p pVar2) {
        int i10 = pVar2.f5992o;
        List list = pVar2.f5994q;
        if (i10 == -1) {
            return y0(pVar, pVar2);
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += ((byte[]) list.get(i12)).length;
        }
        return pVar2.f5992o + i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0736, code lost:
    
        if (r0.equals("ELUGA_Ray_X") == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x08b7, code lost:
    
        if (r13.equals("JSN-L21") == false) goto L664;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean x0(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 3206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.l.x0(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0084, code lost:
    
        if (r3.equals("video/av01") == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int y0(z1.p r11, i1.p r12) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.l.y0(z1.p, i1.p):int");
    }

    public static List z0(Context context, z1.j jVar, i1.p pVar, boolean z10, boolean z11) {
        String str = pVar.f5991n;
        if (str == null) {
            return w0.f9686s;
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !x4.f.v(context)) {
            String b2 = z1.x.b(pVar);
            List a10 = b2 == null ? w0.f9686s : jVar.a(b2, z10, z11);
            if (!a10.isEmpty()) {
                return a10;
            }
        }
        return z1.x.f(jVar, pVar, z10, z11);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.Surface B0(z1.p r6) {
        /*
            r5 = this;
            i2.n0 r0 = r5.f6234g1
            if (r0 == 0) goto L9
            android.view.Surface r6 = r0.d()
            return r6
        L9:
            android.view.Surface r0 = r5.f6237k1
            if (r0 == 0) goto Le
            return r0
        Le:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 35
            r2 = 0
            if (r0 < r1) goto L1a
            boolean r0 = r6.f14006h
            if (r0 == 0) goto L1a
            return r2
        L1a:
            boolean r0 = r5.K0(r6)
            l1.d.g(r0)
            i2.n r0 = r5.f6238l1
            if (r0 == 0) goto L32
            boolean r1 = r0.f6262o
            boolean r3 = r6.f14005f
            if (r1 == r3) goto L32
            if (r0 == 0) goto L32
            r0.release()
            r5.f6238l1 = r2
        L32:
            i2.n r0 = r5.f6238l1
            if (r0 != 0) goto Lab
            android.content.Context r0 = r5.U0
            boolean r6 = r6.f14005f
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L47
            boolean r0 = i2.n.b(r0)
            if (r0 == 0) goto L45
            goto L49
        L45:
            r0 = r2
            goto L4a
        L47:
            int r0 = i2.n.f6260r
        L49:
            r0 = r1
        L4a:
            l1.d.g(r0)
            i2.m r0 = new i2.m
            java.lang.String r3 = "ExoPlayer:PlaceholderSurface"
            r0.<init>(r3)
            if (r6 == 0) goto L59
            int r6 = i2.n.f6260r
            goto L5a
        L59:
            r6 = r2
        L5a:
            r0.start()
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r4 = r0.getLooper()
            r3.<init>(r4, r0)
            r0.f6255p = r3
            l1.i r4 = new l1.i
            r4.<init>(r3)
            r0.f6254o = r4
            monitor-enter(r0)
            android.os.Handler r3 = r0.f6255p     // Catch: java.lang.Throwable -> L89
            android.os.Message r6 = r3.obtainMessage(r1, r6, r2)     // Catch: java.lang.Throwable -> L89
            r6.sendToTarget()     // Catch: java.lang.Throwable -> L89
        L79:
            i2.n r6 = r0.f6258s     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            java.lang.RuntimeException r6 = r0.f6257r     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            java.lang.Error r6 = r0.f6256q     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            r0.wait()     // Catch: java.lang.Throwable -> L89 java.lang.InterruptedException -> L8b
            goto L79
        L89:
            r6 = move-exception
            goto La9
        L8b:
            r2 = r1
            goto L79
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            if (r2 == 0) goto L97
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r6.interrupt()
        L97:
            java.lang.RuntimeException r6 = r0.f6257r
            if (r6 != 0) goto La8
            java.lang.Error r6 = r0.f6256q
            if (r6 != 0) goto La7
            i2.n r6 = r0.f6258s
            r6.getClass()
            r5.f6238l1 = r6
            goto Lab
        La7:
            throw r6
        La8:
            throw r6
        La9:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            throw r6
        Lab:
            i2.n r6 = r5.f6238l1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.l.B0(z1.p):android.view.Surface");
    }

    @Override // z1.s
    public final s1.f C(z1.p pVar, i1.p pVar2, i1.p pVar3) {
        s1.f b2 = pVar.b(pVar2, pVar3);
        int i10 = b2.f11285e;
        j jVar = this.f6231d1;
        jVar.getClass();
        if (pVar3.f5998u > jVar.f6217a || pVar3.f5999v > jVar.f6218b) {
            i10 |= 256;
        }
        if (A0(pVar, pVar3) > jVar.f6219c) {
            i10 |= 64;
        }
        int i11 = i10;
        return new s1.f(pVar.f14000a, pVar2, pVar3, i11 != 0 ? 0 : b2.f11284d, i11);
    }

    public final boolean C0(z1.p pVar) {
        if (this.f6234g1 != null) {
            return true;
        }
        Surface surface = this.f6237k1;
        if (surface == null || !surface.isValid()) {
            return (Build.VERSION.SDK_INT >= 35 && pVar.f14006h) || K0(pVar);
        }
        return true;
    }

    @Override // z1.s
    public final z1.o D(IllegalStateException illegalStateException, z1.p pVar) {
        Surface surface = this.f6237k1;
        g gVar = new g(illegalStateException, pVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
        return gVar;
    }

    public final boolean D0(r1.e eVar) {
        if (k() || eVar.d(536870912)) {
            return true;
        }
        long j10 = this.H1;
        return j10 == -9223372036854775807L || j10 - (eVar.f10412u - this.M0.f14018c) <= 100000;
    }

    public final void E0() {
        if (this.f6244r1 > 0) {
            this.f11254u.getClass();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = elapsedRealtime - this.f6243q1;
            int i10 = this.f6244r1;
            k0 k0Var = this.W0;
            Handler handler = k0Var.f6226b;
            if (handler != null) {
                handler.post(new i0(k0Var, i10, j10));
            }
            this.f6244r1 = 0;
            this.f6243q1 = elapsedRealtime;
        }
    }

    public final void F0() {
        if (this.C1) {
            int i10 = Build.VERSION.SDK_INT;
            z1.m mVar = this.Z;
            if (mVar == null) {
                return;
            }
            this.E1 = new k(this, mVar);
            if (i10 >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                mVar.d(bundle);
            }
        }
    }

    public final void G0(long j10) {
        Surface surface;
        w0(j10);
        f1 f1Var = this.f6252z1;
        boolean equals = f1Var.equals(f1.f5878d);
        k0 k0Var = this.W0;
        if (!equals && !f1Var.equals(this.A1)) {
            this.A1 = f1Var;
            k0Var.c(f1Var);
        }
        this.L0.f11268e++;
        z zVar = this.Z0;
        boolean z10 = zVar.f6308e != 3;
        zVar.f6308e = 3;
        zVar.f6314l.getClass();
        zVar.g = l1.a0.O(SystemClock.elapsedRealtime());
        if (z10 && (surface = this.f6237k1) != null) {
            Handler handler = k0Var.f6226b;
            if (handler != null) {
                handler.post(new h0(k0Var, surface, SystemClock.elapsedRealtime()));
            }
            this.f6240n1 = true;
        }
        b0(j10);
    }

    public final void H0(z1.m mVar, int i10, long j10) {
        Surface surface;
        Trace.beginSection("releaseOutputBuffer");
        mVar.w(i10, j10);
        Trace.endSection();
        this.L0.f11268e++;
        this.f6245s1 = 0;
        if (this.f6234g1 == null) {
            f1 f1Var = this.f6252z1;
            boolean equals = f1Var.equals(f1.f5878d);
            k0 k0Var = this.W0;
            if (!equals && !f1Var.equals(this.A1)) {
                this.A1 = f1Var;
                k0Var.c(f1Var);
            }
            z zVar = this.Z0;
            boolean z10 = zVar.f6308e != 3;
            zVar.f6308e = 3;
            zVar.f6314l.getClass();
            zVar.g = l1.a0.O(SystemClock.elapsedRealtime());
            if (!z10 || (surface = this.f6237k1) == null) {
                return;
            }
            Handler handler = k0Var.f6226b;
            if (handler != null) {
                handler.post(new h0(k0Var, surface, SystemClock.elapsedRealtime()));
            }
            this.f6240n1 = true;
        }
    }

    public final void I0(Object obj) {
        Handler handler;
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        Surface surface2 = this.f6237k1;
        k0 k0Var = this.W0;
        if (surface2 == surface) {
            if (surface != null) {
                f1 f1Var = this.A1;
                if (f1Var != null) {
                    k0Var.c(f1Var);
                }
                Surface surface3 = this.f6237k1;
                if (surface3 == null || !this.f6240n1 || (handler = k0Var.f6226b) == null) {
                    return;
                }
                handler.post(new h0(k0Var, surface3, SystemClock.elapsedRealtime()));
                return;
            }
            return;
        }
        this.f6237k1 = surface;
        n0 n0Var = this.f6234g1;
        z zVar = this.Z0;
        if (n0Var == null) {
            zVar.h(surface);
        }
        this.f6240n1 = false;
        int i10 = this.f11255v;
        z1.m mVar = this.Z;
        if (mVar != null && this.f6234g1 == null) {
            z1.p pVar = this.f14026g0;
            pVar.getClass();
            boolean C0 = C0(pVar);
            int i11 = Build.VERSION.SDK_INT;
            if (!C0 || this.f6232e1) {
                h0();
                S();
            } else {
                Surface B0 = B0(pVar);
                if (B0 != null) {
                    mVar.s(B0);
                } else {
                    if (i11 < 35) {
                        throw new IllegalStateException();
                    }
                    mVar.q();
                }
            }
        }
        if (surface != null) {
            f1 f1Var2 = this.A1;
            if (f1Var2 != null) {
                k0Var.c(f1Var2);
            }
        } else {
            this.A1 = null;
            n0 n0Var2 = this.f6234g1;
            if (n0Var2 != null) {
                n0Var2.c();
            }
        }
        if (i10 == 2) {
            n0 n0Var3 = this.f6234g1;
            if (n0Var3 != null) {
                n0Var3.n(true);
            } else {
                zVar.c(true);
            }
        }
        F0();
    }

    public final boolean J0(long j10, long j11, boolean z10, boolean z11) {
        if (this.f6234g1 != null && this.V0) {
            j11 -= -this.G1;
        }
        if (j10 < -500000 && !z10) {
            c2.e1 e1Var = this.f11256w;
            e1Var.getClass();
            int t3 = e1Var.t(j11 - this.f11258y);
            if (t3 != 0) {
                PriorityQueue priorityQueue = this.f6230c1;
                if (z11) {
                    s1.e eVar = this.L0;
                    int i10 = eVar.f11267d + t3;
                    eVar.f11267d = i10;
                    eVar.f11269f += this.f6246t1;
                    eVar.f11267d = priorityQueue.size() + i10;
                } else {
                    this.L0.f11272j++;
                    M0(priorityQueue.size() + t3, this.f6246t1);
                }
                if (I()) {
                    S();
                }
                n0 n0Var = this.f6234g1;
                if (n0Var != null) {
                    n0Var.h(false);
                }
                return true;
            }
        }
        return false;
    }

    @Override // z1.s
    public final int K(r1.e eVar) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((this.f6247u1 == null && !this.C1) || eVar.f10412u >= this.f11259z || D0(eVar)) ? 0 : 32;
        }
        return 0;
    }

    public final boolean K0(z1.p pVar) {
        if (this.C1 || x0(pVar.f14000a)) {
            return false;
        }
        return !pVar.f14005f || n.b(this.U0);
    }

    @Override // z1.s
    public final float L(float f10, i1.p pVar, i1.p[] pVarArr) {
        z1.p pVar2;
        float f11 = -1.0f;
        for (i1.p pVar3 : pVarArr) {
            float f12 = pVar3.f6002y;
            if (f12 != -1.0f) {
                f11 = Math.max(f11, f12);
            }
        }
        float f13 = f11 == -1.0f ? -1.0f : f11 * f10;
        if (this.f6247u1 == null || (pVar2 = this.f14026g0) == null) {
            return f13;
        }
        int i10 = pVar.f5998u;
        int i11 = pVar.f5999v;
        float f14 = -3.4028235E38f;
        if (pVar2.f14007i) {
            float f15 = pVar2.f14010l;
            if (f15 != -3.4028235E38f && pVar2.f14008j == i10 && pVar2.f14009k == i11) {
                f14 = f15;
            } else {
                float f16 = 1024.0f;
                if (!pVar2.g(i10, i11, 1024.0f)) {
                    f14 = 0.0f;
                    while (true) {
                        float f17 = f16 - f14;
                        if (Math.abs(f17) <= 5.0f) {
                            break;
                        }
                        float f18 = (f17 / 2.0f) + f14;
                        if (pVar2.g(i10, i11, f18)) {
                            f14 = f18;
                        } else {
                            f16 = f18;
                        }
                    }
                } else {
                    f14 = 1024.0f;
                }
                pVar2.f14010l = f14;
                pVar2.f14008j = i10;
                pVar2.f14009k = i11;
            }
        }
        return f13 != -1.0f ? Math.max(f13, f14) : f14;
    }

    public final void L0(z1.m mVar, int i10) {
        Trace.beginSection("skipVideoBuffer");
        mVar.h(i10);
        Trace.endSection();
        this.L0.f11269f++;
    }

    @Override // z1.s
    public final ArrayList M(z1.j jVar, i1.p pVar, boolean z10) {
        List z02 = z0(this.U0, jVar, pVar, z10, this.C1);
        HashMap hashMap = z1.x.f14048a;
        ArrayList arrayList = new ArrayList(z02);
        Collections.sort(arrayList, new p8.d(1, new v0(28, pVar)));
        return arrayList;
    }

    public final void M0(int i10, int i11) {
        s1.e eVar = this.L0;
        eVar.f11270h += i10;
        int i12 = i10 + i11;
        eVar.g += i12;
        this.f6244r1 += i12;
        int i13 = this.f6245s1 + i12;
        this.f6245s1 = i13;
        eVar.f11271i = Math.max(i13, eVar.f11271i);
        int i14 = this.X0;
        if (i14 <= 0 || this.f6244r1 < i14) {
            return;
        }
        E0();
    }

    public final void N0(long j10) {
        s1.e eVar = this.L0;
        eVar.f11273k += j10;
        eVar.f11274l++;
        this.f6249w1 += j10;
        this.f6250x1++;
    }

    @Override // z1.s
    public final g1 O(z1.p pVar, i1.p pVar2, MediaCrypto mediaCrypto, float f10) {
        i1.g gVar;
        int i10;
        j jVar;
        Point point;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i11;
        int i12;
        char c10;
        boolean z10;
        int y02;
        String str = pVar.f14002c;
        i1.p[] pVarArr = this.f11257x;
        pVarArr.getClass();
        int i13 = pVar2.f5998u;
        float f11 = pVar2.f6002y;
        i1.g gVar2 = pVar2.D;
        int i14 = pVar2.f5999v;
        int A0 = A0(pVar, pVar2);
        if (pVarArr.length == 1) {
            if (A0 != -1 && (y02 = y0(pVar, pVar2)) != -1) {
                A0 = Math.min((int) (A0 * 1.5f), y02);
            }
            jVar = new j(i13, i14, A0);
            gVar = gVar2;
            i10 = i14;
        } else {
            int length = pVarArr.length;
            int i15 = i13;
            int i16 = i14;
            int i17 = 0;
            boolean z11 = false;
            while (i17 < length) {
                i1.p pVar3 = pVarArr[i17];
                i1.p[] pVarArr2 = pVarArr;
                if (gVar2 != null && pVar3.D == null) {
                    i1.o a10 = pVar3.a();
                    a10.C = gVar2;
                    pVar3 = new i1.p(a10);
                }
                s1.f b2 = pVar.b(pVar2, pVar3);
                int i18 = length;
                int i19 = pVar3.f5999v;
                if (b2.f11284d != 0) {
                    int i20 = pVar3.f5998u;
                    i12 = i17;
                    c10 = 65535;
                    z11 |= i20 == -1 || i19 == -1;
                    i15 = Math.max(i15, i20);
                    i16 = Math.max(i16, i19);
                    A0 = Math.max(A0, A0(pVar, pVar3));
                } else {
                    i12 = i17;
                    c10 = 65535;
                }
                length = i18;
                i17 = i12 + 1;
                pVarArr = pVarArr2;
            }
            if (z11) {
                l1.b.q("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i15 + "x" + i16);
                boolean z12 = i14 > i13;
                int i21 = z12 ? i14 : i13;
                boolean z13 = z12;
                int i22 = z12 ? i13 : i14;
                float f12 = i22 / i21;
                int i23 = 0;
                while (true) {
                    gVar = gVar2;
                    if (i23 >= 9) {
                        break;
                    }
                    int i24 = K1[i23];
                    int i25 = i23;
                    int i26 = (int) (i24 * f12);
                    if (i24 <= i21 || i26 <= i22) {
                        break;
                    }
                    if (!z13) {
                        i26 = i24;
                    }
                    if (!z13) {
                        i24 = i26;
                    }
                    int i27 = i22;
                    MediaCodecInfo.CodecCapabilities codecCapabilities = pVar.f14003d;
                    if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                        i11 = i21;
                        point = null;
                    } else {
                        int widthAlignment = videoCapabilities.getWidthAlignment();
                        i11 = i21;
                        int heightAlignment = videoCapabilities.getHeightAlignment();
                        point = new Point(l1.a0.f(i26, widthAlignment) * widthAlignment, l1.a0.f(i24, heightAlignment) * heightAlignment);
                    }
                    if (point != null) {
                        i10 = i14;
                        if (pVar.g(point.x, point.y, f11)) {
                            break;
                        }
                    } else {
                        i10 = i14;
                    }
                    i23 = i25 + 1;
                    i14 = i10;
                    gVar2 = gVar;
                    i22 = i27;
                    i21 = i11;
                }
                i10 = i14;
                point = null;
                if (point != null) {
                    i15 = Math.max(i15, point.x);
                    i16 = Math.max(i16, point.y);
                    i1.o a11 = pVar2.a();
                    a11.f5947t = i15;
                    a11.f5948u = i16;
                    A0 = Math.max(A0, y0(pVar, new i1.p(a11)));
                    l1.b.q("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i15 + "x" + i16);
                }
            } else {
                gVar = gVar2;
                i10 = i14;
            }
            jVar = new j(i15, i16, A0);
        }
        this.f6231d1 = jVar;
        int i28 = this.C1 ? this.D1 : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", i13);
        mediaFormat.setInteger("height", i10);
        l1.d.o(mediaFormat, pVar2.f5994q);
        if (f11 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f11);
        }
        l1.d.n(mediaFormat, "rotation-degrees", pVar2.f6003z);
        if (gVar != null) {
            i1.g gVar3 = gVar;
            l1.d.n(mediaFormat, "color-transfer", gVar3.f5891c);
            l1.d.n(mediaFormat, "color-standard", gVar3.f5889a);
            l1.d.n(mediaFormat, "color-range", gVar3.f5890b);
            byte[] bArr = gVar3.f5892d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(pVar2.f5991n)) {
            HashMap hashMap = z1.x.f14048a;
            Pair b10 = l1.e.b(pVar2);
            if (b10 != null) {
                l1.d.n(mediaFormat, "profile", ((Integer) b10.first).intValue());
            }
        }
        mediaFormat.setInteger("max-width", jVar.f6217a);
        mediaFormat.setInteger("max-height", jVar.f6218b);
        l1.d.n(mediaFormat, "max-input-size", jVar.f6219c);
        int i29 = Build.VERSION.SDK_INT;
        mediaFormat.setInteger("priority", 0);
        if (f10 != -1.0f) {
            mediaFormat.setFloat("operating-rate", f10);
        }
        if (this.Y0) {
            z10 = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z10 = true;
        }
        if (i28 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z10);
            mediaFormat.setInteger("audio-session-id", i28);
        }
        if (i29 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.B1));
        }
        Surface B0 = B0(pVar);
        if (this.f6234g1 != null && !l1.a0.L(this.U0)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return new g1(pVar, mediaFormat, pVar2, B0, mediaCrypto, null);
    }

    @Override // z1.s
    public final void P(r1.e eVar) {
        if (this.f6233f1) {
            ByteBuffer byteBuffer = eVar.f10413v;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b10 = byteBuffer.get();
                byte b11 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s10 == 60 && s11 == 1 && b10 == 4) {
                    if (b11 == 0 || b11 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        z1.m mVar = this.Z;
                        mVar.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        mVar.d(bundle);
                    }
                }
            }
        }
    }

    @Override // z1.s
    public final boolean U(i1.p pVar) {
        n0 n0Var = this.f6234g1;
        if (n0Var == null || n0Var.v()) {
            return true;
        }
        try {
            return this.f6234g1.q(pVar);
        } catch (m0 e7) {
            throw f(e7, pVar, false, 7000);
        }
    }

    @Override // z1.s
    public final void V(Exception exc) {
        l1.b.h("MediaCodecVideoRenderer", "Video codec error", exc);
        k0 k0Var = this.W0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new androidx.fragment.app.d(k0Var, 8, exc));
        }
    }

    @Override // z1.s
    public final void W(long j10, long j11, String str) {
        String str2;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        k0 k0Var = this.W0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            str2 = str;
            handler.post(new g0(k0Var, str2, j10, j11, 0));
        } else {
            str2 = str;
        }
        this.f6232e1 = x0(str2);
        z1.p pVar = this.f14026g0;
        pVar.getClass();
        boolean z10 = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(pVar.f14001b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = pVar.f14003d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            int length = codecProfileLevelArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (codecProfileLevelArr[i10].profile == 16384) {
                    z10 = true;
                    break;
                }
                i10++;
            }
        }
        this.f6233f1 = z10;
        F0();
    }

    @Override // z1.s
    public final void X(String str) {
        k0 k0Var = this.W0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new androidx.fragment.app.d(k0Var, 9, str));
        }
    }

    @Override // z1.s
    public final s1.f Y(x4.e eVar) {
        s1.f Y = super.Y(eVar);
        i1.p pVar = (i1.p) eVar.f13543q;
        pVar.getClass();
        k0 k0Var = this.W0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new androidx.emoji2.text.m(k0Var, pVar, Y, 2));
        }
        return Y;
    }

    @Override // z1.s
    public final void Z(i1.p pVar, MediaFormat mediaFormat) {
        int integer;
        int i10;
        z1.m mVar = this.Z;
        if (mVar != null) {
            mVar.m(this.f6241o1);
        }
        if (this.C1) {
            i10 = pVar.f5998u;
            integer = pVar.f5999v;
        } else {
            mediaFormat.getClass();
            boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z10 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z10 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i10 = integer2;
        }
        float f10 = pVar.A;
        int i11 = pVar.f6003z;
        if (i11 == 90 || i11 == 270) {
            f10 = 1.0f / f10;
            int i12 = integer;
            integer = i10;
            i10 = i12;
        }
        this.f6252z1 = new f1(f10, i10, integer);
        n0 n0Var = this.f6234g1;
        if (n0Var == null || !this.I1) {
            this.Z0.g(pVar.f6002y);
        } else {
            i1.o a10 = pVar.a();
            a10.f5947t = i10;
            a10.f5948u = integer;
            a10.f5953z = f10;
            i1.p pVar2 = new i1.p(a10);
            int i13 = this.f6235i1;
            List list = this.f6236j1;
            if (list == null) {
                o9.e0 e0Var = o9.g0.f9617p;
                list = w0.f9686s;
            }
            n0Var.f(pVar2, this.M0.f14017b, i13, list);
            this.f6235i1 = 2;
        }
        this.I1 = false;
    }

    @Override // z1.s
    public final void b0(long j10) {
        super.b0(j10);
        if (this.C1) {
            return;
        }
        this.f6246t1--;
    }

    @Override // s1.d, s1.a1
    public final void c(int i10, Object obj) {
        if (i10 == 1) {
            I0(obj);
            return;
        }
        if (i10 == 7) {
            obj.getClass();
            y yVar = (y) obj;
            this.F1 = yVar;
            n0 n0Var = this.f6234g1;
            if (n0Var != null) {
                n0Var.l(yVar);
                return;
            }
            return;
        }
        if (i10 == 10) {
            obj.getClass();
            int intValue = ((Integer) obj).intValue();
            if (this.D1 != intValue) {
                this.D1 = intValue;
                if (this.C1) {
                    h0();
                    return;
                }
                return;
            }
            return;
        }
        if (i10 == 4) {
            obj.getClass();
            int intValue2 = ((Integer) obj).intValue();
            this.f6241o1 = intValue2;
            z1.m mVar = this.Z;
            if (mVar != null) {
                mVar.m(intValue2);
                return;
            }
            return;
        }
        if (i10 == 5) {
            obj.getClass();
            int intValue3 = ((Integer) obj).intValue();
            this.f6242p1 = intValue3;
            n0 n0Var2 = this.f6234g1;
            if (n0Var2 != null) {
                n0Var2.x(intValue3);
                return;
            }
            e0 e0Var = this.Z0.f6305b;
            if (e0Var.f6173j == intValue3) {
                return;
            }
            e0Var.f6173j = intValue3;
            e0Var.d(true);
            return;
        }
        if (i10 == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(i1.e1.f5870a)) {
                n0 n0Var3 = this.f6234g1;
                if (n0Var3 == null || !n0Var3.v()) {
                    return;
                }
                this.f6234g1.r();
                return;
            }
            this.f6236j1 = list;
            n0 n0Var4 = this.f6234g1;
            if (n0Var4 != null) {
                n0Var4.i(list);
                return;
            }
            return;
        }
        if (i10 == 14) {
            obj.getClass();
            l1.u uVar = (l1.u) obj;
            if (uVar.f8133a == 0 || uVar.f8134b == 0) {
                return;
            }
            this.f6239m1 = uVar;
            n0 n0Var5 = this.f6234g1;
            if (n0Var5 != null) {
                Surface surface = this.f6237k1;
                l1.d.h(surface);
                n0Var5.t(surface, uVar);
                return;
            }
            return;
        }
        switch (i10) {
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                obj.getClass();
                this.B1 = ((Integer) obj).intValue();
                z1.m mVar2 = this.Z;
                if (mVar2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.B1));
                    mVar2.d(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.f6237k1;
                I0(null);
                obj.getClass();
                ((l) obj).c(1, surface2);
                break;
            case 18:
                boolean z10 = this.f6247u1 != null;
                e1 e1Var = (e1) obj;
                this.f6247u1 = e1Var;
                if (z10 != (e1Var != null)) {
                    u0(this.f14020a0);
                    break;
                }
                break;
            default:
                if (i10 == 11) {
                    s1.d0 d0Var = (s1.d0) obj;
                    d0Var.getClass();
                    this.U = d0Var;
                    break;
                }
                break;
        }
    }

    @Override // z1.s
    public final void c0() {
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            n0Var.u();
            if (this.G1 == -9223372036854775807L) {
                this.G1 = this.M0.f14017b;
            }
            this.f6234g1.s(-this.G1);
        } else {
            this.Z0.f(2);
        }
        this.I1 = true;
        F0();
    }

    @Override // z1.s
    public final void d0(r1.e eVar) {
        this.J1 = 0;
        int K = K(eVar);
        if ((Build.VERSION.SDK_INT < 34 || (K & 32) == 0) && !this.C1) {
            this.f6246t1++;
        }
    }

    @Override // z1.s
    public final boolean f0(long j10, long j11, z1.m mVar, ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, i1.p pVar) {
        int i13;
        mVar.getClass();
        long j13 = j12 - this.M0.f14018c;
        int i14 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.f6230c1;
            Long l10 = (Long) priorityQueue.peek();
            if (l10 == null || l10.longValue() >= j12) {
                break;
            }
            i14++;
            priorityQueue.poll();
        }
        M0(i14, 0);
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            if (!z10 || z11) {
                return n0Var.k(j12, new h(this, mVar, i10, j13));
            }
            L0(mVar, i10);
            return true;
        }
        int a10 = this.Z0.a(j12, j10, j11, this.M0.f14017b, z10, z11, this.f6228a1);
        e3.a aVar = this.f6228a1;
        if (a10 == 0) {
            this.f11254u.getClass();
            long nanoTime = System.nanoTime();
            y yVar = this.F1;
            if (yVar != null) {
                yVar.d(j13, nanoTime, pVar, this.f14021b0);
            }
            H0(mVar, i10, nanoTime);
            N0(aVar.f4415a);
            return true;
        }
        if (a10 == 1) {
            long j14 = aVar.f4416b;
            long j15 = aVar.f4415a;
            if (j14 == this.f6251y1) {
                L0(mVar, i10);
            } else {
                y yVar2 = this.F1;
                if (yVar2 != null) {
                    i13 = i10;
                    yVar2.d(j13, j14, pVar, this.f14021b0);
                } else {
                    i13 = i10;
                }
                H0(mVar, i13, j14);
            }
            N0(j15);
            this.f6251y1 = j14;
            return true;
        }
        if (a10 == 2) {
            Trace.beginSection("dropVideoBuffer");
            mVar.h(i10);
            Trace.endSection();
            M0(0, 1);
            N0(aVar.f4415a);
            return true;
        }
        if (a10 == 3) {
            L0(mVar, i10);
            N0(aVar.f4415a);
            return true;
        }
        if (a10 == 4 || a10 == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(a10));
    }

    @Override // s1.d
    public final void g() {
        n0 n0Var = this.f6234g1;
        if (n0Var == null) {
            z zVar = this.Z0;
            if (zVar.f6308e == 0) {
                zVar.f6308e = 1;
                return;
            }
            return;
        }
        int i10 = this.f6235i1;
        if (i10 == 0 || i10 == 1) {
            this.f6235i1 = 0;
        } else {
            n0Var.w();
        }
    }

    @Override // z1.s
    public final void i0() {
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            n0Var.u();
        }
    }

    @Override // s1.d
    public final String j() {
        return "MediaCodecVideoRenderer";
    }

    @Override // z1.s
    public final void k0() {
        super.k0();
        this.f6230c1.clear();
        this.f6246t1 = 0;
        this.J1 = 0;
        this.f6248v1 = false;
    }

    @Override // s1.d
    public final boolean l() {
        if (!this.H0) {
            return false;
        }
        n0 n0Var = this.f6234g1;
        return n0Var == null || n0Var.b();
    }

    @Override // z1.s, s1.d
    public final boolean m() {
        boolean m10 = super.m();
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            return n0Var.o(m10);
        }
        if (m10 && (this.Z == null || this.C1)) {
            return true;
        }
        return this.Z0.b(m10);
    }

    @Override // z1.s, s1.d
    public final void n() {
        k0 k0Var = this.W0;
        this.A1 = null;
        this.H1 = -9223372036854775807L;
        F0();
        this.f6240n1 = false;
        this.E1 = null;
        this.f6248v1 = true;
        try {
            super.n();
            s1.e eVar = this.L0;
            k0Var.getClass();
            synchronized (eVar) {
            }
            Handler handler = k0Var.f6226b;
            if (handler != null) {
                handler.post(new j0(k0Var, eVar, 1));
            }
            k0Var.c(f1.f5878d);
        } catch (Throwable th) {
            k0Var.a(this.L0);
            k0Var.c(f1.f5878d);
            throw th;
        }
    }

    @Override // s1.d
    public final void o(boolean z10, boolean z11) {
        n0 n0Var;
        this.L0 = new s1.e();
        d1 d1Var = this.f11251r;
        d1Var.getClass();
        boolean z12 = d1Var.f11263b;
        l1.d.g((z12 && this.D1 == 0) ? false : true);
        if (this.C1 != z12) {
            this.C1 = z12;
            h0();
        }
        s1.e eVar = this.L0;
        k0 k0Var = this.W0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new j0(k0Var, eVar, 0));
        }
        boolean z13 = this.h1;
        z zVar = this.Z0;
        if (!z13) {
            if (this.f6236j1 != null && this.f6234g1 == null) {
                o oVar = new o(this.U0, zVar);
                oVar.f6265o = true;
                l1.v vVar = this.f11254u;
                vVar.getClass();
                oVar.f6270t = vVar;
                l1.d.g(!oVar.f6266p);
                if (((s) oVar.f6269s) == null) {
                    oVar.f6269s = new s();
                }
                u uVar = new u(oVar);
                oVar.f6266p = true;
                uVar.f6292n = 1;
                SparseArray sparseArray = uVar.f6282c;
                if (l1.a0.k(sparseArray, 0)) {
                    n0Var = (n0) sparseArray.get(0);
                } else {
                    p pVar = new p(uVar, uVar.f6280a);
                    uVar.g.add(pVar);
                    sparseArray.put(0, pVar);
                    n0Var = pVar;
                }
                this.f6234g1 = n0Var;
            }
            this.h1 = true;
        }
        n0 n0Var2 = this.f6234g1;
        if (n0Var2 == null) {
            l1.v vVar2 = this.f11254u;
            vVar2.getClass();
            zVar.f6314l = vVar2;
            zVar.f(!z11 ? 1 : 0);
            return;
        }
        n0Var2.g(new h5.i(4, this));
        y yVar = this.F1;
        if (yVar != null) {
            this.f6234g1.l(yVar);
        }
        if (this.f6237k1 != null && !this.f6239m1.equals(l1.u.f8132c)) {
            this.f6234g1.t(this.f6237k1, this.f6239m1);
        }
        this.f6234g1.x(this.f6242p1);
        this.f6234g1.e(this.X);
        List list = this.f6236j1;
        if (list != null) {
            this.f6234g1.i(list);
        }
        this.f6235i1 = !z11 ? 1 : 0;
        this.P0 = true;
    }

    @Override // z1.s
    public final boolean o0(r1.e eVar) {
        boolean z10 = false;
        if (!D0(eVar)) {
            boolean z11 = eVar.f10412u < this.f11259z;
            if (z11 && !eVar.d(268435456)) {
                if (eVar.d(67108864)) {
                    eVar.j();
                    z10 = true;
                }
                if (z10) {
                    if (z11) {
                        this.L0.f11267d++;
                    } else {
                        this.f6230c1.add(Long.valueOf(eVar.f10412u));
                        this.J1++;
                    }
                }
                return z10;
            }
        }
        return false;
    }

    @Override // z1.s, s1.d
    public final void p(long j10, boolean z10) {
        n0 n0Var = this.f6234g1;
        if (n0Var != null && !z10) {
            n0Var.h(true);
        }
        super.p(j10, z10);
        n0 n0Var2 = this.f6234g1;
        z zVar = this.Z0;
        if (n0Var2 == null) {
            e0 e0Var = zVar.f6305b;
            e0Var.f6176m = 0L;
            e0Var.f6179p = -1L;
            e0Var.f6177n = -1L;
            zVar.f6310h = -9223372036854775807L;
            zVar.f6309f = -9223372036854775807L;
            zVar.f6308e = Math.min(zVar.f6308e, 1);
            zVar.f6311i = -9223372036854775807L;
        }
        if (z10) {
            n0 n0Var3 = this.f6234g1;
            if (n0Var3 != null) {
                n0Var3.n(false);
            } else {
                zVar.c(false);
            }
        }
        F0();
        this.f6245s1 = 0;
    }

    @Override // z1.s
    public final boolean p0() {
        i1.p pVar = this.f14020a0;
        if (this.f6247u1 == null || this.f6248v1 || this.C1) {
            return true;
        }
        return (pVar != null && pVar.f5993p > 0) || this.Q0 || this.F0 != -9223372036854775807L;
    }

    @Override // s1.d
    public final void q() {
        n0 n0Var = this.f6234g1;
        if (n0Var == null || !this.V0) {
            return;
        }
        n0Var.a();
    }

    @Override // z1.s
    public final boolean q0(z1.p pVar) {
        return C0(pVar);
    }

    @Override // s1.d
    public final void r() {
        try {
            try {
                this.f14039u0 = false;
                j0();
                h0();
                p4.p pVar = this.T;
                if (pVar != null) {
                    pVar.m(null);
                }
                this.T = null;
            } catch (Throwable th) {
                p4.p pVar2 = this.T;
                if (pVar2 != null) {
                    pVar2.m(null);
                }
                this.T = null;
                throw th;
            }
        } finally {
            this.h1 = false;
            this.G1 = -9223372036854775807L;
            n nVar = this.f6238l1;
            if (nVar != null) {
                nVar.release();
                this.f6238l1 = null;
            }
        }
    }

    @Override // z1.s
    public final boolean r0() {
        z1.p pVar = this.f14026g0;
        if (this.f6234g1 != null && pVar != null) {
            String str = pVar.f14000a;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.r0();
    }

    @Override // s1.d
    public final void s() {
        this.f6244r1 = 0;
        this.f11254u.getClass();
        this.f6243q1 = SystemClock.elapsedRealtime();
        this.f6249w1 = 0L;
        this.f6250x1 = 0;
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            n0Var.p();
        } else {
            this.Z0.d();
        }
    }

    @Override // s1.d
    public final void t() {
        E0();
        int i10 = this.f6250x1;
        if (i10 != 0) {
            long j10 = this.f6249w1;
            k0 k0Var = this.W0;
            Handler handler = k0Var.f6226b;
            if (handler != null) {
                handler.post(new i0(k0Var, j10, i10));
            }
            this.f6249w1 = 0L;
            this.f6250x1 = 0;
        }
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            n0Var.j();
        } else {
            this.Z0.e();
        }
    }

    @Override // z1.s
    public final int t0(z1.j jVar, i1.p pVar) {
        boolean z10;
        int i10 = 0;
        if (!i1.g0.l(pVar.f5991n)) {
            return r.a.a(0, 0, 0, 0);
        }
        int i11 = 1;
        boolean z11 = pVar.f5995r != null;
        Context context = this.U0;
        List z02 = z0(context, jVar, pVar, z11, false);
        if (z11 && z02.isEmpty()) {
            z02 = z0(context, jVar, pVar, false, false);
        }
        if (z02.isEmpty()) {
            return r.a.a(1, 0, 0, 0);
        }
        int i12 = pVar.O;
        if (i12 != 0 && i12 != 2) {
            return r.a.a(2, 0, 0, 0);
        }
        z1.p pVar2 = (z1.p) z02.get(0);
        boolean e7 = pVar2.e(pVar);
        if (!e7) {
            for (int i13 = 1; i13 < z02.size(); i13++) {
                z1.p pVar3 = (z1.p) z02.get(i13);
                if (pVar3.e(pVar)) {
                    z10 = false;
                    e7 = true;
                    pVar2 = pVar3;
                    break;
                }
            }
        }
        z10 = true;
        int i14 = e7 ? 4 : 3;
        int i15 = pVar2.f(pVar) ? 16 : 8;
        int i16 = pVar2.g ? 64 : 0;
        int i17 = z10 ? 128 : 0;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(pVar.f5991n) && !x4.f.v(context)) {
            i17 = 256;
        }
        if (e7) {
            List z03 = z0(context, jVar, pVar, z11, true);
            if (!z03.isEmpty()) {
                HashMap hashMap = z1.x.f14048a;
                ArrayList arrayList = new ArrayList(z03);
                Collections.sort(arrayList, new p8.d(i11, new v0(28, pVar)));
                z1.p pVar4 = (z1.p) arrayList.get(0);
                if (pVar4.e(pVar) && pVar4.f(pVar)) {
                    i10 = 32;
                }
            }
        }
        return i14 | i15 | i10 | i16 | i17;
    }

    @Override // z1.s, s1.d
    public final void u(i1.p[] pVarArr, long j10, long j11, c2.d0 d0Var) {
        super.u(pVarArr, j10, j11, d0Var);
        t0 t0Var = this.D;
        if (t0Var.p()) {
            this.H1 = -9223372036854775807L;
        } else {
            d0Var.getClass();
            this.H1 = t0Var.g(d0Var.f2539a, new r0()).f6015d;
        }
    }

    @Override // z1.s, s1.d
    public final void w(long j10, long j11) {
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            try {
                n0Var.m(j10, j11);
            } catch (m0 e7) {
                throw f(e7, e7.f6259o, false, 7001);
            }
        }
        super.w(j10, j11);
    }

    @Override // z1.s, s1.d
    public final void y(float f10, float f11) {
        super.y(f10, f11);
        n0 n0Var = this.f6234g1;
        if (n0Var != null) {
            n0Var.e(f10);
        } else {
            this.Z0.i(f10);
        }
    }
}
