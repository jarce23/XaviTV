package d0;

import android.os.Looper;
import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import i2.k0;
import l1.a0;
import s1.t;
import s1.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3978o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f3979p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f3980q;

    public /* synthetic */ j(int i10, int i11, Object obj) {
        this.f3978o = i11;
        this.f3980q = obj;
        this.f3979p = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f3978o;
        int i11 = this.f3979p;
        Object obj = this.f3980q;
        switch (i10) {
            case 0:
                ((b) obj).i(i11);
                break;
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.f3830p.get();
                if (view != null) {
                    sideSheetBehavior.t(view, i11, false);
                    break;
                }
                break;
            case 2:
                ((j1.a) obj).f6939b.onAudioFocusChange(i11);
                break;
            default:
                x xVar = ((k0) obj).f6227c;
                int i12 = a0.f8067a;
                b4.b bVar = xVar.f11482o.F;
                t tVar = new t(i11, 2);
                bVar.getClass();
                l1.d.g(Looper.myLooper() == ((l1.x) bVar.f2177c).f8138a.getLooper());
                bVar.f2175a++;
                bVar.t(new androidx.fragment.app.d(bVar, 12, tVar));
                bVar.z(Integer.valueOf(i11));
                break;
        }
    }
}
