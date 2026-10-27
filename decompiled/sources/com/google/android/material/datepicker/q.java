package com.google.android.material.datepicker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends BaseAdapter {

    /* renamed from: r, reason: collision with root package name */
    public static final int f3788r = x.c(null).getMaximum(4);

    /* renamed from: s, reason: collision with root package name */
    public static final int f3789s = (x.c(null).getMaximum(7) + x.c(null).getMaximum(5)) - 1;

    /* renamed from: o, reason: collision with root package name */
    public final p f3790o;

    /* renamed from: p, reason: collision with root package name */
    public c f3791p;

    /* renamed from: q, reason: collision with root package name */
    public final b f3792q;

    public q(p pVar, b bVar) {
        this.f3790o = pVar;
        this.f3792q = bVar;
        throw null;
    }

    public final int a() {
        int i10 = this.f3792q.f3740s;
        p pVar = this.f3790o;
        Calendar calendar = pVar.f3781o;
        int i11 = calendar.get(7);
        if (i10 <= 0) {
            i10 = calendar.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        return i12 < 0 ? i12 + pVar.f3784r : i12;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i10) {
        if (i10 < a() || i10 > c()) {
            return null;
        }
        int a10 = (i10 - a()) + 1;
        Calendar a11 = x.a(this.f3790o.f3781o);
        a11.set(5, a10);
        return Long.valueOf(a11.getTimeInMillis());
    }

    public final int c() {
        return (a() + this.f3790o.f3785s) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f3789s;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10 / this.f3790o.f3784r;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.f3791p == null) {
            this.f3791p = new c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) android.support.v4.media.d.h(viewGroup, R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int a10 = i10 - a();
        if (a10 >= 0) {
            p pVar = this.f3790o;
            if (a10 < pVar.f3785s) {
                textView.setTag(pVar);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(a10 + 1)));
                textView.setVisibility(0);
                textView.setEnabled(true);
                if (getItem(i10) == null || textView == null) {
                    return textView;
                }
                textView.getContext();
                x.b().getTimeInMillis();
                throw null;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        if (getItem(i10) == null) {
            textView.getContext();
            x.b().getTimeInMillis();
            throw null;
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
