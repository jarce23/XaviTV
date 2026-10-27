package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import l.n;
import l.o;
import l.s;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ h E;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f7538a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7544h;

    /* renamed from: i, reason: collision with root package name */
    public int f7545i;

    /* renamed from: j, reason: collision with root package name */
    public int f7546j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f7547k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f7548l;

    /* renamed from: m, reason: collision with root package name */
    public int f7549m;

    /* renamed from: n, reason: collision with root package name */
    public char f7550n;

    /* renamed from: o, reason: collision with root package name */
    public int f7551o;

    /* renamed from: p, reason: collision with root package name */
    public char f7552p;

    /* renamed from: q, reason: collision with root package name */
    public int f7553q;

    /* renamed from: r, reason: collision with root package name */
    public int f7554r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7555s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7556t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7557u;

    /* renamed from: v, reason: collision with root package name */
    public int f7558v;

    /* renamed from: w, reason: collision with root package name */
    public int f7559w;

    /* renamed from: x, reason: collision with root package name */
    public String f7560x;

    /* renamed from: y, reason: collision with root package name */
    public String f7561y;

    /* renamed from: z, reason: collision with root package name */
    public o f7562z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;

    /* renamed from: b, reason: collision with root package name */
    public int f7539b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f7540c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f7541d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f7542e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7543f = true;
    public boolean g = true;

    public g(h hVar, Menu menu) {
        this.E = hVar;
        this.f7538a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f7567c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e7) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e7);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        h hVar = this.E;
        Context context = hVar.f7567c;
        boolean z10 = false;
        menuItem.setChecked(this.f7555s).setVisible(this.f7556t).setEnabled(this.f7557u).setCheckable(this.f7554r >= 1).setTitleCondensed(this.f7548l).setIcon(this.f7549m);
        int i10 = this.f7558v;
        if (i10 >= 0) {
            menuItem.setShowAsAction(i10);
        }
        if (this.f7561y != null) {
            if (context.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (hVar.f7568d == null) {
                hVar.f7568d = h.a(context);
            }
            Object obj = hVar.f7568d;
            String str = this.f7561y;
            f fVar = new f();
            fVar.f7536a = obj;
            Class<?> cls = obj.getClass();
            try {
                fVar.f7537b = cls.getMethod(str, f.f7535c);
                menuItem.setOnMenuItemClickListener(fVar);
            } catch (Exception e7) {
                StringBuilder s10 = android.support.v4.media.d.s("Couldn't resolve menu item onClick handler ", str, " in class ");
                s10.append(cls.getName());
                InflateException inflateException = new InflateException(s10.toString());
                inflateException.initCause(e7);
                throw inflateException;
            }
        }
        if (this.f7554r >= 2) {
            if (menuItem instanceof n) {
                n nVar = (n) menuItem;
                nVar.f8036x = (nVar.f8036x & (-5)) | 4;
            } else if (menuItem instanceof s) {
                s sVar = (s) menuItem;
                g0.a aVar = sVar.f8046c;
                try {
                    if (sVar.f8047d == null) {
                        sVar.f8047d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    sVar.f8047d.invoke(aVar, Boolean.TRUE);
                } catch (Exception e8) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e8);
                }
            }
        }
        String str2 = this.f7560x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, h.f7563e, hVar.f7565a));
            z10 = true;
        }
        int i11 = this.f7559w;
        if (i11 > 0) {
            if (z10) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i11);
            }
        }
        o oVar = this.f7562z;
        if (oVar != null) {
            if (menuItem instanceof g0.a) {
                ((g0.a) menuItem).b(oVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z11 = menuItem instanceof g0.a;
        if (z11) {
            ((g0.a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            c0.a.g(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z11) {
            ((g0.a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            c0.a.k(menuItem, charSequence2);
        }
        char c10 = this.f7550n;
        int i12 = this.f7551o;
        if (z11) {
            ((g0.a) menuItem).setAlphabeticShortcut(c10, i12);
        } else if (Build.VERSION.SDK_INT >= 26) {
            c0.a.f(menuItem, c10, i12);
        }
        char c11 = this.f7552p;
        int i13 = this.f7553q;
        if (z11) {
            ((g0.a) menuItem).setNumericShortcut(c11, i13);
        } else if (Build.VERSION.SDK_INT >= 26) {
            c0.a.j(menuItem, c11, i13);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z11) {
                ((g0.a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                c0.a.i(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z11) {
                ((g0.a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                c0.a.h(menuItem, colorStateList);
            }
        }
    }
}
