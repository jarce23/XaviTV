package j6;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import i6.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7120o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f7121p;

    public /* synthetic */ d(int i10, Object obj) {
        this.f7120o = i10;
        this.f7121p = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f7120o) {
            case 0:
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                e eVar = (e) ((WeakReference) this.f7121p).get();
                if (eVar != null) {
                    ArrayList arrayList = eVar.f7124b;
                    View view = eVar.f7123a;
                    if (!arrayList.isEmpty()) {
                        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        int i10 = 0;
                        int a10 = eVar.a(view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                        int a11 = eVar.a(view.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (a10 > 0 || a10 == Integer.MIN_VALUE) {
                            if (a11 > 0 || a11 == Integer.MIN_VALUE) {
                                ArrayList arrayList2 = new ArrayList(arrayList);
                                int size = arrayList2.size();
                                while (i10 < size) {
                                    Object obj = arrayList2.get(i10);
                                    i10++;
                                    ((f) ((b) obj)).l(a10, a11);
                                }
                                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(eVar.f7125c);
                                }
                                eVar.f7125c = null;
                                arrayList.clear();
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                ((CoordinatorLayout) this.f7121p).p(0);
                break;
            default:
                ((z9.a) this.f7121p).e();
                break;
        }
        return true;
    }

    public d(e eVar) {
        this.f7120o = 0;
        this.f7121p = new WeakReference(eVar);
    }
}
