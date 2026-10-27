package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import e.a;
import l.b;
import l.c;
import l.k;
import l.n;
import l.y;
import m.l;
import m.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ActionMenuItemView extends w0 implements y, View.OnClickListener, l {
    public c A;
    public boolean B;
    public boolean C;
    public final int D;
    public int E;
    public final int F;

    /* renamed from: v, reason: collision with root package name */
    public n f370v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f371w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f372x;

    /* renamed from: y, reason: collision with root package name */
    public k f373y;

    /* renamed from: z, reason: collision with root package name */
    public b f374z;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.B = g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4360c, 0, 0);
        this.D = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.F = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.E = -1;
        setSaveEnabled(false);
    }

    @Override // m.l
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // l.y
    public final void b(n nVar) {
        this.f370v = nVar;
        setIcon(nVar.getIcon());
        setTitle(nVar.getTitleCondensed());
        setId(nVar.f8014a);
        setVisibility(nVar.isVisible() ? 0 : 8);
        setEnabled(nVar.isEnabled());
        if (nVar.hasSubMenu() && this.f374z == null) {
            this.f374z = new b(this);
        }
    }

    @Override // m.l
    public final boolean c() {
        return !TextUtils.isEmpty(getText()) && this.f370v.getIcon() == null;
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (i10 < 480) {
            return (i10 >= 640 && i11 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // l.y
    public n getItemData() {
        return this.f370v;
    }

    public final void h() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f371w);
        if (this.f372x != null && ((this.f370v.f8037y & 4) != 4 || (!this.B && !this.C))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f371w : null);
        CharSequence charSequence = this.f370v.f8029q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z12 ? null : this.f370v.f8018e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f370v.f8030r;
        if (TextUtils.isEmpty(charSequence2)) {
            k5.a.w(this, z12 ? null : this.f370v.f8018e);
        } else {
            k5.a.w(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar = this.f373y;
        if (kVar != null) {
            kVar.c(this.f370v);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.B = g();
        h();
    }

    @Override // m.w0, android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (!isEmpty && (i12 = this.E) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int i13 = this.D;
        int min = mode == Integer.MIN_VALUE ? Math.min(size, i13) : i13;
        if (mode != 1073741824 && i13 > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i11);
        }
        if (!isEmpty || this.f372x == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f372x.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.f370v.hasSubMenu() && (bVar = this.f374z) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z10) {
        if (this.C != z10) {
            this.C = z10;
            n nVar = this.f370v;
            if (nVar != null) {
                l.l lVar = nVar.f8026n;
                lVar.f7997k = true;
                lVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f372x = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.F;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(k kVar) {
        this.f373y = kVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i10, int i11, int i12, int i13) {
        this.E = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(c cVar) {
        this.A = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f371w = charSequence;
        h();
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }
}
