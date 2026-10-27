package y9;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends Drawable {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f13910u = 0;

    /* renamed from: a, reason: collision with root package name */
    public final RectF f13911a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f13912b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    public final RectF f13913c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f13914d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f13915e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13916f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f13917h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f13918i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f13919j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f13920k;

    /* renamed from: l, reason: collision with root package name */
    public Shader.TileMode f13921l;

    /* renamed from: m, reason: collision with root package name */
    public Shader.TileMode f13922m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13923n;

    /* renamed from: o, reason: collision with root package name */
    public float f13924o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean[] f13925p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13926q;

    /* renamed from: r, reason: collision with root package name */
    public float f13927r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f13928s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView.ScaleType f13929t;

    public c(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f13913c = rectF;
        this.f13917h = new RectF();
        this.f13919j = new Matrix();
        this.f13920k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f13921l = tileMode;
        this.f13922m = tileMode;
        this.f13923n = true;
        this.f13924o = 0.0f;
        this.f13925p = new boolean[]{true, true, true, true};
        this.f13926q = false;
        this.f13927r = 0.0f;
        this.f13928s = ColorStateList.valueOf(-16777216);
        this.f13929t = ImageView.ScaleType.FIT_CENTER;
        this.f13914d = bitmap;
        int width = bitmap.getWidth();
        this.f13916f = width;
        int height = bitmap.getHeight();
        this.g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f13915e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f13918i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f13928s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f13927r);
    }

    public static Drawable a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return drawable;
        }
        if (drawable instanceof c) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i10 = 0; i10 < numberOfLayers; i10++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i10), a(layerDrawable.getDrawable(i10)));
            }
            return layerDrawable;
        }
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            try {
                bitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            } catch (Exception e7) {
                e7.printStackTrace();
                Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
                bitmap = null;
            }
        }
        return bitmap != null ? new c(bitmap) : drawable;
    }

    public final void b(Canvas canvas) {
        boolean[] zArr = this.f13925p;
        for (boolean z10 : zArr) {
            if (z10) {
                if (this.f13924o == 0.0f) {
                    return;
                }
                RectF rectF = this.f13912b;
                float f10 = rectF.left;
                float f11 = rectF.top;
                float width = rectF.width() + f10;
                float height = rectF.height() + f11;
                float f12 = this.f13924o;
                boolean z11 = zArr[0];
                Paint paint = this.f13915e;
                RectF rectF2 = this.f13920k;
                if (!z11) {
                    rectF2.set(f10, f11, f10 + f12, f11 + f12);
                    canvas.drawRect(rectF2, paint);
                }
                if (!zArr[1]) {
                    rectF2.set(width - f12, f11, width, f12);
                    canvas.drawRect(rectF2, paint);
                }
                if (!zArr[2]) {
                    rectF2.set(width - f12, height - f12, width, height);
                    canvas.drawRect(rectF2, paint);
                }
                if (zArr[3]) {
                    return;
                }
                rectF2.set(f10, height - f12, f12 + f10, height);
                canvas.drawRect(rectF2, paint);
                return;
            }
        }
    }

    public final void c() {
        float width;
        float height;
        int i10 = b.f13909a[this.f13929t.ordinal()];
        int i11 = this.g;
        int i12 = this.f13916f;
        RectF rectF = this.f13911a;
        Matrix matrix = this.f13919j;
        RectF rectF2 = this.f13917h;
        if (i10 == 1) {
            rectF2.set(rectF);
            float f10 = this.f13927r;
            rectF2.inset(f10 / 2.0f, f10 / 2.0f);
            matrix.reset();
            matrix.setTranslate((int) (((rectF2.width() - i12) * 0.5f) + 0.5f), (int) (((rectF2.height() - i11) * 0.5f) + 0.5f));
        } else if (i10 != 2) {
            RectF rectF3 = this.f13913c;
            if (i10 == 3) {
                matrix.reset();
                float min = (((float) i12) > rectF.width() || ((float) i11) > rectF.height()) ? Math.min(rectF.width() / i12, rectF.height() / i11) : 1.0f;
                float width2 = (int) (((rectF.width() - (i12 * min)) * 0.5f) + 0.5f);
                float height2 = (int) (((rectF.height() - (i11 * min)) * 0.5f) + 0.5f);
                matrix.setScale(min, min);
                matrix.postTranslate(width2, height2);
                rectF2.set(rectF3);
                matrix.mapRect(rectF2);
                float f11 = this.f13927r;
                rectF2.inset(f11 / 2.0f, f11 / 2.0f);
                matrix.setRectToRect(rectF3, rectF2, Matrix.ScaleToFit.FILL);
            } else if (i10 == 5) {
                rectF2.set(rectF3);
                matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.END);
                matrix.mapRect(rectF2);
                float f12 = this.f13927r;
                rectF2.inset(f12 / 2.0f, f12 / 2.0f);
                matrix.setRectToRect(rectF3, rectF2, Matrix.ScaleToFit.FILL);
            } else if (i10 == 6) {
                rectF2.set(rectF3);
                matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.START);
                matrix.mapRect(rectF2);
                float f13 = this.f13927r;
                rectF2.inset(f13 / 2.0f, f13 / 2.0f);
                matrix.setRectToRect(rectF3, rectF2, Matrix.ScaleToFit.FILL);
            } else if (i10 != 7) {
                rectF2.set(rectF3);
                matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
                matrix.mapRect(rectF2);
                float f14 = this.f13927r;
                rectF2.inset(f14 / 2.0f, f14 / 2.0f);
                matrix.setRectToRect(rectF3, rectF2, Matrix.ScaleToFit.FILL);
            } else {
                rectF2.set(rectF);
                float f15 = this.f13927r;
                rectF2.inset(f15 / 2.0f, f15 / 2.0f);
                matrix.reset();
                matrix.setRectToRect(rectF3, rectF2, Matrix.ScaleToFit.FILL);
            }
        } else {
            rectF2.set(rectF);
            float f16 = this.f13927r;
            rectF2.inset(f16 / 2.0f, f16 / 2.0f);
            matrix.reset();
            float f17 = 0.0f;
            if (rectF2.height() * i12 > rectF2.width() * i11) {
                width = rectF2.height() / i11;
                float width3 = (rectF2.width() - (i12 * width)) * 0.5f;
                height = 0.0f;
                f17 = width3;
            } else {
                width = rectF2.width() / i12;
                height = (rectF2.height() - (i11 * width)) * 0.5f;
            }
            matrix.setScale(width, width);
            float f18 = (int) (f17 + 0.5f);
            float f19 = this.f13927r;
            matrix.postTranslate((f19 / 2.0f) + f18, (f19 / 2.0f) + ((int) (height + 0.5f)));
        }
        this.f13912b.set(rectF2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        float f10;
        float f11;
        float f12;
        boolean z10 = this.f13923n;
        Paint paint = this.f13915e;
        if (z10) {
            BitmapShader bitmapShader = new BitmapShader(this.f13914d, this.f13921l, this.f13922m);
            Shader.TileMode tileMode = this.f13921l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f13922m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f13919j);
            }
            paint.setShader(bitmapShader);
            this.f13923n = false;
        }
        boolean z11 = this.f13926q;
        RectF rectF = this.f13917h;
        Paint paint2 = this.f13918i;
        RectF rectF2 = this.f13912b;
        if (z11) {
            if (this.f13927r <= 0.0f) {
                canvas.drawOval(rectF2, paint);
                return;
            } else {
                canvas.drawOval(rectF2, paint);
                canvas.drawOval(rectF, paint2);
                return;
            }
        }
        boolean[] zArr = this.f13925p;
        for (boolean z12 : zArr) {
            if (z12) {
                float f13 = this.f13924o;
                if (this.f13927r <= 0.0f) {
                    canvas.drawRoundRect(rectF2, f13, f13, paint);
                    b(canvas);
                    return;
                }
                canvas.drawRoundRect(rectF2, f13, f13, paint);
                canvas.drawRoundRect(rectF, f13, f13, paint2);
                b(canvas);
                for (boolean z13 : zArr) {
                    if (z13) {
                        if (this.f13924o == 0.0f) {
                            return;
                        }
                        float f14 = rectF2.left;
                        float f15 = rectF2.top;
                        float width = rectF2.width() + f14;
                        float height = rectF2.height() + f15;
                        float f16 = this.f13924o;
                        float f17 = this.f13927r / 2.0f;
                        if (zArr[0]) {
                            canvas2 = canvas;
                            f10 = f14;
                            f11 = f15;
                        } else {
                            canvas2 = canvas;
                            canvas2.drawLine(f14 - f17, f15, f14 + f16, f15, paint2);
                            f11 = f15;
                            canvas2.drawLine(f14, f11 - f17, f14, f11 + f16, paint2);
                            f10 = f14;
                        }
                        if (!zArr[1]) {
                            float f18 = f11;
                            canvas2.drawLine((width - f16) - f17, f18, width, f11, paint2);
                            canvas2.drawLine(width, f18 - f17, width, f18 + f16, paint2);
                            width = width;
                        }
                        if (zArr[2]) {
                            f12 = height;
                        } else {
                            canvas2.drawLine((width - f16) - f17, height, width + f17, height, paint2);
                            canvas2.drawLine(width, height - f16, width, height, paint2);
                            f12 = height;
                        }
                        if (zArr[3]) {
                            return;
                        }
                        float f19 = f12;
                        canvas2.drawLine(f10 - f17, f12, f10 + f16, f19, paint2);
                        canvas2.drawLine(f10, f12 - f16, f10, f19, paint2);
                        return;
                    }
                }
                return;
            }
        }
        canvas.drawRect(rectF2, paint);
        if (this.f13927r > 0.0f) {
            canvas.drawRect(rectF, paint2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f13915e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f13915e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f13916f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f13928s.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13911a.set(rect);
        c();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.f13928s.getColorForState(iArr, 0);
        Paint paint = this.f13918i;
        if (paint.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        paint.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f13915e.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f13915e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z10) {
        this.f13915e.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z10) {
        this.f13915e.setFilterBitmap(z10);
        invalidateSelf();
    }
}
