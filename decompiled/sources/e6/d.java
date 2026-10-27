package e6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends Drawable implements g, Animatable {

    /* renamed from: o, reason: collision with root package name */
    public final c f4629o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4630p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4631q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4632r;

    /* renamed from: t, reason: collision with root package name */
    public int f4634t;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4636v;

    /* renamed from: w, reason: collision with root package name */
    public Paint f4637w;

    /* renamed from: x, reason: collision with root package name */
    public Rect f4638x;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4633s = true;

    /* renamed from: u, reason: collision with root package name */
    public final int f4635u = -1;

    public d(c cVar) {
        this.f4629o = cVar;
    }

    public final void a() {
        m6.f.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f4632r);
        i iVar = (i) this.f4629o.f4628b;
        if (iVar.f4649a.f10012l.f9990c == 1) {
            invalidateSelf();
            return;
        }
        if (this.f4630p) {
            return;
        }
        this.f4630p = true;
        ArrayList arrayList = iVar.f4651c;
        if (iVar.f4657j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (isEmpty && !iVar.f4654f) {
            iVar.f4654f = true;
            iVar.f4657j = false;
            iVar.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f4632r) {
            return;
        }
        if (this.f4636v) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f4638x == null) {
                this.f4638x = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f4638x);
            this.f4636v = false;
        }
        i iVar = (i) this.f4629o.f4628b;
        f fVar = iVar.f4656i;
        Bitmap bitmap = fVar != null ? fVar.f4646u : iVar.f4659l;
        if (this.f4638x == null) {
            this.f4638x = new Rect();
        }
        Rect rect = this.f4638x;
        if (this.f4637w == null) {
            this.f4637w = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f4637w);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f4629o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((i) this.f4629o.f4628b).f4663p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((i) this.f4629o.f4628b).f4662o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f4630p;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4636v = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        if (this.f4637w == null) {
            this.f4637w = new Paint(2);
        }
        this.f4637w.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f4637w == null) {
            this.f4637w = new Paint(2);
        }
        this.f4637w.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        m6.f.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f4632r);
        this.f4633s = z10;
        if (!z10) {
            this.f4630p = false;
            i iVar = (i) this.f4629o.f4628b;
            ArrayList arrayList = iVar.f4651c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                iVar.f4654f = false;
            }
        } else if (this.f4631q) {
            a();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f4631q = true;
        this.f4634t = 0;
        if (this.f4633s) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f4631q = false;
        this.f4630p = false;
        i iVar = (i) this.f4629o.f4628b;
        ArrayList arrayList = iVar.f4651c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            iVar.f4654f = false;
        }
    }
}
