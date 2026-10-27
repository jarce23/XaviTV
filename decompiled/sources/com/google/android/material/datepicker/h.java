package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b4.b1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ l F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(l lVar, int i10, int i11) {
        super(i10);
        this.F = lVar;
        this.E = i11;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final void P0(RecyclerView recyclerView, int i10) {
        v vVar = new v(recyclerView.getContext());
        vVar.f2450a = i10;
        Q0(vVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void S0(b1 b1Var, int[] iArr) {
        int i10 = this.E;
        l lVar = this.F;
        if (i10 == 0) {
            iArr[0] = lVar.f3764o0.getWidth();
            iArr[1] = lVar.f3764o0.getWidth();
        } else {
            iArr[0] = lVar.f3764o0.getHeight();
            iArr[1] = lVar.f3764o0.getHeight();
        }
    }
}
