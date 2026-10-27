package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k1.a;
import k1.f;
import u3.b;
import u3.c;
import u3.e0;
import u3.l0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public List f1216o;

    /* renamed from: p, reason: collision with root package name */
    public c f1217p;

    /* renamed from: q, reason: collision with root package name */
    public int f1218q;

    /* renamed from: r, reason: collision with root package name */
    public float f1219r;

    /* renamed from: s, reason: collision with root package name */
    public float f1220s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1221t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1222u;

    /* renamed from: v, reason: collision with root package name */
    public int f1223v;

    /* renamed from: w, reason: collision with root package name */
    public e0 f1224w;

    /* renamed from: x, reason: collision with root package name */
    public View f1225x;

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1216o = Collections.EMPTY_LIST;
        this.f1217p = c.g;
        this.f1218q = 0;
        this.f1219r = 0.0533f;
        this.f1220s = 0.08f;
        this.f1221t = true;
        this.f1222u = true;
        b bVar = new b(context, 0);
        this.f1224w = bVar;
        this.f1225x = bVar;
        addView(bVar);
        this.f1223v = 1;
    }

    private List<k1.b> getCuesWithStylingPreferencesApplied() {
        if (this.f1221t && this.f1222u) {
            return this.f1216o;
        }
        ArrayList arrayList = new ArrayList(this.f1216o.size());
        for (int i10 = 0; i10 < this.f1216o.size(); i10++) {
            a a10 = ((k1.b) this.f1216o.get(i10)).a();
            if (!this.f1221t) {
                a10.f7610n = false;
                CharSequence charSequence = a10.f7598a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        a10.f7598a = SpannableString.valueOf(charSequence);
                        a10.f7599b = null;
                    }
                    CharSequence charSequence2 = a10.f7598a;
                    charSequence2.getClass();
                    Spannable spannable = (Spannable) charSequence2;
                    for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                        if (!(obj instanceof f)) {
                            spannable.removeSpan(obj);
                        }
                    }
                }
                j1.c.o(a10);
            } else if (!this.f1222u) {
                j1.c.o(a10);
            }
            arrayList.add(a10.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        boolean isInEditMode = isInEditMode();
        c cVar = c.g;
        if (isInEditMode) {
            return cVar;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager != null && captioningManager.isEnabled()) {
            CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
            cVar = new c(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : -16777216, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
        }
        return cVar;
    }

    private <T extends View & e0> void setView(T t3) {
        removeView(this.f1225x);
        View view = this.f1225x;
        if (view instanceof l0) {
            ((l0) view).f12423p.destroy();
        }
        this.f1225x = t3;
        this.f1224w = t3;
        addView(t3);
    }

    public final void a(int i10, float f10) {
        Context context = getContext();
        float applyDimension = TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        this.f1218q = 2;
        this.f1219r = applyDimension;
        d();
    }

    public final void b() {
        setStyle(getUserCaptionStyle());
    }

    public final void c() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void d() {
        this.f1224w.a(getCuesWithStylingPreferencesApplied(), this.f1217p, this.f1219r, this.f1218q, this.f1220s);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.f1222u = z10;
        d();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f1221t = z10;
        d();
    }

    public void setBottomPaddingFraction(float f10) {
        this.f1220s = f10;
        d();
    }

    public void setCues(List<k1.b> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f1216o = list;
        d();
    }

    public void setFractionalTextSize(float f10) {
        this.f1218q = 0;
        this.f1219r = f10;
        d();
    }

    public void setStyle(c cVar) {
        this.f1217p = cVar;
        d();
    }

    public void setViewType(int i10) {
        if (this.f1223v == i10) {
            return;
        }
        if (i10 == 1) {
            setView(new b(getContext(), 0));
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new l0(getContext()));
        }
        this.f1223v = i10;
    }
}
