package a6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: f, reason: collision with root package name */
    public static final r5.g f91f = r5.g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", r5.a.f10786q);
    public static final r5.g g = new r5.g("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, r5.g.f10790e);

    /* renamed from: h, reason: collision with root package name */
    public static final r5.g f92h;

    /* renamed from: i, reason: collision with root package name */
    public static final r5.g f93i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set f94j;

    /* renamed from: k, reason: collision with root package name */
    public static final d9.f f95k;

    /* renamed from: l, reason: collision with root package name */
    public static final ArrayDeque f96l;

    /* renamed from: a, reason: collision with root package name */
    public final u5.a f97a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f98b;

    /* renamed from: c, reason: collision with root package name */
    public final u5.f f99c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f100d;

    /* renamed from: e, reason: collision with root package name */
    public final b0 f101e = b0.a();

    static {
        p pVar = p.f84b;
        Boolean bool = Boolean.FALSE;
        f92h = r5.g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f93i = r5.g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f94j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f95k = new d9.f(2);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = m6.n.f9027a;
        f96l = new ArrayDeque(0);
    }

    public s(ArrayList arrayList, DisplayMetrics displayMetrics, u5.a aVar, u5.f fVar) {
        this.f100d = arrayList;
        m6.f.c("Argument must not be null", displayMetrics);
        this.f98b = displayMetrics;
        m6.f.c("Argument must not be null", aVar);
        this.f97a = aVar;
        m6.f.c("Argument must not be null", fVar);
        this.f99c = fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap c(a6.c0 r9, android.graphics.BitmapFactory.Options r10, a6.r r11, u5.a r12) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r10.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r11.A()
            r9.n()
        Lc:
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            java.lang.String r3 = r10.outMimeType
            java.util.concurrent.locks.Lock r4 = a6.g0.f60b
            r4.lock()
            android.graphics.Bitmap r9 = r9.e(r10)     // Catch: java.lang.IllegalArgumentException -> L1f java.lang.Throwable -> L66
            r4.unlock()
            return r9
        L1f:
            r4 = move-exception
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            java.lang.String r7 = ", outHeight: "
            java.lang.String r8 = ", outMimeType: "
            java.lang.StringBuilder r1 = r.a.g(r6, r1, r7, r2, r8)     // Catch: java.lang.Throwable -> L66
            r1.append(r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = ", inBitmap: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L66
            android.graphics.Bitmap r2 = r10.inBitmap     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = d(r2)     // Catch: java.lang.Throwable -> L66
            r1.append(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L66
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L66
            if (r1 == 0) goto L50
            java.lang.String r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r1, r5)     // Catch: java.lang.Throwable -> L66
        L50:
            android.graphics.Bitmap r0 = r10.inBitmap     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L65
            r12.g(r0)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            r0 = 0
            r10.inBitmap = r0     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            android.graphics.Bitmap r9 = c(r9, r10, r11, r12)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            java.util.concurrent.locks.Lock r10 = a6.g0.f60b
            r10.unlock()
            return r9
        L64:
            throw r5     // Catch: java.lang.Throwable -> L66
        L65:
            throw r5     // Catch: java.lang.Throwable -> L66
        L66:
            r9 = move-exception
            java.util.concurrent.locks.Lock r10 = a6.g0.f60b
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.s.c(a6.c0, android.graphics.BitmapFactory$Options, a6.r, u5.a):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options options) {
        f(options);
        ArrayDeque arrayDeque = f96l;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final e a(c0 c0Var, int i10, int i11, r5.h hVar, r rVar) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.f99c.d(65536, byte[].class);
        synchronized (s.class) {
            ArrayDeque arrayDeque = f96l;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                f(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        r5.a aVar = (r5.a) hVar.c(f91f);
        r5.i iVar = (r5.i) hVar.c(g);
        p pVar = (p) hVar.c(p.g);
        boolean booleanValue = ((Boolean) hVar.c(f92h)).booleanValue();
        r5.g gVar = f93i;
        try {
            return e.b(b(c0Var, options2, pVar, aVar, iVar, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), i10, i11, booleanValue, rVar), this.f97a);
        } finally {
            e(options2);
            this.f99c.h(bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0200 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0419  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(a6.c0 r40, android.graphics.BitmapFactory.Options r41, a6.p r42, r5.a r43, r5.i r44, boolean r45, int r46, int r47, boolean r48, a6.r r49) {
        /*
            Method dump skipped, instructions count: 1408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.s.b(a6.c0, android.graphics.BitmapFactory$Options, a6.p, r5.a, r5.i, boolean, int, int, boolean, a6.r):android.graphics.Bitmap");
    }
}
