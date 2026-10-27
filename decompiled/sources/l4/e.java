package l4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import j9.v1;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends m {
    public static final String[] O = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final androidx.leanback.widget.z P = new androidx.leanback.widget.z(PointF.class, "topLeft", 4);
    public static final androidx.leanback.widget.z Q = new androidx.leanback.widget.z(PointF.class, "bottomRight", 5);
    public static final androidx.leanback.widget.z R = new androidx.leanback.widget.z(PointF.class, "bottomRight", 6);
    public static final androidx.leanback.widget.z S = new androidx.leanback.widget.z(PointF.class, "topLeft", 7);
    public static final androidx.leanback.widget.z T = new androidx.leanback.widget.z(PointF.class, "position", 8);

    public static void H(u uVar) {
        View view = uVar.f8258b;
        HashMap hashMap = uVar.f8257a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        hashMap.put("android:changeBounds:parent", view.getParent());
    }

    @Override // l4.m
    public final void c(u uVar) {
        H(uVar);
    }

    @Override // l4.m
    public final void f(u uVar) {
        H(uVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l4.m
    public final Animator j(ViewGroup viewGroup, u uVar, u uVar2) {
        int i10;
        e eVar;
        ObjectAnimator a10;
        if (uVar != null) {
            HashMap hashMap = uVar.f8257a;
            if (uVar2 != null) {
                HashMap hashMap2 = uVar2.f8257a;
                ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = uVar2.f8258b;
                    Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                    int i11 = rect.left;
                    int i12 = rect2.left;
                    int i13 = rect.top;
                    int i14 = rect2.top;
                    int i15 = rect.right;
                    int i16 = rect2.right;
                    int i17 = rect.bottom;
                    int i18 = rect2.bottom;
                    int i19 = i15 - i11;
                    int i20 = i17 - i13;
                    int i21 = i16 - i12;
                    int i22 = i18 - i14;
                    Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                    if ((i19 == 0 || i20 == 0) && (i21 == 0 || i22 == 0)) {
                        i10 = 0;
                    } else {
                        i10 = (i11 == i12 && i13 == i14) ? 0 : 1;
                        if (i15 != i16 || i17 != i18) {
                            i10++;
                        }
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i10++;
                    }
                    int i23 = i10;
                    if (i23 > 0) {
                        w.a(view, i11, i13, i15, i17);
                        if (i23 != 2) {
                            eVar = this;
                            if (i11 == i12 && i13 == i14) {
                                eVar.J.getClass();
                                a10 = h.a(view, R, v1.x(i15, i17, i16, i18));
                            } else {
                                eVar.J.getClass();
                                a10 = h.a(view, S, v1.x(i11, i13, i12, i14));
                            }
                        } else if (i19 == i21 && i20 == i22) {
                            eVar = this;
                            eVar.J.getClass();
                            a10 = h.a(view, T, v1.x(i11, i13, i12, i14));
                        } else {
                            eVar = this;
                            d dVar = new d(view);
                            eVar.J.getClass();
                            ObjectAnimator a11 = h.a(dVar, P, v1.x(i11, i13, i12, i14));
                            eVar.J.getClass();
                            ObjectAnimator a12 = h.a(dVar, Q, v1.x(i15, i17, i16, i18));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(a11, a12);
                            animatorSet.addListener(new b(dVar));
                            a10 = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            com.bumptech.glide.c.B(viewGroup4, true);
                            eVar.n().a(new c(viewGroup4));
                        }
                        return a10;
                    }
                }
            }
        }
        return null;
    }

    @Override // l4.m
    public final String[] p() {
        return O;
    }
}
