package androidx.leanback.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class ResizingTextView extends TextView {

    /* renamed from: o, reason: collision with root package name */
    public final int f937o;

    /* renamed from: p, reason: collision with root package name */
    public final int f938p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f939q;

    /* renamed from: r, reason: collision with root package name */
    public final int f940r;

    /* renamed from: s, reason: collision with root package name */
    public final int f941s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f942t;

    /* renamed from: u, reason: collision with root package name */
    public int f943u;

    /* renamed from: v, reason: collision with root package name */
    public float f944v;

    /* renamed from: w, reason: collision with root package name */
    public int f945w;

    /* renamed from: x, reason: collision with root package name */
    public int f946x;

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.textViewStyle);
        this.f942t = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.f14f, R.attr.textViewStyle, 0);
        try {
            this.f937o = obtainStyledAttributes.getInt(1, 1);
            this.f938p = obtainStyledAttributes.getDimensionPixelSize(4, -1);
            this.f939q = obtainStyledAttributes.getBoolean(0, false);
            this.f940r = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f941s = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void a(int i10, int i11) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i10, getPaddingEnd(), i11);
        } else {
            setPadding(getPaddingLeft(), i10, getPaddingRight(), i11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ResizingTextView.onMeasure(int, int):void");
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.bumptech.glide.d.M(callback, this));
    }
}
