package h;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.activity.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int H = 0;
    public b A;
    public boolean B;
    public b C;
    public com.bumptech.glide.e D;
    public boolean G;

    /* renamed from: o, reason: collision with root package name */
    public b f5501o;

    /* renamed from: p, reason: collision with root package name */
    public Rect f5502p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f5503q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f5504r;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5506t;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5508v;

    /* renamed from: w, reason: collision with root package name */
    public j f5509w;

    /* renamed from: x, reason: collision with root package name */
    public long f5510x;

    /* renamed from: y, reason: collision with root package name */
    public long f5511y;

    /* renamed from: z, reason: collision with root package name */
    public f f5512z;

    /* renamed from: s, reason: collision with root package name */
    public int f5505s = 255;

    /* renamed from: u, reason: collision with root package name */
    public int f5507u = -1;
    public int E = -1;
    public int F = -1;

    public e(b bVar, Resources resources) {
        i(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0272, code lost:
    
        r5.onStateChange(r5.getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0279, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static h.e c(android.content.Context r24, android.content.res.Resources r25, android.content.res.XmlResourceParser r26, android.util.AttributeSet r27, android.content.res.Resources.Theme r28) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e.c(android.content.Context, android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):h.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f5506t = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f5503q
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L36
            long r9 = r13.f5510x
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f5505s
            r3.setAlpha(r9)
            r13.f5510x = r6
            goto L38
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            h.b r10 = r13.f5501o
            int r10 = r10.f5494y
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f5505s
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L39
        L36:
            r13.f5510x = r6
        L38:
            r3 = r8
        L39:
            android.graphics.drawable.Drawable r9 = r13.f5504r
            if (r9 == 0) goto L61
            long r10 = r13.f5511y
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f5504r = r0
            r13.f5511y = r6
            goto L63
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            h.b r4 = r13.f5501o
            int r4 = r4.f5495z
            int r3 = r3 / r4
            int r4 = r13.f5505s
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.f5511y = r6
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            androidx.activity.j r14 = r13.f5509w
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        b(theme);
        onStateChange(getState());
    }

    public final void b(Resources.Theme theme) {
        b bVar = this.f5501o;
        if (theme == null) {
            bVar.getClass();
            return;
        }
        bVar.c();
        int i10 = bVar.f5477h;
        Drawable[] drawableArr = bVar.g;
        for (int i11 = 0; i11 < i10; i11++) {
            Drawable drawable = drawableArr[i11];
            if (drawable != null && drawable.canApplyTheme()) {
                drawableArr[i11].applyTheme(theme);
                bVar.f5475e |= drawableArr[i11].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            bVar.f5472b = resources;
            int i12 = resources.getDisplayMetrics().densityDpi;
            if (i12 == 0) {
                i12 = 160;
            }
            int i13 = bVar.f5473c;
            bVar.f5473c = i12;
            if (i13 != i12) {
                bVar.f5482m = false;
                bVar.f5479j = false;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.f5501o.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        if (this.f5512z == null) {
            this.f5512z = new f();
        }
        f fVar = this.f5512z;
        fVar.f5514p = drawable.getCallback();
        drawable.setCallback(fVar);
        try {
            if (this.f5501o.f5494y <= 0 && this.f5506t) {
                drawable.setAlpha(this.f5505s);
            }
            b bVar = this.f5501o;
            if (bVar.C) {
                drawable.setColorFilter(bVar.B);
            } else {
                if (bVar.F) {
                    drawable.setTintList(bVar.D);
                }
                b bVar2 = this.f5501o;
                if (bVar2.G) {
                    drawable.setTintMode(bVar2.E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f5501o.f5492w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.f5501o.A);
            Rect rect = this.f5502p;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
            f fVar2 = this.f5512z;
            Drawable.Callback callback = (Drawable.Callback) fVar2.f5514p;
            fVar2.f5514p = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            f fVar3 = this.f5512z;
            Drawable.Callback callback2 = (Drawable.Callback) fVar3.f5514p;
            fVar3.f5514p = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f5504r;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final void e() {
        boolean z10;
        Drawable drawable = this.f5504r;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f5504r = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f5503q;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f5506t) {
                this.f5503q.setAlpha(this.f5505s);
            }
        }
        if (this.f5511y != 0) {
            this.f5511y = 0L;
            z10 = true;
        }
        if (this.f5510x != 0) {
            this.f5510x = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public final Drawable f() {
        if (!this.f5508v && super.mutate() == this) {
            b bVar = new b(this.C, this, null);
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            i(bVar);
            this.f5508v = true;
        }
        return this;
    }

    public final Drawable g() {
        if (!this.B) {
            f();
            b bVar = this.A;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.B = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f5505s;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f5501o.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z10;
        b bVar = this.f5501o;
        if (!bVar.f5490u) {
            bVar.c();
            bVar.f5490u = true;
            int i10 = bVar.f5477h;
            Drawable[] drawableArr = bVar.g;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    bVar.f5491v = true;
                    z10 = true;
                    break;
                }
                if (drawableArr[i11].getConstantState() == null) {
                    bVar.f5491v = false;
                    z10 = false;
                    break;
                }
                i11++;
            }
        } else {
            z10 = bVar.f5491v;
        }
        if (!z10) {
            return null;
        }
        this.f5501o.f5474d = getChangingConfigurations();
        return this.f5501o;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f5503q;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f5502p;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        b bVar = this.f5501o;
        if (bVar.f5481l) {
            if (!bVar.f5482m) {
                bVar.b();
            }
            return bVar.f5484o;
        }
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        b bVar = this.f5501o;
        if (bVar.f5481l) {
            if (!bVar.f5482m) {
                bVar.b();
            }
            return bVar.f5483n;
        }
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        b bVar = this.f5501o;
        if (bVar.f5481l) {
            if (!bVar.f5482m) {
                bVar.b();
            }
            return bVar.f5486q;
        }
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        b bVar = this.f5501o;
        if (bVar.f5481l) {
            if (!bVar.f5482m) {
                bVar.b();
            }
            return bVar.f5485p;
        }
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f5503q;
        if (drawable != null && drawable.isVisible()) {
            b bVar = this.f5501o;
            if (bVar.f5487r) {
                return bVar.f5488s;
            }
            bVar.c();
            int i10 = bVar.f5477h;
            Drawable[] drawableArr = bVar.g;
            r1 = i10 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i11 = 1; i11 < i10; i11++) {
                r1 = Drawable.resolveOpacity(r1, drawableArr[i11].getOpacity());
            }
            bVar.f5488s = r1;
            bVar.f5487r = true;
        }
        return r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        b bVar = this.f5501o;
        Rect rect2 = null;
        boolean z10 = false;
        if (!bVar.f5478i) {
            Rect rect3 = bVar.f5480k;
            if (rect3 != null || bVar.f5479j) {
                rect2 = rect3;
            } else {
                bVar.c();
                Rect rect4 = new Rect();
                int i10 = bVar.f5477h;
                Drawable[] drawableArr = bVar.g;
                for (int i11 = 0; i11 < i10; i11++) {
                    if (drawableArr[i11].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i12 = rect4.left;
                        if (i12 > rect2.left) {
                            rect2.left = i12;
                        }
                        int i13 = rect4.top;
                        if (i13 > rect2.top) {
                            rect2.top = i13;
                        }
                        int i14 = rect4.right;
                        if (i14 > rect2.right) {
                            rect2.right = i14;
                        }
                        int i15 = rect4.bottom;
                        if (i15 > rect2.bottom) {
                            rect2.bottom = i15;
                        }
                    }
                }
                bVar.f5479j = true;
                bVar.f5480k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                z10 = true;
            }
        } else {
            Drawable drawable = this.f5503q;
            z10 = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f5501o.A && getLayoutDirection() == 1) {
            int i16 = rect.left;
            rect.left = rect.right;
            rect.right = i16;
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(int r10) {
        /*
            r9 = this;
            int r0 = r9.f5507u
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            h.b r0 = r9.f5501o
            int r0 = r0.f5495z
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f5504r
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f5503q
            if (r0 == 0) goto L29
            r9.f5504r = r0
            h.b r0 = r9.f5501o
            int r0 = r0.f5495z
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f5511y = r0
            goto L35
        L29:
            r9.f5504r = r4
            r9.f5511y = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f5503q
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            h.b r0 = r9.f5501o
            int r1 = r0.f5477h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.d(r10)
            r9.f5503q = r0
            r9.f5507u = r10
            if (r0 == 0) goto L5a
            h.b r10 = r9.f5501o
            int r10 = r10.f5494y
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f5510x = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f5503q = r4
            r10 = -1
            r9.f5507u = r10
        L5a:
            long r0 = r9.f5510x
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.f5511y
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L7b
        L67:
            androidx.activity.j r10 = r9.f5509w
            if (r10 != 0) goto L75
            androidx.activity.j r10 = new androidx.activity.j
            r1 = 17
            r10.<init>(r1, r9)
            r9.f5509w = r10
            goto L78
        L75:
            r9.unscheduleSelf(r10)
        L78:
            r9.a(r0)
        L7b:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e.h(int):boolean");
    }

    public final void i(b bVar) {
        this.f5501o = bVar;
        int i10 = this.f5507u;
        if (i10 >= 0) {
            Drawable d6 = bVar.d(i10);
            this.f5503q = d6;
            if (d6 != null) {
                d(d6);
            }
        }
        this.f5504r = null;
        this.A = bVar;
        this.C = bVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        b bVar = this.f5501o;
        if (bVar != null) {
            bVar.f5487r = false;
            bVar.f5489t = false;
        }
        if (drawable != this.f5503q || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f5501o.A;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    public final boolean j(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f5504r;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f5503q;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        e();
        com.bumptech.glide.e eVar = this.D;
        if (eVar != null) {
            eVar.w();
            this.D = null;
            h(this.E);
            this.E = -1;
            this.F = -1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.G) {
            g();
            b bVar = this.C;
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            this.G = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5504r;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f5503q;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i10) {
        b bVar = this.f5501o;
        int i11 = this.f5507u;
        int i12 = bVar.f5477h;
        Drawable[] drawableArr = bVar.g;
        boolean z10 = false;
        for (int i13 = 0; i13 < i12; i13++) {
            Drawable drawable = drawableArr[i13];
            if (drawable != null) {
                boolean layoutDirection = drawable.setLayoutDirection(i10);
                if (i13 == i11) {
                    z10 = layoutDirection;
                }
            }
        }
        bVar.f5493x = i10;
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i10) {
        Drawable drawable = this.f5504r;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f5503q;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        if (h(r1) != false) goto L45;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStateChange(int[] r15) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e.onStateChange(int[]):boolean");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable != this.f5503q || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        if (this.f5506t && this.f5505s == i10) {
            return;
        }
        this.f5506t = true;
        this.f5505s = i10;
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            if (this.f5510x == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z10) {
        b bVar = this.f5501o;
        if (bVar.A != z10) {
            bVar.A = z10;
            Drawable drawable = this.f5503q;
            if (drawable != null) {
                drawable.setAutoMirrored(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        b bVar = this.f5501o;
        bVar.C = true;
        if (bVar.B != colorFilter) {
            bVar.B = colorFilter;
            Drawable drawable = this.f5503q;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z10) {
        b bVar = this.f5501o;
        if (bVar.f5492w != z10) {
            bVar.f5492w = z10;
            Drawable drawable = this.f5503q;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f10, float f11) {
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f5502p;
        if (rect == null) {
            this.f5502p = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f5503q;
        if (drawable != null) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        b bVar = this.f5501o;
        bVar.F = true;
        if (bVar.D != colorStateList) {
            bVar.D = colorStateList;
            this.f5503q.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f5501o;
        bVar.G = true;
        if (bVar.E != mode) {
            bVar.E = mode;
            this.f5503q.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        boolean j10 = j(z10, z11);
        com.bumptech.glide.e eVar = this.D;
        if (eVar != null && (j10 || z11)) {
            if (z10) {
                eVar.v();
                return j10;
            }
            jumpToCurrentState();
        }
        return j10;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f5503q || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
