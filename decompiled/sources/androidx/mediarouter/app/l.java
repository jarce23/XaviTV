package androidx.mediarouter.app;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Map f1329o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Map f1330p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ s f1331q;

    public l(s sVar, HashMap hashMap, HashMap hashMap2) {
        this.f1331q = sVar;
        this.f1329o = hashMap;
        this.f1330p = hashMap2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Map map;
        Map map2;
        o0 o0Var;
        w3.z zVar;
        s sVar = this.f1331q;
        sVar.S.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        HashSet hashSet = sVar.V;
        if (hashSet == null || sVar.W == null) {
            return;
        }
        int size = hashSet.size() - sVar.W.size();
        m mVar = new m(0, sVar);
        int firstVisiblePosition = sVar.S.getFirstVisiblePosition();
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            int childCount = sVar.S.getChildCount();
            map = this.f1329o;
            map2 = this.f1330p;
            if (i10 >= childCount) {
                break;
            }
            View childAt = sVar.S.getChildAt(i10);
            w3.z zVar2 = (w3.z) sVar.T.getItem(firstVisiblePosition + i10);
            Rect rect = (Rect) map.get(zVar2);
            int top = childAt.getTop();
            int i11 = rect != null ? rect.top : (sVar.f1387c0 * size) + top;
            AnimationSet animationSet = new AnimationSet(true);
            HashSet hashSet2 = sVar.V;
            if (hashSet2 == null || !hashSet2.contains(zVar2)) {
                zVar = zVar2;
            } else {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                zVar = zVar2;
                alphaAnimation.setDuration(sVar.f1409w0);
                animationSet.addAnimation(alphaAnimation);
                i11 = top;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i11 - top, 0.0f);
            translateAnimation.setDuration(sVar.f1407v0);
            animationSet.addAnimation(translateAnimation);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setInterpolator(sVar.f1413y0);
            if (!z10) {
                animationSet.setAnimationListener(mVar);
                z10 = true;
            }
            childAt.clearAnimation();
            childAt.startAnimation(animationSet);
            w3.z zVar3 = zVar;
            map.remove(zVar3);
            map2.remove(zVar3);
            i10++;
        }
        for (Map.Entry entry : map2.entrySet()) {
            w3.z zVar4 = (w3.z) entry.getKey();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
            Rect rect2 = (Rect) map.get(zVar4);
            if (sVar.W.contains(zVar4)) {
                o0Var = new o0(bitmapDrawable, rect2);
                o0Var.f1371h = 0.0f;
                o0Var.f1369e = sVar.f1411x0;
                o0Var.f1368d = sVar.f1413y0;
            } else {
                int i12 = sVar.f1387c0 * size;
                o0 o0Var2 = new o0(bitmapDrawable, rect2);
                o0Var2.g = i12;
                o0Var2.f1369e = sVar.f1407v0;
                o0Var2.f1368d = sVar.f1413y0;
                o0Var2.f1375l = new x4.e(sVar, zVar4, 2, false);
                sVar.X.add(zVar4);
                o0Var = o0Var2;
            }
            sVar.S.f1261o.add(o0Var);
        }
    }
}
