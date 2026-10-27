package k;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends a implements l.j {

    /* renamed from: q, reason: collision with root package name */
    public Context f7527q;

    /* renamed from: r, reason: collision with root package name */
    public ActionBarContextView f7528r;

    /* renamed from: s, reason: collision with root package name */
    public x4.c f7529s;

    /* renamed from: t, reason: collision with root package name */
    public WeakReference f7530t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7531u;

    /* renamed from: v, reason: collision with root package name */
    public l.l f7532v;

    @Override // k.a
    public final void a() {
        if (this.f7531u) {
            return;
        }
        this.f7531u = true;
        this.f7529s.U(this);
    }

    @Override // k.a
    public final View b() {
        WeakReference weakReference = this.f7530t;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // k.a
    public final l.l c() {
        return this.f7532v;
    }

    @Override // k.a
    public final MenuInflater d() {
        return new h(this.f7528r.getContext());
    }

    @Override // k.a
    public final CharSequence e() {
        return this.f7528r.getSubtitle();
    }

    @Override // k.a
    public final CharSequence f() {
        return this.f7528r.getTitle();
    }

    @Override // k.a
    public final void g() {
        this.f7529s.V(this, this.f7532v);
    }

    @Override // l.j
    public final boolean h(l.l lVar, MenuItem menuItem) {
        return ((x4.i) this.f7529s.f13537p).s(this, menuItem);
    }

    @Override // k.a
    public final boolean i() {
        return this.f7528r.G;
    }

    @Override // k.a
    public final void j(View view) {
        this.f7528r.setCustomView(view);
        this.f7530t = view != null ? new WeakReference(view) : null;
    }

    @Override // k.a
    public final void k(int i10) {
        l(this.f7527q.getString(i10));
    }

    @Override // k.a
    public final void l(CharSequence charSequence) {
        this.f7528r.setSubtitle(charSequence);
    }

    @Override // k.a
    public final void m(int i10) {
        n(this.f7527q.getString(i10));
    }

    @Override // k.a
    public final void n(CharSequence charSequence) {
        this.f7528r.setTitle(charSequence);
    }

    @Override // k.a
    public final void o(boolean z10) {
        this.f7520p = z10;
        this.f7528r.setTitleOptional(z10);
    }

    @Override // l.j
    public final void r(l.l lVar) {
        g();
        m.k kVar = this.f7528r.f401r;
        if (kVar != null) {
            kVar.l();
        }
    }
}
