package androidx.leanback.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class GuidedActionItemContainer extends v {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f899o;

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        new Rect();
        if (context.getApplicationInfo().targetSdkVersion < 23) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.foreground});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                setForeground(drawable);
            }
            obtainStyledAttributes.recycle();
        }
        this.f899o = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i10) {
        if (this.f899o || !com.bumptech.glide.e.n(this, view)) {
            return super.focusSearch(view, i10);
        }
        View focusSearch = super.focusSearch(view, i10);
        if (com.bumptech.glide.e.n(this, focusSearch)) {
            return focusSearch;
        }
        return null;
    }
}
