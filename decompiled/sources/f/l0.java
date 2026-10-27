package f;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 extends k.a implements l.j {

    /* renamed from: q, reason: collision with root package name */
    public final Context f4802q;

    /* renamed from: r, reason: collision with root package name */
    public final l.l f4803r;

    /* renamed from: s, reason: collision with root package name */
    public x4.c f4804s;

    /* renamed from: t, reason: collision with root package name */
    public WeakReference f4805t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ m0 f4806u;

    public l0(m0 m0Var, Context context, x4.c cVar) {
        this.f4806u = m0Var;
        this.f4802q = context;
        this.f4804s = cVar;
        l.l lVar = new l.l(context);
        lVar.f7998l = 1;
        this.f4803r = lVar;
        lVar.f7992e = this;
    }

    @Override // k.a
    public final void a() {
        m0 m0Var = this.f4806u;
        if (m0Var.f4814k != this) {
            return;
        }
        if (m0Var.f4821r) {
            m0Var.f4815l = this;
            m0Var.f4816m = this.f4804s;
        } else {
            this.f4804s.U(this);
        }
        this.f4804s = null;
        m0Var.B(false);
        ActionBarContextView actionBarContextView = m0Var.f4811h;
        if (actionBarContextView.f408y == null) {
            actionBarContextView.e();
        }
        m0Var.f4809e.setHideOnContentScrollEnabled(m0Var.f4826w);
        m0Var.f4814k = null;
    }

    @Override // k.a
    public final View b() {
        WeakReference weakReference = this.f4805t;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // k.a
    public final l.l c() {
        return this.f4803r;
    }

    @Override // k.a
    public final MenuInflater d() {
        return new k.h(this.f4802q);
    }

    @Override // k.a
    public final CharSequence e() {
        return this.f4806u.f4811h.getSubtitle();
    }

    @Override // k.a
    public final CharSequence f() {
        return this.f4806u.f4811h.getTitle();
    }

    @Override // k.a
    public final void g() {
        if (this.f4806u.f4814k != this) {
            return;
        }
        l.l lVar = this.f4803r;
        lVar.w();
        try {
            this.f4804s.V(this, lVar);
        } finally {
            lVar.v();
        }
    }

    @Override // l.j
    public final boolean h(l.l lVar, MenuItem menuItem) {
        x4.c cVar = this.f4804s;
        if (cVar != null) {
            return ((x4.i) cVar.f13537p).s(this, menuItem);
        }
        return false;
    }

    @Override // k.a
    public final boolean i() {
        return this.f4806u.f4811h.G;
    }

    @Override // k.a
    public final void j(View view) {
        this.f4806u.f4811h.setCustomView(view);
        this.f4805t = new WeakReference(view);
    }

    @Override // k.a
    public final void k(int i10) {
        l(this.f4806u.f4807c.getResources().getString(i10));
    }

    @Override // k.a
    public final void l(CharSequence charSequence) {
        this.f4806u.f4811h.setSubtitle(charSequence);
    }

    @Override // k.a
    public final void m(int i10) {
        n(this.f4806u.f4807c.getResources().getString(i10));
    }

    @Override // k.a
    public final void n(CharSequence charSequence) {
        this.f4806u.f4811h.setTitle(charSequence);
    }

    @Override // k.a
    public final void o(boolean z10) {
        this.f7520p = z10;
        this.f4806u.f4811h.setTitleOptional(z10);
    }

    @Override // l.j
    public final void r(l.l lVar) {
        if (this.f4804s == null) {
            return;
        }
        g();
        m.k kVar = this.f4806u.f4811h.f401r;
        if (kVar != null) {
            kVar.l();
        }
    }
}
