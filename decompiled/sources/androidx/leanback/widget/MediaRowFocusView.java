package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class MediaRowFocusView extends View {

    /* renamed from: o, reason: collision with root package name */
    public final Paint f919o;

    /* renamed from: p, reason: collision with root package name */
    public final RectF f920p;

    /* renamed from: q, reason: collision with root package name */
    public int f921q;

    public MediaRowFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f920p = new RectF();
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.lb_playback_media_row_highlight_color));
        this.f919o = paint;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        this.f921q = height;
        int height2 = ((height * 2) - getHeight()) / 2;
        float f10 = -height2;
        float width = getWidth();
        float height3 = getHeight() + height2;
        RectF rectF = this.f920p;
        rectF.set(0.0f, f10, width, height3);
        int i10 = this.f921q;
        canvas.drawRoundRect(rectF, i10, i10, this.f919o);
    }
}
