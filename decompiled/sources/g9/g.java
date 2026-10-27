package g9;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends d9.j {
    public static final /* synthetic */ int V = 0;
    public f U;

    @Override // d9.j
    public final void f(Canvas canvas) {
        if (this.U.f5343r.isEmpty()) {
            super.f(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.U.f5343r);
        } else {
            canvas.clipRect(this.U.f5343r, Region.Op.DIFFERENCE);
        }
        super.f(canvas);
        canvas.restore();
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.U = new f(this.U);
        return this;
    }

    public final void t(float f10, float f11, float f12, float f13) {
        RectF rectF = this.U.f5343r;
        if (f10 == rectF.left && f11 == rectF.top && f12 == rectF.right && f13 == rectF.bottom) {
            return;
        }
        rectF.set(f10, f11, f12, f13);
        invalidateSelf();
    }
}
