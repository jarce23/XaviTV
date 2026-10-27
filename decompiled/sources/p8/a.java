package p8;

import com.google.android.material.button.MaterialButton;
import d9.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends com.bumptech.glide.c {
    @Override // com.bumptech.glide.c
    public final void A(y yVar, float f10) {
        ((MaterialButton) yVar).setDisplayedWidthIncrease(f10);
    }

    @Override // com.bumptech.glide.c
    public final float n(y yVar) {
        float displayedWidthIncrease;
        displayedWidthIncrease = ((MaterialButton) yVar).getDisplayedWidthIncrease();
        return displayedWidthIncrease;
    }
}
