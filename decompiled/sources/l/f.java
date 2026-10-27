package l;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.fragment.app.o0;
import java.util.ArrayList;
import m.b2;
import m.e2;
import m.o1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends t implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public View B;
    public View C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public boolean J;
    public w K;
    public ViewTreeObserver L;
    public PopupWindow.OnDismissListener M;
    public boolean N;

    /* renamed from: p, reason: collision with root package name */
    public final Context f7962p;

    /* renamed from: q, reason: collision with root package name */
    public final int f7963q;

    /* renamed from: r, reason: collision with root package name */
    public final int f7964r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f7965s;

    /* renamed from: t, reason: collision with root package name */
    public final Handler f7966t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f7967u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f7968v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public final d f7969w = new d(0, this);

    /* renamed from: x, reason: collision with root package name */
    public final o0 f7970x = new o0(2, this);

    /* renamed from: y, reason: collision with root package name */
    public final h5.i f7971y = new h5.i(13, this);

    /* renamed from: z, reason: collision with root package name */
    public int f7972z = 0;
    public int A = 0;
    public boolean I = false;

    public f(Context context, View view, int i10, boolean z10) {
        this.f7962p = context;
        this.B = view;
        this.f7964r = i10;
        this.f7965s = z10;
        this.D = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f7963q = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f7966t = new Handler();
    }

    @Override // l.b0
    public final boolean a() {
        ArrayList arrayList = this.f7968v;
        return arrayList.size() > 0 && ((e) arrayList.get(0)).f7959a.N.isShowing();
    }

    @Override // l.x
    public final void b() {
        ArrayList arrayList = this.f7968v;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ListAdapter adapter = ((e) obj).f7959a.f8611q.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((i) adapter).notifyDataSetChanged();
        }
    }

    @Override // l.b0
    public final void c() {
        if (a()) {
            return;
        }
        ArrayList arrayList = this.f7967u;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            u((l) obj);
        }
        arrayList.clear();
        View view = this.B;
        this.C = view;
        if (view != null) {
            boolean z10 = this.L == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.L = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f7969w);
            }
            this.C.addOnAttachStateChangeListener(this.f7970x);
        }
    }

    @Override // l.x
    public final void d(w wVar) {
        this.K = wVar;
    }

    @Override // l.b0
    public final void dismiss() {
        ArrayList arrayList = this.f7968v;
        int size = arrayList.size();
        if (size > 0) {
            e[] eVarArr = (e[]) arrayList.toArray(new e[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                e eVar = eVarArr[i10];
                if (eVar.f7959a.N.isShowing()) {
                    eVar.f7959a.dismiss();
                }
            }
        }
    }

    @Override // l.x
    public final void e(l lVar, boolean z10) {
        ArrayList arrayList = this.f7968v;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (lVar == ((e) arrayList.get(i10)).f7960b) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            return;
        }
        int i11 = i10 + 1;
        if (i11 < arrayList.size()) {
            ((e) arrayList.get(i11)).f7960b.c(false);
        }
        e eVar = (e) arrayList.remove(i10);
        l lVar2 = eVar.f7960b;
        e2 e2Var = eVar.f7959a;
        m.x xVar = e2Var.N;
        lVar2.r(this);
        if (this.N) {
            b2.b(xVar, null);
            xVar.setAnimationStyle(0);
        }
        e2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.D = ((e) arrayList.get(size2 - 1)).f7961c;
        } else {
            this.D = this.B.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z10) {
                ((e) arrayList.get(0)).f7960b.c(false);
                return;
            }
            return;
        }
        dismiss();
        w wVar = this.K;
        if (wVar != null) {
            wVar.e(lVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.L;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.L.removeGlobalOnLayoutListener(this.f7969w);
            }
            this.L = null;
        }
        this.C.removeOnAttachStateChangeListener(this.f7970x);
        this.M.onDismiss();
    }

    @Override // l.b0
    public final o1 f() {
        ArrayList arrayList = this.f7968v;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((e) arrayList.get(arrayList.size() - 1)).f7959a.f8611q;
    }

    @Override // l.x
    public final boolean i() {
        return false;
    }

    @Override // l.x
    public final boolean j(d0 d0Var) {
        ArrayList arrayList = this.f7968v;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            e eVar = (e) obj;
            if (d0Var == eVar.f7960b) {
                eVar.f7959a.f8611q.requestFocus();
                return true;
            }
        }
        if (!d0Var.hasVisibleItems()) {
            return false;
        }
        l(d0Var);
        w wVar = this.K;
        if (wVar != null) {
            wVar.p(d0Var);
        }
        return true;
    }

    @Override // l.t
    public final void l(l lVar) {
        lVar.b(this, this.f7962p);
        if (a()) {
            u(lVar);
        } else {
            this.f7967u.add(lVar);
        }
    }

    @Override // l.t
    public final void n(View view) {
        if (this.B != view) {
            this.B = view;
            this.A = Gravity.getAbsoluteGravity(this.f7972z, view.getLayoutDirection());
        }
    }

    @Override // l.t
    public final void o(boolean z10) {
        this.I = z10;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        e eVar;
        ArrayList arrayList = this.f7968v;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                eVar = null;
                break;
            }
            eVar = (e) arrayList.get(i10);
            if (!eVar.f7959a.N.isShowing()) {
                break;
            } else {
                i10++;
            }
        }
        if (eVar != null) {
            eVar.f7960b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // l.t
    public final void p(int i10) {
        if (this.f7972z != i10) {
            this.f7972z = i10;
            this.A = Gravity.getAbsoluteGravity(i10, this.B.getLayoutDirection());
        }
    }

    @Override // l.t
    public final void q(int i10) {
        this.E = true;
        this.G = i10;
    }

    @Override // l.t
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.M = onDismissListener;
    }

    @Override // l.t
    public final void s(boolean z10) {
        this.J = z10;
    }

    @Override // l.t
    public final void t(int i10) {
        this.F = true;
        this.H = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0178  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(l.l r20) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.f.u(l.l):void");
    }
}
