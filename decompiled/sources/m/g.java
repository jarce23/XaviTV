package m;

import android.content.Context;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends l.v {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8410l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k f8411m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, Context context, l.l lVar, View view) {
        super(context, lVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.f8411m = kVar;
        this.f8055f = 8388613;
        h5.i iVar = kVar.K;
        this.f8056h = iVar;
        l.t tVar = this.f8057i;
        if (tVar != null) {
            tVar.d(iVar);
        }
    }

    @Override // l.v
    public final void c() {
        switch (this.f8410l) {
            case 0:
                k kVar = this.f8411m;
                kVar.H = null;
                kVar.getClass();
                super.c();
                break;
            default:
                k kVar2 = this.f8411m;
                l.l lVar = kVar2.f8452q;
                if (lVar != null) {
                    lVar.c(true);
                }
                kVar2.G = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, Context context, l.d0 d0Var, View view) {
        super(context, d0Var, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.f8411m = kVar;
        if ((d0Var.A.f8036x & 32) != 32) {
            View view2 = kVar.f8458w;
            this.f8054e = view2 == null ? (View) kVar.f8457v : view2;
        }
        h5.i iVar = kVar.K;
        this.f8056h = iVar;
        l.t tVar = this.f8057i;
        if (tVar != null) {
            tVar.d(iVar);
        }
    }
}
