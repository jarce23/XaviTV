package u1;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.fragment.app.v0;
import i1.g0;
import i1.j0;
import i2.k0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: n0, reason: collision with root package name */
    public static final Object f12295n0 = new Object();

    /* renamed from: o0, reason: collision with root package name */
    public static ScheduledExecutorService f12296o0;

    /* renamed from: p0, reason: collision with root package name */
    public static int f12297p0;
    public i1.d A;
    public v B;
    public v C;
    public j0 D;
    public boolean E;
    public ByteBuffer F;
    public int G;
    public long H;
    public long I;
    public long J;
    public long K;
    public int L;
    public boolean M;
    public boolean N;
    public long O;
    public float P;
    public ByteBuffer Q;
    public int R;
    public ByteBuffer S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12298a;

    /* renamed from: a0, reason: collision with root package name */
    public i1.e f12299a0;

    /* renamed from: b, reason: collision with root package name */
    public final x4.m f12300b;

    /* renamed from: b0, reason: collision with root package name */
    public p4.p f12301b0;

    /* renamed from: c, reason: collision with root package name */
    public final t f12302c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f12303c0;

    /* renamed from: d, reason: collision with root package name */
    public final f0 f12304d;

    /* renamed from: d0, reason: collision with root package name */
    public long f12305d0;

    /* renamed from: e, reason: collision with root package name */
    public final j1.k f12306e;

    /* renamed from: e0, reason: collision with root package name */
    public long f12307e0;

    /* renamed from: f, reason: collision with root package name */
    public final e0 f12308f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f12309f0;
    public final w0 g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f12310g0;

    /* renamed from: h, reason: collision with root package name */
    public final s f12311h;
    public Looper h0;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayDeque f12312i;

    /* renamed from: i0, reason: collision with root package name */
    public long f12313i0;

    /* renamed from: j, reason: collision with root package name */
    public int f12314j;

    /* renamed from: j0, reason: collision with root package name */
    public long f12315j0;

    /* renamed from: k, reason: collision with root package name */
    public x4.m f12316k;

    /* renamed from: k0, reason: collision with root package name */
    public Handler f12317k0;

    /* renamed from: l, reason: collision with root package name */
    public final m6.j f12318l;

    /* renamed from: l0, reason: collision with root package name */
    public Context f12319l0;

    /* renamed from: m, reason: collision with root package name */
    public final m6.j f12320m;

    /* renamed from: m0, reason: collision with root package name */
    public final boolean f12321m0;

    /* renamed from: n, reason: collision with root package name */
    public final a0 f12322n;

    /* renamed from: o, reason: collision with root package name */
    public final j5.g f12323o;

    /* renamed from: p, reason: collision with root package name */
    public final a0 f12324p;

    /* renamed from: q, reason: collision with root package name */
    public final int f12325q;

    /* renamed from: r, reason: collision with root package name */
    public t1.u f12326r;

    /* renamed from: s, reason: collision with root package name */
    public p4.p f12327s;

    /* renamed from: t, reason: collision with root package name */
    public u f12328t;

    /* renamed from: u, reason: collision with root package name */
    public u f12329u;

    /* renamed from: v, reason: collision with root package name */
    public j1.d f12330v;

    /* renamed from: w, reason: collision with root package name */
    public AudioTrack f12331w;

    /* renamed from: x, reason: collision with root package name */
    public b f12332x;

    /* renamed from: y, reason: collision with root package name */
    public e f12333y;

    /* renamed from: z, reason: collision with root package name */
    public android.support.v4.media.session.a0 f12334z;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00ae, code lost:
    
        r11 = r0.getDeviceId();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z(c2.q r11) {
        /*
            r10 = this;
            r10.<init>()
            java.lang.Object r0 = r11.f2681b
            android.content.Context r0 = (android.content.Context) r0
            r1 = 0
            if (r0 != 0) goto Lc
            r2 = r1
            goto L10
        Lc:
            android.content.Context r2 = r0.getApplicationContext()
        L10:
            r10.f12298a = r2
            i1.d r3 = i1.d.f5843b
            r10.A = r3
            if (r2 == 0) goto L19
            goto L1d
        L19:
            java.lang.Object r1 = r11.f2682c
            u1.b r1 = (u1.b) r1
        L1d:
            r10.f12332x = r1
            java.lang.Object r1 = r11.f2683d
            x4.m r1 = (x4.m) r1
            r10.f12300b = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r10.f12314j = r2
            java.lang.Object r3 = r11.f2684e
            u1.a0 r3 = (u1.a0) r3
            r10.f12322n = r3
            java.lang.Object r3 = r11.g
            j5.g r3 = (j5.g) r3
            r3.getClass()
            r10.f12323o = r3
            u1.s r3 = new u1.s
            p4.p r4 = new p4.p
            r5 = 13
            r4.<init>(r5, r10)
            r3.<init>(r4)
            r10.f12311h = r3
            u1.t r3 = new u1.t
            r3.<init>()
            r10.f12302c = r3
            u1.f0 r4 = new u1.f0
            r4.<init>()
            byte[] r5 = l1.a0.f8069c
            r4.f12207m = r5
            r10.f12304d = r4
            j1.k r5 = new j1.k
            r5.<init>()
            r10.f12306e = r5
            u1.e0 r5 = new u1.e0
            r5.<init>()
            r10.f12308f = r5
            o9.w0 r3 = o9.g0.s(r4, r3)
            r10.g = r3
            r3 = 1065353216(0x3f800000, float:1.0)
            r10.P = r3
            r10.Y = r2
            i1.e r3 = new i1.e
            r3.<init>()
            r10.f12299a0 = r3
            u1.v r4 = new u1.v
            i1.j0 r5 = i1.j0.f5905d
            r6 = 0
            r8 = 0
            r4.<init>(r5, r6, r8)
            r10.C = r4
            r10.D = r5
            r10.E = r2
            java.util.ArrayDeque r2 = new java.util.ArrayDeque
            r2.<init>()
            r10.f12312i = r2
            m6.j r2 = new m6.j
            r2.<init>()
            r10.f12318l = r2
            m6.j r2 = new m6.j
            r2.<init>()
            r10.f12320m = r2
            java.lang.Object r11 = r11.f2685f
            u1.a0 r11 = (u1.a0) r11
            r10.f12324p = r11
            r11 = 34
            r2 = -1
            if (r1 < r11) goto Lb7
            if (r0 != 0) goto Lae
            goto Lb7
        Lae:
            int r11 = a6.y.c(r0)
            if (r11 == 0) goto Lb7
            if (r11 == r2) goto Lb7
            r2 = r11
        Lb7:
            r10.f12325q = r2
            r11 = 1
            r10.f12321m0 = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.z.<init>(c2.q):void");
    }

    public static boolean p(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        isOffloadedPlayback = audioTrack.isOffloadedPlayback();
        return isOffloadedPlayback;
    }

    public final void a(long j10) {
        j0 j0Var;
        u uVar = this.f12329u;
        boolean z10 = false;
        x4.m mVar = this.f12300b;
        if (uVar == null || !uVar.f12284j) {
            if (this.f12303c0 || uVar.f12278c != 0) {
                j0Var = j0.f5905d;
            } else {
                int i10 = uVar.f12276a.H;
                j0Var = this.D;
                j1.j jVar = (j1.j) mVar.f13566r;
                float f10 = j0Var.f5906a;
                jVar.getClass();
                l1.d.b(f10 > 0.0f);
                if (jVar.f6985c != f10) {
                    jVar.f6985c = f10;
                    jVar.f6990i = true;
                }
                float f11 = j0Var.f5907b;
                l1.d.b(f11 > 0.0f);
                if (jVar.f6986d != f11) {
                    jVar.f6986d = f11;
                    jVar.f6990i = true;
                }
            }
            this.D = j0Var;
        } else {
            j0Var = j0.f5905d;
        }
        j0 j0Var2 = j0Var;
        if (!this.f12303c0) {
            u uVar2 = this.f12329u;
            if (uVar2.f12278c == 0) {
                int i11 = uVar2.f12276a.H;
                z10 = this.E;
                ((d0) mVar.f13565q).f12181o = z10;
            }
        }
        this.E = z10;
        this.f12312i.add(new v(j0Var2, Math.max(0L, j10), l1.a0.T(this.f12329u.f12280e, k())));
        j1.d dVar = this.f12329u.f12283i;
        this.f12330v = dVar;
        dVar.a();
        p4.p pVar = this.f12327s;
        if (pVar != null) {
            final boolean z11 = this.E;
            final k0 k0Var = ((b0) pVar.f9953p).V0;
            Handler handler = k0Var.f6226b;
            if (handler != null) {
                handler.post(new Runnable() { // from class: u1.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        s1.x xVar = k0.this.f6227c;
                        int i12 = l1.a0.f8067a;
                        s1.a0 a0Var = xVar.f11482o;
                        boolean z12 = a0Var.f11189d0;
                        boolean z13 = z11;
                        if (z12 == z13) {
                            return;
                        }
                        a0Var.f11189d0 = z13;
                        a0Var.f11204m.e(23, new s1.u(1, z13));
                    }
                });
            }
        }
    }

    public final AudioTrack b(l lVar, i1.d dVar, int i10, i1.p pVar, Context context) {
        try {
            AudioTrack a10 = this.f12324p.a(lVar, dVar, i10, context);
            int state = a10.getState();
            if (state == 1) {
                return a10;
            }
            try {
                a10.release();
            } catch (Exception unused) {
            }
            throw new n(state, lVar.f12224b, lVar.f12225c, lVar.f12223a, lVar.f12228f, pVar, lVar.f12227e, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e7) {
            throw new n(0, lVar.f12224b, lVar.f12225c, lVar.f12223a, lVar.f12228f, pVar, lVar.f12227e, e7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.media.AudioTrack c(u1.u r9) {
        /*
            r8 = this;
            int r0 = r8.Y     // Catch: u1.n -> L3a
            int r1 = r8.f12325q     // Catch: u1.n -> L3a
            r2 = -1
            if (r1 == r2) goto L26
            android.content.Context r2 = r8.f12298a     // Catch: u1.n -> L1c
            if (r2 == 0) goto L26
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: u1.n -> L1c
            r4 = 34
            if (r3 < r4) goto L26
            android.content.Context r0 = r8.f12319l0     // Catch: u1.n -> L1c
            if (r0 != 0) goto L20
            android.content.Context r0 = a6.y.d(r2, r1)     // Catch: u1.n -> L1c
            r8.f12319l0 = r0     // Catch: u1.n -> L1c
            goto L20
        L1c:
            r0 = move-exception
            r9 = r0
            r2 = r8
            goto L3d
        L20:
            android.content.Context r0 = r8.f12319l0     // Catch: u1.n -> L1c
            r1 = 0
            r7 = r0
            r5 = r1
            goto L29
        L26:
            r1 = 0
            r5 = r0
            r7 = r1
        L29:
            u1.l r3 = r9.a()     // Catch: u1.n -> L3a
            i1.d r4 = r8.A     // Catch: u1.n -> L3a
            i1.p r6 = r9.f12276a     // Catch: u1.n -> L3a
            r2 = r8
            android.media.AudioTrack r9 = r2.b(r3, r4, r5, r6, r7)     // Catch: u1.n -> L37
            return r9
        L37:
            r0 = move-exception
        L38:
            r9 = r0
            goto L3d
        L3a:
            r0 = move-exception
            r2 = r8
            goto L38
        L3d:
            p4.p r0 = r2.f12327s
            if (r0 == 0) goto L44
            r0.i(r9)
        L44:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.z.c(u1.u):android.media.AudioTrack");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c0, code lost:
    
        if (r11 > 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c3, code lost:
    
        if (r15 > 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c6, code lost:
    
        if (r15 < 0) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(i1.p r26, int[] r27) {
        /*
            Method dump skipped, instructions count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.z.d(i1.p, int[]):void");
    }

    public final void e(long j10) {
        int write;
        p4.p pVar;
        s1.d0 d0Var;
        boolean z10;
        m6.j jVar = this.f12320m;
        if (this.S == null) {
            return;
        }
        if (((Exception) jVar.f9021c) != null) {
            synchronized (f12295n0) {
                z10 = f12297p0 > 0;
            }
            if (z10 || SystemClock.elapsedRealtime() < jVar.f9020b) {
                return;
            }
        }
        int remaining = this.S.remaining();
        if (this.f12303c0) {
            l1.d.g(j10 != -9223372036854775807L);
            if (j10 == Long.MIN_VALUE) {
                j10 = this.f12305d0;
            } else {
                this.f12305d0 = j10;
            }
            AudioTrack audioTrack = this.f12331w;
            ByteBuffer byteBuffer = this.S;
            if (Build.VERSION.SDK_INT >= 26) {
                write = audioTrack.write(byteBuffer, remaining, 1, 1000 * j10);
            } else {
                if (this.F == null) {
                    ByteBuffer allocate = ByteBuffer.allocate(16);
                    this.F = allocate;
                    allocate.order(ByteOrder.BIG_ENDIAN);
                    this.F.putInt(1431633921);
                }
                if (this.G == 0) {
                    this.F.putInt(4, remaining);
                    this.F.putLong(8, j10 * 1000);
                    this.F.position(0);
                    this.G = remaining;
                }
                int remaining2 = this.F.remaining();
                if (remaining2 > 0) {
                    int write2 = audioTrack.write(this.F, remaining2, 1);
                    if (write2 < 0) {
                        this.G = 0;
                        write = write2;
                    } else if (write2 < remaining2) {
                        write = 0;
                    }
                }
                write = audioTrack.write(byteBuffer, remaining, 1);
                if (write < 0) {
                    this.G = 0;
                } else {
                    this.G -= write;
                }
            }
        } else {
            write = this.f12331w.write(this.S, remaining, 1);
        }
        this.f12307e0 = SystemClock.elapsedRealtime();
        if (write < 0) {
            if ((Build.VERSION.SDK_INT >= 24 && write == -6) || write == -32) {
                if (k() <= 0) {
                    if (p(this.f12331w)) {
                        if (this.f12329u.f12278c == 1) {
                            this.f12309f0 = true;
                        }
                    }
                }
                r2 = true;
            }
            p pVar2 = new p(write, this.f12329u.f12276a, r2);
            p4.p pVar3 = this.f12327s;
            if (pVar3 != null) {
                pVar3.i(pVar2);
            }
            if (!pVar2.f12233p || this.f12298a == null) {
                jVar.e(pVar2);
                return;
            }
            b bVar = b.f12152c;
            this.f12332x = bVar;
            this.f12333y.a(bVar);
            throw pVar2;
        }
        jVar.f9021c = null;
        jVar.f9019a = -9223372036854775807L;
        jVar.f9020b = -9223372036854775807L;
        if (p(this.f12331w)) {
            if (this.K > 0) {
                this.f12310g0 = false;
            }
            if (this.W && (pVar = this.f12327s) != null && write < remaining && !this.f12310g0 && (d0Var = ((b0) pVar.f9953p).U) != null) {
                d0Var.f11260a.f11323e0 = true;
            }
        }
        int i10 = this.f12329u.f12278c;
        if (i10 == 0) {
            this.J += write;
        }
        if (write == remaining) {
            if (i10 != 0) {
                l1.d.g(this.S == this.Q);
                this.K = (this.L * this.R) + this.K;
            }
            this.S = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0043 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f() {
        /*
            r6 = this;
            j1.d r0 = r6.f12330v
            boolean r0 = r0.d()
            r1 = -9223372036854775808
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L14
            r6.e(r1)
            java.nio.ByteBuffer r0 = r6.S
            if (r0 != 0) goto L44
            goto L43
        L14:
            j1.d r0 = r6.f12330v
            boolean r5 = r0.d()
            if (r5 == 0) goto L2e
            boolean r5 = r0.f6949d
            if (r5 == 0) goto L21
            goto L2e
        L21:
            r0.f6949d = r4
            java.util.ArrayList r0 = r0.f6947b
            java.lang.Object r0 = r0.get(r3)
            j1.g r0 = (j1.g) r0
            r0.e()
        L2e:
            r6.t(r1)
            j1.d r0 = r6.f12330v
            boolean r0 = r0.c()
            if (r0 == 0) goto L44
            java.nio.ByteBuffer r0 = r6.S
            if (r0 == 0) goto L43
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L44
        L43:
            return r4
        L44:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.z.f():boolean");
    }

    public final void g() {
        android.support.v4.media.session.a0 a0Var;
        if (o()) {
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0L;
            this.f12310g0 = false;
            this.L = 0;
            this.C = new v(this.D, 0L, 0L);
            this.O = 0L;
            this.B = null;
            this.f12312i.clear();
            this.Q = null;
            this.R = 0;
            this.S = null;
            this.U = false;
            this.T = false;
            this.V = false;
            this.F = null;
            this.G = 0;
            this.f12304d.f12209o = 0L;
            j1.d dVar = this.f12329u.f12283i;
            this.f12330v = dVar;
            dVar.a();
            AudioTrack audioTrack = this.f12311h.f12251c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.f12331w.pause();
            }
            if (p(this.f12331w)) {
                x4.m mVar = this.f12316k;
                mVar.getClass();
                this.f12331w.unregisterStreamEventCallback((y) mVar.f13565q);
                ((Handler) mVar.f13564p).removeCallbacksAndMessages(null);
            }
            l a10 = this.f12329u.a();
            u uVar = this.f12328t;
            if (uVar != null) {
                this.f12329u = uVar;
                this.f12328t = null;
            }
            s sVar = this.f12311h;
            sVar.f();
            sVar.f12251c = null;
            sVar.f12253e = null;
            if (Build.VERSION.SDK_INT >= 24 && (a0Var = this.f12334z) != null) {
                AudioTrack audioTrack2 = (AudioTrack) a0Var.f230p;
                w wVar = (w) a0Var.f232r;
                wVar.getClass();
                audioTrack2.removeOnRoutingChangedListener(wVar);
                a0Var.f232r = null;
                this.f12334z = null;
            }
            AudioTrack audioTrack3 = this.f12331w;
            p4.p pVar = this.f12327s;
            Handler handler = new Handler(Looper.myLooper());
            synchronized (f12295n0) {
                try {
                    if (f12296o0 == null) {
                        int i10 = l1.a0.f8067a;
                        f12296o0 = Executors.newSingleThreadScheduledExecutor(new l1.z());
                    }
                    f12297p0++;
                    f12296o0.schedule(new p4.j(audioTrack3, pVar, handler, a10, 1), 20L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f12331w = null;
        }
        m6.j jVar = this.f12320m;
        jVar.f9021c = null;
        jVar.f9019a = -9223372036854775807L;
        jVar.f9020b = -9223372036854775807L;
        m6.j jVar2 = this.f12318l;
        jVar2.f9021c = null;
        jVar2.f9019a = -9223372036854775807L;
        jVar2.f9020b = -9223372036854775807L;
        this.f12313i0 = 0L;
        this.f12315j0 = 0L;
        Handler handler2 = this.f12317k0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public final f h(i1.p pVar) {
        boolean booleanValue;
        boolean isOffloadedPlaybackSupported;
        int playbackOffloadSupport;
        if (this.f12309f0) {
            return f.f12199d;
        }
        i1.d dVar = this.A;
        j5.g gVar = this.f12323o;
        gVar.getClass();
        pVar.getClass();
        int i10 = pVar.G;
        dVar.getClass();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 29 || i10 == -1) {
            return f.f12199d;
        }
        Context context = (Context) gVar.f7115p;
        Boolean bool = (Boolean) gVar.f7114o;
        boolean z10 = false;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            if (context != null) {
                String parameters = j1.c.k(context).getParameters("offloadVariableRateSupported");
                gVar.f7114o = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            } else {
                gVar.f7114o = Boolean.FALSE;
            }
            booleanValue = ((Boolean) gVar.f7114o).booleanValue();
        }
        String str = pVar.f5991n;
        str.getClass();
        int c10 = g0.c(str, pVar.f5988k);
        if (c10 == 0 || i11 < l1.a0.q(c10)) {
            return f.f12199d;
        }
        int r2 = l1.a0.r(pVar.F);
        if (r2 == 0) {
            return f.f12199d;
        }
        try {
            AudioFormat build = new AudioFormat.Builder().setSampleRate(i10).setChannelMask(r2).setEncoding(c10).build();
            if (i11 < 31) {
                isOffloadedPlaybackSupported = AudioManager.isOffloadedPlaybackSupported(build, (AudioAttributes) dVar.a().f5610p);
                if (!isOffloadedPlaybackSupported) {
                    return f.f12199d;
                }
                e3.d dVar2 = new e3.d();
                dVar2.f4425a = true;
                dVar2.f4427c = booleanValue;
                return dVar2.a();
            }
            playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(build, (AudioAttributes) dVar.a().f5610p);
            if (playbackOffloadSupport == 0) {
                return f.f12199d;
            }
            e3.d dVar3 = new e3.d();
            if (i11 > 32 && playbackOffloadSupport == 2) {
                z10 = true;
            }
            dVar3.f4425a = true;
            dVar3.f4426b = z10;
            dVar3.f4427c = booleanValue;
            return dVar3.a();
        } catch (IllegalArgumentException unused) {
            return f.f12199d;
        }
    }

    public final int i(i1.p pVar) {
        q();
        String str = pVar.f5991n;
        int i10 = pVar.H;
        if ("audio/raw".equals(str)) {
            if (!l1.a0.K(i10)) {
                android.support.v4.media.d.x("Invalid PCM encoding: ", i10, "DefaultAudioSink");
                return 0;
            }
            if (i10 != 2) {
                return 1;
            }
        } else if (this.f12332x.d(pVar, this.A) == null) {
            return 0;
        }
        return 2;
    }

    public final long j() {
        return this.f12329u.f12278c == 0 ? this.H / r0.f12277b : this.I;
    }

    public final long k() {
        u uVar = this.f12329u;
        if (uVar.f12278c != 0) {
            return this.K;
        }
        long j10 = this.J;
        long j11 = uVar.f12279d;
        int i10 = l1.a0.f8067a;
        return ((j10 + j11) - 1) / j11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x00b3, code lost:
    
        if (n() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x03c8, code lost:
    
        if (r15 == 0) goto L219;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(java.nio.ByteBuffer r29, long r30, int r32) {
        /*
            Method dump skipped, instructions count: 1236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.z.l(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean m() {
        boolean isOffloadedPlayback;
        if (!o()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            isOffloadedPlayback = this.f12331w.isOffloadedPlayback();
            if (isOffloadedPlayback && this.V) {
                return false;
            }
        }
        long k10 = k();
        s sVar = this.f12311h;
        long a10 = sVar.a();
        int i10 = sVar.f12254f;
        int i11 = l1.a0.f8067a;
        return k10 > l1.a0.V(a10, (long) i10, 1000000L, RoundingMode.UP);
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.z.n():boolean");
    }

    public final boolean o() {
        return this.f12331w != null;
    }

    public final void q() {
        Context context;
        b bVar;
        Looper myLooper = Looper.myLooper();
        boolean z10 = this.f12333y == null || this.h0 == myLooper;
        StringBuilder sb2 = new StringBuilder("DefaultAudioSink accessed on multiple threads: ");
        Looper looper = this.h0;
        sb2.append(looper == null ? "null" : looper.getThread().getName());
        sb2.append(" and ");
        sb2.append(myLooper != null ? myLooper.getThread().getName() : "null");
        l1.d.f(sb2.toString(), z10);
        if (this.f12333y == null && (context = this.f12298a) != null) {
            this.h0 = myLooper;
            e eVar = new e(context, new v0(26, this), this.A, this.f12301b0);
            this.f12333y = eVar;
            if (eVar.f12197j) {
                bVar = eVar.g;
                bVar.getClass();
            } else {
                eVar.f12197j = true;
                d dVar = eVar.f12194f;
                if (dVar != null) {
                    dVar.f12172a.registerContentObserver(dVar.f12173b, false, dVar);
                }
                Handler handler = eVar.f12191c;
                Context context2 = eVar.f12189a;
                c cVar = eVar.f12192d;
                if (cVar != null) {
                    j1.c.k(context2).registerAudioDeviceCallback(cVar, handler);
                }
                b b2 = b.b(context2, context2.registerReceiver(eVar.f12193e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler), eVar.f12196i, eVar.f12195h);
                eVar.g = b2;
                bVar = b2;
            }
            this.f12332x = bVar;
        }
        this.f12332x.getClass();
    }

    public final void r() {
        this.W = true;
        if (o()) {
            s sVar = this.f12311h;
            if (sVar.f12271x != -9223372036854775807L) {
                sVar.G.getClass();
                sVar.f12271x = l1.a0.O(SystemClock.elapsedRealtime());
            }
            sVar.f12257j = l1.a0.T(sVar.f12254f, sVar.b());
            r rVar = sVar.f12253e;
            rVar.getClass();
            rVar.a(0);
            if (!this.U || p(this.f12331w)) {
                this.f12331w.play();
            }
        }
    }

    public final void s() {
        if (this.U) {
            return;
        }
        this.U = true;
        long k10 = k();
        s sVar = this.f12311h;
        sVar.f12273z = sVar.b();
        sVar.G.getClass();
        sVar.f12271x = l1.a0.O(SystemClock.elapsedRealtime());
        sVar.A = k10;
        if (p(this.f12331w)) {
            this.V = false;
        }
        this.f12331w.stop();
        this.G = 0;
    }

    public final void t(long j10) {
        ByteBuffer byteBuffer;
        e(j10);
        if (this.S != null) {
            return;
        }
        if (!this.f12330v.d()) {
            ByteBuffer byteBuffer2 = this.Q;
            if (byteBuffer2 != null) {
                w(byteBuffer2);
                e(j10);
                return;
            }
            return;
        }
        while (!this.f12330v.c()) {
            do {
                j1.d dVar = this.f12330v;
                if (dVar.d()) {
                    ByteBuffer byteBuffer3 = dVar.f6948c[dVar.b()];
                    if (byteBuffer3.hasRemaining()) {
                        byteBuffer = byteBuffer3;
                    } else {
                        dVar.e(j1.g.f6955a);
                        byteBuffer = dVar.f6948c[dVar.b()];
                    }
                } else {
                    byteBuffer = j1.g.f6955a;
                }
                if (byteBuffer.hasRemaining()) {
                    w(byteBuffer);
                    e(j10);
                } else {
                    ByteBuffer byteBuffer4 = this.Q;
                    if (byteBuffer4 == null || !byteBuffer4.hasRemaining()) {
                        return;
                    }
                    j1.d dVar2 = this.f12330v;
                    ByteBuffer byteBuffer5 = this.Q;
                    if (dVar2.d() && !dVar2.f6949d) {
                        dVar2.e(byteBuffer5);
                    }
                }
            } while (this.S == null);
            return;
        }
    }

    public final void u() {
        g();
        o9.e0 listIterator = this.g.listIterator(0);
        while (listIterator.hasNext()) {
            ((j1.g) listIterator.next()).reset();
        }
        this.f12306e.reset();
        this.f12308f.reset();
        j1.d dVar = this.f12330v;
        if (dVar != null) {
            o9.g0 g0Var = dVar.f6946a;
            for (int i10 = 0; i10 < g0Var.size(); i10++) {
                j1.g gVar = (j1.g) g0Var.get(i10);
                gVar.flush();
                gVar.reset();
            }
            dVar.f6948c = new ByteBuffer[0];
            j1.e eVar = j1.e.f6950e;
            dVar.f6949d = false;
        }
        this.W = false;
        this.f12309f0 = false;
    }

    public final void v() {
        if (o()) {
            try {
                this.f12331w.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.D.f5906a).setPitch(this.D.f5907b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e7) {
                l1.b.r("DefaultAudioSink", "Failed to set playback params", e7);
            }
            j0 j0Var = new j0(this.f12331w.getPlaybackParams().getSpeed(), this.f12331w.getPlaybackParams().getPitch());
            this.D = j0Var;
            float f10 = j0Var.f5906a;
            s sVar = this.f12311h;
            sVar.f12255h = f10;
            r rVar = sVar.f12253e;
            if (rVar != null) {
                rVar.a(0);
            }
            sVar.f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(java.nio.ByteBuffer r19) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.z.w(java.nio.ByteBuffer):void");
    }
}
