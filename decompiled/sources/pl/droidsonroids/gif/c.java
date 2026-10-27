package pl.droidsonroids.gif;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.TypedValue;
import android.widget.MediaController;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    public final f.c A;
    public final e B;
    public final Rect C;
    public ScheduledFuture D;
    public final int E;
    public final int F;

    /* renamed from: o, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f10202o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f10203p;

    /* renamed from: q, reason: collision with root package name */
    public long f10204q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f10205r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f10206s;

    /* renamed from: t, reason: collision with root package name */
    public final Bitmap f10207t;

    /* renamed from: u, reason: collision with root package name */
    public final GifInfoHandle f10208u;

    /* renamed from: v, reason: collision with root package name */
    public final ConcurrentLinkedQueue f10209v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f10210w;

    /* renamed from: x, reason: collision with root package name */
    public PorterDuffColorFilter f10211x;

    /* renamed from: y, reason: collision with root package name */
    public PorterDuff.Mode f10212y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f10213z;

    public c(Resources resources, int i10) {
        this(new GifInfoHandle(resources.openRawResourceFd(i10)));
        TypedValue typedValue = new TypedValue();
        resources.getValue(i10, typedValue, true);
        int i11 = typedValue.density;
        if (i11 == 0) {
            i11 = 160;
        } else if (i11 == 65535) {
            i11 = 0;
        }
        int i12 = resources.getDisplayMetrics().densityDpi;
        float f10 = (i11 <= 0 || i12 <= 0) ? 1.0f : i12 / i11;
        this.F = (int) (this.f10208u.e() * f10);
        this.E = (int) (this.f10208u.j() * f10);
    }

    public final void a(long j10) {
        boolean z10 = this.f10213z;
        f.c cVar = this.A;
        if (z10) {
            this.f10204q = 0L;
            cVar.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        ScheduledFuture scheduledFuture = this.D;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        cVar.removeMessages(-1);
        this.D = this.f10202o.schedule(this.B, Math.max(j10, 0L), TimeUnit.MILLISECONDS);
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return this.f10208u.h() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return this.f10208u.h() > 1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z10;
        PorterDuffColorFilter porterDuffColorFilter = this.f10211x;
        Paint paint = this.f10206s;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f10211x);
            z10 = true;
        }
        canvas.drawBitmap(this.f10207t, this.C, this.f10205r, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f10206s.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f10206s.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.f10208u.c();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.f10208u.d();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.E;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return (!this.f10208u.k() || this.f10206s.getAlpha() < 255) ? -2 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        super.invalidateSelf();
        if (this.f10213z && this.f10203p) {
            long j10 = this.f10204q;
            if (j10 != Long.MIN_VALUE) {
                long max = Math.max(0L, j10 - SystemClock.uptimeMillis());
                this.f10204q = Long.MIN_VALUE;
                this.f10202o.remove(this.B);
                this.D = this.f10202o.schedule(this.B, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        return this.f10203p;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f10203p;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f10210w;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f10205r.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f10210w;
        if (colorStateList == null || (mode = this.f10212y) == null) {
            return false;
        }
        this.f10211x = b(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f10202o.execute(new b(this, this, i10));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f10206s.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f10206s.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z10) {
        this.f10206s.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z10) {
        this.f10206s.setFilterBitmap(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f10210w = colorStateList;
        this.f10211x = b(colorStateList, this.f10212y);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f10212y = mode;
        this.f10211x = b(this.f10210w, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (!this.f10213z) {
            if (z10) {
                if (z11) {
                    this.f10202o.execute(new a(this, this));
                }
                if (visible) {
                    start();
                    return visible;
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public final void start() {
        synchronized (this) {
            try {
                if (this.f10203p) {
                    return;
                }
                this.f10203p = true;
                a(this.f10208u.n());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        synchronized (this) {
            try {
                if (this.f10203p) {
                    this.f10203p = false;
                    ScheduledFuture scheduledFuture = this.D;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.A.removeMessages(-1);
                    this.f10208u.p();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        GifInfoHandle gifInfoHandle = this.f10208u;
        int j10 = gifInfoHandle.j();
        int e7 = gifInfoHandle.e();
        int h10 = gifInfoHandle.h();
        int g = gifInfoHandle.g();
        StringBuilder g6 = r.a.g("GIF: size: ", j10, "x", e7, ", frames: ");
        g6.append(h10);
        g6.append(", error: ");
        g6.append(g);
        return g6.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            r2 = this;
            int r0 = pl.droidsonroids.gif.GifInfoHandle.f10197b
            java.lang.String r0 = "file"
            java.lang.String r1 = r4.getScheme()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1e
            pl.droidsonroids.gif.GifInfoHandle r3 = new pl.droidsonroids.gif.GifInfoHandle
            java.lang.String r4 = r4.getPath()
            r3.<init>()
            long r0 = pl.droidsonroids.gif.GifInfoHandle.openFile(r4)
            r3.f10198a = r0
            goto L2c
        L1e:
            java.lang.String r0 = "r"
            android.content.res.AssetFileDescriptor r3 = r3.openAssetFileDescriptor(r4, r0)
            if (r3 == 0) goto L30
            pl.droidsonroids.gif.GifInfoHandle r4 = new pl.droidsonroids.gif.GifInfoHandle
            r4.<init>(r3)
            r3 = r4
        L2c:
            r2.<init>(r3)
            return
        L30:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not open AssetFileDescriptor for "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.c.<init>(android.content.ContentResolver, android.net.Uri):void");
    }

    public c(GifInfoHandle gifInfoHandle) {
        this.f10203p = true;
        this.f10204q = Long.MIN_VALUE;
        this.f10205r = new Rect();
        this.f10206s = new Paint(6);
        this.f10209v = new ConcurrentLinkedQueue();
        e eVar = new e(this);
        this.B = eVar;
        this.f10213z = true;
        int i10 = ub.c.f12573o;
        this.f10202o = ub.b.f12572a;
        this.f10208u = gifInfoHandle;
        Bitmap createBitmap = Bitmap.createBitmap(gifInfoHandle.j(), gifInfoHandle.e(), Bitmap.Config.ARGB_8888);
        this.f10207t = createBitmap;
        createBitmap.setHasAlpha(true ^ gifInfoHandle.k());
        this.C = new Rect(0, 0, gifInfoHandle.j(), gifInfoHandle.e());
        this.A = new f.c(this);
        eVar.a();
        this.E = gifInfoHandle.j();
        this.F = gifInfoHandle.e();
    }
}
