package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class o extends s implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler h0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f760q0;

    /* renamed from: s0, reason: collision with root package name */
    public Dialog f762s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f763t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f764u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f765v0;

    /* renamed from: i0, reason: collision with root package name */
    public final androidx.activity.j f752i0 = new androidx.activity.j(1, this);

    /* renamed from: j0, reason: collision with root package name */
    public final l f753j0 = new l(this);

    /* renamed from: k0, reason: collision with root package name */
    public final m f754k0 = new m(this);

    /* renamed from: l0, reason: collision with root package name */
    public int f755l0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    public int f756m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f757n0 = true;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f758o0 = true;

    /* renamed from: p0, reason: collision with root package name */
    public int f759p0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    public final a6.n f761r0 = new a6.n(2, this);

    /* renamed from: w0, reason: collision with root package name */
    public boolean f766w0 = false;

    @Override // androidx.fragment.app.s
    public void A() {
        this.Q = true;
        Dialog dialog = this.f762s0;
        if (dialog != null) {
            this.f763t0 = false;
            dialog.show();
            View decorView = this.f762s0.getWindow().getDecorView();
            za.h.e("<this>", decorView);
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.s
    public void B() {
        this.Q = true;
        Dialog dialog = this.f762s0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.s
    public final void C(Bundle bundle) {
        Bundle bundle2;
        this.Q = true;
        if (this.f762s0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f762s0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.s
    public final void D(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.D(layoutInflater, viewGroup, bundle);
        if (this.S != null || this.f762s0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f762s0.onRestoreInstanceState(bundle2);
    }

    public final void J(boolean z10, boolean z11) {
        if (this.f764u0) {
            return;
        }
        this.f764u0 = true;
        this.f765v0 = false;
        Dialog dialog = this.f762s0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f762s0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.h0.getLooper()) {
                    onDismiss(this.f762s0);
                } else {
                    this.h0.post(this.f752i0);
                }
            }
        }
        this.f763t0 = true;
        if (this.f759p0 >= 0) {
            i0 k10 = k();
            int i10 = this.f759p0;
            if (i10 < 0) {
                throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Bad id: "));
            }
            k10.v(new h0(k10, i10), z10);
            this.f759p0 = -1;
            return;
        }
        a aVar = new a(k());
        aVar.f640p = true;
        aVar.h(this);
        if (z10) {
            aVar.e(true);
        } else {
            aVar.e(false);
        }
    }

    public Dialog K() {
        if (i0.F(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.p(E(), this.f756m0);
    }

    public final void L() {
        if (i0.F(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to 0, 2132017486");
        }
        this.f755l0 = 0;
        this.f756m0 = R.style.FullScreenDialogStyle;
    }

    public void M(i0 i0Var, String str) {
        this.f764u0 = false;
        this.f765v0 = true;
        i0Var.getClass();
        a aVar = new a(i0Var);
        aVar.f640p = true;
        aVar.f(0, this, str, 1);
        aVar.e(false);
    }

    @Override // androidx.fragment.app.s
    public final x4.f c() {
        return new n(this, new q(this));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f763t0) {
            return;
        }
        if (i0.F(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        J(true, true);
    }

    @Override // androidx.fragment.app.s
    public final void r() {
        this.Q = true;
    }

    @Override // androidx.fragment.app.s
    public void t(Context context) {
        super.t(context);
        this.f802c0.d(this.f761r0);
        if (this.f765v0) {
            return;
        }
        this.f764u0 = false;
    }

    @Override // androidx.fragment.app.s
    public void u(Bundle bundle) {
        super.u(bundle);
        this.h0 = new Handler();
        this.f758o0 = this.K == 0;
        if (bundle != null) {
            this.f755l0 = bundle.getInt("android:style", 0);
            this.f756m0 = bundle.getInt("android:theme", 0);
            this.f757n0 = bundle.getBoolean("android:cancelable", true);
            this.f758o0 = bundle.getBoolean("android:showsDialog", this.f758o0);
            this.f759p0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.s
    public final void w() {
        this.Q = true;
        Dialog dialog = this.f762s0;
        if (dialog != null) {
            this.f763t0 = true;
            dialog.setOnDismissListener(null);
            this.f762s0.dismiss();
            if (!this.f764u0) {
                onDismiss(this.f762s0);
            }
            this.f762s0 = null;
            this.f766w0 = false;
        }
    }

    @Override // androidx.fragment.app.s
    public final void x() {
        this.Q = true;
        if (!this.f765v0 && !this.f764u0) {
            this.f764u0 = true;
        }
        androidx.lifecycle.y yVar = this.f802c0;
        yVar.getClass();
        androidx.lifecycle.y.a("removeObserver");
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) yVar.f1172b.g(this.f761r0);
        if (xVar == null) {
            return;
        }
        xVar.d();
        xVar.c(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048 A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:10:0x001a, B:12:0x0026, B:18:0x003e, B:20:0x0048, B:21:0x0052, B:23:0x0030, B:25:0x0036, B:26:0x003b, B:27:0x006a), top: B:9:0x001a }] */
    @Override // androidx.fragment.app.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater y(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r8 = super.y(r8)
            boolean r0 = r7.f758o0
            java.lang.String r1 = "FragmentManager"
            r2 = 2
            if (r0 == 0) goto L9c
            boolean r3 = r7.f760q0
            if (r3 == 0) goto L11
            goto L9c
        L11:
            if (r0 != 0) goto L14
            goto L73
        L14:
            boolean r0 = r7.f766w0
            if (r0 != 0) goto L73
            r0 = 0
            r3 = 1
            r7.f760q0 = r3     // Catch: java.lang.Throwable -> L50
            android.app.Dialog r4 = r7.K()     // Catch: java.lang.Throwable -> L50
            r7.f762s0 = r4     // Catch: java.lang.Throwable -> L50
            boolean r5 = r7.f758o0     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L6a
            int r5 = r7.f755l0     // Catch: java.lang.Throwable -> L50
            if (r5 == r3) goto L3b
            if (r5 == r2) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L50
        L3b:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L50
        L3e:
            android.content.Context r4 = r7.i()     // Catch: java.lang.Throwable -> L50
            boolean r5 = r.a.k(r4)     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L52
            android.app.Dialog r5 = r7.f762s0     // Catch: java.lang.Throwable -> L50
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L50
            r5.setOwnerActivity(r4)     // Catch: java.lang.Throwable -> L50
            goto L52
        L50:
            r8 = move-exception
            goto L70
        L52:
            android.app.Dialog r4 = r7.f762s0     // Catch: java.lang.Throwable -> L50
            boolean r5 = r7.f757n0     // Catch: java.lang.Throwable -> L50
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L50
            android.app.Dialog r4 = r7.f762s0     // Catch: java.lang.Throwable -> L50
            androidx.fragment.app.l r5 = r7.f753j0     // Catch: java.lang.Throwable -> L50
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L50
            android.app.Dialog r4 = r7.f762s0     // Catch: java.lang.Throwable -> L50
            androidx.fragment.app.m r5 = r7.f754k0     // Catch: java.lang.Throwable -> L50
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L50
            r7.f766w0 = r3     // Catch: java.lang.Throwable -> L50
            goto L6d
        L6a:
            r3 = 0
            r7.f762s0 = r3     // Catch: java.lang.Throwable -> L50
        L6d:
            r7.f760q0 = r0
            goto L73
        L70:
            r7.f760q0 = r0
            throw r8
        L73:
            boolean r0 = androidx.fragment.app.i0.F(r2)
            if (r0 == 0) goto L8f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "get layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r2 = " from dialog context"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L8f:
            android.app.Dialog r0 = r7.f762s0
            if (r0 == 0) goto Ld7
            android.content.Context r0 = r0.getContext()
            android.view.LayoutInflater r8 = r8.cloneInContext(r0)
            return r8
        L9c:
            boolean r0 = androidx.fragment.app.i0.F(r2)
            if (r0 == 0) goto Ld7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "getting layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r2 = r7.f758o0
            if (r2 != 0) goto Lc6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "mShowsDialog = false: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
            return r8
        Lc6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "mCreatingDialog = true: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
        Ld7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.y(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.s
    public void z(Bundle bundle) {
        Dialog dialog = this.f762s0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i10 = this.f755l0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f756m0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f757n0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f758o0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f759p0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
