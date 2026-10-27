package com.google.android.material.datepicker;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import b4.f0;
import b4.f1;
import java.util.Locale;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z extends f0 {

    /* renamed from: d, reason: collision with root package name */
    public final l f3802d;

    public z(l lVar) {
        this.f3802d = lVar;
    }

    @Override // b4.f0
    public final int a() {
        return this.f3802d.f3759j0.f3741t;
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        l lVar = this.f3802d;
        int i11 = lVar.f3759j0.f3736o.f3783q + i10;
        TextView textView = ((y) f1Var).f3801u;
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i11)));
        Context context = textView.getContext();
        textView.setContentDescription(x.b().get(1) == i11 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i11)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i11)));
        c cVar = lVar.f3762m0;
        if (x.b().get(1) == i11) {
            n7.i iVar = cVar.f3744b;
        } else {
            n7.i iVar2 = cVar.f3743a;
        }
        throw null;
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        return new y((TextView) android.support.v4.media.d.h(viewGroup, R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
