package l;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import m.e2;
import m.i0;
import m.l0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7956o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f7957p;

    public /* synthetic */ d(int i10, Object obj) {
        this.f7956o = i10;
        this.f7957p = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f7956o) {
            case 0:
                f fVar = (f) this.f7957p;
                ArrayList arrayList = fVar.f7968v;
                if (fVar.a() && arrayList.size() > 0) {
                    int i10 = 0;
                    if (!((e) arrayList.get(0)).f7959a.M) {
                        View view = fVar.C;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i10 < size) {
                                Object obj = arrayList.get(i10);
                                i10++;
                                ((e) obj).f7959a.c();
                            }
                            break;
                        } else {
                            fVar.dismiss();
                            break;
                        }
                    }
                }
                break;
            case 1:
                c0 c0Var = (c0) this.f7957p;
                e2 e2Var = c0Var.f7951v;
                if (c0Var.a() && !e2Var.M) {
                    View view2 = c0Var.A;
                    if (view2 != null && view2.isShown()) {
                        e2Var.c();
                        break;
                    } else {
                        c0Var.dismiss();
                        break;
                    }
                }
                break;
            case 2:
                l0 l0Var = (l0) this.f7957p;
                if (!l0Var.getInternalPopup().a()) {
                    l0Var.f8472t.k(l0Var.getTextDirection(), l0Var.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = l0Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    break;
                }
                break;
            default:
                i0 i0Var = (i0) this.f7957p;
                l0 l0Var2 = i0Var.V;
                i0Var.getClass();
                if (!l0Var2.isAttachedToWindow() || !l0Var2.getGlobalVisibleRect(i0Var.T)) {
                    i0Var.dismiss();
                    break;
                } else {
                    i0Var.s();
                    i0Var.c();
                    break;
                }
                break;
        }
    }
}
