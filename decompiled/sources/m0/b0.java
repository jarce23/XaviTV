package m0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public q1 f8640a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f8641b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f8642c;

    public b0(View view, m mVar) {
        this.f8641b = view;
        this.f8642c = mVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        q1 g = q1.g(view, windowInsets);
        int i10 = Build.VERSION.SDK_INT;
        m mVar = this.f8642c;
        if (i10 < 30) {
            c0.a(windowInsets, this.f8641b);
            if (g.equals(this.f8640a)) {
                return mVar.f(view, g).f();
            }
        }
        this.f8640a = g;
        q1 f10 = mVar.f(view, g);
        if (i10 >= 30) {
            return f10.f();
        }
        WeakHashMap weakHashMap = k0.f8683a;
        a0.c(view);
        return f10.f();
    }
}
