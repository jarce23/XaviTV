package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class OverlayListView extends ListView {

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f1261o;

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1261o = new ArrayList();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        boolean z10;
        super.onDraw(canvas);
        ArrayList arrayList = this.f1261o;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                o0 o0Var = (o0) it.next();
                BitmapDrawable bitmapDrawable = o0Var.f1365a;
                if (bitmapDrawable != null) {
                    bitmapDrawable.draw(canvas);
                }
                long drawingTime = getDrawingTime();
                BitmapDrawable bitmapDrawable2 = o0Var.f1365a;
                Rect rect = o0Var.f1367c;
                if (o0Var.f1374k) {
                    z10 = false;
                } else {
                    float max = o0Var.f1373j ? Math.max(0.0f, Math.min(1.0f, (drawingTime - o0Var.f1372i) / o0Var.f1369e)) : 0.0f;
                    Interpolator interpolator = o0Var.f1368d;
                    float interpolation = interpolator == null ? max : interpolator.getInterpolation(max);
                    int i10 = (int) (o0Var.g * interpolation);
                    Rect rect2 = o0Var.f1370f;
                    rect.top = rect2.top + i10;
                    rect.bottom = rect2.bottom + i10;
                    float f10 = ((o0Var.f1371h - 1.0f) * interpolation) + 1.0f;
                    o0Var.f1366b = f10;
                    if (bitmapDrawable2 != null) {
                        bitmapDrawable2.setAlpha((int) (f10 * 255.0f));
                        bitmapDrawable2.setBounds(rect);
                    }
                    if (o0Var.f1373j && max >= 1.0f) {
                        o0Var.f1374k = true;
                        x4.e eVar = o0Var.f1375l;
                        if (eVar != null) {
                            s sVar = (s) eVar.f13543q;
                            sVar.X.remove((w3.z) eVar.f13542p);
                            sVar.T.notifyDataSetChanged();
                        }
                    }
                    z10 = !o0Var.f1374k;
                }
                if (!z10) {
                    it.remove();
                }
            }
        }
    }
}
