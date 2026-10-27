package l;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import m.r1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends r1 {

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f7943x = 0;

    /* renamed from: y, reason: collision with root package name */
    public final /* synthetic */ View f7944y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f7944y = actionMenuItemView;
    }

    @Override // m.r1
    public final b0 b() {
        m.g gVar;
        switch (this.f7943x) {
            case 0:
                c cVar = ((ActionMenuItemView) this.f7944y).A;
                if (cVar == null || (gVar = ((m.h) cVar).f8421a.H) == null) {
                    return null;
                }
                return gVar.a();
            default:
                m.g gVar2 = ((m.j) this.f7944y).f8441r.G;
                if (gVar2 == null) {
                    return null;
                }
                return gVar2.a();
        }
    }

    @Override // m.r1
    public final boolean c() {
        b0 b2;
        switch (this.f7943x) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f7944y;
                k kVar = actionMenuItemView.f373y;
                return kVar != null && kVar.c(actionMenuItemView.f370v) && (b2 = b()) != null && b2.a();
            default:
                ((m.j) this.f7944y).f8441r.l();
                return true;
        }
    }

    @Override // m.r1
    public boolean d() {
        switch (this.f7943x) {
            case 1:
                m.k kVar = ((m.j) this.f7944y).f8441r;
                if (kVar.I != null) {
                    return false;
                }
                kVar.c();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(m.j jVar, m.j jVar2) {
        super(jVar2);
        this.f7944y = jVar;
    }
}
