package u5;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import j9.w1;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import m6.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements a {

    /* renamed from: x, reason: collision with root package name */
    public static final Bitmap.Config f12539x = Bitmap.Config.ARGB_8888;

    /* renamed from: o, reason: collision with root package name */
    public final k f12540o;

    /* renamed from: p, reason: collision with root package name */
    public final Set f12541p;

    /* renamed from: q, reason: collision with root package name */
    public final w1 f12542q;

    /* renamed from: r, reason: collision with root package name */
    public final long f12543r;

    /* renamed from: s, reason: collision with root package name */
    public long f12544s;

    /* renamed from: t, reason: collision with root package name */
    public int f12545t;

    /* renamed from: u, reason: collision with root package name */
    public int f12546u;

    /* renamed from: v, reason: collision with root package name */
    public int f12547v;

    /* renamed from: w, reason: collision with root package name */
    public int f12548w;

    public g(long j10) {
        Bitmap.Config config;
        k kVar = new k();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f12543r = j10;
        this.f12540o = kVar;
        this.f12541p = unmodifiableSet;
        this.f12542q = new w1(20);
    }

    public final void a() {
        Log.v("LruBitmapPool", "Hits=" + this.f12545t + ", misses=" + this.f12546u + ", puts=" + this.f12547v + ", evictions=" + this.f12548w + ", currentSize=" + this.f12544s + ", maxSize=" + this.f12543r + "\nStrategy=" + this.f12540o);
    }

    @Override // u5.a
    public final Bitmap b(int i10, int i11, Bitmap.Config config) {
        Bitmap c10 = c(i10, i11, config);
        if (c10 != null) {
            return c10;
        }
        if (config == null) {
            config = f12539x;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public final synchronized Bitmap c(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap b2;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                config2 = Bitmap.Config.HARDWARE;
                if (config == config2) {
                    throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                }
            }
            b2 = this.f12540o.b(i10, i11, config != null ? config : f12539x);
            if (b2 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb2 = new StringBuilder("Missing bitmap=");
                    this.f12540o.getClass();
                    sb2.append(k.c(n.d(config) * i10 * i11, config));
                    Log.d("LruBitmapPool", sb2.toString());
                }
                this.f12546u++;
            } else {
                this.f12545t++;
                long j10 = this.f12544s;
                this.f12540o.getClass();
                this.f12544s = j10 - n.c(b2);
                this.f12542q.getClass();
                b2.setHasAlpha(true);
                b2.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb3 = new StringBuilder("Get bitmap=");
                this.f12540o.getClass();
                sb3.append(k.c(n.d(config) * i10 * i11, config));
                Log.v("LruBitmapPool", sb3.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b2;
    }

    public final synchronized void d(long j10) {
        while (this.f12544s > j10) {
            try {
                k kVar = this.f12540o;
                Bitmap bitmap = (Bitmap) kVar.f12558b.c0();
                if (bitmap != null) {
                    kVar.a(Integer.valueOf(n.c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        a();
                    }
                    this.f12544s = 0L;
                    return;
                }
                this.f12542q.getClass();
                long j11 = this.f12544s;
                this.f12540o.getClass();
                this.f12544s = j11 - n.c(bitmap);
                this.f12548w++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Evicting bitmap=");
                    this.f12540o.getClass();
                    sb2.append(k.c(n.c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb2.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    a();
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // u5.a
    public final Bitmap e(int i10, int i11, Bitmap.Config config) {
        Bitmap c10 = c(i10, i11, config);
        if (c10 != null) {
            c10.eraseColor(0);
            return c10;
        }
        if (config == null) {
            config = f12539x;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // u5.a
    public final synchronized void g(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f12540o.getClass();
                if (n.c(bitmap) <= this.f12543r && this.f12541p.contains(bitmap.getConfig())) {
                    this.f12540o.getClass();
                    int c10 = n.c(bitmap);
                    this.f12540o.e(bitmap);
                    this.f12542q.getClass();
                    this.f12547v++;
                    this.f12544s += c10;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder("Put bitmap in pool=");
                        this.f12540o.getClass();
                        sb2.append(k.c(n.c(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        a();
                    }
                    d(this.f12543r);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb3 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f12540o.getClass();
                sb3.append(k.c(n.c(bitmap), bitmap.getConfig()));
                sb3.append(", is mutable: ");
                sb3.append(bitmap.isMutable());
                sb3.append(", is allowed config: ");
                sb3.append(this.f12541p.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb3.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // u5.a
    public final void k(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || i10 >= 20) {
            m();
        } else if (i10 >= 20 || i10 == 15) {
            d(this.f12543r / 2);
        }
    }

    @Override // u5.a
    public final void m() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        d(0L);
    }
}
