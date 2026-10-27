package l;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements g0.a {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f7927a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f7928b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f7929c;

    /* renamed from: d, reason: collision with root package name */
    public char f7930d;

    /* renamed from: e, reason: collision with root package name */
    public int f7931e;

    /* renamed from: f, reason: collision with root package name */
    public char f7932f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f7933h;

    /* renamed from: i, reason: collision with root package name */
    public Context f7934i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f7935j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f7936k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f7937l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f7938m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7939n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7940o;

    /* renamed from: p, reason: collision with root package name */
    public int f7941p;

    @Override // g0.a
    public final o a() {
        return null;
    }

    @Override // g0.a
    public final g0.a b(o oVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f7933h;
        if (drawable != null) {
            if (this.f7939n || this.f7940o) {
                this.f7933h = drawable;
                Drawable mutate = drawable.mutate();
                this.f7933h = mutate;
                if (this.f7939n) {
                    mutate.setTintList(this.f7937l);
                }
                if (this.f7940o) {
                    this.f7933h.setTintMode(this.f7938m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // g0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f7932f;
    }

    @Override // g0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f7935j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f7933h;
    }

    @Override // g0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f7937l;
    }

    @Override // g0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f7938m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f7929c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // g0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f7931e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f7930d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f7927a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f7928b;
        return charSequence != null ? charSequence : this.f7927a;
    }

    @Override // g0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f7936k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f7941p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f7941p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f7941p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f7941p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c10) {
        this.f7932f = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        this.f7941p = (z10 ? 1 : 0) | (this.f7941p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        this.f7941p = (z10 ? 2 : 0) | (this.f7941p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f7935j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        this.f7941p = (z10 ? 16 : 0) | (this.f7941p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f7933h = drawable;
        c();
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f7937l = colorStateList;
        this.f7939n = true;
        c();
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f7938m = mode;
        this.f7940o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f7929c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c10) {
        this.f7930d = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c10, char c11) {
        this.f7930d = c10;
        this.f7932f = Character.toLowerCase(c11);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f7927a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f7928b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f7936k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        this.f7941p = (this.f7941p & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f7932f = Character.toLowerCase(c10);
        this.g = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final g0.a setContentDescription(CharSequence charSequence) {
        this.f7935j = charSequence;
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c10, int i10) {
        this.f7930d = c10;
        this.f7931e = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i10) {
        this.f7927a = this.f7934i.getResources().getString(i10);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final g0.a setTooltipText(CharSequence charSequence) {
        this.f7936k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i10) {
        this.f7933h = this.f7934i.getDrawable(i10);
        c();
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f7930d = c10;
        this.f7931e = KeyEvent.normalizeMetaState(i10);
        this.f7932f = Character.toLowerCase(c11);
        this.g = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i10) {
        return this;
    }
}
