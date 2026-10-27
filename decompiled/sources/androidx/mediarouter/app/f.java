package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f extends androidx.fragment.app.o {

    /* renamed from: x0, reason: collision with root package name */
    public final boolean f1302x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public f.d0 f1303y0;

    /* renamed from: z0, reason: collision with root package name */
    public w3.o f1304z0;

    public f() {
        this.f757n0 = true;
        Dialog dialog = this.f762s0;
        if (dialog != null) {
            dialog.setCancelable(true);
        }
    }

    @Override // androidx.fragment.app.o
    public final Dialog K() {
        if (this.f1302x0) {
            a0 a0Var = new a0(i());
            this.f1303y0 = a0Var;
            N();
            a0Var.h(this.f1304z0);
        } else {
            e eVar = new e(i());
            this.f1303y0 = eVar;
            N();
            eVar.i(this.f1304z0);
        }
        return this.f1303y0;
    }

    public final void N() {
        if (this.f1304z0 == null) {
            Bundle bundle = this.f811t;
            if (bundle != null) {
                this.f1304z0 = w3.o.b(bundle.getBundle("selector"));
            }
            if (this.f1304z0 == null) {
                this.f1304z0 = w3.o.f12981c;
            }
        }
    }

    @Override // androidx.fragment.app.s, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.Q = true;
        f.d0 d0Var = this.f1303y0;
        if (d0Var == null) {
            return;
        }
        if (!this.f1302x0) {
            e eVar = (e) d0Var;
            eVar.getWindow().setLayout(com.google.android.gms.internal.cast.n.i(eVar.getContext()), -2);
        } else {
            a0 a0Var = (a0) d0Var;
            Context context = a0Var.f1267v;
            a0Var.getWindow().setLayout(!context.getResources().getBoolean(R.bool.is_tablet) ? -1 : com.google.android.gms.internal.cast.n.i(context), context.getResources().getBoolean(R.bool.is_tablet) ? -2 : -1);
        }
    }
}
