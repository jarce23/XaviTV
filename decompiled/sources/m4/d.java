package m4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends g implements Animatable {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f8882u = 0;

    /* renamed from: q, reason: collision with root package name */
    public final Context f8884q;

    /* renamed from: r, reason: collision with root package name */
    public g9.l f8885r = null;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f8886s = null;

    /* renamed from: t, reason: collision with root package name */
    public final h.f f8887t = new h.f(this);

    /* renamed from: p, reason: collision with root package name */
    public final c f8883p = new c();

    public d(Context context, int i10) {
        this.f8884q = context;
    }

    @Override // m4.g, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        c cVar = this.f8883p;
        cVar.f8878a.draw(canvas);
        if (cVar.f8879b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getAlpha() : this.f8883p.f8878a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f8883p.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getColorFilter() : this.f8883p.f8878a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f8890o == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new e6.c(1, this.f8890o.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f8883p.f8878a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f8883p.f8878a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getOpacity() : this.f8883p.f8878a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0182, code lost:
    
        if (r8.f8879b != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0184, code lost:
    
        r8.f8879b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x018b, code lost:
    
        r8.f8879b.playTogether(r8.f8880c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0192, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r22, org.xmlpull.v1.XmlPullParser r23, android.util.AttributeSet r24, android.content.res.Resources.Theme r25) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.d.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.isAutoMirrored() : this.f8883p.f8878a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f8890o;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f8883p.f8879b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.isStateful() : this.f8883p.f8878a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f8883p.f8878a.setBounds(rect);
        }
    }

    @Override // m4.g, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i10) {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.setLevel(i10) : this.f8883p.f8878a.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.setState(iArr) : this.f8883p.f8878a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f8883p.f8878a.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setAutoMirrored(z10);
        } else {
            this.f8883p.f8878a.setAutoMirrored(z10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8883p.f8878a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            i7.e.z(drawable, i10);
        } else {
            this.f8883p.f8878a.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        } else {
            this.f8883p.f8878a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setTintMode(mode);
        } else {
            this.f8883p.f8878a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f8883p.f8878a.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        c cVar = this.f8883p;
        if (cVar.f8879b.isStarted()) {
            return;
        }
        cVar.f8879b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f8883p.f8879b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
