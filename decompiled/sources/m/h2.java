package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.chromium.net.R;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h2 {

    /* renamed from: i, reason: collision with root package name */
    public static h2 f8425i;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f8427a;

    /* renamed from: b, reason: collision with root package name */
    public p.i f8428b;

    /* renamed from: c, reason: collision with root package name */
    public p.j f8429c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap f8430d = new WeakHashMap(0);

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f8431e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8432f;
    public j9.g1 g;

    /* renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f8424h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    public static final f2 f8426j = new f2(6);

    public static synchronized h2 d() {
        h2 h2Var;
        synchronized (h2.class) {
            try {
                if (f8425i == null) {
                    h2 h2Var2 = new h2();
                    f8425i = h2Var2;
                    j(h2Var2);
                }
                h2Var = f8425i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return h2Var;
    }

    public static synchronized PorterDuffColorFilter h(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (h2.class) {
            f2 f2Var = f8426j;
            f2Var.getClass();
            int i11 = (31 + i10) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) f2Var.f(Integer.valueOf(mode.hashCode() + i11));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i10, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public static void j(h2 h2Var) {
        if (Build.VERSION.SDK_INT < 24) {
            h2Var.a("vector", new g2(3));
            h2Var.a("animated-vector", new g2(2));
            h2Var.a("animated-selector", new g2(1));
            h2Var.a("drawable", new g2(0));
        }
    }

    public final void a(String str, g2 g2Var) {
        if (this.f8428b == null) {
            this.f8428b = new p.i(0);
        }
        this.f8428b.put(str, g2Var);
    }

    public final synchronized void b(Context context, long j10, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                p.g gVar = (p.g) this.f8430d.get(context);
                if (gVar == null) {
                    gVar = new p.g();
                    this.f8430d.put(context, gVar);
                }
                gVar.g(j10, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable c(Context context, int i10) {
        if (this.f8431e == null) {
            this.f8431e = new TypedValue();
        }
        TypedValue typedValue = this.f8431e;
        context.getResources().getValue(i10, typedValue, true);
        long j10 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable e7 = e(context, j10);
        if (e7 != null) {
            return e7;
        }
        LayerDrawable layerDrawable = null;
        if (this.g != null) {
            if (i10 == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{f(context, R.drawable.abc_cab_background_internal_bg), f(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i10 == R.drawable.abc_ratingbar_material) {
                layerDrawable = j9.g1.l(this, context, R.dimen.abc_star_big);
            } else if (i10 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawable = j9.g1.l(this, context, R.dimen.abc_star_medium);
            } else if (i10 == R.drawable.abc_ratingbar_small_material) {
                layerDrawable = j9.g1.l(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j10, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable e(Context context, long j10) {
        p.g gVar = (p.g) this.f8430d.get(context);
        if (gVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) gVar.d(j10);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int b2 = q.a.b(gVar.f9774p, gVar.f9776r, j10);
            if (b2 >= 0) {
                Object[] objArr = gVar.f9775q;
                Object obj = objArr[b2];
                Object obj2 = p.h.f9777a;
                if (obj != obj2) {
                    objArr[b2] = obj2;
                    gVar.f9773o = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable f(Context context, int i10) {
        return g(context, i10, false);
    }

    public final synchronized Drawable g(Context context, int i10, boolean z10) {
        Drawable k10;
        try {
            if (!this.f8432f) {
                this.f8432f = true;
                Drawable f10 = f(context, R.drawable.abc_vector_test);
                if (f10 == null || (!(f10 instanceof m4.p) && !"android.graphics.drawable.VectorDrawable".equals(f10.getClass().getName()))) {
                    this.f8432f = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            k10 = k(context, i10);
            if (k10 == null) {
                k10 = c(context, i10);
            }
            if (k10 == null) {
                k10 = context.getDrawable(i10);
            }
            if (k10 != null) {
                k10 = n(context, i10, z10, k10);
            }
            if (k10 != null) {
                i1.a(k10);
            }
        } catch (Throwable th) {
            throw th;
        }
        return k10;
    }

    public final synchronized ColorStateList i(Context context, int i10) {
        ColorStateList colorStateList;
        p.j jVar;
        WeakHashMap weakHashMap = this.f8427a;
        ColorStateList colorStateList2 = null;
        colorStateList = (weakHashMap == null || (jVar = (p.j) weakHashMap.get(context)) == null) ? null : (ColorStateList) jVar.c(i10);
        if (colorStateList == null) {
            j9.g1 g1Var = this.g;
            if (g1Var != null) {
                colorStateList2 = g1Var.m(context, i10);
            }
            if (colorStateList2 != null) {
                if (this.f8427a == null) {
                    this.f8427a = new WeakHashMap();
                }
                p.j jVar2 = (p.j) this.f8427a.get(context);
                if (jVar2 == null) {
                    jVar2 = new p.j();
                    this.f8427a.put(context, jVar2);
                }
                jVar2.a(i10, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    public final Drawable k(Context context, int i10) {
        int next;
        p.i iVar = this.f8428b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        p.j jVar = this.f8429c;
        if (jVar != null) {
            String str = (String) jVar.c(i10);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.f8428b.get(str) == null) {
                return null;
            }
        } else {
            this.f8429c = new p.j();
        }
        if (this.f8431e == null) {
            this.f8431e = new TypedValue();
        }
        TypedValue typedValue = this.f8431e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long j10 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable e7 = e(context, j10);
        if (e7 != null) {
            return e7;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f8429c.a(i10, name);
                g2 g2Var = (g2) this.f8428b.get(name);
                if (g2Var != null) {
                    e7 = g2Var.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (e7 != null) {
                    e7.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, j10, e7);
                }
            } catch (Exception e8) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e8);
            }
        }
        if (e7 == null) {
            this.f8429c.a(i10, "appcompat_skip_skip");
        }
        return e7;
    }

    public final synchronized void l(Context context) {
        p.g gVar = (p.g) this.f8430d.get(context);
        if (gVar != null) {
            gVar.b();
        }
    }

    public final synchronized void m(j9.g1 g1Var) {
        this.g = g1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable n(android.content.Context r8, int r9, boolean r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.h2.n(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
