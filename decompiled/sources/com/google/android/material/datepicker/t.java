package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b4.f0;
import b4.f1;
import b4.p0;
import java.util.Calendar;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends f0 {

    /* renamed from: d, reason: collision with root package name */
    public final b f3797d;

    /* renamed from: e, reason: collision with root package name */
    public final a6.n f3798e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3799f;

    public t(ContextThemeWrapper contextThemeWrapper, b bVar, a6.n nVar) {
        p pVar = bVar.f3736o;
        p pVar2 = bVar.f3737p;
        p pVar3 = bVar.f3739r;
        if (pVar.f3781o.compareTo(pVar3.f3781o) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (pVar3.f3781o.compareTo(pVar2.f3781o) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f3799f = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * q.f3788r) + (n.P(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f3797d = bVar;
        this.f3798e = nVar;
        if (this.f2228a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f2229b = true;
    }

    @Override // b4.f0
    public final int a() {
        return this.f3797d.f3742u;
    }

    @Override // b4.f0
    public final long b(int i10) {
        Calendar a10 = x.a(this.f3797d.f3736o.f3781o);
        a10.add(2, i10);
        a10.set(5, 1);
        Calendar a11 = x.a(a10);
        a11.get(2);
        a11.get(1);
        a11.getMaximum(7);
        a11.getActualMaximum(5);
        a11.getTimeInMillis();
        return a11.getTimeInMillis();
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        s sVar = (s) f1Var;
        b bVar = this.f3797d;
        Calendar a10 = x.a(bVar.f3736o.f3781o);
        a10.add(2, i10);
        p pVar = new p(a10);
        sVar.f3795u.setText(pVar.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) sVar.f3796v.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !pVar.equals(materialCalendarGridView.a().f3790o)) {
            new q(pVar, bVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) android.support.v4.media.d.h(viewGroup, R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!n.P(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new s(linearLayout, false);
        }
        linearLayout.setLayoutParams(new p0(-1, this.f3799f));
        return new s(linearLayout, true);
    }
}
