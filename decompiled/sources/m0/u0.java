package m0;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 extends WindowInsetsAnimation$Callback {

    /* renamed from: a, reason: collision with root package name */
    public final io.realm.internal.p f8723a;

    /* renamed from: b, reason: collision with root package name */
    public List f8724b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f8725c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f8726d;

    public u0(io.realm.internal.p pVar) {
        super(0);
        this.f8726d = new HashMap();
        this.f8723a = pVar;
    }

    public final x0 a(WindowInsetsAnimation windowInsetsAnimation) {
        x0 x0Var = (x0) this.f8726d.get(windowInsetsAnimation);
        if (x0Var == null) {
            x0Var = new x0(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                x0Var.f8738a = new v0(windowInsetsAnimation);
            }
            this.f8726d.put(windowInsetsAnimation, x0Var);
        }
        return x0Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        ((View) this.f8723a.f6758r).setTranslationY(0.0f);
        this.f8726d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        io.realm.internal.p pVar = this.f8723a;
        View view = (View) pVar.f6758r;
        int[] iArr = (int[]) pVar.f6759s;
        view.getLocationOnScreen(iArr);
        pVar.f6755o = iArr[1];
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        float fraction;
        ArrayList arrayList = this.f8725c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f8725c = arrayList2;
            this.f8724b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation k10 = i2.b0.k(list.get(size));
            x0 a10 = a(k10);
            fraction = k10.getFraction();
            a10.f8738a.d(fraction);
            this.f8725c.add(a10);
        }
        q1 g = q1.g(null, windowInsets);
        this.f8723a.c(g, this.f8724b);
        return g.f();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        Insets lowerBound;
        Insets upperBound;
        a(windowInsetsAnimation);
        lowerBound = bounds.getLowerBound();
        e0.c c10 = e0.c.c(lowerBound);
        upperBound = bounds.getUpperBound();
        e0.c c11 = e0.c.c(upperBound);
        io.realm.internal.p pVar = this.f8723a;
        View view = (View) pVar.f6758r;
        int[] iArr = (int[]) pVar.f6759s;
        view.getLocationOnScreen(iArr);
        int i10 = pVar.f6755o - iArr[1];
        pVar.f6756p = i10;
        view.setTranslationY(i10);
        i2.b0.m();
        return i2.b0.i(c10.d(), c11.d());
    }
}
