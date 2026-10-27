package c9;

import android.graphics.Paint;
import android.graphics.Path;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f2971i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f2972j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f2973k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f2974l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f2975a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f2976b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f2977c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2978d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2979e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2980f;
    public final Path g = new Path();

    /* renamed from: h, reason: collision with root package name */
    public final Paint f2981h;

    public a() {
        Paint paint = new Paint();
        this.f2981h = paint;
        Paint paint2 = new Paint();
        this.f2975a = paint2;
        this.f2978d = e0.a.h(-16777216, 68);
        this.f2979e = e0.a.h(-16777216, 20);
        this.f2980f = e0.a.h(-16777216, 0);
        paint2.setColor(this.f2978d);
        paint.setColor(0);
        Paint paint3 = new Paint(4);
        this.f2976b = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f2977c = new Paint(paint3);
    }
}
