package v5;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import p4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final int f12679e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12680a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityManager f12681b;

    /* renamed from: c, reason: collision with root package name */
    public final p f12682c;

    /* renamed from: d, reason: collision with root package name */
    public final float f12683d;

    static {
        f12679e = Build.VERSION.SDK_INT < 26 ? 4 : 1;
    }

    public d(Context context) {
        this.f12683d = f12679e;
        this.f12680a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f12681b = activityManager;
        this.f12682c = new p(20, context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
            return;
        }
        this.f12683d = 0.0f;
    }
}
