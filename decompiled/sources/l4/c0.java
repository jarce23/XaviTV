package l4;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 extends b0 {
    @Override // com.bumptech.glide.d
    public final void F(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // l4.b0, com.bumptech.glide.d
    public final void G(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // l4.b0
    public final void Q(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // l4.b0
    public final void R(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // l4.b0
    public final void S(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // com.bumptech.glide.d
    public final float w(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }
}
