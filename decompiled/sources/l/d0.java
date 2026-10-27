package l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends l implements SubMenu {
    public final n A;

    /* renamed from: z, reason: collision with root package name */
    public final l f7958z;

    public d0(Context context, l lVar, n nVar) {
        super(context);
        this.f7958z = lVar;
        this.A = nVar;
    }

    @Override // l.l
    public final boolean d(n nVar) {
        return this.f7958z.d(nVar);
    }

    @Override // l.l
    public final boolean e(l lVar, MenuItem menuItem) {
        return super.e(lVar, menuItem) || this.f7958z.e(lVar, menuItem);
    }

    @Override // l.l
    public final boolean f(n nVar) {
        return this.f7958z.f(nVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // l.l
    public final String j() {
        n nVar = this.A;
        int i10 = nVar != null ? nVar.f8014a : 0;
        if (i10 == 0) {
            return null;
        }
        return android.support.v4.media.d.m(i10, "android:menu:actionviewstates:");
    }

    @Override // l.l
    public final l k() {
        return this.f7958z.k();
    }

    @Override // l.l
    public final boolean m() {
        return this.f7958z.m();
    }

    @Override // l.l
    public final boolean n() {
        return this.f7958z.n();
    }

    @Override // l.l
    public final boolean o() {
        return this.f7958z.o();
    }

    @Override // l.l, android.view.Menu
    public final void setGroupDividerEnabled(boolean z10) {
        this.f7958z.setGroupDividerEnabled(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // l.l, android.view.Menu
    public final void setQwertyMode(boolean z10) {
        this.f7958z.setQwertyMode(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i10) {
        u(0, null, i10, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i10) {
        u(i10, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i10) {
        this.A.setIcon(i10);
        return this;
    }
}
