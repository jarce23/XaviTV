package d9;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public i7.e f4300a = new l();

    /* renamed from: b, reason: collision with root package name */
    public i7.e f4301b = new l();

    /* renamed from: c, reason: collision with root package name */
    public i7.e f4302c = new l();

    /* renamed from: d, reason: collision with root package name */
    public i7.e f4303d = new l();

    /* renamed from: e, reason: collision with root package name */
    public d f4304e = new a(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public d f4305f = new a(0.0f);
    public d g = new a(0.0f);

    /* renamed from: h, reason: collision with root package name */
    public d f4306h = new a(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public f f4307i;

    /* renamed from: j, reason: collision with root package name */
    public f f4308j;

    /* renamed from: k, reason: collision with root package name */
    public f f4309k;

    /* renamed from: l, reason: collision with root package name */
    public f f4310l;

    public n() {
        int i10 = 0;
        this.f4307i = new f(i10);
        this.f4308j = new f(i10);
        this.f4309k = new f(i10);
        this.f4310l = new f(i10);
    }

    public static m a(Context context, int i10, int i11, a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i11, true);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(j8.a.f7204y);
        try {
            int i12 = obtainStyledAttributes.getInt(0, 0);
            int i13 = obtainStyledAttributes.getInt(3, i12);
            int i14 = obtainStyledAttributes.getInt(4, i12);
            int i15 = obtainStyledAttributes.getInt(2, i12);
            int i16 = obtainStyledAttributes.getInt(1, i12);
            d c10 = c(obtainStyledAttributes, 5, aVar);
            d c11 = c(obtainStyledAttributes, 8, c10);
            d c12 = c(obtainStyledAttributes, 9, c10);
            d c13 = c(obtainStyledAttributes, 7, c10);
            d c14 = c(obtainStyledAttributes, 6, c10);
            m mVar = new m();
            mVar.f4289a = j1.c.h(i13);
            mVar.f4293e = c11;
            mVar.f4290b = j1.c.h(i14);
            mVar.f4294f = c12;
            mVar.f4291c = j1.c.h(i15);
            mVar.g = c13;
            mVar.f4292d = j1.c.h(i16);
            mVar.f4295h = c14;
            return mVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static m b(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j8.a.f7197r, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static d c(TypedArray typedArray, int i10, d dVar) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue != null) {
            int i11 = peekValue.type;
            if (i11 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i11 == 6) {
                return new k(peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return dVar;
    }

    public final boolean d() {
        return (this.f4301b instanceof l) && (this.f4300a instanceof l) && (this.f4302c instanceof l) && (this.f4303d instanceof l);
    }

    public final boolean e(RectF rectF) {
        boolean z10 = this.f4310l.getClass().equals(f.class) && this.f4308j.getClass().equals(f.class) && this.f4307i.getClass().equals(f.class) && this.f4309k.getClass().equals(f.class);
        float a10 = this.f4304e.a(rectF);
        return z10 && ((this.f4305f.a(rectF) > a10 ? 1 : (this.f4305f.a(rectF) == a10 ? 0 : -1)) == 0 && (this.f4306h.a(rectF) > a10 ? 1 : (this.f4306h.a(rectF) == a10 ? 0 : -1)) == 0 && (this.g.a(rectF) > a10 ? 1 : (this.g.a(rectF) == a10 ? 0 : -1)) == 0) && d();
    }

    public final m f() {
        m mVar = new m();
        mVar.f4289a = this.f4300a;
        mVar.f4290b = this.f4301b;
        mVar.f4291c = this.f4302c;
        mVar.f4292d = this.f4303d;
        mVar.f4293e = this.f4304e;
        mVar.f4294f = this.f4305f;
        mVar.g = this.g;
        mVar.f4295h = this.f4306h;
        mVar.f4296i = this.f4307i;
        mVar.f4297j = this.f4308j;
        mVar.f4298k = this.f4309k;
        mVar.f4299l = this.f4310l;
        return mVar;
    }

    public final String toString() {
        return "[" + this.f4304e + ", " + this.f4305f + ", " + this.g + ", " + this.f4306h + "]";
    }
}
