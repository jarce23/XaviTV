package m4;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.util.ArrayDeque;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends g {

    /* renamed from: x, reason: collision with root package name */
    public static final PorterDuff.Mode f8941x = PorterDuff.Mode.SRC_IN;

    /* renamed from: p, reason: collision with root package name */
    public n f8942p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuffColorFilter f8943q;

    /* renamed from: r, reason: collision with root package name */
    public ColorFilter f8944r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8945s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8946t;

    /* renamed from: u, reason: collision with root package name */
    public final float[] f8947u;

    /* renamed from: v, reason: collision with root package name */
    public final Matrix f8948v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f8949w;

    public p() {
        this.f8946t = true;
        this.f8947u = new float[9];
        this.f8948v = new Matrix();
        this.f8949w = new Rect();
        n nVar = new n();
        nVar.f8931c = null;
        nVar.f8932d = f8941x;
        nVar.f8930b = new m();
        this.f8942p = nVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f8890o;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f8949w;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f8944r;
        if (colorFilter == null) {
            colorFilter = this.f8943q;
        }
        Matrix matrix = this.f8948v;
        canvas.getMatrix(matrix);
        float[] fArr = this.f8947u;
        matrix.getValues(fArr);
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[4]);
        float abs3 = Math.abs(fArr[1]);
        float abs4 = Math.abs(fArr[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int width = (int) (rect.width() * abs);
        int min = Math.min(2048, width);
        int min2 = Math.min(2048, (int) (rect.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        n nVar = this.f8942p;
        Bitmap bitmap = nVar.f8934f;
        if (bitmap == null || min != bitmap.getWidth() || min2 != nVar.f8934f.getHeight()) {
            nVar.f8934f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
            nVar.f8938k = true;
        }
        if (this.f8946t) {
            n nVar2 = this.f8942p;
            if (nVar2.f8938k || nVar2.g != nVar2.f8931c || nVar2.f8935h != nVar2.f8932d || nVar2.f8937j != nVar2.f8933e || nVar2.f8936i != nVar2.f8930b.getRootAlpha()) {
                n nVar3 = this.f8942p;
                nVar3.f8934f.eraseColor(0);
                Canvas canvas2 = new Canvas(nVar3.f8934f);
                m mVar = nVar3.f8930b;
                mVar.a(mVar.g, m.f8914p, canvas2, min, min2);
                n nVar4 = this.f8942p;
                nVar4.g = nVar4.f8931c;
                nVar4.f8935h = nVar4.f8932d;
                nVar4.f8936i = nVar4.f8930b.getRootAlpha();
                nVar4.f8937j = nVar4.f8933e;
                nVar4.f8938k = false;
            }
        } else {
            n nVar5 = this.f8942p;
            nVar5.f8934f.eraseColor(0);
            Canvas canvas3 = new Canvas(nVar5.f8934f);
            m mVar2 = nVar5.f8930b;
            mVar2.a(mVar2.g, m.f8914p, canvas3, min, min2);
        }
        n nVar6 = this.f8942p;
        if (nVar6.f8930b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (nVar6.f8939l == null) {
                Paint paint2 = new Paint();
                nVar6.f8939l = paint2;
                paint2.setFilterBitmap(true);
            }
            nVar6.f8939l.setAlpha(nVar6.f8930b.getRootAlpha());
            nVar6.f8939l.setColorFilter(colorFilter);
            paint = nVar6.f8939l;
        }
        canvas.drawBitmap(nVar6.f8934f, (Rect) null, rect, paint);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getAlpha() : this.f8942p.f8930b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f8942p.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getColorFilter() : this.f8944r;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f8890o != null && Build.VERSION.SDK_INT >= 24) {
            return new o(this.f8890o.getConstantState());
        }
        this.f8942p.f8929a = getChangingConfigurations();
        return this.f8942p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f8942p.f8930b.f8922i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f8942p.f8930b.f8921h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.isAutoMirrored() : this.f8942p.f8933e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        n nVar = this.f8942p;
        if (nVar == null) {
            return false;
        }
        m mVar = nVar.f8930b;
        if (mVar.f8927n == null) {
            mVar.f8927n = Boolean.valueOf(mVar.g.a());
        }
        if (mVar.f8927n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f8942p.f8931c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f8945s && super.mutate() == this) {
            n nVar = this.f8942p;
            n nVar2 = new n();
            nVar2.f8931c = null;
            nVar2.f8932d = f8941x;
            if (nVar != null) {
                nVar2.f8929a = nVar.f8929a;
                m mVar = new m(nVar.f8930b);
                nVar2.f8930b = mVar;
                if (nVar.f8930b.f8919e != null) {
                    mVar.f8919e = new Paint(nVar.f8930b.f8919e);
                }
                if (nVar.f8930b.f8918d != null) {
                    nVar2.f8930b.f8918d = new Paint(nVar.f8930b.f8918d);
                }
                nVar2.f8931c = nVar.f8931c;
                nVar2.f8932d = nVar.f8932d;
                nVar2.f8933e = nVar.f8933e;
            }
            this.f8942p = nVar2;
            this.f8945s = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        n nVar = this.f8942p;
        ColorStateList colorStateList = nVar.f8931c;
        if (colorStateList == null || (mode = nVar.f8932d) == null) {
            z10 = false;
        } else {
            this.f8943q = a(colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        m mVar = nVar.f8930b;
        if (mVar.f8927n == null) {
            mVar.f8927n = Boolean.valueOf(mVar.g.a());
        }
        if (mVar.f8927n.booleanValue()) {
            boolean b2 = nVar.f8930b.g.b(iArr);
            nVar.f8938k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f8942p.f8930b.getRootAlpha() != i10) {
            this.f8942p.f8930b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setAutoMirrored(z10);
        } else {
            this.f8942p.f8933e = z10;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8944r = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            i7.e.z(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        n nVar = this.f8942p;
        if (nVar.f8931c != colorStateList) {
            nVar.f8931c = colorStateList;
            this.f8943q = a(colorStateList, nVar.f8932d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        n nVar = this.f8942p;
        if (nVar.f8932d != mode) {
            nVar.f8932d = mode;
            this.f8943q = a(nVar.f8931c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f8890o;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i10;
        char c10;
        int i11;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.f8890o;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        n nVar = this.f8942p;
        nVar.f8930b = new m();
        TypedArray h10 = d0.b.h(resources, theme, attributeSet, a.f8867a);
        n nVar2 = this.f8942p;
        m mVar = nVar2.f8930b;
        int i12 = !d0.b.e(xmlPullParser, "tintMode") ? -1 : h10.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i12 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i12 != 5) {
            if (i12 != 9) {
                switch (i12) {
                    case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        nVar2.f8932d = mode;
        ColorStateList colorStateList = null;
        int i13 = 1;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            h10.getValue(1, typedValue);
            int i14 = typedValue.type;
            if (i14 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i14 >= 28 && i14 <= 31) {
                colorStateList = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = h10.getResources();
                int resourceId = h10.getResourceId(1, 0);
                ThreadLocal threadLocal = d0.c.f3961a;
                try {
                    colorStateList = d0.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e7) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e7);
                }
            }
        }
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList2 != null) {
            nVar2.f8931c = colorStateList2;
        }
        boolean z10 = nVar2.f8933e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z10 = h10.getBoolean(5, z10);
        }
        nVar2.f8933e = z10;
        float f10 = mVar.f8923j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f10 = h10.getFloat(7, f10);
        }
        mVar.f8923j = f10;
        float f11 = mVar.f8924k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f11 = h10.getFloat(8, f11);
        }
        mVar.f8924k = f11;
        if (mVar.f8923j <= 0.0f) {
            throw new XmlPullParserException(h10.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f11 > 0.0f) {
            mVar.f8921h = h10.getDimension(3, mVar.f8921h);
            float dimension = h10.getDimension(2, mVar.f8922i);
            mVar.f8922i = dimension;
            if (mVar.f8921h <= 0.0f) {
                throw new XmlPullParserException(h10.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = mVar.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = h10.getFloat(4, alpha);
                }
                mVar.setAlpha(alpha);
                String string = h10.getString(0);
                if (string != null) {
                    mVar.f8926m = string;
                    mVar.f8928o.put(string, mVar);
                }
                h10.recycle();
                nVar.f8929a = getChangingConfigurations();
                nVar.f8938k = true;
                n nVar3 = this.f8942p;
                m mVar2 = nVar3.f8930b;
                ArrayDeque arrayDeque = new ArrayDeque();
                j jVar = mVar2.g;
                p.e eVar = mVar2.f8928o;
                arrayDeque.push(jVar);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z11 = true;
                while (eventType != i13 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        j jVar2 = (j) arrayDeque.peek();
                        i10 = depth;
                        if ("path".equals(name)) {
                            i iVar = new i();
                            iVar.f8892e = 0.0f;
                            iVar.g = 1.0f;
                            iVar.f8894h = 1.0f;
                            iVar.f8895i = 0.0f;
                            iVar.f8896j = 1.0f;
                            iVar.f8897k = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            iVar.f8898l = cap2;
                            Paint.Join join2 = Paint.Join.MITER;
                            iVar.f8899m = join2;
                            iVar.f8900n = 4.0f;
                            TypedArray h11 = d0.b.h(resources, theme, attributeSet, a.f8869c);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                String string2 = h11.getString(0);
                                if (string2 != null) {
                                    iVar.f8912b = string2;
                                }
                                String string3 = h11.getString(2);
                                if (string3 != null) {
                                    iVar.f8911a = n4.a.i(string3);
                                }
                                iVar.f8893f = d0.b.c(h11, xmlPullParser, theme, "fillColor", 1);
                                float f12 = iVar.f8894h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f12 = h11.getFloat(12, f12);
                                }
                                iVar.f8894h = f12;
                                int i15 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? h11.getInt(8, -1) : -1;
                                Paint.Cap cap3 = iVar.f8898l;
                                if (i15 == 0) {
                                    cap = cap2;
                                } else if (i15 != 1) {
                                    cap = i15 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                iVar.f8898l = cap;
                                int i16 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? h11.getInt(9, -1) : -1;
                                Paint.Join join3 = iVar.f8899m;
                                if (i16 == 0) {
                                    join = join2;
                                } else if (i16 != 1) {
                                    join = i16 != 2 ? join3 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                iVar.f8899m = join;
                                float f13 = iVar.f8900n;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f13 = h11.getFloat(10, f13);
                                }
                                iVar.f8900n = f13;
                                iVar.f8891d = d0.b.c(h11, xmlPullParser, theme, "strokeColor", 3);
                                float f14 = iVar.g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f14 = h11.getFloat(11, f14);
                                }
                                iVar.g = f14;
                                float f15 = iVar.f8892e;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f15 = h11.getFloat(4, f15);
                                }
                                iVar.f8892e = f15;
                                float f16 = iVar.f8896j;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f16 = h11.getFloat(6, f16);
                                }
                                iVar.f8896j = f16;
                                float f17 = iVar.f8897k;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f17 = h11.getFloat(7, f17);
                                }
                                iVar.f8897k = f17;
                                float f18 = iVar.f8895i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f18 = h11.getFloat(5, f18);
                                }
                                iVar.f8895i = f18;
                                int i17 = iVar.f8913c;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i17 = h11.getInt(13, i17);
                                }
                                iVar.f8913c = i17;
                            }
                            h11.recycle();
                            jVar2.f8902b.add(iVar);
                            if (iVar.getPathName() != null) {
                                eVar.put(iVar.getPathName(), iVar);
                            }
                            nVar3.f8929a = nVar3.f8929a;
                            z11 = false;
                            c10 = '\b';
                        } else {
                            c10 = '\b';
                            if ("clip-path".equals(name)) {
                                h hVar = new h();
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    TypedArray h12 = d0.b.h(resources, theme, attributeSet, a.f8870d);
                                    String string4 = h12.getString(0);
                                    if (string4 != null) {
                                        hVar.f8912b = string4;
                                    }
                                    String string5 = h12.getString(1);
                                    if (string5 != null) {
                                        hVar.f8911a = n4.a.i(string5);
                                    }
                                    hVar.f8913c = !d0.b.e(xmlPullParser, "fillType") ? 0 : h12.getInt(2, 0);
                                    h12.recycle();
                                }
                                jVar2.f8902b.add(hVar);
                                if (hVar.getPathName() != null) {
                                    eVar.put(hVar.getPathName(), hVar);
                                }
                                nVar3.f8929a = nVar3.f8929a;
                            } else if ("group".equals(name)) {
                                j jVar3 = new j();
                                TypedArray h13 = d0.b.h(resources, theme, attributeSet, a.f8868b);
                                float f19 = jVar3.f8903c;
                                if (d0.b.e(xmlPullParser, "rotation")) {
                                    f19 = h13.getFloat(5, f19);
                                }
                                jVar3.f8903c = f19;
                                jVar3.f8904d = h13.getFloat(1, jVar3.f8904d);
                                jVar3.f8905e = h13.getFloat(2, jVar3.f8905e);
                                float f20 = jVar3.f8906f;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                    f20 = h13.getFloat(3, f20);
                                }
                                jVar3.f8906f = f20;
                                float f21 = jVar3.g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                    f21 = h13.getFloat(4, f21);
                                }
                                jVar3.g = f21;
                                float f22 = jVar3.f8907h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                    f22 = h13.getFloat(6, f22);
                                }
                                jVar3.f8907h = f22;
                                float f23 = jVar3.f8908i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                    f23 = h13.getFloat(7, f23);
                                }
                                jVar3.f8908i = f23;
                                String string6 = h13.getString(0);
                                if (string6 != null) {
                                    jVar3.f8910k = string6;
                                }
                                jVar3.c();
                                h13.recycle();
                                jVar2.f8902b.add(jVar3);
                                arrayDeque.push(jVar3);
                                if (jVar3.getGroupName() != null) {
                                    eVar.put(jVar3.getGroupName(), jVar3);
                                }
                                nVar3.f8929a = nVar3.f8929a;
                            }
                        }
                        i11 = 1;
                    } else {
                        i10 = depth;
                        c10 = '\b';
                        i11 = 1;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i13 = i11;
                    depth = i10;
                }
                if (!z11) {
                    this.f8943q = a(nVar.f8931c, nVar.f8932d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(h10.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(h10.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public p(n nVar) {
        this.f8946t = true;
        this.f8947u = new float[9];
        this.f8948v = new Matrix();
        this.f8949w = new Rect();
        this.f8942p = nVar;
        this.f8943q = a(nVar.f8931c, nVar.f8932d);
    }
}
