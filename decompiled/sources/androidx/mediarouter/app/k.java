package androidx.mediarouter.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends Animation {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1323o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f1324p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f1325q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ View f1326r;

    public /* synthetic */ k(int i10, int i11, View view, int i12) {
        this.f1323o = i12;
        this.f1324p = i10;
        this.f1325q = i11;
        this.f1326r = view;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f10, Transformation transformation) {
        int i10 = this.f1323o;
        View view = this.f1326r;
        int i11 = this.f1325q;
        int i12 = this.f1324p;
        switch (i10) {
            case 0:
                s.o(view, i12 - ((int) ((i12 - i11) * f10)));
                break;
            default:
                int i13 = i11 + ((int) ((i12 - i11) * f10));
                int i14 = n0.h0;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = i13;
                view.setLayoutParams(layoutParams);
                break;
        }
    }
}
