package w8;

import android.content.Context;
import com.bumptech.glide.c;
import com.bumptech.glide.e;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f13141f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f13142a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13143b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13144c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13145d;

    /* renamed from: e, reason: collision with root package name */
    public final float f13146e;

    public a(Context context) {
        boolean y8 = c.y(context, R.attr.elevationOverlayEnabled, false);
        int k10 = e.k(context, R.attr.elevationOverlayColor, 0);
        int k11 = e.k(context, R.attr.elevationOverlayAccentColor, 0);
        int k12 = e.k(context, R.attr.colorSurface, 0);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f13142a = y8;
        this.f13143b = k10;
        this.f13144c = k11;
        this.f13145d = k12;
        this.f13146e = f10;
    }
}
