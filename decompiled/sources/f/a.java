package f;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements AdapterView.OnItemClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ e f4684o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ b f4685p;

    public a(b bVar, e eVar) {
        this.f4685p = bVar;
        this.f4684o = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        b bVar = this.f4685p;
        DialogInterface.OnClickListener onClickListener = bVar.f4713n;
        e eVar = this.f4684o;
        onClickListener.onClick(eVar.f4750b, i10);
        if (bVar.f4715p) {
            return;
        }
        eVar.f4750b.dismiss();
    }
}
