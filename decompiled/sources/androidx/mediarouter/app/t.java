package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.res.Configuration;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class t extends androidx.fragment.app.o {

    /* renamed from: x0, reason: collision with root package name */
    public final boolean f1416x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public f.d0 f1417y0;

    /* renamed from: z0, reason: collision with root package name */
    public w3.o f1418z0;

    public t() {
        this.f757n0 = true;
        Dialog dialog = this.f762s0;
        if (dialog != null) {
            dialog.setCancelable(true);
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void B() {
        super.B();
        f.d0 d0Var = this.f1417y0;
        if (d0Var == null || this.f1416x0) {
            return;
        }
        ((s) d0Var).j(false);
    }

    @Override // androidx.fragment.app.o
    public final Dialog K() {
        if (this.f1416x0) {
            n0 n0Var = new n0(i());
            this.f1417y0 = n0Var;
            n0Var.j(this.f1418z0);
        } else {
            this.f1417y0 = new s(i());
        }
        return this.f1417y0;
    }

    @Override // androidx.fragment.app.s, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.Q = true;
        f.d0 d0Var = this.f1417y0;
        if (d0Var != null) {
            if (this.f1416x0) {
                ((n0) d0Var).k();
            } else {
                ((s) d0Var).s();
            }
        }
    }
}
