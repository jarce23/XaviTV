package h;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements Drawable.Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5513o = 0;

    /* renamed from: p, reason: collision with root package name */
    public Object f5514p;

    public /* synthetic */ f() {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f5513o) {
            case 0:
                break;
            default:
                ((m4.d) this.f5514p).invalidateSelf();
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        switch (this.f5513o) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f5514p;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j10);
                    break;
                }
                break;
            default:
                ((m4.d) this.f5514p).scheduleSelf(runnable, j10);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f5513o) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f5514p;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                    break;
                }
                break;
            default:
                ((m4.d) this.f5514p).unscheduleSelf(runnable);
                break;
        }
    }

    public f(m4.d dVar) {
        this.f5514p = dVar;
    }

    private final void a(Drawable drawable) {
    }
}
