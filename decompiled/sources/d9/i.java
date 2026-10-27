package d9;

import androidx.fragment.app.v0;
import com.google.android.material.button.MaterialButton;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final int f4275p;

    public i(int i10) {
        this.f4275p = i10;
    }

    @Override // com.bumptech.glide.c
    public final void A(y yVar, float f10) {
        j jVar = (j) yVar;
        float[] fArr = jVar.P;
        if (fArr != null) {
            int i10 = this.f4275p;
            if (fArr[i10] != f10) {
                fArr[i10] = f10;
                v0 v0Var = jVar.R;
                if (v0Var != null) {
                    float h10 = jVar.h();
                    MaterialButton materialButton = (MaterialButton) v0Var.f843p;
                    int i11 = (int) (h10 * 0.11f);
                    if (materialButton.L != i11) {
                        materialButton.L = i11;
                        materialButton.j();
                        materialButton.invalidate();
                    }
                }
                jVar.invalidateSelf();
            }
        }
    }

    @Override // com.bumptech.glide.c
    public final float n(y yVar) {
        float[] fArr = ((j) yVar).P;
        if (fArr != null) {
            return fArr[this.f4275p];
        }
        return 0.0f;
    }
}
