package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements AdapterView.OnItemClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f3793o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ t f3794p;

    public r(t tVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f3794p = tVar;
        this.f3793o = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        MaterialCalendarGridView materialCalendarGridView = this.f3793o;
        q a10 = materialCalendarGridView.a();
        if (i10 < a10.a() || i10 > a10.c()) {
            return;
        }
        if (materialCalendarGridView.a().getItem(i10).longValue() >= ((l) this.f3794p.f3798e.f74p).f3759j0.f3738q.f3745o) {
            throw null;
        }
    }
}
