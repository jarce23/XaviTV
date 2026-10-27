package b4;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends q0 {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f2181a;

    /* renamed from: b, reason: collision with root package name */
    public final i1 f2182b = new i1(this);

    /* renamed from: c, reason: collision with root package name */
    public z f2183c;

    /* renamed from: d, reason: collision with root package name */
    public z f2184d;

    public static int b(View view, androidx.emoji2.text.g gVar) {
        return ((gVar.c(view) / 2) + gVar.e(view)) - ((gVar.l() / 2) + gVar.k());
    }

    public static View c(o0 o0Var, androidx.emoji2.text.g gVar) {
        int x6 = o0Var.x();
        View view = null;
        if (x6 == 0) {
            return null;
        }
        int l10 = (gVar.l() / 2) + gVar.k();
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < x6; i11++) {
            View w10 = o0Var.w(i11);
            int abs = Math.abs(((gVar.c(w10) / 2) + gVar.e(w10)) - l10);
            if (abs < i10) {
                view = w10;
                i10 = abs;
            }
        }
        return view;
    }

    public final int[] a(o0 o0Var, View view) {
        int[] iArr = new int[2];
        if (o0Var.e()) {
            iArr[0] = b(view, d(o0Var));
        } else {
            iArr[0] = 0;
        }
        if (o0Var.f()) {
            iArr[1] = b(view, e(o0Var));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public final androidx.emoji2.text.g d(o0 o0Var) {
        z zVar = this.f2184d;
        if (zVar == null || ((o0) zVar.f570b) != o0Var) {
            this.f2184d = new z(o0Var, 0);
        }
        return this.f2184d;
    }

    public final androidx.emoji2.text.g e(o0 o0Var) {
        z zVar = this.f2183c;
        if (zVar == null || ((o0) zVar.f570b) != o0Var) {
            this.f2183c = new z(o0Var, 1);
        }
        return this.f2183c;
    }

    public final void f() {
        o0 layoutManager;
        RecyclerView recyclerView = this.f2181a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        View c10 = layoutManager.f() ? c(layoutManager, e(layoutManager)) : layoutManager.e() ? c(layoutManager, d(layoutManager)) : null;
        if (c10 == null) {
            return;
        }
        int[] a10 = a(layoutManager, c10);
        int i10 = a10[0];
        if (i10 == 0 && a10[1] == 0) {
            return;
        }
        this.f2181a.g0(i10, a10[1], false);
    }
}
