package com.google.android.material.datepicker;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* renamed from: r, reason: collision with root package name */
    public static final int f3746r;

    /* renamed from: o, reason: collision with root package name */
    public final Calendar f3747o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3748p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3749q;

    static {
        f3746r = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar c10 = x.c(null);
        this.f3747o = c10;
        this.f3748p = c10.getMaximum(7);
        this.f3749q = c10.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3748p;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i10) {
        int i11 = this.f3748p;
        if (i10 >= i11) {
            return null;
        }
        int i12 = i10 + this.f3749q;
        if (i12 > i11) {
            i12 -= i11;
        }
        return Integer.valueOf(i12);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) android.support.v4.media.d.h(viewGroup, R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i11 = i10 + this.f3749q;
        int i12 = this.f3748p;
        if (i11 > i12) {
            i11 -= i12;
        }
        Calendar calendar = this.f3747o;
        calendar.set(7, i11);
        textView.setText(calendar.getDisplayName(7, f3746r, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public e(int i10) {
        Calendar c10 = x.c(null);
        this.f3747o = c10;
        this.f3748p = c10.getMaximum(7);
        this.f3749q = i10;
    }
}
