package l;

import android.view.MenuItem;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f8042a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f8043b;

    public q(s sVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f8043b = sVar;
        this.f8042a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f8042a.onMenuItemActionCollapse(this.f8043b.g(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f8042a.onMenuItemActionExpand(this.f8043b.g(menuItem));
    }
}
