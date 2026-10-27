package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z0 extends BaseAdapter {

    /* renamed from: o, reason: collision with root package name */
    public final f.j f4228o;

    /* renamed from: p, reason: collision with root package name */
    public final List f4229p;

    public z0(f.j jVar, ArrayList arrayList) {
        this.f4228o = jVar;
        this.f4229p = arrayList;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List list = this.f4229p;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i10) {
        return this.f4229p.get(i10);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f4228o).inflate(R.layout.item_sort, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.txt_name)).setText((CharSequence) this.f4229p.get(i10));
        return inflate;
    }
}
