package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import f.b0;
import f.s;
import l.l;
import m.d1;
import m.e1;
import m.g;
import m.k;
import m.z2;
import m0.p0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public TypedValue f436o;

    /* renamed from: p, reason: collision with root package name */
    public TypedValue f437p;

    /* renamed from: q, reason: collision with root package name */
    public TypedValue f438q;

    /* renamed from: r, reason: collision with root package name */
    public TypedValue f439r;

    /* renamed from: s, reason: collision with root package name */
    public TypedValue f440s;

    /* renamed from: t, reason: collision with root package name */
    public TypedValue f441t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f442u;

    /* renamed from: v, reason: collision with root package name */
    public d1 f443v;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f442u = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f440s == null) {
            this.f440s = new TypedValue();
        }
        return this.f440s;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f441t == null) {
            this.f441t = new TypedValue();
        }
        return this.f441t;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f438q == null) {
            this.f438q = new TypedValue();
        }
        return this.f438q;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f439r == null) {
            this.f439r = new TypedValue();
        }
        return this.f439r;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f436o == null) {
            this.f436o = new TypedValue();
        }
        return this.f436o;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f437p == null) {
            this.f437p = new TypedValue();
        }
        return this.f437p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d1 d1Var = this.f443v;
        if (d1Var != null) {
            d1Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        k kVar;
        super.onDetachedFromWindow();
        d1 d1Var = this.f443v;
        if (d1Var != null) {
            b0 b0Var = ((s) d1Var).f4848p;
            e1 e1Var = b0Var.F;
            if (e1Var != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) e1Var;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((z2) actionBarOverlayLayout.f414s).f8621a.f475o;
                if (actionMenuView != null && (kVar = actionMenuView.H) != null) {
                    kVar.c();
                    g gVar = kVar.H;
                    if (gVar != null && gVar.b()) {
                        gVar.f8057i.dismiss();
                    }
                }
            }
            if (b0Var.K != null) {
                b0Var.f4743z.getDecorView().removeCallbacks(b0Var.L);
                if (b0Var.K.isShowing()) {
                    try {
                        b0Var.K.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                b0Var.K = null;
            }
            p0 p0Var = b0Var.M;
            if (p0Var != null) {
                p0Var.b();
            }
            l lVar = b0Var.z(0).f4692h;
            if (lVar != null) {
                lVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(d1 d1Var) {
        this.f443v = d1Var;
    }
}
