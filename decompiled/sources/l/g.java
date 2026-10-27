package l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends BaseAdapter {

    /* renamed from: o, reason: collision with root package name */
    public int f7973o = -1;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ h f7974p;

    public g(h hVar) {
        this.f7974p = hVar;
        a();
    }

    public final void a() {
        l lVar = this.f7974p.f7977q;
        n nVar = lVar.f8008v;
        if (nVar != null) {
            lVar.i();
            ArrayList arrayList = lVar.f7996j;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((n) arrayList.get(i10)) == nVar) {
                    this.f7973o = i10;
                    return;
                }
            }
        }
        this.f7973o = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final n getItem(int i10) {
        h hVar = this.f7974p;
        l lVar = hVar.f7977q;
        lVar.i();
        ArrayList arrayList = lVar.f7996j;
        hVar.getClass();
        int i11 = this.f7973o;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return (n) arrayList.get(i10);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        h hVar = this.f7974p;
        l lVar = hVar.f7977q;
        lVar.i();
        int size = lVar.f7996j.size();
        hVar.getClass();
        return this.f7973o < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7974p.f7976p.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((y) view).b(getItem(i10));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
