package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ThumbsBar extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    public int f987o;

    /* renamed from: p, reason: collision with root package name */
    public final int f988p;

    /* renamed from: q, reason: collision with root package name */
    public final int f989q;

    /* renamed from: r, reason: collision with root package name */
    public final int f990r;

    /* renamed from: s, reason: collision with root package name */
    public final int f991s;

    /* renamed from: t, reason: collision with root package name */
    public int f992t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f993u;

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f987o = -1;
        new SparseArray();
        this.f993u = false;
        this.f988p = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_width);
        this.f989q = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_height);
        this.f991s = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_width);
        this.f990r = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_height);
        this.f992t = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_margin);
    }

    public final void a() {
        int i10;
        int i11;
        while (getChildCount() > this.f987o) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (true) {
            int childCount = getChildCount();
            int i12 = this.f987o;
            i10 = this.f989q;
            i11 = this.f988p;
            if (childCount >= i12) {
                break;
            } else {
                addView(new ImageView(getContext()), new LinearLayout.LayoutParams(i11, i10));
            }
        }
        int heroIndex = getHeroIndex();
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i13) {
                layoutParams.width = this.f990r;
                layoutParams.height = this.f991s;
            } else {
                layoutParams.width = i11;
                layoutParams.height = i10;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredWidth = (childAt.getMeasuredWidth() / 2) + (getWidth() / 2);
        childAt.layout(width, getPaddingTop(), measuredWidth, childAt.getMeasuredHeight() + getPaddingTop());
        int measuredHeight = (childAt.getMeasuredHeight() / 2) + getPaddingTop();
        for (int i14 = heroIndex - 1; i14 >= 0; i14--) {
            int i15 = width - this.f992t;
            View childAt2 = getChildAt(i14);
            childAt2.layout(i15 - childAt2.getMeasuredWidth(), measuredHeight - (childAt2.getMeasuredHeight() / 2), i15, (childAt2.getMeasuredHeight() / 2) + measuredHeight);
            width = i15 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex >= this.f987o) {
                return;
            }
            int i16 = measuredWidth + this.f992t;
            View childAt3 = getChildAt(heroIndex);
            childAt3.layout(i16, measuredHeight - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i16, (childAt3.getMeasuredHeight() / 2) + measuredHeight);
            measuredWidth = i16 + childAt3.getMeasuredWidth();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        if (this.f993u) {
            return;
        }
        int i12 = measuredWidth - this.f990r;
        int i13 = ((i12 + r3) - 1) / (this.f988p + this.f992t);
        if (i13 < 2) {
            i13 = 2;
        } else if ((i13 & 1) != 0) {
            i13++;
        }
        int i14 = i13 + 1;
        if (this.f987o != i14) {
            this.f987o = i14;
            a();
        }
    }

    public void setNumberOfThumbs(int i10) {
        this.f993u = true;
        this.f987o = i10;
        a();
    }

    public void setThumbSpace(int i10) {
        this.f992t = i10;
        requestLayout();
    }
}
