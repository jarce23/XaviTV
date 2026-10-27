package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final n7.i f3743a;

    /* renamed from: b, reason: collision with root package name */
    public final n7.i f3744b;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.bumptech.glide.c.z(R.attr.materialCalendarStyle, context, l.class.getCanonicalName()).data, j8.a.f7192m);
        n7.i.A(context, obtainStyledAttributes.getResourceId(4, 0));
        n7.i.A(context, obtainStyledAttributes.getResourceId(2, 0));
        n7.i.A(context, obtainStyledAttributes.getResourceId(3, 0));
        n7.i.A(context, obtainStyledAttributes.getResourceId(5, 0));
        ColorStateList l10 = com.bumptech.glide.d.l(context, obtainStyledAttributes, 7);
        this.f3743a = n7.i.A(context, obtainStyledAttributes.getResourceId(9, 0));
        n7.i.A(context, obtainStyledAttributes.getResourceId(8, 0));
        this.f3744b = n7.i.A(context, obtainStyledAttributes.getResourceId(10, 0));
        new Paint().setColor(l10.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
