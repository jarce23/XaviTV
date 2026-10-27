package a9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.bumptech.glide.f;
import d0.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f160a;

    /* renamed from: b, reason: collision with root package name */
    public final String f161b;

    /* renamed from: c, reason: collision with root package name */
    public final String f162c;

    /* renamed from: d, reason: collision with root package name */
    public final int f163d;

    /* renamed from: e, reason: collision with root package name */
    public final int f164e;

    /* renamed from: f, reason: collision with root package name */
    public final float f165f;
    public final float g;

    /* renamed from: h, reason: collision with root package name */
    public final float f166h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f167i;

    /* renamed from: j, reason: collision with root package name */
    public final float f168j;

    /* renamed from: k, reason: collision with root package name */
    public final ColorStateList f169k;

    /* renamed from: l, reason: collision with root package name */
    public float f170l;

    /* renamed from: m, reason: collision with root package name */
    public final int f171m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f172n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f173o = false;

    /* renamed from: p, reason: collision with root package name */
    public Typeface f174p;

    public d(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, e.a.f4379w);
        this.f170l = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f169k = com.bumptech.glide.d.l(context, obtainStyledAttributes, 3);
        com.bumptech.glide.d.l(context, obtainStyledAttributes, 4);
        com.bumptech.glide.d.l(context, obtainStyledAttributes, 5);
        this.f163d = obtainStyledAttributes.getInt(2, 0);
        this.f164e = obtainStyledAttributes.getInt(1, 1);
        int i11 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f171m = obtainStyledAttributes.getResourceId(i11, 0);
        this.f161b = obtainStyledAttributes.getString(i11);
        obtainStyledAttributes.getBoolean(14, false);
        this.f160a = com.bumptech.glide.d.l(context, obtainStyledAttributes, 6);
        this.f165f = obtainStyledAttributes.getFloat(7, 0.0f);
        this.g = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f166h = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i10, j8.a.f7199t);
        this.f167i = obtainStyledAttributes2.hasValue(0);
        this.f168j = obtainStyledAttributes2.getFloat(0, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f162c = obtainStyledAttributes2.getString(obtainStyledAttributes2.hasValue(3) ? 3 : 1);
        }
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f174p;
        int i10 = this.f163d;
        if (typeface == null && (str = this.f161b) != null) {
            this.f174p = Typeface.create(str, i10);
        }
        if (this.f174p == null) {
            int i11 = this.f164e;
            if (i11 == 1) {
                this.f174p = Typeface.SANS_SERIF;
            } else if (i11 == 2) {
                this.f174p = Typeface.SERIF;
            } else if (i11 != 3) {
                this.f174p = Typeface.DEFAULT;
            } else {
                this.f174p = Typeface.MONOSPACE;
            }
            this.f174p = Typeface.create(this.f174p, i10);
        }
    }

    public final void b(Context context, com.bumptech.glide.e eVar) {
        if (!c(context)) {
            a();
        }
        int i10 = this.f171m;
        if (i10 == 0) {
            this.f172n = true;
        }
        if (this.f172n) {
            eVar.s(this.f174p, true);
            return;
        }
        try {
            b bVar = new b(this, eVar);
            ThreadLocal threadLocal = l.f3981a;
            if (context.isRestricted()) {
                bVar.a(-4);
            } else {
                l.b(context, i10, new TypedValue(), 0, bVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f172n = true;
            eVar.r(1);
        } catch (Exception e7) {
            Log.d("TextAppearance", "Error loading font " + this.f161b, e7);
            this.f172n = true;
            eVar.r(-3);
        }
    }

    public final boolean c(Context context) {
        Context context2;
        Typeface b2;
        String str;
        Typeface create;
        if (this.f172n) {
            return true;
        }
        int i10 = this.f171m;
        if (i10 != 0) {
            ThreadLocal threadLocal = l.f3981a;
            Typeface typeface = null;
            if (context.isRestricted()) {
                context2 = context;
                b2 = null;
            } else {
                context2 = context;
                b2 = l.b(context2, i10, new TypedValue(), 0, null, false, true);
            }
            if (b2 != null) {
                this.f174p = b2;
                this.f172n = true;
                return true;
            }
            if (!this.f173o) {
                this.f173o = true;
                Resources resources = context2.getResources();
                int i11 = this.f171m;
                if (i11 != 0 && resources.getResourceTypeName(i11).equals("font")) {
                    try {
                        XmlResourceParser xml = resources.getXml(i11);
                        while (xml.getEventType() != 1) {
                            if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), a0.a.f4b);
                                str = obtainAttributes.getString(7);
                                obtainAttributes.recycle();
                                break;
                            }
                            xml.next();
                        }
                    } catch (Throwable unused) {
                    }
                }
                str = null;
                if (str != null && (create = Typeface.create(str, 0)) != Typeface.DEFAULT) {
                    typeface = Typeface.create(create, this.f163d);
                }
            }
            if (typeface != null) {
                this.f174p = typeface;
                this.f172n = true;
                return true;
            }
        }
        return false;
    }

    public final void d(Context context, TextPaint textPaint, com.bumptech.glide.e eVar) {
        e(context, textPaint, eVar);
        ColorStateList colorStateList = this.f169k;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f160a;
        textPaint.setShadowLayer(this.f166h, this.f165f, this.g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, com.bumptech.glide.e eVar) {
        Typeface typeface;
        if (c(context) && this.f172n && (typeface = this.f174p) != null) {
            f(context, textPaint, typeface);
            return;
        }
        a();
        f(context, textPaint, this.f174p);
        b(context, new c(this, context, textPaint, eVar));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface u10 = f.u(context.getResources().getConfiguration(), typeface);
        if (u10 != null) {
            typeface = u10;
        }
        textPaint.setTypeface(typeface);
        int i10 = (~typeface.getStyle()) & this.f163d;
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f170l);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(this.f162c);
        }
        if (this.f167i) {
            textPaint.setLetterSpacing(this.f168j);
        }
    }
}
