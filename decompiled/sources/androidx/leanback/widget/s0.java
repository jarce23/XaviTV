package androidx.leanback.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 extends ReplacementSpan {

    /* renamed from: o, reason: collision with root package name */
    public final int f1071o;

    /* renamed from: p, reason: collision with root package name */
    public final int f1072p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ t0 f1073q;

    public s0(t0 t0Var, int i10, int i11) {
        this.f1073q = t0Var;
        this.f1071o = i10;
        this.f1072p = i11;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        int measureText = (int) paint.measureText(charSequence, i10, i11);
        t0 t0Var = this.f1073q;
        int width = t0Var.f1082p.getWidth();
        int i15 = width * 2;
        int i16 = measureText / i15;
        int i17 = (measureText % i15) / 2;
        boolean z10 = 1 == t0Var.getLayoutDirection();
        t0Var.f1081o.setSeed(this.f1071o);
        int alpha = paint.getAlpha();
        for (int i18 = 0; i18 < i16 && this.f1072p + i18 < t0Var.f1084r; i18++) {
            float f11 = (width / 2) + (i18 * i15) + i17;
            float f12 = z10 ? ((f10 + measureText) - f11) - width : f10 + f11;
            paint.setAlpha((t0Var.f1081o.nextInt(4) + 1) * 63);
            if (t0Var.f1081o.nextBoolean()) {
                canvas.drawBitmap(t0Var.f1083q, f12, i13 - r13.getHeight(), paint);
            } else {
                canvas.drawBitmap(t0Var.f1082p, f12, i13 - r13.getHeight(), paint);
            }
        }
        paint.setAlpha(alpha);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        return (int) paint.measureText(charSequence, i10, i11);
    }
}
