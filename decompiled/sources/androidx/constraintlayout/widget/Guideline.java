package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import x.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i10) {
        d dVar = (d) getLayoutParams();
        dVar.f13178a = i10;
        setLayoutParams(dVar);
    }

    public void setGuidelineEnd(int i10) {
        d dVar = (d) getLayoutParams();
        dVar.f13180b = i10;
        setLayoutParams(dVar);
    }

    public void setGuidelinePercent(float f10) {
        d dVar = (d) getLayoutParams();
        dVar.f13182c = f10;
        setLayoutParams(dVar);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
    }
}
