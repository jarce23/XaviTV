package androidx.mediarouter.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ s f1307o;

    public g(s sVar) {
        this.f1307o = sVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        s sVar = this.f1307o;
        sVar.S.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        HashSet hashSet = sVar.V;
        if (hashSet == null || hashSet.size() == 0) {
            sVar.k(true);
            return;
        }
        m mVar = new m(1, sVar);
        int firstVisiblePosition = sVar.S.getFirstVisiblePosition();
        boolean z10 = false;
        for (int i10 = 0; i10 < sVar.S.getChildCount(); i10++) {
            View childAt = sVar.S.getChildAt(i10);
            if (sVar.V.contains((w3.z) sVar.T.getItem(firstVisiblePosition + i10))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(sVar.f1409w0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z10) {
                    alphaAnimation.setAnimationListener(mVar);
                    z10 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }
}
