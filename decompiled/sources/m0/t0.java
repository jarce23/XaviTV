package m0;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t0 extends w0 {

    /* renamed from: e, reason: collision with root package name */
    public static final PathInterpolator f8717e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

    /* renamed from: f, reason: collision with root package name */
    public static final z0.a f8718f = new z0.a();
    public static final DecelerateInterpolator g = new DecelerateInterpolator(1.5f);

    /* renamed from: h, reason: collision with root package name */
    public static final AccelerateInterpolator f8719h = new AccelerateInterpolator(1.5f);

    public static void e(View view) {
        io.realm.internal.p j10 = j(view);
        if (j10 != null) {
            ((View) j10.f6758r).setTranslationY(0.0f);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                e(viewGroup.getChildAt(i10));
            }
        }
    }

    public static void f(View view, q1 q1Var, boolean z10) {
        io.realm.internal.p j10 = j(view);
        if (j10 != null) {
            j10.f6757q = q1Var;
            if (!z10) {
                View view2 = (View) j10.f6758r;
                int[] iArr = (int[]) j10.f6759s;
                view2.getLocationOnScreen(iArr);
                z10 = true;
                j10.f6755o = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                f(viewGroup.getChildAt(i10), q1Var, z10);
            }
        }
    }

    public static void g(View view, q1 q1Var, List list) {
        io.realm.internal.p j10 = j(view);
        if (j10 != null) {
            j10.c(q1Var, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                g(viewGroup.getChildAt(i10), q1Var, list);
            }
        }
    }

    public static void h(View view, x4.e eVar) {
        io.realm.internal.p j10 = j(view);
        if (j10 != null) {
            View view2 = (View) j10.f6758r;
            int[] iArr = (int[]) j10.f6759s;
            view2.getLocationOnScreen(iArr);
            int i10 = j10.f6755o - iArr[1];
            j10.f6756p = i10;
            view2.setTranslationY(i10);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                h(viewGroup.getChildAt(i11), eVar);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static io.realm.internal.p j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof s0) {
            return ((s0) tag).f8715a;
        }
        return null;
    }
}
