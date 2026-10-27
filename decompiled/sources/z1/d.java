package z1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.nio.ByteBuffer;
import l1.a0;
import x5.b0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements m {

    /* renamed from: o, reason: collision with root package name */
    public final MediaCodec f13958o;

    /* renamed from: p, reason: collision with root package name */
    public final g f13959p;

    /* renamed from: q, reason: collision with root package name */
    public final n f13960q;

    /* renamed from: r, reason: collision with root package name */
    public final k f13961r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13962s;

    /* renamed from: t, reason: collision with root package name */
    public int f13963t = 0;

    public d(MediaCodec mediaCodec, HandlerThread handlerThread, n nVar, k kVar) {
        this.f13958o = mediaCodec;
        this.f13959p = new g(handlerThread);
        this.f13960q = nVar;
        this.f13961r = kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
    
        if (r7 == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(z1.d r5, android.media.MediaFormat r6, android.view.Surface r7, android.media.MediaCrypto r8, int r9) {
        /*
            z1.g r0 = r5.f13959p
            android.media.MediaCodec r1 = r5.f13958o
            android.os.HandlerThread r2 = r0.f13977b
            android.os.Handler r3 = r0.f13978c
            r4 = 1
            if (r3 != 0) goto Ld
            r3 = r4
            goto Le
        Ld:
            r3 = 0
        Le:
            l1.d.g(r3)
            r2.start()
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r2 = r2.getLooper()
            r3.<init>(r2)
            r1.setCallback(r0, r3)
            r0.f13978c = r3
            java.lang.String r0 = "configureCodec"
            android.os.Trace.beginSection(r0)
            r1.configure(r6, r7, r8, r9)
            android.os.Trace.endSection()
            z1.n r6 = r5.f13960q
            r6.start()
            java.lang.String r6 = "startCodec"
            android.os.Trace.beginSection(r6)
            r1.start()
            android.os.Trace.endSection()
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 35
            if (r6 < r7) goto L5f
            z1.k r6 = r5.f13961r
            if (r6 == 0) goto L5f
            java.lang.Object r7 = r6.f13998c
            android.media.LoudnessCodecController r7 = (android.media.LoudnessCodecController) r7
            if (r7 == 0) goto L54
            boolean r7 = z1.a.e(r7, r1)
            if (r7 != 0) goto L54
            goto L5f
        L54:
            java.lang.Object r6 = r6.f13996a
            java.util.HashSet r6 = (java.util.HashSet) r6
            boolean r6 = r6.add(r1)
            l1.d.g(r6)
        L5f:
            r5.f13963t = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.d.c(z1.d, android.media.MediaFormat, android.view.Surface, android.media.MediaCrypto, int):void");
    }

    public static String g(int i10, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i10 == 1) {
            sb2.append("Audio");
        } else if (i10 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i10);
            sb2.append(")");
        }
        return sb2.toString();
    }

    @Override // z1.m
    public final void a() {
        k kVar;
        k kVar2;
        try {
            if (this.f13963t == 1) {
                this.f13960q.shutdown();
                g gVar = this.f13959p;
                synchronized (gVar.f13976a) {
                    gVar.f13987m = true;
                    gVar.f13977b.quit();
                    gVar.a();
                }
            }
            this.f13963t = 2;
            if (this.f13962s) {
                return;
            }
            try {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30 && i10 < 33) {
                    this.f13958o.stop();
                }
                if (i10 >= 35 && (kVar2 = this.f13961r) != null) {
                    kVar2.c(this.f13958o);
                }
                this.f13958o.release();
                this.f13962s = true;
            } finally {
            }
        } catch (Throwable th) {
            if (!this.f13962s) {
                try {
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 30 && i11 < 33) {
                        this.f13958o.stop();
                    }
                    if (i11 >= 35 && (kVar = this.f13961r) != null) {
                        kVar.c(this.f13958o);
                    }
                    this.f13958o.release();
                    this.f13962s = true;
                } finally {
                }
            }
            throw th;
        }
    }

    @Override // z1.m
    public final void b(int i10, o4.a aVar, long j10, int i11) {
        this.f13960q.b(i10, aVar, j10, i11);
    }

    @Override // z1.m
    public final void d(Bundle bundle) {
        this.f13960q.d(bundle);
    }

    @Override // z1.m
    public final void e(int i10, int i11, long j10, int i12) {
        this.f13960q.e(i10, i11, j10, i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[Catch: all -> 0x002e, DONT_GENERATE, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x000a, B:6:0x000f, B:8:0x0013, B:10:0x0017, B:12:0x0021, B:18:0x002c, B:21:0x0031, B:25:0x003c, B:28:0x0040, B:30:0x004e, B:31:0x0075, B:35:0x006b, B:36:0x0077, B:37:0x007c, B:39:0x007d, B:40:0x007f, B:41:0x0080, B:42:0x0082, B:43:0x0083, B:44:0x0085), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0031 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x000a, B:6:0x000f, B:8:0x0013, B:10:0x0017, B:12:0x0021, B:18:0x002c, B:21:0x0031, B:25:0x003c, B:28:0x0040, B:30:0x004e, B:31:0x0075, B:35:0x006b, B:36:0x0077, B:37:0x007c, B:39:0x007d, B:40:0x007f, B:41:0x0080, B:42:0x0082, B:43:0x0083, B:44:0x0085), top: B:3:0x000a }] */
    @Override // z1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(android.media.MediaCodec.BufferInfo r11) {
        /*
            r10 = this;
            z1.n r0 = r10.f13960q
            r0.a()
            z1.g r0 = r10.f13959p
            java.lang.Object r1 = r0.f13976a
            monitor-enter(r1)
            java.lang.IllegalStateException r2 = r0.f13988n     // Catch: java.lang.Throwable -> L2e
            r3 = 0
            if (r2 != 0) goto L83
            android.media.MediaCodec$CodecException r2 = r0.f13984j     // Catch: java.lang.Throwable -> L2e
            if (r2 != 0) goto L80
            android.media.MediaCodec$CryptoException r2 = r0.f13985k     // Catch: java.lang.Throwable -> L2e
            if (r2 != 0) goto L7d
            long r2 = r0.f13986l     // Catch: java.lang.Throwable -> L2e
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r2 > 0) goto L28
            boolean r2 = r0.f13987m     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L26
            goto L28
        L26:
            r2 = r3
            goto L29
        L28:
            r2 = r4
        L29:
            r5 = -1
            if (r2 == 0) goto L31
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            return r5
        L2e:
            r0 = move-exception
            r11 = r0
            goto L86
        L31:
            b4.p r2 = r0.f13980e     // Catch: java.lang.Throwable -> L2e
            int r6 = r2.f2378c     // Catch: java.lang.Throwable -> L2e
            int r7 = r2.f2379d     // Catch: java.lang.Throwable -> L2e
            if (r6 != r7) goto L3a
            r3 = r4
        L3a:
            if (r3 == 0) goto L3e
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            return r5
        L3e:
            if (r6 == r7) goto L77
            java.lang.Object r3 = r2.f2377b     // Catch: java.lang.Throwable -> L2e
            int[] r3 = (int[]) r3     // Catch: java.lang.Throwable -> L2e
            r3 = r3[r6]     // Catch: java.lang.Throwable -> L2e
            int r6 = r6 + r4
            int r4 = r2.f2380e     // Catch: java.lang.Throwable -> L2e
            r4 = r4 & r6
            r2.f2378c = r4     // Catch: java.lang.Throwable -> L2e
            if (r3 < 0) goto L68
            android.media.MediaFormat r2 = r0.f13982h     // Catch: java.lang.Throwable -> L2e
            l1.d.h(r2)     // Catch: java.lang.Throwable -> L2e
            java.util.ArrayDeque r0 = r0.f13981f     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r0 = r0.remove()     // Catch: java.lang.Throwable -> L2e
            android.media.MediaCodec$BufferInfo r0 = (android.media.MediaCodec.BufferInfo) r0     // Catch: java.lang.Throwable -> L2e
            int r5 = r0.offset     // Catch: java.lang.Throwable -> L2e
            int r6 = r0.size     // Catch: java.lang.Throwable -> L2e
            long r7 = r0.presentationTimeUs     // Catch: java.lang.Throwable -> L2e
            int r9 = r0.flags     // Catch: java.lang.Throwable -> L2e
            r4 = r11
            r4.set(r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L2e
            goto L75
        L68:
            r11 = -2
            if (r3 != r11) goto L75
            java.util.ArrayDeque r11 = r0.g     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r11 = r11.remove()     // Catch: java.lang.Throwable -> L2e
            android.media.MediaFormat r11 = (android.media.MediaFormat) r11     // Catch: java.lang.Throwable -> L2e
            r0.f13982h = r11     // Catch: java.lang.Throwable -> L2e
        L75:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            return r3
        L77:
            java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException     // Catch: java.lang.Throwable -> L2e
            r11.<init>()     // Catch: java.lang.Throwable -> L2e
            throw r11     // Catch: java.lang.Throwable -> L2e
        L7d:
            r0.f13985k = r3     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L80:
            r0.f13984j = r3     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L83:
            r0.f13988n = r3     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L86:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.d.f(android.media.MediaCodec$BufferInfo):int");
    }

    @Override // z1.m
    public final void flush() {
        this.f13960q.flush();
        this.f13958o.flush();
        g gVar = this.f13959p;
        synchronized (gVar.f13976a) {
            gVar.f13986l++;
            Handler handler = gVar.f13978c;
            int i10 = a0.f8067a;
            handler.post(new w1.o(4, gVar));
        }
        this.f13958o.start();
    }

    @Override // z1.m
    public final void h(int i10) {
        this.f13958o.releaseOutputBuffer(i10, false);
    }

    @Override // z1.m
    public final void i(i2.k kVar, Handler handler) {
        this.f13958o.setOnFrameRenderedListener(new b(this, kVar, 0), handler);
    }

    @Override // z1.m
    public final boolean j(b0 b0Var) {
        g gVar = this.f13959p;
        synchronized (gVar.f13976a) {
            gVar.f13989o = b0Var;
        }
        return true;
    }

    @Override // z1.m
    public final void m(int i10) {
        this.f13958o.setVideoScalingMode(i10);
    }

    @Override // z1.m
    public final MediaFormat o() {
        MediaFormat mediaFormat;
        g gVar = this.f13959p;
        synchronized (gVar.f13976a) {
            try {
                mediaFormat = gVar.f13982h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    @Override // z1.m
    public final void q() {
        this.f13958o.detachOutputSurface();
    }

    @Override // z1.m
    public final ByteBuffer r(int i10) {
        return this.f13958o.getInputBuffer(i10);
    }

    @Override // z1.m
    public final void s(Surface surface) {
        this.f13958o.setOutputSurface(surface);
    }

    @Override // z1.m
    public final ByteBuffer v(int i10) {
        return this.f13958o.getOutputBuffer(i10);
    }

    @Override // z1.m
    public final void w(int i10, long j10) {
        this.f13958o.releaseOutputBuffer(i10, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[Catch: all -> 0x002e, DONT_GENERATE, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x000a, B:6:0x000f, B:8:0x0013, B:10:0x0017, B:12:0x0021, B:18:0x002c, B:21:0x0030, B:26:0x004a, B:29:0x003e, B:30:0x004c, B:31:0x0051, B:33:0x0052, B:34:0x0054, B:35:0x0055, B:36:0x0057, B:37:0x0058, B:38:0x005a), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0030 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x000a, B:6:0x000f, B:8:0x0013, B:10:0x0017, B:12:0x0021, B:18:0x002c, B:21:0x0030, B:26:0x004a, B:29:0x003e, B:30:0x004c, B:31:0x0051, B:33:0x0052, B:34:0x0054, B:35:0x0055, B:36:0x0057, B:37:0x0058, B:38:0x005a), top: B:3:0x000a }] */
    @Override // z1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int x() {
        /*
            r7 = this;
            z1.n r0 = r7.f13960q
            r0.a()
            z1.g r0 = r7.f13959p
            java.lang.Object r1 = r0.f13976a
            monitor-enter(r1)
            java.lang.IllegalStateException r2 = r0.f13988n     // Catch: java.lang.Throwable -> L2e
            r3 = 0
            if (r2 != 0) goto L58
            android.media.MediaCodec$CodecException r2 = r0.f13984j     // Catch: java.lang.Throwable -> L2e
            if (r2 != 0) goto L55
            android.media.MediaCodec$CryptoException r2 = r0.f13985k     // Catch: java.lang.Throwable -> L2e
            if (r2 != 0) goto L52
            long r2 = r0.f13986l     // Catch: java.lang.Throwable -> L2e
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r2 > 0) goto L28
            boolean r2 = r0.f13987m     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L26
            goto L28
        L26:
            r2 = r3
            goto L29
        L28:
            r2 = r4
        L29:
            r5 = -1
            if (r2 == 0) goto L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            return r5
        L2e:
            r0 = move-exception
            goto L5b
        L30:
            b4.p r0 = r0.f13979d     // Catch: java.lang.Throwable -> L2e
            int r2 = r0.f2378c     // Catch: java.lang.Throwable -> L2e
            int r6 = r0.f2379d     // Catch: java.lang.Throwable -> L2e
            if (r2 != r6) goto L39
            r3 = r4
        L39:
            if (r3 == 0) goto L3c
            goto L4a
        L3c:
            if (r2 == r6) goto L4c
            java.lang.Object r3 = r0.f2377b     // Catch: java.lang.Throwable -> L2e
            int[] r3 = (int[]) r3     // Catch: java.lang.Throwable -> L2e
            r5 = r3[r2]     // Catch: java.lang.Throwable -> L2e
            int r2 = r2 + r4
            int r3 = r0.f2380e     // Catch: java.lang.Throwable -> L2e
            r2 = r2 & r3
            r0.f2378c = r2     // Catch: java.lang.Throwable -> L2e
        L4a:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            return r5
        L4c:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            throw r0     // Catch: java.lang.Throwable -> L2e
        L52:
            r0.f13985k = r3     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L55:
            r0.f13984j = r3     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L58:
            r0.f13988n = r3     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L5b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.d.x():int");
    }
}
