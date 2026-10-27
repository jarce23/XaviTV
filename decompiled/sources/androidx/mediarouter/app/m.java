package androidx.mediarouter.app;

import android.view.animation.Animation;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1341a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1342b;

    public /* synthetic */ m(int i10, Object obj) {
        this.f1341a = i10;
        this.f1342b = obj;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f1341a) {
            case 0:
                break;
            case 1:
                ((s) this.f1342b).k(true);
                break;
            default:
                n0 n0Var = ((l0) this.f1342b).f1340m;
                n0Var.M = false;
                n0Var.o();
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i10 = this.f1341a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        switch (this.f1341a) {
            case 0:
                s sVar = (s) this.f1342b;
                OverlayListView overlayListView = sVar.S;
                ArrayList arrayList = overlayListView.f1261o;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    o0 o0Var = (o0) obj;
                    if (!o0Var.f1373j) {
                        o0Var.f1372i = overlayListView.getDrawingTime();
                        o0Var.f1373j = true;
                    }
                }
                sVar.S.postDelayed(sVar.C0, sVar.f1407v0);
                break;
            case 1:
                break;
            default:
                ((l0) this.f1342b).f1340m.M = true;
                break;
        }
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }

    private final void e(Animation animation) {
    }
}
