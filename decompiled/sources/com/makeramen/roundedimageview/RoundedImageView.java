package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;
import y9.a;
import y9.c;
import y9.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class RoundedImageView extends ImageView {
    public static final Shader.TileMode D = Shader.TileMode.CLAMP;
    public static final ImageView.ScaleType[] E = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public ImageView.ScaleType A;
    public Shader.TileMode B;
    public Shader.TileMode C;

    /* renamed from: o, reason: collision with root package name */
    public final float[] f3935o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f3936p;

    /* renamed from: q, reason: collision with root package name */
    public ColorStateList f3937q;

    /* renamed from: r, reason: collision with root package name */
    public float f3938r;

    /* renamed from: s, reason: collision with root package name */
    public ColorFilter f3939s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3940t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f3941u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3942v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3943w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f3944x;

    /* renamed from: y, reason: collision with root package name */
    public int f3945y;

    /* renamed from: z, reason: collision with root package name */
    public int f3946z;

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.f3935o = fArr;
        this.f3937q = ColorStateList.valueOf(-16777216);
        this.f3938r = 0.0f;
        this.f3939s = null;
        this.f3940t = false;
        this.f3942v = false;
        this.f3943w = false;
        this.f3944x = false;
        Shader.TileMode tileMode = D;
        this.B = tileMode;
        this.C = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f13908a, 0, 0);
        int i10 = obtainStyledAttributes.getInt(0, -1);
        if (i10 >= 0) {
            setScaleType(E[i10]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        fArr[0] = obtainStyledAttributes.getDimensionPixelSize(6, -1);
        fArr[1] = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        fArr[2] = obtainStyledAttributes.getDimensionPixelSize(5, -1);
        fArr[3] = obtainStyledAttributes.getDimensionPixelSize(4, -1);
        boolean z10 = false;
        for (int i11 = 0; i11 < 4; i11++) {
            float[] fArr2 = this.f3935o;
            if (fArr2[i11] < 0.0f) {
                fArr2[i11] = 0.0f;
            } else {
                z10 = true;
            }
        }
        if (!z10) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length = this.f3935o.length;
            for (int i12 = 0; i12 < length; i12++) {
                this.f3935o[i12] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        this.f3938r = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f3938r = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
        this.f3937q = colorStateList;
        if (colorStateList == null) {
            this.f3937q = ColorStateList.valueOf(-16777216);
        }
        boolean z11 = obtainStyledAttributes.getBoolean(8, false);
        this.f3944x = z11;
        this.f3943w = obtainStyledAttributes.getBoolean(9, false);
        int i13 = obtainStyledAttributes.getInt(10, -2);
        if (i13 != -2) {
            setTileModeX(a(i13));
            setTileModeY(a(i13));
        }
        int i14 = obtainStyledAttributes.getInt(11, -2);
        if (i14 != -2) {
            setTileModeX(a(i14));
        }
        int i15 = obtainStyledAttributes.getInt(12, -2);
        if (i15 != -2) {
            setTileModeY(a(i15));
        }
        e();
        d(true);
        if (z11) {
            super.setBackgroundDrawable(this.f3936p);
        }
        obtainStyledAttributes.recycle();
    }

    public static Shader.TileMode a(int i10) {
        if (i10 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i10 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i10 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    public final void b(float f10, float f11, float f12, float f13) {
        float[] fArr = this.f3935o;
        if (fArr[0] == f10 && fArr[1] == f11 && fArr[2] == f13 && fArr[3] == f12) {
            return;
        }
        fArr[0] = f10;
        fArr[1] = f11;
        fArr[3] = f12;
        fArr[2] = f13;
        e();
        d(false);
        invalidate();
    }

    public final void c(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof c)) {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    c(layerDrawable.getDrawable(i10), scaleType);
                }
                return;
            }
            return;
        }
        c cVar = (c) drawable;
        Paint paint = cVar.f13918i;
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (cVar.f13929t != scaleType) {
            cVar.f13929t = scaleType;
            cVar.c();
        }
        float f10 = this.f3938r;
        cVar.f13927r = f10;
        paint.setStrokeWidth(f10);
        ColorStateList colorStateList = this.f3937q;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        cVar.f13928s = colorStateList;
        paint.setColor(colorStateList.getColorForState(cVar.getState(), -16777216));
        cVar.f13926q = this.f3943w;
        Shader.TileMode tileMode = this.B;
        if (cVar.f13921l != tileMode) {
            cVar.f13921l = tileMode;
            cVar.f13923n = true;
            cVar.invalidateSelf();
        }
        Shader.TileMode tileMode2 = this.C;
        if (cVar.f13922m != tileMode2) {
            cVar.f13922m = tileMode2;
            cVar.f13923n = true;
            cVar.invalidateSelf();
        }
        float[] fArr = this.f3935o;
        if (fArr != null) {
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            HashSet hashSet = new HashSet(4);
            hashSet.add(Float.valueOf(f11));
            hashSet.add(Float.valueOf(f12));
            hashSet.add(Float.valueOf(f13));
            hashSet.add(Float.valueOf(f14));
            hashSet.remove(Float.valueOf(0.0f));
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
            }
            if (hashSet.isEmpty()) {
                cVar.f13924o = 0.0f;
            } else {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
                cVar.f13924o = floatValue;
            }
            boolean[] zArr = cVar.f13925p;
            zArr[0] = f11 > 0.0f;
            zArr[1] = f12 > 0.0f;
            zArr[2] = f13 > 0.0f;
            zArr[3] = f14 > 0.0f;
        }
        Drawable drawable2 = this.f3941u;
        if (drawable2 == null || !this.f3940t) {
            return;
        }
        Drawable mutate = drawable2.mutate();
        this.f3941u = mutate;
        if (this.f3942v) {
            mutate.setColorFilter(this.f3939s);
        }
    }

    public final void d(boolean z10) {
        if (this.f3944x) {
            if (z10) {
                this.f3936p = c.a(this.f3936p);
            }
            c(this.f3936p, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public final void e() {
        c(this.f3941u, this.A);
    }

    public int getBorderColor() {
        return this.f3937q.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f3937q;
    }

    public float getBorderWidth() {
        return this.f3938r;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f10 = 0.0f;
        for (float f11 : this.f3935o) {
            f10 = Math.max(f11, f10);
        }
        return f10;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.A;
    }

    public Shader.TileMode getTileModeX() {
        return this.B;
    }

    public Shader.TileMode getTileModeY() {
        return this.C;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        ColorDrawable colorDrawable = new ColorDrawable(i10);
        this.f3936p = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f3936p = drawable;
        d(true);
        super.setBackgroundDrawable(this.f3936p);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        if (this.f3946z != i10) {
            this.f3946z = i10;
            Resources resources = getResources();
            Drawable drawable = null;
            if (resources != null) {
                int i11 = this.f3946z;
                if (i11 != 0) {
                    try {
                        drawable = resources.getDrawable(i11);
                    } catch (Exception e7) {
                        Log.w("RoundedImageView", "Unable to find resource: " + this.f3946z, e7);
                        this.f3946z = 0;
                    }
                }
                drawable = c.a(drawable);
            }
            this.f3936p = drawable;
            setBackgroundDrawable(drawable);
        }
    }

    public void setBorderColor(int i10) {
        setBorderColor(ColorStateList.valueOf(i10));
    }

    public void setBorderWidth(int i10) {
        setBorderWidth(getResources().getDimension(i10));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f3939s != colorFilter) {
            this.f3939s = colorFilter;
            this.f3942v = true;
            this.f3940t = true;
            Drawable drawable = this.f3941u;
            if (drawable != null) {
                Drawable mutate = drawable.mutate();
                this.f3941u = mutate;
                if (this.f3942v) {
                    mutate.setColorFilter(this.f3939s);
                }
            }
            invalidate();
        }
    }

    public void setCornerRadius(float f10) {
        b(f10, f10, f10, f10);
    }

    public void setCornerRadiusDimen(int i10) {
        float dimension = getResources().getDimension(i10);
        b(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        c cVar;
        this.f3945y = 0;
        if (bitmap != null) {
            cVar = new c(bitmap);
        } else {
            int i10 = c.f13910u;
            cVar = null;
        }
        this.f3941u = cVar;
        e();
        super.setImageDrawable(this.f3941u);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f3945y = 0;
        this.f3941u = c.a(drawable);
        e();
        super.setImageDrawable(this.f3941u);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f3945y != i10) {
            this.f3945y = i10;
            Resources resources = getResources();
            Drawable drawable = null;
            if (resources != null) {
                int i11 = this.f3945y;
                if (i11 != 0) {
                    try {
                        drawable = resources.getDrawable(i11);
                    } catch (Exception e7) {
                        Log.w("RoundedImageView", "Unable to find resource: " + this.f3945y, e7);
                        this.f3945y = 0;
                    }
                }
                drawable = c.a(drawable);
            }
            this.f3941u = drawable;
            e();
            super.setImageDrawable(this.f3941u);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z10) {
        this.f3943w = z10;
        e();
        d(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.A != scaleType) {
            this.A = scaleType;
            switch (d.f13930a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            e();
            d(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.B == tileMode) {
            return;
        }
        this.B = tileMode;
        e();
        d(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.C == tileMode) {
            return;
        }
        this.C = tileMode;
        e();
        d(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f3937q.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f3937q = colorStateList;
        e();
        d(false);
        if (this.f3938r > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f10) {
        if (this.f3938r == f10) {
            return;
        }
        this.f3938r = f10;
        e();
        d(false);
        invalidate();
    }
}
