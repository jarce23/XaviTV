package l;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements g0.a {
    public o A;
    public MenuItem.OnActionExpandListener B;

    /* renamed from: a, reason: collision with root package name */
    public final int f8014a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8015b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8016c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8017d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f8018e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f8019f;
    public Intent g;

    /* renamed from: h, reason: collision with root package name */
    public char f8020h;

    /* renamed from: j, reason: collision with root package name */
    public char f8022j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f8024l;

    /* renamed from: n, reason: collision with root package name */
    public final l f8026n;

    /* renamed from: o, reason: collision with root package name */
    public d0 f8027o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f8028p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f8029q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f8030r;

    /* renamed from: y, reason: collision with root package name */
    public int f8037y;

    /* renamed from: z, reason: collision with root package name */
    public View f8038z;

    /* renamed from: i, reason: collision with root package name */
    public int f8021i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f8023k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f8025m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f8031s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f8032t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8033u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8034v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8035w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f8036x = 16;
    public boolean C = false;

    public n(l lVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f8026n = lVar;
        this.f8014a = i11;
        this.f8015b = i10;
        this.f8016c = i12;
        this.f8017d = i13;
        this.f8018e = charSequence;
        this.f8037y = i14;
    }

    public static void c(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    @Override // g0.a
    public final o a() {
        return this.A;
    }

    @Override // g0.a
    public final g0.a b(o oVar) {
        this.f8038z = null;
        this.A = oVar;
        this.f8026n.p(true);
        o oVar2 = this.A;
        if (oVar2 != null) {
            oVar2.f8039a = new h5.i(14, this);
            oVar2.f8040b.setVisibilityListener(oVar2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f8037y & 8) == 0) {
            return false;
        }
        if (this.f8038z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f8026n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f8035w && (this.f8033u || this.f8034v)) {
            drawable = drawable.mutate();
            if (this.f8033u) {
                drawable.setTintList(this.f8031s);
            }
            if (this.f8034v) {
                drawable.setTintMode(this.f8032t);
            }
            this.f8035w = false;
        }
        return drawable;
    }

    public final boolean e() {
        o oVar;
        if ((this.f8037y & 8) != 0) {
            if (this.f8038z == null && (oVar = this.A) != null) {
                this.f8038z = oVar.f8040b.onCreateActionView(this);
            }
            if (this.f8038z != null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f8026n.f(this);
        }
        return false;
    }

    public final void f(boolean z10) {
        if (z10) {
            this.f8036x |= 32;
        } else {
            this.f8036x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f8038z;
        if (view != null) {
            return view;
        }
        o oVar = this.A;
        if (oVar == null) {
            return null;
        }
        View onCreateActionView = oVar.f8040b.onCreateActionView(this);
        this.f8038z = onCreateActionView;
        return onCreateActionView;
    }

    @Override // g0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f8023k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f8022j;
    }

    @Override // g0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f8029q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f8015b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f8024l;
        if (drawable != null) {
            return d(drawable);
        }
        int i10 = this.f8025m;
        if (i10 == 0) {
            return null;
        }
        Drawable o2 = n4.a.o(this.f8026n.f7988a, i10);
        this.f8025m = 0;
        this.f8024l = o2;
        return d(o2);
    }

    @Override // g0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f8031s;
    }

    @Override // g0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f8032t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f8014a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // g0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f8021i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f8020h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f8016c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f8027o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f8018e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f8019f;
        return charSequence != null ? charSequence : this.f8018e;
    }

    @Override // g0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f8030r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f8027o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f8036x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f8036x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f8036x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        o oVar = this.A;
        return (oVar == null || !oVar.f8040b.overridesItemVisibility()) ? (this.f8036x & 8) == 0 : (this.f8036x & 8) == 0 && this.A.f8040b.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i10;
        this.f8038z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i10 = this.f8014a) > 0) {
            view.setId(i10);
        }
        l lVar = this.f8026n;
        lVar.f7997k = true;
        lVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c10) {
        if (this.f8022j == c10) {
            return this;
        }
        this.f8022j = Character.toLowerCase(c10);
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        int i10 = this.f8036x;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f8036x = i11;
        if (i10 != i11) {
            this.f8026n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        int i10 = this.f8036x;
        int i11 = i10 & 4;
        l lVar = this.f8026n;
        if (i11 == 0) {
            int i12 = (i10 & (-3)) | (z10 ? 2 : 0);
            this.f8036x = i12;
            if (i10 != i12) {
                lVar.p(false);
            }
            return this;
        }
        ArrayList arrayList = lVar.f7993f;
        int size = arrayList.size();
        lVar.w();
        for (int i13 = 0; i13 < size; i13++) {
            n nVar = (n) arrayList.get(i13);
            if (nVar.f8015b == this.f8015b && (nVar.f8036x & 4) != 0 && nVar.isCheckable()) {
                boolean z11 = nVar == this;
                int i14 = nVar.f8036x;
                int i15 = (z11 ? 2 : 0) | (i14 & (-3));
                nVar.f8036x = i15;
                if (i14 != i15) {
                    nVar.f8026n.p(false);
                }
            }
        }
        lVar.v();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f8036x |= 16;
        } else {
            this.f8036x &= -17;
        }
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f8025m = 0;
        this.f8024l = drawable;
        this.f8035w = true;
        this.f8026n.p(false);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8031s = colorStateList;
        this.f8033u = true;
        this.f8035w = true;
        this.f8026n.p(false);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f8032t = mode;
        this.f8034v = true;
        this.f8035w = true;
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c10) {
        if (this.f8020h == c10) {
            return this;
        }
        this.f8020h = c10;
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f8028p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c10, char c11) {
        this.f8020h = c10;
        this.f8022j = Character.toLowerCase(c11);
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f8037y = i10;
        l lVar = this.f8026n;
        lVar.f7997k = true;
        lVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f8018e = charSequence;
        this.f8026n.p(false);
        d0 d0Var = this.f8027o;
        if (d0Var != null) {
            d0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f8019f = charSequence;
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        int i10 = this.f8036x;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f8036x = i11;
        if (i10 != i11) {
            l lVar = this.f8026n;
            lVar.f7994h = true;
            lVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f8018e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // g0.a, android.view.MenuItem
    public final g0.a setContentDescription(CharSequence charSequence) {
        this.f8029q = charSequence;
        this.f8026n.p(false);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final g0.a setTooltipText(CharSequence charSequence) {
        this.f8030r = charSequence;
        this.f8026n.p(false);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f8022j == c10 && this.f8023k == i10) {
            return this;
        }
        this.f8022j = Character.toLowerCase(c10);
        this.f8023k = KeyEvent.normalizeMetaState(i10);
        this.f8026n.p(false);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f8020h == c10 && this.f8021i == i10) {
            return this;
        }
        this.f8020h = c10;
        this.f8021i = KeyEvent.normalizeMetaState(i10);
        this.f8026n.p(false);
        return this;
    }

    @Override // g0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f8020h = c10;
        this.f8021i = KeyEvent.normalizeMetaState(i10);
        this.f8022j = Character.toLowerCase(c11);
        this.f8023k = KeyEvent.normalizeMetaState(i11);
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i10) {
        this.f8024l = null;
        this.f8025m = i10;
        this.f8035w = true;
        this.f8026n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i10) {
        setTitle(this.f8026n.f7988a.getString(i10));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i10) {
        int i11;
        l lVar = this.f8026n;
        Context context = lVar.f7988a;
        View inflate = LayoutInflater.from(context).inflate(i10, (ViewGroup) new LinearLayout(context), false);
        this.f8038z = inflate;
        this.A = null;
        if (inflate != null && inflate.getId() == -1 && (i11 = this.f8014a) > 0) {
            inflate.setId(i11);
        }
        lVar.f7997k = true;
        lVar.p(true);
        return this;
    }
}
