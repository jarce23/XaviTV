package m;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends d0.b {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f8485h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8486i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ WeakReference f8487j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ s0 f8488k;

    public n0(s0 s0Var, int i10, int i11, WeakReference weakReference) {
        this.f8488k = s0Var;
        this.f8485h = i10;
        this.f8486i = i11;
        this.f8487j = weakReference;
    }

    @Override // d0.b
    public final void j(Typeface typeface) {
        int i10;
        if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f8485h) != -1) {
            typeface = r0.a(typeface, i10, (this.f8486i & 2) != 0);
        }
        s0 s0Var = this.f8488k;
        if (s0Var.f8553m) {
            s0Var.f8552l = typeface;
            TextView textView = (TextView) this.f8487j.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new androidx.activity.h(textView, typeface, s0Var.f8550j, 5));
                } else {
                    textView.setTypeface(typeface, s0Var.f8550j);
                }
            }
        }
    }

    @Override // d0.b
    public final void i(int i10) {
    }
}
