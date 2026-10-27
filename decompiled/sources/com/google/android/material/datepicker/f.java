package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import b4.o0;
import java.util.Calendar;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3750o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ t f3751p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ l f3752q;

    public /* synthetic */ f(l lVar, t tVar, int i10) {
        this.f3750o = i10;
        this.f3752q = lVar;
        this.f3751p = tVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3750o) {
            case 0:
                l lVar = this.f3752q;
                int c12 = ((LinearLayoutManager) lVar.f3764o0.getLayoutManager()).c1() - 1;
                Calendar a10 = x.a(this.f3751p.f3797d.f3736o.f3781o);
                a10.add(2, c12);
                lVar.J(new p(a10));
                break;
            default:
                l lVar2 = this.f3752q;
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) lVar2.f3764o0.getLayoutManager();
                View e12 = linearLayoutManager.e1(0, linearLayoutManager.x(), false);
                int N = e12 == null ? -1 : o0.N(e12);
                Calendar a11 = x.a(this.f3751p.f3797d.f3736o.f3781o);
                a11.add(2, N + 1);
                lVar2.J(new p(a11));
                break;
        }
    }
}
