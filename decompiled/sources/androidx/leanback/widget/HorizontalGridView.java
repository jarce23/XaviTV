package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class HorizontalGridView extends f {

    /* renamed from: c1, reason: collision with root package name */
    public boolean f902c1;

    /* renamed from: d1, reason: collision with root package name */
    public boolean f903d1;

    /* renamed from: e1, reason: collision with root package name */
    public final Paint f904e1;

    /* renamed from: f1, reason: collision with root package name */
    public Bitmap f905f1;

    /* renamed from: g1, reason: collision with root package name */
    public LinearGradient f906g1;
    public int h1;

    /* renamed from: i1, reason: collision with root package name */
    public int f907i1;

    /* renamed from: j1, reason: collision with root package name */
    public Bitmap f908j1;

    /* renamed from: k1, reason: collision with root package name */
    public LinearGradient f909k1;

    /* renamed from: l1, reason: collision with root package name */
    public int f910l1;

    /* renamed from: m1, reason: collision with root package name */
    public int f911m1;

    /* renamed from: n1, reason: collision with root package name */
    public final Rect f912n1;

    public HorizontalGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f904e1 = new Paint();
        this.f912n1 = new Rect();
        this.W0.u1(0);
        m0(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.f13e);
        setRowHeight(obtainStyledAttributes);
        setNumRows(obtainStyledAttributes.getInt(0, 1));
        obtainStyledAttributes.recycle();
        n0();
        Paint paint = new Paint();
        this.f904e1 = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    private Bitmap getTempBitmapHigh() {
        Bitmap bitmap = this.f908j1;
        if (bitmap == null || bitmap.getWidth() != this.f910l1 || this.f908j1.getHeight() != getHeight()) {
            this.f908j1 = Bitmap.createBitmap(this.f910l1, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f908j1;
    }

    private Bitmap getTempBitmapLow() {
        Bitmap bitmap = this.f905f1;
        if (bitmap == null || bitmap.getWidth() != this.h1 || this.f905f1.getHeight() != getHeight()) {
            this.f905f1 = Bitmap.createBitmap(this.h1, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f905f1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void draw(Canvas canvas) {
        boolean z10;
        boolean z11 = this.f902c1;
        p pVar = this.W0;
        boolean z12 = true;
        if (z11) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                pVar.getClass();
                m mVar = (m) childAt.getLayoutParams();
                mVar.getClass();
                if (childAt.getLeft() + mVar.f1036e < getPaddingLeft() - this.f907i1) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        if (this.f903d1) {
            for (int childCount2 = getChildCount() - 1; childCount2 >= 0; childCount2--) {
                View childAt2 = getChildAt(childCount2);
                pVar.getClass();
                m mVar2 = (m) childAt2.getLayoutParams();
                mVar2.getClass();
                if (childAt2.getRight() - mVar2.g > (getWidth() - getPaddingRight()) + this.f911m1) {
                    break;
                }
            }
        }
        z12 = false;
        if (!z10) {
            this.f905f1 = null;
        }
        if (!z12) {
            this.f908j1 = null;
        }
        if (!z10 && !z12) {
            super.draw(canvas);
            return;
        }
        int paddingLeft = this.f902c1 ? (getPaddingLeft() - this.f907i1) - this.h1 : 0;
        int width = this.f903d1 ? (getWidth() - getPaddingRight()) + this.f911m1 + this.f910l1 : getWidth();
        int save = canvas.save();
        canvas.clipRect((this.f902c1 ? this.h1 : 0) + paddingLeft, 0, width - (this.f903d1 ? this.f910l1 : 0), getHeight());
        super.draw(canvas);
        canvas.restoreToCount(save);
        Canvas canvas2 = new Canvas();
        Rect rect = this.f912n1;
        rect.top = 0;
        rect.bottom = getHeight();
        if (z10 && this.h1 > 0) {
            Bitmap tempBitmapLow = getTempBitmapLow();
            tempBitmapLow.eraseColor(0);
            canvas2.setBitmap(tempBitmapLow);
            int save2 = canvas2.save();
            canvas2.clipRect(0, 0, this.h1, getHeight());
            float f10 = -paddingLeft;
            canvas2.translate(f10, 0.0f);
            super.draw(canvas2);
            canvas2.restoreToCount(save2);
            this.f904e1.setShader(this.f906g1);
            canvas2.drawRect(0.0f, 0.0f, this.h1, getHeight(), this.f904e1);
            rect.left = 0;
            rect.right = this.h1;
            canvas.translate(paddingLeft, 0.0f);
            canvas.drawBitmap(tempBitmapLow, rect, rect, (Paint) null);
            canvas.translate(f10, 0.0f);
        }
        if (!z12 || this.f910l1 <= 0) {
            return;
        }
        Bitmap tempBitmapHigh = getTempBitmapHigh();
        tempBitmapHigh.eraseColor(0);
        canvas2.setBitmap(tempBitmapHigh);
        int save3 = canvas2.save();
        canvas2.clipRect(0, 0, this.f910l1, getHeight());
        canvas2.translate(-(width - this.f910l1), 0.0f);
        super.draw(canvas2);
        canvas2.restoreToCount(save3);
        this.f904e1.setShader(this.f909k1);
        canvas2.drawRect(0.0f, 0.0f, this.f910l1, getHeight(), this.f904e1);
        rect.left = 0;
        rect.right = this.f910l1;
        canvas.translate(width - r4, 0.0f);
        canvas.drawBitmap(tempBitmapHigh, rect, rect, (Paint) null);
        canvas.translate(-(width - this.f910l1), 0.0f);
    }

    public final boolean getFadingLeftEdge() {
        return this.f902c1;
    }

    public final int getFadingLeftEdgeLength() {
        return this.h1;
    }

    public final int getFadingLeftEdgeOffset() {
        return this.f907i1;
    }

    public final boolean getFadingRightEdge() {
        return this.f903d1;
    }

    public final int getFadingRightEdgeLength() {
        return this.f910l1;
    }

    public final int getFadingRightEdgeOffset() {
        return this.f911m1;
    }

    public final void n0() {
        if (this.f902c1 || this.f903d1) {
            setLayerType(2, null);
            setWillNotDraw(false);
        } else {
            setLayerType(0, null);
            setWillNotDraw(true);
        }
    }

    public final void setFadingLeftEdge(boolean z10) {
        if (this.f902c1 != z10) {
            this.f902c1 = z10;
            if (!z10) {
                this.f905f1 = null;
            }
            invalidate();
            n0();
        }
    }

    public final void setFadingLeftEdgeLength(int i10) {
        if (this.h1 != i10) {
            this.h1 = i10;
            if (i10 != 0) {
                this.f906g1 = new LinearGradient(0.0f, 0.0f, this.h1, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
            } else {
                this.f906g1 = null;
            }
            invalidate();
        }
    }

    public final void setFadingLeftEdgeOffset(int i10) {
        if (this.f907i1 != i10) {
            this.f907i1 = i10;
            invalidate();
        }
    }

    public final void setFadingRightEdge(boolean z10) {
        if (this.f903d1 != z10) {
            this.f903d1 = z10;
            if (!z10) {
                this.f908j1 = null;
            }
            invalidate();
            n0();
        }
    }

    public final void setFadingRightEdgeLength(int i10) {
        if (this.f910l1 != i10) {
            this.f910l1 = i10;
            if (i10 != 0) {
                this.f909k1 = new LinearGradient(0.0f, 0.0f, this.f910l1, 0.0f, -16777216, 0, Shader.TileMode.CLAMP);
            } else {
                this.f909k1 = null;
            }
            invalidate();
        }
    }

    public final void setFadingRightEdgeOffset(int i10) {
        if (this.f911m1 != i10) {
            this.f911m1 = i10;
            invalidate();
        }
    }

    public void setNumRows(int i10) {
        p pVar = this.W0;
        if (i10 < 0) {
            pVar.getClass();
            throw new IllegalArgumentException();
        }
        pVar.R = i10;
        requestLayout();
    }

    public void setRowHeight(TypedArray typedArray) {
        if (typedArray.peekValue(1) != null) {
            setRowHeight(typedArray.getLayoutDimension(1, 0));
        }
    }

    public void setRowHeight(int i10) {
        this.W0.v1(i10);
        requestLayout();
    }
}
