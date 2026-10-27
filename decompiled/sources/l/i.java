package l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends BaseAdapter {

    /* renamed from: o, reason: collision with root package name */
    public final l f7981o;

    /* renamed from: p, reason: collision with root package name */
    public int f7982p = -1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7983q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f7984r;

    /* renamed from: s, reason: collision with root package name */
    public final LayoutInflater f7985s;

    /* renamed from: t, reason: collision with root package name */
    public final int f7986t;

    public i(l lVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f7984r = z10;
        this.f7985s = layoutInflater;
        this.f7981o = lVar;
        this.f7986t = i10;
        a();
    }

    public final void a() {
        l lVar = this.f7981o;
        n nVar = lVar.f8008v;
        if (nVar != null) {
            lVar.i();
            ArrayList arrayList = lVar.f7996j;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((n) arrayList.get(i10)) == nVar) {
                    this.f7982p = i10;
                    return;
                }
            }
        }
        this.f7982p = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final n getItem(int i10) {
        ArrayList l10;
        boolean z10 = this.f7984r;
        l lVar = this.f7981o;
        if (z10) {
            lVar.i();
            l10 = lVar.f7996j;
        } else {
            l10 = lVar.l();
        }
        int i11 = this.f7982p;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return (n) l10.get(i10);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList l10;
        boolean z10 = this.f7984r;
        l lVar = this.f7981o;
        if (z10) {
            lVar.i();
            l10 = lVar.f7996j;
        } else {
            l10 = lVar.l();
        }
        return this.f7982p < 0 ? l10.size() : l10.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        boolean z10 = false;
        if (view == null) {
            view = this.f7985s.inflate(this.f7986t, viewGroup, false);
        }
        int i11 = getItem(i10).f8015b;
        int i12 = i10 - 1;
        int i13 = i12 >= 0 ? getItem(i12).f8015b : i11;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f7981o.m() && i11 != i13) {
            z10 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z10);
        y yVar = (y) view;
        if (this.f7983q) {
            listMenuItemView.setForceShowIcon(true);
        }
        yVar.b(getItem(i10));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
