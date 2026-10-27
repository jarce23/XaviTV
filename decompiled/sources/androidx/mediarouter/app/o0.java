package androidx.mediarouter.app;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final BitmapDrawable f1365a;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1367c;

    /* renamed from: d, reason: collision with root package name */
    public Interpolator f1368d;

    /* renamed from: e, reason: collision with root package name */
    public long f1369e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f1370f;
    public int g;

    /* renamed from: i, reason: collision with root package name */
    public long f1372i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1373j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1374k;

    /* renamed from: l, reason: collision with root package name */
    public x4.e f1375l;

    /* renamed from: b, reason: collision with root package name */
    public float f1366b = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f1371h = 1.0f;

    public o0(BitmapDrawable bitmapDrawable, Rect rect) {
        this.f1365a = bitmapDrawable;
        this.f1370f = rect;
        Rect rect2 = new Rect(rect);
        this.f1367c = rect2;
        if (bitmapDrawable != null) {
            bitmapDrawable.setAlpha((int) (this.f1366b * 255.0f));
            bitmapDrawable.setBounds(rect2);
        }
    }
}
