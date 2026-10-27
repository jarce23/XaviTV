package f;

import android.view.Window;
import m.d1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements m0.m, d1, l.w {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4847o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ b0 f4848p;

    public /* synthetic */ s(b0 b0Var, int i10) {
        this.f4847o = i10;
        this.f4848p = b0Var;
    }

    @Override // l.w
    public void e(l.l lVar, boolean z10) {
        a0 a0Var;
        switch (this.f4847o) {
            case 2:
                this.f4848p.p(lVar);
                break;
            default:
                l.l k10 = lVar.k();
                int i10 = 0;
                boolean z11 = k10 != lVar;
                if (z11) {
                    lVar = k10;
                }
                b0 b0Var = this.f4848p;
                a0[] a0VarArr = b0Var.f4720a0;
                int length = a0VarArr != null ? a0VarArr.length : 0;
                while (true) {
                    if (i10 >= length) {
                        a0Var = null;
                    } else {
                        a0Var = a0VarArr[i10];
                        if (a0Var == null || a0Var.f4692h != lVar) {
                            i10++;
                        }
                    }
                }
                if (a0Var != null) {
                    if (!z11) {
                        b0Var.q(a0Var, z10);
                        break;
                    } else {
                        b0Var.o(a0Var.f4686a, a0Var, k10);
                        b0Var.q(a0Var, true);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00cb  */
    @Override // m0.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m0.q1 f(android.view.View r20, m0.q1 r21) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.s.f(android.view.View, m0.q1):m0.q1");
    }

    @Override // l.w
    public boolean p(l.l lVar) {
        Window.Callback callback;
        switch (this.f4847o) {
            case 2:
                Window.Callback callback2 = this.f4848p.f4743z.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, lVar);
                    break;
                }
                break;
            default:
                if (lVar == lVar.k()) {
                    b0 b0Var = this.f4848p;
                    if (b0Var.U && (callback = b0Var.f4743z.getCallback()) != null && !b0Var.f4725f0) {
                        callback.onMenuOpened(108, lVar);
                        break;
                    }
                }
                break;
        }
        return true;
    }
}
