package androidx.mediarouter.app;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatSeekBar;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class MediaRouteVolumeSlider extends AppCompatSeekBar {

    /* renamed from: p, reason: collision with root package name */
    public final float f1256p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1257q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f1258r;

    /* renamed from: s, reason: collision with root package name */
    public int f1259s;

    /* renamed from: t, reason: collision with root package name */
    public int f1260t;

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1256p = i7.e.k(context);
    }

    public final void a(int i10, int i11) {
        if (this.f1259s != i10) {
            if (Color.alpha(i10) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(i10));
            }
            this.f1259s = i10;
        }
        if (this.f1260t != i11) {
            if (Color.alpha(i11) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(i11));
            }
            this.f1260t = i11;
        }
    }

    public final void b(boolean z10) {
        if (this.f1257q == z10) {
            return;
        }
        this.f1257q = z10;
        super.setThumb(z10 ? null : this.f1258r);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int i10 = isEnabled() ? 255 : (int) (this.f1256p * 255.0f);
        Drawable drawable = this.f1258r;
        int i11 = this.f1259s;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        drawable.setColorFilter(i11, mode);
        this.f1258r.setAlpha(i10);
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) getProgressDrawable();
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.progress);
            layerDrawable.findDrawableByLayerId(R.id.background).setColorFilter(this.f1260t, mode);
            progressDrawable = findDrawableByLayerId;
        }
        progressDrawable.setColorFilter(this.f1259s, mode);
        progressDrawable.setAlpha(i10);
    }

    @Override // android.widget.AbsSeekBar
    public final void setThumb(Drawable drawable) {
        this.f1258r = drawable;
        if (this.f1257q) {
            drawable = null;
        }
        super.setThumb(drawable);
    }
}
