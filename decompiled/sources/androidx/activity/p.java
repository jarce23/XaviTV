package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class p extends Dialog implements androidx.lifecycle.r, f4.e {

    /* renamed from: o, reason: collision with root package name */
    public androidx.lifecycle.t f319o;

    /* renamed from: p, reason: collision with root package name */
    public final com.bumptech.glide.manager.t f320p;

    /* renamed from: q, reason: collision with root package name */
    public final y f321q;

    public p(Context context, int i10) {
        super(context, i10);
        this.f320p = new com.bumptech.glide.manager.t(this);
        this.f321q = new y(new d(2, this));
    }

    public static void a(p pVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        za.h.e("view", view);
        c();
        super.addContentView(view, layoutParams);
    }

    @Override // f4.e
    public final f4.d b() {
        return (f4.d) this.f320p.f3099d;
    }

    public final void c() {
        Window window = getWindow();
        za.h.b(window);
        View decorView = window.getDecorView();
        za.h.d("window!!.decorView", decorView);
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        za.h.b(window2);
        View decorView2 = window2.getDecorView();
        za.h.d("window!!.decorView", decorView2);
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        za.h.b(window3);
        View decorView3 = window3.getDecorView();
        za.h.d("window!!.decorView", decorView3);
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
    }

    @Override // androidx.lifecycle.r
    public final androidx.lifecycle.t f() {
        androidx.lifecycle.t tVar = this.f319o;
        if (tVar != null) {
            return tVar;
        }
        androidx.lifecycle.t tVar2 = new androidx.lifecycle.t(this);
        this.f319o = tVar2;
        return tVar2;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f321q.b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            za.h.d("onBackInvokedDispatcher", onBackInvokedDispatcher);
            y yVar = this.f321q;
            yVar.getClass();
            yVar.f366e = onBackInvokedDispatcher;
            yVar.c(yVar.g);
        }
        this.f320p.d(bundle);
        androidx.lifecycle.t tVar = this.f319o;
        if (tVar == null) {
            tVar = new androidx.lifecycle.t(this);
            this.f319o = tVar;
        }
        tVar.d(androidx.lifecycle.l.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        za.h.d("super.onSaveInstanceState()", onSaveInstanceState);
        this.f320p.e(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        androidx.lifecycle.t tVar = this.f319o;
        if (tVar == null) {
            tVar = new androidx.lifecycle.t(this);
            this.f319o = tVar;
        }
        tVar.d(androidx.lifecycle.l.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.t tVar = this.f319o;
        if (tVar == null) {
            tVar = new androidx.lifecycle.t(this);
            this.f319o = tVar;
        }
        tVar.d(androidx.lifecycle.l.ON_DESTROY);
        this.f319o = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        c();
        super.setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        za.h.e("view", view);
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        za.h.e("view", view);
        c();
        super.setContentView(view, layoutParams);
    }
}
