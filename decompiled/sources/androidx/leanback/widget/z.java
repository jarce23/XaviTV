package androidx.leanback.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1101a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(Class cls, String str, int i10) {
        super(cls, str);
        this.f1101a = i10;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f1101a) {
            case 0:
                return Float.valueOf(((a0) obj).f1001a);
            case 1:
                return Float.valueOf(((a0) obj).f1005e);
            case 2:
                return Float.valueOf(((a0) obj).f1003c);
            case 3:
                return Integer.valueOf(((t0) obj).getStreamPosition());
            case 4:
                return null;
            case 5:
                return null;
            case 6:
                return null;
            case 7:
                return null;
            case 8:
                return null;
            case 9:
                return Float.valueOf(l4.w.f8260a.w((View) obj));
            case 10:
                return ((View) obj).getClipBounds();
            default:
                return Float.valueOf(((SwitchCompat) obj).N);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f1101a) {
            case 0:
                a0 a0Var = (a0) obj;
                a0Var.f1001a = ((Float) obj2).floatValue();
                a0Var.a();
                a0Var.f1009j.invalidate();
                break;
            case 1:
                a0 a0Var2 = (a0) obj;
                float floatValue = ((Float) obj2).floatValue();
                a0Var2.f1005e = floatValue;
                float f10 = floatValue / 2.0f;
                a0Var2.f1006f = f10;
                PagingIndicator pagingIndicator = a0Var2.f1009j;
                a0Var2.g = f10 * pagingIndicator.J;
                pagingIndicator.invalidate();
                break;
            case 2:
                a0 a0Var3 = (a0) obj;
                a0Var3.f1003c = ((Float) obj2).floatValue() * a0Var3.f1007h * a0Var3.f1008i;
                a0Var3.f1009j.invalidate();
                break;
            case 3:
                ((t0) obj).setStreamPosition(((Integer) obj2).intValue());
                break;
            case 4:
                l4.d dVar = (l4.d) obj;
                PointF pointF = (PointF) obj2;
                dVar.getClass();
                dVar.f8197a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                dVar.f8198b = round;
                int i10 = dVar.f8202f + 1;
                dVar.f8202f = i10;
                if (i10 == dVar.g) {
                    l4.w.a(dVar.f8201e, dVar.f8197a, round, dVar.f8199c, dVar.f8200d);
                    dVar.f8202f = 0;
                    dVar.g = 0;
                    break;
                }
                break;
            case 5:
                l4.d dVar2 = (l4.d) obj;
                PointF pointF2 = (PointF) obj2;
                dVar2.getClass();
                dVar2.f8199c = Math.round(pointF2.x);
                int round2 = Math.round(pointF2.y);
                dVar2.f8200d = round2;
                int i11 = dVar2.g + 1;
                dVar2.g = i11;
                if (dVar2.f8202f == i11) {
                    l4.w.a(dVar2.f8201e, dVar2.f8197a, dVar2.f8198b, dVar2.f8199c, round2);
                    dVar2.f8202f = 0;
                    dVar2.g = 0;
                    break;
                }
                break;
            case 6:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                l4.w.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 7:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                l4.w.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 8:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int round3 = Math.round(pointF5.x);
                int round4 = Math.round(pointF5.y);
                l4.w.a(view3, round3, round4, view3.getWidth() + round3, view3.getHeight() + round4);
                break;
            case 9:
                float floatValue2 = ((Float) obj2).floatValue();
                l4.w.f8260a.F((View) obj, floatValue2);
                break;
            case 10:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
            default:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
        }
    }
}
