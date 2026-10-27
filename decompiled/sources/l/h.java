package l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements x, AdapterView.OnItemClickListener {

    /* renamed from: o, reason: collision with root package name */
    public Context f7975o;

    /* renamed from: p, reason: collision with root package name */
    public LayoutInflater f7976p;

    /* renamed from: q, reason: collision with root package name */
    public l f7977q;

    /* renamed from: r, reason: collision with root package name */
    public ExpandedMenuView f7978r;

    /* renamed from: s, reason: collision with root package name */
    public w f7979s;

    /* renamed from: t, reason: collision with root package name */
    public g f7980t;

    public h(Context context) {
        this.f7975o = context;
        this.f7976p = LayoutInflater.from(context);
    }

    @Override // l.x
    public final void b() {
        g gVar = this.f7980t;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // l.x
    public final void d(w wVar) {
        throw null;
    }

    @Override // l.x
    public final void e(l lVar, boolean z10) {
        w wVar = this.f7979s;
        if (wVar != null) {
            wVar.e(lVar, z10);
        }
    }

    @Override // l.x
    public final boolean g(n nVar) {
        return false;
    }

    @Override // l.x
    public final void h(Context context, l lVar) {
        if (this.f7975o != null) {
            this.f7975o = context;
            if (this.f7976p == null) {
                this.f7976p = LayoutInflater.from(context);
            }
        }
        this.f7977q = lVar;
        g gVar = this.f7980t;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // l.x
    public final boolean i() {
        return false;
    }

    @Override // l.x
    public final boolean j(d0 d0Var) {
        boolean hasVisibleItems = d0Var.hasVisibleItems();
        Context context = d0Var.f7988a;
        if (!hasVisibleItems) {
            return false;
        }
        m mVar = new m();
        mVar.f8011o = d0Var;
        f.f fVar = new f.f(context);
        h hVar = new h(fVar.getContext());
        mVar.f8013q = hVar;
        hVar.f7979s = mVar;
        d0Var.b(hVar, context);
        h hVar2 = mVar.f8013q;
        if (hVar2.f7980t == null) {
            hVar2.f7980t = new g(hVar2);
        }
        g gVar = hVar2.f7980t;
        f.b bVar = fVar.f4778a;
        bVar.f4712m = gVar;
        bVar.f4713n = mVar;
        View view = d0Var.f8001o;
        if (view != null) {
            bVar.f4705e = view;
        } else {
            bVar.f4703c = d0Var.f8000n;
            fVar.setTitle(d0Var.f7999m);
        }
        bVar.f4711l = mVar;
        f.g create = fVar.create();
        mVar.f8012p = create;
        create.setOnDismissListener(mVar);
        WindowManager.LayoutParams attributes = mVar.f8012p.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        mVar.f8012p.show();
        w wVar = this.f7979s;
        if (wVar == null) {
            return true;
        }
        wVar.p(d0Var);
        return true;
    }

    @Override // l.x
    public final boolean k(n nVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        this.f7977q.q(this.f7980t.getItem(i10), this, 0);
    }
}
