package g9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5349a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5350b;

    public /* synthetic */ l(int i10, Object obj) {
        this.f5349a = i10;
        this.f5350b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f5349a) {
            case 2:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f5350b;
                actionBarOverlayLayout.K = null;
                actionBarOverlayLayout.f419x = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f5349a) {
            case 0:
                m mVar = (m) this.f5350b;
                mVar.p();
                mVar.f5363r.start();
                break;
            case 1:
                ((l4.m) this.f5350b).l();
                animator.removeListener(this);
                break;
            case 2:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f5350b;
                actionBarOverlayLayout.K = null;
                actionBarOverlayLayout.f419x = false;
                break;
            case 3:
                m4.d dVar = (m4.d) this.f5350b;
                ArrayList arrayList = new ArrayList(dVar.f8886s);
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ColorStateList colorStateList = ((r8.a) arrayList.get(i10)).f10967b.C;
                    if (colorStateList != null) {
                        dVar.setTintList(colorStateList);
                    }
                }
                break;
            case 4:
                ((HideBottomViewOnScrollBehavior) this.f5350b).f3663k = null;
                break;
            default:
                ((HideViewOnScrollBehavior) this.f5350b).f3673k = null;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f5349a) {
            case 3:
                m4.d dVar = (m4.d) this.f5350b;
                ArrayList arrayList = new ArrayList(dVar.f8886s);
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    r8.c cVar = ((r8.a) arrayList.get(i10)).f10967b;
                    ColorStateList colorStateList = cVar.C;
                    if (colorStateList != null) {
                        dVar.setTint(colorStateList.getColorForState(cVar.G, colorStateList.getDefaultColor()));
                    }
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
