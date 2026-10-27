package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import b4.f1;
import java.util.WeakHashMap;
import m0.k0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public final TextView f3795u;

    /* renamed from: v, reason: collision with root package name */
    public final MaterialCalendarGridView f3796v;

    public s(LinearLayout linearLayout, boolean z10) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f3795u = textView;
        WeakHashMap weakHashMap = k0.f8683a;
        new m0.x(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).f(textView, Boolean.TRUE);
        this.f3796v = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z10) {
            return;
        }
        textView.setVisibility(8);
    }
}
