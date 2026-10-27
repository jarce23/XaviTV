package g9;

import android.view.View;
import android.widget.AdapterView;
import m.i0;
import m.l0;
import m.z1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements AdapterView.OnItemClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5414o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f5415p;

    public /* synthetic */ u(int i10, Object obj) {
        this.f5414o = i10;
        this.f5415p = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        CharSequence convertSelectionToString;
        switch (this.f5414o) {
            case 0:
                w wVar = (w) this.f5415p;
                z1 z1Var = wVar.f5419s;
                convertSelectionToString = wVar.convertSelectionToString(i10 < 0 ? !z1Var.N.isShowing() ? null : z1Var.f8611q.getSelectedItem() : wVar.getAdapter().getItem(i10));
                wVar.setText(convertSelectionToString, false);
                AdapterView.OnItemClickListener onItemClickListener = wVar.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i10 < 0) {
                        view = !z1Var.N.isShowing() ? null : z1Var.f8611q.getSelectedView();
                        i10 = !z1Var.N.isShowing() ? -1 : z1Var.f8611q.getSelectedItemPosition();
                        j10 = !z1Var.N.isShowing() ? Long.MIN_VALUE : z1Var.f8611q.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(z1Var.f8611q, view, i10, j10);
                }
                z1Var.dismiss();
                break;
            default:
                i0 i0Var = (i0) this.f5415p;
                l0 l0Var = i0Var.V;
                l0Var.setSelection(i10);
                if (l0Var.getOnItemClickListener() != null) {
                    l0Var.performItemClick(view, i10, i0Var.S.getItemId(i10));
                }
                i0Var.dismiss();
                break;
        }
    }
}
