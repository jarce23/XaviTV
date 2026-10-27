package m;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z2 implements f1 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f8621a;

    /* renamed from: b, reason: collision with root package name */
    public int f8622b;

    /* renamed from: c, reason: collision with root package name */
    public View f8623c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f8624d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f8625e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f8626f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f8627h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f8628i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f8629j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f8630k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8631l;

    /* renamed from: m, reason: collision with root package name */
    public k f8632m;

    /* renamed from: n, reason: collision with root package name */
    public int f8633n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f8634o;

    public final void a(int i10) {
        View view;
        Toolbar toolbar = this.f8621a;
        int i11 = this.f8622b ^ i10;
        this.f8622b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    b();
                }
                if ((this.f8622b & 4) != 0) {
                    Drawable drawable = this.f8626f;
                    if (drawable == null) {
                        drawable = this.f8634o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i11 & 3) != 0) {
                c();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    toolbar.setTitle(this.f8627h);
                    toolbar.setSubtitle(this.f8628i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f8623c) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final void b() {
        Toolbar toolbar = this.f8621a;
        if ((this.f8622b & 4) != 0) {
            if (TextUtils.isEmpty(this.f8629j)) {
                toolbar.setNavigationContentDescription(this.f8633n);
            } else {
                toolbar.setNavigationContentDescription(this.f8629j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i10 = this.f8622b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) != 0) {
            drawable = this.f8625e;
            if (drawable == null) {
                drawable = this.f8624d;
            }
        } else {
            drawable = this.f8624d;
        }
        this.f8621a.setLogo(drawable);
    }
}
