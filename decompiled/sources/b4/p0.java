package b4;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class p0 extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public f1 f2381a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f2382b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2383c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2384d;

    public p0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2382b = new Rect();
        this.f2383c = true;
        this.f2384d = false;
    }

    public p0(int i10, int i11) {
        super(i10, i11);
        this.f2382b = new Rect();
        this.f2383c = true;
        this.f2384d = false;
    }

    public p0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f2382b = new Rect();
        this.f2383c = true;
        this.f2384d = false;
    }

    public p0(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f2382b = new Rect();
        this.f2383c = true;
        this.f2384d = false;
    }

    public p0(p0 p0Var) {
        super((ViewGroup.LayoutParams) p0Var);
        this.f2382b = new Rect();
        this.f2383c = true;
        this.f2384d = false;
    }
}
