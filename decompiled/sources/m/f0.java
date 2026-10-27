package m;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 implements k0, DialogInterface.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public f.g f8406o;

    /* renamed from: p, reason: collision with root package name */
    public g0 f8407p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f8408q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ l0 f8409r;

    public f0(l0 l0Var) {
        this.f8409r = l0Var;
    }

    @Override // m.k0
    public final boolean a() {
        f.g gVar = this.f8406o;
        if (gVar != null) {
            return gVar.isShowing();
        }
        return false;
    }

    @Override // m.k0
    public final int b() {
        return 0;
    }

    @Override // m.k0
    public final Drawable d() {
        return null;
    }

    @Override // m.k0
    public final void dismiss() {
        f.g gVar = this.f8406o;
        if (gVar != null) {
            gVar.dismiss();
            this.f8406o = null;
        }
    }

    @Override // m.k0
    public final void e(CharSequence charSequence) {
        this.f8408q = charSequence;
    }

    @Override // m.k0
    public final void g(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // m.k0
    public final void h(int i10) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // m.k0
    public final void i(int i10) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // m.k0
    public final void j(int i10) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // m.k0
    public final void k(int i10, int i11) {
        if (this.f8407p == null) {
            return;
        }
        l0 l0Var = this.f8409r;
        f.f fVar = new f.f(l0Var.getPopupContext());
        CharSequence charSequence = this.f8408q;
        if (charSequence != null) {
            fVar.setTitle(charSequence);
        }
        g0 g0Var = this.f8407p;
        int selectedItemPosition = l0Var.getSelectedItemPosition();
        f.b bVar = fVar.f4778a;
        bVar.f4712m = g0Var;
        bVar.f4713n = this;
        bVar.f4716q = selectedItemPosition;
        bVar.f4715p = true;
        f.g create = fVar.create();
        this.f8406o = create;
        AlertController$RecycleListView alertController$RecycleListView = create.f4787t.f4754f;
        alertController$RecycleListView.setTextDirection(i10);
        alertController$RecycleListView.setTextAlignment(i11);
        this.f8406o.show();
    }

    @Override // m.k0
    public final int l() {
        return 0;
    }

    @Override // m.k0
    public final CharSequence n() {
        return this.f8408q;
    }

    @Override // m.k0
    public final void o(ListAdapter listAdapter) {
        this.f8407p = (g0) listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        l0 l0Var = this.f8409r;
        l0Var.setSelection(i10);
        if (l0Var.getOnItemClickListener() != null) {
            l0Var.performItemClick(null, i10, this.f8407p.getItemId(i10));
        }
        dismiss();
    }
}
