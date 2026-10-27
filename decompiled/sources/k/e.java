package k;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import l.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7533a;

    /* renamed from: b, reason: collision with root package name */
    public final a f7534b;

    public e(Context context, a aVar) {
        this.f7533a = context;
        this.f7534b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f7534b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f7534b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new a0(this.f7533a, this.f7534b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f7534b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f7534b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f7534b.f7519o;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f7534b.f();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f7534b.f7520p;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f7534b.g();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f7534b.i();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f7534b.j(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f7534b.l(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f7534b.f7519o = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f7534b.n(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z10) {
        this.f7534b.o(z10);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i10) {
        this.f7534b.k(i10);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i10) {
        this.f7534b.m(i10);
    }
}
