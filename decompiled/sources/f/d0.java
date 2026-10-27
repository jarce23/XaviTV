package f;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d0 extends androidx.activity.p implements k {

    /* renamed from: r, reason: collision with root package name */
    public b0 f4747r;

    /* renamed from: s, reason: collision with root package name */
    public final c0 f4748s;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v2, types: [f.c0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d0(android.view.ContextThemeWrapper r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 2130969087(0x7f0401ff, float:1.7546846E38)
            if (r6 != 0) goto L15
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L16
        L15:
            r2 = r6
        L16:
            r4.<init>(r5, r2)
            f.c0 r2 = new f.c0
            r2.<init>()
            r4.f4748s = r2
            f.q r2 = r4.d()
            if (r6 != 0) goto L34
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L34:
            r5 = r2
            f.b0 r5 = (f.b0) r5
            r5.f4727i0 = r6
            r2.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.d0.<init>(android.view.ContextThemeWrapper, int):void");
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        b0 b0Var = (b0) d();
        b0Var.v();
        ((ViewGroup) b0Var.P.findViewById(R.id.content)).addView(view, layoutParams);
        b0Var.A.a(b0Var.f4743z.getCallback());
    }

    public final q d() {
        if (this.f4747r == null) {
            o oVar = q.f4836o;
            this.f4747r = new b0(getContext(), getWindow(), this, this);
        }
        return this.f4747r;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        d().d();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return n4.a.m(this.f4748s, getWindow().getDecorView(), this, keyEvent);
    }

    public final boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i10) {
        b0 b0Var = (b0) d();
        b0Var.v();
        return b0Var.f4743z.findViewById(i10);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        b0 b0Var = (b0) d();
        if (b0Var.C != null) {
            b0Var.A();
            b0Var.C.getClass();
            b0Var.B(0);
        }
    }

    @Override // androidx.activity.p, android.app.Dialog
    public void onCreate(Bundle bundle) {
        d().a();
        super.onCreate(bundle);
        d().c();
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void onStop() {
        super.onStop();
        b0 b0Var = (b0) d();
        b0Var.A();
        m0 m0Var = b0Var.C;
        if (m0Var != null) {
            m0Var.f4825v = false;
            k.j jVar = m0Var.f4824u;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void setContentView(int i10) {
        c();
        d().g(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().k(charSequence);
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void setContentView(View view) {
        c();
        d().i(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        d().k(getContext().getString(i10));
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        d().j(view, layoutParams);
    }
}
