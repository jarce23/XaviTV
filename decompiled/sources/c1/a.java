package c1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.VerticalGridView;
import b4.f0;
import b4.f1;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends f0 {

    /* renamed from: d, reason: collision with root package name */
    public final int f2496d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2497e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2498f;
    public final d g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f2499h;

    public a(c cVar, int i10, int i11, int i12) {
        this.f2499h = cVar;
        this.f2496d = i10;
        this.f2497e = i12;
        this.f2498f = i11;
        this.g = (d) cVar.f2503q.get(i12);
    }

    @Override // b4.f0
    public final int a() {
        d dVar = this.g;
        if (dVar == null) {
            return 0;
        }
        return (dVar.f2515c - dVar.f2514b) + 1;
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        d dVar;
        b bVar = (b) f1Var;
        TextView textView = bVar.f2500u;
        if (textView != null && (dVar = this.g) != null) {
            int i11 = dVar.f2514b + i10;
            CharSequence[] charSequenceArr = dVar.f2516d;
            textView.setText(charSequenceArr == null ? String.format(dVar.f2517e, Integer.valueOf(i11)) : charSequenceArr[i11]);
        }
        View view = bVar.f2232a;
        c cVar = this.f2499h;
        ArrayList arrayList = cVar.f2502p;
        int i12 = this.f2497e;
        cVar.c(view, ((VerticalGridView) arrayList.get(i12)).getSelectedPosition() == i10, i12, false);
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f2496d, viewGroup, false);
        int i11 = this.f2498f;
        return new b(inflate, i11 != 0 ? (TextView) inflate.findViewById(i11) : (TextView) inflate);
    }

    @Override // b4.f0
    public final void j(f1 f1Var) {
        ((b) f1Var).f2232a.setFocusable(this.f2499h.isActivated());
    }
}
