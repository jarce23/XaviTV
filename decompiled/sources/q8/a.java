package q8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.google.android.material.carousel.CarouselLayoutManager;
import u3.o;
import u3.p;
import u3.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10362a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10363b;

    public /* synthetic */ a(int i10, Object obj) {
        this.f10362a = i10;
        this.f10363b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int height;
        int height2;
        switch (this.f10362a) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) this.f10363b;
                if (i12 - i10 != i16 - i14 || i13 - i11 != i17 - i15) {
                    view.post(new androidx.activity.d(19, carouselLayoutManager));
                    break;
                }
                break;
            case 1:
                o oVar = (o) this.f10363b;
                int i18 = oVar.F;
                PopupWindow popupWindow = oVar.E;
                int i19 = i13 - i11;
                int i20 = i17 - i15;
                if ((i12 - i10 != i16 - i14 || i19 != i20) && popupWindow.isShowing()) {
                    oVar.u();
                    popupWindow.update(view, (oVar.getWidth() - popupWindow.getWidth()) - i18, (-popupWindow.getHeight()) - i18, -1, -1);
                    break;
                }
                break;
            default:
                t tVar = (t) this.f10363b;
                o oVar2 = tVar.f12479a;
                int width = (oVar2.getWidth() - oVar2.getPaddingLeft()) - oVar2.getPaddingRight();
                int height3 = (oVar2.getHeight() - oVar2.getPaddingBottom()) - oVar2.getPaddingTop();
                ViewGroup viewGroup = tVar.f12481c;
                int c10 = t.c(viewGroup) - (viewGroup != null ? viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() : 0);
                if (viewGroup == null) {
                    height = 0;
                } else {
                    height = viewGroup.getHeight();
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        height += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                }
                int paddingBottom = height - (viewGroup != null ? viewGroup.getPaddingBottom() + viewGroup.getPaddingTop() : 0);
                int max = Math.max(c10, t.c(tVar.f12488k) + t.c(tVar.f12486i));
                ViewGroup viewGroup2 = tVar.f12482d;
                if (viewGroup2 == null) {
                    height2 = 0;
                } else {
                    height2 = viewGroup2.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        height2 += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                    }
                }
                boolean z10 = width <= max || height3 <= (height2 * 2) + paddingBottom;
                if (tVar.A != z10) {
                    tVar.A = z10;
                    view.post(new p(tVar, 1));
                }
                boolean z11 = i12 - i10 != i16 - i14;
                if (!tVar.A && z11) {
                    view.post(new p(tVar, 2));
                    break;
                }
                break;
        }
    }
}
