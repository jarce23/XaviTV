package m8;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f9036p;

    @Override // com.bumptech.glide.c
    public final int m(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int measuredHeight;
        int i10;
        switch (this.f9036p) {
            case 0:
                measuredHeight = view.getMeasuredHeight();
                i10 = marginLayoutParams.bottomMargin;
                break;
            case 1:
                measuredHeight = view.getMeasuredWidth();
                i10 = marginLayoutParams.leftMargin;
                break;
            default:
                measuredHeight = view.getMeasuredWidth();
                i10 = marginLayoutParams.rightMargin;
                break;
        }
        return measuredHeight + i10;
    }

    @Override // com.bumptech.glide.c
    public final int o() {
        switch (this.f9036p) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    @Override // com.bumptech.glide.c
    public final ViewPropertyAnimator p(View view, int i10) {
        switch (this.f9036p) {
            case 0:
                return view.animate().translationY(i10);
            case 1:
                return view.animate().translationX(-i10);
            default:
                return view.animate().translationX(i10);
        }
    }
}
