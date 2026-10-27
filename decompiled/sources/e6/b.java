package e6;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements r5.j {

    /* renamed from: f, reason: collision with root package name */
    public static final d9.f f4621f = new d9.f(17);
    public static final a g = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final Context f4622a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4623b;

    /* renamed from: e, reason: collision with root package name */
    public final j5.g f4626e;

    /* renamed from: d, reason: collision with root package name */
    public final d9.f f4625d = f4621f;

    /* renamed from: c, reason: collision with root package name */
    public final a f4624c = g;

    public b(Context context, ArrayList arrayList, u5.a aVar, u5.f fVar) {
        this.f4622a = context.getApplicationContext();
        this.f4623b = arrayList;
        this.f4626e = new j5.g(aVar, fVar);
    }

    public static int d(p5.b bVar, int i10, int i11) {
        int min = Math.min(bVar.g / i11, bVar.f9993f / i10);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder g6 = r.a.g("Downsampling GIF, sampleSize: ", max, ", target dimens: [", i10, "x");
            g6.append(i11);
            g6.append("], actual dimens: [");
            g6.append(bVar.f9993f);
            g6.append("x");
            g6.append(bVar.g);
            g6.append("]");
            Log.v("BufferGifDecoder", g6.toString());
        }
        return max;
    }

    @Override // r5.j
    public final boolean a(Object obj, r5.h hVar) {
        return !((Boolean) hVar.c(j.f4665b)).booleanValue() && com.bumptech.glide.f.m(this.f4623b, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // r5.j
    public final t5.y b(java.lang.Object r8, int r9, int r10, r5.h r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            e6.a r8 = r7.f4624c
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.f4620a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            p5.c r0 = (p5.c) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            p5.c r0 = new p5.c     // Catch: java.lang.Throwable -> L17
            r0.<init>()     // Catch: java.lang.Throwable -> L17
        L15:
            r5 = r0
            goto L1b
        L17:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L57
        L1b:
            r0 = 0
            r5.f9999b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.f9998a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            p5.b r0 = new p5.b     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.f10000c = r0     // Catch: java.lang.Throwable -> L54
            r5.f10001d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.f9999b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.f9999b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            c6.b r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            e6.a r9 = r1.f4624c
            r9.c(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            e6.a r9 = r1.f4624c
            r9.c(r5)
            throw r8
        L54:
            r0 = move-exception
            r1 = r7
        L56:
            r9 = r0
        L57:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L59
            throw r9
        L59:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.b.b(java.lang.Object, int, int, r5.h):t5.y");
    }

    public final c6.b c(ByteBuffer byteBuffer, int i10, int i11, p5.c cVar, r5.h hVar) {
        StringBuilder sb2;
        int i12 = m6.h.f9016b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            p5.b b2 = cVar.b();
            c6.b bVar = null;
            if (b2.f9990c > 0 && b2.f9989b == 0) {
                Bitmap.Config config = hVar.c(j.f4664a) == r5.a.f10785p ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int d6 = d(b2, i10, i11);
                d9.f fVar = this.f4625d;
                j5.g gVar = this.f4626e;
                fVar.getClass();
                p5.d dVar = new p5.d(gVar, b2, byteBuffer, d6);
                dVar.c(config);
                dVar.f10011k = (dVar.f10011k + 1) % dVar.f10012l.f9990c;
                Bitmap b10 = dVar.b();
                if (b10 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb2 = new StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                bVar = new c6.b(new d(new c(0, new i(com.bumptech.glide.b.a(this.f4622a), dVar, i10, i11, b10))), 1);
                if (!Log.isLoggable("BufferGifDecoder", 2)) {
                    return bVar;
                }
                sb2 = new StringBuilder("Decoded GIF from stream in ");
                sb2.append(m6.h.a(elapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb2.toString());
                return bVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb2 = new StringBuilder("Decoded GIF from stream in ");
                sb2.append(m6.h.a(elapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb2.toString());
                return bVar;
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + m6.h.a(elapsedRealtimeNanos));
            }
            throw th;
        }
    }
}
