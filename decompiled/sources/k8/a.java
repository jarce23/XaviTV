package k8;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f7830a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final z0.a f7831b = new z0.a(z0.a.f13950d);

    /* renamed from: c, reason: collision with root package name */
    public static final z0.a f7832c = new z0.a();

    /* renamed from: d, reason: collision with root package name */
    public static final z0.a f7833d = new z0.a(z0.a.f13951e);

    static {
        new DecelerateInterpolator();
    }

    public static float a(float f10, float f11, float f12) {
        return ((f11 - f10) * f12) + f10;
    }

    public static float b(float f10, float f11, float f12, float f13, float f14) {
        return f14 <= f12 ? f10 : f14 >= f13 ? f11 : a(f10, f11, (f14 - f12) / (f13 - f12));
    }

    public static int c(float f10, int i10, int i11) {
        return Math.round(f10 * (i11 - i10)) + i10;
    }
}
