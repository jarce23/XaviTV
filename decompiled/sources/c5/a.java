package c5;

import android.view.View;
import android.view.ViewParent;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.helper.s;
import app.shamel.tv.models.CategoryModel;
import com.google.android.material.sidesheet.SideSheetBehavior;
import i1.a0;
import i1.m0;
import i1.t0;
import io.realm.n0;
import java.lang.ref.WeakReference;
import n0.q;
import okhttp3.internal.url._UrlKt;
import s1.y0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements s, q, l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2923o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f2924p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f2925q;

    public /* synthetic */ a(int i10, int i11, Object obj) {
        this.f2923o = i11;
        this.f2925q = obj;
        this.f2924p = i10;
    }

    @Override // n0.q
    public boolean f(View view) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2925q;
        int i10 = this.f2924p;
        if (i10 == 1 || i10 == 2) {
            throw new IllegalArgumentException(android.support.v4.media.d.r(new StringBuilder("STATE_"), i10 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = sideSheetBehavior.f3830p;
        if (weakReference == null || weakReference.get() == null) {
            sideSheetBehavior.r(i10);
            return true;
        }
        View view2 = (View) sideSheetBehavior.f3830p.get();
        d0.j jVar = new d0.j(i10, 1, sideSheetBehavior);
        ViewParent parent = view2.getParent();
        if (parent != null && parent.isLayoutRequested() && view2.isAttachedToWindow()) {
            view2.post(jVar);
            return true;
        }
        jVar.run();
        return true;
    }

    @Override // l1.m
    public void invoke(Object obj) {
        switch (this.f2923o) {
            case 2:
                t0 t0Var = ((y0) this.f2925q).f11493a;
                ((m0) obj).e(this.f2924p);
                break;
            default:
                ((m0) obj).s((a0) this.f2925q, this.f2924p);
                break;
        }
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) this.f2925q;
        if (((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0)).getId().equalsIgnoreCase("fav_id")) {
            n0 w10 = a6.n.K().w((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelMobileActivity.f1942v0.g(), liveChannelMobileActivity.f1942v0.o());
            liveChannelMobileActivity.f1928i0 = w10;
            liveChannelMobileActivity.f1918c0.q(-1, w10);
        } else {
            liveChannelMobileActivity.f1918c0.e(this.f2924p);
        }
        liveChannelMobileActivity.f1942v0.S(a6.n.K().t());
    }
}
