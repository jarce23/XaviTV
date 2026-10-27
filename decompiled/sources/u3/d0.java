package u3;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* renamed from: a, reason: collision with root package name */
    public final float f12377a;

    /* renamed from: b, reason: collision with root package name */
    public final float f12378b;

    /* renamed from: c, reason: collision with root package name */
    public final float f12379c;

    /* renamed from: d, reason: collision with root package name */
    public final float f12380d;

    /* renamed from: e, reason: collision with root package name */
    public final float f12381e;

    /* renamed from: f, reason: collision with root package name */
    public final TextPaint f12382f;
    public final Paint g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f12383h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f12384i;

    /* renamed from: j, reason: collision with root package name */
    public Layout.Alignment f12385j;

    /* renamed from: k, reason: collision with root package name */
    public Bitmap f12386k;

    /* renamed from: l, reason: collision with root package name */
    public float f12387l;

    /* renamed from: m, reason: collision with root package name */
    public int f12388m;

    /* renamed from: n, reason: collision with root package name */
    public int f12389n;

    /* renamed from: o, reason: collision with root package name */
    public float f12390o;

    /* renamed from: p, reason: collision with root package name */
    public int f12391p;

    /* renamed from: q, reason: collision with root package name */
    public float f12392q;

    /* renamed from: r, reason: collision with root package name */
    public float f12393r;

    /* renamed from: s, reason: collision with root package name */
    public int f12394s;

    /* renamed from: t, reason: collision with root package name */
    public int f12395t;

    /* renamed from: u, reason: collision with root package name */
    public int f12396u;

    /* renamed from: v, reason: collision with root package name */
    public int f12397v;

    /* renamed from: w, reason: collision with root package name */
    public int f12398w;

    /* renamed from: x, reason: collision with root package name */
    public float f12399x;

    /* renamed from: y, reason: collision with root package name */
    public float f12400y;

    /* renamed from: z, reason: collision with root package name */
    public float f12401z;

    public d0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f12381e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f12380d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f12377a = round;
        this.f12378b = round;
        this.f12379c = round;
        TextPaint textPaint = new TextPaint();
        this.f12382f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12383h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z10) {
        Canvas canvas2;
        if (!z10) {
            this.J.getClass();
            this.f12386k.getClass();
            canvas.drawBitmap(this.f12386k, (Rect) null, this.J, this.f12383h);
            return;
        }
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f12396u) > 0) {
            int i10 = this.f12396u;
            Paint paint = this.g;
            paint.setColor(i10);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        int i11 = this.f12398w;
        TextPaint textPaint = this.f12382f;
        if (i11 == 1) {
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStrokeWidth(this.f12377a);
            textPaint.setColor(this.f12397v);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else {
            float f10 = this.f12378b;
            if (i11 == 2) {
                float f11 = this.f12379c;
                textPaint.setShadowLayer(f10, f11, f11, this.f12397v);
            } else if (i11 == 3 || i11 == 4) {
                boolean z11 = i11 == 3;
                int i12 = z11 ? -1 : this.f12397v;
                int i13 = z11 ? this.f12397v : -1;
                float f12 = f10 / 2.0f;
                textPaint.setColor(this.f12394s);
                textPaint.setStyle(Paint.Style.FILL);
                float f13 = -f12;
                textPaint.setShadowLayer(f10, f13, f13, i12);
                staticLayout2.draw(canvas2);
                textPaint.setShadowLayer(f10, f12, f12, i13);
            }
        }
        textPaint.setColor(this.f12394s);
        textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(save);
    }
}
