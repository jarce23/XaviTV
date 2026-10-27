package l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8050a;

    /* renamed from: b, reason: collision with root package name */
    public final l f8051b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8052c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8053d;

    /* renamed from: e, reason: collision with root package name */
    public View f8054e;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public w f8056h;

    /* renamed from: i, reason: collision with root package name */
    public t f8057i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f8058j;

    /* renamed from: f, reason: collision with root package name */
    public int f8055f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final u f8059k = new u(this);

    public v(Context context, l lVar, View view, boolean z10, int i10, int i11) {
        this.f8050a = context;
        this.f8051b = lVar;
        this.f8054e = view;
        this.f8052c = z10;
        this.f8053d = i10;
    }

    public final t a() {
        t c0Var;
        if (this.f8057i == null) {
            Context context = this.f8050a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                c0Var = new f(context, this.f8054e, this.f8053d, this.f8052c);
            } else {
                c0Var = new c0(this.f8050a, this.f8051b, this.f8054e, this.f8053d, this.f8052c);
            }
            c0Var.l(this.f8051b);
            c0Var.r(this.f8059k);
            c0Var.n(this.f8054e);
            c0Var.d(this.f8056h);
            c0Var.o(this.g);
            c0Var.p(this.f8055f);
            this.f8057i = c0Var;
        }
        return this.f8057i;
    }

    public final boolean b() {
        t tVar = this.f8057i;
        return tVar != null && tVar.a();
    }

    public void c() {
        this.f8057i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f8058j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i10, int i11, boolean z10, boolean z11) {
        t a10 = a();
        a10.s(z11);
        if (z10) {
            if ((Gravity.getAbsoluteGravity(this.f8055f, this.f8054e.getLayoutDirection()) & 7) == 5) {
                i10 -= this.f8054e.getWidth();
            }
            a10.q(i10);
            a10.t(i11);
            int i12 = (int) ((this.f8050a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a10.f8048o = new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12);
        }
        a10.c();
    }
}
